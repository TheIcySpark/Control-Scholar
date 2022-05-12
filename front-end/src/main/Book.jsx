import { Component } from "react";
import axios from "axios";

export default class Book extends Component{
    constructor(props){
        super(props)
        this.state = {isLoading: true, data: undefined}
    }

    handleDrop = e =>{
        axios.delete('http://localhost:8080/api/libraryManager/book/drop',{data:{
            id: this.props.defaultValueId
        }})
            .then(res =>{
                if(res.status === 200){
                    this.setState({data: res.data})
                    alert('Book deleted')
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    handleSubmit = e =>{
        axios.post('http://localhost:8080/api/libraryManager/book/add',{
            name: this.name,
            author: this.author,
            edition: this.edition,
            publisher: this.publisher,
            year: this.year
        })
            .then(res =>{
                if(res.status === 200){
                    this.setState({data: res.data})
                    this.setState({isLoading: false})
                    alert('Book saved in database')
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    render(){
        let dropButton
        if(this.props.defaultValueId){
            dropButton = <button className="btn btn-danger" onClick={this.handleDrop}>drop</button>
        }
        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label>Name</label>
                        <input 
                        type="text"
                        className="form-control"
                        onChange={e => this.name = e.target.value}
                        defaultValue={this.props.defaultValueName}
                        />
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <input 
                        type="text"
                        className="form-control"
                        onChange={e => this.author = e.target.value}
                        defaultValue={this.props.defaultValueAuthor}
                        />
                    </div>
                    <div className="form-group">
                        <label>Edition</label>
                        <input 
                        type="text"
                        className="form-control"
                        onChange={e => this.edition = e.target.value}
                        defaultValue={this.props.defaultValueEdition}
                        />
                    </div>
                    <div className="form-group">
                        <label>Publisher</label>
                        <input 
                        type="text"
                        className="form-control"
                        onChange={e => this.publisher = e.target.value}
                        defaultValue={this.props.defaultValuePublisher}
                        />
                    </div>
                    <div className="form-group">
                        <label>year</label>
                        <input 
                        type="number"
                        className="form-control"
                        onChange={e => this.year = e.target.value}
                        defaultValue={this.props.defaultValueYear}
                        />
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                {dropButton}
            </div>
        )
    }
}