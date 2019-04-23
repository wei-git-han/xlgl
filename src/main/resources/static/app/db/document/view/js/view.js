var menuUrl = {"url":"/app/db/document/view/data/menuUrl.json","dataType":"text"};;//左侧文件menulist
var getDataUrl = {"url":"/app/db/document/view/data/getData.json","dataType":"text"};;//右侧获取文件信息
var listUrl = {"url":"/app/db/document/view/data/blfkList.json","dataType":"text"}; //办理反馈list
var fjDataUrl = {"url":"/app/db/document/view/data/fjList.json","dataType":"text"}; //文件列表-附件list
var tjUrl = {"url":"/app/db/document/view/data/tjsuccess.json","dataType":"text"}; //办理反馈提交
var zbjlDataUrl = {"url":"/app/db/document/view/data/zbjlList.json","dataType":"text"}; //文件转办-转办记录list
var cbDataUrl = {"url":"/app/db/document/view/data/cbList.json","dataType":"text"}; //文件转办-催办记录list
var bjDataUrl = {"url":"/app/db/document/view/data/bjList.json","dataType":"text"}; //文件转办-办结记录list
var banjieUrl = {"url":"/app/db/document/view/data/tjsuccess.json","dataType":"text"}; //办结地址
var chengbanUrl = {"url":"/app/db/document/view/data/tjsuccess.json","dataType":"text"}; //承办地址
var uploadFileUrl = "/app/db/documentinfo/uploadFile";//文件上传

var fileId=getUrlParam("fileId")||""; //主文件id
var fileFrom=getUrlParam("fileFrom")||""; //文件来源

