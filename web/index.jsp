<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 15 Aug, 2015, 2:21:25 PM
    Author     : Chanky-JVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <s:head></s:head>
    <body>
        <s:form action="getEmployee"> 
            <s:textfield name="ename" label="EmployeeName"/>
            <s:textfield name="salary" label="Salary"/>
            <s:submit value="Submit"/>       
        </s:form>
    
    </body>
</html>
