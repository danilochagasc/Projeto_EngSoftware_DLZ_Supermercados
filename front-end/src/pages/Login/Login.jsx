import React from "react";
import { InputField, Button } from '../../components';
import logoDLZ from '../../assets/logoDLZ.svg';
import facebook from '../../assets/facebook.svg';
import google from '../../assets/google.png';
import "./style.css";

export default function Login() {
  return (
    <main className="main">
      <div className="background"></div>
      <aside className="left-aside">
        <img src={logoDLZ} alt="Logo" className="logo" />
      </aside>

      <div className="right-aside">
        <h1 className="title">Login</h1>
        <div className="line-title"></div>
        <form action="" className="form">
          <InputField placeholder="Email" type="email" />
          <InputField placeholder="Senha" type="password" />

          <a href="#" className="forgot-password">Esqueceu sua senha?</a>

          <Button size="large">Login</Button>
        </form>

        <div className="or">
          <div className="line-or"></div>
          <p>ou</p>
          <div className="line-or"></div>
        </div>

        <div className="logins">
          <div className="facebook-login"><img src={facebook} alt="" className="login-image" /></div>
          <div className="google-login"><img src={google} alt="" className="login-image" /></div>
        </div>

        <p className="signin">Não tem uma conta? <a href="/cadastro" className="signin-link">Registre-se</a></p>
      </div>
    </main>
  );
}