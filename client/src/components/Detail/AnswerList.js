import Answer from './Answer';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { useEffect, useState } from 'react';
import { REDIRECT_URI } from '../Apiurl';
function AnswerList() {
  const { id } = useParams();
  console.log('POST' + id);
  const [answerBody, setAnswerBody] = useState(null);
  console.log('answer바디엔?' + answerBody);

  useEffect(() => {
    axios
      .get(`${REDIRECT_URI}questions/${id}`, {
        headers: {
          'Content-Type': `application/json`,
          'ngrok-skip-browser-warning': '69420',
        },
      })
      .then((res) => {
        setAnswerBody(res.data);

        // console.log('List엔 무엇이?' + JSON.stringify(res.data));
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <>
      {answerBody &&
        answerBody.answers.map((answer) => {
          return <Answer key={answer.answerId} answer={answer} />;
        })}
    </>
  );
}

export default AnswerList;
