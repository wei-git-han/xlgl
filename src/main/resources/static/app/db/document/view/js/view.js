var menuUrl = {"url":rootPath +"/documentfile/list","dataType":"text"};;//左侧文件menulist（文件列表-附件list）
var getFileUrl = {"url":"/app/db/documentfile/getFile","dataType":"text"};;//左侧页签获取文件信息
var getDataUrl = {"url":"/app/db/documentinfo/info","dataType":"json"};//右侧获取主文件信息
var getSzpsListUrl = {"url":rootPath +"/documentszps/queryList","dataType":"text"}; //获取首长批示
var zbjlDataUrl = {"url":"/app/db/documentzbjl/list","dataType":"json"}; //文件转办-转办记录list
var getButtonParamUrl = {"url":"/app/db/subdocinfo/buttonParam","dataType":"json"}; //获取按钮显示控制参数
var chengbanUrl = {"url":"/app/db/subdocinfo/undertakeOperation","dataType":"text"}; //承办地址
var tjUrl = {"url":"/app/db/subdocinfo/submitOperation","dataType":"text"}; //办理反馈提交
var luoShiUrl = {"url":"/app/db/subdocinfo/luoShiOperation","dataType":"text"}; //常态落实操作

var listUrl = {"url":"/app/db/document/view/data/blfkList.json","dataType":"text"}; //办理反馈list
var cbDataUrl = {"url":"/app/db/document/view/data/cbList.json","dataType":"text"}; //文件转办-催办记录list
var bjDataUrl = {"url":"/app/db/document/view/data/bjList.json","dataType":"text"}; //文件转办-办结记录list
var banjieUrl = {"url":"/app/db/document/view/data/tjsuccess.json","dataType":"text"}; //办结地址

var uploadFileUrl = "/app/db/documentinfo/uploadFile";//文件上传
var fileId=getUrlParam("fileId")||""; //主文件id
var subId=getUrlParam("subId")||""; //主文件id
var fileFrom=getUrlParam("fileFrom")||""; //文件来源

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
				if(!data.isUndertaken && data.isCheckUser){//承办、转办按钮都显示，输入框相关不显示
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
						if(data.roleType=='3'){//是局长显示审批完成否则显示提交
							$("#sptg").show();
						}else{
							$("#tijiao").show();
						}
						if(!isUndertaker){//当前处理人是承办人则不显示返回修改
							$("#fhxg").show();
						}
					}
				}
			}
		});	
	}
	
	//文件menu
	var takeMenufn = function(id){
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
	
	//文件列表——附件
	var initFjfn = function(){
		$ajax({
			url:menuUrl,
			data:{infoId:fileId},
			success:function(data){
				if(data&&data.length>0){
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
	
	//办理反馈记录
	var initblfkList = function(){
		$ajax({
			url:listUrl,
 			data:{fileId:fileId},
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
								'		<span style="color:#999;">'+listdate+'</span>'+
								'	</div>'+
								'	<div class="timeline-body">';
								$.each(o.rows,function(k,b){
									var borderStyle="";
									var answerStyle="";
									var answer = b.answer;
									var isOK = b.isOK;
									var isOKobj = "";
									if(isOK == "1"){
										isOKobj ="审批通过";
									}
									if(answer !="0"){
										answerStyle = "margin-left:20px!important;"
									}
									if(k>0){
										borderStyle = "border-top:none;"
									}
									html1 += '<div class="timeline-content" style="'+borderStyle+answerStyle+'">'+
									         '	<div class="listUser"><img src="../images/userh.png" class="listicon"> '+b.uerName+'<span class="isOkFlag">'+isOKobj+'</span></div>';
									html1 += '	<div class="listContent">';
									html1 += '		<span>'+b.content+'</span><span>'+b.createdTime+'</span><div class="listfj">';
									$.each(b.fj,function(s,t){
										html1 += '		<a id="'+t.fjId+'">'+t.fjName+'</a>';
									})
									html1 += '	</div></div>';
									html1 += '</div>';
								})
								
								html1 +='	</div>'+
										'</div>'
						$(".timelinesview").append(html1);
					})
				}
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
			data:{fileId:fileId},
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
		
		//办理反馈
		$("#clear").click(function(){
			$("#opinionContent").val("");
		});
		
		//办理反馈提交
		$("#tijiao").click(function(){
			if($.trim($("#opinionContent").val()) == "" || $.trim($("#opinionContent").val())=="null"){
				newbootbox.alert("意见不能为空！");
				return;
			}
			$ajax({
				url:tjUrl,
				data:{subId:subId,opinionContent:$("#opinionContent").val()},
				success:function(data){
					if(data.result == "success"){
						newbootbox.alert("保存成功！").done(function(){
							/*成功后的回调*/
						});
					}
				}
			});	
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
		
		//转办
		$("#zhuanban").click(function(){
			newbootbox.newdialog({
				id:"zhuanbanDialog",
				width:800,
				height:600,
				header:true,
				title:"转办",
				classed:"cjDialog",
				url:"/app/db/document/jndb/html/zhuanbanDialog.html?subId="+subId+"&infoId="+fileId+"&fileFrom="+fileFrom
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
	 					data:{fileId:fileId},
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
		$("#form3").validate({
		    submitHandler: function() {
				var ajax_option ={
					type: "post",
					url:uploadFileUrl,//默认是form action
					success:function(data){
						if(data.result == "success"){
							newbootbox.alert('上传成功！').done(function(){
				        		$(".fileinput-filename").text("");
				    			$("#pdf").val("");
		    				});
						}else{
							newbootbox.alert("上传失败！"); 
						}
					}
				}
				$('#form3').ajaxSubmit(ajax_option);
		   }
		});
		
		$("#addfjbtn").click(function(){
			$("#pdf").unbind("change");
			$("#pdf").click();
			$("#pdf").change(function(){
				var fileNameArry = $(this).val().split("\\");
				var fileName;
				if(fileNameArry.length==1){
					fileName=fileNameArry[0];
				}else{
					fileName=fileNameArry[fileNameArry.length-1];
				}
				$(".fileinput-filename").text(fileName);
				$("#form3").submit();
			});
		})
	}
		
	return{
		//加载页面处理程序
		initControl:function(){
			showButton();
			takeMenufn();
			initdata();
			initFjfn();
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