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
@WebServlet(urlPatterns = {"/CatagoryList"})
public class CatagoryList extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
                                               
                        try{
                            PrintWriter out = response.getWriter();
                            Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();   
                            PreparedStatement pst =  connection.prepareStatement("select *from tbl_catagory order by catagory_id desc");                          
                            ResultSet rs = pst.executeQuery();
                            
                            out.println("<table cellspacing='3' style='width:100%;' align='center'>\n" +
                                    "        <tr style='background-color:#00b6ff;color:white;height:25px;'>\n" +
                                    "              <th>Catagory ID</th>\n" +
                                    "              <th>Catagory Name</th>\n" +                
                                    "        </tr>");
                            while(rs.next())
                            {
                               
                                out.println("<tr style='background-color:#fcf6d6;color:#772d00 ;height:25px;font-size:14px; font-weight:bold;cursor:pointer;'>");
                                out.println("<th align='center'>"+rs.getString(1)+"</td>"+
                                                  "<th align='center'>"+rs.getString(2)+"</td>\n"+                             
                                                  "</tr>\n");
                                
                            }                           
                         }
                            catch(Exception e)                             
                            {
                                e.printStackTrace();
                            } 

               }
    
    
    }
