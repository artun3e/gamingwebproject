async function getData (variable){
	const user = variable;
	const url = '/CS308RegisterWithJPA/search/fromDB/byPayment/' + user; 
	const response = await fetch(url);
	const data = await response.json();
	
//	var numberField = document.getElementById("cardNumber");
//	var cvcField = document.getElementById("cvc");
//	var dateField = document.getElementById("expDate");
//	
//	numberField.value = data[0].cardNumber;
//	cvcField.value = data[0].cvc;
//	dateField.value = data[0].expirationDate;
	for(var j=1; j<data.length; j++){
		var additionalPaymentFields = document.querySelector("#main > div.content.margin-top60.margin-bottom60 > div > div > div.col-sm-9.col-md-9.col-lg-9 > div:nth-child(4)");
		var divPayment = document.createElement("div");
		divPayment.setAttribute("class", "col-sm-6 col-md-6 info-box");
		divPayment.innerHTML = myvar;
		additionalPaymentFields.append(divPayment);
	}
	for(var i=0; i<data.length; i++){		
		var addPaymentDiv = document.getElementsByClassName("additionalPayments")[i];
		console.log(addPaymentDiv);
		var additionalNumber = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[0];
		var additionalCVC = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[1];
		var additionalDate = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[2];
		var hiddenID = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[3];
		addPaymentDiv.id = i;
		console.log(additionalNumber);
		console.log(additionalCVC);
		console.log(additionalDate);
		additionalNumber.value = data[i].cardNumber;
		additionalCVC.value = data[i].cvc;
		additionalDate.value = data[i].expirationDate;
		hiddenID.value = data[i].id;
	}


}
function updateCard(card){
	
	var i = card.parentNode.id;
	console.log(i);
	var id = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[3].value;
	console.log(id);
	if (id != -1){
		console.log("updating...");
		var number = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[0].value;
		if(number.length == 16){
			var cvc = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[1].value;
			if(cvc.length == 3){
				var date = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[2].value;
				if(date.length == 5){
					
					var xhr = new XMLHttpRequest();
					var url = "UpdatePaymentServlet";
					xhr.open("POST", url, true);
					var params = "payment_id="+id+"&card_number="+number+"&cvc="+cvc+"&expiration_date="+date;
					console.log(params);
					xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
					xhr.send(params);
				}
				else
					alert("You entered a wrong expiration date.")

			}
			else
				alert("You entered a wrong CVC code.")
			
		}
		else
			alert("You entered a wrong card number.");
	}
	else 
		alert("You do not have any payment methods to update. Please add one.")
}
function addCard(){
	console.log("adding...");
	var number = document.getElementById("add_cardNumber").value;
	if(number.length == 16){
		var cvc = document.getElementById("add_cvc").value;
		if(cvc.length == 3){
			var date = document.getElementById("add_expDate").value;
				if (date.length == 5){
				var xhr = new XMLHttpRequest();
				var url = "AddPaymentServlet";
				xhr.open("POST", url, true);
				var params = "card_number="+number+"&cvc="+cvc+"&expiration_date="+date;
				console.log(params);
				xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhr.send(params);
				}
				else
					alert("Your expiration date is not valid.");
				}
		else
			alert("Your CVC code should be 3 digits.");
		}
	else 
		alert("Your card number should be 16 digits.")
}

function deleteCard(card){
	var i = card.parentNode.id;
	var id = document.getElementsByClassName("additionalPayments")[i].getElementsByTagName("input")[3].value;
	if (id != -1){
		var result = confirm("Want to delete?");
		if (result == true){
			window.stop();
			console.log("deleting...");
			var xhr = new XMLHttpRequest();
			var url = "DeletePaymentServlet";
			xhr.open("POST", url, true);
			var params = "payment_id="+id;
			console.log(params);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send(params);
		}
		else
			window.stop();
	
	}
	else{
		window.stop();
		alert("You do not have any payment methods to delete. Please add one.")
	}
		
}



var myvar = '                                        <div class="additionalPayments">'+
'                                        <ul class="list-unstyled">'+

'                                                <li>'+
'                                                    <div class="form-group">'+
'                                                        <label for="number"> Card Number <span class="required">*</span></label>'+
'														<input type="text" name="cardNumber" id="" class="form-control">'+
''+
'                                                        '+
'                                                    </div>'+
'                                                </li>'+
'                                                                                                <li>'+
'                                                    <div class="form-group">'+
'                                                        <label for="number"> CVC <span class="required">*</span></label>'+
'														<input type="text" name="ccv" id="" class="form-control" >'+
''+
'                                                        '+
'                                                    </div>'+
'                                                </li>'+
'                                                                                                <li>'+
'                                                    <div class="form-group">'+
'                                                        <label for="number"> DATE <span class="required">*</span></label>'+
'														<input type="text" name="expDate" id="" class="form-control" >'+
'														<input type="hidden" value="">																				'+
'                                                        '+
'                                                    </div>'+
'                                                </li>'+
'                                                </ul>'+
'                                            <a href="#" onclick="updateCard(this)" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Update</a>'+
'                                             <a href="#" onclick="deleteCard(this)" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Delete</a><p></p>'+
'                                     </div>  ';
	
