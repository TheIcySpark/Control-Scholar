import React, {Component} from "react";
import Profile from "../main/Profile";
import './loggedInBanner.css'

export default class LoggedInBanner extends Component{
	constructor(props){
		super(props)
		this.state = {bodyComponent: 0}
	}

    render(){
		let bodyRender
		if(this.state.bodyComponent == 0){
			bodyRender = <Profile></Profile>
		}
        return(
			<div>
				<nav className="navbar navbar-light bg-light justify-content-between">
					<a className="navbar-brand" href="#">
						<svg viewBox="0 0 1024 1024" className="profile-icon">
							<path d="M512 128l470 256v342h-86v-296l-384 210-470-256zM214 562l298 164 298-164v172l-298 162-298-162v-172z"></path>
						</svg>
					</a>
					<a className="nav-link" href="#">Profile</a>
					<a className="nav-link" href="#">Library</a>
					<a className="nav-link" href="#">Another</a>
					<button className="btn btn-danger" onClick={this.props.handleLogout}>Logout</button>
				</nav>
				{bodyRender}
			</div>
		)
	}
}