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
    	 name.innerHTML = data[0].name;
    	 var images = data[0].screenshots;
     	 imagesArr = images.split(',');
     	 var imageSplit = imagesArr[1].split("': ");
         var imgvalue = imageSplit[1].replace(/['"]+/g, '');
         image.src = imgvalue;
    	 price.innerHTML = data[0].price + "$";
    	 description.innerHTML = data[0].detailed_description;
    }
	
	var parsed = parseURLParams(window.location.href);
    getData(parsed);
    console.log(parsed);
    document.title = parsed.name[0];