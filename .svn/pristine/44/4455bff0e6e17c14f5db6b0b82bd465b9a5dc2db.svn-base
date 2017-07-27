/***********求购信息接口***************/
$(".nav1").on("click", function() { //给a标签添加事件

    $(this).addClass("nav_click");
    $(".nav2").removeClass("nav_click");
    $(".btn").show();
    $(".btn1").hide();
    $(".banner").show();
    $(".banner1").hide();
    getData();
});
$(".nav2").on("click", function() { //给a标签添加事件

    $(this).addClass("nav_click");
    $(".nav1").removeClass("nav_click");
    $(".banner1").show();
    $(".btn1").show();
    $(".btn").hide();
    $(".banner").hide();
    getdiscussList();
});

var userId = localStorage.getItem("mlbUserId");
getData();
/*alert(userId);*/
function getData() {
    var searchParams = {};
    searchParams.mlbuserId = userId;
    searchParams.type  = 1;
    var temp =JSON.stringify(searchParams);
    var res = Restful.get('/bsuserrequire/getUserRequireListByMlbUserId',temp);

    if (res) {
        var data = res.dataList;
        var msg = $('#banner-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"banner": data});
        $(".banner").html(html);
    }
}

/********end********/

/***********供应信息接口***************/

/*alert(userId);*/
function getdiscussList() {
    var params = {};
    params.mlbuserId = userId;
    params.type = 2;
    var temp =JSON.stringify(params);
    var res = Restful.get('bsgoodsinfo/getGoodsListByMlbUserId', temp);

    if (res ) {
        var data = res.dataList;
        var msg = $('#banner1-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({'banner1':data});
        /*console.log(html);*/
        $(".banner1").html(html);
    }
}
/********end********/