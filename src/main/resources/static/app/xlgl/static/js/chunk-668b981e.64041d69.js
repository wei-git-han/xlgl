(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-668b981e"],{"09f4":function(t,e,a){"use strict";a.d(e,"a",function(){return l}),Math.easeInOutQuad=function(t,e,a,i){return t/=i/2,t<1?a/2*t*t+e:(t--,-a/2*(t*(t-2)-1)+e)};var i=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function o(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function n(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function l(t,e,a){var l=n(),s=t-l,r=20,u=0;e="undefined"===typeof e?500:e;var c=function t(){u+=r;var n=Math.easeInOutQuad(u,l,s,e);o(n),u<e?i(t):a&&"function"===typeof a&&a()};c()}},c963:function(t,e,a){"use strict";var i=a("cf88"),o=a.n(i);o.a},cf88:function(t,e,a){},f31f:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("el-button",{staticClass:"btnPosition",attrs:{type:"primary"},on:{click:t.addTest}},[t._v("创建题库类型")]),t._v(" "),a("el-scrollbar",[a("el-tree",{attrs:{data:t.treeData,props:t.defaultProps,"default-expand-all":"","node-key":"id"},on:{"node-click":t.handleNodeClick},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.node,o=e.data;return a("span",{staticClass:"custom-tree-node"},[a("span",[t._v(t._s(i.label))]),t._v(" "),i.isLeaf?a("span",[a("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(){return t.remove(i,o)}}},[t._v("\n                Delete\n              ")])],1):t._e()])}}])})],1)],1),t._v(" "),a("el-col",{attrs:{span:18}},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.listQuery,size:"medium"}},[a("el-form-item",[a("el-input",{attrs:{placeholder:"请输入查询内容"},model:{value:t.listQuery.subjectName,callback:function(e){t.$set(t.listQuery,"subjectName",e)},expression:"listQuery.subjectName"}})],1),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.onSubmit}},[t._v("搜索")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:t.downLoadFormWork}},[t._v("模板下载")]),t._v(" "),a("el-upload",{staticClass:"upload-demo",attrs:{multiple:!1,"with-credentials":!0,action:t.fileUploadUrl}},[a("el-button",{attrs:{type:"primary"}},[t._v("题目导入")])],1)],1)],1),t._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:!0,stripe:!0,"highlight-current-row":""}},[a("el-table-column",{attrs:{type:"expand"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-row",{attrs:{title:e.row.topicOption}},t._l(e.row.optionArr,function(e,i){return a("span",{key:i,staticClass:"spanSty"},[t._v(t._s(e))])}),0)]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"题目","min-width":"300",align:"left"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("div",{attrs:{title:e.row.topicColumn}},[t._v(t._s(e.row.topicColumn))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"答案",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.topicResult))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.handleModifyStatus(i,"edit")}}},[t._v("编辑")]),t._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleModifyStatus(i,"delete")}}},[t._v("删除")]),t._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(e){return t.handleModifyStatus(i,"info")}}},[t._v("详情")])]}}])})],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getTestList}})],1)],1),t._v(" "),a("el-dialog",{attrs:{title:t.textMap[t.dialogStatus],visible:t.dialogVisible,width:"30%","before-close":t.handleClose},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.temp,size:"medium"}},[a("el-form-item",{attrs:{label:"创建科目："}},[a("el-input",{attrs:{placeholder:"请输入查询内容"},model:{value:t.temp.subjectName,callback:function(e){t.$set(t.temp,"subjectName",e)},expression:"temp.subjectName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"科目题型："}},[a("el-select",{staticClass:"filter-item",attrs:{filterable:"",placeholder:"请选择科目题型"},model:{value:t.temp.subjectType,callback:function(e){t.$set(t.temp,"subjectType",e)},expression:"temp.subjectType"}},t._l(t.typeList,function(t){return a("el-option",{key:t.value,attrs:{label:t.name,value:t.value}})}),1)],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.saveDialog}},[t._v("确 定")]),t._v(" "),a("el-button",{on:{click:t.handleClose}},[t._v("取 消")])],1)],1),t._v(" "),a("el-dialog",{attrs:{title:t.textMap[t.dialogStatus],visible:t.formWorkVisible,width:"30%","before-close":t.cancelFormWork},on:{"update:visible":function(e){t.formWorkVisible=e}}},[a("el-radio-group",{model:{value:t.radioTypekList,callback:function(e){t.radioTypekList=e},expression:"radioTypekList"}},t._l(t.typeList,function(e,i){return a("el-radio",{key:i,attrs:{label:e.value}},[t._v(t._s(e.name))])}),1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.addFormWork}},[t._v("确 定")]),t._v(" "),a("el-button",{on:{click:t.cancelFormWork}},[t._v("取 消")])],1)],1)],1)},o=[],n=(a("28a5"),a("b775"));function l(t){return Object(n["a"])({url:"/app/xlgl/xlglexamsubject/save",method:"post",data:t})}function s(){return Object(n["a"])({url:"/app/xlgl/xlglexamsubject/subject",method:"get"})}function r(t){return Object(n["a"])({url:"/app/xlgl/xlglexamtopic/list",method:"get",params:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/xlglexamsubject/update",method:"post",data:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/xlglexamtopic/delete",method:"post",data:t})}function d(t){return Object(n["a"])({url:"/app/xlgl/xlglexamtopic/update",method:"post",data:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/xlglexamtopic/info",method:"post",data:t})}var m=a("333d"),f={name:"ComplexTable",components:{Pagination:m["a"]},data:function(){return{treeData:[],defaultProps:{children:"children",label:"label"},tableKey:0,list:null,total:0,listLoading:!1,listQuery:{id:"047e2a84-86c9-443b-92e1-0018817a1c60",topicType:"",subjectId:"",topicColumn:"",page:1,limit:20},typeList:[{name:"单选",value:"1"},{name:"多选",value:"2"},{name:"判断",value:"3"},{name:"填空",value:"4"},{name:"简答",value:"5"}],temp:{subjectName:"",subjectType:""},dialogVisible:!1,formWorkVisible:!1,dialogStatus:"",textMap:{update:"Edit",create:"新增题库类型",formWork:"模板类型"},radioTypekList:"",fileUploadUrl:"http://172.16.1.27:11009/app/xlgl/xlglexamtopic/readExcelSave"}},created:function(){this.getTreeList(),this.getTestList()},methods:{addTest:function(){this.dialogStatus="create",this.dialogVisible=!0},saveDialog:function(){var t=this;l({subjectName:this.temp.subjectName,subjectType:this.temp.subjectType}).then(function(e){0===e.data.code?(t.$message({type:"success",message:"题库类型添加成功!"}),t.getTreeList()):t.$message({type:"info",message:e.data.msg})})},handleClose:function(){this.temp={subjectName:"",subjectType:""},this.dialogVisible=!1},getTreeList:function(){var t=this;s().then(function(e){t.treeData=e.data})},remove:function(t,e){var a=this,i=t.parent,o=i.data.children||i.data,n=[];o.length>1&&o.map(function(t){t.type!=e.type&&n.push(t.type)}),u({id:i.data.id,delType:e.type,subjectType:n.join(",")}).then(function(t){0===t.data.code?(a.$message({type:"success",message:"删除成功!"}),a.getTreeList()):a.$message({type:"info",message:t.data.msg})})},handleNodeClick:function(t){console.log(t)},onSubmit:function(){},getTestList:function(){var t=this;this.listLoading=!0,r(this.listQuery).then(function(e){e.data.page.list.map(function(t){t.optionArr=t.topicOption.split(",")}),t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1500)})},handleModifyStatus:function(t,e){var a=this;"edit"===e?d({id:t.id}).then(function(t){}):"delete"===e?c({ids:t.id}).then(function(t){0===t.data.code?(a.$message({type:"success",message:"删除成功!"}),a.getTestList()):a.$message({type:"info",message:t.data.msg})}):"info"===e&&p({id:t.id}).then(function(t){})},importData:function(){},downLoadFormWork:function(){this.dialogStatus="formWork",this.formWorkVisible=!0},addFormWork:function(){window.location.href="http://172.16.1.27:11009/app/xlgl/xlglexamtopic/downloadFile?topicType="+this.radioTypekList+"&access_token="+this.$store.state.user.token},cancelFormWork:function(){this.radioTypekList="",this.formWorkVisible=!1}}},b=f,g=(a("c963"),a("2877")),v=Object(g["a"])(b,i,o,!1,null,"5752506f",null);e["default"]=v.exports}}]);