import React, { Suspense, lazy } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';

const FirstRoute = lazy(() => import('./FirstRoute/FirstRoute'));
const SecondRoute = lazy(() => import('./SecondRoute/SecondRoute'));

function App() {
  return (
    <Router>
      <li>
      <Link to='/parent'>First route</Link>
      </li>
      <li>
      <Link to='/backend'>Second route</Link>
      </li>
    <Suspense fallback={<div>Loading...</div>}>
      <Switch>
        <Route exact path="/parent" component={FirstRoute}/>
        <Route path="/backend" component={SecondRoute}/>
      </Switch>
    </Suspense>
  </Router>
  );
}


export default App;

