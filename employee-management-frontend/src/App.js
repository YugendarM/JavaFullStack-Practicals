import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router,Routes,Route,Link } from 'react-router-dom';
import EmployeeDeletion from './components/EmployeeDeletionComponent/EmployeeDeletion';
import EmployeeDirectory from './components/EmployeeDirectoryComponent/EmployeeDirectory';
import EmployeeRegistration from './components/EmployeeRegistrationComponent/EmployeeRegistration';

function App() {
  return (
    <div className="App">
      <Router>
        <header>
          <h1 className='header'>Employee Management Application</h1>
        </header>

        <nav className='nav__container'>
          <Link className='nav__item' to={"/"}>Employee Directory</Link>
          <Link className='nav__item' to={"/admin/add"}>Employee Registration</Link>
          <Link className='nav__item' to={"/admin/delete"}>Employee Deletion</Link>
        </nav>

        <Routes>
          <Route exact path='/' Component={EmployeeDirectory}></Route>
          <Route exact path='/admin/add' Component={EmployeeRegistration}></Route>
          <Route exact path='/admin/delete' Component={EmployeeDeletion}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
