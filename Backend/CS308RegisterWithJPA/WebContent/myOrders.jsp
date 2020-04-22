<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<!DOCTYPE html>
<html>
<head>

<style>
body {
  background-image: url("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw8NDw8NDQ0NDQ8NDQ8NDQ0NDQ8NDQ0NFREWFhURFRUYHSggGBolGxUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDQ0NDw8PFSsZFRkrKy0rKy03KysrLTctKy03LTctNy03LS0tKzctKys3LTctKy0tLSstLTctLSsrNystK//AABEIALEBHAMBIgACEQEDEQH/xAAYAAEBAQEBAAAAAAAAAAAAAAABAAIDB//EABcQAQEBAQAAAAAAAAAAAAAAAAABEQL/xAAVAQEBAAAAAAAAAAAAAAAAAAAAAf/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/APFQiAIIIpYoUkoisIJIwEjiBLCsAI4gCOKwAkgAaxYDIsaAANCgAUgyiACKQBgIAhAUkoYQQRxQqIggikBWKRqQBixrDgM4saw4DGLGsWAxgxuwWAyGsGAAUDKIBmo0AmWhUAkgBBQSBgIwNRRJFRGIwEUQRkEjcgCRrDDgA4ZGsBnFjSwGcWN4MBiwN2DAc7BXSs2A5pqwAyGqKDIpQMpIACKgCCgkkBhEKiMDSiKIIxGAY1BG5AUakUagJSNSHAZw41iwGcFjeDAYFjdgsBzsZdLGKDFZrdZsBhGgAGqyABoABoIBRKAiDARSUMIhgEggY1GY3AMb5ZjUBrGoGoBjQjUESwnBGcFjYorFZbrNBixmt1miudFarNBistUABSKAZaZBCkVAKJAkiChSUJEMAwggY3GY1AajcYjcBqNxiNwGmozCI1CIREzWqKDLNarNFYrNarNFZrFbrFBihqsgARQApZBCkVAJIEYEDSEKhhBAwiEGo1GI1Abjcc43AbjUYjUBuNRhqURrTrOrQaFGigmabWaArNOs0Vms1qsWgKybQABrIIUsghSEAkgSSAwiECYzGlCWWoBMCBuNRiVqA6RpiNSg3KYxKdBvTrGrRGtWs6rRVaLRaLQVZptYoKsU1mgAaAAIAUGgECKgElABQQaLJihMCUaLMMBoswg1GpWDAdIZWJTKDpp1z0yg6atY06DWjWdWg1rOjRQNrNFooK1nVQCSABIUFQkACSCUBgJAoJJKNIQgdMZMUaLJAlkg0dZWg3KdY06DerWNWg3o1nVoNWjWdWgdZWoAkAVCQBBAgWUCEkAYCARAIggiCoUkoZSyQaQQNIagJCA6tCA6ggIS0EggQSBCrQCSALQkggQgjAYCSQAhASkoUkojEgKKBJICkgSSBJIEqkABQBJAKEgSSQZSSCSQJJA//9k=");
  
}
title{
color:white;
}

.box {
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
	
	
	
	
	
<!-- <script type="text/javascript" src="myOrders.js"></script> -->

</head>

<body style = "background-color:#DCFAB5;">

	<section class="container content-section">
		<h1 style="color:white; text-align:left;" class="section-header">My Orders</h1>
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
	
	for(Order o : orderList){
		double total = 0;		
		
	    System.out.println(o.getOwner().getEmail());
	    System.out.println(o.getDate());
	    
	    Map<Games, Integer> gameList = new HashMap<>();
	    gameList  = o.getProducts();	    
	    
	    out.println("<div class=\"box\">");
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
	    out.println("<div id=\"total\">");
	    out.println("<td><a>" + "Total: "+ total + "$</a></td>");
	    out.println("</div>");
	    			out.println("</tbody>");
	    				out.println("</tr>");
					out.println("</thead>");
				out.println("</table>");
			out.println("</div>");
		out.println("</div>");

		    
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

</body>
</html>