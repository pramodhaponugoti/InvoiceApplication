
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
        <f:form role="form" action="addProjectPerson" method="POST" commandName="projectPersonCommand">
            <div class="col-lg-4">
            	<div class="form-group">
                    <label >Project Number</label>
                    <div class="input-group">
                        <f:input  class="form-control" path="projectNumber"  placeholder="Enter Number" required="true"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        <f:errors path="projectNumber" ></f:errors>
                    </div>
                </div>
            	
                <div class="form-group">
                    <label >Person Name </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="personName" placeholder="Enter Name" required="true"/>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                
                                 
              <input type="submit" name="submit" id="submit" value="AddProjectPerson" size="5" class="btn btn-primary ">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
            </div>
        </f:form>
        
    </div>
</div>
<!-- Registration form - END -->


</body>
</html>