<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/29/2023
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        .card{
            width: 700px;
            margin: auto;
            margin-top: 30px;
            border-radius: 15px;
            box-shadow: 10px 10px 15px 15px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
<form method="post" action="/store/dang-ky">
    <div class="card">
        <div class="card-header text-center">
            <h3 style="font-family: 'Noto Sans'; font-weight: bolder">Đăng ký</h3>
        </div>
        <div class="card-body m-auto" style="width: 80%;">
            <div class="input-group mb-3">
                <span class="input-group-text">Tên tài khoản: </span>
                <input type="text" class="form-control" name="ma">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Họ tên: </span>
                <input type="text" class="form-control" name="ten">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Số điện thoại: </span>
                <input type="text" class="form-control" name="sdt">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Địa chỉ: </span>
                <input type="text" class="form-control" name="diaChi">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Thành phố: </span>
                <input type="text" class="form-control" name="thanhPho">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Mật khẩu: </span>
                <input type="text" class="form-control" name="matKhau">
            </div>
            <div class="text-center mt-4">
                <button type="submit" class="btn btn-primary" style="width: 100%; height: 45px">Đăng ký</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
