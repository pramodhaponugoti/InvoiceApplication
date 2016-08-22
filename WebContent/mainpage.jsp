<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Invoice Project</title>
   
  <style type="text/css">
    <%@ include file="css/bootstrap.min.css" %>
  </style>
     
  <script type="text/javascript" >
  <%@ include file="js/jquery.min.js" %>
  </script>
  
  <script type="text/javascript" >
  <%@ include file="js/bootstrap.min.js" %>
  </script>
     

    <!-- Custom CSS -->
    <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                <li>
				
    <a class="navbar-brand" id="menu1" data-toggle="dropdown">Import 
    <span class="caret"></span></a>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1" >
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./importClientData">Client Data</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./importCompanyData">Company Data</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./importEmployeeData">Employee Data</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./importProjectData">Project Data</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./importProjectPersonData">Project Person Data</a></li>
      
    </ul>
  
  </li>
  					<li>
                        <a class="navbar-brand" href="./clientList">Client</a>
                    </li>
                    
                    <li>
                        <a class="navbar-brand" href="./companyList">Company</a>
                    </li>
                    
                    <li>
                        <a class="navbar-brand" href="./employeeList">Employee</a>
                    </li>
                    
                    <li>
                        <a class="navbar-brand" href="./projectList">Project</a>
                    </li>
                    
                    <li>
                        <a class="navbar-brand" href="./projectPersonList">Project Person</a>
                    </li>
                    
                    <li>
                        <a class="navbar-brand" href="./testData"> Test </a>
                    </li>
                    
                    <li>
                        <a class="navbar-brand" href="./generateInvoice">Generate Invoices </a>
                    </li>
                    
                    <li>
				
    <a class="navbar-brand" id="menu1" data-toggle="dropdown">Reports 
    <span class="caret"></span></a>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1" >
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./invoiceReports">Invoice Reports</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./payrollReports">Payroll Reports</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="./projectReports">Project Reports</a></li>
      
    </ul>
  
  </li>
                    
                    <li>
                        <a class="navbar-brand" href="./logout">Logout</a>
                    </li>
                   
                    
                </ul>
            </div>
				
        </div>
    </nav>


</body>

</html>
