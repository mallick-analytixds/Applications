<%-- 
    Document   : Login Page
    Created on : Sep 1, 2015, 1:19:59 AM
    Author     : Mallick
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>        
      
         <script type="text/javascript" src="Analytix_Inventory_Assets/Common_Analytix_Inventory_Assets.js"></script>  
        <link rel="stylesheet" href="Analytix_Inventory_Assets/style.css"  type="text/css"/>      
    </head>
    <body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
       
     <div id="fixed_header" style="margin: 0px auto;">
                    <center>           
                            <div id="inventoryLogo2">
                                <img src="Analytix_Inventory_Assets/logo1.png"  height="60px" width="80px" style="margin-top: 10px;"/>
                                <img src="Analytix_Inventory_Assets/namelogo2.png" height="40px" width="600px" style="margin-top: 10px;" />
                            </div> 
                      </center>
        </div>
        
        
        <div id="login_container">
            <form  id="signinform" action="Login" method="post">
            <table align="center" id="table1" cellspacing="5">
                            <tr align="center">
                                        <td> 
                                        <img src="Analytix_Inventory_Assets/lock_1.png" height="50px" width="50px">
                                        </td>
                            </tr>
                            <tr>
                                        <td>
                                           
                                            <input class="login"  type="text" placeholder="Username" id="un" autocomplete="off" name="userid"/>
                                        <td>
                            </tr>
                            <tr>
                                        <td>
                                        <input class="login" type="password" placeholder="Password" id="pas" autocomplete="off" name="password"/>
                                        <td>
                            </tr>
                             <tr>
                                        <td>
                                            <input type="button" value="Login" onclick="loginCheck()" class="btn">
                                         
                                        <td>
                            </tr>        
                                 <tr>
                                        <td align="center">
                                            <a href="#" >Admin : chanky123 123456<br>Sales : mallick 000000</a>                                         
                                        <td>
                            </tr>  
            </table>   
                </form>
        </div>
        <c:if test="${param.state=='fail'}">
               <style type="text/css">
                 .login
                 {
                   -webkit-box-shadow: 1px 2px 8px 0px rgba(240,17,17,1) !important;
                   -moz-box-shadow: 1px 2px 8px 0px rgba(240,17,17,1)  !important;
                    box-shadow: 1px 2px 8px 0px rgba(240,17,17,1) !important;
                 }               
               </style>
               <script>
               alert("Wrong UserName or Password") ; 
               </script> 
        </c:if>
    </body>
                <script>
                    function loginCheck()
                    {
                        
                        if(document.getElementById("un").value.length <3 || document.getElementById("pas").value.length <3  )
                        {
                            alert('Fill the Data Properly');                            
                        }
                        else
                        {
                            document.getElementById("signinform").submit();
                        }
                        
                    }
                </script>
</html>
