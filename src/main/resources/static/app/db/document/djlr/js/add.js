var loginUser =  {"url":rootPath +"/documentinfo/getLoginUser","dataType":"text"};//获取当前登录人---录入人
var dicUrl = {"url":rootPath +"/documentdic/getDicByTypet","dataType":"text"}; //返回的下拉框字典值
var saveSzpsUrl = {"url":rootPath +"/documentszps/save","dataType":"text"}; //保存首长批示
var getSzpsListUrl = {"url":rootPath +"/documentszps/queryList","dataType":"text"}; //获取首长批示
var updateUrl={"url":rootPath +"/documentinfo/update","dataType":"json"}; //表单数据保存
var uploadFileUrl = "/app/db/documentinfo/uploadFile";//文件上传
var fileDataUrl = {"url":rootPath +"/documentfile/list","dataType":"text"}; //相关文件-附件list
var delFileUrl = {"url":"/app/db/documentfile/delete","dataType":"text"}; /*相关文件--删除附件*/
var getFormatFileUrl = {"url":"/app/db/documentfile/getFile","dataType":"text"}; /*相关文件-点击获取对应文件*/
var getPdfPath = {"url":rootPath +"/fileinfo/getFormaFileUrl","dataType":"text"};
var UserTreeUrl = {"url":"/app/base/user/treeByPost","dataType":"text"}; //登记人树
var deleteSzcqUrl = {"url":"/app/db/documentszps/delete","dataType":"text"};//删除首长批示
var fileFrom=getUrlParam("fileFrom")||""; //文件来源
var scanFilePath = "";//扫描件路径
//带入批示首长信息
var psszName = "";
var pageModule = function(){
	 /*带入录入人*/
	var makeLoginUser = function(){
		$ajax({
			url:loginUser,  
			success:function(data){
				$("#userId").val(data.userId);
				$("#userName").val(data.userName);
			}
		})
	}
	
	var initUserTree = function(){
		$("#userName").createSelecttree({
			url :UserTreeUrl,
			width : '100%',
			success : function(data, treeobj) {},
			selectnode : function(e, data) {
				$("#userName").val(data.node.text);
				$("#userId").val(data.node.id);
			}
		});
	}
	
	//请求各字典数据
	var initdictionary = function(){
		$ajax({
			url:dicUrl,
			data:{dicType:"all"},
			success:function(data){
				if(data.code!=500){//&&data.security_classification!="" && data.security_classification!=null && typeof(data.security_classification)!=undefined){
					initselect("docTypeId",data.document_type);
					initselect("securityId",data.security_classification);
					initselect("urgencyId",data.urgency_degree);
				}
			}
		});
	}
	
	//获取抄清list
	var initCqfn = function(){
		$ajax({
			url:getSzpsListUrl,
			data:{infoId:$("#id").val()},
			success:function(data){
				$("#showcq").html("");
				$("#cqcontent").val("");
				$("#editcqId").val("");
				$.each(data,function(i,item){
					$("#showcq").append(
						'<div class="cqline">'+
						'	<div dataId="'+item.id+'" dataName="'+item.leaderComment+'" dataUser="'+item.userName+'" dataDate="'+item.createdTime+'"><span>'+item.userName+'</span><span class="cqrq">'+item.createdTime+'</span><span class="pull-right"><a style="margin-right:10px" class="editcq">编辑</a><a class="delcq">删除</a></span></div>'+
						'	<div>'+item.leaderComment+'</div>'+
						'</div>'
					);
				});
				
				$(".editcq").click(function(){//编辑抄清
					$("#cqcontent").val($(this).parent().parent().attr("dataName"));
					$("#editcqId").val($(this).parent().parent().attr("dataId"));
					
					psszName = $(this).parent().parent().attr("dataUser");
					$("#cqDate").val($(this).parent().parent().attr("dataDate"));
				});
				
				$(".delcq").click(function(){
					$ajax({
						url:deleteSzcqUrl,//删除抄清
						data:{id:$(this).parent().parent().attr("dataId")},
						success:function(data){
							if(data.result == "success"){
								newbootbox.alert("删除成功！").done(function(){
									initCqfn();
								});
							}else{
								newbootbox.alert(data.result+"！");
							}
						}
			    	});
				});
			}
		});
	}
	
	//相关文件
	var initfilefn = function(){
		$ajax({
			url:fileDataUrl,
			data:{infoId:$("#id").val()},
			success:function(data){
				$("#file_all").html("");
				if(data&&data.length>0){
					$.each(data,function(i,item){
						$("#file_all").append(
							'<li><input type="checkbox" name="fjcheckbox" data="'+item.id+'" /> <a data="'+item.id+'">'+item.fileName+'</a></li>'
			            )
					});
				}else{
					//psLoad('','');
					$("#embedwrap").hide();
				}
				$("#file_all>li>a").click(function(){
					$("#embedwrap").show();
					var scanId = $(this).attr("data");
					$ajax({
						url:getFormatFileUrl,
						data:{id:scanId},
						success:function(data){
							psLoad(data.formatId,data.downFormatIdUrl);
						}
			    	});
				})
			}
		});	
	}

	var initother = function(){
		//文件类别change事件
		$("#docTypeId").change(function(){
			if($(this).val() == "1" || $(this).val() == "2" || $(this).val() == "4"){
				$("#jobContent").attr("disabled",true);
				$("#banjianNumber").removeAttr("disabled");
				$("#chaoqing").show();
			}else{
				$("#chaoqing").hide();
				$("#jobContent").removeAttr("disabled");
				$("#banjianNumber").attr("disabled",true);
			}
		});
		
		//扫描设置
		$("#scanSet").click(function(){
			$(".smczcont").toggle();
		});
		
		$(".date-picker").datepicker({
		    language:"zh-CN",
		    rtl: Metronic.isRTL(),
		    orientation: "right",
		    autoclose: true
		});
		
		$(".form_datetime").datetimepicker({
		    language:"zh-CN",
		    autoclose: true,
		    isRTL: Metronic.isRTL(),
		    format: "yyyy-mm-dd   hh:ii",
		    pickerPosition: (Metronic.isRTL() ? "bottom-right" : "bottom-left")
		});
		

		var newdate = (new Date()).format("yyyy-MM-dd");
		$("#applyTime").val(newdate);
		
		$("#commentForm").validate({
			ignore:'',
		    submitHandler: function() {
		    	$("#docTypeName").val($("#docTypeId option:checked").text());
		    	$("#securityClassification").val($("#securityId option:checked").text());
		    	$("#urgencyDegree").val($("#urgencyId option:checked").text());
			    var elementarry = ["docTypeId","docTypeName","docTitle","securityId","securityClassification",
			    	"urgencyId","urgencyDegree","docCode","banjianNumber","userId","userName","applyTime","printDate","jobContent","remark"];
				var paramdata = getformdata(elementarry);
				paramdata.id = $("#id").val();
				//newbootbox.alert('正在保存，请稍候...',false);
				$.ajax({
					url:updateUrl.url,
					data:paramdata,
					type:"post",
					success:function(data){
						$("#id").val(data.id);
						window.top.$(".newclose").click();
						if(addFlag){
							window.location.href="/app/db/document/djlr/html/add.html";
						}else if(returnSave){
							window.location.href = "/app/db/document/djlr/html/djlr.html?fileFrom=djlr";
						}else{
							setTimeout(function(){
								newbootbox.alert("保存成功！").done(function(){
								});
							},200);
						}
					}
				})
		    },
		    errorPlacement: function(error, element) {
	    	 	if($(element).parent().hasClass("selecttree")){
	    	 		error.appendTo(element.parent().parent().parent()); 
	    	 	}else{
	    	 		error.appendTo(element.parent());  
	    	 	}
		     }
		});
		//保存
		$("#save").click(function(){
			$("#commentForm").submit();
		})
		//保存并新增
		var addFlag =false;//此变量用来标识是不是保存并新增的操作，在submit中区分保存保存回调成功的跳转
		$("#saveAndAdd").click(function(){
			addFlag=true;
			$("#commentForm").submit();
		})
		//取消并退出
		var returnSave =false;//此变量用来标识是不是取消并退出按钮中保存的操作，在submit中区分保存回调成功的跳转
		$("#return").click(function(){
			newbootbox.confirm100({
			    title: "提示",
			    message: "是否保存当前更改？不保存将丢失编辑数据",
			    callback1:function(){
			    	returnSave=true;
			    	$("#commentForm").submit();
			    },
			    callback2:function(){
			    	window.location.href = "/app/db/document/djlr/html/djlr.html?fileFrom=djlr";
			    }
			});
		})
		//返回按钮
		$("#goback").click(function(){
				//$("#commentForm").submit();
			newbootbox.confirm100({
			    title: "提示",
			    message: "是否保存当前更改？不保存将丢失编辑数据",
			    callback1:function(){
			    	returnSave=true;
			    	$("#commentForm").submit();
			    },
			    callback2:function(){
			    	window.location.href = "/app/db/document/djlr/html/djlr.html?fileFrom=djlr";
			    }
			});
		});
		
		
		//扫描续传功能
		$("#scanKeepTransfer").click(function() {   	
	    	$.ajax({
	    		type: "post",
				url:"/app/dzbms/fileinfo/checkScanpdf",//默认是form action
				success:function(data){
					if(data.result != "success"){
						newbootbox.alert(data.result);
					}
				}
	    	});
	    });
		
		
		//选择首长
		$("#choosesz").click(function(){
			newbootbox.newdialog({
				id:"chooseszDialog",
				width:800,
				height:600,
				header:true,
				title:"选择首长",
				classed:"cjDialog",
				url:"/app/db/document/djlr/html/chooseszDialog.html",
			})
		});
		
		//增加批示
		$("#addcq").click(function(){
			if($("#id").val() == "" || $("#id").val() == null || typeof($("#id").val()) == undefined){
				newbootbox.alertInfo("请先保存要素信息再增加批示！"); 
				return  false;
			} 
			var leaderComment=$("#cqcontent").val();
			var createdTime=$("#cqDate").val();
			if($.trim(leaderComment) == "" || $.trim(leaderComment) == null){
				newbootbox.alert('请输入抄清内容！');
				return;
			}
			$ajax({
				url:saveSzpsUrl,
				data:{infoId:$("#id").val(),userName:psszName,leaderComment:leaderComment,createdTime:createdTime,id:$("#editcqId").val()},
				success:function(data){
					if(data.result == "success"){
						newbootbox.alert("保存成功！").done(function(){
							initCqfn();
						});
					}
				}
			});
			//清空之前选中和复制的参数
			$("#cqDate").val("");
			$("#cqcontent").val("");
			psszName="";
		});
		
		//转办
		$("#zhuanban").click(function(){
			if($("#id").val() == "" || $("#id").val() == null || typeof($("#id").val()) == undefined){
				newbootbox.alertInfo("请先保存要素信息再开始转办！"); 
				return  false;
			} 
			var fileId = $("#id").val();
			newbootbox.newdialog({
				id:"zhuanbanDialog",
				width:800,
				height:600,
				header:true,
				title:"转办",
				classed:"cjDialog",
				url:"/app/db/document/blfk/html/zhuanbanDialog.html?fileIds="+fileId
			})
		});
		
		
		//删除附件
		$("#delfj").click(function(){
			if($("#file_all").find("input[name=fjcheckbox]:checked").length>0){
				var checkId = [];
				$("#file_all").find("input[name=fjcheckbox]").each(function(){
					if($(this).is(":checked")){
						checkId.push($(this).attr("data"));
					}
				})
				$ajax({
					url:delFileUrl,
					data:{ids:checkId.toString()},
					success:function(data){
						if(data.result == "success" && data.url != ""){
							newbootbox.alert("删除成功！").done(function(){
								initfilefn();
							}); 
						}
					}
				})
			}else{
				newbootbox.alert("请选中要删除的附件！"); 
			}
		});
	}
	
	var initPdf = function(){
		$("#uploadPdf").click(function(){
			$("#FireFoxOFDDIV").hide();
		})
		
		$("#showupload").on("hidden.bs.modal",function(e){
			$("#FireFoxOFDDIV").show();
		});

		$(".close.fileinput-exists").live("click",function(){
			$(this).parent().parent().parent().remove();
		})

		$("#addfile2").click(function(){
			$(this).parent().parent().before(
                '<div class="form-group has-success new_success">'+
                '    <div class="col-xs-12">'+
                '        <div class="fileinput fileinput-new" data-provides="fileinput">'+
                '            <span class="btn default btn-file" style="padding-left:50px;padding-right:50px;">'+
                '            <span class="fileinput-new">'+
                '            上传 </span>'+
                '            <span class="fileinput-exists">'+
                '            修改 </span>'+
                '            <input type="file" name="...">'+
                '            </span>'+
                '            <span class="fileinput-filename" style="padding-left:20px;">'+
                '            </span>'+
                '            &nbsp; <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput">'+
                '            </a>'+
                '        </div>'+
                '    </div>'+
                '</div>'
			)
		})
		
		$("#form3").validate({
		    submitHandler: function() {
		    	$("#dialogzz").show();
		    	$("#dialogzz").css("display","table");
				var ajax_option ={
					type: "post",
					url:uploadFileUrl,//默认是form action
					success:function(data){
						$("#dialogzz").hide();
						if(data.result == "success"){
							newbootbox.alert('上传成功！').done(function(){
				        		$(".fileinput-filename").text("");
				    			$("#pdf").val("");
				    			$("#scanId").val(data.smjId);
				    			$("#embedwrap").show();
				    			psLoad('', data.smjFilePath);
				    			initfilefn();
		    				});
						}else{
							newbootbox.alert("上传失败！"); 
						}
					}
				}
				$('#form3').ajaxSubmit(ajax_option);
		   }
		});
		
		$("#addFj").click(function(){
			if($("#id").val() == "" || $("#id").val() == null || typeof($("#id").val()) == undefined){
				newbootbox.alertInfo("请先保存要素信息再开始扫描！"); 
				return  false;
			} 
			$("#pdf").unbind("click");
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
				var id=$("#id").val();
				$("#idpdf").val(id);
				$("#form3").submit();
			});
		})

		
		//扫描件表单提交
		$("#smjForm").validate({
			submitHandler : function() {
				$("#infoId").val($("#id").val());
				var ajax_option = {
					type: "post",
					url : "/app/db/documentinfo/saveSmjPsFile",
					success : function(data) {
						if (data.result == "success") {
							newbootbox.alert("保存成功！").done(function(){
								$("#embedwrap").show();
								psLoad(data.scanId, data.scanFilePath);
							});
						} 
					}
				}
				$('#smjForm').ajaxSubmit(ajax_option);
			}
		});
	}
	
	return{
		//加载页面处理程序
		initControl:function(){
			initdictionary();
			initfilefn();
			initCqfn();
			initUserTree();
			makeLoginUser();
			initother();
			initPdf();
		},
		getUserData:function(message1){
			psszName=message1;
		}
	}
	
}();

var psLoad = function(psFileId, psPath){
	var embedWidth = "100%";
	var embedHeight = "100%";
	var id=$("#scanId").val();
	if(psFileId != null && psFileId != ""){
		$("#scanId").val(psFileId);
	}
	if(psPath != null && psPath != ""){
		scanFilePath = psPath;
		openOFDFile(scanFilePath, "FireFoxOFDDIV",embedWidth,embedHeight);
	}else{
		//初始化版式文件
		$ajax({
			type:"post",
			async:false,
			url:getPdfPath,//文件请求地址
			data:{id:id},
			success:function(data){
				if(data.result == "success" && data.url != ""){
					scanFilePath = data.url;
				}
			}
		})
		// 判断隐藏域中是否有值，如果有则从隐藏域取，或者初始化打开
		if ($("#cloneDiv").html() != null && $("#cloneDiv").html() != "") {
			fromCloneDivOpenFile('FireFoxOFDDIV', 'cloneDiv', 'showPsAreaDiv',embedHeight);
		} else {
			if(scanFilePath != null && scanFilePath != ""){
				openOFDFile(scanFilePath, "FireFoxOFDDIV",embedWidth,embedHeight);
			}
		}
	}
}


