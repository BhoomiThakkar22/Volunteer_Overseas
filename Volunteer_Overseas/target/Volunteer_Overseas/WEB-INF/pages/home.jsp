<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-grid.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/owl.carousel.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/temp.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/MediaHome.css"/>"
	rel="stylesheet">

</head>
<body>
	<header class="search-banner container-fluid">
		<nav class="navbar navbar-expand-sm navbar-light ">
			<img src="/Volunteer_Overseas/resources/images/logo_1.png"
				style="margin-right: 20px;" />
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarText" aria-controls="navbarText"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOW
							IT WORKS</a></li>
					<li class="nav-item"><a class="nav-link" href="contact">CONTACT
							US</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0">

					<a href="login"><button class="btn btn-outline-white my-2 my-sm-0"
						style="color: white;" type="submit">Log In</button></a>
				</form>
			</div>
		</nav>
		<nav class="navbar navbar-expand-sm navbar-light d-none">
			<img class="img-responsive"
				src="/Volunteer_Overseas/resources/images/logo.png" height="50px"
				widhth="40px"></img>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item "><a class="nav-link" href="#">HOW IT
							WORKS</a></li>
					<li class="nav-item "><a class="nav-link" href="#">CONTACT
							US</a></li>


				</ul>
				<form class="form-inline my-2 my-lg-0">
					<button class="form-control btn btn-outline-success my-2 my-sm-0"
						type="submit">Login</button>
				</form>
			</div>
		</nav>

		<div>
			<h1>Discover Yourself, Discover the World</h1>
			<h3>Apply to your perfect volunteer, intern, or teach abroad
				program.</h3>

			<div class="container-fluid search-bar">
				<form class="form">
				<div class="row">
				
					<div class="col-sm-3 form-group">

						<label>Type</label> <select class="form-control home-select-1"
							id="myselect">
							<%-- <c:forEach items="${categories}" var="category">
							<option value="${category.id}">${category.name}</option>
							
							</c:forEach> --%>
							<option value="1">Volunteer Abroad</option>
							<option value="1">2</option>
							<option value="1">3</option>
							<option value="1">4</option>
							<option value="1">5</option> 
						</select>

					</div>
					<div class="col-sm-4 form-group">
						<label>Location</label> <input type="text"
							class="form-control search-input" value="Anywhere">
					</div>
					<div class="col-sm-3 form-group">

						<label>Activity</label> <select class="form-control home-select-2">
							<option value="1">Anything</option>
							<option value="1">2</option>
							<option value="1">3</option>
							<option value="1">4</option>
							<option value="1">5</option>
						</select>

					</div>
					<div class="col-sm-2 form-group">
						<a href="search_result"><button type="submit" class=" btn-danger">Search</button></a>
					</div>
					
				</div>
				</form>
			</div>
		</div>
	</header>


	<div class="container-fluid">

		<div class="container-fluid" id="slider1">
			<h2>Trending Projects</h2>
			<div class="owl-carousel owl-nav">
				<%
					for (int i = 0; i < 10; i++) {
				%>
				<div class="item">
					<a href="index"><img
						src="/Volunteer_Overseas/resources/images/thumb01.jpg" /></a>
					<div>
						<label class="label1"> Cost Rice </label>
						<h6>MEDICAL SUPPORT IN QAPOS</h6>
						<p>Global Vlounteering International</p>
						<label class="label2">12 people researching this project</label>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<div class="container-fluid" id="slider2">
			<h2>Feature Destinations</h2>
			<div class="owl-carousel">
				<%
					for (int i = 0; i < 10; i++) {
				%>
				<div class="item">
					<a href="index"><img
						src="/Volunteer_Overseas/resources/images/thumb10.jpg" /></a>
					<div>
						<label class="slider2-label"> 37 Projects in </label>
						<h6>KENAY</h6>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<div class="container-fluid " id="slider3">
			<h2>Most Affordable Project</h2>
			<div class="owl-carousel">
				<%
					for (int i = 0; i < 10; i++) {
				%>
				<div class="item">
					<a href="index"> <img
						src="/Volunteer_Overseas/resources/images/thumb16.jpg">
					</a>
					<div>
						<label class="slider3-label1">Starting At </label>
						<h4>$299/Week</h4>
						<label class="slider3-label1">for 4 weeks</label>
						<h6>Surf School for Children</h6>
					</div>
					<figcaption>
						<label>South Africa</label>
						<h6>Global Volunteering International</h6>
					</figcaption>
				</div>
				<%
					}
				%>

			</div>
		</div>


	</div>
	<%@include file="includes.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#slider1>div').owlCarousel();
			$('#slider2>div').owlCarousel();
			$('#slider3>div').owlCarousel();

		});
		$('#slider1>div')
				.owlCarousel(
						{
							loop : true,
							margin : 10,
							nav : true,
							navText : [
									"<img src='/Volunteer_Overseas/resources/images/left-white-arrow.png'>",
									"<img src='/Volunteer_Overseas/resources/images/right-white-arrow.png'>" ],
							responsiveClass : true,
							responsive : {
								0 : {
									items : 1,
								},
								425 : {
									items : 2,
								},
								1024 : {
									items : 4,

								}
							}
						});
		$('#slider2>div')
				.owlCarousel(
						{
							loop : true,
							margin : 10,
							nav : true,
							navText : [
									"<img src='/Volunteer_Overseas/resources/images/left-white-arrow.png'>",
									"<img src='/Volunteer_Overseas/resources/images/right-white-arrow.png'>" ],
							responsiveClass : true,
							responsive : {
								0 : {
									items : 2,

								},
								425 : {
									items : 3,

								},
								1024 : {
									items : 6,
									nav : true
								}
							}
						});

		$('#slider3>div')
				.owlCarousel(
						{
							loop : true,
							margin : 10,
							nav : true,
							navText : [
									"<img src='/Volunteer_Overseas/resources/images/left-white-arrow.png'>",
									"<img src='/Volunteer_Overseas/resources/images/right-white-arrow.png'>" ],
							responsiveClass : true,
							responsive : {
								0 : {
									items : 1,

								},
								425 : {
									items : 3,

								},
								1000 : {
									items : 5,

								}
							}
						});
	</script>
	<script type="text/javascript">
		$(window).scroll(
				function() {
					if ($(window).scrollTop() > 0) {
						/*$("header.head-index nav:first").hide();*/
						$("header.search-banner nav:eq(1)").removeClass(
								'd-none');
						$("header.search-banner nav:eq(1)").addClass(
								'fixed-header');

					} else {
						/*$("header.head-search nav:first").show();*/
						$("header.search-banner nav:eq(1)").addClass('d-none');
						$("header.search-banner nav:eq(1)").removeClass(
								'fixed-header');

					}
				});
	</script>
	<footer>
		<img class="footer-img"
			src="/Volunteer_Overseas/resources/images/logo_1.png" height="50px"
			widhth="50px"></img> <span
			style="float: right; color: white; padding-top: 25px; padding-right: 10px;">
			<a href="contact" class="text-light">CONTACT US</a></span> <span
			style="float: right; color: white; padding-top: 25px; padding-right: 10px;"><a href="faq" class="text-light">FAQ
			&nbsp; </a></span>
	</footer>
</body>
</html>