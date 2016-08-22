<%@ include file="mainpage.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html>
<html>

<body>



<!-- Registration form - START -->
<div class="container">
    <div class="row">
        <f:form role="form" action="addClient" method="POST" commandName="clientCommand">
            <div class="col-lg-4">
                <div class="form-group">
                    <label >Client Number</label>
                    <div class="input-group">
                        <f:input  class="form-control" path="clientNumber"  placeholder="Enter Number" required="true"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        <f:errors path="clientNumber" ></f:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label >Name </label>
                    <div class="input-group">
                        <f:input  class="form-control" path="name" placeholder="Enter Name" />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >Address Line1</label>
                    <div class="input-group">
                        <f:textarea path="addressLine1"  class="form-control" rows="2" ></f:textarea>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >Address Line2</label>
                    <div class="input-group">
                        <f:textarea path="addressLine2"  class="form-control" rows="2" ></f:textarea>
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
                
                <div class="form-group">
                    <label >Email </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="email" placeholder="Enter Email"  />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                 <div class="form-group">
                    <label >Contact </label>
                    <div class="input-group">
                        <f:input   class="form-control"  path="contact" placeholder="Enter Contact"  />
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Invoice Freq </label>
                    <div class="input-group">
                        <f:select   class="form-control"  path="invoiceFreq" placeholder="Enter Invoice Freq"  >
                        <f:option value="Weekly">Weekly</f:option>
                        <f:option value="BiWeekly">BiWeekly</f:option>
                        <f:option value="Monthly">Monthly</f:option>
                        <f:option value="Monthly-Cal">Monthly-Cal</f:option>
                        </f:select>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Billing Terms </label>
                    <div class="input-group">
                        <f:select   class="form-control"  path="billingTerms" placeholder="Billing Terms"  >
                        <f:option value="Due on Recipt">Due on Recipt</f:option>
                        <f:option value="Net 10 Days">Net 10 Days</f:option>
                        <f:option value="Net 20 Days">Net 20 Days</f:option>
                        <f:option value="Net 30 Days-Cal">Net 30 Days</f:option>
                        <f:option value="Net 60 Days-Cal">Net 60 Days</f:option>
                        </f:select>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label >Invoice Grouping </label>
                    <div class="input-group">
                        <f:select   class="form-control"  path="invoiceGrouping" placeholder="Enter Invoice Grouping"  >
                        <f:option value="Project">Project</f:option>
                        <f:option value="Invoice">Invoice</f:option>
                        </f:select>
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                
               
                
              <input type="submit" name="submit" id="submit" value="AddClient" size="5" class="btn btn-primary ">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
            </div>
        </f:form>
        
    </div>
</div>
<!-- Registration form - END -->


</body>
</html>