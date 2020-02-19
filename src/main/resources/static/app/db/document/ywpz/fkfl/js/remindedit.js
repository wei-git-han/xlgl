var id = getUrlParam2("id");
var role = getUrlParam2("role");
var time = getUrlParam2("time");
var content = getUrlParam2("content");
var type = getUrlParam2("type");
var saveUrl = {"url":"/remindadministration/save","dataType":"text"};  //保存
var editUrl = {"url":"/remindadministration/update","dataType":"text"};  //修改
var editInfo = {"url":"/remindadministration/info","dataType":"text"}; //编辑数据

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
//			setformdata({
//				remindRole : role,
//				remindTime : time,
//				remindContent : content
//			});
		}

		console.log(role,time,content)
	}
	var initother = function(){
		$("#quxiao").click(function(){
			newbootbox.newdialogClose("addDialog");
		});
		$("#save").click(function(){
			var remindRole = $("#remindRole").val();
			var remindTime = $("#remindTime").val();
			var remindContent = $("#remindContent").val();
			$ajax({
				url:id?editUrl:saveUrl,
				data:{id:id,remindRole:remindRole,remindTime:remindTime,remindContent:remindContent,type:type},
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
