<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录 | 博客后台管理系统</title>
    <link href="/assets/images/favicon.ico" rel="icon">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.bootcss.com/jquery-confirm/2.5.1/jquery-confirm.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/nprogress/0.2.0/nprogress.min.css" rel="stylesheet">
    <link href="/assets/css/zhyd.core.css" rel="stylesheet">
</head>

<body class="login">
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static"
     data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="login_wrapper">
                    <div class="animate form login_form" style="position: relative;">
                        <section class="login_content">
                            <form action="/passport/signin" method="POST" id="login-form">
                                <h1>1登录管理系统</h1>
                                <#if message?exists>
                                    <div class="alert alert-danger" role="alert">
                                        ${message?if_exists}
                                    </div>
                                </#if>
                                <div>
                                    <input type="text" class="form-control" placeholder="请输入用户名" name="username" required=""/>
                                </div>
                                <div>
                                    <input type="password" class="form-control" placeholder="请输入密码" name="password" required=""/>
                                </div>
                                <#if enableKaptcha?exists && enableKaptcha>
                                    <div class="form-group col-xs-6" style="padding-left: 0px;">
                                        <img alt="点击获取验证码" id="img-kaptcha" src="/getKaptcha" style="cursor:pointer;height: 34px;width: 180px;">
                                    </div>
                                    <div class="form-group col-xs-6">
                                        <span><input type="text" class="form-control" placeholder="验证码" id="kaptcha" name="kaptcha"></span>
                                    </div>
                                </#if>
                                <div class="form-group" style="text-align : left">
                                    <label><input type="checkbox" id="rememberMe" name="rememberMe" style="width: 12px; height: 12px;margin-right: 5px;">记住我</label>
                                </div>
                                <div>
                                    <button type="button" class="btn btn-success btn-login" style="width: 100%;">登录</button>
                                </div>

                                <div class="clearfix"></div>

                                <div class="separator">
                                    <p class="change_link">没有账号? <a href="#signup" class="to_register"> 注册账号 </a></p>
                                    <div class="clearfix"></div>
                                    <div>
                                        <h1><i class="fa fa-coffee"></i> 博客后台管理系统</h1>
                                        <p>Copyright © 2018 zhrey.cn. All Rights Reserved. </p>
                                    </div>
                                </div>
                            </form>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/jquery-confirm/2.5.1/jquery-confirm.min.js" type="text/javascript"></script>
<script src="/assets/js/zyd.tool.js"></script>
<script>
    $("#modal").modal('show');
    $(".btn-login").click(function () {
        $.ajax({
            type: "POST",
            url: "/passport/signin",
            data: $("#login-form").serialize(),
            dataType: "json",
            success: function (json) {
                $.tool.ajaxSuccess(json);
                if (json.status === 200) {
                    window.location.href = "/";
                }else{
                    $("#img-kaptcha").attr("src", '/getKaptcha?time=' + new Date().getTime());
                }
            }
        });
    });
    $("#img-kaptcha").click(function () {
        $(this).attr("src", '/getKaptcha?time=' + new Date().getTime());
    });
    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode === 13) {
            $(".btn-login").click();
        }
    };
</script>
</html>
