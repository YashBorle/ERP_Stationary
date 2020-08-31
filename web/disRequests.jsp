<%-- 
    Document   : Show Faculty Request
    Created on : 27 Apr, 2020, 8:03:12 PM
    Author     : LoveYou3000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <style>
            #tableReq{
                margin: 10px
            }
            
            #home1{
                color: white;
                text-decoration: azure;
            }
            
        </style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty Requests</title>
        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  
    </head>
    <body>
        
        <h4 class="jumbotron">Faculty Request</h4>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="DisplayRequests" method="get">
                        <div class="input-group">
                            <label for="last" >Last Requests: </label>
                            <div class="mx-2">
                                <div class="col-xs-3">
                                    <input class="form-control" type="number" id="last" name="last">
                                </div>
                            </div>
                            <button class="btn btn-primary" id="submit" type="submit">Get them</button>
                            <div class="mx-2">
                                <button class="btn btn-primary" id="home"><a id="home1" href="index.jsp">Home</a></button>
                            </div>
                        </div>
                    </form>
                    <div class="m-2">
                        <table id="reqTable" class="table table-striped">
                            <tr class="bg-info">
                                <th>Name</th>
                                <th>Item</th>
                                <th>Quantity</th>
                                <th>Date And Time</th>
                                <th>Remarks</th>
                            <tbody id="tableB"></tbody>
                            </tr>
                        </table>
                        <div id="debug"></div>
                    </div>
                </div>
            </div>
        </div>
        <script>


            
            var json=`<%= (String)(request.getAttribute("json")) %>`;
            var flag=`<%= (String)(request.getAttribute("flag")) %>`;
//            var obj = JSON.parse(json);
            
            if(flag==="true"){
                var obj = JSON.parse(json);
                var n = Object.keys(obj).length;
//                $("#debug").html(obj[1].item);
                buildTable(obj,n);
            }
            else if(flag==="false"){
                alert(json);
            }
            
            function buildTable(data,n){
//                var table = $("#tableB");
                var table = document.getElementById("tableB");
                for(var i =0;i<n;i++){
                    var row =   `<tr>
                                    <td>`+data[i].facultyName+`</td>
                                    <td>`+data[i].item+`</td>
                                    <td>`+data[i].quantity+`</td>
                                    <td>`+data[i].reqDate+`</td>
                                    <td>`+data[i].remarks+`</td>
                                </tr>`;
                    table.innerHTML += row;
                }
                
            }
            
        </script>
    </body>
</html>
