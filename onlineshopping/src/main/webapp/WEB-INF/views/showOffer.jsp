<!-- petla forEach z biblioteki jstl  - test polaczenie z projektem backendu -->
<c:forEach items="${categories}" var="category">
				
	<a href="#" class="list-group-item">${category.name}</a> 
				
</c:forEach>