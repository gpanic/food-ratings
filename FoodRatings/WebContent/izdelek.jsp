<?xml version="1.0" encoding="UTF-8" ?>
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
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings - Izdelki</title>
</head>
<body>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Izdelki" name="title"/>
		<jsp:param value="Vsi ocenjeni izdelki." name="subtitle"/>
	</jsp:include>
	<div id="content">
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
							<p class="item_att">Kategorija</p>
							<p class="item_att_value"><%=i.getKategorija().getNaziv() %></p>
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						<div>
							<p class="item_att">Proizvajalec</p>
							<p class="item_att_value"><%=i.getProizvajalec().getNaziv()+" ("+i.getProizvajalec().getDrzava()+", "+i.getProizvajalec().getMesto()+")" %></p>
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
							<p class="item_att_value"><%=i.getDrzavaIzvora().getIme() %></p>
						</div>
					</td>
					<td>
						<div class="rating_small"><%=df.format(avgDrzave) %></div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>