(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-73f05606"],{"98ee":function(t,e,i){},aa2b:function(t,e,i){"use strict";var a=i("98ee"),s=i.n(a);s.a},e64d:function(t,e,i){"use strict";i.d(e,"a",function(){return s}),i.d(e,"i",function(){return l}),i.d(e,"h",function(){return o}),i.d(e,"c",function(){return n}),i.d(e,"f",function(){return c}),i.d(e,"b",function(){return r}),i.d(e,"j",function(){return u}),i.d(e,"d",function(){return p}),i.d(e,"e",function(){return d}),i.d(e,"g",function(){return m});var a=i("b775");function s(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/save",method:"post",data:t})}function l(){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/subject",method:"get"})}function o(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/list",method:"get",params:t})}function n(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/update",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/delete",method:"post",data:t})}function r(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/delete",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/update",method:"post",data:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlglexamtopic/info",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlglexamfile/list",method:"post",data:t})}function m(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/getSubjectState",method:"post",data:t})}},f31f:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticStyle:{height:"calc(100vh - 120px)",overflow:"hidden","padding-bottom":"60px"},attrs:{xl:6,md:6}},[i("el-button",{staticClass:"btnPosition",attrs:{type:"primary"},on:{click:t.addTest}},[t._v("创建题库类型")]),t._v(" "),i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-tree",{ref:"tree",attrs:{data:t.treeData,props:t.defaultProps,"default-expand-all":"","node-key":"id"},on:{"node-click":t.handleNodeClick},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.node,s=e.data;return i("span",{staticClass:"custom-tree-node",on:{mouseenter:function(e){return t.mouseenter(s)},mouseleave:function(e){return t.mouseleave(s)}}},[i("span",[t._v(t._s(a.label))]),t._v(" "),a.isLeaf?i("span",[a.parent.parent?i("el-button",{directives:[{name:"show",rawName:"v-show",value:s.show,expression:"data.show"}],attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(e){return e.stopPropagation(),t.remove(a,s)}}}):t._e()],1):t._e(),t._v(" "),(a.isLeaf||a.parent.parent)&&a.parent.parent?t._e():i("span",[i("el-button",{directives:[{name:"show",rawName:"v-show",value:s.show,expression:"data.show"}],attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){return e.stopPropagation(),t.add(a,s)}}}),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:s.show,expression:"data.show"}],attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(e){return e.stopPropagation(),t.removeSubject(a,s)}}})],1)])}}])})],1)],1),t._v(" "),i("el-col",{attrs:{xl:18,md:18}},[i("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.listQuery,size:"medium"}},[i("el-col",{attrs:{xl:20,md:20}},[i("el-form-item",[i("el-input",{staticClass:"inputSize",attrs:{placeholder:"请输入查询内容"},model:{value:t.listQuery.topicColumn,callback:function(e){t.$set(t.listQuery,"topicColumn",e)},expression:"listQuery.topicColumn"}})],1),t._v(" "),i("el-form-item",[i("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.onSubmit}},[t._v("搜索")])],1)],1),t._v(" "),i("el-col",{attrs:{xl:4,md:4}},[i("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.openFileDialog}},[t._v("题目导入")])],1),t._v(" "),i("el-col",{attrs:{xl:22,md:22}},[i("el-input",{staticClass:"textareaSty",attrs:{type:"textarea"},model:{value:t.remark,callback:function(e){t.remark=e},expression:"remark"}})],1),t._v(" "),i("el-col",{attrs:{xl:2,md:2}},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveTestDiscribute}},[t._v("保存")])],1)],1),t._v(" "),i("div",{staticStyle:{height:"calc(100vh - 360px)",overflow:"hidden",width:"100%","padding-top":"10px"}},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{"default-expand-all":!0,data:t.list,border:"",fit:!0,stripe:!0,"highlight-current-row":""}},[i("el-table-column",{attrs:{type:"expand"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-row",{attrs:{title:e.row.topicOption}},t._l(e.row.optionArr,function(e,a){return i("span",{key:a,staticClass:"spanSty"},[t._v(t._s(e))])}),0)]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"题目","min-width":"300",align:"left"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("div",{attrs:{title:e.row.topicColumn}},[t._v(t._s(e.row.topicColumn))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"答案",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.topicResult))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.handleModifyStatus(a,"edit")}}},[t._v("编辑")]),t._v(" "),i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleModifyStatus(a,"delete")}}},[t._v("删除")])]}}])})],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getTestList}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:t.textMap[t.dialogStatus],visible:t.dialogVisible,width:"30%","before-close":t.handleClose},on:{"update:visible":function(e){t.dialogVisible=e}}},["create"===t.dialogStatus||"create1"===t.dialogStatus?i("el-form",{staticClass:"demo-form-inline questionForm",attrs:{inline:!0,rules:t.rules,model:t.temp,size:"medium"}},[i("el-form-item",{attrs:{label:"创建科目：",prop:"subjectName"}},["create"===t.dialogStatus?i("el-input",{attrs:{placeholder:"请输入科目名称"},model:{value:t.temp.subjectName,callback:function(e){t.$set(t.temp,"subjectName",e)},expression:"temp.subjectName"}}):t._e(),t._v(" "),"create1"===t.dialogStatus?i("el-input",{attrs:{placeholder:"请输入科目名称",readonly:""},model:{value:t.temp.subjectName,callback:function(e){t.$set(t.temp,"subjectName",e)},expression:"temp.subjectName"}}):t._e()],1),t._v(" "),i("el-form-item",{attrs:{label:"科目题型：",prop:"subjectType"}},[i("el-select",{staticClass:"filter-item",attrs:{filterable:"",placeholder:"请选择科目题型"},model:{value:t.temp.subjectType,callback:function(e){t.$set(t.temp,"subjectType",e)},expression:"temp.subjectType"}},t._l(t.typeList,function(t){return i("el-option",{key:t.value,attrs:{label:t.name,value:t.value}})}),1)],1)],1):t._e(),t._v(" "),"update"===t.dialogStatus?i("el-form",{staticClass:"demo-form-inline questionForm",attrs:{inline:!0,rules:t.rules,model:t.updateTemp,size:"medium"}},[i("el-form-item",{attrs:{label:"题目：",prop:"topicColumn"}},[i("el-input",{attrs:{placeholder:"请输入试题题目"},model:{value:t.updateTemp.topicColumn,callback:function(e){t.$set(t.updateTemp,"topicColumn",e)},expression:"updateTemp.topicColumn"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"选项：",prop:"topicOption"}},[i("el-input",{attrs:{placeholder:"请输入试题选项"},model:{value:t.updateTemp.topicOption,callback:function(e){t.$set(t.updateTemp,"topicOption",e)},expression:"updateTemp.topicOption"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"答案：",prop:"topicResult"}},[i("el-input",{attrs:{placeholder:"请输入正确答案"},model:{value:t.updateTemp.topicResult,callback:function(e){t.$set(t.updateTemp,"topicResult",e)},expression:"updateTemp.topicResult"}})],1)],1):t._e(),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveDialog}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.handleClose}},[t._v("取 消")])],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"题目导入",visible:t.importFileDialog,width:"40%",accept:".xls,.xlsx","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.importFileDialog=e}}},[i("div",{staticClass:"downDiv"},[i("h3",[t._v("上传模板")]),t._v(" "),i("div",{staticStyle:{"text-align":"center"}},[i("el-radio-group",{model:{value:t.radiofileType,callback:function(e){t.radiofileType=e},expression:"radiofileType"}},t._l(t.typeList,function(e){return i("el-radio",{key:e.value,attrs:{label:e.value}},[t._v(t._s(e.name))])}),1)],1)]),t._v(" "),t.moBanList.length>0?i("div",{staticClass:"downDiv"},[i("h3",[t._v("下载模板")]),t._v(" "),i("div",{staticStyle:{"text-align":"center"}},t._l(t.moBanList,function(e){return i("el-row",{key:e.fileId,staticStyle:{height:"30px","line-height":"30px"},attrs:{gutter:20}},[i("el-col",{attrs:{span:6}},[i("span",[t._v(t._s(t._f("fileType")(e.fileType))+"：")])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"left"},attrs:{span:18}},[i("a",{staticStyle:{"text-decoration":"underline",color:"#3377FF"},attrs:{href:"#"},on:{click:function(i){return t.downMOBan(e.fileId)}}},[t._v(t._s(e.fileName))])])],1)}),1)]):t._e(),t._v(" "),i("div",{staticClass:"centerPosition"},[i("div",{staticClass:"downDiv"},[i("h3",{staticStyle:{"text-align":"left"}},[t._v("上传附件")])]),t._v(" "),t.radiofileType?i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"auto-upload":!1,"with-credentials":!0,action:t.saveFileModel,data:t.fileMobanData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])]):i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},s=[],l=(i("28a5"),i("e64d")),o=i("333d"),n={name:"ComplexTable",components:{Pagination:o["a"]},filters:{fileType:function(t){var e="";switch(t){case"1":e="单选题模板";break;case"2":e="多选题模板";break;case"3":e="判断题模板";break;case"4":e="填空题模板";break}return e}},data:function(){return{treeData:[],defaultProps:{children:"children",label:"label"},tableKey:0,list:null,total:0,listLoading:!1,listQuery:{topicType:"",subjectId:"",topicColumn:"",page:1,limit:20},typeList:[{name:"单选",value:"1"},{name:"多选",value:"2"},{name:"判断",value:"3"},{name:"填空",value:"4"}],temp:{subjectName:"",subjectType:"",subjectTypes:""},updateTemp:{topicColumn:"",topicOption:"",topicResult:""},dialogVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增题库类型",create1:"新增题库类型"},rules:{subjectName:[{required:!0,message:"请输入科目名称",trigger:"blur"}],subjectType:[{required:!0,message:"请选择科目题型",trigger:"change"}],topicColumn:[{required:!0,message:"请输入试题题目",trigger:"blur"}],topicOption:[{required:!0,message:"请输入试题选项",trigger:"blur"}],topicResult:[{required:!0,message:"请输入正确答案",trigger:"blur"}]},radiofileType:"",remark:"",importFileDialog:!1,moBanList:[],fileData:{access_token:this.$store.state.user.token,subjectId:""},fileMobanData:{fileType:""},fileUploadUrl:"/app/xlgl/xlglexamtopic/readExcelSave",saveFileModel:"/app/xlgl/xlglexamtopic/upLoadFile"}},watch:{radiofileType:{handler:function(t){this.fileMobanData.fileType=t}}},created:function(){this.getTreeList()},methods:{addTest:function(){this.dialogStatus="create",this.dialogVisible=!0},saveDialog:function(){var t=this;if("update"===this.dialogStatus){if(this.updateTemp.topicColumn||this.$message({type:"info",message:"请输入试题题目"}),this.updateTemp.topicOption||this.$message({type:"info",message:"请输入试题选项"}),this.updateTemp.topicResult||this.$message({type:"info",message:"请输入正确答案"}),this.updateTemp.topicColumn&&this.updateTemp.topicOption&&this.updateTemp.topicResult){var e={id:this.updateTemp.id,subjectId:this.updateTemp.subjectId,topicColumn:this.updateTemp.topicColumn,topicOption:this.updateTemp.topicOption,topicResult:this.updateTemp.topicResult,topicType:this.updateTemp.topicType};Object(l["j"])(e).then(function(e){0===e.data.code?t.$message({type:"success",message:"修改成功!",onClose:function(){t.handleClose(),t.getTestList()}}):t.$message({type:"info",message:e.data.msg})})}}else if(this.temp.subjectName||this.$message({type:"info",message:"请输入科目名称"}),this.temp.subjectType||this.$message({type:"info",message:"请选择科目题型"}),this.temp.subjectName&&this.temp.subjectType)if("create"===this.dialogStatus)Object(l["a"])({subjectName:this.temp.subjectName,subjectType:this.temp.subjectType}).then(function(e){0===e.data.code?t.$message({type:"success",message:"题库类型添加成功!",onClose:function(){t.handleClose(),t.getTreeList()}}):t.$message({type:"info",message:e.data.msg})});else{var i=this.temp.subjectTypes.indexOf(this.temp.subjectType);-1===i&&this.temp.subjectTypes.push(this.temp.subjectType),Object(l["c"])({id:this.listQuery.subjectId,subjectType:this.temp.subjectTypes.join(",")}).then(function(e){0===e.data.code?t.$message({type:"success",message:"题库类型添加成功!",onClose:function(){t.handleClose(),t.getTreeList()}}):t.$message({type:"info",message:e.data.msg})})}},handleClose:function(){"update"===this.dialogStatus?this.updateTemp={topicColumn:"",topicOption:"",topicResult:""}:this.temp={subjectName:"",subjectType:"",subjectTypes:""},this.dialogVisible=!1},getTreeList:function(){var t=this;Object(l["i"])().then(function(e){t.treeData=e.data,t.$nextTick(function(){this.treeData.length>=1&&(this.$refs.tree.setCurrentKey(this.treeData[0].children[0].id),this.listQuery.subjectId=this.treeData[0].id,this.listQuery.topicType=this.treeData[0].children[0].type,this.fileData.subjectId=this.treeData[0].id,this.getTestList(),this.getSubjectState())})})},remove:function(t,e){var i=this;this.$confirm("是否删除该题型?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var a=t.parent,s=a.data.children||a.data,o=[];s.length>1&&s.map(function(t){t.type!=e.type&&o.push(t.type)}),Object(l["c"])({id:a.data.id,delType:e.type,subjectType:o.join(",")}).then(function(t){0===t.data.code?i.$message({type:"success",message:"删除成功!",onClose:function(){i.getTreeList()}}):i.$message({type:"info",message:t.data.msg})})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},add:function(t,e){this.dialogStatus="create1",this.temp.subjectName=e.label;var i=e.children,a=[];for(var s in i)a.push(i[s].type);this.temp.subjectTypes=a,this.dialogVisible=!0},removeSubject:function(t,e){var i=this;this.$confirm("是否删除该科目?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l["f"])({ids:e.id}).then(function(t){0===t.data.code?i.$message({type:"success",message:"删除成功!",onClose:function(){i.getTreeList()}}):i.$message({type:"info",message:t.data.msg})})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},mouseenter:function(t){this.$set(t,"show",!0)},mouseleave:function(t){this.$set(t,"show",!1)},handleNodeClick:function(t,e){this.remark="",t.type?(this.listQuery={subjectId:e.parent.data.id,topicType:t.type,page:this.listQuery.page,limit:this.listQuery.limit},this.fileData.subjectId=e.parent.data.id,this.getTestList(),this.getSubjectState()):(this.listQuery.subjectId=t.id,this.getSubjectState())},openFileDialog:function(){this.getMobanList(),this.importFileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.radiofileType="",this.importFileDialog=!1},submitFile:function(){this.$refs.upload.submit()},successFile:function(t){var e=this;200===t.code||t.fileId?this.$message({type:"success",message:"上传成功!",onClose:function(){e.getTestList(),e.closeFileDialog()}}):this.$message({type:"info",message:t.msg})},errorFile:function(){this.$message({type:"info",message:"上传失败！"})},onSubmit:function(){this.getTestList()},getTestList:function(){var t=this;this.listLoading=!0,Object(l["h"])(this.listQuery).then(function(e){e.data.page.list.map(function(t){t.optionArr=t.topicOption.split(",")}),t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},handleModifyStatus:function(t,e){var i=this;"edit"===e?(this.dialogStatus="update",this.dialogVisible=!0,Object(l["d"])({id:t.id}).then(function(t){i.updateTemp=t.data.xlglExamTopic})):"delete"===e&&this.$confirm("是否进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l["b"])({ids:t.id}).then(function(t){0===t.data.code?i.$message({type:"success",message:"删除成功!",onClose:function(){i.getTestList()}}):i.$message({type:"info",message:t.data.msg})})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},getMobanList:function(){var t=this;Object(l["e"])().then(function(e){t.moBanList=e.data.list})},downMOBan:function(t){window.location.href="xlgl/xlglexamtopic/downloadFile?topicType="+this.listQuery.topicType+"&fileId="+t+"&access_token="+this.$store.state.user.token},saveTestDiscribute:function(){var t=this;if(this.listQuery.subjectId){var e={id:this.listQuery.subjectId,state:this.remark};Object(l["c"])(e).then(function(e){0===e.data.code?t.$message({type:"success",message:"保存成功!"}):t.$message({type:"info",message:e.data.msg})})}else this.$message({type:"info",message:"请先创建考试科目"})},getSubjectState:function(){var t=this,e={id:this.listQuery.subjectId};Object(l["g"])(e).then(function(e){t.remark=e.data.state})}}},c=n,r=(i("aa2b"),i("2877")),u=Object(r["a"])(c,a,s,!1,null,"4ad738e6",null);e["default"]=u.exports}}]);