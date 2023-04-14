<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="KVS Departmental Store">
    <meta name="keywords" content="html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>KVS Home</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        <div class="humberger__menu__widget">
            
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="./shop-grid.html">Shop</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="./shop-details.html">Shop Details</a></li>
                        <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                        <li><a href="./checkout.html">Check Out</a></li>
                        <li><a href="./blog-details.html">Blog Details</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/register/showRegistrationForm">Sign Up</a></li>
                <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> Sign Out</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
       
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
          
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="${pageContext.request.contextPath}/login_home">Home</a></li>
                            
                            
                            <!-- Customer navigation -->
                            <security:authorize access="hasRole('CUSTOMER')">
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="${pageContext.request.contextPath}/customer/viewOrders">Your Orders</a></li>
                            <li><a href="${pageContext.request.contextPath}/customer/viewCart"><i class="fa fa-shopping-bag"></i>Cart</a></li>
                            </security:authorize>
                            <!--li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> Sign Out</a></li-->
                            
                            <!--Staff navigation -->
                            <security:authorize access="hasRole('STAFF')">
                            <li><a href="#">Manage Online Orders</a>
                                <ul class="header__menu__dropdown">
                                    
                                    <li><a href="${pageContext.request.contextPath}/staff/viewProcessingOrders">Orders under process [DUE ORDERS]</a></li>
                                    <li><a href="${pageContext.request.contextPath}/staff/viewProcessedOrders">Processed Orders</a></li>
                                </ul>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/staff/viewCart"><i class="fa fa-shopping-bag"></i>Sale Cart</a></li>
                            </security:authorize>
                            
                            <!-- Admin navigation -->
                            <security:authorize access="hasRole('ADMIN')">
                            <li><a href="#">Manage Orders</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="${pageContext.request.contextPath}/admin/viewUnprocessedOrders">Unprocessed Orders</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/viewProcessingOrders">Orders under process</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/viewProcessedOrders">Processed Orders</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Manage Counters</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="${pageContext.request.contextPath}/admin/addOnlineCounter">Add Online Counter</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/viewOnlineCounters">View Online Counters</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/addOfflineCounter">Add Offline Counter</a></li>
                                    <li><a href="${pageContext.request.contextPath}/admin/viewOfflineCounters">View Offline Counters</a></li>
                                </ul>
                            </li>
                          
                            </security:authorize>
                            
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <div class="header__cart__price">
                        <!-- Add a logout button -->
                        	<form:form action="${pageContext.request.contextPath}/logout">
	
										<i class="fa fa-sign-out"></i><input type="submit" value="Sign out" class="site-btn" />
	
							</form:form>
						</div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    
    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
            
            <!-- Customer menu -->
                <security:authorize access="hasRole('CUSTOMER')">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Product Categories</span>
                        </div>
                        <ul>
                        <!-- loop over all categories -->
                        <c:forEach var="temp" items="${categories}">
                        
                        <!-- construct an update "link" with vendor id -->
							  
						<c:url var="viewLink" value="/customer/viewProducts">
							  			
							  	<c:param name="categoryId" value="${temp.id}" />
							  		
						</c:url>
						
                           <li><a href="${viewLink}"> ${temp.catName} </a></li>
                         </c:forEach>
                        </ul>
                    </div>
                </div>
                </security:authorize>
                
                <!-- Staff menu -->
                <security:authorize access="hasRole('STAFF')">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Product Categories</span>
                        </div>
                        <ul>
                        <!-- loop over all categories -->
                        <c:forEach var="temp" items="${categories}">
                        
                        <!-- construct an update "link" with vendor id -->
							  
						<c:url var="viewLink" value="/staff/viewProducts">
							  			
							  	<c:param name="categoryId" value="${temp.id}" />
							  		
						</c:url>
						
                           <li><a href="${viewLink}"> ${temp.catName} </a></li>
                         </c:forEach>
                        </ul>
                    </div>
                </div>
                </security:authorize>
                
                  <!-- Admin menu -->
                <security:authorize access="hasRole('ADMIN')">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Manage Store</span>
                        </div>
                        <ul>
                        	<li><h5><b>Customers and Sales</b></h5></li>
                        	<li><hr></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewCustomer"> View Customers </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewSales"> View Sales (offline) </a></li>
                            <li><hr></li>
                            <li><h5><b>Staffs</b></h5></li>
                        	<li><hr></li>
                            <li><a href="${pageContext.request.contextPath}/admin/addStaff"> Add Staff </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewStaff"> View Staffs </a></li>
                            <li><hr></li>
                            <li><h5><b>Vendors and Supplies</b></h5></li>
                        	<li><hr></li>
                            <li><a href="${pageContext.request.contextPath}/admin/addVendor"> Add Vendor </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewVendor"> View Vendors </a></li>
                           	<li><hr></li>
                            <li><h5><b>Products</b></h5></li>
                        	<li><hr></li>
                            <li><a href="${pageContext.request.contextPath}/admin/addCategory"> Add Product Category </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/addBrand"> Add New Brand </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/addProduct"> Add Product </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewCats"> View Product Categories </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewBrands"> View Brands </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewProducts"> View Products </a></li>
                            <li><hr></li>
                            <li><h5><b>Godowns</b></h5></li>
                        	<li><hr></li>
                            <li><a href="${pageContext.request.contextPath}/admin/addGodown"> Add Godown </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/viewGodown"> View Godowns </a></li>
                            
                            
                            
                         
                        </ul>
                    </div>
                </div>
                </security:authorize>
                
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <img src="${pageContext.request.contextPath}/resources/img/custom.png" alt="">
                                
                                <input type="text" placeholder="What do yo u need?">
                                <!--button type="submit" class="site-btn">SEARCH</button>-->
                             
                                
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+91 9064612414</h5>
                                <span>24/7 Support</span>
                            </div>
                        </div>
                    </div>
                    <div class="hero__item set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/hero/banner1.jpg">
                        <div class="hero__text">
                            <p style="color:dark-gray;font-size:160%"><b>KENDUADIHI VARIETY STORE</b></p>
                            <!--  <h2>WELCOME <br />${user.firstName}</h2> -->
                            <p><h2>WELCOME<br>${user.firstName}</h2></p>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->


    

    <!-- Blog Section Begin -->
    <section class="from-blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title from-blog__title">
                        <h2>Customer Reviews</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="${pageContext.request.contextPath}/resources/img/blog/blog-1.jpg" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> September 5,2020</li>
                                
                            </ul>
                            <h5><a href="#">Great Shopping Experience</a></h5>
                            <p>I had a great experience with KVS. The staffs are very friendly and the products are genuine. I look forward for more shopping. </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="${pageContext.request.contextPath}/resources/img/blog/blog-2.jpg" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> October 24,2020</li>
                                
                            </ul>
                            <h5><a href="#">Low Prices</a></h5>
                            <p>The prices of the same products of same brand costs more any other stores near my home. KVS provides the branded products with special discounts, which is great !!!</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="${pageContext.request.contextPath}/resources/img/blog/blog-3.jpg" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> November 13,2020</li>
                                
                            </ul>
                            <h5><a href="#">Trusted Shop</a></h5>
                            <p>I am a customer of KVS store for a long time. Now they are selling online which makes it more easy for us. Good luck KVS !</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.html"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address:<br>T.G. Samanta Road, Kenduadihi, Bankura, West Bengal - 722102</li>
                            <li>Phone: +91 9064612414</li>
                            <li>Email: kvs.bnk@gmail.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            
                        </ul>
                        <ul>
                            <li><a href="#">About Bankura</a></li>
                            <li><a href="#">About Our Shop</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Thank you for choosing us</h6>
                        <p>Connect with us in social media platforms</p>
                        <form action="#">
                            
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>  
        </div>
    </footer>
      <!-- Footer Section End -->
    	
    
    <!-- Js Plugins -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>


</body>

</html>









