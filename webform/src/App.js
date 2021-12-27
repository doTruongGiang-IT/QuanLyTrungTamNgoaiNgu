
import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import routes from './appRoutes';
import MenuComponent from './components/Menu';

function renderRoutes(routes) {
  let result = '';
  if(routes.length > 0) {
    result = routes.map((route, index) => {
      return <Route key={index} path={route.path} exact={route.exact} element={route.main} />
    });
  }
  return result;
};

function App() {
  return (
    <Router>
      <div className="App">
        <MenuComponent />
        <Routes>
          {renderRoutes(routes)}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
