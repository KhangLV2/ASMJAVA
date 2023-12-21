<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/23/2023
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center m-3 text-danger">Thêm nhân viên</h3>
<form method="post" action="/nhan-vien/add">
    <div class="row">
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã:</span>
                <input type="text" class="form-control" name="ma" required>
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
                <span class="input-group-text">Tên:</span>
                <input type="text" class="form-control" name="ten" required>
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
                <span class="input-group-text">Tên đệm:</span>
                <input type="text" class="form-control" name="tenDem" required>
            </div>
        </div>
        <div class="col">
            <div class="input-group mb-3">
                <span class="input-group-text">Mật khẩu:</span>
                <input type="text" class="form-control" name="matKhau" required>
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
                <span class="input-group-text">Cửa hàng:</span>
                <select class="form-select" aria-label="Default select example" name="idCH">
                    <c:forEach items="${listCuaHang}" var="cuaHang">
                        <option value="${cuaHang.id}">${cuaHang.ten} - ${cuaHang.thanhPho}</option>
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
                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1" value="Nam" required>
                    <label class="form-check-label" for="inlineRadio1">Nam</label>
                </div>
                <div class="form-check form-check-inline mt-2">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2" value="Nữ" required>
                    <label class="form-check-label" for="inlineRadio2">Nữ</label>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6">
            <div class="input-group mb-3">
                <span class="input-group-text">Chức vụ:</span>
                <select class="form-select" aria-label="Default select example" name="idCV">
                    <c:forEach items="${listChucVu}" var="chucVu">
                        <option value="${chucVu.id}">${chucVu.ten}</option>
                    </c:forEach>
                </select>
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
                <span class="input-group-text">Trạng thái:</span>
                <input type="number" class="form-control" name="trangThai" required>
            </div>
        </div>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-success">Add</button>
    </div>
</form>

<h3 class="text-center m-3 text-danger">Danh sách nhân viên</h3>
<table class="table container">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Họ tên</th>
        <th>Giới tính</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>SDT</th>
        <th>Cửa hàng</th>
        <th>Chức vụ</th>
        <th>Mật khẩu</th>
        <th>Trạng thái</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${listNhanVien}" var="nhanVien">
        <tr>
            <th>${i.index}</th>
            <td>${nhanVien.ma}</td>
            <td>${nhanVien.ho} ${nhanVien.tenDem} ${nhanVien.ten}</td>
            <td>${nhanVien.gioiTinh}</td>
            <td> <fmt:formatDate value="${nhanVien.ngaySinh}" pattern="dd/MM/yyyy"></fmt:formatDate> </td>
            <td>${nhanVien.diaChi}</td>
            <td>${nhanVien.sdt}</td>
            <td>${nhanVien.idCH.ten} ${nhanVien.idCH.thanhPho}</td>
            <td>${nhanVien.idCV.ten}</td>
            <td>${nhanVien.matKhau}</td>
            <td>${nhanVien.trangThai == 0 ? "Đang làm việc" : "Đã nghỉ việc"}</td>
            <td>
                <a href="/nhan-vien/detail?id=${nhanVien.id}"><button class="btn btn-primary">Detail</button></a>
                <a href="/nhan-vien/delete?id=${nhanVien.id}"><button class="btn btn-danger">Delete</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
