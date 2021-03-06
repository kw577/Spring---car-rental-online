<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- spring tags - pozwala na korzystanie z dodatkowych funkcji zawartych w frameworku spring -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

	
	<!--Biblioteka zaw. datapicker - mozna tez pobrac te pliki i dodac rel-->
	<!--Mozliwe style do wyboru: base black-tie blitzer cupertino dark-hive dot-luv eggplant excite-bike flick hot-sneaks humanity le-frog mint-choc overcast pepper-grinder redmond smoothness south-street start sunny swanky-purse trontastic ui-darkness ui-lightness vader-->
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/cupertino/jquery-ui.css" type="text/css" />
	
</head>
<body>
	<div id="container">
			
	<!-- Navigation - w tym miejscu jest wstawiony kod z pliku navbar.jsp -->
	<%@include file="./shared/navbar.jsp"%>
		
		
	<!-- Glowna zawartosc strony -->	
	<c:if test="${userClickHome == true or userClickWholeOffer == true or userClickCategoryOffer == true or userClickUserCriteriaOffer == true}"> <!--  c: - funkcja z biblioteki jstl   - ta zawartosc strony jest ladowana gdy uzytkownik kliknie link do strony startowej -->
		<!-- userClickHome - zmienna w klasie PageController.java -->
		<%@include file="home.jsp"%>
	</c:if>	
	
	
	
	<c:if test="${userClickAbout == true }"> 
		<!-- userClickAbout - zmienna w klasie PageController.java -->
		<%@include file="about.jsp"%>
	</c:if>


	<c:if test="${userClickContact == true }"> 
		<!-- userClickContact - zmienna w klasie PageController.java -->
		<%@include file="contact.jsp"%>
	</c:if>
	
	<!-- Gry uzytkownik wybierze przycisk podgladu pojedynczego produktu - informacja ta jest przekazywana w PageController.java poprzezz zmienna userClickShowProduct -->
	<c:if
		test="${userClickShowDetails == true}">
		<%@include file="detailedOffer.jsp"%>
	</c:if>
	
	<!-- Formularz rezerwacji -->
	<c:if
		test="${userClickEquipmentReservation == true}">
		<%@include file="equipmentReservation.jsp"%>
	</c:if>
	
	
	<!-- Footer - w tym miejscu jest wstawiony kod z pliku footer.jsp -->
	<%@include file="./shared/footer.jsp"%>
	
	</div>
	
	
	<!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
	
	<!--Dodanie biblioteki jquery-->
	<script src="${js}/jquery-1.11.3.min.js"></script>

	<!-- DataTable Plugin - jQuery - tabela do wyswietlania produktow -->
	<script src="${js}/jquery.dataTables.js"></script>

	

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
	
		  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#depart" ).datepicker({dateFormat: 'yy-mm-dd'});
    $( "#return" ).datepicker({dateFormat: 'yy-mm-dd'});
    $( "#rentStart" ).datepicker({dateFormat: 'yy-mm-dd'});
    $( "#rentEnd" ).datepicker({dateFormat: 'yy-mm-dd'});
  } );
  </script>
	
	
	
	
	
</body>
</html>