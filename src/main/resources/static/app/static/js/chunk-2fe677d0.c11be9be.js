(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2fe677d0"],{"194e":function(t,e,i){"use strict";var l=i("f85b"),a=i.n(l);a.a},"7a03":function(t,e,i){"use strict";i.d(e,"d",function(){return a}),i.d(e,"a",function(){return s}),i.d(e,"g",function(){return n}),i.d(e,"b",function(){return o}),i.d(e,"f",function(){return r}),i.d(e,"c",function(){return c}),i.d(e,"h",function(){return u}),i.d(e,"e",function(){return d});var l=i("b775");function a(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/list",method:"post",data:t})}function s(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/deletePicture",method:"post",data:t})}function n(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/save",method:"post",data:t})}function o(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/tree",method:"post",data:t})}function r(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/infoList",method:"post",data:t})}function c(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetycheckup/infoByOrganIdOne",method:"post",data:t})}function u(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/update",method:"post",data:t})}function d(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/getUserOrganByRoot",method:"post",data:t})}},ed02:function(t,e,i){"use strict";i.r(e);var l=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticStyle:{height:"30px"}},[i("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.goBack}})],1),t._v(" "),i("el-row",{attrs:{gutter:20}},[i("el-col",{attrs:{span:14}},[i("div",{staticClass:"div1"},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),i("el-col",{attrs:{span:10}},[i("div",{staticClass:"div1"},[i("div",{staticStyle:{"margin-bottom":"10px"}},["0"===t.show||"2"===t.show||"3"===t.show?i("el-button",{attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")]):t._e()],1),t._v(" "),i("div",{staticClass:"div2"},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-table",{key:t.tableKey,ref:"filetable",attrs:{data:t.fileList,border:"",fit:"",stripe:"","highlight-current-row":""},on:{"row-click":t.handleCurrent}},[i("el-table-column",{attrs:{label:"文件名",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(e){var l=e.row;return[i("span",[t._v(t._s(l.fileName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var l=e.row;return[i("span",[t._v(t._s(l.uploadDate))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var l=e.row;return[i("span",[t._v(t._s(l.createUsername))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var l=e.row;return["2"===t.show||"3"===t.show?i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleModifyStatus(l,"delete")}}},[t._v("删除")]):t._e(),t._v(" "),i("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(e){return t.handleModifyStatus(l,"down")}}},[t._v("下载")])]}}])})],1)],1)],1)])])],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile,"on-remove":t.removeFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传word、excel、ofd等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},a=[],s=i("7a03"),n={name:"DetailFiles",props:{info:{type:Object,default:function(){return{}}}},data:function(){return{show:this.$store.state.user.userInfo.adminFlag,tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token,id:this.info.id},fileUploadUrl:"/app/xlgl/xlglsafetyanalyse/uploadPicture",onlineFileUrl:"",fileList:[],uploadFileList:[]}},created:function(){this.getYaFileList()},methods:{getYaFileList:function(){var t=this,e={organId:this.info.organId,id:this.info.id};Object(s["f"])(e).then(function(e){if(t.fileList=e.data,t.fileList.length>0){t.$refs.filetable.setCurrentRow(t.fileList[0]);var i=t.fileList[0].fileName,l=i.substring(i.lastIndexOf(".")+1).toLocaleUpperCase();"PDF"===l?t.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileList[0].fileIds+"&access_token="+t.$store.state.user.token:t.$message({type:"info",message:"请下载对应的文件再进行查看！"})}})},handleCurrent:function(t){this.$refs.filetable.setCurrentRow(t);var e=t.fileName,i=e.substring(e.lastIndexOf(".")+1).toLocaleUpperCase();"PDF"===i?this.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileIds+"&access_token="+this.$store.state.user.token:this.$message({type:"info",message:"请下载对应的文件再进行查看！"})},handleModifyStatus:function(t,e){var i=this;"delete"===e?Object(s["a"])({ids:t.id}).then(function(t){0===t.data.code?i.$message({type:"success",message:"删除成功!",onClose:function(){i.getYaFileList()}}):i.$message({type:"info",message:t.data.msg})}):"down"===e&&(window.location.href="xlgl/xlglsafetyanalyse/downLoad?fileId="+t.fileIds+"&access_token="+this.$store.state.user.token)},openDialog:function(){this.fileDialog=!0},closeFileDialog:function(){this.uploadFileList=[],this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(t){var e=this;this.$root.$emit("uploadFileHandle",!0),this.fileData.fileIds=this.uploadFileList.join(","),Object(s["h"])(this.fileData).then(function(t){0===t.data.code?e.$notify({title:"提示",message:"上传成功！",type:"success",duration:1500,onClose:function(){e.getYaFileList(),e.closeFileDialog()}}):(e.$root.$emit("uploadFileHandle",!1),e.$notify({title:"提示",message:"保存失败!",duration:1500,type:"warning"}))})},successFile:function(t){this.$root.$emit("uploadFileHandle",!1),"0"===t.code&&t.fileId&&t.fileId.length>0?this.uploadFileList.push(t.fileId):this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},errorFile:function(){this.$root.$emit("uploadFileHandle",!1),this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},removeFile:function(t){var e=this.uploadFileList.indexOf(t.response.fileId);-1!==e&&this.uploadFileList.splice(e,1)},goBack:function(){this.$parent.detailFlag=!1}}},o=n,r=(i("194e"),i("2877")),c=Object(r["a"])(o,l,a,!1,null,"73db27f8",null);e["default"]=c.exports},f85b:function(t,e,i){}}]);