<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- spring tags - pozwala na korzystanie z dodatkowych funkcji zawartych w frameworku spring -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
<!-- c:   - oznacza ze korzystamy z funkcjonalnosci z biblioteki jstl -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!-- contextRoot to nazwa projektu - "onlineshopping"  -->    
<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Car Rental Online</title>

    <!-- Custom CSS -->
    <link href="${css}/myapp.css" rel="stylesheet">
    
    <!--Pobranie czcionki z google.fonts-->
	<link href='http://fonts.googleapis.com/css?family=Lato:400,900&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

</head>
<body>
	
	<div id="container">
			

		
		<div id="topbar">
			<div id="topbarL">
				<img src="${images}/mainPage_image.png" class="imageLogo"/>
			</div>
			<div id="topbarR">
				<!--<span> sluzy do grupowania elementow (np. tekstu, obrazkow) zazwyczaj w celu przypisania im okreslonego stylu CSS. W przciwienstwie do div nie uzywa sie ich do okreslania rozkladu elementow na stronie-->
				<span class="bigtitle">We will find the best car for you !!! </span>
				<div style="height: 15px;"></div> <!--div inline - w celu dodania linii odstepu-->
				We rent cars, motorcycles, small busses and car's trailers. Always in good price.
			</div>
			<div style="clear:both;"></div> <!--div dodany zostal aby wyczyscic formtaowanie float: left; - rozmieszczenie szeregowe div'ow zawarte w div'ach topbarL i topbarR-->
		</div>
		
		<div class="menu">
		
			
				<div class="option">Main page</div>
				<div class="option">Our offer</div>
				<div class="option">About us</div>
				<div class="option">Contact us</div>
				<div class="option">Gallery</div>
				
				
				<div style="clear:both;"></div> <!--div dodany zostal aby wyczyscic formtaowanie float: left; - rozmieszczenie szeregowe div'ow-->
			
			
		</div>
		
		
		
		<div class="row">
			<div id="sidebar">
				<div class="optionL">Cars</div>
				<div class="optionL">Motorcycles</div>
				<div class="optionL">Busses</div>
				<div class="optionL">Limousines</div>
				<div class="optionL">Trailers</div>
				
			</div>
			
			<div id="content">
				<span class="bigtitle">Car Rental Online</span>
				
				<br /><br />
				
				Here are our cars: 
				
				<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
				
				
				<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
				Pierwsza wersja.
				
			</div>	
		</div>	
		<div id="footer">
			Projekt w ramach przedmiotu Programowanie Zaawansowane Java &copy; 
		</div>
	
	</div>
	
	
	<!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
	
	<!--Dodanie biblioteki jquery-->
	<script src="${js}/jquery-1.11.3.min.js"></script>


	<!--ponizej skrypt powodujacy przyklejanie sie paska nawigacji do gornej czesci strony przy jej scrolowaniu-->
	<script>
		$(document).ready(function() {
		var NavY = $('.menu').offset().top;
		 
		var stickyNav = function(){
		var ScrollY = $(window).scrollTop();
			  
		if (ScrollY > NavY) { 
			$('.menu').addClass('sticky');
		} else {
			$('.menu').removeClass('sticky'); 
		}
		};
		 
		
		stickyNav();
		 
		$(window).scroll(function() {
			stickyNav();
		});
		});
	
	</script>
	
	
	
	
	
	
	
</body>
</html>