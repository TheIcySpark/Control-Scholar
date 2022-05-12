import {Component} from "react";
import axios from 'axios';
import './home.css'

export default class Login extends Component{

    handleSubmit = e => {
        e.preventDefault()

        const data = {
            id: this.id,
            password: this.password
        }       

        axios.post('http://localhost:8080/api/member/login', null, {params: {
            id: data.id,
            password : data.password
        }})
            .then(res =>{
                if(res.status === 200){
                    localStorage.setItem('accessToken', 'Bearer ' + res.data)
                    localStorage.setItem('id', this.id)
                    this.props.handleLogin()
                }else{
                    alert("Can you stop kidding, just login")
                }
            })
            .catch(err =>{
                document.getElementById("alertDiv").classList.remove("invisible")
                document.getElementById("alertDiv").classList.add("visible")
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
                <div id="alertDiv" className="alert alert-warning invisible" role="alert">
                    Error in credentials
                </div>
            </div>
        )
    }
}