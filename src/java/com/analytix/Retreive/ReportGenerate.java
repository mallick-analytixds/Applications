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
@WebServlet(urlPatterns = {"/ReportGenerate"})
public class ReportGenerate extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
                                               
                        try{
                            String date = request.getParameter("date");
                            PrintWriter out = response.getWriter();
                            Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();   
                            PreparedStatement pst;
                            if(date !=null)
                            {
                               pst =  connection.prepareStatement("select *from tbl_main_bill order by bill_id desc");     
//                            pst =  connection.prepareStatement("select *from tbl_main_bill  order by bill_id desc where BILL_DATE=?");  
//                            pst.setDate(1, new java.sql.d);
                            }
                            else
                            {
                               pst =  connection.prepareStatement("select *from tbl_main_bill order by bill_id desc");     
                            }
                            ResultSet rs = pst.executeQuery();
                            System.out.println(date);
                            int TotalCount = 0;
                            int TotalItems = 0;
                            int TotalAmount = 0;
                            
                    
                            
                            out.println("<br><h2 style='display:inline;'>Select Date :</h2>&nbsp;&nbsp;&nbsp;"
                                    + "<select name='dateselector' class='textBox' id='dateselector' "
                                    + "onchange='contentLoader(\"/Analytix_Inventory_System/ReportGenerate?date=\"+this.value,\"crud_Area\")' >");
                            while(rs.next())
                            {
                                       
                                                      out.println("<option>"+rs.getString(3)+"</option> ");
                            }
                            out.println("</select>");
                            rs = pst.executeQuery();
                            
                            
                            
                            
                            out.println("<table cellspacing='3' style='width:100%;' align='center'>\n" +
                                    "        <tr style='background-color:#00b6ff;color:white;height:25px;'>\n" +
                                    "              <th>Bill ID</th>\n" +
                                    "              <th>Customer Name</th>\n" +     
                                    "              <th>Bill Date</th>\n" +   
                                    "              <th>Total Items</th>\n" +   
                                    "              <th>Total Amount Paid</th>\n" +   
                                    "              <th>Prepared By</th>\n" +   
                                    "        </tr>");
                            while(rs.next())
                            {
                                TotalCount++;
                                TotalItems+=rs.getInt(4);
                                TotalAmount+=rs.getInt(5);
                                out.println("<tr style='background-color:#fcf6d6;color:#772d00 ;height:25px;font-size:14px; font-weight:bold;cursor:pointer;'>");
                                out.println("<th align='center'>"+rs.getString(1)+"</td>"+
                                                  "<th align='center'>"+rs.getString(2)+"</td>\n"+     
                                                    "<th align='center'>"+rs.getString(3)+"</td>\n"+       
                                                    "<th align='center'>"+rs.getString(4)+"</td>\n"+       
                                                    "<th align='center'>"+rs.getString(5)+"</td>\n"+      
                                                    "<th align='center'>"+rs.getString(6)+"</td>\n"+       
                                        
                                                  "</tr>\n");
                                
                            }        
                           out.println(" <tr style='background-color:#00b6ff;color:white;height:25px;'>\n" +
                                    "              <th>"+TotalCount+"</th>\n" +
                                    "              <th></th>\n" +     
                                    "              <th>Total : - </th>\n" +   
                                    "              <th>"+TotalItems+"</th>\n" +   
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
