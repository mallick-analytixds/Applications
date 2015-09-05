<%-- 
    Document   : Final_Bill
    Created on : Sep 3, 2015, 10:16:02 AM
    Author     : Mallick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #bill_container
    {
        
        height:500px;
        width:500px;
      
    }
    td{
        text-align: center;
        
    }
</style>
<div id="bill_container">
        <table >
            <tr>
                <th colspan="4">*************************************************************</th>
            </tr>
            <tr>
                <th colspan="4" align="left">Analytix Inventory System<br>Bill Receipt</th>
            </tr>
            <tr>
                <th colspan="4">*************************************************************</th>
            </tr>
             <tr>
                <th align="left">Customer Name:</th><th align="left">${Bill_Detail.get('CUSTOMER_NAME')}</th>
                <th align="left">Date:</th><th align="left">${Bill_Detail.get('BILL_DATE')}</th>
            </tr>
            <tr>
                <th align="left">Bill No :</th><th align="left">${Bill_Detail.get('BILL_ID')}</th>
            </tr>
              <th colspan="4">*************************************************************</th>
            <tr>
                
                        <th>Name of Product</th>
                        <th>Quantity</th>
                        <th>Price/Item</th>     
                        <th>Total Amount</th>   
            </tr>
             <th colspan="4">-------------------------------------------------------------------------------------------</th>
                <c:forEach items="${Cart_List}" var="itemObject">
                    <tr>
                        <td>${itemObject.getProductName()}</td>
                        <td>${itemObject.getQuantiy()}</td>
                        <td>0</td>     
                        <td>${itemObject.getAmount()}</td>   
                    </tr>
                </c:forEach>
                 <tr>
                <th colspan="4">-------------------------------------------------------------------------------------------</th>
            </tr>
             <tr>
                        <th align="left">Total : </th>
                        <th>${Bill_Detail.get('TOTAL_ITEMS')}</th>
                        <th>Gross Total</th>     
                        <th>${Bill_Detail.get('TOTAL_AMOUNT_PAID')}</th>   
            </tr>
            <tr>
                <th align="right" colspan="4">Prepared By : ${Bill_Detail.get('PREPARED_BY')}</th>
            </tr>
            <tr>
                <th align="center" colspan="4"><input type="button" value="Print" onClick="printPage()"</th>
            </tr>
        </table>
</div>
            <script type="text/javascript">
                function printPage()
                {
                    
                    window.print();
                }
            </script>




<!DOCTYPE html>
