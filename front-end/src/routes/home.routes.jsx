import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Home, Cart, Profile } from "../pages";

const HomeRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/:departamento" element={<Home />}></Route>
        <Route path="/Cart" element={<Cart />}></Route>
        <Route path="/Profile" element={<Profile />}></Route>
      </Routes>
    </Router>
  );
}

export default HomeRoutes;
