(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-00b93e88"],{5281:function(t,e,i){"use strict";var s=i("d645"),a=i.n(s);a.a},c03e:function(t,e,i){"use strict";i.d(e,"b",function(){return a}),i.d(e,"a",function(){return l}),i.d(e,"c",function(){return o});var s=i("b775");function a(t){return Object(s["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function l(t){return Object(s["a"])({url:"/app/xlgl/peopleManagement/list",method:"post",data:t})}function o(t){return Object(s["a"])({url:"/app/xlgl/peopleManagement/qxjUserInfoList",method:"post",data:t})}},d645:function(t,e,i){},d91d:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("div",{staticStyle:{cursor:"pointer"},on:{click:function(e){return e.stopPropagation(),t.toggleShow(e)}}},[i("title-card",{attrs:{"title-text":t.cardTitle}})],1),t._v(" "),i("svg-icon",{staticClass:"icon btn1",attrs:{"icon-class":"goback"},on:{click:t.backFn}}),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.showStatistics,expression:"showStatistics"}],staticClass:"div1"},[i("div",{staticClass:"hSty zwl"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            人员在位率（%）\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.zwlv)+"\n          ")])])]),t._v(" "),i("div",{staticClass:"hSty bp"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            应在位人数（人）\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.yzwrs)+"\n          ")])])]),t._v(" "),i("div",{staticClass:"hSty qb"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            休假人数（人）\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.xjrs)+"\n          ")])])]),t._v(" "),i("div",{staticClass:"hSty xj"},[i("div",{staticClass:"wz"},[i("div",[t._v("\n            请假人数（人）\n          ")]),t._v(" "),i("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.qjrs)+"\n          ")])])])])],1),t._v(" "),i("div",{staticStyle:{"margin-top":"20px","border-radius":"5px","background-color":"#ffffff"}},[i("title-card",{attrs:{"title-text":t.cardTitle1}}),t._v(" "),i("el-button",{staticStyle:{float:"right","margin-top":"-40px","margin-right":"20px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFile}},[t._v("导出")]),t._v(" "),i("div",{staticStyle:{padding:"20px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:"","highlight-current-row":""},on:{"selection-change":t.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),t._v(" "),i("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),i("el-table-column",{attrs:{label:"姓名",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-popover",{attrs:{trigger:"hover",placement:"top"}},[i("p",[t._v("应休天数: "+t._s(e.row.totalDays))]),t._v(" "),i("p",[t._v("未休天数: "+t._s(e.row.weixiujiaDays))]),t._v(" "),i("p",[t._v("已休天数: "+t._s(e.row.xiuJiaDays))]),t._v(" "),i("p",[t._v("请假类型: "+t._s(e.row.type))]),t._v(" "),i("p",[t._v("起止时间: "+t._s(e.row.startDate)+" ~ "+t._s(e.row.endDate))]),t._v(" "),i("div",{staticClass:"name-wrapper",attrs:{slot:"reference"},slot:"reference"},[i("el-tag",{attrs:{size:"medium"}},[t._v(t._s(e.row.fullname))])],1)])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"职务",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.post))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"座机号",width:"185px"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.telephone))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"手机号",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.mobile))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"房间号","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.address))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"部门","class-name":"status-col",width:"250"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(s.organName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"在位情况","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var s=e.row;return[i("span",[t._v(t._s(t._f("reginFilter")(s.isShow)))])]}}])})],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.qxjUserInfoList}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"题目导入",visible:t.importFileDialog,width:"40%",accept:".xls,.xlsx","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.importFileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},a=[],l=i("c03e"),o=i("35b7"),n=i("333d"),r={name:"PersonStatusJu",components:{TitleCard:o["a"],Pagination:n["a"]},filters:{reginFilter:function(t){return 0===t?"不在":"在位"}},props:{id:{type:String,default:""}},data:function(){return{cardTitle:"单位人员情况",cardTitle1:"单位人员统计表",showStatistics:!0,tableKey:0,list:[],total:0,listLoading:!1,listQuery:{page:1,limit:20,organId:this.id},collectList:[],importFileDialog:!1,fileUploadUrl:"",fileData:{access_token:this.$store.state.user.token},totalInfo:{zwlv:0,yzwrs:0,xjrs:0,qjrs:0}}},created:function(){this.getTotalJu(),this.qxjUserInfoList()},methods:{toggleShow:function(){this.showStatistics=!this.showStatistics},getTotalJu:function(){var t=this,e={status:1};Object(l["b"])(e).then(function(e){500===e.data.code||(t.totalInfo=e.data)})},qxjUserInfoList:function(){var t=this;this.listLoading=!0,Object(l["c"])(this.listQuery).then(function(e){(500!==e.data.code||e.data.page)&&(t.list=e.data.rows,t.total=e.data.total),setTimeout(function(){t.listLoading=!1},1500)})},handleUpdate:function(t){this.$emit("openDetail","2",t)},handleSelectionChange:function(t){this.collectList=t},exportFile:function(){if(this.collectList.length<1)this.$message({message:"请选择需要导出的数据",type:"info"});else{var t=[];for(var e in this.collectList)t.push(this.collectList[e].id);window.location.href="app/xlgl/peopleManagement/exportPeople?organId="+this.listQuery.organId+"&ids="+t.join(",")+"&access_token="+this.$store.state.user.token}},importFile:function(){this.importFileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.importFileDialog=!1},submitFile:function(){this.$refs.upload.submit()},successFile:function(){var t=this;this.$message({type:"success",message:"上传成功!",onClose:function(){t.closeFileDialog()}})},errorFile:function(){this.$message({type:"info",message:"上传失败！"})},backFn:function(){this.$emit("openDetail","1")}}},c=r,u=(i("5281"),i("2877")),d=Object(u["a"])(c,s,a,!1,null,"123d9e6f",null);e["default"]=d.exports}}]);