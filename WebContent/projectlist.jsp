 <%@ include file="mainpage.jsp" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- Page Content -->

    <div class="container">

		<div class="row">
			<div class="col-lg-12 text-center">
				<strong><span class="bg-warning"> ${resultMsg} </span> </strong>
			</div>
		</div>

		<div class="row">
			<ul>
				<li><a href="./addProjectForm?action=true"
					class="btn btn-primary">AddProject</a></li>
			</ul>
		</div>
		
		<div class="table table-striped">
        
        <table class="table" > 
        <thead class="thead-default">
        <tr class="bg-warning">
        <th>Project Number</th>
        <th>Client Number</th>
        <th>Project Name</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Status</th>
        <th>Project Manager</th>
        <th>Client Contact</th>
        <th>Budget</th>
        <th>Is Active</th>
        <th>Edit</th>
        <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="${projectDataList}" var="project">
        <tr class="bg-primary">
        <td>${project.projectNumber}</td>
        <td>${project.clientNumber}</td>
        <td>${project.projectName}</td>
        <td>${project.startDate}</td>
        <td>${project.endDate}</td>
        <td>${project.status}</td>
        <td>${project.projectManager}</td>
        <td>${project.clientContact}</td>
        <td>${project.budget}</td>
        <td>${project.isActive}</td>
        <td><a href="./editProject?projectNumber=${project.projectNumber}" class="btn btn-success">Edit</a></td>
        <td><a href="./inactiveProject?projectNumber=${project.projectNumber}" class="btn btn-warning">InActive</a> </td>   
        </tr>
        </c:forEach>
        </table>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    