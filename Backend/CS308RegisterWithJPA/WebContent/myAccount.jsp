<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<%@ page import="java.io.PrintWriter"%>

<!--[if gt IE 9]><!-->  
<html> 
	<!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <title>My Account</title>
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:100,200,300,700,800,900' rel='stylesheet' type='text/css'>
        <!-- Library CSS -->
        <link rel="stylesheet" href="css_myAccount/bootstrap.css">
        <link rel="stylesheet" href="css_myAccount/bootstrap-theme.css">
        <link rel="stylesheet" href="css_myAccount/fonts/font-awesome/css_myAccount/font-awesome.css">
        <link rel="stylesheet" href="css_myAccount/animations.css" media="screen">
        <link rel="stylesheet" href="css_myAccount/superfish.css" media="screen">
        <link rel="stylesheet" href="css_myAccount/team-member.css" media="screen">
        <link rel="stylesheet" href="css_myAccount/prettyPhoto.css" media="screen">
        <!-- Theme CSS -->
        <link rel="stylesheet" href="css_myAccount/style.css">
        <!-- Skin -->
        <link rel="stylesheet" href="css_myAccount/colors/green.css" class="colors">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css_myAccount/theme-responsive.css">
        <!-- Switcher CSS -->
        <link href="css_myAccount/switcher.css" rel="stylesheet">
        <link href="css_myAccount/spectrum.css" rel="stylesheet">
        <!-- Favicons -->
        <link rel="shortcut icon" href="img/ico/favicon.ico">
        <link rel="apple-touch-icon" href="img/ico/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="img/ico/apple-touch-icon-72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="img/ico/apple-touch-icon-114.png">
        <link rel="apple-touch-icon" sizes="144x144" href="img/ico/apple-touch-icon-144.png">
        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
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
		<link rel="stylesheet" href="css/searchBar.css">
		<link rel="stylesheet" href="css/register.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        <!--[if IE]>
        <link rel="stylesheet" href="css_myAccount/ie.css">
        <![endif]-->
    </head>
    <body class="page">
<!--         <div class="page-mask">
            <div class="page-loader">
                <div class="spinner"></div>
                Loading...
            </div>
        </div> -->
        <!-- Wrap -->
        <header id="site-header">
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
        <div class="wrap">
            <!-- Header -->
<!--             <header id="header"> -->
                
               
<!--             </header> -->
            <!-- /Header --> 
