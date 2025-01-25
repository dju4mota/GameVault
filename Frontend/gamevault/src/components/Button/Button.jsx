import styled from "@emotion/styled"

const LogButton = styled.button`
  background-color: #ff4800;
  border-radius: 5px;
  border: none;
  cursor: pointer;
  display: flex;
  padding: 8px 25px;
  margin: 1vh auto auto auto;
  text-align: center;
  color:rgb(255, 255, 255);
  :hover {
    background-color: orange;
    transition: all 0.5s;
    transform: scale(1.1);
  }
`

export const Button = ({ text }) => {
  return (<LogButton> {text} </LogButton>)

}