import React, {Component} from "react";
import './home.css'
import axios from 'axios'

export class Login extends Component{
    

    handleSubmit = e => {
        e.preventDefault()

        const data = {
            username: this.username,
            password: this.password
        }

        axios.post('http://localhost:8080/login', data)
            .then(res =>{
                localStorage.setItem('token', res.token)
            })
            .catch(err =>{
                console.log(err)
            })
    }
    
    
    render() {
        return (
            <div></div>
        )
    }
}