var sureUrl = {"url":"/app/db/replyexplain/edit","dataType":"text"}; //保存
var subId=getUrlParam("subId")||""; //子分支主id
var fileId=getUrlParam("fileId")||""; 
var teamId=getUrlParam("teamId")||""; 
var fromMsg=getUrlParam("fromMsg")|| false; 
var replyContent=getUrlParam2("replyContent")||""; //文件来源
var checkStatus = getUrlParam("checkStatus");
$("#button1").find("font").text($.trim($("#button1 [data="+checkStatus+"]").text()));
var pageModule = function(){
	var initother = function(){
		$("#replyContent").val(replyContent);
		//确定
		$("#sure").click(function(){
			$.ajax({
				url:sureUrl.url,
				data:{subId:subId,infoId:fileId,teamId:teamId,replyContent:$("#replyContent").val(),checkStatus:checkStatus},
				type:'post',
				success:function(data){
					newbootbox.newdialogClose("editDialog");
					if(data.result=="success"){
						if(fromMsg && fromMsg=="true"){
							newbootbox.alert("修改成功！").done(function(){
								window.parent.pageModule.initblfkList();
							});
						}else{
							newbootbox.alert("修改成功！").done(function(){
								window.top.iframe1.window.pageModule.initblfkList();
							});
						}  
					}else{
						newbootbox.alert("修改失败！");
					}
				}
			})
		});
		
		//关闭
		$("#close").click(function(){
			newbootbox.newdialogClose("editDialog");
		});
		
		$("#button1 a").click(function(){
			var data = $(this).attr("data");
			checkStatus = data;
			var name = $.trim($(this).text());
			$("#button1").find("font").text(name);
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initother();
		}
	};
}();
