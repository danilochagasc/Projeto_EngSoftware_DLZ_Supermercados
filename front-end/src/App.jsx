import React from 'react';
import GlobalStyle from './styles/globalStyle.js';
import { Login, Signin } from './pages';

function App() {
  return (
    <div>
      <GlobalStyle />
      <Signin />
    </div>
  )
}

export default App;
