var locationNum,locationText;
var passValue;
$(".leftContent > div:nth-child(9)").addClass("left_active");

var userId = DES3.decrypt(localStorage.getItem('userId'));

var result = Restful.get('bsinventoryuser/'+userId);

if(result){
    $('#accountNum').val(result.loginName);
    $('#username').val(result.trueName);
    $('#addressDesc').val(result.address);
    $('#printHead').val(result.printHead);
    $('#password').val('********');
    passValue = result.passWord;

}


$('#password').focus(function () {
    $('#password').val('');
});

$(document).on('click','#submit',function () {
    var trueName = $('#username').val();
    var password;
    if(!trueName){
        $('#username').nextAll('p').css('display','block');
        return;
    }
    if($('#password').val() == '********'){
        password = passValue;
    }else if($('#password').val() != ''){
        password = md5($('#password').val());
    }else if($('#password').val() == ''){
        $('#password').nextAll('p').css('display','block');
        return;
    }
    var params = {};
    params.action = 'modifyUserInfo';
    params.trueName = trueName;
    params.password = password;

    var result = Restful.post('bsinventoryuser/'+userId,params);
    $(this).addClass('disable');
    if(result){
        if(result.success){
            alert('设置成功');
            $(this).removeClass('disable');
            localStorage.setItem('userName',DES3.encrypt(trueName));
            window.location.reload();
        }else {
            alert('设置不成功');
            $(this).removeClass('disable');
        }
    }else {
        alert('请求失败,请稍后再试');
        $(this).removeClass('disable');
    }
});
