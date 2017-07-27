/**
 * Created by new on 2017/3/28.
 */
//查询条件
var paidMoney,unpaidMoney,startDate = '',endDate = '';
var grainType = 1;
var searchType = 1;
var currentPage = 1;
var pages;
var name = '';
var searchStaffId = '';

var userId = DES3.decrypt(localStorage.getItem('userId'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));
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
}).on('change', function () {
    startDate = $('#dateStart').val();
    endDate = $('#dateEnd').val();
    getData();
    if (searchType != 1) {
        deleteTd();
        changePerson();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
});


function clearDate() {
    $('#dateStart,#dateEnd').val('');
    startDate = $('#dateStart').val();
    endDate = $('#dateEnd').val();
    getData();
    if (searchType != 1) {
        deleteTd();
        changePerson();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
}
getData();
initPaging();
var select2Array = [];
var person = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:2,pageSize:1000});
if(person){
    if(person.success){
        var personArr = person.dataList;
        select2Array.push({id: 0, text: '请选择', phone: ''});
        $.each(personArr,function (index,val) {
            select2Array.push({id: val.staffId, text: val.trueName, phone: val.phone});
        })
    }else {
        select2Array.push({id:0,text:'无',phone:''});
    }
}
$('#salePerson').select2({
    data: select2Array,
    templateResult: formatState
});
//select格式化
function formatState(state) {
    if (!state.id) {
        return state.text;
    }
    var $state = '';
    if(state.text != '请选择'){
        $state = $(
            '<span style="display: inline-block;height: 2rem;">姓名: ' + state.text + '</br><span>手机号:' + state.phone + '</span></span>'
        );
    }else {
        $state = $(
            '<span style="display: inline-block;">' + state.text+'</span>'
        );
    }
    return $state;
};
$(".leftContent > div:nth-child(6)> p:nth-child(4)").addClass("left_active");
$(".leftContent > div:nth-child(5)").addClass("left_active");
$(".child").eq(2).css('display','block');

$(document).on('mouseover','#accountRemark',function () {
    $(this).siblings('div').slideDown(100);
});
$(document).on('mouseout','#accountRemark',function () {
    $(this).siblings('div').css('display','none');
});
//删除表格列
function deleteTd() {
    $(".rightContent thead > tr > td:nth-child(8)").css("display", "none");
    $(".rightContent tbody > tr > td:nth-child(8)").css("display", "none");
    $(".rightContent thead > tr > td:nth-child(10)").css("display", "none");
    $(".rightContent tbody > tr > td:nth-child(10)").css("display", "none");
    $(".rightContent thead > tr > td:nth-child(12)").css("display", "none");
    $(".rightContent tbody > tr > td:nth-child(12)").css("display", "none");
}

