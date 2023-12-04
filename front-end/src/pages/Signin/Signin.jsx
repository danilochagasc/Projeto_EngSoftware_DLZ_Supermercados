import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import useAuth from "../../hooks/auth";
import { InputField, Button } from "../../components";
import logoDLZ from "../../assets/logoDLZ.svg";
import "./style.css";

export default function Signin() {

  const navigate = useNavigate();

  const initValue = { nome: "", email: "", senha: "", endereco: "", permissao: "USER" }

  const [data, setData] = useState(initValue);

  const { signin } = useAuth();

  function handleSignin() {
    signin(data);
  }

  function storeAuthData(i) {
    setData({ ...data, ...i });
  }

  return (
    <main className="main">
      <div className="background"></div>
      <aside className="left-aside">
        <img src={logoDLZ} alt="Logo" className="logo-auth" />
      </aside>

      <div className="right-aside">
        <h1 className="title-auth">Registre-se</h1>
        <div className="line-title"></div>
        <form action="" className="form">
          <InputField placeholder="Nome Completo" type="text" onChange={(i) => { storeAuthData({ nome: i.target.value }) }} />
          <InputField placeholder="Email" type="email" onChange={(i) => { storeAuthData({ email: i.target.value }) }} />
          <InputField placeholder="Senha" type="password" onChange={(i) => { storeAuthData({ senha: i.target.value }) }} />
          <InputField placeholder="Telefone" type="tel" onChange={(i) => { storeAuthData({ telefone: i.target.value }) }} />
          <InputField placeholder="Endereço" type="text" onChange={(i) => { storeAuthData({ endereco: i.target.value }) }} />
          <p className="login-link">Já possuo conta  <a href="../" className="terms-link">Logar</a></p>

          <Button size="large" onClick={handleSignin} >Registrar</Button>
        </form>
      </div>
    </main>
  );
}