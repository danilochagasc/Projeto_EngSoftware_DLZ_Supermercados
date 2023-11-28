import React from 'react';
import { useNavigate } from 'react-router-dom';
import logoDLZ from '../../assets/logoDLZ.svg';
import carrinhoIcon from '../../assets/carrinho-de-compras.svg';
import "./style.css";

const Header = (props) => {

  const navigate = useNavigate();

  function handleNavigate(route) {
    navigate(`/${route}`);
  }

  return (
    <header className='header'>
      <nav className="nav-top">
        <div className="logo">
          <img src={logoDLZ} alt="" />
        </div>
        <div className='search-container'>
          <input type="text" placeholder='Buscar por produto' className='input' />
          <button className='search-btn'>Buscar</button>
        </div>
        <button className='car-btn' >
          <img src={carrinhoIcon} alt="" />
        </button>
      </nav>

      <nav className="nav-bottom">
        <ul className="nav-bottom-list">
          <li className='list-item'>
            <button className='button-list-item' onClick={props.toggleSideBar}>Ver todas as categorias</button>
          </li>
          <li className='list-item'>
            <button className='button-list-item' href="">Fale Conosco</button>
          </li>
        </ul>
      </nav>

    </header>
  );
};

export default Header;
