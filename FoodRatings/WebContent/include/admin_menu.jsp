<%
	String izdelki=request.getParameter("izdelki");
	String proizvajalci=request.getParameter("proizvajalci");
	String drzave=request.getParameter("drzave");
	String kategorije=request.getParameter("kategorije");
	String uporabniki=request.getParameter("uporabniki");
%>

<div id="admin_menu">
	<ul>
		<li><a href="/FoodRatings/admin/admin_izdelki.jsp" <%if(izdelki!=null){out.print("class=\"selected\"");} %>>Izdelki</a></li>
		<li><a href="/FoodRatings/admin/admin_proizvajalci.jsp" <%if(proizvajalci!=null){out.print("class=\"selected\"");} %>>Proizvajalci</a></li>
		<li><a href="/FoodRatings/admin/admin_drzave.jsp" <%if(drzave!=null){out.print("class=\"selected\"");} %>>Drzave</a></li>
		<li><a href="/FoodRatings/admin/admin_kategorije.jsp" <%if(kategorije!=null){out.print("class=\"selected\"");} %>>Kategorije</a></li>
		<li><a href="/FoodRatings/admin/admin_uporabniki.jsp" <%if(uporabniki!=null){out.print("class=\"selected\"");} %>>Uporabniki</a></li>
	</ul>
</div>