var grid = null;
var delUrl={"url":rootPath + '/documentclerkset/delete',"dataType":'json'};
var pageModule = function() {
	var initgrid = function() {
		grid = $("#gridcont").createGrid({
			columns: [{
				display: "所在单位",
				name: "name",
				width: "30%",
				align: "left",
				render: function(rowdata){
					 return rowdata.deptName; 
				}
			}, {
				display: "人员",
				name: "children",
				width: "30%",
				align: "center",
				render:  function(rowdata){
					 return rowdata.userName; 
				}
			},
 			{
				display : "角色",
				name : "directortype",
				width: "40%",
				align : "center",
				render : function(rowdata) {
					return rowdata.directortype=='1'?"正局":"副局";
				}
			}
			],
			
			width: "100%",
			height: "100%",
			checkbox: true,
			rownumberyon: true,
			paramobj:{type:'3'},
			overflowx: false,
            pagesize: 15,
			url: tableUrl
			
		});

	}

	var initother = function() {
		$("#add").click(function() {
			window.location.href="edit.html";
		});
		$("#edit").click(function() {
			var datas = grid.getcheckrow();
			var ids=[];
			if(datas.length < 1 || datas.length > 1) {
				newbootbox.alertInfo("请选择一条数据进行编辑！");
			} else {
				$(datas).each(function(i){
					ids[i]=this.id;
				});
				window.location.href="edit.html?id="+ids[0];
			}
			
		});

		$("#plsc").click(function() {
			var datas = grid.getcheckrow();
			var ids=[];
			if(datas.length < 1) {
				newbootbox.alertInfo("请选择要删除的数据！");
			} else {
				$(datas).each(function(i){
					ids[i]=this.id;
				});
				newbootbox.confirm({
					 title: "提示",
				     message: "是否要进行删除操作？",
				     callback1:function(){
				    	 $ajax({
								url: delUrl,
								type: "GET",
								data: {"ids": ids.toString()},
								success: function(data) {
									if(data.result == "success") {
										newbootbox.alertInfo('删除成功！').done(function(){
											grid.refresh();
										});
									}else{
										newbootbox.alertInfo("删除失败！");
									}
								}
							})
				     }
				});
			}
		});
		
	}

	return {
		//加载页面处理程序
		initControl: function() {
			initgrid();
			initother();
		}
	}

}();
