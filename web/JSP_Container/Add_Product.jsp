<%-- 
    Document   : Add_Product
    Created on : Sep 2, 2015, 9:54:37 AM
    Author     : Mallick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>        
                   <link rel="stylesheet" href="../Analytix_Inventory_Assets/common.css"  type="text/css"/>   
                    <script type="text/javascript" src="../Analytix_Inventory_Assets/Common_Analytix_Inventory_Assets.js"></script>                     
    </head>
    <body>
          <jsp:useBean class= "com.analytix.Beans.CatagoryDropdownBean" id="selectlist">                           
          </jsp:useBean>  
        <div id="add_catagory_Heading">            
            &nbsp;Add Product
        </div>
        <hr style="width:100%;">
        <form>
        <table align="center" style="width: 100%"  cellspacing="10" >
            <tr>
                <td>Product ID</td>      
                <td align="right"><input type="text" name="product_id" class="textBox" readonly="true" value="Automatic" /></td>   
                <td>Product Name</td>      
                <td align="right"><input type="text" name="product_name" class="textBox" id="product_name"/></td>       
            </tr>     
               <tr>
                        <td>Choose Catagory</td>      
                        <td align="right">
                            <select class="textBox" name="product_catagory" id="product_catagory">
                                <c:forEach items="${selectlist.mylist}" var="menuitem">
                                <option>${menuitem}</option>    
                                </c:forEach>
                             </select>
                                
                        </td>        
                <td>Quantity</td>      
                <td align="right"><input type="text" name="product_quantity" class="textBox" id="product_quantity"/></td>             
            </tr>                    
            <tr>
                <td></td><td></td>     
                <td>Price / Item</td>      
                <td align="right"><input type="text" name="product_price" class="textBox" id="product_price"/></td>                        
            </tr>                    
            <tr align="right">
                <td colspan="4" >   <br><br><input type="button" onclick="ProductSave()" value="Add Product" class="button" /></td>
            </tr>
        </table>
        </form>
        <hr style="width:100%;">
    </body>
</html>
