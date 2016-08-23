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
        <th>Number Of Hours</th>
        <th>Bill Rate</th>
        <th>Amount Paid</th>      
         </tr>
        </thead>
        <c:forEach items="${payrollDataList}" var="payroll">
        <tr class="bg-primary">
        <td>${payroll.empName}</td>
        <td>${payroll.projectNumber}</td>
        <td>${payroll.projectName}</td>
        <td>${payroll.noOfHours}</td>
        <td>${payroll.billRate}</td>
         <td>$${payroll.amountPaid}.00</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->
        
        
    </div>
    <!-- /.container -->
    </body>
    </html>
    
    