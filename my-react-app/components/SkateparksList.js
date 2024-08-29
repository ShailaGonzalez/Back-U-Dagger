// src/components/SkateparksList.js
import React, { useState, useEffect } from 'react';
import { getSkateparks } from '../services/skateparkService';
import { Link } from 'react-router-dom';

const SkateparksList = () => {
  const [skateparks, setSkateparks] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchSkateparks = async () => {
      try {
        const data = await getSkateparks();
        setSkateparks(data);
      } catch (err) {
        setError(err.message);
      }
    };
    fetchSkateparks();
  }, []);

  return (
    <div>
      <h1>Skateparks List</h1>
      {error && <p>Error: {error}</p>}
      <Link to="/skatepark-map"><button>View Map</button></Link>
      <ul>
        {skateparks.map(skatepark => (
          <li key={skatepark.id}>
            {skatepark.name} - {skatepark.location}
            <Link to={`/skateparks/${skatepark.id}`}>Details</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SkateparksList;

