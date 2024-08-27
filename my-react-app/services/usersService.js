import axios from 'axios';

const API_URL = 'http://localhost:8080/users'; // Cambia la URL según la configuración de tu backend

// Obtener todos los usuarios
export const getUsers = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error('Error fetching users', error);
        throw error;
    }
};

// Crear un nuevo usuario
export const createUser = async (user) => {
    try {
        const response = await axios.post(API_URL, user);
        return response.data;
    } catch (error) {
        console.error('Error creating user', error);
        throw error;
    }
};

// Obtener un usuario por ID
export const getUserById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching user', error);
        throw error;
    }
};

// Actualizar un usuario por ID
export const updateUser = async (id, user) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, user);
        return response.data;
    } catch (error) {
        console.error('Error updating user', error);
        throw error;
    }
};

// Eliminar un usuario por ID
export const deleteUser = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
    } catch (error) {
        console.error('Error deleting user', error);
        throw error;
    }
};
