<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
#vendors {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#vendors td, #vendors th {
  border: 1px solid #ddd;
  padding: 8px;
}

#vendors tr:nth-child(even){background-color: #f2f2f2;}

#vendors tr:hover {background-color: #ddd;}

#vendors th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

</head>
<table id="vendors">
  <tr>
    <th>Vendor Id</th>
    <th>Vendor Name</th>
    <th>Street</th>
    <th>City</th>
    <th>State</th>
    <th>Email</th>
  </tr>
  
  <c:forEach var="temp" items="${vendors}">
  	<tr>
    <td>${temp.id}</td>
    <td>${temp.vendorName}</td>
    <td>${temp.street}</td>
    <td>${temp.city}</td>
    <td>${temp.state}</td>
    <td>${temp.email}</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>