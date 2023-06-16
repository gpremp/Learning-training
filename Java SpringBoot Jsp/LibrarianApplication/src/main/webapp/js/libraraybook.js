/**
  funtion for sweet aleart and form to delete a book from database
 */
function deleteBook(bookId) {
	swal({
		title: "Are you sure?",
		text: "Once deleted, you will not be able to recover this book details!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				var form = document.createElement("form");
				document.body.appendChild(form);
				form.action = "deletebook";
				var element1 = document.createElement("INPUT");
				element1.name = "bookId"
				element1.value = bookId;
				element1.type = 'hidden'
				form.appendChild(element1);
				form.submit();
				swal("Your book details has been deleted!", {
					icon: "success",
				});
			} else {
				swal("Your book details is safe!");
			}
		});
}