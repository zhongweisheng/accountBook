/**
 * Created by new on 2017/3/31.
 */
var res = Restful.get('bsNews/getBsNewsList','{page:0,number:10}');
var data = res.dataList;
var msg = $('#news-list').html();
var compiledTemplate = Template7.compile(msg);
var html = compiledTemplate({"newsList": data});
$("#list").html(html);

$(document).on('click','#list li',function () {
    var id = $(this).attr('data-id');
    window.open('http://wxmlb.wvagri.com/mlbweb/siteManageD/webNewsVewi.jsp?id='+id);
});
