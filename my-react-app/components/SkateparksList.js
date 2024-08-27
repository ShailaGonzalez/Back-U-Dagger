import React, { useEffect, useState } from 'react';
import { getSkateparks } from '../services/skateparksService';

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
            <ul>
                {skateparks.map(skatepark => (
                    <li key={skatepark.id}>{skatepark.name} - {skatepark.location}</li>
                ))}
            </ul>
        </div>
    );
};

export default SkateparksList;

