async function getData (variable){
	const user = variable;
	const url = '/CS308RegisterWithJPA/search/fromDB/byPayment/' + user; 
	const response = await fetch(url);
	const data = await response.json();
	
	var numberField = document.getElementById("cardNumber");
	var cvcField = document.getElementById("cvc");
	var dateField = document.getElementById("expDate");
	
	numberField.value = data[0].cardNumber;
	cvcField.value = data[0].cvc;
	dateField.value = data[0].expirationDate;
	
	
	
}