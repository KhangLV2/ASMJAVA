<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 11/22/2023
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách nơi sản xuất</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container">
<h3 class="text-center m-3 text-danger">Thêm nơi sản xuất</h3>
<form method="post" action="/nsx/add">
    <div class="input-group mb-3">
        <span class="input-group-text">Mã:</span>
        <input type="text" class="form-control" name="ma" required>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Tên:</span>
        <input type="text" class="form-control" name="ten" required>
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-success">Add</button>
    </div>
</form>

<h3 class="text-center m-3 text-danger">Danh sách nơi sản xuất</h3>
<table class="table container">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${listNSX}" var="nsx">
        <tr>
            <th>${i.index + 1}</th>
            <td>${nsx.ma}</td>
            <td>${nsx.ten}</td>
            <td>
                <a href="/nsx/detail?id=${nsx.id}"><button class="btn btn-primary">Detail</button></a>
                <a href="/nsx/delete?id=${nsx.id}"><button class="btn btn-danger">Delete</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
