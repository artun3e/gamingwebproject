<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
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
  
  
    <body>

      <div class="register-container">
        <div class="register-left">
          <form action="forgotpassword" method="post">
            <h3> Enter the email address of the associated account</h3>
            <img src="img/logo.png" height="100px" width="100px"> <br>
            <input class="register" type="email" id="email" name="email" placeholder="E-mail"><br>
            <h5> Your password should be at least 6 characters.</h5><br>
            <button> Confirm </button>
          </form>
        </div>
        <div class="register-right">
<p> Yinelenen bir sayfa iÃ§eriÄinin okuyucunun dikkatini daÄÄ±ttÄ±ÄÄ± bilinen bir gerÃ§ektir. Lorem Ipsum kullanmanÄ±n amacÄ±, sÃ¼rekli 'buraya metin gelecek, buraya metin gelecek' yazmaya kÄ±yasla daha dengeli bir harf daÄÄ±lÄ±mÄ± saÄlayarak okunurluÄu artÄ±rmasÄ±dÄ±r. Åu anda birÃ§ok masaÃ¼stÃ¼ yayÄ±ncÄ±lÄ±k paketi ve web sayfa dÃ¼zenleyicisi, varsayÄ±lan mÄ±gÄ±r metinler olarak Lorem Ipsum kullanmaktadÄ±r. AyrÄ±ca arama motorlarÄ±nda 'lorem ipsum' anahtar sÃ¶zcÃ¼kleri ile arama yapÄ±ldÄ±ÄÄ±nda henÃ¼z tasarÄ±m aÅamasÄ±nda olan Ã§ok sayÄ±da site listelenir. YÄ±llar iÃ§inde, bazen kazara, bazen bilinÃ§li olarak (Ã¶rneÄin mizah katÄ±larak), Ã§eÅitli sÃ¼rÃ¼mleri geliÅtirilmiÅtir.</p>
        </div>
      </div>

    </body>

</html>