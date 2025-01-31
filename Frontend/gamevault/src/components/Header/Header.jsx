import styled from '@emotion/styled';
import { Button } from '../Button/Button';

const Div = styled.div`
  position: absolute;
  background-color: #ff4800;
  color: white;
  width: 100%;
  height: 10%;
  align-items: center;
  justify-content: center;
  display: flex;
`;

const Title = styled.h1`
  font-size: 1.5em;
  text-align: left;
  color: white;
  position: absolute;
  left: 20%;
  display: flex;
  background-color: rgb(170, 0, 255);
`;

const Menu = styled.div`
  display: flex;
  position: absolute;
  right: 20%;
  button {
    background-color:rgb(90, 90, 90);
    color: white;
  }
`;

export const Header = ({ openModal }) => {
  return (
    <Div>
      <Title>GameVault</Title>
      <Menu>
        perfil | Jogos | Listas | <Button onClick={openModal}> +Log </Button>
      </Menu>
    </Div>
  );
};
