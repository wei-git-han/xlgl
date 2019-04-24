var fileId=getUrlParam("fileId")||""; //主文件id
var pageModule = function(){
	var initother = function(){
		//确定
		$("#sure").click(function(){
			
		});
		
		//关闭
		$("#close").click(function(){
			newbootbox.newdialogClose("cuibanDialog");
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initother();
		}
	};
}();
