(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d139bb8a"],{"7a03":function(e,t,s){"use strict";s.d(t,"d",function(){return a}),s.d(t,"a",function(){return l}),s.d(t,"b",function(){return n}),s.d(t,"e",function(){return o}),s.d(t,"c",function(){return r});var i=s("b775");function a(e){return Object(i["a"])({url:"/app/xlgl/xlglsafetyanalyse/list",method:"post",data:e})}function l(e){return Object(i["a"])({url:"/app/xlgl/xlglsafetyanalyse/deletePicture",method:"post",data:e})}function n(e){return Object(i["a"])({url:"/app/xlgl/xlglsafetyanalyse/tree",method:"post",data:e})}function o(e){return Object(i["a"])({url:"/app/xlgl/xlglsafetyanalyse/infoList",method:"post",data:e})}function r(e){return Object(i["a"])({url:"/app/xlgl/xlglsafetycheckup/infoByOrganIdOne",method:"post",data:e})}},dd39f:function(e,t,s){},dd83:function(e,t,s){"use strict";var i=s("dd39f"),a=s.n(i);a.a},ed02:function(e,t,s){"use strict";s.r(t);var i=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"app-container"},[s("div",{staticStyle:{height:"30px"}},[s("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:e.goBack}})],1),e._v(" "),s("el-row",{attrs:{gutter:20}},[s("el-col",{attrs:{span:14}},[s("div",{staticClass:"div1"},[s("iframe",{attrs:{src:e.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),e._v(" "),s("el-col",{attrs:{span:10}},[s("div",{staticClass:"div1"},[s("div",{staticStyle:{"margin-bottom":"10px"}},[0===e.show||2===e.show||3===e.show?s("el-button",{attrs:{type:"success",size:"mini"},on:{click:e.openDialog}},[e._v("上传")]):e._e()],1),e._v(" "),s("div",{staticClass:"div2"},[s("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[s("el-table",{key:e.tableKey,ref:"filetable",attrs:{data:e.fileList,border:"",fit:"",stripe:"","highlight-current-row":""},on:{"row-click":e.handleCurrent}},[s("el-table-column",{attrs:{label:"文件名",align:"center","min-width":"150px"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[s("span",[e._v(e._s(i.fileName))])]}}])}),e._v(" "),s("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[s("span",[e._v(e._s(i.uploadDate))])]}}])}),e._v(" "),s("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[s("span",[e._v(e._s(i.createUsername))])]}}])}),e._v(" "),s("el-table-column",{attrs:{label:"操作",width:"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[2===e.show||3===e.show?s("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleModifyStatus(i,"delete")}}},[e._v("删除")]):e._e(),e._v(" "),s("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(t){return e.handleModifyStatus(i,"down")}}},[e._v("下载")])]}}])})],1)],1)],1)])])],1),e._v(" "),s("el-dialog",{attrs:{title:"上传附件",visible:e.fileDialog,width:"40%","before-close":e.closeFileDialog},on:{"update:visible":function(t){e.fileDialog=t}}},[s("div",{staticClass:"centerPosition"},[s("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:e.fileUploadUrl,data:e.fileData,"on-success":e.successFile,"on-error":e.errorFile}},[s("i",{staticClass:"el-icon-upload"}),e._v(" "),s("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),s("em",[e._v("点击上传")])]),e._v(" "),s("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("支持上传word、excel、ofd等格式")])])],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{type:"primary"},on:{click:e.submitFile}},[e._v("确 定")]),e._v(" "),s("el-button",{on:{click:e.closeFileDialog}},[e._v("取 消")])],1)])],1)},a=[],l=s("7a03"),n={name:"DetailFiles",props:{info:{type:Object,default:function(){return{}}}},data:function(){return{show:this.$store.state.user.userInfo.adminFlag,tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token,id:this.info.id},fileUploadUrl:"/app/xlgl/xlglsafetyanalyse/uploadPicture",onlineFileUrl:"",fileList:[]}},created:function(){this.getYaFileList()},methods:{getYaFileList:function(){var e=this,t={organId:this.info.organId,id:this.info.id};Object(l["e"])(t).then(function(t){if(e.fileList=t.data,e.fileList.length>0){e.$refs.filetable.setCurrentRow(e.fileList[0]);var s=e.fileList[0].fileName,i=s.substring(s.lastIndexOf(".")+1).toLocaleUpperCase();"PDF"===i?e.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+e.fileList[0].fileIds+"&access_token="+e.$store.state.user.token:e.$message({type:"info",message:"请下载对应的文件再进行查看！"})}})},handleCurrent:function(e){this.$refs.filetable.setCurrentRow(e);var t=e.fileName,s=t.substring(t.lastIndexOf(".")+1).toLocaleUpperCase();"PDF"===s?this.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+e.infoId+"&access_token="+this.$store.state.user.token:this.$message({type:"info",message:"请下载对应的文件再进行查看！"})},handleModifyStatus:function(e,t){var s=this;"delete"===t?Object(l["a"])({ids:e.id}).then(function(e){0===e.data.code?s.$message({type:"success",message:"删除成功!",onClose:function(){s.getYaFileList()}}):s.$message({type:"info",message:e.data.msg})}):"down"===t&&(window.location.href="app/xlgl/xlglsafetyanalyse/downLoad?fileId="+e.fileIds+"&access_token="+this.$store.state.user.token)},openDialog:function(){this.fileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){this.$refs.upload.submit()},successFile:function(e){var t=this;"0"===e.code?this.$message({type:"success",message:"上传成功!",onClose:function(){t.getYaFileList(),t.closeFileDialog()}}):this.$message({type:"info",message:"上传失败!"})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},goBack:function(){this.$parent.detailFlag=!1}}},o=n,r=(s("dd83"),s("2877")),c=Object(r["a"])(o,i,a,!1,null,"5a5b23db",null);t["default"]=c.exports}}]);