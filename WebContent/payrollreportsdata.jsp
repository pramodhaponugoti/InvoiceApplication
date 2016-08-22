 <%@ include file="mainpage.jsp" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- Page Content -->

    <div class="container">

        <div class="row">
        <div class="col-lg-12 text-center">
        <strong>${payrollMsg}</strong>
        </div>              
        </div>
           
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">        
        <th>Employee Name</th>
        <th>Project Number</th>        
        <th>Project Name</th>
        <th>Bill Rate</th>
        <th>Bill Rate Per Day</th>
        <th>Bill Rate Per Week</th>
        <th>Bill Rate Per Month</th>
         </tr>
        </thead>
        <c:forEach items="${payrollDataList}" var="payroll">
        <tr class="bg-primary">
        <td>${payroll.empName}</td>
        <td>${payroll.projectNumber}</td>
        <td>${payroll.projectName}</td>
        <td>${payroll.billRate}</td>
        <td>$${payroll.billRatePerDay}.00</td>
        <td>$${payroll.billRatePerWeek}.00</td>
        <td>$${payroll.billRatePerMonth}.00</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->
        
        
    </div>
    <!-- /.container -->
    </body>
    </html>
    
    