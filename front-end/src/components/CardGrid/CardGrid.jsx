import React from 'react';
import { Card } from '../index';

const CardGrid = ({ departamento }) => {
  return (
    <div>
      <Card id={departamento} />
      <Card id={departamento} />
      <Card id={departamento} />
    </div>
  );
};

export default CardGrid;
