<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="foodratings.client.Drzava"%>
<%@page import="foodratings.client.Proizvajalec"%>
<%@page import="foodratings.client.Kategorija"%>
<%@page import="java.util.List"%>
<%@page import="foodratings.client.DataManagerProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	DataManagerProxy dmp=new DataManagerProxy();
	List<Kategorija> klist=dmp.listKategorija().getKategorije();
	List<Proizvajalec> plist=dmp.listProizvajalec().getProizvajalci();
	List<Drzava> dlist=dmp.listDrzava().getDrzave();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings - Administracija</title>
</head>
<body>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Administracija" name="title"/>
		<jsp:param value="Urejanje strani, podatkov in uporabnikov." name="subtitle"/>
	</jsp:include>
	<jsp:include page="/include/admin_menu.jsp" >
		<jsp:param value="selected" name="izdelki"/>
	</jsp:include>
	<div id="content">
		<form action="/FoodRatings/AddIzdelekServlet" method="post">
			<div class="item_details">
				<h1>Dodaj izdelek</h1>
					<div>
						<p class="item_att">Naziv</p>
						<p class="item_att_textfield"><input type="text" class="input_text" name="naziv"/></p>
					</div>
					<div>
						<p class="item_att">Kategorija</p>
						<select name="kategorija" class="input_select">
<%
	for(Kategorija k:klist) {
%>
							<option value="<%=k.getId() %>"><%=k.getNaziv() %></option>
<%
	}
%>
						</select>
					</div>
					<div>
						<p class="item_att">Proizvajalec</p>
						<select name="proizvajalec" class="input_select">
<%
	for(Proizvajalec p:plist) {
%>
							<option value="<%=p.getId() %>"><%=p.getNaziv()+" ("+p.getMesto()+", "+p.getDrzava()+")" %></option>
<%
	}
%>
						</select>
					</div>
					<div>
						<p class="item_att">Drzava izvora</p>
						<select name="drzava" class="input_select">
<%
	for(Drzava d:dlist) {
%>
							<option value="<%=d.getId() %>"><%=d.getIme() %></option>
<%
	}
%>
						</select>
					</div>
			</div>
			<div class="buttons">
				<input type="submit" value="Dodaj" class="input_button"/>
				<input type="button" value="Pobriši" class="input_button" onclick="this.form.reset()")"/>
				<input type="button" value="Prekliči" class="input_button" onclick="location.href='/FoodRatings/admin/admin_izdelki.jsp'")"/>
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
%>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>