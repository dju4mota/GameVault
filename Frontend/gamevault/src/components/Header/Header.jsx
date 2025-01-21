import styled from "@emotion/styled";

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
  background-color: rgb(22, 28, 70);
  display: flex;
  position: absolute;
  right: 20%;
`;

export const Header = () => {
  return (
    <Div>
      <Title>GameVault</Title>
      <Menu> perfil | Jogos | Listas | + Log </Menu>
    </Div>
  );
};
