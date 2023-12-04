import React, { createContext, useState } from 'react';

// Create the context
export const SideBarContext = createContext();

// Create the provider component
export const SideBarProvider = ({ children }) => {
  const [sideBarOpen, setSideBarOpen] = useState(false);

  function toggleSideBar() {
    setSideBarOpen(!sideBarOpen);
  }

  function closeSideBar() {
    if (sideBarOpen) {
      setSideBarOpen(false);
    }
  }

  return (
    <SideBarContext.Provider value={{ sideBarOpen, toggleSideBar, closeSideBar }}>
      {children}
    </SideBarContext.Provider>
  );
};
