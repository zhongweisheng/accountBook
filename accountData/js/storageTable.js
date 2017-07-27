/**
 * Created by new on 2017/3/28.
 */
//查询条件
$(".leftContent > div:nth-child(6)> p:nth-child(6)").addClass("left_active");
$(".leftContent > div:nth-child(5)").addClass("left_active");
$(".child").eq(2).css('display', 'block');
var paidMoney,unpaidMoney,startDate = '',endDate = '';
var grainType = 1;
var searchType = 1;
var currentPage = 1;
var pages;
var depot = '0';
var name = '';
var searchStaffId = '';

var userId = DES3.decrypt(localStorage.getItem('userId'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));
var userName = DES3.decrypt(localStorage.getItem('userName'));
getData();
initPaging();
var select2Array = [];
var person = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:1,pageSize:1000});
/*console.log(person);*/
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
    location.reload();
    $('#dateStart,#dateEnd').val('');
    if (searchType != 1) {
        deleteTd();
        changePerson();
    } else {
        $(".rightContent td").css("display", "table-cell");
    }
}
$('#salePerson').select2({
    data: select2Array,
    templateResult: formatState
});
//删除表格
function deleteTd() {
    $(".rightContent thead > tr > td:nth-child(8)").css("display", "none");
    $(".rightContent tbody > tr > td:nth-child(8)").css("display", "none");

    $(".rightContent thead > tr > td:nth-child(11)").css("display", "none");
    $(".rightContent tbody > tr > td:nth-child(11)").css("display", "none");
}
//下载明细
$('#excelBtn').on('click',function () {
    if(confirm('导出表格?')){
        rptDownLoad();
    }
});
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
});


$(".page").on('click',function (e) {
    currentPage = $('.activP').text();
    getData(1);
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
function getData(isinit) {

    var params = {};
    params.grainType = grainType;
    params.currentPage = currentPage;
    params.searchType = searchType;
    params.ownerId = ownerId;
    params.userId = userId;
    params.depotId = depot;
    params.recordType = 3;
    params.pageSize = 10;
    params.staffName = name;
    params.staffId = searchStaffId;
    params.startDate = startDate;
    params.endDate = endDate;
    var res = Restful.post('bsinventorystorage/search', params);
/*    console.log(res);*/
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
        var msg = $('#inTable-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"inTable": data});
   
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


function toEdit(e) {
    var id = $(e).attr('data-id');
    // var id = $('.id'+10073).attr('data-id');
    // alert(id)
    location.href = 'editStorage.html?id='+id;
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
var thatId,hasSettled,notSettled;
$('#list').on('click','.balance',function () {

    thatId = $(this).attr('data-id');
    $('.balanceModel input').val('');
    var $tr = $(this).parent().parent().children('td');
    $('.b-staffName').html($tr.eq(2).html()?$tr.eq(2).html():'无');
    $('.b-date').html($tr.eq(1).html());
	 $('.b-netWeight').html($tr.eq(6).html());
    hasSettled = parseFloat($tr.eq(7).html().split(',').join(''));

    $('.b-hasSettled').html(hasSettled);
    var grossWeight = parseFloat($tr.eq(3).html().split(',').join(''));
    var tareWeight = parseFloat($tr.eq(4).html().split(',').join(''));
    var deduction = parseFloat($tr.eq(5).html().split(',').join(''));
    $('.balanceModel').animate({left:'0'},500);
    $('.b-yes').animate({left:'150%'},500);

   notSettled = grossWeight-tareWeight-deduction-hasSettled;
    if(notSettled ==0){
        notSettled ="0";
    }

    conuntWeight = parseFloat($tr.eq(6).html().split(',').join(''));
    
    $('.b-notSettled').html(notSettled);
    $('.balanceModel').animate({left:'0'},500);
/*    console.log($('.b-date').html($tr.eq(1).html()));*/
});
var testNum = true;
//结算的计算

function calcu() {
    var settleCount = parseFloat($('#settleCount').val());
    var settlePrice = parseFloat($('#settlePrice').val());
    var shouldPay = settleCount * settlePrice * 2;
    $('#shouldPay').html(shouldPay?shouldPay.toFixed(2):0);
    $('.b-hasSettled').html(hasSettled + settleCount);

    //未结算公斤
    $('.b-notSettled').html(conuntWeight - (hasSettled + settleCount));

    $('.settleCount').html(settleCount);
    $('.settlePrice').html(settlePrice);
    $('#actualPay').val(shouldPay?shouldPay.toFixed(2):0);
    $('.actualPay').html(shouldPay?shouldPay.toFixed(2):0);

}

$('#settleCount,#settlePrice').keyup(function () {
    calcu();
});
//结算页面切换
$('#actualPay').keyup(function () {

    $('.actualPay').html($(this).val());
});

$('#b-cencel').on('click',function () {
    $('.balanceModel').animate({left:'100%'},500);
});


/*

$(document).on('click','#b-confirm',function () {

});
*/



$('#b-confirm').on('click',function () {
			
		if ($('#settleCount').val()==""||$('#settlePrice').val()==""||$('#actualPay').val()=="") {
        	alert("请填写完整数据");
        } else{
        	    if($('.b-notSettled').html() < 0){
		        alert('今日结算数大于未结算数');
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
    var settleCount = parseFloat($('#settleCount').val());

    var params = {};
    params.operateUserName = userName;
    params.operateUserId = userId;
    params.storageId = thatId;
    params.settleCount = $('#settleCount').val();
    params.settlePrice = $('#settlePrice').val();
    params.shouldPay = $('#shouldPay').html();
    params.actualPay = $('#actualPay').val();
    params.hasSettled = $('.b-hasSettled').html();
    params.notSettled = $('.b-notSettled').html();
    if(testNum){
        var result = Restful.post('bsinventorystoragepay',params);
        if(result&&result.success){

            alert('结算成功');
            $('.balanceModel').animate({left:'100%'},500);
            $('.b-write').animate({left:'50%'},500);
            getData();

        }else{
            alert('结算不成功');

            $('.balanceModel').animate({left:'100%'},500);
        }
    }
});

$('#list').on('click','.print',function () {
    var id = $(this).attr('data-id');
    window.open('dataPrintStorage.html?id='+id);
});

$('#list').on('click','.details',function () {
    var id = $(this).attr('data-id');
    window.location.href = 'storageDetails.html?id='+id;
});

$('#list').on('click','.delete',function () {
    var id = $(this).attr('data-id');
    var isDelete = confirm('是否删除本条数据?');
    if(isDelete){
        var params = {};
        params.recordId = id;
        var result = Restful.post('bsinventorystorage/deleteRecordOrdre',params);
        if(result.success){
            getData();
        }
    }
});

//导出表格
function rptDownLoad(){
    var form = $("<form>");
    form.attr('style', 'display:none');
    form.attr('target', '');
    form.attr('method', 'post');
    form.attr('action', '/accountBook/bsinventorystorage/export');
    var input1 = $('<input>');
    input1.attr('type', 'hidden');
    input1.attr('name', 'grainType');
   input1.attr('value', grainType);
    var input2 = $('<input>');
    input2.attr('type', 'hidden');
    input2.attr('name', 'searchType');
    input2.attr('value', 1);
    var input3 = $('<input>');
    input3.attr('type', 'hidden');
    input3.attr('name', 'userId');
    input3.attr('value', ownerId);
    var input4 = $('<input>');
    input4.attr('type', 'hidden');
    input4.attr('name', 'recordType');
    input4.attr('value', 3);
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


function excelBtn() {
    if(confirm('导出表格?')){
        rptDownLoad();
    }
}
