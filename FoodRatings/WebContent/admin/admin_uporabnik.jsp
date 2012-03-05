<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="foodratings.client.Uporabnik"%>
<%@page import="foodratings.client.Drzava"%>
<%@page import="foodratings.client.Proizvajalec"%>
<%@page import="foodratings.client.Kategorija"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="foodratings.util.FoodRatingsUtil"%>
<%@page import="foodratings.client.Izdelek"%>
<%@page import="foodratings.client.DataManagerProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	int id=-1;
	if(request.getParameter("idItem")!=null) {
		id=Integer.parseInt(request.getParameter("idItem"));
	} else {
		if(request.getHeader("Referer")!=null) {
	response.sendRedirect(request.getHeader("Referer"));
		} else {
	response.sendRedirect("/FoodRatings");
		}
	}
	
	DataManagerProxy dmp=new DataManagerProxy();
	Uporabnik u=dmp.readUporabnik(id);
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
		<jsp:param value="selected" name="uporabniki"/>
	</jsp:include>
	<div id="content">
		<form name="updateIzdelekForm" action="/FoodRatings/UpdateUporabnikServlet" method="post">
			<input type="hidden" name="idItem" value="<%=u.getId() %>"/>
			<div class="item_details">
				<h1><%=u.getUsername() %></h1>
				<table>
					<tr>
						<td>
							<div>
								<p class="item_att">Username</p>
								<p class="item_att_textfield"><input type="text" class="input_text" name="username" value="<%=u.getUsername() %>"/></p>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<p class="item_att">Vloga</p>
								<select name="admin" class="input_select">
									<option value="admin" <%if(dmp.isAdminUporabnik(u.getId())){out.print("selected=\"selected\"");} %>>admin</option>
									<option value="user" <%if(!dmp.isAdminUporabnik(u.getId())){out.print("selected=\"selected\"");} %>>user</option>
								</select>
							</div>
						</td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" value="Posodobi" class="input_button"/>
				<input type="button" value="Prekliči" class="input_button" onclick="location.href='/FoodRatings/admin/admin_uporabniki.jsp'"/>
			</div>
		</form>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>