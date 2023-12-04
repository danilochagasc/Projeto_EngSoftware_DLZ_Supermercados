import React, { useState, useEffect } from 'react';
import trashIcon from '../../assets/trash.png';
import api from '../../services/api';
import './style.css';

export default function OrdersTable() {

  //const [click, setClick] = useState(true);
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    getOrdersData();
  }, []);

  async function getOrdersData() {
    const response = await api.get('/pedido/listar', {
      headers: {
        Authorization: `Bearer ${localStorage.getItem('token')}`,
      },
    });
    setOrders(response.data);
    console.log(response.data);
  }

  function calcularValorTotal(produtos) {
    const valorTotal = produtos.reduce((total, produto) => {

      return ((total + produto.precoVenda) / 100).toFixed(2);
    }, 0);

    return valorTotal;
  }

  function calcularQtdComprada(produtos) {
    const valorTotal = produtos.reduce((total, produto) => {

      return (total + produto.quantidadeComprada);
    }, 0);

    return valorTotal;
  }

  function formatData(data) {
    const date = new Date(data);
    return date.toLocaleString();
  }


  return (
    <table>
      <thead>
        <tr>
          <th>Pedido</th>
          <th>Valor Total</th>
          <th>Quantidade de produtos</th>
          <th>Data/Hora</th>
        </tr>
      </thead>
      <tbody>
        {orders.length > 0 ? orders.map((item, key) => (
          <tr>
            <td>Pedido {key + 1}</td>
            <td>{calcularValorTotal(item.produtosNoPedido)}</td>
            <td>{calcularQtdComprada(item.produtosNoPedido)}</td>
            <td>{formatData(item.dataHora)}</td>
          </tr>
        )) :
          <tr><td>Não há pedidos na sua conta</td></tr>}
      </tbody>
    </table>
  );
};

