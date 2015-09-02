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


@WebServlet(urlPatterns = {"/AddCatagory"})
public class AddCatagory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                                
                        String catagory   = request.getParameter("catagory");
                        try
                         {                             
                            Connection connection= com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();                                 
                            PreparedStatement pst =  connection.prepareStatement("insert into TBL_CATAGORY values (?)");                            
                            pst.setString(1, catagory);                     
                            int status = pst.executeUpdate();                             
                         }
                         catch(Exception e)
                         {
                            e.printStackTrace();
                         }
                      
                       
    }

}
