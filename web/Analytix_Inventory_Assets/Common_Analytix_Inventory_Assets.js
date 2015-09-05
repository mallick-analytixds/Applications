
    function menuHide()
    {
          document.getElementById("main_menu_container").style.display="none";
          document.getElementById("menu_opener").style.display="block";  
    }


    function menuHide2(obj)
    {
          obj.style.display="none";
          document.getElementById("main_menu_container").style.display="block";        
    }
    function contentLoader(jspname,container)
    {
                                           
                                           xmlup=new XMLHttpRequest();	
                                           xmlup.onreadystatechange=
                                           function()
                                           {
                                                   if(xmlup.readyState === 4 && xmlup.status === 200)	
                                                           {
                                                                document.getElementById(container).innerHTML= xmlup.responseText;
                                                           }
                                                   else
                                                   {
                                                   }
                                           };
                                           xmlup.open("get",jspname,false);		
                                           xmlup.send();
        
    }
    
  function ItemTotalCalculation(qntvalue)
  {
      
      var quantity = parseInt(qntvalue);
      var price = parseInt(document.getElementById("pricePerItem").value);      

      document.getElementById("totalItemAmount").value = quantity * price;
      
  }
  
  function makeNull()
  {
      document.getElementById("totalItemAmount").value="";
      
  }
  
  
  
  
   var JsonItems = {"JOBJECT":[{"NAME":""}]};
  function cart_Item_List_Generator()
  {
      if(document.getElementById("product_name").value=="")
      {
          alert("Select  a Product First !")
      }
      else
      {
      
     var product_name = document.getElementById("product_name").value;
     var itemquantity = parseInt(document.getElementById("itemquantity").value);
     var pricePerItem = document.getElementById("pricePerItem").value;
     var totalItemAmount = document.getElementById("totalItemAmount").value;
     var NoOfItems= document.getElementById("no_of_items").value;
     var isItemConsist = false;
     
     
            if(itemquantity <= 0 )
            {
                  alert("No Quantity Selected !");
            }
            else
            {
                            for(i in  JsonItems.JOBJECT)
                            {
                                if(product_name == JsonItems.JOBJECT[i].NAME)
                                {
                                    isItemConsist = true;
                                }
                            }

                            if(isItemConsist==true)
                            {
                                    alert("Item Already Added !! Remove existing to Add again");
                            }
               else
               {     
                            if(itemquantity <= 0 )
                            {
                                alert("No Quantity Selected !");
                            }
                            else
                            {
                            JsonItems['JOBJECT'].push({"NAME": product_name });
                            isItemConsist = false;
                            dynamicRowGenerator(product_name,itemquantity,pricePerItem,totalItemAmount,NoOfItems);
                            }
               }    
             }
         }
      
  }
  
  function dynamicRowGenerator(product_name,itemquantity,pricePerItem,totalItemAmount,NoOfItems)
  {
                    
                   var textBox = document.createElement('input');
                   textBox.setAttribute('type','text');
                   textBox.setAttribute('readonly','');	
                   textBox.setAttribute('name','product_name'+NoOfItems);
                   textBox.setAttribute('class','menu_textbox_readonly_big');
                   textBox.setAttribute('value',product_name);
                   textBox.setAttribute('id','product_name'+NoOfItems);
                   document.getElementById("ALL_CART_ITEM").appendChild(textBox);
                   
                   
                   
                   var textBox2 = document.createElement('input');
                   textBox2.setAttribute('type','text');	
                   textBox2.setAttribute('readonly','');	
                   textBox2.setAttribute('name','itemquantity'+NoOfItems);
                   textBox2.setAttribute('class','menu_textbox_readonly');
                   textBox2.setAttribute('value',itemquantity);
                   textBox2.setAttribute('id','itemquantity'+NoOfItems);
                   document.getElementById("ALL_CART_ITEM").appendChild(textBox2);
                   
                   
                   var textBox3 = document.createElement('input');
                   textBox3.setAttribute('type','text');	
                   textBox3.setAttribute('readonly','');	
                   textBox3.setAttribute('name','pricePerItem'+NoOfItems);
                   textBox3.setAttribute('class','menu_textbox_readonly');
                   textBox3.setAttribute('value',pricePerItem);
                   textBox3.setAttribute('id','pricePerItem'+NoOfItems);
                   document.getElementById("ALL_CART_ITEM").appendChild(textBox3);
                   
                   var textBox4 = document.createElement('input');
     	textBox4.setAttribute('type','text');	
                    textBox4.setAttribute('readonly','');	 
                    textBox4.setAttribute('name','totalItemAmount'+NoOfItems);
                   textBox4.setAttribute('class','menu_textbox_readonly');
                   textBox4.setAttribute('value',totalItemAmount);
                   textBox4.setAttribute('id','totalItemAmount'+NoOfItems);
                   document.getElementById("ALL_CART_ITEM").appendChild(textBox4);
                   
                   
                   var button = document.createElement('input');
                   button.setAttribute('type','button');
                   button.setAttribute('class','remove_button')
                   button.setAttribute('value','X');
                   button.setAttribute('onClick','removeCart('+NoOfItems+',this)');
                  document.getElementById("ALL_CART_ITEM").appendChild(button);
                    
     	var bar = document.createElement('br');
                  bar.setAttribute('id','bar'+NoOfItems);  
                  document.getElementById("ALL_CART_ITEM").appendChild(bar);     
        
     	document.getElementById("no_of_items").value= 1 + parseInt(document.getElementById("no_of_items").value);
        
     	document.getElementById("GrossTotal").value = parseInt(document.getElementById("GrossTotal").value) + parseInt(document.getElementById('totalItemAmount'+NoOfItems).value);
                  document.getElementById("AllTotalItem").value = parseInt(document.getElementById("AllTotalItem").value) + parseInt(document.getElementById('itemquantity'+NoOfItems).value);
        
  }
  
  function removeCart(NoOfItems,currentobject)
  {
                               
                                
                              document.getElementById("GrossTotal").value = parseInt(document.getElementById("GrossTotal").value) - parseInt(document.getElementById('totalItemAmount'+NoOfItems).value);
                              document.getElementById("AllTotalItem").value = parseInt(document.getElementById("AllTotalItem").value) - parseInt(document.getElementById('itemquantity'+NoOfItems).value);
                              
                                    
                                for (key in JsonItems.JOBJECT)
                                {
		if (JsonItems.JOBJECT[key].NAME == document.getElementById('product_name'+NoOfItems).value)
		                {
		                delete JsonItems.JOBJECT[key];
                                                        }	                
	            }
                                 
                                var textBox = document.getElementById('product_name'+NoOfItems);
                                textBox.parentNode.removeChild(textBox);
                                
                                var textBox2 = document.getElementById('itemquantity'+NoOfItems);
                                textBox2.parentNode.removeChild(textBox2);
                                
                                var textBox3 = document.getElementById('pricePerItem'+NoOfItems);
                                textBox3.parentNode.removeChild(textBox3);
                                
                                var textBox4 = document.getElementById('totalItemAmount'+NoOfItems);
                                textBox4.parentNode.removeChild(textBox4);
                                
                                var bar = document.getElementById('bar'+NoOfItems);
                                bar.parentNode.removeChild(bar);
                                
                                var button = currentobject;
                                button.parentNode.removeChild(button);
                          
										
                                
                               
                                document.getElementById("no_of_items").value= parseInt(document.getElementById("no_of_items").value) -1;
                             
                                
                                
                                
  }
  
                        function ajaxSubmit(queryString,destination)
                        {

                                xmlup=new XMLHttpRequest();	
                                           xmlup.onreadystatechange=
                                           function()
                                           {
                                                   if(xmlup.readyState === 4 && xmlup.status === 200)	
                                                           {
                                                               var status = xmlup.responseText;    
                                                               alert(status);   
                                                               if(status != "Failed to Add Catagory")
                                                               {
                                                               document.getElementById("catagoryTB").value="";
                                                               document.getElementById("display_Area").innerHTML="";
                                                               contentLoader('../CatagoryList','display_Area');
                                                               }
                                                           }
                                                   else
                                                   {
                                                   }
                                           };
                                           xmlup.open("get",destination+queryString,false);		
                                           xmlup.send();
                                

                        }                        
                        function CatagorySave()
                        {
                            var catName = document.getElementById("catagoryTB").value;
                            if(catName.length >3)
                            {
                                ajaxSubmit('?catagory='+catName, '../AddCatagory') ;    
                            }
                            else
                            alert("Invalid Catagory Name")   
                            
                        }
                        
                        function ajaxSubmitProduct(queryString,destination)
                        {

                                xmlup=new XMLHttpRequest();	
                                           xmlup.onreadystatechange=
                                           function()
                                           {
                                                   if(xmlup.readyState === 4 && xmlup.status === 200)	
                                                           {
                                                               var status = xmlup.responseText;    
                                                               alert(status);   
                                                               if(status != "Failed to Add Product")
                                                               {
                                                                document.getElementById("product_name").value="";
                                                                document.getElementById("product_quantity").value="";
                                                                document.getElementById("product_price").value="";
                                                               } 
                                                                
                                                                 //document.getElementById("display_Area").innerHTML="";
                                                                //contentLoader('../CatagoryList','display_Area');
                                                           }
                                                   else
                                                   {
                                                   }
                                           };
                                           xmlup.open("get",destination+queryString,false);		
                                           xmlup.send();
                                

                        }                        
                        function ProductSave()
                        {
                              var product_catagory = document.getElementById("product_catagory").value;
                              var product_name = document.getElementById("product_name").value;
                              var product_quantity = parseInt(document.getElementById("product_quantity").value);
                              var product_price = parseInt(document.getElementById("product_price").value);
                              
                              
                               
                               
                            if(product_name.length >3 && (product_quantity > 0 && product_quantity < 1000) &&  (product_price > 0 && product_price < 200000))
                            {
                            ajaxSubmitProduct('?product_catagory='+product_catagory+'&product_name='+product_name+'&product_quantity='+product_quantity+'&product_price='+product_price, '../AddProduct') ;    
                            }
                            else
                            alert("Invalid Detais")   
                            
                        }
                        
                        
    function noBack() 
               {
    window.history.forward()
                }
    window.history.forward()
    
    
                    function billGenerateValidation()
                    {
                       if(parseInt(document.getElementById("AllTotalItem").value) < 1)
                       {
                            alert("Not Enough Items to Create Bill")
                       }
                       else if (document.getElementById("customer_name").value.length==0) 
                       {
                           var r = confirm("Print Bill Without Customer Name ?");
                                            if (r == true) 
                                                {
                                                        document.getElementById("cartForm").submit();
                                                } 
                                            else 
                                                {
                                                        document.getElementById("customer_name").focus();
                                                } 

                       }
                       else
                       {
                           document.getElementById("cartForm").submit();                           
                       }
                    }