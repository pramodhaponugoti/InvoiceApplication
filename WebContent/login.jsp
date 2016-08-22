<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>



<!DOCTYPE html>
<html >
  <head>
 
    <meta charset="UTF-8">
    <title>Login Form</title>
    
    
    <style type="text/css">
    <%@ include file="css/loginstyle.css" %>
    </style>
       

    
    
    
  </head>

  <body>

    <div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">Eagle  Log in</h2>

  <f:form class="login-container" action="login" commandName="loginCommand" method="POST">
    <p><f:input path="userName" placeholder="Username"/><strong><f:errors path="userName"></f:errors></strong></p> 
    <p><f:password path="password" placeholder="Password"/><strong><f:errors path="password"></f:errors></strong></p>
    <p><input type="submit" value="Log in"></p>
  </f:form>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    
    
    
    
  </body>
</html>
