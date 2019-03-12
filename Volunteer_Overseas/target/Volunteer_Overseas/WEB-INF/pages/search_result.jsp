<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="includes.jsp"%>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-grid.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css"/>" type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/navigation.css"/>" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"
	type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/media.css"/>"
	type="text/css">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js" />"></script>

<script type="text/javascript"
	src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"></script>
<style type="text/css">
p img {
	border-radius: 10px;
}
</style>

</head>
<body>
	<div class="sch fixed-top">
		<nav class="navbar navbar-expand-lg navbar-light"
			style="border-bottom: 1px solid #fff"> <a
			class="navbar-brand tbleft" href="#"><img
			src="/Volunteer_Overseas/resources/images/logo.png"
			style="height: 50px"></a>
		<button class="navbar-toggler ttab" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse back" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#"
					style="color: #00acc1; font-size: 16px;">HOW IT WORKS<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					style="color: #00acc1; font-size: 16px;">CONTACT US</a></li>

			</ul>
			<form class="form-inline">
				<button class="btn btn-outline-success my-2 my-sm-0 login1"
					type="submit"
					style="color: #00acc1; float: right; font-size: 14px; border: 1px solid #00acc1; pointer-events: none;">Login</button>
			</form>
		</div>
		</nav>
	</div>

	<div class="container-fluid "
		style="padding-left: 50px; padding-right: 50px; padding-top: 105px;">
		<div class="row bg-light" style="padding-top: 10px;">
			<div class="col-md-4 cvt">
				<div>
					<label style="color: #00acc1; font-size: 14px;">cause</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input style="background-color: #e53b51;" type="checkbox"
						class="custom-control-input" id="defaultInline1"> <label
						class="custom-control-label" for="defaultInline1">Volunteer</label>
				</div>
				<!-- Default inline 2-->
				<div class="custom-control custom-checkbox custom-control-inline">
					<input style="background-color: #e53b51;" type="checkbox"
						class="custom-control-input" id="defaultInline2"> <label
						class="custom-control-label" for="defaultInline2">Teach</label>
				</div>

				<!-- Default inline 3-->
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="defaultInline3"> <label class="custom-control-label"
						for="defaultInline3">Intern</label>
				</div>

			</div>

			<div class="col-md-3 scm">

				<div>
					<label style="color: #00acc1; font-size: 14px;">Country</label>
				</div>
				<div class="form-group">
					<form class="form-control">
						<input type="text" name="sc" value="Search Contry"
							style="font-size: 16px; border: none;">
					</form>
				</div>
			</div>

			<div class="col-md-3 acm">

				<div>
					<label style="color: #00acc1; font-size: 14px;">Activity</label>
				</div>
				<div class="form-group">
					<form>
						<select class="custom-select">
							<option selected>Animal Conversion</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select>
					</form>
				</div>
			</div>

			<div class="co-xs-12 mobile_sr flex-container">
				<div style="padding-top: 40px;">
					<P style="font-size: 14px">
						<span style="color: #00acc1"> Volunteer </span>in <span
							style="color: #00acc1"> cambodia </span> for <span
							style="color: #00acc1">Animal Conversion</span> <img
							src="images/edit-icon.png"
							style="float: right; border: 1px solid #00acc1; border-radius: 0px; margin-right: 7px; height: 20px; width: 20px; margin-bottom: 19px;">
					</P>
				</div>

				<!-- For mobile -->

				<div style="padding-top: 25px">

					<button type="button" class="btn btnmf more-filters-btn"
						data-toggle="modal" data-target="#exampleModal">
						More Filters <span
							style="top: -15px; border-radius: 100%; left: 0px; background-color: #00acc1"
							class="badge badge-light">4</span>
						<!--  <span class="sr-only">unread messages</span> -->
					</button>
					<div class="modal fade more-filters" id="exampleModal"
						tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-body">
									<div class="row">
										<button type="button" class="close" data-dismiss="modal"
											style="padding-left: 50%">&times;</button>
									</div>
									<div class="row">
										<div class="col-md-4">
											<div>
												<label style="color: #00acc1; font-size: 14px;">Start
													date(range)</label> <input type="reset" class="reset">
											</div>
											<div class="row">
												<div class="col-4">
													<select class="custom-select dpd">
														<option selected>month</option>
													</select>
												</div>
												<div class="col-4">
													<select class="custom-select dpd">
														<option selected>dd</option>
													</select>
												</div>
												<div class="col-4">
													<select class="custom-select dpd">
														<option selected>yyyy</option>
													</select>
												</div>
											</div>



											<div class="row" style="padding-top: 20px">
												<div class="col-4">
													<select class="custom-select dpd">
														<option selected>month</option>
													</select>
												</div>
												<div class="col-4">
													<select class="custom-select dpd">
														<option selected>dd</option>
													</select>
												</div>
												<div class="col-4">
													<select class="custom-select dpd">
														<option selected>yyyy</option>
													</select>
												</div>
											</div>

										</div>
										<div class="col-md-4">

											<div>
												<label style="color: #00acc1; font-size: 14px;">Duration</label>
												<input type="reset" class="reset">
											</div>
											<div class="slidecontainer">
												<p>1week - 10weeks</p>
												<input type="range" min="1" max="10" value="1"
													class="slider" id="myRange">
											</div>
										</div>
										<div class="col-md-4">
											<div>
												<label style="color: #00acc1; font-size: 14px;">Minimum
													Age</label>
											</div>
											<div style="padding-top: 15px">
												<form class="form-group">
													<select class="form-control">
														<option>--</option>
													</select>
												</form>
											</div>
										</div>

									</div>

								</div>
								<div>
									<div class="container see_results">
										<div class="row">
											<button type="submit" class="btn form-control"
												data-dismiss="modal">See Results</button>
										</div>
									</div>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- hide when mobile view -->
			<div class="col-md-2 desk1">

				<button type="button" class="btn btnmf more-filters-btn db"
					data-toggle="modal" data-target="#exampleModal1"
					style="float: right;">
					More Filters <span
						style="position: relative; top: -15px; border-radius: 100%; left: 20px; background-color: #00acc1"
						class="badge badge-light">4</span>
					<!--  <span class="sr-only">unread messages</span> -->
				</button>
				<button type="button" class="btn btntab more-filters-btn"
					data-toggle="modal" data-target="#exampleModal1"
					style="float: right;">
					<b style="margin-top: 20px">...</b> <span
						style="position: relative; top: -20px; left: 2px; background-color: #00acc1; border-radius: 100%"
						class="badge badge-light">4</span>
					<!--  <span class="sr-only">unread messages</span> -->
				</button>

				<div class="modal fade" id="exampleModal1" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog " role="document">
						<div class="modal-content side_tab">
							<div class="modal-body">
								<div class="row">
									<div class="col-lg-4">
										<div>
											<label style="color: #00acc1; font-size: 14px;">Start
												date(range)</label> <input type="reset" class="reset">
										</div>
										<div class="row">


											<div class="col-4">
												<select class="custom-select">
													<option selected>month</option>
												</select>
											</div>
											<div class="col-4">
												<select class="custom-select">
													<option selected>dd</option>
												</select>
											</div>
											<div class="col-4">
												<select class="custom-select">
													<option selected>yyyy</option>
												</select>
											</div>


										</div>

										<div class="row" style="padding-top: 20px">


											<div class="col-4">
												<select class="custom-select">
													<option selected>month</option>
												</select>
											</div>
											<div class="col-4">
												<select class="custom-select">
													<option selected>dd</option>
												</select>
											</div>
											<div class="col-4">
												<select class="custom-select">
													<option selected>yyyy</option>
												</select>
											</div>


										</div>
									</div>
									<div class="col-lg-4">

										<div>
											<label style="color: #00acc1; font-size: 14px;">Duration</label>
											<input type="reset" class="reset">

										</div>
										<div class="slidecontainer">
											<p>1week - 10weeks</p>
											<input type="range" min="1" max="10" value="1" class="slider"
												id="myRange">
										</div>
									</div>
									<div class="col-lg-4">
										<div>
											<label style="color: #00acc1; font-size: 14px;">Minimum
												Age</label>
										</div>
										<div style="padding-top: 15px">
											<form class="form-group">
												<select class="form-control">
													<option>--</option>
												</select>
											</form>
										</div>
									</div>

								</div>
								<div>
									<div class="container see_results">
										<div class="row">
											<button type="submit" class="btn form-control"
												data-dismiss="modal">See Results</button>
										</div>
									</div>
								</div>

							</div>

						</div>
					</div>
				</div>

			</div>


		</div>


		<div class="row">

			<div class="col-md-12">
				329 Results
				<div style="float: right;">
					Sort by: <select style="font-size: 14px;">
						<option>Relevancy</option>
					</select>
				</div>
			</div>

		</div>

		<!-- first row-->
		<div class="row search-panel">
			<% for(int i = 0; i < 15; i++) { %>

			<div class="col-md-4">

				<div id="myCarousel" class="carousel slide bg-inverse"
					data-ride="carousel" data-interval="false">
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block w-100"
								src="/Volunteer_Overseas/resources/images/photo01.jpg"
								alt="First slide">
							<div class="carousel-caption">
								<div class="caption">
									<p>MEDICAL VOLUNTEERING</p>
								</div>
							</div>
						</div>
						<div class="carousel-item" data-interval="false">
							<img class="d-block w-100"
								src="/Volunteer_Overseas/resources/images/photo02.jpg"
								alt="Second slide">
							<div class="carousel-caption">
								<div class="caption1">
									<p>LOREM IPSUM</p>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="/Volunteer_Overseas/resources/images/photo03.jpg"
								alt="Third slide">
							<div class="carousel-caption">
								<div class="caption1">
									<p>DOLOR SIT</p>
								</div>
							</div>
						</div>

					</div>
					<a class="carousel-control-prev" href="#myCarousel" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#myCarousel" role="button"
						data-slide="next"> <span class="carousel-control-next-icon"
						aria-hidden="true"></span> <span class="sr-only">Next</span>
					</a>
				</div>
				<p></p>
				<P style="font-size: 16px">Volunteer with Tigers</P>
				<p style="font-size: 14px; color: #00acc1">
					<img
						src="/Volunteer_Overseas/resources/images/volunteer-logo01.png"
						style="width: 20px; height: 20px;">Love Volunteers
				</p>
				<p style="font-size: 14px;">
					$215/week <font style="color: red">.</font> 1-2 weeks duration
				</p>

			</div>

			

			<% } %>
		</div>
		
		<div class="row n1">

			<!-- <div class="col-md-5"></div>
	<div class="col-md-4"> -->

			<nav>
			<ul style="border: none;" class="pagination">

				<!-- <a href="#" class="page-link" aria-label="Previous">
