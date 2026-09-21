<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<body>
<h2>Hello World!</h2>

<form action="emp?action=add" method="post">
<input type ="text" name="eName" > Enter name
<br>
<input type ="number" name="esal" > Enter salary
<br>
<input type ="number" name="mid" > Enter manager ID
<br>
<button type="submit">Add Employee</button>
</form>


<h2>Employee List</h2>

<table>
<tr>
<th>Name</th>
<th>Salary</th>
<th>Manager ID</th>
</tr>



<c:forEach var="employee" items="${emps}" >

<tr>
<td>${employee.ename}</td>
<td>${employee.esal}</td>
<td>${employee.mid}</td>
</tr>

</c:forEach>

</table>
</body>
</html>
