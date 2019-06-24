var Subject = new Array();
var User = new Array();
var Max = new Array();
var Avg = new Array();
var loginName = document.getElementById("loginName").innerText;
for (var i = 0; i < correctNumByUser.length; i++) {
    Subject.push(correctNumByUser[i].subject);
    User.push(correctNumByUser[i].correct);
    Max.push(correctNumMax[i].correctMax);
    Avg.push(correctNumAvg[i].correctAvg);
}
var options = {
    chart: {
        type: 'line'                          //指定图表的类型，默认是折线图（line）
    },
    title: {
        text: '铭孜教育课程数量数据统计'                 // 标题
    },
    xAxis: {
        categories: Subject  // x 轴分类
    },
    yAxis: {
        title: {
            text: '答题正确率'                // y 轴标题
        }
    },
    series: [{
        // 数据列
        name: loginName,                        // 数据列名
        data: User            // 数据
    }, {
        name: '优秀',
        data: Max
    }, {
        name: '平均',
        data: Avg
    }]
};
// 图表初始化函数
var chart = Highcharts.chart('container', options);
$('#sure-button1,#sure-button').click(function () {
    var bTime = $('#start_datetime_input').val();
    var eTime = $('#end_datetime_input').val();
    var dynamicNum = new Array();
    var dynamicMax = new Array();
    var dynamicAvg = new Array();
    var test = xxSelectedArr.concat(czSelectedArr);
    var NjSelectedArr = test.concat(gzSelectedArr);
    $.ajax({
        url: '/correct/correctData',
        type: 'post',
        dataType: 'json',
        data: {
            'subjects': xkSelectedArr,
            'grades': NjSelectedArr,
            "bTime": bTime,
            "eTime": eTime,
            "username": loginName,
        },
        traditional: true,
        async: false,
        error: function () {
            alert('error');
        },
        success: function (data) {
            console.log(data);
            for (var i = 0; i <= 8; i++) {
                if (data[i].correct != null) {
                    dynamicNum.push(data[i].correct);
                }
            }
            for (var i = 9; i <= 17; i++) {
                if (data[i].correctAvg != null) {
                    dynamicAvg.push(data[i].correctAvg);
                }
            }
            for (var i = 18; i <= 26; i++) {
                if (data[i].correctMax != null) {
                    dynamicMax.push(data[i].correctMax);
                }
            }
            while (chart.series.length > 0) {
                chart.series[0].remove();
            }
            chart.addSeries({
                name: loginName,
                data: dynamicNum
            })
            chart.addSeries({
                name: '平均',
                data: dynamicAvg
            })
            chart.addSeries({
                name: '优秀',
                data: dynamicMax
            })
        }
    })
});