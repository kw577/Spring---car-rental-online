<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>

	<div class="row2">
	
			<div class="summary">
				<div class="summaryLeft">
						<img src="${images}/${equipment.code}.png" class="detailedViewPhoto"/>
					
				</div>
				
				<div class="summaryRight">
					<div class="specificationTitle">${equipment.name}</div>
					<div class="specification">Brand: ${equipment.brand}</div>
					<div class="specification">${equipment.unitPrice} &#8364;/day</div>
					<div class="specification">${equipment.quantity}pcs</div>
					
					
				</div>

				<div style="clear:both;"></div> <!--div dodany zostal aby wyczyscic formtaowanie float: left; - rozmieszczenie szeregowe div'ow-->
				
			</div>	
			
			<div class="reservationForm">
							
				<sform:form modelAttribute="reservation">
					<div class="reservationFormInput">		
						Pick-up date:
						</br>
						<sform:input type="text" id="rentStart" path="reservation_start" placeholder="Rent start"/>					
					</div>
					
				
					<div class="reservationFormInput">
						Drop-off date:
						</br>		
						<sform:input type="text" id="rentEnd" path="reservation_end" placeholder="Rent end"/>					
					</div>
					
					<div class="reservationFormInput">
						Enter your name:
						</br>
						<sform:input type="text" id="userName" path="user_name" placeholder="Your name"/>						
					</div>					
							
					<div class="reservationFormInput">
						Enter your surname:
						</br>	
						<sform:input type="text" id="userSurname" path="user_surname" placeholder="Your surname"/>						
					</div>	
					
					<div class="reservationFormInput">
						Your e-mail address:
						</br>	
						<sform:input type="text" id="userEmail" path="user_email" placeholder="Your email"/>						
					</div>	
							
					<div class="reservationFormInput">
						Your phone number:
						</br>	
						<sform:input type="text" id="userPhone" path="user_phone" placeholder="Your phone"/>						
					
					</div>	
					<div class="reservationFormInput">
						<input type="submit" value="Reservation">
						<sform:hidden path="id"/>
						<sform:hidden path="equipment_id"/>
						<sform:hidden path="total_price"/>
					</div>
					<div class="reservationFormInput">
						
						<a href="${contextRoot}/home" class="cancelButton">Cancel</a>
						
					</div>
					
					<div style="clear:both;"></div>
				</sform:form>
					
			</div>	
		
		

		
	</div>	