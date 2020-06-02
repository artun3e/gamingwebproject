<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User" %>
<%@ page import="cs308.sabanciuniv.edu.Games" %>
<%@ page import="cs308.sabanciuniv.edu.GamesManager" %>
<html>
   <head>
      <meta charset="utf-8">
      <title>Web Store!</title>
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
      <link rel="stylesheet" href="css/searchBar.css">
      <script type="text/javascript" src="js/register.js"></script>
      <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <script type="text/javascript" src="js/index.js"></script>
      <script type="text/javascript" src="js/indexPop.js"></script>
      <meta charset="UTF-8">
   </head>
   <body>
      <!-- Preloader Start -->
      <div class="spinner-wrapper">
         <div class="sk-folding-cube">
            <div class="sk-cube1 sk-cube"></div>
            <div class="sk-cube2 sk-cube"></div>
            <div class="sk-cube4 sk-cube"></div>
            <div class="sk-cube3 sk-cube"></div>
         </div>
      </div>
      <!-- Preloader end -->
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
                     <li class="dropdown"><a class="nav-link" href="#" value="Action">Action</a></li>
                     <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="Multiplayer">Multiplayer</a></li>
                     <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="Sports">Sports</a></li>
                     <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="FPS">FPS</a></li>
                     <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="RPG">RPG</a></li>
                     <li class="dropdown" style="margin-left: 5%;"><a class="nav-link" href="#" value="Strategy">Strategy</span></a>
                     <li style="margin-left: 5%; margin-top: 6px;"><input id="search"  type="text" placeholder="What are you looking for?" onkeydown="if (event.keyCode == 13) { search(); }"></li>
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
                     <% 
                        session = request.getSession();
                        session = request.getSession();
                        if(session.getAttribute("user") != null)
                        {
                        Object temp = session.getAttribute("user");
                        User user = (User) temp;
                        if(user.getUserType() == User.userType.Admin || user.getUserType() == User.userType.ProductManager || user.getUserType() == User.userType.SalesManager){
                        out.println("<li class=\"dropdown\" style=\"margin-left: 5%;\">");	
                        out.println("<a class=\"fa fa-shield\" href=\"adminPanel.jsp\" style=\"font-size: 34px; color: grey;\"></a>");	
                        out.println("</li>");	
                        }
                               out.print("<p style=\"margin-left: 5%;margin-top: 8px;\">"+user.getName()+"</p>");
                        }
                        %>
                  </ul>
               </div>
            </div>
         </nav>
      </header>
      <script type = "text/javascript">
         function displayNextImage() {
             x = (x === images.length - 1) ? 0 : x + 1;
             document.getElementById("landing-img").src = images[x];
         }
         
         function displayPreviousImage() {
             x = (x <= 0) ? images.length - 1 : x - 1;
             document.getElementById("landing-img").src = images[x];
         }
         
         function startTimer() {
             setInterval(displayNextImage, 3000);
         }
         
         var images = [], x = -1;
         images[0] = "img/campaign0.jpg";
         images[1] = "img/campaign1.png";
         images[2] = "img/campaign2.jpg";
         images[3] = "img/campaign3.jpg";
      </script>
      <div class="img-div">
         <script> startTimer() </script>
         <img id="landing-img" src="img/campaign0.jpg" height= "650" width="1200">
      </div>
      <style>
         .img-div {
         text-align: center;
         }
         #landing-img{
         border-radius: 7%;
         }
      </style>
      <div class="section">
         <!-- container -->
         <p style='color: #a94442' style="margin-left: 500px;">
            <%
               session = request.getSession();
               if(session.getAttribute("loggedIn-Error") != null)
               {
                   out.print("You are already logged in!");
                   session.removeAttribute("loggedIn-Error");
               }
               %>
         </p>
         <div class="main" >
            <div class="container">
               <!-- row -->
               <div class="row" ">
                  <!-- ASIDE -->
                  <div id="aside" class="col-md-3">
                     <!-- aside Widget -->
                     <div class="aside">
                        <h3 class="aside-title">Categories</h3>
                        <div class="checkbox-filter">
                           <div class="input-checkbox">
                              <input type="checkbox" id="category-1" class="input-checkbox_check" value="Action">
                              <label for="category-1">
                                 <span></span>
                                 Action
                                 <!-- <small>(120)</small> -->
                              </label>
                           </div>
                           <div class="input-checkbox">
                              <input type="checkbox" id="category-2" class="input-checkbox_check" value="Multiplayer">
                              <label for="category-2">
                                 <span></span>
                                 Multiplayer
                                 <!-- <small>(740)</small> -->
                              </label>
                           </div>
                           <div class="input-checkbox">
                              <input type="checkbox" id="category-3" class="input-checkbox_check" value="Sports">
                              <label for="category-3">
                                 <span></span>
                                 Sports
                                 <!-- <small>(1450)</small> -->
                              </label>
                           </div>
                           <div class="input-checkbox">
                              <input type="checkbox" id="category-4" class="input-checkbox_check" value="FPS">
                              <label for="category-4">
                                 <span></span>
                                 FPS
                                 <!-- <small>(578)</small> -->
                              </label>
                           </div>
                           <div class="input-checkbox">
                              <input type="checkbox" id="category-5" class="input-checkbox_check" value="Strategy">
                              <label for="category-5">
                                 <span></span>
                                 Strategy
                                 <!-- <small>(120)</small> -->
                              </label>
                           </div>
                           <!-- <div class="input-checkbox">
                              <input type="checkbox" id="category-6">
                              <label for="category-6">
                                  <span></span>
                                  Smartphones
                                  <small>(740)</small>
                              </label>
                              </div> -->
                        </div>
                     </div>
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
                     <div class="aside">
                        <h3 class="aside-title">YOU MIGHT LIKE</h3>
                        <%
                           List<Games> myGames_2 = (List<Games>)GamesManager.getRandomGames();
                              int k = 0;
                              for(Games game : myGames_2)
                              {
                              	if(k ==3) break;
                              	Random r = new Random();
                           Integer random = r.nextInt((30 - 20) + 1) + 20;
                           out.println("<div class=\"product-widget\">");
                           out.println("<div class=\"product-img\">");
                           out.println("<img src=" + game.getHeader_image() + " alt=\"\">");
                           out.println("</div>");
                           out.println("<div class=\"product-body\">");
                           out.println("<p class=\"product-category\"> "+ game.getPublisher() +"</p>");
                           out.println("<h3 class=\"product-name\"><a onclick=\"toDetails(this)\" href=\"#\">"+ game.getName() + "</a></h3>");
                           out.println("<h4 class=\"product-price\">$"+ game.getPrice() + "<del class=\"product-old-price\">$" + (int)(game.getPrice() + random) + "</del></h4>");
                           out.println("</div>");
                           out.println("</div>");	
                           k++;
                              }
                           %>
                     </div>
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
                        </div>
                     </div>
                     <!-- /store top filter -->
                     <!-- store products -->
                     <div class="row" id="About_To_Change">
                        <%--  <%
                           String pageNumber = (request.getQueryString());
                           if(pageNumber == null)
                           	pageNumber = "p=1";
                           List<Games> myGames;
                                	if(request.getSession().getAttribute("indexGames") == null){
                                		myGames = (List<Games>)GamesManager.getRandomGames();
                                		System.out.println("Getting Random Games in Index Page");
                                		request.getSession().setAttribute("indexGames", myGames);
                                	}
                                		
                                	else 
                                	{
                                		myGames = (List<Games>)request.getSession().getAttribute("indexGames");
                                	}
                           
                                	int start=0, end=9;
                                	if(pageNumber.equals("p=2")){
                                		start = 9;
                                		end = 18;
                                	}
                                	else if(pageNumber.equals("p=3")){
                                		System.out.println("ifin icindeyim");
                                		start = 18;
                                		end = 27;
                                	}
                                	else if(pageNumber.equals("p=4")){
                                		start = 27;
                                		end = 36;
                                	}
                                	else if(pageNumber.equals("p=5")){
                                		start = 36;
                                		end = 45;
                                	}
                                		
                                 	
                                       for(int j=start; j<end; j++)
                                       {
                                       	Games game = myGames.get(j);
                                 	%>
                           	<script>
                           	var something = '<%=request.getSession().getAttribute("user")%>';
                           	console.log(something);
                           	consoling();
                           	</script>
                                 	<%
                                       	Random r = new Random();
                           	Integer random = r.nextInt((30 - 20) + 1) + 20;
                                       	out.println("<div class=\"col-md-4 col-xs-6\">");
                                       		out.println("<div class=\"product\">");
                                       			out.println("<div class=\"product-img\">");
                                       				out.println("<img src=\""+ game.getHeader_image() +" alt=\"\">");
                                       				out.println("<div class=\"product-label\">");
                                       					out.println("<span class=\"new\">NEW</span>");
                                       				out.println("</div>");
                                       			out.println("</div>");
                                       			out.println("<div class=\"product-body\">");
                                       				out.println("<p class=\"product-category\">" + game.getCategories() + "</p>");
                                       				out.println("<h3 class=\"product-name\"><a onclick=\"toDetails(this)\" href=\"#\">"+ game.getName() +"</a></h3>");
                                       				out.println("<h4 class=\"product-price\">$" + game.getPrice() + "<del class=\"product-old-price\">$" + ((int)game.getPrice() + random) + ".00</del></h4>");	
                                       				out.println("<div class=\"product-rating\">");
                                       				int starNumber = 0;
                                       				double rating = game.getRating();
                                                          if(rating > 0.95)
                                        				 starNumber = 5;
                                                      	else if(rating >= 0.80 && rating < 0.95)
                                                      		starNumber = 4;
                                                      	else if(rating >= 0.60 && rating < 0.80)
                                                      		starNumber = 3;
                                                      	else if(rating >= 0.40 && rating < 0.60)
                                                      		starNumber = 2;
                                                      	else if(rating >= 0 && rating < 0.40)
                                                      		starNumber = 1;
                                                      	else
                                                      		starNumber = 0;
                                                          for (int i=0; i<starNumber; i++)
                           					out.println("<i class=\"fa fa-star\"></i>");	
                           
                                        			out.println("</div>");
                                       				//out.println("<div class=\"product-btns\">");	
                                       				//	out.println("<button class=\"add-to-wishlist\"><i class=\"fa fa-heart-o\"></i><span class=\"tooltipp\">add to wishlist</span></button>");
                                       				//	out.println("<button class=\"add-to-compare\"><i class=\"fa fa-exchange\"></i><span class=\"tooltipp\">add to compare</span></button>");
                                       				//	out.println("<button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">quick view</span></button>");
                                       				//out.println("</div>");
                                       			out.println("</div>");
                                       			out.println("<div class=\"add-to-cart\">");
                                       				out.println("<button onclick=\"addToCart(this)\" class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> cart</button>");
                                       			out.println("</div>");
                                       		out.println("</div>");
                                       	out.println("</div>");
                                       }
                           
                           %> --%>
                        <!--	Old Static Product
                           <div class="col-md-4 col-xs-6">
                               <div class="product">
                                   <div class="product-img">
                                       <img src="./img/product09.png" alt="">
                                   </div>
                                   <div class="product-body">
                                       <p class="product-category">Category</p>
                                       <h3 class="product-name"><a href="#">Half-Life: Blue Shift</a></h3>
                                       <h4 class="product-price">$40.00 <del class="product-old-price">$45.00</del></h4>
                                       <div class="product-rating">
                                       </div>
                                       <div class="product-btns">
                                           <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                           <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                           <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                       </div>
                                   </div>
                                   <div class="add-to-cart">
                                       <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> cart</button>
                                   </div>
                               </div>
                           </div> -->
                     </div>
                     <!-- /store products -->
                     <!-- store bottom filter -->
                     <div class="store-filter clearfix">
                        <span class="store-qty">Showing 9 products</span>
                        <%
                           System.out.println("We are in Home Page");
                           if(request.getSession().getAttribute("cart") != null){
                               //The cart is NOT null. Thus there is some products in the cart. Let's display them.
                               System.out.println("Cart has elements.");
                               Map<Games, Integer> cartMap = (HashMap)request.getSession().getAttribute("cart");
                               out.println("<p style=\"color:red;\">");
                               for(Games game : cartMap.keySet())
                               {
                                   System.out.println((game.getAppID() / 10)+ " : " + game.getName() + ": " + cartMap.get(game));
                                   out.println((game.getAppID() / 10) + " : " + game.getName() + ": " + cartMap.get(game) + "</br>");
                                   
                               }
                               out.println("</p>");
                           }
                           %>
                        <script></script> 
                        <ul class="store-pagination" id="store-pagination">
                           <!-- <li><a onclick="showPage1()" href="#1" class="page_number_1" >1</a></li> -->
<!--                            <li><a onclick="showPage2()" href="#2" class="page_number_2">2</a></li>
                           <li><a onclick="showPage3()" href="#3" class="page_number_3">3</a></li>
                           <li><a onclick="showPage4()" href="#4" class="page_number_4">4</a></li>
                           <li><a onclick="showPage5()" href="#5" class="page_number_5">5</a></li> -->
                           <!-- <li><a href="#"><i class="fa fa-angle-right" style="margin-top: 14px;"></i></a></li> -->
                        </ul>
                     </div>
                     <!-- /store bottom filter -->
                  </div>
                  <!-- /STORE -->
               </div>
               <!-- /row -->
            </div>
            <!-- /container -->
         </div>
      </div>
   </body>
   </body>
   <footer> </footer>
</html>