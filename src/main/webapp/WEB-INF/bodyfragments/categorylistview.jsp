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
<title>Hotel List</title>
</head>
<body class="bg-image bgimage">

<div class="container">

<h2 style="padding: 30px">Category List</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark">
  <thead>
    <tr>
      <th scope="col">Category Name</th>    
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.catName}</td>
      <td>      
      <a href="${pageContext.request.contextPath}/catEdit?id=${li.id}">Edit</a>
      <a href="${pageContext.request.contextPath}/catDelete?id=${li.id}">Delete</a>          
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>