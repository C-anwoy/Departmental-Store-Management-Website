<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Add/Update Vendor Form</title>
	
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
					<div class="panel-title">Add/Update Vendor Details</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/admin/saveVendor" 
						  	   modelAttribute="vendor"
						  	   method="POST"
						  	   class="form-horizontal">
					
						<!-- need to associate this data with vendor id -->
						<form:hidden path="id" />

						
						<!-- Vendor name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="vendorName" cssClass="error" />
							<form:input path="vendorName" placeholder="Name of Vendor" class="form-control" />
						</div>
						
						<!-- Address -->
						<div style="margin-bottom: 5px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							<form:input path="street" placeholder="Street" class="form-control" />
						</div>
						<div style="margin-bottom: 5px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							<form:input path="city" placeholder="City" class="form-control" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							<form:input path="state" placeholder="State" class="form-control" />
						</div>
				
						<!-- Email -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span> 
							<form:errors path="email" cssClass="error" />
							<form:input path="email" placeholder="Email" class="form-control" />
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