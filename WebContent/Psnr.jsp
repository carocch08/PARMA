<%@ page import="clases.BilateralFilter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PSNR</title>
</head>
	<body>
		<form enctype="multipart/form-data" action="PsnrServlet">
	    	<div class="form-group">
	        	<input id="file-1" type="file" class="file" multiple=true name="file1" data-preview-file-type="any">
	        	<BR>
	        </div>
			<div class="form-group">
				<BR>
				<input id="file-3" type="file" multiple=true name="file2">
	        </div>
	        <div class="form-group">
	        	<BR>
	        	<button class="btn btn-primary">Resultado</button>
	        </div>
		</form>
	</body>
</html>