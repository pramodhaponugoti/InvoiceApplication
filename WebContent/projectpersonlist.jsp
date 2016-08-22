
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test = "${role == 'Developer'}">
 <%@ include file="empmainpage.jsp" %>
 </c:if>
 
 <c:if test = "${role == 'Project Manager'}">
 <%@ include file="mgrmainpage.jsp" %>
 </c:if>
 
 <c:if test = "${role == 'Accountant'}">
 <%@ include file="mainpage.jsp" %>
 </c:if>
 
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
        <ul>
        <li><a href="./addProjectPersonForm?action=true" class="btn btn-primary">AddProjectPerson</a></li>
        </ul>
        </div>   
           
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">
        <th>Project Number</th>
        <th>Person Name</th>
        <th>Is Active</th>
        <th>Edit</th>
        <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="${projectPersonDataList}" var="projectPerson">
        <tr class="bg-primary">
        <td>${projectPerson.projectNumber}</td>
        <td>${projectPerson.personName}</td>
        <td>${projectPerson.isActive}</td>
        <td><a href="./editProjectPerson?projectNumber=${projectPerson.projectNumber}&&personName=${projectPerson.personName}" class="btn btn-success">Edit</a></td>
        <td><a href="./inactiveProjectPerson?projectNumber=${projectPerson.projectNumber}&&personName=${projectPerson.personName}" class="btn btn-warning">InActive</a> </td>   
        
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    