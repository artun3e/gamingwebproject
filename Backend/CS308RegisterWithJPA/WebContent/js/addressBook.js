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
	
	for(var j=1; j<data.length; j++){
		var additionalAddressFields = document.querySelector("#main > div.content.margin-top60.margin-bottom60 > div > div > div.col-sm-9.col-md-9.col-lg-9 > div:nth-child(4)");
		var divAddress = document.createElement("div");
		divAddress.setAttribute("class", "col-sm-6 col-md-6 info-box");
		divAddress.innerHTML = extraAddress;
		additionalAddressFields.append(divAddress);
	}
	
	for(var i=0; i<data.length; i++){		
		var extraAddressDiv = document.getElementsByClassName("additionalAddress")[i];
		console.log(extraAddressDiv);
		var additionalAddress = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[0];
		var additionalCity = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[1];
		var additionalPhone = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[2];
		var hiddenID = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[3];
		extraAddressDiv.id = i;
		additionalAddress.value = data[i].address;
		additionalCity.value = data[i].city;
		additionalPhone.value = data[i].phoneNumber;
		hiddenID.value = data[i].id;
	}
	
	
	
}

function updateAddress(address){
	var i = address.parentNode.id;
	var id = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[3].value;
	if (id != -1){
		var address = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[0].value;
		if (address.length != 0){
			var city = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[1].value;
			if(city.length != 0){
				var phone = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[2].value;
				if(phone.length != 0){
					console.log("updating...");
					var xhr = new XMLHttpRequest();
					var url = "UpdateAddressServlet";
					xhr.open("POST", url, true);
					var params = "address_id="+id+"&address="+address+"&city="+city+"&phone_number="+phone;
					console.log(params);
					xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
					xhr.send(params);
				}
				else
					alert("You cannot leave phone field empty.")
			}
			else
				alert("You cannot leave city field empty.");	

		}
		else
			alert("You cannot leave address field empty.");	
		
	}
	else 
		alert("You do not have any address to update. Please add one.")

}
function addAddress(){
	console.log("adding...");
	var address = document.getElementById("add_address").value;
	if(address.length != 0){
		var city = document.getElementById("add_city").value;
		if(city.length != 0){
			var phone = document.getElementById("add_phone").value;
			if(phone.length !=0){
				var xhr = new XMLHttpRequest();
				var url = "AddAddressServlet";
				xhr.open("POST", url, true);
				var params = "address="+address+"&city="+city+"&phone_number="+phone;
				console.log(params);
				xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhr.send(params);
			}
			else
				alert("You cannot leave phone field empty.")
		}
		else
			alert("You cannot leave city field empty.");
	}
	else
		alert("You cannot leave address field empty.");	
	
}

function deleteAddress(address){
	console.log("deleting...");
    var i = address.parentNode.id;
    var id = document.getElementsByClassName("additionalAddress")[i].getElementsByTagName("input")[3].value;
	if(id != -1){
		var result = confirm("Want to delete?");
		if (result == true){
		var xhr = new XMLHttpRequest();
		var url = "DeleteAddressServlet";
		xhr.open("POST", url, true);
		var params = "address_id="+id;
		console.log(params);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(params);
		}
	}
	else
		alert("You do not have any address to delete. Please add one.")

}

var extraAddress = 
'                                    <div class="additionalAddress">'+
'                                        <ul class="list-unstyled">'+
'                                                <li>'+
'                                                    <div class="form-group">'+
'                                                        <label for="number"> Address <span class="required">*</span></label>'+
'														<input type="text" name="name" id="name" class="form-control">'+
''+
'                                                        '+
'                                                    </div>'+
'                                                </li>'+
'                                                                                                <li>'+
'                                                    <div class="form-group">'+
'                                                        <label for="number"> Region / City <span class="required">*</span></label>'+
'														<input type="text" name="name" id="name" class="form-control">'+
''+
'                                                        '+
'                                                    </div>'+
'                                                </li>'+
'                                                                                                <li>'+
'                                                    <div class="form-group">'+
'                                                        <label for="number"> Phone Number <span class="required">*</span></label>'+
'														<input type="text" name="name" id="name" class="form-control">'+
'<input type="hidden" value="">	'+
'                                                        '+
'                                                    </div>'+
'                                                </li>'+
'                                                </ul>'+
'                                            <a href="#" onclick="updateAddress(this)" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Update</a>'+
'              								 <a href="#" onclick="deleteAddress(this)" class="btn btn-color margin-top"><i class="fa fa-trash"></i> Delete</a><p></p>'+
'                                    </div>';
	
