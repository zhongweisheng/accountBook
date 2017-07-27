/**
 * Created by new on 2017/3/28.
 */
$('#change-add').css('display','none');
$('#driver-add').css('display','none');
var id = getQueryString('id');
var userId = DES3.decrypt(localStorage.getItem('ud'));
var ownerId = DES3.decrypt(localStorage.getItem('ownerId'));
// var userId = 1000;
var isNewPerson = false;
var driverstate = false;
var locationText,locationNum;
var data = Restful.get('bsInventoryStorageTemp/'+id);
/*recordType  1： 入库  2： 出库 3 ：代储 */
var recordType = data.recordType;


//读取粮库
var depotRes = Restful.post('bsinventorydepot/getDepots',{userId:userId});
if(depotRes && depotRes.length != 0){
    var html = '';
    for(var i=0,len=depotRes.length;i<len;i++){
        html += '<li data-depot="'+depotRes[i].id+'">'+depotRes[i].name+'</li>';
    }
    $(".select").html('').append(html);
    $(".select li").each(function (idx,val) {
        if($(val).attr('data-depot') == data.depotId){
            $(".nav h2").html($(".select li").eq(idx).text());
            $(".select li").eq(idx).addClass('depotChange');
        }
    });
}else{
    $(".select").html('').append('<li data-depot="0">默认库</li>');
    $(".select li").each(function (idx,val) {
        if($(val).attr('data-depot') == data.depotId){
            $(".nav h2").html($(".select li").eq(idx).text());
            $(".select li").eq(idx).addClass('depotChange');
        }
    });
}


//清除扣重默认值
$("#deduction").on('focus',function () {
    if($("#deduction").val() == 0 ||$("#deduction").val() == ''){
        $("#deduction").val('');
    }
});


var a= {};
a.userId = ownerId;
if(recordType == 3){
    a.staffType = 1;
}else if(recordType == 3){
    a.staffType = 2;
}
a.pageSize = 1000;
var select2Array = [],driverArray = [],licensePlate = ['无'],phoneArray = [''],driverPhone = [''];
var person = Restful.post('bsinventorystaff/list',a);
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

if(recordType == 3){
    $('.date').text('入库日期:');
    $('.type').text('送粮人:');
    $('.paymsg').text('二、付款信息');
}
$('#salePerson').val(data.staffId).select2({
    data:select2Array,
    templateResult: formatState
});
$('#driver').val(data.driverId).select2({
    data:driverArray,
    templateResult: formatState
});
if(data.grainType == 1){
    $(".xmlist").show();
    $(".meibian").hide();
    $('.addressSelete').citys({
        required:false,
        nodata:'disabled',
        code:data.location,
        onChange:function(data){
            console.log(data);
            locationText = data.province+data.city+data.area;
            locationNum = data.code;
            if($('#two').css('display') == 'none'){
                $('select').attr('disabled',true);
            }
        }
    });

    $("#varietyType").val(data.varietyType);
    $("#packingType").val(data.packingType);
    $("#productionNiafe").val(data.productionNiafe);
    $("#smell").val(data.smell);
}else{
    $(".xmlist").hide();
    $(".meibian").show();
}
$('#recordNumber').val(data.recordNumber);
$("#date").val(data.date);
$("#licensePlate").val(data.licensePlate);
$("#rongzhong").val(data.bulkDensity);
$("#buwanshanli").val(data.imperfectGrains);
$("#water").val(data.moistureContent);
$("#meibian").val(data.mildew);
$("#impurity").val(data.impurity);
$("#productQuality").val(data.productQuality);
$('#grainType').val(data.grainType);
$("#deduction").val(data.deduction?data.deduction:0);
$('#quality').val(data.productQuality);
$('#remark').val(data.remark);
$("#grossWeightIn").val(recordType == 3?data.grossWeightIn:data.grossWeightOut);

$("#tareWeightIn").val(recordType == 3?data.tareWeightIn:data.tareWeightOut);
$("#netWeightIn").val(recordType == 3?data.netWeightIn:data.netWeightOut);
/*$("#unitPrice").val(data.unitPrice);*/
/*$("#moneyIn").val(recordType == 3?data.moneyIn:data.moneyOut);*/
if(data.staffId){
    $("#salePerson").val(data.staffId).select2();
}

