var user_email;

function addReview(){
	var rating = checkRating();
	if(rating != -1){
		var comment = document.querySelector("#review-form > form > textarea").value;
		var gameName = parsed.name[0];
		console.log(gameName);
		var xhrAddR = new XMLHttpRequest();
		var urlRR = "addreview";
		xhrAddR.open("POST", urlRR, true);
		var params = "itemName="+gameName+"&comment="+comment+"&rating="+rating;
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
	else
		 alert("You need to give star rating in order to submit a comment!");
	
}

function checkRating(){
	if(document.querySelector("#star5").checked == true)
		return 5;
	else if(document.querySelector("#star4").checked == true)
		return 4;
	else if(document.querySelector("#star3").checked == true)
		return 3;
	else if(document.querySelector("#star2").checked == true)
		return 2;
	else if(document.querySelector("#star1").checked == true)
		return 1;
	else 
		return -1;
	
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
        	 deleteButton(reviews[r].user, r);

    	 }
    	 ratingSection(reviews);
    	 
    	 image.style.width = "575px";
         image.style.height = "350px";
    }

function ratingSection(review){
	 var count5star=0, count4star=0,count3star=0,count2star=0,count1star=0;
	 if(review.length == 0){
		 
		 var reviewSection = document.querySelector("#tab3 > div > div.col-md-6");
		 var element = document.createElement("h2");
		 element.innerHTML = "Sorry, no one has commented this game yet."
		 reviewSection.appendChild(element);
		 var history5star = document.querySelector("#rating > ul > li:nth-child(1) > span");
		 var history4star = document.querySelector("#rating > ul > li:nth-child(2) > span");
		 var history3star = document.querySelector("#rating > ul > li:nth-child(3) > span");
		 var history2star = document.querySelector("#rating > ul > li:nth-child(4) > span");
		 var history1star = document.querySelector("#rating > ul > li:nth-child(5) > span");
		 history5star.innerHTML = 0;
		 history4star.innerHTML = 0;
		 history3star.innerHTML = 0;
		 history2star.innerHTML = 0;
		 history1star.innerHTML = 0;
	 }
	 for (var r=0; r<review.length ; r++){
		 var reviewStars = document.getElementsByClassName("review-rating")[r];
		 var rating = review[r].rating;
		 if(rating == "5")
			 count5star = count5star +1;
		 else if(rating == "4")
			 count4star = count4star +1;
		 else if(rating == "3")
			 count3star = count3star +1;
		 else if(rating == "2")
			 count2star = count2star +1;
		 else if (rating == "1")
			 count1star = count1star +1;
		 
		 var history5star = document.querySelector("#rating > ul > li:nth-child(1) > span");
		 var history4star = document.querySelector("#rating > ul > li:nth-child(2) > span");
		 var history3star = document.querySelector("#rating > ul > li:nth-child(3) > span");
		 var history2star = document.querySelector("#rating > ul > li:nth-child(4) > span");
		 var history1star = document.querySelector("#rating > ul > li:nth-child(5) > span");
		 history5star.innerHTML = count5star;
		 history4star.innerHTML = count4star;
		 history3star.innerHTML = count3star;
		 history2star.innerHTML = count2star;
		 history1star.innerHTML = count1star;
		 var progress5star = document.querySelector("#rating > ul > li:nth-child(1) > div.rating-progress > div")
		 var progress4star = document.querySelector("#rating > ul > li:nth-child(2) > div.rating-progress > div")
		 var progress3star = document.querySelector("#rating > ul > li:nth-child(3) > div.rating-progress > div")
		 var progress2star = document.querySelector("#rating > ul > li:nth-child(4) > div.rating-progress > div")
		 var progress1star = document.querySelector("#rating > ul > li:nth-child(5) > div.rating-progress > div")
		 var totalCount = count5star + count4star + count3star + count2star + count1star;
		 var portion;
		 portion = (count5star/totalCount) * 100;
		 progress5star.setAttribute("style", "width: "+portion +"%");
		 portion = (count4star/totalCount) * 100;
		 progress4star.setAttribute("style", "width: "+portion+"%");
		 portion = (count3star/totalCount) * 100;
		 progress3star.setAttribute("style", "width: "+portion+"%");	 
		 portion = (count2star/totalCount) * 100;
		 progress2star.setAttribute("style", "width: "+portion+"%");
		 portion = (count1star/totalCount) * 100;
		 progress1star.setAttribute("style", "width: "+portion+"%");
		
		 var totalRating = document.querySelector("#rating > div > span");
		 var weightedAverage = (count5star* 5 + count4star * 4 + count3star * 3 + count2star *2 + count1star) / totalCount;
		 totalRating.innerHTML = Math.round(weightedAverage * 10) / 10;
		 var weightedStar = document.querySelector("#rating > div > div")
		 weightedStar.innerHTML = "";
		 for(var i=0; i < Math.floor(weightedAverage); i++){
	      	var star = document.createElement('i');
	        star.setAttribute('class', "fa fa-star");
			 	weightedStar.appendChild(star)
		 }

		 var ratingF = parseInt(rating);
		 for(var i=0; i<ratingF; i++){
	     	var star = document.createElement('i');
	        star.setAttribute('class', "fa fa-star");
	        reviewStars.appendChild(star);
		 }
		 
	 }
	 
}
function createNewReview(){ //creates new element in html for each product

	var reviewsTab = document.querySelector("#reviews > ul.reviews");
    var newElement = document.createElement('li');
    //// newElement.setAttribute('id', elementId);
    newElement.setAttribute('class', "li_rev")
    newElement.innerHTML = reviewHTML;
    reviewsTab.appendChild(newElement);
    }

function deleteButton(user, order){
	if (user == user_email){
		var commentLi = document.getElementById('user-reviews').getElementsByClassName('li_rev')[order];
		var deleteButton = document.createElement('button');
		deleteButton.innerHTML = "delete";
		commentLi.appendChild(deleteButton);
	}
}

var reviewHTML = 
'														<div class="review-heading">'+
'															<h5 class="name"></h5>'+
'															<p class="date">27 DEC 2018, 8:0 PM</p>'+
'															<div class="review-rating">'+
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
  
function sessionMail(user){
	user_email = user;
}
