

$(document).ready(function () {
	
    $('#multipleSelectExample').select2();
    
    $(".selectRow").click(function(e){
    	
    	
    });
    $("#update_button").click(function(e) {
    	var id = document.getElementById('id').value;
    	var name = document.getElementById('name').value;
    	var publisher = document.getElementById('publisher').value;
    	
    	var price = document.getElementById('price').value;
    	var shortdescription = document.getElementById('shortdescription').value;
    	var detaileddescription = document.getElementById('detaileddescription').value;
    	var minimum = document.getElementById('minimum').value;
    	var aboutthegame = document.getElementById('aboutthegame').value;
    	var background = document.getElementById('background').value;
    	var screenshots = document.getElementById('screenshots').value;
    	var headerimage = document.getElementById('headerimage').value;
    	var platforms = document.getElementById('platforms').value;
    	
    	//New Attributes
    	var salePrice = document.getElementById('sale_price').value;
    	var stock = document.getElementById('stock').value;
    	var onSale = document.getElementById('checkbox_new').checked;
    	
    	var cats_coma ="";
    	$('.select2-selection__choice').each(function(){
    		cats_coma += $(this)[0].title + ",";
    	});
    	cats_coma = cats_coma.substring(0, cats_coma.length -1);
    	
    	var params = 'id='+id+'&name='+name+'&publisher='+publisher+'&categories='+cats_coma +'&price='+price+'&shortdescription='+shortdescription+'&detaileddescription='+detaileddescription;
    	params = params + '&minimum='+minimum+'&aboutthegame='+aboutthegame+'&background='+background+'&screenshots='+screenshots+'&headerimage='+headerimage+'&platforms='+platforms;
    	params = params + '&salePrice='+salePrice +'&stock='+stock +'&onSale='+onSale;
    	
    	var xhr = new XMLHttpRequest();
        var url = "UpdateProductServlet";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.addEventListener('readystatechange', function (e) {
	        if(this.readyState === 4 )
	        {
				alert("Item has been updated!");
	        }
        });
        xhr.send(params);
	});
    $("update_button_bummy").click(function(e) {
    	
    });
});




