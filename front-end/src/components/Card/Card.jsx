import React, { useState } from 'react';
import axios from 'axios';
import './style.css';


const Card = ({ id, nome, preco, imagem }) => {

  const [count, setCount] = useState(0);
  const [lilCar, setLilCar] = useState({ produto: { idProduto: id }, quantidade: count });
  const teste = { produto: { idProduto: '1c190c78-2665-4902-9cdf-810e5d2160ac' }, quantidade: 2 };


  function incrementCount() {
    setCount(prevCount => prevCount + 1);
  }

  function decrementCount() {
    if (count > 0) {
      setCount(prevCount => prevCount - 1);
    }
  }

  async function addToCar() {
    //setLilCar({ produto: { idProduto: id }, quantidade: count });
    if (count > 0) {
      console.log('Entrou no if');
      const response = await axios.post('http://localhost:8080/carrinho/registrar', teste);
      console.log(response);
    }
    console.log('Adicionado ao carrinho');
  }

  return (
    <div className='card'>
      <h1 className='product-name'>{nome}</h1>
      <h2 className='product-price'>R$ {preco.toFixed(2)}</h2>
      <img className='product-image' src={imagem} alt="" />
      <div className='put-on-car'>
        <div className='alter-count-product'>
          <button className='put-on-car-button' onClick={incrementCount}>+</button>
          <p className='count'>{count}</p>
          <button className='put-on-car-button' onClick={decrementCount}>-</button>
        </div>
        <button className='buy-button' onClick={addToCar}>Comprar</button>
      </div>
    </div>
  );
};

export default Card;
