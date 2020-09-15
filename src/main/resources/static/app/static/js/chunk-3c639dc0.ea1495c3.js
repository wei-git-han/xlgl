(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3c639dc0"],{5248:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container1",staticStyle:{padding:"0 10px 20px"}},[a("el-card",[a("div",{staticStyle:{height:"40px","text-align":"right"}},[a("el-button",{staticClass:"addBtn noBorder",attrs:{type:"primary",size:"small",icon:"el-icon-plus"},on:{click:e.addPeople}},[e._v("增加")]),e._v(" "),a("el-button",{staticClass:"deleteBtn1 noBorder",attrs:{type:"primary",icon:"el-icon-delete",size:"small"},on:{click:e.deleteUser}},[e._v("删除")])],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],key:e.tableKey,attrs:{data:e.list,border:"",fit:"",stripe:"","highlight-current-rowstyle":"width: 100%;"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"center",width:"55"}}),e._v(" "),a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{label:"姓名",width:"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.userName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"单位名称","min-width":"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[a("span",[e._v(e._s(i.deptName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"350","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[a("el-button",{staticClass:"noBorder editBtn",attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:function(t){return e.handleUpdate(i)}}},[e._v("编辑")]),e._v(" "),"delete"!=i.status?a("el-button",{staticClass:"noBorder deleteBtn",attrs:{size:"mini",type:"primary",icon:"el-icon-delete"},on:{click:function(t){return e.deleteUser(i)}}},[e._v("\n            删除\n          ")]):e._e()]}}])})],1),e._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.listQuery.page,limit:e.listQuery.pagesize},on:{"update:page":function(t){return e.$set(e.listQuery,"page",t)},"update:limit":function(t){return e.$set(e.listQuery,"pagesize",t)},pagination:e.getAdminsetList}})],1),e._v(" "),a("el-dialog",{attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t},close:e.resetTemp}},[a("el-form",{ref:"dataForm",staticStyle:{margin:"0px 50px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"100px"}},[a("el-form-item",{attrs:{label:"姓名：",prop:"userName"}},[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:e.showTree,callback:function(t){e.showTree=t},expression:"showTree"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[a("el-tree",{attrs:{data:e.treeData,props:e.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":e.selectUser}})],1),e._v(" "),a("el-input",{attrs:{slot:"reference",placeholder:"请输入姓名",readonly:"readonly"},slot:"reference",model:{value:e.temp.userName,callback:function(t){e.$set(e.temp,"userName",t)},expression:"temp.userName"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"角色："}},[a("el-select",{staticClass:"filter-item",attrs:{filterable:"",placeholder:"请选择角色",readonly:"",disabled:""},model:{value:e.temp.adminType,callback:function(t){e.$set(e.temp,"adminType",t)},expression:"temp.adminType"}},e._l(e.roleList,function(e){return a("el-option",{key:e.id,attrs:{label:e.text,value:e.id}})}),1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("确定")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1)},n=[],s=(a("ac6a"),a("d8e5")),l=a("a417"),r=a("333d"),o={name:"BusinessConfig",components:{Pagination:r["a"]},data:function(){return{tableKey:0,list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10,adminType:"1"},departList:[],rolesList:[],collectList:[],temp:{id:"",userName:"",userId:""},defaultProps:{children:"children",label:"text"},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增",connect:"权限交接"},roleList:[{id:"1",text:"部管理员"},{id:"2",text:"局管理员"},{id:"4",text:"处管理员"}],certigierList:[],showTree:!1,rules:{},treeData:[]}},created:function(){this.getAdminsetList()},methods:{getAdminsetList:function(){var e=this;this.listLoading=!0,Object(s["d"])(this.listQuery).then(function(t){e.list=t.data.rows,e.total=t.data.total,setTimeout(function(){e.listLoading=!1},200)})},selectUser:function(e){"1"===e.type&&(this.temp.userId=e.id,this.temp.userName=e.text,this.showTree=!1)},handleSelectionChange:function(e){this.collectList=e},addPeople:function(){this.dialogStatus="create",this.getBuAllTree(),this.dialogFormVisible=!0,this.temp.adminType=this.listQuery.adminType},getTree:function(){var e=this;Object(l["c"])().then(function(t){e.treeData=[t.data]})},getBuAllTree:function(){var e=this;Object(s["f"])().then(function(t){e.treeData=[t.data]})},deleteUser:function(e){var t=this,a=[];e.id?a.push(e.id):this.collectList.length>0?this.collectList.forEach(function(e){a.push(e.id)}):this.$message("请选择需要删除的数据！"),a.length>0&&this.$confirm("此操作将永久删除人员, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s["b"])({ids:a.join(",")}).then(function(e){e.data.result?t.$message({type:"success",message:"删除成功!"}):t.$message({type:"info",message:e.data.message}),t.getAdminsetList()})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},resetTemp:function(){this.temp={}},handleUpdate:function(e){var t=this,a=e.id,i=e.userId,n=e.userName,s=e.adminType;this.temp={id:a,userId:i,userName:n,adminType:s},this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs["dataForm"].clearValidate(),t.getBuAllTree()})},updateData:function(){var e=this;this.$refs["dataForm"].validate(function(t){if(t){var a=Object.assign({},e.temp);Object(s["e"])(a).then(function(t){var a="修改失败",i="info";t.data.result&&(i="success",a="修改成功",e.dialogFormVisible=!1,e.getAdminsetList()),e.$message({message:a,type:i})})}})}}},c=o,u=(a("6a87"),a("2877")),d=Object(u["a"])(c,i,n,!1,null,"b0b2f974",null);t["default"]=d.exports},"6a87":function(e,t,a){"use strict";var i=a("cde1"),n=a.n(i);n.a},a417:function(e,t,a){"use strict";a.d(t,"c",function(){return n}),a.d(t,"b",function(){return s}),a.d(t,"a",function(){return l});var i=a("b775");function n(){return Object(i["a"])({url:"/app/base/user/tree",method:"get"})}function s(){return Object(i["a"])({url:"/app/base/user/chuTree",method:"get"})}function l(){return Object(i["a"])({url:"/app/base/user/allTree",method:"get"})}},cde1:function(e,t,a){},d8e5:function(e,t,a){"use strict";a.d(t,"d",function(){return n}),a.d(t,"c",function(){return s}),a.d(t,"a",function(){return l}),a.d(t,"e",function(){return r}),a.d(t,"b",function(){return o}),a.d(t,"f",function(){return c}),a.d(t,"g",function(){return u});var i=a("b775");function n(e){return Object(i["a"])({url:"/app/xlgl/adminset/list",method:"get",params:e})}function s(e){return Object(i["a"])({url:"/app/xlgl/adminset/juList",method:"get",params:e})}function l(e){return Object(i["a"])({url:"/app/xlgl/adminset/chuList",method:"get",params:e})}function r(e){return Object(i["a"])({url:"/app/xlgl/adminset/saveOrUpdate",method:"get",params:e})}function o(e){return Object(i["a"])({url:"/app/xlgl/adminset/delete",method:"get",params:e})}function c(){return Object(i["a"])({url:"/app/base/user/allTree",method:"get"})}function u(e){return Object(i["a"])({url:"/app/xlgl/taskmenu/getPeoplePermissionList",method:"post",data:e})}}}]);