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
        <th>Project Number</th>
        <th>Person Name</th>
        <th>Is Active</th>
        </tr>
        </thead>
        <c:forEach items="${projectPersonDataList}" var="projectPerson">
        <tr class="bg-primary">
        <td>${projectPerson.projectNumber}</td>
        <td>${projectPerson.personName}</td>
        <td>${projectPerson.isActive}</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    