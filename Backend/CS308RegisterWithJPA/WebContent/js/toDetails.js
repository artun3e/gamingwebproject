function toDetails(game){
	var value = game.innerHTML;
	console.log(value);
	var newURL = RemoveLastDirectoryPartOf(window.location.href);
	window.location.href = newURL + '/product.jsp?name=' + value;
	 //gets value from search bar
}
function RemoveLastDirectoryPartOf(the_url)
{
    var the_arr = the_url.split('/');
    the_arr.pop();
    return( the_arr.join('/') );
}