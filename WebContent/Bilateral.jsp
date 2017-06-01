<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filtro Bilateral</title>
<style>
	body {background-image: url("background.jpg");
		color: white;
		font-family: Calibri;
		text-shadow: 2px 2px black;}
		
	.general {
		width: 100%;}
	h1 {margin-left: 40%;
		margin-top: 20%;}
		
	form-group {
		margin-left: 35%;}
	
	label {margin-left: 35%;}
	
	input {
		width: 300px;
    	padding: 12px 20px;
    	margin: 8px 0 0 35%;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;}
    
    .btn {width: 50px%;
	    background-color: #4CAF50;
	    color: white;
	    padding: 14px 20px;
	    margin: 8px 0 0 35%;
	    border: none;
	    border-radius: 4px;
	    cursor: pointer;}	
</style>
</head>
	 <body>
		 <form enctype="multipart/form-data" action="Bilateral">
		 	<div class="general">
		     	<h1>Filtro Bilateral</h1>
		        <form action="Bilateral" >
		        	<div class="form-group">
		        	<label for="other">Seleccione la imagen:</label>
				    	<input id="file-1" type="file" class="file" multiple=true name="file1" data-preview-file-type="any">				    	
				        <BR>
				    </div>
				    <div class="form-group">
					<label for="other">Nombre de la nueva imagen:</label>
						<input type="text" name ="new_name" />
					</div>
					<div class="form-group">
						<label for="other">Intensidad dominante:</label>
						<input type="text" name ="dominante" />
					</div>
					<div class="form-group">
					<label for="other">Intensidad de espacio:</label>
						<input type="text" name ="space" />
					</div>								
						<td><input type="submit" form="form1" value="Resultado"></td>
				</form> 
		   </div>
		 </form>
	</body>
</html>