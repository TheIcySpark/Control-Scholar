import axios from "axios";
import { Component } from "react";


export default class Profile extends Component{

    constructor(props){
        super(props)
        this.state = {isLoading: true, data: undefined}
    }

    componentDidMount(){
        axios.get('http://localhost:8080/api/member/get/' + localStorage.getItem('id'))
            .then(res =>{
                if(res.status === 200){
                    this.setState({data: res.data})
                    this.setState({isLoading: false})
                    localStorage.setItem('location', res.data.learningCenter.location)
                }
            })
            .catch(err =>{
                alert(err)
            })
    }

    render(){
        if(this.state.isLoading){
            return <div>Loading ...</div>
        }

        return(
            <div>
                <form>
                    <div className="form-group">
                        <label>Email address</label>
                        <input 
                        type="email"
                        className="form-control"
                        defaultValue={this.state.data.email}
                        />
                    </div>
                    <div className="form-group">
                        <label>id</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        defaultValue={this.state.data.id}
                        />
                    </div>
                    <div className="form-group">
                        <label>curp</label>
                        <input 
                        type="text" 
                        className="form-control"
                        defaultValue={this.state.data.curp}
                        />
                    </div>
                    <div className="form-group">
                        <label>name</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        defaultValue={this.state.data.name}
                        />
                    </div>
                    <div className="form-group">
                        <label>paternal surname</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        defaultValue={this.state.data.paSurname}
                        />
                    </div>
                    <div className="form-group">
                        <label>maternal surname</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        defaultValue={this.state.data.maSurname}
                        />
                    </div>
                    <div className="form-group">
                        <label>roles</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        defaultValue={this.state.data.roles}
                        />
                    </div>
                    <div className="form-group">
                        <label>learning center location</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        defaultValue={this.state.data.learningCenter.location}
                        />
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        )
    }
}