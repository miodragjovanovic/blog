import React, { Component } from 'react';


class Home extends Component {
    constructor(props) {
        super(props);

        this.state = {
            someText: 'Test'
        };

        this.onChange = this.onChange.bind(this);
    }

    onChange(event) {
        this.setState({
            someText: event.target.value
        });
        console.log(event);
    }

    componentDidMount() {

    }


    render() {
        return (
            <div className="Home">
                <h1>Home page of custom blog</h1>
                <input value={this.state.someText} onChange={this.onChange}></input>
                <p>{this.state.someText}</p>
            </div>
        );
    }
}

export default Home;