
    function menuHide()
    {
          document.getElementById("main_menu_container").style.display="none";        
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
  
  
  function cart_Item_List_Generator()
  {
     var product_name = document.getElementById("product_name").value;
     var itemquantity = document.getElementById("itemquantity").value;
     var pricePerItem = document.getElementById("pricePerItem").value;
     var totalItemAmount = document.getElementById("totalItemAmount").value;
     var NoOfItems= document.getElementById("no_of_items").value;
     dynamicRowGenerator(product_name,itemquantity,pricePerItem,totalItemAmount,NoOfItems)
      
  }
  
  function dynamicRowGenerator(product_name,itemquantity,pricePerItem,totalItemAmount,NoOfItems)
  {
                    
                   var textBox = document.createElement('input');
     	 textBox.setAttribute('type','text');	
     	 textBox.setAttribute('name','product_name'+NoOfItems);
                   textBox.setAttribute('class','menu_textbox_big');
                   textBox.setAttribute('value',product_name);
                   textBox.setAttribute('id','product_name'+NoOfItems);
                   document.getElementById("ALL_CART_ITEM").appendChild(textBox);
                   
                   
                   
                   var textBox2 = document.createElement('input');
     	 textBox2.setAttribute('type','text');	
     	 textBox2.setAttribute('name','itemquantity'+NoOfItems);
                   textBox2.setAttribute('class','menu_textbox');
                   textBox2.setAttribute('value',itemquantity);
                   textBox2.setAttribute('id','itemquantity'+NoOfItems);
                   document.getElementById("ALL_CART_ITEM").appendChild(textBox2);
                   
                   
                   var textBox3 = document.createElement('input');
     	 textBox3.setAttribute('type','text');	
     	 textBox3.setAttribute('name','pricePerItem'+NoOfItems);
                   textBox3.setAttribute('class','menu_textbox');
                   textBox3.setAttribute('value',pricePerItem);
                   textBox3.setAttribute('id','pricePerItem'+NoOfItems);
                   document.getElementById("ALL_CART_ITEM").appendChild(textBox3);
                   
                   var textBox4 = document.createElement('input');
     	 textBox4.setAttribute('type','text');	
     	 textBox4.setAttribute('name','totalItemAmount'+NoOfItems);
                   textBox4.setAttribute('class','menu_textbox');
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