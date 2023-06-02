import React from 'react';
import { Button } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import { useNavigate, Link } from 'react-router-dom';
import Navbar from 'react-bootstrap/Navbar';

/**
 * Function to attach a header into the web page with add new block and home button
 */
function Header() {
  const navigate = useNavigate();
  const newPost = () => {
    navigate('/post')
  }
  return (
    <div>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">
            Blog Post App
          </Navbar.Brand>
          <Navbar.Collapse className="justify-content-end">
            <Link to={'/'} class="btn btn-outline-dark active">Home</Link>
            <Button onClick={newPost} class="btn btn-success active">New Post</Button>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
}

export default Header;