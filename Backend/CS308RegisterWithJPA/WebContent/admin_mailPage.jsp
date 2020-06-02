<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<!DOCTYPE html>

<html class="no-js" lang="">

<head>


<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Mail Page</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
	rel="stylesheet">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="css3/bootstrap.min.css">
<!-- font awesome CSS
		============================================ -->
<link rel="stylesheet" href="css3/font-awesome.min.css">
<!-- owl.carousel CSS
		============================================ -->
<link rel="stylesheet" href="css3/owl.carousel.css">
<link rel="stylesheet" href="css3/owl.theme.css">
<link rel="stylesheet" href="css3/owl.transitions.css">
<!-- meanmenu CSS
		============================================ -->
<link rel="stylesheet" href="css3/meanmenu/meanmenu.min.css">
<!-- animate CSS
		============================================ -->
<link rel="stylesheet" href="css3/animate.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet" href="css3/normalize.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet"
	href="css3/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- Notika icon CSS
		============================================ -->
<link rel="stylesheet" href="css3/notika-custom-icon.css">
<!-- wave CSS
		============================================ -->
<link rel="stylesheet" href="css3/wave/waves.min.css">
<link rel="stylesheet" href="css3/wave/button.css">
<!-- main CSS
		============================================ -->
<link rel="stylesheet" href="css3/main.css">
<!-- style CSS
		============================================ -->
<link rel="stylesheet" href="style.css">
<!-- responsive CSS
		============================================ -->
<link rel="stylesheet" href="css3/responsive.css">
<!-- modernizr JS
		============================================ -->
