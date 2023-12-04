import React, { useState } from "react";
import useAuth from "../../hooks/auth";
import { InputField, Button } from '../../components';
import logoDLZ from '../../assets/logoDLZ.svg';
import "./style.css";

export default function Login() {

  const initValue = { email: "", senha: "" }

  const [data, setData] = useState(initValue);

  const { login } = useAuth();

  function handleLogin(event) {
    event.preventDefault();
    login(data);
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
        <h1 className="title-auth">Login</h1>
        <div className="line-title"></div>
        <form action="" className="form">
          <InputField placeholder="Email" type="email" onChange={(i) => { storeAuthData({ email: i.target.value }) }} />
          <InputField placeholder="Senha" type="password" onChange={(i) => { storeAuthData({ senha: i.target.value }) }} />

          <a href="#" className="forgot-password">Esqueceu sua senha?</a>

          <Button size="large" onClick={handleLogin}>Login</Button>
        </form>

        <div className="or">
          <div className="line-or"></div>
          <p>ou</p>
          <div className="line-or"></div>
        </div>

        <p className="signin">Não tem uma conta? <a href="/cadastro" className="signin-link">Registre-se</a></p>
      </div>
    </main>
  );
}