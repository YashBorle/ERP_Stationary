<html>
    <head>
        <title>Stock Fill Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        
    </head>
    
    <body>
        <h4 class="jumbotron">STOCK FILL PAGE</h4>
        <table class="table table-striped">
        <tr class="bg-info">
            <th>Serial</th>
            <th>Item</th>
            <th>Requested</th>
            <th>Remark</th>
            <th>Supplied</th>
            </tr>
            
            <tbody id="tableReq"></tbody>
        </table>
        <div class="d-flex flex-row">
            <div class="p-3">
                Date and Time :
                <span id="date"/>
                </div>
            <div class="p-3">
                <p id="time"></p>
                </div>
            <div class="p-3">
            <button class="btn btn-primary" id="submit" value="Save" >Save</button>
            </div>
            </div>
        <div id="message"></div>
        
        <script>
            
            
            


        var flag = '<%= (String) (request.getAttribute("flag")) %>';
        if(flag==="true"){
        let myjson = '<%= (String) (request.getAttribute("gjson")) %>';
        var obj = JSON.parse(myjson);
        
        
        buildTable(obj);
        
        function buildTable(data){           
            var table = document.getElementById("tableReq")
            
            for(var i=0;i<data.items.length;i++){
            var row=`
                    <tr>
                        <td>`+(i+1)+`</td>
                        <td>`+data.items[i]+`</td>
                        <td>`+data.quantity[i]+`</td>
                        <td><input type="text" name="remark" value=""></td>
                        <td><input type="number" name="supplied" value="" ></td>
                    <tr>`
            table.innerHTML += row
            }
            document.getElementById("date").innerHTML=data.printDate
//            document.getElementById("time").innerHTML=data.time
        }
        
        
        $(document).ready(function(){
            $("#submit").click(function(){
                var rem= jQuery.makeArray(document.getElementsByName("remark"));
                var sup= jQuery.makeArray(document.getElementsByName("supplied"));
                
                var rema = [];
                var supa = [];
                
                for(var i=0;i<rem.length;i++){
                    rema.push(rem[i].value);
                        supa.push(sup[i].value);
                }
                
//                var pos = JSON.stringify({items:obj.items.toString(),id:obj.reqId,remarks:rema.toString(),supplied:supa.toString()});
//                $("#message").html(pos);
                $.ajax({
                    type:'POST',
                    data:{items:obj.items.toString(),id:obj.reqId,remarks:rema.toString(),supplied:supa.toString()},
                    datatype:'json',
                    url:'SubmitSupplied',
                    success: function(result){
                        window.alert(result.message);
                        if(result.message==="Success"){
                            window.location.pathname = "ERP_Stationary/index.jsp"
                        }
                    }
                });
                
            });
        });
    }
    else{
        alert("No Running Entry Found");
        window.location.pathname ="ERP_Stationary/index.jsp";
    }
        
        </script>
        
    </body>
    
</html>