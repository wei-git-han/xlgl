var saveUrl = {"url":rootPath +"/orgAdmin/saveOrUpdate","dataType":"text"};  //保存
var editInfo = {"url":rootPath +"/orgAdmin/info","dataType":"text"}; //编辑数据
var uniturl = {"url":"/app/base/dept/allOrgTree","dataType":"text"};//单位数
var treeurl = {"url":"/sysuser/tree","dataType":"text"}; //人员树
var id = getUrlParam("id");
var pageModule = function(){
	var initdatafn = function(){
		if(id && id != "null" && id != ""){
			$("#jb").show();
			$ajax({
				url:editInfo,
				data:{id:id},
				type: "GET",
				success:function(data){
					setformdata(data);
				}
			});
		}else{
			$("#jb").hide();
		}
		
	}
	
	var initother = function(){
		//单位选择
		$("#orgName").createSelecttree({
			url : uniturl,
			width : $("#orgName").parent().width()+"px",
			success : function(data, treeobj) {
			},
			selectnode : function(e, data) {
				$("#orgId").val($("#" + data.selected).attr("id"));
				$("#orgName").val(data.node.text);
			}
		});
		//人员选择
		$("#adminName").createUserTree({
			url : treeurl,
			width : $("#adminName").parent().width()+"px",
			success : function(data, treeobj) {
			},
			selectnode : function(e, data,treessname,treessid) {
				$("#adminName").val(treessname);
				$("#adminId").val(treessid);
			},
			deselectnode : function(e, data,treessname,treessid) {
				$("#adminName").val(treessname);
				$("#adminId").val(treessid);
			}
		});
		
		$("#quxiao").click(function(){
			window.location.href="/app/db/document/ywpz/jssz/html/jssz.html";
		});
		
		
		$("#commentForm").validate({
		    submitHandler: function() {
		    	var orgId = $("#orgId").val();
				var orgName = $("#orgName").val();
		    	var adminName = $("#adminName").val();
				var adminId = $("#adminId").val();
				var orgLevel=$("#orgLevel").val();
				if(adminName == null || adminName == ''){
					newbootbox.alert("请选择人员！");
					return ;
				}
				$ajax({
					url:saveUrl,
					data:{id:id,adminName:adminName,adminId:adminId,orgName:orgName,orgId:orgId,orgLevel:orgLevel},
					type:'GET',
					success:function(data){
						if(data.result=="success"){
							newbootbox.alertInfo("保存成功！").done(function(){
								window.location.href="/app/dzbms/document/ywpz/jssz/html/jssz.html";
							}); 
						}else{
							newbootbox.alertInfo(data.result); 
						}
					}
				})
		    }
		 });
		
		 $("#save").click(function(){
			$("#commentForm").submit();
		 });
	}
	
	return{
		//加载页面处理程序
		initControl:function(){
			initdatafn();
			initother();
		}
	};
}();
