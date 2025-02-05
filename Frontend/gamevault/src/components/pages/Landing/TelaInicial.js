import React, { useState } from 'react';
import { Header } from '../../Header/Header';
import ModalReview from '../../Modal/ModalReview';

function TelaInicial() {
  const [modalIsOpen, setModalIsOpen] = useState(false);
  
  return (
    <div>
      <Header openModal={() => setModalIsOpen(true)} />
      <ModalReview
        isOpen={modalIsOpen}
        onRequestClose={() => setModalIsOpen(false)}
      />
      
    </div>
  );
}

export default TelaInicial;