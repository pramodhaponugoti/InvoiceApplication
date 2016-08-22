 <%@ include file="mainpage.jsp" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- Page Content -->

    <div class="container">

        
        <!-- /.row -->
        
        <div class="row">
        <div class="col-lg-12 text-center">
        <strong>${projectMsg}</strong>
        </div>              
        </div>
        
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">        
        <th>Project Number</th>        
        <th>Project Name</th>
        <th>Number Of Emps</th>
        <th>Number of Clients</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Budget</th>
         </tr>
        </thead>
        <c:forEach items="${projectDataList}" var="project">
        <tr class="bg-primary">
        <td>${project.projectNumber}</td>
        <td>${project.projectName}</td>
        <td>${project.noOfEmps}</td>
        <td>${project.noOfClients}</td>
        <td>${project.startDate}</td>
        <td>${project.endDate}</td>
        <td>$${project.budget}.00</td>
         </tr>
        </c:forEach>
        </table>
        </div>
        
        

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    