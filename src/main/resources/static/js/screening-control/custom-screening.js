//筛选面板控制
$(document).ready(function () {
    $("#screening-hideShow,#cancel-button").click(function () {
        $(".screening-none-area").slideToggle("slow");
    })
});
//年级按钮控制隐藏区域
$(function () {
    $('.choose-label.choose-label-nj').click(function () {
        if ($("#male").is(':checked') == false) {
            $('.screening-none-area .nj-area').show()
        } else {
            $('.screening-none-area .nj-area').hide()
        }
    });
});
//学科按钮控制隐藏区域
$('.choose-label.choose-label-xk').click(function () {
    if ($("#male1").is(':checked') == false) {
        // $('.xk .selected-ul').show();
        $('.screening-none-area .xk-area').show()
    } else {
        // $('.xk .selected-ul').hide();
        $('.screening-none-area .xk-area').hide()
    }
});

//循环取消函数
function removeRepeatArr(arr) {
    for (var i = 0; i < arr.length - 1; i++) {
        for (var j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                arr.splice(j, 1);
                j--;
            }
        }
    }
    return arr;
}

//小学隐藏区域控制
var start = true;
$('.nj-area .nj-area-ul .nj-area-li').eq(0).click(function () {
    if (start) {
        start = false;
        $('.nj-area .nj-area-ul .xx-area').eq(0).slideDown();
    } else {
        start = true;
        $('.nj-area .nj-area-ul .xx-area').eq(0).slideUp();
    }
});
//初中隐藏区域控制
var start1 = true;
$('.nj-area .nj-area-ul .nj-area-li').eq(1).click(function () {
    if (start1) {
        start1 = false;
        $('.nj-area .nj-area-ul .xx-area').eq(1).slideDown();
    } else {
        start1 = true;
        $('.nj-area .nj-area-ul .xx-area').eq(1).slideUp();
    }
});
//高中隐藏区域控制
var start2 = true;
$('.nj-area .nj-area-ul .nj-area-li').eq(2).click(function () {
    if (start2) {
        start2 = false;
        $('.nj-area .nj-area-ul .xx-area').eq(2).slideDown();
    } else {
        start2 = true;
        $('.nj-area .nj-area-ul .xx-area').eq(2).slideUp();
    }
});
//小学选择功能
var xxSelectedArr = [];
var xxSelectedContent;

function showSelected1() {
    xxSelectedContent = '';
    if (xxSelectedArr.length == 0) {
        $('.nj-area .nj-area-ul .xx-area').eq(0).find('ul li').removeClass('active')
    }
    $.each(xxSelectedArr, function (i) {
        xxSelectedContent += '<li>' + xxSelectedArr[i] + '</li>'
        // $.each(xxSelectedArr,function(i){
        //     xxSelectedContent += '<li data-num="'+i+'">'+xxSelectedArr[i]+'</li>'
    });
    $('.nj-area .nj-area-ul .xx-area').eq(0).find('.selected-ul').show();
    $('.nj-area .nj-area-ul .xx-area').eq(0).find('.selected-ul ul').html(xxSelectedContent)
    $('.nj-area .nj-area-ul .xx-area').eq(0).find('.xx-selected-num span').text(xxSelectedArr.length)
}

$('.nj-area .nj-area-ul .xx-area').eq(0).find('ul li').click(function () {
    // $(this).addClass('active').siblings().removeClass('active');
    $(this).addClass('active');
    xxSelectedArr.push($.trim($(this).html()))
    removeRepeatArr(xxSelectedArr);
    showSelected1();
});
$(document).on('click', '.xx-area .selected-ul .selected-ul-xx li', function () {
    var xxArr = ['一年级', '二年级', '三年级', '四年级', '五年级', '六年级'];
    for (var i = 0; i < xxSelectedArr.length; i++) {
        if ($(this)[0].innerText == xxSelectedArr[i]) {
            xxSelectedArr.splice(i, 1);
        }
    }
    for (var j = 0; j < xxArr.length; j++) {
        if ($(this)[0].innerText == xxArr[j]) {
            $('.xx-area .xx-ul li').eq(j).removeClass('active');
        }
    }
    if ($(this).attr('data-num') == 0 || $(this).attr('data-num') == 1) {
        if (!$('.xx-area .xx-ul li').hasClass('active')) {
            $('.xx-area .xx-ul li').show();
            $('.nj-area .nj-area-li-cz').show();
            $('.nj-area .nj-area-li-gz').show();
            $('.xk-area .xk-ul li').show();
            //$('.xk-area .selected-ul-xk').show();
        }
    }
    showSelected1();
});
//初中选择功能
var czSelectedArr = [];
var czSelectedContent;

