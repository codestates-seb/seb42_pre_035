import './main.css';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
import Postlist from '../post/Postlist';

function Main() {
  const isAuth = useSelector((state) => state.auth.isAuthenticated);
  return (
    <div id="content">
      <div className="mainBar">
        <div className="barTop">
          <div className="d-flex mb24 jc-space-between fw-wrap ai-start">
            <h1 className="title">Top Questions </h1>
            <div className="d-flex ai-center fl1 jc-end ml32">
              <div className="flex--item mr8">
                <p className="js-advanced-tips-toggle">Advanced Search Tips</p>
              </div>
              <div className="ml12 aside-cta flex--item print:d-none">
                <Link
                  to={isAuth ? 'questions' : 'login'}
                  className="askQuestionBtn"
                >
                  Ask Question
                </Link>
              </div>
            </div>
          </div>
          <div className="resultBar">
            <div className="result">0 results</div>

            <div className="flex--item">
              <div className=" d-flex s-btn-group js-filter-btn">
                <span className="resultBtn hoverBtn flex--item">Relevance</span>
                <span className="resultBtn2 hoverBtn flex--item">Newest</span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Postlist />
    </div>
  );
}
export default Main;
