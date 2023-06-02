/**
  funtion for sweet aleart and form to delete a book from database
 */
  function deleteStudent(studentId) {
    console.log(studentId)
	swal({
		title: "Are you sure?",
		text: "Once deleted, you will not be able to recover this book details!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				let form = document.createElement("form");
				document.body.appendChild(form);
				form.action = `/deleteStudent/${studentId}`;
				form.submit();
				swal("Your book details has been deleted!", {
					icon: "success",
				});
			} else {
				swal("Your book details is safe!");
			}
		});
}
/**
 * Function to redirect into student update page with student ID
 * @param {*} studentId 
 */
function editStudent(studentId) {
    console.log(studentId)
	let form = document.createElement("form");
	document.body.appendChild(form);
	form.action = `/teacher/updateStudent/${studentId}`;
	form.submit();
}