<script src="js3/vendor/modernizr-2.8.3.min.js"></script>
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
						<a href="adminPanel.jsp"><img src="img/logo.png" alt=""
							width="50" height="50" /></a>
					</div>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
					<div class="header-top-menu" style="margin-top: 24px;">

						<%
							session = request.getSession();
							if (session.getAttribute("user") != null) {
								Object temp = session.getAttribute("user");
								User user = (User) temp;
								if (user.getUserType() == User.userType.Admin) {
									out.println("<h2>Administrator</h2>"); //Admin
								} else if (user.getUserType() == User.userType.ProductManager) {
									out.println("<h2>Product Manager</h2>"); //ProductManager
								} else if (user.getUserType() == User.userType.SalesManager) {
									out.println("<h2>Sales Manager</h2>"); //SalesManager
								} else {
						%><script>
																				alert("you are not authourized to see this page");
																				window.location = "index.jsp";
																			</script>
						<%
							}
							} else {
						%><script>
																		alert("you are not authourized to see this page");
																		window.location = "index.jsp";
																	</script>
						<%
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
						<li><a data-toggle="tab" href="#Home"><i
								class="notika-icon notika-house"></i> Home</a></li>
						<li class="active"><a data-toggle="tab" href="#mailbox"><i
								class="notika-icon notika-mail"></i> Email</a></li>
						<li><a data-toggle="tab" href="#Charts"><i
								class="notika-icon notika-bar-chart"></i> Charts</a></li>
						<li><a data-toggle="tab" href="#Tables"><i
								class="notika-icon notika-windows"></i> Tables</a></li>
					</ul>
					<div class="tab-content custom-menu-content">
						<div id="Home"
							class="tab-pane  notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="adminPanel.jsp">Home Page</a></li>
							</ul>
						</div>
						<div id="mailbox"
							class="tab-pane active notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="admin_mailPage.jsp">Compose Email</a></li>
							</ul>
						</div>
						<div id="Charts"
							class="tab-pane notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="admin_charts_flot.jsp">Flot Charts</a></li>
								<li><a href="admin_charts_area.jsp">Area Charts</a></li>
							</ul>
						</div>
						<div id="Tables"
							class="tab-pane notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<%
									session = request.getSession();
									if (session.getAttribute("user") != null) {
										Object temp = session.getAttribute("user");
										User user = (User) temp;
										if (user.getUserType() == User.userType.Admin) {
											out.println("<li><a href=\"admin_Cats_table.jsp\">Category Table</a></li>"); //Category
											out.println("<li><a href=\"admin_Games_table.jsp\">Games Table</a></li>"); //Game
											out.println("<li><a href=\"admin_Invoice_table.jsp\">Invoice Table</a></li>"); //Orders
										} else if (user.getUserType() == User.userType.ProductManager) {
											out.println("<li><a href=\"admin_Cats_table.jsp\">Category Table</a></li>"); //Category
											out.println("<li><a href=\"admin_Games_table.jsp\">Games Table</a></li>"); //Game
										} else if (user.getUserType() == User.userType.SalesManager) {
											out.println("<li><a href=\"admin_Invoice_table.jsp\">Invoice Table</a></li>"); //Orders
										} else {
								%><script>
																				alert("you are not authourized to see this page");
																				window.location = "index.jsp";
																			</script>
								<%
									}
									} else {
								%><script>
																		alert("you are not authourized to see this page");
																		window.location = "index.jsp";
																	</script>
								<%
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
										<i class="notika-icon notika-mail"></i>
									</div>
									<div class="breadcomb-ctn">
										<h2>Compose Email</h2>
										<p>
											Welcome to Admin Email Page</span>
										</p>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-3"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcomb area End-->
	<!-- Compose email area Start-->
	<div class="inbox-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="view-mail-list sm-res-mg-t-30">
						<div class="view-mail-hd">
							<div class="view-mail-hrd">
								<h2>New Message</h2>
							</div>
						</div>
						<div class="cmp-int mg-t-20">
							<div class="row">
								<div class="col-lg-1 col-md-2 col-sm-2 col-xs-12">
									<div class="cmp-int-lb cmp-int-lb1 text-right">
										<span>To: </span>
									</div>
								</div>
								<div class="col-lg-11 col-md-10 col-sm-10 col-xs-12">
									<div class="form-group">
										<div class="nk-int-st cmp-int-in cmp-email-over">
											<input id="myemail" name="myemail" type="email"
												class="form-control" placeholder="example@email.com" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-1 col-md-2 col-sm-2 col-xs-12">
									<div class="cmp-int-lb cmp-int-lb1 text-right">
										<span>Cc: </span>
									</div>
								</div>
								<div class="col-lg-11 col-md-10 col-sm-10 col-xs-12">
									<div class="form-group">
										<div class="nk-int-st cmp-int-in cmp-email-over">
											<input type="email" class="form-control" placeholder="" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-1 col-md-2 col-sm-2 col-xs-12">
									<div class="cmp-int-lb cmp-int-lb1 text-right">
										<!-- <span>Subject: </span> -->
										<span>Subject: </span>
										<textarea
											style="margin-top: -10px; margin-left: 90px; width: 1010px;"
											name="subject" id="subject" rows="1" cols="112"></textarea>
									</div>
								</div>
								<div class="col-lg-11 col-md-10 col-sm-10 col-xs-12">
									<div class="form-group cmp-em-mg">
										<!-- <div class="nk-int-st cmp-int-in cmp-email-over">
                                            <input type="text" class="form-control" placeholder="" />
                                        </div> -->
									</div>
								</div>
							</div>
						</div>
						<div class="cmp-int-box mg-t-20">
							<div class="text-area">
								<textarea style="width: 1100px;" name="myMessage" id="myMessage"
									rows="10" cols="112" placeholder="Write your mail here..."></textarea>
							</div>
						</div>
						<div class="multiupload-sys">
							<div id="dropzone" class="dropmail">
								<form action="/upload"
									class="dropzone dropzone-custom needsclick" id="demo-upload">
									<div class="dz-message needsclick download-custom">
										<i class="notika-icon notika-cloud" aria-hidden="true"></i>
										<h2>Drop files here or click to upload.</h2>
										<p>
											<span class="note needsclick">(This is just a demo
												dropzone. Selected files are <strong>not</strong> actually
												uploaded.)
											</span>
										</p>
									</div>
								</form>
							</div>
						</div>
						<div class="vw-ml-action-ls text-right mg-t-20">
							<div class="btn-group ib-btn-gp active-hook nk-email-inbox">
								<button class="btn btn-default btn-sm waves-effect">
									<i class="notika-icon notika-next"></i> Reply
								</button>
								<button class="btn btn-default btn-sm waves-effect">
									<i class="notika-icon notika-right-arrow"></i> Forward
								</button>
								<button onclick="sendMailTo()"
									class="btn btn-default btn-sm waves-effect">
									<i class="notika-icon notika-down-arrow"></i> Send
								</button>
								<button onclick="sendAll()"
									class="btn btn-default btn-sm waves-effect">
									<i class="notika-icon notika-trash"></i> Send All
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Compose email area End-->
	<!-- Start Footer area-->
	<div class="footer-copyright-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="footer-copy-right">
						<p>
							Copyright © 2018 . All rights reserved. Template by <a
								href="https://colorlib.com">Colorlib</a>.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function sendAll() {
			var messageVariable = document.getElementById("myMessage").value;
			var topicVariable = document.getElementById("subject").value;

			console.log("your message: " + messageVariable.value);
			console.log("your topic: "
					+ document.getElementById("subject").value);
			

			var xhr = new XMLHttpRequest();
			var url = "SendAllServlet";
			xhr.open("POST", url, true);
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			var params = 'topic=' + topicVariable + '&messageInput='
					+ messageVariable;
			xhr.send(params);
		}

		function sendMailTo() {
			var messageVariable = document.getElementById("myMessage").value;
			var topicVariable = document.getElementById("subject").value;
			var myemail = document.getElementById("myemail").value;

			console.log("your message: " + messageVariable);
			console.log("your topic: "	+ topicVariable);
			console.log("your email: " + myemail);

			var newparams = 'messageInput=' + messageVariable + '&topic='
					+ topicVariable + '&RecipientString=' + myemail;
			console.log(newparams);

			var xhr2 = new XMLHttpRequest();
			var url2 = "http://localhost:8080/CS308RegisterWithJPA/SendMailsServlet";
			xhr2.open("POST", url2, true);

			xhr2.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr2.addEventListener('readystatechange', function(e) {
				if (this.readyState === 4) {
					alert("You have successfuly send mail!"); // Then Refresh Page
					window.location = "admin_mailPage.jsp";
				}
			});

			xhr2.send(newparams);
		}
	</script>

	<!-- End Footer area-->
	<!-- jquery
		============================================ -->
	<script src="js3/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="js3/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="js3/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script src="js3/jquery-price-slider.js"></script>
	<!-- owl.carousel JS
		============================================ -->
	<script src="js3/owl.carousel.min.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script src="js3/jquery.scrollUp.min.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script src="js3/meanmenu/jquery.meanmenu.js"></script>
	<!-- counterup JS
		============================================ -->
	<script src="js3/counterup/jquery.counterup.min.js"></script>
	<script src="js3/counterup/waypoints.min.js"></script>
	<script src="js3/counterup/counterup-active.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script src="js3/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- sparkline JS
		============================================ -->
	<script src="js3/sparkline/jquery.sparkline.min.js"></script>
	<script src="js3/sparkline/sparkline-active.js"></script>
	<!-- flot JS
		============================================ -->
	<script src="js3/flot/jquery.flot.js"></script>
	<script src="js3/flot/jquery.flot.resize.js"></script>
	<script src="js3/flot/flot-active.js"></script>
	<!-- knob JS
		============================================ -->
	<script src="js3/knob/jquery.knob.js"></script>
	<script src="js3/knob/jquery.appear.js"></script>
	<script src="js3/knob/knob-active.js"></script>
	<!-- summernote JS
		============================================ -->
	<script src="js3/summernote/summernote-updated.min.js"></script>
	<script src="js3/summernote/summernote-active.js"></script>
	<!-- dropzone JS
		============================================ -->
	<script src="js3/dropzone/dropzone.js"></script>
	<!--  wave JS
		============================================ -->
	<script src="js3/wave/waves.min.js"></script>
	<script src="js3/wave/wave-active.js"></script>
	<!-- icheck JS
		============================================ -->
	<script src="js3/icheck/icheck.min.js"></script>
	<script src="js3/icheck/icheck-active.js"></script>
	<!--  Chat JS
		============================================ -->
	<script src="js3/chat/jquery.chat.js"></script>
	<!--  todo JS
		============================================ -->
	<script src="js3/todo/jquery.todo.js"></script>
	<!-- plugins JS
		============================================ -->
	<script src="js3/plugins.js"></script>
	<!-- main JS
		============================================ -->
	<script src="js3/main.js"></script>
</body>

</html>