 <%@ include file="mainpage.jsp" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">    
var path = (window.URL || window.webkitURL).createObjectURL(file);
console.log('path', path);
</script>

</head>
<body>
<!-- Page Content -->
    <div class="container">

        <div class="row">
        
            <div class="col-lg-12 text-center">
            <form action="uploadData" method="POST">
            <input type="hidden" value="${processData}" name="hiddenFileName" id="importDataId" />
            <strong> ${pageInfo}</strong> 
				<label class="custom-file"> <input type="file"  id="fileUpload" size="30"
					class="btn btn-primary" name="filePath"> <span
					class="custom-file-control"></span>
				</label>
				<div class="row">
				<input type="submit" value="Submit" class="btn btn-primary"/> 
				</div>
			</form>
			</div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    </body>
    </html>
    
    