import './post.css';

// const [users, setUsers] = useState([]);

// fetch('https://a973-125-247-122-218.jp.ngrok.io/post')
//   .then((response) => response.json())
//   .then((json) => console.log(json));

// fetch('https://a973-125-247-122-218.jp.ngrok.io/users');

// function elapsedTime(date) {
//   const start = new Date(date);
//   const end = new Date();

//   const diff = (end - start) / 1000;

//   const times = [
//     { name: '년', milliSeconds: 60 * 60 * 24 * 365 },
//     { name: '개월', milliSeconds: 60 * 60 * 24 * 30 },
//     { name: '일', milliSeconds: 60 * 60 * 24 },
//     { name: '시간', milliSeconds: 60 * 60 },
//     { name: '분', milliSeconds: 60 },
//   ];

//   for (const value of times) {
//     const betweenTime = Math.floor(diff / value.milliSeconds);

//     if (betweenTime > 0) {
//       return `${betweenTime}${value.name} 전`;
//     }
//   }
//   return '방금 전';
// }

// elapsedTime('2022-11-15');

// fetch('https://a973-125-247-122-218.jp.ngrok.io/users');

const Post = ({ post }) => {
  // console.log(JSON.stringify(post));
  return (
    <div className="Post">
      <div className="leftcon">
        <div className="votes">
          <span className="votesNum">0</span>
          <span className="votesUnit">votes</span>
        </div>
        <div className="answer">
          <span className="answerNum">{post.answers.length}</span>
          <span className="answerUnit">answer</span>
        </div>
        <div className="views">
          <span className="viewsNum">{post.viewCount}</span>
          <span className="viewsUnit">views</span>
        </div>
      </div>
      <div className="postwidth">
        <h3 className="postname">
          <a href={`/questions/${post.questionId}`} className="postnames">
            <div
              dangerouslySetInnerHTML={{
                __html: post.title,
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

export default Post;
