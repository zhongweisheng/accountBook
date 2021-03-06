/**
 * Created by luffy on 17-2-17.
 */
var $$ = $.noConflict();
var locationNum,locationText;
$$('.addressSelete').citys({
    required:false,
    nodata:'disabled',
    onChange:function(data){
        console.log(data);
        locationText = data.province+data.city+data.area;
        locationNum = data.code;
    }
});

$(".input-right").on('click',function () {
    $(".loginintpu").removeClass('active');
    $(this).closest('.loginintpu').addClass('active');
});

$(document).on('input','.tel-vertification input',function () {
    var val = $(this).val();
    val = val.replace(/\s/,"");
    console.log($('.get-text-code').data('loading'));
    if(val.length == 11) {
        $('.get-text-code').removeClass('disable-btn');
        $('.get-text-code').data('loading',true)
    }else{
        $('.get-text-code').addClass('disable-btn');
        $('.get-text-code').data('loading',false);
    }
    if ($('.get-text-code').data('loading')) {
        return false;
    }
});
function telVertification () {
    var tel = $('.tel-vertification input').val();
    var telReminder = $('.reminder').addClass('show');
    if (!(tel.length == 11)) {
        telReminder.html('您输入的号码位数不正确！');
        return false;
    }
    if(!tel.match(/^1[3,5,8,7]\d{9}$/g)) {
        telReminder.html('您输入的手机号码有误');
        return false;
    }else {
        console.log('手机输入号码正确');
    }
    telReminder.removeClass('active');
    return true;
}
//发短信
//$(document).on('touchstart','.get-text-code',function () {
    function getTextCode(code) {

    var getcodetime = 60;
    var getcodebtn = $(code);
    var reminder = $('.reminder').addClass('show');
    var tel = $('.tel-vertification input').val();
    if (!tel) {
        $.toast('请您先输入手机号码');
        $('.tel-vertification input')[0].focus();
        return false;
    }
    if ($(code).hasClass('disable-btn')) {
        $(code).data('loading',true);
        return false;
    }else {
        $(code).data('loading',false);
        if (!telVertification()) {
            return false;
        } ;
        $(code).addClass('disable-btn');

        $.ajax({
            url:"/accountBook/common/sendSmsCode?phone="+tel+"&pageType=1",
            type:"get",
            dataType:"json",
            success:function (data) {
                console.log(data);
                if(data.success){
                    var timer = setInterval(function () {
                        getcodetime -= 1;
                        if(getcodetime <= 0) {
                            clearInterval(timer);
                            getcodebtn.data('loading',false);
                            getcodebtn.removeClass('disable-btn');
                            reminder.html('');
                        }else {
                            getcodebtn.data('loading',true);
                            reminder.html('短信已发送，如未收到，请<span style="color:red;">'+getcodetime+'</span>s后再次获取');
                        }

                    },1000);
                }else {
                    $.alert(data.message);
                }

            },
            error:function (err) {
                console.log(err)
            }
        })

    }
}
$(document).on('input','#code',function () {
    var regx = '^[0-9]*$';
    if(!$('#code').val().match(regx)){
        $('#code').val('');
        return;
    }
});
//提交注册
$("#submit").on('click',function () {
    if(!$("#name").val()){
        $.toast('请输入姓名');
        return false;
    }else if(!$("#account").val()){
        $.toast('请输入帐号');
        return false;
    }else if(!$("#password").val()){
        $.toast('请输入密码');
        return false;
    }else if(!$("#code").val()){
        $.toast('请输入短信验证码');
        return false;
    }/*else if(!$("#code-v").val()){
    	$.toast('请输入邀请码');
    	return false;
    }*/
    if(!$("#agreeInput").prop("checked")){
        $.toast("请同意协议后提交");
        return false;
    }
    var params = {};
    params.userName = $("#name").val();
    params.loginName = $("#account").val();
    params.passwordDE = $("#password").val();
    params.password = md5($("#password").val());
    params.smscode = $("#code").val();
    // params.invitecode = $("#code-v").val();
    params.location = locationNum;
    params.locationDesc = locationText;
    $.ajax({
        url:"/accountBook//mlbuserinventoryuser",
        type:"post",
        data:params,
        dataType:"json",
        success:function (result) {
             console.log(result);
             if(result.success){
                 $.alert("注册成功");
                 localStorage.setItem('userName', DES3.encrypt(result.retObj.userName));
                 localStorage.setItem('userType', 1);
                 localStorage.setItem('ud', DES3.encrypt(result.retObj.userId));
                 localStorage.setItem('ownerId', DES3.encrypt(result.retObj.userId));
                 localStorage.setItem('mlbUserId',result.retObj.mlbUserId);
                 localStorage.setItem('mlbUserName',result.retObj.mlbUserName);
                 var type = localStorage.getItem('type');
                 window.location.href = 'entry.html?type='+type;
             }else {
                 $.alert(result.description);
             }
        },
        error:function () {
            $.alert("注册失败");
        }
    });
});

$("#openAgreeModal").on('click',function () {
    $(".agreeModal").show();
});
$(".agreeBtn").on('click',function () {
    $(".agreeModal").hide();
});
$.init();