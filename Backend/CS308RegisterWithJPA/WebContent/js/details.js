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



    //goes to url which returns json list
    /*window.location.href = 'searchResults.html';*/
// function to get json object
async function getData(value){
		const query  = value.name[0];
		const url = '/CS308RegisterWithJPA/search/fromDB/byName/' + query; 
//		window.location.href = url;
    	const response = await fetch(url);
    	const data = await response.json();
//       	clearDiv();
//    	for (var k = 0; k < data.length; k++){
//    		fillCard(data[k], k);
//    	} //
    	console.log(data[0].name);
    	 var name = document.getElementById('detail-name');
    	 var image = document.getElementById('detail-img');
    	 var price = document.getElementById('detail-price');
    	 var description = document.getElementById('detail-description');
    	 var descriptionTab = document.getElementsByClassName("col-md-12")[0].getElementsByTagName('p')[0];
    	 console.log(descriptionTab);
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
         var sid1 = document.getElementsByClassName("product-preview")[1].getElementsByTagName('img')[0];
         console.log(sid1);
         var sid2 = document.getElementsByClassName("product-preview")[2].getElementsByTagName('img')[0];
         console.log(sid2);
         var sid3 = document.getElementsByClassName("product-preview")[3].getElementsByTagName('img')[0];
         var sid4 = document.getElementsByClassName("product-preview")[4].getElementsByTagName('img')[0];
         var sid5 = document.getElementsByClassName("product-preview")[6].getElementsByTagName('img')[0];
         var sid6 = document.getElementsByClassName("product-preview")[7].getElementsByTagName('img')[0];
         var sid7 = document.getElementsByClassName("product-preview")[8].getElementsByTagName('img')[0];
         var sid8 = document.getElementsByClassName("product-preview")[9].getElementsByTagName('img')[0];
         console.log(sideValue1);
         sid1.src =sideValue1;
         sid2.src =sideValue2;
         sid3.src =sideValue3;
         sid4.src =sideValue4;
         sid5.src =sideValue1;
         sid6.src =sideValue2;
         sid7.src =sideValue3;
         sid8.src =sideValue4;
    	 price.innerHTML = data[0].price + "$";
    	 description.innerHTML = data[0].short_description;
    	 descriptionTab.innerHTML = data[0].detailed_description;
    }
	
	var parsed = parseURLParams(window.location.href);
    getData(parsed);
    document.title = parsed.name[0];