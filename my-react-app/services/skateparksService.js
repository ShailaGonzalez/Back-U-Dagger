import axios from 'axios';

const API_URL = 'http://localhost:3001/skateparks'; // Cambia la URL según la configuración de mi backend

// Obtener todos los skateparks
export const getSkateparks = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error('Error fetching skateparks:', error); // Loggea el error técnico
        throw new Error('Unable to fetch skateparks. Please try again later.'); 
    }
};

// Obtener un skatepark por ID
export const getSkateparkById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching skatepark by ID:', error); // Loggea el error técnico
        throw new Error('Unable to fetch skatepark details. Please try again later.'); 
    }
};

// Actualizar un skatepark por ID
export const updateSkatepark = async (id, skatepark) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, skatepark);
        return response.data;
    } catch (error) {
        console.error('Error updating skatepark:', error); // Loggea el error técnico
        throw new Error('Unable to update skatepark. Please try again later.'); 
    }
};