function showSelected2() {
    czSelectedContent = '';
    if (czSelectedArr.length == 0) {
        $('.nj-area .nj-area-ul .cz-area').eq(0).find('ul li').removeClass('active');
    }
    $.each(czSelectedArr, function (i) {
        czSelectedContent += '<li>' + czSelectedArr[i] + '</li>'
    })
    $(' .nj-area .nj-area-ul  .cz-area').eq(0).find('.selected-ul').show();
    $(' .nj-area .nj-area-ul  .cz-area').eq(0).find('.selected-ul ul').html(czSelectedContent);
    $(' .nj-area .nj-area-ul  .cz-area').eq(0).find('.cz-selected-num span').text(czSelectedArr.length);
}

$('.nj-area .nj-area-ul .cz-area').eq(0).find('ul li').click(function () {
    // $(this).addClass('active').siblings().removeClass('active');
    $(this).addClass('active');
    czSelectedArr.push($.trim($(this).html()));
    removeRepeatArr(czSelectedArr);
    showSelected2();
});

$(document).on('click', '.cz-area .selected-ul .selected-ul-cz li', function () {
    var czArr = ['七年级', '八年级', '九年级'];
    for (var i = 0; i < czSelectedArr.length; i++) {
        if ($(this)[0].innerText == czSelectedArr[i]) {
            czSelectedArr.splice(i, 1);
        }
    }
    for (var j = 0; j < czArr.length; j++) {
        if ($(this)[0].innerText == czArr[j]) {
            $('.cz-area .cz-ul li').eq(j).removeClass('active');
        }
    }
    showSelected2();

});

//高中选择功能
var gzSelectedArr = [];
var gzSelectedContent;

function showSelected3() {
    gzSelectedContent = '';
    if (gzSelectedArr.length == 0) {
        $('.nj-area .nj-area-ul .gz-area').eq(0).find('ul li').removeClass('active');
    }
    $.each(gzSelectedArr, function (i) {
        gzSelectedContent += '<li>' + gzSelectedArr[i] + '</li>'
    })
    $('.nj-area .nj-area-ul  .gz-area').eq(0).find('.selected-ul').show();
    $('.nj-area .nj-area-ul  .gz-area').eq(0).find('.selected-ul ul').html(gzSelectedContent);
    $('.nj-area .nj-area-ul  .gz-area').eq(0).find('.gz-selected-num span').text(gzSelectedArr.length);
}

$('.nj-area .nj-area-ul  .gz-area').eq(0).find('ul li').click(function () {
    // $(this).addClass('active').siblings().removeClass('active');
    $(this).addClass('active');
    gzSelectedArr.push($.trim($(this).html()));
    removeRepeatArr(gzSelectedArr);
    showSelected3();
})

$(document).on('click', '.gz-area .selected-ul .selected-ul-gz li', function () {
    var gzArr = ['高一', '高二', '高三'];
    for (var i = 0; i < gzSelectedArr.length; i++) {
        if ($(this)[0].innerText == gzSelectedArr[i]) {
            gzSelectedArr.splice(i, 1);
        }
    }
    for (var j = 0; j < gzArr.length; j++) {
        if ($(this)[0].innerText == gzArr[j]) {
            $('.gz-area .gz-ul li').eq(j).removeClass('active');
        }
    }
    showSelected3();
});

//学科选择功能
var xkSelectedArr = [];
var xkSelectedContent;

function showSelected() {
    //console.log(xkSelectedArr.length)
    xkSelectedContent = '';
    $.each(xkSelectedArr, function (i) {
        xkSelectedContent += '<li>' + xkSelectedArr[i] + '</li>'
    })
    // console.log(xkSelectedContent)
    $('.xk .selected-ul').show();
    $('.xk .selected-ul ul').html(xkSelectedContent);
    $('.xk .selected-ul .selected-num span').text(xkSelectedArr.length);
}

$('.xk .xk-area ul li').click(function () {
    // $(this).addClass('active').siblings().removeClass('active');
    $(this).addClass('active');
    xkSelectedArr.push($.trim($(this).html()))
    removeRepeatArr(xkSelectedArr);
    showSelected();
})

$(document).on('click', '.xk-area .selected-ul .selected-ul-xk li', function () {
    var xkArr = ['数学', '物理', '化学', '生物', '地理', '英语', '语文', '历史', '政治'];
    for (var i = 0; i < xkSelectedArr.length; i++) {
        if ($(this)[0].innerText == xkSelectedArr[i]) {
            xkSelectedArr.splice(i, 1);
        }
    }
    for (var j = 0; j < xkArr.length; j++) {
        if ($(this)[0].innerText == xkArr[j]) {
            $('.xk-area .xk-ul li').eq(j).removeClass('active');
        }
    }
    showSelected();
});