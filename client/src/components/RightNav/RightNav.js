import './Right.css';

function RightNav() {
  return (
    <div className="RightNav">
      <div className="RightNavbox">
        <header>The Overflow Blog</header>
        <ul>
          <li>
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
          <li>Watch tags to curate your list of questions.</li>
        </ul>
      </div>
    </div>
  );
}

export default RightNav;
