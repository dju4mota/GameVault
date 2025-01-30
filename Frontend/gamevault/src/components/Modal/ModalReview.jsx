import React, { useState } from "react";
import styled from "@emotion/styled";
import axios from "axios";

import Modal from "react-modal";

Modal.setAppElement("#root");

const ModalContainer = styled.div``;

const StyledModal = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 50%;
  display: flex;
  background-color: #444444;
  color: white;
  border-radius: 20px;
  padding: 20px;
  flex-direction: column;
  justify-content: center;
  font-family: "Montserrat", sans-serif;
  font-size: 16px;
  font-weight: 400;
  padding: 20px;
`;

const Overlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(154, 62, 62, 0.8);
`;

const Title = styled.h2`
  margin: 0;
  font-size: 24px;
  font-weight: bold;
  font-family: "Montserrat", sans-serif;
`;

const Content = styled.div`
  margin: 20px 0;
  justify-content: center;
  flex-direction: row;
  align-items: center;

  form {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
  }

  .cover {
    display: flex;
    justify-content: center;
    align-items: center;
    img {
      height: 200px;
    }
    padding: 10px;
  }

  .nomeJogo {
    display: flex;
    flex-direction: column;
    font-family: "Montserrat", sans-serif;
    font-weight: semibold;
    font-size: 18px;

    input {
      margin-top: 5px;
      padding: 5px;
      border: 1px solid #000;
      filter: drop-shadow(3px 3px 3px rgba(0, 0, 0, 0.5));
      width: 100%;
      height: 30px;
    }
  }
`;

const CloseButton = styled.button`
  padding: 10px 20px;
  border: none;
  border-radius: 10px;
  background-color: #007bff;
  color: white;
  cursor: pointer;
  &:hover {
    background-color: #0056b3;
  }
`;

const OpenButton = styled.button`
  padding: 10px 20px;
  border: none;
  border-radius: 10px;
  background-color: #28a745;
  color: white;
  cursor: pointer;
  &:hover {
    background-color: #218838;
  }
`;

const StarRatingContainer = styled.div`
  display: inline-block;
  border: 0;
  margin-left: 10px;

  .rate {
    display: inline-block;
    border: 0;
  }

  input {
    display: none;
  }

  label {
    float: right;
    position: relative;
    cursor: pointer;

    &:before {
      display: inline-block;
      font-size: 2rem;
      padding: 0.3rem 0.2rem;
      margin: 0;
      font-family: FontAwesome;
      content: "\\f005"; /* full star */
    }
  }

  .half:before {
    content: "\\f089"; /* half star no outline */
    position: absolute;
    padding-right: 0;
  }

  input:checked ~ label,
  label:hover,
  label:hover ~ label {
    color: #73b100;
  }

  input:checked + label:hover,
  input:checked ~ label:hover,
  input:checked ~ label:hover ~ label,
  label:hover ~ input:checked ~ label {
    color: #a6e72d;
  }
`;

function StarRating({ value, onChange }) {
  const ratings = [5, 4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0.5];

  return (
    <StarRatingContainer>
      <div className="rate">
        {ratings.map((rating) => {
          const isHalf = rating % 1 !== 0;
          return (
            <React.Fragment key={rating}>
              <input
                type="radio"
                id={`star${rating}`}
                name="nota"
                value={rating}
                checked={value === rating.toString()}
                onChange={onChange}
              />
              <label
                htmlFor={`star${rating}`}
                className={isHalf ? "half" : ""}
                title={`${rating} stars`}
              />
            </React.Fragment>
          );
        })}
      </div>
    </StarRatingContainer>
  );
}

function ModalReview() {
  const [modalIsOpen, setIsOpen] = React.useState(false);

  const [formData, setFormData] = useState({
    reviewId: "",
    name: "",
    review: "",
    date: "",
    nota: "",
    plataforma: "",
    genero: "",
    horas: "",
  });

  function abrirModal() {
    setIsOpen(true);
  }

  function fecharModal() {
    setIsOpen(false);
  }

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const reviewData = {
        reviewId: parseFloat(Math.floor(Math.random() * 1000)),
        score: parseFloat(formData.nota),
        comment: formData.review,
        data: formData.date,
        game: {
          title: formData.name,
          description: "Descrição genérica",
          genre: formData.genero,
        },
        hoursPlayed: parseFloat(formData.horas),
        platform: formData.plataforma,
      };

      console.log("JSON enviado:", JSON.stringify(reviewData, null, 2));

      const response = await axios.post(
        "http://localhost:8080/reviews",
        reviewData
      );
      console.log("Resposta do servidor:", response.data);

      alert("Review enviada com sucesso!");
      fecharModal();
    } catch (error) {
      console.error("Erro ao enviar a review:", error);
      alert("Erro ao enviar a review. Tente novamente. erro: ");
    }
  };

  return (
    <ModalContainer>
      <OpenButton onClick={abrirModal}>Abrir modal</OpenButton>
      <Modal
        isOpen={modalIsOpen}
        onRequestClose={fecharModal}
        contentLabel="Nova Review"
        className="_"
        overlayClassName="_"
        closeTimeoutMS={200}
        style={{
          content: { inset: 0, padding: 0 },
        }}
      >
        <Overlay>
          <StyledModal>
            <Title>Review Jogo</Title>
            <Content>
              <form onSubmit={handleSubmit}>
                <div className="cover">
                  <img
                    src="https://upload.wikimedia.org/wikipedia/en/b/b0/Persona_5_cover_art.jpg"
                    alt="Capa do jogo"
                  />
                </div>
                <div className="infos">
                  <div className="nomeJogo">
                    <label>
                      Nome do jogo
                      <input
                        type="text"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        placeholder="Digite o nome do jogo"
                      />
                    </label>
                  </div>

                  <label>
                    Review:
                    <input
                      type="text"
                      name="review"
                      value={formData.review}
                      onChange={handleChange}
                    />
                  </label>

                  <div className="dataJogado">
                    <label>
                      Jogado em:
                      <input
                        type="date"
                        name="date"
                        value={formData.date}
                        onChange={handleChange}
                      />
                    </label>
                  </div>

                  <label style={{ display: "flex", alignItems: "center" }}>
                    Nota:
                    <StarRating value={formData.nota} onChange={handleChange} />
                  </label>
                  <br />
                  <label>
                    Plataforma:
                    <input
                      type="text"
                      name="plataforma"
                      value={formData.plataforma}
                      onChange={handleChange}
                    />
                  </label>
                  <br />
                  <label>
                    Gênero:
                    <input
                      type="text"
                      name="genero"
                      value={formData.genero}
                      onChange={handleChange}
                    />
                  </label>
                  <br />
                  <label>
                    Horas jogadas:
                    <input
                      type="number"
                      name="horas"
                      value={formData.horas}
                      onChange={handleChange}
                    />
                  </label>
                  <button type="submit">Enviar Review</button>
                </div>
              </form>
            </Content>
            <CloseButton onClick={fecharModal}>Fechar modal</CloseButton>
          </StyledModal>
        </Overlay>
      </Modal>
    </ModalContainer>
  );
}

export default ModalReview;
