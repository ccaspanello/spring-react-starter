import React, {useEffect} from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

class App extends React.Component {

    state = {
        greeting: ""
    }

    componentDidMount() {
        axios.get(`/greeting`)
            .then(res => {
                const greeting = res.data;
                this.setState({greeting});
            })
    }

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <p>
                        Edit <code>src/App.js</code> and save to reload.
                    </p>
                    <a
                        className="App-link"
                        href="https://reactjs.org"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        Learn React
                    </a>
                    <h1>{this.state.greeting}</h1>
                </header>
            </div>
        );
    }
}

export default App;
