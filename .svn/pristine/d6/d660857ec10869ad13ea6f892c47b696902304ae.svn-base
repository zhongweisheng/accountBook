/**
 * Created by new on 2017/5/22.
 */
/**
 * Created by luffy on 17-2-16.
 */
var mlbUserId = localStorage.getItem('mlbUserId');
if(!mlbUserId){
    window.location.href='entry.html?type=9';
}

var $$ = $.noConflict();
var locationText,locationNum = 0;
//地址三级联动
$$('.addressSelete').citys({
    required:false,
    nodata:'disabled',
    onChange:function(data){
        console.log(data);
        locationText = data.province+data.city+data.area;
        locationNum = data.code;
    }
});


//控制输入的容重
var cornRange = [720,[685,719],[650,684],[620,649],[590,619]];
var wheatRange = [790,[770,789],[750,769],[730,749],[710,729]];

function weightRange(range,type) {
    var quality = Math.floor($("#quality").val());
    var weight = Math.floor($("#weight").val());
    if (quality == 1){
        if(weight < range){
            $.alert('输入范围：≥'+range);
            $("#weight").val('');
        }
    }else{
        if(weight < type[quality-1][0] || weight >= type[quality-1][1]){
            $.alert('输入范围：'+type[quality-1][0]+'~'+type[quality-1][1]);
            $("#weight").val('');
        }
    }
}


$("#weight").on('change',function () {
    //选择的质量
    var grainType = Math.floor($("#cropsType").val());
    if(grainType == 2){
        weightRange(720,cornRange);
    }else{
        weightRange(790,wheatRange);
    }
});

var delay = 500;
var qtime = new Date();
$('#quality').on('focus',function(){
    qtime = new Date();
}).on('blur',function(e){
    if(new Date().getTime()-qtime.getTime()<delay){
        $('#quality').focus();
    }
});

function weightRange2(range,type) {
    var quality = Math.floor($("#quality").val());
    var weight = Math.floor($("#weight").val());
    if(quality == 1){
        if(weight < range && weight > 0){
            $.alert('输入范围：≥'+range);
            $("#weight").val('');
        }
        $("#weight").attr("placeholder","输入范围：≥"+type[quality-1]);
    }else{
        if((weight > 0 &&weight < type[quality-1][0]) || weight >= type[quality-1][1]){
            $.alert('输入范围：'+type[quality-1][0]+'~'+type[quality-1][1]);
            $("#weight").val('');
        }
        $("#weight").attr("placeholder","输入范围："+type[quality-1][0]+"~"+type[quality-1][1]);
    }
}
// 容重联动
function weightChange() {
    var grainType = Math.floor($("#cropsType").val());
    if(grainType == 2){
        weightRange2(720,cornRange);
    }else{
        weightRange2(790,wheatRange);
    }
}
$("#cropsType,#quality").on('change',function () {
    weightChange();
});





$(".right").click(function () {

    if(!checkForm()){
        return false;
    }
    if($(this).hasClass('disabled')){
        return;
    }
    $(this).addClass('disabled');
    var params = {};
    params.userId = mlbUserId;
    params.foodType = $("#cropsType").val();

    /*是否委托*/
   /* params.serviceType = $("#serviceType").val();*/
    params.foodNum = $("#ton").val();
    params.foodPrice = $("#price").val();
    params.locationDesc = locationText;
    params.location = locationNum;
    params.address = $("#address").val();
    params.grainLevel = $("#quality").val();
    if($("#cropsType").val() ==2){
        params.ATTR_7 = $("#water").val();
        params.ATTR_13 = $("#weight").val();
        params.ATTR_5 = $("#mildew").val();
        params.ATTR_15 = $("#noperfect").val();
        params.ATTR_16 = $("#impurity").val();
        params.ATTR_14 = $("#qremarks").val();
        params.foodRequire = "水分(%):"+params.ATTR_7+",容重(g/l):"+params.ATTR_13+",生霉粒(%):"+params.ATTR_5+",不完善粒(%):"+params.ATTR_15+",杂质(%):"+params.ATTR_16+",品质备注："+params.ATTR_14;
    }else{
        params.ATTR_6 = $("#water").val();
        params.ATTR_8 = $("#weight").val();
        params.ATTR_10 = $("#mildew").val();
        params.ATTR_17 = $("#noperfect").val();
        params.ATTR_18 = $("#impurity").val();
        params.ATTR_11 = $("#qremarks").val();
        params.foodRequire = "水分(%):"+params.ATTR_6+",容重(g/l):"+params.ATTR_8+",生霉粒(%):"+params.ATTR_10+",不完善粒(%):"+params.ATTR_17+",杂质(%):"+params.ATTR_18+",品质备注："+params.ATTR_11;
    }
    params.remark = $("#remarks").val();
    params.hasInvoice = $("#invoice").val();
    params.hasLogistics = $("#logistics").val();


    var res = Restful.post('bsgoodsinfo',params);
    if(res&&res.success){
        window.location.href = "Tradeleads.html";
    }else{
        $.toast("操作失败");
        $(this).removeClass('disabled');
    }
});


$.init();


function checkForm() {

    var reg =  /^[1-9]\d?(\.\d{1}|0\.\d{1})?$/;
    if(!$("#ton").val()){
        $.toast('请输入数量');
        return false;
    }

    if(!locationNum){
        $.toast('请输入发货地址');
        return false;
    }
    if(!$("#price").val() || $("#price").val() > 2800 || $("#price").val() < 900){
        $.toast('请输入正确价格');
        $("#price").val('');
        return false;
    }

    if(!$("#address").val()){
        $.toast('请输入详细地址');
        return false;
    }

    if(!$("#water").val()){
        $.toast('请输入水分');
        return false;
    }
    if(!reg.test($("#water").val())){
        $.toast('输入正确水分格式,整数或者一位小数');
        $("#water").val('');
        return false;
    }
    if(!$("#weight").val()){
        $.toast('请输入容重');
        return false;
    }

    if(!$("#mildew").val()){
        $.toast('请输入生霉粒');
        return false;
    }
    if(!reg.test($("#mildew").val())){
        $.toast('输入正确生霉粒格式,整数或者一位小数');
        $("#mildew").val('');
        return false;
    }
/*    if(!$("#impurity").val()){
        $.toast('请输入杂质');
        return false;
    }
    if(!reg.test($("#impurity").val())){
        $.toast('输入正确杂质格式,整数或者一位小数');
        $("#impurity").val('');
        return false;
    }
    if($("#noperfect").val() != null){
        if(!reg.test($("#noperfect").val())){
            $.toast('输入正确不完善粒格式,整数或者一位小数');
            $("#noperfect").val('');
            return false;
        }
    }*/
    return true;
}

