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

<body class="bg-image bgimage">
<div class="container">
<h2 style="padding: 30px">Blogs List</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark">
  <thead>
    <tr>
      <th scope="col">Title</th> 
      <th scope="col">Description</th> 
      <th scope="col">Category</th>    
       <th scope="col">Image</th> 
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>    
      <td>${li.title}</td>
      <td>${li.description}</td> 
      <td>${li.catName}</td>
      <td><img alt="" src="${pageContext.request.contextPath}/getImage/${li.id}" height="100px" width="100px"></td>
      <td>    
      
      <c:choose>
      <c:when test="${sessionScope.user.userRole == 'Admin' }">
      
      <a href="${pageContext.request.contextPath}/blogEdit?id=${li.id}">Edit</a>
      <a href="${pageContext.request.contextPath}/blogDelete?id=${li.id}">Delete</a> 
      </c:when>
      <c:otherwise>
         <a href="${pageContext.request.contextPath}/viewBlog?id=${li.id}">View</a>
      </c:otherwise>
     
      </c:choose>
        
           
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>