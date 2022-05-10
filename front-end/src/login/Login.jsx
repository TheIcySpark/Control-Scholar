import React, {Component} from "react";
import axios from 'axios';
import './home.css'

export class Login extends Component{
    

    handleSubmit = e => {
        e.preventDefault()

        const data = {
            id: this.id,
            password: this.password
        }       
        console.log(data)

        axios.post('http://localhost:8080/api/member/login', null, {params: {
            id: data.id,
            password : data.password
        }})
            .then(res =>{
                console.log("xd")
                console.log(res)
                console.log(res.headers)
            })
            .catch(err =>{
                console.log(err)
            })
    }
    
    
    render() {
        return (
            <div className="home-container">
                <div className="home-banner">
                    <h1 className="home-text">Damn vulnerable control Schoolar</h1>
                    <button className="btn btn btn-info button">Contact</button>
                </div>
                <br></br>
                <form className="home-login-form" onSubmit={this.handleSubmit}>
                    <input
                    type="text"
                    required
                    placeholder="id"
                    className="input form-control"
                    onChange={e => this.id = e.target.value}
                    />
                    <input
                    type="password"
                    required
                    placeholder="Password"
                    className="home-textinput1 input form-control"
                    onChange={e => this.password = e.target.value}
                    />
                    <button className="btn btn-primary button form-control">Login</button>
                </form>
            </div>
        )
    }
}