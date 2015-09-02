<%-- 
    Document   : Login Page
    Created on : Sep 1, 2015, 1:19:59 AM
    Author     : Mallick
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <script src="" type="text/javascript"></script>
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
            <table align="center" id="table1" cellspacing="5">
                            <tr align="center">
                                        <td> 
                                        <img src="Analytix_Inventory_Assets/lock_1.png" height="50px" width="50px">
                                        </td>
                            </tr>
                            <tr>
                                        <td>
                                            <form  id="signinform" action="" method="post">
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
                                            <input type="button" value="Login" class="btn">
                                            </form>
                                        <td>
                            </tr>                  
            </table>   
        </div>
    </body>
</html>
