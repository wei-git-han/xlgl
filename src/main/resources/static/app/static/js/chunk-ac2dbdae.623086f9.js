(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ac2dbdae"],{"04d0":function(t,e,a){},5308:function(t,e,a){"use strict";var n=a("04d0"),s=a.n(n);s.a},c03e:function(t,e,a){"use strict";a.d(e,"e",function(){return s}),a.d(e,"a",function(){return i}),a.d(e,"j",function(){return r}),a.d(e,"g",function(){return l}),a.d(e,"c",function(){return o}),a.d(e,"h",function(){return c}),a.d(e,"f",function(){return u}),a.d(e,"i",function(){return p}),a.d(e,"b",function(){return d}),a.d(e,"k",function(){return h}),a.d(e,"d",function(){return m});var n=a("b775");function s(t){return Object(n["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function i(t){return Object(n["a"])({url:"/app/xlgl/peopleManagement/list",method:"post",data:t})}function r(t){return Object(n["a"])({url:"/app/xlgl/peopleManagement/qxjUserInfoList",method:"post",data:t})}function l(t){return Object(n["a"])({url:"/app/xlgl/peopleManagementNew/organTreeList",method:"post",data:t})}function o(t){return Object(n["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/peopleManagementNew/organTreeListALL",method:"post",data:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/peopleManagementNew/organTree",method:"post",data:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/peopleManagementNew/platList",method:"post",data:t})}function d(t){return Object(n["a"])({url:"/app/xlgl/peopleManagementNew/getPlatNumber",method:"post",data:t})}function h(t){return Object(n["a"])({url:"/app/xlgl/syncPeople/shuaxin",method:"post",data:t})}function m(t){return Object(n["a"])({url:"/app/xlgl/peopleManagement/getStatisticsByDept",method:"post",data:t})}},d91d:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"posRel"},[a("el-card",{staticStyle:{height:"calc(98vh - 15px)",margin:"10px"},attrs:{"body-style":{padding:"0px 10px"}}},[a("title-card",{attrs:{"title-text":"各地区人员分布情况"}}),t._v(" "),a("el-button",{staticClass:"iconBack",attrs:{size:"mini"},on:{click:t.goBack}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"goback"}}),t._v("\n      返回上一级\n    ")],1),t._v(" "),a("el-row",{staticClass:"ma-t_20",attrs:{gutter:20}},[a("el-col",{attrs:{span:3}},[a("div",{staticClass:"organTree"},[a("div",{staticStyle:{height:"40px","line-height":"40px","padding-left":"15px"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px"},attrs:{"icon-class":"mulu"}})],1),t._v(" "),a("ul",[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"700px"}},t._l(t.mapTreeList,function(e,n){return a("li",{key:n,class:[n===t.ins?"active":"pd-l_30"],on:{click:function(a){return t.changeOrgan(e,n)}}},[t._v(t._s(e.plat.length>5?e.plat.substr(0,5):e.plat))])}),0)],1)])]),t._v(" "),a("el-col",{attrs:{span:21}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"recordNum"},[t._v("共查询到"),a("span",[t._v(t._s(t.recordNum))]),t._v("条人员记录")])]),t._v(" "),a("el-col",{attrs:{span:18}},[a("el-row",[a("el-form",{attrs:{model:t.listQuery,"label-position":"left","label-width":"100px"}},[a("el-col",{attrs:{span:6}},[a("el-date-picker",{attrs:{type:"date",size:"small",placeholder:"请选择日期",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd"},on:{change:t.getDate},model:{value:t.listQuery.timeStr,callback:function(e){t.$set(t.listQuery,"timeStr",e)},expression:"listQuery.timeStr"}})],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(e){t.showUserTree=e},expression:"showUserTree"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[a("el-tree",{ref:"userTree",attrs:{data:t.mapTreeData,props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":t.handleNodeClick}})],1),t._v(" "),a("el-input",{staticStyle:{width:"200px"},attrs:{slot:"reference",size:"small",clearable:"",placeholder:"请选择单位"},on:{clear:t.clearNode},slot:"reference",model:{value:t.listQuery.organName,callback:function(e){t.$set(t.listQuery,"organName",e)},expression:"listQuery.organName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{size:"small",placeholder:"输入人员姓名",clearable:""},on:{clear:t.clearFn},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.search(e)}},model:{value:t.listQuery.userName,callback:function(e){t.$set(t.listQuery,"userName",e)},expression:"listQuery.userName"}})],1)],1),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.searchFn}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"sousuo"}}),t._v("\n                查询\n              ")],1),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFn}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"daochu"}}),t._v("\n                导出\n              ")],1)],1)],1)],1),t._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],staticClass:"ma-t_20",attrs:{data:t.tableList,border:"",fit:"",stripe:"","header-cell-style":{fontSize:"16px",color:"#333"},"highlight-current-rowstyle":"width: 100%;",height:"730"}},[a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",align:"center",prop:"userName"}}),t._v(" "),a("el-table-column",{attrs:{label:"单位",align:"center",prop:"deptName"}}),t._v(" "),a("el-table-column",{attrs:{label:"部门",align:"center",prop:"organName"}}),t._v(" "),a("el-table-column",{attrs:{label:"手机号码",align:"center",prop:"phone"}}),t._v(" "),a("el-table-column",{attrs:{label:"当前位置",align:"center",prop:"location"}}),t._v(" "),a("el-table-column",{attrs:{label:"详细地址",align:"center",prop:"address"}}),t._v(" "),a("el-table-column",{attrs:{label:"在位状态",align:"center",prop:"status"}})],1)],1)],1)],1)],1)},s=[],i=(a("ac6a"),a("35b7")),r=a("c03e"),l={name:"PersonStatusJu",components:{TitleCard:i["a"]},props:{id:{type:String,default:""}},data:function(){return{mapTreeList:[],ins:0,listQuery:{userName:"",timeStr:"",organId:"",organName:""},isManager:this.$store.state.user.userInfo.adminFlag,recordNum:"",listLoading:!1,tableList:[],showUserTree:!1,mapTreeData:[],defaultProps:{children:"children",label:"text"}}},created:function(){this.getPlatNumber(),this.platList(),this.mapOrganTree()},methods:{getPlatNumber:function(){var t=this,e={parentId:"1"===this.isManager?"":this.$store.state.user.userInfo.juId};Object(r["b"])(e).then(function(e){t.mapTreeList=e.data.list,e.data.list.forEach(function(e,a){t.id===e.plat&&(t.ins=a)})})},platList:function(){var t=this;this.listLoading=!0;var e={parentId:"1"===this.isManager?"":this.$store.state.user.userInfo.juId,userName:this.listQuery.userName,timeStr:this.listQuery.timeStr,organId:this.listQuery.organId,province:this.id};Object(r["i"])(e).then(function(e){t.tableList=e.data.list,t.recordNum=e.data.list.length,setTimeout(function(){t.listLoading=!1},100)})},mapOrganTree:function(){var t=this;Object(r["f"])().then(function(e){t.mapTreeData=e.data.children})},handleNodeClick:function(t){this.listQuery.organId=t.id,this.listQuery.organName=t.text,this.showUserTree=!1,this.platList()},clearNode:function(){this.listQuery.organId="",this.platList()},clearFn:function(){this.platList()},getDate:function(t){this.listQuery.timeStr=t,this.platList()},goBack:function(){this.$emit("back","1")},changeOrgan:function(t,e){this.ins=e,this.id=t.plat,this.platList()},searchFn:function(){this.platList()},exportFn:function(){window.location.href="/app/xlgl/peopleManagementNew/exportPlat?parentId="+("1"===this.isManager?"":this.$store.state.user.userInfo.juId)+"&province="+this.id+"&timeStr="+this.listQuery.timeStr+"&access_token="+this.$store.state.user.token}}},o=l,c=(a("5308"),a("2877")),u=Object(c["a"])(o,n,s,!1,null,"73851ef0",null);e["default"]=u.exports}}]);