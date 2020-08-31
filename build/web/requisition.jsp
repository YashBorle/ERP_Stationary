<%-- 
    Document   : requisition.jsp
    Created on : 14 Apr, 2020, 7:54:18 PM
    Author     : LoveYou3000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <style>
         body{
             padding: 10px;
         }
         
         #addbtn{
             margin-bottom: 5px;
         }
     
     </style>
     
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  
 </head>

 
     <h4 class="jumbotron">Requisition Page</h4>
    <h6>Requirements:</h6>
	<table>
    <tr><th><label for='drop'>Select the item</label></th>
    <th><select id="drop">
    </th> </tr>

    <tr><th><label for="quantity">Quantity</label></th>
        <th><input type="number" id="quantity" placeholder="Quantity Required"></th>
   
<tr><th><button type="button" id="addbtn" class="btn btn-success" onClick="add()" >Add</button></th></tr>
      </div>
      
      <form>
                <table class="table table-primary">
                    <tr class="bg-info">
                        <th>Serial No.</th>
                        <th>Item</th>
                        <th>Quantity</th>
                    </tr>
                    <tbody id="myTable"></tbody>
                </table>
                
                <input type="button" class="btn btn-primary" id="submit" value="Submit"/>
                <div>Items:  <p id="itemQuan" name="itemQuan"></p></div>
        </form>
      <div id="message"></div>

      
<!--      
                   <script type="text/javascript">
                    $(document).ready(function(){
                     $("#message").html("Hello World");
                    });
-->                    </script>
<script type="text/javascript">
    
//    var elems = document.getElementsByName("item")
//    var arr = jQuery.makeArray( elems );


    let myData = `<%= (String)(request.getAttribute("gjson") ) %>`;
    var obj = JSON.parse(myData);
    var opt = document.getElementById("drop");
    for(var i=0;i<obj.length;i++){
                    var option =`<option>`+obj[i].ItemName+`</option>`
                    opt.innerHTML += option;
                }
    
    
    $(document).ready(function(){
     $("#submit").click(function(){
        var arr = jQuery.makeArray(document.getElementsByName("item"));
        var qua = jQuery.makeArray(document.getElementsByName("quantity"));
        var quant= [];
        var it =[];
        for(var i=0;i<arr.length;i++){
            if(arr[i].value!==""){
                it.push(arr[i].value);
                if(qua[i].value!==""){
                    quant.push(qua[i].value);
                }
            }                
        }
        $.ajax({
            type:'POST',
            data:{items:it.toString(),quantity: quant.toString(),itl:it.length,qtl:quant.length},
            datatype:'json',
            url:'DataInput',
            success: function(result){
                if(result.message === "Success"){
                    alert(result.message);
                    window.location.pathname ="ERP_Stationary/index.jsp";
                }
                else{
                    window.alert(result.message);
                }
//                $("#message").html("Success"); 
            }
        });
     });
    });

    
    var i=0;
    var n = i+1;
    var item=[n];
    var quant=[n];
    
    function add(){
        var added = document.getElementById("itemQuan");
        var table = document.getElementById("myTable");
        var quanity = document.getElementById("quantity");
        var drop = document.getElementById("drop");
        ival=drop.value;
        qval=quanity.value;
        
        var row=getDynamicTable(i,ival,qval);
        
        itemQuan.innerHTML=i+1;
        table.innerHTML += row;
        i++;
        
        quanity.value=0;
        drop.selectedIndex++;
        
    }
    
    function getDynamicTable(i,ival,qval){
        return `
                    <tr>
                    <td>`+(i+1)+`</td>
                    <div><td><input type="text" name="item" value=`+ival+` readonly></td></div>&nbsp
                    <div><td><input type="number" name="quantity" value=`+qval+`></td></div>
                    </tr>
                    `
    }
    
    
    
    </script>
</html>
