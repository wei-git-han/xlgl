(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-04f0b087"],{"4ead":function(e,t,a){"use strict";var i=a("bbfb"),s=a.n(i);s.a},a417:function(e,t,a){"use strict";a.d(t,"c",function(){return s}),a.d(t,"b",function(){return n}),a.d(t,"a",function(){return l});var i=a("b775");function s(){return Object(i["a"])({url:"/app/base/user/tree",method:"get"})}function n(){return Object(i["a"])({url:"/app/base/user/chuTree",method:"get"})}function l(){return Object(i["a"])({url:"/app/base/user/allTree",method:"get"})}},bbfb:function(e,t,a){},cc5e:function(e,t,a){"use strict";a.d(t,"c",function(){return s}),a.d(t,"d",function(){return n}),a.d(t,"a",function(){return l}),a.d(t,"b",function(){return r}),a.d(t,"g",function(){return o}),a.d(t,"f",function(){return c}),a.d(t,"e",function(){return u});var i=a("b775");function s(e){return Object(i["a"])({url:"/app/xlgl/roleset/list",method:"get",params:e})}function n(e){return Object(i["a"])({url:"/app/xlgl/roleset/saveOrUpdate",method:"get",params:e})}function l(e){return Object(i["a"])({url:"/app/xlgl/roleset/delete",method:"post",params:e})}function r(e){return Object(i["a"])({url:"/app/base/dept/syncTree",method:"post",params:e})}function o(e){return Object(i["a"])({url:"/app/base/user/list",method:"post",params:e})}function c(e){return Object(i["a"])({url:"/app/base/user/updateZbqk",method:"post",params:e})}function u(e){return Object(i["a"])({url:"/app/base/user/updateSfyx",method:"post",params:e})}},fbb9:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-card",[a("div",{staticStyle:{height:"40px","text-align":"right"}},[a("el-button",{staticClass:"addBtn noBorder",attrs:{type:"primary",size:"small",icon:"el-icon-plus"},on:{click:e.addPeople}},[e._v("增加")]),e._v(" "),a("el-button",{staticClass:"deleteBtn1 noBorder",attrs:{type:"primary",icon:"el-icon-delete",size:"small"},on:{click:e.deleteUser}},[e._v("删除")])],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],key:e.tableKey,attrs:{data:e.list,border:"",fit:"",stripe:"","highlight-current-rowstyle":"width: 100%;"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"center",width:"55"}}),e._v(" "),a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{label:"部门","min-width":"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[a("span",[e._v(e._s(i.deptName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"姓名","min-width":"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[a("span",[e._v(e._s(i.userName))])]}}])}),a("el-table-column",{attrs:{label:"角色","min-width":"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[a("span",[e._v(e._s(e.ROLES_LIST[i.roleFlag]))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"350","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){var i=t.row;return[a("el-button",{staticClass:"noBorder editBtn",attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:function(t){return e.handleUpdate(i)}}},[e._v("编辑")]),e._v(" "),"delete"!=i.status?a("el-button",{staticClass:"noBorder deleteBtn",attrs:{size:"mini",type:"primary",icon:"el-icon-delete"},on:{click:function(t){return e.deleteUser(i)}}},[e._v("\n            删除\n          ")]):e._e()]}}])})],1),e._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.listQuery.page,limit:e.listQuery.pagesize},on:{"update:page":function(t){return e.$set(e.listQuery,"page",t)},"update:limit":function(t){return e.$set(e.listQuery,"pagesize",t)},pagination:e.getRoleList}})],1),e._v(" "),a("el-dialog",{attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible,"before-close":e.closeDialog},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"dataForm",staticStyle:{margin:"0px 50px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"100px"}},[a("el-form-item",{attrs:{label:"姓名：",prop:"userName"}},[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:e.showTree,callback:function(t){e.showTree=t},expression:"showTree"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[a("el-tree",{attrs:{data:e.treeData,props:e.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":e.selectUser}})],1),e._v(" "),a("el-input",{attrs:{slot:"reference",placeholder:"请输入姓名",readonly:"readonly"},slot:"reference",model:{value:e.temp.userName,callback:function(t){e.$set(e.temp,"userName",t)},expression:"temp.userName"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"角色："}},[a("el-select",{attrs:{placeholder:"请选择角色"},model:{value:e.temp.roleFlag,callback:function(t){e.$set(e.temp,"roleFlag",t)},expression:"temp.roleFlag"}},e._l(e.roleList,function(e){return a("el-option",{key:e.id,attrs:{label:e.text,value:e.id}})}),1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("确定")]),e._v(" "),a("el-button",{on:{click:e.closeDialog}},[e._v("取消")])],1)],1)],1)},s=[],n=(a("ac6a"),a("cc5e")),l=a("a417"),r=a("333d"),o={name:"BusinessConfig",components:{Pagination:r["a"]},data:function(){return{tableKey:0,list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10},departList:[],rolesList:[],collectList:[],temp:{id:"",userName:"",userId:"",roleFlag:""},defaultProps:{children:"children",label:"text"},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增",connect:"权限交接"},roleList:[{id:"1",text:"首长"},{id:"2",text:"首长秘书"},{id:"3",text:"局长"},{id:"4",text:"局秘书"},{id:"5",text:"处长"},{id:"6",text:"参谋"}],certigierList:[],showTree:!1,rules:{},treeData:[],ROLES_LIST:{1:"首长",2:"首长秘书",3:"局长",4:"局秘书",5:"处长",6:"参谋"}}},created:function(){this.getRoleList()},methods:{getRoleList:function(){var e=this;this.listLoading=!0,Object(n["c"])(this.listQuery).then(function(t){e.list=t.data.rows,e.total=t.data.total,setTimeout(function(){e.listLoading=!1},1500)})},addPeople:function(){this.dialogStatus="create",this.getTree(),this.dialogFormVisible=!0,this.temp.adminType=this.listQuery.adminType},getTree:function(){var e=this;Object(l["c"])().then(function(t){e.treeData=[t.data]})},selectUser:function(e){"1"===e.type&&(this.temp.userId=e.id,this.temp.userName=e.text,this.showTree=!1)},handleUpdate:function(e){var t=this,a=e.id,i=e.userId,s=e.userName,n=e.roleFlag;this.temp={id:a,userId:i,userName:s,roleFlag:n},this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs["dataForm"].clearValidate()})},closeDialog:function(){this.temp={},this.dialogFormVisible=!1},updateData:function(){var e=this;this.$refs["dataForm"].validate(function(t){if(t){var a=Object.assign({},e.temp);Object(n["d"])(a).then(function(t){var a="",i="";"success"===t.data.result?(i="success",a="create"===e.dialogStatus?"新增成功":"修改成功",e.getRoleList(),e.closeDialog()):(i="fail",a="create"===e.dialogStatus?"新增失败":"修改失败",e.getRoleList(),e.closeDialog()),e.$message({message:a,type:i})})}})},handleSelectionChange:function(e){this.collectList=e},deleteUser:function(e){var t=this,a=[];e.id?a.push(e.id):this.collectList.length>0?this.collectList.forEach(function(e){a.push(e.id)}):this.$message("请选择需要删除的数据！"),a.length>0&&this.$confirm("此操作将永久删除人员, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(n["a"])({ids:a.join(",")}).then(function(e){e.data.result?t.$message({type:"success",message:"删除成功!"}):t.$message({type:"info",message:e.data.message}),t.getRoleList()})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})}}},c=o,u=(a("4ead"),a("2877")),d=Object(u["a"])(c,i,s,!1,null,"a88a59b6",null);t["default"]=d.exports}}]);