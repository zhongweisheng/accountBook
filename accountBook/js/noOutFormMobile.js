var grainType = 2;
var timeType = 1;
var currentPage = 1;
var name;

var userId = DES3.decrypt(localStorage.getItem('ud'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));

//读取粮库
var depotRes = Restful.post('bsinventorydepot/getDepots',{userId:userId});
if(depotRes && depotRes.length != 0){
    var html = '';
    for(var i=0,len=depotRes.length;i<len;i++){
        html += '<li data-depot="'+depotRes[i].id+'">'+depotRes[i].name+'</li>';
    }
    $(".select").html('').append(html);
    $(".top h2").html($(".select li").eq(0).text()+' <img src="accountData/img/select.png"/>');
    $(".select li").eq(0).addClass('depotChange');
}else{
    $(".select").html('').append('<li data-depot="0">默认库</li>');
    $(".top h2").html($(".select li").eq(0).text()+' <img src="accountData/img/select.png"/>');
    $(".select li").eq(0).addClass('depotChange');
}
$(".top").click(function() {
    $(".balanceModel").fadeToggle();
});
$(".select").on('click','li',function () {
    var depotSel = $(this).text();
    $(this).addClass('depotChange').siblings().removeClass('depotChange');
    $(".top h2").html(depotSel+' <img src="accountData/img/select.png"/>');
    getData();
    shouMoreText();
});
getData();
shouMoreText();

/*$("#driver").on('change',function () {
 getData();
 });*/
$("#search").on('click',function () {
    getData();
});

var driverArray = [];
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
$("#driver").select2({
    data:driverArray,
    templateResult: formatState
});

//select格式化
function formatState (state) {
    if (!state.id) { return state.text; }
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

function getData(){
	  var params = {};
	    params.grainType = '';
	    params.recordNumber = '';
	    params.searchType = 1;
	    params.currentPage = currentPage;
        params.userId = ownerId;
        params.operateUserId = userId;
        params.depotId = $(".depotChange").attr('data-depot');
	    params.recordType = 2;
	    params.pageSize = 10;
	    params.strTime = '';
	    params.endTime = '';
	    params.licensePlate = '';
	    params.staffId = '';
	    params.driverId = $("#driver").val();

    var res = Restful.post('bsInventoryTemporary/search',params);
    if(res.success){
        var data = res.dataList;
        var msg = $('#inStorage-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"inStorage":data});
        $("#list").html(html);

        $('.more-text').removeClass('hiden');
    }else{
        $('.more').css('display','none');
        $("#list").html(
            '<div style="width: 100%">' +
                '<div style="width: 100%;height: 5rem;background: url(../img/nodata.png) center no-repeat;background-size: 50% 5rem;margin-top: 3rem;">' +
                '</div>' +
                '<div style="text-align: center;margin-top: 1rem">' +
                    '<span style="color: #929292;font-size: 0.9rem;">暂无此类数据~</span>' +
                '</div>' +
            '</div>'
        );
    }
}
function loadMore() {
    moreCtrl();
    currentPage += 1;
    getDataAsync();
}


function moreCtrl() {
    var text = $('.more-text');
    var animation = $('.spinner');
    if(text.hasClass('hiden')){
        text.removeClass('hiden');
        animation.addClass('hiden');
        excu = true;
    }else {
        text.addClass('hiden');
        animation.removeClass('hiden');
        excu = true;
    }
}

function getDataAsync() {
    var params = {};
    params.grainType = '';
    params.recordNumber = '';
    params.searchType = 1;
    params.currentPage = currentPage;
    params.userId = ownerId;
    params.operateUserId = userId;
    params.depotId = $(".depotChange").attr('data-depot');
    params.recordType = 2;
    params.pageSize = 10;
    params.strTime = '';
    params.endTime = '';
    params.licensePlate = '';
    params.staffId = '';
    params.driverId = $("#driver").val();
    params.CHANNAL_TYPE_CHECK='WEIXIN';
    var qcode = '';
    var arrSimple=new Array();
    for(var i in params){
        var forvalue = params[i] || '';
        arrSimple.push(i+'='+forvalue);
    }
    arrSimple.sort();
    qcode =arrSimple.join('');
    eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('0=1(0);',2,2,'qcode|md5'.split('|'),0,{}))
    params.qcode = qcode;
    $.ajax({
        type: 'post',
        url: 'accountBook/bsinventoryrecord/search',
        dataType: 'json',
        data: params,
        success: function(res) {
            if(res.success){
                var data = res.dataList;
                var msg = $('#inStorage-list').html();
                var compiledTemplate = Template7.compile(msg);
                var html = compiledTemplate({"inStorage":data});
                $("#list").append(html);
                moreCtrl();
            }else{
                moreCtrl();
                $('.more-text').text('没有更多数据了')
            }
        },
        error: function(err) {
            moreCtrl();
            console.log("请求出错");
            $("#list").html(
                '<div style="width: 100%">' +
                '<div style="width: 100%;height: 5rem;background: url(../img/nodata.png) center no-repeat;background-size: 50% 5rem;margin-top: 3rem;">' +
                '</div>' +
                '<div style="text-align: center;margin-top: 1rem">' +
                '<span style="color: #929292;font-size: 0.9rem;">暂无此类数据~</span>' +
                '</div>' +
                '</div>'
            );
        }
    });
}

/*
$(document).on('click','.card',function () {
    var id = $(this).attr('data-id');
    location.href = 'editMoblie.html?id='+id;
})
*/

function toEdit(e) {
    if(timeType != 1){
        return;
    }
    var id = $(e).attr('data-id');
    location.href = 'editnoOutFormMoblie.html?id='+id;
}
function shouMoreText() {
    var winHeight = window.screen.height;
    winHeight = 664;
    var listHeight = $('#list').height();
    if(listHeight<winHeight){
        $('.more').css('display','none');
    }else {
        $('.more').css('display','block');
    }
}