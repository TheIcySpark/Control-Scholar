import { Component } from "react";
import axios from "axios";
import Book from "./Book";

export default class ViewMembers extends Component{
    constructor(props){
        super(props)

        this.state = {isLoading: true, data: undefined}

        this.reloadComponent = this.reloadComponent.bind(this)
    }

    loadData(){
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


    reloadComponent(){
        this.setState({isLoading: true})
        this.loadData()
    }
    

    componentDidMount(){
        this.loadData()
    }

    render(){
        if(this.state.isLoading){
            return(
                <div>
                    Loading ...
                </div>
            )
        }

        let r = this.reloadComponent

        let books = []
        this.state.data.forEach(function(value, index, array){
            books.push(
                <Book 
                key={index} 
                defaultValueName = {value.name}
                defaultValueAuthor = {value.author}
                defaultValuePublisher = {value.publisher}
                defaultValueEdition = {value.edition}
                defaultValueYear = {value.year}
                defaultValueId = {value.id}
                reloadComponent = {r}
                />
            )
        })
        return(
            <div>
                {books}
            </div>
        )
    }
}