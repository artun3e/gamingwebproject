	var addressOption = []; 
	var paymentOption = [];
	
	var paymentID;
	var addressID;
	var user;
	
async function getData (variable){
	const query = variable;
	user = query;
	const paymentURL = '/CS308RegisterWithJPA/search/fromDB/byPayment/' + query; 
	const paymentResponse = await fetch(paymentURL);
	const paymentData = await paymentResponse.json();
	
	const addressURL = '/CS308RegisterWithJPA/search/fromDB/byAddress/' + query; 
	const addressResponse = await fetch(addressURL);
	const addressData = await addressResponse.json(); 

	if(addressData.length != 0){
		document.getElementById("adr").value = addressData[0].address;
		document.getElementById("city").value = addressData[0].city;
		document.getElementById("phone").value = addressData[0].phoneNumber;
		addressID= addressData[0].id;
	}
	else
	{
		document.getElementById("aDiv").innerHTML = "";
		var optDiv = document.getElementById("addressOptionDiv");
		optDiv.innerHTML = "";
		var info = document.createElement("h3");
		info.innerText = "You do not have any address.";
		var link = document.createElement("a");
		link.innerText = "Please add through this link!";
		link.setAttribute("href", "/CS308RegisterWithJPA/myAddress.jsp");
		optDiv.append(info);
		optDiv.append(link);
	}
	
	if(paymentData.length != 0){
		document.getElementById("ccnum").value = paymentData[0].cardNumber;
		document.getElementById("cvv").value = paymentData[0].cvc;
		document.getElementById("expDate").value = paymentData[0].expirationDate;
		paymentID= paymentData[0].id;
	}
	else{
		document.getElementById("pDiv").innerHTML = "";
		var optDiv = document.getElementById("paymentOptionDiv");
		optDiv.innerHTML = "";
		var info = document.createElement("h3");
		info.innerText = "You do not have any payment methods.";
		var link = document.createElement("a");
		link.innerText = "Please add through this link!";
		link.setAttribute("href", "/CS308RegisterWithJPA/myPayment.jsp");
		optDiv.append(info);
		optDiv.append(link);
	}


	
	

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
	if(addressOption.length != 0)
		var selA = document.getElementById('selectAddress');
	if(paymentOption.length != 0)
		var selP = document.getElementById('selectPayment');
	
	// display value property of select list (from selected option)
	if(selA != null)
		console.log("this is addressID " , selA.value );
	if(selP != null)
	 console.log("this is paymentID " , selP.value);
	
	for(var i=0; i<addressOption.length; i++){
		var found;
		console.log(addressOption);
		if (addressOption[i].id == selA.value){
			found = addressOption[i];
			document.getElementById("adr").value = found.address;
			document.getElementById("city").value = found.city;
			document.getElementById("phone").value = found.phoneNumber;
			addressID = found.id;
		}
	}


	for(var i=0; i<paymentOption.length; i++){
	var found;
	if (paymentOption[i].id == selP.value){
		found = paymentOption[i];
		document.getElementById("ccnum").value = found.cardNumber;
		document.getElementById("cvv").value = found.cvc;
		document.getElementById("expDate").value = found.expirationDate;
		paymentID = found.id;
	}

	}
	
}

function getPaymentID(){
	console.log("getPaymentID");
	console.log(paymentID);
	return paymentID;
}

function getAddressID(){
	console.log("getAddressID");
	console.log(addressID);
	return addressID;
}

function getUser(){
	console.log(user);
	return user;
}