<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<html>

  <head>
  <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
   <link rel="stylesheet" href="css/register.css">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/slick.css">
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
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

                    <li style="margin-left: 75%; margin-top: 12px;"><input id="search"  type="text" placeholder="Search.."  onkeydown="if (event.keyCode == 13) { search(); }"></li>
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