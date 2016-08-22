 <%@ include file="mainpage.jsp" %>
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
        <li><a href="./addCompanyForm" class="btn btn-primary">AddCompany</a></li>
        </ul>
        </div>        
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">
        <th>Name</th>
        <th>Address Line1</th>
        <th>Address Line2</th>
        <th>City</th>
        <th>State</th>
        <th>Zip</th>
        <th>Is Active</th>
        <th>Edit</th>
        <th>Action</th>
         </tr>
        </thead>
        <c:forEach items="${companyDataList}" var="company">
        <tr class="bg-primary">
        <td>${company.name}</td>
        <td>${company.addressLine1}</td>
        <td>${company.addressLine2}</td>
        <td>${company.city}</td>
        <td>${company.state}</td>
        <td>${company.zip}</td>
        <td>${company.isActive}</td>
        <td><a href="./editCompany?name=${company.name}" class="btn btn-success">Edit</a></td>
        <td><a href="./inactiveCompany?name=${company.name}" class="btn btn-warning">InActive</a> </td>   
        
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    