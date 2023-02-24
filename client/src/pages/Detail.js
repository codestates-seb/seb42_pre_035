import Question from '../components/Detail/Questions';
import Header from '../components/Header/Header';
import LeftNav from '../components/LeftNav/LeftNav';

function Detail() {
  return (
    <div>
      <Header />
      <div className="h">
        <LeftNav />
        <Question />
      </div>
    </div>
  );
}
export default Detail;
