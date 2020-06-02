var products = [];
var firstData = [];
var filtered = [];

async function getData() {
    const url = '/CS308RegisterWithJPA/search/fromDB/random45games';
    //	window.location.href = url;
    const response = await fetch(url);
    const data = await response.json();
    console.log(data.length);


    for (var k = 0; k < data.length; k++) {
        products.push(data[k]);
    }
    for (var z = 0; z < 9; z++) {
        fillCard(data[z], z);
    }
    addPages();
    firstData = products;
}

getData();


function clearDiv() {
    document.getElementsByClassName("main")[0].innerHTML = "";
}

var productHTML =
    '                                <div class="product">' +
    '                                    <div class="product-img">' +
    '                                        <img src="" alt="">' +
    '                                        <div class="product-label">' +
    '                                        </div>' +
    '                                    </div>' +
    '                                    <div class="product-body">' +
    '                                        <p class="product-category">Category</p>' +
    '                                        <h3 class="product-name"><a href="#">product name goes here</a></h3>' +
    '                                        <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>' +
    '                                        <div class="product-rating">' +
    '                                            <i class="fa fa-star"></i>' +
    '                                            <i class="fa fa-star"></i>' +
    '                                            <i class="fa fa-star"></i>' +
    '                                            <i class="fa fa-star"></i>' +
    '                                            <i class="fa fa-star"></i>' +
    '                                        </div>' +
    '                                    </div>' +
    '                                    <div class="add-to-cart">' +
    '                                        <button onclick="addToCart(this)" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> Add </button>' +
    '                                    </div>' +
    '                                </div>';


function addStars(k, rating) {
    var stars = document.getElementsByClassName("product-rating")[k];
    stars.innerHTML = "";
    if (rating >= 0.95)
        var starNumber = 5;
    else if (rating >= 0.80 && rating < 0.95)
        var starNumber = 4;
    else if (rating >= 0.60 && rating < 0.80)
        var starNumber = 3;
    else if (rating >= 0.40 && rating < 0.60)
        var starNumber = 2;
    else if (rating >= 0 && rating < 0.40)
        var starNumber = 1;
    else
        var starNumber = 0;
    for (var i = 0; i < starNumber; i++) {
        var star = document.createElement('i');
        star.setAttribute('class', "fa fa-star");
        stars.appendChild(star);
    }

}

function createNewCard() { //creates new element in html for each product
    var p = document.getElementById("About_To_Change");
    var newElement = document.createElement('div');
    //// newElement.setAttribute('id', elementId);
    newElement.innerHTML = productHTML;
    newElement.setAttribute('class', "col-md-4 col-xs-6");
    p.appendChild(newElement);
    

}

