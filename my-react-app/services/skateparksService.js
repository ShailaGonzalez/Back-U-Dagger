import axios from 'axios';

const API_URL = 'http://localhost:8080/skateparks'; // Cambia la URL según la configuración de tu backend

// Obtener todos los skateparks
export const getSkateparks = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error('Error fetching skateparks', error);
        throw error;
    }
};

// Crear un nuevo skatepark
export const createSkatepark = async (skatepark) => {
    try {
        const response = await axios.post(API_URL, skatepark);
        return response.data;
    } catch (error) {
        console.error('Error creating skatepark', error);
        throw error;
    }
};

// Obtener un skatepark por ID
export const getSkateparkById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching skatepark', error);
        throw error;
    }
};

// Actualizar un skatepark por ID
export const updateSkatepark = async (id, skatepark) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, skatepark);
        return response.data;
    } catch (error) {
        console.error('Error updating skatepark', error);
        throw error;
    }
};

// Eliminar un skatepark por ID
export const deleteSkatepark = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
    } catch (error) {
        console.error('Error deleting skatepark', error);
        throw error;
    }
};
