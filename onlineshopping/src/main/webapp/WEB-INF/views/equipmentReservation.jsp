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
							
				<form action="" method="post">
					<div class="reservationFormInput">		
						Pick-up date:
						</br>
						<input type="text" id="rentStart" placeholder="Rent start">		
					</div>
					
				
					<div class="reservationFormInput">
						Drop-off date:
						</br>
						<input type="text" id="rentEnd" placeholder="Rent end">		
					</div>
					
					<div class="reservationFormInput">
						Enter your name:
						</br>
						<input type="text" id="userName" placeholder="Your name">		
					</div>					
							
					<div class="reservationFormInput">
						Enter your surname:
						</br>
						<input type="text" id="userSurname" placeholder="Your surname">		
					</div>	
					
					<div class="reservationFormInput">
						Your e-mail address:
						</br>
						<input type="text" id="userEmail" placeholder="Address e-mail">		
					</div>	
							
					<div class="reservationFormInput">
						Your phone number:
						</br>
						<input type="text" id="userEmail" placeholder="Phone number">		
					</div>	
					<div class="reservationFormInput">
						<input type="submit" value="Reservation">
					</div>
					<div class="reservationFormInput">
						
						<a href="${contextRoot}/home" class="cancelButton">Cancel</a>
						
					</div>
					
					<div style="clear:both;"></div>
				</form>
					
			</div>	
		
		

		
	</div>	