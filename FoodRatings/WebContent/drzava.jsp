<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="foodratings.client.Drzava"%>
<%@page import="foodratings.client.Ocena"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="foodratings.util.FoodRatingsUtil"%>
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
	Drzava d=dmp.readDrzava(id);
	
	double avgUporabniki=FoodRatingsUtil.getAverageRating(d.getOcene());
	DecimalFormat df=new DecimalFormat("0.0");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings - Drzava</title>
</head>
<body>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Drzave" name="title"/>
		<jsp:param value="Vse ocenjene drzave." name="subtitle"/>
	</jsp:include>
	<div id="content">
		<div class="item_details">
			<div class="rating">
				<span>Ocena uporabnikov</span>
				<div><%=df.format(avgUporabniki) %></div>
			</div>
			<h1><%=d.getIme() %></h1>
			<table>
				<tr>
					<td>
						<div>
							<p class="item_att">Ime</p>
							<p class="item_att_value"><%=d.getIme() %></p>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div>
							<p class="item_att">Kratica</p>
							<p class="item_att_value"><%=d.getKratica() %></p>
						</div>
					</td>
				</tr>
			</table>
		</div>
<%
	if(session.getAttribute("userId")!=null) {
		int rating=-1;
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		List<Ocena> ocene=d.getOcene();
		for(Ocena o:ocene) {
			if(o.getIdUser()==userId) {
				rating=o.getOcena();
			}
		}
%>
		<div class="item_rating_system">
			<form action="RateDrzavaServlet" method="post">
				<input type="hidden" name="userId" value="<%=session.getAttribute("userId") %>"/>
				<input type="hidden" name="itemId" value="<%=d.getId() %>"/>
				<div>Vaša ocena:</div>
				<select name="rating" class="input_select_rating">
<%
		if(rating==-1) {
%>
					<option value="-1">Brez</option>
<%
		}
		for(int j=1;j<11;j++) {	
%>
					<option value="<%=j %>" <%if(rating>=0&&rating==j){out.print("selected=\"selected\"");} %>><%=j %></option>
<%
		}
%>
				</select>
				<input type="submit" class="input_button" value="Oceni" style="margin-left:20px;"/>
			</form>
		</div>
<%
	}
%>
		<div class="buttons">
			<input type="button" value="Nazaj" class="input_button" onclick="location.href='/FoodRatings/drzave.jsp'"/>
		</div>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>