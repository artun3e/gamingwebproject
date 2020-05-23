<%@ page contentType="text/html;charset=UTF-8" language="java"
		 pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.GamesManager"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<!DOCTYPE html>

<html class="no-js" lang="">

<head>
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
			
	<link rel="stylesheet" href="./css3/chosen.css">
	<link rel="stylesheet" href="./css3/prism.css">
	<script src="./js3/chosen.proto.js"></script>	
	<script src="./js3/chosen.jquery.js"></script>	
	<script src="./js3/prism.js"></script>	
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
					<a href="#"><img src="img/logo/logo.png" alt="" /></a>
				</div>
			</div>
			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
				<div class="header-top-menu">
					<ul class="nav navbar-nav notika-top-nav">
						<li class="nav-item dropdown"><a href="#"
														 data-toggle="dropdown" role="button" aria-expanded="false"
														 class="nav-link dropdown-toggle"><span><i
								class="notika-icon notika-search"></i></span></a>
							<div role="menu"
								 class="dropdown-menu search-dd animated flipInX">
								<div class="search-input">
									<i class="notika-icon notika-left-arrow"></i> <input
										type="text" />
								</div>
							</div></li>
						<li class="nav-item dropdown"><a href="#"
														 data-toggle="dropdown" role="button" aria-expanded="false"
														 class="nav-link dropdown-toggle"><span><i
								class="notika-icon notika-mail"></i></span></a>
							<div role="menu"
								 class="dropdown-menu message-dd animated zoomIn">
								<div class="hd-mg-tt">
									<h2>Messages</h2>
								</div>
								<div class="hd-message-info">
									<a href="#">
										<div class="hd-message-sn">
											<div class="hd-message-img">
												<img src="img/post/1.jpg" alt="" />
											</div>
											<div class="hd-mg-ctn">
												<h3>David Belle</h3>
												<p>Cum sociis natoque penatibus et magnis dis
													parturient montes</p>
											</div>
										</div>
									</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/2.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Jonathan Morris</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/4.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Fredric Mitchell</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/1.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>David Belle</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/2.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Glenn Jecobs</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a>
								</div>
								<div class="hd-mg-va">
									<a href="#">View All</a>
								</div>
							</div></li>
						<li class="nav-item nc-al"><a href="#"
													  data-toggle="dropdown" role="button" aria-expanded="false"
													  class="nav-link dropdown-toggle"><span><i
								class="notika-icon notika-alarm"></i></span>
							<div class="spinner4 spinner-4"></div>
							<div class="ntd-ctn">
								<span>3</span>
							</div></a>
							<div role="menu"
								 class="dropdown-menu message-dd notification-dd animated zoomIn">
								<div class="hd-mg-tt">
									<h2>Notification</h2>
								</div>
								<div class="hd-message-info">
									<a href="#">
										<div class="hd-message-sn">
											<div class="hd-message-img">
												<img src="img/post/1.jpg" alt="" />
											</div>
											<div class="hd-mg-ctn">
												<h3>David Belle</h3>
												<p>Cum sociis natoque penatibus et magnis dis
													parturient montes</p>
											</div>
										</div>
									</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/2.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Jonathan Morris</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/4.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Fredric Mitchell</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/1.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>David Belle</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img">
											<img src="img/post/2.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Glenn Jecobs</h3>
											<p>Cum sociis natoque penatibus et magnis dis
												parturient montes</p>
										</div>
									</div>
								</a>
								</div>
								<div class="hd-mg-va">
									<a href="#">View All</a>
								</div>
							</div></li>
						<li class="nav-item"><a href="#" data-toggle="dropdown"
												role="button" aria-expanded="false"
												class="nav-link dropdown-toggle"><span><i
								class="notika-icon notika-menus"></i></span>
							<div class="spinner4 spinner-4"></div>
							<div class="ntd-ctn">
								<span>2</span>
							</div></a>
							<div role="menu"
								 class="dropdown-menu message-dd task-dd animated zoomIn">
								<div class="hd-mg-tt">
									<h2>Tasks</h2>
								</div>
								<div class="hd-message-info hd-task-info">
									<div class="skill">
										<div class="progress">
											<div class="lead-content">
												<p>HTML5 Validation Report</p>
											</div>
											<div class="progress-bar wow fadeInLeft" data-progress="95%"
												 style="width: 95%;" data-wow-duration="1.5s"
												 data-wow-delay="1.2s">
												<span>95%</span>
											</div>
										</div>
										<div class="progress">
											<div class="lead-content">
												<p>Google Chrome Extension</p>
											</div>
											<div class="progress-bar wow fadeInLeft" data-progress="85%"
												 style="width: 85%;" data-wow-duration="1.5s"
												 data-wow-delay="1.2s">
												<span>85%</span>
											</div>
										</div>
										<div class="progress">
											<div class="lead-content">
												<p>Social Internet Projects</p>
											</div>
											<div class="progress-bar wow fadeInLeft" data-progress="75%"
												 style="width: 75%;" data-wow-duration="1.5s"
												 data-wow-delay="1.2s">
												<span>75%</span>
											</div>
										</div>
										<div class="progress">
											<div class="lead-content">
												<p>Bootstrap Admin</p>
											</div>
											<div class="progress-bar wow fadeInLeft" data-progress="65%"
												 style="width: 65%;" data-wow-duration="1.5s"
												 data-wow-delay="1.2s">
												<span>65%</span>
											</div>
										</div>
										<div class="progress progress-bt">
											<div class="lead-content">
												<p>Youtube App</p>
											</div>
											<div class="progress-bar wow fadeInLeft" data-progress="55%"
												 style="width: 55%;" data-wow-duration="1.5s"
												 data-wow-delay="1.2s">
												<span>55%</span>
											</div>
										</div>
									</div>
								</div>
								<div class="hd-mg-va">
									<a href="#">View All</a>
								</div>
							</div></li>
						<li class="nav-item"><a href="#" data-toggle="dropdown"
												role="button" aria-expanded="false"
												class="nav-link dropdown-toggle"><span><i
								class="notika-icon notika-chat"></i></span></a>
							<div role="menu"
								 class="dropdown-menu message-dd chat-dd animated zoomIn">
								<div class="hd-mg-tt">
									<h2>Chat</h2>
								</div>
								<div class="search-people">
									<i class="notika-icon notika-left-arrow"></i> <input
										type="text" placeholder="Search People" />
								</div>
								<div class="hd-message-info">
									<a href="#">
										<div class="hd-message-sn">
											<div class="hd-message-img chat-img">
												<img src="img/post/1.jpg" alt="" />
												<div class="chat-avaible">
													<i class="notika-icon notika-dot"></i>
												</div>
											</div>
											<div class="hd-mg-ctn">
												<h3>David Belle</h3>
												<p>Available</p>
											</div>
										</div>
									</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img chat-img">
											<img src="img/post/2.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Jonathan Morris</h3>
											<p>Last seen 3 hours ago</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img chat-img">
											<img src="img/post/4.jpg" alt="" />
										</div>
										<div class="hd-mg-ctn">
											<h3>Fredric Mitchell</h3>
											<p>Last seen 2 minutes ago</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img chat-img">
											<img src="img/post/1.jpg" alt="" />
											<div class="chat-avaible">
												<i class="notika-icon notika-dot"></i>
											</div>
										</div>
										<div class="hd-mg-ctn">
											<h3>David Belle</h3>
											<p>Available</p>
										</div>
									</div>
								</a> <a href="#">
									<div class="hd-message-sn">
										<div class="hd-message-img chat-img">
											<img src="img/post/2.jpg" alt="" />
											<div class="chat-avaible">
												<i class="notika-icon notika-dot"></i>
											</div>
										</div>
										<div class="hd-mg-ctn">
											<h3>Glenn Jecobs</h3>
											<p>Available</p>
										</div>
									</div>
								</a>
								</div>
								<div class="hd-mg-va">
									<a href="#">View All</a>
								</div>
							</div></li>
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
							<li><a data-toggle="collapse" data-target="#Charts"
								   href="#">Home</a>
								<ul class="collapse dropdown-header-top">
									<li><a href="index.html">Dashboard One</a></li>
									<li><a href="index-2.html">Dashboard Two</a></li>
									<li><a href="index-3.html">Dashboard Three</a></li>
									<li><a href="index-4.html">Dashboard Four</a></li>
									<li><a href="analytics.html">Analytics</a></li>
									<li><a href="widgets.html">Widgets</a></li>
								</ul></li>
							<li><a data-toggle="collapse" data-target="#demoevent"
								   href="#">Email</a>
								<ul id="demoevent" class="collapse dropdown-header-top">
									<li><a href="inbox.html">Inbox</a></li>
									<li><a href="view-email.html">View Email</a></li>
									<li><a href="compose-email.html">Compose Email</a></li>
								</ul></li>
							<li><a data-toggle="collapse" data-target="#democrou"
								   href="#">Interface</a>
								<ul id="democrou" class="collapse dropdown-header-top">
									<li><a href="animations.html">Animations</a></li>
									<li><a href="google-map.html">Google Map</a></li>
									<li><a href="data-map.html">Data Maps</a></li>
									<li><a href="code-editor.html">Code Editor</a></li>
									<li><a href="image-cropper.html">Images Cropper</a></li>
									<li><a href="wizard.html">Wizard</a></li>
								</ul></li>
							<li><a data-toggle="collapse" data-target="#demolibra"
								   href="#">Charts</a>
								<ul id="demolibra" class="collapse dropdown-header-top">
									<li><a href="flot-charts.html">Flot Charts</a></li>
									<li><a href="bar-charts.html">Bar Charts</a></li>
									<li><a href="line-charts.html">Line Charts</a></li>
									<li><a href="area-charts.html">Area Charts</a></li>
								</ul></li>
							<li><a data-toggle="collapse" data-target="#demodepart"
								   href="#">Tables</a>
								<ul id="demodepart" class="collapse dropdown-header-top">
									<li><a href="data_table_Cats">Category Table</a></li>
									<li><a href="data_table_Games">Games Table</a></li>
								</ul></li>
							<li><a data-toggle="collapse" data-target="#demo" href="#">Forms</a>
								<ul id="demo" class="collapse dropdown-header-top">
									<li><a href="form-elements.html">Form Elements</a></li>
									<li><a href="form-components.html">Form Components</a></li>
									<li><a href="form-examples.html">Form Examples</a></li>
								</ul></li>
							<li><a data-toggle="collapse"
								   data-target="#Miscellaneousmob" href="#">App views</a>
								<ul id="Miscellaneousmob" class="collapse dropdown-header-top">
									<li><a href="notification.html">Notifications</a></li>
									<li><a href="alert.html">Alerts</a></li>
									<li><a href="modals.html">Modals</a></li>
									<li><a href="buttons.html">Buttons</a></li>
									<li><a href="tabs.html">Tabs</a></li>
									<li><a href="accordion.html">Accordion</a></li>
									<li><a href="dialog.html">Dialogs</a></li>
									<li><a href="popovers.html">Popovers</a></li>
									<li><a href="tooltips.html">Tooltips</a></li>
									<li><a href="dropdown.html">Dropdowns</a></li>
								</ul></li>
							<li><a data-toggle="collapse" data-target="#Pagemob"
								   href="#">Pages</a>
								<ul id="Pagemob" class="collapse dropdown-header-top">
									<li><a href="contact.html">Contact</a></li>
									<li><a href="invoice.html">Invoice</a></li>
									<li><a href="typography.html">Typography</a></li>
									<li><a href="color.html">Color</a></li>
									<li><a href="login-register.html">Login Register</a></li>
									<li><a href="404.html">404 Page</a></li>
								</ul></li>
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
					<li><a data-toggle="tab" href="#Home"><i
							class="notika-icon notika-house"></i> Home</a></li>
					<li><a data-toggle="tab" href="#mailbox"><i
							class="notika-icon notika-mail"></i> Email</a></li>
					<li><a data-toggle="tab" href="#Interface"><i
							class="notika-icon notika-edit"></i> Interface</a></li>
					<li><a data-toggle="tab" href="#Charts"><i
							class="notika-icon notika-bar-chart"></i> Charts</a></li>
					<li class="active"><a data-toggle="tab" href="#Tables"><i
							class="notika-icon notika-windows"></i> Tables</a></li>
					<li><a data-toggle="tab" href="#Forms"><i
							class="notika-icon notika-form"></i> Forms</a></li>
					<li><a data-toggle="tab" href="#Appviews"><i
							class="notika-icon notika-app"></i> App views</a></li>
					<li><a data-toggle="tab" href="#Page"><i
							class="notika-icon notika-support"></i> Pages</a></li>
				</ul>
				<div class="tab-content custom-menu-content">
					<div id="Home"
						 class="tab-pane in notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="index.html">Dashboard One</a></li>
							<li><a href="index-2.html">Dashboard Two</a></li>
							<li><a href="index-3.html">Dashboard Three</a></li>
							<li><a href="index-4.html">Dashboard Four</a></li>
							<li><a href="analytics.html">Analytics</a></li>
							<li><a href="widgets.html">Widgets</a></li>
						</ul>
					</div>
					<div id="mailbox"
						 class="tab-pane notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="inbox.html">Inbox</a></li>
							<li><a href="view-email.html">View Email</a></li>
							<li><a href="compose-email.html">Compose Email</a></li>
						</ul>
					</div>
					<div id="Interface"
						 class="tab-pane notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="animations.html">Animations</a></li>
							<li><a href="google-map.html">Google Map</a></li>
							<li><a href="data-map.html">Data Maps</a></li>
							<li><a href="code-editor.html">Code Editor</a></li>
							<li><a href="image-cropper.html">Images Cropper</a></li>
							<li><a href="wizard.html">Wizard</a></li>
						</ul>
					</div>
					<div id="Charts"
						 class="tab-pane notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="flot-charts.html">Flot Charts</a></li>
							<li><a href="bar-charts.html">Bar Charts</a></li>
							<li><a href="line-charts.html">Line Charts</a></li>
							<li><a href="area-charts.html">Area Charts</a></li>
						</ul>
					</div>
					<div id="Tables"
						 class="tab-pane active notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="data_table_Cats.jsp">Category Table</a></li>
							<li><a href="data_table_Games.jsp">Games Table</a></li>
						</ul>
					</div>
					<div id="Forms"
						 class="tab-pane notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="form-elements.html">Form Elements</a></li>
							<li><a href="form-components.html">Form Components</a></li>
							<li><a href="form-examples.html">Form Examples</a></li>
						</ul>
					</div>
					<div id="Appviews"
						 class="tab-pane notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="notification.html">Notifications</a></li>
							<li><a href="alert.html">Alerts</a></li>
							<li><a href="modals.html">Modals</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="tabs.html">Tabs</a></li>
							<li><a href="accordion.html">Accordion</a></li>
							<li><a href="dialog.html">Dialogs</a></li>
							<li><a href="popovers.html">Popovers</a></li>
							<li><a href="tooltips.html">Tooltips</a></li>
							<li><a href="dropdown.html">Dropdowns</a></li>
						</ul>
					</div>
					<div id="Page"
						 class="tab-pane notika-tab-menu-bg animated flipInX">
						<ul class="notika-main-menu-dropdown">
							<li><a href="contact.html">Contact</a></li>
							<li><a href="invoice.html">Invoice</a></li>
							<li><a href="typography.html">Typography</a></li>
							<li><a href="color.html">Color</a></li>
							<li><a href="login-register.html">Login Register</a></li>
							<li><a href="404.html">404 Page</a></li>
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
									<h2>Games Table</h2>
									<p>
										Welcome to Tech Market <span class="bread-ntd">Admin
												Panel Games Table</span>
									</p>
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
				<div class="col-lg-12">
					<p class="lead">
						Adding Game
					</p>
					<div class="row justify-content-md-center" >
						<div class="col-8" style="margin-left: 14px;">
							<form action='' method=POST>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Game ID:</label>
									<div class="col-sm-10">
										<input  type="text" class="form-control" name="id" id="id" value="" placeholder="Will be automatically assigned" readonly/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Game Name:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="name" id="name"  placeholder="Game Name"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Publisher: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="publisher" id="publisher" placeholder="Publisher"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Categories: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="categories" id="categories" placeholder="Categories"/>
									</div>
									<div class="chosen-container chosen-container-multi" title="" style="width: 350px;">
										<ul class="chosen-choices">
										  <li class="search-choice"><span>Sloth Bear</span><a class="search-choice-close" data-option-array-index="5"></a></li><li class="search-choice"><span>Polar Bear</span><a class="search-choice-close" data-option-array-index="7"></a></li><li class="search-choice"><span>Brown Bear</span><a class="search-choice-close" data-option-array-index="3"></a></li><li class="search-field">
										    <input class="chosen-search-input" type="text" autocomplete="off" value="Your Favorite Types of Bear" tabindex="8" style="width: 25px;">
										  </li>
										</ul>
										<div class="chosen-drop">
											<ul class="chosen-results">
										  		<li class="active-result" data-option-array-index="1">American Black Bear</li>
												<li class="active-result" data-option-array-index="2">Asiatic Black Bear</li>
												<li class="result-selected" data-option-array-index="3">Brown Bear</li>
												<li class="active-result" data-option-array-index="4">Giant Panda</li>
												<li class="result-selected" data-option-array-index="5">Sloth Bear</li>
												<li class="active-result" data-option-array-index="6">Sun Bear</li>
												<li class="result-selected" data-option-array-index="7">Polar Bear</li>
												<li class="active-result" data-option-array-index="8">Spectacled Bear</li>
											</ul>
										</div>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Price: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="price" id="price" placeholder="Price"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Short Description: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="shortdescription" id="shortdescription" placeholder="Short Description"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Detailed Description: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="detaileddescription" id="detaileddescription" placeholder="Detailed Description"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Minimum Requirements: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="minimum" id="minimum" placeholder="Minimum Requirements"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">About the game: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="aboutthegame" id="aboutthegame" placeholder="About the game"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Background: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="background" id="background" placeholder="Background"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Screenshots: </label>
									<div class="col-sm-10">
										<textarea style="rows='2'" type="text" class="form-control" name="screenshots" id="screenshots" placeholder="Screenshots"></textarea>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Header Image: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="headerimage" id="headerimage" placeholder="Header Image"/>
									</div>
								</div>
								<div class="form-group row" style="margin-left: 14px;">
									<label style="margin-top: 7px;" class="col-sm-2 col-form-label">Platforms: </label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="platforms" id="platforms" placeholder="Platforms"/>
									</div>
								</div>
								<button type="submit" class="btn btn-primary btn-block btn-lg"
										name="edit">ADD</button>

								<a class='btn btn-success btn-block btn-lg' href="data_table_Games.jsp"
								   style="margin-left: auto; margin-right: auto; display: block; margin-top: 5%; margin-bottom: 0%">Take
									Me To The Games List</a>
							</form>
						</div>
						<div class="col-3"></div>
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
<!-- tawk chat JS
    ============================================ -->
<script src="./js3/tawk-chat.js"></script>
</body>

</html>