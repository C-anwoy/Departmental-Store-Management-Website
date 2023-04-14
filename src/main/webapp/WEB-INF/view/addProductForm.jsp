<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Add/Update Product Form</title>
	
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
					<div class="panel-title">Add/Update Product</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form action="${pageContext.request.contextPath}/admin/saveProduct" 
						
						  	   method="POST"
						  	   class="form-horizontal">
					

						
						<!-- Product name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
		
							<input required type="text" name="productName" placeholder="Name of the Product" class="form-control" />
						</div>
						
						<!-- Product Description -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<input required type="text" name="productDes" placeholder="Product Description" class="form-control" />
						</div>
						
						<!-- Product Category -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<select required name="category" class="form-control">
                  					
                  					<!-- loop over all categories -->
                  				<option value="none" selected disabled hidden>Choose Product Category</option>
                        		<c:forEach var="temp" items="${categories}">
                  					<option value="${temp.catName}" label="${temp.catName}"/>
                         		</c:forEach>
                         
							</select>
						</div>
						
						<!-- Product Brands -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<select required name="brand" class="form-control">
								<!-- loop over all brands -->
								<option value="none" selected disabled hidden>Choose Brand</option>
                        		<c:forEach var="temp" items="${brands}">
                  					<option value="${temp.brandName}" label="${temp.brandName}"/>
                         		</c:forEach> 
							</select>
						</div>
						
						<!-- MRP -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<input required type="number" name="MRP" placeholder="MRP (in Rs.)" min="1" class="form-control" />
						</div>
						
						<!-- Quantity in stock -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<input required type="number" name="quantity" placeholder="Quantity in Stock" min="0" class="form-control" />
						</div>
						
						<!-- Godown -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span> 
							
							<select required name="godown" class="form-control">
								<!-- loop over all brands -->
								<option value="none" selected disabled hidden>Select Godown Id</option>
                        		<c:forEach var="temp" items="${godowns}">
                  					<option value="${temp.id}" label="${temp.id}"/>
                         		</c:forEach> 
							</select>
						</div>
						

						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</div>
						
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