//修改买(送)粮人字段
function changePerson() {
    var text = $("#salePerson").find('option:selected').text();
    if(text != '请选择'){
        $(".staffName").html(text);
    }else{
        $(".staffName").html('全部');
    }
}
//时间条件搜索
$("#timeChange").on('click', 'a', function () {
    if($(this).attr('id') == 'excelBtn'){
        return;
    }
    searchType = $(this).attr("data-timeType");
    currentPage = 1;
    getData();
    if (searchType != 1) {
        deleteTd();
        changePerson();
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
    if (searchType != 1) {
        deleteTd();
        changePerson();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
});

$("#salePerson").on('change', function () {
    searchStaffId = $("#salePerson").val();
    currentPage = 1;
    getData();
    if (searchType != 1) {
        deleteTd();
        changePerson();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
});

//粮库
var depotre = Restful.post('bsinventorydepot/getDepots',{userId:userId});
if(depotre){
    var html = '<option value="0">全部</option>';
    for(var i=0,len=depotre.length;i<len;i++){
        html += ' <option value="'+depotre[i].id+'" >'+depotre[i].name+'</option>';
    }
    $(".depot").html('').append(html);
}

$("#depot").on('change', function () {
    depot = $("#depot").val();
    currentPage = 1;
    getData();
    if (searchType != 1) {
        deleteTd();
        changePerson();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
});


function getData(isinit) {
	
    var params = {};
    params.grainType = grainType;
    params.currentPage = currentPage;
    params.searchType = searchType;
    params.ownerId = ownerId;
    params.userId = userId;
    params.depotId = $("#depot").val();
    params.recordType = 2;
    params.pageSize = 10;
    params.staffName = name;
    params.staffId = searchStaffId;
    params.startDate = startDate;
    params.endDate = endDate;
    var res = Restful.post('bsinventoryrecord/search', params);
    if (res.success) {
        var data = res.dataList;
        for(var i=0,len=data.length;i<len;i++){
            if(data[i].paidMoney == ''){
                data[i].paidMoney = 0;
            }
            if(searchType == 1 && data[i].paidMoney != ''){
                data[i].paidMoney = data[i].paidMoney.split(',').join('');
            }
            if(data[i].unpaidMoney == ''){
                data[i].unpaidMoney = data[i].money;
            }
        }
        var msg = $('#outTable-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"outTable": data});
        $("#list").html(html);
        pages = Math.ceil(res.total/10);
        if(isinit == 1){

        }else{
            initPaging();
        }
    }else{
        pages = 1;
        initPaging();
        $("#list").html('');
        $("#list").html('<tr><td colspan="12"><div style="width: 100%;height: 400px;line-height: 400px;font-size: 30px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
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
        getData(1);
        if (searchType != 1) {
            deleteTd();
            changePerson();
        } else {
            $(".rightContent td").css("display", "table-cell");
        }
    });
}
//导出表格
function rptDownLoad(){
    var form = $("<form>");
    form.attr('style', 'display:none');
    form.attr('target', '');
    form.attr('method', 'post');
    form.attr('action', '/accountBook/bsinventoryrecord/export');
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
    input4.attr('name', 'recordType');
    input4.attr('value', 2);
    var input5 = $('<input>');
    input5.attr('type', 'hidden');
    input5.attr('name', 'startDate');
    input5.attr('value', startDate);
    var input6 = $('<input>');
    input6.attr('type', 'hidden');
    input6.attr('name', 'endDate');
    input6.attr('value', endDate);
    $('body').append(form);
    form.append(input1);
    form.append(input2);
    form.append(input3);
    form.append(input4);
    form.append(input5);
    form.append(input6);
    form.submit();
    form.remove();
}

$('#excelBtn').on('click',function () {
    if(confirm('导出表格?')){
        rptDownLoad();
    }
});

function toEdit(e) {
    var id = $(e).attr('data-id');
    // var id = $('.id'+10073).attr('data-id');
    // alert(id)
    location.href = 'edit.html?id='+id;
}
function showEdit() {
    if (searchType != 1) {
        deleteTd();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
    if(currentPage == 1){
        $('.edit').css('display','inline-block');
    }
}
function fmoney(s, n) {
    n = n > 0 && n <= 20 ? n : 2;
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(),
        r = s.split(".")[1];
    t = "";
    for(i = 0; i < l.length; i ++ )
    {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
    }
    return t.split("").reverse().join("") + "." + r;
}
var thatId,hasSettled,notSettled,money;
$('#list').on('click','.balance',function () {
    thatId = $(this).attr('data-id');
    $('.balanceModel input').val('');
    var $tr = $(this).parent().parent().children('td');
    $('.b-staffName').html($tr.eq(2).html()?$tr.eq(2).html():'无');
    money = parseFloat($tr.eq(8).html().split(',').join(''));
    $('.b-money').html(money);
    hasSettled = parseFloat($tr.eq(9).html().split(',').join(''));
    $('.b-hasSettled').html(hasSettled);
    notSettled = parseFloat($tr.eq(10).html().split(',').join(''));
    $('.b-notSettled').html(notSettled);
    $('.balanceModel').animate({left:'0'},500);
    $('.b-yes').animate({left:'150%'},500);
 /*   console.log($('.b-date').html($tr.eq(1).html()));*/
});
$('#list').on('click','#print',function () {
    var id = $(this).attr('data-id');
    window.open('dataPrint.html?id='+id);
});
var testNum = true;
//结算的计算
$('#pay').keyup(function () {
 
    if($('#pay').val()==""){
    	$('#pay').val("");
    	
    }else{
    	   var pay = parseFloat($('#pay').val());
    $('.b-hasSettled').html(pay);
    $('.b-notSettled').html((money - pay).toFixed(2));
    }
});
//结算页面切换
$('#b-cencel').on('click',function () {
    $('.balanceModel').animate({left:'100%'},500);
});
$('#b-confirm').on('click',function () {
    if ($('#pay').val()=="") {
        alert("请填写收款金额");
    } else{
        if($('#pay').val() > money){
            alert('收款金额大于总金额');
            testNum = false;
        }else{
            testNum = true;
        }
        if(testNum){
            $('.b-write').animate({left:'-50%'},500);
            $('.b-yes').animate({left:'50%'},500);
        }
    }
});

$('#b-back').on('click',function () {
    $('.b-write').animate({left:'50%'},500);
    $('.b-yes').animate({left:'150%'},500);
});
//提交结算
$('#b-submit').on('click',function () {
    var params = {};
    params.id = thatId;
    params.paidMoney = $('.b-hasSettled').html();
    params.unpaidMoney = $('.b-notSettled').html();
    if(testNum){
        var result = Restful.post('bsinventoryrecord/updatePaidMoney',params);
        if(result&&result.success){

            alert('结算成功');
            $('.balanceModel').animate({left:'100%'},500);
            $('.b-write').animate({left:'50%'},500);
            getData(1);

        }else{
            alert('结算不成功');
            $('.balanceModel').animate({left:'100%'},500);
        }
    }
});
$('#list').on('click','.delete',function () {
    var id = $(this).attr('data-id');
    var isDelete = confirm('是否删除本条数据?');
    if(isDelete){
        var params = {};
        params.recordId = id;
        var result = Restful.post('bsinventoryrecord/deleteRecordOrdre',params);
        Restful.operateRecord(id,2,23);
        if(result.success){
            getData();
        }
    }
});