function fillCard(element, k) { //fill the card with necessary information
    createNewCard();
    var images = element.screenshots;
    var newImg = element.header_image;
    imagesArr = images.split(',');
    var image = imagesArr[1].split("': ");
    var imgvalue = image[1].replace(/['"]+/g, '');
    var img = document.getElementsByClassName("product")[k].getElementsByTagName('img')[0];
    img.src = newImg;
    img.style.width = "100%";
    img.style.height = "300px"
    var brand = document.getElementsByClassName("product")[k].getElementsByTagName('p')[0];
    var name = document.getElementsByClassName("product")[k].getElementsByTagName('h3')[0];
    var price = document.getElementsByClassName("product")[k].getElementsByTagName('h4')[0];
    brand.innerHTML = element.publisher;
    name.innerHTML = '<a onclick="toDetails(this)" href="#">' + element.name + '</a>';
    if (element.onSale == true)
        price.innerHTML = "$" + element.salePrice + '<del class="product-old-price">$' + element.price + '</del>';
    else
        price.innerHTML = "$" + element.salePrice;
    var rating = element.rating;
    addStars(k, rating);
}

function reFill(element, j) { //fill the card with necessary information
	if(element != null && element != undefined){
	    var images = element.screenshots;
	    var newImg = element.header_image;
	    imagesArr = images.split(',');
	    var image = imagesArr[1].split("': ");
	    var imgvalue = image[1].replace(/['"]+/g, '');
	    var img = document.getElementsByClassName("product")[j].getElementsByTagName('img')[0];
	    img.src = newImg;
	    var brand = document.getElementsByClassName("product")[j].getElementsByTagName('p')[0];
	    var name = document.getElementsByClassName("product")[j].getElementsByTagName('h3')[0];
	    var price = document.getElementsByClassName("product")[j].getElementsByTagName('h4')[0];
	    brand.innerHTML = element.publisher;
	    name.innerHTML = '<a onclick="toDetails(this)" href="#">' + element.name + '</a>';
	    if (element.onSale == true)
	        price.innerHTML = "$" + element.salePrice + '<del class="product-old-price">$' + element.price + '</del>';
	    else
	        price.innerHTML = "$" + element.salePrice;
	    var rating = element.rating;
	    addStars(j, rating);
	}

}


function checkImage(img, imagesArr) { //check image exists or not
    img.onerror = function() {
        //        		console.log(img.src);
        img.src = imagesArr[1];
    };
}




//    (async () => {
//  	var b = (await getData());
//  	b.forEach(element => fillCard(element));
//  	console.log(element.brand);
//})()

function addToCart(game) {
    console.log("add to cart butonuna basildi");
    var child = game.parentElement.parentElement;

    var itemName = child.getElementsByClassName("product-name")[0].getElementsByTagName('a')[0].innerText;

    var xhr = new XMLHttpRequest();
    var url = "addtocart";
    xhr.open("POST", url, true);
    var params = 'itemName=' + itemName;
    console.log(params);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhr.send(params);
}

function sortByPrice(type) {
    if (type == "p-asc") {
        products.sort(function(a, b) {
            return a.salePrice - b.salePrice
        });
        for (var j = 0; j < 9; j++) {
            reFill(products[j], j);
        }
    } else if (type == "p-desc") {
        products.sort(function(a, b) {
            return b.salePrice - a.salePrice
        });
        for (var j = 0; j < 9; j++) {
            reFill(products[j], j);
        }
    } else if (type == "r-asc") {
        products.sort(function(a, b) {
            return a.rating - b.rating
        });
        for (var j = 0; j < 9; j++) {
            reFill(products[j], j);
        }
    } else {
        products.sort(function(a, b) {
            return b.rating - a.rating
        });
        for (var j = 0; j < 9; j++) {
            reFill(products[j], j);
        }
    }
}

function filter(min, max) {
    if (document.getElementById("5stars").checked == true)
        document.getElementById("5stars").checked = false;
    if (document.getElementById("4stars").checked == true)
        document.getElementById("4stars").checked = false;
    if (document.getElementById("3stars").checked == true)
        document.getElementById("3stars").checked = false;
    if (document.getElementById("2stars").checked == true)
        document.getElementById("2stars").checked = false;
    if (document.getElementById("1star").checked == true)
        document.getElementById("1star").checked = false;


    products = firstData;
    filtered = [];
    if (min == "") {
        min = 0;
        document.querySelector("#price-min").value = 0;
    }
    if (max == "") {
        max = 999;
        document.querySelector("#price-max").value = 999;
    }
    var count = 0;
    var row = document.querySelector("#store > div.row");
    row.innerHTML = "";
    for (var j = 0; j < 9; j++) {
        if (products[j].salePrice >= min && products[j].salePrice <= max) {
            fillCard(products[j], count)
            filtered.push(products[j]);
            count++;
        }

    }
    products = filtered;
}

function ratingCheckbox() {
    var ratingFiltered = [];

    var five = document.getElementById("5stars");

    var four = document.getElementById("4stars");

    var three = document.getElementById("3stars");

    var two = document.getElementById("2stars");

    var one = document.getElementById("1star");

    ratingCount = 0;
    var row = document.querySelector("#store > div.row");
//    row.innerHTML = "";
    for (var j = 0; j < firstData.length; j++) {
    	var element = firstData[j];
        if (five.checked == false && four.checked == false && three.checked == false && two.checked == false && one.checked == false) {
        	ratingFiltered = firstData;
//            for (var j = 0; j < 9; j++) {
////                fillCard(products[j], j)
//            }
        }
        else{
            if (five.checked == true) {
                if (element.rating >= 0.95) {
//                    fillCard(products[j], ratingCount)
                    ratingFiltered.push(element);
                    ratingCount++;
                }
            }
            if (four.checked == true) {
                if (element.rating >= 0.80 && element.rating < 0.95) {
//                    fillCard(products[j], ratingCount)
                    ratingFiltered.push(element);
                    ratingCount++;
                }
            }
            if (three.checked == true) {
                if (element.rating >= 0.60 && element.rating < 0.80) {
//                    fillCard(products[j], ratingCount)
                    ratingFiltered.push(element);
                    ratingCount++;
                }
            }
            if (two.checked == true) {
                if (element.rating >= 0.40 && element.rating < 0.60) {
//                    fillCard(products[j], ratingCount)
                    ratingFiltered.push(element);
                    ratingCount++;
                }
            }
            if (one.checked == true) {
                if (element.rating >= 0 && element.rating < 0.40) {
//                    fillCard(products[j], ratingCount)
                    ratingFiltered.push(element);
                    ratingCount++;
                }
            }
            
        }
        	
        
    }
    products = ratingFiltered;

    addPages();
    	
    
    showPage1();
}

function addPages(){
	var pagination = document.getElementById("store-pagination");
	pagination.innerHTML = "";
	var p1 = '<li><a onclick="showPage1()" href="#1" class="page_number_1" >1</a></li>';
	var p2 = '<li><a onclick="showPage2()" href="#2" class="page_number_2" >2</a></li>';
	var p3 = '<li><a onclick="showPage3()" href="#3" class="page_number_3" >3</a></li>';
	var p4 = '<li><a onclick="showPage4()" href="#4" class="page_number_4" >4</a></li>';
	var p5 = '<li><a onclick="showPage5()" href="#5" class="page_number_5" >5</a></li>';	
	var liElement = document.createElement("li");
	liElement.innerHTML = p1;
	pagination.appendChild(liElement);
    if(products.length > 9 && products.length <= 18){
    	var pagination = document.getElementById("store-pagination");
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p2;
    	pagination.appendChild(liElement);
    }
    else if(products.length > 18 && products.length <= 27){
    	var pagination = document.getElementById("store-pagination");
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p2;
    	pagination.appendChild(liElement);
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p3;
    	pagination.appendChild(liElement);
    }
    else if(products.length > 27 && products.length <= 36){
    	var pagination = document.getElementById("store-pagination");
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p2;
    	pagination.appendChild(liElement);
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p3;
    	pagination.appendChild(liElement);
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p4;
    	pagination.appendChild(liElement);
    }
    else if(products.length > 36 && products.length <= 45){
    	var pagination = document.getElementById("store-pagination");
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p2;
    	pagination.appendChild(liElement);
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p3;
    	pagination.appendChild(liElement);
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p4;
    	pagination.appendChild(liElement);
    	var liElement = document.createElement("li");
    	liElement.innerHTML = p5;
    	pagination.appendChild(liElement);
    }
}


function showPage1() {
	document.getElementById("About_To_Change").innerHTML = "";
	var boundary = 9;
	if (products.length < 9)
		boundary = products.length;
    for (var j = 0; j < boundary; j++) {
        fillCard(products[j], j);
    }
}

function showPage2() {
	document.getElementById("About_To_Change").innerHTML = "";
	var boundary = 18;
	if (products.length < 18)
		boundary = products.length;
    for (var j = 9; j < boundary; j++) {
    	fillCard(products[j], j - 9);
    }
}

function showPage3() {
	document.getElementById("About_To_Change").innerHTML = "";
	var boundary = 27;
	if (products.length < 27)
		boundary = products.length;
    for (var j = 18; j < boundary; j++) {
    	fillCard(products[j], j - 18);
    }
}

function showPage4() {
	document.getElementById("About_To_Change").innerHTML = "";
	var boundary = 36;
	if (products.length < 36)
		boundary = products.length;
    for (var j = 27; j < boundary; j++) {
    	fillCard(products[j], j - 27);
    }

}

function showPage5() {
	document.getElementById("About_To_Change").innerHTML = "";
	var boundary = 45;
	if (products.length < 45)
		boundary = products.length;
    for (var j = 36; j < boundary; j++) {
    	fillCard(products[j], j - 36);
    }
}