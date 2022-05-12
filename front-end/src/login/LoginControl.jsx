import React from "react";
import Login from "./Login";
import LoggedInBanner from "./LoggedInBanner";

export default class LoginControl extends React.Component{
    constructor(props){
        super(props)
        this.state = {isLoggedIn: false}

        this.handleLogin = this.handleLogin.bind(this)
        this.handleLogout = this.handleLogout.bind(this)
    }

    componentDidMount(){
        if(localStorage.getItem("accessToken") != null){
            this.setState({isLoggedIn: true})
        }
    }

    handleLogin(){
        this.setState({isLoggedIn: true})
    }

    handleLogout(){
        localStorage.clear();
        this.setState({isLoggedIn: false})
    }

    render(){
        if(this.state.isLoggedIn){
            return(
                <div>
                    <LoggedInBanner handleLogout = {this.handleLogout}></LoggedInBanner>
                </div>
            )
        }else{
            return(
                <div>
                    <Login handleLogin = {this.handleLogin}></Login>
                </div>
            )
        }
    }
}