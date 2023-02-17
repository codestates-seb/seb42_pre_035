import './inputBox.css';
function inputBox() {
  return (
    <div className="boxItem">
      <div className="flexItem">
        <div className="mb12">
          <span className="boxName">[tag]</span>
          <span className="fc500">search within tag</span>
        </div>
        <div className="mb12">
          <span className="boxName">user:1234</span>
          <span className="fc500">search by author</span>
        </div>
        <div className="mb12">
          <span className="boxName">words here</span>
          <span className="fc500">exact phrase</span>
        </div>
        <div className="sm:mb12">
          <span className="boxName">collective:Name</span>
          <span className="fc500">collective content</span>
        </div>
      </div>
      <div className="flexItem">
        <div className="mb12">
          <span className="boxName">answers:0</span>
          <span className="fc500">unanswered questions</span>
        </div>
        <div className="mb12">
          <span className="boxName">score:3</span>
          <span className="fc500">posts with a 3+ score</span>
        </div>
        <div className="mb12">
          <span className="boxName">is:question</span>
          <span className="fc500">type of post</span>
        </div>
        <div className="">
          <span className="boxName">isaccepted:yes</span>
          <span className="fc500">search within status</span>
        </div>
      </div>
    </div>
  );
}
export default inputBox;
