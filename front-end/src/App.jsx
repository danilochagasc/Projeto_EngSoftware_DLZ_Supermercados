import React from 'react';
import GlobalStyle from './styles/globalStyle.js';
import AppRoutes from './routes';
import { AuthProvider } from './contexts/authContext.jsx';

function App() {
  return (
    <AuthProvider>
      <GlobalStyle />
      <AppRoutes />
    </AuthProvider>
  )
}

export default App;
