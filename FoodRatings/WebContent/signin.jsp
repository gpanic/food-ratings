<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings - Prijava</title>
</head>
<body>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Prijava" name="title"/>
		<jsp:param value="Prijavite se s svojim uporabniskim imenom in geslo, ali pa si ustvarite nov racun." name="subtitle"/>
	</jsp:include>
	<div id="content">
		<form id="signinForm" action="/FoodRatings/SignInServlet" method="post">
			<div>
				<label for="username" class="block">Uporabniško ime</label>
				<input type="text" id="username" name="username" class="input_text"/>
			</div>
			<div>
				<label for="password" class="block">Geslo</label>
				<input type="password" id="password" name="password" class="input_text"/>
			</div>
			<div>
				<input type="submit" value="Prijava" class="input_button"/><span><a href="#" class="transition">Registracija</a></span>
			</div>
		</form>
<%
	if(session.getAttribute("login")!=null) {
		session.removeAttribute("login");
%>
		<jsp:include page="/include/message_error.jsp">
			<jsp:param value="Napacno uporabnisko ime ali geslo." name="errorMessage"/>
		</jsp:include>
<%
	}
%>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>