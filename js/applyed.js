var isShow = true;
var isShowDate = localStorage.getItem('isShowDateApply');
if(isShowDate){
    var mDate1 = new Date();
    mYear1 = mDate1.getFullYear();
    mMounth1 = mDate1.getMonth();
    mDay1 = mDate1.getDate();
    mDate1 = mYear1 +'/'+mMounth1 +'/'+mDay1;
    if(mDate1 == isShowDate){
        isShow = false;
    }else{
        isShow = true;
        var mDate = new Date();
        mYear = mDate.getFullYear();
        mMounth = mDate.getMonth();
        mDay = mDate.getDate();
        mDate = mYear +'/'+mMounth +'/'+mDay;
        localStorage.setItem('isShowDateApply',mDate);
    }
}else{
    isShow = true;
    var mDate = new Date();
    mYear = mDate.getFullYear();
    mMounth = mDate.getMonth();
    mDay = mDate.getDate();
    mDate = mYear +'/'+mMounth +'/'+mDay;
    localStorage.setItem('isShowDateApply',mDate);
}

if(isShow){
    groom();
    $('.balanceModel').show();
}else{
    $('.balanceModel').hide();
    groom();
}


$(document).ready(function () {

var locationNum = '',quality = '',grainType = '';
getapplyData();

/*供应页面条件查询*/
function getapplyData() {
    var searchParams = {};
    var searchName = $('#searchName').val();
    var startDate = $('#startDate').val();
    searchParams.type = grainType;

    searchParams.userName = encodeURI(searchName);
    searchParams.startDate = startDate;
    searchParams.endDate = startDate;
    searchParams.location = locationNum == '-1'?'':locationNum;
    searchParams.quality = quality;

  /*  console.log(searchParams);*/
    var res = Restful.get('bsgoodsinfo/findGoodsList',JSON.stringify(searchParams));
    if (res) {
        var data = res.dataList;
        var msg = $('#supply-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"supply": data});
        $("#supplylist").html(html);
        //$('.more-text').removeClass('hiden');
    } else {
        //$('.more').css('display', 'none');
        $("#applylist").html(
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

//打电话
$(document).on('click','.phone',function () {
    var phone = $(this).data('phone');
    window.location.href = 'tel:'+phone;
});

jQuery.noConflict();
jQuery('.addressSelete').citys({

    required:false,
    nodata:'disabled',
    onChange:function(data){
        console.log(data);
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
    quality = $('#quality').val();
    grainType = $('#grainType').val();
    getapplyData();
});
$('#supplylist').on('click','.card1',function () {

    var id = $(this).attr('data-id');
    var params = {};
    params.operateUserId = 0;
    params.targetType = 2;
    params.targetId = id;
    params.operateUserName = '';
    params.operateType = 1;
    var  res= Restful.post('bsclickcount',params);
    window.location.href = 'supplier.html?id='+id;
});

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
    window.location.href = 'supplier.html?id='+id;
});

/*供应推荐查询*/
        function groom() {
    var params ={};
    jsonParams = JSON.stringify(params);
    var res = Restful.get('bsadvertposition/list?type=2',jsonParams);
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

