import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Home } from "../pages";

const HomeRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/:departamento" element={<Home />}></Route>
      </Routes>
    </Router>
  );
}

export default HomeRoutes;
