<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Checkout</title>

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
            <div class="header__top__right__language">
                <img src="${pageContext.request.contextPath}/resources/img/language.png" alt="">
                <div>English</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Spanis</a></li>
                    <li><a href="#">English</a></li>
                </ul>
            </div>
            <div class="header__top__right__auth">
                <a href="#"><i class="fa fa-user"></i> Login</a>
            </div>
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
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                <li>Free Shipping for all Order of $99</li>
            </ul>
        </div>
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
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="#">Fresh Meat</a></li>
                            <li><a href="#">Vegetables</a></li>
                            <li><a href="#">Fruit & Nut Gifts</a></li>
                            <li><a href="#">Fresh Berries</a></li>
                            <li><a href="#">Ocean Foods</a></li>
                            <li><a href="#">Butter & Eggs</a></li>
                            <li><a href="#">Fastfood</a></li>
                            <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Checkout</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Checkout</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            
            <div class="checkout__form">
                <h4>Sale Details</h4>
                <form action="${pageContext.request.contextPath}/staff/processSale" method="POST">
                   
                        
                        <div class="col-lg-6 col-md-8">
                            <div class="checkout__order">
                                <h4>Your Sale</h4>
                                <div class="checkout__order__products">Products <span>Total</span></div>
                                
                                <ul>
                                	<c:forEach var="temp" items="${products}">
                                    <li>${temp.p.primaryKey.product.productName} - ${temp.p.primaryKey.product.brand.brandName} <span>Rs. ${temp.total}</span></li>
                                    </c:forEach>
                                </ul>
                                <div class="checkout__order__subtotal">Subtotal <span>Rs. ${total}</span></div>
                                <div class="checkout__order__total">Total <span>Rs. ${total}</span></div>
                                <div class="checkout__input__checkbox">
                                    <p>
                                        Choose Payment Method:
                                        
                                    </p>
                                </div>
                                <div class="checkout__input__checkbox">
                                    <input required type="radio" id="cod" name="payment_method" value="cod">
  									<label for="cod">Cash On Delivery</label><br>
  									<input required type="radio" id="ePayment" name="payment_method" value="ePayment">
  									<label for="ePayment">Online Payment</label>
                                </div>
                                <div class="checkout__input__checkbox">
                                    <label for="customerId">Enter Customer ID:</label>
                                    <input required type="number" id="customerId" name="customerId" min="1">
  									
                                </div>
                                <button type="submit" class="site-btn">PROCESS SALE</button>
                            </div>
                        </div>
                    </div>
                    <!-- Manually add csrf token -->
						<input type="hidden"
								name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->
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