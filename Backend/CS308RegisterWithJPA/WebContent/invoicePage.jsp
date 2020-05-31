<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User" %>
<%@ page import="cs308.sabanciuniv.edu.Games" %>
<%@ page import="cs308.sabanciuniv.edu.GamesManager" %>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<%@ page import="cs308.sabanciuniv.edu.OrderManager"%>
<%@ page buffer="522kb" autoFlush="false" %>
<!DOCTYPE html>

<html class="no-js" lang="">

<head>
<script type="text/javascript" src="libs/png_support/zlib.js"></script>
<script type="text/javascript" src="libs/png_support/png.js"></script>
<script type="text/javascript" src="jspdf.plugin.addimage.js"></script>
<script type="text/javascript" src="jspdf.plugin.png_support.js"></script>
<script type="text/javascript" src="jspdf.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
	<script type="text/javascript" src="https://html2canvas.hertzen.com/dist/html2canvas.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Admin Panel</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img3/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/owl.carousel.css">
    <link rel="stylesheet" href="./css3/owl.theme.css">
    <link rel="stylesheet" href="./css3/owl.transitions.css">
    <!-- meanmenu CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/meanmenu/meanmenu.min.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/normalize.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- jvectormap CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/jvectormap/jquery-jvectormap-2.0.3.css">
    <!-- notika icon CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/notika-custom-icon.css">
    <!-- wave CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/wave/waves.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/main.css">
    <!-- style CSS
    
		============================================ -->
	<link rel="stylesheet" href="./css3/jquery.dataTables.min.css">
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="./js3/vendor/modernizr-2.8.3.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
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
  width: 1000px;
}
.border-top-0{

width: 1000px;

}
</style>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- Start Header Top Area -->
    <div class="header-top-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="logo-area">
                        
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                    <div class="header-top-menu">
                        <ul class="nav navbar-nav notika-top-nav">
                            <li class="nav-item dropdown">
                                <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><span><i class="notika-icon notika-search"></i></span></a>
                                <div role="menu" class="dropdown-menu search-dd animated flipInX">
                                    <div class="search-input">
                                        <i class="notika-icon notika-left-arrow"></i>
                                        <input type="text" />
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Header Top Area -->
    <!-- Mobile Menu start -->
    <div class="mobile-menu-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="mobile-menu">
                        <nav id="dropdown">
                            <ul class="mobile-menu-nav">
                                <li><a data-toggle="collapse" data-target="#Charts" href="#">Home</a>
                                    <ul class="collapse dropdown-header-top">
                                        <li><a href="index.html">Dashboard One</a></li>
                                        <li><a href="index-2.html">Dashboard Two</a></li>
                                        <li><a href="index-3.html">Dashboard Three</a></li>
                                        <li><a href="index-4.html">Dashboard Four</a></li>
                                        <li><a href="analytics.html">Analytics</a></li>
                                        <li><a href="widgets.html">Widgets</a></li>
                                    </ul>
                                </li>
                                <li><a data-toggle="collapse" data-target="#demoevent" href="#">Email</a>
                                    <ul id="demoevent" class="collapse dropdown-header-top">
                                        <li><a href="inbox.html">Inbox</a></li>
                                        <li><a href="view-email.html">View Email</a></li>
                                        <li><a href="compose-email.html">Compose Email</a></li>
                                    </ul>
                                </li>
                                <li><a data-toggle="collapse" data-target="#democrou" href="#">Interface</a>
                                    <ul id="democrou" class="collapse dropdown-header-top">
                                        <li><a href="animations.html">Animations</a></li>
                                        <li><a href="google-map.html">Google Map</a></li>
                                        <li><a href="data-map.html">Data Maps</a></li>
                                        <li><a href="code-editor.html">Code Editor</a></li>
                                        <li><a href="image-cropper.html">Images Cropper</a></li>
                                        <li><a href="wizard.html">Wizard</a></li>
                                    </ul>
                                </li>
                                <li><a data-toggle="collapse" data-target="#demolibra" href="#">Charts</a>
                                    <ul id="demolibra" class="collapse dropdown-header-top">
                                        <li><a href="flot-charts.html">Flot Charts</a></li>
                                        <li><a href="bar-charts.html">Bar Charts</a></li>
                                        <li><a href="line-charts.html">Line Charts</a></li>
                                        <li><a href="area-charts.html">Area Charts</a></li>
                                    </ul>
                                </li>
                                <li><a data-toggle="collapse" data-target="#demodepart" href="#">Tables</a>
                                    <ul id="demodepart" class="collapse dropdown-header-top">
                                        <li><a href="data_table_Cats.jsp">Category Table</a></li>
                                        <li><a href="data_table_Games.jsp">Games Table</a></li>
                                    </ul>
                                </li>
                                <li><a data-toggle="collapse" data-target="#demo" href="#">Forms</a>
                                    <ul id="demo" class="collapse dropdown-header-top">
                                        <li><a href="form-elements.html">Form Elements</a></li>
                                        <li><a href="form-components.html">Form Components</a></li>
                                        <li><a href="form-examples.html">Form Examples</a></li>
                                    </ul>
                                </li>
                                <li><a data-toggle="collapse" data-target="#Miscellaneousmob" href="#">App views</a>
                                    <ul id="Miscellaneousmob" class="collapse dropdown-header-top">
                                        <li><a href="notification.html">Notifications</a>
                                        </li>
                                        <li><a href="alert.html">Alerts</a>
                                        </li>
                                        <li><a href="modals.html">Modals</a>
                                        </li>
                                        <li><a href="buttons.html">Buttons</a>
                                        </li>
                                        <li><a href="tabs.html">Tabs</a>
                                        </li>
                                        <li><a href="accordion.html">Accordion</a>
                                        </li>
                                        <li><a href="dialog.html">Dialogs</a>
                                        </li>
                                        <li><a href="popovers.html">Popovers</a>
                                        </li>
                                        <li><a href="tooltips.html">Tooltips</a>
                                        </li>
                                        <li><a href="dropdown.html">Dropdowns</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a data-toggle="collapse" data-target="#Pagemob" href="#">Pages</a>
                                    <ul id="Pagemob" class="collapse dropdown-header-top">
                                        <li><a href="contact.html">Contact</a>
                                        </li>
                                        <li><a href="invoice.html">Invoice</a>
                                        </li>
                                        <li><a href="typography.html">Typography</a>
                                        </li>
                                        <li><a href="color.html">Color</a>
                                        </li>
                                        <li><a href="login-register.html">Login Register</a>
                                        </li>
                                        <li><a href="404.html">404 Page</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Mobile Menu end -->
    <!-- Main Menu area start-->
    <div class="main-menu-area mg-tb-40">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
                        <li><a data-toggle="tab" href="#Home"><i class="notika-icon notika-house"></i> Home</a>
                        </li>
                        <li><a data-toggle="tab" href="#mailbox"><i class="notika-icon notika-mail"></i> Email</a>
                        </li>
                        <li><a data-toggle="tab" href="#Interface"><i class="notika-icon notika-edit"></i> Interface</a>
                        </li>
                        <li><a data-toggle="tab" href="#Charts"><i class="notika-icon notika-bar-chart"></i> Charts</a>
                        </li>
                        <li class="active"><a data-toggle="tab" href="#Tables"><i class="notika-icon notika-windows"></i> Tables</a>
                        </li>
                        <li><a data-toggle="tab" href="#Forms"><i class="notika-icon notika-form"></i> Forms</a>
                        </li>
                        <li><a data-toggle="tab" href="#Appviews"><i class="notika-icon notika-app"></i> App views</a>
                        </li>
                        <li><a data-toggle="tab" href="#Page"><i class="notika-icon notika-support"></i> Pages</a>
                        </li>
                    </ul>
                    <div class="tab-content custom-menu-content">
                        <div id="Home" class="tab-pane in notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="index.html">Dashboard One</a>
                                </li>
                                <li><a href="index-2.html">Dashboard Two</a>
                                </li>
                                <li><a href="index-3.html">Dashboard Three</a>
                                </li>
                                <li><a href="index-4.html">Dashboard Four</a>
                                </li>
                                <li><a href="analytics.html">Analytics</a>
                                </li>
                                <li><a href="widgets.html">Widgets</a>
                                </li>
                            </ul>
                        </div>
                        <div id="mailbox" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="inbox.html">Inbox</a>
                                </li>
                                <li><a href="view-email.html">View Email</a>
                                </li>
                                <li><a href="compose-email.html">Compose Email</a>
                                </li>
                            </ul>
                        </div>
                        <div id="Interface" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="animations.html">Animations</a>
                                </li>
                                <li><a href="google-map.html">Google Map</a>
                                </li>
                                <li><a href="data-map.html">Data Maps</a>
                                </li>
                                <li><a href="code-editor.html">Code Editor</a>
                                </li>
                                <li><a href="image-cropper.html">Images Cropper</a>
                                </li>
                                <li><a href="wizard.html">Wizard</a>
                                </li>
                            </ul>
                        </div>
                        <div id="Charts" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="flot-charts.html">Flot Charts</a>
                                </li>
                                <li><a href="bar-charts.html">Bar Charts</a>
                                </li>
                                <li><a href="line-charts.html">Line Charts</a>
                                </li>
                                <li><a href="area-charts.html">Area Charts</a>
                                </li>
                            </ul>
                        </div>
                        <div id="Tables" class="tab-pane active notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="data_table_Cats.jsp">Category Table</a>
                                </li>
                                <li><a href="data_table_Games.jsp">Games Table</a>
                                </li>
                            </ul>
                        </div>
                        <div id="Forms" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="form-elements.html">Form Elements</a>
                                </li>
                                <li><a href="form-components.html">Form Components</a>
                                </li>
                                <li><a href="form-examples.html">Form Examples</a>
                                </li>
                            </ul>
                        </div>
                        <div id="Appviews" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="notification.html">Notifications</a>
                                </li>
                                <li><a href="alert.html">Alerts</a>
                                </li>
                                <li><a href="modals.html">Modals</a>
                                </li>
                                <li><a href="buttons.html">Buttons</a>
                                </li>
                                <li><a href="tabs.html">Tabs</a>
                                </li>
                                <li><a href="accordion.html">Accordion</a>
                                </li>
                                <li><a href="dialog.html">Dialogs</a>
                                </li>
                                <li><a href="popovers.html">Popovers</a>
                                </li>
                                <li><a href="tooltips.html">Tooltips</a>
                                </li>
                                <li><a href="dropdown.html">Dropdowns</a>
                                </li>
                            </ul>
                        </div>
                        <div id="Page" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="contact.html">Contact</a>
                                </li>
                                <li><a href="invoice.html">Invoice</a>
                                </li>
                                <li><a href="typography.html">Typography</a>
                                </li>
                                <li><a href="color.html">Color</a>
                                </li>
                                <li><a href="login-register.html">Login Register</a>
                                </li>
                                <li><a href="404.html">404 Page</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Main Menu area End-->
	<!-- Breadcomb area Start-->
	<div class="breadcomb-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcomb-list">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="breadcomb-wp">
									<div class="breadcomb-icon">
										<i class="notika-icon notika-windows"></i>
									</div>
									<div class="breadcomb-ctn">
										<h2>Invoice Page</h2>
										<p>Welcome to Tech Market <span class="bread-ntd">Admin Panel Invoice Page</span></p>
									</div>
								</div>
							</div>
							<!-- <div class="col-lg-6 col-md-6 col-sm-6 col-xs-3">
								<div class="breadcomb-report">
									<button data-toggle="tooltip" data-placement="left" title="Download Report" class="btn"><i class="notika-icon notika-sent"></i></button>
								</div>
							</div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcomb area End-->
    <!-- Data Table area Start-->
    <div class="data-table-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>Invoices</h2>
                            <p>This panel is for Admin to view and change order status.</p>
                        </div>
