<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="foodratings.client.proizvajalec.ManageProizvajalecProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/KISFoodWeb/css/style.css" />
<title>Food Ratings</title>
</head>
<body>
<div id="body_container">
	<div id="header_container">
		<div id="header">
			<div id="website_title">
				FOOD<span id="highlight">RATINGS</span>
			</div>
			<ul>
				<li><a href="">DOMOV</a></li>
				<li><a href="">IZDELKI</a></li>
				<li><a href="">ADMIN</a></li>
			</ul>
			<ul id="menuitems_right">
				<li><a href="">USER</a></li>
			</ul>
		</div>
	</div>
	<div id="content_header_container">
		<div id="content_header">
			<h1>Domov</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In fringilla tortor et mauris facilisis vel tincidunt lacus pharetra. Nulla sollicitudin nibh ut neque accumsan quis lobortis nisl fringilla.</p>
		</div>
	</div>
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
<div id="footer_container">
	<div id="footer">
		<ul id="footer_links">
			<li class="first"><span>&copy;2012 Food Ratings</span></li>
			<li>
				<dl>
					<dt>Navigacija</dt>
					<dd><a href="">Domov</a></dd>
					<dd><a href="">Izdelki</a></dd>
					<dd><a href="">Admin</a></dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>Food Ratings</dt>
					<dd><a href="">O nas</a></dd>
					<dd><a href="">Vizija</a></dd>
					<dd><a href="">Kontakt</a></dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>Skupnost</dt>
					<dd><a href="">Forum</a></dd>
					<dd><a href="">Twitter</a></dd>
					<dd><a href="">Facebook</a></dd>
				</dl>
			</li>
		</ul>
	</div>
</div>
</body>
</html>