<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<!DOCTYPE html>
<html>
<head>

<style>
title{
color:white;
}
.accordion {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #ccc; 
}

.total {
font-size:40px;
font-weight:bold;
}

.box {
border:3px solid black;
  background-color: #E8A2A2;
  background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQfbeY07Hj35CsKASs4BAyDuaAGBg-GOxVpws5yqFBILOgaFySW&usqp=CAU");
  
  color: white;
  margin: 20px;
  padding: 20px;
}
</style>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
	<link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="./vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,700">
	<link href="./vendor/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>	
	<link href="./vendor/owl.carousel/assets/owl.carousel.css" rel="stylesheet" type="text/css"/>
	<link href="./vendor/owl.carousel/assets/owl.theme.default.css" rel="stylesheet" type="text/css"/>
	<link href="./css/style.default.css" rel="stylesheet" type="text/css"/>
	
	<link href="./css/custom.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="./vendor/jquery/jquery.min.js">	</script>	
	<script type="text/javascript" src="./vendor/popper.js/umd/popper.min.js"> </script>
    <script type="text/javascript" src="./vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script type="text/javascript" src="./vendor/waypoints/lib/jquery.waypoints.min.js"> </script>
    <script type="text/javascript" src="./vendor/jquery.counterup/jquery.counterup.min.js"> </script>
    <script type="text/javascript" src="./vendor/owl.carousel/owl.carousel.min.js"></script>
    <script type="text/javascript" src="./vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
    <script type="text/javascript" src="./js/jquery.parallax-1.1.3.js"></script>
    <script type="text/javascript" src="./vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="./vendor/jquery.scrollto/jquery.scrollTo.min.js"></script>
    <script type="text/javascript" src="./js/front.js"></script>
	
	<script src="js/search.js"></script>
        <script src="js/toDetails.js"></script>
    <link rel="stylesheet" href="css/register.css">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/slick.css">
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/register.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
          
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
    <script type="text/javascript" src="js/index.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/nouislider.min.js"></script>
    <script src="js/jquery.zoom.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/search.js"></script>
    <script src="js/toDetails.js"></script>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/slick.css">
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <!-- Berkin CSS and JS-->
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/register.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script type="text/javascript" src="js/index.js"></script>
    <meta charset="UTF-8">
	

</head>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container" style="margin-right: center;">
            <a class="navbar-brand" href="index.jsp"> <img src="img/logo.png" width="34"
                                                                 height="34" class="d-inline-block align-top" alt=""> Tech
                Market
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                     <li class="dropdown"><a class="nav-link" href="Home_HTML">Action
                        <span class="sr-only">(current)</span>
                    </a>

                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Multiplayer <span class="sr-only">(current)</span></a>

					</li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML"> Sports <span
                            class="sr-only">(current)</span></a>

                    </li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML"> FPS <span class="sr-only">(current)</span></a>

                   </li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML"> RPG <span
                            class="sr-only">(current)</span></a>
                   </li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Strategy<span class="sr-only">(current)</span></a>
                    <li style="margin-left: 5%; margin-top: 5px;"><input id="search"  type="text" placeholder="Search.."  onkeydown="if (event.keyCode == 13) { search(); }"></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="fa fa-user" style="font-size: 34px; color: grey;"></a>

                        <div class="dropdown-content">
                            <a href="login.jsp">Login</a> 
                            <a href="register.jsp">Register</a> <a
                                href="myOrders.jsp">My Orders</a> <a href="#account">Account</a> <a
                                href="#liked">Liked Ones</a>
                        </div></li>
                    <a class="fa fa-shopping-cart" href="shoppingCart.jsp" style="font-size: 34px; color: grey; margin-left: 10%;"></a>
                </ul>
            </div>
        </div>
    </nav>

</header>

<body style = "background-color:white;">

	<section class="container content-section">
		<h1 style="color:black; text-align:justify;" class="section-header">Your Orders</h1>
		<div id="cart-items"></div>
	</section>

<%

session = request.getSession();
if(session.getAttribute("user") != null)
{
	
	Object temp = session.getAttribute("user");
	User user = (User) temp;
	
	List<Order> orderList = new ArrayList<Order>();
	orderList = user.getOrders();
	out.println("<div id=\"all\">");
	out.println("<div id=\"content\">");
    out.println("<div class=\"container\">");
    out.println("<div class=\"row bar\">");
    out.println("<div id=\"customer-order\" class=\"col-lg-9\">");
    
    int orderid = 1;
	for(Order o : orderList){		
		double total = 0;		
		
	    System.out.println(o.getOwner().getEmail());
	    System.out.println(o.getDate());
	    
	    Map<Games, Integer> gameList = new HashMap<>();
	    gameList  = o.getProducts();	    
	    
	    
	    
	    out.println("<div class=\"box\">");
	    out.println("<button id=\"newbtn\" class=\"accordion\">Order " + orderid + "</button>");
			out.println("<div class=\"table-responsive\">");
				out.println("<table class=\"table\">");
				
				
					out.println("<thead>");
						out.println("<tr>");
							out.println("<th class=\"border-top-0\">Order Date: " + o.getDate() + "</th>");
							out.println("<th class=\"border-top-0\">Product</th>");
							out.println("<th class=\"border-top-0\">Quantity</th>");
							out.println("<th class=\"border-top-0\">Unit Price</th>");
							//out.println("<th class=\"border-top-0\">Discount</th>");
							out.println("<th class=\"border-top-0\">Total</th>");
						out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");
	    for(Games game : gameList.keySet())
	    {
	    	System.out.println(game.getHeader_image());
	    	out.println("<tr>");
	    		//out.println("<td><a href=\"#\"><img src=\"./img/product02.png\" alt=" + game.getName() + "class=\"img-fluid\"></a></td>");
	    		out.println("<td><a href=\"#\"><img src=" + game.getHeader_image() +  "alt=" + game.getName() + "width=\"100\" height=\"100\"\"></a></td>");
	    		
	    		out.println("<td><a href=\"#\">" + game.getName()+ "</a></td>");
	    		out.println("<td><a>" + gameList.get(game) + "</a></td>");
	    		//out.println("<td><a href=\"#\">" + gameList.get(game)* 0 + "</a></td>");
	    		out.println("<td><a>" + game.getPrice()+ "$</a></td>");
	    		out.println("<td><a>" + game.getPrice() * gameList.get(game) + "$</a></td>");
	    	out.println("</tr>");
	    	
	    	total = total + (game.getPrice() * gameList.get(game));
	    		System.out.println(game.getName());
	    		System.out.println(gameList.get(game));
	    		System.out.println(game.getPrice());
	    					
	    }
	    out.println("<div class=\"total\">");
	    out.println("<td><a><td><a><td><a><td><a><td><a>" + "Total: "+ total + "$</a></td>");
	    out.println("</div>");
	    			out.println("</tbody>");
	    				out.println("</tr>");
					out.println("</thead>");
				out.println("</table>");
			out.println("</div>");
		out.println("</div>");
		
		orderid = orderid + 1;
		    
	}
	out.println("</div>");
	out.println("</div>");
	out.println("</div>");
	out.println("</div>");
	out.println("</div>");
	
	
}
else
{
	session.setAttribute("order-error", "Please login before accessing this page!!!!");
    response.setHeader("order-error","true");
    response.sendRedirect("login.jsp");
    return;
}
%>
<script>
$(document).ready(function () {
    var butEl = document.getElementsByClassName("accordion");
        count = butEl.length;
    for (i = 0; i < count; i++){
        butEl[i].click();
        butEl[i].click();
    }
});

</script>

<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>

</body>
</html>