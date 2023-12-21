<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/22/2023
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin cửa hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center m-3 text-danger">Sửa thông tin cửa hàng cửa hàng</h3>
<form method="post" action="/cua-hang/update?id=${cuaHang.id}">
    <div class="input-group mb-3">
        <span class="input-group-text">Mã:</span>
        <input type="text" class="form-control" name="ma" value="${cuaHang.ma}">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Tên:</span>
        <input type="text" class="form-control" name="ten" value="${cuaHang.ten}">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Địa chỉ:</span>
        <input type="text" class="form-control" name="diaChi" value="${cuaHang.diaChi}">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Thành phố:</span>
        <input type="text" class="form-control" name="thanhPho" value="${cuaHang.thanhPho}">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Quốc gia:</span>
        <input type="text" class="form-control" name="quocGia" value="${cuaHang.quocGia}">
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-warning">Update</button>
    </div>
</form>
</body>
</html>
