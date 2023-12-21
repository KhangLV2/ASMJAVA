<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/23/2023
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa thông tin nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center m-3 text-danger">Thêm nhân viên</h3>
<form method="post" action="/nhan-vien/update?id=${nhanVien.id}">
    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã:</span>
                <input type="text" class="form-control" name="ma" value="${nhanVien.ma}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Địa chỉ:</span>
                <input type="text" class="form-control" name="diaChi" value="${nhanVien.diaChi}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Tên:</span>
                <input type="text" class="form-control" name="ten" value="${nhanVien.ten}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Số điện thoại:</span>
                <input type="text" class="form-control" name="sdt" value="${nhanVien.sdt}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Tên đệm:</span>
                <input type="text" class="form-control" name="tenDem" value="${nhanVien.tenDem}">
            </div>
        </div>
        <div class="col">
            <div class="input-group mb-3">
                <span class="input-group-text">Mật khẩu:</span>
                <input type="text" class="form-control" name="matKhau" value="${nhanVien.matKhau}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Họ:</span>
                <input type="text" class="form-control" name="ho" value="${nhanVien.ho}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Cửa hàng:</span>
                <select class="form-select" aria-label="Default select example" name="idCH">
                    <c:forEach items="${listCuaHang}" var="cuaHang">
                        <option value="${cuaHang.id}"
                            <c:if test="${nhanVien.idCH == cuaHang.id}"> selected</c:if>
                        >${cuaHang.ten} - ${cuaHang.thanhPho}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Giới tính:</span>
                <div class="form-check form-check-inline ms-2 mt-2">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1"
                                <c:if test="${nhanVien.gioiTinh == 'Nam'}">checked</c:if>
                           value="Nam">
                    <label class="form-check-label" for="inlineRadio1">Nam</label>
                </div>
                <div class="form-check form-check-inline mt-2">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2"
                                <c:if test="${nhanVien.gioiTinh == 'Nữ'}">checked</c:if>
                           value="Nữ">
                    <label class="form-check-label" for="inlineRadio2">Nữ</label>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Chức vụ:</span>
                <select class="form-select" aria-label="Default select example" name="idCV">
                    <c:forEach items="${listChucVu}" var="chucVu">
                        <option value="${chucVu.id}"
                            <c:if test="${nhanVien.idCV == chucVu.id}">selected</c:if>
                        >${chucVu.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Ngày sinh:</span>
                <input type="date" class="form-control" name="ngaySinh" value="${nhanVien.ngaySinh}">
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Trạng thái:</span>
                <input type="number" class="form-control" name="trangThai" value="${nhanVien.trangThai}">
            </div>
        </div>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-warning">Update</button>
    </div>
</form>
</body>
</html>
