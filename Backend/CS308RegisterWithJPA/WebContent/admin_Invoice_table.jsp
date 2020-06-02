<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.GamesManager"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<%@ page import="cs308.sabanciuniv.edu.OrderManager"%>
<%@ page buffer="522kb" autoFlush="false"%>

<!DOCTYPE html>

<html class="no-js" lang="">

<head>
<script type="text/javascript" src="libs/png_support/zlib.js"></script>
<script type="text/javascript" src="libs/png_support/png.js"></script>
<script type="text/javascript" src="jspdf.plugin.addimage.js"></script>
<script type="text/javascript" src="jspdf.plugin.png_support.js"></script>
<script type="text/javascript" src="jspdf.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script type="text/javascript"
	src="https://html2canvas.hertzen.com/dist/html2canvas.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
	rel="stylesheet">
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
<link rel="stylesheet"
	href="./css3/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- jvectormap CSS
		============================================ -->
<link rel="stylesheet"
	href="./css3/jvectormap/jquery-jvectormap-2.0.3.css">
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<style>
title {
	color: white;
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
	font-size: 40px;
	font-weight: bold;
}

.box {
	border: 3px solid black;
	background-color: white;
	/* background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQpizgTqXwu_qPrqX-7VMso67IJbE73M36wSaNeStJ8zvVs0gy4&usqp=CAU");
   */
	color: white;
	margin: 20px;
	padding: 20px;
	width: 1000px;
}

.border-top-0 {
	width: 1000px;
}

.current {
	color: green;
}

#pagin a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 1px;
  border-radius: 50%;
}

#pagin a.current {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

#pagin a:hover:not(.current) {background-color: #ddd;}

#pagin li {
	display: inline-block;
}
.center {
  text-align: right;
}

.prev {
	cursor: pointer;
}

.next {
	cursor: pointer;
}

.last {
	cursor: pointer;
	margin-left: 5px;
}