$('select').attr('disabled',true);
$('input').attr('disabled',true);


//计算净重
function Calculation() {
    var grossWeightOut = $("#grossWeightIn").val();
    var tareWeightOut = $("#tareWeightIn").val();
   /* var unitPrice = $("#unitPrice").val();*/
    var deduction = $("#deduction").val();
    var netWeightOut = grossWeightOut - tareWeightOut -deduction;
    netWeightOut = netWeightOut.toFixed(2);
 /*   var moneyOut = netWeightOut * unitPrice *2;*/
    moneyOut = moneyOut.toFixed(2);
    $("#netWeightIn").val(netWeightOut);
/*    $("#moneyIn").val(moneyOut);*/
}
$("#grossWeightIn").on('input',function () {
    Calculation();
});

$("#tareWeightIn").on('input',function () {
    Calculation();
});

/*$("#unitPrice").on('input',function () {
    Calculation();
});*/
$("#deduction").on('input',function () {
    Calculation();
});
//切换粮食类型
$(document).on('change','#grainType',function () {
    var grainType = $("#grainType").val();
    if(grainType == 1){
        $(".xmlist").show();
        $(".meibian").hide();
    }else{
        $(".xmlist").hide();
        $(".meibian").show();
    }
});

//表单验证
function checkForm() {
    var weightReg =  /^[1-9]\d*\.\d{0,2}|[1-9]\d*|0\.\d{0,2}|0$/;//00000000.00------11位
    var qualityReg =  /^[1-9]\d*\.\d{1}|[1-9]\d*|0\.\d{1}$/;//00.0---------------4位
    var priceReg =  /^[1-9]\d*\.\d{0,3}|[1-9]\d*|0\.\d{0,3}$/;//000.00-------------6位
    var grainType = $("#grainType").val();
    var date = $("#date").val();
    var hour = $("#hour").val();
    var minute = $("#minute").val();
    var time = hour + ':' + minute;
    var grossWeightOut = $("#grossWeightIn").val();
    var tareWeightOut = $("#tareWeightIn").val();
/*    var unitPrice = $("#unitPrice").val();*/
    var netWeightOut = grossWeightOut - tareWeightOut;
    if(netWeightOut < 0){
        alert('皮重不能大于毛重');
        return false;
    }
	    if (recordType == 3) {
		if ($("#addPerson").val() != '' && $("#phone").val() == '') {
			alert("请填写送粮人手机号");
			return false;
		}
		if ($("#phone").val() != '' && $("#addPerson").val() == '') {
			alert("请填写送粮人姓名");
			return false;
		}
	} else {
		if ($("#addPerson").val() != '' && $("#phone").val() == '') {
			alert("请填写买粮人手机号");
			return false;
		}
		if ($("#phone").val() != '' && $("#addPerson").val() == '') {
			alert("请填买粮人写姓名");
			return false;
		}
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
/*    if ($("#unitPrice").val() == '') {
        alert('请填写单价后提交');
        return false;
    }*/
    if (!weightReg.test($("#grossWeightIn").val())) {
        alert('毛重最多八位整数俩位小数');
        return false;
    }
    if (!weightReg.test($("#tareWeightIn").val())) {
        alert('皮重最多八位整数俩位小数');
        return false;
    }
/*    if (!priceReg.test($("#unitPrice").val())) {
        alert('单价最多三位整数俩位小数');
        return false;
    }*/
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

//提交表单
$("#save").on('click', function () {
    var telTest = false;
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
    params.id = data.id;
    params.recordType = recordType;
    params.userId = ownerId;
    params.operateUserId = userId;
    params.depotId = $(".depotChange").attr('data-depot');
    params.recordNumber = data.recordNumber;
    params.date = date;
    params.licensePlate = $("#licensePlate").val();
    params.bulkDensity = $("#rongzhong").val();
    params.imperfectGrains = $("#buwanshanli").val();
    params.moistureContent = $("#water").val();
    params.impurity = $("#impurity").val();
    params.mildew = $("#meibian").val();
    params.productQuality = $("#quality").val();
    params.remark = $("#remark").val();
    params.grainType = $("#grainType").val();
  /*  params.unitPrice = $("#unitPrice").val();*/
    params.deduction = $("#deduction").val();
    params.varietyType = $("#varietyType").val();
    params.packingType = $("#packingType").val();
    params.productionNiafe = $("#productionNiafe").val();
    params.smell = $("#smell").val();
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
    if(recordType == 3){
        params.grossWeightIn = $("#grossWeightIn").val();
        params.tareWeightIn = $("#tareWeightIn").val();
        params.netWeightIn = $("#netWeightIn").val();
     /*   params.moneyIn = $("#moneyIn").val();*/
    }else{
        params.grossWeightOut = $("#grossWeightIn").val();
        params.tareWeightOut = $("#tareWeightIn").val();
        params.netWeightOut = $("#netWeightIn").val();
    /*    params.moneyOut = $("#moneyIn").val();*/
    }
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
        params.staffId =-100;
        params.staffName = $('#addPerson').val();
        params.staffPhone = $('#phone').val();
        if(params.staffPhone != null && params.staffPhone != ''){
        	var telParams = {};
        	telParams.userId = ownerId;
        	if(recordType == 3){
        		telParams.staffType = 1;
        	}else{
        		telParams.staffType = 2;
        	}
        	telParams.phone = $("#phone").val();
        	telTest = Restful.post('bsinventorystaff/isExist', telParams);
        }
    }else {
        var staffId = $('#salePerson').val();

        if(staffId != 0){
            params.staffId = staffId;
            params.staffName = $("#salePerson option:selected").text();
            var idx = $('#salePerson').children('option:selected').index();
            params.staffPhone = phoneArray[idx];
        }else {
            params.staffId = '';
            params.staffName = '';
            params.staffPhone = '';
        }
    }

/*    console.log(params);*/
    
    
        		
    if (!telTest) {
		var testName;
		$.each(depotRes, function(idx, item){
			if(depotRes[idx].id == $('.depotChange').attr('data-depot')){	
				testName = depotRes[idx].name;	
			}
		});
		if (window.confirm("确定要保存到"+testName+"库吗？")) {
            var res = Restful.post('bsinventorystorage/insert', params);
			if (res.success) {
				alert('保存成功');
				Restful.operateRecord(res.retcode,1,11);
				     if(recordType ==3 ){
                window.location.href = 'inStorageMobile.html';
            }else if(recordType == 2){
                window.location.href = 'outStorage.html';
            }
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


$(document).on('click','#change-add',function () {
    isNewPerson = true;
    $('#addPerson').val('');
    $('#salePerson').parent('label').css('display','none');
    $('#change-add').css('display','none');
    $(".heiChange").css('height','4rem');
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


$(document).on('click','#editSub',function () {
    $('.can').removeClass('no-edit');
    $('input,select').removeAttr('disabled');
    $('#one').css('display','none');
    $('#two').css('display','block');
    $('#change-add').css('display','inline-block');
    $('#driver-add').css('display','inline-block');
    if(recordType == 1){
        $('.title').text('入库单修改');
    }else if(recordType == 2){
        $('.title').text('出库单修改');
    }

    $(".nav").click(function() {
        $(".select").slideToggle();
    });
    $(".select").on('click','li',function () {
        var depotSel = $(this).text();
        $(this).addClass('depotChange').siblings().removeClass('depotChange');
        $(".nav h2").html(depotSel+'<img src="accountData/img/u40.png"/>');
    });

});
$(document).on('click','#cencel',function () {
    if(recordType ==3 ){
        location.href = 'inStorageMobile.html';
    }else if(recordType == 2){
        location.href = 'noOutFormMobile.html';
    }
});

$(document).on('click','#delete',function () {
    var isDelete = confirm('是否删除本条数据?');
    if(isDelete){
        var params = {};
        params.temporaryId = id;
        var result = Restful.post('bsInventoryTemporary/deleteInventoryTemporary',params);
        if(result.success){
            alert('删除成功');
            if(recordType ==3 ){
                location.href = 'inStorageMobile.html';
            }else if(recordType == 2){
                location.href = 'noOutFormMobile.html';
            }
        }
    }
});

