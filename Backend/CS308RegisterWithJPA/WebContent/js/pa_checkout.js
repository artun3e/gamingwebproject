async function getData (variable){
	console.log("pa_checkout js'teyim");
	console.log(variable);
	const user = variable;
	const paymentURL = '/CS308RegisterWithJPA/search/fromDB/byPayment/' + user; 
	const paymentResponse = await fetch(paymentURL);
	const paymentData = await paymentResponse.json();
	
	const addressURL = '/CS308RegisterWithJPA/search/fromDB/byAddress/' + user; 
	const addressResponse = await fetch(addressURL);
	const addressData = await addressResponse.json(); 
	
	console.log(paymentData[0]);
	console.log(addressData[0]);
	
	document.getElementById("adr").value = addressData[0].address;
	document.getElementById("city").value = addressData[0].city;
	document.getElementById("phone").value = addressData[0].phoneNumber;
	
	document.getElementById("ccnum").value = paymentData[0].cardNumber;
	document.getElementById("cvv").value = paymentData[0].cvc;
	document.getElementById("expDate").value = paymentData[0].expirationDate;
	
}