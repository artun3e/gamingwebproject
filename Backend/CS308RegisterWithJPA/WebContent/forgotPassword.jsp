<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<%@ page import="java.io.PrintWriter" %>
<html>

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
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/nouislider.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- Berkin CSS and JS-->
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/searchBar.css">
<script type="text/javascript" src="js/register.js"></script>
<script src="js/search.js"></script>
<script src="js/details.js"></script>
<script src="js/toDetails.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

                    <li style="margin-left: 100%; margin-top: 6px;"><input id="search"  type="text" placeholder="Search.."  onkeydown="if (event.keyCode == 13) { search(); }"></li>
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

      <div class="register-container">
        <div class="register-left">
          <form action="forgotpassword" method="post">
            <h3> Enter the email address of the associated account</h3>
            <img src="img/logo.png" height="100px" width="100px"> <br>
              <p style='color: #a94442'>
              <%
                  session = request.getSession();
                  if(session.getAttribute("forgotPasswordIncorrect")!= null)
                  {
                      out.println("No such email was found...");
                      session.removeAttribute("forgotPasswordIncorrect");
                  }
              %>
              </p>
            <input class="register" type="email" id="email" name="email" placeholder="E-mail"><br>
            <h5> Your password should be at least 6 characters.</h5><br>
            <button> Confirm </button>
          </form>
        </div>
          <div class="register-right">
              <div class="row">
                  <div class="col-6 col-md mt-4 mb-4 footerText">
                      <i class="fas fa-feather fa-4x"></i>
                      <p class="mt-3"><b>Easy to Use </b><br><br>
                          <span class="footerSpan">A simple and useful user interface that helps you to get things done</span>
                      </p>
                      <div class="underLine"></div>
                  </div>
                  <div class="col-6 col-md mt-4 mb-4 footerText">
                      <i class="fas fa-shield-alt fa-4x"></i>
                      <p class="mt-3"><b> Totally Secure </b><br><br>
                          <span class="footerSpan">All payment methods and technologies consider the data security</span>
                      </p>
                      <div class="underLine"></div>
                  </div>
                  <div class="col-6 col-md mt-4 mb-4 footerText">
                      <i class=""></i>
                      <p class="mt-3"><b> Fastest Delivery </b> <br><br>
                          <span class="footerSpan">Accounts that you buy will be delivered as soon as possible</span>
                      </p>
                      <div class="underLine"></div>
                  </div>
                  <div class="col-6 col-md mt-4 mb-4 footerText">
                      <i class="far fa-handshake fa-4x"></i>
                      <p class="mt-3"> <b> Customer Happiness </b><br><br>
                          <span class="footerSpan">We are always here to help you after or before your purchase</span>
                      </p>
                      <div class="underLine"></div>
                  </div>
              </div>
          </div>
      </div>

    </body>

</html>