import React, { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import useSide from '../../hooks/side';
import api from '../../services/api';

import { Header, CardGrid, SideBar } from '../../components';
import './style.css';

export default function Home() {

  const { departamento } = useParams();

  const { toggleSideBar, closeSideBar, sideBarOpen } = useSide();

  return (
    <div >
      <Header toggleSideBar={toggleSideBar} />
      <div className='home-content' >
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
      <SideBar isOpen={sideBarOpen} onClickOutSide={closeSideBar} />
    </div>
  );
}
