<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-07-01
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data" accept-charset="UTF-8" >
    <div>
        <input type="file" name="files" />
    </div>
    <div>
        <input type="file" name="files" />
    </div>
    <div>
        <input type="file" name="files" />
    </div>
    <div>
        <input type="file" name="files" />
    </div>
    <div>
        <input type="file" name="files" />
    </div>
    <div>
        <input type="submit" />
    </div>
</form>
</body>
</html>