var deptTreeUrl = {"url":"/app/base/dept/tree_onlyroot","dataType":"text"}; //部门树
var sureUrl = {"url":"/app/db/documentzbjl/save","dataType":"text"}; //保存
var infoId=getUrlParam("fileId")||""; //主文件id
var pageModule = function(){
	var initTree = function(){
		$ajax({
			url:deptTreeUrl,
			success:function(data){
				$("#people-tree").jstree({
				    "plugins": ["wholerow", "types" , "checkbox"],
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
			}
		})
	};
	
	var initother = function(){
		//确定
		$("#sure").click(function(){
			var nodes2 = $("#people-tree").jstree("get_bottom_selected",true);
			var ids = [];
			var names = [];
			$.each(nodes2,function(i,obj){
				ids.push(obj.id);
				names.push(obj.text);
			});
			
			$ajax({
				url:sureUrl,
				data:{infoId:infoId,deptNames:names.toString(),deptIds:ids.toString()},
				success:function(data){
					newbootbox.newdialogClose("zhuanbanDialog");
					if(data.result=="success"){
						newbootbox.alert("转办成功！").done(function(){
							$("#iframe1",window.top.document).attr("src","/app/db/document/djlr/html/djlr.html");
						});
					}else{
						newbootbox.alert("转办失败！");
					}
				}
			})
		});
		
		//关不
		$("#close").click(function(){
			newbootbox.newdialogClose("zhuanbanDialog");
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
