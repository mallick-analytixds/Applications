<%-- 
    Document    : Dashboard
    Created on  : Sep 1, 2015, 3:51:53 AM
    Author         : Mallick
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
            <head>
                    <link rel="stylesheet" href="../Analytix_Inventory_Assets/dashboard.css"  type="text/css"/>   
                    <script type="text/javascript" src="../Analytix_Inventory_Assets/Common_Analytix_Inventory_Assets.js"></script>              
            </head>
            <body>  
                   <div class="fixed_header">      
                        <img src="../Analytix_Inventory_Assets/cp2.png"  height="50px" width="50px" style="display:inline;"/>       
                  <img src="../Analytix_Inventory_Assets/ttt.png" style="display:inline; padding-bottom: 10px;"/>       
                    </div>       
                   <div id="left_sidebar">
                            <div id="main_menu_container" >
                                <div id="hide_button"  onclick="menuHide()">
                                    <img src="../Analytix_Inventory_Assets/hide.png"  height="20px" width="20px" />               
                                </div>                                
                                <c:choose>                                            
                                            <c:when test="${usertype!='SALES'}">
                                                            <input class="menu_button" type="button" value="Add Catagory" style="margin-top:10px;"onclick="contentLoader('Catagory.jsp','crud_Area');contentLoader('../CatagoryList','display_Area')"/>
                                                            <input class="menu_button" type="button" value="Add Product" onclick="contentLoader('Add_Product.jsp','crud_Area');document.getElementById('display_Area').innerHTML='' "/>
                                                            <input class="menu_button" type="button" value="Billing" onclick="contentLoader('Billing.jsp','crud_Area') ;document.getElementById('display_Area').innerHTML=''"/>
                                                            <input class="menu_button" type="button" value="Stock Details" onclick="contentLoader('/Analytix_Inventory_System/ReportGenerateStock','crud_Area')"/>
                                                            <input class="menu_button" type="button" value="Sale Details" onclick="contentLoader('/Analytix_Inventory_System/ReportGenerate','crud_Area')"/>
                                                            <input class="menu_button" type="button" value="Logout" onclick="window.open('../Logout','_self')"/>           
                                            </c:when>
                                            <c:otherwise>
                                                            <br><br>  
                                                            <input class="menu_button" type="button" value="Billing" onclick="contentLoader('Billing.jsp','crud_Area') ;document.getElementById('display_Area').innerHTML=''"/>
                                                            <input class="menu_button" type="button" value="Stock Details" onclick="contentLoader('')"/>
                                                            <input class="menu_button" type="button" value="Sale Details" onclick="contentLoader('')"/>
                                                            <input class="menu_button" type="button" value="Logout" onclick="window.open('../Logout','_self')"/>    
                                            </c:otherwise>
                                  </c:choose>                                                
                            </div> 
                       <img id="menu_opener" src="../Analytix_Inventory_Assets/open.png" style="margin-top: 230px; height:100px;width:100px;cursor: pointer;display:none;" title="Click To Open Control Panel" onclick="menuHide2(this)">
                       
                   </div>    
                <div id="body_content_container">
                    <div id="crud_Area">
                    </div>  
                    <div id="display_Area" style="overflow: auto;">
                    </div>
                    
                </div>
                <c:if test="${param.Bill!=null}">
                    
                    <script>
                        contentLoader('Billing.jsp','crud_Area');
                        window.open("../Bill_Print?Bill="+${param.Bill}, "Bill Printing", "width=520, height=530, top=100, left=450");
                    </script>
                </c:if>
            </body>
</html>
