(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d5139a10"],{"1b98":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container1",staticStyle:{"background-color":"#ffffff",margin:"0 10px 20px"}},[a("div",{staticClass:"app-content1"},[a("div",{staticStyle:{cursor:"pointer"},on:{click:function(e){return e.stopPropagation(),t.toggleShow(e)}}},[a("title-card",{attrs:{"title-text":t.cardTitle}})],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.showStatistics,expression:"showStatistics"}],staticClass:"div1"},[a("div",{staticClass:"hSty zwl"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.sjzwrs,"实际在位人数",t.totalInfo.sjzwrs)}},[t._m(0),t._v(" "),a("div",{staticClass:"size1"},[a("span",[t._v(t._s(t.totalInfo.sjzwrs))]),t._v(" "),a("span",{staticStyle:{"margin-left":"130px"}},[t._v(t._s(t.totalInfo.zwlv))])])])]),t._v(" "),a("div",{staticClass:"hSty bp"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.yzwrs,"应在位人数",t.totalInfo.yzwrs)}},[a("div",[t._v("\n            应在位人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.yzwrs)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty qb"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.xjrs,"休假人数",t.totalInfo.xjrs)}},[a("div",[t._v("\n            休假人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.xjrs)+"\n          ")])])]),t._v(" "),a("div",{staticClass:"hSty xj"},[a("div",{staticClass:"wz",attrs:{title:t._f("fileTitle")(t.totalInfo.qjrs,"请假人数",t.totalInfo.qjrs)}},[a("div",[t._v("\n            请假人数（人）\n          ")]),t._v(" "),a("div",{staticClass:"size1"},[t._v("\n            "+t._s(t.totalInfo.qjrs)+"\n          ")])])])])]),t._v(" "),a("div",{staticStyle:{"margin-top":"20px","border-radius":"5px","background-color":"#ffffff"}},[a("title-card",{attrs:{"title-text":t.cardTitle1}}),t._v(" "),a("el-button",{staticStyle:{float:"right","margin-top":"-40px","margin-right":"20px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFile}},[t._v("导出")]),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:"","highlight-current-row":""},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),t._v(" "),a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"单位名称",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.name))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"应在位人数","min-width":"200px"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.yzwrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"实际在位人数",width:"200px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.sjzwrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"人员在位率",width:"200px"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.zwrate))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"请假人数",align:"center",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.qjrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"休假人数","class-name":"status-col",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.xjrs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"230","class-name":"small-padding fixed-width"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return["1"===i.status?a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.handleUpdate(i)}}},[t._v("查看")]):t._e()]}}])})],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getJuList}})],1)],1)])},s=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("span",[t._v("实际在位人数(人)")]),t._v(" "),a("span",{staticStyle:{"margin-left":"30px"}},[t._v("人员在位率(%)")])])}],n=a("c03e"),l=a("35b7"),o=a("333d"),r={name:"PersonStatusDepart",components:{TitleCard:l["a"],Pagination:o["a"]},filters:{fileTitle:function(t,e){return e+"："+t}},data:function(){return{cardTitle:"全局人员情况",cardTitle1:"各局人员统计表",tableKey:0,list:null,total:0,listLoading:!1,listQuery:{page:1,limit:20},collectList:[],totalInfo:{zwlv:0,yzwrs:0,xjrs:0,qjrs:0,sjzwrs:0},showStatistics:!0}},created:function(){this.getTotalJu(),this.getJuList()},methods:{toggleShow:function(){this.showStatistics=!this.showStatistics},getTotalJu:function(){var t=this,e={status:0};Object(n["b"])(e).then(function(e){500===e.data.code||(t.totalInfo=e.data)})},getJuList:function(){var t=this;this.listLoading=!0,Object(n["a"])(this.listQuery).then(function(e){(500!==e.data.code||e.data.page)&&(t.list=e.data.page.list,t.total=e.data.page.totalCount),setTimeout(function(){t.listLoading=!1},200)})},handleUpdate:function(t){this.$emit("openDetail","2",t)},handleSelectionChange:function(t){this.collectList=t},exportFile:function(){if(this.collectList.length<1)this.$notify({title:"提示",message:"请选择需要导出的数据",duration:500,type:"warning"});else{var t=[];for(var e in this.collectList)t.push(this.collectList[e].id);window.location.href="xlgl/peopleManagement/export?organIds="+t.join(",")+"&access_token="+this.$store.state.user.token}}}},c=r,u=(a("79e6"),a("2877")),d=Object(u["a"])(c,i,s,!1,null,"358eaf5a",null);e["default"]=d.exports},"79e6":function(t,e,a){"use strict";var i=a("d63e"),s=a.n(i);s.a},c03e:function(t,e,a){"use strict";a.d(e,"b",function(){return s}),a.d(e,"a",function(){return n}),a.d(e,"c",function(){return l});var i=a("b775");function s(t){return Object(i["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function n(t){return Object(i["a"])({url:"/app/xlgl/peopleManagement/list",method:"post",data:t})}function l(t){return Object(i["a"])({url:"/app/xlgl/peopleManagement/qxjUserInfoList",method:"post",data:t})}},d63e:function(t,e,a){}}]);