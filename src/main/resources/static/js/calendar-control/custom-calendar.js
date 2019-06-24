//日历ul列表点击样式
$(function () {
    $(".date-ul li").click(function () {
        $(".date-ul li").eq($(this).index()).addClass("active").siblings().removeClass("active");
    })
});
//日历ul功能
$(document).ready(function () {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var mon = myDate.getMonth() + 1;
    var beforeMon = myDate.getMonth();
    var date = myDate.getDate();
    var sevenDate = myDate.getDate() - 6;
    var yesterday = myDate.getDate() - 1;
    $("#AllDate").click(function () {
        $('#start_datetime_input').val("2018-1-1");
        $('#end_datetime_input').val(year + "-" + mon + "-" + date);
        console.log($('#end_datetime_input').val(year + "-" + mon + "-" + date));
    });
    $("#InThirtyDays").click(function () {
        $('#start_datetime_input').val(year + "-" + beforeMon + "-" + date);
        $('#end_datetime_input').val(year + "-" + mon + "-" + date);
    });
    $("#InSevenDays").click(function () {
        $('#start_datetime_input').val(year + "-" + mon + "-" + sevenDate);
        $('#end_datetime_input').val(year + "-" + mon + "-" + date);
    });
    $("#Yesterday").click(function () {
        $('#start_datetime_input').val(year + "-" + mon + "-" + yesterday);
        $('#end_datetime_input').val(year + "-" + mon + "-" + date);
    });
    $("#Today").click(function () {
        $('#start_datetime_input').val(year + "-" + mon + "-" + date);
        $('#end_datetime_input').val(year + "-" + mon + "-" + date);
    });
});
//日历面板区域控制
$(document).ready(function () {
    $("#date-hideShow,#cancel-button1").click(function () {
        $("#date-content").slideToggle("slow");
    })
});
//日历控件
$('.form_datetime').datetimepicker({
    weekStart: 1,
    todayBtn: 1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1,
    language: 'zh-CN',
    format: 'yyyy-mm-dd',
    minView: 2
});
//
$('#start_datetime').datetimepicker().on('show', function () {
    const endTime = $('#end_datetime_input').val();
    if (endTime !== '') {
        $(this).datetimepicker('setEndDate', endTime);
    } else {
        $(this).datetimepicker('setEndDate', null);
    }
});

$('#end_datetime').datetimepicker().on('show', function () {
    const startTime = $('#start_datetime_input').val();

    if (startTime !== '') {
        $(this).datetimepicker('setStartDate', startTime);
    } else {
        $(this).datetimepicker('setStartDate', null);
    }
});
