(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-68462a80","chunk-2d0af4e3"],{"0e80":function(e,t,l){"use strict";l.r(t);var a=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-row",{attrs:{gutter:20}},[l("el-col",{attrs:{span:16}},[l("div",{staticClass:"div1"},[l("iframe",{attrs:{src:e.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),e._v(" "),l("el-col",{attrs:{span:8}},[l("div",{staticClass:"div1"},[l("div",{staticClass:"div2"},[l("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[l("el-table",{key:e.tableKey,ref:"filetable",attrs:{data:e.fileList,border:"",fit:"","highlight-current-row":""},on:{"row-click":e.handleCurrent}},[l("el-table-column",{attrs:{label:"文件名",align:"center","min-width":"150px"},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.row;return[l("span",[e._v(e._s(a.name))])]}}])}),e._v(" "),l("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.row;return[l("span",[e._v(e._s(a.examineSubjectName))])]}}])}),e._v(" "),l("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.row;return[l("span",[e._v(e._s(a.updateDate))])]}}])}),e._v(" "),l("el-table-column",{attrs:{label:"操作",width:"80px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.row;return[l("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleModifyStatus(a,"delete")}}},[e._v("下载")]),e._v(" "),l("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleModifyStatus(a,"delete")}}},[e._v("删除")])]}}])})],1)],1)],1)])])],1)],1)},i=[],s={name:"DetailLegalInfo",props:{fileList:{type:Array,default:function(){return[]}}},data:function(){return{tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token},fileUploadUrl:"",onlineFileUrl:"/app/openFile/demo.html"}},mounted:function(){this.$refs.filetable.setCurrentRow(this.fileList[0])},methods:{handleCurrent:function(e){this.$refs.filetable.setCurrentRow(e)},handleModifyStatus:function(e,t){var l=this;deleteFileById({ids:e.id}).then(function(e){0===e.data.code?l.$message({type:"success",message:"删除成功!",onClose:function(){l.getTestList()}}):l.$message({type:"info",message:e.data.msg})})}}},n=s,o=l("2877"),r=Object(o["a"])(n,a,i,!1,null,"a67ee03a",null);t["default"]=r.exports},"4e6e":function(e,t,l){"use strict";var a=l("b100"),i=l.n(a);i.a},b100:function(e,t,l){},b862:function(e,t,l){"use strict";l.r(t);var a=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-button",{staticStyle:{float:"right","margin-top":"5px",position:"absolute",right:"80px","z-index":"999"},attrs:{type:"success",size:"mini"},on:{click:e.openDialog}},[e._v("新增")]),e._v(" "),l("el-tabs",{staticClass:"legalTab",on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[l("el-tab-pane",{attrs:{label:"全军管理法规",name:"first"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1),e._v(" "),l("el-tab-pane",{attrs:{label:"装备发展管理法规",name:"second"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1),e._v(" "),l("el-tab-pane",{attrs:{label:"常用资料",name:"third"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1),e._v(" "),l("el-tab-pane",{attrs:{label:"其他法规",name:"four"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1)],1),e._v(" "),l("el-dialog",{attrs:{title:"上传附件",visible:e.fileDialog,width:"40%","before-close":e.closeFileDialog},on:{"update:visible":function(t){e.fileDialog=t}}},[l("div",{staticClass:"centerPosition"},[l("el-form",{staticClass:"demo-form-inline questionForm",attrs:{inline:!0,size:"medium"}},[l("el-form-item",{attrs:{label:"资料类型选择：",required:""}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.selectValue,callback:function(t){e.selectValue=t},expression:"selectValue"}},e._l(e.options,function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1),e._v(" "),l("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:e.fileUploadUrl,data:e.fileData,"on-success":e.successFile1,"on-error":e.errorFile1}},[l("i",{staticClass:"el-icon-upload"}),e._v(" "),l("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),l("em",[e._v("点击上传")])]),e._v(" "),l("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("支持上传excel等格式")])])],1),e._v(" "),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:e.submitFile}},[e._v("确 定")]),e._v(" "),l("el-button",{on:{click:e.closeFileDialog}},[e._v("取 消")])],1)])],1)},i=[],s=(l("7f7f"),l("0e80")),n=l("b775");function o(e,t){return Object(n["a"])({url:"/app/xlgl/xlglrule/list",method:"post",data:t})}var r={name:"LegalIndex",components:{dlegalInfo:s["default"]},data:function(){return{activeName:"first",fileList:[],options:[{label:"全军管理法规",value:"0"},{label:"装备发展部管理法规",value:"1"},{label:"常用资料",value:"2"},{label:"其他法规",value:"3"}],fileUploadUrl:"",fileData:{access_token:this.$store.state.user.token},selectValue:"",fileDialog:!1}},methods:{getLegalFileList:function(){o().then(function(e){})},handleClick:function(e,t){console.log("选中的值"+e.name)},openDialog:function(){this.fileDialog=!0},submitFile:function(){this.$refs.upload.submit()},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},successFile1:function(e){var t=this;200===e.code||e.fileId?this.$message({type:"success",message:"上传成功!",onClose:function(){t.getTestList(),t.closeFileDialog()}}):this.$message({type:"info",message:e.msg})},errorFile1:function(){this.$message({type:"info",message:"上传失败！"})}}},c=r,u=(l("4e6e"),l("2877")),f=Object(u["a"])(c,a,i,!1,null,"2c35a948",null);t["default"]=f.exports}}]);