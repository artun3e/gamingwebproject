
function changeVal(el) {
  var qt = parseFloat(el.parent().children(".qt").html());
  var price = parseFloat(el.parent().children(".price").html());
  var eq = Math.round(price * qt * 100) / 100;
  
  el.parent().children(".full-price").html( eq + "$" );
  
  changeTotal();			
}

function changeTotal() {
  
  var price = 0;
  
  $(".full-price").each(function(index){
    price += parseFloat($(".full-price").eq(index).html());
  });
  
  price = Math.round(price * 100) / 100;
  var tax = Math.round(price * 0.05 * 100) / 100
  var shipping = parseFloat($(".shipping span").html());
  var fullPrice = Math.round((price + tax + shipping) *100) / 100;
  
  if(price == 0) {
    fullPrice = 0;
  }
  
  $(".subtotal span").html(price);
  $(".tax span").html(tax);
  $(".total span").html(fullPrice);
}

$(document).ready(function(){
	changeTotal();
	
  $(".remove").click(function(){
	 
	var child_ = $(this).parent().parent();
	var itemName = child_.children('.content_info').children('.product_name')[0].innerText;
	    
	console.log(itemName);
	var xhr = new XMLHttpRequest();
	var url = "removefromcart";
	xhr.open("POST", url, true);
	var params = 'itemName='+itemName;
	console.log(params);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
	
    var el = $(this);
    el.parent().parent().addClass("removed");
    window.setTimeout(
      function(){
        el.parent().parent().slideUp('fast', function() { 
          el.parent().parent().remove(); 
          if($(".product").length == 0) {
            if(check) {
              $("#cart").html("<h1>The shop does not function, yet!</h1>");
            } else {
              $("#cart").html("<h1>No products!</h1>");
            }
          }
          changeTotal(); 
        });
      }, 200);
  });
  
  $(".qt-plus").click(function(){
    $(this).parent().children(".qt").html(parseInt($(this).parent().children(".qt").html()) + 1);
    
    $(this).parent().children(".full-price").addClass("added");
    
    var child_ = $(this).parent().parent();
    var itemName = child_.children('.content_info').children('.product_name')[0].innerText;
    
    //console.log(itemName);
    var xhr = new XMLHttpRequest();
    var url = "addtocart";
    xhr.open("POST", url, true);
	var params = 'itemName='+itemName;
	console.log(params);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(params);
    
    var el = $(this);
    window.setTimeout(function(){el.parent().children(".full-price").removeClass("added"); changeVal(el);}, 150);
  });
  
  $(".qt-minus").click(function(){
    
    child = $(this).parent().children(".qt");
    
    var child_ = $(this).parent().parent();
    var itemName = child_.children('.content_info').children('.product_name')[0].innerText;
    
    if(parseInt(child.html()) > 1) {
      child.html(parseInt(child.html()) - 1);
      //console.log(itemName);
      var xhr = new XMLHttpRequest();
      var url = "decrementfromcart";
      xhr.open("POST", url, true);
      var params = 'itemName='+itemName;
      console.log(params);
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xhr.send(params);
    }
    else{
		console.log(itemName);
		var xhr = new XMLHttpRequest();
		var url = "removefromcart";
		xhr.open("POST", url, true);
		var params = 'itemName='+itemName;
		console.log(params);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(params);
    	
        var el = $(this);
        el.parent().parent().addClass("removed");
        window.setTimeout(
          function(){
            el.parent().parent().slideUp('fast', function() { 
              el.parent().parent().remove(); 
              if($(".product").length == 0) {
                if(check) {
                  $("#cart").html("<h1>The shop does not function, yet!</h1>");
                } else {
                  $("#cart").html("<h1>No products!</h1>");
                }
              }
              changeTotal(); 
            });
          }, 200);
    }
    
    $(this).parent().children(".full-price").addClass("minused");
    
    var el = $(this);
    window.setTimeout(function(){el.parent().children(".full-price").removeClass("minused"); changeVal(el);}, 150);
  });
  
  window.setTimeout(function(){$(".is-open").removeClass("is-open")}, 1200);
  
  $(".btn_check").click(function(){
    var cartItemContainer = document.getElementsByClassName('products')[0]
    var cartRows = cartItemContainer.getElementsByClassName('product')
    Item_Names = []
    Item_Q = []
    for(var i = 0; i < cartRows.length; i++){
    	var cartRow = cartRows[i]
    	
    	var product_name_element = cartRow.getElementsByClassName('product_name')[0]
    	var quantity_element = cartRow.getElementsByClassName('qt')[0]
    	
    	var product_name = product_name_element.innerText
    	var quantity = parseFloat(quantity_element.innerText)
    	Item_Names.push(product_name)
    	Item_Q.push(quantity)
    }
    
    var xhr = new XMLHttpRequest();
    var url = "placeorder";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.addEventListener('readystatechange', function (e) {
      if(this.readyState === 4 )
      {
        console.log("we are done!!!!");
        var returnedResponse = xhr.getResponseHeader("order-error");
        if(returnedResponse === "true")
        {
          console.log("No login.");
          window.location = "login.jsp";
        }
      }
    });
    var data_about = JSON.stringify({"list_names": Item_Names, "list_q": Item_Q });
    var params = 'list_names='+Item_Names+'&list_q='+Item_Q;
    console.log(data_about);
    xhr.send(params);
  });
  
});