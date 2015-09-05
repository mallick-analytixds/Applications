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
import javax.servlet.http.HttpSession;
import org.apache.catalina.Session;
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
                                               
                        try{
                            PrintWriter out = response.getWriter();
                            String UserName = request.getParameter("userid");
                            String Password = request.getParameter("password");
                            Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();                               
                            PreparedStatement pst =  connection.prepareStatement("select USER_TYPE from TBL_USER_TABLE WHERE  USER_ID = ? AND PASSWORD = ?");       
                            pst.setString(1, UserName);
                            pst.setString(2, Password);
                            ResultSet rs = pst.executeQuery();      
                            if(rs.next())
                            {
                                HttpSession s1 =request.getSession();
                                s1.setAttribute("islogin","true");
                                s1.setAttribute("username",UserName);
                                s1.setAttribute("usertype",rs.getString(1));    
                                response.sendRedirect("JSP_Container/Dashboard.jsp");
                            }         
                            else
                            {
                                response.sendRedirect("login.jsp?state=fail");
                            }
                            }
                            catch(Exception e)                             
                            {
                                e.printStackTrace();
                            } 

               }
    
    
    }
