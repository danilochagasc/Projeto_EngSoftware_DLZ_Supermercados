import React from 'react';
import { useNavigate } from 'react-router-dom';
import './style.css';

const DepartamentList = () => {

  const departamentos = [
    { id: 1, nome: "Laticínios" },
    { id: 2, nome: "Frios" },
    { id: 3, nome: "Higiene" },
    { id: 4, nome: "Limpeza" },
    { id: 5, nome: "Bebidas" },
    { id: 6, nome: "Carnes" },
    { id: 7, nome: "Biscoitos" },
    { id: 8, nome: "Padaria" },
    { id: 9, nome: "Hortifruti" },
  ]

  const navigate = useNavigate();

  function handleNavigate(route) {
    navigate(`/${route}`);
  }

  return (
    <div className='container'>
      <h2 className='title'>Departamentos</h2>
      <div className='list-dep'>
        {departamentos.map((departamento, index) => {
          return (
            <button className='list-dep-item' onClick={() => { handleNavigate(departamento.nome) }}>{departamento.nome}</button>
          )
        })
        }
      </div>
    </div>
  );
};

export default DepartamentList;
