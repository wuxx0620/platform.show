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
        url: '/focus/focusData',
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
            var html = "";
            html += "<tr><th>科目</th>" + "<th>" + loginName + "</th>" + "<th>优秀</th>" + " <th>平均</th></tr>";
            for (var i = 0; i <= 8; i++) {
                if (data[i].focusNum != null) {
                    dynamicNum.push(data[i].focusNum);
                }
            }
            for (var i = 9; i <= 17; i++) {
                if (data[i].focusAvg != null) {
                    dynamicAvg.push(data[i].focusAvg);
                }
            }
            for (var i = 18; i <= 26; i++) {
                if (data[i].focusMax != null) {
                    dynamicMax.push(data[i].focusMax);
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