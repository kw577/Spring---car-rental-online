<table id="table1">
  <tr>
    <th>Item</th>
    <th>Brand</th>
    <th>Description</th>
    <th>Price per day</th>
    <th>Amount available</th>
  </tr>
</table>


<!-- jQuery AJAX -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	
<script>
$( document ).ready(function() {
 $.getJSON("${contextRoot}/json/data/whole/offer", function(data){ 
     var equipment_data = '';
      $.each(data, function(key, value){
          equipment_data += '<tr>';
          equipment_data += '<td>'+value.name+'</td>';
          equipment_data += '<td>'+value.brand+'</td>';
          equipment_data += '<td>'+value.description+'</td>';
          equipment_data += '<td>'+value.unitPrice+'</td>';
          equipment_data += '<td>'+value.quantity+'</td>';
          equipment_data += '</tr>';
      });
      $('#table1').append(equipment_data);    
  });
 });
</script> 



