(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b60c42e4"],{"4dcc":function(t,a,e){},"538b":function(t,a,e){"use strict";var i=e("4dcc"),l=e.n(i);l.a},7769:function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"app-container"},[e("div",{staticClass:"app-content"},[e("title-card",{attrs:{"title-text":t.title}}),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("el-button",{staticStyle:{float:"right",margin:"-40px 120px 0 30px"},attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("导入")]):t._e(),t._v(" "),e("el-row",{staticStyle:{padding:"20px"},attrs:{gutter:20}},[e("el-col",{attrs:{span:15}},[e("div",{staticClass:"div1"},[e("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),e("el-col",{attrs:{span:9}},[e("div",{staticClass:"div1"},[e("div",{staticClass:"div2"},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[e("el-table",{key:t.tableKey,ref:"filetable",attrs:{data:t.fileList,border:"",fit:"","highlight-current-row":""},on:{"row-click":t.handleCurrent}},[e("el-table-column",{attrs:{label:"文件名称",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("span",[t._v(t._s(i.fileName))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("span",[t._v(t._s(i.createdTime))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("span",[t._v(t._s(i.creator))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"操作",width:"120px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var i=a.row;return[e("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){return a.stopPropagation(),t.handleModifyStatus(i,"down")}}},[t._v("下载")])]}}])})],1)],1)],1)])])],1),t._v(" "),e("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(a){t.fileDialog=a}}},[e("div",{staticClass:"centerPosition"},[e("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[e("i",{staticClass:"el-icon-upload"}),t._v(" "),e("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),e("em",[t._v("点击上传")])]),t._v(" "),e("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传word、excel、ofd等格式")])])],1),t._v(" "),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),e("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)])},l=[],s=e("b775");function d(t){return Object(s["a"])({url:"/app/xlgl/xlglzbgl/getFileList",method:"post",data:t})}var o=e("35b7"),n={name:"EquipIndex",components:{TitleCard:o["a"]},data:function(){return{title:"单位通用装备实力统计表",show:this.$store.state.user.userInfo.adminFlag,listQuery:{page:1,limit:20},total:0,listLoading:!1,tableKey:0,fileList:[],fileDialog:!1,fileData:{access_token:this.$store.state.user.token},fileUploadUrl:"/app/xlgl/xlglzbgl/uploadFile",onlineFileUrl:"",demoTableData:[{title:"《关于的伤口范德萨是否快递路上的革命是多么》",allPages:5,typeList:[{title:"轻武器",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]},{title:"单位自查",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]}]},{title:"《关于的伤口范德萨是否快递路上的革命是多么》",allPages:5,typeList:[{title:"动员部署",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]},{title:"单位自查",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]}]}]}},created:function(){this.getZbFileList()},mounted:function(){},methods:{handleCurrent:function(t){this.$refs.filetable.setCurrentRow(t),this.onlineFileUrl="/app/openFile/demo.html?fileId="+t.infoId+"&access_token="+this.$store.state.user.token},getZbFileList:function(){var t=this;this.listLoading=!0,d(this.listQuery).then(function(a){t.fileList=a.data.list,t.fileList.length>0&&(t.$refs.filetable.setCurrentRow(t.fileList[0]),t.onlineFileUrl="/app/openFile/demo.html?fileId="+t.fileList[0].fileId+"&access_token="+t.$store.state.user.token),setTimeout(function(){t.listLoading=!1},200)})},openDialog:function(){this.onlineFileUrl="",this.fileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){this.$root.$emit("uploadFileHandle",!0),this.$refs.upload.submit()},successFile:function(t){var a=this;this.$root.$emit("uploadFileHandle",!1),t.fileId&&t.fileId.length>0?this.$notify({title:"提示",message:"上传成功！",type:"success",duration:1500,onClose:function(){a.getZbFileList(),a.closeFileDialog()}}):this.$notify({title:"提示",message:t.msg,duration:1500,type:"warning"})},errorFile:function(){this.$root.$emit("uploadFileHandle",!1),this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},handleModifyStatus:function(t,a){"down"===a&&(window.location.href="xlgl/xlglcarsmanager/downLoadFile?fileId="+t.fileId+"&access_token="+this.$store.state.user.token)}}},r=n,c=(e("538b"),e("2877")),u=Object(c["a"])(r,i,l,!1,null,"62f94f1a",null);a["default"]=u.exports}}]);