import { Component } from "react";
import axios from "axios";
import Member from "./Member";

export default class ViewMembers extends Component{
    constructor(props){
        super(props)

        this.state = {isLoading: true, data: undefined}

        this.reloadComponent = this.reloadComponent.bind(this)
    }

    loadData(){
        axios.get('http://localhost:8080/api/admin/' + localStorage.getItem('location') +'/member/get/all')
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

        let members = []
        this.state.data.forEach(function(value, index, array){
            members.push(
                <Member
                key={index} 
                defaultValueName = {value.name}
                defaultValuePaSurname = {value.paSurname}
                defaultValueMaSurname = {value.maSurname}
                defaultValueEmail = {value.email}
                defaultValueRoles = {value.roles}
                defaultValueCurp = {value.curp}
                defaultValueId = {value.id}
                reloadComponent = {r}
                />
            )
        })
        return(
            <div>
                {members}
            </div>
        )
    }
}