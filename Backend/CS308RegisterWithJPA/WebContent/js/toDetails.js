function toDetails(game){
	var value = game.innerHTML;
	console.log(value);
	window.location.href = 'product.jsp?name=' + value;
	 //gets value from search bar
}
