/**
 * Created by luffy on 17-2-16.
 */
var isNewPerson = false;
var driverstate = false;
var userId = DES3.decrypt(localStorage.getItem('ud'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));
var locationText,locationNum;
//地址三级联动
$('.addressSelete').citys({
    required:false,
    nodata:'disabled',
    onChange:function(data){
        console.log(data);
        locationText = data.province+data.city+data.area;
        locationNum = data.code;
    }
});

//读取粮库
var depotRes = Restful.post('bsinventorydepot/getDepots',{userId:userId});
if(depotRes && depotRes.length != 0){
    var html = '';
    for(var i=0,len=depotRes.length;i<len;i++){
        html += '<li data-depot="'+depotRes[i].id+'">'+depotRes[i].name+'</li>';
    }
    $(".select").html('').append(html);
    $(".nav h2").html($(".select li").eq(0).text()+' <img src="accountData/img/select.png"/>');
    $(".select li").eq(0).addClass('depotChange');
}else{
    $(".select").html('').append('<li data-depot="0">默认库</li>');
    $(".nav h2").html($(".select li").eq(0).text()+' <img src="accountData/img/select.png/>');
    $(".select li").eq(0).addClass('depotChange');
}
$(".nav").click(function() {
    $(".balanceModel").fadeToggle();
});


/*筛选品种*/
$(".navRight").click(function(event){
    $(".type").fadeToggle();
    event.stopPropagation();/*阻止事件冒泡*/
})


$(".selectType").on('click','li',function () {
    var grainType = $(this).text();
    var grainTypeVal = $(this).val();

    if(grainType !="选择品种"){
        $(".grainType").html(grainType);
        $(".grainType").val(grainTypeVal);
    }
});
$(".grainType").val(1);

/******选择库**********/

