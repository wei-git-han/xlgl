var lsList = {"url":"/app/db/replyexplain/getAllLatestOneReply","dataType":"text"}; //督办落实列表
var fileId=getUrlParam("fileId")||""; //主文件id
var pageModule = function(){
	var initls = function(){
		$ajax({
			url:lsList,
			data:{infoId:fileId},
			success:function(data){
				$("#lsContent").html("");
				$.each(data,function(i,item){
					$("#lsContent").append(
						'<div class="record">'+
			            '	<div class="line1"><span>'+item.userName+'&nbsp;&nbsp;'+item.createdTime+'&nbsp;&nbsp;落实情况：</span></div>'+
			            '	<div class="line2">'+item.replyContent+'</div>'+
			            '</div>'
		            )
				});
			}
		});
	}
	
	var initother = function(){
		//关闭
		$("#close").click(function(){
			newbootbox.newdialogClose("dblsqkDialog");
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initls();
			initother();
		}
	};
}();
