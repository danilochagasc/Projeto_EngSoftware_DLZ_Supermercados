import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import { DepartamentList, Header, CardGrid } from '../../components';
import logoDLZ from '../../assets/logoDLZ.svg';
import './style.css';

export default function Home() {

  const { departamento } = useParams();

  //Controla a abertura e fechamento da SideBar
  const [sideBarOpen, setSideBarOpen] = useState(false);

  //Funções para controlar a abertura e fechamento da SideBar
  function toggleSideBar() {
    setSideBarOpen(!sideBarOpen);
  }

  function closeSideBar() {
    if (sideBarOpen) {
      setSideBarOpen(false);
    }
  }

  //Fecha a SideBar quando o usuário seleciona um departamento
  useEffect(() => {
    closeSideBar();
  }, [departamento])

  return (
    <div className={sideBarOpen ? "container-relative" : ""}>

      {/* ==================================================================================== */}
      {/* ================================Parte da SideBar==================================== */}

      {sideBarOpen ?
        <nav className={`nav-side ${sideBarOpen ? "nav-side-open" : ""}`}>
          <div className="logo">
            <img src={logoDLZ} alt="" />
          </div>
          <DepartamentList />
        </nav>
        : null}

      {/* ==================================================================================== */}

      <div onClick={closeSideBar}>
        <Header sideBarOpen={sideBarOpen} toggleSideBar={toggleSideBar} />

        <div className='home-content'>
          <aside className='home-aside'>
            <p className='navigate-ref'>Home &gt; {departamento}</p>
            <h1 className='title'>{departamento}</h1>
            <h3 className='order-by'>Ordenar por</h3>
            <div className='order-buttons'>
              <button className='order-btn'>Maior Preço</button>
              <button className='order-btn'>Menor Preço</button>
              <button className='order-btn'>De A a Z</button>
              <button className='order-btn'>De Z a A</button>
            </div>
          </aside>


          <main className='home-main'>
            <CardGrid departamento={departamento} />
          </main>

        </div>

        <div className={`${sideBarOpen ? "overlay visible" : ""}`}></div>

      </div>

    </div>
  );
}
