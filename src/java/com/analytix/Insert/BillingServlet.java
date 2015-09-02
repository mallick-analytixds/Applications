package com.analytix.Insert;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Analytix.Beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
/**
  @author Chanky-JVM                                
 */
@WebServlet(urlPatterns = {"/BillingServlet"})
public class BillingServlet extends HttpServlet 
{
   Connection connection;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
     int NoOfParameters =  Integer.parseInt(request.getParameter("no_of_items"));     
     int GrossTotal =  Integer.parseInt(request.getParameter("GrossTotal"));     
     int AllTotalItem = Integer.parseInt(request.getParameter("AllTotalItem")); 
     String Customer_name = request.getParameter("customer_name");
     String PreparedBy = "Admin";
  
     
     try{
                    connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();
                    connection.setAutoCommit(false);
                    connection.setSavepoint();
                    int BILL_ID_NO=0;
                    PreparedStatement MAIN_BILL_ENTRY = connection.prepareStatement("INSERT INTO TBL_MAIN_BILL (CUSTOMER_NAME,TOTAL_ITEMS,TOTAL_AMOUNT_PAID,PREPARED_BY) VALUES (?,?,?,?)");
                    
                    MAIN_BILL_ENTRY.setString(1, Customer_name);
                    MAIN_BILL_ENTRY.setInt(2, AllTotalItem);
                    MAIN_BILL_ENTRY.setInt(3, GrossTotal);  
                    MAIN_BILL_ENTRY.setString(4, PreparedBy);
                    int success_MAIN_BILL_ENTRY= MAIN_BILL_ENTRY.executeUpdate();    
                    
                    ResultSet BILL_ID = connection.prepareStatement("SELECT MAX(BILL_ID) FROM TBL_MAIN_BILL").executeQuery();
                    if(BILL_ID.next()){BILL_ID_NO = BILL_ID.getInt(1);}
                    PreparedStatement CART_TABLE_ENTRY = connection.prepareStatement("INSERT INTO TBL_CART_ITEMS (BILL_ID,PRODUCT_NAME,QUANTITY,TOTAL_PRODUCT_AMOUNT) VALUES (?,?,?,?)");                          
                    PreparedStatement STOCK_DEDUCTION = connection.prepareStatement("update tbl_stock set PRODUCT_QUANTITY=((select PRODUCT_QUANTITY from TBL_STOCK where PRODUCT_NAME=?)- ?) where PRODUCT_NAME=?");      
                    
                    for(int i=0;i<15;i++)
                    {
                                if(request.getParameter("product_name"+String.valueOf(i))!=null)
                                {
                                STOCK_DEDUCTION.setObject(1,request.getParameter("product_name"+String.valueOf(i)));
                                STOCK_DEDUCTION.setObject(2, request.getParameter("itemquantity"+String.valueOf(i)));
                                STOCK_DEDUCTION.setObject(3,request.getParameter("product_name"+String.valueOf(i)));
                                STOCK_DEDUCTION.addBatch();
                                
                                
                                CART_TABLE_ENTRY.setObject(1, BILL_ID_NO);
                                CART_TABLE_ENTRY.setObject(2, request.getParameter("product_name"+String.valueOf(i)));
                                CART_TABLE_ENTRY.setObject(3, request.getParameter("itemquantity"+String.valueOf(i)));
                                CART_TABLE_ENTRY.setObject(4, request.getParameter("totalItemAmount"+String.valueOf(i)));
                                CART_TABLE_ENTRY.addBatch();
                                }
                                
                    }

      
                    
                    int succes_STOCK_DEDUCTION[]= STOCK_DEDUCTION.executeBatch(); 
                    int succes_CART_TABLE_ENTRY[]= CART_TABLE_ENTRY.executeBatch();    
                    
                    System.out.println("Main Bill Entry : - "+success_MAIN_BILL_ENTRY);
                    System.out.println("succes_STOCK_DEDUCTION :-"+succes_STOCK_DEDUCTION.length);                    
                    System.out.println("succes_CART_TABLE_ENTRY :- "+succes_CART_TABLE_ENTRY.length);
                    
                    if(success_MAIN_BILL_ENTRY>0 && succes_STOCK_DEDUCTION.length == NoOfParameters && succes_CART_TABLE_ENTRY.length == NoOfParameters)
                    {
                    connection.commit();
                    response.sendRedirect("JSP_Container/Dashboard.jsp?Bill="+BILL_ID_NO);                  
                    }
                    
            }
     catch(Exception e)
            {
                        try 
                        {                          
                           connection.rollback();
                         } catch (Exception f) 
                         {
                         }
                        
                        e.printStackTrace();
            }
            finally
            {
                try 
                {
                      connection.setAutoCommit(true);
                } catch (Exception e) {
                }
                  
            }
     
        
    }

    

}
