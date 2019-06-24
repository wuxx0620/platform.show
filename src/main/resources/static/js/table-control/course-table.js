var loginName = document.getElementById("loginName").innerText;
$('#sure-button1,#sure-button').click(function () {
    var bTime = $('#start_datetime_input').val();
    var eTime = $('#end_datetime_input').val();
    var dynamicNum = new Array();
    var dynamicMax = new Array();
    var dynamicAvg = new Array();
    var Subject = new Array();
    var test = xxSelectedArr.concat(czSelectedArr);
    var NjSelectedArr = test.concat(gzSelectedArr);
    $.ajax({
        url: '/course/courseNumData',
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
            var html = "";
            html += "<tr><th>科目</th>" + "<th>" + loginName + "</th>" + "<th>优秀</th>" + " <th>平均</th></tr>";
            for (var i = 0; i < data.length; i++) {
                if (data[i].courseNum != null) {
                    dynamicNum.push(data[i].courseNum);
                }
            }
            for (var i = 0; i < data.length; i++) {
                if (data[i].courseNumAvg != null) {
                    dynamicAvg.push(data[i].courseNumAvg);
                }
            }
            for (var i = 0; i < data.length; i++) {
                if (data[i].courseNumMax != null) {
                    dynamicMax.push(data[i].courseNumMax);
                }
            }

            for (var i = 0; i < 9; i++) {
                Subject.push(data[i].subject);
                html += "<tr><th>" + Subject[i] + "</th>" + "<th>" + dynamicNum[i] +
                    "</th><th>" + dynamicMax[i] + "</th>" + "<th>" + dynamicAvg[i] + "</th></tr>"
            }
            $("#table").html(html);
        }
    })
});