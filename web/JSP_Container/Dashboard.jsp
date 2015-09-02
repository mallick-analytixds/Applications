<%-- 
    Document    : Dashboard
    Created on  : Sep 1, 2015, 3:51:53 AM
    Author         : Mallick
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
            <head>
                    <link rel="stylesheet" href="../Analytix_Inventory_Assets/dashboard.css"  type="text/css"/>   
                    <script type="text/javascript" src="../Analytix_Inventory_Assets/Common_Analytix_Inventory_Assets.js"></script>              
            </head>
            <body>  
                    <div class="fixed_header">                    
                    </div>       
                   <div id="left_sidebar">
                            <div id="main_menu_container">
                                <div id="hide_button"  onclick="menuHide()">
                                    <img src="../Analytix_Inventory_Assets/hide.png"  height="20px" width="20px" />               
                                </div>
                                <input class="menu_button" type="button" value="Add Catagory" style="margin-top:10px;"onclick="contentLoader('Catagory.jsp','crud_Area');contentLoader('../CatagoryList','display_Area')"/>
                                <input class="menu_button" type="button" value="Add Product" onclick="contentLoader('Add_Product.jsp','crud_Area')"/>
                                <input class="menu_button" type="button" value="Billing" onclick="contentLoader('Billing.jsp','crud_Area')"/>
                                <input class="menu_button" type="button" value="Stock Details" onclick="contentLoader('AddCatagory')"/>
                                <input class="menu_button" type="button" value="Sale Details" onclick="contentLoader('AddCatagory')"/>
                                <input class="menu_button" type="button" value="Logout" onclick="contentLoader('AddCatagory')"/>                                
                            </div> 
                   </div>    
                <div id="body_content_container">
                    <div id="crud_Area">
                        
                    </div>    
                 
                    <div id="display_Area" style="overflow: auto;">
                     
                    </div>
                    
                </div>
                
            </body>
</html>
