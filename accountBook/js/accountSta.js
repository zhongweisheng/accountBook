var grainType = 2;
var timeType = 1;
var currentPage = 1;

var userId = DES3.decrypt(localStorage.getItem('ud'));
getData();


$("#grainChange").on('click','div',function () {
    grainType = $(this).attr('data-grainType');
    currentPage = 1;

    $(this).addClass('tab_active');
    $(this).siblings().removeClass('tab_active');
    $('.more-text').html('轻触加载更多...');
    $('.more').css('display','block');

    getData();
    shouMoreText();
});


$("#timeChange").on('click','li',function () {
    timeType = $(this).attr('data-timeType');
    currentPage = 1;

    if(timeType == 2 || timeType == 4){
        $(".card > div:last-child").removeClass("date").addClass("date-one");
    }else{
        $(".card > div:last-child").removeClass("date-one").addClass("date");
    }
    $(this).addClass('nav_active');
    $(this).siblings().removeClass('nav_active');
    $('.more-text').html('轻触加载更多...');

    getData();
    shouMoreText();
});
function getData(){
    var params = {};
    params.userId = userId;
    params.searchType = timeType;
    params.grainType = grainType;
    params.currentPage = currentPage;

    var res = Restful.post('bsinventoryrecord/searchStat',params);
    if(res.success){
        var data = res.dataList;
        var msg = $('#accountSta-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"accountSta":data});
        $("#list").html(html);

        $('.more-text').removeClass('hiden');
    }else{
        $("#list").html('<div style="width: 100%">' +
            '<div style="width: 100%;height: 5rem;background: url(../img/nodata.png) center no-repeat;background-size: 50% 5rem;margin-top: 3rem;">' +
            '</div>' +
            '<div style="text-align: center;margin-top: 1rem">' +
            '<span style="color: #929292;font-size: 0.9rem;">暂无此类数据~</span>' +
            '</div>' +
            '</div>');
    }
}

$(document).on('click','.more-text',function () {
    moreCtrl();
    currentPage++;
    getDataAsync();
})

function moreCtrl() {
    var text = $('.more-text');
    var animation = $('.spinner');
    if(text.hasClass('hiden')){
        text.removeClass('hiden');
        animation.addClass('hiden');
        excu = true;
    }else {
        text.addClass('hiden');
        animation.removeClass('hiden');
        excu = true;
    }
}

function getDataAsync() {
    var params = {};
    params.userId = userId;
    params.searchType = timeType;
    params.grainType = grainType;
    params.currentPage = currentPage;

    $.ajax({
        type: 'post',
        url: 'accountBook/bsinventoryrecord/search',
        dataType: 'json',
        data: params,
        success: function(res) {
            if(res.success){
                var data = res.dataList;
                var msg = $('#accountSta-list').html();
                var compiledTemplate = Template7.compile(msg);
                var html = compiledTemplate({"accountSta":data});
                $("#list").append(html);

                moreCtrl();
            }else{
                moreCtrl();
                $('.more-text').text('没有更多数据了');
            }
        },
        error: function(err) {
            moreCtrl();
            console.log("请求出错");
            $("#list").html(
                '<div style="width: 100%">' +
                '<div style="width: 100%;height: 5rem;background: url(../img/nodata.png) center no-repeat;background-size: 50% 5rem;margin-top: 3rem;">' +
                '</div>' +
                '<div style="text-align: center;margin-top: 1rem">' +
                '<span style="color: #929292;font-size: 0.9rem;">暂无此类数据~</span>' +
                '</div>' +
                '</div>'
            );
        }
    });
}