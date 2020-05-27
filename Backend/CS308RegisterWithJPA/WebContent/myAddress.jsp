<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<%@ page import="java.io.PrintWriter"%>
<html> 
	<!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <title>My Addresses </title>
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

<script src="js/addressBook.js"></script>
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        <!--[if IE]>
        <link rel="stylesheet" href="css/ie.css">
        <![endif]-->
    </head>
    <body class="page">
        <!-- Wrap -->
        <div class="wrap">
            <!-- Header -->
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
            <!-- /Header --> 
            <%
                            	session = request.getSession();
							    if(session.getAttribute("user") != null)
							    {
							        Object temp = session.getAttribute("user");
							        User user = (User) temp;
							        out.println("<h2>Welcome "+user.getName()+"</h2>");	//Admin
							        %> 
							        <script>
                                                        
							        getData("<%=user.getEmail()%>");
                                                        
                                   </script> 
                                                        
                                    <%
							        
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
                                    <h2 class="title">Address Book</h2>
                                </div>
                                <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                                    <div class="breadcrumbs pull-right">
                                        <ul>
                                            <li>You are Now on:</li>
                                            <li><a href="index.html">Home</a></li>
                                            <li><a href="shop.html">Shop</a></li>
                                            <li>My Address</li>
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
                                <div class="title-box">
                                    <hr/>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6 col-md-6 info-box">
                                        <h3>Default  Address</h3>
                                        <ul class="list-unstyled">
                                                <li>
                                                    <div class="form-group">
                                                        <label for="number"> Address <span class="required">*</span></label>
														<% 
                                                        out.println("<input type='text' name='address' id='address' class='form-control' placeholder='Orta Mah. Universite Cad.' >" ); 
                                                        %>

                                                    </div>
                                                </li>
                                                                                                <li>
                                                    <div class="form-group">
                                                        <label for="number"> Region / City <span class="required">*</span></label>
														<% 
                                                        out.println("<input type='text' name='city' id='city' class='form-control' placeholder='Tuzla / Istanbul' >" ); 
                                                        %>
                                                        
                                                    </div>
                                                </li>
                                                                                                <li>
                                                    <div class="form-group">
                                                        <label for="number"> Phone Number <span class="required">*</span></label>
														<% 
                                                        out.println("<input type='text' name='phone' id='phone' class='form-control' placeholder='5555555555' >" ); 
                                                        %>
                                                        
                                                    </div>
                                                </li>
                                                </ul>
                                            <a href="#" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Update </a>
                                            <br><br>
                                    </div>
                                   
                                </div>
                                <div class="title-box">
                                    <h3>Additional Address Entries</h3>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6 col-md-6 info-box">
                                        <ul class="list-unstyled">
                                                <li>
                                                    <div class="form-group">
                                                        <label for="number"> Address <span class="required">*</span></label>
														<% 
                                                        out.println("<input type='text' name='name' id='name' class='form-control' placeholder='Orta Mah. Universite Cad.' >" ); 
                                                        %>
                                                        
                                                    </div>
                                                </li>
                                                                                                <li>
                                                    <div class="form-group">
                                                        <label for="number"> Region / City <span class="required">*</span></label>
														<% 
                                                        out.println("<input type='text' name='name' id='name' class='form-control' placeholder='Tuzla / Istanbul' >" ); 
                                                        %>
                                                        
                                                    </div>
                                                </li>
                                                                                                <li>
                                                    <div class="form-group">
                                                        <label for="number"> Phone Number <span class="required">*</span></label>
														<% 
                                                        out.println("<input type='text' name='name' id='name' class='form-control' placeholder='5555555555' >" ); 
                                                        %>
                                                        
                                                    </div>
                                                </li>
                                                </ul>
                                            <a href="#" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Update</a> <a href="#" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Delete</a></p>
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
                                            <li >
                                                <a href="myAccount.jsp"><i class="fa fa-user item-icon"></i>Account Information</a>
                                            </li>
                                            <li>
                                                <a href="myPayment.jsp"><i class="fa fa-credit-card"></i>Payment Methods</a>
                                            </li>
                                            <li class="active">
                                                <a href="myAddress.jsp"><i class="fa fa-pencil-square-o item-icon"></i>Address Book</a>
                                            </li>
                                            <li>
                                                <a href="myOrdersss.jsp"><i class="fa fa-shopping-cart item-icon"></i>My Orders</a>
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

            <!-- /Modal -->
            <!-- Scroll To Top --> 
            <a href="#" class="scrollup"><i class="fa fa-angle-up"></i></a>
        </div>
        <!-- /Wrap -->


    </body>
</html>

