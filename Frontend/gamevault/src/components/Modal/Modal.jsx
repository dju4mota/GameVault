import React from 'react';
import Modal from 'react-modal';
import styled from '@emotion/styled';

const Overlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
`;

// In your BaseModal component
const ModalContainer = styled.div`
  background-color: #444;
  border-radius: 8px;
  padding: 2rem;
  width: ${props => props.width || '80%'};
  max-width: 1000px;
  position: relative;
  color: white;
  display: flex;
  flex-direction: column;
  max-height: 90vh; // Prevent modal from exceeding viewport height
  overflow: hidden; // Hide any overflow

  header {
    position: relative;
    margin-bottom: 1.5rem;
    flex-shrink: 0; // Prevent header from shrinking
  }
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.5rem;
  
  h2 {
    margin: 0;
    font-size: 1.5rem;
  }
`;

const Body = styled.div`
    display: flex;
    flex-direction: row;
`;

const CloseButton = styled.button`
  position: absolute;
  top: -10px;
  right: -10px;
  background: #ff4800;
  border: none;
  color: white;
  cursor: pointer;
  font-size: 1.5rem;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);

  &:hover {
    background: #ff5c1a;
  }

  &::before {
    content: "\\f00d";
    font-family: FontAwesome;
  }
`;

const BaseModal = ({ 
  isOpen, 
  onClose, 
  title, 
  children, 
  width = '50%', 
  height = 'auto' 
}) => (
  <Modal
    isOpen={isOpen}
    onRequestClose={onClose}
    style={{
      overlay: { 
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        zIndex: 1000
      },
      content: {
        inset: '0',
        padding: '0',
        border: 'none',
        background: 'none'
      }
    }}
  >
    <Overlay>
      <ModalContainer width={width} height={height}>
        <Header>
          <h2>{title}</h2>
          <CloseButton onClick={onClose}>
            <i className="fa fa-times" />
          </CloseButton>
        </Header>
        <Body>
          {children}
        </Body>
      </ModalContainer>
    </Overlay>
  </Modal>
);

export default BaseModal;