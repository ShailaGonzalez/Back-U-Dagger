import axios from 'axios';

const API_URL = 'http://localhost:8080/products'; // URL de la API

// Obtener todos los productos
export const getProducts = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data; // Devuelve la lista de productos
    } catch (error) {
        console.error('Error fetching products', error);
        throw error; // Lanza el error si ocurre
    }
};

// Crear un nuevo producto
export const createProduct = async (product) => {
    try {
        const response = await axios.post(API_URL, product);
        return response.data; // Devuelve el producto creado
    } catch (error) {
        console.error('Error creating product', error);
        throw error; // Lanza el error si ocurre
    }
};

// Obtener un producto por ID
export const getProductById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data; // Devuelve el producto con el ID especificado
    } catch (error) {
        console.error('Error fetching product', error);
        throw error; // Lanza el error si ocurre
    }
};

// Actualizar un producto por ID
export const updateProduct = async (id, product) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, product);
        return response.data; // Devuelve el producto actualizado
    } catch (error) {
        console.error('Error updating product', error);
        throw error; // Lanza el error si ocurre
    }
};

// Eliminar un producto por ID
export const deleteProduct = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`); // Elimina el producto con el ID especificado
    } catch (error) {
        console.error('Error deleting product', error);
        throw error; // Lanza el error si ocurre
    }
};
