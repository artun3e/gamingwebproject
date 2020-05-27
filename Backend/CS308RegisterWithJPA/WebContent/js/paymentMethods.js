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
function updateCardInfo(){
	console.log("updating...");
	var number = document.getElementById("cardNumber").value;
	var cvc = document.getElementById("cvc").value;
	var date = document.getElementById("expDate").value;
	var xhr = new XMLHttpRequest();
	var url = "UpdatePaymentServlet";
	xhr.open("POST", url, true);
	var params = "payment_id="+2+"&card_number="+number+"&cvc="+cvc+"&expiration_date="+date;
	console.log(params);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
}