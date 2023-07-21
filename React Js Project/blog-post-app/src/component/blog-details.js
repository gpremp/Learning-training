import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../static/css/blog-details.css';
import Header from './header';
import img from '../static/image/like.png';
import Swal from 'sweetalert2';
import { useLocation, useParams, Link, useNavigate } from 'react-router-dom';
import { isLoggedIn } from '../auth/login-auth';
/**
 * Function to create a page to show blog details An option to like the blog and delete the blog
 * @returns Return BlogDetail function With HTML
 */
function BlogDetails(props) {
    const location = useLocation();
    let loginIn = isLoggedIn();
    let { id } = useParams();  // Id of blog
    const blog = location.state.blog; // Getting details of blog from state
    const navigate = useNavigate();
    /**
     * Function to ask whether to delete a blog or not,if yes delete the blog
     */
    const deleteBlog = () => {
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
          }).then((result) => {
            if (result.isConfirmed) {
            axios.delete(`http://localhost:8080/blog/${id}`)
              Swal.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
              )
              setTimeout(() => {
                navigate('/');
              }, 600);
             
            }
          })
    }
    /**
     * Function to add a like to blog
     */
    const addLike = () =>{
        location.state.blog.blogLike = blog.blogLike + 1;
        axios.post("http://localhost:8080/blog",blog).then(
            (response)=>{
                navigate(`/blog/${blog.id}`, {state:{blog: blog}})
            }
        )
        console.log(blog);
    }

    useEffect(() => {
        if(loginIn){
            navigate("/signIn");
          }
    }, []);
    return (
        <div>
            <Header />
            <div className="container">
                <div className="row justify-content-center">
                    <div className="col-7">

                        <ul class="nav">
                            <li class="nav-item"><h2><p>{blog.blogLike}</p></h2></li>
                            <li class="nav-item">
                                <button ><img src={img} alt="my image" onClick={addLike} /></button>
                            </li>
                            <li class="nav-item">
                                <Link to={`/blog/update/${id}`} state={{ blog: blog }} class="btn btn-success active"
                                    role="button" aria-pressed="true">Update</Link>
                            </li>
                            <li class="nav-item">
                                <button onClick={deleteBlog} class="btn btn-danger"
                                    role="button" aria-pressed="true">Delete</button>
                            </li>
                        </ul>
                        <div class="card">
                            <div class="card-header text-center">
                                <h3><p>{blog.title}</p></h3>
                            </div>
                            <div class="card-body">
                                <h5 class="card-title text-left">Catogory : {blog.category}</h5>
                                <p class="card-text text-center">{blog.content}</p>
                            </div>
                        </div>
                        <button onClick={()=>{navigate('/')}} class="btn btn-primary" type="button">Back</button>

                    </div>
                </div>
            </div>
        </div>
    )
}
export default BlogDetails;