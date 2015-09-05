
package com.analytix.Beans;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


public class SessionFilter implements Filter 
{
    
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  throws IOException, ServletException
    {
            
        
            HttpServletRequest rst =(HttpServletRequest) request;
            HttpServletResponse rsp = (HttpServletResponse)response; 
            String IncomingURL =  rst.getRequestURI();                     
            System.out.println("********************************************************************************"+IncomingURL);
            CharSequence allowed   = "Analytix_Inventory_Assets"; // Icons and CSS/JS
            CharSequence allowed2 = "login.jsp"; //Login JSP Page
            CharSequence allowed3 = "Login"; //Login Servlet
            if(rst.getSession().getAttribute("islogin")==null)
            {
          
                if(IncomingURL.contains(allowed) || IncomingURL.contains(allowed2) || IncomingURL.contains(allowed3))
                {
                chain.doFilter(request, response);
                }
                else
                {
                rsp.sendRedirect("/Analytix_Inventory_System/login.jsp");
                }
            }
            else
            {
                 chain.doFilter(request, response);
            }
          
            
       
    }
 
   public void destroy() 
    {        
           
    } 
   @Override
    public void init(FilterConfig filterConfig)
    {   
        
    }

      
}
