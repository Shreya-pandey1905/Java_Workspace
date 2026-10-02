$(document).ready(function(){
	getManagers();
	getEmployees();
	new DataTable('#emptable');
	$("#search").keyup(function(){
		var Search= $(this).val();
		$.ajax({
			url: 'EmpController',
			type: 'GET',
			data: {
				action: 'searchEmployees',
				name: Search
			},
			dataType: 'json',
			success: function(res){
				var obj = '';
				$.each(res, function(index, item){
					obj += "<tr>";
     				obj += "<td>" + item.id + "</td>";
					obj += "<td>" + item.name + "</td>";
					obj += "<td>" + item.salary + "</td>";
					obj += "<td>" + item.managerName + "</td>";
					obj += "</tr>";

				});
				$("#empdata").html(obj);
			},
			error: function(){
				console.log("Search error");
			}
		});

	});

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

function getManagers()
{
	$.ajax({
		url: 'EmpController',
		type: 'GET',
		data: {
			action: 'getManagers'
		},
		dataType: 'json',

		success: function(res) {

			console.log(res);

			var obj = '<option value="">Select manager</option>';

			$.each(res, function(index, item) {

				obj += '<option value="' + item.mid + '">'
					+ item.mname +
					'</option>';

			});

			$("#mid").html(obj);
		},

		error: function() {
			console.log("Error loading managers");
		}
	});
}