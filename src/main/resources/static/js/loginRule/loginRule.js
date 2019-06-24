//登录规则
function validator() {
    /**
     * 下面是进行插件初始化
     * 你只需传入相应的键值对
     * */
    $('#loginForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            /*输入框不同状态，显示图片的样式*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            /*验证*/
            username: {
                /*键名username和input name值对应*/
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        /*非空提示*/
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        /*长度提示*/
                        min: 4,
                        max: 30,
                        message: '用户名长度必须在4到30之间'
                    },
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 30,
                        message: '密码长度必须在3到30之间'
                    },
                    // /*有6字符以上才发送ajax请求*/
                    // threshold: 3,
                    // remote: {
                    //     url: "login/checkLogin",
                    //     data: {username: $("#username").val(), password: $("#password").val()},
                    //     message: '用户名或密码错误',
                    // }
                }
            }
        }
    });
}

//后台验证密码
function checkLogin() {
    //先判断是否进行了bootstrapvalidator的验证
    validator();
    var bootstrapValidator = $("#loginForm").data('bootstrapValidator');
    bootstrapValidator.validate();
    if (bootstrapValidator.isValid()) {
        $.ajax({
            type: "POST",
            url: "login/checkLogin",
            data: {
                username: $("#username").val(),
                password: $("#password").val(),
            },
            async: false,
            success: function (data) {
                if (data.code == 200) {
                    $.cookie('ssid', data.cookieId);
                    window.alert("登录成功");
                    window.location.href = "/index";
                } else {
                    window.alert("用户名或密码错误,请重新登录");
                }
            }
        });
    }
}