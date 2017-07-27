/**
 * Created by new on 2017/3/28.
 */
$('#date').datetimepicker({
    startView:4,
    minView:2,
    todayBtn:true,
    todayHighlight:true,
    language:'zh-CN'
});
if (navigator.userAgent.indexOf('Firefox') >= 0){
    $('input[type=number]').on('DOMMouseScroll',function () {
        return false;
    });
}else{
    $('input[type=number]').on('mousewheel',function () {
        return false;
    });
}
var id = getQueryString('id');
var datas = Restful.get('bsInventoryTemporary/'+id);
var isNewPerson,driverstate,locationNum,locationText;
var recordType = datas.recordType;
var staffType;
var userId = DES3.decrypt(localStorage.getItem('userId'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));


//清除扣重默认值
$("#deduction").on('focus',function () {
    if($("#deduction").val() == 0 ||$("#deduction").val() == ''){
        $("#deduction").val('');
    }
});

if(datas.recordType == 1){
    $("title").html('入库单');
    $('#editType').text('入库单修改');
    $(".InOutdate > span").html('入库日期：');
    $(".savebtn").html('保存入库单');
    $(".perName").html("送粮人：");
    $(".paymsg").html("付款信息");
    var person = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:1,pageSize:1000});
    staffType = 1;
}else if(datas.recordType == 2){
    $("title").html('出库单');
    $('#editType').text('出库单修改');
    $(".InOutdate > span").html('出库日期：');
    $(".savebtn").html('保存出库单');
    $(".perName").html("买粮人：");
    $(".paymsg").html("收款信息");

    person = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:2,pageSize:1000});
    staffType = 2;
}

var select2Array = [],driverArray = [],licensePlate = ['无'],phoneArray = [''],driverPhone = [''];
if(person){
    if(person.success){
        var personArr = person.dataList;
        select2Array.push({id:0,text:'请选择',phone:''});
        $.each(personArr,function (index,val) {
            select2Array.push({id:val.staffId,text:val.trueName,phone:val.phone});
            phoneArray.push(val.phone);
        })
    }else {
        select2Array.push({id:0,text:'无',phone:''});
    }
}
$('#salePerson').select2({
    data: select2Array,
    templateResult: formatState
});



var driver = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:3,pageSize:1000});
if(driver){
    if(driver.success){
        var driverArr = driver.dataList;
        driverArray.push({id: 0, text: '请选择', phone: ''});
        $.each(driverArr,function (index,val) {
            driverArray.push({id: val.staffId, text: val.trueName, phone: val.phone});
            licensePlate.push(val.licensePlate);
            driverPhone.push(val.phone);
        })
    }else {
        driverArray.push({id:0,text:'无',phone:''});
    }
}



