
async function getData() {
	
	const url_2 = '/CS308RegisterWithJPA/search/fromDB/getAllCategories/'
	const response_2 = await
		fetch(url_2);
	const data_2 = await
		response_2.json();
	
	var str_html ="";
	data_2.forEach(function (item, index) {
		str_html += "<option value="+ item +">"+ item +"</option>";
	});
	var options = document.getElementById('multipleSelectExample');
	options.innerHTML = str_html;
	
}

getData();



