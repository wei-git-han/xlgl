(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-67be8bfe"],{"20bc":function(t,e,i){"use strict";var a=i("26df"),o=i.n(a);o.a},"26df":function(t,e,i){},e64d:function(t,e,i){"use strict";i.d(e,"a",function(){return o}),i.d(e,"i",function(){return l}),i.d(e,"h",function(){return s}),i.d(e,"c",function(){return n}),i.d(e,"f",function(){return p}),i.d(e,"b",function(){return c}),i.d(e,"d",function(){return r}),i.d(e,"e",function(){return u}),i.d(e,"g",function(){return d}),i.d(e,"j",function(){return f}),i.d(e,"k",function(){return m}),i.d(e,"l",function(){return h});var a=i("b775");function o(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/save",method:"post",data:t})}function l(){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/subject",method:"get"})}function s(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/list",method:"get",params:t})}function n(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/update",method:"post",data:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/delete",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/delete",method:"post",data:t})}function r(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/info",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglexamfile/list",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/getSubjectState",method:"post",data:t})}function f(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/getUpLoad",method:"post",data:t})}function m(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/saveTopic",method:"post",data:t})}function h(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/updateTopic",method:"post",data:t})}},f31f:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container",staticStyle:{"background-color":"#ffffff",margin:"0 10px",padding:"10px"}},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticStyle:{height:"calc(100vh - 40px)",overflow:"hidden","padding-bottom":"60px"},attrs:{xl:6,md:6}},[i("el-button",{staticClass:"btnPosition",attrs:{type:"primary"},on:{click:t.addTest}},[t._v("创建题库类型")]),t._v(" "),i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-tree",{ref:"tree",attrs:{data:t.treeData,props:t.defaultProps,"default-expand-all":"","node-key":"id"},on:{"node-click":t.handleNodeClick},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.node,o=e.data;return i("span",{staticClass:"custom-tree-node",on:{mouseenter:function(e){return t.mouseenter(o)},mouseleave:function(e){return t.mouseleave(o)}}},[i("span",{attrs:{title:a.label}},[t._v(t._s(t._f("labelFilter")(a.label)))]),t._v(" "),a.isLeaf?i("span",[a.parent.parent?i("el-button",{directives:[{name:"show",rawName:"v-show",value:o.show,expression:"data.show"}],attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(e){return e.stopPropagation(),t.remove(a,o)}}}):t._e()],1):t._e(),t._v(" "),(a.isLeaf||a.parent.parent)&&a.parent.parent?t._e():i("span",[i("el-button",{directives:[{name:"show",rawName:"v-show",value:o.show,expression:"data.show"}],attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){return e.stopPropagation(),t.add(a,o)}}}),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:o.show,expression:"data.show"}],attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(e){return e.stopPropagation(),t.removeSubject(a,o)}}})],1)])}}])})],1)],1),t._v(" "),i("el-col",{attrs:{xl:18,md:18}},[i("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.listQuery,size:"medium"}},[i("el-col",{staticStyle:{"text-align":"right"},attrs:{xl:19,md:18}},[i("el-form-item",[i("el-input",{staticClass:"inputSize",attrs:{placeholder:"请输入查询内容"},model:{value:t.listQuery.topicColumn,callback:function(e){t.$set(t.listQuery,"topicColumn",e)},expression:"listQuery.topicColumn"}})],1),t._v(" "),i("el-form-item",[i("el-button",{staticStyle:{width:"80px"},attrs:{type:"primary",icon:"el-icon-search",size:"small"},on:{click:t.onSubmit}},[t._v("搜索")])],1)],1),t._v(" "),i("el-col",{attrs:{xl:5,md:6}},[i("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",icon:"el-icon-plus",size:"small",disabled:t.isEmpty},on:{click:t.openFileDialog}},[t._v("题目导入")]),t._v(" "),i("el-button",{staticStyle:{float:"right","margin-right":"20px"},attrs:{type:"primary",disabled:t.isEmpty,size:"small"},on:{click:t.openPictureDialog}},[t._v("新增题目")])],1),t._v(" "),i("el-col",{attrs:{xl:22,md:22}},[i("el-input",{staticClass:"textareaSty",attrs:{type:"textarea"},model:{value:t.remark,callback:function(e){t.remark=e},expression:"remark"}})],1),t._v(" "),i("el-col",{attrs:{xl:2,md:2}},[i("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.saveTestDiscribute}},[t._v("保存")])],1)],1),t._v(" "),i("div",{staticStyle:{height:"calc(100vh - 250px)",overflow:"hidden",position:"relative",width:"100%",top:"10px",background:"#ffffff",padding:"10px"}},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{"default-expand-all":!0,data:t.list,border:"",fit:!0,stripe:!0,"highlight-current-row":""}},[i("el-table-column",{attrs:{type:"expand"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-row",{attrs:{title:e.row.topicOption}},t._l(e.row.optionArr,function(a,o){return i("span",{key:o,staticClass:"spanSty"},[t._v(t._s(a)),e.row.map[a.split(":")[0]]?i("i",{staticClass:"el-icon-picture",staticStyle:{"font-size":"18px",color:"#007aff",margin:"0 2px"}}):t._e()])}),0)]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"题目","min-width":"300",align:"left"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("div",{attrs:{title:e.row.topicColumn}},[e.row.pictureColumn?i("i",{staticClass:"el-icon-picture",staticStyle:{"font-size":"18px",color:"#007aff",margin:"0 2px"}}):t._e(),t._v(t._s(e.row.topicColumn))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"答案",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.topicResult))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.handleModifyStatus(a,"edit")}}},[t._v("编辑")]),t._v(" "),i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleModifyStatus(a,"delete")}}},[t._v("删除")])]}}])})],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getTestList}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:t.textMap[t.dialogStatus],visible:t.dialogVisible,width:"30%","before-close":t.handleClose},on:{"update:visible":function(e){t.dialogVisible=e}}},["create"===t.dialogStatus||"create1"===t.dialogStatus?i("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,rules:t.rules,model:t.temp,size:"medium"}},[i("el-form-item",{attrs:{label:"创建科目：",prop:"subjectName"}},["create"===t.dialogStatus?i("el-input",{staticStyle:{width:"340px"},attrs:{placeholder:"请输入科目名称",maxlength:"50"},model:{value:t.temp.subjectName,callback:function(e){t.$set(t.temp,"subjectName",e)},expression:"temp.subjectName"}}):"create1"===t.dialogStatus?i("el-input",{staticStyle:{width:"340px"},attrs:{placeholder:"请输入科目名称",readonly:"",maxlength:"50"},model:{value:t.temp.subjectName,callback:function(e){t.$set(t.temp,"subjectName",e)},expression:"temp.subjectName"}}):t._e()],1),t._v(" "),i("el-form-item",{attrs:{label:"科目题型：",prop:"subjectType"}},[i("el-select",{staticClass:"filter-item",staticStyle:{width:"340px"},attrs:{filterable:"",placeholder:"请选择科目题型"},model:{value:t.temp.subjectType,callback:function(e){t.$set(t.temp,"subjectType",e)},expression:"temp.subjectType"}},t._l(t.typeList,function(t){return i("el-option",{key:t.value,attrs:{label:t.name,value:t.value}})}),1)],1)],1):t._e(),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveDialog}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.handleClose}},[t._v("取 消")])],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"题目导入",visible:t.importFileDialog,width:"40%",accept:".xls,.xlsx","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.importFileDialog=e}}},[i("div",{directives:[{name:"show",rawName:"v-show",value:t.uploadPermission,expression:"uploadPermission"}],staticClass:"downDiv"},[i("h3",[t._v("上传模板")]),t._v(" "),i("div",{staticStyle:{"text-align":"center"}},[i("el-radio-group",{model:{value:t.radiofileType,callback:function(e){t.radiofileType=e},expression:"radiofileType"}},t._l(t.typeList,function(e){return i("el-radio",{key:e.value,attrs:{label:e.value}},[t._v(t._s(e.name))])}),1)],1)]),t._v(" "),t.moBanList.length>0?i("div",{staticClass:"downDiv"},[i("h3",[t._v("下载模板")]),t._v(" "),i("div",{staticStyle:{"text-align":"center"}},t._l(t.moBanList,function(e){return i("el-row",{key:e.fileId,staticStyle:{height:"30px","line-height":"30px"},attrs:{gutter:20}},[i("el-col",{attrs:{span:6}},[i("span",[t._v(t._s(t._f("fileType")(e.fileType))+"：")])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"left"},attrs:{span:18}},[i("a",{staticStyle:{"text-decoration":"underline",color:"#3377FF"},attrs:{href:"#"},on:{click:function(i){return t.downMOBan(e.fileId)}}},[t._v(t._s(e.fileName))])])],1)}),1)]):t._e(),t._v(" "),i("div",{staticClass:"centerPosition"},[i("div",{staticClass:"downDiv"},[i("h3",{staticStyle:{"text-align":"left"}},[t._v("上传附件")])]),t._v(" "),t.radiofileType?i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"auto-upload":!1,"with-credentials":!0,action:t.saveFileModel,data:t.fileMobanData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])]):i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)]),t._v(" "),i("el-dialog",{attrs:{title:t.textMap1[t.pictureDialogFlag],visible:t.pictureDialogVisible,width:"50%","before-close":t.handleClose1,"close-on-press-escape":!1,"close-on-click-modal":!1},on:{"update:visible":function(e){t.pictureDialogVisible=e}}},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"500px"}},[i("el-form",{staticClass:"demo-form-inline questionForm pictureForm",attrs:{"label-position":"right",rules:t.rules,"label-width":"120px",model:t.pictureInfo,size:"medium"}},[i("el-form-item",{attrs:{label:"题目：",prop:"topicColumn"}},[i("el-input",{attrs:{type:"textarea",placeholder:"请输入试题题目",maxlength:"500"},model:{value:t.pictureInfo.topicColumn,callback:function(e){t.$set(t.pictureInfo,"topicColumn",e)},expression:"pictureInfo.topicColumn"}}),t._v(" "),i("el-upload",{staticClass:"upload-demo default-upload-list picture1",attrs:{drag:"",action:t.pictureUpload,"list-type":"picture-card",multiple:"","on-success":t.addTopicColumnfn,"on-remove":t.removeTopicColumnfn,"file-list":t.fileListAll,accept:".jpg,.jpeg,.png",limit:4}},[i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),"1"===t.listQuery.topicType||"2"===t.listQuery.topicType?i("el-form-item",{attrs:{label:"选项A："}},[i("el-input",{attrs:{placeholder:"请输入试题选项"},model:{value:t.pictureInfo.topicOptionA,callback:function(e){t.$set(t.pictureInfo,"topicOptionA",e)},expression:"pictureInfo.topicOptionA"}}),t._v(" "),i("el-upload",{staticClass:"upload-demo default-upload-list picture1",attrs:{drag:"","list-type":"picture-card",action:t.pictureUpload,"on-success":t.addTopicAOptionfn,"on-remove":t.removeTopicOptionfn,"file-list":t.fileListA,accept:".jpg,.jpeg,.png",limit:1}},[i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1):t._e(),t._v(" "),"1"===t.listQuery.topicType||"2"===t.listQuery.topicType?i("el-form-item",{attrs:{label:"选项B："}},[i("el-input",{attrs:{placeholder:"请输入试题选项"},model:{value:t.pictureInfo.topicOptionB,callback:function(e){t.$set(t.pictureInfo,"topicOptionB",e)},expression:"pictureInfo.topicOptionB"}}),t._v(" "),i("el-upload",{staticClass:"upload-demo default-upload-list picture1",attrs:{drag:"","list-type":"picture-card",action:t.pictureUpload,"on-success":t.addTopicBOptionfn,"on-remove":t.removeTopicOptionfn,"file-list":t.fileListB,accept:".jpg,.jpeg,.png",limit:1}},[i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1):t._e(),t._v(" "),"1"===t.listQuery.topicType||"2"===t.listQuery.topicType?i("el-form-item",{attrs:{label:"选项C："}},[i("el-input",{attrs:{placeholder:"请输入试题选项"},model:{value:t.pictureInfo.topicOptionC,callback:function(e){t.$set(t.pictureInfo,"topicOptionC",e)},expression:"pictureInfo.topicOptionC"}}),t._v(" "),i("el-upload",{staticClass:"upload-demo default-upload-list picture1",attrs:{drag:"","list-type":"picture-card",action:t.pictureUpload,"on-success":t.addTopicCOptionfn,"on-remove":t.removeTopicOptionfn,"file-list":t.fileListC,accept:".jpg,.jpeg,.png",limit:1}},[i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1):t._e(),t._v(" "),"1"===t.listQuery.topicType||"2"===t.listQuery.topicType?i("el-form-item",{attrs:{label:"选项D："}},[i("el-input",{attrs:{placeholder:"请输入试题选项"},model:{value:t.pictureInfo.topicOptionD,callback:function(e){t.$set(t.pictureInfo,"topicOptionD",e)},expression:"pictureInfo.topicOptionD"}}),t._v(" "),i("el-upload",{staticClass:"upload-demo default-upload-list picture1",attrs:{drag:"","list-type":"picture-card",action:t.pictureUpload,"on-success":t.addTopicDOptionfn,"on-remove":t.removeTopicOptionfn,"file-list":t.fileListD,accept:".jpg,.jpeg,.png",limit:1}},[i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1):t._e(),t._v(" "),i("el-form-item",{attrs:{label:"答案：",prop:"topicResult"}},[i("el-input",{attrs:{placeholder:"请输入正确答案",maxlength:"1"===t.listQuery.topicType?1:50},model:{value:t.pictureInfo.topicResult,callback:function(e){t.$set(t.pictureInfo,"topicResult",e)},expression:"pictureInfo.topicResult"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.savePicuteDialog(t.pictureDialogFlag)}}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:t.handleClose1}},[t._v("取 消")])],1)],1)],1)},o=[],l=(i("28a5"),i("ac6a"),i("e64d")),s=i("333d"),n={name:"ComplexTable",components:{Pagination:s["a"]},filters:{fileType:function(t){var e="";switch(t){case"1":e="单选题模板";break;case"2":e="多选题模板";break;case"3":e="判断题模板";break;case"4":e="填空题模板";break}return e},labelFilter:function(t){return t.length<10?t:t.substring(0,10)+"..."}},data:function(){return{treeData:[],defaultProps:{children:"children",label:"label"},tableKey:0,list:null,total:0,listLoading:!1,listQuery:{topicType:"",subjectId:"",topicColumn:"",page:1,limit:20},fileListC:[],fileListD:[],fileListB:[],fileListA:[],fileListAll:[],typeList:[{name:"单选",value:"1"},{name:"多选",value:"2"},{name:"判断",value:"3"},{name:"填空",value:"4"}],temp:{subjectName:"",subjectType:"",subjectTypes:""},updateTemp:{topicColumn:"",topicOption:"",topicResult:""},dialogVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增题库类型",create1:"新增题库类型"},rules:{subjectName:[{required:!0,message:"请输入科目名称",trigger:"blur"}],subjectType:[{required:!0,message:"请选择科目题型",trigger:"change"}],topicColumn:[{required:!0,message:"请输入试题题目",trigger:"blur"}],topicOption:[{required:!0,message:"请输入试题选项",trigger:"blur"}],topicResult:[{required:!0,message:"请输入正确答案",trigger:"blur"}]},radiofileType:"",remark:"",importFileDialog:!1,moBanList:[],fileData:{access_token:this.$store.state.user.token,subjectId:""},fileMobanData:{fileType:""},fileUploadUrl:"/app/xlgl/xlglexamtopic/readExcelSave",saveFileModel:"/app/xlgl/xlglexamtopic/upLoadFile",uploadPermission:!1,isEmpty:!1,textMap1:{update:"编辑",create:"新增"},pictureDialogFlag:"create",pictureUpload:"/app/xlgl/xlglexamtopic/uploadPicture",pictureDialogVisible:!1,pictureInfo:{topicColumn:"",topicOptionA:"",topicOptionB:"",topicOptionC:"",topicOptionD:"",topicResult:""},topicColumnFile:[],topicOptionFileObj:[]}},watch:{radiofileType:{handler:function(t){this.fileMobanData.fileType=t}}},created:function(){this.getTreeList()},methods:{addTest:function(){this.dialogStatus="create",this.dialogVisible=!0},saveDialog:function(){var t=this;if(this.temp.subjectName||this.$notify({title:"提示",message:"请输入科目名称",duration:1500,type:"warning"}),this.temp.subjectType||this.$notify({title:"提示",message:"请选择科目题型",duration:1500,type:"warning"}),this.temp.subjectName&&this.temp.subjectType)if("create"===this.dialogStatus)Object(l["a"])({subjectName:this.temp.subjectName,subjectType:this.temp.subjectType}).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"题库类型添加成功!",duration:1500,type:"success",onClose:function(){t.handleClose(),t.getTreeList()}}):t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"})});else{var e=this.temp.subjectTypes.indexOf(this.temp.subjectType);-1===e&&this.temp.subjectTypes.push(this.temp.subjectType);var i=[];this.temp.subjectTypes.forEach(function(t){t&&i.push(t)}),Object(l["c"])({id:this.listQuery.subjectId,subjectType:i.join(",")}).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"题库类型添加成功!",duration:1500,type:"success",onClose:function(){t.handleClose(),t.getTreeList()}}):t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"})})}},handleClose:function(){"update"===this.dialogStatus?this.updateTemp={topicColumn:"",topicOption:"",topicResult:""}:this.temp={subjectName:"",subjectType:"",subjectTypes:""},this.dialogVisible=!1},getTreeList:function(){var t=this;Object(l["i"])().then(function(e){t.treeData=e.data,t.$nextTick(function(){this.treeData.length>=1?(this.$refs.tree.setCurrentKey(this.treeData[0].children[0].id),this.listQuery.subjectId=this.treeData[0].id,this.listQuery.topicType=this.treeData[0].children[0].type,this.fileData.subjectId=this.treeData[0].id,this.getTestList(),this.getSubjectState(),this.isEmpty=!1):this.isEmpty=!0})})},remove:function(t,e){var i=this;this.$confirm("是否删除该题型?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var a=t.parent,o=a.data.children||a.data,s=[];o.length>1&&o.map(function(t){t.type!=e.type&&s.push(t.type)}),Object(l["c"])({id:a.data.id,delType:e.type,subjectType:s.join(",")}).then(function(t){0===t.data.code?i.$notify({title:"提示",message:"删除成功",duration:1500,type:"success",onClose:function(){i.getTreeList()}}):i.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}).catch(function(){i.$notify({title:"提示",message:"已取消删除",duration:1500,type:"warning"})})},add:function(t,e){this.remark="",e.type?(this.listQuery={subjectId:t.parent.data.id,topicType:e.type,page:this.listQuery.page,limit:this.listQuery.limit},this.fileData.subjectId=t.parent.data.id,this.getTestList(),this.getSubjectState()):(this.listQuery.subjectId=e.id,this.getSubjectState()),this.dialogStatus="create1",this.temp.subjectName=e.label;var i=e.children,a=[];for(var o in i)a.push(i[o].type);this.temp.subjectTypes=a,this.dialogVisible=!0},removeSubject:function(t,e){var i=this;this.$confirm("是否删除该科目?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l["f"])({ids:e.id}).then(function(t){0===t.data.code?i.$notify({title:"提示",message:"删除成功!",duration:1500,type:"success",onClose:function(){i.getTreeList()}}):i.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}).catch(function(){i.$notify({title:"提示",message:"已取消删除",duration:1500,type:"warning"})})},mouseenter:function(t){this.$set(t,"show",!0)},mouseleave:function(t){this.$set(t,"show",!1)},handleNodeClick:function(t,e){this.remark="",t.type?(this.listQuery={subjectId:e.parent.data.id,topicType:t.type,page:this.listQuery.page,limit:this.listQuery.limit},this.fileData.subjectId=e.parent.data.id,this.getTestList(),this.getSubjectState()):(this.listQuery.subjectId=t.id,this.getSubjectState())},openFileDialog:function(){this.getUpLoad(),this.getMobanList(),this.importFileDialog=!0},getUpLoad:function(){var t=this;Object(l["j"])().then(function(e){t.uploadPermission=e.data.state})},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.radiofileType="",this.importFileDialog=!1},submitFile:function(){this.$root.$emit("uploadFileHandle",!0),this.$refs.upload.submit()},successFile:function(t){var e=this;this.$root.$emit("uploadFileHandle",!1),200===t.code||t.fileId?this.$notify({title:"提示",message:"上传成功!",type:"success",duration:1500,onClose:function(){e.getTestList(),e.closeFileDialog()}}):this.$notify({title:"提示",message:t.msg,duration:1500,type:"warning"})},errorFile:function(){this.$root.$emit("uploadFileHandle",!1),this.$notify({title:"提示",message:"上传失败！",duration:1500,type:"warning"})},onSubmit:function(){this.getTestList()},getTestList:function(){var t=this;this.listLoading=!0,Object(l["h"])(this.listQuery).then(function(e){e.data.page.list.map(function(t){t.optionArr=t.topicOption.split(","),t.map=t.map||{}}),t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},handleModifyStatus:function(t,e){var i=this;this.topicOptionFileObj=[],this.topicColumnFile=[],this.fileListAll=[],this.fileListA=[],this.fileListB=[],this.fileListC=[],this.fileListD=[],"edit"===e?(this.pictureDialogFlag="update",this.pictureDialogVisible=!0,this.pictureInfo={topicColumn:"",topicOptionA:"",topicOptionB:"",topicOptionC:"",topicOptionD:"",topicResult:""},Object(l["d"])({id:t.id}).then(function(t){if(i.updateTemp=t.data.xlglExamTopic,i.pictureInfo.topicColumn=i.updateTemp.topicColumn,i.pictureInfo.topicResult=i.updateTemp.topicResult,i.topicOptionFileObj=[],i.topicColumnFile=[],i.fileListAll=[],i.fileListA=[],i.fileListB=[],i.fileListC=[],i.fileListD=[],i.updateTemp.pictureColumn){var e=i.updateTemp.pictureColumn.split(",");e.forEach(function(t){i.fileListAll.push({url:"/app/xlgl/xlgldocumentfile/downLoad?fileId=".concat(t)}),i.topicColumnFile.push({fileid:t})})}if(("1"===i.updateTemp.topicType||"2"===i.updateTemp.topicType)&&(i.updateTemp.map&&(i.fileListA=i.updateTemp.map.A?[{url:"/app/xlgl/xlgldocumentfile/downLoad?fileId=".concat(i.updateTemp.map.A)}]:[],i.fileListB=i.updateTemp.map.A?[{url:"/app/xlgl/xlgldocumentfile/downLoad?fileId=".concat(i.updateTemp.map.B)}]:[],i.fileListC=i.updateTemp.map.A?[{url:"/app/xlgl/xlgldocumentfile/downLoad?fileId=".concat(i.updateTemp.map.C)}]:[],i.fileListD=i.updateTemp.map.A?[{url:"/app/xlgl/xlgldocumentfile/downLoad?fileId=".concat(i.updateTemp.map.D)}]:[],i.updateTemp.map.A&&i.topicOptionFileObj.push({type:"A",fileid:i.updateTemp.map.A}),i.updateTemp.map.B&&i.topicOptionFileObj.push({type:"B",fileid:i.updateTemp.map.B}),i.updateTemp.map.C&&i.topicOptionFileObj.push({type:"C",fileid:i.updateTemp.map.C}),i.updateTemp.map.D&&i.topicOptionFileObj.push({type:"D",fileid:i.updateTemp.map.D})),i.updateTemp.topicOption)){var a=i.updateTemp.topicOption.split(",");a.forEach(function(t){var e=t.split(":");i.pictureInfo["topicOption".concat(e[0])]=e[1]})}})):"delete"===e&&this.$confirm("是否进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l["b"])({ids:t.id}).then(function(t){0===t.data.code?i.$notify({title:"提示",message:"删除成功",duration:1500,type:"success",onClose:function(){i.getTestList()}}):i.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}).catch(function(){i.$notify({title:"提示",message:"已取消删除",duration:1500,type:"warning"})})},getMobanList:function(){var t=this;Object(l["e"])().then(function(e){t.moBanList=e.data.list})},downMOBan:function(t){window.location.href="/app/xlgl/xlglexamtopic/downloadFile?topicType="+this.listQuery.topicType+"&fileId="+t+"&access_token="+this.$store.state.user.token},saveTestDiscribute:function(){var t=this;if(this.listQuery.subjectId){var e={id:this.listQuery.subjectId,state:this.remark};Object(l["c"])(e).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"保存成功!",duration:1500,type:"success"}):t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"})})}else this.$notify({title:"提示",message:"请先创建考试科目",duration:1500,type:"warning"})},getSubjectState:function(){var t=this,e={id:this.listQuery.subjectId};Object(l["g"])(e).then(function(e){t.remark=e.data.state})},openPictureDialog:function(){this.topicOptionFileObj=[],this.topicColumnFile=[],this.fileListAll=[],this.fileListA=[],this.fileListB=[],this.fileListC=[],this.fileListD=[],this.pictureDialogFlag="create",this.pictureDialogVisible=!0},handleClose1:function(){this.pictureInfo={},this.pictureDialogVisible=!1},addTopicColumnfn:function(t){this.topicColumnFile.push(t.fileid),console.log(this.fileListAll)},removeTopicColumnfn:function(t){this.topicColumnFile.remove(t.fileid)},addTopicDOptionfn:function(t){this.topicOptionFileObj.push({type:"D",fileid:t.fileid})},addTopicCOptionfn:function(t){this.topicOptionFileObj.push({type:"C",fileid:t.fileid})},addTopicBOptionfn:function(t){this.topicOptionFileObj.push({type:"B",fileid:t.fileid})},addTopicAOptionfn:function(t){this.topicOptionFileObj.push({type:"A",fileid:t.fileid})},removeTopicOptionfn:function(t){var e=this;this.topicOptionFileObj.forEach(function(i){i.fileid===t.response.fileid&&e.topicOptionFileObj.remove(i)})},savePicuteDialog:function(t){for(var e=this,i=[],a=[],o={haveA:!1,haveB:!1,haveC:!1,haveD:!1},s=0;s<this.topicOptionFileObj.length;s++){var n=this.topicOptionFileObj[s];i.push(n.type+"-"+n.fileid),o["have".concat(n.type)]=!0}(this.pictureInfo.topicOptionA||o.haveA)&&a.push("A:"+this.pictureInfo.topicOptionA||!1),(this.pictureInfo.topicOptionB||o.haveB)&&a.push("B:"+this.pictureInfo.topicOptionB||!1),(this.pictureInfo.topicOptionC||o.haveC)&&a.push("C:"+this.pictureInfo.topicOptionC||!1),(this.pictureInfo.topicOptionD||o.haveD)&&a.push("D:"+this.pictureInfo.topicOptionD||!1);var p={topicColumn:this.pictureInfo.topicColumn,topicType:this.listQuery.topicType,topicOption:a.join(","),subjectId:this.listQuery.subjectId,topicResult:this.pictureInfo.topicResult,pictureColumn:this.topicColumnFile.join(","),pictureOption:i.join(",")};"update"===t?(p.id=this.updateTemp.id,Object(l["l"])(p).then(function(t){0===t.data.code?e.$notify({title:"提示",message:"修改成功!",duration:1500,type:"success",onClose:function(){e.handleClose1(),e.getTestList()}}):e.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})):Object(l["k"])(p).then(function(t){0===t.data.code?e.$notify({title:"提示",message:"新增成功!",duration:1500,type:"success",onClose:function(){e.handleClose1(),e.getTestList()}}):e.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}}},p=n,c=(i("20bc"),i("2877")),r=Object(c["a"])(p,a,o,!1,null,"64ceff5a",null);e["default"]=r.exports}}]);