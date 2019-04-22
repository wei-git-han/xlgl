var peopleTreeUrl = {"url":"/app/base/user/tree","dataType":"text"}; //人员树
var userName;//选择的首长名字
var userId;//选择的首长id
var pageModule = function(){
	var initTree = function(){
		$ajax({
			url:peopleTreeUrl,
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
					var id = $("#" + data.selected).attr("id");
					userName = data.node.text;
					userId = data.node.id;
				});
			}
		})
	};
	
	var initother = function(){
		//确定
		$("#sure").click(function(){
			window.top.iframe1.window.pageModule.getUserData(userName,userId);
			newbootbox.newdialogClose("chooseszDialog");
		});
		
		//关闭
		$("#close").click(function(){
			newbootbox.newdialogClose("chooseszDialog");
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
