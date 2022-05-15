import { Component } from "react";
import axios from "axios";

export default class Book extends Component{
    constructor(props){
        super(props)
    }

    handleDrop = e =>{
        axios.delete('http://localhost:8080/api/libraryManager/book/drop',{data:{
            id: this.props.defaultValueId
        }})
            .then(res =>{
                if(res.status === 200){
                    this.props.reloadComponent()
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    handleSubmit = e =>{
        axios.post('http://localhost:8080/api/libraryManager/book/add',{
            name: document.getElementById("name").value,
            author: document.getElementById("author").value,
            edition: document.getElementById("edition").value,
            publisher: document.getElementById("publisher").value,
            year: document.getElementById("year").value
        }, {headers: {
            Authorization: localStorage.getItem('accessToken')
        }})
            .then(res =>{
                if(res.status === 200){
                    alert('Book saved in database')
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    render(){
        let dropButton
        let submitButton
        let disabled
        if(this.props.defaultValueId){
            dropButton = <button className="btn btn-danger" onClick={this.handleDrop}>drop</button>
            disabled = true
        }else{
            submitButton = <button type="submit" className="btn btn-primary">Submit</button>
            disabled = false
        }
        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label>Name</label>
                        <input 
                        disabled={disabled}
                        id="name"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueName}
                        />
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <input 
                        disabled={disabled}
                        id="author"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueAuthor}
                        />
                    </div>
                    <div className="form-group">
                        <label>Edition</label>
                        <input 
                        disabled={disabled}
                        id="edition"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueEdition}
                        />
                    </div>
                    <div className="form-group">
                        <label>Publisher</label>
                        <input 
                        disabled={disabled}
                        id="publisher"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValuePublisher}
                        />
                    </div>
                    <div className="form-group">
                        <label>year</label>
                        <input 
                        disabled={disabled}
                        id="year"
                        type="number"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueYear}
                        />
                    </div>
                    {submitButton}
                </form>
                {dropButton}
            </div>
        )
    }
}