<%@ include file="mainpage.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html>
<html>

<body>



<!-- Registration form - START -->
<div class="container">
    <div class="row">
        <f:form role="form" action="updateCompany" method="POST" commandName="companyCommand" readonly="${companyCommand.isActive}">
            <div class="col-lg-4">
               
                <div class="form-group">
                    <label >Name </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="name" placeholder="Enter Name"  readonly="true"  required="true"/>
                        <span class="input-group-addon"> <span class="glyphicon glyphicon-asterisk"></span> </span>
                        <f:errors path="name"></f:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label >Address Line1</label>
                    <div class="input-group">
                        <f:textarea path="addressLine1"  class="form-control" rows="5" ></f:textarea>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >Address Line2</label>
                    <div class="input-group">
                        <f:textarea path="addressLine2"  class="form-control" rows="5" ></f:textarea>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >City </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="city" placeholder="Enter City"  />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >State </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="state" placeholder="Enter State"  />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Zip </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="zip" placeholder="Enter Zip"  />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                
                
                 
              <input type="submit" name="submit" id="submit" value="UpdateCompany" size="5" class="btn btn-primary">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
              
            </div>
        </f:form>
        
    </div>
</div>
<!-- Registration form - END -->


</body>
</html>