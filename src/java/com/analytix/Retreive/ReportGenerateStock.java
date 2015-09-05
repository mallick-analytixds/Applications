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
@WebServlet(urlPatterns = {"/ReportGenerateStock"})
public class ReportGenerateStock extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
                                               
                        try{
                            PrintWriter out = response.getWriter();
                            String catgagory= request.getParameter("catagory");
                            Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();   
                            PreparedStatement pst;          
                            PreparedStatement pst2 = connection.prepareStatement("select distinct Product_catagory from tbl_stock order by product_catagory"); 
                            if(catgagory !=null)
                            {
                               pst = connection.prepareStatement("select *from tbl_stock  where product_catagory=? ");      
                               pst.setString(1, catgagory);               
                            }
                            else
                            {
                               pst = connection.prepareStatement("select *from tbl_stock order by product_catagory");      
                            }                    
                            ResultSet rs = pst.executeQuery();
                            ResultSet rs2 = pst2.executeQuery();
                            int TotalCount = 0;
                            int TotalItems = 0;
                            int TotalAmount = 0;
                            
                    
                           
                            out.println("<br><h2 style='display:inline;'>Select Catagory :</h2>&nbsp;&nbsp;&nbsp;<select name='catagoryselector' class='textBox' id='catagoryselector' onchange='contentLoader(\"/Analytix_Inventory_System/ReportGenerateStock?catagory=\"+this.value,\"crud_Area\")' >");;
                            while(rs2.next())
                            {
                                       
                                                      out.println("<option>"+rs2.getString(1)+"</option> ");
                            }
                            out.println("</select>");
                       
                            
                            
                            
                            
                            out.println("<table cellspacing='3' style='width:100%;' align='center'>\n" +
                                    "        <tr style='background-color:#00b6ff;color:white;height:25px;'>\n" +
                                    "              <th>Product ID</th>\n" +
                                    "              <th>Product Catagory</th>\n" +     
                                    "              <th>Product Name</th>\n" +   
                                    "              <th>Product Quantity</th>\n" +   
                                    "              <th>Price Per Item</th>\n" +   
                                     "              <th>Total Value</th>\n" +   
                                    "              <th>Date Added</th>\n" +   
                                    "        </tr>");
                            while(rs.next())
                            {
                                TotalCount++;
                                TotalItems+=rs.getInt(4);
                                TotalAmount+=Integer.parseInt(rs.getString(5)) * Integer.parseInt(rs.getString(4));
                                out.println("<tr style='background-color:#fcf6d6;color:#772d00 ;height:25px;font-size:14px; font-weight:bold;cursor:pointer;'>");
                                out.println("<th align='center'>"+rs.getString(1)+"</td>"+
                                                  "<th align='center'>"+rs.getString(2)+"</td>\n"+     
                                                    "<th align='center'>"+rs.getString(3)+"</td>\n"+       
                                                    "<th align='center'>"+rs.getString(4)+"</td>\n"+       
                                                    "<th align='center'>"+rs.getString(5)+"</td>\n"+    
                                                     "<th align='center'>"+Integer.parseInt(rs.getString(5)) * Integer.parseInt(rs.getString(4)) +"</td>\n"+  
                                                    "<th align='center'>"+rs.getString(6)+"</td>\n"+       
                                        
                                                  "</tr>\n");
                                
                            }        
                           out.println(" <tr style='background-color:#00b6ff;color:white;height:25px;'>\n" +
                                    "              <th>"+TotalCount+"</th>\n" +
                                    "              <th></th>\n" +     
                                    "              <th>Total Stock: - </th>\n" +   
                                    "              <th>"+TotalItems+"</th>\n" +   
                                    "              <th>Stock Valuation</th>\n" +   
                                    "              <th>"+TotalAmount+"</th>\n" +   
                                    "              <th></th>\n" +   
                                    "        </tr></table>");
                          
                          
                           
                           
                           
                           
                         }
                            catch(Exception e)                             
                            {
                                e.printStackTrace();
                            } 

               }
    
    
    }
