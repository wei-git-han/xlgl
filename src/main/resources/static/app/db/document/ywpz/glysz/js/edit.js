var id = getUrlParam2("id");
var clerkUrl = {"url":"/app/gwcl/documentclerkset/info","dataType":"text"}
var saveUrl = {"url":rootPath +"/documentclerkset/save","dataType":"text"};
var userTree = {"url":"/app/base/user/allTree","dataType":"text"}; //人员选择树

var pageModule = function(){
	var initdatafn = function(){
		$ajax({
			url:clerkUrl,
			data:{id:id},
			success:function(data){
				setformdata(data);
			}
		})
	}
	
	var initother = function(){
		$("#userName").createUserTree({
			url : userTree,
			width:"100%",
			success : function(data, treeobj) {},
			selectnode : function(e, data) {
				$("#userName").val(data.node.text);
				$("#userId").val(data.node.id);
				var deptId = $("#userNametree2").jstree().get_parent(data.node.id);
				$("#deptId").val(deptId);
			}
		});
		
		$("#quxiao,#fanhui").click(function(){
			window.location.href="/app/db/document/ywpz/glysz/html/index.html";
		})
		
		$("#save").click(function(){
			var userName=$("#userName").val();
			var userId=$("#userId").val();
			var deptId=$("#deptId").val();
			var directortype=$("#directortype").val();
			if(userId == ''){
				newbootbox.alertInfo("请选择用户！");
				return;
			}
			$ajax({
				url:saveUrl,
				data:{userName:userName,userId:userId,deptId:deptId,type:'3',directortype:directortype,id:id},
				type: "GET",
				success:function(data){
					if(data.result == "success") {
						newbootbox.alertInfo('保存成功！').done(function(){
							window.location.href = "/app/gwcl/document/ywpz/bzsz/html/index.html"
						});
					}else if(data.result == "repeat") {
						newbootbox.alertInfo('用户已存在！').done(function(){
							window.location.href = "/app/gwcl/document/ywpz/bzsz/html/index.html"
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
