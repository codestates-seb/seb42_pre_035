import RightNav from '../RightNav/RightNav';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';
import './Questions.css';
function Question() {
  return (
    <div>
      <div className="container_Q">
        <div className="flexItem-Q01">
          <div className="question-header">
            <h1 itemProp="name" className="headline_Q">
              여기에 질문을 가져옵니다.
            </h1>
            <div className="side">
              <button className="questionBtn">Ask Question</button>
            </div>
          </div>
          <div className="flexSecond">
            <div className="flexItem_line" title="2023-02-24 04:30:20Z">
              <span className="lineSpan">Asked</span>
              <time itemProp="dateCreated" dateTime="2023-02-24T04:30:20">
                today
              </time>
            </div>
            <div className="flexItem_line">
              <span className="lineSpan">Modified</span>
              <a
                href="?lastactivity"
                className="s-link s-link__inherit"
                title="2023-02-24 04:30:20Z"
              >
                today
              </a>
            </div>
            <div className="flexItem_line" title="Viewed 2 times">
              <span className="lineSpan">Viewed</span>2 times
            </div>
          </div>
        </div>
        <div className="flexItem-Q02">
          <div className="itemLeft">
            <div className="questionJs">
              <div className="postLayout">
                <div className="postLayoutL">
                  <div className="voteContainer" data-post-id="75552654">
                    <button
                      className="voteUpbtn"
                      data-controller="s-tooltip"
                      data-s-tooltip-placement="right"
                      aria-pressed="false"
                      aria-label="Up vote"
                      data-selected-classes="fc-theme-primary"
                      data-unselected-classes=""
                      aria-describedby="--stacks-s-tooltip-92xb60y1"
                    >
                      <svg
                        aria-hidden="true"
                        className="svg-icon iconArrowUpLg"
                        width="36"
                        height="36"
                        viewBox="0 0 36 36"
                      >
                        <path d="M2 25h32L18 9 2 25Z"></path>
                      </svg>
                    </button>
                    <div
                      id="--stacks-s-tooltip-92xb60y1"
                      className="s-popover s-popover__tooltip"
                      role="tooltip"
                    >
                      <div className="s-popover--arrow"></div>
                    </div>
                    <div
                      className="js-vote-count flex--item d-flex fd-column ai-center fc-black-500 fs-title"
                      itemProp="upvoteCount"
                      data-value="0"
                    >
                      0
                    </div>
                    <button
                      className="voteDownbtn"
                      data-controller="s-tooltip"
                      data-s-tooltip-placement="right"
                      aria-pressed="false"
                      aria-label="Down vote"
                      data-selected-classes="fc-theme-primary"
                      data-unselected-classes=""
                      aria-describedby="--stacks-s-tooltip-a10gfyjf"
                    >
                      <svg
                        aria-hidden="true"
                        className="svg-icon iconArrowDownLg"
                        width="36"
                        height="36"
                        viewBox="0 0 36 36"
                      >
                        <path d="M2 11h32L18 27 2 11Z"></path>
                      </svg>
                    </button>
                    <div
                      id="--stacks-s-tooltip-a10gfyjf"
                      className="s-popover s-popover__tooltip"
                      role="tooltip"
                    >
                      <div className="s-popover--arrow"></div>
                    </div>

                    <button
                      className="savesBtn"
                      id="saves-btn-75552654"
                      data-controller="s-tooltip"
                      data-s-tooltip-placement="right"
                      data-s-popover-placement=""
                      aria-pressed="false"
                      data-post-id="75552654"
                      data-post-type-id="1"
                      data-user-privilege-for-post-click="-1"
                      aria-controls=""
                      data-s-popover-auto-show="false"
                      aria-describedby="--stacks-s-tooltip-zm5y68e1"
                    >
                      <svg
                        aria-hidden="true"
                        className="fc-theme-primary-500 js-saves-btn-selected d-none svg-icon iconBookmark"
                        width="18"
                        height="18"
                        viewBox="0 0 18 18"
                      >
                        <path d="M3 17V3c0-1.1.9-2 2-2h8a2 2 0 0 1 2 2v14l-6-4-6 4Z"></path>
                      </svg>
                    </button>
                    <div
                      id="--stacks-s-tooltip-zm5y68e1"
                      className="s-popover s-popover__tooltip"
                      role="tooltip"
                    >
                      <div className="s-popover--arrow"></div>
                    </div>

                    <a
                      className="js-post-issue flex--item s-btn s-btn__unset c-pointer py6 mx-auto"
                      href="/posts/75552654/timeline"
                      data-shortcut="T"
                      data-ks-title="timeline"
                      data-controller="s-tooltip"
                      data-s-tooltip-placement="right"
                      aria-label="Timeline"
                      aria-describedby="--stacks-s-tooltip-2ln50fed"
                    >
                      <svg
                        aria-hidden="true"
                        className="iconHistory"
                        width="19"
                        height="18"
                        viewBox="0 0 19 18"
                      >
                        <path d="M3 9a8 8 0 1 1 3.73 6.77L8.2 14.3A6 6 0 1 0 5 9l3.01-.01-4 4-4-4h3L3 9Zm7-4h1.01L11 9.36l3.22 2.1-.6.93L10 10V5Z"></path>
                      </svg>
                    </a>
                    <div
                      id="--stacks-s-tooltip-2ln50fed"
                      className="s-popover s-popover__tooltip"
                      role="tooltip"
                    >
                      <div className="s-popover--arrow"></div>
                    </div>
                  </div>
                </div>
                <div className="postLayoutR">
                  <div className="postBody" itemProp="text">
                    <p>여기에 질문내용이 들어갑니다.</p>
                  </div>
                  <div className="postTag">
                    <div className="post-taglist">
                      <div className="relativeFw">
                        <ul className="postTaginline">
                          <li className="tag-list-item">
                            <a
                              href="/questions/tagged/r"
                              className="post-tag js-gps-track"
                              title="show questions tagged 'r'"
                              aria-label="show questions tagged 'r'"
                              rel="tag"
                              aria-labelledby="r-container"
                            >
                              태그
                            </a>
                          </li>
                          <li className="tag-list-item">
                            <a
                              href="/questions/tagged/extract"
                              className="post-tag js-gps-track"
                              title=""
                              aria-label="show questions tagged 'extract'"
                              rel="tag"
                              aria-labelledby="extract-container"
                            >
                              기능
                            </a>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                  <div className="postButtom">
                    <div className="flexItemBtn">
                      <button
                        type="button"
                        className="postEditBtn"
                        data-gps-track="post.click({ item: 6, priv: -1, post_type: 1 }); suggestededit.queue_full"
                        title="Revise and improve this post"
                        data-error-message='There are <a href="https://meta.stackexchange.com/questions/84362/whats-the-fixed-size-of-the-suggested-edit-queue">too many pending edits</a> on Stack Overflow. Please try again later.'
                      >
                        Edit
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="answers"></div>
            <div className="editorZone">
              <h1 className="bottom-notice">
                Know someone who can answer? Share a link to this question email
                , Twitter , or Facebook .
              </h1>
              <h2 className="yourAnswer">Your Answer</h2>
              <ReactQuill />
              <div className="form-submit clear-both d-flex gsx gs4">
                <button
                  id="submit-button"
                  className="questionBtn"
                  type="submit"
                  autoComplete="off"
                >
                  Post Your Answer{' '}
                </button>
              </div>
            </div>
          </div>
          <div className="itemRight">
            <RightNav />
          </div>
        </div>
      </div>
    </div>
  );
}
export default Question;
