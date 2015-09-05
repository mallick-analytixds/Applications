<%-- 
    Document   : Catagory
    Created on : Sep 2, 2015, 9:54:03 AM
    Author     : Mallick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
                   <link rel="stylesheet" href="../Analytix_Inventory_Assets/common.css"  type="text/css"/>   
                    <script type="text/javascript" src="../Analytix_Inventory_Assets/Common_Analytix_Inventory_Assets.js"></script>   
    </head>
    <body>
        <div id="add_catagory_Heading">            
            &nbsp;Add Catagory
        </div>
        <hr style="width:100%;">
        <form>
        <table align="center" style="width: 50%">
            <tr>
                <td>Catagory Name</td>      
                <td align="right"><input type="text" name="catagory" id="catagoryTB" class="textBox"/></td>        
            </tr>         
            <tr align="right">
                <td colspan="2" >   <br><br><input type="button" value="Add Catagory" onclick="CatagorySave()" class="button" /></td>
            </tr>
        </table>
        </form>
        <hr style="width:100%;">
    </body>
</html>
