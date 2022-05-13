import { Component } from "react";
import axios from "axios";
import BookCopies from "./BookCopies";

export default class ViewBookCopies extends Component{
    constructor(props){
        super(props)
        this.state = {isLoading: true, data: undefined}
        this.reloadComponent = this.reloadComponent.bind(this)
    }

    loadData(){
        axios.get('http://localhost:8080/api/libraryManager/'+ localStorage.getItem('location') +'/bookCopies/get/all')
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

    componentDidMount(){
        this.loadData()
    }

    reloadComponent(){
        this.setState({isLoading: true})
        this.loadData()
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
        let r = this.reloadComponent
        this.state.data.forEach(function(value, index, array){
            bookCopies.push(
                <BookCopies
                key={index}
                defaultValueCopies = {value.copies}
                defaultValueBook = {value.book.id}
                defaultValueId = {value.id}
                reloadComponent = {r}
                />

            )
        })
        return (
             <div>
                 {bookCopies}
             </div>
        )
    }
}