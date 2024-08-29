import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UsersList from './components/UsersList'; // Lista de usuarios
import UserForm from './components/UserForm'; // agregar o editar usuarios
import ProductsList from './components/ProductsList'; // Lista de productos
import ProductForm from './components/ProductForm'; //  agregar o editar productos
import SkateparksList from './components/SkateparksList'; // Lista de skateparks
import SkateparkMap from './components/SkateparkMap'; // Mapa de skateparks
import Navbar from './components/Navbar'; // Navegación

const App = () => {
  return (
    <Router>
      <div>
        <h1>U!Dagger</h1>
        <Navbar />  {/* Incluye el Navbar */}
        <Switch>
          // Rutas para la lista de usuarios y el formulario de usuarios //
          <Route path="/users" exact component={UsersList} />
          <Route path="/users/add" component={UserForm} /> {/* Agregar usuario */}
          <Route path="/users/:id" component={UserForm} /> {/* Editar usuario */}
          
          {/* Rutas para la lista de productos y el formulario de productos */}
          <Route path="/products" exact component={ProductsList} />
          <Route path="/products/:id" component={ProductForm} /> {/* Editar producto */}
          <Route path="/add-product" component={ProductForm} /> {/* Agregar producto */}
          
          {/* Rutas para la lista de skateparks y el mapa de skateparks */}
          <Route path="/skateparks" exact component={SkateparksList} />
          <Route path="/skatepark-map" component={SkateparkMap} />
          
          {/* Ruta por defecto */}
          <Route path="/" exact>
            <h2>My SkateTreasures</h2>
          </Route>
        </Switch>
      </div>
    </Router>
  );
};

export default App;
