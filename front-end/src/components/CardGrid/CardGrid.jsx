import React, { useEffect, useState } from 'react';
import './style.css';
import axios from 'axios';
import { Card } from '../index';

const CardGrid = ({ departamento }) => {

  const [products, setProducts] = useState([]);

  async function getProductsByDep() {
    const response = await axios.get(`http://localhost:8080/produto/listarPorDep/${departamento}`);
    setProducts(response.data);
  }

  async function getProducts() {
    const response = await axios.get(`http://localhost:8080/produto/listar`);
    setProducts(response.data);
  }

  useEffect(() => {
    if (departamento) {
      getProductsByDep();
    } else {
      getProducts();
    }
  }, [departamento]);

  return (
    <div className='card-grid'>
      {products.map((produto) => {
        return (
          <Card id={produto.idProduto} nome={produto.nome} preco={(produto.preco_em_centavos / 100)} imagem={produto.imagem} />
        );
      })}
    </div>
  );
};

export default CardGrid;
