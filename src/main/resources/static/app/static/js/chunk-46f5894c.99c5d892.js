(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-46f5894c"],{"06c9":function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app-container"},[n("el-card",[n("div",{staticStyle:{height:"40px","text-align":"right"}},[n("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.updateData}},[e._v("确定")])],1),e._v(" "),n("el-row",[n("el-col",{attrs:{span:5}},[n("el-input",{attrs:{placeholder:"输入人员名称进行过滤"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),e._v(" "),n("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"750px"}},[n("el-tree",{directives:[{name:"loading",rawName:"v-loading",value:e.treeLoading,expression:"treeLoading"}],ref:"userTree",staticClass:"filter-tree",attrs:{data:e.userTreeData,props:e.defaultProps,"node-key":"id","filter-node-method":e.filterNode,"default-expanded-keys":e.defaultActiveId},on:{"node-click":e.selectUser}})],1)],1),e._v(" "),n("el-col",{attrs:{span:19}},[n("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"calc(100vh - 150px)"}},[n("el-tree",{ref:"menuTree",attrs:{data:e.menuTreeData,"show-checkbox":"",props:e.defaultProps,"node-key":"id","default-expand-all":!0,"default-expanded-keys":["all"]},on:{check:e.getCheckMenu}})],1)],1)],1)],1)],1)},s=[],r=(n("8e6e"),n("456d"),n("ac6a"),n("bd86")),a=n("d8e5"),o=n("8f39"),c=n("a417"),u=n("2f62");function l(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);t&&(i=i.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),n.push.apply(n,i)}return n}function d(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?l(n,!0).forEach(function(t){Object(r["a"])(e,t,n[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):l(n).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))})}return e}var f=d({name:"BusinessConfig"},Object(u["b"])(["permission_routes"]),{data:function(){return{tableKey:0,list:null,total:0,listLoading:!0,treeLoading:!1,listQuery:{page:1,pagesize:10,adminType:"2"},departList:[],rolesList:[],collectList:[],temp:{id:"",userName:"",uid:"",param:""},defaultProps:{children:"children",label:"text"},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增",connect:"权限交接"},roleList:[{id:"1",text:"部管理员"},{id:"2",text:"局管理员"},{id:"4",text:"处管理员"}],certigierList:[],showUserTree:!1,showMenuTree:!1,rules:{},userTreeData:[],demoTree:[],menuTreeData:[],defaultActiveId:[],filterText:"",userSelectType:""}},watch:{showMenuTree:function(e){e||this.getCheckMenu()},filterText:function(e){this.$refs.userTree.filter(e)}},created:function(){this.getAdminsetJuList(),this.getTree()},methods:{getAdminsetJuList:function(){var e=this;this.listLoading=!0,Object(a["c"])(this.listQuery).then(function(t){e.list=t.data.rows,e.total=t.data.total,setTimeout(function(){e.listLoading=!1},200)})},selectUser:function(e){this.userSelectType=e.type,"1"===e.type?(this.temp.uid=e.id,this.temp.userName=e.text,this.showUserTree=!1,this.getPeoplePermissionList(e.id)):this.$refs.menuTree.setCheckedKeys([])},handleSelectionChange:function(e){this.collectList=e},addPeople:function(){this.dialogStatus="create",this.getTree(),this.dialogFormVisible=!0},getTree:function(){var e=this;this.treeLoading=!0,Object(c["a"])().then(function(t){e.userTreeData=[t.data],e.defaultActiveId=[t.data.children[0].id],setTimeout(function(){e.treeLoading=!1},200)}),Object(o["b"])().then(function(t){e.menuTreeData=[{id:"all",text:"全部",children:t.data}],e.$nextTick(function(){e.getPeoplePermissionList(e.$store.state.user.userInfo.userId)})}),Object(o["d"])().then(function(e){console.log(e.data)})},deleteUser:function(e){var t=this,n=[];e.id?n.push(e.id):this.collectList.length>0?this.collectList.forEach(function(e){n.push(e.id)}):this.$message("请选择需要删除的数据！"),n.length>0&&this.$confirm("此操作将永久删除人员, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(a["b"])({ids:n.join(",")}).then(function(e){e.data.result?t.$message({type:"success",message:"删除成功!"}):t.$message({type:"info",message:e.data.message}),t.getAdminsetJuList()})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},resetTemp:function(){this.temp={}},handleUpdate:function(e){var t=this,n=e.id,i=e.param,s=e.uid;this.temp={id:n,param:i,uid:s},this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs["dataForm"].clearValidate()})},updateData:function(){var e=this;if("1"===this.userSelectType){var t=Object.assign({},this.temp);Object(o["c"])(t).then(function(t){var n="修改失败",i="info";t.data.result&&(i="success",n="修改成功",e.dialogFormVisible=!1,e.getAdminsetJuList()),e.$message({message:n,type:i})})}else this.$message({message:"只有人员才可以被授予菜单权限",type:"info"})},getCheckMenu:function(){var e=this.$refs.menuTree.getCheckedNodes(),t=[],n=[];e.forEach(function(e){"all"!==e.id&&(n.push(e.id),t.push(e.text))}),console.log(n),this.temp.param=n.toString(),this.temp.paramName=t.toString()},filterNode:function(e,t){return!e||-1!==t.text.indexOf(e)},getPeoplePermissionList:function(e){var t=this;this.$refs.menuTree.setCheckedKeys([]);var n={userId:e};Object(a["g"])(n).then(function(e){"no"===e.data.result?t.$message({message:"该用户尚未配置菜单！",type:"info"}):t.$refs.menuTree.setCheckedKeys(e.data.result)})}}}),p=f,h=(n("1cef"),n("2877")),m=Object(h["a"])(p,i,s,!1,null,"aa271324",null);t["default"]=m.exports},"1cef":function(e,t,n){"use strict";var i=n("31f3"),s=n.n(i);s.a},"31f3":function(e,t,n){},a417:function(e,t,n){"use strict";n.d(t,"c",function(){return s}),n.d(t,"b",function(){return r}),n.d(t,"a",function(){return a});var i=n("b775");function s(){return Object(i["a"])({url:"/app/base/user/tree",method:"get"})}function r(){return Object(i["a"])({url:"/app/base/user/chuTree",method:"get"})}function a(){return Object(i["a"])({url:"/app/base/user/allTree",method:"get"})}},d8e5:function(e,t,n){"use strict";n.d(t,"d",function(){return s}),n.d(t,"c",function(){return r}),n.d(t,"a",function(){return a}),n.d(t,"e",function(){return o}),n.d(t,"b",function(){return c}),n.d(t,"f",function(){return u}),n.d(t,"g",function(){return l});var i=n("b775");function s(e){return Object(i["a"])({url:"/app/xlgl/adminset/list",method:"get",params:e})}function r(e){return Object(i["a"])({url:"/app/xlgl/adminset/juList",method:"get",params:e})}function a(e){return Object(i["a"])({url:"/app/xlgl/adminset/chuList",method:"get",params:e})}function o(e){return Object(i["a"])({url:"/app/xlgl/adminset/saveOrUpdate",method:"get",params:e})}function c(e){return Object(i["a"])({url:"/app/xlgl/adminset/delete",method:"get",params:e})}function u(){return Object(i["a"])({url:"/app/base/user/allTree",method:"get"})}function l(e){return Object(i["a"])({url:"/app/xlgl/taskmenu/getPeoplePermissionList",method:"post",data:e})}}}]);