package com.analytix.Beans;
import java.sql.Connection;
import java.sql.DriverManager;
/*
  @author Masaddat Mallick
*/
public class ConnectionObjectSingleton 
{    
    private static Connection connection;        
    private ConnectionObjectSingleton()
    {
            try
            {
                        String user="ADS_USER2";
                        String pass="520759";
                        String url = "jdbc:sqlserver://localhost;database=INVENTORY;";
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                
                        connection=DriverManager.getConnection(url,user,pass);
             }
            catch(Exception e)
            {
                        e.printStackTrace();             
            }    
    
    }
    public  static synchronized Connection getConnectionObject() throws InterruptedException // With out Synchronization two or more threads can enter Object creation block at a time and will get different Objects
    {
                        if(connection==null)
                        {
                                   if(Thread.currentThread().getName().equalsIgnoreCase("t1"))
                                   {
                                       Thread.sleep(2000);
                                   }
                                   new ConnectionObjectSingleton();
                                   return connection;
                        }
                        else
                        return connection;
    }
    
    @Override
    protected Object clone()
    {
                    if(connection==null)
                        {
                                   new ConnectionObjectSingleton();
                                   return connection;
                        }
                    else
                    return connection;
    }
    
    public Object customSQLFunction(String TableName,String ColumnName)
    {
            return null;
    }
   
}
    
