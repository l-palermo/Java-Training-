import React, { Suspense, lazy } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';

const FirstRoute = lazy(() => import('./FirstRoute/FirstRoute'));
const SecondRoute = lazy(() => import('./SecondRoute/SecondRoute'));
const UserSignUp = lazy(() => import('./UserSignUp/UserSignUp'));

function App() {
  return (
    <Router>
      <li>
      <Link to='/firstRoute'>First route</Link>
      </li>
      <li>
      <Link to='/secondRoute'>Second route</Link>
      </li>
      <li>
      <Link to='/userSignUp'>User sign up</Link>
      </li>
    <Suspense fallback={<div>Loading...</div>}>
      <Switch>
        <Route exact path="/fisrtRoute" component={FirstRoute}/>
        <Route path="/secondRoute" component={SecondRoute}/>
        <Route path="/userSignUp" component={UserSignUp}/>
      </Switch>
    </Suspense>
  </Router>
  );
}


export default App;

