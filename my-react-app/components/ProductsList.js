import React, { useEffect, useState } from 'react';
import { getProducts, deleteProduct } from '../services/productService';
import { Link } from 'react-router-dom';

const ProductsList = () => {
  // Estado para almacenar la lista de productos y posibles errores
  const [products, setProducts] = useState([]);
  const [error, setError] = useState(null);

  // Efecto para obtener los productos cuando el componente se monta
  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const data = await getProducts(); // Llama al servicio para obtener productos
        setProducts(data); // Guarda los productos en el estado
      } catch (err) {
        setError(err.message); // Maneja errores
      }
    };
    fetchProducts(); // Ejecuta la función para obtener productos
  }, []);

  // Maneja la eliminación de un producto
  const handleDelete = async (id) => {
    try {
      await deleteProduct(id); // Llama al servicio para eliminar el producto
      setProducts(products.filter(product => product.id !== id)); // Actualiza la lista de productos
    } catch (err) {
      setError(err.message); // Maneja errores
    }
  };

  return (
    <div>
      <h1>Products List</h1>
      {error && <p>Error: {error}</p>} {/* Muestra errores */}
      <Link to="/add-product"><button>Add Product</button></Link> {/* Enlace para agregar un producto */}
      <ul>
        {products.map(product => (
          <li key={product.id}>
            {product.name} - ${product.price} {/* Muestra nombre y precio del producto */}
            <button onClick={() => handleDelete(product.id)}>Delete</button> {/* Botón para eliminar */}
            <Link to={`/products/${product.id}`}>Edit</Link> {/* Enlace para editar */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductsList;

