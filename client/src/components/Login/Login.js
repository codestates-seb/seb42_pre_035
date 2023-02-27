/* eslint-disable no-unused-vars */
import axios from 'axios';
import { useState, useCallback } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Login.css';

function Login() {
  const navigate = useNavigate();

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const [emailMessage, setEmailMessage] = useState('');
  const [passwordMessage, setPasswordMessage] = useState('');

  const [isEmail, setIsEmail] = useState(true);
  const [isPassword, setIsPassword] = useState(false);

  // // 이메일
  const onChangeEmail = useCallback((e) => {
    const emailRegex =
      /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    const emailCurrent = e.target.value;
    setEmail(emailCurrent);

    if (!emailRegex.test(emailCurrent) && emailCurrent.length > 8) {
      setEmailMessage('The email is not a valid email address.');
      setIsEmail(false);
    } else {
      setEmailMessage('');
      setIsEmail(true);
    }
  }, []);

  const API_URL = 'https://a973-125-247-122-218.jp.ngrok.io/users/login';

  const passwordhandler = (e) => {
    const passwordCurrent = e.target.value;
    setPassword(passwordCurrent);
    console.log(password);
  };

  const loginHandler = () => {
    axios.defaults.withCredentials = true;
    console.log('The link was clicked.');

    const headers = {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json',
    };

    // if (!email || !password) {
    //   setEmail('');
    //   setPassword('');
    //   // setErrorMessage("Email or password cannot be empty.");
    //   return;
    // } else {
    //   // setErrorMessage('');
    // }

    return axios
      .post(API_URL, { email: email, password: password }, { headers })
      .then((response) => {
        navigate('/');
        console.log(response);
        const accessToken = response.headers.get('Authorization').split(' ')[1];
        sessionStorage.setItem('accesstoken', accessToken);
        sessionStorage.setItem(
          'userInfoStorage',
          JSON.stringify(response.data.data)
        );
        // setIsLogin(true);
      })
      .catch((err) => {
        // if (err.response.status === 401) {
        //   console.log(err.response.data);
      });
  };

  return (
    <form>
      <div className="login">
        <div className="stofbtn">
          <svg
            aria-hidden="true"
            className="native svg-icon iconLogoGlyphMd"
            width="32"
            height="37"
            viewBox="0 0 32 37"
          >
            …<path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
            <path
              d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
              fill="#F48024"
            ></path>
          </svg>
        </div>
        <div className="content">
          <div className="loginbox">
            <div className="loginemail">
              <p>Email</p>
              <input
                className="s-input"
                id="email"
                type="email"
                size="30"
                maxLength="100"
                name="email"
                onChange={onChangeEmail}
              ></input>
              <svg
                aria-hidden="true"
                className={
                  isEmail
                    ? 'nullicon'
                    : 's-input-icon js-alert-icon svg-icon iconAlertCircle'
                }
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
              </svg>
              <div className="emlerr">{emailMessage}</div>
            </div>
            <div className="emailerr"></div>
            <div className="loginpwd">
              <p className="ps">password</p>
              <p className="forgot">Forgot password?</p>
            </div>
            <input
              className="password"
              type="password"
              minLength="8"
              maxLength="20"
              required
              autoComplete="off"
              name="password"
              id="password"
              onChange={passwordhandler}
            ></input>
            {/* <svg
              aria-hidden="true"
              className="s-input-icon js-alert-icon svg-icon iconAlertCircle"
              width="18"
              height="18"
              viewBox="0 0 18 18"
            >
              <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
            </svg> */}
            <div className="loginbtn">
              <button
                className="submit-button"
                id="submit-button"
                name="submit-button"
                type="button"
                value="Log in"
                onClick={loginHandler}
              >
                Log in
              </button>
            </div>
          </div>
        </div>
        <div className="text">
          <div className="signupsup">
            <p>Don’t have an account?</p>
            <Link to="/signup">
              <p className="sup">Sign up</p>
            </Link>
          </div>
          <div className="signupsup2">
            <p>Are you an employer? </p>
            <div className="signupbt">
              <p>Sign up on Talent </p>
              <svg
                aria-hidden="true"
                className="butt"
                width="14"
                height="14"
                viewBox="0 0 14 14"
              >
                <path d="M5 1H3a2 2 0 0 0-2 2v8c0 1.1.9 2 2 2h8a2 2 0 0 0 2-2V9h-2v2H3V3h2V1Zm2 0h6v6h-2V4.5L6.5 9 5 7.5 9.5 3H7V1Z"></path>
              </svg>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
}

export default Login;
