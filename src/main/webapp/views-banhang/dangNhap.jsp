<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/28/2023
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }
        body{
            width: 100%;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: white;
        }

        .container{
            width: 500px;
            padding: 60px 70px 100px 70px;
            background: #fff;
            border-radius: 10px;
            text-align: center;
            overflow: hidden;

            box-shadow: 10px 10px 15px 15px rgba(0,0,0,0.1);
        }

        .container header{
            font-size: 40px;
            font-weight: 600;
            justify-content: center;
            color: gray;
        }
        .container form{
            margin: 40px 0;
        }

        form input{
            display: block;
            justify-items: center;
            width: 100%;
            height: 100%;
            outline: 0;
            padding: 0 45px;
            font-size: 18px;
            background: none;
            caret-color: #5372F0;
            border-radius: 5px;
            border: 2px solid #5372f053;
            border-bottom-width: 2px;
            transition: all 0.2s ease;
        }
        form .field input:focus,
        form .field.valid input{
            border-color: #8749f2;

        }
        .field .input-area i{
            position: absolute;
            top: 50%;
            font-size: 18px;
            pointer-events: none;
            transform: translateY(-50%);
        }

        hr {
            border: 1px solid #ddd;
        }
        button {
            display: flex;
            align-items: center;
            justify-content: space-between;
            border-radius: 5px;
            cursor: pointer;
        }

    </style>
</head>
<body>
<div class="container">
    <header>Đăng nhập</header>
    <form id="myForm" method="post" action="/store/dang-nhap">
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Tên tài khoản" id="ma" name="ma">
        </div>
        <p class="text-danger" id="maErr"></p>
        <div class="input-group mb-3">
            <input type="password" class="form-control" placeholder="Mật khẩu" id="matKhau" name="matKhau">
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary" style="width: 100%; height: 45px">Đăng nhập</button>
        </div>
        <p class="text-danger" id="matKhauErr"></p>
    </form>
    <div>
        <p>Bạn chưa có tài khoản? <a href="/store/dang-ky">Đăng ký</a></p>
    </div>
</div>
</body>
<script>
    // document.getElementById("myForm").addEventListener("submit", function (evt){
    //     let ma = document.getElementById("ma").value;
    //     let matKhau = document.getElementById("matKhau").value;
    //     let maErr = document.getElementById("maErr")
    //     let matKhauErr = document.getElementById("matKhauErr")
    //     if(ma==""){
    //         maErr.textContent = " ( * ) Vui lòng nhập vào tên tài khoản!"
    //     }else {
    //         maErr.textContent = ""
    //     }
    //     if(matKhau==""){
    //         matKhauErr.textContent = " ( * ) Vui lòng nhập vào mật khẩu!"
    //     }else {
    //         matKhauErr.textContent = ""
    //     }
    // })
</script>
</html>
