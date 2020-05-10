function addReview(){	
	var comment = document.querySelector("#review-form > form > textarea").value;
	var gameName = parsed.name[0];
	console.log(gameName);
	var xhrAddR = new XMLHttpRequest();
	var urlRR = "addreview";
	xhrAddR.open("POST", urlRR, true);
	var params = "itemName="+gameName+"&comment="+comment;
	console.log(params);
	xhrAddR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhrAddR.send(params);
	xhrAddR.addEventListener('readystatechange', function (e) {
        if(this.readyState === 4 )
        {
          console.log("we are done!!!!");
          var returnedResponse = xhrAddR.getResponseHeader("order-error");
          if(returnedResponse === "true")
          {
            console.log("No login.");
            window.location = "login.jsp";
          }
          else
          {
              alert("Your comment is sent!");
              window.location = "product.jsp?name=" + gameName;
          }
        }
      });
}




function parseURLParams(url) {
    var queryStart = url.indexOf("?") + 1,
        queryEnd   = url.indexOf("#") + 1 || url.length + 1,
        query = url.slice(queryStart, queryEnd - 1),
        pairs = query.replace(/\+/g, " ").split("&"),
        parms = {}, i, n, v, nv;

    if (query === url || query === "") return;

    for (i = 0; i < pairs.length; i++) {
        nv = pairs[i].split("=", 2);
        n = decodeURIComponent(nv[0]);
        v = decodeURIComponent(nv[1]);

        if (!parms.hasOwnProperty(n)) parms[n] = [];
        parms[n].push(nv.length === 2 ? v : null);
    }
    return parms;
}
   	console.log("Details icindeyim");
   	var list=new Array; 
    //goes to url which returns json list
    /*window.location.href = 'searchResults.html';*/
