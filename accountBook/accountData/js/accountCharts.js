/**
 * Created by new on 2017/4/5.
 */

var isZhou = false;
var grainType = 2;
var searchType = 1;
var timeType = 1;
var depot = '0';
var ymval, xmval, sdval;
var xData,outData,hasData,xDataz,outDataz,hasDataz;
var yinPriceData;
var yinAmountData;
var hasAmountData;
var outPriceData;
var outAmoountData;
var inAmountName = '收粮量(吨)';
var hasAmountName = '库存(吨)';
var outAmountName = '售粮量(吨)';
var colors = ['#5793f3', '#d14a61', '#675bba'];
var colorsLine = [ '#d14a61', '#675bba'];
getData();
var depotre = Restful.post('bsinventorydepot/getDepots',{userId:userId});
if(depotre){
    var html = '<option value="0">全部</option>';
 
    for(var i=0,len=depotre.length;i<len;i++){
        html += ' <option value="'+depotre[i].id+'">'+depotre[i].name+'</option>';
    }
    $(".depot").html('').append(html);

/*console.log(depotre);*/	
}
function getData() {
    var params = {};
    params.userId = DES3.decrypt(localStorage.getItem('userId'));
	params.depotId = depot;
    params.searchType = timeType;
    params.grainType = grainType;
    params.type = searchType;
    var res = Restful.post('bsinventoryrecord/findRecordDao', params);
/*    console.log(res);*/
    if (res) {
        var data = res.dataList;
        var msg = $('#table-list').html();
        var compiledTemplate = Template7.compile(msg);
        var html = compiledTemplate({"table": data});
        $("#list").html(html);
        var chartData = res.dataList[0];
        ymval = chartData.ymPercentage;
        xmval = chartData.xmPercentage;
        sdval = chartData.sdPercentage;
        xData = chartData.xData;
        hasData = chartData.hasData;
        outData = chartData.outData;
        xDataz = chartData.xDataz;
        hasDataz = chartData.hasDataz;
        outDataz = chartData.outDataz;
        yinPriceData = chartData.yinPriceData;
        yinAmountData = chartData.yinAmountData;
        hasAmountData = chartData.hasAmountData;
        outPriceData = chartData.outPriceData;
        outAmoountData = chartData.outAmoountData;
        var inLine = echarts.init(document.getElementById('c-inLine'));
        var inBar = echarts.init(document.getElementById('c-inBar'));
        var hasChart = echarts.init(document.getElementById('c-hasBar'));
        var outLine = echarts.init(document.getElementById('c-outLine'));
        var outBar = echarts.init(document.getElementById('c-outBar'));
        //入库
        inLineoption = {
            grid:{
                left:'15%',
                bottom:67,
            },
            title:{
                text: '入库价格',
                padding:[5,5,5,40],
                textStyle:{
                    color:'#000'
                }
            },
            legend: {
                data: ['收粮价(元/斤)'],
                y: 30
            },
            color: colorsLine,
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    var res;
                    if(isZhou){
                        res = '<p>'+params[0].axisValue+'</br>'+xDataz[params[0].dataIndex]+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }else{
                        res ='<p>'+params[0].axisValue+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }
                    return res;
                }
            },
            xAxis: [
                {
                    type: 'category',
                    data: xData,
                    axisLabel: {
                        rotate: 45
                    },
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '收粮价(元/斤)',
                    //nameLocation:'start',
                    boundaryGap: ['10%', '10%'],
                    splitLine: {
                        "show": false
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name: '收粮价(元/斤)',
                    type: 'line',
                    itemStyle: {
                        normal: {
                            label: {
                                show: true
                            }
                        }
                    },
                    data: yinPriceData
                }
            ]
        };
        inBaroption = {
    		grid:{
                left:'15%',
                bottom:67,
            },
            color: colors,
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    var res;
                    if(isZhou){
                        res = '<p>'+params[0].axisValue+'</br>'+xDataz[params[0].dataIndex]+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }else{
                        res ='<p>'+params[0].axisValue+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }
                    return res;
                }
            },
            title: {
                text: '入库数量',
                padding:[5,5,5,40],
                textStyle:{
                    color:'#000'
                }
            },
            legend: {
                data: [inAmountName],
                y: 30
            },
            xAxis: [
                {
                    type: 'category',
                    data: xData,
                    axisLabel: {
                        rotate: 45
                    },
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: inAmountName,
                    boundaryGap: ['10%', '10%'],
                    splitLine: {
                        "show": false
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                }

            ],
            series: [
                {
                    name: inAmountName,
                    type: 'bar',
                    barMaxWidth: 50,
                    itemStyle: {
                        normal: {
                            label: {
                                show: false,
                                position:'top',
                                color:'#000'
                            }
                        }
                    },
                    data: yinAmountData
                }
            ]
        };
        //库存
        hasOption = {
    		grid:{
                left:'15%',
                bottom:67,
            },
            title:{
                text: '库存数量',
                padding:[5,5,5,40],
                textStyle:{
                    color:'#000'
                }
    		},
            color: colors,
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    var res;
                    if(isZhou){
                        res = '<p>'+params[0].axisValue+'</br>'+hasDataz[params[0].dataIndex]+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }else{
                        res ='<p>'+params[0].axisValue+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }
                    return res;
                }
            },
            legend: {
                data: [hasAmountName],
                y: 30
            },
            xAxis: [
                {
                    type: 'category',
                    data: hasData,
                    axisLabel: {
                        rotate: 45
                    },
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: hasAmountName,
                    boundaryGap: ['10%', '10%'],
                    splitLine: {
                        "show": false
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name: hasAmountName,
                    type: 'bar',
                    barMaxWidth: 50,
                    itemStyle: {
                        normal: {
                            label: {
                                show: false,
                                position:'top',
                                color:'#000'
                            }
                        }
                    },
                    data: hasAmountData
                }
            ]
        };
        //出库
        outLineoption = {
    		grid:{
                left:'15%',
                bottom:67,
            },
            title:{
                text: '出库价格',
                padding:[5,5,5,40],
                textStyle:{
                    color:'#000'
                }
            },
            color: colorsLine,
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    var res;
                    if(isZhou){
                        res = '<p>'+params[0].axisValue+'</br>'+outDataz[params[0].dataIndex]+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }else{
                        res ='<p>'+params[0].axisValue+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }
                    return res;
                }
            },
            legend: {
                data: ['售粮价(元/斤)'],
                y: 30
            },
            xAxis: [
                {
                    type: 'category',
                    data: outData,
                    axisLabel: {
                        rotate: 45
                    },
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '售粮价(元/斤)',
                    boundaryGap: ['10%', '10%'],
                    splitLine: {
                        "show": false
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name: '售粮价(元/斤)',
                    type: 'line',
                    itemStyle: {
                        normal: {
                            label: {
                                show: true
                            }
                        }
                    },
                    data: outPriceData
                }
            ]
        };
        outBaroption = {
    		grid:{
                left:'15%',
                bottom:67,
            },
            color: colors,
            title: {
                text: '出库数量',
                padding:[5,5,5,40],
                textStyle:{
                    color:'#000'
                }
            },
            tooltip: {
                trigger: 'axis',
                formatter: function (params) {
                    var res;
                    if(isZhou){
                        res = '<p>'+params[0].axisValue+'</br>'+outDataz[params[0].dataIndex]+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }else{
                        res ='<p>'+params[0].axisValue+'</br>'+params[0].seriesName+':'+params[0].data+'</p>';
                    }
                    return res;
                }
            },
            legend: {
                data: [outAmountName],
                y: 30
            },
            xAxis: [
                {
                    type: 'category',
                    data: outData,
                    axisLabel: {
                        rotate: 45
                    },
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: outAmountName,
                    boundaryGap: ['10%', '10%'],
                    splitLine: {
                        "show": false
                    },
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name: outAmountName,
                    type: 'bar',
                    barMaxWidth: 50,
                    itemStyle: {
                        normal: {
                            label: {
                                show: false,
                                position:'top',
                                color:'#000'
                            }
                        }
                    },
                    data: outAmoountData
                }
            ]
        };
        if(!yinAmountData){
            $("#c-inBar").html('<div style="width: 100%;height: 100px;line-height: 100px;font-size: 20px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
        }else{
            inBar.setOption(inBaroption);
        }
        if(!yinPriceData){
            $("#c-inLine").html('<div style="width: 100%;height: 100px;line-height: 100px;font-size: 20px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
        }else{
            inLine.setOption(inLineoption);
        }
        if(!hasAmountData){
            $("#c-hasBar").html('<div style="width: 100%;height: 100px;line-height: 100px;font-size: 20px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
        }else{
           hasChart.setOption(hasOption);
        }
        if(!outPriceData){
            $("#c-outLine").html('<div style="width: 100%;height: 100px;line-height: 100px;font-size: 20px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
        }else{
            outLine.setOption(outLineoption);
        }
        if(!outAmoountData){
            $("#c-outBar").html('<div style="width: 100%;height: 100px;line-height: 100px;font-size: 20px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
        }else{
            outBar.setOption(outBaroption);
        }
    } else {
        $("#list").html('');
        $("#list").html('<tr><td colspan="4"><div style="width: 100%;height: 100px;line-height: 100px;font-size: 20px;text-align: center;margin:0 auto;color: #c1c1c1;text-shadow: #999999;">暂无数据</div>');
    }
}
$("#timeType").on('change', function () {
    timeType = $("#timeType").val();
    if(timeType ==2){
        isZhou = true;
    }else{
        isZhou = false;
    }
    grainType = $("#grainType").val();
    getData();
});
$("#searchType").on('change', function () {
    searchType = $("#searchType").val();
    if (searchType != 1) {
        inAmountName = '收粮金额(元)';
        hasAmountName = '库存金额(元)';
        outAmountName = '售粮金额(元)';
    } else {
        inAmountName = '收粮量(吨)';
        hasAmountName = '库存(吨)';
        outAmountName = '售粮量(吨)';
    }
    getData();
});

$("#grainType").on('change', function () {
	grainType = $('#grainType').val();
	getData();
});
	

$("#depot").on('change', function () {
    depot = $("#depot").val();
/*    console.log(depot);*/
    getData();
});

