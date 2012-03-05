<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="foodratings.client.DataManagerProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings - Registracija</title>
</head>
<body>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Registracija" name="title"/>
		<jsp:param value="Ustvarite si nov racun." name="subtitle"/>
	</jsp:include>
	<div id="content">
		<form action="/FoodRatings/RegistrationServlet" method="post">
			<div class="inputForm">
				<div class="inputFields">
					<div>
						<label for="username" class="block">Uporabniško ime</label>
						<input type="text" id="username" name="username" class="input_text"/>
					</div>
					<div>
						<label for="password" class="block">Geslo</label>
						<input type="password" id="password" name="password" class="input_text"/>
					</div>
					<div>
						<label for="password2" class="block">Ponovitev gesla</label>
						<input type="password" id="password2" name="password2" class="input_text"/>
					</div>
				</div>
				<div class="inputButtons">
					<input type="submit" value="Registriraj" class="input_button"/>
					<input type="button" value="Pobriši" class="input_button" onclick="this.form.reset()"/>
				</div>
			</div>
		</form>
<%
	if(session.getAttribute("fields")!=null) {
		session.removeAttribute("fields");
%>
		<jsp:include page="/include/message_error.jsp">
			<jsp:param value="Izpolnite vsa polja." name="errorMessage"/>
		</jsp:include>
<%
	}

	if(session.getAttribute("passMatch")!=null) {
		session.removeAttribute("passMatch");
%>
		<jsp:include page="/include/message_error.jsp">
			<jsp:param value="Gesli se ne ujemata." name="errorMessage"/>
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