/* eslint-disable react/prop-types */
import { Component } from 'react';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';
import './QuestionEdit.css';

class EditorComponent extends Component {
  constructor(props) {
    super(props);
  }

  modules = {
    toolbar: [
      //[{ 'font': [] }],
      [{ header: [1, 2, false] }],
      ['bold', 'italic', 'underline', 'strike', 'blockquote'],
      [
        { list: 'ordered' },
        { list: 'bullet' },
        { indent: '-1' },
        { indent: '+1' },
      ],
      ['link', 'image'],
      [{ align: [] }, { color: [] }, { background: [] }], // dropdown with defaults from theme
      ['clean'],
    ],
  };

  formats = [
    //'font',
    'header',
    'bold',
    'italic',
    'underline',
    'strike',
    'blockquote',
    'list',
    'bullet',
    'indent',
    'link',
    'image',
    'align',
    'color',
    'background',
  ];

  render() {
    const { value, onChange } = this.props;

    return (
      <div className="container">
        <div className="content_01">
          <div className="editorContainer">
            <div className="editorHeader">
              <div className="background">
                <h1 className="fs-headline1 fw-bold mt24">
                  Ask a public question
                </h1>
              </div>
              <div className="w100 mt16">
                <div className="exContainer">
                  <div className="s-notice s-notice__info p24 w70 lg:w100">
                    <h2 className="fs-title fw-normal mb8">
                      Writing a good question
                    </h2>
                    <p className="fs-body2 mb0">
                      You’re ready to{' '}
                      <a href="https://stackoverflow.com/help/how-to-ask">
                        ask
                      </a>{' '}
                      a{' '}
                      <a href="https://stackoverflow.com/help/on-topic">
                        programming-related question
                      </a>{' '}
                      and this form will help guide you through the process.
                    </p>
                    <p className="fs-body2 mt0">
                      Looking to ask a non-programming question? See{' '}
                      <a href="https://stackexchange.com/sites#technology-traffic">
                        the topics here
                      </a>{' '}
                      to find a relevant site.
                    </p>
                    <h5 className="fw-bold mb8">Steps</h5>
                    <ul className="mb0">
                      <li>Summarize your problem in a one-line title.</li>
                      <li>Describe your problem in more detail.</li>
                      <li>
                        Describe what you tried and what you expected to happen.
                      </li>
                      <li>
                        Add “tags” which help surface your question to members
                        of the community.
                      </li>
                      <li>Review your question and post it to the site.</li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div className="titleFlex">
              <div className="titleBody">
                <div className="editorEx">
                  <span className="E1_span">Title</span>
                  <p>
                    Be specific and imagine you’re asking a question to another
                    person.
                  </p>
                </div>
                <input
                  id="title"
                  name="title"
                  type="text"
                  maxLength="300"
                  placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
                  className="qs-input js-post-title-field ask-title-field"
                  data-min-length="15"
                  data-max-length="150"
                ></input>
              </div>
              <div className="flex--item js-title-sidebar js-sidebar-toggler ps-relative w100">
                <div className="ps-absolute lg:ps-relative p0 s-card bs-sm">
                  <div className="titleCard">Writing a good title</div>
                  <div className="titleCard2">
                    <div className="flex--item">
                      <svg
                        aria-hidden="true"
                        className="svg-spot spotPencil"
                        width="48"
                        height="48"
                        viewBox="0 0 48 48"
                      >
                        <path
                          d="M31.52 5.2a.34.34 0 0 0-.46.08L7 39.94a.34.34 0 0 0-.06.16l-.54 5.21c-.03.26.24.45.48.34l4.77-2.29c.05-.02.1-.06.13-.1L35.83 8.58a.34.34 0 0 0-.09-.47l-4.22-2.93Z"
                          opacity=".2"
                        ></path>
                        <path d="M28.53 2.82c.4-.58 1.2-.73 1.79-.32l4.22 2.92c.58.4.72 1.2.32 1.79L10.82 41.87c-.13.18-.3.33-.5.43l-4.77 2.28c-.9.44-1.93-.29-1.83-1.29l.55-5.2c.02-.22.1-.43.22-.6L28.53 2.81Zm4.43 3.81L29.74 4.4 28.2 6.6l3.22 2.24 1.53-2.21Zm-2.6 3.76-3.23-2.24-20.32 29.3 3.22 2.24 20.32-29.3ZM5.7 42.4 8.62 41l-2.57-1.78-.34 3.18Zm35.12.3a1 1 0 1 0-.9-1.78 35 35 0 0 1-7.94 3.06c-1.93.43-3.8.3-5.71-.04-.97-.17-1.93-.4-2.92-.64l-.3-.07c-.9-.21-1.81-.43-2.74-.62-2.9-.58-6.6-.49-9.43.65a1 1 0 0 0 .74 1.86c2.4-.96 5.68-1.07 8.3-.55.88.18 1.77.4 2.66.6l.3.08c1 .24 2 .48 3.03.66 2.07.37 4.22.53 6.5.02 3-.67 5.77-1.9 8.41-3.22Z"></path>
                      </svg>
                    </div>
                    <div className="flex--item fs-caption">
                      <p>Your title should summarize the problem.</p>
                      <p>
                        You might find that you have a better idea of your title
                        after writing out the rest of the question.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="editorFlex">
              <div className="editorBody">
                <div className="editorEx">
                  <span className="E1_span">
                    What are the details of your problem?
                  </span>
                  <p>
                    Introduce the problem and expand on what you put in the
                    title. Minimum 20 characters.
                  </p>
                </div>
                <ReactQuill
                  style={{ height: '300px', width: '800px' }}
                  theme="snow"
                  modules={this.modules}
                  formats={this.formats}
                  value={value || ''}
                  onChange={(content, delta, source, editor) =>
                    onChange(editor.getHTML())
                  }
                />

                <div className="flex--item">
                  <button
                    className="questionBtn"
                    type="button"
                    autoComplete="off"
                  >
                    Review your question
                  </button>
                </div>
              </div>
              <div className="flex--item js-title-sidebar js-sidebar-toggler ps-relative w100">
                <div className="s-card2">
                  <div className="titleCard">Introduce the problem</div>
                  <div className="titleCard2">
                    <div className="flex--item">
                      <svg
                        aria-hidden="true"
                        className="svg-spot spotPencil"
                        width="48"
                        height="48"
                        viewBox="0 0 48 48"
                      >
                        <path
                          d="M31.52 5.2a.34.34 0 0 0-.46.08L7 39.94a.34.34 0 0 0-.06.16l-.54 5.21c-.03.26.24.45.48.34l4.77-2.29c.05-.02.1-.06.13-.1L35.83 8.58a.34.34 0 0 0-.09-.47l-4.22-2.93Z"
                          opacity=".2"
                        ></path>
                        <path d="M28.53 2.82c.4-.58 1.2-.73 1.79-.32l4.22 2.92c.58.4.72 1.2.32 1.79L10.82 41.87c-.13.18-.3.33-.5.43l-4.77 2.28c-.9.44-1.93-.29-1.83-1.29l.55-5.2c.02-.22.1-.43.22-.6L28.53 2.81Zm4.43 3.81L29.74 4.4 28.2 6.6l3.22 2.24 1.53-2.21Zm-2.6 3.76-3.23-2.24-20.32 29.3 3.22 2.24 20.32-29.3ZM5.7 42.4 8.62 41l-2.57-1.78-.34 3.18Zm35.12.3a1 1 0 1 0-.9-1.78 35 35 0 0 1-7.94 3.06c-1.93.43-3.8.3-5.71-.04-.97-.17-1.93-.4-2.92-.64l-.3-.07c-.9-.21-1.81-.43-2.74-.62-2.9-.58-6.6-.49-9.43.65a1 1 0 0 0 .74 1.86c2.4-.96 5.68-1.07 8.3-.55.88.18 1.77.4 2.66.6l.3.08c1 .24 2 .48 3.03.66 2.07.37 4.22.53 6.5.02 3-.67 5.77-1.9 8.41-3.22Z"></path>
                      </svg>
                    </div>
                    <div className="flex--item fs-caption">
                      <p>
                        Explain how you encountered the problem you’re trying to
                        solve, and any difficulties that have prevented you from
                        solving it yourself.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default EditorComponent;
