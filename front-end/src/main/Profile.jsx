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
                    console.log(res.data)
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
                        />
                    </div>
                    <div className="form-group">
                        <label>curp</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        />
                    </div>
                    <div className="form-group">
                        <label>name</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        />
                    </div>
                    <div className="form-group">
                        <label>paternal surname</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        />
                    </div>
                    <div className="form-group">
                        <label>maternal surname</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        />
                    </div>
                    <div className="form-group">
                        <label>password</label>
                        <input 
                        type="password" 
                        className="form-control" 
                        />
                    </div>
                    <div className="form-group">
                        <label>roles</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        />
                    </div>
                    <div className="form-group">
                        <label>learning center location</label>
                        <input 
                        type="text" 
                        className="form-control" 
                        />
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        )
    }
}