import React, {Component} from "react";
import AddBook from "../main/Book";
import BookCopiesView from "../main/BookCopiesView";
import Profile from "../main/Profile";
import BookCopies from "../main/BookCopies";
import './loggedInBanner.css'
import ViewBooks from "../main/ViewBooks";

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
			bodyRender = <BookCopiesView></BookCopiesView>
		}else if(this.state.bodyComponent === 2){
			bodyRender = <AddBook></AddBook>
		}else if(this.state.bodyComponent === 3){
			bodyRender = <ViewBooks></ViewBooks>
		}else if(this.state.bodyComponent === 4){
			bodyRender = <BookCopies></BookCopies>
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
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(1)}}>Library</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(2)}}>Add book</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(3)}}>View Books</a>
					<a className="nav-link"  href="#" onClick={() =>{this.handleClickNavBar(4)}}>Add book copies</a>
					<button className="btn btn-danger" onClick={this.props.handleLogout}>Logout</button>
				</nav>
				{bodyRender}
			</div>
		)
	}
}