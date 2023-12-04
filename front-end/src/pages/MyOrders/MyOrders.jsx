import React from 'react';
import { Header, SideBar, OrdersTable } from '../../components';
import useSide from '../../hooks/side';
import './style.css';

export default function MyOrders() {

  const { toggleSideBar, closeSideBar, sideBarOpen } = useSide();



  return (
    <div>
      <Header toggleSideBar={toggleSideBar} />
      <h1 className='title-cart'>Carrinho</h1>

      <div className='content'>
        <OrdersTable />
      </div>

      <SideBar isOpen={sideBarOpen} onClickOutSide={closeSideBar} />
    </div>
  );
};