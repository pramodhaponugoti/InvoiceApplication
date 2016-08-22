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
        <th>Client Number</th>
        <th>Name</th>
        <th>Address Line1</th>
        <th>Address Line2</th>
        <th>City</th>
        <th>State</th>
        <th>Zip</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Invoice FRQ</th>
        <th>Billing Terms</th>
        <th>Invoice Grouping</th>
        <th>Is Active</th>
        </tr>
        </thead>
        <c:forEach items="${clientDataList}" var="client">
        <tr class="bg-primary">
        <td>${client.clientNumber}</td>
        <td>${client.name}</td>
        <td>${client.addressLine1}</td>
        <td>${client.addressLine2}</td>
        <td>${client.city}</td>
        <td>${client.state}</td>
        <td>${client.zip}</td>
        <td>${client.email}</td>
        <td>${client.contact}</td>
        <td>${client.invoiceFreq}</td>
        <td>${client.billingTerms}</td>
        <td>${client.invoiceGrouping}</td>
        <td>${client.isActive}</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    