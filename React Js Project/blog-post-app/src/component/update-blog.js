import React, { useState, useEffect } from 'react';
import '../static/css/newPost.css';
import axios from 'axios';
import Header from './header';
import Swal from 'sweetalert2';
import { useLocation, useParams, useNavigate } from 'react-router-dom';
import { isLoggedIn } from '../auth/login-auth';

/**
 * function to create update blog page
 */
function UpdatePost() {
  const location = useLocation();
  let loginIn = isLoggedIn();
  let { id } = useParams(); // Represent the id of blog
  const blog = location.state.blog;
  // Create a state variable for the form data
  const [blogData, setblogData] = useState({
    id: blog.id, title: blog.title, category: blog.category, content: blog.content, blogLike: blog.blogLike
  });
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  const navigate = useNavigate();

  // Define an event handler for the form submission
  const handleSubmit = (event) => {
    event.preventDefault();
    setIsSubmit(true);
    setFormErrors(validate(blogData));
    if(isSubmit){
      submitBlog(blogData);
    }
  };

  // Define an event handler for the input change
  const handleChange = (event) => {
    const { name, value } = event.target;
    setblogData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };
  // Function to create form errors
  const validate = (values) => {
    const errors = {};
    if (!values.title) {
      setIsSubmit(false);
      errors.title = "Title is required!";
    }
    if (!values.category) {
      setIsSubmit(false);
      errors.category = "Category is required!";
    }
    if (!values.content) {
      setIsSubmit(false);
      errors.content = "content is required";
    }
    return errors;
  };
  // HTTP request to update the blog into database
  const submitBlog = (data) => {
    console.log(data);
    axios.put("http://localhost:8080/blog", data).then(
      (response) => {
        Swal.fire("Success!", "Blog Updated Successfully!", "success");
        navigate(`/blog/${blog.id}`, { state: { blog: blogData } })
      }
    )
  }

  useEffect(() => {
    if(loginIn){
      navigate("/signIn");
    }
}, []);

  return (
    <div className="container">
      <Header />
      <div className="row justify-content-center">
        <div className="col-7">
          <div class="card-header">
            <h3 className='text-center'>Update post</h3>
          </div>
          <form class="form" onSubmit={handleSubmit}>
            <label><b>Title</b></label>
            <input class="input" type="text" name="title" value={blogData.title} onChange={handleChange} />
            <h6>{formErrors.title}</h6>
            <label><b>Categories</b></label>
            <input class="input" type="text" name="category" value={blogData.category} onChange={handleChange} />
            <h6>{formErrors.category}</h6>
            <label><b>Content</b></label>
            <textarea class="form-control" name="content" value={blogData.content} onChange={handleChange}></textarea>
            <h6>{formErrors.content}</h6>
            <button class="btn btn-success" type="submit">Update Post</button>
            <button onClick={() => { navigate(-1) }} class="btn btn-primary" type="button">Cancel</button>

          </form>
        </div>
      </div>
    </div>
  );
}
export default UpdatePost;