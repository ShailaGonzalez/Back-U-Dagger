import React, { useState, useEffect } from 'react';
import { getUsers, deleteUser } from '../services/userService';
import { Link } from 'react-router-dom';

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

  const handleDelete = async (id) => {
    try {
      await deleteUser(id);
      setUsers(users.filter(user => user.id !== id));
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      <h1>Users List</h1>
      {error && <p>Error: {error}</p>}
      <Link to="/users/add"><button>Add User</button></Link>
      <ul>
        {users.map(user => (
          <li key={user.id}>
            {user.name} - {user.email}
            <button onClick={() => handleDelete(user.id)}>Delete</button>
            <Link to={`/users/${user.id}`}>Edit</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UsersList;
