<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 12/3/2023
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <style>
        .navbar{
            position: relative;
            position: fixed;
        }
        .nav:hover {
            text-decoration: underline;
        }
        .nav-link {
            margin-left: 15px;
            font-size: 18px;
        }
        .gh{
            color: black;
            position: relative;
            display: flex;
            align-items: center;
            justify-content: center;
            width: 65px;
            font-size: 25px;
            margin-left: 15px;
        }
        .user{
            color: black;
            position: relative;
            display: flex;
            align-items: center;
            justify-content: center;
            width: 65px;
            font-size: 25px;
            margin-left: 10px;
            margin-right: 10px;
        }
        .sl {
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 14px;
            text-align: center;
            background-color: red;
            width: 18px;
            height: 18px;
            position: absolute;
            font-weight: 500;
            color: white;
            left: 23px;
            top: -1px;
            border-radius: 100%;
        }
        .tenUser{
            position: absolute;
            font-size: 15px;
            right: 8px;
            top: 64px;
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand ms-5" href="/store/trang-chu">
                <img src="/img/logoSh.jpg" style="width: 130px; height: 45px">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item nav">
                        <a class="nav-link active fw-bold" aria-current="page" href="/store/trang-chu" >Trang chủ</a>
                    </li>
                    <li class="nav-item nav">
                        <a class="nav-link active fw-bold" aria-current="page" href="#">Giới thiệu</a>
                    </li>
                    <li class="nav-item nav">
                        <a class="nav-link active fw-bold" aria-current="page" href="#">Liên hệ</a>
                    </li>
                    <li class="nav-item nav">
                        <a class="nav-link active fw-bold" aria-current="page" href="/store/lich-su-mua-hang">Lịch sử mua hàng</a>
                    </li>
                </ul>
                <form class="d-flex mt-3">
                    <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-secondary" type="submit"><i class="bi bi-search"></i></button>
                    <a class="gh" href="/store/gio-hang"><i class="bi bi-cart-check"></i>
                        <div class="sl">${soLuongGH}</div>
                    </a>
                    <div class="user" style="margin-right: 30px">
                        <div class="dropdown">
                            <a class="dropdown-toggle user" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="bi bi-person"></i>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="/store/dang-nhap">Đăng nhập</a></li>
                                <li><a class="dropdown-item" href="/store/dang-ky">Đăng ký</a></li>
                                <li><a class="dropdown-item" href="/store/dang-xuat">Đăng xuất</a></li>
                            </ul>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <p class="tenUser"> Xin chào: ${khachHang.ten} </p>
    </nav>
</header>

<main style="margin-top: 100px">
    <form id="myForm" method="post" action="/store/thanh-toan">
    <div class="container">
        <div class="row">
            <div class="col-12 col-sm-7" style="width: 58%; height: 580px; overflow-x: auto">
                <table class="table text-center" style="width: 100%; border-collapse: collapse">
                    <tr>
                        <th>#</th>
                        <th>#</th>
                        <th>Tên sản phẩm</th>
                        <th>Màu sắc</th>
                        <th>Size</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Xóa sản phẩm</th>
                    </tr>
                    <c:forEach varStatus="i" items="${listGHCT}" var="ghct">
                        <tr class="sp">
                            <th>
                                <a href="/store/chon-san-pham?idCTSP=${ghct.idCTSP}"><input class="form-check-input" type="checkbox" value=""></a>
                            </th>
                            <th><img style="width: 100px; height: 70px" src="${ghct.img}"></th>
                            <td>${ghct.tenSP}</td>
                            <td>${ghct.tenMS}</td>
                            <td>${ghct.size}</td>
                            <td>${ghct.soLuong}</td>
                            <td><fmt:formatNumber value="${ghct.donGia}" pattern="#,##0.##"/> vnd</td>
                            <td>
                                <a href="/store/xoa-san-pham?idCTSP=${ghct.idCTSP}"><i class="bi bi-x-circle-fill"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-12 col-sm-5">
                <h3 class="text-center text-danger fw-bold mt-2" style="font-family: 'Noto Sans'">Thông tin thanh toán</h3>
                <div class="row mt-3">
                    <div class="col">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Tên khách hàng:</span>
                            <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
                        </div>
                    </div>
                    <div class="col">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Số điện thoại:</span>
                            <input type="text" class="form-control" name="sdt" value="${khachHang.sdt}">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Địa chỉ:</span>
                            <input type="text" class="form-control" name="diachi" value="${khachHang.diaChi} ${khachHang.thanhPho}">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="input-group">
                            <span class="input-group-text">Giao tới địa chỉ khác:</span>
                            <textarea class="form-control" aria-label="With textarea" placeholder="Địa chỉ khác"></textarea>
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <h4 >Giao hàng:</h4>
                    <div class="col">
                        <div class="input-group1">
                            <div class="form-check1">
                                <input class="form-check-input" type="radio" typeof="submit" name="flexRadioDefault" id="giaoHangNhanh">
                                <label class="form-check-label" for="giaoHangNhanh">
                                    Giao hàng nhanh trong ngày
                                </label>
                            </div>
                            <div class="form-check1 mt-2">
                                <input class="form-check-input" type="radio" typeof="submit" name="flexRadioDefault" id="giaoHangTieuChuan" checked>
                                <label class="form-check-label" for="giaoHangTieuChuan">
                                    Giao hàng tiêu chuẩn(3-5 ngày)
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="col text-center">
                            <div class="form-check">
                                <label class="form-check-label">
                                    65.000 vnd
                                </label>
                            </div>
                            <br>
                            <div class="form-check" style="margin-top: -17px">
                                <label class="form-check-label">
                                    40.000 vnd
                                </label>
                            </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <h4>Phương thức thanh toán</h4>
                    <div class="col">
                        <div class="input-group2">
                            <div class="form-check2">
                                <input class="form-check-input" type="radio" name="thanhToan" id="thanhToanKhiNhanHang" checked>
                                <label class="form-check-label" for="thanhToanKhiNhanHang">
                                    Thanh toán khi nhận hàng
                                </label>
                            </div>
                            <div class="form-check2 mt-2">
                                <input class="form-check-input" type="radio" name="thanhToan" id="chuyenKhoan">
                                <label class="form-check-label" for="chuyenKhoan">
                                    Chuyển khoản ngân hàng
                                </label>
                            </div>
                            <div class="form-check2 mt-2">
                                <input class="form-check-input" type="radio" name="thanhToan" id="viMoMo">
                                <label class="form-check-label" for="viMoMo">
                                    Thanh toán qua ví momo
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row mt-2" style="border-top: 1px solid darkgrey; border-bottom: 1px solid darkgrey; padding: 6px">
                    <div class="col">
                        <h4>Tổng tiền: </h4>
                    </div>
                    <div class="col text-center">
                        <h5 style="margin-top: 5px">${tongTien} vnd</h5>
                    </div>
                </div>

                <div class="text-center mt-2">
                    <button type="submit" style="width: 100%; border-radius: 0%" class="btn btn-danger">Thanh toán ngay</button>
                </div>

            </div>
        </div>
    </div>
    </form>
</main>

<footer style="background-color: black; color: white; margin-top: 50px" >
    <a href=""><button class="btn btn-secondary" style="width: 100%; border-radius: 0px">Lên đầu trang</button></a>
    <div class="row mt-3 mb-3">
        <div class="col ms-5">
            <h5>Về V&Store</h5>
            V&Store lần đầu tiên xuất hiện tại thành phố đáng sống Hà Nội vào năm 2023
            với mục đích chia sẽ và phát triển niềm đam mê với nền văn hóa "sát mặt đất".
            Cùng những founder và dàn staff đều là những người có cùng sở thích và tình yêu đối với "bộ môn" này,
            tụi mình đã và đang cố gắng từng ngày để có thể giúp cộng đồng này càng ngày càng lớn mạnh hơn.
            Rất mong sẽ nhận được sự ủng hộ nhiệt tình từ các bạn !
        </div>
        <div class="col ms-4">
            <h5>Địa chỉ cửa hàng</h5>
            <strong>Cơ sở 1: </strong> 345 Hoàng Quốc Việt Hà Nội <br>
            <strong>Cơ sở 2: </strong> 33 Trường Chinh TPHCM
        </div>
        <div class="col me-4">
            <h5>Hỗ trợ khách hàng</h5>
            <a href="">- Chính sách đổi trả</a> <br>
            <a href="">- Chính sách bảo mật</a> <br>
            <a href="">- Điều khoản dịch vụ</a> <br>
            <a href="">- Liên hệ</a>
        </div>
        <div class="col me-5">
            <h5>Chăm sóc khách hàng</h5>
            <strong>Số điện thoại: </strong>0999999999 <br>
            <strong>Email: </strong> v&store@gmail.com <br>

            <h5 class="mt-3">Theo dõi tôi</h5>
            <i class="bi bi-facebook ms-2"></i>
            <i class="bi bi-instagram ms-2"></i>
            <i class="bi bi-tiktok ms-2"></i>
        </div>
    </div>
</footer>
</body>
<script>
    document.getElementById("myForm").addEventListener("submit", function (evt){
        alert("Thanh toán thành công");
    })
</script>
</html>
