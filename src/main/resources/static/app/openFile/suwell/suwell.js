/**
 * shuwen	数科服务以及页签切换公用方法
 * @time 2017-08-29
 */
var ocx = null;
/**
 * 初始化数科插件，打开pdf文档
 * 
 * @param filePath
 *            文件路径
 * @param webPath
 *            域名
 */
function openOFDFile(filePath, areaDivId,width,height, optionType) {
	if (filePath != '' && filePath != null) {
		ocx = suwell.ofdReaderInit(areaDivId, width+"px", height+"px");
		ocx.openFile(filePath, false);
		//隐藏工具栏，导航栏
		ocx.setCompsiteVisible("navigator",false);
		//ocx.setCompsiteVisible('toolbar',false);
		// 设定插件区域自适应宽度
		ocx.performClick("vzmode_fitwidth");
		//缩放倍数
		//ocx.setScale(200);
		//启动签批模式
		//ocx.performClick("t_tablet/signpen_05mm");
		// 隐藏打开本地文件按钮
		ocx.setCompsiteVisible('f_open',false);
		// 隐藏保存按钮
		ocx.setCompsiteVisible('f_save',false);
		// 隐藏打印按钮
		if (optionType == 'hidePrint') {
			ocx.setCompsiteVisible('f_print',false);
		}
		// 隐藏顺时针旋转90度
		ocx.setCompsiteVisible('v_rotateclock',false);
		// 隐藏逆时针旋转90度
		ocx.setCompsiteVisible('v_rotateanti',false);
		//签章栏
		ocx.setCompsiteVisible("toolbar_seal",false);
		//基础工具栏 选择复制工具放开
		//ocx.setCompsiteVisible("toolbar_basetool",false);
		//放大镜工具浪
		ocx.setCompsiteVisible("toolbar_zoom",false);
		//文本工具栏
		ocx.setCompsiteVisible("toolbar_document",false);
		// 隐藏文本注解工具栏
		ocx.setCompsiteVisible("toolbar_annott",false);
		// 
		ocx.setCompsiteVisible("toolbar_edit",false);
		// 隐藏全屏手写签批
		if (optionType != 'showTablet') {
			ocx.setCompsiteVisible("toolbar_tablet",false);
		}
		// 隐藏图形注解工具栏
		ocx.setCompsiteVisible("toolbar_annotp",false);
		//隐藏区域手写签批
		ocx.setCompsiteVisible("t_tabletdlg",false);
		//隐藏区域手写签批
		ocx.setCompsiteVisible("menu",false);
	}
}

/**
 * 克隆已经初始化的数科打开文档区域，使其在页签切换的时候能正常打开，不再重新初始化
 */
function cloneDiv(pluginID, hiddenID) {
	if ($("#" + pluginID).html() != null && $("#" + pluginID).html() != "") {
		var oldOfdDiv = document.getElementById(pluginID);
		var newOfdDiv = document.adoptNode(oldOfdDiv);
		$(newOfdDiv).find("embed").height(1);
		$("#" + hiddenID).append(newOfdDiv);
	}
}

function fromCloneDivOpenFile(pluginID, hiddenID, showAreaId,height){
	if ($("#" + hiddenID).html() != null && $("#" + hiddenID).html() != "") {
		var oldOfdDiv = $("#" + pluginID)[0];
		var newOfdDiv = document.adoptNode(oldOfdDiv);
		$(newOfdDiv).find("embed").height(height);
		$("#" + showAreaId).append(newOfdDiv);
	}
}

function saveOfdFile(){
	var tokenAccess = "";
	var opinionContent = $("#opinionContent").val();
	var oid = $("#id").val();
	//获取token
	$.ajax({
		url:rootPath + "/draft/getAccessToken",
		type: "GET",
		success:function(data){
			tokenAccess = data.token;
			//数科插件保存内容
			var url=location.protocol+"//"+location.host+"/servlet/suwell/save?recordId=" + id + "&access_token=" + tokenAccess;
			var ret = ocx.saveFile(url);
			var fileName = id + ".ofd";
			//更新版式文件ID
			if(ret){
				$ajax({
					url:save,
					data:{id:oid,documentId:documentId,opinionType:'3',opinionContent:encodeURI(opinionContent),fileName:fileName},
					type: "GET",
					success:function(data){
						if(data.result == "success"){
							$ajax({
								url:update,
								data:{id:id,status:'1'},
								type: "GET",
								success:function(data){
									bootbox.dialog({
										message: "保存待交档操作成功！",
								        title: "提示",
							            buttons: {
								            success: {
								                label: "确定",
								                className: "btn-primary",
								                callback: function() {
								                	window.location.href="fhgz.html";
								                }
								            }
							            }
							        });
								}
							});
						}
					}
				});
			}
		}
	});
}