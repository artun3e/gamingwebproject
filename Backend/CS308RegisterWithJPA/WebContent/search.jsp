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

<<<<<<< HEAD
                    <li style="margin-left: 75%; margin-top: 12px;"><input id="search"  type="text" placeholder="Search.."  onkeydown="if (event.keyCode == 13) { search(); }"></li>
                    <li class="dropdown" style="margin-left: 5%;">
                    	<a class="fa fa-user" style="font-size: 34px; color: grey;"></a>
=======
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
                    <li style="margin-left: 5%; margin-top: 5px;"><input id="search"  type="text" placeholder="What are you looking for?"  onkeydown="if (event.keyCode == 13) { search(); }"></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="fa fa-user" style="font-size: 34px; color: grey;"></a>
>>>>>>> 9444eed3eed2a180a541da4822c48aceac0ccfcc

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
                   	<%
                        if(session.getAttribute("user") != null)
                        {
                            Object obj = session.getAttribute("user");
                            User user = (User) obj;
                            out.print("<p style=\"margin-left: 5%;margin-top: 8px;\">"+user.getName()+"</p>");
                        }
                   	%>
                </ul>
            </div>
        </div>
    </nav>
</header>
<body>
	<div class="main">

    </div
</body>
</body>
<footer> </footer>
</html>
