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
public class ProductDropdownBean 
{

   

    public ProductDropdownBean() 
    {
        this.productNameList = new ArrayList<String>();
        getAllMenu();
        
    }
    private List productNameList;

    public List getProductNameList() {
        return productNameList;
    }

    public void setProductNameList(List productNameList) {
        this.productNameList = productNameList;
    }
      
    private void getAllMenu()
    {
        try
        {
                            Connection connection = com.analytix.Beans.ConnectionObjectSingleton.getConnectionObject();   
                            PreparedStatement pst =  connection.prepareStatement("select product_name,product_price from tbl_stock order by product_name");                          
                            ResultSet rs = pst.executeQuery();     
                            while(rs.next())
                            {
                                productNameList.add(rs.getString(1));                       
                            }                                            
                 
        } catch (Exception e)
        {
        e.printStackTrace();
        }
       
        
    }

}
