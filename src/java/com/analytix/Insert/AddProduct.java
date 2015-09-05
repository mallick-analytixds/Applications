package com.analytix.Insert;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                     
                        try
                         {                             
                            Connection connection= com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();                                 
                            PreparedStatement pst =  connection.prepareStatement("insert into TBL_STOCK (PRODUCT_CATAGORY,PRODUCT_NAME,PRODUCT_QUANTITY,PRODUCT_PRICE) values (?,?,?,?)");     
                            pst.setString(1, request.getParameter("product_catagory"));
                            pst.setString(2, request.getParameter("product_name"));     
                            pst.setInt(3, Integer.parseInt(request.getParameter("product_quantity")));   
                            pst.setInt(4,  Integer.parseInt(request.getParameter("product_price")));   
                            int status = pst.executeUpdate();  
                            
                             if(status == 1)
                            {
                                System.out.println("------------------------------------"+status);
                                response.getWriter().println("You Added Product : "+ request.getParameter("product_name") +" With :" +request.getParameter("product_quantity")+" Quantity");
                                
                            }
                            else
                            {
                                System.out.println("-------------------------------------"+status);
                               response.getWriter().println("Failed to Add Product");
                            }
                            
                         }
                         catch(Exception e)
                         {
                             response.getWriter().println("Failed to Add Product");
                            e.printStackTrace();
                         }
                      
                       
    }

}
