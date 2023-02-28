import Header from '../components/Header/Header';
import LeftNav from '../components/LeftNav/LeftNav';
import Main from '../components/main/Main';
import RightNav from '../components/RightNav/RightNav';
import './Home.css';

function Home() {
  return (
    <div>
      <Header />
      <div className="hFlex">
        <div className="h">
          <LeftNav />
          <Main />
          <RightNav />
        </div>
      </div>
      <footer></footer>
    </div>
  );
}
export default Home;
