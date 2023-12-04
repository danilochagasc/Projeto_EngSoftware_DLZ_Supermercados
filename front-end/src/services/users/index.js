import api from '../api';

class UserData {
  register(data) {
    return api.post('/cliente/registrar', data);
  }
  authenticate(data) {
    return api.post('/cliente/login', data);
  }
}

export default new UserData();