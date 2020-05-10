<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User" %>
<head>
    <meta charset="utf-8">
    <title>Login!</title>
    <meta name="description"
          content="You Can Freely Buy The Best Goods on the Internet">
    <meta name="author" content="CS308">

    <!-- Deniz CSS and JS-->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <!-- Berkin CSS and JS-->
    <script src="js/search.js"></script>
        <script src="js/toDetails.js"></script>
        <script src="js/results.js"></script>
    <link rel="stylesheet" href="css/register.css">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/slick.css">
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/searchBar.css">
    <script type="text/javascript" src="js/register.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta charset="UTF-8">
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container" style="margin-right: center;">
            <a class="navbar-brand" href="index.jsp" style="margin-top: 6px;"> <img src="img/logo.png" width="34" height="34" class="d-inline-block align-top" alt="" style="margin-top: -6px;"> Tech Market </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
  					<li class="dropdown"><a class="nav-link" href="#" value="Action"></a></li>
                    <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="Multiplayer"></a></li>
                    <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="Sports"></a></li>
                    <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="FPS"></a></li>
                    <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="RPG"></a></li>
                    <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="Strategy"></span></a>

                    <li style="margin-left: 100%; margin-top: 12px;"><input id="search"  type="text" placeholder="What are you looking for?"  onkeydown="if (event.keyCode == 13) { search(); }"></li>
                    <li class="dropdown" style="margin-left: 5%;">
                    	<a class="fa fa-user" style="font-size: 34px; color: grey;"></a>

                        <div class="dropdown-content">
                        	<% 
                        		session = request.getSession();
                        		if(session.getAttribute("user") != null)
	                        	{
                        			/* out.println("<a href=\"#account\">Account</a>");
                        			out.println("<a href=\"#liked\">Liked Ones</a>"); */
                        			out.println("<a href=\"myOrders.jsp\">My Orders</a>");
                        			out.println("<a onclick=\"Log_User_Out(this)\" href=\"#\">Logout</a>");
	                        	}
                        		else{
                        			out.println("<a href=\"login.jsp\">Login</a>");
                        			out.println("<a href=\"register.jsp\">Register</a>");
                        		}
                        	%>
                        </div>
                     </li>
                     <li class="dropdown" style="margin-left: 5%;">
                    	<a class="fa fa-shopping-cart" href="shoppingCart.jsp" style="font-size: 34px; color: grey;"></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<body>
	<div class="main">
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <!-- ASIDE -->
                    <div id="aside" class="col-md-3">
                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Categories</h3>
                            <div class="checkbox-filter">

                                <div class="input-checkbox">
                                    <input type="checkbox" id="category-1">
                                    <label for="category-1">
                                        <span></span>
                                        Laptops
                                        <small>(120)</small>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <!-- /aside Widget -->

                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Price</h3>
                            <div class="price-filter">
                                <div id="price-slider"></div>
                                <div class="input-number price-min">
                                    <input id="price-min" type="number">
                                    <span class="qty-up">+</span>
                                    <span class="qty-down">-</span>
                                </div>
                                <span>-</span>
                                <div class="input-number price-max">
                                    <input id="price-max" type="number">
                                    <span class="qty-up">+</span>
                                    <span class="qty-down">-</span>
                                </div>
                                <br>
                                <button onClick="filter(document.getElementById('price-min').value,document.getElementById('price-max').value)"> Filter</button>
                            </div>
                        </div>
                        <!-- /aside Widget -->

                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">RATINGS</h3>
                            <div class="checkbox-filter">
                                <div class="input-checkbox" >
                                    <input type="checkbox" id="5stars" onclick="ratingCheckbox()">
                                    <label for="5stars">
                                        <span></span>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <small></small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="4stars" onclick="ratingCheckbox()">
                                    <label for="4stars">
                                        <span></span>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <small></small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="3stars" onclick="ratingCheckbox()">
                                    <label for="3stars">
                                        <span></span>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>

                                        <small></small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="2stars" onclick="ratingCheckbox()">
                                    <label for="2stars">
                                        <span></span>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <small></small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="1star" onclick="ratingCheckbox()">
                                    <label for="1star">
                                        <span></span>
                                        <i class="fa fa-star"></i>
                                        <small></small>
                                    </label>
                                </div>

                            </div>
                        </div>
                        <!-- /aside Widget -->

                        <!-- aside Widget -->
                        <!-- <div class="aside">
                            <h3 class="aside-title">Top selling</h3>
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="./img/product01.png" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">Category</p>
                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                </div>
                            </div>

                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="./img/product02.png" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">Category</p>
                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                </div>
                            </div>

                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="./img/product03.png" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">Category</p>
                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                </div>
                            </div>
                        </div> -->
                        <!-- /aside Widget -->
                    </div>
                    <!-- /ASIDE -->

                    <!-- STORE -->
                    <div id="store" class="col-md-9">
                        <!-- store top filter -->
                        <div class="store-filter clearfix">
                            <div class="store-sort">
                                <label>
                                    Sort By:
                                    <select class="input-select" onChange="sortByPrice(this.value)">
                                        <option value="p-asc"> Price (Ascending)</option>
                                        <option value="p-desc"> Price (Descending)</option>
                                        <option value="r-asc"> Rating (Ascending)</option>
                                        <option value="r-desc"> Rating (Descending)</option>
                                    </select>
                                </label>

<!--                                 <label>
                                    Show:
                                    <select class="input-select">
                                        <option value="0">20</option>
                                        <option value="1">50</option>
                                    </select>
                                </label> -->
                            </div>
                        </div>
                        <!-- /store top filter -->

                        <!-- store products -->
                        <div class="row">
						
						</div>

<!--                         store bottom filter
                        <div class="store-filter clearfix">
                            <span class="store-qty">Showing 20-100 products</span>
                            <ul class="store-pagination">
                                <li class="active">1</li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                            </ul>
                        </div>
                        /store bottom filter -->
                    </div>
                    <!-- /STORE -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->
    </div>
</body>
</body>
<footer> </footer>
</html>
