import React, { useEffect, useRef } from 'react';
import { DepartamentList } from '../../components';
import logoDLZ from '../../assets/logoDLZ.svg';
import './sidebarStyle.css';

export default function SideBar({ isOpen, onClickOutSide }) {

  const componentRef = useRef(null);

  const handleClickOutSide = (event) => {
    if (componentRef.current && !componentRef.current.contains(event.target)) {
      onClickOutSide();
    }
  };

  useEffect(() => {
    document.addEventListener('mousedown', handleClickOutSide);

    return () => {
      document.removeEventListener('mousedown', handleClickOutSide);
    };
  }, []);

  return (
    isOpen && (
      <nav className="sidebar-overlay" ref={componentRef}>
        <div className="logo">
          <img src={logoDLZ} alt="" />
        </div>
        <DepartamentList />
      </nav>
    )
  );
};