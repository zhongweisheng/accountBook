/**
 * Created by new on 2017/3/28.
 */
//查询条件
var currentPage = 1;
var pages;
$('#dateStart').datetimepicker({
    startView:4,
    minView:2,
    todayBtn:true,
    todayHighlight:true,
    language:'zh-CN'
});
$('#dateEnd').datetimepicker({
    startView:4,
    minView:2,
    todayBtn:true,
    todayHighlight:true,
    language:'zh-CN'
});
var userId = DES3.decrypt(localStorage.getItem('userId'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));
$(".leftContent > div:nth-child(8)> p:nth-child(10)").addClass("left_active");
$(".leftContent > div:nth-child(7)").addClass("left_active");
$(".child").eq(3).css('display', 'block');

//获取员工列表
getStaff();
function getStaff() {
    var params = {};
    params.ownerId = userId;
    var res = Restful.post('bsinventoryuser/list', params);
    if (res.success) {
        var data = res.dataList;
        var html = '<option value="0">请选择</option>';
        for(var i=0,len=data.length;i<len;i++){
            html += '<option value="'+data[i].userId+'">'+data[i].trueName+'</option>';
        }
        $('#operatePerson').html('').append(html);
    } else {
        $("#list").html('');
        $("#list").html('<tr><td colspan="5"><div style="width: 100%;height: 400px;line-height: 100px;font-size: 30px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
    }
}
getData();
initPaging();



$("#operatePerson").on('change', function () {
    currentPage = 1;
    operateUserId = $('#operatePerson').val();
    getData(1);
});
$("#operateType").on('change', function () {

    currentPage = 1;
    operateType = $('#operateType').val();
    getData(1);
});
$("#dateEnd").on('change', function () {
    currentPage = 1;
    startDate = $('#dateStart').val();
    endDate = $('#dateEnd').val();
    getData(1);
});

//获取员工操作信息
function getData(inti) {
    var params = {};
    params.currentPage = currentPage;
    params.userId = userId;
    params.ownerId = userId;
    params.startDate = $('#dateStart').val();
    params.endDate = $('#dateEnd').val();
    params.operateType = $('#operateType').val();
    params.operateUserId = $('#operatePerson').val();
    params.pageSize = 10;
    var res = Restful.post('bsinventoryoperate/list', params);
    if (res.success) {
        var data = res.dataList;
        var msg = $('#inTable-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"inTable": data});
        $("#list").html(html);
        pages = Math.ceil(res.total/10);
        if(inti==1) {
            initPaging();
        }

    }else{
        pages = 1;
        initPaging();
        $("#list").html('');
        $("#list").html('<tr><td colspan="5"><div style="width: 100%;height: 400px;line-height: 400px;font-size: 30px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
    }
}

function initPaging() {
    //分页初始化
    $('.page').page({
        leng: pages,//分页总数
        activeClass: 'activP' , //active 类样式定义
    });
    $(".page").on('click',function () {
        currentPage = $('.activP').text();
        getData();
    });
}


//初始化日期
$(function() {
    var dateNow = new Date();
    var year = dateNow.getFullYear();
    var month = dateNow.getMonth() + 1;
    if (month < 10) {
        month = '0' + month;
    }
    var day = dateNow.getDate();
    if (day < 10) {
        day = '0' + day;
    }
    var hour = dateNow.getHours();
    if (hour < 10) {
        hour = '0' + hour;
    }
    var minute = dateNow.getMinutes();
    if (minute < 10) {
        minute = '0' + minute;
    }
    nowDate = year + '-' + month + '-' + day;
    $("#date").val(nowDate);
});

