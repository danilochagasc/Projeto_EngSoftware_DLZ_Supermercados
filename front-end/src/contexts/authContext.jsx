import React, { createContext, useState, useEffect } from 'react';

import api from '../services/api';
import userApi from '../services/users';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState();
  const [token, setToken] = useState();
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function loadStorageData() {
      const storagedUser = await localStorage.getItem("user");
      const storagedToken = await localStorage.getItem("token");

      if (storagedUser && storagedToken) {
        api.defaults.headers.common.Authorization = `Baerer ${storagedToken}`;
        setUser(JSON.parse(storagedUser));
        setToken(storagedToken);
      }

      setLoading(false);
    }

    loadStorageData();
  }, []);

  async function signin(userData) { //COLOCAR UM TRATAMENTO DE EXCEÇÃO AQUI
    try {
      await userApi.register(userData);
      setLoading(false);
    } catch (error) {
      console.log(error);
    }

    window.alert("Cadastro realizado com sucesso!")//COLOCAR UM TOAST AQUI
  }

  async function login(userData) {
    const response = await userApi.authenticate(userData);
    setLoading(false);

    api.defaults.headers.common.Authorization = `Baerer ${response.data.token}`;
    setUser(JSON.parse(userData));
    setToken(response.data.token);

    await localStorage.setItem("user", JSON.stringify(userData));
    await localStorage.setItem("token", response.data.token);

  }

  async function logout() {
    await localStorage.removeItem("user");
    await localStorage.removeItem("token");
    setUser(null);
    setToken(null);
  }

  return (
    <AuthContext.Provider value={{ signed: !!token, user, token, loading, setLoading, signin, login, logout }}>
      {children}
    </AuthContext.Provider>
  );

}

export default AuthContext;