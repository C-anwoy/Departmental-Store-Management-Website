<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Add Supply Form</title>
	
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
					<div class="panel-title">Add Supply</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form action="${pageContext.request.contextPath}/admin/saveSupply" 
						
						  	   method="POST"
						  	   class="form-horizontal">
					

						
						<!-- Batch Number -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
		
							<input required type="number" name="batchNo" placeholder="Batch Number" min="1" class="form-control" />
						</div>
						
						<!-- Product Id -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<input required type="number" name="productId" placeholder="Product ID" min="1" class="form-control" />
						</div>
						
						
						<!-- Quantity Supplied -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<input required type="number" name="quantity" placeholder="Quantity Supplied" min="1" class="form-control" />
						</div>
						
						<!-- Supply Date -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<input required type="text" name="supplyDate" placeholder="Date of Supply" onfocus="(this.type= 'date')" class="form-control" />
						</div>
						
						<!-- Expiry Date -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<input type="text" name="expiryDate" placeholder="Date of Expiry" onfocus="(this.type= 'date')" class="form-control" />
						</div>
						

						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</div>
						
						<input type="hidden"
								name="vendorId"
								value="${vendor.id}" />
						<!-- Manually add csrf token -->
						
						<input type="hidden"
								name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						
					</form>
					
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