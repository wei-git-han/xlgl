(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6ba43022","chunk-12c746e4"],{"04a5":function(t,e,i){"use strict";var s=i("310e"),a=i.n(s);a.a},"310e":function(t,e,i){},"3ceb":function(t,e,i){},"4b2b":function(t,e,i){"use strict";var s=i("3ceb"),a=i.n(s);a.a},"9ef8":function(t,e,i){"use strict";i.d(e,"b",function(){return a}),i.d(e,"a",function(){return l});var s=i("b775");function a(t){return Object(s["a"])({url:"/app/xlgl/adminset/list",method:"post",data:t})}function l(t){return Object(s["a"])({url:"/app/xlgl/adminset/list",method:"post",data:t})}},cb8f:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[0===t.fileList.length?i("div",{staticClass:"app-container"},[i("div",{staticClass:"waitDiv"},[i("h6",[t._v("你还未上传文件，请点击按钮上传")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{width:"360px",height:"220px"},attrs:{"icon-class":"tixing"}}),t._v(" "),i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("注：只能上传word文件格式，且不超过500kb")])])],1)]):i("detail-file",{attrs:{"file-list":t.fileList}})],1)},a=[],l=i("feea"),n=i("9ef8"),o={name:"CarManagerindex",components:{detailFile:l["default"]},data:function(){return{fileUrl:"/app/xlgl/xlglnotice/saveOrUpdate",fileData:{access_token:this.$store.state.user.token},fileShow:!1,fileList:[{name:"文档一"},{name:"文档二"}]}},created:function(){this.getCarFileList()},methods:{successFile:function(t){var e=this;this.$message({type:"success",message:"上传成功!",onClose:function(){e.getCarFileList()}})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},getCarFileList:function(){Object(n["b"])().then(function(t){})}}},r=o,c=(i("4b2b"),i("2877")),u=Object(c["a"])(r,s,a,!1,null,"5ad308d2",null);e["default"]=u.exports},feea:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{attrs:{span:16}},[i("div",{staticClass:"div1"},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),i("el-col",{attrs:{span:8}},[i("div",{staticClass:"div1"},[i("div",{staticStyle:{"margin-bottom":"10px"}},[i("el-button",{attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")])],1),t._v(" "),i("div",{staticClass:"div2"},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-table",{key:t.tableKey,ref:"filetable",attrs:{data:t.fileList,border:"",fit:"","highlight-current-row":""},on:{"row-click":t.handleCurrent}},[i("el-table-column",{attrs:{label:"文件名",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.name))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.examineSubjectName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.updateDate))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",width:"80px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleModifyStatus(s,"delete")}}},[t._v("删除")])]}}])})],1)],1)],1)])])],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},a=[],l=i("9ef8"),n={name:"DetailFiles",props:{fileList:{type:Array,default:function(){return[]}}},data:function(){return{tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token},fileUploadUrl:"",onlineFileUrl:"/app/openFile/demo.html"}},mounted:function(){this.$refs.filetable.setCurrentRow(this.fileList[0])},methods:{handleCurrent:function(t){this.$refs.filetable.setCurrentRow(t)},handleModifyStatus:function(t,e){var i=this;Object(l["a"])({ids:t.id}).then(function(t){0===t.data.code?i.$message({type:"success",message:"删除成功!",onClose:function(){i.getTestList()}}):i.$message({type:"info",message:t.data.msg})})},openDialog:function(){this.fileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){this.$refs.upload.submit()},successFile:function(t){var e=this;this.$message({type:"success",message:"上传成功!",onClose:function(){e.$parent.getCarFileList()}})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})}}},o=n,r=(i("04a5"),i("2877")),c=Object(r["a"])(o,s,a,!1,null,"fc879b78",null);e["default"]=c.exports}}]);