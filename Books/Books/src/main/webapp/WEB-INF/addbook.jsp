<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    .error {
        color: red;
        display: none;
    }
</style>
</head>
<body>
	<form action="${book==null? 'savebook':'updatebook'}" method="post" id="bookForm">
		<input type="number" name="book_id" placeholder="book_id" value="${book.book_id}"><br>
		<input type="tel" id="mobile" name="author_contact" placeholder="author contact" value="${book.author_contact}"><br>
		<span id="lblError" class="error">Invalid Mobile Number.</span>
		<input type="text" name="book_author" placeholder="author name" value="${book.book_author}"><br>
		<input type="text" name="book_name" placeholder="book name" value="${book.book_name}"><br>
		<input type="submit" value="addBook" id="btnsubmit"><br>
	</form>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#bookForm").submit(function (event) {
				var regex = /^(0|91)?[6-9][0-9]{9}$/;
				if (!regex.test($("#mobile").val())) {
					$("#lblError").css({
						"display": "block"
					});     
					event.preventDefault(); 
				} 
				else {
					$("#lblError").css("display", "none");
				}
			});
		});
	</script>

</body>
</html>
