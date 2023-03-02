/* eslint-disable no-unused-vars */
/* eslint-disable no-unused-vars */
import './Header.css';
import { useState, useRef, useEffect, useCallback } from 'react';
import InputBox from './InputBox';
import UserMenu from '../UserMenu';
import { Link, useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux';

function Header() {
  // const useStore = create(() => ({
  //   searchText: isText,
  // }));
  const isAuth = useSelector((state) => state.auth.isAuthenticated);
  const [open, setOpen] = useState(false);
  const [isOpen, setIsOpen] = useState(false);
  const [isText, setIsText] = useState('');
  const searchRef = useRef(null);
  const userRef = useRef(null);
  // const { searchText } = useStore();

  const navigate = useNavigate();

  const onChange = useCallback((e) => {
    const Current = e.target.value;
    setIsText(Current);
  }, []);

  useEffect(() => {
    function handleOutside(e) {
      if (searchRef.current && !searchRef.current.contains(e.target)) {
        setOpen(false);
      }
    }
    document.addEventListener('mousedown', handleOutside);
    return () => {
      document.removeEventListener('mousedown', handleOutside);
    };
  }, [searchRef]);

  useEffect(() => {
    function handleOutside(e) {
      if (userRef.current && !userRef.current.contains(e.target)) {
        setIsOpen(false);
      }
    }
    document.addEventListener('mousedown', handleOutside);
    return () => {
      document.removeEventListener('mousedown', handleOutside);
    };
  }, [userRef]);

  const click = () => {
    setOpen(true);
  };
  const click2 = () => {
    setIsOpen(!isOpen);
  };
  const handleOnKeyPress = (e) => {
    if (e.key === 'Enter') {
      navigate(`/search?q=${isText}`); // Enter 입력이 되면 클릭 이벤트 실행
      window.location.reload();
    }
  };

  return (
    <header className="header">
      <div className="headerContainer">
        <div className="headerLeft">
          <Link to="/">
            <div className="headerLogo">
              <img
                src="https://t1.daumcdn.net/cfile/tistory/9933A13359EAC02836"
                alt="logo"
              />
            </div>
          </Link>
        </div>
        <h3>Products</h3>
        <div ref={searchRef} className="headerMiddle">
          <div className="headerSearchContainer">
            <svg
              aria-hidden="true"
              className="iconSearch"
              width="18"
              height="18"
              viewBox="0 0 18 18"
            >
              <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
            </svg>
            <input
              onClick={click}
              onChange={onChange}
              type="text"
              placeholder="Search..."
              onKeyPress={handleOnKeyPress}
            />
          </div>
          {open ? <InputBox /> : null}
        </div>
        <div className="headerRight">
          {isAuth ? (
            <div className="headerRightContainer">
              <div className="headerRightIconUser">
                <img
                  src="https://www.gravatar.com/avatar/1d6089a9bd3ab137764e21e41ca771aa?s=48&amp;d=identicon&amp;r=PG"
                  alt="user avatar"
                  width="24"
                  height="24"
                  className="bar-sm s-avatar--image js-avatar-me"
                />
              </div>
              <div className="headerRightIcon">
                <svg
                  aria-hidden="true"
                  className="svg-icon iconInbox"
                  width="20"
                  height="18"
                  viewBox="0 0 20 18"
                >
                  <path d="M4.63 1h10.56a2 2 0 0 1 1.94 1.35L20 10.79V15a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-4.21l2.78-8.44c.25-.8 1-1.36 1.85-1.35Zm8.28 12 2-2h2.95l-2.44-7.32a1 1 0 0 0-.95-.68H5.35a1 1 0 0 0-.95.68L1.96 11h2.95l2 2h6Z"></path>
                </svg>
              </div>
              <div className="headerRightIcon">
                <svg
                  aria-hidden="true"
                  className="svg-icon iconAchievements"
                  width="18"
                  height="18"
                  viewBox="0 0 18 18"
                >
                  <path d="M15 2V1H3v1H0v4c0 1.6 1.4 3 3 3v1c.4 1.5 3 2.6 5 3v2H5s-1 1.5-1 2h10c0-.4-1-2-1-2h-3v-2c2-.4 4.6-1.5 5-3V9c1.6-.2 3-1.4 3-3V2h-3ZM3 7c-.5 0-1-.5-1-1V4h1v3Zm8.4 2.5L9 8 6.6 9.4l1-2.7L5 5h3l1-2.7L10 5h2.8l-2.3 1.8 1 2.7h-.1ZM16 6c0 .5-.5 1-1 1V4h1v2Z"></path>
                </svg>
              </div>
              <div className="headerRightIcon">
                <svg
                  aria-hidden="true"
                  className="svg-icon iconHelp"
                  width="18"
                  height="18"
                  viewBox="0 0 18 18"
                >
                  <path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8Zm.81 12.13c-.02.71-.55 1.15-1.24 1.13-.66-.02-1.17-.49-1.15-1.2.02-.72.56-1.18 1.22-1.16.7.03 1.2.51 1.17 1.23ZM11.77 8c-.59.66-1.78 1.09-2.05 1.97a4 4 0 0 0-.09.75c0 .05-.03.16-.18.16H7.88c-.16 0-.18-.1-.18-.15.06-1.35.66-2.2 1.83-2.88.39-.29.7-.75.7-1.24.01-1.24-1.64-1.82-2.35-.72-.21.33-.18.73-.18 1.1H5.75c0-1.97 1.03-3.26 3.03-3.26 1.75 0 3.47.87 3.47 2.83 0 .57-.2 1.05-.48 1.44Z"></path>
                </svg>
              </div>
              <div
                ref={userRef}
                onClick={click2}
                role="presentation"
                className="userMenuContainer"
              >
                <div className="headerRightIcon">
                  <svg
                    aria-hidden="true"
                    className="svg-icon iconStackExchange"
                    width="18"
                    height="18"
                    viewBox="0 0 18 18"
                  >
                    <path d="M15 1H3a2 2 0 0 0-2 2v2h16V3a2 2 0 0 0-2-2ZM1 13c0 1.1.9 2 2 2h8v3l3-3h1a2 2 0 0 0 2-2v-2H1v2Zm16-7H1v4h16V6Z"></path>
                  </svg>
                </div>
                {isOpen ? <UserMenu /> : null}
              </div>
            </div>
          ) : (
            <div className="userLogin">
              <Link to="/login">
                <button className="loginBtn">Log in</button>
              </Link>
              <Link to="/signup">
                <button className="signupBtn">Sign up</button>
              </Link>
            </div>
          )}
        </div>
      </div>
    </header>
  );
}
export default Header;
