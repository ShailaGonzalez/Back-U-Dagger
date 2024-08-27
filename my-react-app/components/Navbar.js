import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UsersList from './components/UsersList';
import ProductsList from './components/ProductsList';
import SkateparksList from './components/SkateparksList';
import ProductForm from './components/ProductForm';
import Navbar from './components/Navbar';  

const App = () => {
  return (
    <Router>
      <div>
        <h1>My Skate App</h1>
        <Navbar /> {/* Incluye el Navbar aquí */}
        <Switch>
          <Route path="/users" exact component={UsersList} />
          <Route path="/products" exact component={ProductsList} />
          <Route path="/skateparks" exact component={SkateparksList} />
          <Route path="/products/:id" component={ProductForm} />
          <Route path="/add-product" component={ProductForm} />
          <Route path="/" exact>
            <h2>Welcome Dagger!</h2>
          </Route>
        </Switch>
      </div>
    </Router>
  );
};

export default App;
