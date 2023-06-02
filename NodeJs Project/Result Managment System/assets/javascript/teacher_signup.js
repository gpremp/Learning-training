
/**
  Funtion to show error if user provide wrong input
 */
  function setError(id, error){
    element = document.getElementById(id);
    element.getElementsByClassName("formerror")[0].innerHTML = error;
}

/**
  Fuction to clear error if user provide correct input.
 */
function clearErrors(){
    errors = document.getElementsByClassName("formerror");
    for(let item of errors){
        item.innerHTML = "";
    }
}

/**
  Fuction to validate user input data.
 */
function validate(){
    var formValidate = true;
    clearErrors();
    const firstName = document.getElementById("fname").value;
    const lastName = document.getElementById("lname").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const repeatPassword = document.getElementById("repeatPassword").value;
    const emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    const letterCheck = /^[a-zA-Z]+$/;

    if(!firstName){
        setError("first_Name","*name can not be empty or null");
        formValidate = false
    }
    else if(!(letterCheck.test(firstName))){
        setError("first_Name","*Number not allowed");
        formValidate = false
    }
    if(!lastName){
        setError("last_name","*name can not be empty or null");
        formValidate = false
    }
   
    else if(!(letterCheck.test(lastName))){
        setError("last_name","*Number not allowed");
        formValidate = false
    }
    if(!email.match(emailformat)){
        setError("inputemail","*Email is not valid");
        formValidate = false
    }
    if(!(password==repeatPassword)){
	setError("inputPassword","*Password not matched");
	setError("inputRepeatpwd","*Password not matched");
        formValidate = false
  }
    return formValidate    
}
window.addEventListener('load',function(){
	let status = document.getElementById("status").value;
	if(status=="success"){
		swal("Good job!", "Account created succesfully!", "success");
	}
	if(status=="failed"){
		swal("You have already an account!", "Please SignIn!", "error");
	}
});