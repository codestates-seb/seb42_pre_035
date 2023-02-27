import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Signup from './pages/Signup';
import Login from './components/Login/Login';
import './css/App.css';
import Home from './pages/Home';
import SearchPage from './pages/SearchPage';
import Question from './pages/Question';
import Detail from './pages/Detail';
function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/questions" element={<Question />}></Route>
          <Route path="/search" element={<SearchPage />}></Route>
          <Route path="/signup" element={<Signup />}></Route>
          <Route path="/questions/:id" element={<Detail />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}
export default App;
