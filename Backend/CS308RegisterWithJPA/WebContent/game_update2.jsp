<html>
<head>
    <title>multiple select</title>
    <script src="https://code.jquery.com/jquery-3.4.0.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
</head>

<body>
<p>Multiple select example</p>
	<div class="selectRow">
	    <!--     Using data-placeholder below to set place holder value versus putting in configuration-->
	    <select class="" id="multipleSelectExample" data-placeholder="Select an option" multiple="">
	        <option selected="1" value="1">Option 1</option>
	        <option value="2">Option 2</option>
	        <option value="3">Option 3</option>
	        <option value="4">Option 4</option>
	        <option value="5">Option 5</option>
	    </select>
	</div>
</body>
<script>
    $(document).ready(function () {
            $('#multipleSelectExample').select2();
            
	});
</script>
</html>