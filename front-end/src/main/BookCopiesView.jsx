import { Component } from "react";
import axios from "axios";

export default class BookCopiesView extends Component{
    constructor(props){
        super(props)
        this.state = {isLoading: true, data: undefined}
    }

    componentDidMount(){
        axios.get('http://localhost:8080/api/'+ localStorage.getItem('location') +'/book/get/all')
            .then(res =>{
                if(res.status === 200){
                    this.setState({data: res.data})
                    this.setState({isLoading: false})
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    render() {
        if(this.state.isLoading){
            return(
                <div>
                    Loading ...
                </div>
            )
        }
        let bookCopies = []
        this.state.data.forEach(function(value, index, array){
            bookCopies.push(<div>
                <form>
                    <div className="form-group">
                        <label>Book</label>
                        <input
                        type="text"
                        className="form-control"
                        defaultValue={value.book.name}
                        />
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <input
                        type="text"
                        className="form-control"
                        defaultValue={value.book.author}
                        />
                    </div>
                    <div className="form-group">
                        <label>Edition</label>
                        <input
                        type="text"
                        className="form-control"
                        defaultValue={value.book.edition}
                        />
                    </div>
                    <div className="form-group">
                        <label>Publisher</label>
                        <input
                        type="text"
                        className="form-control"
                        defaultValue={value.book.publisher}
                        />
                    </div>
                    <div className="form-group">
                        <label>year</label>
                        <input
                        type="text"
                        className="form-control"
                        defaultValue={value.book.year}
                        />
                    </div>
                    <div className="form-group">
                        <label>Location</label>
                        <input
                        type="text"
                        className="form-control"
                        defaultValue={value.learningCenter.location}
                        />
                    </div>
                    <div className="form-group">
                        <label>Book copies</label>
                        <input
                        type="text"
                        className="form-control"
                        defaultValue={value.copies}
                        />
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                <br></br>
            </div>)
        })
        return (
             <div>
                 {bookCopies}
             </div>
        )
    }
}