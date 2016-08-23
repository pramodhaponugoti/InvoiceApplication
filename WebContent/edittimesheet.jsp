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
        <f:form role="form" action="saveOrUpdateTimeSheet" method="POST" commandName="timeSheetCommand">
            <div class="col-lg-4">
               
               <div class="form-group">
                    <label >Person Id </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="personId" required="true" />
                        <span class="input-group-addon"> <span class="glyphicon glyphicon-asterisk"></span> </span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Person Name </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="personName" readonly="true" />
                        <span class="input-group-addon"> <span class="glyphicon glyphicon-asterisk"></span> </span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Number Of Hours</label>
                    <div class="input-group">
                        <f:input path="numberOfHours"  class="form-control" placeholder="Enter Hours" ></f:input>
                        <span class="input-group-addon"></span>
                    </div>
                </div>                
                
                 <div class="form-group">
                    <label >Project </label>
                    <div class="input-group">
                      <f:select   class="form-control"  path="projectData"  items="${projectDataList}"  />
                        <span class="input-group-addon"> <span class="glyphicon glyphicon-asterisk"></span> </span>
                    </div>
                </div>        
                
                <div class="form-group">
                    <label >Date  </label>
                    <div class="input-group">
                        <f:select   class="form-control"  path="loginDate"  items="${dateList}" />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
               
                 
              <input type="submit" name="submit" id="submit" value="Update" size="5" class="btn btn-primary">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
              
            </div>
        </f:form>
        
    </div>
</div>
<!-- Registration form - END -->


</body>
</html>