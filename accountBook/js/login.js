/**
 * Created by luffy on 17-2-17.
 */
//注册页面地址
var loginType = Restful.getQueryString('loginType');
alert(loginType);
$("#live").attr('href','live.html');
$("#findPassword").attr('href','findPassword.html');
var newPhone,newUserId;
// alert($("#findPassword").attr('href'));
// alert($("#live").attr('href'));

$(".input-right").on('click',function () {
    $(".loginintpu").removeClass('active');
    $(this).closest('.loginintpu').addClass('active');
});
$("#submit").on('click',function () {

    var account = $("#account").val();
    if(!account){
        $.toast('输入正确账号');
        return false;
    }
    if(!$("#password").val()){
        $.toast('请输入密码');
        return false;
    }
    if($(this).hasClass('disabled')){
        return;
    }
    $(this).addClass('disabled');

    var params = {};
    params.loginName = account;
    params.passwordDE = $("#password").val();
    params.password = md5($("#password").val());
    newPhone = account;
    var result = Restful.post('mlbuserinventoryuser/login',params);
    if(result){
        if(result.success){
            if(result.retcode == 20000){
                $(".new-model").show();
                newUserId = result.retObj.userId;
            }else{
                localStorage.setItem('userName', DES3.encrypt(result.retObj.userName));
                localStorage.setItem('ud', DES3.encrypt(result.retObj.userId));
                localStorage.setItem('userType', result.retObj.userType);
                localStorage.setItem('mlbUserId',result.retObj.mlbUserId);
                localStorage.setItem('mlbUserName',result.retObj.mlbUserName);
                if(result.retObj.userType == 1){
                    localStorage.setItem('ownerId', DES3.encrypt(result.retObj.userId));
                    localStorage.setItem('userType', 1);
                }else{
                    localStorage.setItem('ownerId', DES3.encrypt(result.retObj.ownerId));
                    localStorage.setItem('userType', 2);
                }
                Restful.operateRecord(10000,3,31);
                var type = localStorage.getItem('type');
                if(loginType == 10){
                    window.location.href = 'downstream.html';
                }
                else {
                    window.location.href = 'public.html';

                }
            }
        }else {
            $.alert("登录失败，未注册或账号密码错误");
            $(this).removeClass('disabled');
        }
    }else {
        $.alert("服务器繁忙请稍后再试","抱歉");
        $(this).removeClass('disabled');
    }
});

function getTextCode(code) {
    $(code).css('color','#aaa');
    var getcodetime = 60;
    var tel = newPhone;

        $.ajax({
            url:"/accountBook/common/sendSmsCode?phone="+tel+"&pageType=3",
            type:"get",
            dataType:"json",
            success:function (data) {
                console.log(data);
                if(data.success){
                    var timer = setInterval(function () {
                        getcodetime -= 1;
                        if(getcodetime <= 0) {
                            clearInterval(timer);
                            $('.reminder').html('');
                            $(code).css('color','#37a333');
                        }else {
                            $('.reminder').html('短信已发送，如未收到，请<span style="color:red;">'+getcodetime+'</span>s后再次获取');
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


//首次登陆验证
$(document).on('click','#register-new',function () {
    var params = {};
    params.userId = newUserId;
    params.smscode = $('#phoneCode-new').val();
    var newres = Restful.post('bsinventoryuser/setActive',params);
    if(newres&&newres.success){
        localStorage.setItem('userId', DES3.encrypt(newres.retObj.userId));
        localStorage.setItem('userName', DES3.encrypt(newres.retObj.userName));
        localStorage.setItem('userType', newres.retObj.userType);
        localStorage.setItem('ownerId', DES3.encrypt(newres.retObj.ownerId));
        location.href = 'inFormMobile.html';
    }
    $(".new-model").hide();
});
$(document).on('click','#back',function () {
    $(".new-model").hide();
});
$.init();