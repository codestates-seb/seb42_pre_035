import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Signup from './pages/Signup';
import Login from './components/Login/Login';
import './css/App.css';
import Home from './pages/Home';
import SearchPage from './pages/SearchPage';
import Question from './pages/Question';
function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/question" element={<Question />}></Route>
          <Route path="/serch" element={<SearchPage />}></Route>
          <Route path="/singup" element={<Signup />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}
export default App;
