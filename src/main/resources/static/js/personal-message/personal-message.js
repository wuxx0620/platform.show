$('#message-submit').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        /*输入框不同状态，显示图片的样式*/
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        company: {
            validators: {
                notEmpty: {
                    /*非空提示*/
                    message: '公司名称不能为空'
                },
                stringLength: {
                    /*长度提示*/
                    min: 1,
                    max: 20,
                    message: '公司名称长度必须在1到20之间'
                },
            }
        },
        name: {
            validators: {
                notEmpty: {
                    /*非空提示*/
                    message: '姓名不能为空'
                },
                regexp: {
                    regexp: /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/,
                    message: '请输入正确的姓名格式',
                },
                // stringLength: {
                //     /*长度提示*/
                //     min: 1,
                //     max: 20,
                //     message: '姓名长度必须在1到20之间'
                // },
            }
        },
        phone: {
            validators: {
                notEmpty: {
                    /*非空提示*/
                    message: '手机号不能为空'
                },
                regexp: {
                    regexp: /^1[34578]\d{9}$/,
                    message: '请输入正确的手机号码'
                },
                // stringLength: {
                //     /*长度提示*/
                //     min: 1,
                //     max: 11,
                //     message: '请输入11位手机号码'
                // },
            }
        },
        email: {
            validators: {
                notEmpty: {
                    /*非空提示*/
                    message: '邮箱不能为空'
                },
                regexp: {
                    regexp: /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/i,
                    message: '请输入正确的邮箱'
                },
                // stringLength: {
                //     /*长度提示*/
                //     min: 1,
                //     max: 20,
                //     message: '姓名长度必须在1到20之间'
                // },
            }
        },
    }
});