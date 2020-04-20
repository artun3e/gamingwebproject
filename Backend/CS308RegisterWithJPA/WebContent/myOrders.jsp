<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="js/myOrders.js"></script>

</head>

<body>

<section class="container content-section">
            <h2 class="section-header">My Orders</h2>
            <div class="cart-row">
                <span class="cart-item cart-header cart-column">ITEM</span>
                <span class="cart-price cart-header cart-column">PRICE</span>
                <span class="cart-quantity cart-header cart-column">QUANTITY</span>
            </div>
            <div id="cart-items">
            </div>
            <div class="cart-total">
                <strong class="cart-total-title">Total</strong>
                <span class="cart-total-price">$0</span>
            </div>
        </section>


<script>
	var titles = ["item1", "item2", "item3"]
	var prices = ["123", "456", "789"]
	var images = ["./img/product01.png", "./img/product02.png", "./img/product03.png"]
	var title = "PC"
	var price = "123"
	var imageSrc = "./img/product01.png"

	for (var i = 0; i < titles.length; i++) {
			  title = titles[i];
			  price = prices[i];
			  imageSrc = images[i];
		
	const div = document.createElement('div');

	div.className = 'row';

	div.innerHTML = `
		<div class="cart-item cart-column">
			<h2> \${title} </h2>
			<p> \${price} </p>
        	<img class="cart-item-image" src="\${imageSrc}" width="200" height="200">
        	<span class="cart-item-title">${title}</span>
   		</div>
	  `;

	  document.getElementById('cart-items').appendChild(div);
	  console.log(price);
	}
</script>

</body>
</html>