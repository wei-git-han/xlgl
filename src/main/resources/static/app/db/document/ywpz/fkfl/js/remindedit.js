var id = getUrlParam2("id");
var role = getUrlParam2("role");
var time = getUrlParam2("time");
var content = getUrlParam2("content");
var state = getUrlParam2("state");
var type = getUrlParam2("type");//1局内未转办提醒设置，2为承办或为反馈设置，3催填提醒设置
var saveUrl = {"url":"/remindadministration/save","dataType":"text"};  //保存
var editUrl = {"url":"/remindadministration/update","dataType":"text"};  //修改
var editInfo = {"url":"/remindadministration/info","dataType":"text"}; //编辑数据

var pageModule = function(){
	var initdatafn = function(){
//		$("#datetimepicker").datetimepicker({
//			format: 'HH:mm',
//			language:"zh",
////			autoclose: true,
////			startView: 1,
////			minView:0,
////			maxView:0,
//		}).on('show',function(){
//			
//		})
//		$("#remindTime").html("");
//		var html = "";
//		for(var i = 0;i<25;i++){
//			if(i == 9){
//				html+='<option value="'+i+':00" selected>'+i+':00</option>';
//			}else{
//				html+='<option value="'+i+':00">'+i+':00</option>';
//			}
//		}
//		$("#remindTime").append(html);
		if(id!="" && !!id){
//			$("#remindRole").attr("disabled",true);
			$ajax({
				url:editInfo,
				data:{id:id},
				success:function(data){
					setformdata(data.remindAdministration);
				}
			})
//			setformdata({
//				remindRole : role,
//				remindTime : time,
//				remindContent : content
//			});
		}else{
			setformdata({remindTime:"9:00"});
			$("#remindRole").val("承办人");
		}

		console.log(role,time,content)
	}
	var initother = function(){
		$("#quxiao").click(function(){
			newbootbox.newdialogClose("addDialog");
		});
		$("#save").click(function(){
			var remindRole = $("#remindRole").val();
			var remindTime = $("#remindTime").val()?$("#remindTime").val():"9:00";
			var remindContent = $("#remindContent").val();
			var state = $("#state").val();
			$ajax({
				url:id?editUrl:saveUrl,
				data:{
					id:id,
					remindRole:remindRole,
					remindTime:remindTime,
					remindContent:remindContent,
					type:type,
					state:state?state:"false"
				},
				type: "GET",
				success:function(data){
					newbootbox.newdialogClose("addDialog");
					if(data.msg == "success") {
						newbootbox.alertInfo('保存成功！').done(function(){
							window.top.iframe1.window.iframe100.window.pageModule.initgridright();
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
