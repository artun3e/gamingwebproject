
$(document).ready(function() {
	$(".add-to-cart-btn").click(function(e) {
		e.stopPropagation();
		e.stopImmediatePropagation();
		
		var child = $(this).parent().parent();
		var itemName = child.children('.product-body').children('.product-name')[0].innerText;
		
		console.log(itemName);
		
		var xhr = new XMLHttpRequest();
	    var url = "addtocart";
	    xhr.open("POST", url, true);
	    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    
	    xhr.send(itemName);
	});
});