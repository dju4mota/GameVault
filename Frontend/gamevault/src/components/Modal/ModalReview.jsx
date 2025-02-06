import React, { useState } from "react";
import axios from "axios";
import BaseModal from "../Modal/Modal";
import StarRating from "../StarRating/StarRating";
import FormField from "../FormField/FormField";
import styled from "@emotion/styled";

const ModalContent = styled.div`
  display: flex;
  gap: 30px;
  height: 100%;
  overflow: hidden;
  flex: 1;
  justify-content: center;
  align-items: flex-start;
  flex-direction: row;

  .cover {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: row;
    padding: 20px;

    img {
      width: 100%;
      height: auto;
      max-height: 400px;
      object-fit: cover;
    }
  }

  .form-content {
    flex: 1;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 15px;
    align-content: start;
    overflow: visible; 
    padding-right: 20px;

    .full-width {
      grid-column: 1 / -1;
      width: 100%;
    }

    textarea {
      width: 100%;
      resize: none;
    }

    button[type="submit"] {
      grid-column: 1 / -1;
      justify-self: end;
      margin-right: 20px;
      width: auto;
      padding: 0 25px;
      background-color: #ff4800;
      color: #fff;
      font-family: "Montserrat", sans-serif;
      font-weight: bold;
      border: none;
      border-radius: 8px;
      height: 50px;
      width: 20%;
    }
  }

  @media (max-width: 768px) {
    flex-direction: column;

    .cover {
      margin-top: 0;
      padding: 10px 20px 0;
    }

    .form-content {
      grid-template-columns: 1fr;
    }
  }
`;

function ModalReview({ isOpen, onRequestClose }) {
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

      await axios.post("http://localhost:8080/reviews", reviewData);
      alert("Review enviada com sucesso!");
      onRequestClose();
    } catch (error) {
      console.error("Erro ao enviar a review:", error);
      alert("Erro ao enviar a review. Tente novamente.");
    }
  };

  return (
    <BaseModal
      isOpen={isOpen}
      onClose={onRequestClose}
      title="Review Jogo"
      width="90%"
    >
      <ModalContent>
        <div className="cover">
          <img
            src="https://upload.wikimedia.org/wikipedia/en/b/b0/Persona_5_cover_art.jpg"
            alt="Capa do jogo"
          />
        </div>

        <form onSubmit={handleSubmit} className="form-content">
          <FormField
            label="Nome do jogo"
            name="name"
            value={formData.name}
            onChange={handleChange}
            className="full-width"
            placeholder={"Digite o nome do jogo"}
            width={"100%"}
          />

          <FormField
            label="Review"
            name="review"
            type="textarea"
            value={formData.review}
            onChange={handleChange}
            className="full-width"
            placeholder="Digite sua review"
          />

          <FormField
            label="Jogo terminado em:"
            name="date"
            type="date"
            value={formData.date}
            onChange={handleChange}
          />

          <FormField
            label="Plataforma"
            name="plataforma"
            value={formData.plataforma}
            onChange={handleChange}
            placeholder={"ex: Nintendo Switch, PS4"}
          />

          <FormField
            label="Gênero"
            name="genero"
            value={formData.genero}
            onChange={handleChange}
            placeholder={"ex: RPG, Ação"}
          />

          <FormField
            label="Horas jogadas"
            name="horas"
            type="number"
            value={formData.horas}
            onChange={handleChange}
          />

          <FormField
            label="Nota"
            name="nota"
            value={formData.nota}
            onChange={handleChange}
            component={StarRating}
            className="full-width"
          />

          <button type="submit">Salvar</button>
        </form>
      </ModalContent>
    </BaseModal>
  );
}

export default ModalReview;
