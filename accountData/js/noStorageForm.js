/**
 * Created by new on 2017/3/28.
 */
//查询条件
var grainType = 2;
var searchType = 1;
var currentPage = 1;
var pages;
var name = '';
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
});
getData();
initPaging();
$(".page").on('click',function (e) {
    currentPage = $('.activP').text();
    getData();
});

$("#search").on('click',function () {
    getData();
    initPaging();
});

var depotre = Restful.post('bsinventorydepot/getDepots',{userId:userId});
if(depotre){
    var html = '<option value="0">全部</option>';
    for(var i=0,len=depotre.length;i<len;i++){
        html += ' <option value="'+depotre[i].id+'" >'+depotre[i].name+'</option>';
    }
    $(".depot").html('').append(html);
}

var select2Array = [],driverArray = [];
var person = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:1,pageSize:1000});
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
var driver = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:3,pageSize:1000});
if(driver){
    if(driver.success){
        var driverArr = driver.dataList;
        driverArray.push({id: 0, text: '请选择', phone: ''});
        $.each(driverArr,function (index,val) {
            driverArray.push({id: val.staffId, text: val.trueName, phone: val.phone});
        })
    }else {
        driverArray.push({id:0,text:'无',phone:''});
    }
}
$('#salePerson').select2({
    data: select2Array,
    templateResult: formatState
});
$('#driver').select2({
    data: driverArray,
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
$("#grainType").on('change', function () {
    grainType = $("#grainType").val();
    getData();
});
 $("#salePerson").on('change', function () {
     salePerson = $("#salePerson").val();
     getData();
 });
$("#driver").on('change', function () {
    driverId = $("#driver").val();
    getData();
});
$("#depot").on('change', function () {
    depot = $("#depot").val();
    getData();
});
$("#dateEnd").on('change', function () {
    endTime = $("#dateEnd").val();
    getData();
});
function getData() {
    var params = {};
    params.grainType = $("#grainType").val();
    params.recordNumber = '';
    params.searchType = 1;
    params.currentPage = currentPage;
    params.userId = userId;
    params.ownerId = ownerId;
    params.depotId = $("#depot").val();
    params.recordType = 3;
    params.pageSize = 8;
    params.strTime = $("#dateStart").val();
    params.endTime = $("#dateEnd").val();
   // params.licensePlate = $("#licensePlate").val();
    params.staffId = $("#salePerson").val();
    params.driverId = $("#driver").val();
    var res = Restful.post('bsInventoryStorageTemp/search', params);
    if (res.success) {
        var data = res.dataList;
        var msg = $('#noInForm-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"noInForm": data});
        $("#list").html(html);
        pages = Math.ceil(res.total/6);
    }else{
        $("#list").html('');
        $("#list").html('<div style="width: 100%;height: 400px;line-height: 400px;font-size: 30px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
    }
}

function initPaging() {
    //分页初始化
    $('.page').page({
        leng: pages,//分页总数
        activeClass: 'activP' , //active 类样式定义
    });
}

$(document).on('click','#delete',function () {
    var id = $(this).attr('data-id');
    var isDelete = confirm('是否删除本条数据?');
    if(isDelete){
        var params = {};
        params.temporaryId = id;

        var result = Restful.post('bsInventoryStorageTemp/deleteInventoryTemporary',params);
        if(result.success){
            getData();
        }
    }
});


$(document).on('click','.jump',function () {
    var id = $(this).attr('data-id');
    location.href = 'editnoStorage.html?id='+id;
});

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
