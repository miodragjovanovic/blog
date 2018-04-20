import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import Blog from './Components/Blog';
import Contact from './Components/Contact';
import Home from './Components/Home';
import Comments from './Components/Comments';
import Login from './Components/Login';
import axios from 'axios';

const BasicExample = () => (
  <Router>
    <div>
    <Link to="/comments">Comments</Link>
    <br/>
    <Link to="/login">Login</Link>
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
       
          
       
      </ul>
        
      <hr />

      <Route exact path="/" component={HomePage} />
      <Route path="/blog" component={AboutPage} />
      <Route path="/contact" component={ContactPage} />
      <Route path="/comments" component={CommentsPage} onEnter={this.requireAuth}/>
      <Route path="/login" component={LoginPage} />
    </div>
  </Router>
);

function requireAuth(nextState, replace) {
  if (!loggedIn()) {
    replace({
      pathname: '/login'
    })
  }
}

function loggedIn() {

        axios.post('http://localhost:8080/api/blog/loggedIn?user=' + sessionStorage.getItem('user') )
        .then(response => {
            console.log(response);
            return response.data;
        });

}

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

const LoginPage = () => (
  <div>
    <Login />
  </div>
);

export default BasicExample;
