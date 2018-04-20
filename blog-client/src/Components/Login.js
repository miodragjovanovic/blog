import React, { Component } from 'react';
import axios from 'axios';


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
        }

        this.handleChangeUsername = this.handleChangeUsername.bind(this);
        this.handleChangePassword = this.handleChangePassword.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
        this.getMe = this.getMe.bind(this);
    }



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

    sessionStorage.setItem('user', this.state.username);
    axios.post(url, formData, config)
        .then(response => {
            console.log("LoggedIn", response);
        })
        .catch(error => {
            console.log(error);
        });

  }

  handleLogout() {
        sessionStorage.setItem('user', null);
        axios.get('http://localhost:8080/logout', {withCredentials: true})
        .then(response => {
            console.log(response);
        });

    }

    getMe() {
        axios.post('http://localhost:8080/api/blog/loggedIn?user=' + sessionStorage.getItem('user') )
        .then(response => {
            console.log(response);
        });

    }

    render() {
        return (
            <div className="Login">            
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
                <input type="submit" value="Getme" onClick={this.getMe}/>


            </div>
        );
    }
}

export default Login;