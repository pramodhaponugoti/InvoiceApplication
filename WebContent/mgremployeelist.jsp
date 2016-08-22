 <%@ include file="mgrmainpage.jsp" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- Page Content -->

    <div class="container">

		<div class="row">
        <div class="col-lg-12 text-center">                             
                    <strong><span class="bg-warning"> ${resultMsg} </span>   </strong>                           
        </div>              
        </div>

		<div class="row">
        <div class="col-lg-12 text-center">
        <strong>${result}</strong>
        </div>              
        </div>
        <div class="row">
        <ul>
        <li><a href="./addEmployeeForm" class="btn btn-primary">AddEmployee</a></li>
        </ul>
        </div>        
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">
        <th>Name</th>
        <th>Title</th>
        <th>Bill Rate</th>
        <th>Role</th>
        <th>Is Active</th>
        <th>Edit</th>
        <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="${employeeDataList}" var="employee">
        <tr class="bg-primary">
        <td>${employee.name}</td>
        <td>${employee.title}</td>
        <td>${employee.billRate}</td>
        <td>${employee.role}</td>
        <td>${employee.isActive}</td>
        <td><a href="./editEmployee?name=${employee.name}" class="btn btn-success">Edit</a></td>
        <td><a href="./inactiveEmployee?name=${employee.name}" class="btn btn-warning">InActive</a> </td>   
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    