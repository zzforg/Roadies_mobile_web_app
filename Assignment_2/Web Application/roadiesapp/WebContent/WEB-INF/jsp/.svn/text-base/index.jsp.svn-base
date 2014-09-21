<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Roadies application</title>
<style>

HTML, BODY, TD, CODE, KBD, TT, OL, UL, DL, LI, DT, DD {
    font-size: 12px;
}

HTML, BODY, TD, H1, H2, H3, H4, OL, UL, DL, LI, DT, DD {
    font-family: arial,helvetica,sans-serif;
}


body {
	background-color: #DDDDDD;
	padding: 0;
	margin: 0;
}

#main_content {
	width: 960px;
	background-color: #FFFFFF;
	margin: auto;
	min-height: 600px;
}

#header {
	position:relative;
	height: 80px;
	background-color:#666666;
	padding: 10px 10px 10px 10px;
}

#header div.left{
	color:#ffffff;
	float:left;
}

#header div.right{
	color:#ffffff;
	float:right;
}

#header div.right a{
	color:#ffffff;
}

#body{
	padding: 10px 10px 10px 10px;
	height:auto;
	min-height:400px;
}

#footer{
	background-color:#aaaaaa;
	margin-top:5px;
	padding: 10px 10px 10px 10px;
	height:30px;
}

#case_list h2{
	color:#777777;
	padding:10px;
	padding-bottom:5px;
}

#case_list{
	background-color:#eeeeee;
	min-height:150px;
}

#case_list table{
	padding:10px;
}

#case_list table th{
	background-color:#dddddd;
	padding:7px;
}

#case_list table tr{
	background-color:#ffffff;
}

#case_list table td{
	padding:7px;
}
</style>
</head>
<body>
	<div id="main_content">
		<div id="header">
			<div class="left"><h1>Roadies!</h1><h3>Ultimate roadside assistance solution</h3></div>
			<div class="right"><a href="logout.html">Logout</a></div>
		</div>
		<div id="body">
			<p>${message}</p>
			<div id="case_list">
			<h2>Cases Reported</h2>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Problem</th>
						<th>Location</th>
						<th>When?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${cases}">
						<tr>
							<td>${c.cid}</td>
							<td>${c.problem}</td>
							<td>${c.location}</td>
							<td>${c.timestamp}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
			</div>
		</div>
		<div id="footer">
			<p>
				<a href="logout.html">Logout</a>
			</p>
		</div>
	</div>
</body>
</html>