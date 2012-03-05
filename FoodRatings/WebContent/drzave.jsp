<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="foodratings.client.Drzava"%>
<%@page import="java.util.List"%>
<%@page import="foodratings.client.DataManagerProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="/FoodRatings/js/list.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings - Države izvora</title>
</head>
<body>
<form method="post" action="/FoodRatings/drzava.jsp" name="selectListItemForm" id="selectListItemForm">
	<input type="hidden" id="idItem" name="idItem" value=""/>
</form>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Drzave izvora" name="title"/>
		<jsp:param value="Vse ocenjene drzave izvora." name="subtitle"/>
	</jsp:include>
	<div id="content">
		<h1>Pregled držav</h1>
<%
	DataManagerProxy dmp=new DataManagerProxy();
	List<Drzava> list=dmp.listDrzava().getDrzave();
	for(Drzava d:list) {
		out.println("<div class=\"list_item_admin\" onClick=\"selectListItem("+d.getId()+")\">"
				+"<h1>"+d.getIme()+"</h1>"
				+"<h2>Kratica: "+d.getKratica()+"</h2>"
				+"</div>");
	}
	
	if(session.getAttribute("rated")!=null) {
		session.removeAttribute("rated");
%>
		<jsp:include page="/include/message_info.jsp">
			<jsp:param value="Ocenili ste drzavo." name="message"/>
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