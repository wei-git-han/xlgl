(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7219d45a","chunk-505b0e33"],{"09f4":function(e,t,l){"use strict";l.d(t,"a",function(){return n}),Math.easeInOutQuad=function(e,t,l,i){return e/=i/2,e<1?l/2*e*e+t:(e--,-l/2*(e*(e-2)-1)+t)};var i=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(e){window.setTimeout(e,1e3/60)}}();function a(e){document.documentElement.scrollTop=e,document.body.parentNode.scrollTop=e,document.body.scrollTop=e}function s(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function n(e,t,l){var n=s(),o=e-n,r=20,u=0;t="undefined"===typeof t?500:t;var c=function e(){u+=r;var s=Math.easeInOutQuad(u,n,o,t);a(s),u<t?i(e):l&&"function"===typeof l&&l()};c()}},"0e80":function(e,t,l){"use strict";l.r(t);var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-row",{attrs:{gutter:20}},[l("el-col",{attrs:{span:16}},[l("div",{staticClass:"div1"},[l("iframe",{attrs:{src:e.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),e._v(" "),l("el-col",{attrs:{span:8}},[l("div",{staticClass:"div1"},[l("div",{staticClass:"div2"},[l("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[l("el-table",{key:e.tableKey,ref:"filetable",attrs:{data:e.fileList,border:"",fit:"","highlight-current-row":""},on:{"row-click":e.handleCurrent}},[l("el-table-column",{attrs:{label:"文件名",align:"center","min-width":"150px"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[l("span",[e._v(e._s(i.name))])]}}])}),e._v(" "),l("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[l("span",[e._v(e._s(i.examineSubjectName))])]}}])}),e._v(" "),l("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[l("span",[e._v(e._s(i.updateDate))])]}}])}),e._v(" "),l("el-table-column",{attrs:{label:"操作",width:"80px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[l("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleModifyStatus(i,"delete")}}},[e._v("下载")]),e._v(" "),l("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleModifyStatus(i,"delete")}}},[e._v("删除")])]}}])})],1)],1),e._v(" "),l("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.listQuery.page,limit:e.listQuery.limit},on:{"update:page":function(t){return e.$set(e.listQuery,"page",t)},"update:limit":function(t){return e.$set(e.listQuery,"limit",t)},pagination:e.getTestList}})],1)])])],1)],1)},a=[],s=l("b775");function n(e){return Object(s["a"])({url:"/app/xlgl/xlglrule/list",method:"post",data:e})}var o=l("333d"),r={name:"DetailLegalInfo",components:{Pagination:o["a"]},props:{fileList:{type:Array,default:function(){return[]}}},data:function(){return{tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token},fileUploadUrl:"",onlineFileUrl:"/app/pdf.js/web/viewer.html",listQuery:{type:"",page:1,limit:20}}},mounted:function(){this.$refs.filetable.setCurrentRow(this.fileList[0])},methods:{getLegalFileList:function(){var e=this;n(this.listQuery).then(function(t){e.fileList=t.data.list})},handleCurrent:function(e){this.$refs.filetable.setCurrentRow(e)},handleModifyStatus:function(e,t){var l=this;deleteFileById({ids:e.id}).then(function(e){0===e.data.code?l.$message({type:"success",message:"删除成功!",onClose:function(){l.getTestList()}}):l.$message({type:"info",message:e.data.msg})})}}},u=r,c=l("2877"),d=Object(c["a"])(u,i,a,!1,null,"5a6c3625",null);t["default"]=d.exports},"5f99":function(e,t,l){},b862:function(e,t,l){"use strict";l.r(t);var i=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-button",{staticStyle:{float:"right","margin-top":"5px",position:"absolute",right:"80px","z-index":"999"},attrs:{type:"success",size:"mini"},on:{click:e.openDialog}},[e._v("新增")]),e._v(" "),l("el-tabs",{staticClass:"legalTab",on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[l("el-tab-pane",{attrs:{label:"全军管理法规",name:"0"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1),e._v(" "),l("el-tab-pane",{attrs:{label:"装备发展管理法规",name:"1"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1),e._v(" "),l("el-tab-pane",{attrs:{label:"常用资料",name:"2"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1),e._v(" "),l("el-tab-pane",{attrs:{label:"其他法规",name:"3"}},[l("dlegalInfo",{attrs:{"file-list":e.fileList}})],1)],1),e._v(" "),l("el-dialog",{attrs:{title:"上传附件",visible:e.fileDialog,width:"40%","before-close":e.closeFileDialog},on:{"update:visible":function(t){e.fileDialog=t}}},[l("div",{staticClass:"centerPosition"},[l("el-form",{staticClass:"demo-form-inline questionForm",attrs:{inline:!0,size:"medium"}},[l("el-form-item",{attrs:{label:"资料类型选择：",required:""}},[l("el-select",{attrs:{placeholder:"请选择"},model:{value:e.selectValue,callback:function(t){e.selectValue=t},expression:"selectValue"}},e._l(e.options,function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1),e._v(" "),l("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:e.fileUploadUrl,data:e.fileData,"on-success":e.successFile1,"on-error":e.errorFile1}},[l("i",{staticClass:"el-icon-upload"}),e._v(" "),l("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),l("em",[e._v("点击上传")])]),e._v(" "),l("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("支持上传excel等格式")])])],1),e._v(" "),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:e.submitFile}},[e._v("确 定")]),e._v(" "),l("el-button",{on:{click:e.closeFileDialog}},[e._v("取 消")])],1)])],1)},a=[],s=(l("7f7f"),l("0e80")),n={name:"LegalIndex",components:{dlegalInfo:s["default"]},data:function(){return{activeName:"0",fileList:[],options:[{label:"全军管理法规",value:"0"},{label:"装备发展部管理法规",value:"1"},{label:"常用资料",value:"2"},{label:"其他法规",value:"3"}],fileUploadUrl:"",fileData:{access_token:this.$store.state.user.token},selectValue:"",fileDialog:!1,listQuery:{type:"",page:1,limit:20}}},created:function(){this.$set(this.listQuery,"type","0"),this.getLegalFileList()},methods:{handleClick:function(e,t){this.$set(this.listQuery,"type",e.name),this.getLegalFileList()},openDialog:function(){this.fileDialog=!0},submitFile:function(){this.$refs.upload.submit()},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},successFile1:function(e){var t=this;200===e.code||e.fileId?this.$message({type:"success",message:"上传成功!",onClose:function(){t.getTestList(),t.closeFileDialog()}}):this.$message({type:"info",message:e.msg})},errorFile1:function(){this.$message({type:"info",message:"上传失败！"})}}},o=n,r=(l("f323"),l("2877")),u=Object(r["a"])(o,i,a,!1,null,"6934327e",null);t["default"]=u.exports},f323:function(e,t,l){"use strict";var i=l("5f99"),a=l.n(i);a.a}}]);