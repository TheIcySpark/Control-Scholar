import { Component } from "react";
import axios from "axios";

export default class BookCopies extends Component{
    constructor(props){
        super(props)
        this.state = {isLoading: true, data: undefined}
    }

    componentDidMount(){
        axios.get('http://localhost:8080/api/libraryManager/book/get/all')
            .then(res =>{
                if(res.status === 200){
                    this.setState({data: res.data})
                    this.setState({isLoading: false})
                    console.log(res.data)
                }
            })
            .catch(err =>{
                alert(err)
            })
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
        alert(this.book)
        axios.post('http://localhost:8080/api/libraryManager/' + localStorage.getItem('location') + '/bookCopies/add',{
            copies: this.copies,
            book: {id: this.book}
        })
            .then(res =>{
                if(res.status === 200){
                    alert('Books copies added')
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    render(){
        if(this.state.isLoading){
            return(
                <div>
                    Loading ...
                </div>
            )
        }

        let dropButton
        if(this.props.defaultValueId){
            dropButton = <button className="btn btn-danger" onClick={this.handleDrop}>drop</button>
        }

        let options = []
        this.state.data.forEach(function(value, index, array){
            options.push(
                <option value = {value.id}>{value.name}</option>
            )
        })

        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label>Copies number</label>
                        <input 
                        type="text"
                        className="form-control"
                        onChange={e => this.copies = e.target.value}
                        defaultValue={this.props.defaultValueCopies}
                        />
                    </div>
                    <div className="form-group">
                        <label>Book: </label>
                        <select onChange={e => this.book = e.target.value}>
                            {options}
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                {dropButton}
            </div>
        )
    }
}