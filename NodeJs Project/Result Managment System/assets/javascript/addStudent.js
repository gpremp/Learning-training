
/**
  Funtion to show error if user provide wrong input
 */
  function setError(id, error){
    element = document.getElementById(id);
    element.innerHTML = error;
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
    const name = document.getElementById("name").value;
    const rollNo = document.getElementById("rollNo").value;
    const score = document.getElementById("score").value;
    const letterCheck = /^[a-zA-Z]+$/;
    const nameArray = name.split(" ");

    nameArray.forEach(function (item){
        if(!item){
            setError("nameError","*name can not be empty or null");
            formValidate = false
        }
        else if(!(letterCheck.test(item))){
            setError("nameError","*Number not allowed");
            formValidate = false
        }
    })
    if(rollNo<=0){
        setError("rollNoError","*Rollno can not be negative");
        formValidate = false
    }
    if(score<=0){
        setError("scoreError","*score can not be nagative");
        formValidate = false
    }
   
    return formValidate    
}
window.addEventListener('load',function(){
	let status = document.getElementById("status").value;
	if(status=="success"){
		swal("Success!", "Student added succesfully!", "success");
	}
	if(status=="failed"){
		swal("RollNo already exits!", "Try Again!", "error");
	}
});