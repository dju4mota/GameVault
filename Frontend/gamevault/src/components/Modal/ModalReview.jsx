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
  border-radius: 20px;
  padding: 20px;
    flex-direction: column;
    justify-content: center;
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
`;

const Content = styled.p`
  margin: 20px 0;
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
  

      const response = await axios.post("http://localhost:8080/reviews", reviewData);
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
                    <label>
                        Nome do jogo:
                        <input type="text" name="name" value={formData.name} onChange={handleChange} />
    
                    </label>
                    <br />
                    <label>
                        Review:
                        <input type="text" name="review" value={formData.review} onChange={handleChange}/>
                    </label>
                    <br />
                    <label>
                        Data:
                        <input type="date" name="date" value={formData.date} onChange={handleChange}/>
                    </label>
                    <br />
                    <label>
                        Nota:
                        <input type="number" name="nota" value={formData.nota} onChange={handleChange}/>
                    </label>
                    <br />
                    <label>
                        Plataforma:
                        <input type="text" name="plataforma" value={formData.plataforma} onChange={handleChange}/>
                    </label>
                    <br />
                    <label>
                        Gênero:
                        <input type="text" name="genero" value={formData.genero} onChange={handleChange}/>
                    </label>
                    <br />
                    <label>
                        Horas jogadas:
                        <input type="number" name="horas" value={formData.horas} onChange={handleChange}/>    
                    </label>
                    <br />
                    <button type="submit">Enviar Review</button>
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
