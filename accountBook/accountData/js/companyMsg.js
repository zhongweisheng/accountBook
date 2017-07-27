var locationNum,locationText,companyId;
$(".leftContent > div:nth-child(8)> p:nth-child(2)").addClass("left_active");
$(".leftContent > div:nth-child(7)").addClass("left_active");
$(".child").eq(3).css('display', 'block');
$('.addressSelete').citys({
    required:false,
    nodata:'disabled',
    onChange:function(data){
        console.log(data);
        locationText = data.province+data.city+data.area;
        locationNum = data.code;
    }
});
var userId = DES3.decrypt(localStorage.getItem('userId'));



var result = Restful.get('/bsinventorycompany/getCompanyByOwnerId/'+userId);
// var result = Restful.get('bsinventorycompany/'+userId);

$('#isUseCom').change(function () {
    var isUseCom = $('#isUseCom').prop('checked');
    if(isUseCom){
        var companyName = $('#companyName').val();
        $('#printHead').val(companyName);
    }else{
        $('#printHead').val('');
    }
});

if(result){
    $('#companyName').val(result.companyName);
    if(result.location){
        $('.addressSelete').citys({
            required:false,
            nodata:'disabled',
            code:result.location,
            onChange:function(data){
                console.log(data);
                locationText = data.province+data.city+data.area;
                locationNum = data.code;
            }
        });
    }else {
        $('.addressSelete').citys({
            required:false,
            nodata:'disabled',
            onChange:function(data){
                console.log(data);
                locationText = data.province+data.city+data.area;
                locationNum = data.code;
            }
        });
    }
    $('#address').val(result.address);
    $('#printHead').val(result.printHead);
    companyId = result.id;
}




$(document).on('click','#submit',function () {
    var companyName = $('#companyName').val();
    var location = locationNum;
    var locationDesc = locationText;
    var address = $('#address').val();
    var printHead = $('#printHead').val();
    var params = {};
   // params.id = companyId;
    params.companyName = companyName;
    params.location = location;
    params.locationDesc = locationDesc;
    params.address = address;
    params.printHead = printHead;
    var result = Restful.post('bsinventorycompany/'+companyId,params);
    $(this).addClass('disable');
    if(result){
        if(result.success){
            alert('设置成功');
            $(this).removeClass('disable');
        }else {
            alert('设置不成功');
            $(this).removeClass('disable');
        }
    }else {
        alert('请求失败,请稍后再试');
        $(this).removeClass('disable');
    }
});
