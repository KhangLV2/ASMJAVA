<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/23/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center m-3 text-danger">Sửa thông tin chi tiết sản phẩm</h3>
<form method="post" action="/chi-tiet-sp/update?id=${chiTietSP.id}">
    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Dòng sản phẩm:</span>
                <select class="form-select" aria-label="Default select example" name="idDongSP">
                        <c:forEach items="${listDongSP}" var="dongSP">
                            <option value="${dongSP.id}"
                                    <c:if test="${chiTietSP.idDongSP.id == dongSP.id}"> selected</c:if>> ${dongSP.ten}
                            </option>
                        </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mô tả:</span>
                <input type="text" class="form-control" name="moTa" value="${chiTietSP.moTa}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Sản phẩm:</span>
                <select class="form-select" aria-label="Default select example" name="idSanPham">
                    <c:forEach items="${listSanPham}" var="sanPham">
                        <option value="${sanPham.id}"
                            <c:if test="${chiTietSP.idSP.id == sanPham.id}">selected</c:if>> ${sanPham.ten}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Số lượng:</span>
                <input type="number" class="form-control" name="soLuong" value="${chiTietSP.soLuongTon}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Màu sắc:</span>
                <select class="form-select" aria-label="Default select example" name="idMauSac">
                    <c:forEach items="${listMauSac}" var="mauSac">
                        <option value="${mauSac.id}"
                            <c:if test="${chiTietSP.idMauSac.id == mauSac.id}"> selected</c:if>> ${mauSac.ten}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Giá nhập:</span>
                <input type="text" class="form-control" name="giaNhap" value="${chiTietSP.giaNhap}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Nơi sản xuất:</span>
                <select class="form-select" aria-label="Default select example" name="idNsx">
                    <c:forEach items="${listNsx}" var="nsx">
                        <option value="${nsx.id}"
                            <c:if test="${chiTietSP.idNsx.id == nsx.id}"> selected</c:if>> ${nsx.ten}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Giá bán:</span>
                <input type="text" class="form-control" name="giaBan" value="${chiTietSP.giaBan}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Năm bảo hành:</span>
                <input type="number" class="form-control" name="namBH" value="${chiTietSP.namBH}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Size:</span>
                <input type="number" class="form-control" name="size" value="${chiTietSP.size}" required>
            </div>
        </div>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-warning">Update</button>
    </div>
</form>
</body>
</html>