<table>
<tr>
    <td>DATE</td>
    <td>E-MAIL</td>
    <td>PRICE</td>
    <td>PRODUCT</td>
</tr>
<tr>
    <td><input type="text" name="date" id="date"></td>
    <td><input type="text" name="email" id="email"></td>
    <td><input type="text" name="price" id="price"></td>
    <td><input type="text" name="product" id="product"></td>
</tr>
</table>

 <a class='btn btn-success btn-block btn-lg' onclick="filterFunction()" href="#"style="margin-left: auto; margin-right: auto; display: block; margin-top: 10px; margin-bottom: 10px">FILTER</a>

<a class='btn btn-success btn-block btn-lg' onclick="downloadPDF()" href="#"style="margin-left: auto; margin-right: auto; display: block; margin-top: 10px; margin-bottom: 10px">DOWNLOAD AS PDF</a>
<%

session = request.getSession();
if(session.getAttribute("user") != null)
{
	
	OrderManager om = new OrderManager();
	List<Order> orderList = om.getAllOrders();
	
	
	out.println("<div id=\"all\" class=\"all\">");
	out.println("<div id=\"content\">");
    out.println("<div class=\"container\">");
    out.println("<div class=\"row bar\">");
    out.println("<div id=\"customer-order\" class=\"col-lg-9\">");
    
    int orderid = 1;
	for(Order o : orderList){		
		double total = 0;		
		
	    
	    Map<Games, Integer> gameList = new HashMap<>();
	    gameList  = o.getProducts();	    
	    Map<Games, Double> prices = o.getPricesAtThatTime();
	    
	    
	    out.println("<div class=\"box\">");
			out.println("<div class=\"table-responsive\"style=\"width:100%\">");
				out.println("<table class=\"table\">");
				
				
					out.println("<thead>");
					out.println("<th class=\"border-top-0\">User: " + o.getOwner().getEmail() + "</th>"); //get user name
					out.println("<th class=\"border-top-0\">Date: " + o.getDate() + "</th>"); //get order date
					out.println("<th class=\"border-top-0\">Status: " + o.getStatus() + "</th>");
					out.println("<th class=\"border-top-0\">Change Status</th>");
					out.println("<td><select id=\"orderStatus\">");
						out.println("<option value=\"Null\">---</option>");
						out.println("<option value=\"PreparingPackaage\">Preparing Package</option>");
						out.println("<option value=\"Shipped\">Shipped</option>");
						out.println("<option value=\"OutonDelivery\">Out on Delivery</option>");
						out.println("<option value=\"Delivered\">Delivered</option>");					
					out.println("</td>");
					out.println("<td>");
					out.println("<button type=\"button\" onclick=\"alert('Hello world!')\">UPDATE</button>");
					out.println("</td>");
						out.println("<tr>");				
							out.println("<th class=\"border-top-0\"></th>");
							out.println("<th class=\"border-top-0\">Product</th>");
							out.println("<th class=\"border-top-0\">Quantity</th>");
							out.println("<th class=\"border-top-0\">Unit Price</th>");
							out.println("<th class=\"border-top-0\">Total</th>");							
						out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");
	    for(Games game : gameList.keySet())
	    {
	    	out.println("<tr>");
	    		out.println("<td><a href=\"#\"><img crossorigin=\"anonymous\" src=" + game.getHeader_image() +  "alt=" + game.getName() + "width=\"100\" height=\"100\"\"></a></td>");
	    		out.println("<td><a onclick=\"toDetails(this)\" href=\"#\">" + game.getName()+ "</a></td>");
	    		out.println("<td><a>" + gameList.get(game) + "</a></td>");
	    		out.println("<td><a>" + prices.get(game)+ "$</a></td>");
	    		out.println("<td><a>" + prices.get(game) * gameList.get(game) + "$</a></td>");    		
	    		
	    	out.println("</tr>");
	    	
	    	total = total + (prices.get(game) * gameList.get(game));
	    					
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
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Data Table area End-->
    <!-- Start Footer area-->
    <div class="footer-copyright-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="footer-copy-right">
						<p>Copyright 2020. All rights reserved.</p>
					</div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Footer area-->
    <!-- jquery
		============================================ -->
    <script src="./js3/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="./js3/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="./js3/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="./js3/jquery-price-slider.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="./js3/owl.carousel.min.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="./js3/jquery.scrollUp.min.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="./js3/meanmenu/jquery.meanmenu.js"></script>
    <!-- counterup JS
		============================================ -->
    <script src="./js3/counterup/jquery.counterup.min.js"></script>
    <script src="js/counterup/waypoints.min.js"></script>
    <script src="./js3/counterup/counterup-active.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="./js3/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- sparkline JS
		============================================ -->
    <script src="./js3/sparkline/jquery.sparkline.min.js"></script>
    <script src="./js3/sparkline/sparkline-active.js"></script>
    <!-- flot JS
		============================================ -->
    <script src="./js3/flot/jquery.flot.js"></script>
    <script src="./js3/flot/jquery.flot.resize.js"></script>
    <script src="./js3/flot/flot-active.js"></script>
    <!-- knob JS
		============================================ -->
    <script src="./js3/knob/jquery.knob.js"></script>
    <script src="./js3/knob/jquery.appear.js"></script>
    <script src="./js3/knob/knob-active.js"></script>
    <!--  Chat JS
		============================================ -->
    <script src="./js3/chat/jquery.chat.js"></script>
    <!--  todo JS
		============================================ -->
    <script src="./js3/todo/jquery.todo.js"></script>
	<!--  wave JS
		============================================ -->
    <script src="./js3/wave/waves.min.js"></script>
    <script src="./js3/wave/wave-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="./js3/plugins.js"></script>
    <!-- Data Table JS
		============================================ -->
    <script src="./js3/data-table/jquery.dataTables.min.js"></script>
    <script src="./js3/data-table/data-table-act.js"></script>
    <!-- main JS
		============================================ -->
    <script src="./js3/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
    <script src="./js3/tawk-chat.js"></script>
    
    
<script>
/* var products = [];
async function filterFunction() {
	var date = document.getElementById('date').value;
	var email = document.getElementById('email').value;
	var price = document.getElementById('price').value;
	var product = document.getElementById('product').value;
if(date.length == 0)
{
	date = "null";
}
if(email.length == 0)
{
	email = "null";
}
if(price.length == 0)
{
	price = "null";
}
if(product.length == 0)
{
	product = "null";
}
	console.log("date: " + date);
	console.log("email: " + email);
	console.log("price: " + price);
	console.log("producct: " + product);

	const url = '/CS308RegisterWithJPA/search/fromDB/filteredOrders/' + date + '/' + email + '/'+ price +'/'+ product; 

	const response = await fetch(url);
	const data = await response.json();

	var all = document.querySelector("#all");
	all.innerHTML = "";

	if(data.length == 0){
		document.getElementsByClassName("main")[0].innerHTML = noResult;
	}
	else{		
    	for (var k = 0; k < data.length; k++){
    		products.push(data[k]);
    		fillCard(data[k], k);    	
    	} 
	}
	
	
}

var productHTML = 
    '                                <div class="product">'+
    '                                    <div class="product-img">'+
    '                                        <img crossorigin="anonymous" src="./img/product01.png" alt="">'+
    '                                        <div class="product-label">'+
    '                                        </div>'+
    '                                    </div>'+
    '                                    <div class="product-body">'+
    '                                        <p class="product-category">Category</p>'+
    '                                        <h3 class="product-name"><a href="#">product name goes here</a></h3>'+
    '                                        <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>'+
    '                                        <div class="product-rating">'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                        </div>'+
    '                                    </div>'+
    '                                    <div class="add-to-cart">'+
    '                                        <button onclick="addToCart(this)" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> Add </button>'+
    '                                    </div>'+
    '                                </div>';

    function fillCard(element, k){
    	console.log("started"); 
    	console.log(element.pricesAtThatTime);
        

    } */



    function downloadPDF(){
    	console.log("download as pdf"); 

    	var data = document.getElementById('all');
    	var date = new Date();
    	html2canvas(data).then(canvas => {
    	var imgWidth = 210;
    	var pageHeight = 295;
    	var imgHeight = canvas.height * imgWidth / canvas.width;
    	var heightLeft = imgHeight;

    	  //enter code here
    	  const imgData = canvas.toDataURL('image/png')

    	  var doc = new jsPDF('p', 'mm');
    	  var position = 0;

    	  doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight+15);
    	  heightLeft -= pageHeight;

    	  while (heightLeft >= 0) {
    	    position = heightLeft - imgHeight;
    	    doc.addPage();
    	    doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight + 15);
    	    heightLeft -= pageHeight;
    	  }
    	doc.save ('invoice'+ '_'+date.getTime()+'.pdf')

    	});
    	
    }
    
</script>
    
</body>

</html>