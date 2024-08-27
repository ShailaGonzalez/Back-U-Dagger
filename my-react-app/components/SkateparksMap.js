import React, { useEffect, useState } from 'react';
import { APIProvider, Map, Marker } from '@vis.gl/react-google-maps';
import { getSkateparks } from '../services/skateparksService';

const SkateparksMap = () => {
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
        <div style={{ height: '500px', width: '100%' }}>
            <h1>Skateparks Map</h1>
            {error && <p>Error: {error}</p>}
            <APIProvider apiKey={process.env.REACT_APP_GOOGLE_MAPS_API_KEY}>
                <Map
                    style={{ height: '100%', width: '100%' }}
                    defaultCenter={{ lat: 41.3851, lng: 2.1734 }} // Coordenadas para centrar en Barcelona
                    defaultZoom={12}
                >
                    {skateparks.map(skatepark => (
                        <Marker
                            key={skatepark.id}
                            position={{ lat: skatepark.latitude, lng: skatepark.longitude }}
                            title={skatepark.name}
                        />
                    ))}
                </Map>
            </APIProvider>
        </div>
    );
};

export default SkateparksMap;
