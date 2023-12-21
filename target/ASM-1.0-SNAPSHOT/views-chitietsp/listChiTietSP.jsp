<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/23/2023
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center m-3 text-danger">Thêm chi tiết sản phẩm</h3>
<form method="post" action="/chi-tiet-sp/add">
    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Dòng sản phẩm:</span>
                <select class="form-select" aria-label="Default select example" name="idDongSP">
                    <c:forEach items="${listDongSP}" var="dongSP">
                        <option value="${dongSP.id}">${dongSP.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mô tả:</span>
                <input type="text" class="form-control" name="moTa" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Sản phẩm:</span>
                <select class="form-select" aria-label="Default select example" name="idSanPham">
                    <c:forEach items="${listSanPham}" var="sanPham">
                        <option value="${sanPham.id}">${sanPham.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Số lượng:</span>
                <input type="number" class="form-control" name="soLuong" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Màu sắc:</span>
                <select class="form-select" aria-label="Default select example" name="idMauSac">
                    <c:forEach items="${listMauSac}" var="mauSac">
                        <option value="${mauSac.id}">${mauSac.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Giá nhập:</span>
                <input type="text" class="form-control" name="giaNhap" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Nơi sản xuất:</span>
                <select class="form-select" aria-label="Default select example" name="idNsx">
                    <c:forEach items="${listNsx}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Giá bán:</span>
                <input type="text" class="form-control" name="giaBan" required>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Năm bảo hành:</span>
                <input type="number" class="form-control" name="namBH" required>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Size:</span>
                <input type="number" class="form-control" name="size" required>
            </div>
        </div>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-success">Add</button>
    </div>
</form>

<h3 class="text-center m-3 text-danger">Danh sách chi tiết sản phẩm</h3>
<table class="table container">
    <thead>
    <tr>
        <th>STT</th>
        <th>Dòng sản phẩm</th>
        <th>Sản phẩm</th>
        <th>Màu sắc</th>
        <th>Nơi sản xuất</th>
        <th>Năm bảo hành</th>
        <th>Mô tả</th>
        <th>Số lượng</th>
        <th>Size</th>
        <th>Giá nhập</th>
        <th>Giá bán</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${listChiTietSP}" var="chiTietSP">
        <tr>
            <th>${i.index}</th>
            <td>${chiTietSP.idDongSP.ten}</td>
            <td>${chiTietSP.idSP.ten}</td>
            <td>${chiTietSP.idMauSac.ten}</td>
            <td>${chiTietSP.idNsx.ten}</td>
            <td>${chiTietSP.namBH}</td>
            <td>${chiTietSP.moTa}</td>
            <td>${chiTietSP.soLuongTon}</td>
            <td>${chiTietSP.size}</td>
            <td>${chiTietSP.giaNhap}</td>
            <td>${chiTietSP.giaBan}</td>
            <td>
                <a href="/chi-tiet-sp/detail?id=${chiTietSP.id}"><button class="btn btn-primary">Detail</button></a>
                <a href="/chi-tiet-sp/delete?id=${chiTietSP.id}"><button class="btn btn-danger">Delete</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
