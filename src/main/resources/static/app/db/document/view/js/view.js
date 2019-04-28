var menuUrl = {"url":rootPath +"/documentfile/list","dataType":"text"};;//左侧文件menulist（文件列表-附件list）
var getFileUrl = {"url":"/app/db/documentfile/getFile","dataType":"text"};;//左侧页签获取文件信息
var getDataUrl = {"url":"/app/db/documentinfo/info","dataType":"json"};//右侧获取主文件信息
var getSzpsListUrl = {"url":rootPath +"/documentszps/queryList","dataType":"text"}; //获取首长批示
var zbjlDataUrl = {"url":"/app/db/documentzbjl/list","dataType":"json"}; //文件转办-转办记录list
var getButtonParamUrl = {"url":"/app/db/subdocinfo/buttonParam","dataType":"json"}; //获取按钮显示控制参数
var chengbanUrl = {"url":"/app/db/subdocinfo/undertakeOperation","dataType":"text"}; //承办地址
var saveUrl = {"url":"/app/db/replyexplain/save","dataType":"text"}; //办理反馈保存
var finishUrl = {"url":"/app/db/subdocinfo/finishOperation","dataType":"text"}; //完成审批操作
var returnUrl = {"url":"/app/db/subdocinfo/returnOperation","dataType":"text"}; //返回修改操作
var luoShiUrl = {"url":"/app/db/subdocinfo/luoShiOperation","dataType":"text"}; //常态落实操作
var banjieUrl = {"url":"/app/db/subdocinfo/banJieOperation","dataType":"text"}; //办结操作
var bjDataUrl = {"url":"/app/db/documentinfo/getBanJieList","dataType":"text"}; //办结记录
var delfjUrl = {"url":"/app/db/replyexplain/deleteAttch","dataType":"text"}; //删除办理反馈中的附件
var downLoadUrl= {"url":"/app/db/replyexplain/downLoad","dataType":"text"}; //下载办理反馈中的附件
var subReplyListUrl = {"url":"/app/db/replyexplain/subReplyList","dataType":"text"}; //局内办理反馈list
//var allReplyListUrl = {"url":"/app/db/replyexplain/allReplyList","dataType":"text"}; //各局办理反馈list
//var opinionUrl = {"url":"/app/db/replyexplain/getOpinion","dataType":"text"}; //各局办理反馈list
var cbDataUrl = {"url":"/app/db/document/view/data/cbList.json","dataType":"text"}; //文件转办-催办记录list
var fileId=getUrlParam("fileId")||""; //主文件id
var subId=getUrlParam("subId")||""; //主文件id
var fileFrom=getUrlParam("fileFrom")||""; //文件来源
var isCbr = 0;
var pageModule = function(){
	/* 按钮权限控制 */
	var showButton = function(){
		$ajax({
			url:getButtonParamUrl,
			data:{subId:subId},
			success:function(data){
				$(".ifShow").hide();
				/*Integer docStatus=0;//1:待转办；3：退回修改；5：待落实；7：待审批；9：办理中；11：建议办结;
				String roleType = DbDefined.ROLE_6;//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
				boolean isCheckUser=false;//是否是当前办理人
				boolean isUndertaken=false;//是否已承办
				boolean isUndertaker=false;//是否承办人*/
				if(data.docStatus<10){//文件为办理中
					if(!data.isUndertaken && data.isCheckUser){//承办、转办按钮显示，输入框相关不显示
						$(".right_top_zbjl").css("bottom","60px");//按钮父元素上方元素样式控制
						$(".right_zbjl").show();//按钮父元素样式控制
						$("#chengban").show();
						$("#zhuanban").show();
					}else{
						if(data.isCheckUser){//显示办结、常态落实,输入框
							$(".right_zbjl").show();
							$("#luoshi").show();
							$("#banjie").show();
							$(".blfk_bottom").show(); //意见框
							$(".blfk_top").css({"bottom":"40%","height":"58%"});   //意见框上方元素样式控制
							$("#save").show();
							//$("#showfj").show();
							
							if(data.roleType=='3'){//是局长显示审批完成否则显示提交
								$("#sptg").show();
							}else{
								$("#tijiao").show();
							}
							if(!data.isUndertaker){//当前处理人是承办人则不显示返回修改
								$("#fhxg").show();
							}else{
								$("#ifaddfj").show();
								$("#showfj").show();
								isCbr = 1;
							}
						}
					}
				}
					
			}
		});	
	}
	
	//文件menu
	var takeMenufn = function(){
		$ajax({
			url:menuUrl,
			data:{infoId:fileId},
			success:function(data){
				var html1 = "";
				var firstFileId="";
				if(data &&　data.length>0){
					$("#ttcont").append(`
						<div id="tt" class="easyui-tabs" data-options="tabHeight:40,tabWidth:180" style="width:100%;"></div>	
					`);
					$.each(data,function(i,o){
						if(i==0){
							firstFileId = o.id;
						}
						var id = o.id;
						var fileName = o.fileName;
						var fileServerFormatId = o.fileServerFormatId;
						$("#tt").append(`
							<div title="<font title='${fileName}'>${fileName}</font>" id="${id}" fileServerFormatId="${fileServerFormatId}">
							</div>
						`);
					}); 
					$('#tt').tabs({
						onSelect:function(title){
							var tab = $('#tt').tabs('getSelected');
							var id = tab.attr("id");
							var fileServerFormatId = tab.attr("fileServerFormatId");
							$("#fjList>li>a").removeClass("fjactive");
							$("#fj_"+id).find("a").addClass("fjactive");
							getFile(id);
						},
						onClose:function(title){
						}
					});
					
					//文件列表——附件
					$("#fjList").html("");
					$.each(data,function(i,item){
						$("#fjList").append('<li num="'+i+'" id="fj_'+item.id+'"  data_id="'+item.id+'" formatId="'+item.fileServerFormatId+'" ><a class="'+(i==0?"fjactive":"")+'">'+item.fileName+'</a></li>');
					});
					//点击附件名称
					$("#fjList li").click(function(){
						$("#fjList>li>a").removeClass("fjactive");
						$(this).find("a").addClass("fjactive");
						var clickfileId = $(this).attr("data_id");
						getFile(clickfileId);
						$("#tt").tabs("select",parseInt($(this).attr("num")))
					}); 
				}
			}
		});	
	}
	
	var getFile = function(clickfileId){
		$ajax({
			url:getFileUrl,
			data:{id:clickfileId},
			success:function(data){
				var downFormatIdUrl = data.downFormatIdUrl;
				if(downFormatIdUrl != null && downFormatIdUrl != ''){
					openOFDFile(downFormatIdUrl, "suwell",$("#suwell").width(),$("#suwell").height(), "showTablet");
				}else{//没有文件仅初始化插件
					suwell.ofdReaderInit("suwell",$("#suwell").width(),$("#suwell").height());
				}
			}
		});	
	}
	
	//批示信息
	var initps = function(){
		$ajax({
			url:getSzpsListUrl,
			data:{infoId:fileId},
			success:function(data){
				var psxqBtn="";
				if(data.length>1){
					psxqBtn='<a href="javascript:;" class="psxqBtn" onclick="showXQ(\''+fileId+'\')">详情</a>'
				}
				if(data&&data.length>0){
					$(".line3").html('<i class="fa fa-info-circle" style="color:#33CC99"></i> <span class="option"><font class="psstyle">'+data[0].userName+'批示：'+data[0].leaderComment+'</font>'+psxqBtn+'</span>');
				}
			}
		});	
	}
	
	/*公文信息*/
	var initdata = function(){
		$ajax({
			url:getDataUrl,
			data:{id:fileId},
			success:function(data){
				if(data && !!data){
					$("#gwName").text(data.docTitle);
					$(".commonHtml").html("");
					$(".commonHtml").append(
						'<div class="line1"><span class="fileName">'+data.docTitle+'</span><font class="miji secretLevelName">'+data.urgencyDegree+'</font></div>'+
		            	'<div class="line2 fileNum">'+data.banjianNumber+'</div>'
					)
				}
			}
		});	
	}
	
	
	//办理反馈记录
	var initblfkList = function(){
		$ajax({
			url:subReplyListUrl,
 			data:{infoId:fileId,subId:subId},
			success:function(data){
				if(data&&data.length>0){
					var html1= "";
					$.each(data,function(i,o){
						var listdate = o.listdate;
						html1=	'<div class="timelinesheys ">'+
								'	<div class="timeline-icon1">'+
								'		<i class="icontime"></i>'+
								'	</div>'+
								'	<div class="timeline-user">'+
								/*'		<span style="color:#999;">'+listdate+'</span>'+*/
								'		<span style="color:#999;">2019-05-01 09:00:00</span>'+
								'	</div>'+
								'	<div class="timeline-body">';
									var borderStyle="";
									var showZhankaiStyle="";
									var cuoweiStyle="";
									var showZhankai = o.showZhankai;
									var cuowei = o.cuowei;
									if(cuowei && cuowei == "1"){
										cuoweiStyle = "margin-left:20px!important;"
									}
									//var ifeditbtn = o.ifeditbtn;
									var ifeditbtn = "1";
									if(i>0){
										borderStyle = "border-top:none;"
									}
									if(showZhankai =="1"){//1展开（有margin）      0不展开
										showZhankaiStyle = "margin-left:30px!important;"
									}
									html1 += '<div class="timeline-content" style="'+borderStyle+'">'+
									         '	<div class="listUser" data_id="'+o.teamId+'"><img src="../images/userh.png" class="listicon"> '+o.cbrName+'</div>';
									html1 += '	<div class="listContent">';
									html1 += '		<span>'+o.content+'</span><span>'+o.updateTime+'</span><div class="listfj">';
									
									
									$.each(o.attchList,function(s,t){
										html1 += '		<div class="fujianwrap"><a class="fujian" id="'+t.id+'" onclick="downloadfn(\''+t.fileServerId+'\')">'+t.fileName+'</a><i title="删除附件" class="fa fa-times-circle delx" data="'+t.id+'"></i></div>';
									})
									
									html1 += '	</div>';
									if(ifeditbtn == "1"){
										html1 += '		<div class="editwrap"><button class="editBtn" id="'+o.teamId+'" data_val="'+o.content+'">编辑</button></div>';
									}
									html1 += '	</div>';
									html1 += '	</div>';
									if(cuowei && cuowei == "1"){
										html1 +='<div class="zhankaiwrap"><a data_id="'+o.teamId+'" class="zhankai">展开</a>  <i class="fa fa-angle-down" style="color:#5b9bd1"></i></div>'
									}
									$.each(o.opinionList,function(s,k){
										var trackingType = k.trackingType;
										var trackingTypeobj = "";
										if(trackingType == "3"){
											trackingTypeobj ="返回修改";
										}else{
											trackingTypeobj ="审批通过";
										}
										
										html1 += '<div class="timeline-content '+o.teamId+'" style="'+borderStyle+cuoweiStyle+'display:none;">'+
										         '	<div class="listUser" data_id="'+k.id+'"><img src="../images/userh.png" class="listicon"> '+k.userName+'<span class="isOkFlag">'+trackingTypeobj+'</span></div>';
										html1 += '	<div class="listContent">';
										html1 += '		<span>'+k.opinionContent+'</span><span>'+k.createdTime+'</span>';
										html1 += '	</div>';
										html1 += '</div>';
									})
									html1 +='	</div>';
								
								
								
								
								html1 +='	</div>'
						$(".timelinesview").append(html1);
					})
				}else{
					$(".timelinesview").attr("style","padding:0px!important");
				}

				//意见记录编辑
				$(".editBtn").unbind("click");
				$(".editBtn").click(function(){
					if($.trim($(this).text())=="编辑"){
						$(this).text("取消编辑");
						$("#replyContent").val($(this).attr("data_val"));
						$("#editRecordId").val($(this).attr("id"));
						$("#editTeamId").val($(this).attr("id"))
						if(isCbr && isCbr == 1){
							$(this).parents(".timeline-content").find(".fujianwrap .delx").attr("style","display:inline-block!important");
							return;
						}
					}else{
						$(this).text("编辑");
						$("#replyContent").val("");
						$("#editRecordId").val("");
						$(this).parents(".timeline-content").find(".fujianwrap .delx").attr("style","display:none!important");
					}
				});
				
				//删除附件
				$(".delx").click(function(){
					$(this).parent().remove();
					var delId = $(this).attr("data");
					$ajax({
	 					url:delfjUrl,
	 					data:{id:delId},
	 					type: "GET",
	 					success:function(data){
	 						if(data.result == "success"){
	 							showButton();
	 						}
	 					}
	 				});
				});
				
				//展开
				$(".zhankai").click(function(e){
					var dataId = $(this).attr("data_id");
					if($.trim($(this).text()) == "展开"){
						$("."+dataId).slideDown(500);
						$(this).text("收起");
						$(this).siblings().removeClass("fa-angle-down").addClass("fa-angle-up");
					}else{
						$("."+dataId).slideUp(500);
						$(this).text("展开");
						$(this).siblings().removeClass("fa-angle-up").addClass("fa-angle-down");
					}
				});
			}
		})
	}
	
	//文件转办——转办记录
	var initzbjlfn = function(){
		$ajax({
			url:zbjlDataUrl,
			data:{infoId:fileId},
			success:function(data){
				if(data&&data.length>0){
					$("#zbrecord").html("");
					$.each(data,function(i,item){
						$("#zbrecord").append(
							'<div class="record">'+
				            '	<label class="zbUser">转办人:</label>'+
				            '	<div><span>'+item.userName+'</span><span class="zbDate">'+item.createdTime+'</span></div>'+
				            '	<label class="cbdw">承办单位/人:</label>'+
				            '	<div>'+item.receiverNames+'</div>'+
				            '</div>'
			            )
					});
				}
			}
		});	
	}
	
	//文件转办——催办记录
	var initcbfn = function(){
		$ajax({
			url:cbDataUrl,
			data:{fileId:fileId},
			success:function(data){
				if(data&&data.length>0){
					$("#cbrecord").html("");
					$.each(data,function(i,item){
						$("#cbrecord").append(
							'<div class="record">'+
				            '	<label class="zbUser">转办人:</label>'+
				            '	<div><span>'+item.zbUser+'</span><span class="zbDate">'+item.zbdate+'</span></div>'+
				            '	<label class="cbdw">承办单位/人:</label>'+
				            '	<div>'+item.unit+'</div>'+
				            '</div>'
			            )
					});
				}
			}
		});	
	}
	
	//文件转办—办结记录
	var initbjfn = function(){
		$ajax({
			url:bjDataUrl,
			data:{infoId:fileId},
			success:function(data){
				if(data&&data.length>0){
					$("#jybjrecord").html("");
					$.each(data,function(i,item){
						$("#jybjrecord").append(
							'<div class="record">'+
				            '	<label class="zbUser">转办人:</label>'+
				            '	<div><span>'+item.zbUser+'</span><span class="zbDate">'+item.zbdate+'</span></div>'+
				            '	<label class="cbdw">承办单位/人:</label>'+
				            '	<div>'+item.unit+'</div>'+
				            '</div>'
			            )
					});
				}
			}
		});	
	}

	var initother = function(){
		//返回
		$("#goback").click(function(){
			skip();
		});
		
		//办理反馈清屏
		$("#clear").click(function(){
			$("#replyContent").val("");
		});
		
		//送审
		$("#tijiao").click(function(){
			var cbrFlag="";
			if(isCbr && isCbr == 1){
				cbrFlag="1";
			}
			if(isCbr != 1){
				if($("#replyContent").val() == "" || $("#replyContent").val() == null || $("#replyContent").val() == "undefined"){
					newbootbox.alert("意见不能为空！");
					return;
				}
			}
			newbootbox.newdialog({
				id:"tijiaoDialog",
				width:800,
				height:600,
				header:true,
				title:"提交",
				classed:"cjDialog",
				url:"/app/db/document/view/html/tijiaoDialog.html?subId="+subId+"&infoId="+fileId+"&replyContent="+$("#replyContent").val()+"&cbrFlag="+cbrFlag
			})
		});
		
		//承办
		$("#chengban").click(function(){
			$ajax({
				url:chengbanUrl,
				data:{subId:subId},
				type: "GET",
				success:function(data){
					if(data.result == "success"){
						showButton();
					}
				}
			});
		});
		
		
		//返回修改
		$("#fhxg").click(function(){
			var replyContent = $("#replyContent").val();
			if(replyContent == "" || replyContent== null || replyContent == "undefined"){
				newbootbox.alert("意见不能为空！");
				return;
			}
			$ajax({
				url:returnUrl,
				data:{subId:subId,replyContent:replyContent},
				type: "GET",
				success:function(data){
					if(data.result == "success"){
						showButton();
					}
				}
			});
		});
		
		//审批通过
		$("#sptg").click(function(){
			var replyContent = $("#replyContent").val();
			if(replyContent == "" || replyContent== null || replyContent == "undefined"){
				newbootbox.alert("意见不能为空！");
				return;
			}
			$ajax({
				url:finishUrl,
				data:{subId:subId,replyContent:replyContent},
				type: "GET",
				success:function(data){
					if(data.result == "success"){
						showButton();
					}
				}
			});
		});
		
		//转办
		$("#zhuanban").click(function(){
			newbootbox.newdialog({
				id:"zhuanbanDialog",
				width:800,
				height:600,
				header:true,
				title:"转办",
				classed:"cjDialog",
				url:"/app/db/document/jndb/html/zhuanbandx.html?subId="+subId+"&infoId="+fileId+"&fileFrom="+fileFrom
			})
		});
		
		//办结
		$("#banjie").click(function(){
			newbootbox.oconfirm({
			 	title:"提示",
			 	message: "是否确认要进行文件办结操作？",
			 	callback1:function(){
	 				$ajax({
	 					url:banjieUrl,
	 					data:{infoId:fileId,subId:subId},
	 					type: "GET",
	 					success:function(data){
	 						if(data.result == "success"){
	 							showButton();
	 						}
	 					}
	 				});
			 	}
			});
		});
		
		//常态落实
		$("#luoshi").click(function(){
			newbootbox.oconfirm({
			 	title:"提示",
			 	message: "是否确认要进行文件常态落实操作？",
			 	callback1:function(){
	 				$ajax({
	 					url:luoShiUrl,
	 					data:{infoId:fileId,subId:subId},
	 					type: "GET",
	 					success:function(data){
	 						if(data.result == "success"){
	 							showButton();
	 						}
	 					}
	 				});
			 	}
			});
		});
		
		//办理反馈-添加附件
		var o1 = $("#file1").createfile({
			//initdata:filedata1,
			yn:true,//true 多个  false 单个
			view:"view1",//view1 列表视图  view2 图片视图
			name:"file",// 后端获取文件的名称
			type:["ofd","pdf","doc","docx","wps"],
			maxsize:500*1024*1024,
			cssStyle:"width:0px;height:0px"
		});
		
		//表单
		$("#commentForm").validate({
		    submitHandler: function() {
		    	var ajax_option = {
					url : saveUrl.url,// 默认是form action
					data:{subId:subId,infoId:fileId,teamId:$("#editTeamId").val(),replyContent:$("#replyContent").val()},
					success : function(data) {
						if (data.result == "success") {
							newbootbox.alert("保存成功！").done(function(){
								$("#replyContent").val("");
								initblfkList();
							}); 
						} else {
							newbootbox.alert("提交失败，请稍后重试！"); 
						}
					}
				}
				$('#commentForm').ajaxSubmit(ajax_option); 
		    }
		});
		
		//办理反馈保存
		$("#save").click(function(){
			$("#commentForm").submit();
		});
		
		//催办
		$("#cuiban").click(function(){
			newbootbox.newdialog({
				id:"cuibanDialog",
				width:800,
				height:600,
				header:true,
				title:"催办",
				classed:"cjDialog",
				url:"/app/db/document/view/html/cuibanDialog.html?fileId="+fileId,
			})
		});
		
		//查看附件
		$("#showfj").click(function(){
			$(".filelist").toggle();
		});
		
		$("body").click(function(e){
			if($(e.target).hasClass("showfj") || $(e.target).parents("div").hasClass("filelist")){
				return;
			};
			$(".filelist").hide();
		});
	}
		
	return{
		//加载页面处理程序
		initControl:function(){
			showButton();
			takeMenufn();
			initdata();
			initblfkList();
			initps();
			initzbjlfn();
			initcbfn();
			initbjfn();
			initother();
			$(".scroller").css("height","100%");
			$(".slimScrollDiv").css("height","100%");
		}
	};
}();


//跳转返回事件
function skip(){
	if(fileFrom == "djlr"){//文件来源于登记录入
		window.location.href="/app/db/document/djlr/html/djlr.html?searchType=djlr";
	}else if(fileFrom == "grdb"){//文件来源于个人待办
		window.location.href="/app/db/document/grdb/html/grdb.html?searchType=grdb";
	}else if(fileFrom=="blfk"){  //文件来源于办理反馈
		window.location="/app/db/document/blfk/html/blfk.html?searchType=blfk";
	}else{ 
		window.location.href="/app/db/document/grdb/html/grdb.html?searchType=grdb";
	}
}

//批示详情
function showXQ(id){
	newbootbox.newdialog({
		id:"psDialog",
		width:800,
		height:600,
		header:true,
		title:"批示详情",
		classed:"cjDialog",
		url:"/app/db/document/view/html/psDialog.html?fileId="+id,
	})
}

//下载
function downloadfn(fileServerId){
	$ajax({
		url:downLoadUrl,
		data:{fileId:fileServerId},
	    success:function(data){
	    	if(data.url != null && data.url != ''){
	    		window.location.href = data.url;
	    	}
	    }
	});
}
