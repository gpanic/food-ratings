<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/FoodRatings/css/style.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Food Ratings</title>
</head>
<body>
<div id="body_container">
	<jsp:include page="/include/header.jsp" />
	<jsp:include page="/include/content_header.jsp" >
		<jsp:param value="Domov" name="title"/>
		<jsp:param value="Osrednja stran." name="subtitle"/>
	</jsp:include>
	<div id="content">
		<h1>Food Ratings</h1>
		<p>Ideja je spletna aplikacija, ki ocenjuje kvaliteto prehrambenih izdelkov na podlagi večih parametrov, ki jih uporabniki vnašajo. Za oceno kvalitete se uporabi presoja uporabnikov in zunanje storitve. Vse ocene se beležijo v podatkovni bazi, kar omogoča statistične analize in pregled ocen izdelkov. Vsi izdelki so uvrščeni v določene kategorije in podkategorije. Aplikacija omogoča tudi urejanje vseh obstoječih izdelkov. Uporabniški vmesnik je v obliki spletne strani, ki komunicira z aplikacijskim strežnikom, ta pa podatke črpa iz podatkovne baze. Arhitektura je v slogu SOA-e, kar pomeni, da so funkcionalnosti izpostavljene v obliki spletnih storitev, ki jih uporabniški vmesnik kliče.</p>
	</div>
	<div class="push"></div>
</div>
<jsp:include page="/include/footer.jsp" />
</body>
</html>