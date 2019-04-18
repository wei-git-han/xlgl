var getDataUrl = {"url":"/app/db/document/view/data/getData.json","dataType":"text"};;//右侧获取文件信息
var fileId=getUrlParam("fileId")||""; //主文件id
var pageModule = function(){
	var initdata = function(){
		$ajax({
			url:getDataUrl,
			data:{id:fileId},
			success:function(data){
				$(".commonHtml").append(
					'<div class="line1"><span class="fileName">'+data.fileName+'</span><font class="miji secretLevelName">'+data.secretLevelName+'</font></div>'+
	            	'<div class="line2 fileNum">'+data.fileNum+'</div>'+
	            	'<div class="line3"><i class="fa fa-info-circle" style="color:#33CC99"></i> <span class="option">'+data.option+'</span></div>'
				)
			}
		});	
	}
	var initother = function(){
		
	}
		
	return{
		//加载页面处理程序
		initControl:function(){
			initother();
			initdata();
			$(".scroller").css("height","100%");
			$(".slimScrollDiv").css("height","100%");
		}
	};
}();
