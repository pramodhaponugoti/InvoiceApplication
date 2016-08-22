<%@ include file="mainpage.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html>
<html>

<body>



<!-- Registration form - START -->
<div class="container">

<div class="row">
			<div class="col-lg-14 text-center">
				<strong><span class="bg-warning"> ${resultMsg} </span> </strong>
			</div>
</div>
		
    <div class="row">
        <f:form  id="invoiceId" action="sendEmail" method="POST" commandName="invoiceCommand">
              <div class="col-lg-4">
                
                <div class="form-group">
                    <label >Email Id :</label>
                    <div class="input-group">
                        <f:input  class="form-control" path="emailId"  placeholder="Enter Email Id" required="true"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <div class="form-group">
                <div class="input-group">               
               <label class="custom-file"> <input type="file"  id="fileUpload"  size="30"
					class="btn btn-primary" name="filePath" required> <span
					class="custom-file-control"></span>
				</label>
				</div>
				</div>
				
              <input type="submit" name="submit" id="submit" value="Send Invoice" size="5" class="btn btn-primary ">
              <input type="reset" value="Reset" class="btn btn-primary pull-right"> 
            	
            </div>
        </f:form>
        </div>
        
    </div>

<!-- Registration form - END -->


</body>
</html>