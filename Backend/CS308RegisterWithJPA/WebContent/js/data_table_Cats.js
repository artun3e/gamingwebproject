
function RemoveLastDirectoryPartOf(the_url){
    var the_arr = the_url.split('/');
    the_arr.pop();
    return( the_arr.join('/') );
}
function toUpdate(game){
	var $row = $(game).closest("tr");
    $tds = $row.find("td");
	var itemName = $tds[0].innerHTML;
	console.log(itemName);
	
	var newURL = RemoveLastDirectoryPartOf(window.location.href);
	
	var check = itemName.search("'");
	if(check != -1){
		var arr = itemName.split("'");
		window.location.href = newURL + '/admin_Cat_update.jsp?name=' + arr[1];
	}
	else
		window.location.href = newURL + '/admin_Cat_update.jsp?name=' + itemName;
}
function toDelete(game){
	var $row = $(game).closest("tr");
    $tds = $row.find("td");
	var itemName = $tds[0].innerHTML;
	console.log(itemName);
	
	var data = 'category=' + itemName;
	var xhr = new XMLHttpRequest();
	var url = "RemoveCategoryServlet";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.addEventListener('readystatechange', function (e) {
		if(this.readyState === 4 )
		{
			alert("You have successfuly deleted " + itemName);	// Then Refresh Page
			window.location = "admin_Cats_table.jsp";
		}
	});
	xhr.send(data);
}


