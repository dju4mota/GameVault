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
  overflow: hidden; // Prevent scrolling
  flex: 1; // Take available space

  .cover {
    flex: 0 0 300px;
    display: flex;
    align-items: center;
    
    img {
      width: 100%;
      height: auto;
      max-height: 400px;
      object-fit: cover;
      border-radius: 8px;
    }
  }

  .form-content {
    flex: 1;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 15px;
    align-content: start;
    overflow: hidden; // Prevent scrolling
    padding-right: 10px; // Space for scrollbar (if needed)

    .full-width {
      grid-column: 1 / -1;
    }

    button[type="submit"] {
      grid-column: 1 / -1;
      justify-self: center;
      margin-top: 20px;
    }
  }

  @media (max-width: 768px) {
    flex-direction: column;
    
    .cover {
      flex: 0 0 auto;
      max-width: 200px;
      margin: 0 auto;
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
      />

      <FormField
        label="Data de lançamento"
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
      />

      <FormField
        label="Gênero"
        name="genero"
        value={formData.genero}
        onChange={handleChange}
      />

      <FormField
        label="Horas jogadas"
        name="horas"
        type="number"
        value={formData.horas}
        onChange={handleChange}
      />

      <FormField
        label="Review"
        name="review"
        value={formData.review}
        onChange={handleChange}
        className="full-width"
      />

      <FormField
        label="Nota"
        name="nota"
        value={formData.nota}
        onChange={handleChange}
        component={StarRating}
        className="full-width"
      />

      <button type="submit">Enviar Review</button>
    </form>
  </ModalContent>
</BaseModal>
  );
}

export default ModalReview;
