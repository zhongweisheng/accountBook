
var Restful = function() {

    var restURL = "accountBook/";

    return {


        get:function(tableName, queryJsonStr) {
            queryJsonStr = queryJsonStr||'';
            var split ="?";
            if(tableName.indexOf("?")>-1) {
                split = "&";
            }
            var jsonData;
            $.ajax({
                type: 'get',
                url: restURL + tableName + split+"CHANNAL_TYPE_CHECK=WEIXIN&query=" + encodeURIComponent(queryJsonStr),
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                async: false,
                /*beforeSend:function () {
                    $.showIndicator();
                },*/
                success: function(data) {
                   // $.hideIndicator();
                    jsonData = data;
                },
                error: function(err) {
                    //$.hideIndicator();
                    console.log("请求出错")
                }
            });
            return jsonData;
        },
        post:function(tableName, queryJsonStr) {
            queryJsonStr.CHANNAL_TYPE_CHECK='WEIXIN';
            var qcode = '';
            var arrSimple=new Array();
            for(var i in queryJsonStr){
                var forvalue = queryJsonStr[i] || '';
                arrSimple.push(i+'='+forvalue);
            }
            arrSimple.sort();
            qcode =arrSimple.join('');
   /*         console.log(qcode);*/
            eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('0=1(0);',2,2,'qcode|md5'.split('|'),0,{}))
            queryJsonStr.qcode = qcode;
            var jsonData;
            $.ajax({
                type: 'post',
                url: restURL + tableName,
                dataType: 'json',
                async: false,
                data: queryJsonStr,
                /*beforeSend:function () {
                    $.showIndicator();
                },*/
                success: function(data) {
                    //$.hideIndicator();
                    jsonData = data;
                },
                error: function(err) {
                    //$.hideIndicator();
                    console.log("请求出错");
                    jsonData = '';
                }
            });
            return jsonData;
        },
        getQueryString: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);  //获取url中"?"符后的字符串并正则匹配
            var context = "";
            if (r != null)
                context = r[2];
            reg = null;
            r = null;
            return context == null || context == "" || context == "undefined" ? "" : context;
        },
        operateRecord: function (targetId, targetType, operateType) {
            var operateName;
            switch (operateType) {
                case 11:
                    operateName = '添加入库单';
                    break;
                case 12:
                    operateName = '编辑入库单';
                    break;
                case 13:
                    operateName = '删除入库单';
                    break;
                case 21:
                    operateName = '添加出库单';
                    break;
                case 22:
                    operateName = '添加出库单';
                    break;
                case 23:
                    operateName = '添加出库单';
                    break;
                case 31:
                    operateName = '登录';
                    break;
            }
            var operateRecord = {};
            operateRecord.depotId = '0';
            operateRecord.fromType = 1;
            operateRecord.ownerId = DES3.decrypt(localStorage.getItem('ownerId'));
            operateRecord.operateUserId = DES3.decrypt(localStorage.getItem('ud'));
            operateRecord.operateUserName = DES3.decrypt(localStorage.getItem('userName'));
            operateRecord.targetId = targetId;
            operateRecord.targetType = targetType;
            operateRecord.operateType = operateType;
            operateRecord.operateName = operateName;
            Restful.post('bsinventoryoperate', operateRecord);
        }
    };
}();

