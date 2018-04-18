import React, { Component } from 'react';
import axios from 'axios';


class Comments extends Component {
    constructor(props) {
        super(props);
        this.state = {
            comments: [],
            username: '',
            password: '',
        }

        this.getPost = this.getPost.bind(this);
        this.handleChangeUsername = this.handleChangeUsername.bind(this);
        this.handleChangePassword = this.handleChangePassword.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

// componentDidMount() {
//     this.getPost();
// }


 handleChangeUsername(event) {
    this.setState({ username: event.target.value, errorMessage: null });
  }

  handleChangePassword(event) {
    this.setState({ password: event.target.value, errorMessage: null });
  }

  handleSubmit() {
    let formData = new FormData();    //formdata object

    formData.append('username', this.state.username);   //append the values with key, value pair
    formData.append('password', this.state.password);
    formData.append('submit', 'Login');

    const config = {     
        headers: { 'content-type': 'multipart/form-data' },
        withCredentials: true,
        mode: 'cors'
    }

    var url = 'http://localhost:8080/login';

    axios.post(url, formData, config)
        .then(response => {
            console.log(response);
        })
        .catch(error => {
            console.log(error);
        });

  }

  handleLogout() {
        axios.get('http://localhost:8080/logout', {withCredentials: true})
        .then(response => {
            console.log(response);
        });

    }


getPost() {
    axios.get('http://localhost:8080/api/user/comments', {withCredentials: true})
        .then(res => {
            console.log(res.data)
            this.setState({
                comments : res.data
            });
        });

  }


    render() {
        return (
            <div className="Comments">
                <h1 onClick={this.getPost}>Bla</h1>
                    {this.state.comments.map(c =>
                        <div key={c.id}>
                            <p>{c.email}</p>
                            <p>{c.text}</p>
                        </div>
                    )}
                

                <form>
                    <label>
                        Username:
                        <input type="text" value={this.state.username} onChange={this.handleChangeUsername} />
                    </label>
                    <label>
                        Password:
                        <input type="text" value={this.state.password} onChange={this.handleChangePassword} />
                    </label>
                    <input type="submit" value="Submit" onClick={this.handleSubmit}/>
                </form>
                <input type="submit" value="Logout" onClick={this.handleLogout}/>


            </div>
        );
    }
}

export default Comments;