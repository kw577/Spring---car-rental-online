Here are our cars: 
				
<br/><br/>

<c:if test="${userClickWholeOffer == true }">
	<script>
		window.categoryId = '';
	</script>
</c:if>


<c:if test="${userClickCategoryOffer == true }">
	<script>
	window.categoryId = '${category.id}';
	</script>
</c:if>









<table id="table1">
  <tr>
  	<th></th>
    <th>Item</th>
    <th>Brand</th>
    <th>Description</th>
    <th>Price per day</th>
    <th>Amount</th>
    <th></th>
  </tr>
</table>


<!-- jQuery AJAX -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	
<script>
$( document ).ready(function() {
	
	
	var jsonUrl = '';
	if(window.categoryId == '') { // uzytkownik chce wyswietlic wszystkie produkty - nie wybral kategorii
		// zmienna pomocnicza categoryId utworzona w listProducts.jsp
		jsonUrl = '/json/data/whole/offer';
	}
	else { // uzytkownik wybral kategorie dla ktorej chce wyswietlic wszystkie produkty
		jsonUrl = '/json/data/category/'+ window.categoryId +'/equipment';
	}
	
	
	
 $.getJSON("${contextRoot}"+jsonUrl, function(data){ 
     var equipment_data = '';
      $.each(data, function(key, value){
          equipment_data += '<tr>';
          
          equipment_data += '<td>'+'<img src="${images}/'+value.code+'.png" class="dataTableImg"/>'+'</td>';
          
          equipment_data += '<td>'+value.name+'</td>';
          equipment_data += '<td>'+value.brand+'</td>';
          equipment_data += '<td>'+value.description+'</td>';
          equipment_data += '<td>'+value.unitPrice+'</td>';
          equipment_data += '<td>'+value.quantity+'</td>';
          
          equipment_data += '<td>'+'<a href="${contextRoot}/view/id/'+value.id+'/equipment">'+'<img src="${images}/icon_view.png" class="iconTableImg"/></a> &#160;'
          						  +'<a href="${contextRoot}/cart/add/id/'+value.id+'/equipment">'+'<img src="${images}/icon_choose.png" class="iconTableImg"/></a>'+'</td>';
          
          equipment_data += '</tr>';
      });
      $('#table1').append(equipment_data);    
  });
 });
</script> 



