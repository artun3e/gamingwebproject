

$(document).ready(function () {
    $("#add_button").click(function(e) {
    	var name = document.getElementById('name').value;
    	
    	var params = 'category='+name;
    	
    	var xhr = new XMLHttpRequest();
        var url = "AddCategoryServlet";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.addEventListener('readystatechange', function (e) {
	        if(this.readyState === 4 )
	        {
				alert("Category has been added!");
				window.location = "admin_Cats_table.jsp";
	        }
        });
        xhr.send(params);
	});
});




