(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-62c82b6c"],{"09f4":function(t,e,i){"use strict";i.d(e,"a",function(){return l}),Math.easeInOutQuad=function(t,e,i,a){return t/=a/2,t<1?i/2*t*t+e:(t--,-i/2*(t*(t-2)-1)+e)};var a=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function s(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function n(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function l(t,e,i){var l=n(),o=t-l,r=20,c=0;e="undefined"===typeof e?500:e;var u=function t(){c+=r;var n=Math.easeInOutQuad(c,l,o,e);s(n),c<e?a(t):i&&"function"===typeof i&&i()};u()}},4645:function(t,e,i){"use strict";var a=i("cd47"),s=i.n(a);s.a},c03e:function(t,e,i){"use strict";i.d(e,"b",function(){return s}),i.d(e,"a",function(){return n}),i.d(e,"c",function(){return l});var a=i("b775");function s(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function n(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/list",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/qxjUserInfoList",method:"post",data:t})}},cd47:function(t,e,i){},d91d:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),i("svg-icon",{staticClass:"icon btn1",attrs:{"icon-class":"goback"},on:{click:t.backFn}}),t._v(" "),t._m(0)],1),t._v(" "),i("div",{staticStyle:{"margin-top":"20px","border-radius":"5px","background-color":"#ffffff"}},[i("title-card",{attrs:{"title-text":t.cardTitle1}}),t._v(" "),i("el-button",{staticStyle:{float:"right","margin-top":"-40px","margin-right":"20px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFile}},[t._v("导出")]),t._v(" "),i("el-button",{staticStyle:{float:"right","margin-top":"-40px","margin-right":"100px"},attrs:{type:"primary",size:"mini"},on:{click:t.importFile}},[t._v("导入")]),t._v(" "),i("div",{staticStyle:{padding:"20px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:"","highlight-current-row":""},on:{"selection-change":t.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),t._v(" "),i("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),i("el-table-column",{attrs:{label:"姓名",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-popover",{attrs:{trigger:"hover",placement:"top"}},[i("p",[t._v("应休天数: "+t._s(e.row.id))]),t._v(" "),i("p",[t._v("未休天数: "+t._s(e.row.address))]),t._v(" "),i("p",[t._v("已休天数: "+t._s(e.row.address))]),t._v(" "),i("p",[t._v("请夹类型: "+t._s(e.row.address))]),t._v(" "),i("p",[t._v("起止时间: "+t._s(e.row.address))]),t._v(" "),i("div",{staticClass:"name-wrapper",attrs:{slot:"reference"},slot:"reference"},[i("el-tag",{attrs:{size:"medium"}},[t._v(t._s(e.row.id))])],1)])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"职务",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.id))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"座机号",width:"200px"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("span",[t._v(t._s(a.id))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"手机号",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.id))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"房间号","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("span",[t._v(t._s(a.id))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"部门","class-name":"status-col",width:"250"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("span",[t._v(t._s(a.id))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"在位情况","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[i("span",[t._v(t._s(a.id))])]}}])})],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)}}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"题目导入",visible:t.importFileDialog,width:"40%",accept:".xls,.xlsx","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.importFileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},s=[function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"div1"},[i("div",{staticClass:"hSty zwl"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            人员在位率\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            123\n          ")])])]),t._v(" "),i("div",{staticClass:"hSty bp"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            人员编配率\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            123\n          ")])])]),t._v(" "),i("div",{staticClass:"hSty qb"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            缺编（人）\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            123\n          ")])])]),t._v(" "),i("div",{staticClass:"hSty xj"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            人员休假完成率\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            123\n          ")])])])])}],n=i("c03e"),l=i("35b7"),o=i("333d"),r={name:"PersonStatusJu",components:{TitleCard:l["a"],Pagination:o["a"]},props:{id:{type:String,default:""}},data:function(){return{cardTitle:"单位人员情况",cardTitle1:"单位人员统计表",tableKey:0,list:[{id:"123"}],total:0,listLoading:!1,listQuery:{page:1,limit:20,organId:this.id},collectList:[],importFileDialog:!1,fileUploadUrl:"",fileData:{access_token:this.$store.state.user.token}}},created:function(){this.getTotalJu(),this.qxjUserInfoList()},methods:{getTotalJu:function(){var t={status:1};Object(n["b"])(t).then(function(t){})},qxjUserInfoList:function(){Object(n["c"])(this.listQuery).then(function(t){})},handleUpdate:function(t){this.$emit("openDetail","2",t)},handleSelectionChange:function(t){this.collectList=t},exportFile:function(){this.collectList.length<1&&this.$message({message:"请选择需要导出的数据",type:"info"})},importFile:function(){this.importFileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.importFileDialog=!1},submitFile:function(){this.$refs.upload.submit()},successFile:function(){var t=this;this.$message({type:"success",message:"上传成功!",onClose:function(){t.closeFileDialog()}})},errorFile:function(){this.$message({type:"info",message:"上传失败！"})},backFn:function(){this.$emit("openDetail","1")}}},c=r,u=(i("4645"),i("2877")),d=Object(u["a"])(c,a,s,!1,null,"9efc727c",null);e["default"]=d.exports}}]);