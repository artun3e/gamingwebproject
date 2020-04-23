<html>

  <head>
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
  </head>
  
  <header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container" style="margin-right: 22%;">
			<a class="navbar-brand" href="index.jsp"> <img src="img/logo.png" width="34"
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
					 <li class="dropdown"><a class="nav-link" href="Home_HTML">Action
                        <span class="sr-only">(current)</span>
                    </a>

                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Multiplayer <span class="sr-only">(current)</span></a>

					</li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML"> Sports <span
                            class="sr-only">(current)</span></a>

                    </li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML"> FPS <span class="sr-only">(current)</span></a>

                   </li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML"> RPG <span
                            class="sr-only">(current)</span></a>
                   </li>
                    <li class="dropdown" style="margin-left: 5%;"><a
                            class="nav-link" href="Home_HTML">Strategy<span class="sr-only">(current)</span></a>
					<li style="margin-left: 5%; margin-top: 5px;"><input id="search"  type="text" placeholder="Search.."  onkeydown="if (event.keyCode == 13) { search(); }"></li>
					<li class="dropdown" style="margin-left: 5%;"><a
						class="fa fa-user" style="font-size: 34px; color: grey;"></a>

						<div class="dropdown-content">
							<a href="login.jsp">Login</a> 
							<a href="register.jsp">Register</a> 
							<a href="myOrders.jsp">My Orders</a> 
								<a href="#account">Account</a> 
						</div></li>
					<a class="fa fa-shopping-cart" href="shoppingCart.jsp" style="font-size: 34px; color: grey; margin-left: 10%;"></a>
				</ul>
			</div>
		</div>
	</nav>

</header>
  
  
    <body>

      <div class="register-container">
        <div class="register-left">
          <form action="forgotpassword" method="post">
            <h3> Enter the email address of the associated account</h3>
            <img src="img/logo.png" height="100px" width="100px"> <br>
            <input class="register" type="email" id="email" name="email" placeholder="E-mail"><br>
            <h5> Your password should be at least 6 characters.</h5><br>
            <button> Confirm </button>
          </form>
        </div>
        <div class="register-right">
<p> Yinelenen bir sayfa içeriğinin okuyucunun dikkatini dağıttığı bilinen bir gerçektir. Lorem Ipsum kullanmanın amacı, sürekli 'buraya metin gelecek, buraya metin gelecek' yazmaya kıyasla daha dengeli bir harf dağılımı sağlayarak okunurluğu artırmasıdır. Şu anda birçok masaüstü yayıncılık paketi ve web sayfa düzenleyicisi, varsayılan mıgır metinler olarak Lorem Ipsum kullanmaktadır. Ayrıca arama motorlarında 'lorem ipsum' anahtar sözcükleri ile arama yapıldığında henüz tasarım aşamasında olan çok sayıda site listelenir. Yıllar içinde, bazen kazara, bazen bilinçli olarak (örneğin mizah katılarak), çeşitli sürümleri geliştirilmiştir.</p>
        </div>
      </div>

    </body>

</html>