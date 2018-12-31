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
				
				
				
					<!-- petla forEach z biblioteki jstl  - test polaczenie z projektem backendu -->
					<c:forEach items="${categories}" var="category">
				
						<a href="#" class="list-group-item">${category.name}</a> 
				
					</c:forEach>
				
				
				
				
				
				<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
				Pierwsza wersja.
				
			</div>	
</div>