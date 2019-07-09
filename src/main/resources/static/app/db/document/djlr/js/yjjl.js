var showIdeaRecordUrl = {"url":"/app/db/addXbDeal/showIdeaRecord","dataType":"text"}; //意见记录
var userTree = {"url":"/app/base/user/tree","dataType":"text"}; //人员选择树
var addOrDeleteXbPersonUrl = {"url":"/app/db/addXbDeal/addOrDeleteXbPerson","dataType":"text"}; //添加或者删除协办人
var commitIdeaUrl={"url":"/app/db/addXbDeal/commitIdea","dataType":"text"}; //发送意见url
var documentId=getUrlParam("documentId");//办件id
var infoId=getUrlParam("infoId")||""; //主文件id
var subId=getUrlParam("subId")||""; //文件来源
var pageModule = function(){
	var initother = function(){
		$("#showInfo").click(function(){
			$('#timeLineTab').hide()
			$('#infoTab').show()
		});
		
		$('#nameArea').hide();
		
		//关闭
		$("#close").click(function(){
			newbootbox.newdialogClose("yijianDialog");
		});
		
		//提交
		$("#tijiao").click(function(){
			$ajax({
				url:commitIdeaUrl,
				data:{infoId:infoId,subId:subId,feedBackIdea:$("#opinionContent").val()},
				type: "GET",
				success:function(data){
					if(data.result == "success"){
						newbootbox.alert("发送成功！").done(function(){
			    			pageModule.takeMenufn()
						});
					}else{
						newbootbox.alert("发送失败！").done(function(){
			    			pageModule.takeMenufn()
						});
					}
				}
			});
			newbootbox.newdialogClose("yijianDialog");
		});
		
		//清屏
		$("#qp").click(function(){
			$("#opinionContent").val("");
		});
		$('#canOrg').click(function(){
			$('#timeLineTab').show()
			$('#infoTab').hide()
		})
		$('#sureOrg').click(function(){
			var treeids = [];
			var userIds = $("#orgTree").jstree("get_checked");//获取选中人员
			
			$.ajax({
	 			url:addOrDeleteXbPersonUrl.url,
	 			data:{userIds:userIds.toString(),subId:subId,infoId:infoId},
	 			success:function(data){
	 				newbootbox.newdialogClose("yijianDialog");
	 				if(data.result  == "success"){
	 					newbootbox.alert('协办人添加成功！');
	 				}else{
	 					newbootbox.alert('协办人添加失败！');			
	 				}
//	 				$("input[name=users]").click(function(){
//	 					window.top.iframe1.window.pageModule.getUserData($(this).attr("personName"),$(this).attr("data"));
//	 					newbootbox.newdialogClose("chooseszDialog");
//	 				})
	 				
	 			}
	 		});
//			$('#timeLineTab').show()
//			$('#infoTab').hide()
		})
	}
	var initOrgTree = function() {
		$ajax({
			url : userTree,
			success : function(data) {
				$("#orgTree").jstree({
					"plugins" : [ "wholerow", "types", "checkbox" ],
					"checkbox" : {
						"keep_selected_style" : false
					},
					"core" : {
						"themes" : {
							"responsive" : false
						},
						"data" : data,
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
	}
	//转办记录
	var initList = function(){
		$ajax({
			url:showIdeaRecordUrl,
 			data:{subId:subId,infoId:infoId},
			success:function(data){
				var html1= "";
				$.each(data,function(i,o){
					var zbr = o.zbr;
					var zbFlag = o.zbFlag;
					if($.trim(zbFlag) == "update"){
						zbFlag = "修改承办人为：";
						var setClass = "timeline-icon";
					}else{
						zbFlag = "发起转办,设置承办人为：";
						var setClass = "timeline-icon1";
					}
					var zbTime = o.zbTime;
					var cbrList = o.cbrList;
					html1=	'<div class="timelinesheys">'+
							'	<div class="'+setClass+'">'+
							'		<i class="icontime"></i>'+
							'	</div>'+
							'	<div class="timeline-user">'+
							'		<span class="user">'+zbr+'</span><span class="zbFlag">'+zbFlag+'</span><span class="zbTime">'+zbTime+'</span>'+
							'	</div>'+
							'	<div class="timeline-body">';
							$.each(cbrList,function(i,item){
									html1 += '<div class="timeline-content" title="">'+
									         '	<div style="font-weight:700;">'+item.orgName+'</div>';
									html1 += '	<div style="color:#555;">'+item.cbrName+'</div>';
									html1 += '</div>';
							})
							
							html1 +='	</div>'+
									'</div>'
					$(".timelinesview").append(html1);
				})
			}
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initList();
			initother();
			initOrgTree()
		}
	};
	
}();

