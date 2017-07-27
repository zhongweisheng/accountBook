var mlbUserId = localStorage.getItem('mlbUserId');
var isShow = true;
var errorMsg = Restful.get('blacklist/isBlackList/'+mlbUserId);
if(errorMsg ==1){
    $(".errorMsg").show();

}
if(errorMsg ==0){
    $(".errorMsg").hide();
}

if(localStorage.getItem('isShowDate')){
    var isShowDate = localStorage.getItem('isShowDate');
    var mDate1 = new Date();
    mYear1 = mDate1.getFullYear();
    mMounth1 = mDate1.getMonth();
    mDay1 = mDate1.getDate();
    mDate1 = mYear1 +'/'+mMounth1 +'/'+mDay1;
    if(mDate1 == isShowDate){
        isShow = false;
    }else{
        isShow = true;
        mDate = new Date();
        mYear = mDate.getFullYear();
        mMounth = mDate.getMonth();
        mDay = mDate.getDate();
        mDate = mYear +'/'+mMounth +'/'+mDay;
        localStorage.setItem('isShowDate',mDate);
    }
}else{
    isShow = true;
    mDate = new Date();
    mYear = mDate.getFullYear();
    mMounth = mDate.getMonth();
    mDay = mDate.getDate();
    mDate = mYear +'/'+mMounth +'/'+mDay;
    localStorage.setItem('isShowDate',mDate);
}

if(isShow){
    groom();
    $('.balanceModel').show();
}else{
    groom();
    $('.balanceModel').hide();
}
$('.nav_ul li').on('click',function () {
   $(this).addClass('nav_active').siblings().removeClass('nav_active');
});
var locationNum = '',quality = '',grainType = '';
var lat = 39.904989,lng = 116.405285,minDistance = 0,maxDistance = 100,$navActive = 0;
if (navigator.geolocation) {
    if(navigator.geolocation.getCurrentPosition){
        navigator.geolocation.getCurrentPosition(showPosition,showError);
    }
}
function showPosition(position) {
    lat = position.coords.latitude;
    lng = position.coords.longitude;
    getData();
}
function showError(error)
{
    switch(error.code)
    {
        case error.PERMISSION_DENIED:
            lat =  39.904989;
            lng = 116.405285;
            break;
        case error.POSITION_UNAVAILABLE:
            lat =  39.904989;
            lng = 116.405285;
            break;
        case error.TIMEOUT:
            lat =  39.904989;
            lng = 116.405285;
            break;
        case error.UNKNOWN_ERROR:
            lat =  39.904989;
            lng = 116.405285;
            break;
    }
}

var nav = sessionStorage.getItem('page');
if(nav == 1){
    minDistance = 100;
    maxDistance = 200;
    $('.nav').children().eq(1).addClass('nav_active').siblings().removeClass('nav_active');
    getData();
}else if(nav == 2){
    $('.nav').children().eq(2).addClass('nav_active').siblings().removeClass('nav_active');
    minDistance = 200;
    maxDistance = 2000;
    getData();
}else {
    getData();
}

$('.nav').on('click','li',function () {
    $navActive = $(this).index();
    if($navActive == 0){
        minDistance = '0';
        maxDistance = 100;
        sessionStorage.setItem('page',0);
    }else if($navActive == 1){
        minDistance = 100;
        maxDistance = 200;
        sessionStorage.setItem('page',1);
    }else{
        minDistance = 200;
        maxDistance = 2000;
        sessionStorage.setItem('page',2);
    }
    getData();
});


function getData() {
    var params = {};
    params.lat = lat;
    params.lng = lng;
    params.minDistance = minDistance;
    params.maxDistance = maxDistance;
    params.foodType = grainType;
    params.location = locationNum == '-1'?'':locationNum;
    // console.log(params);
    jsonParams = JSON.stringify(params);
    var res = Restful.get('mlbuser/getUserList',jsonParams);
    if (res && res.success) {
        var data = res.dataList;
        var msg = $('#down-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"down": data});
        $("#downlist").html(html);
        //$('.more-text').removeClass('hiden');
    } else {
        //$('.more').css('display', 'none');
        $("#downlist").html(
            '<div style="width: 100%">' +
            '<div style="width: 100%;height: 5rem;background: url(../img/nodata.png) center no-repeat;background-size: 50% 5rem;margin-top: 3rem;">' +
            '</div>' +
            '<div style="text-align: center;margin-top: 1rem">' +
            '<span style="color: #929292;font-size: 0.9rem;">暂无此类数据~</span>' +
            '</div>' +
            '</div>'
        );
    }
    util.configWXJs(['onMenuShareTimeline',
        'onMenuShareAppMessage']);
    util.shareJump('卖粮宝');
}



//打电话
$(document).on('click','.phone',function () {
    var phone = $(this).data('phone');
    window.location.href = 'tel:'+phone;
});

$('.addressSelete').citys({
    required:false,
    nodata:'disabled',
    onChange:function(data){
    /*    console.log(data);*/
        locationText = data.province+data.city+data.area;
        locationNum = data.code;
    }
});
//筛选
$('.search').on('click',function () {
    jQuery.noConflict();
    jQuery('.searchModel').show().animate({'left':0},300);
    $('#grainType,#quality').val('0');
    locationNum = '';
});

$('.cencel').on('click',function () {
    jQuery('.searchModel').animate({'left':'100%'},200);
});
$('.submit').on('click',function () {
    jQuery('.searchModel').animate({'left':'100%'},200);
    grainType = $('#grainType').val();
    getData();
});

$('#downlist').on('click','.infor',function () {
    var id = $(this).attr('data-id');
    var params = {};
    params.operateUserId = 0;
    params.targetType = 2;
    params.targetId = id;
    params.operateUserName = '';
    params.operateType = 1;
    var  res= Restful.post('bsclickcount',params);
    window.location.href = 'wantbuy.html?id='+id;
});


$('.close').on('click',function () {
	$(".balanceModel").hide();
    $('.balanceModel1').hide();
});

$('.balanceModel,.balanceModel1').on('click',function (e) {
    if(e.target == this){
        $(".balanceModel").hide();
        $('.balanceModel1').hide();
    }
});

$('.jumpdetail').on('click',function () {

    id = $(this).data('id');
    var params = {};
    params.operateUserId = 0;
    params.targetType = 2;
    params.targetId = id;
    params.operateUserName = '';
    params.operateType = 1;
    var  res= Restful.post('bsclickcount',params);
    window.location.href = 'wantbuy.html?id='+id;
});


/*供应推荐查询*/
function groom() {
    var params ={};
    jsonParams = JSON.stringify(params);
    var res = Restful.get('bsadvertposition/list?type=1',jsonParams);
    console.log(res);
    if (res) {
        /*供应*/
        var data = res.dataList;
        var msg = $('#gooMsg').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"msg": data});
        $(".jumpdetail1").html(html);
        /*供应2*/
        var msg2 = $('#gooMsg2').html();
        var compiledTemplate2 = Template7.compile(msg2);
        var html2 = compiledTemplate2({"msg": data});
        $(".jumpdetail2").html(html2);
        //$('.more-text').removeClass('hiden');
    }
}

