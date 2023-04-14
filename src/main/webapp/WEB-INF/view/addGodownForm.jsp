<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Add Godown Form</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
		<style>
		.error {color:red}
	</style>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Add/Update Godown</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/admin/saveGodown" 
						  	   modelAttribute="godown"
						  	   method="POST"
						  	   class="form-horizontal">
					
						<!-- need to associate this data with godown id -->
						<form:hidden path="id" />
						
						
						
						<!-- Address -->
						<div style="margin-bottom: 5px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							<form:input type="text" path="street" placeholder="Street" class="form-control" />
						</div>
						<div style="margin-bottom: 5px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							<form:input required="required" type="text" path="city" placeholder="City" class="form-control" />
						</div>
						<div style="margin-bottom: 5px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							<form:input required="required" type="number" path="pin" placeholder="PIN" min="100000" class="form-control" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							<form:input required="required" type="text" path="state" placeholder="State" class="form-control" />
						</div>
				
						<!-- Phone -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-th-large"></i></span> 
							<form:input required="required" type="number" path="phone" placeholder="Phone Number (10 digits)" min="1000000000" class="form-control" />
						</div>
						
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-th-large"></i></span> 
							<input  type="number", name="inchargeId", placeholder="Incharge ID", value="${godown.incharge.userName}", min="1", class="form-control"/>
						</div>
				
						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</div>
						
					</form:form>
					
					<div style="clear; both;"></div>
					<p>
					<a href="${pageContext.request.contextPath}/login_home">Back to Home page</a>
					
					
					</p>

				</div>

			</div>

		</div>

	</div>

</body>
</html>