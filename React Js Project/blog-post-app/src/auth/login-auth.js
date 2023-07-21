export  function doLogin(data){
    localStorage.setItem("email",JSON.stringify(data));
}

export  function isLoggedIn(){
    let data = localStorage.getItem("email");
    // console.log(data);
    if(data==null || data==="" || data===undefined){
        return true;
    }
    else{
        return false;
    }
}

export  function isLogOut(){
    localStorage.removeItem("email");
    console.log(localStorage.removeItem("email"))
}