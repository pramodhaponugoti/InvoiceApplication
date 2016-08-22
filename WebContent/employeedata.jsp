 <%@ include file="mainpage.jsp" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- Page Content -->

    <div class="container">

        <div class="row">
        <div class="col-lg-12 text-center">
        <strong>${result}</strong>
        </div>              
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
        </tr>
        </thead>
        <c:forEach items="${employeeDataList}" var="employee">
        <tr class="bg-primary">
        <td>${employee.name}</td>
        <td>${employee.title}</td>
        <td>${employee.billRate}</td>
        <td>${employee.role}</td>
         <td>${employee.isActive}</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    