<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MSE y PSNR</title>
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
		width: 400px;
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
	 <form enctype="multipart/form-data" action="PsnrServlet">
	 	<div class="general">
	            <h1>Procesador de imágenes</h1>
	            <form enctype="multipart/form-data">
	            	<label for="fname">Seleccione la imagen 1:</label>
	                <div class="form-group">
	                    <input id="file-1" type="file" class="file" multiple=true name="file1" data-preview-file-type="any">
	                </div>
	                <label for="fname">Seleccione la imagen 2:</label>
	                <div class="form-group">
	                    <input id="file-3" type="file" multiple=true name="file2">
	                </div>
	                <div class="form-group">
	                    <button class="btn btn-primary">Resultado</button>
	                    <button class="btn btn-default" type="reset" style="margin-left: 25%;">Reset</button>
	                </div>
	            </form>
	        </div>
	   </form>
    </body>
</html>