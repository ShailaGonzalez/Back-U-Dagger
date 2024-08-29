import React, { useEffect, useState } from 'react';
import { getProducts, deleteProduct } from '../services/productService';
import { Link } from 'react-router-dom';

const ProductsList = () => {
  // Estados para productos y errores
  const [products, setProducts] = useState([]);
  const [error, setError] = useState(null);

  // Obtener productos al montar el componente
  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const data = await getProducts();
        setProducts(data);
      } catch (err) {
        setError('Failed to fetch products.'); 
      }
    };
    fetchProducts();
  }, []);

  // Manejar eliminación de producto
  const handleDelete = async (id) => {
    try {
      await deleteProduct(id);
      setProducts(products.filter(product => product.id !== id));
    } catch (err) {
      setError('Failed to delete product.'); 
    }
  };

  return (
    <div>
      <h1>Products List</h1>
      {error && <p className="error">{error}</p>} {/* Mostrar errores */}
      <Link to="/add-product"><button>Add Product</button></Link>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            {product.name} - ${product.price}
            <button onClick={() => handleDelete(product.id)}>Delete</button>
            <Link to={`/products/${product.id}`}>Edit</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductsList;
