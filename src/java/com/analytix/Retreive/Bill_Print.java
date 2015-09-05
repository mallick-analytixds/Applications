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
import com.analytix.Beans.Cart_Item_Bean;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
@WebServlet(urlPatterns = {"/Bill_Print"})
public class Bill_Print extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
                                               
                        try{
                            System.out.println("PRINT BILL");
                            
                            int  billid=Integer.parseInt(request.getParameter("Bill"));                        
                            Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();            
                            
                            PreparedStatement Cart_Items =  connection.prepareStatement("select *from tbl_cart_items where bill_id=? ");
                            PreparedStatement Bill_Detail =  connection.prepareStatement("select *from tbl_main_bill where bill_id=?");
                            
                            Bill_Detail.setInt(1, billid);
                            Cart_Items.setInt(1, billid);
                            
                            ResultSet All_Cart_Items = Cart_Items.executeQuery();
                            ResultSet Bill_Detail_Info = Bill_Detail.executeQuery();
                            
                            ArrayList <Cart_Item_Bean> Cart_Item_List = new ArrayList <Cart_Item_Bean>();
                            Map <String,String> Bill_Detail_list = new TreeMap <String,String>();
                             
                             if(Bill_Detail_Info.next())
                             {
                             Bill_Detail_list.put("BILL_ID", Bill_Detail_Info.getString(1));
                             Bill_Detail_list.put("CUSTOMER_NAME", Bill_Detail_Info.getString(2));
                             Bill_Detail_list.put("BILL_DATE", Bill_Detail_Info.getString(3));
                             Bill_Detail_list.put("TOTAL_ITEMS", Bill_Detail_Info.getString(4));
                             Bill_Detail_list.put("TOTAL_AMOUNT_PAID", Bill_Detail_Info.getString(5));
                             Bill_Detail_list.put("PREPARED_BY", Bill_Detail_Info.getString(6));
                             }
                            while(All_Cart_Items.next())
                            {
                                Cart_Item_List.add(new Cart_Item_Bean(All_Cart_Items.getString(3), All_Cart_Items.getString(4), All_Cart_Items.getString(5))); 
                            }
                            request.setAttribute("Cart_List", Cart_Item_List);
                            request.setAttribute("Bill_Detail", Bill_Detail_list);
                            System.out.println("Before Forward"+Cart_Item_List.size());
                            System.out.println("Before Forward"+Bill_Detail_list.size());
                            request.getRequestDispatcher("/JSP_Container/Final_Bill.jsp").forward(request, response);
                            
                            
                                                     
                         }
                            catch(Exception e)                             
                            {
                                e.printStackTrace();
                            } 

               }
    
    
    }
