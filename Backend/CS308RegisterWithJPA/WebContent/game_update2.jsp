<%@ page contentType="text/html;charset=UTF-8" language="java"
		 pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cs308.sabanciuniv.edu.User"%>
<%@ page import="cs308.sabanciuniv.edu.Games"%>
<%@ page import="cs308.sabanciuniv.edu.GamesManager"%>
<%@ page import="cs308.sabanciuniv.edu.Order"%>
<!DOCTYPE html>


<head>
	<link rel="stylesheet" href="./js_drop/dropdown.css">
	<script src="./js_drop/dropdown.js"></script>
	<script src="./js_drop/package.js"></script>
	<script src="./js_drop/index.js"></script>
</head>
<body>
	<select name="skills" multiple="" class="ui fluid dropdown">
		<option value="">Skills</option>
		<option value="angular">Angular</option>
		<option value="css">CSS</option>
		<option value="design">Graphic Design</option>
		<option value="ember">Ember</option>
		<option value="html">HTML</option>
		<option value="ia">Information Architecture</option>
		<option value="javascript">Javascript</option>
		<option value="mech">Mechanical Engineering</option>
		<option value="meteor">Meteor</option>
		<option value="node">NodeJS</option>
		<option value="plumbing">Plumbing</option>
		<option value="python">Python</option>
		<option value="rails">Rails</option>
		<option value="react">React</option>
		<option value="repair">Kitchen Repair</option>
		<option value="ruby">Ruby</option>
		<option value="ui">UI Design</option>
		<option value="ux">User Experience</option>
	</select>
</body>
</html>