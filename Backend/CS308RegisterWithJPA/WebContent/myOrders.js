function addItemToCart() {
	var title = "asdasd"
	var price = "123"
	var imageSrc = "./img/product01.png"
	const div = document.createElement('div');

	div.className = 'row';

	div.innerHTML = `
	    <input type="text" name="name" value="" />
	    <input type="text" name="value" value="" />
	    <label> 
	      <input type="checkbox" name="check" value="1" /> Checked? 
	    </label>
	    <input type="button" value="-" onclick="removeRow(this)" />
	  `;

	  document.getElementById('cart-items').appendChild(div);
}