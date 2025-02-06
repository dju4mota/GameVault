import styled from "@emotion/styled";
import { Button } from "../Button/Button";

const Div = styled.div`
  position: absolute;
  background-color: #ff4800;
  color: white;
  width: 100%;
  height: 12%;
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
  font-family: "Montserrat", sans-serif;
`;

const Menu = styled.div`
  display: flex;
  width: 20%;
  position: absolute;
  right: 20%;
  justify-content: space-between;
  button {
    background-color: rgb(90, 90, 90);
    color: white;
  }
`;

export const Header = ({ openModal, openProfile, openJogos, openListas }) => {
  return (
    <Div>
      <Title>GameVault</Title>
      <Menu>
        <Button onClick={openModal}>Profile </Button>
        <Button onClick={openModal}> Jogos </Button>
        <Button onClick={openModal}> Listas </Button>
        <Button onClick={openModal}> +Log </Button>
      </Menu>
    </Div>
  );
};
