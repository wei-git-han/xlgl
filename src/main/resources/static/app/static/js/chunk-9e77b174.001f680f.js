(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-9e77b174"],{"374b":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:24}},[a("el-card",{staticClass:"margin-card",attrs:{"body-style":{padding:"0px 10px"}}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("el-row",[a("el-col",{attrs:{span:10}},[a("span",[t._v("进行中考试：")]),t._v(" "),a("span",{staticClass:"intoSty"},[t._v(t._s(t.conutInto.into))]),t._v(" "),a("span",[t._v("已完成考试：")]),t._v(" "),a("span",{staticClass:"intoNotSty"},[t._v(t._s(t.conutInto.intoNot))])]),t._v(" "),a("el-col",{attrs:{span:14}},[a("span",{staticClass:"demonstration"},[t._v("发起时间")]),t._v(" "),a("el-date-picker",{attrs:{type:"datetime",placeholder:"选择日期时间",align:"right"},model:{value:t.listQuery.time,callback:function(e){t.$set(t.listQuery,"time",e)},expression:"listQuery.time"}}),t._v(" "),a("el-input",{staticStyle:{width:"240px"},attrs:{placeholder:"请输入考试标题"},model:{value:t.listQuery.examineName,callback:function(e){t.$set(t.listQuery,"examineName",e)},expression:"listQuery.examineName"}}),t._v(" "),a("el-button",{staticStyle:{"margin-left":"50px"},attrs:{size:"mini",type:"primary"},on:{click:t.getTrainList}},[t._v("查询")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"50px"},attrs:{size:"mini",type:"success"},on:{click:t.testPractice}},[t._v("自主考试练习")])],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"20px"}},[a("el-col",{staticStyle:{height:"calc(100vh - 300px)",overflow:"hidden"},attrs:{span:24}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,attrs:{data:t.list,border:"",fit:"",stripe:""},on:{"row-click":t.openTestPaper}},[a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"考试名称",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(n.examineName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"考试科目",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(n.examineSubjectName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"考试截止时间",width:"170px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(n.examineEndDate))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"当前状态",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return["0"===n.overStatus?a("span",{staticClass:"color color1"},[t._v(t._s(t._f("overStatusFilter")(n.overStatus)))]):t._e(),t._v(" "),"1"===n.overStatus?a("span",{staticClass:"color color2"},[t._v(t._s(t._f("overStatusFilter")(n.overStatus)))]):t._e(),t._v(" "),"2"===n.overStatus?a("span",{staticClass:"color color3"},[t._v(t._s(t._f("overStatusFilter")(n.overStatus)))]):t._e(),t._v(" "),"99"===n.overStatus?a("span",{staticClass:"color color4"},[t._v(t._s(t._f("overStatusFilter")(n.overStatus)))]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"参考率",align:"center",width:"120px"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(n.ratio))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"已参加人数",width:"100px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(n.numberInto))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"需要补考人数",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(n.numberIntoNot))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"完成状态",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(t._f("userStatusFilter")(n.userStatus)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"发布时间",width:"170px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var n=e.row;return[a("span",[t._v(t._s(n.issueDate))])]}}])})],1)],1)],1)],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getTrainList}})],1)],1)],1)],1)},s=[],i=a("6237"),l=a("333d"),r={name:"ComplexTable",components:{Pagination:l["a"]},filters:{overStatusFilter:function(t){return"0"===t?"进行中":"1"===t?"已完结":"2"===t?"补考中":"99"===t?"未开始":void 0},userStatusFilter:function(t){return"1"===t?"已完成":"2"===t?"未考试":"3"===t?"已补考":void 0}},data:function(){return{conutInto:{into:0,intoNot:0},showGradeResult:!1,tableKey:0,list:null,total:0,listLoading:!0,listQuery:{page:1,limit:20,issueDate:"",examineName:""}}},created:function(){this.getConutInto(),this.getTrainList()},methods:{getConutInto:function(){var t=this;Object(i["a"])().then(function(e){t.conutInto=e.data})},getTrainList:function(){var t=this;this.listLoading=!0,Object(i["f"])(this.listQuery).then(function(e){t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1500)})},openTestPaper:function(t,e,a){var n=this;"99"===t.overStatus?this.$message({type:"info",message:"还未到考试时间，请等待！"}):"0"===t.overStatus?"2"===t.userStatus?this.$confirm("是否确定要开始考试，考试后不可中途离开此页面，否则将强制交卷。","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.$emit("showTestPaper","2",t)}).catch(function(){n.$message({type:"info",message:"已取消"})}):this.$emit("showTestPaper","5",t):"1"===t.overStatus?this.$emit("showTestPaper","5",t):"2"===t.overStatus&&("2"===t.userStatus?this.$confirm("是否确定要开始考试，考试后不可中途离开此页面，否则将强制交卷。","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.$emit("showTestPaper","2",t)}).catch(function(){n.$message({type:"info",message:"已取消"})}):this.$emit("showTestPaper","5",t))},testPractice:function(){this.$emit("showTestPaper","7")}}},o=r,u=(a("aa3a"),a("2877")),c=Object(u["a"])(o,n,s,!1,null,"655b3d75",null);e["default"]=c.exports},6237:function(t,e,a){"use strict";a.d(e,"f",function(){return s}),a.d(e,"b",function(){return i}),a.d(e,"h",function(){return l}),a.d(e,"a",function(){return r}),a.d(e,"d",function(){return o}),a.d(e,"c",function(){return u}),a.d(e,"e",function(){return c}),a.d(e,"g",function(){return p}),a.d(e,"j",function(){return d}),a.d(e,"i",function(){return m});var n=a("b775");function s(t){return Object(n["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function i(t){return Object(n["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function l(t){return Object(n["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function r(t){return Object(n["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function o(t){return Object(n["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}function d(t){return Object(n["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function m(t){return Object(n["a"])({url:"/app/xlgl/xlglexamanswer/saveBatchLIANXI",method:"post",data:t})}},aa3a:function(t,e,a){"use strict";var n=a("dd7c"),s=a.n(n);s.a},dd7c:function(t,e,a){}}]);