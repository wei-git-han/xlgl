(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0d7aa020","chunk-fc156530","chunk-12d492aa"],{"0f58":function(t,e,a){"use strict";var i=a("32be"),s=a.n(i);s.a},"1b98":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("div",{staticStyle:{cursor:"pointer"},on:{click:function(e){return e.stopPropagation(),t.toggleShow(e)}}},[a("title-card",{attrs:{"title-text":t.cardTitle}})],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.showStatistics,expression:"showStatistics"}],staticClass:"div1"},[a("div",{staticClass:"hSty zwl"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.zwlv,"人员在位率",t.totalInfo.zwlv)}},[a("div",[t._v("\n            人员在位率（%）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.zwlv)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty bp"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.yzwrs,"应在位人数",t.totalInfo.yzwrs)}},[a("div",[t._v("\n            应在位人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.yzwrs)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty qb"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.xjrs,"休假人数",t.totalInfo.xjrs)}},[a("div",[t._v("\n            休假人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.xjrs)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty xj"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.qjrs,"请假人数",t.totalInfo.qjrs)}},[a("div",[t._v("\n            请假人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.qjrs)+"\n          ")])])])])]),t._v(" "),a("div",{staticStyle:{"margin-top":"20px","border-radius":"5px","background-color":"#ffffff"}},[a("title-card",{attrs:{"title-text":t.cardTitle1}}),t._v(" "),a("el-button",{staticStyle:{float:"right","margin-top":"-40px","margin-right":"20px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFile}},[t._v("导出")]),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:"","highlight-current-row":""},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),t._v(" "),a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"单位名称",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.name))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"应在位人数","min-width":"200px"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.yzwrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"实际在位人数",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.sjzwrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"人员在位率",width:"200px"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.zwrate))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"请假人数",align:"center",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.qjrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"休假人数","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.xjrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"230","class-name":"small-padding fixed-width"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return["1"===i.status?a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.handleUpdate(i)}}},[t._v("查看")]):t._e()]}}])})],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getJuList}})],1)],1)])},s=[],l=a("c03e"),n=a("35b7"),o=a("333d"),r={name:"PersonStatusDepart",components:{TitleCard:n["a"],Pagination:o["a"]},filters:{fileTitle:function(t,e){return e+"："+t}},data:function(){return{cardTitle:"全局人员情况",cardTitle1:"各局人员统计表",tableKey:0,list:null,total:0,listLoading:!1,listQuery:{page:1,limit:20},collectList:[],totalInfo:{zwlv:0,yzwrs:0,xjrs:0,qjrs:0},showStatistics:!0}},created:function(){this.getTotalJu(),this.getJuList()},methods:{toggleShow:function(){this.showStatistics=!this.showStatistics},getTotalJu:function(){var t=this,e={status:0};Object(l["b"])(e).then(function(e){500===e.data.code||(t.totalInfo=e.data)})},getJuList:function(){var t=this;this.listLoading=!0,Object(l["a"])(this.listQuery).then(function(e){(500!==e.data.code||e.data.page)&&(t.list=e.data.page.list,t.total=e.data.page.totalCount),setTimeout(function(){t.listLoading=!1},1500)})},handleUpdate:function(t){this.$emit("openDetail","2",t)},handleSelectionChange:function(t){this.collectList=t},exportFile:function(){if(this.collectList.length<1)this.$message({message:"请选择需要导出的数据",type:"info"});else{var t=[];for(var e in this.collectList)t.push(this.collectList[e].id);window.location.href="app/xlgl/peopleManagement/export?organIds="+t.join(",")+"&access_token="+this.$store.state.user.token}}}},c=r,u=(a("4ac4"),a("2877")),d=Object(u["a"])(c,i,s,!1,null,"729a9c3e",null);e["default"]=d.exports},"2cae":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",["2"===t.showPage?a("depart",{attrs:{id:t.id},on:{openDetail:t.changePage}}):t._e(),t._v(" "),"1"===t.showPage?a("ju",{on:{openDetail:t.changePage}}):t._e()],1)},s=[],l=a("d91d"),n=a("1b98"),o={name:"PersonIndex",components:{depart:l["default"],ju:n["default"]},data:function(){return{showPage:"1",id:""}},methods:{changePage:function(t,e){"2"===t&&(this.id=e.id),this.showPage=t}}},r=o,c=a("2877"),u=Object(c["a"])(r,i,s,!1,null,"67eb454e",null);e["default"]=u.exports},"32be":function(t,e,a){},"4ac4":function(t,e,a){"use strict";var i=a("bffd"),s=a.n(i);s.a},bffd:function(t,e,a){},c03e:function(t,e,a){"use strict";a.d(e,"b",function(){return s}),a.d(e,"a",function(){return l}),a.d(e,"c",function(){return n});var i=a("b775");function s(t){return Object(i["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function l(t){return Object(i["a"])({url:"/app/xlgl/peopleManagement/list",method:"post",data:t})}function n(t){return Object(i["a"])({url:"/app/xlgl/peopleManagement/qxjUserInfoList",method:"post",data:t})}},d91d:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("div",{staticStyle:{cursor:"pointer"},on:{click:function(e){return e.stopPropagation(),t.toggleShow(e)}}},[a("title-card",{attrs:{"title-text":t.cardTitle}})],1),t._v(" "),a("svg-icon",{staticClass:"icon btn1",attrs:{"icon-class":"goback"},on:{click:t.backFn}}),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.showStatistics,expression:"showStatistics"}],staticClass:"div1"},[a("div",{staticClass:"hSty zwl"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.zwlv,"人员在位率",t.totalInfo.zwlv)}},[a("div",[t._v("\n            人员在位率（%）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.zwlv)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty bp"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.yzwrs,"应在位人数",t.totalInfo.yzwrs)}},[a("div",[t._v("\n            应在位人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.yzwrs)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty qb"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.xjrs,"休假人数",t.totalInfo.xjrs)}},[a("div",[t._v("\n            休假人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.xjrs)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty xj"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.qjrs,"请假人数",t.totalInfo.qjrs)}},[a("div",[t._v("\n            请假人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.qjrs)+"\n          ")])])])])],1),t._v(" "),a("div",{staticStyle:{"margin-top":"20px","border-radius":"5px","background-color":"#ffffff"}},[a("title-card",{attrs:{"title-text":t.cardTitle1}}),t._v(" "),a("el-button",{staticStyle:{float:"right","margin-top":"-40px","margin-right":"20px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFile}},[t._v("导出")]),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:"","highlight-current-row":""},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),t._v(" "),a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-popover",{attrs:{trigger:"hover",placement:"top"}},[a("p",[t._v("应休天数: "+t._s(e.row.QXJtotalDays))]),t._v(" "),a("p",[t._v("未休天数: "+t._s(e.row.QXJweixiujiaDays))]),t._v(" "),a("p",[t._v("已休天数: "+t._s(e.row.QXJxiuJiaDays))]),t._v(" "),a("p",[t._v("请假类型: "+t._s(e.row.QXJtype))]),t._v(" "),a("p",[t._v("起止时间: "+t._s(e.row.QXJstartDate)+" ~ "+t._s(e.row.QXJendDate))]),t._v(" "),a("div",{staticClass:"name-wrapper",attrs:{slot:"reference"},slot:"reference"},[a("el-tag",{attrs:{size:"medium"}},[t._v(t._s(e.row.fullname))])],1)])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"职务",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.post))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"座机号",width:"185px"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.telephone))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"手机号",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.mobile))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"房间号","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.address))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"部门","class-name":"status-col",width:"250"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.organName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"在位情况","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(t._f("reginFilter")(i.isShow)))])]}}])})],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.qxjUserInfoList}})],1)],1),t._v(" "),a("el-dialog",{attrs:{title:"题目导入",visible:t.importFileDialog,width:"40%",accept:".xls,.xlsx","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.importFileDialog=e}}},[a("div",{staticClass:"centerPosition"},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"auto-upload":!1,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),a("em",[t._v("点击上传")])]),t._v(" "),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传excel等格式")])])],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),a("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},s=[],l=a("c03e"),n=a("35b7"),o=a("333d"),r={name:"PersonStatusJu",components:{TitleCard:n["a"],Pagination:o["a"]},filters:{reginFilter:function(t){return 0===t?"不在":"在位"},fileTitle:function(t,e){return e+"："+t}},props:{id:{type:String,default:""}},data:function(){return{cardTitle:"单位人员情况",cardTitle1:"单位人员统计表",showStatistics:!0,tableKey:0,list:[],total:0,listLoading:!1,listQuery:{page:1,limit:20,organId:this.id},collectList:[],importFileDialog:!1,fileUploadUrl:"",fileData:{access_token:this.$store.state.user.token},totalInfo:{zwlv:0,yzwrs:0,xjrs:0,qjrs:0}}},created:function(){this.getTotalJu(),this.qxjUserInfoList()},methods:{toggleShow:function(){this.showStatistics=!this.showStatistics},getTotalJu:function(){var t=this,e={status:1};Object(l["b"])(e).then(function(e){500===e.data.code||(t.totalInfo=e.data)})},qxjUserInfoList:function(){var t=this;this.listLoading=!0,Object(l["c"])(this.listQuery).then(function(e){(500!==e.data.code||e.data.page)&&(t.list=e.data.rows,t.total=e.data.total),setTimeout(function(){t.listLoading=!1},1500)})},handleUpdate:function(t){this.$emit("openDetail","2",t)},handleSelectionChange:function(t){this.collectList=t},exportFile:function(){if(this.collectList.length<1)this.$message({message:"请选择需要导出的数据",type:"info"});else{var t=[];for(var e in this.collectList)t.push(this.collectList[e].id);window.location.href="app/xlgl/peopleManagement/exportPeople?organId="+this.listQuery.organId+"&ids="+t.join(",")+"&access_token="+this.$store.state.user.token}},importFile:function(){this.importFileDialog=!0},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.importFileDialog=!1},submitFile:function(){this.$refs.upload.submit()},successFile:function(){var t=this;this.$message({type:"success",message:"上传成功!",onClose:function(){t.closeFileDialog()}})},errorFile:function(){this.$message({type:"info",message:"上传失败！"})},backFn:function(){this.$emit("openDetail","1")}}},c=r,u=(a("0f58"),a("2877")),d=Object(u["a"])(c,i,s,!1,null,"0934dc34",null);e["default"]=d.exports}}]);