<span aria-hidden="true">&laquo;</span>
</a> -->

				<li class="page-item active"><a href="#" class="page-link">1</a></li>
				<li class="page-item"><a href="#" class="page-link">2</a></li>
				<li class="page-item"><a href="#" class="page-link">3</a></li>
				<li class="page-item"><a href="#" class="page-link">4</a></li>
				<li class="page-item"><a href="#" class="page-link">5</a></li>
				<li class="page-item"><a href="#" class="page-link">6</a></li>

				<li><a href="#">.....</a></li>
				<li class="page-item"><a href="#" class="page-link">12</a></li>
				<!-- <a href="#" class="page-link" aria-label="Next">
<span aria-hidden="true">&raquo;</span>
</a> -->

			</ul>
			</nav>

			<!-- </div> -->

		</div>

	</div>

	<div class="footer">
		<div class="row">
			<img src="images/logo_1.png"> <span> <a
				href="contact_us.html">CONTACT US</a> <a href="faq.html">FAQ</a>
			</span>
		</div>
	</div>
	<script type="text/javascript">
      $('more-filters-btn').click(function () {
    $('.modal').css("data-backdrop","false");
});
 </script>
	<script type="text/javascript"
		src="<c:url value="https://code.jquery.com/jquery-3.2.1.slim.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>"></script>

	<!-- jQuery library -->
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
 -->
	<!-- Popper -->
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 -->
	<!-- Latest compiled and minified Bootstrap JavaScript -->
	<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 -->
	<script type="text/javascript">
  $('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus')
})
</script>
	<script type="text/javascript">
    $(".more-filters-btn").click(function(){ 
          var $this = $(this).closest(".search-panel");
           $this.find(".more-filters").slideToggle(); 
      });  
</script>
	<!-- Initialize Bootstrap functionality -->
	<script>
// Initialize tooltip component
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

// Initialize popover component
$(function () {
  $('[data-toggle="popover"]').popover()
})
</script>
</body>
</html>