import api from '../api';

export async function addProductToCar(data) {
  const response = api.post('/carrinho/registrar/', data);
  return response;
}

export async function incrementProductToCar(id) {
  const response = await api.put('/carrinho/adicionar/' + id);
  return response;
}

export async function decrementProductToCar(id) {
  const response = api.put('/carrinho/remover/' + id);
  return response;
}