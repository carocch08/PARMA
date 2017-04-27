<%@ page import="clases.BilateralFilter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Bilateral" >
		<table>
			<tr>
				<div class="form-group">
	        		<input id="file-1" type="file" class="file" multiple=true name="file1" data-preview-file-type="any">
	        		<BR>
	        	</div>
			</tr>
			<tr>
				<td>Dominante:</td>
				<td><input type="text" name ="dominante" /></td>
			</tr>
			<tr>
				<td>Espacio:</td>
				<td><input type="text" name ="space" /></td>
			</tr>
			<tr>
				<td><input type="submit" /></td>
			</tr>
		</table>		
	</form>    
    
</body>

</html>