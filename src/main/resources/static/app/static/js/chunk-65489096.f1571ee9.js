(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-65489096","chunk-1b884c8b"],{"3aaa":function(t,e,i){},"7a03":function(t,e,i){"use strict";i.d(e,"d",function(){return l}),i.d(e,"a",function(){return s}),i.d(e,"f",function(){return n}),i.d(e,"b",function(){return o}),i.d(e,"e",function(){return r}),i.d(e,"c",function(){return c}),i.d(e,"g",function(){return u});var a=i("b775");function l(t){return Object(a["a"])({url:"/app/xlgl/xlglsafetyanalyse/list",method:"post",data:t})}function s(t){return Object(a["a"])({url:"/app/xlgl/xlglsafetyanalyse/deletePicture",method:"post",data:t})}function n(t){return Object(a["a"])({url:"/app/xlgl/xlglsafetyanalyse/save",method:"post",data:t})}function o(t){return Object(a["a"])({url:"/app/xlgl/xlglsafetyanalyse/tree",method:"post",data:t})}function r(t){return Object(a["a"])({url:"/app/xlgl/xlglsafetyanalyse/infoList",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglsafetycheckup/infoByOrganIdOne",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglsafetyanalyse/update",method:"post",data:t})}},"9a28":function(t,e,i){},da66:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[t.detailFlag?t._e():i("div",[i("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),"0"===t.show||"2"===t.show||"3"===t.show?i("el-button",{staticStyle:{float:"right",margin:"-40px 30px 0 30px"},attrs:{type:"success",size:"mini"},on:{click:t.openFileDialog}},[t._v("上传")]):t._e(),t._v(" "),i("el-select",{staticStyle:{float:"right",margin:"-40px 150px 0 0"},attrs:{placeholder:"请选择极度",size:"small"},on:{change:t.selectChange},model:{value:t.listQuery.quarter,callback:function(e){t.$set(t.listQuery,"quarter",e)},expression:"listQuery.quarter"}},[i("el-option",{attrs:{value:"1",label:"第一季度（1月、2月、3月）"}},[t._v("第一季度（1月、2月、3月）")]),t._v(" "),i("el-option",{attrs:{value:"2",label:"第二季度（4月、5月、6月）"}},[t._v("第二季度（4月、5月、6月）")]),t._v(" "),i("el-option",{attrs:{value:"3",label:"第三季度（7月、8月、9月）"}},[t._v("第三季度（7月、8月、9月）")]),t._v(" "),i("el-option",{attrs:{value:"4",label:"第四季度（10月、11月、12月）"}},[t._v("第四季度（10月、11月、12月）")])],1),t._v(" "),i("div",{staticStyle:{height:"calc(100vh - 240px)"}},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:"",stripe:!0,"highlight-current-row":""}},[i("el-table-column",{attrs:{label:"单位名称","min-width":"300",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("div",{staticStyle:{cursor:"pointer"},attrs:{title:a.organName},on:{click:function(e){return t.openDetailPaper(a)}}},[t._v(t._s(a.organName))])]}}],null,!1,837787893)}),t._v(" "),i("el-table-column",{attrs:{label:"文件主题",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.content))])]}}],null,!1,3823322255)}),t._v(" "),i("el-table-column",{attrs:{label:"上传时间",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.updateDate))])]}}],null,!1,3297142691)}),t._v(" "),i("el-table-column",{attrs:{label:"上传人",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.createUsername))])]}}],null,!1,3256479092)}),t._v(" "),i("el-table-column",{attrs:{label:"上传状态",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(t._f("statusFilter")(e.row.status)))])]}}],null,!1,3239357375)})],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getSearchList}})],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("el-form",{staticClass:"oraganForm",attrs:{"label-width":"180px",inline:!0}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"单位名称：",required:""}},[i("el-input",{attrs:{readonly:""},model:{value:t.listQuery.depart,callback:function(e){t.$set(t.listQuery,"depart",e)},expression:"listQuery.depart"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"主题",required:""}},[i("el-input",{model:{value:t.listQuery.content,callback:function(e){t.$set(t.listQuery,"content",e)},expression:"listQuery.content"}})],1)],1)],1)],1),t._v(" "),i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传word、excel、ofd等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)],1),t._v(" "),t.detailFlag?i("detail-file",{attrs:{info:t.info}}):t._e()],1)},l=[],s=i("35b7"),n=i("ed02"),o=i("333d"),r=i("7a03"),c={name:"SafetySpecification",components:{TitleCard:s["a"],detailFile:n["default"],Pagination:o["a"]},filters:{statusFilter:function(t){return 0===t?"未上传":"已上传"}},data:function(){return{cardTitle:"安全分析与预案",show:this.$store.state.user.userInfo.adminFlag,fileDialog:!1,detailFlag:!1,listQuery:{quarter:"1",depart:this.$store.state.user.userInfo.orgName,content:"",page:1,limit:20},tableKey:0,list:null,total:0,listLoading:!1,fileUploadUrl:"/app/xlgl/xlglsafetyanalyse/uploadPicture",fileData:{access_token:this.$store.state.user.token,content:""},info:null,fileList:[]}},created:function(){this.getSearchList();var t=(new Date).getMonth()+1;1===t||2===t||3===t?this.listQuery.quarter="1":4===t||5===t||6===t?this.listQuery.quarter="2":7===t||8===t||9===t?this.listQuery.quarter="3":10!==t&&11!==t&&12!==t||(this.listQuery.quarter="4")},methods:{getSearchList:function(){var t=this;this.listLoading=!0,Object(r["d"])(this.listQuery).then(function(e){t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},selectChange:function(){this.getSearchList()},openFileDialog:function(){this.fileDialog=!0},closeFileDialog:function(){this.listQuery.content="",this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){var t=this;if(this.fileData.content=this.listQuery.content,this.fileData.content){var e={content:this.listQuery.content,organName:this.listQuery.depart,organId:this.$store.state.user.userInfo.organId,fileIds:this.fileList.join(",")};Object(r["f"])(e).then(function(e){t.$message({type:"success",message:"上传成功!",onClose:function(){t.getSearchList(),t.closeFileDialog()}})})}else this.$message({type:"warning",message:"请填写主题!"})},successFile:function(t){t.fileId&&t.fileId.length>0?this.fileList.push(t.fileId):this.$message({type:"info",message:"上传失败!"})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},openDetailPaper:function(t){this.detailFlag=!0,this.info=t}}},u=c,d=(i("f7c5"),i("2877")),f=Object(d["a"])(u,a,l,!1,null,"8a22ce34",null);e["default"]=f.exports},ed02:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticStyle:{height:"30px"}},[i("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.goBack}})],1),t._v(" "),i("el-row",{attrs:{gutter:20}},[i("el-col",{attrs:{span:14}},[i("div",{staticClass:"div1"},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),i("el-col",{attrs:{span:10}},[i("div",{staticClass:"div1"},[i("div",{staticStyle:{"margin-bottom":"10px"}},["0"===t.show||"2"===t.show||"3"===t.show?i("el-button",{attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")]):t._e()],1),t._v(" "),i("div",{staticClass:"div2"},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[i("el-table",{key:t.tableKey,ref:"filetable",attrs:{data:t.fileList,border:"",fit:"",stripe:"","highlight-current-row":""},on:{"row-click":t.handleCurrent}},[i("el-table-column",{attrs:{label:"文件名",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("span",[t._v(t._s(a.fileName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("span",[t._v(t._s(a.uploadDate))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("span",[t._v(t._s(a.createUsername))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return["2"===t.show||"3"===t.show?i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleModifyStatus(a,"delete")}}},[t._v("删除")]):t._e(),t._v(" "),i("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(e){return t.handleModifyStatus(a,"down")}}},[t._v("下载")])]}}])})],1)],1)],1)])])],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传word、excel、ofd等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},l=[],s=i("7a03"),n={name:"DetailFiles",props:{info:{type:Object,default:function(){return{}}}},data:function(){return{show:this.$store.state.user.userInfo.adminFlag,tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token,id:this.info.id},fileUploadUrl:"/app/xlgl/xlglsafetyanalyse/uploadPicture",onlineFileUrl:"",fileList:[],uploadFileList:[]}},created:function(){this.getYaFileList()},methods:{getYaFileList:function(){var t=this,e={organId:this.info.organId,id:this.info.id};Object(s["e"])(e).then(function(e){if(t.fileList=e.data,t.fileList.length>0){t.$refs.filetable.setCurrentRow(t.fileList[0]);var i=t.fileList[0].fileName,a=i.substring(i.lastIndexOf(".")+1).toLocaleUpperCase();"PDF"===a?t.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileList[0].fileIds+"&access_token="+t.$store.state.user.token:t.$message({type:"info",message:"请下载对应的文件再进行查看！"})}})},handleCurrent:function(t){this.$refs.filetable.setCurrentRow(t);var e=t.fileName,i=e.substring(e.lastIndexOf(".")+1).toLocaleUpperCase();"PDF"===i?this.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileIds+"&access_token="+this.$store.state.user.token:this.$message({type:"info",message:"请下载对应的文件再进行查看！"})},handleModifyStatus:function(t,e){var i=this;"delete"===e?Object(s["a"])({ids:t.id}).then(function(t){0===t.data.code?i.$message({type:"success",message:"删除成功!",onClose:function(){i.getYaFileList()}}):i.$message({type:"info",message:t.data.msg})}):"down"===e&&(window.location.href="xlgl/xlglsafetyanalyse/downLoad?fileId="+t.fileIds+"&access_token="+this.$store.state.user.token)},openDialog:function(){this.fileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(t){var e=this;this.fileData.fileIds=this.uploadFileList.join(","),Object(s["g"])(this.fileData).then(function(t){0===t.data.code?e.$message({type:"success",message:"上传成功!",onClose:function(){e.getYaFileList(),e.closeFileDialog()}}):e.$message({type:"info",message:"保存失败!"})})},successFile:function(t){"0"===t.code&&t.fileId&&t.fileId.length>0?this.uploadFileList.push(t.fileId):this.$message({type:"info",message:"上传失败!"})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},goBack:function(){this.$parent.detailFlag=!1}}},o=n,r=(i("fbd5"),i("2877")),c=Object(r["a"])(o,a,l,!1,null,"1d458549",null);e["default"]=c.exports},f7c5:function(t,e,i){"use strict";var a=i("3aaa"),l=i.n(a);l.a},fbd5:function(t,e,i){"use strict";var a=i("9a28"),l=i.n(a);l.a}}]);