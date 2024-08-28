import axios from 'axios';

const API_URL = 'http://localhost:3001/products'; // URL de la API

// Obtener todos los productos
export const getProducts = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error('Error fetching products:', error); // Loggea el error técnico
        throw new Error('Unable to fetch products. Please try again later.'); // Mensaje amigable para el usuario
    }
};

// Crear un nuevo producto
export const createProduct = async (product) => {
    try {
        const response = await axios.post(API_URL, product);
        return response.data;
    } catch (error) {
        console.error('Error creating product:', error); // Loggea el error técnico
        throw new Error('Unable to create product. Please try again later.'); // Mensaje amigable para el usuario
    }
};

// Obtener un producto por ID
export const getProductById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching product by ID:', error); // Loggea el error técnico
        throw new Error('Unable to fetch product details. Please try again later.'); // Mensaje amigable para el usuario
    }
};

// Actualizar un producto por ID
export const updateProduct = async (id, product) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, product);
        return response.data;
    } catch (error) {
        console.error('Error updating product:', error); // Loggea el error técnico
        throw new Error('Unable to update product. Please try again later.'); // Mensaje amigable para el usuario
    }
};

// Eliminar un producto por ID
export const deleteProduct = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
    } catch (error) {
        console.error('Error deleting product:', error); // Loggea el error técnico
        throw new Error('Unable to delete product. Please try again later.'); // Mensaje amigable para el usuario
    }
};