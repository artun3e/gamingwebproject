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
      <script type="text/javascript" src="js/pa_checkout.js"></script>
      <script type="text/javascript">
         function Log_User_Out(logging){	
         	var xhr = new XMLHttpRequest();
             var url = "logout";
             xhr.open("POST", url, true);
             xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
             xhr.addEventListener('readystatechange', function(e){
             	if(this.readyState === 4)
         		{
         			alert("Successfully logged out.")
         			console.log("User logged out.");
         			window.location = "index.jsp";
         		}
         	})
             xhr.send();
         }
      </script>
   </head>
   <header id="site-header">
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
                           	out.println("<a href=\"myAccount.jsp\">My Account</a>");
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
                %> <script> 
            getData("<%=user.getEmail()%>")
         </script> <% 
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
                      			out.println("<h1 style=\"margin-bottom: -15px;\" class= \"product_name\" <a onclick=\"toDetails(this)\" href=\"#\">"+ game.getName() +"</h1> <br> <br>");	
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

       <div class="container" id="apDiv">
       <%
       Map<Games, Integer> cartMap = (HashMap)request.getSession().getAttribute("cart");
       if(session.getAttribute("user") != null){
	       if(cartMap.size() > 0){
	       out.println("        <div class=\"row-checkout\">");
	       out.println("           <div class=\"column-75\">");
	       out.println("              <div class=\"storage\">");
	       out.println("                 <div class=\"row-checkout\">");
	       out.println("                    <div class=\"column-50\">");
	       out.println("                    <div id=\"addressOptionDiv\">");
	       out.println("                                         <form id=\"adrOption\">");
	       out.println("                          <label> Select an address</label>");
	       out.println("                          <select onchange=\"checkOptions()\" id=\"selectAddress\">");
	       out.println("                          </select>");
	       out.println("                       </form>");
	       out.println("                    </div>");
	       out.println("                        <h3> Address</h3>");
	       out.println("                       <br><br><br>                ");
	       out.println("                       <!--             <label for=\"fname\"><i class=\"fa fa-user\"></i> Full Name</label>");
	       out.println("                          <input type=\"text\" id=\"fname\" name=\"firstname\" placeholder=\"John M. Doe\">");
	       out.println("                          <label for=\"email\"><i class=\"fa fa-envelope\"></i> Email</label>");
	       out.println("                          <input type=\"text\" id=\"email\" name=\"email\" placeholder=\"john@example.com\"> -->");
	       out.println("                       <label for=\"adr\"><i class=\"fa fa-address-card-o\"></i> Address</label>");
	       out.println("                       <input type=\"text\" id=\"adr\" name=\"address\" placeholder=\"542 W. 15th Street\">");
	       out.println("                       <label for=\"city\"><i class=\"fa fa-institution\"></i> City</label>");
	       out.println("                       <input type=\"text\" id=\"city\" name=\"city\" placeholder=\"New York\">");
	       out.println("                       <label for=\"phone\" class=\"fa fa-phone\">Phone Number</label>");
	       out.println("                       <input type=\"text\" id=\"phone\" name=\"phone\" placeholder=\"0(5xx)\">");
	       out.println(" ");
	       out.println("                       <label>");
	       out.println("                       <input type=\"checkbox\" checked=\"checked\" name=\"sameadr\"> Shipping address same as billing");
	       out.println("                       </label>");
	       out.println("                    </div>");
	       out.println("                    <div class=\"column-50\">");
	       out.println("                       <h3>Payment</h3>");
	       out.println("                       <div id=\"paymentOptionDiv\">");
	       out.println("                       ");
	       out.println("                                              <form id=\"payOption\">");
	       out.println("                          <label> Select a payment method</label>");
	       out.println("                          <select onchange=\"checkOptions()\" id=\"selectPayment\">");
	       out.println("                          </select>");
	       out.println("                       </form>");
	       out.println("                       </div>");
	       out.println("                       <label for=\"fname\">Accepted Cards</label>");
	       out.println("                       <div class=\"icon-storage\">");
	       out.println("                          <i class=\"fa fa-cc-visa\" style=\"color:navy;\"></i>");
	       out.println("                          <i class=\"fa fa-cc-amex\" style=\"color:blue;\"></i>");
	       out.println("                          <i class=\"fa fa-cc-mastercard\" style=\"color:red;\"></i>");
	       out.println("                          <i class=\"fa fa-cc-discover\" style=\"color:orange;\"></i>");
	       out.println("                       </div>");
	       out.println("                       <!--             <label for=\"cname\">Name on Card</label>");
	       out.println("                          <input type=\"text\" id=\"cname\" name=\"cardname\" placeholder=\"John More Doe\"> -->");
	       out.println("                       <label for=\"ccnum\">Credit card number</label>");
	       out.println("                       <input type=\"text\" id=\"ccnum\" name=\"cardnumber\" placeholder=\"1111-2222-3333-4444\">");
	       out.println("                       <label for=\"expmonth\">Expiration Date</label>");
	       out.println("                       <input type=\"text\" id=\"expDate\" name=\"expmonth\" placeholder=\"September\">");
	       out.println("                       <label for=\"cvv\">CVV</label>");
	       out.println("                       <input type=\"text\" id=\"cvv\" name=\"cvv\" placeholder=\"352\">");
	       out.println("                    </div>");
	       out.println("                 </div>");
	       out.println("              </div>");
	       out.println("           </div>");
	       out.println("        </div>");
	       }
       }
       %>
       
      <!--   <div class="row-checkout">
            <div class="column-75">
               <div class="storage">
                  <div class="row-checkout">
                     <div class="column-50">
                     <div id="addressOptionDiv">
                                          <form id="adrOption">
                           <label> Select an address</label>
                           <select onchange="checkOptions()" id="selectAddress">
                           </select>
                        </form>
                     </div>

                        <h3> Address</h3>
                        <br><br><br>                
                                    <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                           <input type="text" id="fname" name="firstname" placeholder="John M. Doe">
                           <label for="email"><i class="fa fa-envelope"></i> Email</label>
                           <input type="text" id="email" name="email" placeholder="john@example.com">
                        <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                        <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
                        <label for="city"><i class="fa fa-institution"></i> City</label>
                        <input type="text" id="city" name="city" placeholder="New York">
                        <label for="phone" class="fa fa-phone">Phone Number</label>
                        <input type="text" id="phone" name="phone" placeholder="0(5xx)">

 
                        <label>
                        <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                        </label>
                     </div>
                     <div class="column-50">
                        <h3>Payment</h3>
                        <div id="paymentOptionDiv">
                        
                                               <form id="payOption">
                           <label> Select a payment method</label>
                           <select onchange="checkOptions()" id="selectPayment">
                           </select>
                        </form>
                        </div>
                        <label for="fname">Accepted Cards</label>
                        <div class="icon-storage">
                           <i class="fa fa-cc-visa" style="color:navy;"></i>
                           <i class="fa fa-cc-amex" style="color:blue;"></i>
                           <i class="fa fa-cc-mastercard" style="color:red;"></i>
                           <i class="fa fa-cc-discover" style="color:orange;"></i>
                        </div>
                                    <label for="cname">Name on Card</label>
                           <input type="text" id="cname" name="cardname" placeholder="John More Doe">
                        <label for="ccnum">Credit card number</label>
                        <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                        <label for="expmonth">Expiration Date</label>
                        <input type="text" id="expDate" name="expmonth" placeholder="September">
                        <label for="cvv">CVV</label>
                        <input type="text" id="cvv" name="cvv" placeholder="352">
                     </div>
                  </div>
               </div>
            </div>
         </div> -->
        </div> 
         <style>
            .row-checkout {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            -ms-flex-wrap: wrap; /* IE10 */
            flex-wrap: wrap;
            margin: 0 -16px;
            }
            .column-25 {
            -ms-flex: 25%; /* IE10 */
            flex: 25%;
            }
            .column-50 {
            -ms-flex: 50%; /* IE10 */
            flex: 50%;
            }
            .column-75 {
            -ms-flex: 75%; /* IE10 */
            flex: 75%;
            }
            .column-25,
            .column-50,
            .column-75 {
            padding: 0 16px;
            }
            .storage {
            background-color: #f2f2f2;
            padding: 5px 20px 15px 20px;
            border: 1px solid lightgrey;
            border-radius: 3px;
            }
            input[type=text] {
            width: 100%;
            margin-bottom: 20px;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 3px;
            }
            label {
            margin-bottom: 10px;
            display: block;
            }
            .icon-storage {
            margin-bottom: 20px;
            padding: 7px 0;
            font-size: 24px;
            }
            .btn {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            margin: 10px 0;
            border: none;
            width: 100%;
            border-radius: 3px;
            cursor: pointer;
            font-size: 17px;
            }
            .btn:hover {
            background-color: #45a049;
            }
            span.price {
            float: right;
            color: grey;
            }
            /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (and change the direction - make the "cart" column go on top) */
            @media (max-width: 800px) {
            .row-checkout {
            flex-direction: column-reverse;
            }
            .column-25 {
            margin-bottom: 20px;
            }
            }
         </style>
      
   </body>
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
</html>