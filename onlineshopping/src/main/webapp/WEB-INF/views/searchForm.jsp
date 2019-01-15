<%@taglib prefix="sf" uri="http://www.springframework.org/tags" %>  

<div id="formularz">
					
					<form action="<sf:url value="offer/criteria/search"/>">	
						<div class="formularzOpis">
						Pick-up date:
						<input type="text" id="depart" name="rentStart" value="${param.rentStart}" placeholder="Rent start">
						</div>
						
						
				
						
						<div class="formularzOpis">
						Drop-off date:

						<input type="text" id="return" name="rentEnd" value="${param.rentEnd}" placeholder="Rent end">
						
						</div>
						<br /><br />
						
						</br>
						
						<div class="formularzOpis">
						What do you want to rent:
						<select id="vehicle" name="category" path="category">
							<option selected hidden style='display: none' value='0'></option>
							<c:forEach items="${categories}" var="category">
								<option value="${category.id}" >${category.name}</option>
							</c:forEach>
						</select>
							
						
						
						</div>
						<div class="formularzOpis">
						Enter max price daily:
					
						
						<input type="number" id="cena" name="maxPrice" value="${param.maxPrice}" placeholder="Max price/day" min="0">
						</div>

						<br /><br />

						<input type="submit" value="Search">
					</form>
</div>