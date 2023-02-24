/* eslint-disable no-unused-vars */
import { useState, useCallback } from 'react';
import './SignUp.css';
import axios from 'axios';

function signUp() {
  // eslint-disable-next-line no-unused-vars
  const [Name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [emailMessage, setEmailMessage] = useState('');
  const [isemail, setIsemail] = useState(false);
  const [password, setPassword] = useState('');
  const [passwordMessage, setPasswordMessage] = useState('');
  const [isPassword, setIsPassword] = useState(true);

  const API_URL = 'https://f6a2-125-247-122-218.jp.ngrok.io/users';

  // axios.defaults.withCredentials = true;

  const submit = async () => {
    await axios
      .post(API_URL, {
        name: Name,
        email: email,
        password: password,
      })
      .then((res) => {
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
  };

  const onNameHandler = (event) => {
    setName(event.currentTarget.value);
  };

  const onChangeEmail = useCallback((e) => {
    const emailRegex =
      /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    const emailCurrent = e.target.value;
    setEmail(emailCurrent);

    if (!emailRegex.test(emailCurrent) && emailCurrent.length > 5) {
      setEmailMessage(`${e.target.value} is not a valid email address.`);
      setIsemail(true);
    } else {
      setEmailMessage('');
      setIsemail(false);
    }
  }, []);

  const onChangePassword = useCallback((e) => {
    const passwordRegex = /^(?=.*[0-9]).{8,25}$/;
    const passwordCurrent = e.target.value;
    setPassword(passwordCurrent);

    if (!passwordRegex.test(passwordCurrent) && passwordCurrent.length > 1) {
      setPasswordMessage('Please combine special characters and numbers.');
      setIsPassword(false);
    } else if (passwordCurrent.length > 0) {
      setPasswordMessage('this password is available.');
      setIsPassword(true);
    }
  }, []);

  return (
    <div className="body">
      <div className="containerFlex">
        <div className="leftEx">
          <h1>Join the Stack Overflow community</h1>
          <div className="leftFlex">
            <div className="flexFc">
              <svg width="26" height="26" className="svgIcon">
                <path
                  opacity=".5"
                  d="M4.2 4H22a2 2 0 012 2v11.8a3 3 0 002-2.8V5a3 3 0 00-3-3H7a3 3 0 00-2.8 2z"
                ></path>
                <path d="M1 7c0-1.1.9-2 2-2h18a2 2 0 012 2v12a2 2 0 01-2 2h-2v5l-5-5H3a2 2 0 01-2-2V7zm10.6 11.3c.7 0 1.2-.5 1.2-1.2s-.5-1.2-1.2-1.2c-.6 0-1.2.4-1.2 1.2 0 .7.5 1.1 1.2 1.2zm2.2-5.4l1-.9c.3-.4.4-.9.4-1.4 0-1-.3-1.7-1-2.2-.6-.5-1.4-.7-2.4-.7-.8 0-1.4.2-2 .5-.7.5-1 1.4-1 2.8h1.9v-.1c0-.4 0-.7.2-1 .2-.4.5-.6 1-.6s.8.1 1 .4a1.3 1.3 0 010 1.8l-.4.3-1.4 1.3c-.3.4-.4 1-.4 1.6 0 0 0 .2.2.2h1.5c.2 0 .2-.1.2-.2l.1-.7.5-.7.6-.4z"></path>
              </svg>
            </div>
            <div className="flexItem01">Get unstuck — ask a question</div>
          </div>
          <div className="leftFlex">
            <div className="flexFc">
              <svg width="26" height="26" className="svgIcon">
                <path d="M12 .7a2 2 0 013 0l8.5 9.6a1 1 0 01-.7 1.7H4.2a1 1 0 01-.7-1.7L12 .7z"></path>
                <path
                  opacity=".5"
                  d="M20.6 16H6.4l7.1 8 7-8zM15 25.3a2 2 0 01-3 0l-8.5-9.6a1 1 0 01.7-1.7h18.6a1 1 0 01.7 1.7L15 25.3z"
                ></path>
              </svg>
            </div>
            <div className="flexItem01">
              Unlock new privileges like voting and commenting
            </div>
          </div>
          <div className="leftFlex">
            <div className="flexFc">
              <svg width="26" height="26" className="svgIcon">
                <path d="M14.8 3a2 2 0 00-1.4.6l-10 10a2 2 0 000 2.8l8.2 8.2c.8.8 2 .8 2.8 0l10-10c.4-.4.6-.9.6-1.4V5a2 2 0 00-2-2h-8.2zm5.2 7a2 2 0 110-4 2 2 0 010 4z"></path>
                <path
                  opacity=".5"
                  d="M13 0a2 2 0 00-1.4.6l-10 10a2 2 0 000 2.8c.1-.2.3-.6.6-.8l10-10a2 2 0 011.4-.6h9.6a2 2 0 00-2-2H13z"
                ></path>
              </svg>
            </div>
            <div className="flexItem01">
              Save your favorite tags, filters, and jobs
            </div>
          </div>
          <div className="leftFlex">
            <div className="flexFc">
              <svg width="26" height="26" className="svgIcon">
                <path d="M21 4V2H5v2H1v5c0 2 2 4 4 4v1c0 2.5 3 4 7 4v3H7s-1.2 2.3-1.2 3h14.4c0-.6-1.2-3-1.2-3h-5v-3c4 0 7-1.5 7-4v-1c2 0 4-2 4-4V4h-4zM5 11c-1 0-2-1-2-2V6h2v5zm11.5 2.7l-3.5-2-3.5 1.9L11 9.8 7.2 7.5h4.4L13 3.8l1.4 3.7h4L15.3 10l1.4 3.7h-.1zM23 9c0 1-1 2-2 2V6h2v3z"></path>
              </svg>
            </div>
            <div className="flexItem01">Earn reputation and badges</div>
          </div>

          <div className="light">
            <p>
              Collaborate and share knowledge with a private group for FREE.
            </p>
            <a
              href="https://stackoverflow.com/teams?utm_source=so-owned&amp;utm_medium=product&amp;utm_campaign=free-50&amp;utm_content=public-sign-up"
              target="_blank"
              rel="noreferrer"
            >
              Get Stack Overflow for Teams free for up to 50 users
            </a>
          </div>
        </div>
        <div className="signBody">
          <div id="formContainer" className="loginContainer">
            <form
              id="login-form"
              className="loginForm"
              // onSubmit=
              // action="https://67d1-125-247-122-218.jp.ngrok.io/users"
              // method="POST"
            >
              <input
                type="hidden"
                name="fkey"
                defaultValue="e0564dc8a6877b58040cd016376500ff43dc58916b6c5550550771d9dd7ac649"
              />
              <input type="hidden" name="ssrc" defaultValue="head" />
              <input type="hidden" name="legalLinksShown" defaultValue={1} />
              <div className="authItem">
                <label className="flexItemLabel" htmlFor="display-name">
                  Display name
                </label>
                <div className="flexRelative">
                  <input
                    className="flex--item si-input"
                    type="text"
                    onChange={onNameHandler}
                    name="display-name"
                    id="display-name"
                    data-is-teams="false"
                  />
                </div>
                <p className="flex--item si-input-message js-error-message d-none"></p>
              </div>
              <div className="authItem">
                <label className="flexItemLabel" htmlFor="email">
                  Email
                </label>
                <div className="flexRelative">
                  <input
                    className="si-input"
                    id="email"
                    type="email"
                    onChange={onChangeEmail}
                    size={30}
                    maxLength={100}
                    name="email"
                  />

                  <svg
                    aria-hidden="true"
                    className={
                      isemail
                        ? 'si-input-icon js-alert-icon d-none svg-icon iconAlertCircle'
                        : 'nullIcon'
                    }
                    width={18}
                    height={18}
                    viewBox="0 0 18 18"
                  >
                    <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z" />
                  </svg>
                </div>
                <p className="inputMessage">{emailMessage}</p>
              </div>
              <label className="flexItemLabel" htmlFor="password">
                Password
              </label>
              <div className="authItem">
                <p className="flex--item si-input-message js-error-message d-none"></p>

                <div className="flexRelative">
                  <input
                    className="flex--item si-input"
                    type="password"
                    autoComplete="off"
                    onChange={onChangePassword}
                    name="password"
                    id="password"
                  />
                  <svg
                    aria-hidden="true"
                    className={
                      isPassword
                        ? 'nullIcon'
                        : 's-input-icon js-alert-icon d-none svg-icon iconAlertCircle'
                    }
                    width={18}
                    height={18}
                    viewBox="0 0 18 18"
                  >
                    <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z" />
                  </svg>
                </div>
                <p className="fs-caption fc-light mt4 mb4">{passwordMessage}</p>
                <div className="d-flex ai-center ps-relative jc-space-between"></div>
              </div>
              <div className="d-flex flex__center bg-black-050 ba bc-black-075 bar-sm pt8 pb2">
                {/* <div id="no-captcha-here">
                  <div style={{ width: '164px', height: '144px' }}>
                    <textarea
                      id="g-recaptcha-response"
                      name="g-recaptcha-response"
                      className="g-recaptcha-response"
                      style={{
                        width: '250px',
                        height: '40px',
                        border: '1px solid rgb(193, 193, 193)',
                        margin: '10px 25px',
                        padding: '0px',
                        resize: 'none',
                        display: 'none',
                      }}
                      defaultValue={''}
                    />
                  </div>
                </div>
                <script></script> */}
                <div className="js-auth-item">
                  <div className="js-catpcha-error-container">
                    <p className="s-input-message m0 p0 js-error-message" />
                  </div>
                </div>
              </div>
              <div className="signUpflexItem">
                <div className="d-flex">
                  <div className="flex--item mr4">
                    <input
                      type="checkbox"
                      name="EmailOptIn"
                      id="opt-in"
                      className="s-checkbox"
                      data-ga-action="Email Opt-In"
                      data-ga-is-pii="false"
                    />
                  </div>
                  <div className="flex--item pt2">
                    <label
                      htmlFor="opt-in"
                      className="s-label fw-normal fs-caption px0"
                    >
                      Opt-in to receive occasional product updates, user
                      research invitations, company announcements, and digests.
                    </label>
                  </div>
                  <div className="flex--item ml4 mt2">
                    <svg
                      aria-hidden="true"
                      className="svg-icon iconHelpSm"
                      width={14}
                      height={14}
                      viewBox="0 0 14 14"
                    >
                      <path d="M7 1C3.74 1 1 3.77 1 7c0 3.26 2.77 6 6 6 3.27 0 6-2.73 6-6s-2.73-6-6-6Zm1.06 9.06c-.02.63-.48 1.02-1.1 1-.57-.02-1.03-.43-1.01-1.06.02-.63.5-1.04 1.08-1.02.6.02 1.05.45 1.03 1.08Zm.73-3.07-.47.3c-.2.15-.36.36-.44.6a3.6 3.6 0 0 0-.08.65c0 .04-.03.14-.16.14h-1.4c-.14 0-.16-.09-.16-.13-.01-.5.11-.99.36-1.42A4.6 4.6 0 0 1 7.7 6.07c.15-.1.21-.21.3-.33.18-.2.28-.47.28-.74.01-.67-.53-1.14-1.18-1.14-.9 0-1.18.7-1.18 1.46H4.2c0-1.17.31-1.92.98-2.36a3.5 3.5 0 0 1 1.83-.44c.88 0 1.58.16 2.2.62.58.42.88 1.02.88 1.82 0 .5-.17.9-.43 1.24-.15.2-.44.47-.86.79h-.01Z" />
                    </svg>

                    <div
                      className="s-popover ws2"
                      id="opt-in-learn-more"
                      role="menu"
                      aria-hidden="true"
                    ></div>
                  </div>
                </div>
              </div>
              <div className="d-flex gs4 gsy fd-column js-auth-item ">
                <button
                  className="signUpBtn"
                  id="submit-button"
                  name="submit-button"
                  onClick={submit}
                >
                  Sign up
                </button>
                <p className="flex--item s-input-message js-error-message d-none"></p>
              </div>
              <input type="hidden" id="oauth_version" name="oauth_version" />
              <input type="hidden" id="oauth_server" name="oauth_server" />
            </form>
            <div className="js-terms fs-caption fc-light ta-left mt32">
              By clicking “Sign up”, you agree to our{' '}
              <a
                href="https://stackoverflow.com/legal/terms-of-service/public"
                name="tos"
                target="_blank"
                className="-link"
                rel="noreferrer"
              >
                terms of service
              </a>
              ,{' '}
              <a
                href="https://stackoverflow.com/legal/privacy-policy"
                name="privacy"
                target="_blank"
                className="-link"
                rel="noreferrer"
              >
                privacy policy
              </a>{' '}
              and{' '}
              <a
                href="https://stackoverflow.com/legal/cookie-policy"
                name="cookie"
                target="_blank"
                className="-link"
                rel="noreferrer"
              >
                cookie policy
              </a>
              <input type="hidden" name="legalLinksShown" defaultValue={1} />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default signUp;
