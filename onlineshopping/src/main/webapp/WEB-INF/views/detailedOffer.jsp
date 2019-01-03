		<div class="detailedView1">
			<div class="detailedViewLeft">
					<img src="${images}/${equipment.code}.png" class="detailedViewPhoto"/>
			</div>
			
			<div class="detailedViewRight">
				<div class="specificationTitle">${equipment.name}</div>
				<div class="specification">Brand: ${equipment.brand}</div>
				<div class="specification">${equipment.unitPrice} &#8364;/day</div>
				<div class="specification">${equipment.quantity}pcs</div>
				
				
			</div>

			<div style="clear:both;"></div> 
			
		</div>	
		
		
		
		
		
		
		<div class="detailedView2">
			<div class="descripton">
					${equipment.detailed_description}
			</div>
			
			<div class="actionButtons">
			
				<a href="${contextRoot}/show/whole/offer" class="backButton">BACK</a>
			
				<a href="${contextRoot}/cart/add/id/${equipment.id}/equipment" class="orderButton">RENT</a>
			
										
				
			</div>

			<div style="clear:both;"></div> 
			
		</div>	