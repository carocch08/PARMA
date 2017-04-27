<%@ page import="clases.BilateralFilter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
        <div class="container">
            <h1>Procesador de imágenes</h1>
            <form enctype="multipart/form-data">
                <div class="form-group">
                    <input id="file" type="file" class="file" multiple=true data-preview-file-type="any">
                    </p>
                    <input id="dominance" type="value" class="value" multiple=true data-preview-file-type="any">
                    <input id="space" type="value" class="value" multiple=true data-preview-file-type="any">                                        
					<% System.out.println("Hola"); out.println("Holis"); %>
                </div>
                <div class="form-group">
                    <input type="button" name="fetchdata" value="Aceptar" onclick="">
                    <button class="btn btn-default" type="reset">Reset</button>
                </div>
            </form>
        </div>
    </body>
</body>
<%

%>
</html>