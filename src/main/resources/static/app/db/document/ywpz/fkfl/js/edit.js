var id = getUrlParam2("id");
var saveUrl = {"url":"","dataType":"text"};  //保存
var editInfo = {"url":"","dataType":"text"}; //编辑数据

var pageModule = function(){
	var initdatafn = function(){
		if(id!="" && !!id){
			$ajax({
				url:editInfo,
				data:{id:id},
				success:function(data){
					setformdata(data);
				}
			})
		}
	}
	var initother = function(){
		$("#quxiao").click(function(){
			newbootbox.newdialogClose("addDialog");
		});
		$("#save").click(function(){
			var flName = $("#flName").val();
			var flId = $("#flId").val();
			var flcontent = $("#flcontent").val();
			$ajax({
				url:saveUrl,
				data:{id:id,flName:flName,flId:flId,flcontent:flcontent},
				type: "GET",
				success:function(data){
					newbootbox.newdialogClose("addDialog");
					if(data.result == "success") {
						newbootbox.alertInfo('保存成功！').done(function(){
							window.top.iframe1.window.iframe100.window.pageModule.initgrid();
						});
					}else{
						newbootbox.alertInfo("保存失败！");
					}
				}
			});
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initdatafn();
			initother();
		}
	};
}();
