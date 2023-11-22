import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Login, Signin } from "../pages";

const Home = () => {
  return (
    <div>
      <h1>HOME</h1><br />
      <button>signout</button>
    </div>
  );
}

const HomeRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />}></Route>
      </Routes>
    </Router>
  );
}

export default HomeRoutes;
