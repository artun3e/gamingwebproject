function search()
{   
    var value = document.getElementById('search').value;
    var newURL = RemoveLastDirectoryPartOf(window.location.href);
    window.location.href = newURL + '/search.jsp?name=' + value; //gets value from search bar
    
    /*window.location.href = 'searchResults.html';*/
// function to get json object

    function RemoveLastDirectoryPartOf(the_url)
    {
        var the_arr = the_url.split('/');
        the_arr.pop();
        return( the_arr.join('/') );
    }
	
}