<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/22/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center m-3 text-danger">Thêm khách hàng</h3>
<form method="post" action="/khach-hang/update?id=${khachHang.id}">
    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã:</span>
                <input type="text" class="form-control" name="ma" value="${khachHang.ma}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Số điện thoại:</span>
                <input type="text" class="form-control" name="sdt" value="${khachHang.sdt}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Tên:</span>
                <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Địa chỉ:</span>
                <input type="text" class="form-control" name="diaChi" value="${khachHang.diaChi}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Tên đệm:</span>
                <input type="text" class="form-control" name="tenDem" value="${khachHang.tenDem}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Thành phố:</span>
                <input type="text" class="form-control" name="thanhPho" value="${khachHang.thanhPho}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Họ:</span>
                <input type="text" class="form-control" name="ho" value="${khachHang.ho}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Quốc gia:</span>
                <input type="text" class="form-control" name="quocGia" value="${khachHang.quocGia}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Ngày sinh:</span>
                <input type="date" class="form-control" name="ngaySinh" <fmt:formatDate value="${khachHang.ngaySinh}" pattern="dd/MM/yyyy"/>>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mật khẩu:</span>
                <input type="text" class="form-control" name="matKhau" value="${khachHang.matKhau}">
            </div>
        </div>
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-warning">Update</button>
    </div>
</form>
</body>
</html>
