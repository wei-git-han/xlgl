var deptTreeUrl = {"url":"/app/base/user/tree","dataType":"text"}; //部门树
var sureUrl = {"url":"/app/db/subdocinfo/submitOperation","dataType":"text"}; //保存
var subId=getUrlParam("subId")||""; //子分支主id
var infoId=getUrlParam("infoId")||""; //主文件id
var replyContent=getUrlParam2("replyContent")||""; //文件来源
var userId;
var userName;

var pageModule = function(){
	var initTree = function(){
		$ajax({
			url:deptTreeUrl,
			success:function(data){
				$("#people-tree").jstree({
				    "plugins": ["wholerow", "types"],
				    "core": {
				    "themes" : {
				        "responsive": false
				    },    
				    "data": data,
				    },
				    "types" : {
				    	"default" : {
					        "icon" : "peoples_img"
					    },
					    "file" : {
					        "icon" : "peoples_img"
					    },
					    "1" : {
					        "icon" : "people_img"
					    }
				    }
				});
				$("#people-tree").on("select_node.jstree", function(e,data) {
					 userName = data.node.text;
					 userId = data.node.id;
				});
				
			}
		})
	};
	
	var initother = function(){
		//确定
		$("#sure").click(function(){
			$ajax({
				url:sureUrl,
				data:{subId:subId,infoId:infoId,userName:userName,userId:userId,replyContent:replyContent},
				success:function(data){
					newbootbox.newdialogClose("zhuanbanDialog");
					if(data.result=="success"){
						newbootbox.alert("提交成功！").done(function(){
							$("#iframe1",window.top.document).attr("src","/app/db/document/grdb/html/grdb.html");
						});
					}else{
						newbootbox.alert("提交失败！");
					}
				}
			})
		});
		
		//关不
		$("#close").click(function(){
			newbootbox.newdialogClose("tijiaoDialog");
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initTree();
			initother();
		}
	};
}();
