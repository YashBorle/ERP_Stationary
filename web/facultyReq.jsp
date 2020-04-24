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
		<input class="form-control" type="text" name="tname" placeholder="Enter Faculty Name">
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
                    
			<input class="form-control" type="number" name="qtyre" placeholder="Quantity Required">
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="remarks">
                                Remarks:
                        </label>
                    </div>
                    <div class="col">
                        <textarea class="form-control" id="remarks" placeholder="Type Any Remarks"></textarea>
                    </div>
                </div>
                <input class="btn btn-primary" type="submit" name="Submit" id="subBtn">

                <p id="debug"></p>

                    <table class="table table-striped">
                        <tr class="bg-info">
                            <th>Item id</th>
                            <th>Item</th>
                            <th>Stock Available</th>
                        </tr>
                        <tbody id="StockTable"></tbody>
                    </table>
	</form>
        

        
        <script>
            

            
            
            
            let myData = `<%= (String)(request.getAttribute("gjson") ) %>`;
            var obj = JSON.parse(myData);
            

//            var debu = document.getElementById("debug");
////            debu.innerHTML = obj;
//            debu.innerHTML =obj.length;            
            
            fillOption(obj);
            
            function fillOption(data){
                
                var opt = document.getElementById("selectDrop");
                var table = document.getElementById("StockTable");
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
            
        </script>
        

</body>
</html>