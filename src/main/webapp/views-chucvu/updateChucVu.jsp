<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/21/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin chức vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<h3 class="text-center m-3 text-danger">Sửa thông tin chức vụ</h3>
<form class="container" method="post" action="/chuc-vu/update?id=${chucVu.id}">
    <div class="input-group mb-3">
        <span class="input-group-text">Mã:</span>
        <input type="text" class="form-control" name="ma" value="${chucVu.ma}">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Tên:</span>
        <input type="text" class="form-control" name="ten" value="${chucVu.ten}">
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-warning">Update</button>
    </div>
</form>
</body>
</html>
