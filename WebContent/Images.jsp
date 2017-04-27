<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <body>
        <div class="container">
            <h1>Procesador de imágenes</h1>
            <form enctype="multipart/form-data">
                <div class="form-group">
                    <input id="file-1" type="file" class="file" multiple=true name="file1" data-preview-file-type="any">
                </div>

                <div class="form-group">
                    <input id="file-3" type="file" multiple=true name="file2">
                </div>
                <div class="form-group">
                    <button class="btn btn-primary">Submit</button>
                    <button class="btn btn-default" type="reset">Reset</button>
                </div>
            </form>
        </div>
    </body>
</html>