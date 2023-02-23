import './Right.css';

function RightNav() {
  return (
    <div className="RightNav">
      <div className="RightNavbox">
        <header>The Overflow Blog</header>
        <ul>
          <li className="one">
            Serverless scales well, but most databases don’t sponsored post
          </li>
          <li>
            Monitoring debt builds up faster than software teams can pay it off
          </li>
        </ul>
        <header>Featured on Meta</header>
        <ul>
          <li>Ticket smash for [status-review] tag: Part Deux</li>
          <li>
            We’ve added a Necessary cookies only option to the cookie consent
            popup
          </li>
          <li>We’ve made changes to our Privacy Notice for Collectives™</li>
          <li>The [amazon] tag is being burninated</li>
          <li>Microsoft Azure Collective launch and proposed tag changes</li>
          <li>Temporary policy: ChatGPT is banned</li>
        </ul>
      </div>
      <div className="filters">
        <header>Custom Filters</header>
        <ul>
          <li>Create a custom filter</li>
        </ul>
      </div>
      <div className="watchedtags">
        <header>Watched Tags</header>
        <ul>
          <svg
            aria-hidden="true"
            id="watch"
            className="watch"
            width="48"
            height="48"
            viewBox="0 0 48 48"
          >
            …
            <path d="M18.5 5a1 1 0 1 0 0 2c.63 0 1.24.05 1.84.15a1 1 0 0 0 .32-1.98A13.6 13.6 0 0 0 18.5 5Zm7.02 1.97a1 1 0 1 0-1.04 1.7 11.5 11.5 0 0 1 5.44 8.45 1 1 0 0 0 1.98-.24 13.5 13.5 0 0 0-6.38-9.91ZM18.5 0a18.5 18.5 0 1 0 10.76 33.55c.16.57.46 1.12.9 1.57L40 44.94A3.5 3.5 0 1 0 44.94 40l-9.82-9.82c-.45-.45-1-.75-1.57-.9A18.5 18.5 0 0 0 18.5 0ZM2 18.5a16.5 16.5 0 1 1 33 0 16.5 16.5 0 0 1-33 0Zm29.58 15.2a1.5 1.5 0 1 1 2.12-2.12l9.83 9.83a1.5 1.5 0 1 1-2.12 2.12l-9.83-9.83Z"></path>
          </svg>
          <li id="watch">Watch tags to curate your list of questions.</li>
          <div className="watchatag">
            <p>Watch a tag</p>
          </div>
        </ul>
      </div>
    </div>
  );
}

export default RightNav;
