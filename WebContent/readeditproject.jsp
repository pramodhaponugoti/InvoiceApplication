<%@ include file="mainpage.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html>
<html>

<body>



<!-- Registration form - START -->
<div class="container">
    <div class="row">
        <f:form role="form" action="updateProject" method="POST" commandName="projectCommand">
            <div class="col-lg-4">
            	<div class="form-group">
                    <label >Project Number</label>
                    <div class="input-group">
                        <f:input  class="form-control" path="projectNumber"  placeholder="Enter Number" readonly="true"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        <f:errors path="projectNumber" ></f:errors>
                    </div>
                </div>
            	
                <div class="form-group">
                    <label >Client Number</label>
                    <div class="input-group">
                        <f:input  class="form-control" path="clientNumber"  placeholder="Enter Number" readonly="true"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >Project Name </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="projectName" placeholder="Enter Name" readonly="true"/>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >Start Date</label>
                    <div class="input-group">
                        <f:input path="startDate"  class="form-control" placeholder="Enter Start Date" readonly="true"/>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >End Date</label>
                    <div class="input-group">
                        <f:input path="endDate"  class="form-control"  placeholder="Enter End Date" readonly="true"/>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >Status </label>
                    <div class="input-group">
                        <f:select   class="form-control"  path="status"  disabled="true">
                        <f:option value="Closed">Closed</f:option>
                        <f:option value="In Progress">In Progress</f:option>
                        </f:select>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Project Manager </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="projectManager" placeholder="Enter Project Manager"  readonly="true"/>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Client Contact </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="clientContact" placeholder="Enter Client Contact"  readonly="true"/>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Budget </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="budget" placeholder="Enter Budget"  readonly="true"/>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                                 
              <input type="submit" name="submit" id="submit" value="UpdateProject" size="5" class="btn btn-primary ">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
            </div>
        </f:form>
        
    </div>
</div>
<!-- Registration form - END -->


</body>
</html>