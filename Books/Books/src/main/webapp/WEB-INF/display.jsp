<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Title Here</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <style>
        #a {
            text-align: right;
        }

        body {
            width: 100%;
            height: 100vh;
        }

        #bo {
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }

        #add {
            color: rgb(255, 119, 0);
            font-size: 30px;
        }

        a {
            text-decoration: none;
        }
        #ss{
        	display:flex;
        	justify-content: center;
        	align-items: center;
        	margin-bottom: 40px;
        	
        }
        #mySearch{
        	padding: 10px 30px;
        	font-size: 15px;
        	
        }
        #s{
        	
        	font-size: 20px;
        }
        #back{
        	display:flex;
        	justify-content: center;
        	align-items: center;
        	margin-top: 30px;
        	font-size: 35px;
        	font-family: sans-serif;
        }
    </style>
</head>
<body>

    <h2 style="text-align: center; color: blue;">WELCOME TO OUR LIBRARY</h2>
  <!--   <s:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/demo" user="root" password="root"/>
    <s:query var="rs" dataSource="${db}">select*from Books</s:query>
    <c:forEach items="${rs.rows}" var="r">
    	<c:out value="${r.book_name}"></c:out>
    </c:forEach>
    
    <h2>hello</h2> -->
    
   
    <form action="bookSearch" id="ss">
        <input type="text" id="mySearch" name="searchTerm" placeholder="Search by book name" />&nbsp;&nbsp;
       <input type="submit" value="search" id="s">
   </form>
    <div id="bo">
        <table border="1" id="b" width="50%">
            <tr style="color: green;">
                <th id="a" colspan="6"><a id="add" href="form">ADD BOOK</a></th>
            </tr>
            <tr>
            	
                <th>book_id</th>
                <th>book_name</th>
                <th>book_author</th>
                <th>author_contact</th>
                <th colspan="2">Actions</th>
            </tr>

            <c:forEach var="book" items="${details}">
                <tr class="book-row">
                    <td>${book.book_id}</td>
                    <td>${book.book_name}</td>
                    <td>${book.book_author}</td>
                    <td>${book.author_contact}</td>
                    <td><a style="color: blue;" href="update/?book_id=${book.book_id}">EDIT</a></td>
                    <td><a style="color: red;" href="remove/?book_id=${book.book_id}">REMOVE</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
	<a href="back" id="back">BACK</a>
   
</body>
</html>
