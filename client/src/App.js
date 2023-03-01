import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Signup from './pages/Signup';
import Login from './components/Login/Login';
import './css/App.css';
import Home from './pages/Home';
import SearchPage from './pages/SearchPage';
import Question from './pages/Question';
import Detail from './pages/Detail';
import { authActions } from './Redux/auth';
import { Cookies } from 'react-cookie';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';
function App() {
  const dispatch = useDispatch();

  const cookies = new Cookies();
  useEffect(() => {
    const Refresh = cookies.get('Refresh');
    if (Refresh) {
      dispatch(authActions.login());
    } else {
      dispatch(authActions.logout());
    }
  }, []);
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
