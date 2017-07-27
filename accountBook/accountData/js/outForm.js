 /**
 * Created by new on 2017/3/28.
 */
 //日历插件初始化
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
var userId = DES3.decrypt(localStorage.getItem('userId'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));
var isNewPerson,driverstate,locationNum,locationText;
//清除扣重默认值
$("#deduction").on('focus',function () {
	if($("#deduction").val() == 0 ||$("#deduction").val() == ''){
	        $("#deduction").val('');
	}
});

//获取单号，称重日期，时间
var select2Array = [],driverArray = [],licensePlate = ['无'],phoneArray = [''],driverPhone = [''];
var person = Restful.post('bsinventorystaff/list',{userId:ownerId,staffType:2,pageSize:1000});
if(person){
    if(person.success){
        var personArr = person.dataList;
        select2Array.push({id:0,text:'请选择',phone:''});
        $.each(personArr,function (index,val) {
            select2Array.push({id:val.staffId,text:val.trueName,phone:val.phone});
            phoneArray.push(val.phone);
        })
    }else {
        select2Array.push({id:0,text:'',phone:''});
    }
}
$("#buyPerson").select2({
    data:select2Array,
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
        driverArray.push({id:0,text:'',phone:''});
    }
}
$('#driver').select2({
    data: driverArray,
    templateResult: formatState
});
 $('#driver').on('change', function() {
     var idx = $('#driver').children('option:selected').index();
     $('#licensePlate').val(licensePlate[idx]);
     /*选中司机 出现默认车牌号*/
   /*  if($('#licensePlate').val() == '' && licensePlate[idx]){
         $('#licensePlate').val(licensePlate[idx]);
     }*/
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
}

//初始化日期
$(function () {
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
});

//计算净重
function Calculation() {
    var grossWeightOut = $("#grossWeightOut").val();
    var tareWeightOut = $("#tareWeightOut").val();
    var unitPrice = $("#unitPrice").val();
    var deduction = $("#deduction").val();
    var netWeightOut = grossWeightOut - tareWeightOut - deduction;
    netWeightOut = netWeightOut.toFixed(2);
    var moneyOut = netWeightOut * unitPrice * 2;
    moneyOut = moneyOut.toFixed(2);
    $("#netWeightOut").val(netWeightOut);
    $("#moneyOut").val(moneyOut);
}
 $("#grossWeightOut,#tareWeightOut,#unitPrice,#deduction").keyup(function() {
     Calculation();
 });

 $(".grain").show();
 $(".notGrain").hide();
 //玉米小麦切换
 $("#grainType").on('change',function() {
     if($(this).val() == 0){
         $(this).siblings('p').html('请选择入库类型');
         return false;
     }else if ($(this).val() == 1){
         $(".grain").show();
         $(".notGrain").hide();
         $("this").siblings('p').html('');
     }else{
         $(".notGrain").show();
         $(".grain").hide();
         $("this").siblings('p').html('');
     }
 });

$('.addressSelete').citys({
    required:false,
    nodata:'disabled',
    onChange:function(data){
        console.log(data);
        locationText = data.province+data.city+data.area;
        locationNum = data.code;
    }
});
//表单验证
function checkForm() {
	var weightReg =  /^[1-9]\d*\.\d{0,2}|[1-9]\d*|0\.\d{0,2}|0$/;//00000000.00------11位
    var qualityReg =  /^[1-9]\d*\.\d{1}|[1-9]\d*|0\.\d{1}$/;//00.0---------------4位
    var priceReg =  /^[1-9]\d*\.\d{0,3}|[1-9]\d*|0\.\d{0,3}$/;//000.00-------------6位
    var grainType = $("#grainType").val();
    var date = $("#date").val();
    /*var hour = $("#hour").find('option:selected').val();
    var minute = $("#minute").find('option:selected').val();
     var time = hour + ':' + minute;*/
    var grossWeightOut = $("#grossWeightOut").val();
    var tareWeightOut = $("#tareWeightOut").val();
    var netWeightOut = grossWeightOut - tareWeightOut;
    if(netWeightOut < 0){
        alert('皮重不能大于毛重');
        return false;
    }
    if($("#addPerson").val() != '' && $("#phone").val() == ''){
        alert("请填写买粮人手机号");
        return false;
    }
    if($("#phone").val() != '' && $("#addPerson").val() == ''){
        alert("请填写买粮人姓名");
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
    if($("#unitPrice").val() == '' || $("#unitPrice").val() < 0){
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
        $("#unitPrice").siblings('p').html('单价最多三位整数三位小数');
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
        alert('不可重复提交');
        return;
    }
    $("#submit").addClass('disable');
    var date = $("#date").val();
    var params = {};
    var location = locationNum;
	var locationDesc = locationText;
    params.recordType = 2;
    params.userId = ownerId;
    params.operateUserId = userId;
    params.depotId = $('#depot').val();
    params.recordNumber = $("#recordNumber").text().replace('No.', '');
    params.date = date;
    params.licensePlate = $("#licensePlate").val();


    var grainType = $("#grainType").val();
    if(grainType == 1){
        params.bulkDensity = $("#rongzhongxm").val();
        params.imperfectGrains = $("#buwanshanlixm").val();
        params.moistureContent = $("#waterxm").val();
        params.impurity = $("#impurityxm").val();
        params.productQuality = $("#qualityxm").val();
        params.remark = $("#remarkxm").val();
        
        
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
        params.impurity = $("#impurity").val();
        params.mildew = $("#meibian").val();
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

    params.grossWeightOut = $("#grossWeightOut").val();
    params.tareWeightOut = $("#tareWeightOut").val();
    params.netWeightOut = $("#netWeightOut").val();
    params.unitPrice = $("#unitPrice").val();
    params.moneyOut = $("#moneyOut").val();
    params.paidMoney = $("#paidMoney").val();

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
        	telParams.userId = userId;
        	telParams.staffType = 2;
        	telParams.phone = $("#phone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else {
        var staffId = $('#buyPerson').val();

        if(staffId != 0){
            params.staffId = staffId;
            params.staffName = $('#buyPerson').find('option:selected').text();
            var idx = $('#buyPerson').children('option:selected').index();
            params.staffPhone = phoneArray[idx];
        }else {
            params.staffId = '';
            params.staffName = '';
            params.staffPhone = '';
        }
    }
/*司机和买粮人至少填一项*/
/*    if ((params.driverName == '' || params.driverName == null) && (params.staffName == '' || params.staffName == null)) {
        alert('司机和买粮人至少填一项！');
        $("#submit").removeClass('disable');
        return false;
    }*/
    $("#submit").addClass('disable');
    if (!telTest) {
   	var vs = $('#depot option:selected').html();
        if (window.confirm("确定要保存到"+vs+"库吗？")) {
            var res = Restful.post('bsinventoryrecord/insert', params);
            if (res.success) {
                alert('保存成功');
                Restful.operateRecord(res.retcode,2,21);
                var id = res.retcode;
                window.location.href = 'outFormSuccess.html?id='+id;
                localStorage.setItem('hrefType','outTable');
            } else {
                $("#submit").removeClass('disable');
                alert('提交失败，稍后再试');
            }
            return true;
        } else {
            $("#submit").removeClass('disable');
            return false;
        }
    } else {
        alert('买粮人手机号已存在');
        $("#submit").removeClass('disable');
    }
});



//表单验证
function checkForms() {
	var weightReg =  /^[1-9]\d*\.\d{0,2}|[1-9]\d*|0\.\d{0,2}|0$/;//00000000.00------11位
	var qualityReg =  /^[1-9]\d*\.\d{1}|[1-9]\d*|0\.\d{1}$/;//00.0---------------4位
	var priceReg =  /^[1-9]\d*\.\d{0,3}|[1-9]\d*|0\.\d{0,3}$/;//000.00-------------6位
    var grainType = $("#grainType").val();
	var date = $("#date").val();
	
	if($("#grossWeightOut").val() == '' && $("#tareWeightOut").val() == ''){
		alert("毛重和皮重两项必填一项！");
		return false;
	}
	
	
	 if($("#grossWeightOut").val() != null&& $("#grossWeightOut").val() != '' && !weightReg.test($("#grossWeightOut").val())){
	        $("#grossWeightOut").siblings('p').html('毛重最多八位整数俩位小数');
	        return false;
	    }else{
	        $("#grossWeightOut").siblings('p').html('');
	    }
	    if($("#tareWeightOut").val() != null && $("#tareWeightOut").val() != '' && !weightReg.test($("#tareWeightOut").val())){
	        $("#tareWeightOut").siblings('p').html('皮重最多八位整数俩位小数');
	        return false;
	    }else{
	        $("#tareWeightOut").siblings('p').html('');
	    }

 	if($("#addPerson").val() != '' && $("#phone").val() == ''){
        alert("请填写买粮人手机号");
        return false;
    }
    if($("#phone").val() != '' && $("#addPerson").val() == ''){
        alert("请填写买粮人姓名");
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

    if($('#grainType').val() == 0){
        $("#grainType").siblings('p').html('请选择入库类型');
        return false;
    } else {
        $("#grainType").siblings('p').html('');
    }
	
	if(!priceReg.test($("#unitPrice").val())){
		//$("#unitPrice").siblings('p').html('单价最多三位整数三位小数');
		//return false;
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
$("#temporary").on('click', function () {
	if(!checkForms()){
		return false;
	}
	if ($("#temporary").hasClass('disable')){
		alert('不可重复提交');
		return;
	}
	$("#temporary").addClass('disable');
	var date = $("#date").val();
	var params = {};
	var location = locationNum;
	var locationDesc = locationText;
	params.recordType = 2;
	params.userId = ownerId;
    params.operateUserId = userId;
    params.depotId = $('#depot').val();
	params.recordNumber = $("#recordNumber").text().replace('No.', '');
	params.date = date;
	params.licensePlate = $("#licensePlate").val();

    var grainType = $("#grainType").val();
    if(grainType == 1){
        params.bulkDensity = $("#rongzhongxm").val();
        params.imperfectGrains = $("#buwanshanlixm").val();
        params.moistureContent = $("#waterxm").val();
        params.impurity = $("#impurityxm").val();
        params.productQuality = $("#qualityxm").val();
        params.remark = $("#remarkxm").val();
        
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
        params.bulkDensity = $("#rongzhong").val();
        params.imperfectGrains = $("#buwanshanli").val();
        params.moistureContent = $("#water").val();
        params.impurity = $("#impurity").val();
        params.mildew = $("#meibian").val();
        params.productQuality = $("#quality").val();
        params.remark = $("#remark").val();
        
        if(grainType != 3){
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
    params.grainType = grainType;

    params.grossWeightOut = $("#grossWeightOut").val();
    params.tareWeightOut = $("#tareWeightOut").val();
    params.netWeightOut = $("#netWeightOut").val();
    params.unitPrice = $("#unitPrice").val();
    params.moneyOut = $("#moneyOut").val();
    params.paidMoney = $("#paidMoney").val();

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
	

	
	if(isNewPerson){
		params.staffId = -100;
		params.staffName = $('#addPerson').val();
		params.staffPhone = $('#phone').val();
		if(params.staffPhone != null && params.staffPhone != ''){
			var telParams = {};
			telParams.userId = userId;
			telParams.staffType = 2;
			telParams.phone = $("#phone").val();
			telTest = Restful.post('bsinventorystaff/isExist', telParams);
		}
	}else {
		var staffId = $('#buyPerson').val();
		
		if(staffId != 0){
			params.staffId = staffId;
			params.staffName = $('#buyPerson').find('option:selected').text();
            var idx = $('#buyPerson').children('option:selected').index();
            params.staffPhone = phoneArray[idx];
		}else {
			params.staffId = '';
			params.staffName = '';
            params.staffPhone = '';
		}
	}
	/*司机和送粮人至少填一项*/
/*    if ((params.driverName == '' || params.driverName == null) && (params.staffName == '' || params.staffName == null)) {
        alert('司机和买粮人至少填一项！');
        $("#temporary").removeClass('disable');
        return false;
    }*/
	//console.log(params);
	if (!telTest) {
		var res = Restful.post('bsInventoryTemporary/insert', params);
		if (res.success) {
				alert('暂存成功');
				window.location.href = 'noOutForm.html';
            localStorage.setItem('hrefType','noOutForm');

		} else {
			alert('提交失败，稍后再试');
			$("#temporary").removeClass('disable');
		}
	}else{
		alert('买粮人手机号已存在');
		$("#temporary").removeClass('disable');
	}
});
 $(document).on('blur', '.form-article input:not([id="date"])', function() {
     if ($(this).val()) {
         $(this).nextAll('p').html('');
     }
 });

 $('.add-person').click(function () {
     $('.addPerson').show();
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
     $("#addPerson").val(name);
     $("#phone").val(phone);
     var params = {};
     params.userId = ownerId;
     params.staffType = 2;
     params.trueName = name;
     params.phone = phone;
     params.idCard = '';
     params.cardNumber = '';
     params.company = '';
     params.remark = '';
     var result = Restful.post('bsinventorystaff',params);
     if(result&&result.success){
         var person = Restful.post('bsinventorystaff/list', {userId: ownerId, staffType: 2, pageSize: 1000});
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
         $('#buyPerson').select2({
             data: select2Array,
             templateResult: formatState
         });
         $('#buyPerson').val($('#buyPerson option:last-child').val()).select2({
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
         $('#driver').select2({
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
        var result = ling[0]+'.'+ling[1];

        $(a).val(result+'');
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

