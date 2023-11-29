<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog List</title>
</head>
<body>

<div class="container">

<h1 class="viewnews">Title: ${blog.title}</h1>
<h5 class="viewnews">Category: ${blog.catName}</h5>
<img alt="" src="${pageContext.request.contextPath}/getImage/${blog.id}" height="500px" width="500px">
<p class="viewnews">Description: ${blog.description}</p>

</div>
</body>
</html>