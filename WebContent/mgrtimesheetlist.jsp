
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

		        
        <div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">
        <th>Person Id</th>
        <th>Person Name</th>
        <th>Project ID</th>
        <th>Project Name</th>
        <th>Number Of Hours</th>
        <th>Login Date</th>
        <th>Status</th>
        <th>Edit</th>
        <th>Approve</th>
        <th>DisApprove</th>
         </tr>
        </thead>
        <c:forEach items="${timeSheetDataList}" var="timeSheet">
        <tr class="bg-primary">
        <td>${timeSheet.personId}</td>
        <td>${timeSheet.personName}</td>
        <td>${timeSheet.projectNo}</td>
        <td>${timeSheet.projectName}</td>
        <c:if test = "${timeSheet.numberOfHours == 0}">
 		<td class="btn btn-danger">Hours is Empty . Please Enter Hours...!</td>
 		</c:if>
 		<c:if test = "${timeSheet.numberOfHours != 0}">
 		<td>${timeSheet.numberOfHours}</td>
 		</c:if> 
        <td>${timeSheet.loginDate}</td>
        <td>${timeSheet.status}</td>
        <td><a href="./editTimeSheetForm?personName=${timeSheet.personName}&&loginDate=${timeSheet.loginDate}" class="btn btn-success">Edit</a></td>
        <td><a href="./approveTimeSheet?personName=${timeSheet.personName}&&loginDate=${timeSheet.loginDate}" class="btn btn-warning">Approve</a></td>
        <td><a href="./disApproveTimeSheet?personName=${timeSheet.personName}&&loginDate=${timeSheet.loginDate}" class="btn btn-warning">DisApprove</a></td>
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    