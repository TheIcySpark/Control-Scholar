import { Component } from "react";

export default class Logout extends Component{

    render(){
        <button className="btn btn btn-info" onClick={this.props.handleLogout}>Logout</button>
    }
}