// function to get json object
async function getData(value){
		const query  = value.name[0];
		console.log("query is equal to" + query);
		const url = '/CS308RegisterWithJPA/search/fromDB/byName/' + query; 
    	const response = await fetch(url);
    	const data = await response.json();
    	const urlR = '/CS308RegisterWithJPA/search/fromDB/byNamee/' + query; 
    	const responseR = await fetch(urlR);
    	const reviews = await responseR.json();
    	console.log(reviews);
    	
//       	clearDiv();
//    	for (var k = 0; k < data.length; k++){
//    		fillCard(data[k], k);
//    	} //
    	 var name = document.getElementById('detail-name');
    	 var image = document.getElementById('detail-img');
    	 var price = document.getElementById('detail-price');
    	 var description = document.getElementById('detail-description');
    	 var descriptionTab = document.getElementsByClassName("col-md-12")[0].getElementsByTagName('p')[0];
    	 var requirementTab = document.getElementById("tab2");
    	 
    	 name.innerHTML = data[0].name;
    	 var images = data[0].screenshots;
     	 imagesArr = images.split(',');
     	 var imageSplit = imagesArr[1].split("': ");
     	var sideImg1 = imagesArr[4].split("': ");
     	var sideImg2 = imagesArr[7].split("': ");
     	var sideImg3 = imagesArr[10].split("': ");
     	var sideImg4 = imagesArr[13].split("': ");
         var imgvalue = imageSplit[1].replace(/['"]+/g, '');
         var sideValue1 = sideImg1[1].replace(/['"]+/g, '');
         var sideValue2 = sideImg2[1].replace(/['"]+/g, '');
         var sideValue3 = sideImg3[1].replace(/['"]+/g, '');
         var sideValue4 = sideImg4[1].replace(/['"]+/g, '');
         image.src = imgvalue;
         list.push(imgvalue);
         list.push(sideValue1);
         list.push(sideValue2);
         list.push(sideValue3);
         list.push(sideValue4);
         
         
//         sid1.src =sideValue1;
//         sid2.src =sideValue2;
//         sid3.src =sideValue3;
//         sid4.src =sideValue4;
//         sid5.src =sideValue1;
//         sid6.src =sideValue2;
//         sid7.src =sideValue3;
//         sid8.src =sideValue4;
    	 price.innerHTML = data[0].price + "$";
    	 description.innerHTML = data[0].short_description;
    	 descriptionTab.innerHTML = data[0].detailed_description;
    	 requirementTab.innerHTML = data[0].minimum;
//    	 document.querySelector("#reviews > ul.reviews > li > div.review-heading > h5")
//    	 document.querySelector("#reviews > ul.reviews > li > div.review-body > p")
    	 
    	 for (var r=0; r<reviews.length ; r++){
    		 createNewReview();
    		 var reviewsUser = document.getElementsByClassName("review-heading")[r].getElementsByTagName('h5')[0];
    		 var reviewsComment = document.getElementsByClassName("review-body")[r].getElementsByTagName('p')[0];
    		 var reviewsDate = document.getElementsByClassName("review-heading")[r].getElementsByTagName('p')[0];
    		 reviewsComment.innerHTML = reviews[r].comment;
        	 var username = reviews[r].user.split('@')
        	 reviewsUser.innerHTML = username[0];
        	 var date = reviews[r].date;
        	 reviewsDate.innerHTML = date;
    	 }
    	 
    	 
    	 image.style.width = "575px";
         image.style.height = "350px";
    }
function createNewReview(){ //creates new element in html for each product
	var reviewsTab = document.querySelector("#reviews > ul.reviews");
    var newElement = document.createElement('li');
    //// newElement.setAttribute('id', elementId);
    newElement.innerHTML = reviewHTML;
    reviewsTab.appendChild(newElement);
    }

var reviewHTML = 
'														<div class="review-heading">'+
'															<h5 class="name"></h5>'+
'															<p class="date">27 DEC 2018, 8:0 PM</p>'+
'															<div class="review-rating">'+
'																<i class="fa fa-star"></i>'+
'																<i class="fa fa-star"></i>'+
'																<i class="fa fa-star"></i>'+
'																<i class="fa fa-star"></i>'+
'																<i class="fa fa-star-o empty"></i>'+
'															</div>'+
'														</div>'+
'														<div class="review-body">'+
'															<p></p>'+
'														</div>';
	


	var i = 0;
	function changeNextImage(){
		i++;
		if(i > list.length - 1)
			{
			i = 0;
			}
			
		var image = document.getElementById('detail-img');
		image.src = list[i];
	}
	function changePreviousImage(){
		i--;
		if(i < 0 ){
			i = list.length-1;
			console.log(i);
		}
			
		var image = document.getElementById('detail-img');
		image.src = list[i];
	}
	
	var parsed = parseURLParams(window.location.href);
    getData(parsed);
    document.title = parsed.name[0];
    
    $(document).ready(function() {
	$(".add-to-cart-btn").click(function(e) {
		console.log("add to cart button is clicked")
		e.stopPropagation();
		e.stopImmediatePropagation();
		
		var child = $(this).parent().parent();
		var itemName = document.getElementById("detail-name").innerText;
		var quantity = document.getElementById("input-quantity").value;
		
		if(quantity.length == 0){
			
			var xhr = new XMLHttpRequest();
		    var url = "addtocart";
		    xhr.open("POST", url, true);
			var params = 'itemName='+itemName;
			console.log(params);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		    
		    xhr.send(params);
		}
		else
			{
			console.log(itemName);
			console.log(quantity);
			var xhr = new XMLHttpRequest();
		    var url = "addmultipletocart";
		    xhr.open("POST", url, true);
			var params = 'gameName='+itemName+'&quantity='+quantity;
			console.log(params);
		    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		    
		    xhr.send(params);
			}

	});
    });
    
    window.onload=function(){
        var form = document.querySelector("#review-form");
        function handleForm(event) { event.preventDefault(); } 
        form.addEventListener('submit', handleForm);
    	}
