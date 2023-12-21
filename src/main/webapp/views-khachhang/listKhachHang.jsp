<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/22/2023
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">

<h3 class="text-center m-3 text-danger">Thêm khách hàng</h3>
<form class="container" method="post" action="/khach-hang/add">
    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã:</span>
                <input type="text" class="form-control" name="ma" required>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Số điện thoại:</span>
                <input type="text" class="form-control" name="sdt" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Tên:</span>
                <input type="text" class="form-control" name="ten" required>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Địa chỉ:</span>
                <input type="text" class="form-control" name="diaChi" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Tên đệm:</span>
                <input type="text" class="form-control" name="tenDem" required>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Thành phố:</span>
                <input type="text" class="form-control" name="thanhPho" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Họ:</span>
                <input type="text" class="form-control" name="ho" required>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Quốc gia:</span>
                <input type="text" class="form-control" name="quocGia" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Ngày sinh:</span>
                <input type="date" class="form-control" name="ngaySinh" required>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mật khẩu:</span>
                <input type="text" class="form-control" name="matKhau" required>
            </div>
        </div>
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-success">Add</button>
    </div>
</form>

<h3 class="text-center m-3 text-danger">Danh sách khách hàng</h3>
<table class="table container">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Họ tên</th>
        <th>Ngày sinh</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
        <th>Mật khẩu</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${listKhachHang}" var="khachHang">
        <tr>
            <th>${i.index + 1}</th>
            <td>${khachHang.ma}</td>
            <td>${khachHang.ho} ${khachHang.tenDem} ${khachHang.ten}</td>
            <td><fmt:formatDate value="${khachHang.ngaySinh}" pattern="dd/MM/yyyy"/></td>
            <td>${khachHang.sdt}</td>
            <td>${khachHang.diaChi} - ${khachHang.thanhPho} - ${khachHang.quocGia}</td>
            <td>${khachHang.matKhau}</td>
            <td>
                <a href="/khach-hang/detail?id=${khachHang.id}"><button class="btn btn-primary">Detail</button></a>
                <a href="/khach-hang/delete?id=${khachHang.id}"><button class="btn btn-danger">Delete</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
