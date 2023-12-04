import React from 'react';
import { Header, SideBar, CartTable } from '../../components';
import useSide from '../../hooks/side';
import './style.css';

const Cart = () => {

  const { toggleSideBar, closeSideBar, sideBarOpen } = useSide();

  return (
    <div>
      <Header toggleSideBar={toggleSideBar} />
      <h1 className='title-cart'>Carrinho</h1>

      <div className='content'>
        <CartTable />
      </div>

      <SideBar isOpen={sideBarOpen} onClickOutSide={closeSideBar} />
    </div>
  );
};

export default Cart;
