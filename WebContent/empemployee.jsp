<%@ include file="empmainpage.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html>
<html>

<body>



<!-- Registration form - START -->
<div class="container">
    <div class="row">
        <f:form role="form" action="addEmployee" method="POST" commandName="employeeCommand">
            <div class="col-lg-4">
                
                <div class="form-group">
                    <label >Name </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="name" placeholder="Enter Name" />
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
                        <f:option value="Closed">Closed</f:option>
                        <f:option value="In Progress">In Progress</f:option>
                        </f:select>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                 
                 
                
              <input type="submit" name="submit" id="submit" value="AddEmployee" size="5" class="btn btn-primary">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
              
            </div>
        </f:form>
        
    </div>
</div>
<!-- Registration form - END -->


</body>
</html>