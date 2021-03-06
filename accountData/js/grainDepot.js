
var depotLen;
var userId = DES3.decrypt(localStorage.getItem('userId'));

$(".leftContent > div:nth-child(8)> p:nth-child(2)").addClass("left_active");
$(".leftContent > div:nth-child(7)").addClass("left_active");
$(".child").eq(3).css('display', 'block');

getData();

$(document).on('click','#submit',function () {
    var depotName = $('#depotName').val();
    var depotCapacity = $('#depotCapacity').val();
    var depotLocation = $('#depotLocation').val();

    if(!depotName){
        $('#depotName').nextAll('p').css('display','inline-block');
        return;
    }
    if(!depotCapacity){
        $('#depotCapacity').nextAll('p').css('display','inline-block');
        return;
    }
    if(!depotLocation){
        $('#depotLocation').nextAll('p').css('display','inline-block');
        return;
    }
    var params = {};
    params.ownerId = userId;
    params.name = depotName;
    params.storageCapacity = depotCapacity;
    params.address = depotLocation;
    var result = Restful.post('bsinventorydepot', params);
   /* console.log(result);return;*/
    if(result){
        if(result.success){
            getData();
            $(".registerModel").fadeOut(200);
        }else {
            alert('粮库添加失败');
        }
    }else {
        alert('账号别处登录或者网络有问题');
    }

});

$(document).on('click','#upsubmit',function () {
    var depotName = $('#updepotName').val();
    var depotCapacity = $('#updepotCapacity').val();
    var depotLocation = $('#updepotLocation').val();
    if(!depotName){
        $('#depotName').nextAll('p').css('display','inline-block');
        return;
    }
    if(!depotCapacity){
        $('#depotCapacity').nextAll('p').css('display','inline-block');
        return;
    }
    if(!depotLocation){
        $('#depotLocation').nextAll('p').css('display','inline-block');
        return;
    }
    var params = {};
    params.ownerId = userId;
    params.updateData = 1;
    params.name = depotName;
    params.storageCapacity = depotCapacity;
    params.address = depotLocation;
    var result = Restful.post('bsinventorydepot', params);
    if(result){
        if(result.success){
            getData();
            $(".registerModel").fadeOut(200);
        }else {
            alert('粮库添加失败');
        }
    }else {
        alert('账号别处登录或者网络有问题');
    }

});

function getData() {
    var params = {};
    params.userId = userId;
    var res = Restful.post('bsinventorydepot/list', params);
    if(res && res.success) {
        var data = res.dataList;
        var msg = $('#salePerson-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"salePerson": data});
        $("#list").html(html);
        depotLen = $('#list tr').length;
        if(depotLen > 5){
            $('#add').addClass('disable');
        }else{
            $('#add').removeClass('disable');
        }
    }else{
        $("#list").html('');
        $("#list").html('<tr><td colspan="5"><div style="width: 100%;height: 400px;line-height: 100px;font-size: 30px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
        $('.register-form input,textarea').val('');
        $('#update').fadeIn(200);
    }
}
//打开添加层
$(document).on('click','#add',function () {
    if(depotLen > 9){
        alert('添加数达到上限');
    }else{
        $('.register-form input,textarea').val('');
        $('#addP').fadeIn(200);
    }
});
//关闭添加层
$(document).on('click','#cencel',function () {
    $('.registerModel').fadeOut(200);
    $('.register-form input,textarea').val('')
});


//删除记录
$(document).on('click','#deletebtn',function () {
    if(depotLen == 1){
        $('#deletebtn').addClass('disable');
        alert('不可删除，至少留一个库');
        return;
    }else{
        $('#deletebtn').removeClass('disable');
        var id = $(this).attr('data-id');
        var isDelete = confirm('粮库删除后不可恢复，确定删除?');
        if(isDelete){
    
            var result = Restful.deletestaff('bsinventorydepot/' + id);
            if(result){
                if(result.success){
                    getData();
                    //initPaging();
                }else {
                    alert('粮库删除失败');
                }
            }else {
                alert('账号别处登录或者网络有问题');
            }

        }
    }
});
//打开修改记录
var depotId;
$(document).on('click','#editbtn',function () {
    $('#edit').fadeIn(200);
    var id = $(this).attr('data-id');
    depotId = id;
    var result = Restful.get('bsinventorydepot/' + id);
    if(result){
        $('#depotName-edit').val(result.name);
        $('#depotCapacity-edit').val(result.storageCapacity);
        $('#depotLocation-edit').val(result.address);
    }
});
//保存修改
$(document).on('click','#editSubmit',function () {
    var depotName = $('#depotName-edit').val();
    var depotCapacity = $('#depotCapacity-edit').val();
    var depotLocation = $('#depotLocation-edit').val();
    if (!depotName) {
        $('#depotName').nextAll('p').css('display', 'inline-block');
        return;
    }
    if (!depotCapacity) {
        $('#depotCapacity').nextAll('p').css('display', 'inline-block');
        return;
    }
    if (!depotLocation) {
        $('#depotLocation').nextAll('p').css('display', 'inline-block');
        return;
    }
    var params = {};
    params.ownerId = userId;
    params.name = depotName;
    params.storageCapacity = depotCapacity;
    params.address = depotLocation;
    var result = Restful.post('bsinventorydepot/' + depotId, params);
    if (result) {
        if (result.success) {
            getData();
            $('#edit').fadeOut(200);
        } else {
            alert('粮库编辑失败');
        }
    } else {
        alert('账号别处登录或者网络有问题');
    }
});
//关闭修改层
$(document).on('click','#editCencel',function () {
    $('#edit').fadeOut(200);
});
