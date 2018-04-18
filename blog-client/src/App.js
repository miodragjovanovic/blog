import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import Blog from './Components/Blog';
import Contact from './Components/Contact';
import Home from './Components/Home';
import Comments from './Components/Comments';

const BasicExample = () => (
  <Router>
    <div>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/blog">Blog</Link>
        </li>
        <li>
          <Link to="/contact">Contact Us</Link>
        </li>
        <li>
          <Link to="/comments">Comments</Link>
        </li>
      </ul>

      <hr />

      <Route exact path="/" component={HomePage} />
      <Route path="/blog" component={AboutPage} />
      <Route path="/contact" component={ContactPage} />
      <Route path="/comments" component={CommentsPage} />
    </div>
  </Router>
);

const HomePage = () => (
  <div>
    <Home />
  </div>
);

const AboutPage = () => (
  <div>
    <Blog />
  </div>
);

const ContactPage = () => (
  <div>
    <Contact />
  </div>
);

const CommentsPage = () => (
  <div>
    <Comments />
  </div>
);

export default BasicExample;
