var id = getUrlParam2("id");
var userTree = {"url":"/app/base/user/allTree","dataType":"text"}; //人员选择树
var saveUrl = {"url":rootPath +"/adminset/saveOrUpdate","dataType":"text"};  //保存
var editInfo = {"url":rootPath +"/adminset/info","dataType":"text"}; //编辑数据
var getUserAdminTypeUrl = {"url":rootPath +"/adminset/getAuthor","dataType":"text"};//那当前用户的类型1：部管理员，2：局管理员
var departType = getUrlParam2("departType");
var pageModule = function(){
	var initdatafn = function(){
		if(departType == '1'){
			$('#roleType').val("部管理员");
		} else {
			$('#roleType').val("局管理员");
		}
		$ajax({
			url:editInfo,
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
			}
		});
		
		$("#quxiao,#fanhui").click(function(){
			window.location.href="/app/db/document/ywpz/glysz/html/index.html?departType="+departType;
		})
		
		$("#save").click(function(){
			var userName=$("#userName").val();
			var userId=$("#userId").val();
			var roleType;
			if(userId == ''){
				newbootbox.alertInfo("请选择用户！");
				return;
			}
			if($('#roleType').val() == "局管理员"){
				roleType = 2;
			} else {
				roleType = 1;
			}
			$ajax({
				url:saveUrl,
				data:{id:id,userName:userName,userId:userId,adminType:roleType},
				type: "GET",
				success:function(data){
					if(data.result == "success") {
						newbootbox.alertInfo('保存成功！').done(function(){
							window.location.href = "/app/db/document/ywpz/glysz/html/index.html?departType="+departType;
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
