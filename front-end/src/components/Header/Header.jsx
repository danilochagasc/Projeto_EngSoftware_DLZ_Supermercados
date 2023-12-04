import React from 'react';
import { useNavigate } from 'react-router-dom';
import useAuth from '../../hooks/auth';
import logoDLZ from '../../assets/logoDLZ.svg';
import carrinhoIcon from '../../assets/carrinho-de-compras.svg';
import avatarIcon from '../../assets/avatar.png';
import "./style.css";

const Header = ({ toggleSideBar }) => {

  const navigate = useNavigate();

  function handleNavigate(route) {
    navigate(`/${route}`);
  }

  const { logout } = useAuth();

  function handleLogout() {
    logout();
  }

  return (
    <header className='header'>
      <nav className="nav-top">
        <div className="logo-header">
          <img src={logoDLZ} alt="" />
        </div>
        <div className='search-container'>
          <input type="text" placeholder='Buscar por produto' className='input' />
          <button className='search-btn'>Buscar</button>
        </div>
        <button className='car-btn white' onClick={() => handleNavigate("Profile")}>
          <img src={avatarIcon} alt="" />
        </button>
        <button className='car-btn' onClick={() => handleNavigate("Cart")}>
          <img src={carrinhoIcon} alt="" />
        </button>
      </nav>

      <nav className="nav-bottom">
        <ul className="nav-bottom-list">
          <li className='list-item'>
            <button className='button-list-item' onClick={toggleSideBar}>Ver todas as categorias</button>
          </li>
          <li className='list-item'>
            <button className='button-list-item' onClick={() => handleNavigate('MyOrders')}>Meus Pedidos</button>
          </li>
          <li className='list-item'>
            <button className='button-list-item' onClick={handleLogout}>Sair</button>
          </li>
        </ul>
      </nav>

    </header>
  );
};

export default Header;
