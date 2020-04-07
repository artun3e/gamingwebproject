function Call(searchQuery)
{
    alert("Search suggestions can come here!!");
    var value = searchQuery.value;  
    const url = '/CS308RegisterWithJPA/search/fromDB/byName/' + value;
    async function getData(){
    	const response = await fetch(url);
    	const data = await response.json();
    	for (var k = 0; k < data.length; k++){
    		fillCard(data[k], k);
    	}
    }
    getData();
        var html = '<div class="photo">' +
        '  <img src="image.png" height="200px" width="300px">' +
        '</div>' +
        '<div class="info">' +
        ' <h6> brand </h6>' +
        '    <h6> name </h6>' +
        '    <h6> info </h6>' +
        '    </div>';
        
        function createNewCard(){
            var p = document.getElementsByClassName("main")[0];
            var newElement = document.createElement('div');
            // newElement.setAttribute('id', elementId);
            newElement.innerHTML = html;
            newElement.setAttribute('class', 'results-card');
            p.appendChild(newElement);
            }
        
        
        function fillCard(element, k){
        	createNewCard();
        	var images = element.imageURLs;
            var imagesArr = images.split(',');
            var imgvalue = imagesArr[1];
            var img = document.getElementsByClassName("photo")[k].getElementsByTagName('img')[0];
            img.src = imgvalue;
        	var brand = document.getElementsByClassName("info")[k].getElementsByTagName('h6')[0];
            var name = document.getElementsByClassName("info")[k].getElementsByTagName('h6')[1];
            var price = document.getElementsByClassName("info")[k].getElementsByTagName('h6')[2];
            brand.innerHTML = element.brand;
            name.innerHTML = element.name;
            price.innerHTML = element.price;
            }
//    (async () => {
//  	var b = (await getData());
//  	b.forEach(element => fillCard(element));
//  	console.log(element.brand);
//})()



}
