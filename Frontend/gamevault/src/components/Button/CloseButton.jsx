import styled from "@emotion/styled";

const CloseButton = styled.button`
  position: absolute;
  top: 15px;
  right: 15px;
  background: none;
  border: none;
  color: white;
  cursor: pointer;
  font-size: 1.5rem;
  transition: color 0.3s ease;

  &:hover {
    color: #ff4800;
  }

  &::before {
    content: "\\f00d"; /* FontAwesome times (X) icon */
    font-family: FontAwesome;
    display: inline-block;
  }
`;

export const CloseButtonStyled = ({ children, onClick }) => {
  return <CloseButton onClick={onClick}>{children}</CloseButton>;
};
