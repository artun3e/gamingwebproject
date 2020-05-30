	var addressOption = []; 
	var paymentOption = []; 
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

	
	document.getElementById("adr").value = addressData[0].address;
	document.getElementById("city").value = addressData[0].city;
	document.getElementById("phone").value = addressData[0].phoneNumber;
	
	document.getElementById("ccnum").value = paymentData[0].cardNumber;
	document.getElementById("cvv").value = paymentData[0].cvc;
	document.getElementById("expDate").value = paymentData[0].expirationDate;
	
	

	var selectAddress = document.getElementById("selectAddress"); 
	var selectPayment = document.getElementById("selectPayment");

	
	for(var i=0; i< addressData.length; i++){
		addressOption.push(addressData[i]);
	}
	for(var i=0; i< paymentData.length; i++){
		paymentOption.push(paymentData[i]);
	}


	for(var i = 0; i < addressOption.length; i++) {
	    var opt = (addressOption[i]);
	    var el = document.createElement("option");
	    el.text = opt.address;
	    el.value = opt.id;
	    selectAddress.add(el);
	}	
	
	for(var i = 0; i < paymentOption.length; i++) {
	    var opt = paymentOption[i];
	    var el = document.createElement("option");   
	    el.text = opt.cardNumber;
	    el.value = opt.id;
	    selectPayment.add(el);
	}	
		
}

function checkOptions(){
	var selA = document.getElementById('selectAddress');
	var selP = document.getElementById('selectPayment');
	// display value property of select list (from selected option)
	console.log("this is addressID " , selA.value );
	console.log("this is paymentID " , selP.value);
	
	for(var i=0; i<addressOption.length; i++){
		var found;
		console.log(addressOption);
		if (addressOption[i].id == selA.value){
			found = addressOption[i];
			console.log(found);
			document.getElementById("adr").value = found.address;
			document.getElementById("city").value = found.city;
			document.getElementById("phone").value = found.phoneNumber;
		}
	}


	for(var i=0; i<addressOption.length; i++){
	var found;
	if (paymentOption[i].id == selP.value){
		found = paymentOption[i];
		document.getElementById("ccnum").value = found.cardNumber;
		document.getElementById("cvv").value = found.cvc;
		document.getElementById("expDate").value = found.expirationDate;
	}

	}
	
}