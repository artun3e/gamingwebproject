function parseURLParams(url) {
	var queryStart = url.indexOf("?") + 1, queryEnd = url.indexOf("#") + 1
		|| url.length + 1, query = url.slice(queryStart, queryEnd - 1), pairs = query
		.replace(/\+/g, " ").split("&"), parms = {}, i, n, v, nv;

	if (query === url || query === "")
		return;

	for (i = 0; i < pairs.length; i++) {
		nv = pairs[i].split("=", 2);
		n = decodeURIComponent(nv[0]);
		v = decodeURIComponent(nv[1]);

		if (!parms.hasOwnProperty(n))
			parms[n] = [];
		parms[n].push(nv.length === 2 ? v : null);
	}
	return parms;
}
console.log("Details icindeyim");
var list = new Array;

async function getData(value) {
	
	
	if(value == null){
		alert("To Update Game, First You Need to Select Game.")
		window.location.replace("data_table_Games.jsp");
	}
	const query = value.name[0];
	const url = '/CS308RegisterWithJPA/search/fromDB/byName/' + query;

	const response = await
		fetch(url);
	const data = await
		response.json();

	console.log(data[0].name);

	var id = document.getElementById('id');
	var name = document.getElementById('name');
	var publisher = document.getElementById('publisher');
	var categories = document.getElementById('categories');
	var price = document.getElementById('price');
	var shortdescription = document.getElementById('shortdescription');
	var detaileddescription = document.getElementById('detaileddescription');
	var minimum = document.getElementById('minimum');
	var aboutthegame = document.getElementById('aboutthegame');
	var background = document.getElementById('background');
	var screenshots = document.getElementById('screenshots');
	var headerimage = document.getElementById('headerimage');
	var platforms = document.getElementById('platforms');

	console.log(data);
	id.value = data[0].appID;
	name.value = data[0].name;
	publisher.value = data[0].publisher;
	categories.value = data[0].categories.replace(/;/g, ',');
	price.value = data[0].price + "$";
	shortdescription.value = data[0].short_description;
	detaileddescription.value = data[0].detailed_description;
	minimum.value = data[0].minimum;
	aboutthegame.value = data[0].about_the_game;
	background.value = data[0].background;



	var sc_new = data[0].screenshots;
	sc_new = sc_new.replace(/'/g, '"');
	var json_screens = JSON.parse(sc_new);
	console.log(json_screens);

	var string_we_need ="";
	for(var k in json_screens) {
		string_we_need += json_screens[k].path_full + ",";
	}
	string_we_need = string_we_need.substring(0, string_we_need.length -1);
	screenshots.value = string_we_need;

	headerimage.value = data[0].header_image;
	platforms.value = data[0].platforms.replace(/;/g, ',');;
}

var parsed = parseURLParams(window.location.href);
getData(parsed);
document.title = parsed.name[0];

$(document).ready(function() {
	
	$(".add-to-cart-btn").click(function(e) {
		console.log("add to cart button is clicked")
		e.stopPropagation();
		e.stopImmediatePropagation();

		var child = $(this).parent().parent();
		var itemName = document.getElementById("detail-name").innerText;
		var quantity = document.getElementById("input-quantity").value;

		if(quantity.length == 0){
			var xhr = new XMLHttpRequest();
			var url = "addtocart";
			xhr.open("POST", url, true);
			var params = 'itemName='+itemName;
			console.log(params);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			xhr.send(params);
		}
		else{
			console.log(itemName);
			console.log(quantity);
			var xhr = new XMLHttpRequest();
			var url = "addmultipletocart";
			xhr.open("POST", url, true);
			var params = 'gameName='+itemName+'&quantity='+quantity;
			console.log(params);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			xhr.send(params);
		}

	});
});