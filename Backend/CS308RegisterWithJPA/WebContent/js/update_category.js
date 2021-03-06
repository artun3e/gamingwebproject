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
		alert("To Update Category, First You Need to Select Category.")
		window.location.replace("data_table_Cats.jsp");
	}
}

var parsed = parseURLParams(window.location.href);
getData(parsed);
document.title = parsed.name[0];


$(document).ready(function() {
	document.getElementById('name').value = parsed.name[0];
	
	$("#update_button").click(function(e) {
		if(document.getElementById('name').value == parsed.name[0]){
			alert("To Update You Need To Make Changes First.")
		}
		else{
			var xhr = new XMLHttpRequest();
			var url = "UpdateCategoryServlet";
			xhr.open("POST", url, true);
			var params = "oldcategory="+parsed.name[0]+"&newCategory="+document.getElementById('name').value;
			console.log(params);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.addEventListener('readystatechange', function (e) {
		        if(this.readyState === 4 )
		        {
					alert("Item has been updated!!!");
		        }
	        });
			xhr.send(params);
		}
	});
});