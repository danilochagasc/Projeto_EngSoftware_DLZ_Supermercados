import React, { useState, useEffect } from 'react';
import { Header, SideBar } from '../../components';
import useSide from '../../hooks/side';
import api from '../../services/api';
import './style.css';

const Profile = () => {

  const { toggleSideBar, closeSideBar, sideBarOpen } = useSide();

  const [userData, setUserData] = useState({});

  const [ticket, setTicket] = useState("");

  const [cartTotal, setCartTotal] = useState(0);

  function handleInputChange(event) {
    setTicket(event.target.value);
    console.log(ticket);
  }

  async function handleSubmit() {
    try {
      if (ticket !== "") {
        const res = await api.put(`/carrinho/inserirCupom/${ticket}`, null, {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
          },
        });
      }
      const response = await api.post('/pedido/registrar', null, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      });
    } catch (err) {
      console.log(err);
    }
  }

  async function getCartData() {
    const response = await api.get('/carrinho', {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    console.log(response.data);
    const total = calcularValorTotal(response.data);
    setCartTotal(total);
    console.log(total);
  }

  function calcularValorTotal(produtos) {
    const valorTotal = produtos.reduce((total, produto) => {
      return (total + ((produto.produto.preco_em_centavos * produto.quantidade) / 100));
    }, 0);

    return valorTotal;
  }

  async function getUserData() {
    const response = await api.get('/cliente', {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    setUserData(response.data);
  }

  useEffect(() => {
    getUserData();
    getCartData();
  }, []);

  return (
    <div>
      <Header toggleSideBar={toggleSideBar} />

      <h1 className='title-checkout'>Finalizar Pedido</h1>
      <div className='checkout'>

        <div className='box-field'>
          <h2>Resumo do Pedido:</h2>

          <p className='common-text'>Endereço: </p>
          <p className='common-text'>{userData.endereco}</p>

          <div className='field-ticket'>
            <label className='label-ticket'>Cupom: </label>
            <input className='input-ticket' type='text' name='nome' onChange={(e) => handleInputChange(e)} />
          </div>

          <p className='common-text'>Total: </p>
          <p className='common-text'>{cartTotal}</p>
        </div>

        <button className='final-btn' onClick={() => handleSubmit()}>Finalizar Pedido</button>

      </div>

      <SideBar isOpen={sideBarOpen} onClickOutSide={closeSideBar} />
    </div>
  );
};

export default Profile;
