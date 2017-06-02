<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>

<style type="text/css">
#upload-button{
border: 1px solid #DDD;
width: 100px;
height:80px;
margin: 20px auto;
background-repeat:no-repeat;
background-size: 100% 100%;
}
#upload-button input[type='file']{
width: 100%;
height: 100%;
opacity: 0;
}

body {background-image: url("background.jpg");
	color: white;
	font-family: Calibri;}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 25%;
    background-color: #f1f1f1;
    position: static;
    height: 100%;
    overflow: auto;
}

li a {
    display: block;
    color:rgb(144, 75, 61);
    padding: 8px 16px;
    text-decoration:  underline;
}

li a.active {
    background-color: #4CAF50;
    color: white;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}
</style>

<body>
	<ul>
	  <li><a href="Psnr.jsp">PSNR</a></li>
	  <li><a href="Convolution.jsp">Convolución</a></li>
	  <li><a href="Bilateral.jsp">Filtro Bilateral</a></li>
	  <li><a href="Gaussian.jsp">Filtro Gaussiano</a></li>	  
	  <li><a href="HistoEQ.jsp">Ecualizador de histogramas</a></li>	  
	</ul>
</body>
</html>