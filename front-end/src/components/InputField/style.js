import styled from "styled-components";

export const Input = styled.input`
  border: none;
  border-bottom: 2px solid #828282;
  font-size: 20px;

  width: 30vw;

  margin: .7em 1em .7em 1em;
  padding: .4em .4em .4em 0;
  outline: none;
  transition: border-color 0.4s, color 0.4s;
  
  &:focus {
    border-color: #3A62C8;
  }
  
  &:focus::placeholder {
    color: transparent; 
  }
`;


