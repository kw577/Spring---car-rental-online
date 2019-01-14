		<div class="row">
			<div id="sidebar">			
				
				<c:forEach items="${categories}" var="category">
					<a href="${contextRoot}/show/category/${category.id}/offer" class="buttonlink2">
						<div class="optionL">${category.name}</div> 
					</a>
				</c:forEach>
						
							
			</div>
			
			<div id="content">

				
				
				
				
				<!-- Load only when user clicks display products button -->
				<c:if test="${userClickWholeOffer == true or userClickCategoryOffer == true}"> 
					<span class="bigtitle">Car Rental Online</span>
				
					<br /><br />
					<%@include file="showOffer.jsp"%>
				</c:if>

				
				
				<!-- Load only when user clicks main page -->
				<c:if test="${userClickHome == true}"> 
					<%@include file="searchForm.jsp"%>
				</c:if>
				
				
				
				<br/><br/><br/><br/><br/><br/><br/><br/><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
				Pierwsza wersja.
				
			</div>	
</div>