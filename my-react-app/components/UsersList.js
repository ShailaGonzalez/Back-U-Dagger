import React, { useEffect, useState } from 'react';
import { getUsers } from '../services/usersService';

const UsersList = () => {
    const [users, setUsers] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const data = await getUsers();
                setUsers(data);
            } catch (err) {
                setError(err.message);
            }
        };

        fetchUsers();
    }, []);

    return (
        <div>
            <h1>Users List</h1>
            {error && <p>Error: {error}</p>}
            <ul>
                {users.map(user => (
                    <li key={user.id}>{user.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default UsersList;
