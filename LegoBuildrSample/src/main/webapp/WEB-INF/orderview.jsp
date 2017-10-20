    Document   : orderpage
    Created on : Oct 20, 2017, 1:28:34 AM
    Author     : Zack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

    </head>
    <body>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create Your Order</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Your Lego Order</h4>
      </div>
      <div class="modal-body">
        <form action="FrontController" method="POST">
           <input type="hidden" name="command" value="makeOrder">
           Height:<br>
           <input type="number" id="height" minlength="1" name="height">
           <br>
           Width:<br>
           <input type="number" id="width" minlength="5" name="width">
           <br>
           Length:<br>
           <input type="number" id="length" minlength="5" name="length">
           <br>
           <br><br>
           <input type="button" onclick="javascript:void(0);" id="makeOrder" value="preview order">
           <input type="submit" class="btn btn-success" value="Create your order">
       </form>
             <div id="calculate"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<script src="allOrdersScript.js"></script>
    </body>
</html>
