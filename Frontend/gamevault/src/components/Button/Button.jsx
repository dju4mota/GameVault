import styled from "@emotion/styled"

const StyledButton = styled.button`
  border-radius: 15px;
  border: none;
  cursor: pointer;
  padding: 5px 10px;
  text-align: center;
  :hover {
    transition: all 0.5s;
    transform: scale(1.1);
  }
`

export const Button = ({ children, onClick }) => {
  return <StyledButton onClick={onClick}> {children} </StyledButton>
}