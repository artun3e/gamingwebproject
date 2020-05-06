

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
			window.location.href = newURL + '/update_item.jsp?name=' + arr[1];
		}
		else
			window.location.href = newURL + '/update_item.jsp?name=' + itemName;
	});
	
});