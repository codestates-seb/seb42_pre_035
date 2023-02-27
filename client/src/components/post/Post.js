import './post.css';
import { useEffect } from 'react';
import axios from 'axios';

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

// const createDOMPurify = require('dompurify');
// const { JSDOM } = require('jsdom');

// const window = new JSDOM('').window;
// const DOMPurify = createDOMPurify(window);

// module.exports.agoraStatesDiscussions = [
//   ].map(discussion => {
//   if (discussion.answer) {
//     return {
//       ...discussion,
//       bodyHTML: DOMPurify.sanitize(discussion.bodyHTML),
//       answer: {
//         ...discussion.answer,
//         bodyHTML: DOMPurify.sanitize(discussion.answer.bodyHTML)
//       }
//     }
//   }

//   return {
//     ...discussion,
//     bodyHTML: DOMPurify.sanitize(discussion.bodyHTML)
//   }
// })
// })

// const convertToDiscussion = (obj) => {
//   const li = document.createElement('li'); // li 요소 생성
//   li.className = 'discussion__container'; // 클래스 이름 지정

//   const avatarWrapper = document.createElement('div');
//   avatarWrapper.className = 'discussion__avatar--wrapper';
//   const discussionContent = document.createElement('div');
//   discussionContent.className = 'discussion__content';
//   const discussionAnswered = document.createElement('div');
//   discussionAnswered.className = 'discussion__answered';

//   li.append(avatarWrapper, discussionContent, discussionAnswered);
//   return li;
// };

// const render = (element) => {
//   for (let i = 0; i < agoraStatesDiscussions.length; i += 1) {
//     element.append(convertToDiscussion(agoraStatesDiscussions[i]));
//   }
//   return;
// };

// const ul = document.querySelector('ul.discussions__container');
// render(ul);

function Post() {
  const asd = async () => {
    axios
      .get('https://a973-125-247-122-218.jp.ngrok.io/questions/1', {
        headers: {
          'Content-Type': `application/json`,
          'ngrok-skip-browser-warning': '69420',
        },
      })
      .then((response) => {
        // setUsers(response);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    asd();
  }, []);

  return (
    <div className="Post">
      <div className="leftcon">
        <div className="votes">
          <span className="votesNum">0</span>
          <span className="votesUnit">votes</span>
        </div>
        <div className="answer">
          <span className="answerNum">0</span>
          <span className="answerUnit">answer</span>
        </div>
        <div className="views">
          <span className="viewsNum">0</span>
          <span className="viewsUnit">views</span>
        </div>
      </div>
      <div className="postwidth">
        <h3 className="postname">
          <a
            href="/questions/75551593/selenium-not-clicking-search-button-with-no-id"
            className="postnames"
          >
            Selenium not clicking Search button with no id?
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
}

export default Post;
