$(document).ready(function(){
	getEmployees();
	new DataTable('#emptable');

	$('#modalBtn').click(function (){
		$('#addEmployeeModal').modal('show')
		$.ajax({
			url:'EmpController',
			type:'GET',
			data:{
				action:'getManagers'
			},
			dataType:'json',
			success:function (res){
				var drop= $("#mid")
				// $.each(res, function (index, item){
				// 	drop += '<option value="' + item.mid + '">'
				// 		+ item.mname +
				// 		'</option>';
				// });

				$.each(res,function (index,item){
					var select = document.createElement("option");
					select.text= item.mname;
					select.value= item.mid;
					drop.append(select)
				})


			},
			error:function (){
				console.log("error in fetching manager");
			}

		})
	})

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

	$("#addEmployeeForm").submit(function(event){
		event.preventDefault();

		var name = $("#name").val();
		var salary = $("#salary").val();
		var mid = $("#mid").val();

		$.ajax({
			url: 'EmpController',
			type: 'POST',
			data: {
				action: 'addEmployee',
				name: name,
				salary: salary,
				mid: mid
			},
			dataType: 'json',

			success: function(res){

				if(res.success){
					alert(res.message);

					$("#addEmployeeForm")[0].reset();

					$("#addEmployeeModal").modal('hide');

					getEmployees();
				}
				else{
					alert(res.message);
				}
			},

			error: function(){
				console.log("Error while adding employee");
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

// function getManagers()
// {
// 	$.ajax({
// 		url: 'EmpController',
// 		type: 'GET',
// 		data: {
// 			action: 'getManagers'
// 		},
// 		dataType: 'json',
//
// 		success: function(res) {
//
// 			console.log(res);
//
// 			var obj = '<option value="">Select manager</option>';
//
// 			$.each(res, function(index, item) {
//
// 				obj += '<option value="' + item.mid + '">'
// 					+ item.mname +
// 					'</option>';
//
// 			});
//
// 			$("#mid").html(obj);
// 		},
//
// 		error: function() {
// 			console.log("Error loading managers");
// 		}
// 	});
// }