$(".select").on('click','li',function () {

    var depotSel = $(this).text();
    $(this).addClass('depotChange').siblings().removeClass('depotChange');
    $(".nav h2").html(depotSel+'  <img src="accountData/img/select.png"/>');
});
//清除扣重默认值
$("#deduction").on('focus',function () {
    if($("#deduction").val() == 0 ||$("#deduction").val() == ''){
        $("#deduction").val('');
    }
});
/************************/
var select2Array = [],driverArray = [],licensePlate = ['无'],phoneArray = [''],driverPhone = [''];
var person = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:1,pageSize:1000});
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
$("#salePerson").select2({
    data:select2Array,
    templateResult: formatState
});
$("#driver").select2({
    data:driverArray,
    templateResult: formatState
});
$('#driver').on('change',function () {
    var idx = $('#driver').children('option:selected').index();
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
//初始化日期
$(function () {
    for (var i = 0; i < 24; i++) {
        var hourS = i;
        if (hourS < 10) {
            hourS = '0' + i;
        }
        $("#hour").append('<option value="' + hourS + '">' + hourS + '</option>');
    }
    for (var i = 0; i < 60; i++) {
        var hourS = i;
        if (hourS < 10) {
            hourS = '0' + i;
        }
        $("#minute").append('<option value="' + hourS + '">' + hourS + '</option>');
    }
    //获取日期和时间
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
    $("#hour").val(hour);
    $("#minute").val(minute);
});
//计算净重
function Calculation() {
    var grossWeightIn = $("#grossWeightIn").val();
    var tareWeightIn = $("#tareWeightIn").val();
    var unitPrice = $("#unitPrice").val();
    var deduction = $("#deduction").val();
    var netWeightIn = grossWeightIn - tareWeightIn - deduction;
    netWeightIn = netWeightIn.toFixed(2);
    var moneyIn = netWeightIn * unitPrice * 2;
    moneyIn = moneyIn.toFixed(2);
    $("#netWeightIn").val(netWeightIn);
    $("#moneyIn").val(moneyIn);
}
$("#grossWeightIn").on('input', function () {
    Calculation();
});

$("#tareWeightIn").on('input', function () {
    Calculation();
});

$("#unitPrice").on('input', function () {
    Calculation();
});
$("#deduction").on('input', function () {
    Calculation();
});
//切换粮食类型
$(".xmlist").show();
$(".meibian").hide();
$(".selectType").on('click','li',function () {

    var grainType = $(".grainType").val();
    if(grainType == 1){
        $(".xmlist").show();
        $(".meibian").hide();
    }else{
        $(".xmlist").hide();
        $(".meibian").show();
    }
});

//提交表单
$(document).on('click', '#submit', function () {
    var telTest = false;
    if (!checkForm()) {
        return false;
    }
    if ($("#submit").hasClass('disable')) {
        alert('不可重复提交');
        return;
    }

    $("#submit").addClass('disable');
    var date = $("#date").val();
    var params = {};
    var location = locationNum;
    var locationDesc = locationText;
    params.recordType = 1;
    params.userId = ownerId;
    params.operateUserId = userId;
    params.depotId = $(".depotChange").attr('data-depot');
    params.date = date;
    params.licensePlate = $("#licensePlate").val();
    params.bulkDensity = $("#rongzhong").val();
    params.imperfectGrains = $("#buwanshanli").val();
    params.moistureContent = $("#water").val();
    params.impurity = $("#impurity").val();
    params.mildew = $("#meibian").val();
    params.productQuality = $("#quality").val();
    params.remark = $("#remark").val();
    params.grainType = $(".grainType").val();
    params.unitPrice = $("#unitPrice").val();
    params.deduction = $("#deduction").val();
    params.varietyType = $("#varietyType").val();
    params.packingType = $("#packingType").val();
    params.productionNiafe = $("#productionNiafe").val();
    params.smell = $("#smell").val();
    params.grossWeightIn = $("#grossWeightIn").val();
    params.netWeightIn = $("#netWeightIn").val();
    params.tareWeightIn = $("#tareWeightIn").val();
    params.moneyIn = $("#moneyIn").val();

    if(params.grainType == 1){
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
    	if(params.grainType != 3){
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


    params.smell = $("#smell").val();
    if(location == undefined){
        location="";
    }
    if(locationDesc == undefined){
        locationDesc="";
    }
    params.location = location;
    params.locationDesc = locationDesc;
    if(driverstate){
        params.driverId = -100;
        params.driverName = $('#addDriver').val();
        params.driverPhone = $('#driverPhone').val();
        if(params.driverPhone != null && params.driverPhone != ''){
        	var telParams = {};
        	telParams.userId = ownerId;
        	telParams.staffType = 3;
        	telParams.phone = $("#driverPhone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else{
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
        	telParams.userId = ownerId;
        	telParams.staffType = 1;
        	telParams.phone = $("#phone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else {
        var staffId = $('#salePerson').val();

        if(staffId != 0){
            params.staffId = $('#salePerson').val();
            params.staffName = $("#salePerson option:selected").text();
            var idx = $('#salePerson').children('option:selected').index();
            params.staffPhone = phoneArray[idx];
        }else {
            params.staffId = '';
            params.staffName = '';
            params.staffPhone = '';
        }
    }

    if (!telTest) {
		var testName;
		$.each(depotRes, function(idx, item){
			if(depotRes[idx].id == $('.depotChange').attr('data-depot')){
				testName = depotRes[idx].name;
			}
		});
		if (window.confirm("确定要保存到"+testName+"库吗？")) {
            var res = Restful.post('bsinventoryrecord/insert', params);
			if (res.success) {

				Restful.operateRecord(res.retcode,1,11);
                $(".inFormSuccess").fadeToggle();
			} else {
				$("#submit").removeClass('disable');
				alert('提交失败，稍后再试');
			}
		}else{
            $("#submit").removeClass('disable');
        }
    }else{
        alert('送粮人手机号已存在');
        $("#submit").removeClass('disable');
    }
});

//暂存表单
$(document).on('click', '#temporary', function () {
    var telTest = false;
    if (!checkForms()) {
        return false;
    }
    if ($("#temporary").hasClass('disable')) {
        alert('不可重复提交');
        return;
    }
    $("#temporary").addClass('disable');
    var date = $("#date").val();
    var params = {};
    var location = locationNum;
    var locationDesc = locationText;
    params.recordType = 1;
    params.userId = ownerId;
    params.operateUserId = userId;
    params.depotId = $(".depotChange").attr('data-depot');
    params.date = date;
    params.licensePlate = $("#licensePlate").val();
    params.bulkDensity = $("#rongzhong").val();
    params.imperfectGrains = $("#buwanshanli").val();
    params.moistureContent = $("#water").val();
    params.impurity = $("#impurity").val();
    params.mildew = $("#meibian").val();
    params.productQuality = $("#quality").val();
    params.remark = $("#remark").val();
    params.grainType = $(".grainType").val();


    if( params.grainType == 1){
        if(params.productQuality != null && params.productQuality != ""  && params.productQuality*1 > 0){
        	if(params.bulkDensity == null || params.bulkDensity == "" ){
         		alert("请填写容重！");
     			$("#temporary").removeClass('disable');
     			return false;
         	 }
        	if(params.productQuality*1 == 1){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 790){
        			alert("质量与容重不匹配，容重必须大于等于 790！");
        			$("#temporary").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 2){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 770 ||  params.bulkDensity*1 > 790){
        			alert("质量与容重不匹配，容重必须大于等于 770，小于790！");
        			$("#temporary").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 3){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 750||  params.bulkDensity*1 > 770){
        			alert("质量与容重不匹配，容重必须大于等于 750，小于770！");
        			$("#temporary").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 4){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 730||  params.bulkDensity*1 > 750){
        			alert("质量与容重不匹配，容重必须大于等于 730，小于750！");
        			$("#temporary").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 5){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 710||  params.bulkDensity*1 > 730){
        			alert("质量与容重不匹配，容重必须大于等于 710，小于730！");
        			$("#temporary").removeClass('disable');
        			return false;
        		}
        	}else if(params.productQuality*1 == 6){
        		if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 > 710){
        			alert("质量与容重不匹配，容重必须小于 710！");
        			$("#temporary").removeClass('disable');
        			return false;
        		}
        	}
        }

    }else{
    	if( params.grainType != 3){
    		if(params.productQuality != null && params.productQuality != ""  && params.productQuality*1 > 0){
        		if(params.bulkDensity == null || params.bulkDensity == "" ){
        			alert("请填写容重！");
        			$("#temporary").removeClass('disable');
        			return false;
        		}
        		if(params.productQuality*1 == 1){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 720){
        				alert("质量与容重不匹配，容重必须大于等于 720！");
        				$("#temporary").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 2){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 685 || params.bulkDensity*1 > 720){
        				alert("质量与容重不匹配，容重必须大于等于 685，小于720！");
        				$("#temporary").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 3){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 650 || params.bulkDensity*1 > 685){
        				alert("质量与容重不匹配，容重必须大于等于 650，小于685！");
        				$("#temporary").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 4){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 620 || params.bulkDensity*1 > 650){
        				alert("质量与容重不匹配，容重必须大于等于 620，小于650！");
        				$("#temporary").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 5){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 < 590  || params.bulkDensity*1 > 620){
        				alert("质量与容重不匹配，容重必须大于等于 590，小于620！");
        				$("#temporary").removeClass('disable');
        				return false;
        			}
        		}else if(params.productQuality*1 == 6){
        			if(params.bulkDensity != null && params.bulkDensity != "" && params.bulkDensity*1 > 590){
        				alert("质量与容重不匹配，容重必须小于 590！");
        				$("#temporary").removeClass('disable');
        				return false;
        			}
        		}
        	}
    	}
    }



    params.grossWeightIn = $("#grossWeightIn").val();
    params.netWeightIn = $("#netWeightIn").val();
    params.tareWeightIn = $("#tareWeightIn").val();
    params.unitPrice = $("#unitPrice").val();
    params.moneyIn = $("#moneyIn").val();
    params.deduction = $("#deduction").val();
    params.varietyType = $("#varietyType").val();
    params.packingType = $("#packingType").val();
    params.productionNiafe = $("#productionNiafe").val();
    params.smell = $("#smell").val();
    if(location == undefined){
        location="";
    }
    if(locationDesc == undefined){
        locationDesc="";
    }
    params.location = location;
    params.locationDesc = locationDesc;
    if(driverstate){
        params.driverId = -100;
        params.driverName = $('#addDriver').val();
        params.driverPhone = $('#driverPhone').val();
        if(params.driverPhone != null && params.driverPhone != ''){
        	var telParams = {};
        	telParams.userId = ownerId;
        	telParams.staffType = 3;
        	telParams.phone = $("#driverPhone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else{
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
        $("#temporary").removeClass('disable');
        return;
    }
/*
    if(params.driverName == '' || params.driverName == null){
    	alert('司机不能为空！');
    	$("#temporary").removeClass('disable');
    	return false;
    }
*/

    if(isNewPerson){
        params.staffId = -100;
        params.staffName = $('#addPerson').val();
        params.staffPhone = $('#phone').val();
        if(params.staffPhone != null && params.staffPhone != ''){
        	var telParams = {};
        	telParams.userId = ownerId;
        	telParams.staffType = 1;
        	telParams.phone = $("#phone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else {
        var staffId = $('#salePerson').val();

        if(staffId != 0){
            params.staffId = $('#salePerson').val();
            params.staffName = $("#salePerson option:selected").text();
            var idx = $('#salePerson').children('option:selected').index();
            params.staffPhone = phoneArray[idx];
        }else {
            params.staffId = '';
            params.staffName = '';
            params.staffPhone = '';
        }
    }
    console.log(params);
    if (!telTest) {
            var res = Restful.post('bsInventoryTemporary/insert', params);
			if (res.success) {
				alert('暂存成功');
				window.location.href = 'noInFormMobile.html';
			} else {
				$("#temporary").removeClass('disable');
				alert('提交失败，稍后再试');
			}


    }else{
        alert('送粮人手机号已存在');
        $("#temporary").removeClass('disable');
    }
});





//表单验证
function checkForms() {
	var weightReg =  /^[1-9]\d*\.\d{0,2}|[1-9]\d*|0\.\d{0,2}|0$/;//00000000.00------11位
	var qualityReg =  /^[1-9]\d*\.\d{1}|[1-9]\d*|0\.\d{1}$/;//00.0---------------4位
	var priceReg =  /^[1-9]\d*\.\d{0,3}|[1-9]\d*|0\.\d{0,3}$/;//000.00-------------6位
	var grainType = $(".grainType").val();
	var date = $("#date").val();
	var hour = $("#hour").val();
	var minute = $("#minute").val();
	var time = hour + ':' + minute;
	var grossWeightIn = $("#grossWeightIn").val();
	var tareWeightIn = $("#tareWeightIn").val();
	var unitPrice = $("#unitPrice").val();

	if($("#grossWeightIn").val() == '' && $("#tareWeightIn").val() == ''){
		alert("毛重和皮重两项必填一项！");
		return false;
	}

	if($("#grossWeightIn").val() != null&& $("#grossWeightIn").val() != '' && !weightReg.test($("#grossWeightIn").val())){
		$("#grossWeightIn").siblings('p').html('毛重最多八位整数俩位小数');
		return false;
	}else{
		$("#grossWeightIn").siblings('p').html('');
	}
	if($("#tareWeightIn").val() != null && $("#tareWeightIn").val() != '' && !weightReg.test($("#tareWeightIn").val())){
		$("#tareWeightIn").siblings('p').html('皮重最多八位整数俩位小数');
		return false;
	}else{
		$("#tareWeightIn").siblings('p').html('');
	}

	/*var netWeightIn = grossWeightIn - tareWeightIn;
	if(netWeightIn < 0){
		alert('皮重不能大于毛重');
		return false;
	}*/

	if($("#addPerson").val() != '' && $("#phone").val() == ''){
		alert("请填写送粮人手机号");
		return false;
	}
	if($("#phone").val() != '' && $("#addPerson").val() == ''){
		alert("请填写送粮人姓名");
		return false;
	}
	 if ($("#addDriver").val() != '' && $("#driverPhone").val() == '') {
		   	alert("请填写司机手机号");
		   	return false;
	   }
	   if ($("#driverPhone").val() != '' && $("#addDriver").val() == '') {
		   	alert("请填写司机姓名");
		   	return false;
	   }
/*	if ($("#grossWeightIn").val() == '' || $("#grossWeightIn").val() <= 0) {
		alert('请填写毛重后提交');
		return false;
	}
	if ($("#tareWeightIn").val() == '' || $("#tareWeightIn").val() < 0) {
		alert('请填写皮重后提交');
		return false;
	}
	if ($("#unitPrice").val() == '') {
		alert('请填写单价后提交');
		return false;
	}*/
	if (!priceReg.test($("#unitPrice").val())) {
	//	alert('单价最多三位整数俩位小数');
	//	return false;
	}
	if ($("#water").val() != '' && !qualityReg.test($("#water").val())) {
		alert('水分最多俩位整数一位小数');
		return false;
	}
	if ($("#meibian").val() != '' && !qualityReg.test($("#meibian").val())) {
		alert('霉变最多俩位整数一位小数');
		return false;
	}
	if ($("#buwanshanli").val() != '' && !qualityReg.test($("#buwanshanli").val())) {
		alert('不完善粒最多俩位整数一位小数');
		return false;
	}
	if ($("#impurity").val() != '' && !qualityReg.test($("#impurity").val())) {
		alert('杂质最多俩位整数一位小数');
		return false;
	}
	return true;
}


//表单验证
function checkForm() {
    var weightReg =  /^[1-9]\d*\.\d{0,2}|[1-9]\d*|0\.\d{0,2}|0$/;//00000000.00------11位
    var qualityReg =  /^[1-9]\d*\.\d{1}|[1-9]\d*|0\.\d{1}$/;//00.0---------------4位
    var priceReg =  /^[1-9]\d*\.\d{0,3}|[1-9]\d*|0\.\d{0,3}$/;//000.00-------------6位
    var grainType = $(".grainType").val();
    var date = $("#date").val();
    var hour = $("#hour").val();
    var minute = $("#minute").val();
    var time = hour + ':' + minute;
    var grossWeightIn = $("#grossWeightIn").val();
    var tareWeightIn = $("#tareWeightIn").val();
    var unitPrice = $("#unitPrice").val();
    var netWeightIn = grossWeightIn - tareWeightIn;
    if(netWeightIn < 0){
        alert('皮重不能大于毛重');
        return false;
    }
   if($("#addPerson").val() != '' && $("#phone").val() == ''){
       alert("请填写送粮人手机号");
       return false;
   }
   if($("#phone").val() != '' && $("#addPerson").val() == ''){
       alert("请填写送粮人姓名");
       return false;
   }

   if ($("#addDriver").val() != '' && $("#driverPhone").val() == '') {
	   	alert("请填写司机手机号");
	   	return false;
   }
   if ($("#driverPhone").val() != '' && $("#addDriver").val() == '') {
	   	alert("请填写司机姓名");
	   	return false;
   }
    if ($("#grossWeightIn").val() == '' || $("#grossWeightIn").val() <= 0) {
        alert('请填写毛重后提交');
        return false;
    }
    if ($("#tareWeightIn").val() == '' || $("#tareWeightIn").val() < 0) {
        alert('请填写皮重后提交');
        return false;
    }
    if ($("#unitPrice").val() == '') {
        alert('请填写单价后提交');
        return false;
    }
    if (!weightReg.test($("#grossWeightIn").val())) {
        alert('毛重最多八位整数俩位小数');
        return false;
    }
    if (!weightReg.test($("#tareWeightIn").val())) {
        alert('皮重最多八位整数俩位小数');
        return false;
    }
    if (!priceReg.test($("#unitPrice").val())) {
        alert('单价最多三位整数俩位小数');
        return false;
    }
    if ($("#water").val() != '' && !qualityReg.test($("#water").val())) {
        alert('水分最多俩位整数一位小数');
        return false;
    }
    if ($("#meibian").val() != '' && !qualityReg.test($("#meibian").val())) {
        alert('霉变最多俩位整数一位小数');
        return false;
    }
    if ($("#buwanshanli").val() != '' && !qualityReg.test($("#buwanshanli").val())) {
        alert('不完善粒最多俩位整数一位小数');
        return false;
    }
    if ($("#impurity").val() != '' && !qualityReg.test($("#impurity").val())) {
        alert('杂质最多俩位整数一位小数');
        return false;
    }
    return true;
}
$(document).on('click','#change-add',function () {
    isNewPerson = true;
    $('#addPerson').val('');
    $('#salePerson').parent('label').css('display','none');
    $(".heiChange").css('height','4rem');
    $('#change-add').css('display','none');
    $('#addPerson').css('display','block');
    $('#phone').css('display','block');
    $('#change-sel').css('display','inline-block');
});
$(document).on('click','#change-sel',function () {
    isNewPerson = false;
    $('#salePerson').css('width','80%').parent('label').css('display','inline-block');
    $('#change-add').css('display','block');
    $('#addPerson').css('display','none');
    $(".heiChange").css('height','2rem');
    $('#phone').css('display','none');
    $('#change-sel').css('display','none');
});
$(document).on('click','#driver-add',function () {
    driverstate = true;
    $('#addDriver').val('');
    $('#driver').parent('label').css('display','none');
    $(".heiChange1").css('height','4rem');
    $('#driver-add').css('display','none');
    $('#addDriver').css('display','block');
    $('#driverPhone').css('display','block');
    $('#driver-sel').css('display','inline-block');
});
$(document).on('click','#driver-sel',function () {
    driverstate = false;
    $('#driver').css('width','80%').parent('label').css('display','inline-block');
    $('#driver-add').css('display','block');
    $('#addDriver').css('display','none');
    $(".heiChange1").css('height','2rem');
    $('#driverPhone').css('display','none');
    $('#driver-sel').css('display','none');
});

