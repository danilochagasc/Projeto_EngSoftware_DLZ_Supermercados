import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Login, Signin } from "../pages";

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />}></Route>
        <Route path="/cadastro" element={<Signin />}></Route>
      </Routes>
    </Router>
  );
}

export default AppRoutes;
