import React, { useState, useEffect } from 'react';
import { Header, SideBar } from '../../components';
import useSide from '../../hooks/side';
import useAuth from '../../hooks/auth';
import api from '../../services/api';
import axios from 'axios';
import './style.css';

const Profile = () => {

  const { toggleSideBar, closeSideBar, sideBarOpen } = useSide();

  const [isEditing, setIsEditing] = useState(false);

  const [userData, setUserData] = useState({});

  const { logout } = useAuth();

  function handleInputChange(event) {
    const { name, value } = event.target;
    setUserData({ ...userData, [name]: value });
  }

  function handleEditing(e) {
    e.preventDefault();
    setIsEditing(!isEditing)
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setUserData({ ...userData, ["permissao"]: "USER" });
    const response = await api.put('/cliente/atualizarCliente', userData, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });

    console.log(response.data);

    //LOGICA DE CHAMADA DO AXIOS
    setIsEditing(false);
  }

  async function handleDelete(e) {
    e.preventDefault();
    try {
      const response = await axios.delete('http://localhost:8080/cliente/deletar', {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      });
      /* const response = await api.delete('/cliente/deletar', {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      }); */
      logout();
    } catch (err) {
      console.log(err);
    }
  }

  async function getUserData() {
    const response = await api.get('/cliente', {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    setUserData(response.data);
    console.log(response.data);
  }

  useEffect(() => {
    getUserData();
  }, []);

  return (
    <div>
      <Header toggleSideBar={toggleSideBar} />

      <div className='profile'>
        <form className='border'>


          <h1 className='name-client'>Nome Cliente</h1>
          <div className='box-field-profile'>
            <div className='header-profile'>
              <p className='text-profile'>Informações pessoais: </p>
              <button className='edit-btn' onClick={(e) => handleEditing(e)}>Editar</button>
            </div>
            <div className='field'>
              <label className='label text-profile'>Nome: </label>
              <input className='input-edit' type='text' value={userData.nome} name='nome' disabled={!isEditing} onChange={(e) => handleInputChange(e)} />
            </div>
            <div className='field'>
              <label className='label text-profile'>Email: </label>
              <input className='input-edit' type='text' value={userData.email} name='email' disabled={!isEditing} onChange={handleInputChange} />
            </div>
            <div className='field'>
              <label className='label text-profile'>Telefone: </label>
              <input className='input-edit' type='text' value={userData.telefone} name='telefone' disabled={!isEditing} onChange={handleInputChange} />
            </div>
            <div className='field'>
              <label className='label text-profile'>Endereço: </label>
              <input className='input-edit' type='text' value={userData.endereco} name='endereco' disabled={!isEditing} onChange={handleInputChange} />
            </div>
          </div>
          <div className='bottom-btns'>
            <button className='bottom-btn' onClick={(e) => handleSubmit(e)}>Alterar Dados</button>
            <button className='bottom-btn' onClick={(e) => handleDelete(e)}>Excluir Conta</button>
          </div>
        </form>
      </div>

      <SideBar isOpen={sideBarOpen} onClickOutSide={closeSideBar} />
    </div>
  );
};

export default Profile;
