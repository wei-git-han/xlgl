(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-009a4aee"],{"0853":function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"app-container"},[e("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),e("el-button",{staticStyle:{float:"right",margin:"-40px 20px 0 30px"},attrs:{type:"primary",size:"mini"},on:{click:function(a){return t.handleModifyStatus("down","1")}}},[t._v("导出")]),t._v(" "),"0"===t.show||"2"===t.show||"3"===t.show?e("el-button",{staticStyle:{float:"right",margin:"-40px 120px 0 30px"},attrs:{type:"success",size:"mini"},on:{click:t.openFileDialog}},[t._v("导入")]):t._e(),t._v(" "),e("el-row",{staticStyle:{"margin-top":"10px"},attrs:{gutter:20}},[e("el-col",{staticStyle:{height:"calc(100vh - 160px)",overflow:"hidden"},attrs:{span:6}},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[e("el-tree",{ref:"tree",attrs:{data:t.treeData,props:t.defaultProps,"default-expanded-keys":t.defaultExpand,"node-key":"id"},on:{"node-click":t.handleNodeClick},scopedSlots:t._u([{key:"default",fn:function(a){var l=a.node;return e("span",{staticClass:"custom-tree-node"},[e("span",[t._v(t._s(l.label))])])}}])})],1)],1),t._v(" "),t.fileList.length>0?e("el-col",{staticStyle:{height:"calc(100vh - 160px)",overflow:"hidden"},attrs:{span:t.spanNum}},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[e("el-table",{key:t.tableKey,ref:"filetable",attrs:{data:t.fileList,border:"",fit:"",stripe:"","highlight-current-row":""}},[e("el-table-column",{attrs:{label:"文件名",fixed:"left",align:"center","min-width":"400px"},scopedSlots:t._u([{key:"default",fn:function(a){var l=a.row;return[e("span",[t._v(t._s(l.fileName))])]}}],null,!1,4139281861)}),t._v(" "),e("el-table-column",{attrs:{label:"上传时间",width:"350px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var l=a.row;return[e("span",[t._v(t._s(l.updateDateStr))])]}}],null,!1,1334416628)}),t._v(" "),e("el-table-column",{attrs:{label:"上传人",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var l=a.row;return[e("span",[t._v(t._s(l.createUserName))])]}}],null,!1,3618791478)}),t._v(" "),e("el-table-column",{attrs:{label:"操作",width:"100px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){var l=a.row;return[e("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){return a.stopPropagation(),t.handleModifyStatus("down",l)}}},[t._v("下载")])]}}],null,!1,271078169)})],1)],1)],1):t._e(),t._v(" "),0===t.fileList.length?e("el-col",{staticStyle:{height:"calc(100vh - 200px)",overflow:"hidden"},attrs:{span:t.spanNum}},[e("div",{staticClass:"div1",staticStyle:{height:"100%"}},[e("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]):t._e()],1),t._v(" "),e("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(a){t.fileDialog=a}}},[e("el-form",{staticClass:"oraganForm",attrs:{"label-width":"180px",inline:!0}},[e("el-row",[e("el-col",{attrs:{span:24}},[e("el-form-item",{attrs:{label:"发布单位："}},[e("el-input",{attrs:{readonly:""},model:{value:t.temp.departName,callback:function(a){t.$set(t.temp,"departName",a)},expression:"temp.departName"}})],1)],1)],1)],1),t._v(" "),e("div",{staticClass:"centerPosition"},[e("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile,limit:1}},[e("i",{staticClass:"el-icon-upload"}),t._v(" "),e("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),e("em",[t._v("点击上传")])]),t._v(" "),e("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传word、excel、ofd等格式")])])],1),t._v(" "),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),e("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)],1)],1)},s=[],i=e("35b7"),n=e("7a03"),d={name:"ComplexTable",filters:{fileType:function(t){var a="";switch(t){case"1":a="单选";break;case"2":a="单选";break;case"3":a="单选";break;case"4":a="单选";break}return a}},components:{TitleCard:i["a"]},data:function(){return{cardTitle:"安全检查情况",fileDialog:!1,treeData:[],defaultProps:{children:"children",label:"text"},tableKey:0,list:null,total:0,listLoading:!1,fileData:{access_token:this.$store.state.user.token,orgId:""},fileUploadUrl:"/app/xlgl/xlglsafetyanalyse/upload",fileList:[],temp:{departId:"",departName:""},defaultExpand:[],organId:"",orgName:"",show:this.$store.state.user.userInfo.adminFlag,onlineFileUrl:"",spanNum:18,demoTableData:[{title:"《关于的伤口范德萨是否快递路上的革命是多么》",allPages:5,typeList:[{title:"动员部署",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]},{title:"单位自查",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]}]},{title:"《关于的伤口范德萨是否快递路上的革命是多么》",allPages:5,typeList:[{title:"动员部署",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]},{title:"单位自查",children:[{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"},{data1:"1",data2:"2",data3:"3",data4:"4",data5:"5",data6:"3",data7:"4",data8:"5",data9:"8"}]}]}]}},watch:{listQuery:{handler:function(t){},deep:!0}},created:function(){this.getUserOrganByRoot(),this.getDepartTree()},methods:{getDepartTree:function(){var t=this;Object(n["b"])().then(function(a){t.treeData=a.data.children,t.$nextTick(function(){this.treeData.length>=1&&(this.temp.departId=this.organId,this.temp.departName=this.orgName,this.$refs.tree.setCurrentKey(this.organId),this.defaultExpand=[this.organId],this.getInfoByOrganIdOne())})})},openFileDialog:function(){this.temp.departId.length>1?this.organId===this.temp.departId?this.fileDialog=!0:this.$message({type:"info",message:"只能上传本局文件，请选择您本局!"}):this.$message({type:"info",message:"请先选择需要上传文件的局!"})},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){this.fileData.orgId=this.temp.departId,this.$refs.upload.submit()},successFile:function(t){var a=this;"0"===t.code?this.$message({type:"success",message:"上传成功!",onClose:function(){a.closeFileDialog(),a.getInfoByOrganIdOne()}}):this.$message({type:"info",message:t.msg})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},handleNodeClick:function(t,a){this.temp.departId=t.id,this.temp.departName=t.text,this.getInfoByOrganIdOne()},getInfoByOrganIdOne:function(){var t=this,a={organId:this.temp.departId};Object(n["c"])(a).then(function(a){t.onlineFileUrl="",t.fileList=[];var e=a.data.xlglSafetyCheckup;if("0"===a.data.code){var l=e.fileName,s=l.substring(l.lastIndexOf(".")+1).toLocaleUpperCase();"PDF"===s?t.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+e.fileId+"&access_token="+t.$store.state.user.token:(t.fileList=[a.data.xlglSafetyCheckup],t.$message({type:"info",message:"请下载对应的文件再进行查看！"}))}else t.$message({type:"info",message:"无文件，不能下载！"})})},handleModifyStatus:function(t,a){var e=this;if("1"===a)if(this.temp.departId.length>1){var l={organId:this.temp.departId};Object(n["c"])(l).then(function(t){var a=t.data.xlglSafetyCheckup;a?window.location.href="xlgl/xlglsafetyanalyse/downLoad?fileId="+a.fileId+"&access_token="+e.$store.state.user.token:e.$message({type:"info",message:"该局无附件!"})})}else this.$message({type:"info",message:"请先选择需要导出文件的局!"});else window.location.href="xlgl/xlglsafetyanalyse/downLoad?fileId="+a.fileId+"&access_token="+this.$store.state.user.token},getUserOrganByRoot:function(){var t=this;Object(n["e"])().then(function(a){t.organId=a.data.organId,t.orgName=a.data.organName})}}},o=d,r=(e("eb5c"),e("2877")),c=Object(r["a"])(o,l,s,!1,null,"2906894a",null);a["default"]=c.exports},"7a03":function(t,a,e){"use strict";e.d(a,"d",function(){return s}),e.d(a,"a",function(){return i}),e.d(a,"g",function(){return n}),e.d(a,"b",function(){return d}),e.d(a,"f",function(){return o}),e.d(a,"c",function(){return r}),e.d(a,"h",function(){return c}),e.d(a,"e",function(){return u});var l=e("b775");function s(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/list",method:"post",data:t})}function i(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/deletePicture",method:"post",data:t})}function n(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/save",method:"post",data:t})}function d(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/tree",method:"post",data:t})}function o(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/infoList",method:"post",data:t})}function r(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetycheckup/infoByOrganIdOne",method:"post",data:t})}function c(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/update",method:"post",data:t})}function u(t){return Object(l["a"])({url:"/app/xlgl/xlglsafetyanalyse/getUserOrganByRoot",method:"post",data:t})}},"8c98":function(t,a,e){},eb5c:function(t,a,e){"use strict";var l=e("8c98"),s=e.n(l);s.a}}]);