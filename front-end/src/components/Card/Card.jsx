import React, { useState } from 'react';
import axios from 'axios';
import './style.css';


const Card = ({ id, nome, preco, imagem }) => {

  const [count, setCount] = useState(0);
  const [lilCar, setLilCar] = useState({ produto: { idProduto: id }, quantidade: 0 });

  function incrementCount() {
    setCount(prevCount => {
      const updatedCount = prevCount + 1;
      setLilCar({ produto: { idProduto: id }, quantidade: updatedCount });
      return updatedCount;
    });
  }

  function decrementCount() {
    if (count > 0) {
      setCount(prevCount => {
        const updatedCount = prevCount - 1;
        setLilCar({ produto: { idProduto: id }, quantidade: updatedCount });
        return updatedCount;
      });
    }
  }

  async function addToCar() {
    console.log(lilCar);
    if (count > 0) {
      const response = await axios.post('http://localhost:8080/carrinho/registrar', lilCar, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      });
      console.log(response);
    }
    console.log('Adicionado ao carrinho');
    setCount(0);
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
