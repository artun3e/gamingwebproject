<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: aybar
  Date: 13/04/2020
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    session = request.getSession();
    if(session.getAttribute("user") != null)
    {
        System.out.println("You're already logged in!!!");
        session.setAttribute("loggedIn-Error", true);
        response.sendRedirect("home_Deniz.jsp");
    }
    else
    {
        System.out.println("User is not yet logged in...");
    }
%>
<head>
    <meta charset="utf-8">
    <title>Login!</title>
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

    <!-- Berkin CSS and JS-->
    <link rel="stylesheet" href="register.css">
    <script type="text/javascript" src="register.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta charset="UTF-8">
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container" style="margin-right: 22%;">
            <a class="navbar-brand" href="home_Deniz.jsp"> <img src="logo.png" width="34"
                                                                 height="34" class="d-inline-block align-top" alt=""> Tech
                Market
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="dropdown"><a class="nav-link" href="Home_HTML">Phone
                        <span class="sr-only">(current)</span>
                    </a>

                        <div class="dropdown-content">
                            <a href="#computer">Computer</a> <a href="#phone">Phone</a> <a
                                href="#tv">TV</a> <a href="#camera">Camera</a> <a
                                href="#accessories">Accessories</a>
                        </div></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">TV <span class="sr-only">(current)</span></a>

                        <div class="dropdown-content">
                            <a href="#computer">Computer</a> <a href="#phone">Phone</a> <a
                                href="#tv">TV</a> <a href="#camera">Camera</a> <a
                                href="#accessories">Accessories</a>
                        </div></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Computer <span
                            class="sr-only">(current)</span></a>

                        <div class="dropdown-content">
                            <a href="#computer">Computer</a> <a href="#phone">Phone</a> <a
                                href="#tv">TV</a> <a href="#camera">Camera</a> <a
                                href="#accessories">Accessories</a>
                        </div></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Camera <span class="sr-only">(current)</span></a>

                        <div class="dropdown-content">
                            <a href="#computer">Computer</a> <a href="#phone">Phone</a> <a
                                href="#tv">TV</a> <a href="#camera">Camera</a> <a
                                href="#accessories">Accessories</a>
                        </div></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Home_Appliances<span
                            class="sr-only">(current)</span></a>
                        <div class="dropdown-content">
                            <a href="#computer">Computer</a> <a href="#phone">Phone</a> <a
                                href="#tv">TV</a> <a href="#camera">Camera</a> <a
                                href="#accessories">Accessories</a>
                        </div></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Console<span class="sr-only">(current)</span></a>
                        <div class="dropdown-content">
                            <a href="#computer">Computer</a> <a href="#phone">Phone</a> <a
                                href="#tv">TV</a> <a href="#camera">Camera</a> <a
                                href="#accessories">Accessories</a>
                        </div></li>
                    <li style="margin-left: 5%; margin-top: 5px;"><input
                            type="text" placeholder="Search.."></li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="fa fa-user" style="font-size: 34px; color: grey;"></a>

                        <div class="dropdown-content">
                            <a href="login.jsp">Login</a> <a href="register.html">Register</a> <a
                                href="#orders">My Orders</a> <a href="#account">Account</a> <a
                                href="#liked">Liked Ones</a>
                        </div></li>
                    <a class="fa fa-shopping-cart" href="#Shopping_Cart" style="font-size: 34px; color: grey; margin-left: 10%;"></a>
                </ul>
            </div>
        </div>
    </nav>

</header>
<body>
<div class="container">
    <div class="row">
        <div class="col">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col">&nbsp;</div>
    </div>

    <div class="row justify-content-md-center">
        <div class="col"></div>
        <div class="col-md-auto">
            <h2>Login To Your Account</h2>
        </div>
        <div class="col"></div>
    </div>
    <div class="text-center">
        <img src="logo.png" class="rounded" alt="Balloon" width="128">
        <p style='color: #a94442'>
        <%
            session = request.getSession();
            if(session.getAttribute("order-error") == null){
                System.out.println("Get attribute is null...");
                // Do nothing.
            }
            else{

                String toBeWritten = session.getAttribute("order-error").toString();
                out.print(toBeWritten);
                session.removeAttribute("order-error");
            }
        %></p>
    </div>
    <div class="row justify-content-md-center" style="margin-top: -5%;">
        <form action="login" method="post">
            <input class="register" id="email" type="text" name="email" placeholder="Email"> <br>
            <input class="register" id="pass" type="password" name="pass" placeholder="Password"> <br>
            <input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
            <label for="vehicle1"> Remember Me </label><br>

            <button type="submit" class="btn btn-primary btn-block btn-lg" name="log" value="Login">Submit</button>

            <p class="link-forgot-password-container">
                <a href="" class="link-type-one" target="_parent">Forgot My Password</a>
        </form>
    </div>
</div>
</body>
</body>
<footer> </footer>
</html>
