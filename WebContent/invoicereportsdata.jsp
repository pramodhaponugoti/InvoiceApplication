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
        <th>Project Name</th>
        <th>Payment Terms</th>
        <th>Billing Frequency</th>
        <th>Employee Name</th>
        <th>Number Of Hours</th>
        <th>BillRate</th>
        <th>Amount</th>
        
        </tr>
        </thead>
        <c:forEach items="${clientDataList}" var="client">
        <tr class="bg-primary">
        <td>${client.clientNumber}</td>
        <td>${client.project}</td>
        <td>${client.paymentTerms}</td>
        <td>${client.billingFreq}</td>
        <td>${client.empName}</td>
        <td>${client.noOfHours}</td>
        <td>${client.billRate}</td>
        <td>${client.amountPaid}</td>     
        
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->
        
                
        

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    