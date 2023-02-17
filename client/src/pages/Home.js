import Header from '../components/Header/Header';
import LeftNav from '../components/LeftNav/LeftNav';
import RightNav from '../components/RightNav/RightNav';
import './Home.css';

function Home() {
  return (
    <div>
      <Header />

      <div className="h">
        <LeftNav />
        <RightNav />
      </div>
    </div>
  );
}
export default Home;
