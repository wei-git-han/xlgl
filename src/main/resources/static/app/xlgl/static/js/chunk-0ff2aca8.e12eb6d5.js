(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0ff2aca8"],{"09f4":function(e,t,a){"use strict";a.d(t,"a",function(){return s}),Math.easeInOutQuad=function(e,t,a,n){return e/=n/2,e<1?a/2*e*e+t:(e--,-a/2*(e*(e-2)-1)+t)};var n=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(e){window.setTimeout(e,1e3/60)}}();function i(e){document.documentElement.scrollTop=e,document.body.parentNode.scrollTop=e,document.body.scrollTop=e}function o(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function s(e,t,a){var s=o(),r=e-s,l=20,c=0;t="undefined"===typeof t?500:t;var u=function e(){c+=l;var o=Math.easeInOutQuad(c,s,r,t);i(o),c<t?n(e):a&&"function"===typeof a&&a()};u()}},2325:function(e,t,a){},a3c6:function(e,t,a){"use strict";var n=a("2325"),i=a.n(n);i.a},a417:function(e,t,a){"use strict";a.d(t,"b",function(){return i}),a.d(t,"a",function(){return o});var n=a("b775");function i(){return Object(n["a"])({url:"app/base/user/tree",method:"get"})}function o(){return Object(n["a"])({url:"app/base/user/chuTree",method:"get"})}},cc5e:function(e,t,a){"use strict";a.d(t,"c",function(){return i}),a.d(t,"d",function(){return o}),a.d(t,"a",function(){return s}),a.d(t,"b",function(){return r}),a.d(t,"f",function(){return l}),a.d(t,"e",function(){return c});var n=a("b775");function i(e){return Object(n["a"])({url:"/app/xlgl/roleset/list",method:"get",params:e})}function o(e){return Object(n["a"])({url:"/app/xlgl/roleset/saveOrUpdate",method:"get",params:e})}function s(e){return Object(n["a"])({url:"/app/xlgl/roleset/delete",method:"post",params:e})}function r(e){return Object(n["a"])({url:"/app/base/dept/syncTree",method:"post",params:e})}function l(e){return Object(n["a"])({url:"/app/base/user/list",method:"post",params:e})}function c(e){return Object(n["a"])({url:"/app/base/user/updateZbqk",method:"post",params:e})}},fbb9:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-card",[a("div",{staticStyle:{height:"40px","text-align":"right"}},[a("el-button",{staticClass:"addBtn noBorder",attrs:{type:"primary",size:"small",icon:"el-icon-plus"},on:{click:e.addPeople}},[e._v("增加")]),e._v(" "),a("el-button",{staticClass:"deleteBtn1 noBorder",attrs:{type:"primary",icon:"el-icon-delete",size:"small"},on:{click:e.deleteUser}},[e._v("删除")])],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],key:e.tableKey,attrs:{data:e.list,border:"",fit:"",stripe:"","highlight-current-rowstyle":"width: 100%;"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"center",width:"55"}}),e._v(" "),a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{label:"部门","min-width":"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("span",[e._v(e._s(n.deptName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"姓名","min-width":"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("span",[e._v(e._s(n.userName))])]}}])}),a("el-table-column",{attrs:{label:"角色","min-width":"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("span",[e._v(e._s(e.ROLES_LIST[n.roleFlag]))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"350","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("el-button",{staticClass:"noBorder editBtn",attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:function(t){return e.handleUpdate(n)}}},[e._v("编辑")])]}}])})],1),e._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.listQuery.page,limit:e.listQuery.pagesize},on:{"update:page":function(t){return e.$set(e.listQuery,"page",t)},"update:limit":function(t){return e.$set(e.listQuery,"pagesize",t)},pagination:e.getRoleList}})],1),e._v(" "),a("el-dialog",{attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"dataForm",staticStyle:{margin:"0px 50px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"100px"}},[a("el-form-item",{attrs:{label:"姓名：",prop:"userName"}},[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:e.showTree,callback:function(t){e.showTree=t},expression:"showTree"}},[a("el-scrollbar",{staticStyle:{height:"400px"}},[a("el-tree",{attrs:{data:e.treeData,props:e.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":e.selectUser}})],1),e._v(" "),a("el-input",{attrs:{slot:"reference",placeholder:"请输入姓名",readonly:"readonly"},slot:"reference",model:{value:e.temp.userName,callback:function(t){e.$set(e.temp,"userName",t)},expression:"temp.userName"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"角色："}},[a("el-select",{attrs:{placeholder:"请选择角色"},model:{value:e.temp.roleFlag,callback:function(t){e.$set(e.temp,"roleFlag",t)},expression:"temp.roleFlag"}},e._l(e.roleList,function(e){return a("el-option",{key:e.id,attrs:{label:e.text,value:e.id}})}),1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("确定")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1)},i=[],o=(a("ac6a"),a("cc5e")),s=a("a417"),r=a("333d"),l={name:"BusinessConfig",components:{Pagination:r["a"]},data:function(){return{tableKey:0,list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10},departList:[],rolesList:[],collectList:[],temp:{id:"",userName:"",userId:"",roleFlag:""},defaultProps:{children:"children",label:"text"},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑",create:"新增",connect:"权限交接"},roleList:[{id:"1",text:"首长"},{id:"2",text:"首长秘书"},{id:"3",text:"局长"},{id:"4",text:"局秘书"},{id:"5",text:"处长"},{id:"6",text:"参谋"}],certigierList:[],showTree:!1,rules:{},treeData:[],ROLES_LIST:{1:"首长",2:"首长秘书",3:"局长",4:"局秘书",5:"处长",6:"参谋"}}},created:function(){this.getRoleList()},methods:{getRoleList:function(){var e=this;this.listLoading=!0,Object(o["c"])(this.listQuery).then(function(t){e.list=t.data.rows,e.total=t.data.total,setTimeout(function(){e.listLoading=!1},1500)})},addPeople:function(){this.dialogStatus="create",this.getTree(),this.dialogFormVisible=!0,this.temp.adminType=this.listQuery.adminType},getTree:function(){var e=this;Object(s["b"])().then(function(t){e.treeData=[t.data]})},selectUser:function(e){"1"===e.type&&(this.temp.userId=e.id,this.temp.userName=e.text,this.showTree=!1)},handleUpdate:function(e){var t=this,a=e.id,n=e.userId,i=e.userName,o=e.roleFlag;this.temp={id:a,userId:n,userName:i,roleFlag:o},this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs["dataForm"].clearValidate()})},updateData:function(){var e=this;this.$refs["dataForm"].validate(function(t){if(t){var a=Object.assign({},e.temp);Object(o["d"])(a).then(function(t){var a="",n="";"success"===t.data.result?(n="success",a="create"===e.dialogStatus?"新增成功":"修改成功",e.dialogFormVisible=!1,e.getRoleList()):(n="fail",a="create"===e.dialogStatus?"新增失败":"修改失败",e.dialogFormVisible=!1,e.getRoleList()),e.$message({message:a,type:n})})}})},handleSelectionChange:function(e){this.collectList=e},deleteUser:function(){var e=this,t=[];this.collectList.length>0?(this.collectList.forEach(function(e){t.push(e.id)}),this.$confirm("此操作将永久删除人员, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(o["a"])({ids:t.join(",")}).then(function(t){t.data.result?e.$message({type:"success",message:"删除成功!"}):e.$message({type:"info",message:t.data.message}),e.getRoleList()})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})):this.$message("请选择需要删除的数据！")}}},c=l,u=(a("a3c6"),a("2877")),d=Object(u["a"])(c,n,i,!1,null,"4d4210a4",null);t["default"]=d.exports}}]);