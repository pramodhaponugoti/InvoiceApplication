
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
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
<html>

<body>



<!-- Registration form - START -->
<div class="container">
    <div class="row">
        <f:form role="form" action="updateEmployee" method="POST" commandName="employeeCommand" readonly="${employeeCommand.isActive}">
            <div class="col-lg-4">
                
                <div class="form-group">
                    <label >Name </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="name" placeholder="Enter Name" readonly="true" />
                        <span class="input-group-addon"> <span class="glyphicon glyphicon-asterisk"></span> </span>
                         <f:errors path="name"></f:errors>
                    </div>
                </div>
                               
                <div class="form-group">
                    <label >Title </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="title" placeholder="Enter Title"  />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Bill Rate </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="billRate" placeholder="Enter Bill Rate"  />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                                 
                <div class="form-group">
                    <label >Role </label>
                    <div class="input-group">
                        <f:select   class="form-control"  path="role"  >
                        <f:option value="Developer">Developer</f:option>
                        <f:option value="Project Manager">Project Manager</f:option>
                        </f:select>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                 
                
              <input type="submit" name="submit" id="submit" value="UpdateEmployee" size="5" class="btn btn-primary">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
              
            </div>
        </f:form>
        
    </div>
</div>
<!-- Registration form - END -->


</body>
</html>