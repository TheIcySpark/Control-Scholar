import { Component } from "react";
import axios from "axios";
import AddBook from "./Book";

export default class ViewBooks extends Component{
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

    handleSubmit = e =>{
        e.preventDefault()

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

        let books = []
        this.state.data.forEach(function(value, index, array){
            books.push(
                <AddBook 
                key={index} 
                defaultValueName = {value.name}
                defaultValueAuthor = {value.author}
                defaultValuePublisher = {value.publisher}
                defaultValueEdition = {value.edition}
                defaultValueYear = {value.year}
                defaultValueId = {value.id}
                />
            )
        })
        console.log(books)
        return(
            <div>
                {books}
            </div>
        )
    }
}