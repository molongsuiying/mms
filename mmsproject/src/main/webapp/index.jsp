<%--
  Created by IntelliJ IDEA.
  User: 2447115985
  Date: 2022/1/8
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Gathering Log In form Responsive Widget Template :: W3layouts</title>
    <!-- Meta tag Keywords -->
<%--    <base href="${pageContext.request.contextPath}/">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <base href="${pageContext.request.contextPath}/">
    <!-- //Meta tag Keywords -->
    <link href="//fonts.googleapis.com/css2?family=Kumbh+Sans:wght@300;400;700&display=swap" rel="stylesheet">
    <!--/Style-CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!--//Style-CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all">
    <script type="text/javascript" src="js/JQuery.js"></script>
    <script type="text/javascript">
        $(function (){
            console.log(123)
            $("#code").bind("click",function(){
                $(this).attr("src","/a/login/codeTwo?n="+new Date());
            })
        });
    </script>
</head>
<body>
<div class="w3l-signinform">
    <!-- container -->
    <div class="wrapper">
        <!-- main content -->
        <div class="w3l-form-info">
            <div class="w3_info">
                <h1>Welcome Back</h1>
                <p class="sub-para">Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
                <h2>Log In</h2>
                <form action="/a/login/login" method="post">
                    <div class="input-group">
                        <span><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input id="username" type="text" name="username" placeholder="Username" >
                    </div>
                    <div class="input-group two-groop">
                        <span><i class="fa fa-key" aria-hidden="true"></i></span>
                        <input id="pwd" type="Password" name="pwd" placeholder="Password" >
                    </div>
                    <div class="input-group three-groop">
                        <span><i class="fa fa-key" aria-hidden="true"></i></span>
                        <input id="code1" type="text1" name="code1" placeholder="Code">
                        <img style="cursor: pointer" id="code" src="/a/login/codeTwo">
                    </div>
                    <div class="form-row bottom">
                        <div class="form-check">
                            <input type="checkbox" id="remenber" name="remenber" value="remenber">
                            <label for="remenber"> Remember me?</label>
                        </div>
                        <a href="#url" class="forgot">Forgot password?</a>
                    </div>
                    <button class="btn btn-primary btn-block" type="submit">Log In</button>
                </form>

                <p class="account">Don't have an account? <a href="#register">Register</a></p>
                <span style="color: red">${user}</span>
            </div>
        </div>
        <!-- //main content -->
    </div>
    <!-- //container -->
    <!-- footer -->
    <div class="footer">
        <p>&copy; 2021 Gathering Log In form. All Rights Reserved | Design by <a href="https://w3layouts.com/"
                                                                                 target="blank">W3layouts</a></p>
    </div>
    <!-- footer -->
</div>

</body>
<script>
    // $("#code").bind("click",function () {
    //     console.log("123")
    //     $(this).attr("src","/a/loginOne/code?n="+new Date())
    // })
</script>
</html>