var tabn = 0;
var pageModule = function(){
	//文件menu
	var takeMenufn = function(id){
		$ajax({
			url:menuUrl,
			data:{fileId:fileId},
			success:function(data){
				var canRecover="";//判断是否有恢复按钮：1为有恢复权限
				var canZb="";//判断是否有转版按钮：1为有转版权限
				var showStreamDownload = "";//判断是否有流式文件；1代表有流式文件，显示下载流式按钮；2代表没有流式文件，不显示下载按钮；
				var fileType="";
				var fileUrl="";
				var fileTitle="";
				var html1 = "";
				if(data &&　data.menuAr.length>0){
					$.each(data.menuAr,function(i,o){
						var id = o.id;
						var name = o.name;
						var typeKey = o.typeKey;
						var suffix = o.suffix;
						if(i==0){
							canRecover = o.canRecover;
							canZb = o.canZb;
							showStreamDownload = o.showStreamDownload;//判断是否有流式文件；1代表有流式文件，显示下载流式按钮；2代表没有流式文件，不显示下载按钮；
							fileType=o.type;
							fileUrl=o.url;
							//alert(fileUrl+"==="+fileType);
							if(fileType == '1'){
								$("#lsTip").show();
							}else{
								$("#lsTip").hide();
								if(fileUrl != null && fileUrl != ''){
									if($("#suwell").is(":hidden")){
										$("#suwell").show();
									};
									//openOFDFile(fileUrl, "suwell",$("#suwell").width(),$("#suwell").height(), "showTablet");
								}
							}
						}
						if(typeKey=="cpj"){
							fileTitle="主文件";
						};
						if(typeKey=="fj"){
							fileTitle="附件";
						};
						if(typeKey=="bwly"){
							fileTitle="办文来源";
							$("#downStream").hide();
						}else{
							$("#downStream").show();
						};
						
						html1 = '	<li id="menu_'+id+'" data_id="'+id+'" class="'+(i==0?"active":"")+ '"  data_type="'+typeKey+'" file_type="'+fileType+'" >'+
								'		<a  href="#tab'+i+'"  data-toggle="tab" title="'+fileTitle+':'+name+'">'+fileTitle+':'+name+'</a>'+
								'	</li>';
						$("#takeMenu").append(html1);
						
						if(id!=null&&typeof(id)!="undefined"&&id!=""){
							$("#takeMenu li").removeClass("active");
							$("#menu_"+id).addClass("active");
						};  
					});
				}
				tabn = 1;
				Metronic.refreshtabs();
				//页签点击
				$("#takeMenu li").click(function(){
					var clickfileId = $(this).attr("data_id");
					var clickfileType = $(this).attr("filetype");
					getFile(clickfileId,clickfileType);
				}); 
			}
		});	
	}
	
	var getFile = function(clickfileId,clickfileType){
		$ajax({
			url:getDataUrl,
			data:{fileId:clickfileId,fileType:clickfileType},
			success:function(data){
				fileUrl = data.url;
				fType2 = data.type;
				var canRecover=data.canRecover;//判断是否有恢复按钮：1为有恢复权限
				var canZb=data.canZb;//判断是否有转版按钮：1为有转版权限
				var showStreamDownload = data.showStreamDownload;//判断是否有流式文件；1代表有流式文件，显示下载流式按钮；2代表没有流式文件，不显示下载按钮；
				
				if(fType2 == '1'){
					$("#lsTip").show();
				}else{
					$("#lsTip").hide();
					if(fileUrl != null && fileUrl != ''){
						//版式文件下当文件类型为办文来源时不显示笔等按钮
						if($("#suwell").is(":hidden")){
							$("#suwell").show();
						};
						$("#cssOffice").hide();
						openOFDFile(fileUrl, "suwell",$("#suwell").width(),$("#suwell").height(), "showTablet");
					}else{//没有文件仅初始化插件
						suwell.ofdReaderInit("suwell",$("#suwell").width(),$("#suwell").height());
					}
				}
			}
		});	
	}
	
	
	var initdata = function(){
		$ajax({
			url:getDataUrl,
			data:{fileId:fileId},
			success:function(data){
				$(".commonHtml").html("");
				$(".commonHtml").append(
					'<div class="line1"><span class="fileName">'+data.fileName+'</span><font class="miji secretLevelName">'+data.secretLevelName+'</font></div>'+
	            	'<div class="line2 fileNum">'+data.fileNum+'</div>'+
	            	'<div class="line3"><i class="fa fa-info-circle" style="color:#33CC99"></i> <span class="option">'+data.option+'</span></div>'
				)
			}
		});	
	}
	
	//文件列表——附件
	var initFjfn = function(){
		$ajax({
			url:fjDataUrl,
			data:{fileId:fileId},
			success:function(data){
				$("#fjList").html("");
				$.each(data,function(i,item){
					$("#fjList").append('<li id="'+item.fileId+'" data_fileType="'+item.fileType+'" data_type="'+item.type+'"><a>'+item.fileName+'</a></li>');
				});
			}
		});	
	}
	
	//办理反馈记录
	var initblfkList = function(){
		$ajax({
			url:listUrl,
 			data:{fileId:fileId},
			success:function(data){
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
		})
	}
	
	//文件转办——转办记录
	var initzbjlfn = function(){
		$ajax({
			url:zbjlDataUrl,
			data:{fileId:fileId},
			success:function(data){
				$("#zbrecord").html("");
				$.each(data,function(i,item){
					$("#zbrecord").append(
						'<div class="record">'+
			            '	<label class="zbUser">转办人:</label>'+
			            '	<div><span>'+item.zbUser+'</span><span class="zbDate">'+item.zbdate+'</span></div>'+
			            '	<label class="cbdw">承办单位/人:</label>'+
			            '	<div>'+item.unit+'</div>'+
			            '</div>'
		            )
				});
			}
		});	
	}
	
	//文件转办——催办记录
	var initcbfn = function(){
		$ajax({
			url:cbDataUrl,
			data:{fileId:fileId},
			success:function(data){
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
		});	
	}
	
	//文件转办—办结记录
	var initbjfn = function(){
		$ajax({
			url:bjDataUrl,
			data:{fileId:fileId},
			success:function(data){
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
				data:{fileId:fileId,opinionContent:$("#opinionContent").val()},
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
				data:{fileId:fileId},
				type: "GET",
				success:function(data){
					if(data.result == "success"){
						newbootbox.alert("承办...！").done(function(){
							/*成功后的回调*/
						});
					}
				}
			});
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
	 							skip();
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
				var uploadfiles = document.querySelector("#pdf").files;
				var filesName = [];
				$.each(uploadfiles,function(i,item){
					filesName.push(item.name);
				});
				/*var fileNameArry = $(this).val().split("\\");
				var fileName;
				if(fileNameArry.length==1){
					fileName=fileNameArry[0];
				}else{
					fileName=fileNameArry[fileNameArry.length-1];
				}
				$(".fileinput-filename").text(fileName);*/
				$(".fileinput-filename").text(filesName.toString());
				$("#form3").submit();
			});
		})
	}
		
	return{
		//加载页面处理程序
		initControl:function(){
			takeMenufn();
			initdata();
			initFjfn();
			initblfkList();
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
	if(show == 0){
		windowClose();
	}else if(fileFrom == "grdb"){//文件来源于个人待办
		window.location.href="/app/db/document/grdb/html/grdb.html?searchType=grdb";
	}else if(fileFrom=="blfk"){  //文件来源于办理反馈
		window.location="/app/db/document/blfk/html/blfk.html?searchType=blfk";
	}else{ 
		window.location.href="/app/db/document/grdb/html/grdb.html?searchType=grdb";
	}
}