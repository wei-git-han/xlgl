var dicUrl = {"url":rootPath +"/documentdic/getDicByTypet","dataType":"text"}; //返回的下拉框字典值
var fileNameArry = [];
var docTypeName = '';
var pageModule = function(){
	var initother = function(){
		$("#uploadFile").click(function(){
			$("#file").click();
			$("#file").change(function(){
				fileNameArry = Array.from($(this).context.files);//$(this).val().split("\\");
				var fileName = "";
				if(fileNameArry.length==1){
					fileName=fileNameArry[0].name;
				}else if(fileNameArry.length>1){
//					fileName=fileNameArry[fileNameArry.length-1];
					fileNameArry.map(function(item,index){
						fileName = fileName+(item.name+"<br>")
					})
				}
				$(".fileinput-filename").html(fileName);
			})
		})
		$("#docTypeId").change(function(){
			docTypeName = $("#docTypeId option:checked").text();
			$("#docTypeName").val($("#docTypeId option:checked").text());
		})
		$("#shangchuan2").click(function(){
			var val = $("#file").val();
			var array = val.split("\\");
			var filename = "";
			if(array.length==1){
				filename = array[0];
			}else{
				filename = array[array.length-1];
			}
			var filetype = filename.split(".")[filename.split(".").length-1];
//			if(filetype != 'xls' && filetype != 'xlsx'){
//				newbootbox.alertInfo("请上传正确格式的文件！");
//				return;
//			}
			if(!docTypeName){
				newbootbox.alertInfo("请选择类别！");
				return;
			}else if(fileNameArry.length==0){
				newbootbox.alertInfo("请选择文件！");
				return;
			}
			var ajax_option ={
					type: "post",
					url:"/app/db/documentinfo/uploadFiles",//默认是form action
					success:function(data){
						if(data.result == "success"){
							if(data.msg){
								newbootbox.alertInfo(data.msg);
							}else{
								newbootbox.alertInfo('导入成功！');
							}
							newbootbox.newdialogClose("PLfileDr");
							$("#iframe1",window.top.document).attr("src","/app/db/document/djlr/html/djlr.html?fileFrom=djlr");
							window.top.blfkfn();
						}else{
							newbootbox.alertInfo('导入失败！');
						}
				}
			}
			$('#form2').ajaxSubmit(ajax_option);
			
		})
		
		$("#close").click(function(){
			newbootbox.newdialogClose("PLfileDr");
		})
		
	}
	
	//请求各字典数据
	var initdictionary = function(){
		$ajax({
			url:dicUrl,
			data:{dicType:"all"},
			success:function(data){
				if(data.code!=500){
					initselect1("docTypeId",data.document_type);
				}
			}
		});
	}

	return{
		//加载页面处理程序
		initControl:function(){
			initother();
			initdictionary();
		}
	};
	
}();
