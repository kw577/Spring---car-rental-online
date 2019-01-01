<!-- petla forEach z biblioteki jstl  - test polaczenie z projektem backendu -->
<c:forEach items="${categories}" var="category">
				
	<a href="#" class="list-group-item">${category.name}</a> 
				
</c:forEach>

</br></br>

<c:forEach items="${cars}" var="car">
				
	<a href="#" class="list-group-item">${car.name}</a> 
				
</c:forEach>