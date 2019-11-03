import React, { Suspense, lazy } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';

const ParentComponent = lazy(() => import('./ParentComponent/ParentComponent'));
const BackendData = lazy(() => import('./BackendData/BackendData'));

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
        <Route exact path="/parent" component={ParentComponent}/>
        <Route path="/backend" component={BackendData}/>
      </Switch>
    </Suspense>
  </Router>
  );
}


export default App;

