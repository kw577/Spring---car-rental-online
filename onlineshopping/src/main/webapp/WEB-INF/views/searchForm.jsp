<div id="formularz">
					<form action="" method="post">
						
						<div class="formularzOpis">
						Pick-up date:
						<input type="text" id="depart" placeholder="Rent start">
						</div>
						
						<div class="formularzOpis">
						Drop-off date:
						<input type="text" id="return" placeholder="Rent end">		
						</div>
						<br /><br />
						
				
							
						
						</br>
						
						<div class="formularzOpis">
						What do you want to rent:
						<select id="vehicle">
							<option selected disabled hidden style='display: none' value=''></option>
							<option value="1" >Samochód osobowy</option>
							<option value="2">Motocykl</option>
							<option value="3">Samochód rodzinny</option>
						</select>
						</div>
						<div class="formularzOpis">
						Enter max price daily:
						<input type="text" id="cena" placeholder="Max price/day">
						</div>

						<br /><br />

						<input type="submit" value="Search">
					</form>
</div>