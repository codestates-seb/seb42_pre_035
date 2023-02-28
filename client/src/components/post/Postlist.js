import axios from 'axios';
import Post from './Post';
import { useEffect, useState } from 'react';
import { REDIRECT_URI } from '../Apiurl';

const Postlist = () => {
  const [postBody, setPostBody] = useState(null);

  useEffect(() => {
    axios
      .get(`${REDIRECT_URI}questions?page=1&size=5`, {
        headers: {
          'Content-Type': `application/json`,
          'ngrok-skip-browser-warning': '69420',
        },
      })
      .then((res) => {
        setPostBody(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <div>
      {postBody &&
        postBody.map((post) => {
          return <Post key={post.questionId} post={post} />;
        })}
    </div>
  );
};

export default Postlist;
