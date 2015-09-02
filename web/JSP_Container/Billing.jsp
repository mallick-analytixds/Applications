<%-- 
    Document   : Billing
    Created on : Sep 2, 2015, 1:44:06 PM
    Author     : Mallick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>        
                   <link rel="stylesheet" href="../Analytix_Inventory_Assets/common.css"  type="text/css"/>   
                    <script type="text/javascript" src="../Analytix_Inventory_Assets/Common_Analytix_Inventory_Assets.js"></script>   
    </head>
    <body>
    <jsp:useBean class= "com.analytix.Beans.ProductDropdownBean" id="selectlist">                           
    </jsp:useBean>  
        <div id="add_catagory_Heading">            
            &nbsp;Billing System
        </div>
        <hr style="width:100%;">
        <table align="left" style="width: 40%" cellspacing="20">
            <tr>
                <td colspan="2" align="center" style="height: 60px;background-color: #a9e4f7; color: navy; border-radius: 5px;">ITEM SELECTION</td>
                
            </tr>
            <tr>
                <td>Select Item </td>      
                <td align="right">
                    <select class="textBox" id="product_name" onchange="contentLoader('../ProductInfo?type=qnt&productName='+this.value,'product_Information_quantity');contentLoader('../ProductInfo?type=price&productName='+this.value,'product_Information_price'); makeNull(); ">
                                <option></option>     
                                <c:forEach items="${selectlist.productNameList}" var="menuitem">
                                        <option>${menuitem}</option>    
                                </c:forEach>
                        </select>
                </td>        
            </tr> 
           
               <tr>
                <td>Quantity</td>      
                <td align="right">
                    <div id="product_Information_quantity">
                        
                    </div>
                </td>        
            </tr> 
            <tr>
             <td>Price/Item</td>      
                <td align="right">
                    <div id="product_Information_price">
                        
                    </div>
                </td>        
            </tr> 
             <tr> 
             <td>Total Item Amount</td>      
                <td align="right">
                    <input type="text" id="totalItemAmount" class="textBox"> 
                </td>        
            </tr> 
            <tr align="right">
                <td colspan="2" ><br><br><input type="button" value="Add to Cart" class="button" onclick="cart_Item_List_Generator()" /></td>
            </tr>
        </table>
        
        <!-- ------------------------------------------------------------------------------------------------------------------------------- -->
        <div id="Cart_Item_Container">
            <div id="Cart_Item_Container_header">
                <center>CART ITEMS<center>
            </div>
            <form action="../BillingServlet" method="get">
            <input type="hidden" name="no_of_items" value="0" id="no_of_items"/>
            <br>
            <table align="left" style="width: 100%" >        
                <tr>
                    <td >Customer Name</td>
                    <td align="right"><input type="text" name="customer_name" class="textBox"/></td>
                </tr>  
            </table>
            <br><br>
            <table align="left" style="width: 100%" >  
                <tr style="background-color: #e55b2b; ">
                    <td style="width: 271px; color: #ffffff !important;" align="center">Item Name</td>
                    <td style="width: 105px; color: #ffffff !important;" align="center">Quantity</td>
                    <td style="width: 101px; color: #ffffff !important;" align="center">Price</td>
                    <td style="width: 105px; color: #ffffff !important;" align="center">Total</td>
                    <td style="width: 40px; color: #ffffff !important;" align="center">Remove</td> 
                </tr>
            </table>  
            <div id="ALL_CART_ITEM">
            
            </div> 
            <br><br>
            
            <input type="text" name="GrossTotal" id="GrossTotal" value="0" class="menu_textbox" style="float: right; margin-right: 50px;"/>
            <input type="text" name="AllTotalItem" id="AllTotalItem" value="0" class="menu_textbox" style="float: right;margin-right: 110px;"/>
            <br><br>
            <input type="submit" value="Generate Bill" class="button"/>
            </form>
        </div>
    </body>
</html>