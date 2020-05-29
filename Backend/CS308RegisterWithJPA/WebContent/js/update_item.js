function removeA(arr) {
    var what, a = arguments, L = a.length, ax;
    while (L > 1 && arr.length) {
        what = a[--L];
        while ((ax= arr.indexOf(what)) !== -1) {
            arr.splice(ax, 1);
        }
    }
    return arr;
}

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
		window.location.replace("admin_Games_table.jsp");
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
	var price = document.getElementById('price');
	var shortdescription = document.getElementById('shortdescription');
	var detaileddescription = document.getElementById('detaileddescription');
	var minimum = document.getElementById('minimum');
	var aboutthegame = document.getElementById('aboutthegame');
	var background = document.getElementById('background');
	var screenshots = document.getElementById('screenshots');
	var headerimage = document.getElementById('headerimage');
	var platforms = document.getElementById('platforms');
	var sale_price = document.getElementById('sale_price');
	var stock = document.getElementById('stock');
	var checkbox_new = document.getElementById('checkbox_new');
	
	id.value = data[0].appID;
	name.value = data[0].name;
	publisher.value = data[0].publisher;
	var cats_ =  data[0].categories.replace(/;/g, ',');
	
	const url_2 = '/CS308RegisterWithJPA/search/fromDB/getAllCategories/'
	const response_2 = await
		fetch(url_2);
	const data_2 = await
		response_2.json();
	
	
	var catArr = cats_.split(',');
	var str_html ="";
	catArr.forEach(function (item, index) {
		removeA(data_2, item);
		str_html += "<option selected=1 value="+ item +">"+ item +"</option>";
	});
	data_2.forEach(function (item, index) {
		str_html += "<option value="+ item +">"+ item +"</option>";
	});
	var options = document.getElementById('multipleSelectExample');
	options.innerHTML = str_html;
	
	price.value = data[0].price + "$";
	sale_price.value = data[0].salePrice + "$";
	stock.value = data[0].stock;
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
	platforms.value = data[0].platforms.replace(/;/g, ',');
	checkbox_new.checked = data[0].onSale;
}

var parsed = parseURLParams(window.location.href);
getData(parsed);
document.title = parsed.name[0];



