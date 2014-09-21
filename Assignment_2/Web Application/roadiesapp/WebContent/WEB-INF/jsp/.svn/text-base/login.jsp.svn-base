<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Roadies login</title>
<style>
* {
	margin: 0;
	padding: 0;
}

HTML, BODY, TD, CODE, KBD, TT, OL, UL, DL, LI, DT, DD {
    font-size: 12px;
}

HTML, BODY, TD, H1, H2, H3, H4, OL, UL, DL, LI, DT, DD {
    font-family: arial,helvetica,sans-serif;
}

body {
	font-family: Georgia, serif;
	color: #3a3a3a;
}

.clear {
	clear: both;
}

form {
	width: 406px;
}

legend {
	display: none;
}

fieldset {
	border: 0;
}

label {
	width: 115px;
	text-align: right;
	float: left;
	margin: 0 10px 0 0;
	padding: 9px 0 0 0;
	font-size: 16px;
}

input {
	width: 220px;
	display: block;
	padding: 4px;
	margin: 0 0 10px 0;
	font-size: 18px;
	color: #3a3a3a;
	font-family: Georgia, serif;
}

input[type=checkbox] {
	width: 20px;
	margin: 0;
	display: inline-block;
}

.button {
	border: 1px solid #999;
	-moz-border-radius: 5px;
	padding: 5px;
	color: black;
	font-weight: bold;
	-webkit-border-radius: 5px;
	font-size: 13px;
	width: 70px;
}

#login_box ul, #login_box li{
	list-style-type:none;
}

#login_box{
	background-color:#777777;
	padding:20px;
	width:350px;
	height:300px;
	margin:auto;
}

#login_box li.label{
	font-weight:bold;
}

h3{
margin-top: 0;
color: #fff;
padding: .2em;
font-size:24px;
}

#header{
    float:left;
    clear:both;
}
.button:hover {
	background: white;
	color: black;
}
</style>
</head>
<body>
    <div id="header">
    </div>
	<div id="login_box">
		<form name="login_form"
			action="<c:url value='j_spring_security_check'/>" method="POST">
			<ul>
				<li><h3>Roadies Login</h3></li>
				<li></li>
				<li class="label">Username</li>
				<li><input type='text' id='username' size="30" maxlength="40"
					name='j_username'
					value='' />
				</li>
				<li class="label">Password</li>
				<li><input type='password' name='j_password' size="30"
					maxlength="30"></li>
				<li><input class="button" type="submit" value="Submit" /></li>
				<li><c:if test="${not empty param.login_error}">
													Invalid user name or password, try again.
											</c:if></li>
				</ul>
		</form>
	</div>
</body>
</html>