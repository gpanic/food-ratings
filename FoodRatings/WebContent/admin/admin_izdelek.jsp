<?xml version="1.0" encoding="UTF-8" ?>
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
	Izdelek i=dmp.readIzdelek(id);
	
	double avgUporabniki=FoodRatingsUtil.getAverageRating(i.getOcene());
	double avgProizvajalec=FoodRatingsUtil.getAverageRating(i.getProizvajalec().getOcene());
	double avgDrzave=FoodRatingsUtil.getAverageRating(i.getDrzavaIzvora().getOcene());
	DecimalFormat df=new DecimalFormat("0.0");

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
		<form name="updateIzdelekForm" action="/FoodRatings/UpdateIzdelekServlet" method="post">
			<input type="hidden" name="idItem" value="<%=i.getId() %>"/>
			<div class="item_details">
				<div class="rating">
					<span>Ocena uporabnikov</span>
					<div><%=df.format(avgUporabniki) %></div>
				</div>
				<h1><%=i.getNaziv() %></h1>
				<table>
					<tr>
						<td>
							<div>
								<p class="item_att">Naziv</p>
								<p class="item_att_textfield"><input type="text" class="input_text" name="naziv" value="<%=i.getNaziv() %>"/></p>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<p class="item_att">Kategorija</p>
								<select name="kategorija" class="input_select">
<%
	for(Kategorija k:klist) {
%>
										<option value="<%=k.getId() %>" <%if(i.getKategorija().getId()==k.getId()){out.print("selected=\"selected\"");} %>><%=k.getNaziv() %></option>
<%
	}
%>
								</select>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							<div>
								<p class="item_att">Proizvajalec</p>
								<select name="proizvajalec" class="input_select">
<%
	for(Proizvajalec p:plist) {
%>
									<option value="<%=p.getId() %>" <%if(i.getProizvajalec().getId()==p.getId()){out.print("selected=\"selected\"");} %>><%=p.getNaziv()+" ("+p.getMesto()+", "+p.getDrzava()+")" %></option>
<%
	}
%>
								</select>
							</div>
						</td>
						<td>
							<div class="rating_small"><%=df.format(avgProizvajalec) %></div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<p class="item_att">Drzava izvora</p>
								<select name="drzava" class="input_select">
<%
	for(Drzava d:dlist) {
%>
										<option value="<%=d.getId() %>" <%if(i.getDrzavaIzvora().getId()==d.getId()){out.print("selected=\"selected\"");} %>><%=d.getIme() %></option>
<%
	}
%>
								</select>
							</div>
						</td>
						<td>
							<div class="rating_small"><%=df.format(avgDrzave) %></div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<p class="item_att">Angleško ime</p>
								<p class="item_att_textfield"><input type="text" class="input_text" name="engName" value="<%=i.getEngName() %>"/></p>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" value="Posodobi" class="input_button"/>
				<input type="button" value="Prekliči" class="input_button" onclick="location.href='/FoodRatings/admin/admin_izdelki.jsp'"/>
			</div>
		</form>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>