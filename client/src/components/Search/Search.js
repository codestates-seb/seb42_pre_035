import './Search.css';
import ResultContainer from './ResultContainer';

function Search() {
  return (
    <div id="content">
      <div className="mainBar">
        <div className="barTop">
          <div className="d-flex mb24 jc-space-between fw-wrap ai-start">
            <h1 className="title">Search Results </h1>
            <div className="d-flex ai-center fl1 jc-end ml32">
              <div className="flex--item mr8">
                <p className="js-advanced-tips-toggle">Advanced Search Tips</p>
              </div>
              <div className="ml12 aside-cta flex--item print:d-none">
                <a href="/questions" className="askQuestionBtn">
                  Ask Question
                </a>
              </div>
            </div>
          </div>
          <div className="resultBar">
            <div className="result">0 results</div>

            <div className="flex--item">
              <div className=" d-flex s-btn-group js-filter-btn">
                <a
                  className="resultBtn hoverBtn flex--item"
                  href="/search?tab=relevance&amp;q=dlsnditi&amp;searchOn=3"
                  data-nav-xhref=""
                  title="Search results with best match to search terms"
                  data-value="relevance"
                  data-shortcut=""
                  aria-current="page"
                >
                  Relevance
                </a>
                <a
                  className="resultBtn2 hoverBtn flex--item"
                  href="/search?tab=newest&amp;q=dlsnditi&amp;searchOn=3"
                  data-nav-xhref=""
                  title="Newest search results"
                  data-value="newest"
                  data-shortcut=""
                >
                  Newest
                </a>
              </div>
            </div>
          </div>
        </div>
        <ResultContainer />
      </div>
    </div>
  );
}
export default Search;