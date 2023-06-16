/**
  Funtion to show error if user provide wrong input
 */
func
function setError(error){
    document.getElementById("bookError").innerHTML = error
}

/**
  Fuction to clear error if user provide correct input.
 */
function clearErrors(){
     document.getElementById("bookError").innerHTML = "";
}

/**
  Fuction to validate user input data.
 */
function validate(){
    var formValidate = true;
    clearErrors();
    const bookName = document.getElementById("bookName").value;
    const booNameSplit = bookName.split(" ");
     const letterCheck = /^[a-zA-Z]+$/;
    for (let i = 0; i < booNameSplit.length; i++) {
        if(!(letterCheck.test(booNameSplit[i]))){
        setError("*Number not allowed");
        formValidate = false;
        return formValidate;
        }
    }
    return formValidate    
}
/**
  funtion to show sweet aleart to show message
 */
window.addEventListener('load',function(){
	let status = document.getElementById("bookAddStatus").value;
	if(status=="success"){
		swal("Good job!", "Book Added succesfully!", "success");
	}
});