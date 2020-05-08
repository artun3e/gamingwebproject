const products = [];


async function getData(value){
	const query  = value.name[0];
	const url = '/CS308RegisterWithJPA/search/fromDB/byName/' + query; 
//	window.location.href = url;
	const response = await fetch(url);
	const data = await response.json();
    	console.log(data.length);
		if(data.length == 0){
			document.getElementsByClassName("main")[0].innerHTML = noResult;
		}
		else{
			var main = document.getElementsByClassName("container")[1];
			var resultsInfo = document.createElement('h4');
			if(data.length > 1)
				resultsInfo.innerHTML = "There are " +  data.length + " results for: " + query;
			else 
				resultsInfo.innerHTML = "There is " +  data.length + " result for: " + query;
			main.prepend(resultsInfo);
	    	for (var k = 0; k < data.length; k++){
	    		products.push(data[k]);
	    		fillCard(data[k], k);
	    	
	    	} //
		}

    }
	console.log(products);
	var parsed = parseURLParams(window.location.href);
	getData(parsed);

    document.title = "Search results for: " + parsed.name[0];
    function parseURLParams(url) {
        var queryStart = url.indexOf("?") + 1,
            queryEnd   = url.indexOf("#") + 1 || url.length + 1,
            query = url.slice(queryStart, queryEnd - 1),
            pairs = query.replace(/\+/g, " ").split("&"),
            parms = {}, i, n, v, nv;

        if (query === url || query === "") return;

        for (i = 0; i < pairs.length; i++) {
            nv = pairs[i].split("=", 2);
            n = decodeURIComponent(nv[0]);
            v = decodeURIComponent(nv[1]);

            if (!parms.hasOwnProperty(n)) parms[n] = [];
            parms[n].push(nv.length === 2 ? v : null);
        }
        return parms;
    }
    function clearDiv(){
    	    document.getElementsByClassName("main")[0].innerHTML = "";
    	    
    }       
    var noResult= 
    	'<p> Your search "'+ 
    	parsed.name[0]+
    	'" did not match any products  </p>';
    
    

    var productHTML = 
    '                                <div class="product">'+
    '                                    <div class="product-img">'+
    '                                        <img src="./img/product01.png" alt="">'+
    '                                        <div class="product-label">'+
    '                                            <span class="sale">-30%</span>'+
    '                                            <span class="new">NEW</span>'+
    '                                        </div>'+
    '                                    </div>'+
    '                                    <div class="product-body">'+
    '                                        <p class="product-category">Category</p>'+
    '                                        <h3 class="product-name"><a href="#">product name goes here</a></h3>'+
    '                                        <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>'+
    '                                        <div class="product-rating">'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                            <i class="fa fa-star"></i>'+
    '                                        </div>'+
    '                                        <div class="product-btns">'+
    '                                            <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>'+
    '                                            <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>'+
    '                                            <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>'+
    '                                        </div>'+
    '                                    </div>'+
    '                                    <div class="add-to-cart">'+
    '                                        <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>'+
    '                                    </div>'+
    '                                </div>';
    	

        function addStars(k, rating){
        	var stars = document.getElementsByClassName("product-rating")[k];
        	stars.innerHTML = "";
        	console.log("ben addstarstayim", rating)
        	if(rating > 0.95)
        		var starNumber = 5;
        	else if(rating > 0.83)
        		var starNumber = 4;
        	else if(rating > 0.65)
        		var starNumber = 3;
        	else if(rating > 0.50)
        		var starNumber = 2;
        	else if(rating > 0.35)
        		var starNumber = 1;
        	else
        		var starNumber = 0;
            for(var i=0; i<starNumber ;i++){
            	var star = document.createElement('i');
                star.setAttribute('class', "fa fa-star");
            	stars.appendChild(star);
            }

        }
        
        function createNewCard(k){ //creates new element in html for each product
            var p = document.querySelector("#store > div.row")
            var newElement = document.createElement('div');
            //// newElement.setAttribute('id', elementId);
            newElement.innerHTML = productHTML;
            newElement.setAttribute('class', "col-md-4 col-xs-6");
            p.appendChild(newElement);
            
            }
        
        function fillCard(element, k){ //fill the card with necessary information
        	createNewCard(k);
        	var images = element.screenshots;
        	var newImg = element.header_image;
        	imagesArr = images.split(',');
        	var image = imagesArr[1].split("': ");
            var imgvalue = image[1].replace(/['"]+/g, '');
            var img = document.getElementsByClassName("product-img")[k].getElementsByTagName('img')[0];
            img.src = newImg;
            img.style.width = "100%";
            img.style.height = "300px"
        	var brand = document.getElementsByClassName("product-body")[k].getElementsByTagName('p')[0];
            var name = document.getElementsByClassName("product-body")[k].getElementsByTagName('h3')[0];
            var price = document.getElementsByClassName("product-body")[k].getElementsByTagName('h4')[0];
            brand.innerHTML = element.publisher;
            name.innerHTML = '<a onclick="toDetails(this)" href="#">' + element.name + '</a>' ;
            price.innerHTML = "$" + element.price;
            var rating = element.rating;
            addStars(k, rating);
            }
        
        function reFill(element, j){ //fill the card with necessary information
        	var images = element.screenshots;
        	var newImg = element.header_image;
        	imagesArr = images.split(',');
        	var image = imagesArr[1].split("': ");
            var imgvalue = image[1].replace(/['"]+/g, '');
            var img = document.getElementsByClassName("product-img")[j].getElementsByTagName('img')[0];
            img.src = newImg;
        	var brand = document.getElementsByClassName("product-body")[j].getElementsByTagName('p')[0];
            var name = document.getElementsByClassName("product-body")[j].getElementsByTagName('h3')[0];
            var price = document.getElementsByClassName("product-body")[j].getElementsByTagName('h4')[0];
            brand.innerHTML = element.publisher;
            name.innerHTML = '<a onclick="toDetails(this)" href="#">' + element.name + '</a>' ;
            price.innerHTML = "$" + element.price;
            var rating = element.rating;
            addStars(j, rating);
            }
        
        
        function checkImage(img,imagesArr){ //check image exists or not
        	img.onerror = function() {
//        		console.log(img.src);
        	    img.src= imagesArr[1];
        	};
        }
        
        
        

//    (async () => {
//  	var b = (await getData());
//  	b.forEach(element => fillCard(element));
//  	console.log(element.brand);
//})()

function addToCart(game){	
	var child = game.parentElement.parentElement;

	var itemName = child.getElementsByClassName("product-name")[0].getElementsByTagName('a')[0].innerText;
	
	var xhr = new XMLHttpRequest();
    var url = "addtocart";
    xhr.open("POST", url, true);
	var params = 'itemName='+itemName;
	console.log(params);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    xhr.send(params);
}

function sortByPrice(type){	
	if (type == "p-asc"){
		products.sort(function(a, b){return a.price - b.price});
		for(var j=0; j<products.length; j++){
			reFill(products[j], j);
		}
	}
	else if (type == "p-desc"){
		products.sort(function(a, b){return b.price - a.price});
		for(var j=0; j<products.length; j++){
			reFill(products[j], j);
		}
	}
	else if(type == "r-asc"){
		products.sort(function(a, b){return a.rating - b.rating});
		for(var j=0; j<products.length; j++){
			reFill(products[j], j);
		}
	}
	else{
		products.sort(function(a, b){return b.rating - a.rating});
		for(var j=0; j<products.length; j++){
			reFill(products[j], j);
		}
	}
}	
