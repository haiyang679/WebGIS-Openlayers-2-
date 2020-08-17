/************************************************************************/
/* 卫星云图
*@author fmm 2015-06-24/
/************************************************************************/

var timeStrArray = new Array();     //记录云图地址数组
var timeShowStrArr = new Array();   //记录云图地址数组
var ytInfoTimer = null;             //云图播放动画时间控制器
var timeControl = 0;                //控制卫星云图播放

/*
*	页面初始化
*@author fmm 2015-06-24
*/
$(function () {
    initSpinner();
    initSelectImgList();
});

/*
*	初始化数字调整框
*@author fmm 2015-06-24
*/
function initSpinner() {
    $("#spinner2").spinner({
        min: 1,
        step: 1
    });
}

/*
*	初始化图片列表
*@author fmm 2015-06-24
*/
function initSelectImgList() {
    GetImgAddress(); //得到图片地址
    //动态创建左侧列表
    var html = "<ul>";
    for (var i = 0; i < timeStrArray.length; i++) {
        var tempHtml = "<li class='wxytLi c'>" + timeStrArray[i] + "</li>";
        html += tempHtml;
    }
    html += "</ul>";
    $("#selectImgList").append(html);
    //列表项的样式设置
    $(".selectImg ul li").hover(function () {
        $(this).addClass("b");
        $(this).css("cursor", "pointer")
    }, function () {
        $(this).removeClass("b");
    })
    //单击列表项显示对应云图图片
    $(".selectImg ul li").click(function () {
        $(this).addClass("a").siblings("li").removeClass("a");
        var imgUrl = "Libs/images/yuntu/" + $(this).text() + ".jpg";
        $('#yuntuImg img').attr('src', imgUrl);
        timeControl = $(this).index();
    })
}

/*
*	得到图片的地址
*@author fmm 2015-06-24
*/
function GetImgAddress() {
    var TimeTemp = 1000;
    var dataTimeTemp = "20120618";
    var timeStr = "";
    var StimeStr = "";
    for (var i = 0; i < 24; i++) {              //一天24个小时
        for (var j = 0; j < 60; j = j + 15) {   //每15分钟显示一张图片
            if (i < 10) {
                if (j == 0) {
                    timeStr = dataTimeTemp + "0" + i + "0" + j;
                } else {
                    timeStr = dataTimeTemp + "0" + i + j;
                }
            } else {
                if (j == 0) {
                    timeStr = dataTimeTemp + i + "0" + j;
                } else {
                    timeStr = dataTimeTemp + i + j;
                }
            }
            timeStrArray.push(timeStr);
            var strAddress = "Libs/images/yuntu/" + timeStr + ".jpg";
            timeShowStrArr.push(strAddress);
        }
    }
}

/*
*	开始播放云图动画
*@author fmm 2015-06-24
*/
function startShowCloud() {
    var time = $("#spinner2").spinner("value");
    if (ytInfoTimer != null) {
        clearTimer();
    }
    //设置计时器动态播放
    ytInfoTimer = setInterval(function () {
        if (timeControl * 20 > 470) {
            $("#selectImgList").scrollTop(timeControl * 20 - 400);
        }
        if (timeControl != 0) {
            $(".selectImg ul li:eq(" + (timeControl - 1) + ")").removeClass("a");
        }
        $(".selectImg ul li:eq(" + timeControl + ")").addClass("a");
        if (timeControl < timeShowStrArr.length) {
            var imgUrl = timeShowStrArr[timeControl++];
            var url = "url(" + imgUrl + ")";
            $('#yuntuImg img').attr('src', imgUrl);//切换云图图片
        } else {
            timeControl = 0;
            clearTimer();
        }
    }, time * 1000);
}

/*
*	清除卫星云图时间控制器
*@author fmm 2015-06-25
*/
function clearTimer() {
    if (ytInfoTimer != null) {
        clearInterval(ytInfoTimer);
        ytInfoTimer = null;
    }
}

/*
*	停止卫星云图播放
*@author fmm 2015-06-25
*/
function stopShowCloud() {
    clearTimer();
    if (timeControl > 0) {
        $(".selectImg ul li:eq(" + (timeControl - 1) + ")").addClass("a");
    }    
}