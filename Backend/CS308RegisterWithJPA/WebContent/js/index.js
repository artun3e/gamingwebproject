

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
		var params = 'itemName='+itemName;
		console.log(params);
	    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    
	    xhr.send(params);
	});
	$(".input-checkbox_check").click(function(e){
		e.stopPropagation();
		e.stopImmediatePropagation();
		
		const checkboxes = document.querySelectorAll(`input[class="input-checkbox_check"]:checked`);
	    let values = [];
	    checkboxes.forEach((checkbox) => {
	        values.push(checkbox.value);
	    });
	    console.log(values);		//This is categories Selected
	    // We need a string of HTML.(This HTML has the code that I send over WhatsApp.)
	    // Then we can change the equation down below to acquire items.
	    // I need this function for both findByCategory and getRandomGames which located in the Games Manager
	    
	    document.getElementById("About_To_Change").innerHTML = "whatever";
	});
	$('.store-pagination a').click(function(e){
		
		const checkboxes = document.querySelectorAll(`input[class="input-checkbox_check"]:checked`);
	    let values = [];
	    checkboxes.forEach((checkbox) => {
	        values.push(checkbox.value);
	    });
	    console.log(values);
	    
	    /*var number_page = document.getElementsByClassName("active")[0].innerText;*/
	    $(this).parent().addClass('active').siblings().removeClass('active')
	   
	});
});