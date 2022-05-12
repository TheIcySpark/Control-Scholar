import { Component } from "react";
import axios from "axios";

export default class AddBookCopies extends Component{
    constructor(props){
        super(props)
        this.state = {isLoading: true, data: undefined}
    }

    componentDidMount(){
        axios.post('http://localhost:8080/api/libraryManager/' + localStorage.getItem('location') + '/bookCopies/add')
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

    render(){
        if(this.state.isLoading){
            return(
                <div>
                    Loading ...
                </div>
            )
        }

        let options = []
        this.state.data.forEach(function(value, index, array){
            options.push(
                <option value = {value.book.id}>{value.book.name}</option>
            )
        })

        return(
            <div>
                <form>
                    <div className="form-group">
                        <label>Number of copies</label>
                        <input 
                        type="number"
                        className="form-control"
                        defaultValue={this.state.data.copies}
                        />
                    </div>
                    <div className="form-group">
                        <label>Book</label>
                        <select>
                            {options}
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        )
    }
}