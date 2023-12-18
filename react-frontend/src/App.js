import './App.css';

import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import AddEmployeeComponent from './components/AddEmployeeComponent';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { ListEmployeeComponent } from './components/ListEmployeeComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent/>
        <div className= "container">
          <Routes>
              <Route exact path = "/" element = {<ListEmployeeComponent/>}/>
              <Route path = "/employees" element = {<ListEmployeeComponent/>}/>
              <Route path = "/add-employee" element = {<AddEmployeeComponent/>} />
              <Route path = "/edit-employee/:id" element = {<AddEmployeeComponent/>} />
          </Routes>
        </div>
        <FooterComponent />
      </Router>
  </div>
  );
}

export default App;
