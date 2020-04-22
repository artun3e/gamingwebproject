function search()
{   
    var value = document.getElementById('search').value; //gets value from search bar
    const url = '/CS308RegisterWithJPA/search/fromDB/byName/' + value; //goes to url which returns json list
    /*window.location.href = 'searchResults.html';*/
// function to get json object
async function getData(){
    	const response = await fetch(url);
    	const data = await response.json();
       	clearDiv();
    	for (var k = 0; k < data.length; k++){
    		fillCard(data[k], k);
    	} //
    }
    getData();
    
	
    function clearDiv(){
    	    document.getElementsByClassName("main")[0].innerHTML = "";
    	    
    }        
        var productHTML= '<div class="product">'+
		'<div class="product-img">'+
			'<img src="product01.png" alt="">'+
			'<div class="product-label">'+
				'<span class="sale"></span>'+
				'<span class="new"></span>'+
			'</div>'+
		'</div>'+
		'<div class="product-body">'+
			'<p class="product-category">Category</p>'+
			'<h3 class="product-name"><a href="#">product name goes here</a></h3>'+
			'<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>'+
			'<div class="product-rating">'+
				'<i class="fa fa-star"></i>'+
				'<i class="fa fa-star"></i>'+
				'<i class="fa fa-star"></i>'+
				'<i class="fa fa-star"></i>'+
				'<i class="fa fa-star"></i>'+
			'</div>'+
			'<div class="product-btns">'+
				'<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>'+
				'<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>'+
				'<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>'+
			'</div>'+
		'</div>'+
		'<div class="add-to-cart">'+
			'<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>'+
		'</div>'+
	'</div>';
        
        function createNewCard(){ //creates new element in html for each product
            var p = document.getElementsByClassName("main")[0];
            var newElement = document.createElement('div');
            //// newElement.setAttribute('id', elementId);
            newElement.innerHTML = productHTML;
            newElement.setAttribute('class', "col-md-4 col-xs-6");
            p.appendChild(newElement);
            }
        
        
        function fillCard(element, k){ //fill the card with necessary information
        	createNewCard();
        	var images = element.screenshots;
        	imagesArr = images.split(',');
        	console.log(imagesArr);
        	var image = imagesArr[1].split("': ");
            var imgvalue = image[1].replace(/['"]+/g, '');
            var img = document.getElementsByClassName("product-img")[k].getElementsByTagName('img')[0];
            img.src = imgvalue;
        	var brand = document.getElementsByClassName("product-body")[k].getElementsByTagName('p')[0];
            var name = document.getElementsByClassName("product-body")[k].getElementsByTagName('h3')[0];
            var price = document.getElementsByClassName("product-body")[k].getElementsByTagName('h4')[0];
            brand.innerHTML = element.publisher;
            name.innerHTML = element.name;
            price.innerHTML = "$" + element.price;
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



}