$('#driver').select2({
    data: driverArray,
    templateResult: formatState
});
$('#driver').on('change', function() {
    var idx = $('#driver').children('option:selected').index();
    if($('#licensePlate').val() == '' && licensePlate[idx]){
        $('#licensePlate').val(licensePlate[idx]);
    }
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



$("#date").val(datas.date);
/*var time = data.time;
 $("#hour").val(time.split(':')[0]);
 $("#minute").val(time.split(':')[1]);*/
$("#salePerson").val(datas.staffId).select2({
    data: select2Array,
    templateResult: formatState
});
$("#driver").val(datas.driverId).select2({
    data: driverArray,
    templateResult: formatState
});
$("#depot").val(datas.depotId);
$("#recordNumber").text('No.'+datas.recordNumber);
$("#licensePlate").val(datas.licensePlate);
$("#meibian").val(datas.mildew);
$("#deduction").val(datas.deduction?datas.deduction:0);
$("#varietyType").val(datas.varietyType);
$("#packingType").val(datas.packingType);
$("#productionNiafe").val(datas.productionNiafe);
$("#grainType").val(datas.grainType);


$("#smell").val(datas.smell);




if(datas.grainType == 1){
    $('.addressSelete').citys({
        required:false,
        nodata:'disabled',
        code:datas.location,
        onChange:function(data){
            console.log(data);
            locationText = data.province+data.city+data.area;
            locationNum = data.code;
        }
    });
    $('#grainType2').attr('checked',true);
    $(".grain").show();
    $(".notGrain").hide();
    $("#rongzhongxm").val(datas.bulkDensity);
    $("#buwanshanlixm").val(datas.imperfectGrains);
    $("#waterxm").val(datas.moistureContent);
    $("#impurityxm").val(datas.impurity);
    $("#qualityxm").val(datas.productQuality);
    $("#remarkxm").val(datas.remark);
}else if(datas.grainType == 2){
    $('#grainType1').attr('checked',true);
    $(".grain").hide();
    $(".notGrain").show();
    $("#rongzhong").val(datas.bulkDensity);
    $("#buwanshanli").val(datas.imperfectGrains);
    $("#water").val(datas.moistureContent);
    $("#impurity").val(datas.impurity);
    $("#quality").val(datas.productQuality);
    $("#remark").val(datas.remark);
}else{
    $('#grainType3').attr('checked',true);
    $(".grain").hide();
    $(".notGrain").show();
    $("#rongzhong").val(datas.bulkDensity);
    $("#buwanshanli").val(datas.imperfectGrains);
    $("#water").val(datas.moistureContent);
    $("#impurity").val(datas.impurity);
    $("#quality").val(datas.productQuality);
    $("#remark").val(datas.remark);
}

$("#grossWeightOut").val(recordType == 1?datas.grossWeightIn:datas.grossWeightOut);
$("#tareWeightOut").val(recordType == 1?datas.tareWeightIn:datas.tareWeightOut);

$("#netWeightOut").val(recordType == 1?datas.netWeightIn:datas.netWeightOut);
$("#unitPrice").val(datas.unitPrice);
$("#paidMoney").val(datas.paidMoney);
$("#moneyOut").val(recordType == 1?datas.moneyIn:datas.moneyOut);


//计算净重
function Calculation() {
    var grossWeightOut = $("#grossWeightOut").val();
    var tareWeightOut = $("#tareWeightOut").val();
    var unitPrice = $("#unitPrice").val();
    var deduction = $("#deduction").val();
    var netWeightOut = grossWeightOut - tareWeightOut- deduction;
    netWeightOut = netWeightOut.toFixed(2);
    var moneyOut = netWeightOut * unitPrice * 2;
    moneyOut = moneyOut.toFixed(2);
    $("#netWeightOut").val(netWeightOut);
    $("#moneyOut").val(moneyOut);
}
$("#grossWeightOut").keyup(function () {
    Calculation();
});

$("#tareWeightOut").keyup(function () {
    Calculation();
});

$("#unitPrice").keyup(function () {
    Calculation();
});
$("#deduction").keyup(function () {
    Calculation();
});

var nowDate = '';

//玉米小麦切换
$("input:radio").change(function () {
    if($("input:radio:checked").val() == 1){
//        $("#recordNumber").html('No.'+recordNumber1);
        $('.addressSelete').citys({
            required:false,
            nodata:'disabled',
            onChange:function(data){
                console.log(data);
                locationText = data.province+data.city+data.area;
                locationNum = data.code;
            }
        });
        $(".grain").show();
        $(".notGrain").hide();
    }else if($("input:radio:checked").val() == 2){
//        $("#recordNumber").html('No.'+recordNumber2);
        $(".notGrain").show();
        $(".grain").hide();
    }else{
//        $("#recordNumber").html('No.'+recordNumber3);
        $(".notGrain").show();
        $(".grain").hide();
    }
});



//表单验证
function checkForm() {
    var weightReg =  /^[1-9]\d*\.\d{0,2}|[1-9]\d*|0\.\d{0,2}|0$/;//00000000.00------11位
    var qualityReg =  /^[1-9]\d*\.\d{1}|[1-9]\d*|0\.\d{1}$/;//00.0---------------4位
    var priceReg =  /^[1-9]\d*\.\d{0,3}|[1-9]\d*|0\.\d{0,3}$/;//000.00-------------6位
    var grainType = $("input:radio:checked").val();
    var grossWeightOut = $("#grossWeightOut").val();
    var tareWeightOut = $("#tareWeightOut").val();
    var netWeightOut = grossWeightOut - tareWeightOut;
    if(netWeightOut < 0){
        alert('皮重不能大于毛重');
        return false;
    }
    if(recordType == 1){
   	 if($("#addPerson").val() != '' && $("#phone").val() == ''){
   	        alert("请填写送粮人手机号");
   	        return false;
   	    }
   	    if($("#phone").val() != '' && $("#addPerson").val() == ''){
   	        alert("请填写送粮人姓名");
   	        return false;
   	    }
   }else{
   	 if($("#addPerson").val() != '' && $("#phone").val() == ''){
   	        alert("请填写买粮人手机号");
   	        return false;
   	    }
   	    if($("#phone").val() != '' && $("#addPerson").val() == ''){
   	        alert("请填买粮人写姓名");
   	        return false;
   	    }
   }
   
    if($('#grainType').val() == 0){
        $("#grainType").siblings('p').html('请选择入库类型');
        return false;
    } else {
        $("#grainType").siblings('p').html('');
    }
    if($("#grossWeightOut").val() == '' || $("#grossWeightOut").val() <= 0){
        $("#grossWeightOut").siblings('p').html('请填写毛重后提交');
        return false;
    }else{
        $("#grossWeightOut").siblings('p').html('');
    }
    if($("#tareWeightOut").val() == '' || $("#tareWeightOut").val() < 0){
        $("#tareWeightOut").siblings('p').html('请填写皮重后提交');
        return false;
    }else{
        $("#tareWeightOut").siblings('p').html('');
    }
    if($("#unitPrice").val() == ''){
        $("#unitPrice").siblings('p').html('请填写单价后提交');
        return false;
    }else{
        $("#unitPrice").siblings('p').html('');
    }
    if(!weightReg.test($("#grossWeightOut").val())){
        $("#grossWeightOut").siblings('p').html('毛重最多八位整数俩位小数');
        return false;
    }else{
        $("#grossWeightOut").siblings('p').html('');
    }
    if(!weightReg.test($("#tareWeightOut").val())){
        $("#tareWeightOut").siblings('p').html('皮重最多八位整数俩位小数');
        return false;
    }else{
        $("#tareWeightOut").siblings('p').html('');
    }
    if(!priceReg.test($("#unitPrice").val())){
        $("#unitPrice").siblings('p').html('单价最多三位整数俩位小数');
        return false;
    }else{
        $("#unitPrice").siblings('p').html('');
    }
    
    if(grainType == 1){
   	 if($("#waterxm").val() != '' && !qualityReg.test($("#waterxm").val())){
	        $("#waterxm").siblings('p').html('水分最多俩位整数一位小数');
	        return false;
	    }else{
	        $("#waterxm").siblings('p').html('');
	    }
	    if($("#buwanshanlixm").val() != '' && !qualityReg.test($("#buwanshanlixm").val())){
	        $("#buwanshanlixm").siblings('p').html('不完善粒最多俩位整数一位小数');
	        return false;
	    }else{
	        $("#buwanshanlixm").siblings('p').html('');
	    }
	    if($("#impurityxm").val() != '' && !qualityReg.test($("#impurityxm").val())){
	        $("#impurityxm").siblings('p').html('杂质最多俩位整数一位小数');
	        return false;
	    }else{
	        $("#impurityxm").siblings('p').html('');
	    }
	    
   }else{
   
	    if($("#water").val() != '' && !qualityReg.test($("#water").val())){
	        $("#water").siblings('p').html('水分最多俩位整数一位小数');
	        return false;
	    }else{
	        $("#water").siblings('p').html('');
	    }
	    if($("#meibian").val() != '' && !qualityReg.test($("#meibian").val())){
	        $("#meibian").siblings('p').html('霉变最多俩位整数一位小数');
	        return false;
	    }else{
	        $("#meibian").siblings('p').html('');
	    }
	    if($("#buwanshanli").val() != '' && !qualityReg.test($("#buwanshanli").val())){
	        $("#buwanshanli").siblings('p').html('不完善粒最多俩位整数一位小数');
	        return false;
	    }else{
	        $("#buwanshanli").siblings('p').html('');
	    }
	    if($("#impurity").val() != '' && !qualityReg.test($("#impurity").val())){
	        $("#impurity").siblings('p').html('杂质最多俩位整数一位小数');
	        return false;
	    }else{
	        $("#impurity").siblings('p').html('');
	    }
	    
   }
    return true;
}

//提交表单
$("#submit").on('click', function () {
    if(!checkForm()){
        return false;
    }
    if ($("#submit").hasClass('disable')){
        return;
        alert('不可重复提交');
    }
    $("#submit").addClass('disable');
    var date = $("#date").val();
    /*var hour = $("#hour").val();
     var minute = $("#minute").val();
     var time = hour + ':' + minute;*/
    var params = {};
    params.id = datas.id;
    params.recordType = recordType;
    params.userId = ownerId;
    params.operateUserId = userId;
    params.depotId = $('#depot').val();
    params.recordNumber = $("#recordNumber").text().replace('No.','');
    params.date = date;
    params.licensePlate = $("#licensePlate").val();
    params.mildew = $("#meibian").val();

    var grainType = $("#grainType").val();
    if(grainType == 1){
        params.bulkDensity = $("#rongzhongxm").val();
        params.imperfectGrains = $("#buwanshanlixm").val();
        params.moistureContent = $("#waterxm").val();
        params.impurity = $("#impurityxm").val();
        params.productQuality = $("#qualityxm").val();
        params.remark = $("#remarkxm").val();
        params.smell = $("#smell").val();
        
        if(params.productQuality != null && params.productQuality != ""  && params.productQuality*1 > 0){
        	if(params.bulkDensity == null || params.bulkDensity == "" ){
         		alert("请填写容重！");
     			$("#submit").removeClass('disable');
     			return false;
         	 }
        	if(params.productQuality*1 == 1){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 790){
        			alert("质量与容重不匹配，容重必须大于等于 790！");
        			$("#submit").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 2){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 770 ||  params.bulkDensity*1 > 790){
        			alert("质量与容重不匹配，容重必须大于等于 770，小于790！");
        			$("#submit").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 3){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 750||  params.bulkDensity*1 > 770){
        			alert("质量与容重不匹配，容重必须大于等于 750，小于770！");
        			$("#submit").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 4){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 730||  params.bulkDensity*1 > 750){
        			alert("质量与容重不匹配，容重必须大于等于 730，小于750！");
        			$("#submit").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 5){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 710||  params.bulkDensity*1 > 730){
        			alert("质量与容重不匹配，容重必须大于等于 710，小于730！");
        			$("#submit").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 6){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 > 710){
        			alert("质量与容重不匹配，容重必须小于 710！");
        			$("#submit").removeClass('disable');
        			return false;
        		}
        	}
        }
    }else{
        params.bulkDensity = $("#rongzhong").val();
        params.imperfectGrains = $("#buwanshanli").val();
        params.moistureContent = $("#water").val();
        params.mildew = $("#meibian").val();
        params.impurity = $("#impurity").val();
        params.productQuality = $("#quality").val();
        params.remark = $("#remark").val();
        if(grainType != 3){
        	if(params.productQuality != null && params.productQuality != ""  && params.productQuality*1 > 0){
        		if(params.bulkDensity == null || params.bulkDensity == "" ){
        			alert("请填写容重！");
        			$("#submit").removeClass('disable');
        			return false;
        		}
        		if(params.productQuality*1 == 1){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 720){
        				alert("质量与容重不匹配，容重必须大于等于 720！");
        				$("#submit").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 2){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 685 || params.bulkDensity*1 > 720){
        				alert("质量与容重不匹配，容重必须大于等于 685，小于720！");
        				$("#submit").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 3){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 650 || params.bulkDensity*1 > 685){
        				alert("质量与容重不匹配，容重必须大于等于 650，小于685！");
        				$("#submit").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 4){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 620 || params.bulkDensity*1 > 650){
        				alert("质量与容重不匹配，容重必须大于等于 620，小于650！");
        				$("#submit").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 5){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 590  || params.bulkDensity*1 > 620){
        				alert("质量与容重不匹配，容重必须大于等于 590，小于620！");
        				$("#submit").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 6){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 > 590){
        				alert("质量与容重不匹配，容重必须小于 590！");
        				$("#submit").removeClass('disable');
        				return false;
        			}
        		}
        	}
        }
    }
    params.grainType = grainType;
    params.deduction = $("#deduction").val();
	params.varietyType = $("#varietyType").val();
	params.packingType = $("#packingType").val();
	params.productionNiafe = $("#productionNiafe").val();
	var location = locationNum;
	var locationDesc = locationText;
	if(location == undefined){
		location="";
	}
	if(locationDesc == undefined){
		locationDesc="";
	}
	params.location = location;
    params.locationDesc = locationDesc;
    
    if(recordType == 1){
        params.grossWeightIn = $("#grossWeightOut").val();
        params.tareWeightIn = $("#tareWeightOut").val();
        params.netWeightIn = $("#netWeightOut").val();
        params.moneyIn = $("#moneyOut").val();

    }else{
        params.grossWeightOut = $("#grossWeightOut").val();
        params.tareWeightOut = $("#tareWeightOut").val();
        params.netWeightOut = $("#netWeightOut").val();
        params.moneyOut = $("#moneyOut").val();
    }
    var telTest = false;
    if(driverstate){
        params.driverId = -100;
        params.driverName = $('#addDriver').val();
        params.driverPhone = $('#driverPhone').val();
        if(params.driverPhone != null && params.driverPhone != ''){
        	var telParams = {};
        	telParams.userId = userId;
        	telParams.staffType = 3;
        	telParams.phone = $("#driverPhone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else {
        var driverId = $('#driver').val();
        if(driverId != 0){
            params.driverId = driverId;
            params.driverName = $('#driver').find('option:selected').text();
            var idx = $('#driver').children('option:selected').index();
            params.driverPhone = driverPhone[idx];
        }else {
            params.driverId = '';
            params.driverName = '';
            params.driverPhone = '';
        }
    }
    if (!telTest) {
    }else{
        alert('司机手机号已存在');
        $("#submit").removeClass('disable');
        return;
    }
    if(isNewPerson){
        params.staffId = -100;
        params.staffName = $('#addPerson').val();
        params.staffPhone = $('#phone').val();
        if(params.staffPhone != null && params.staffPhone != ''){
        	var telParams = {};
        	telParams.userId = userId;
        	telParams.staffType = staffType;
        	telParams.phone = $("#phone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else {
        var staffId = $('#salePerson').val();
        if(staffId != 0){
            params.staffId = staffId;
            params.staffName = $('#salePerson').find('option:selected').text();
            var idx = $('#salePerson').children('option:selected').index();
            params.staffPhone = phoneArray[idx];
        }else {
            params.staffId = '';
            params.staffName = '';
            params.staffPhone = '';
        }
    }

    params.unitPrice = $("#unitPrice").val();
    params.paidMoney = $("#paidMoney").val();

    /*司机和送粮人至少填一项*/
/*    if ((params.driverName == '' || params.driverName == null) && (params.staffName == '' || params.staffName == null)) {
        if(datas.recordType == 1){
            alert('司机和送粮人至少填一项！');
        }else{
            alert('司机和买粮人至少填一项！');
        }
        $("#submit").removeClass('disable');
        return false;
    }
    console.log(params);*/
    if (!telTest) {
        var res = Restful.post('bsinventoryrecord/insert',params);
        if(res.success){
        	alert('保存成功');
            if(recordType == 1){
                window.location.href = 'inTable.html';
                localStorage.setItem('hrefType','inTable');
            }else {
            	window.location.href = 'outTable.html';
                localStorage.setItem('hrefType','outTable');
            }
        }else{
        	alert('提交失败，稍后再试');
            $("#submit").removeClass('disable');
        }
    }else{
        if(datas.recordType == 1){
            alert('送粮人手机号已存在');
        }else{
            alert('买粮人手机号已存在');
        }
        $("#submit").removeClass('disable');
    }
});


function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);  //获取url中"?"符后的字符串并正则匹配
    var context = "";
    if (r != null)
        context = r[2];
    reg = null;
    r = null;
    return context == null || context == "" || context == "undefined" ? "" : context;
}
$(document).on('blur', '.form-article input:not([id="date"])', function() {
    if ($(this).val()) {
        $(this).nextAll('p').html('');
    }
});

$('.add-person').click(function () {
    $('.addPerson').show();
    if(recordType == 1){
        $('.addpersontitle').html('添加送粮人');
    }else{
        $('.addpersontitle').html('添加买粮人');
    }
    $('.form-modal input').val('');
});
$('.addPersonbtn').click(function () {
    var name = $(this).parents('.modal-container').find('.addname').val();
    var phone = $(this).parents('.modal-container').find('.addphone').val();
    if(!name){
        alert('请输入姓名');
        return;
    }
    if(!phone){
        alert('请输入电话');
        return;
    }
    $("#addPerson").val(name);z
    $("#phone").val(phone);
    var params = {};
    params.userId = ownerId;
    params.staffType = staffType;
    params.trueName = name;
    params.phone = phone;
    params.idCard = '';
    params.cardNumber = '';
    params.company = '';
    params.remark = '';
    var result = Restful.post('bsinventorystaff',params);
    if(result&&result.success){
        var person = Restful.post('bsinventorystaff/list', {userId: ownerId, staffType: staffType, pageSize: 1000});
        if (person&&person.success) {
            var personArr = person.dataList;
            select2Array = [];
            select2Array.push({id: 0, text: '请选择', phone: ''});
            $.each(personArr, function(index, val) {
                select2Array.push({id: val.staffId, text: val.trueName, phone: val.phone});
                phoneArray.push(val.phone);
            });
        }else{
            alert('添加失败，稍后再试');
        }
        $('#salePerson').select2({
            data: select2Array,
            templateResult: formatState
        });
        $('#salePerson').val($('#salePerson option:last-child').val()).select2({
            data: select2Array,
            templateResult: formatState
        });
    }else{
        alert('添加失败，稍后再试');
    }
    $('.addPerson').hide();
});
$('.addPersoncencel').click(function () {
    $('.form-modal').hide();
});
$('.add-driver').click(function () {
    $('.addDriver').show();
    $('.form-modal input').val('');
});
$('.addDriverbtn').click(function () {
    var name = $(this).parents('.modal-container').find('.addname').val();
    var phone = $(this).parents('.modal-container').find('.addphone').val();
    if(!name){
        alert('请输入姓名');
        return;
    }
    if(!phone){
        alert('请输入电话');
        return;
    }
    $("#addDriver").val(name);
    $("#driverPhone").val(phone);
    var params = {};
    params.userId = ownerId;
    params.staffType = 3;
    params.trueName = name;
    params.phone = phone;
    params.idCard = '';
    params.cardNumber = '';
    params.company = '';
    params.remark = '';
    var result = Restful.post('bsinventorystaff',params);
    if(result&&result.success){
        var driver = Restful.post('bsinventorystaff/list', {userId: ownerId, staffType: 3, pageSize: 1000});
        if (driver&&driver.success) {
            var driverArr = driver.dataList;
            driverArray.push({id: 0,text: '请选择',phone: ''});
            $.each(driverArr, function(index, val) {
                driverArray.push({id: val.staffId,text: val.trueName,phone: val.phone});
                licensePlate.push(val.licensePlate);
                driverPhone.push(val.phone);
            });
        }else{
            alert('添加失败，稍后再试');
        }
        $('#driver') .select2({
            data: driverArray,
            templateResult: formatState
        });
        $('#driver').val($('#driver option:last-child').val()).select2({
            data: driverArray,
            templateResult: formatState
        });
    }else{
        alert('添加失败，稍后再试');
    }
    $('.addDriver').hide();
});
$('.addDrivercencel').click(function () {
    $('.form-modal').hide();
});
function numberCtrl(a,num) {
    var val = $(a).val();
    var ling = val.split('.');
    if(ling.length>1){
        if(ling[1].length>num){
            ling[1] = ling[1].substring(0,num);
        }
        $(a).val(ling[0]+'.'+ling[1]);
    }
}

var str = $("#paidMoney").val();
$("#paidMoney").blur(function(){
    var str = $("#paidMoney").val();

    if(str.substr(0,1)==0 || str.substr(0,1) =="-"){
        str = str.replace(/^[0,-]*/g,'');

        $("#paidMoney").val(str) ;
    }
})