function toDetails(game){
	var value = game.innerHTML;
	console.log(value);
	var newURL = RemoveLastDirectoryPartOf(window.location.href);
	var check = value.search("'");
	if(check != -1){
		var arr = value.split("'");
		window.location.href = newURL + '/product.jsp?name=' + arr[1];
	}
	else
		window.location.href = newURL + '/product.jsp?name=' + value;
	 //gets value from search bar
}
function RemoveLastDirectoryPartOf(the_url)
{
    var the_arr = the_url.split('/');
    the_arr.pop();
    return( the_arr.join('/') );
}