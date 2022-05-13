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
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    handleDrop = e =>{
        axios.delete('http://localhost:8080/api/libraryManager/' + localStorage.getItem('location') +'/bookCopies/drop',{data:{
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
        axios.post('http://localhost:8080/api/libraryManager/' + localStorage.getItem('location') + '/bookCopies/add',{
            copies: document.getElementById("copies").value,
            book: {id: document.getElementById("book").value}
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
        let submitButton
        let disabled 
        if(this.props.defaultValueId){
            dropButton = <button className="btn btn-danger" onClick={this.handleDrop}>drop</button>
            disabled = true
        }else{
            submitButton = <button type="submit" className="btn btn-primary">Submit</button>
            disabled = false
        }

        let options = []
        this.state.data.forEach(function(value, index, array){
            options.push(
                <option key={index} value = {value.id}>{value.name}</option>
            )
        })

        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group" >
                        <label>Copies number</label>
                        <input 
                        disabled={disabled}
                        id = "copies"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueCopies}
                        />
                    </div>
                    <div className="form-group">
                        <label>Book: </label>
                        <select 
                        disabled={disabled}
                        id="book" 
                        defaultValue={this.props.defaultValueBook}>
                            {options}
                        </select>
                    </div>
                    {submitButton}
                </form>
                {dropButton}
            </div>
        )
    }
}