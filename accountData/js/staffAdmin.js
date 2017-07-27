//var currentPage = 1;
//var pages;
var userId = DES3.decrypt(localStorage.getItem('userId'));

$(".leftContent > div:nth-child(8)> p:nth-child(2)").addClass("left_active");
$(".leftContent > div:nth-child(7)").addClass("left_active");
$(".child").eq(3).css('display', 'block');
getData();
//initPaging();

/*$('.page').on('click',function () {
 currentPage = $('.activP').text();
 getData();
 });*/

/*function initPaging() {
 //分页初始化
 $('.page').page({
 leng: pages,//分页总数
 activeClass: 'activP' , //active 类样式定义
 });
 }*/


//全选or全部选
$('#checkAll').change(function () {
    if($(this).prop('checked') == true){
        $('#select :checkbox').prop('checked',true);
    }else{
        $('#select :checkbox').prop('checked',false);
    }
});

$('#select').on('change',' :checkbox',function () {
    allchk();
});
//选项总个数
function allchk(){
    var chknum = $("#select :checkbox").size();
    var chk = 0;
    $("#select :checkbox").each(function () {
        if($(this).prop("checked")==true){
            chk++;
        }
    });
    if(chknum==chk){//全选
        $("#checkAll").prop("checked",true);
    }else{//不全选
        $("#checkAll").prop("checked",false);
    }
}
//全选or全部选
$('#checkAll-edit').change(function () {
    if($(this).prop('checked') == true){
        $('#select-edit :checkbox').prop('checked',true);
    }else{
        $('#select-edit :checkbox').prop('checked',false);
    }
});

$('#select-edit').on('change',' :checkbox',function () {
    allchkEdit();
});
//选项总个数
function allchkEdit(){
    var chknum = $("#select-edit :checkbox").size();
    var chk = 0;
    $("#select-edit :checkbox").each(function () {
        if($(this).prop("checked")==true){
            chk++;
        }
    });
    if(chknum==chk){//全选
        $("#checkAll-edit").prop("checked",true);
    }else{//不全选
        $("#checkAll-edit").prop("checked",false);
    }
}


$(document).on('click', '#submit', function () {
    var valArr = new Array;
    $("#select :checkbox:checked").each(function(i){
        valArr[i] = $(this).attr('data-id');
    });
    var vals = valArr.join(',');//转换为逗号隔开的字符串
    var name = $('#name').val();
    var phone = $('#phone').val();
    var password = $('#password').val();
    if (!phone) {
        $('#phone').nextAll('p').css('display', 'inline-block');
        return;
    }
    if (!password) {
        $('#password').nextAll('p').css('display', 'inline-block');
        return;
    }
    var params = {};
    params.ownerId = userId;
    params.action = 'add';
    params.trueName = name;
    params.phone = phone;
    params.loginName = phone;
    params.passWord = md5(password);
    params.depotIds = vals;
    var result = Restful.post('bsinventoryuser/editUser', params);
    console.log(result);
    if (result) {
        if (result.success) {
            getData();
            $(".registerModel").fadeOut(200);
        } else if(result.retcode == 2000) {
            alert('手机号已经被占用');
        }else{
            alert('员工添加失败');
        }
    } else {
        alert('账号别处登录或者网络有问题');
    }

});
var depotHtml = '';
function getDepot() {
    var params = {};
    params.userId = userId;
    var res = Restful.post('bsinventorydepot/list', params);
    if(res && res.success) {
        var data = res.dataList;
        depotHtml = '';
        for(var i=0,len = data.length;i<len;i++){
            depotHtml +='<li class="choice-con lt"><input type="checkbox" data-id="'+data[i].id+'" id="'+data[i].id+'"><label for="'+data[i].id+'">'+data[i].name+'</label></li>';
        }
    }else{
        alert('获取粮库信息失败');
    }
}
function getData() {
    var params = {};
    params.currentPage = 1;
    params.ownerId = userId;
    params.pageSize = 100;
    var res = Restful.post('bsinventoryuser/list', params);
    if (res.success) {
        var data = res.dataList;
        var msg = $('#salePerson-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"salePerson": data});
        $("#list").html(html);
        if(res.total > 30){
            $('#add').addClass('disable');
        }
    } else {
        $("#list").html('');
        $("#list").html('<tr><td colspan="6"><div style="width: 100%;height: 400px;line-height: 100px;font-size: 30px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
    }
}
//打开添加层
$(document).on('click', '#add', function () {
    if($('#add').hasClass('disable')){
        alert('添加员工数达到上限');
    }else{
        $('.register-form input,textarea').val('');
        $('#addP').fadeIn(200);
        getDepot();
        $('#select').html('').append(depotHtml);
    }
});
//关闭添加层
$(document).on('click', '#cencel', function () {
    $('.registerModel').fadeOut(200);
    $('.register-form input,textarea').val('')
});


//删除记录
$(document).on('click', '#deletebtn', function () {
    $('#deletebtn').removeClass('disable');
    var id = $(this).attr('data-id');
    var isDelete = confirm('确定删除本条记录?');
    if (isDelete) {
        var result = Restful.deletestaff('bsinventoryuser/' + id);
        if (result) {
            if (result.success) {
                getData();
                //initPaging();
            } else {
                alert('员工删除失败');
            }
        } else {
            alert('账号别处登录或者网络有问题');
        }

    }
});
//打开修改记录
var staffId,passVal;
$(document).on('click', '#editbtn', function () {
    $('#edit').fadeIn(200);
    getDepot();
    $('#select-edit').html('').append(depotHtml);
    var id = $(this).attr('data-id');
    staffId = id;
    var result = Restful.get('bsinventoryuser/' + id+'?depotIds=1');
    if (result) {
        var checkArray = result.userImage.split(',');
        $('#select-edit :checkbox').each(function (i,val) {
            for(var i=0,len=checkArray.length;i<len;i++){
                if($(val).attr('data-id') == checkArray[i]){
                    $(val).prop('checked',true);
                }
            }
        });
        $('#name-edit').val(result.trueName);
        $('#phone-edit').val(result.phone);
        $('#password-edit').val('********');
        passVal = result.passWord;
    }
});
//保存修改
$(document).on('click', '#editSubmit', function () {
    var valArr = new Array;
    $("#select-edit :checkbox:checked").each(function (i) {
        valArr[i] = $(this).attr('data-id');
    });
    var vals = valArr.join(',');//转换为逗号隔开的字符串
    var name = $('#name-edit').val();
    var phone = $('#phone-edit').val();
    var password = $('#password-edit').val();
    if (!phone) {
        $('#phone').nextAll('p').css('display', 'inline-block');
        return;
    }
    if (!password) {
        $('#password').nextAll('p').css('display', 'inline-block');
        return;
    }
    var params = {};
    params.ownerId = userId;
    params.userId = staffId;
    params.trueName = name;
    params.phone = phone;
    params.loginName = phone;
    if (password == '********') {
        params.passWord = passVal;
    } else {
        params.passWord = md5(password);
    }
    params.depotIds = vals;
    var result = Restful.post('bsinventoryuser/editUser', params);
    if (result) {
        if (result.success) {
            getData();
            $('#edit').fadeOut(200);
        } else {
            alert('员工编辑失败');
        }
    } else {
        alert('账号别处登录或者网络有问题');
    }
});
//关闭修改层
$(document).on('click', '#editCencel', function () {
    $('#edit').fadeOut(200);
});