<!-- Main Section -->
<%
                            	session = request.getSession();
							    if(session.getAttribute("user") != null)
							    {
							        Object temp = session.getAttribute("user");
							        User user = (User) temp;
							        out.println("<h2>Welcome "+user.getName()+"</h2>");	//Admin
							        
							    }
							    else
							    {
							          %><script> alert("You should be logged in to see this page.");
							        window.location = "index.jsp";</script><%
							    }
							    %>
        <section id="main">
            <div class="breadcrumb-wrapper">
                <div class="pattern-overlay">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                                <h2 class="title">My Account</h2>
                            </div>
                            <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                                <div class="breadcrumbs pull-right">
                                    <ul>
                                        <li>You are Now on:</li>
                                        <li><a href="index.jsp">Home</a></li>
                                        <li><a href="shop.jsp">Shop</a></li>
                                        <li>My Account</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Main Content -->
                <div class="content margin-top60 margin-bottom60">
                    <div class="container">
                        <div class="row">
                            <!-- Left Section -->
                            <div class="col-sm-9 col-md-9 col-lg-9">
                                <div class="my-account margin-top">
                                    <div class="row">
                                        <div class="col-sm-6 col-md-6">
                                            <div class="title-box">
                                                <h3>Account Information</h3>
                                            </div>
                                            <ul class="list-unstyled">
                                                <li>
                                                    <div class="form-group">
                                                        <label for="fname">First Name <span class="required">*</span></label>
                                                        <input type="text" name="fname" id="fname" class="form-control" placeholder="Mr.">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="lname">Last Name <span class="required">*</span></label>
                                                        <input type="text" name="lname" id="lname" class="form-control" placeholder="Atiar">
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="form-group">
                                                        <label for="emailAddress">Email Address <span class="required">*</span></label>
                                                        <input type="email" name="email" id="emailAddress" class="form-control" placeholder="mr-atiar@example.com">
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-6 col-md-6">
                                            <div class="title-box">
                                                <h3>Change Password</h3>
                                            </div>
                                            <ul class="list-unstyled">
                                                <li>
                                                    <div class="form-group">
                                                        <label for="cpassword">Current Password <span class="required">*</span></label>
                                                        <input type="password" name="cpassword" id="cpassword" class="form-control">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="npassword">New Password <span class="required">*</span></label>
                                                        <input type="password" name="npassword" id="npassword" class="form-control">
                                                    </div>
                                                </li>
                                                <li>
                                                    <div class="form-group">
                                                        <label for="cnewpassword">Confirm New Password <span class="required">*</span></label>
                                                        <input type="password" name="cnewpassword" id="cnewpassword" class="form-control">
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="buttons-box clearfix">
                                        <button class="btn btn-color">Save</button>
                                        <span class="required pull-right"><b>*</b> Required Field</span>
                                    </div>
                                </div>
                            </div>
                            <!-- /Left Section -->
                            <!-- Sidebar -->
                            <div id="sidebar" class="sidebar col-sm-3 col-md-3 col-lg-3">
                                <div class="widget">
                                    <h3>My Account</h3>
                                    <!-- menu-->
                                    <div id="sidebar-nav">
                                        <ul class="sidebar-nav">
                                            <li class="active">
                                                <a href="myAccount.jsp"><i class="fa fa-user item-icon"></i>Account Information</a>
                                            </li>
                                            <li>
                                                <a href="myPayment.jsp"><i class="fa fa-credit-card"></i>Payment Methods</a>
                                            </li>
                                            <li>
                                                <a href="myAddress.jsp"><i class="fa fa-pencil-square-o item-icon"></i>Address Book</a>
                                            </li>
                                            <li>
                                                <a href="myOrders.html"><i class="fa fa-shopping-cart item-icon"></i>My Orders</a>
                                            </li>
                                        </ul>
                                    </div>
                                    <!-- /menu-->
                                </div>
                            </div>
                            <!-- /Sidebar -->
                        </div>
                    </div>
                </div>
                <!-- /Main Content -->
        </section>
        <!-- /Main Section -->
            
            <!-- Modal -->
            <section id="modals">
                <!-- Login Modal -->
                <div class="modal login fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h2 class="form-signin-heading modal-title" id="myModalLabel">Login</h2>
                            </div>
                            <form method="post" id="login">
                                <div class="modal-body">
                                    <fieldset>
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <input class="form-control" id="username" name="username" type="text" placeholder="Username" value="" required>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <input class="form-control" type="email" id="email" name="email" placeholder="Email" value="" required>
                                            </div>
                                        </div>
                                    </fieldset>
                                </div>
                                <div class="modal-footer">
                                    <a href="password-recovery.html" class="pull-left">(Lost Password?)</a>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-color">Login</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /Login Modal -->
                <!-- Registration Modal -->
                <div class="modal register fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="registrationModal" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                            <h2 class="form-signin-heading modal-title" id="registrationModalLabel">Create a new account</h2>
                        </div>
                        <form method="post" id="registration">
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="col-md-6">
                                                <input type="text" value="" class="form-control" placeholder="First Name">
                                            </div>
                                            <div class="col-md-6">
                                                <input type="text" value="" class="form-control" placeholder="Last Name">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <input type="text" value="" class="form-control" placeholder="E-mail Address">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group">
                                            <div class="col-md-6">
                                                <input type="password" value="" class="form-control" placeholder="Password">
                                            </div>
                                            <div class="col-md-6">
                                                <input type="password" value="" class="form-control" placeholder="Re-enter Password">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-color">Register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /Registration Modal -->
            </section>
            <!-- /Modal -->
            <!-- Scroll To Top --> 
            <a href="#" class="scrollup"><i class="fa fa-angle-up"></i></a>
        </div>
        <!-- /Wrap -->

        <!-- The Scripts -->
<!--         <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-1.0.0.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/revolution-slider/js/jquery.themepunch.plugins.min.js"></script> 
        <script src="js/revolution-slider/js/jquery.themepunch.revolution.min.js"></script>
        <script src="js/jquery.parallax.js"></script>
        <script src="js/jquery.wait.js"></script>
        <script src="js/fappear.js"></script> 
        <script src="js/modernizr-2.6.2.min.js"></script>
        <script src="js/jquery.bxslider.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/superfish.js"></script>
        <script src="js/tweetMachine.js"></script>
        <script src="js/tytabs.js"></script>
        <script src="js/jquery.gmap.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/jquery.countTo.js"></script>
        <script src="js/jflickrfeed.js"></script>
        <script src="js/jquery.knob.js"></script>
        <script src="js/imagesloaded.pkgd.min.js"></script>
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script src="js/waypoints.min.js"></script>
        <script src="js/wow.js"></script>
        <script src="js/jquery.fitvids.js"></script>
        <script src="js/spectrum.js"></script>
        <script src="js/switcher.js"></script>
        <script src="js/custom.js"></script> -->
    </body>
</html>