.first {
	cursor: pointer;
	margin-right: 5px;
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
                        <a href="adminPanel.jsp"><img src="img/logo.png" alt="" width="50" height="50"/></a>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                    <div class="header-top-menu" style="margin-top:24px; ">
                        
                        <%
                            	session = request.getSession();
							    if(session.getAttribute("user") != null)
							    {
							        Object temp = session.getAttribute("user");
							        User user = (User) temp;
							        if(user.getUserType() == User.userType.Admin){
							        	out.println("<h2>Welcome, Administrator</h2>");	//Admin
							        }
							        else if(user.getUserType() == User.userType.ProductManager){
							        	out.println("<h2>Welcome, Product Manager</h2>");	//ProductManager
							        }
									else if(user.getUserType() == User.userType.SalesManager){
							        	out.println("<h2>Welcome, Sales Manager</h2>");	//SalesManager
							        }
							        else {
							            %><script> alert("you are not authourized to see this page");
							            window.location = "index.jsp";</script><% 
							        }
							    }
							    else
							    {
							          %><script> alert("you are not authourized to see this page");
							        window.location = "index.jsp";</script><%
							    }
							    %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Header Top Area -->
    <!-- Main Menu area start-->
    <div class="main-menu-area mg-tb-40">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
                        <li ><a data-toggle="tab" href="#Home"><i class="notika-icon notika-house"></i> Home</a></li>
                        <li><a data-toggle="tab" href="#mailbox"><i class="notika-icon notika-mail"></i> Email</a></li>
                        <li><a data-toggle="tab" href="#Charts"><i class="notika-icon notika-bar-chart"></i> Charts</a></li>
                        <li class="active"><a data-toggle="tab" href="#Tables"><i class="notika-icon notika-windows"></i> Tables</a></li>
                    </ul>
                    <div class="tab-content custom-menu-content">
                    	<div id="Home" class="tab-pane  notika-tab-menu-bg animated flipInX">
                        	<ul class="notika-main-menu-dropdown">
                            	<li><a href="adminPanel.jsp">Home Page</a></li>
                            </ul>
                        </div>
                        <div id="mailbox" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                            	<li><a href="admin_mailPage.jsp">Compose Email</a></li>
                            </ul>
                        </div>
                        <div id="Charts" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                                <li><a href="admin_charts_flot.jsp">Flot Charts</a>
                                </li>
                                <li><a href="admin_charts_area.jsp">Area Charts</a>
                                </li>
                            </ul>
                        </div>
                        <div id="Tables" class="tab-pane active notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                            	<%
                            	session = request.getSession();
							    if(session.getAttribute("user") != null)
							    {
							        Object temp = session.getAttribute("user");
							        User user = (User) temp;
							        if(user.getUserType() == User.userType.Admin){
							        	out.println("<li><a href=\"admin_Cats_table.jsp\">Category Table</a></li>");	//Category
							        	out.println("<li><a href=\"admin_Games_table.jsp\">Games Table</a></li>");	//Game
							        	out.println("<li><a href=\"admin_Invoice_table.jsp\">Invoice Table</a></li>");	//Orders
							        }
							        else if(user.getUserType() == User.userType.ProductManager){
							        	out.println("<li><a href=\"admin_Cats_table.jsp\">Category Table</a></li>");	//Category
							        	out.println("<li><a href=\"admin_Games_table.jsp\">Games Table</a></li>");	//Game
							        }
									else if(user.getUserType() == User.userType.SalesManager){
							        	out.println("<li><a href=\"admin_Invoice_table.jsp\">Invoice Table</a></li>");	//Orders
							        }
							        else {
							            %><script> alert("you are not authourized to see this page");
							            window.location = "index.jsp";</script><% 
							        }
							    }
							    else
							    {
							          %><script> alert("you are not authourized to see this page");
							        window.location = "index.jsp";</script><%
							    }
							    %>
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
										<p>
											Welcome to Tech Market <span class="bread-ntd">Admin
												Panel Invoice Page</span>
										</p>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-3">
								<div class="breadcomb-report">
									
									<button data-toggle="tooltip" data-placement="left" title="" class="btn waves-effect" data-original-title="Download Report"><i class="notika-icon notika-sent"  onclick="createPDF()"></i></button>
								</div>
							</div>
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
						<table style="width: 100%">
							<tr align="center">
								<td>DATE</td>
								<td>E-MAIL</td>
								<td>PRICE</td>
								<td>PRODUCT</td>
							</tr>
							<tr>
								<td><input style="width: 100%" type="text" name="date"
									id="date"></td>
								<td><input style="width: 100%" type="text" name="email"
									id="email"></td>
								<td><input style="width: 100%" type="text" name="price"
									id="price"></td>
								<td><input style="width: 100%" type="text" name="product"
									id="product"></td>
							</tr>
						</table>

						<a class='btn btn-success btn-block btn-lg'
							onclick="filterFunction()" href="#"
							style="margin-left: auto; margin-right: auto; display: block; margin-top: 10px; margin-bottom: 10px">FILTER</a>
						

						<%
						session = request.getSession();
						if (session.getAttribute("user") != null) {

							OrderManager om = new OrderManager();
							List<Order> orderList;

							if (request.getParameter("email") == null) {
								System.out.println("not filtered");
								orderList = om.getAllOrders();

							} 
							else {
								System.out.println("filtered");

								String date = request.getParameter("date");
								String email = request.getParameter("email");
								String price = request.getParameter("price");
								String product = request.getParameter("product");

								orderList = om.filteredOrders(date, email, price, product);
							}

							out.println("<div class=\"row bar\" id=\"row bar\">");
							//out.println("<div id=\"customer-order\" class=\"col-lg-9\">");

							int orderid = 1;
							for (Order o : orderList) {
								double total = 0;

								Map<Games, Integer> gameList = new HashMap<>();
								gameList = o.getProducts();
								Map<Games, Double> prices = o.getPricesAtThatTime();

								out.println("<div class=\"box\" style=\"width:97%\">");
									out.println("<div>");
										out.println("<table class=\"table\">");
											out.println("<thead>");
												out.println("<tr>");
													out.println("<th class=\"border-top-0\">Order ID: " + o.getId() + "</th>");
													out.println("<th class=\"border-top-0\">User: " + o.getOwner().getEmail() + "</th>"); //get user name
													out.println("<th class=\"border-top-0\">Date: " + o.getDate() + "</th>"); //get order date
													out.println("<th class=\"border-top-0\">Status: " + o.getStatus() + "</th>");
													out.println("<th class=\"border-top-0\">Change Status</th>");
													out.println("<th><select id=\"orderStatus" + orderid + "\">");
														out.println("<option value=\"Null\">---</option>");
														out.println("<option value=\"PreparingPackage\">Preparing Package</option>");
														out.println("<option value=\"Shipped\">Shipped</option>");
														out.println("<option value=\"OutOnDelivery\">Out on Delivery</option>");
														out.println("<option value=\"Delivered\">Delivered</option>");
													out.println("</th>");
													out.println("<th>");
														out.println("<button type=\"button\" onclick=\"updateStatus(this)\">UPDATE</button>");
													out.println("</th>");
												out.println("</tr>");
												out.println("<tr>");
													out.println("<th class=\"border-top-0\"></th>");
													out.println("<th class=\"border-top-0\">Product</th>");
													out.println("<th class=\"border-top-0\">Quantity</th>");
													out.println("<th class=\"border-top-0\">Unit Price</th>");
													out.println("<th class=\"border-top-0\">Total</th>");
												out.println("</tr>");
											out.println("</thead>");
											out.println("<tbody>");
												for (Games game : gameList.keySet()) {
												out.println("<tr>");
													out.println("<td><a href=\"#\"><img crossorigin=\"anonymous\" src=" + game.getHeader_image() + "alt=" + game.getName() + "width=\"212\" height=\"100\"\"></a></td>");
													out.println("<td><a onclick=\"toDetails(this)\" href=\"#\">" + game.getName() + "</a></td>");
													out.println("<td><p>" + gameList.get(game) + "</p></td>");
													out.println("<td><p>" + prices.get(game) + "$</p></td>");
													out.println("<td><p>" + prices.get(game) * gameList.get(game) + "$</p></td>");
												out.println("</tr>");
												total = total + (prices.get(game) * gameList.get(game));
												}
												out.println("<tr>");
													out.println("<div class=\"total\">");
														out.println("<td><a><td><a><td><a><td><a><td><b>" + "Total: " + total + "$</b></td>");
													out.println("</div>");
												out.println("</tr>");
											out.println("</tbody>");
										out.println("</table>");
									out.println("</div>");
								out.println("</div>");

								orderid = orderid + 1;

								}
								//out.println("</div>");
								out.println("</div>");

						} else {
							session.setAttribute("order-error", "Please login before accessing this page!!!!");
							response.setHeader("order-error", "true");
							response.sendRedirect("login.jsp");
							return;
						}
						%>
						<div class="center">
						<ul id="pagin"></ul>
						</div>
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

	<script>
function filterFunction() {
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
	
	var url = 'http://localhost:8080/CS308RegisterWithJPA/admin_Invoice_table.jsp?';
	url += '&date=' + date +'&email=' + email+'&price=' + price+'&product=' + product ;
	window.location.search = url;
}
    function downloadPDF(){
    	console.log("download as pdf"); 

    	var data = document.getElementById('row bar');
    	var date = new Date();
    	html2canvas(data).then(canvas => {
    	var imgWidth = 210;
    	var pageHeight = 295; //295
    	var imgHeight = canvas.height * imgWidth / canvas.width;
    	var heightLeft = imgHeight;

    	  //enter code here
    	  const imgData = canvas.toDataURL('image/png')

    	  var doc = new jsPDF('p', 'mm');
    	  var position = 0;

    	  doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight+15);
    	  heightLeft -= pageHeight;

    	  while (heightLeft >= -5) {
    	    position = heightLeft - imgHeight;
    	    doc.addPage();
    	    doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight + 15);
    	    heightLeft -= pageHeight;
    	  }
    	doc.save ('invoice'+ '_'+date.getTime()+'.pdf')

    	});
    	
    }

    function createPDF(){
    	console.log("download as pdf");
    	var date = new Date();
    	var sTable = document.getElementById('row bar').innerHTML;

        var style = "<style>";
        style = style + "table {width: 100%;font: 17px Calibri;}";
        style = style + "table, th, td {border: solid 1px #DDD; border-collapse: collapse;";
        style = style + "padding: 2px 3px;text-align: center;}";
        style = style + "</style>";

        // CREATE A WINDOW OBJECT.
        var win = window.open('', '', 'height=700,width=700');

        win.document.write('<html><head>');
        win.document.write('<title>Invoice_' + date.getTime()+ '</title>');   // <title> FOR PDF HEADER.
        win.document.write(style);          // ADD STYLE INSIDE THE HEAD TAG.
        win.document.write('</head>');
        win.document.write('<body>');
        win.document.write(sTable);         // THE TABLE CONTENTS INSIDE THE BODY TAG.
        win.document.write('</body></html>');

        win.document.close(); 	// CLOSE THE CURRENT WINDOW.

        win.print();    // PRINT THE CONTENTS.

    }

    function updateStatus(order)
    {
    	//HttpSession session = request.getSession();
		//User user = (User)session.getAttribute("user");
		//if(user.getUserType() == User.userType.Admin || user.getUserType() == User.userType.ProductManager){
			var $row  = $(order).closest("tr");
			var $ths = $row.find("th");
			console.log("ths: " + $ths);
		
			var itemName = $ths[0].innerHTML;
			itemName = itemName.substr(10,2);
			console.log("id: " + itemName);

			var itemName1 = $ths[5].innerHTML;
		
			itemName1 = itemName1.substr(12,itemName1.length-259);
			console.log(itemName1);
		

    		var e = document.getElementById(itemName1);
    		var strUser = e.options[e.selectedIndex].value;
    		console.log(strUser);

  	        var oldstatus = $ths[3].innerHTML;
 	        oldstatus = oldstatus.substr(8);
    		var params = 'order_id='+itemName+'&status='+strUser+'&oldstatus='+oldstatus;
    		console.log(params);


    		var xhr = new XMLHttpRequest();
     	    var url = "ChangeStatusServlet";
     	    xhr.open("POST", url, true);
     	    
        
    	    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
     	    xhr.addEventListener('readystatechange', function (e) {
     	       if(this.readyState === 4 )
     	       {
                   var returnedResponse = xhr.getResponseHeader("aybars");
                   if(returnedResponse === "Admin"|| returnedResponse ==="ProductManager"){
						alert("You have successfully changed the status");
                       }
                   else{
                	   alert("You are not authorized to change status");
                       }
     	        //      // Then Refresh Page
     	           window.location = "admin_Invoice_table.jsp";
     	       }
    	    });
    	
    	    xhr.send(params);
    	    /*
    	    var email = $ths[1].innerHTML;
 	        email = email.substr(6);


        
 	        console.log("your email: "+ email);

  	        var emailarray = email.split("@");
   	        var recipient = emailarray[0];

   	    	var newparams = 'messageInput='+'Hello '+recipient+ '\n\nYour order with the order id '+ itemName +' has changed it\'s status from '+ oldstatus+' to '+ strUser+'.\n\nThanks for your purchase!!!&topic=Updated Order Status'+'&RecipientString=' + email;
   	 		console.log(newparams);

   		 	var xhr2 = new XMLHttpRequest();
      	    var url2 = "http://localhost:8080/CS308RegisterWithJPA/SendMailsServlet";
        	xhr2.open("POST", url2, true);
        	xhr2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        
    	
        xhr2.send(newparams);
        */
		//}
     //   else{
	//		alert("You are not authorized to update status");
     //       }
    }

  ///////////////////////////////////////////////////Pagination
    var pageSize = 5;

	var pageCount =  $(".box").length / pageSize;
    
     for(var i = 0 ; i<pageCount;i++){
        
       $("#pagin").append('<li><a href="#">'+(i+1)+'</a></li> ');
     }
        $("#pagin li").first().find("a").addClass("current")
    showPage = function(page) {
	    $(".box").hide();
	    $(".box").each(function(n) {
	        if (n >= pageSize * (page - 1) && n < pageSize * page)
	            $(this).show();
	    });        
	}
    
	showPage(1);

	$("#pagin li a").click(function() {
	    $("#pagin li a").removeClass("current");
	    $(this).addClass("current");
	    showPage(parseInt($(this).text())) 
	});

    
</script>

</body>

</html>