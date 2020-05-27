async function getData (variable){
	const user = variable;
	const url = '/CS308RegisterWithJPA/search/fromDB/byAddress/' + user; 
	const response = await fetch(url);
	const data = await response.json();
	
	var addressField = document.getElementById("address");
	var cityField = document.getElementById("city");
	var phoneField = document.getElementById("phone");
	
	addressField.value = data[0].address;
	cityField.value = data[0].city;
	phoneField.value = data[0].phoneNumber;
	
	
	
}