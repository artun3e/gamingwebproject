
	console.log("load fonksiyonu");
    var value = "apple";
    const url = '/CS308RegisterWithJPA/search/fromDB/byName/' + value; //goes to url which returns json list
    
    getData();
    
    
// function to get json object
async function getData(){
	console.log("getdata");
    	const response = await fetch(url);
    	const data = await response.json();
    	for (var k = 0; k < 9; k++){
    		fillCard(data[k], k);
    	} //
    }
    

    
        function fillCard(element, k){ //fill the card with necessary information
        	console.log("fillcard fonksiyonu");
        	var images = element.imageURLs;
            var imagesArr = images.split(',');
            var imgvalue = imagesArr[7];
            var img = document.getElementsByClassName("product-img")[k].getElementsByTagName('img')[0];
            console.log("img.src");
            img.src = imgvalue;
            checkImage(img,imagesArr);
        	var brand = document.getElementsByClassName("product-body")[k].getElementsByTagName('p')[0];
            var name = document.getElementsByClassName("product-body")[k].getElementsByTagName('h3')[0];
            var price = document.getElementsByClassName("product-body")[k].getElementsByTagName('h4')[0];
            brand.innerHTML = element.brand;
            name.innerHTML = element.name;
            price.innerHTML = element.price;
            }
        
        
        function checkImage(img,imagesArr){ //check image exists or not
        	img.onerror = function() {
//        		console.log(img.src);
        	    img.src= imagesArr[1];
        	};
        }
        



