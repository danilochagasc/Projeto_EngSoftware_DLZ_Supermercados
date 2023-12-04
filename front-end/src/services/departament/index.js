import api from '../api';

export async function getDepartaments() {
  const response = await api.get('/departamento/listar');
  return response;
}