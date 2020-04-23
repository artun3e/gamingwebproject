<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User" %>
<%@ page import="cs308.sabanciuniv.edu.Games" %>
<head>
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

<!-- Template CSS and JS-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>
    <link rel="stylesheet" href="css/register.css">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/slick.css">
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/searchBar.css">
<script src="js/search.js"></script>
<script src="js/toDetails.js"></script>
<!-- Berkin CSS and JS-->
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="css/shoppingCart.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/shoppingCart.js"></script>
</head>
  <header id="site-header">
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

                    <li style="margin-left: 100%; margin-top: 12px;"><input id="search"  type="text" placeholder="Search.."  onkeydown="if (event.keyCode == 13) { search(); }"></li>
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
	<div class="main">

    <div class="container">
        <h1 class="cart">Shopping cart</h1>
        <h5 class="cart" style="margin-top: -1%;">
	            <%
					session = request.getSession();
					if(session.getAttribute("user") != null)
					{
					    Object obj = session.getAttribute("user");
					    User user = (User) obj;
					    out.print("Hello, " + user.getName());
					}
					else{
						out.print("Hello, you must login in order to give an order.");
					}
		    	%>
	    	</h5>

        <div class="container">
            <p style="margin-left: 5%;">

            </p>
            <section id="shopping_cart" class="products">
                <%
	        	System.out.println("We are in Cart Page");
	            if(request.getSession().getAttribute("cart") != null){
	               //The cart is NOT null. Thus there is some products in the cart. Let's display them.
	               //System.out.println("Cart has elements.");
	                Map<Games, Integer> cartMap = (HashMap)request.getSession().getAttribute("cart");

	                for(Games game : cartMap.keySet())
	                {
	                	out.println("<article class=\"product\">");
	                		out.println("<header>");
	                			out.println("<a  class=\"remove\">");
	                				out.println("<img src=\""+ game.getHeader_image() +" alt=\"\">");
	                				out.println("<h3>Remove product</h3>");
	                			out.println("</a>");
	                		out.println("</header>");
	                		out.println("<div class=\"content_info\">");	
	                			out.println("<h1 style=\"margin-bottom: -15px;\" class= \"product_name\" <a onclick=\"toDetails(this)\" href=\"#\">"+ game.getName() +"</h1>");	
	                			if(game.getShort_description() != null)
	                			{
	                				if(game.getShort_description().length() > 200){
		                				out.println(game.getShort_description().substring(0, 200) + "...");
	                				}
	                				else{
	                					out.println(game.getShort_description());
	                				}
	                			}
	                			else
	                			{
	                				out.println(game.getShort_description());
	                			}
	                		out.println("</div>");	
	                		out.println("<footer class=\"content\">");	
	                			out.println("<span class=\"qt-minus\">-</span>");
	                			out.println("<span class=\"qt\">"+ cartMap.get(game) +"</span>");
	                			out.println("<span class=\"qt-plus\">+</span>");
	                			out.println("<h2 class=\"full-price\"> "+ cartMap.get(game)*game.getPrice() + "$</h2>");
	                			out.println("<h2 class=\"price\"> "+ game.getPrice() +"$</h2>");
	                		out.println("</footer>");	
	                	out.println("</article>");
	                   //System.out.println(game.getName() + ": " + cartMap.get(game));
	                   //out.println(game.getName() + ": " + cartMap.get(game) + "</br>");
	                }
	            }
			%>
            </section>
        </div>
        <footer id="site-footer">
            <div class="container clearfix">
                <div class="left">
                    <h2 class="subtotal">Subtotal: <span>0</span>$</h2>
                    <h3 class="tax">Taxes (5%): <span>0</span>$</h3>
                    <h3 class="shipping">Shipping: <span>0</span>$</h3>
                </div>
                <div class="right">
                    <h1 class="total">Total: <span>0</span>$</h1>
                    <form action="placeorder" method="post">
                        <a class="btn">Checkout</a>
                    </form>
                </div>
            </div>

        </footer>
    </div>

    </header>

    <body>

</div>
</body>
	</body>  


</html>