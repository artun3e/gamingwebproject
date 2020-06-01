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
    for(var z=0; z<9 ; z++){
    	fillCard(data[z], z);
    }
    	
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
    if(element.onSale == true)
    	price.innerHTML = "$" + element.salePrice + '<del class="product-old-price">$' + element.price + '</del>';
    else
    	price.innerHTML = "$" + element.salePrice;
    var rating = element.rating;
    addStars(k, rating);
}

function reFill(element, j) { //fill the card with necessary information
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
    if(element.onSale == true)
    	price.innerHTML = "$" + element.salePrice + '<del class="product-old-price">$' + element.price + '</del>';
    else
    	price.innerHTML = "$" + element.salePrice;
    var rating = element.rating;
    addStars(j, rating);
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
    row.innerHTML = "";
    for (var j = 0; j < 9; j++) {
        if (five.checked == true) {
            if (products[j].rating >= 0.95) {
                fillCard(products[j], ratingCount)
                ratingFiltered.push(products[j]);
                ratingCount++;
            }
        }
        if (four.checked == true) {
            if (products[j].rating >= 0.80 && products[j].rating < 0.95) {
                fillCard(products[j], ratingCount)
                ratingFiltered.push(products[j]);
                ratingCount++;
            }
        }
        if (three.checked == true) {
            if (products[j].rating >= 0.60 && products[j].rating < 0.80) {
                fillCard(products[j], ratingCount)
                ratingFiltered.push(products[j]);
                ratingCount++;
            }
        }
        if (two.checked == true) {
            if (products[j].rating >= 0.40 && products[j].rating < 0.60) {
                fillCard(products[j], ratingCount)
                ratingFiltered.push(products[j]);
                ratingCount++;
            }
        }
        if (one.checked == true) {
            if (products[j].rating >= 0 && products[j].rating < 0.40) {
                fillCard(products[j], ratingCount)
                ratingFiltered.push(products[j]);
                ratingCount++;
            }
        }
        if (five.checked == false && four.checked == false && three.checked == false && two.checked == false && one.checked == false) {
            for (var j = 0; j < 9; j++) {
                fillCard(products[j], j)
            }
        }

    }

}
function showPage1(){
		for (var j = 0; j < 9; j++) {
            reFill(products[j], j);
        }
		var page1 = document.querySelector("#store-pagination > li:nth-child(1)")
		 $(this).parent().addClass('active').siblings().removeClass('active')
}
function showPage2(){
		for (var j = 9; j < 18; j++) {
            reFill(products[j], j-9);
	}
		var page2 = document.querySelector("#store-pagination > li:nth-child(2)")
		 page2.parent().addClass('active').siblings().removeClass('active')
}
function showPage3(){
			for (var j = 18; j < 27; j++) {
	            reFill(products[j], j-18);
		}
			var page3 = document.querySelector("#store-pagination > li:nth-child(3)")
			page3.parent().addClass('active').siblings().removeClass('active')
}
function showPage4(){
		for (var j = 27; j < 36; j++) {
            reFill(products[j], j-27);
        }
		var page4 = document.querySelector("#store-pagination > li:nth-child(4)")
		 page4.parent().addClass('active').siblings().removeClass('active')

}
function showPage5(){
			for (var j = 36; j < 45; j++) {
	            reFill(products[j], j-36);
	        }
			var page5 = document.querySelector("#store-pagination > li:nth-child(5)")
			 page5.parent().addClass('active').siblings().removeClass('active')
}

