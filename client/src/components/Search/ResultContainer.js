function ResultContainer() {
  return (
    <div>
      <div className="noResultContainer">
        <div className="pageDescription">
          <div className="flexCenter">
            <svg
              aria-hidden="true"
              className="glasses"
              width="96"
              height="96"
              viewBox="0 0 96 96"
            >
              <path
                d="M60.38 76.15a6.2 6.2 0 1 1 8.77-8.77l17.78 17.79a6.2 6.2 0 0 1-8.76 8.76L60.38 76.15Z"
                opacity=".2"
              ></path>
              <path d="M52.17 13.27a1.5 1.5 0 0 0-1.5 2.6A25.5 25.5 0 0 1 63 32.97a1.5 1.5 0 1 0 2.94-.59 28.5 28.5 0 0 0-13.77-19.1ZM36.64 11c0-.84.67-1.5 1.5-1.5 1.8 0 3.59.19 5.35.53a1.5 1.5 0 1 1-.58 2.95 25.5 25.5 0 0 0-4.78-.48 1.5 1.5 0 0 1-1.5-1.5ZM38 1.5a36.5 36.5 0 1 0 22.3 65.4 6.47 6.47 0 0 0 1.9 4.48l19.15 19.15a6.5 6.5 0 0 0 9.18-9.18L71.38 62.2a6.47 6.47 0 0 0-4.48-1.9A36.5 36.5 0 0 0 38 1.5ZM4.5 38a33.5 33.5 0 1 1 67 0 33.5 33.5 0 0 1-67 0Zm59.83 31.26a3.5 3.5 0 0 1 4.93-4.93l19.15 19.14a3.5 3.5 0 1 1-4.94 4.94L64.33 69.26Z"></path>
            </svg>
            <div className="ta-center fs-body3 mt12">
              <span>We couldnt find anything</span>{' '}
              {/* <span className="bold">dlsnditi</span> */}
            </div>
            <div className="ta-center fs-body1 mt4">
              <span className="bold">Search options:</span>
              not deleted
            </div>

            <div className="ta-center fs-body1 mt4">
              Try different or less specific keywords.
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default ResultContainer;