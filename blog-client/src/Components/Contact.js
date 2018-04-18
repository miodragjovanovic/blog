import React, { Component } from 'react';
import $ from 'jquery';

class Contact extends Component {

    constructor(props) {
        super(props);

        this.state = {
            email: 'email adress',
            text: 'write here',
            saved: false
        }

        this.onClick = this.onClick.bind(this);
        this.onChangeText = this.onChangeText.bind(this);
        this.onChangeEmail = this.onChangeEmail.bind(this);
        this.save = this.save.bind(this);
    }

    onChangeText(event) {
        this.setState({
            text: event.target.value
        });
    }

    onChangeEmail(event) {
        this.setState({
            email: event.target.value
        });
    }

    onClick(event) {
        console.log(this.state.text);
        console.log(event.target);
        this.save();
    }

    save() {
        console.log(this.state.text);
        var obj = { data : this.state.text,
                    email: this.state.email}
        $.ajax({
        type:"POST",
        url: "http://localhost:8080/api/blog/save",
        data: obj,
        success: function (data) {
            this.setState({
                saved: data
            });
        }.bind(this),
        error: function (xhr, status, err) {
            console.log(err);
        }

        });
  }

    render() {
        return (
            <div className="Contact">
                <p>Contact us by sending email to: <a href="mailto:rhapsoad@yahoo.ie">rhapsoad@yahoo.ie</a> or use the form below</p>
                <br />
                <div>
                    <p>email adress:</p>
                    <input onChange={this.onChangeEmail}/>
                    <br />
                    <p>message:</p>
                    <textarea key='area' onChange={this.onChangeText} value={this.state.text} rows='5' cols='120'></textarea>
                    <br />
                    <button className='btn btn-primary' onClick={this.onClick}>Send</button>
                    <br />
                    <h1>{this.state.saved}</h1>
                </div>
            </div>
        );
    }
}

export default Contact;