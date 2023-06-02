import React, { useState, useEffect } from 'react';
import '../static/css/newPost.css';
import axios from 'axios';
import Header from './header';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';
/**
 * Function to create a page to add new blog into the database
 */
function NewPost() {
  const navigate = useNavigate();
  // Create a state variable for the form data
  const [blogData, setblogData] = useState({});
  // Create a state variable for the error data
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

  // Define an event handler for the form submission
  const handleSubmit = (event) => {
    event.preventDefault();
    setFormErrors(validate(blogData));
    setIsSubmit(true);

  };

  // Define an event handler for the input change
  const handleChange = (event) => {
    const { name, value } = event.target;
    setblogData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(blogData);
      submitBlog(blogData);
      // Reset the form data to an empty object
      setblogData({});
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.title) {
      errors.title = "Title is required!";
    }
    if (!values.category) {
      errors.category = "Category is required!";
    }
    if (!values.content) {
      errors.content = "content is required";
    }
    return errors;
  };
  // HTTP request to add new blog into the database
  const submitBlog = (data) => {
    axios.post("http://localhost:8080/blog", data).then(
      (response) => {
        console.log(response);
        Swal.fire("Success!", "New Blog Added!", "success");
      }
    )
  }


  return (
    <div className="container">
      <Header />
      <div className="row justify-content-center">
        <div className="col-7">
          <div class="card-header">
            <h3>Add new post</h3>
          </div>
          <form class="form" onSubmit={handleSubmit}>
            <label><b>Title</b></label>
            <input class="input" type="text" name="title" value={blogData.title || ''} onChange={handleChange} />
            <h6>{formErrors.title}</h6>
            <label><b>Categories</b></label>
            <input class="input" type="text" name="category" value={blogData.category || ''} onChange={handleChange} />
            <h6>{formErrors.category}</h6>
            <label><b>Content</b></label>
            <textarea class="form-control" name="content" value={blogData.content || ''} onChange={handleChange}></textarea>
            <h6>{formErrors.content}</h6>
            <button class="btn btn-success" type="submit">Add Post</button>
            <button onClick={()=>{navigate(-1)}} class="btn btn-primary" type="button">Cancel</button>
          </form>
        </div>
      </div>
    </div>
  );
}
export default NewPost;