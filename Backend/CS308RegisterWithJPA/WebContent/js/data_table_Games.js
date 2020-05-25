

$(document).ready(function() {
	function RemoveLastDirectoryPartOf(the_url){
	    var the_arr = the_url.split('/');
	    the_arr.pop();
	    return( the_arr.join('/') );
	}
	$(".update").click(function(){
		var $row = $(this).closest("tr");
	    $tds = $row.find("td");
		var itemName = $tds[0].innerHTML;
		console.log(itemName);
		
		var newURL = RemoveLastDirectoryPartOf(window.location.href);
		
		var check = itemName.search("'");
		if(check != -1){
			var arr = itemName.split("'");
			window.location.href = newURL + '/admin_Game_update.jsp?name=' + arr[1];
		}
		else
			window.location.href = newURL + '/admin_Game_update.jsp?name=' + itemName;
	});
	$(".delete").click(function(){
		var $row = $(this).closest("tr");
	    $tds = $row.find("td");
		var itemName = $tds[0].innerHTML;
		console.log(itemName);
		
		var xhr = new XMLHttpRequest();
		var url = "RemoveProductServlet";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.addEventListener('readystatechange', function (e) {
			if(this.readyState === 4 )
			{
				alert("You have successfuly deleted " + itemName);	// Then Refresh Page
				window.location = "admin_Games_table.jsp";
			}
		});
		var params = "gamename="+itemName;
		xhr.send(params);
		

	});
});