function addToCart(game){	
	var child = game.parentElement.parentElement;
	var itemName = child.getElementsByClassName("product-name")[0].getElementsByTagName('a')[0].innerText;
	
	//console.log(itemName);
	
	var xhr = new XMLHttpRequest();
    var url = "addtocart";
    xhr.open("POST", url, true);
	var params = 'itemName='+itemName;
	console.log(params);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    xhr.send(params);
}

function Log_User_Out(){	
	
}

$(document).ready(function() {
	
	/*$(".add-to-cart-btn").click(function(e) {
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
	});*/
	$(".input-checkbox_check").click(function(e){
		e.stopPropagation();
		e.stopImmediatePropagation();
		
		const checkboxes = document.querySelectorAll(`input[class="input-checkbox_check"]:checked`);
	    let values = [];
	    checkboxes.forEach((checkbox) => {
	        values.push(checkbox.value);
	    });
	    console.log(values);
	    
	    var url_2 = "/CS308RegisterWithJPA/search/fromDB/byCategory/";
	    for(var i = 0; i< 5; i++)
    	{
	    	if(values[i]){
	    		url_2 += values[i] + "/"
	    	}
	    	else{
	    		url_2 += "null/"
	    	}
    	}
	    //const url = '/CS308RegisterWithJPA/search/fromDB/byCategory/FPS/null/null/null/null/'; //goes to url which returns json list
	    /*window.location.href = 'searchResults.html';*/
	    // function to get json object
	    var string_html = "";
	    document.getElementById("About_To_Change").innerHTML = "";
	    async function getData(){
	    	const response = await fetch(url_2);
	    	const data = await response.json();
	       	
	    	for (var k = 0; k < data.length; k++){
	    		console.log(data[k]);
	    		var p = document.getElementById("About_To_Change");
	    		var newElement = document.createElement('div');
	            //// newElement.setAttribute('id', elementId);
	            newElement.innerHTML = data[k];
	            newElement.setAttribute('class', "col-md-4 col-xs-6");
	    		p.appendChild(newElement);
	    	}
	    }

	    $( ".store-pagination" ).remove();
	    getData();
	});
	$('.store-pagination a').click(function(e){
		
		const checkboxes = document.querySelectorAll(`input[class="input-checkbox_check"]:checked`);
	    let values = [];
	    checkboxes.forEach((checkbox) => {
	        values.push(checkbox.value);
	    });
	    console.log(values);
	    
	    var url_2 = "/CS308RegisterWithJPA/search/fromDB/randomJSON/";
	    document.getElementById("About_To_Change").innerHTML = "";
	    async function getData(){
	    	const response = await fetch(url_2);
	    	const data = await response.json();
	       	
	    	for (var k = 0; k < data.length; k++){
	    		console.log(data[k]);
	    		var p = document.getElementById("About_To_Change");
	    		var newElement = document.createElement('div');
	            //// newElement.setAttribute('id', elementId);
	            newElement.innerHTML = data[k];
	            newElement.setAttribute('class', "col-md-4 col-xs-6");
	    		p.appendChild(newElement);
	    	}
	    }

	    getData();
	    /*var number_page = document.getElementsByClassName("active")[0].innerText;*/
	    $(this).parent().addClass('active').siblings().removeClass('active')
	   
	});
	$(".nav-link").click(function(e){
		e.stopPropagation();
		e.stopImmediatePropagation();
		var el = $(this);
	    var element = el[0].innerHTML;
	    //console.log(element);
	    
	    var url_2 = "/CS308RegisterWithJPA/search/fromDB/byCategory/";
	    for(var i = 0; i< 5; i++)
    	{
	    	if(i==0){
	    		url_2 += element + "/"
	    	}
	    	else{
	    		url_2 += "null/"
	    	}
    	}
	    var string_html = "";
	    document.getElementById("About_To_Change").innerHTML = "";
	    async function getData(){
	    	const response = await fetch(url_2);
	    	const data = await response.json();
	       	
	    	for (var k = 0; k < data.length; k++){
	    		console.log(data[k]);
	    		var p = document.getElementById("About_To_Change");
	    		var newElement = document.createElement('div');
	            //// newElement.setAttribute('id', elementId);
	            newElement.innerHTML = data[k];
	            newElement.setAttribute('class', "col-md-4 col-xs-6");
	    		p.appendChild(newElement);
	    	}
	    }
	    $( ".aside-title" )[0].innerText="";
	    $( ".checkbox-filter" ).remove();
	    $( ".store-pagination" ).remove();
	    getData();
	});
});