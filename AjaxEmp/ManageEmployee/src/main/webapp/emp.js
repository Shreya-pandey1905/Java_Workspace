$(document).ready(function(){
	getEmployees();
	new DataTable('#emptable');
	// $("#search").keydown(function(){
	//
	// })
});

function getEmployees()
{
	$.ajax({
		url:'EmpController',
		type:'GET',
		data:{action:'getEmp'},
		dataType:'json',
		success:function(res){
			console.log(res);
			var obj='';
			$.each(res,function(index,item){
				obj+="<tr>";
				obj+="<td>"+item.id+"</td>";
				obj+="<td>"+item.name+"</td>";
				obj+="<td>"+item.salary+"</td>";
				obj+="<td>"+item.managerName+"</td>";
				obj+="</tr>";
			});
			$("#empdata").html(obj);
		},
		error:function(){
			console.log("error");
		}
	});
}