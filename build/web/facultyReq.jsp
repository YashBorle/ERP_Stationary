<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/facReq.css">
        
        <style>
            .form-control{
                margin-bottom: 10px;
            }
            
        </style>
        
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        
            
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<h4 class="jumbotron">FACULTY REQUEST PAGE</h4>
        
	<form class="requisition-page">
		<h2>Stationary Required Fill Up Form</h2>
                <div class="row">
                    <div class="col">
		<label for="faculty name" >
			Faculty Name: 
		</label>
                    </div>
                    <div class="col">
                        <select class="form-control" id="facDrop">
                            <option disabled="disabled" selected="selected">Faculty Name</option>
			</select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
		<label for="item name">
			Item Name:
		</label>
                    </div>
                    <div class="col">
		<select class="form-control" id="selectDrop">
                    	<option disabled="disabled" selected="selected">Choose Option</option>
			</select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">

			<label for="qty req">
				Quantity Required:
			</label>
                    </div>
                    <div class="col">
                    
			<input class="form-control" type="number" id="quantity" name="qtyre" placeholder="Quantity Required">
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="remarks">
                                Remarks:
                        </label>
                    </div>
                    <div class="col">
                        <textarea class="form-control" id="rem" placeholder="Type Any Remarks"></textarea>
                    </div>
                </div>
                <input class="btn btn-primary" type="button" name="Submit" id="subBtn" value="Submit">

                <div id="debug"></div>
                <div class="mt-3">
                    <table class="table table-striped">
                        <tr class="bg-info">
                            <th>Item id</th>
                            <th>Item</th>
                            <th>Stock Available</th>
                        </tr>
                        <tbody id="StockTable"></tbody>
                    </table>
                </div>
	</form>
        
        <script>
            

            
            
            
            let fData = `<%= (String)(request.getAttribute("fjson") ) %>`;
            let myData = `<%= (String)(request.getAttribute("gjson") ) %>`;
            var obj = JSON.parse(myData);
            var fobj = JSON.parse(fData);
            

//            var debu = document.getElementById("debug");
////            debu.innerHTML = obj;
//            debu.innerHTML =fobj;            
            
            fillOption(obj,fobj);
            
            function fillOption(data,fac){
                
                var facOpt = document.getElementById("facDrop");
                var opt = document.getElementById("selectDrop");
                var table = document.getElementById("StockTable");
                for(var i=0;i<fac.length;i++){
                    var option =`<option>`+fac[i]+`</option>`
                    facOpt.innerHTML += option;
                }
                for(var i=0;i<data.length;i++){
                    var option =`<option>`+data[i].ItemName+`</option>`
                    opt.innerHTML += option;
                    
                    var row = `
                            <tr>
                                <td>`+ data[i].ItemId+`</td>
                                <td>`+ data[i].ItemName+`</td>
                                <td>`+ data[i].stockAvailable+`</td>
                            <tr>`
                    table.innerHTML += row;
                }
                
            }
            
            
            $(document).ready(function(){
                $("#subBtn").click(function(){
                    var fac = $("#facDrop").val();
                    var item = $("#selectDrop").val();
                    var quantity = $("#quantity").val();
                    var rem = $.trim($("#rem").val());
                    if(fac==="" || item==="" || quantity ==="" || quantity<0 || rem==="" ){
                        window.alert("Please Fill the Values");
                    }else{
//                        $("#debug").html(fac+item+quantity+rem);
                        var pos = JSON.stringify({faculty:fac,item:item,quantity:quantity,remarks:rem});

                        $.ajax({
                            type:'POST',
                            datatype:'json',
                            data:{pos:pos},
                            url:'submitRequest',
                            success: function(response){
                                alert(response.message);
                                location.reload();
                            }
                        });
                    }
                });
            });
            
            
        </script>
        

</body>
</html>