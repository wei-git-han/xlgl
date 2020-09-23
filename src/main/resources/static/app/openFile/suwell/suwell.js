var ocx = null
var sealcountinofdfile = 0
function initOFDReader(areaDivId, width, height, optionType) {
	ocx = suwell.ofdReaderInit(areaDivId, width, height);
	// 设置单文件模式
	ocx.setSingleMode(true)
	ocx.registListener('f_open', 'openperform', false)
	ocx.registListener('f_open', 'openafterform', true)
	//			ocx.performClick("vzmode_fitwidth");
	// 启动签批模式
	// ocx.performClick("t_tablet/signpen_05mm");
	// 注册保存事件的监听
	ocx.registListener('f_saveurl', 'openperform', false)
	ocx.registListener('f_saveurl', 'saveaftertodo', true)
	// 隐藏打印按钮
	if (optionType === 'hidePrint') {
		ocx.setCompsiteVisible('f_print', false)
	}
	// 隐藏全屏手写签批
	if (optionType !== 'showTablet') {
		ocx.setCompsiteVisible('toolbar_tablet', false)
	}
	return ocx;
}

function closeFile() {
	ocx.closeFile();
}

function openOFDFile(filePath, areaDivId,width,height, optionType) {
	/*if(!ocx){
		initOFDReader(areaDivId,width,height, optionType)
		// ocx.setConfigInfo("display.zoom","100");
	}*/
	initOFDReader(areaDivId,width,height, optionType)

	var interval=setInterval(function () {
		var version=ocx.version();
		if(version){
			window.clearInterval(interval)
			if (filePath) {
				if (ocx) {
					// ocx.setConfigInfo("display.zoom","100");
					ocx.openFile(filePath, false);
					// 隐藏导航栏
					ocx.setCompsiteVisible('navigator',false);
					// 隐藏区域手型工具（阅读模式）
					ocx.setCompsiteVisible('t_handtool', false);
					// 隐藏区域手写签批
					ocx.setCompsiteVisible('t_tablet', false)
					// 隐藏区域手写签批
					ocx.setCompsiteVisible('t_tabletdlg', false)
					// 隐藏图形注解工具栏
					ocx.setCompsiteVisible('toolbar_annotp', false)
					// 文本注解工具栏
					ocx.setCompsiteVisible('toolbar_edit', false)
					// 文本工具栏
					ocx.setCompsiteVisible('toolbar_document', false)
					// 放大镜工具浪
					ocx.setCompsiteVisible('toolbar_zoom', false)
					// 隐藏顺时针旋转90度
					ocx.setCompsiteVisible('v_rotateclock', true)
					// 隐藏逆时针旋转90度
					ocx.setCompsiteVisible('v_rotateanti', true)
					//隐藏工具栏
					//     // ocx.setCompsiteVisible('toolbar',false);
					// 设定插件区域自适应宽度
					//     // 签章栏
					//     //ocx.setCompsiteVisible("toolbar_seal",false);
					// 基础工具栏 选择复制工具放开
					// ocx.setCompsiteVisible("toolbar_basetool",false);
					// 缩放倍数
					ocx.setScale(100);
					// 隐藏打开本地文件按钮
					ocx.setCompsiteVisible('f_open',false);
					// 隐藏保存按钮
					ocx.setCompsiteVisible('f_save',false);
				}
			}/*else{
				ocx.closeFile();// 打开之前首先关闭老的文件
			}*/
		}
	},1)
	return ocx;
}

var saveafter = null
// 版式文件的新保存方法，有提示动画的
function savetoremote(url, fn) {
	if (fn) { saveafter = fn }
	ocx.saveFile(url)
}

function incrementalseal() {
	var incrementalsealcount
	if (ocx != null) {
		var SignaturesCount = ocx.getSignaturesCount()
		if (SignaturesCount == null || typeof(SignaturesCount) === 'undefined') {
			SignaturesCount = 0
		}
		incrementalsealcount = SignaturesCount - sealcountinofdfile
	}
	return incrementalsealcount
}

function openafterform() {
	if (ocx != null) {
		sealcountinofdfile = ocx.getSignaturesCount()
	}
}

function saveaftertodo() {
	if (ocx != null) {
		sealcountinofdfile = ocx.getSignaturesCount()
	}
	if (saveafter != null) {
		saveafter()
		saveafter = null
	}
}
function exportPdf() {
	ocx.performClick('f_export');
}