(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f8059498"],{"09f4":function(t,a,e){"use strict";e.d(a,"a",function(){return o}),Math.easeInOutQuad=function(t,a,e,i){return t/=i/2,t<1?e/2*t*t+a:(t--,-e/2*(t*(t-2)-1)+a)};var i=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function l(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function n(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function o(t,a,e){var o=n(),s=t-o,d=20,r=0;a="undefined"===typeof a?500:a;var c=function t(){r+=d;var n=Math.easeInOutQuad(r,o,s,a);l(n),r<a?i(t):e&&"function"===typeof e&&e()};c()}},"35d4":function(t,a,e){"use strict";var i=e("d96e"),l=e.n(i);l.a},7769:function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"app-container"},[e("div",{staticClass:"app-content"},[e("title-card",{attrs:{"title-text":t.title}}),t._v(" "),e("el-button",{staticStyle:{float:"right",margin:"-40px 20px 0 30px"},attrs:{type:"primary",size:"mini"}},[t._v("导出")]),t._v(" "),e("el-button",{staticStyle:{float:"right",margin:"-40px 120px 0 30px"},attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("导入")]),t._v(" "),e("el-row",{staticStyle:{padding:"20px"},attrs:{gutter:20}},[e("el-col",{attrs:{span:15}},[e("div",{staticClass:"div1"},[e("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),e("el-col",{attrs:{span:9}},[e("div",{staticClass:"div1"},[e("div",{staticClass:"div2"},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[e("el-table",{key:t.tableKey,attrs:{data:t.fileList,border:"",fit:"","highlight-current-row":""},on:{"row-click":t.handleCurrent}},[e("el-table-column",{attrs:{label:"文件名称",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("span",[t._v(t._s(i.examineName))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("span",[t._v(t._s(i.examineSubjectName))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("span",[t._v(t._s(i.updateDate))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"操作",width:"120px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return t.handleModifyStatus(i,"delete")}}},[t._v("删除")]),t._v(" "),e("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){return t.handleModifyStatus(i,"down")}}},[t._v("下载")])]}}])})],1)],1),t._v(" "),e("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(a){return t.$set(t.listQuery,"page",a)},"update:limit":function(a){return t.$set(t.listQuery,"limit",a)},pagination:t.getTestList}})],1)])])],1),t._v(" "),e("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(a){t.fileDialog=a}}},[e("div",{staticClass:"centerPosition"},[e("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[e("i",{staticClass:"el-icon-upload"}),t._v(" "),e("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),e("em",[t._v("点击上传")])]),t._v(" "),e("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传word、excel、ofd等格式")])])],1),t._v(" "),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),e("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)])},l=[],n=e("b775");function o(t){return Object(n["a"])({url:"/app/xlgl/xlglzbgl/list",method:"post",data:t})}var s=e("35b7"),d=e("333d"),r={name:"EquipIndex",components:{TitleCard:s["a"],Pagination:d["a"]},data:function(){return{title:"单位通用装备实力统计表",listQuery:{page:1,limit:20},total:0,listLoading:!1,tableKey:0,fileList:null,fileDialog:!1,fileData:{access_token:this.$store.state.user.token},fileUploadUrl:"app/xlgl/xlglzbgl/save",onlineFileUrl:"/app/openFile/demo.html",demoTableData:[{title:"《关于的伤口范德萨是否快递路上的革命是多么》",allPages:5,typeList:[{title:"轻武器",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]},{title:"单位自查",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]}]},{title:"《关于的伤口范德萨是否快递路上的革命是多么》",allPages:5,typeList:[{title:"动员部署",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]},{title:"单位自查",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]}]}]}},mounted:function(){this.$refs.filetable.setCurrentRow(this.fileList[0])},methods:{getZbFileList:function(){var t=this;this.listLoading=!0,o(this.listQuery).then(function(a){t.fileList=a.data.page.list,t.total=a.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1500)})},openDialog:function(){this.fileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){this.$refs.upload.submit()},successFile:function(t){var a=this;0===t.code?this.$message({type:"success",message:"上传成功!",onClose:function(){a.getZbFileList(),a.closeFileDialog()}}):this.$message({type:"info",message:t.msg})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})}}},c=r,u=(e("35d4"),e("2877")),p=Object(u["a"])(c,i,l,!1,null,"07aa7260",null);a["default"]=p.exports},d96e:function(t,a,e){}}]);