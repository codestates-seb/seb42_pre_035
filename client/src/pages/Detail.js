import Question from '../components/Detail/Questions';
import Header from '../components/Header/Header';
import LeftNav from '../components/LeftNav/LeftNav';
import './Home.css';

function Detail() {
  return (
    <div className="hFlex">
      <Header />
      <div className="h">
        <LeftNav />
        <Question />
      </div>
    </div>
  );
}
export default Detail;
