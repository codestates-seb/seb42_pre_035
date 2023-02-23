import Header from '../components/Header/Header';
import LeftNav from '../components/LeftNav/LeftNav';
import Search from '../components/Search/Search';
import RightNav from '../components/RightNav/RightNav';
import './Home.css';

function SearchPage() {
  return (
    <div>
      <Header />
      <div className="h">
        <LeftNav />
        <Search />
        <RightNav />
      </div>
    </div>
  );
}
export default SearchPage;
