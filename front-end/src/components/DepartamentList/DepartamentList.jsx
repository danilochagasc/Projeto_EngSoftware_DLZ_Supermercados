import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { getDepartaments } from '../../services/departament';
import './style.css';

const DepartamentList = () => {

  const [departamentos, setDepartamentos] = useState([]);

  async function getDepartamentList() {
    const response = await axios.get('http://localhost:8080/departamento/listar');
    setDepartamentos(response.data);
    /* const response = getDepartaments();
    setDepartamentos(response.data); */
  }

  useEffect(() => { getDepartamentList() }, []);

  const navigate = useNavigate();

  function handleNavigate(route) {
    navigate(`/${route}`);
  }

  return (
    <div className='container'>
      <h2 className='title'>Departamentos</h2>
      <div className='list-dep'>
        {departamentos.map((departamento) => {
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
