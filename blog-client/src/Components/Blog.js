import React, { Component } from 'react';
import $ from 'jquery';

class Blog extends Component {

  constructor(props) {
    super(props);

    this.state = {
      test: 'initial'
    }

    this.getPost = this.getPost.bind(this);

  }


  componentDidMount() {
    this.getPost();
  }

  getPost() {
    $.ajax({
      url: "http://localhost:8080/api/blog/test",
      success: function (data) {
        this.setState({
          test: data
        });
      }.bind(this),
      error: function (xhr, status, err) {
        console.log(err);
      }

    });
  }

  render() {
    return (
      <div className="Blog">
        Test Blog
         <p>{this.state.test}</p>
      </div>
    );
  }
}

export default Blog;