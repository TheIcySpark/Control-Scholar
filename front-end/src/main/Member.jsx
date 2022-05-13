import { Component } from "react";
import axios from "axios";

export default class Member extends Component{
    constructor(props){
        super(props)
    }

    handleDrop = e =>{
        axios.delete('http://localhost:8080/api/member/' + localStorage.getItem('location') + '/drop',{data:{
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
        axios.post('http://localhost:8080/api/member/' + localStorage.getItem('location') + '/add',{
            name: document.getElementById("name").value,
            paSurname: document.getElementById("paSurname").value,
            maSurname: document.getElementById("maSurname").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value,
            roles: document.getElementById("roles").value,
            curp: document.getElementById("curp").value,
        })
            .then(res =>{
                if(res.status === 200){
                    alert('member saved in database')
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
                        <label>paternal surname</label>
                        <input 
                        disabled={disabled}
                        id="paSurname"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueAuthor}
                        />
                    </div>
                    <div className="form-group">
                        <label>maternal surname</label>
                        <input 
                        disabled={disabled}
                        id="maSurname"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueEdition}
                        />
                    </div>
                    <div className="form-group">
                        <label>email</label>
                        <input 
                        disabled={disabled}
                        id="email"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValuePublisher}
                        />
                    </div>
                    <div className="form-group">
                        <label>password</label>
                        <input 
                        disabled={disabled}
                        id="password"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueYear}
                        />
                    </div>
                    <div className="form-group">
                        <label>roles</label>
                        <input 
                        disabled={disabled}
                        id="roles"
                        type="text"
                        className="form-control"
                        required
                        defaultValue={this.props.defaultValueYear}
                        />
                    </div>
                    <div className="form-group">
                        <label>curp</label>
                        <input 
                        disabled={disabled}
                        id="curp"
                        type="text"
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