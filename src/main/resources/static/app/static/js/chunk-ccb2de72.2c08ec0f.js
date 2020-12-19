(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ccb2de72"],{"16de":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container1",staticStyle:{padding:"0 10px 20px"}},[a("el-card",[a("div",{staticStyle:{height:"40px","text-align":"right"}},[a("el-button",{staticClass:"addBtn1 noBorder",attrs:{type:"success",size:"small",icon:"el-icon-plus"},on:{click:t.addPeople}},[t._v("新增")]),t._v(" "),a("el-button",{staticClass:"deleteBtn1 noBorder",attrs:{type:"danger",icon:"el-icon-delete",size:"small"},on:{click:t.deleteUser}},[t._v("删除")])],1),t._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,attrs:{data:t.list,border:"",fit:"",stripe:"","highlight-current-rowstyle":"width: 100%;"},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"center",width:"55"}}),t._v(" "),a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.userName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"单位名称","min-width":"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.orgName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"350","class-name":"small-padding fixed-width"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("el-button",{staticClass:"noBorder editBtn",attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:function(e){return t.handleUpdate(i)}}},[t._v("编辑")]),t._v(" "),"delete"!=i.status?a("el-button",{staticClass:"noBorder deleteBtn",attrs:{size:"mini",type:"danger",icon:"el-icon-delete"},on:{click:function(e){return t.deleteUser(i)}}},[t._v("\n            删除\n          ")]):t._e()]}}])})],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getAdminsetChuList}})],1),t._v(" "),a("el-dialog",{attrs:{title:t.textMap[t.dialogStatus],visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:t.resetTemp}},[a("el-form",{ref:"dataForm",staticClass:"configForm",staticStyle:{margin:"0px 50px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"100px"}},[a("el-form-item",{attrs:{label:"姓名：",prop:"userName"}},[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showTree,callback:function(e){t.showTree=e},expression:"showTree"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[a("el-tree",{attrs:{data:t.treeData,props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":t.selectUser}})],1),t._v(" "),a("el-input",{attrs:{slot:"reference",placeholder:"请输入姓名",readonly:"readonly"},slot:"reference",model:{value:t.temp.userName,callback:function(e){t.$set(t.temp,"userName",e)},expression:"temp.userName"}})],1)],1),t._v(" "),a("el-form-item",{attrs:{label:"角色："}},[a("el-select",{staticClass:"filter-item",attrs:{filterable:"",placeholder:"请选择角色",readonly:"",disabled:""},model:{value:t.temp.adminType,callback:function(e){t.$set(t.temp,"adminType",e)},expression:"temp.adminType"}},t._l(t.roleList,function(t){return a("el-option",{key:t.id,attrs:{label:t.text,value:t.id}})}),1)],1)],1),t._v(" "),a("div",{staticClass:"text-center",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.updateData}},[t._v("确定")]),t._v(" "),a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")])],1)],1)],1)},n=[],s=(a("ac6a"),a("d8e5")),r=a("a417"),l=a("333d"),o={name:"BusinessConfig",components:{Pagination:l["a"]},data:function(){return{tableKey:0,list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10,adminType:"4"},temp:{id:"",userName:"",userId:""},defaultProps:{children:"children",label:"text"},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增",connect:"权限交接"},roleList:[{id:"1",text:"部管理员"},{id:"2",text:"局管理员"},{id:"4",text:"处管理员"}],showTree:!1,rules:{},collectList:[],treeData:[],adminFlag:this.$store.state.user.userInfo.adminFlag}},created:function(){this.getAdminsetChuList()},methods:{getAdminsetChuList:function(){var t=this;this.listLoading=!0,Object(s["a"])(this.listQuery).then(function(e){t.list=e.data.rows,t.total=e.data.total,setTimeout(function(){t.listLoading=!1},1)})},selectUser:function(t){"1"===t.type&&(this.temp.userId=t.id,this.temp.userName=t.text,this.showTree=!1)},handleSelectionChange:function(t){this.collectList=t},addPeople:function(){this.dialogStatus="create","1"===this.adminFlag?this.getBuAllTree():this.getTree(),this.dialogFormVisible=!0,this.temp.adminType=this.listQuery.adminType},getBuAllTree:function(){var t=this;Object(s["f"])().then(function(e){t.treeData=[e.data]})},getTree:function(){var t=this;Object(r["b"])().then(function(e){t.treeData=[e.data]})},deleteUser:function(t){var e=this,a=[];t.id?a.push(t.id):this.collectList.length>0?this.collectList.forEach(function(t){a.push(t.id)}):this.$notify({title:"提示",message:"请选择需要删除的数据！",duration:1500,type:"warning"}),a.length>0&&this.$confirm("此操作将永久删除人员, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s["b"])({ids:a.join(",")}).then(function(t){t.data.result?e.$notify({title:"提示",message:"删除成功!",duration:1500,type:"success"}):e.$notify({title:"提示",message:t.data.message,duration:1500,type:"warning"}),e.getAdminsetChuList()})}).catch(function(){e.$notify({title:"提示",message:"已取消删除",duration:1500,type:"warning"})})},resetTemp:function(){this.temp={}},handleUpdate:function(t){var e=this,a=t.id,i=t.userId,n=t.userName,s=t.adminType;this.temp={id:a,userId:i,userName:n,adminType:s},this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs["dataForm"].clearValidate()})},updateData:function(){var t=this;this.$refs["dataForm"].validate(function(e){if(e){var a=Object.assign({},t.temp);Object(s["e"])(a).then(function(e){var a="修改失败",i="error";"success"===e.data.result?(i="success",a="修改成功",t.dialogFormVisible=!1,t.getAdminsetChuList()):"isju"===e.data.result&&(a="该人员为局管理员，无法设置为处管理员！",t.getAdminsetChuList()),t.$notify({title:"提示",message:a,duration:1500,type:i})})}})}}},u=o,c=a("2877"),d=Object(c["a"])(u,i,n,!1,null,"6f64ffa6",null);e["default"]=d.exports},a417:function(t,e,a){"use strict";a.d(e,"c",function(){return n}),a.d(e,"b",function(){return s}),a.d(e,"a",function(){return r});var i=a("b775");function n(){return Object(i["a"])({url:"/app/base/user/tree",method:"get"})}function s(){return Object(i["a"])({url:"/app/base/user/chuTree",method:"get"})}function r(){return Object(i["a"])({url:"/app/base/user/allTree",method:"get"})}},d8e5:function(t,e,a){"use strict";a.d(e,"d",function(){return n}),a.d(e,"c",function(){return s}),a.d(e,"a",function(){return r}),a.d(e,"e",function(){return l}),a.d(e,"b",function(){return o}),a.d(e,"f",function(){return u}),a.d(e,"g",function(){return c});var i=a("b775");function n(t){return Object(i["a"])({url:"/app/xlgl/adminset/list",method:"get",params:t})}function s(t){return Object(i["a"])({url:"/app/xlgl/adminset/juList",method:"get",params:t})}function r(t){return Object(i["a"])({url:"/app/xlgl/adminset/chuList",method:"get",params:t})}function l(t){return Object(i["a"])({url:"/app/xlgl/adminset/saveOrUpdate",method:"get",params:t})}function o(t){return Object(i["a"])({url:"/app/xlgl/adminset/delete",method:"get",params:t})}function u(){return Object(i["a"])({url:"/app/base/user/allTree",method:"get"})}function c(t){return Object(i["a"])({url:"/app/xlgl/taskmenu/getPeoplePermissionList",method:"post",data:t})}}}]);