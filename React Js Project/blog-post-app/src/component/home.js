import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../static/css/home.css';
import Header from './header';
import { Link } from "react-router-dom";

/**
 * Function to create a home page with List of all blogs
 * @returns 
 */
function Home() {
    const [blogs, setBlogs] = useState([]);
    useEffect(() => {
        // HTTP request to get list of all blogs from database
        axios.get("http://localhost:8080/blogs").then(
            (data) => {
                console.log(data.data);
                setBlogs(data.data);
            }
        )
    }, []);


    return (
        <div>
            <Header />
            <div className="container">
                <div className="row justify-content-center">
                    <div className="col-7">
                        <div class="card-header">
                            <h3>All Post</h3>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        <p>Blog Title</p>
                                    </th>
                                    <th className='action'>
                                        <p>Action</p>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    blogs.map(
                                        blog =>
                                            <tr key={blog.id}>
                                                <th><p>{blog.title}</p></th>
                                                <th className='action'>
                                                    <Link to={`/blog/${blog.id}`} state={{ blog: blog }} class="btn btn-success active"
                                                        role="button" aria-pressed="true">select</Link>
                                                </th>
                                            </tr>

                                    )
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}
export default Home;