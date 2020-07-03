<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	body{margin-top:20px;}

.toggleDisplay {
  display: none;
}
.toggleDisplay.in {
  display: table-cell;
}
    </style>
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<table class="table table-bordered">
  <thead>
    <tr>
      <th>#</th>
      <th id="click-me">Click Me</th>
      <th>Last Name</th>
      <th>Username</th>
      <th class="toggleDisplay">Th 1</th>
      <th class="toggleDisplay">Th 2</th>
      <th class="toggleDisplay">Th 3</th>
      <th class="toggleDisplay">Th 4</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td class="toggleDisplay">Td 1</td>
      <td class="toggleDisplay">Td 2</td>
      <td class="toggleDisplay">Td 3</td>
      <td class="toggleDisplay">Td 4</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
      <td class="toggleDisplay">Td 1</td>
      <td class="toggleDisplay">Td 2</td>
      <td class="toggleDisplay">Td 3</td>
      <td class="toggleDisplay">Td 4</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
      <td class="toggleDisplay">Td 1</td>
      <td class="toggleDisplay">Td 2</td>
      <td class="toggleDisplay">Td 3</td>
      <td class="toggleDisplay">Td 4</td>
    </tr> 
  </tbody> 
</table>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$("#click-me").click(function() {
    $(".table .toggleDisplay").toggleClass("in");
});
</script>
</body>
</html>