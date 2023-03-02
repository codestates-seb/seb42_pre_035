import Header from '../components/Header/Header';
import { useState } from 'react';
import QuestionEdit from '../components/question/QuestionEdit';

function Question() {
  const [text, setText] = useState('');

  const handleText = (value) => {
    console.log(value);
    setText(value);
  };

  return (
    <div>
      <Header />
      <QuestionEdit value={text} onChange={handleText} />
    </div>
  );
}
export default Question;
