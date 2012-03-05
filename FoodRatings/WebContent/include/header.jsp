<%@page import="foodratings.client.Uporabnik"%>
<%@page import="foodratings.client.DataManagerProxy"%>
<script type="text/javascript">
var show=false;
$(document).click(function(e) {
	var target=e.target;
	if($(target).is('#userTab')) {
		if(!show) {
			$('#userMenu').css('visibility', 'visible');
			$('#userTab').css('z-index', '11');
			$('#userTab').css('background-color', '#3d3d3d');
			$('#userTab').css('color', '#e3e3e3');
			show=true;
		} else {
			$('#userMenu').css('visibility', 'hidden');
			$('#userTab').css('z-index', '9');
			$('#userTab').css('background-color', 'transparent');
			$('#userTab').css('color', '#3d3d3d');
			show=false;
		}
	} else {
		$('#userMenu').css('visibility', 'hidden');
		$('#userTab').css('z-index', '9');
		$('#userTab').css('background-color', 'transparent');
		$('#userTab').css('color', '#3d3d3d');
		show=false;
	}
});
</script>
<%
	DataManagerProxy dmp=new DataManagerProxy();
	Uporabnik user=null;
	if(session.getAttribute("userId")!=null) {
		int id=(Integer)session.getAttribute("userId");
		user=dmp.readUporabnik(id);
	}
%>
<div id="header_container">
	<div id="header">
		<div id="website_title" onclick="location.href='/FoodRatings'">
			FOOD<span id="highlight">RATINGS</span>
		</div>
		<ul>
			<li><a href="/FoodRatings/izdelki.jsp">IZDELKI</a></li>
			<li><a href="/FoodRatings/proizvajalci.jsp">PROIZVAJALCI</a></li>
			<li><a href="/FoodRatings/drzave.jsp">DRZAVE</a></li>
<%
	if(session.getAttribute("userId")!=null) {
		if(user.getRole().equals("admin")) {
%>
			<li><a href="/FoodRatings/admin/admin_izdelki.jsp">ADMIN</a></li>
<%
		}
	}
%>
		</ul>
		<ul id="menuitems_right">
<%
	if(session.getAttribute("userId")!=null) {
%>
			<li><a id="userTab"><%=user.getUsername() %></a></li>
<%
	} else {
%>
			<li><a href="/FoodRatings/signin.jsp">Prijava</a></li>
<%
	}
%>
		</ul>
	</div>
	<div id="userMenu_container">
		<ul id="userMenu">
			<li><a href="#">Moj profil</a></li>
			<li><a href="/FoodRatings/SignOutServlet">Izpisi me</a></li>
		</ul>
	</div>
</div>