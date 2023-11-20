import React from "react";
import { InputField, Button } from '../../components';
import logoDLZ from '../../assets/logoDLZ.svg';
import "./style.css";

export default function Signin() {
  return (
    <main className="main">
      <div className="background"></div>
      <aside className="left-aside">
        <img src={logoDLZ} alt="Logo" className="logo" />
      </aside>

      <div className="right-aside">
        <h1 className="title">Registre-se</h1>
        <div className="line-title"></div>
        <form action="" className="form">
          <InputField placeholder="Nome Completo" type="text" />
          <InputField placeholder="Email" type="email" />
          <InputField placeholder="Endereço" type="text" />
          <InputField placeholder="Telefone" type="tel" />
          <InputField placeholder="Senha" type="password" />
          <p className="terms">Ao se cadastrar, você concorda com nossos  <a href="" className="terms-link">Termos</a>, <a href="" className="terms-link">Política de Privacidade</a> e <a href="" className="terms-link">Política de Cookies</a></p>

          <Button size="large">Registrar</Button>
        </form>
      </div>
    </main>
  );
}