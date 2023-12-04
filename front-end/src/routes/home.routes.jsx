import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { SideBarProvider } from "../contexts/sideBarContext";
import { Home, Cart, Profile, Checkout, MyOrders } from "../pages";

const HomeRoutes = () => {
  return (
    <SideBarProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/:departamento" element={<Home />}></Route>
          <Route path="/Cart" element={<Cart />}></Route>
          <Route path="/Profile" element={<Profile />}></Route>
          <Route path="/Checkout" element={<Checkout />}></Route>
          <Route path="/MyOrders" element={<MyOrders />}></Route>
        </Routes>
      </Router>
    </SideBarProvider>
  );
}

export default HomeRoutes;
