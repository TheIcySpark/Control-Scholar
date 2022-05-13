import React, {Component} from "react";
import AddBook from "../main/Book";
import Profile from "../main/Profile";
import BookCopies from "../main/BookCopies";
import ViewBooks from "../main/ViewBooks";
import ViewBookCopies from "../main/ViewBookCopies";
import './loggedInBanner.css'
import Member from "../main/Member";
import ViewMembers from "../main/ViewMember";

export default class LoggedInBanner extends Component{
	constructor(props){
		super(props)
		this.state = {bodyComponent: 0}
	}

	handleClickNavBar(n){
		this.setState({bodyComponent: n})
	}

    render(){
		let bodyRender
		if(this.state.bodyComponent === 0){
			bodyRender = <Profile></Profile>
		}else if(this.state.bodyComponent === 1){
			bodyRender = <AddBook></AddBook>
		}else if(this.state.bodyComponent === 2){
			bodyRender = <ViewBooks></ViewBooks>
		}else if(this.state.bodyComponent === 3){
			bodyRender = <BookCopies></BookCopies>
		}else if(this.state.bodyComponent === 4){
			bodyRender = <ViewBookCopies></ViewBookCopies>
		}else if(this.state.bodyComponent === 5){
			bodyRender = <Member></Member>
		}else if(this.state.bodyComponent === 6){
			bodyRender = <ViewMembers></ViewMembers>
		}

        return(
			<div>
				<nav className="navbar navbar-light bg-light justify-content-between">
					<a className="navbar-brand" href="#">
						<svg viewBox="0 0 1024 1024" className="profile-icon">
							<path d="M512 128l470 256v342h-86v-296l-384 210-470-256zM214 562l298 164 298-164v172l-298 162-298-162v-172z"></path>
						</svg>
					</a>
					<a className="nav-link" href="#" onClick={() =>{this.handleClickNavBar(0)}}>Profile</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(1)}}>Add book</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(2)}}>View Books</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(3)}}>Add book copies</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(4)}}>View book copies</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(5)}}>Add member</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(6)}}>View members</a>
					<button className="btn btn-danger" onClick={this.props.handleLogout}>Logout</button>
				</nav>
				{bodyRender}
			</div>
		)
	}
}