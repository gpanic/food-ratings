<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="foodratings.client.Izdelek"%>
<%@page import="java.util.List"%>
<%@page import="foodratings.client.DataManagerProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	DataManagerProxy dmp=new DataManagerProxy();
	List<Izdelek> list=dmp.listIzdelek().getIzdelki();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="/FoodRatings/js/list.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings - Administracija</title>
</head>
<body>
<form method="post" action="/FoodRatings/admin/admin_izdelek.jsp" name="selectListItemForm" id="selectListItemForm">
	<input type="hidden" id="idItem" name="idItem" value=""/>
</form>
<form method="post" action="/FoodRatings/DeleteIzdelekServlet" name="deleteListItemForm" id="deleteListItemForm">
	<input type="hidden" id="idItem" name="idItem" value=""/>
</form>
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
		<h1>Pregled izdelkov</h1>
		<table class="list_item_admin_table">
<%

	for(Izdelek i:list) {
		out.println("<tr>"
				+"<td><div class=\"list_item_admin\" onClick=\"selectListItem("+i.getId()+")\">"
				+"<h1>"+i.getNaziv()+"</h1>"
				+"<h2>Kategorija: "+i.getKategorija().getNaziv()+"</h2>"
				+"<h2>Proizvajalec: "+i.getProizvajalec().getNaziv()+"</h2>"
				+"</div></td>"
				+"<td><div class=\"delete_item\" onClick=\"deleteListItem("+i.getId()+")\">"+"X</div></td>"
				+"</tr>");
	}
%>
		</table>
		<div class="buttons">
			<input type="button" value="Dodaj" class="input_button" onclick="location.href='/FoodRatings/admin/admin_izdelek_add.jsp'" />
		</div>
<%
	if(session.getAttribute("created")!=null) {
		session.removeAttribute("created");
%>
		<jsp:include page="/include/message_info.jsp">
			<jsp:param value="Izdelek je bil dodan." name="message"/>
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