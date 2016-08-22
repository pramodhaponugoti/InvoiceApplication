 <%@ include file="mainpage.jsp" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- Page Content -->

    <div class="container">

        <div class="row">
        <div class="col-lg-12 text-center">
        <strong>${clientMsg}</strong>
        </div>              
        </div>
           
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">        
        <th>Client Number</th>
        <th>Client Name</th>
        <th>Project Number</th>        
        <th>Project Name</th>
        <th>Address Line1</th>
        <th>Address Line2</th>
        <th>City</th>
        <th>State</th>
        <th>Zip</th>
        <th>Payment Terms</th>
        <th>Billing Frequency</th>
        </tr>
        </thead>
        <c:forEach items="${clientDataList}" var="client">
        <tr class="bg-primary">
        <td>${client.clientNumber}</td>
        <td>${client.clientName}</td>
        <td>${client.projectNumber}</td>
        <td>${client.project}</td>
        <td>${client.addressLine1}</td>
        <td>${client.addressLine2}</td>
        <td>${client.city}</td>
        <td>${client.state}</td>
        <td>${client.zip}</td>
        <td>${client.paymentTerms}</td>
        <td>${client.billingFreq}</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->
        
        <div class="row">
        <div class="col-lg-12 text-center">
        <strong>${empMsg}</strong>
        </div>              
        </div>
        
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">        
        <th>Employee Name</th>
        <th>Client Number</th>
        <th>Project Number</th>        
        <th>Project Name</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Bill Rate</th>
         </tr>
        </thead>
        <c:forEach items="${employeeDataList}" var="employee">
        <tr class="bg-primary">
        <td>${employee.empName}</td>
        <td>${employee.clientNumber}</td>
        <td>${employee.projectNumber}</td>
        <td>${employee.projectName}</td>
        <td>${employee.startDate}</td>
        <td>${employee.endDate}</td>
        <td>${employee.billRate}</td>
         </tr>
        </c:forEach>
        </table>
        </div>
        
        

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    