/**
 * Created by new on 2017/3/28.
 */
//左边栏样式

//查询条件
var grainType = 2;
var searchType = 1;
var currentPage = 1;
var pages;



getData();
initPaging();
$(".leftContent > div:nth-child(7)").addClass("left_active");
//删除表格列
function deleteTd() {
    $(".rightContent thead > tr > td:nth-child(2)").css("display", "none");
    $(".rightContent tbody > tr > td:nth-child(2)").css("display", "none");
    $(".rightContent thead > tr > td:nth-child(6)").css("display", "none");
    $(".rightContent tbody > tr > td:nth-child(6)").css("display", "none");
}


$("#timeChange").on('click', 'a', function () {
    searchType = $(this).attr("data-timeType");
    currentPage = 1;
    getData();
    initPaging();
    if (searchType != 1) {
        deleteTd();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
    $(this).removeClass('watch').addClass('watchActive');
    $(this).parent().siblings().find('a').removeClass('watchActive').addClass('watch');
});


$("#grainType").on('change', function () {
    grainType = $("#grainType").val();
    currentPage = 1;
    getData();
    initPaging();
    if (searchType != 1) {
        deleteTd();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
});
$(document).on('click','.page',function () {
    currentPage = $('.activP').text();
    getData();
    if (searchType != 1) {
        deleteTd();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
    $(this).removeClass('watch').addClass('watchActive');
    $(this).parent().siblings().find('a').removeClass('watchActive').addClass('watch');
})
function getData() {
    var params = {};
    params.grainType = grainType;
    params.currentPage = currentPage;
    params.searchType = searchType;
    params.userId = DES3.decrypt(localStorage.getItem('userId'));
    params.pageSize = 10;
    var res = Restful.post('bsinventoryrecord/searchStat', params);
    if (res.success) {

        var data = res.dataList;
        var msg = $('#accountSta-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"accountSta": data});
        $("#list").html(html);

        pages  = Math.ceil(res.total/10);
    }else{
        $("#list").html('');
        $("#list").html('<tr><td colspan="9"><div style="width: 100%;height: 400px;line-height: 100px;font-size: 30px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
    }
}

function initPaging() {
    //分页初始化
    $('.page').page({
        leng: pages,//分页总数
        activeClass: 'activP' , //active 类样式定义
    });
}
//导出表格
function rptDownLoad(){
    var userId = DES3.decrypt(localStorage.getItem('userId'));
    var form = $("<form>");
    form.attr('style', 'display:none');
    form.attr('target', '');
    form.attr('method', 'post');
    form.attr('action', '/accountBook/bsinventoryrecord/exportStat');
    var input1 = $('<input>');
    input1.attr('type', 'hidden');
    input1.attr('name', 'grainType');
    input1.attr('value', grainType);
    var input2 = $('<input>');
    input2.attr('type', 'hidden');
    input2.attr('name', 'searchType');
    input2.attr('value', searchType);
    var input3 = $('<input>');
    input3.attr('type', 'hidden');
    input3.attr('name', 'userId');
    input3.attr('value', userId);
    var input4 = $('<input>');
    input4.attr('type', 'hidden');
    $('body').append(form);
    form.append(input1);
    form.append(input2);
    form.append(input3);
    form.submit();
    form.remove();
}

$('.excelBtn').on('click',function () {
    rptDownLoad();
});