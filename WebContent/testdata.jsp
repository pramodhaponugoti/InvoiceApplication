 <%@ include file="mainpage.jsp" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- Page Content -->

    <div class="container">

        <div class="row">
        <div class="col-lg-14 text-center">
        <strong class="btn btn-warning">JUnit Test Cases Result from the given TestInvoice.</strong>
        </div>              
        </div>
           
        <div class="table table-striped">
       
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">
        <th>CLIENT ID</th>
        <th>PROJECT NAME</th>
        <th>NUMBER OF EMPS</th>
        <th>NUMBER OF HOURS</th>
        <th>PROJECT BUDGET</th>
        <th>START DATE</th>
        <th>END DATE</th>       
        <th>PROJECT STATUS</th>
        </tr>
        </thead>
       
        <c:forEach items="${testDataList}" var="testData">
        <tr class="bg-primary">
        <td>${testData.clientID}</td>
        <td>${testData.projectName}</td>
        <td>${testData.noOfEmps}</td>
        <td>${testData.noOfHours}</td>
         <td>${testData.projectBudget}</td>
        <td>${testData.startDate}</td>
        <td>${testData.endDate}</td>       
        <td>${testData.projectStatus}</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    