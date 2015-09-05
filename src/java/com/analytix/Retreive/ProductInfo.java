package com.analytix.Retreive;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
@WebServlet(urlPatterns = {"/ProductInfo"})
public class ProductInfo extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
                                               
                        try{
                            PrintWriter out = response.getWriter();
                            
                            String type=request.getParameter("type");
                            String productName = request.getParameter("productName");
                            Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();   
                            PreparedStatement pst =  connection.prepareStatement("select product_price,product_quantity from tbl_stock where product_name=? ");                          
                            pst.setString(1, productName);
                            ResultSet rs = pst.executeQuery();           
                           
                            while(rs.next())
                            {
                                if(type.equalsIgnoreCase("qnt"))
                                {
                                out.println( "<select onChange='ItemTotalCalculation(this.value)' id='itemquantity' class=\"textBox\" style=\"width:100px !important;\">\n"+
                                                   "<option>0</option>");
                                                                       
                                                       
                                for (int i = 1; i <= Integer.parseInt(rs.getString(2)); i++) 
                                {
                               out.println("<option>"+i+"</option>");
                                }
                               out.println(" </select>");
                                }
                                else
                                {                                                    
                                out.println("<input type=\"text\" readonly=\"\" id='pricePerItem' value='"+rs.getInt(1)+"' class=\"textBox\"/> \n" );
                                }
                                                       

                            }                           
                         }
                            catch(Exception e)                             
                            {
                                e.printStackTrace();
                            } 

               }
    
    
    }
