<%@ page import="java.sql.DataTruncation" %><%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/24/2023
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
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
        .w-100 {
            width: 100%;
            height: 500px;
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


    <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel" style="margin-top: 10px">
        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="10000">
                <img src="/img/head1.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="/img/head5.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="/img/head3.webp" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="/img/head4.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</header>

<main style="margin-top: 30px; margin-bottom: 30px">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <div class="row">
                    <div class="col">
                        <h5 style="color: gray; margin-top: 20px">Tìm kiếm theo</h5>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="dropdown" style="margin-top: 20px">
                            <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenu1" data-bs-toggle="dropdown" aria-expanded="false">
                                Thương hiệu
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><button class="dropdown-item" type="button">Nike</button></li>
                                <li><button class="dropdown-item" type="button">Adidas</button></li>
                                <li><button class="dropdown-item" type="button">Jordan</button></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="dropdown" style="margin-top: 20px">
                            <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
                                Size
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <li><button class="dropdown-item" type="button">37</button></li>
                                <li><button class="dropdown-item" type="button">38</button></li>
                                <li><button class="dropdown-item" type="button">39</button></li>
                                <li><button class="dropdown-item" type="button">40</button></li>
                                <li><button class="dropdown-item" type="button">41</button></li>
                                <li><button class="dropdown-item" type="button">42</button></li>
                                <li><button class="dropdown-item" type="button">43</button></li>
                                <li><button class="dropdown-item" type="button">44</button></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-10 bg-light">
                <div class="row">
                <c:forEach varStatus="i" items="${listSPL}" var="sanPhamL">
                    <div class="col-md-4">
                        <div class="thumbnail" style="text-align: center; text-decoration: none">
                            <a href="/store/detail-ctsp?idSP=${sanPhamL.id}" style="text-decoration: none">
                                <img src="${sanPhamL.img}" alt="Lights" style="width: 95%; height: 300px; border: 1px solid gray">
                                <div class="caption">
                                    <p style="font-size: 19px; color: black; margin-top: 7px" >
                                        ${sanPhamL.tenSP}
                                    </p>
                                    <p style="font-size: 18px; color: red; margin-top: -10px">
                                            <fmt:formatNumber value="${sanPhamL.giaBan}" pattern="#,##0.##"/> vnd
                                    </p>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>

<footer style="background-color: black; color: white" >
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
</html>
