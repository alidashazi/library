<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <!-- Loding font -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">

  <!-- Custom Styles -->
  <link rel="stylesheet" type="text/css" href="/css/styles.css">

  <title>Login</title>
</head>
<body>

<!-- Backgrounds -->

<div id="login-bg" class="container-fluid">

  <div class="bg-img"></div>
  <div class="bg-color"></div>
</div>

<!-- End Backgrounds -->

<div class="container" id="login">
  <div class="row justify-content-center">
    <div class="col-lg-8">
      <div class="login">

        <h1>登录</h1>
        <!-- Loging form -->
        <form action="/user/login" method="post">
            <input type="text" class="form-control" name="username" placeholder="username">
            <input type="password" class="form-control" name="password" placeholder="Password">
          <div class="radio">
            <input type="radio" name="type" value="user" checked="checked"/><span>用户</span>
            <input type="radio" name="type" value="admin" style="margin-left:10px;"/><span style="margin-left:30px;">管理员</span>
          </div>
          <div class="subBtn">
            <input type="submit" class="btn btn-lg btn-block btn-success" value="登录"/>
            <input type="reset"  class="btn btn-lg btn-block btn-success" value="重置"/>
          </div>
        </form>
        <!-- End Loging form -->

      </div>
    </div>
  </div>
</div>


<style>
  .copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
</body>
</html>