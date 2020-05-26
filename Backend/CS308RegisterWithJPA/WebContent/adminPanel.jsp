<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>

<html class="no-js" lang="">

<head>
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
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="./css3/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="./js3/vendor/modernizr-2.8.3.min.js"></script>
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
                        <li class="active"><a data-toggle="tab" href="#Home"><i class="notika-icon notika-house"></i> Home</a></li>
                        <li><a data-toggle="tab" href="#mailbox"><i class="notika-icon notika-mail"></i> Email</a></li>
                        <li><a data-toggle="tab" href="#Charts"><i class="notika-icon notika-bar-chart"></i> Charts</a></li>
                        <li><a data-toggle="tab" href="#Tables"><i class="notika-icon notika-windows"></i> Tables</a></li>
                    </ul>
                    <div class="tab-content custom-menu-content">
                    	<div id="Home" class="tab-pane active notika-tab-menu-bg animated flipInX">
                        	<ul class="notika-main-menu-dropdown">
                            	<li><a href="adminPanel.jsp">Home Page</a></li>
                            </ul>
                        </div>
                        <div id="mailbox" class="tab-pane notika-tab-menu-bg animated flipInX">
                            <ul class="notika-main-menu-dropdown">
                            	<li><a href="mailPage.jsp">Compose Email</a></li>
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
                        <div id="Tables" class="tab-pane notika-tab-menu-bg animated flipInX">
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
							        	out.println("<li><a href=\"admin_Orders_table.jsp\">Orders Table</a></li>");	//Orders
							        }
							        else if(user.getUserType() == User.userType.ProductManager){
							        	out.println("<li><a href=\"admin_Cats_table.jsp\">Category Table</a></li>");	//Category
							        	out.println("<li><a href=\"admin_Games_table.jsp\">Games Table</a></li>");	//Game
							        }
									else if(user.getUserType() == User.userType.SalesManager){
							        	out.println("<li><a href=\"admin_Orders_table.jsp\">Orders Table</a></li>");	//Orders
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
    <!-- Start Status area -->
    <div class="notika-status-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="wb-traffic-inner notika-shadow sm-res-mg-t-30 tb-res-mg-t-30">
                        <div class="website-traffic-ctn">
                            <h2><span class="counter">50,000</span></h2>
                            <p>Total Website Traffics</p>
                        </div>
                        <div class="sparkline-bar-stats1">9,4,8,6,5,6,4,8,3,5,9,5</div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="wb-traffic-inner notika-shadow sm-res-mg-t-30 tb-res-mg-t-30">
                        <div class="website-traffic-ctn">
                            <h2><span class="counter">90,000</span>k</h2>
                            <p>Website Impressions</p>
                        </div>
                        <div class="sparkline-bar-stats2">1,4,8,3,5,6,4,8,3,3,9,5</div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="wb-traffic-inner notika-shadow sm-res-mg-t-30 tb-res-mg-t-30 dk-res-mg-t-30">
                        <div class="website-traffic-ctn">
                            <h2>$<span class="counter">40,000</span></h2>
                            <p>Total Online Sales</p>
                        </div>
                        <div class="sparkline-bar-stats3">4,2,8,2,5,6,3,8,3,5,9,5</div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="wb-traffic-inner notika-shadow sm-res-mg-t-30 tb-res-mg-t-30 dk-res-mg-t-30">
                        <div class="website-traffic-ctn">
                            <h2><span class="counter">1,000</span></h2>
                            <p>Total Support Tickets</p>
                        </div>
                        <div class="sparkline-bar-stats4">2,4,8,4,5,7,4,7,3,5,7,5</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Status area-->
    <!-- Start Sale Statistic area-->
    <div class="sale-statistic-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-8 col-sm-7 col-xs-12">
                    <div class="sale-statistic-inner notika-shadow mg-tb-30">
                        <div class="curved-inner-pro">
                            <div class="curved-ctn">
                                <h2>Sales Statistics</h2>
                                <p>Vestibulum purus quam scelerisque, mollis nonummy metus</p>
                            </div>
                        </div>
                        <div id="curved-line-chart" class="flot-chart-sts flot-chart"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Sale Statistic area-->
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
    <script src="./js3/counterup/waypoints.min.js"></script>
    <script src="./js3/counterup/counterup-active.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="./js3/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- jvectormap JS
		============================================ -->
    <script src="./js3/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="./js3/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="./js3/jvectormap/jvectormap-active.js"></script>
    <!-- sparkline JS
		============================================ -->
    <script src="./js3/sparkline/jquery.sparkline.min.js"></script>
    <script src="./js3/sparkline/sparkline-active.js"></script>
    <!-- sparkline JS
		============================================ -->
    <script src="./js3/flot/jquery.flot.js"></script>
    <script src="./js3/flot/jquery.flot.resize.js"></script>
    <script src="./js3/flot/curvedLines.js"></script>
    <script src="./js3/flot/flot-active.js"></script>
    <!-- knob JS
		============================================ -->
    <script src="./js3/knob/jquery.knob.js"></script>
    <script src="./js3/knob/jquery.appear.js"></script>
    <script src="./js3/knob/knob-active.js"></script>
    <!--  wave JS
		============================================ -->
    <script src="./js3/wave/waves.min.js"></script>
    <script src="./js3/wave/wave-active.js"></script>
    <!--  todo JS
		============================================ -->
    <script src="./js3/todo/jquery.todo.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="./js3/plugins.js"></script>
	<!--  Chat JS
		============================================ -->
    <script src="./js3/chat/moment.min.js"></script>
    <script src="./js3/chat/jquery.chat.js"></script>
    <!-- main JS
		============================================ -->
    <script src="./js3/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
    <script src="./js3/tawk-chat.js"></script>
</body>

</html>