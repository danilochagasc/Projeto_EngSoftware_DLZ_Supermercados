import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import trashIcon from '../../assets/trash.png';
import api from '../../services/api';
import './style.css';

export default function CartTable() {

  const [click, setClick] = useState(true);
  const [cart, setCart] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getCartData();
  }, [click]);

  function handleNavigate() {
    navigate('/Checkout');
  }

  async function getCartData() {
    const response = await api.get('/carrinho', {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    setCart(response.data);
    console.log(response.data);
  }

  async function incrementCount(id) {
    const response = await api.put(`/carrinho/adicionar/${id}`, "", {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    console.log(response.data);
    setClick(!click);
  }

  async function decrementCount(id) {
    const response = await api.put(`/carrinho/remover/${id}`, "", {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    console.log(response.data);
    setClick(!click);
  }

  async function handleDeleteProduct(id) {
    const response = await api.delete(`carrinho/deletarItem/${id}`, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    setClick(!click);
  }

  async function handleDeleteCart() {
    console.log('deletando carrinho');
    const response = await api.delete('carrinho/deletarCarrinho', {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    setClick(!click);
  }

  return (
    <table>
      <thead>
        <tr>
          <th>Nome produto</th>
          <th>Valor</th>
          <th>Quantidade</th>
        </tr>
      </thead>
      <tbody>
        {cart.length > 0 ? cart.map((item) => (
          <tr>
            <td>{item.produto.nome}</td>
            <td>{((item.produto.preco_em_centavos * item.quantidade) / 100).toFixed(2)}</td>
            <td>
              <div className='alter-count-cart'>
                <button className='put-on-cart-button' onClick={() => incrementCount(item.produto.idProduto)}>+</button>
                <p className='count-cart'>{item.quantidade}</p>
                <button className='put-on-cart-button' onClick={() => decrementCount(item.produto.idProduto)}>-</button>

              </div>
            </td>

            <td>
              <button className='delete-item' onClick={() => handleDeleteProduct(item.produto.idProduto)}>
                <img src={trashIcon} alt="" />
              </button>
            </td>
          </tr>
        )) :
          <tr><td>Não há produtos no carrinho</td></tr>}
      </tbody>
      <div className='buttons'>
        <button className='submit-btn btn' onClick={() => handleNavigate()}>Finalizar Pedido</button>
        <button className='delete-btn btn' onClick={() => handleDeleteCart()}>Deletar Carrinho</button>
      </div>
    </table>
  );
};

