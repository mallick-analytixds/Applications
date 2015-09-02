/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analytix.Beans;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Mallick
 */
public class CatagoryDropdownBean 
{

    public List getMylist() {
        return mylist;
    }

    public void setMylist(List mylist) {
        this.mylist = mylist;
    }

    public CatagoryDropdownBean() 
    {
        this.mylist = new ArrayList<String>();
        getAllMenu();
        
    }
    private List mylist = new ArrayList<String>();
      
    private void getAllMenu()
    {
        try
        {
                 Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();   
                            PreparedStatement pst =  connection.prepareStatement("select *from tbl_catagory order by catagory_id desc");                          
                            ResultSet rs = pst.executeQuery();     
                            while(rs.next())
                            {
                                mylist.add(rs.getString(2));                       
                            }                                            
                 
        } catch (Exception e)
        {
        e.printStackTrace();
        }
       
        
    }

}
