(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-161ec411","chunk-3aaec4cc"],{4171:function(t,e,i){"use strict";var s=i("4be5"),l=i.n(s);l.a},"4be5":function(t,e,i){},"9ef8":function(t,e,i){"use strict";i.d(e,"b",function(){return l}),i.d(e,"a",function(){return a});var s=i("b775");function l(t){return Object(s["a"])({url:"/app/xlgl/xlglcarsmanager/getFileList",method:"post",data:t})}function a(t){return Object(s["a"])({url:"/app/xlgl/xlglcarsmanager/delete",method:"post",data:t})}},cb8fc:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[0===t.fileList.length?i("div",{staticClass:"app-container"},[i("div",{staticClass:"empty_default font_3"},["0"===t.show||"1"===t.show||"3"===t.show?i("h6",[t._v("你还未上传文件，请点击按钮上传")]):i("h6",[t._v("暂无文件")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{width:"360px",height:"220px"},attrs:{"icon-class":"tixing"}}),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,data:t.fileData,accept:".pdf","on-success":t.successFile,"on-error":t.errorFile,"on-progress":t.progressFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("注：文件类型只支持pdf格式")])]):t._e()],1)]):i("detail-file",{attrs:{"file-list":t.fileList}})],1)},l=[],a=i("feea"),o=i("9ef8"),n={name:"CarManagerindex",components:{detailFile:a["default"]},data:function(){return{show:this.$store.state.user.userInfo.adminFlag,fileUrl:"/app/xlgl/xlglcarsmanager/uploadFile",fileData:{access_token:this.$store.state.user.token},fileShow:!1,fileList:[]}},created:function(){this.getCarFileList()},methods:{progressFile:function(){this.$root.$emit("uploadFileHandle",!0)},successFile:function(t){this.$root.$emit("uploadFileHandle",!1),t.fileId&&t.fileId.length>0?(this.$notify({title:"提示",message:"上传成功！",type:"success",duration:1500}),this.getCarFileList()):this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},errorFile:function(){this.$root.$emit("uploadFileHandle",!1),this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},getCarFileList:function(){var t=this;Object(o["b"])().then(function(e){t.fileList=e.data.list})}}},r=n,c=i("2877"),u=Object(c["a"])(r,s,l,!1,null,"84a12766",null);e["default"]=u.exports},feea:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{attrs:{span:14}},[i("div",{staticClass:"div1"},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),i("el-col",{attrs:{span:10}},[i("div",{staticClass:"div1"},[i("div",{staticStyle:{"margin-bottom":"10px"}},["0"===t.show||"1"===t.show||"3"===t.show?i("el-button",{attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("导入")]):t._e()],1),t._v(" "),i("div",[i("el-table",{key:t.tableKey,ref:"filetable",attrs:{data:t.fileList,height:"calc(100vh - 100px)",border:"",fit:"","highlight-current-row":""},on:{"row-click":t.handleCurrent}},[i("el-table-column",{attrs:{label:"文件名",align:"center",width:"230px"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.fileName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传时间",width:"140px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.createdTime))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传人",width:"120px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.uploadUser))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return["0"===t.show||"1"===t.show||"3"===t.show?i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return e.stopPropagation(),t.handleModifyStatus(s,"delete")}}},[t._v("删除")]):t._e(),t._v(" "),i("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(e){return e.stopPropagation(),t.handleModifyStatus(s,"down")}}},[t._v("下载")])]}}])})],1)],1)])])],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,accept:".pdf","on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只支持上传pdf格式文件")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},l=[],a=i("9ef8"),o={name:"DetailFiles",props:{fileList:{type:Array,default:function(){return[]}}},data:function(){return{show:this.$store.state.user.userInfo.adminFlag,tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token},fileUploadUrl:"/app/xlgl/xlglcarsmanager/uploadFile",onlineFileUrl:""}},mounted:function(){this.$refs.filetable.setCurrentRow(this.fileList[0]),this.onlineFileUrl="/app/openFile/demo.html?fileId="+this.fileList[0].infoId+"&access_token="+this.$store.state.user.token},methods:{handleCurrent:function(t){this.$refs.filetable.setCurrentRow(t),this.onlineFileUrl="/app/openFile/demo.html?fileId="+t.infoId+"&access_token="+this.$store.state.user.token},handleModifyStatus:function(t,e){var i=this;"down"===e?window.location.href="/app/xlgl/xlglcarsmanager/downLoadFile?fileId="+t.infoId+"&access_token="+this.$store.state.user.token:Object(a["a"])({id:t.id}).then(function(t){"success"===t.data.result?(i.$notify({title:"提示",message:"删除成功!",type:"success",duration:1500}),i.$parent.getCarFileList()):i.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})},openDialog:function(){this.fileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){this.$root.$emit("uploadFileHandle",!0),this.$refs.upload.submit()},successFile:function(t){this.$root.$emit("uploadFileHandle",!1),t.fileId&&t.fileId.length>0?(this.$notify({title:"提示",message:"上传成功!",type:"success",duration:1500}),this.$parent.getCarFileList(),this.closeFileDialog()):(this.$root.$emit("uploadFileHandle",!1),this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"}))},errorFile:function(){this.$root.$emit("uploadFileHandle",!1),this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})}}},n=o,r=(i("4171"),i("2877")),c=Object(r["a"])(n,s,l,!1,null,"6e71910b",null);e["default"]=c.exports}}]);