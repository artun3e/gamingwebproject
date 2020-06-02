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
    var pageNum = (Math.ceil(products.length/9));
    addPages(pageNum);
    firstData = products;
}

getData();
getCategories();

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
	var pLabel = document.getElementsByClassName("product-label")[k];
    if(element.onSale == true){
    	price.innerHTML = "$" + element.salePrice + '<del class="product-old-price">$' + element.price + '</del>';
    	pLabel.innerHTML = "<span class='sale'>SALE!</span>"
    }	
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
        var pLabel = document.getElementsByClassName("product-label")[j];
        if(element.onSale == true){
        	price.innerHTML = "$" + element.salePrice + '<del class="product-old-price">$' + element.price + '</del>';
        	pLabel.innerHTML = "<span class='sale'>SALE!</span>"
        }
        else{
        	pLabel.innerHTML = "";
        	price.innerHTML = "$" + element.salePrice;
        }
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

    var pageNum = (Math.ceil(products.length/9));
    addPages(pageNum);
    	
    
    showPage(1);
}

function createPageHTML(pageNumber){
	var page =  '<a onclick="showPage('+pageNumber+')" href="#'+pageNumber+'" class="page_number_'+pageNumber+'" >'+pageNumber+'</a>';
	return page;
}
function addPages(num){
	var pagination = document.getElementById("store-pagination");
	pagination.innerHTML = "";

	var liElement = document.createElement("li");
	liElement.innerHTML = createPageHTML(1);
	pagination.appendChild(liElement);
	var elem = document.createElement("li");
	for(var i=1; i<num; i++){
		elem.innerHTML = createPageHTML(i+1);
		pagination.appendChild(elem.cloneNode(true));
	}
    
   
}
function showPage(num) {
	document.getElementById("About_To_Change").innerHTML = "";
	var boundary = num*9;
	if (products.length < boundary)
		boundary = products.length;
	var start = (num-1)*9;
    for (var j = start;  j < boundary; j++) {
        fillCard(products[j], j - (start));
    }
    
}



function checkCategory(){
	var query = "";
	if (document.getElementById("category-1").checked == true){
		query = query + "action,";
	}
	if (document.getElementById("category-2").checked == true){
		query = query + "multiplayer,";
	}
	if (document.getElementById("category-3").checked == true){
		query = query + "sports,";
	}
	if (document.getElementById("category-4").checked == true){
		query = query + "fps,";
	}
	if (document.getElementById("category-5").checked == true){
		query = query + "strategy,";
	}
	getCategoricalData(query);
}

async function getCategoricalData(category) {
    var vurl = '/CS308RegisterWithJPA/search/fromDB/getByCategory/';
    //	window.location.href = url;
    const url = vurl+category;
    const response = await fetch(url);
    const catData = await response.json();
    

    products = [];
    for (var k = 0; k < catData.length; k++) {
        products.push(catData[k]);
    }
    var pageNum = (Math.ceil(products.length/9));
    addPages(pageNum);
    showPage(1);

    
//    for (var z = 0; z < 9; z++) {
//        fillCard(data[z], z);
//    }
//    addPages();
//    firstData = products;
}
function createCheckBox(elem){
	var checkboxHTML = '<input type="checkbox" />'+ elem +' This is checkbox <br />';
	return checkBoxHTML;
}

async function getCategories() {
    var vurl = '/CS308RegisterWithJPA/search/fromDB/getAllCategories/';

    //	window.location.href = url;
    const response = await fetch(vurl);
    const categories = await response.json();
    var checkboxList = document.getElementsByClassName("checkbox-container")[0];
    console.log(checkboxList);
    var elem = document.createElement('input');
    var breakElement = document.createElement('br');
    for(var i=0; i<categories.length ; i++){
//    	elem.setAttribute('type', 'checkbox');
//    	var text = document.createTextNode(categories[i]);
//    	checkboxList.appendChild(elem.cloneNode(true));
//    	checkboxList.append(text);
//    	checkboxList.append(breakElement);
    	var name = (categories[i]);
    	  var newChild = '<input type="checkbox" id=\''+name +'\' value=\''+name +'\' onClick="getChecked()" />'+ categories[i] +' <br />';
    	  checkboxList.insertAdjacentHTML('beforeend', newChild);
    }	
    
}
function getChecked(){
	var checked = document.querySelectorAll("input[type=checkbox]:checked");
	var selectedCats = ""
	for(var i=0; i<checked.length; i++)
		selectedCats += checked[i].value + ",";
	getCategoricalData(selectedCats);
}

//$(".checkbox-container").click(function(e){
//	console.log("hoooop");
//	e.stopPropagation();
//	e.stopImmediatePropagation();
//	
//	const checkboxes = document.querySelectorAll(`input[class="input-checkbox_check"]:checked`);
//    let values = [];
//    checkboxes.forEach((checkbox) => {
//        values.push(checkbox.value);
//    });
//    console.log(values);
//    
//    var url_2 = "/CS308RegisterWithJPA/search/fromDB/byCategory/";
//    for(var i = 0; i< 5; i++)
//	{
//    	if(values[i]){
//    		url_2 += values[i] + "/"
//    	}
//    	else{
//    		url_2 += "null/"
//    	}
//	}
//    console.log(url_2);
//    document.getElementById("About_To_Change").innerHTML = "";
//    async function getData(){
//    	const response = await fetch(url_2);
//    	const data = await response.json();
//       	
//    	for (var k = 0; k < data.length; k++){
//    		console.log(data[k]);
//    		var p = document.getElementById("About_To_Change");
//    		var newElement = document.createElement('div');
//            //// newElement.setAttribute('id', elementId);
//            newElement.innerHTML = data[k];
//            newElement.setAttribute('class', "col-md-4 col-xs-6");
//    		p.appendChild(newElement);
//    	}
//    }
//
//    $( ".store-pagination" ).remove();
//    getData();
//});