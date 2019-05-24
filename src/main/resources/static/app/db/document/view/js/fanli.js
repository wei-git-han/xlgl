var flList = {"url":"/app/db/document/view/data/bjList.json","dataType":"text"}; //范例列表--待修改
var fileId=getUrlParam("fileId")||""; //主文件id
var pageModule = function(){
	var initfl = function(){
		$ajax({
			url:flList,
			data:{infoId:fileId},
			success:function(data){
				$("#flContent").html("");
				$.each(data,function(i,item){
					$("#flContent").append(
						'<div class="record">'+
			            '	<div class="line1">'+item.name+'</div>'+
			            '	<div class="line2" id="'+item.id+'">'+item.text+'</div>'+
			            '</div>'
		            )
				});
			}
		});
	}
	
	var initother = function(){
		//关闭
		$("#close").click(function(){
			newbootbox.newdialogClose("fanliDialog");
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initfl();
			initother();
		}
	};
}();
