
var depotre = Restful.post('bsinventorydepot/getDepots',{userId:userId});
if(depotre && depotre.length != 0){
    var html = '';
    for(var i=0,len=depotre.length;i<len;i++){
        html += ' <option value="'+depotre[i].id+'">'+depotre[i].name+'</option>';
    }
    $(".depot").html('').append(html);
    $("#depot option:selected").attr("id");
}else{
    $(".depot").append('<option value="0">默认库</option>');
}