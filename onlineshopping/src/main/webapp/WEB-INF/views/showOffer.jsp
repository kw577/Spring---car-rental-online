<!-- petla forEach z biblioteki jstl  - test polaczenie z projektem backendu -->
<c:forEach items="${categories}" var="category">
				
	<a href="#" class="list-group-item">${category.name}</a> 
				
</c:forEach>

</br></br>

<c:forEach items="${cars}" var="car">
				
	<a href="#" class="list-group-item">${car.name}</a> 
				
</c:forEach>



<table id="table2">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th> 

  </tr>

</table>
	<!-- jQuery AJAX -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	
    
      <script>
$( document ).ready(function() {
 $.getJSON("${contextRoot}/json/data/whole/offer", function(data){ 
     var employee_data = '';
      $.each(data, function(key, value){
          employee_data += '<tr>';
          employee_data += '<td>'+value.name+'</td>';
          employee_data += '<td>'+value.unitPrice+'</td>';
          employee_data += '</tr>';
      });
      $('#table2').append(employee_data);    
  });
 });
 </script> 


</br></br></br></br></br></br></br></br>

<table>
 					
 					
						<thead>

							<tr>

								<th>ID</th>
								<th></th> <!-- ta kolumna przechowuje zdjecie -->
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th> <!-- ta kolumna przechowuje przyciski akcji podgladu produktu i dodania go do koszyka -->

							</tr>

						</thead>


						<tfoot>

							<tr>
								<th></th> 
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>

						</tfoot>


					</table>
