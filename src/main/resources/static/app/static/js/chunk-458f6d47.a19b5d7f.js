(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-458f6d47","chunk-5a78c67a"],{"09f4":function(t,e,n){"use strict";n.d(e,"a",function(){return i}),Math.easeInOutQuad=function(t,e,n,a){return t/=a/2,t<1?n/2*t*t+e:(t--,-n/2*(t*(t-2)-1)+e)};var a=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function s(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function l(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function i(t,e,n){var i=l(),r=t-i,o=20,c=0;e="undefined"===typeof e?500:e;var p=function t(){c+=o;var l=Math.easeInOutQuad(c,i,r,e);s(l),c<e?a(t):n&&"function"===typeof n&&n()};p()}},"51d7":function(t,e,n){},"64e3":function(t,e,n){"use strict";var a=n("e852"),s=n.n(a);s.a},"9b34":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},t._l(t.list.topicCount,function(e,a){return n("div",{key:a},[t.list.listType1&&t.list.listType1.length>0&&"1"===e.topicType?n("div",[n("h2",[t._v("\n        "+t._s(t._f("indexFilter")(a))+"、单选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType1,function(e,a){return n("el-row",{key:e.id,staticClass:"gapSty borderB"},[n("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(a+1)+"、"+t._s(e.topicColumn)+"\n          "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),n("el-col",{attrs:{span:24}},[n("el-radio-group",{model:{value:e.reply,callback:function(n){t.$set(e,"reply",n)},expression:"item.reply"}},t._l(e.topicOptionMap,function(e,a){return n("el-radio",{key:a,staticStyle:{margin:"0px 100px 0px 50px"},attrs:{label:a}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType2&&t.list.listType2.length>0&&"2"===e.topicType?n("div",[n("h2",[t._v("\n        "+t._s(t._f("indexFilter")(a))+"、多选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType2,function(e,a){return n("el-row",{key:e.id,staticClass:"gapSty borderB"},[n("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(a+1)+"、"+t._s(e.topicColumn)+"\n          "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),n("el-col",{attrs:{span:24}},[n("el-checkbox-group",{model:{value:e.reply,callback:function(n){t.$set(e,"reply",n)},expression:"item2.reply"}},t._l(e.topicOptionMap,function(e,a){return n("el-checkbox",{key:a,attrs:{label:a}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType3&&t.list.listType3.length>0&&"3"===e.topicType?n("div",[n("h2",[t._v("\n        "+t._s(t._f("indexFilter")(a))+"、判断题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType3,function(e,a){return n("el-row",{key:e.id,staticClass:"gapSty borderB"},[n("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(a+1)+"、"+t._s(e.topicColumn)+"\n          "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),n("el-col",{attrs:{span:24}},[n("el-radio-group",{model:{value:e.reply,callback:function(n){t.$set(e,"reply",n)},expression:"item3.reply"}},t._l(e.topicOptionMap,function(e,a){return n("el-radio",{key:a,attrs:{label:a}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType4&&t.list.listType4.length>0&&"4"===e.topicType?n("div",[n("h2",[t._v("\n        "+t._s(t._f("indexFilter")(a))+"、填空题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType4,function(e,a){return n("el-row",{key:e.id,staticClass:"gapSty borderB"},[n("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(a+1)+"、"+t._s(e.topicColumn)+"\n          "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),n("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),n("el-col",{attrs:{span:24}},[n("el-input",{attrs:{type:"textarea",placeholder:"答案之间以逗号（，）分隔开"},model:{value:e.reply,callback:function(n){t.$set(e,"reply",n)},expression:"item4.reply"}})],1)],1)})],2):t._e()])}),0)},s=[],l={name:"TestPaper",filters:{indexFilter:function(t){var e="";switch(t){case 0:e="一";break;case 1:e="二";break;case 2:e="三";break;case 3:e="四";break;case 4:e="五";break}return e}},props:{list:{type:Object,default:{}}},data:function(){return{}},created:function(){},methods:{}},i=l,r=(n("64e3"),n("2877")),o=Object(r["a"])(i,a,s,!1,null,"d4921ace",null);e["default"]=o.exports},adb3:function(t,e,n){"use strict";var a=n("51d7"),s=n.n(a);s.a},d4a4:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("el-container",[n("el-header",{staticStyle:{"margin-top":"20px"}},[n("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer","margin-right":"50px"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),n("h3",[t._v(" "+t._s(t.selfInfo.examineName))])],1),t._v(" "),n("el-header",{staticStyle:{"line-height":"60px"}},[n("el-row",[n("el-col",{attrs:{span:4}},[t._v("\n          姓名："+t._s(t.selfInfo.userName)+"\n        ")]),t._v(" "),n("el-col",{attrs:{span:4}},[t._v("\n          时间："+t._s(t.selfInfo.time)+"\n        ")]),t._v(" "),n("el-col",{attrs:{span:4}},[t._v("\n          单位："+t._s(t.selfInfo.orgName)+"\n        ")])],1)],1),t._v(" "),n("el-main",[n("h2",[t._v("恭喜您，答题已完成，本次考试的成绩为："),n("span",{staticClass:"spanSty spanSty1"},[t._v(" "+t._s(t.selfInfo.fractionsum))]),t._v("分，"),n("span",{staticClass:"spanSty"},[t._v(t._s(t.selfInfo.level))]),t._v("等级")]),t._v(" "),n("el-tabs",{on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[n("el-tab-pane",{attrs:{label:"考试概况",name:"first"}},[n("test-content",{attrs:{"test-id":t.testId}})],1),t._v(" "),n("el-tab-pane",{attrs:{label:"已结人员清单",name:"second"}},[n("el-table",{staticClass:"new-table",staticStyle:{width:"100%"},attrs:{data:t.tableData,border:"",fit:!0}},[n("el-table-column",{attrs:{prop:"replyUserName",label:"已考人员",align:"center"}}),t._v(" "),n("el-table-column",{attrs:{prop:"organName",label:"单位",align:"center","min-width":"300"}}),t._v(" "),n("el-table-column",{attrs:{prop:"fractionsum",label:"成绩",align:"center"}}),t._v(" "),n("el-table-column",{attrs:{prop:"level",label:"等级",align:"center"}})],1),t._v(" "),n("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getAllGradeList}})],1)],1),t._v(" "),n("div",[n("el-button",{attrs:{type:"primary",size:"mini"},on:{click:t.testAgain}},[t._v("再考一次")]),t._v(" "),n("el-button",{attrs:{type:"primary",size:"mini"},on:{click:t.testAgainSet}},[t._v("重新组考")])],1)],1)],1)],1)},s=[],l=(n("7f7f"),n("f2d1")),i=n("333d"),r=n("9b34"),o={name:"GradeResult",components:{Pagination:i["a"],testContent:r["default"]},props:{testId:{type:String,default:""}},data:function(){return{selfInfo:null,tableData:[],listQuery:{page:1,limit:20,examineId:this.testId,isNotExam:1,status:0,makeupStatus:0},activeName:"first"}},created:function(){this.getSelfInfo()},methods:{getSelfInfo:function(){var t=this;Object(l["b"])({mainAnswerId:this.testId}).then(function(e){t.selfInfo=e.data})},getAllGradeList:function(){var t=this;Object(l["a"])(this.listQuery).then(function(e){t.tableData=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1500)})},handleClick:function(t,e){"second"===t.name&&this.getAllGradeList()},goBack:function(){this.$emit("showTestPaper","1")},testAgainSet:function(){this.$emit("showTestPaper","7")},testAgain:function(){this.$emit("showTestPaper","8")}}},c=o,p=(n("adb3"),n("2877")),u=Object(p["a"])(c,a,s,!1,null,"dab48e3e",null);e["default"]=u.exports},e852:function(t,e,n){},f2d1:function(t,e,n){"use strict";n.d(e,"b",function(){return s}),n.d(e,"a",function(){return l}),n.d(e,"c",function(){return i});var a=n("b775");function s(t){return Object(a["a"])({url:"/app/xlgl/xlglexammainanswer/getMainAnsUser",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function i(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/view/info",method:"post",data:t})}}}]);