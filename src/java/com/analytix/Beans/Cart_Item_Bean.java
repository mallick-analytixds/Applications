package com.analytix.Beans;
/*
 @author Mallick
 */
public class Cart_Item_Bean
{

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getQuantiy() {
        return Quantiy;
    }

    public void setQuantiy(String Quantiy) {
        this.Quantiy = Quantiy;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public Cart_Item_Bean(String ProductName, String Quantiy, String Amount) {
        this.ProductName = ProductName;
        this.Quantiy = Quantiy;
        this.Amount = Amount;
    }
    
        private String ProductName;
        private String Quantiy;
        private String Amount;
        
        
}
