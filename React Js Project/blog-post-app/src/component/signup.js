import { useState } from "react";
import axios from "axios";
import '../static/css/signup.css';
import Header from "./header";
import Swal from "sweetalert2";
import { useNavigate } from "react-router-dom";

function SignUp(){
    const navigate = useNavigate();
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  
    const handleNameChange = (event) => {
      setName(event.target.value);
    };
  
    const handleEmailChange = (event) => {
      setEmail(event.target.value);
    };
  
    const handlePasswordChange = (event) => {
      setPassword(event.target.value);
    };
  
    const handleSubmit = (event) => {
      event.preventDefault();
      setIsSubmit(true);
      // Perform signup logic here
      console.log('Name:', name);
      console.log('Email:', email);
      console.log('Password:', password);
      const user = {
        name:name,
        email:email,
        password:password
      }
      setFormErrors(validate(user));
      if(isSubmit){
        axios.post("http://localhost:8080/user", user).then(
        (response) => {
          console.log(response.data);
          if(response.data==="success"){
            Swal.fire("Success!", "User Added successfully!", "success");
            navigate("/signIn")
            // Reset the form
        setName('');
        setEmail('');
        setPassword('');
          }
          else{
            Swal.fire("You have already an account!", "Please SignIn!", "error");
          }
         
        }
      )
      }
    };
    function isSentenceValid(sentence) {
        const words = sentence.split(' ');
      
        return words.some((word) => /\d/.test(word));
      }
    const validate = (values) => {
        const emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        const letterCheck = /^[a-zA-Z]+$/;
        const errors = {};
        if (!values.name) {
          setIsSubmit(false);
          errors.name = "Name is required!";
        }
        if(isSentenceValid(values.name)){
            errors.name = "*Number not allowed";
        }
        if (!values.email.match(emailformat)) {
          setIsSubmit(false);
          errors.email = "Email is not valid!";
        }
        if (!values.password) {
          setIsSubmit(false);
          errors.password = "Password is required";
        }
        return errors;
      };
    return(
        <div>
            <Header/>
            <div className="signup-form-container">
      <h2>Sign Up</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            placeholder="Enter your name"
            value={name}
            onChange={handleNameChange}
            required
          />
          <h6>{formErrors.name}</h6>
        </div>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            placeholder="Enter your email"
            value={email}
            onChange={handleEmailChange}
            required
          />
          <h6>{formErrors.email}</h6>
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            placeholder="Enter your password"
            value={password}
            onChange={handlePasswordChange}
            required
          />
          <h6>{formErrors.password}</h6>
        </div>
        <button type="submit">Sign Up</button>
      </form>
    </div>
        </div>
    )
}

export default SignUp;