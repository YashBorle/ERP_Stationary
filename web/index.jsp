<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <div class="jumbotron">
        <h4>ERP Stationary Management</h4>
        </div>        
        <div class="d-flex justify-content-center">
            <div class="p-3"><a class="btn btn-outline-primary" href="GetStock?e='requisition'">Requisition Page</a></div>
            <div class="p-3"><a class="btn btn-outline-primary" href="FetchData">Stock Filling</a></div>
        </div>
        <div class="d-flex justify-content-center">
            <div class="p-3"><a class="btn btn-outline-primary" href="GetStock?e='request'">Faculty Request</a></div>
            <div class="p-3"><a class="btn btn-outline-primary" href="DisplayRequests?last=5">Display Requests</a></div>
        </div>
    </body>
</html>
