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

const Profile = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;
  cursor: pointer;

  &:hover {
    transform: scale(1.05);
    opacity: 0.9;
    transition: all 0.5s;
  }
`;

const ProfileImage = styled.div`
  width: 40px;
  height: 40px;
  border-radius: 50%;
  overflow: hidden;
  transition: inherit;

  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: inherit;
  }
`;

const Username = styled.span`
  color: white;
  font-family: "Montserrat", sans-serif;
  font-weight: bold;
  transition: inherit;
`;

export const Header = ({ openModal, openProfile, openJogos, openListas }) => {
  return (
    <Div>
      <Title>GameVault</Title>
      <Menu>
        <Profile>
          <ProfileImage>
            <img src="https://i.pravatar.cc/300" alt="profile" />
          </ProfileImage>
          <Username>@junior_mota</Username>
        </Profile>
        <Button onClick={openModal}> +Log </Button>
      </Menu>
    </Div>
  );
};
