import React, { Component } from 'react';
import './App.css';
import axios from 'axios';

class App extends Component {
  constructor(props){
    super(props);

    this.submitStudent = this.submitStudent.bind(this);
    this.onChange      = this.onChange.bind(this);

    this.state={
      Name: "",
      studentList: [],
    }
  }

  componentWillMount(){
    this.getAllStudents();
  }

  getAllStudents(){
    const config = {
      method: "get",
      url:  "http://localhost:8081/studentrecord",
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*"
      }
    };
    axios.request(config).then(function(response){
      console.log(response);
      let { studentList } = this.state;
      studentList = response.data;
      this.setState({
        studentList: studentList
      })
    }.bind(this))
    .catch(function(error){
      console.log(error)
    })
  }

  submitStudent(e){
    e.preventDefault();
    let requestData = this.state.Name;
    let requestObject = { name: requestData }
    const config={
      method: "post",
      data: requestObject,
      url: "/addstudent",
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*"
      }
    }
    axios.request(config).then(function(response){
      let {studentList} = this.state;
      studentList.push(response.data);
      this.setState({
        studentList : studentList
      })
    }.bind(this))
  }

  onChange(event){
    this.setState({
      Name : event.target.value
      // [event.target.name]: event.target.value
    })
  }

  render() {
    return (
      <div>
        <div name="input form">
          <form onSubmit={this.submitStudent}>
            <input name="Name" placeholder="Enter your name" value={this.state.Name} onChange={this.onChange} />
            <button type="submit" >submit</button>
          </form>
        </div>
        <div name="student_list">
          {
            this.state.studentList && this.state.studentList.length>0 &&
            this.state.studentList.map(student=>{
              return <div>student id = {student.id} and student name = {student.name}</div>
            })
          }
        </div>
      </div>
    );
  }
}

export default App;
