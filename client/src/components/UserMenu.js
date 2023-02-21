import './UserMenu.css';
function UserMenu() {
  return (
    <div>
      <div className="menuContainer">
        <div className="menuHead">
          <h3>CURRENT COMMUNITY</h3>
        </div>

        <ul className="menuBody ">
          <li className="firstLine">
            <span className="fl1">Stack Overflow</span>
            <div className="links">
              <a href="https://stackoverflow.com/help">help</a>
              <a href="https://chat.stackoverflow.com/?tab=site&amp;host=stackoverflow.com">
                chat
              </a>
              <a href="https://stackoverflow.com/users/logout">log out</a>
            </div>
          </li>
          <li className="related-site d-flex">
            <div className="L-shaped-icon-container">
              <span className="L-shaped-icon"></span>
            </div>
          </li>
        </ul>
      </div>
    </div>
  );
}
export default UserMenu;
