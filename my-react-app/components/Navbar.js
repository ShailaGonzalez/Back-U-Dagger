import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/users">Users List</Link></li>
        <li><Link to="/products">Products List</Link></li>
        <li><Link to="/skateparks">Skateparks List</Link></li>
        <li><Link to="/skatepark-map">Skatepark Map</Link></li>
        <li><Link to="/add-product">Add Product</Link></li>
      </ul>
    </nav>
  );
};

export default Navbar;


