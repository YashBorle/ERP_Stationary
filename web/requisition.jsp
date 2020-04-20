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
    <option value="pen">Pen</option><br />
    <option value="pencil">Pencil</option><br />
    <option value="eraser">Eraser</option><br />
    <option value="bmarker">Board Markers</option><br />
    <option value="highlighter">Highlighters</option><br />
    <option value="shrpener">Sharpener</option><br />
    <option value="stapler">Stapler</option></th> </tr>

    <tr><th><label for="quantity">Quantity</label></th>
        <th><input type="number" id="quantity" placeholder="Quantity Required"></th>
   
<tr><th><button type="button" id="addbtn" class="btn btn-success" onClick="add()" >Add</button></th></tr>
      </div>
      
        <form action="DataInput" method="post">
                <table class="table table-primary">
                    <tr class="bg-info">
                        <th>Serial No.</th>
                        <th>Item</th>
                        <th>Quantity</th>
                    </tr>
                    <tbody id="myTable"></tbody>
                </table>
                
                <input type="submit" class="btn btn-primary" name="submit" value="Submit"/>
                <div>Items:  <p id="itemQuan" name="itemQuan"></p></div>
        </form>
      
<!--      
                   <script type="text/javascript">
                    $(document).ready(function(){
                     $("#message").html("Hello World");
                    });
-->                    </script>
<script type="text/javascript">
    
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
                    <div><input type="text" name="items" value=`+ival+`></div>&nbsp
                    <div><input type="text" name="quantities" value=`+qval+`></div>
                    </tr>
                    `
    }
    
    </script>
</html>
