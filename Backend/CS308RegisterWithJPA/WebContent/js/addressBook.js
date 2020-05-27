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
	
	var row = document.querySelector("#main > div.content.margin-top60.margin-bottom60 > div > div > div.col-sm-9.col-md-9.col-lg-9 > div:nth-child(4)");
	if(data.length> 0){
		row.append(extraAddress);
	}
	
}

var extraAddress = 
'                                    <div class="col-sm-6 col-md-6 info-box">'+
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
''+
'                                                        '+
'                                                    </div>'+
'                                                </li>'+
'                                                </ul>'+
'                                            <a href="#" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Update</a> <a href="#" class="btn btn-color margin-top"><i class="fa fa-pencil"></i> Delete</a><p></p>'+
'                                    </div>';
	
