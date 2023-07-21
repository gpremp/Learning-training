import Bgimg from './static/image/backgroundImg.jpg'
import './App.css';
import {BrowserRouter,Route,Routes} from "react-router-dom";
import NewPost from './component/new-post';
import Home from './component/home';
import BlogDetails from './component/blog-details';
import UpdatePost from './component/update-blog';
import SignIn from './component/signIn';
import SignUp from './component/signup';

function App() {
  return (
    <div style={{ backgroundImage: `url(${Bgimg})`, position: 'fixed',top: 0, left: 0, width: '100%', height: '100%' }}>
    <BrowserRouter>
    <Routes>
    <Route path='/' element={<Home/>}/>
    <Route path='signIn' element={<SignIn/>}/>
    <Route path='signup' element={<SignUp/>}/>
      <Route path='post' element={<NewPost/>}/>
      <Route path='blog/:id' element={<BlogDetails/>}/>
      <Route path='blog/update/:id' element={<UpdatePost/>}/>
    </Routes>
    </BrowserRouter>

    </div>
  );
}

export default App;
