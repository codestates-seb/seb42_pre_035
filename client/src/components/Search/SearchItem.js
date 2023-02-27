import '../post/post.css';

const Searchitem = ({ search }) => {
  return (
    <div className="Post">
      <div className="leftcon">
        <div className="votes">
          <span className="votesNum">0</span>
          <span className="votesUnit">votes</span>
        </div>
        <div className="answer">
          <span className="answerNum">{search.answers.length}</span>
          <span className="answerUnit">answer</span>
        </div>
        <div className="views">
          <span className="viewsNum">{search.viewCount}</span>
          <span className="viewsUnit">views</span>
        </div>
      </div>
      <div className="postwidth">
        <h3 className="postname">
          <a href={`/questions/${search.questionId}`} className="postnames">
            <div
              dangerouslySetInnerHTML={{
                __html: search.title,
              }}
            ></div>
          </a>
        </h3>
        <div className="rightcon">
          <div className="s-post-summary--meta-tags tags js-tags t-python t-selenium-webdriver">
            <ul className="tagssss">
              <li className="d-inline mr4 js-post-tag-list-item">
                <a
                  href="/questions/tagged/python"
                  className="tagsoneee"
                  title="show questions tagged 'python'"
                  aria-label="show questions tagged 'python'"
                  rel="tag"
                  aria-labelledby="python-container"
                >
                  python
                </a>
              </li>
              <li className="d-inline mr4 js-post-tag-list-item">
                <a
                  href="/questions/tagged/selenium-webdriver"
                  className="tagstwoooo"
                  title="show questions tagged 'selenium-webdriver'"
                  aria-label="show questions tagged 'selenium-webdriver'"
                  rel="tag"
                  aria-labelledby="selenium-webdriver-container"
                >
                  selenium-webdriver
                </a>
              </li>
            </ul>
          </div>
          <div className="rightconnnn">
            <div className="s-user-card--info">
              <div className="rightconitem">
                <a
                  href="/users/5112650/jega"
                  className="rightconitemmm"
                  // key={users}
                >
                  {/* {' '}
                  asdasd */}
                  {/* asdasdasd */}
                  {/* {users.name} */}
                </a>
              </div>
            </div>
            <time className="timecon">
              {/* {elapsedTime} */}
              <a
                href="/questions/75552845/upgrading-groovy-from-2-4-to-3-0-why-intellij-complains-about-could-not-resolv"
                className="s-link s-link__muted"
              >
                asked
                <span title="2023-02-24 05:16:13Z" className="relativetime">
                  26 secs ago
                </span>
              </a>
            </time>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Searchitem;
