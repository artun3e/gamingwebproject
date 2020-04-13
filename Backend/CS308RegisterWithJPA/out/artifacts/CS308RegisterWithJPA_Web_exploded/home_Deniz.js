let addToCartButtons = document.getElementsByClassName('add-to-cart-btn');
console.log(addToCartButtons);

for(var i = 0; i < addToCartButtons.length; i++){
    var button = addToCartButtons[i];
    button.addEventListener('click', function(event){
        var buttonClicked = event.target;
        let productName = buttonClicked.parentElement.parentElement.getElementsByClassName('product-name')[0].innerText;
        console.log(productName);
        var xhr = new XMLHttpRequest();
        var url = "addtocart";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        var params = 'itemName='+productName;
        xhr.send(params);
    })
}