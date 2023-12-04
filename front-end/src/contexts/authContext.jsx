import React, { createContext, useState, useEffect } from 'react';

import api from '../services/api';
import userApi from '../services/users';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState();
  const [token, setToken] = useState("");

  useEffect(() => {
    function loadStorageData() {
      const storagedUser = localStorage.getItem("user");
      const storagedToken = localStorage.getItem("token");

      if (storagedUser && storagedToken) {
        api.defaults.headers.common.Authorization = `Baerer ${storagedToken}`;
        setUser(JSON.parse(storagedUser));
        setToken(storagedToken);
      }

    }

    loadStorageData();
  }, [token]);

  async function signin(userData) { //COLOCAR UM TRATAMENTO DE EXCEÇÃO AQUI
    try {
      await userApi.register(userData);
      window.alert("Passou o response");
      //window.alert("Passou o response" + response.data);
    } catch (error) {
      console.log(error);
    }

    window.alert("Cadastro realizado com sucesso!")//COLOCAR UM TOAST AQUI
  }

  async function login(userData) {
    try {
      console.log(userData);
      const response = await userApi.authenticate(userData); // ERRO

      api.defaults.headers.common.Authorization = `Bearer ${response.data}`;

      const stringUser = JSON.stringify(userData);
      setUser(JSON.parse(stringUser));
      setToken(response.data);
      console.log(response);

      localStorage.setItem("user", JSON.stringify(userData));
      localStorage.setItem("token", response.data);
    } catch (error) {
      window.alert(error)
    }
  }

  function logout() {
    localStorage.removeItem("user");
    localStorage.removeItem("token");
    setUser(null);
    setToken(null);
  }
  //!!token
  return (
    <AuthContext.Provider value={{ signed: !!token, user, token, signin, login, logout }}>
      {children}
    </AuthContext.Provider>
  );

}

export default AuthContext;