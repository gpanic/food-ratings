<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="foodratings.client.proizvajalec.ManageProizvajalecProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<title>Food Ratings - Administracija</title>
</head>
<body>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Administracija" name="title"/>
		<jsp:param value="Urejanje strani, podatkov in uporabnikov." name="subtitle"/>
	</jsp:include>
	<jsp:include page="/include/admin_menu.jsp" />
	<div id="content">
		<h1>Naslov</h1>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sed nulla nec eros adipiscing euismod vitae ut nunc. Sed ornare risus ut massa consequat eget feugiat nisl egestas. Aliquam erat volutpat. Donec facilisis erat ac lacus feugiat at aliquam velit mattis. Vivamus et mi tellus. Vivamus luctus lorem erat, non scelerisque erat. Ut interdum gravida orci, et bibendum tortor volutpat ut. Nullam in justo est. Ut imperdiet adipiscing tortor ut dictum. Nunc venenatis porttitor dui vitae auctor. Proin pretium eleifend libero, ac faucibus purus tristique vel. Pellentesque id semper urna. Morbi porttitor auctor orci.</p>
		<p>Nam sit amet erat lacus, sit amet dictum mauris. Suspendisse mattis scelerisque nunc quis condimentum. Donec et lectus a odio pharetra placerat sed eu libero. Curabitur tincidunt fermentum enim, nec laoreet metus semper non. Vivamus ut mauris porttitor dui pretium vulputate nec sed tellus. Nam diam velit, pharetra vitae cursus non, pulvinar ac nibh. Etiam pretium, metus ut convallis pretium, quam est commodo massa, id laoreet justo velit ut sapien. Maecenas aliquam, sem in lobortis convallis, lacus ligula ultrices massa, id euismod justo mi vel orci. Proin rhoncus mattis condimentum. Donec in dui neque. Aliquam tempus luctus odio in imperdiet. Vivamus accumsan nulla id tellus mattis iaculis. Proin eget mauris risus.</p>
		<%
			ManageProizvajalecProxy mpp=new ManageProizvajalecProxy();
			out.println(mpp.readProizvajalec(0).getNaziv());
		%>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>