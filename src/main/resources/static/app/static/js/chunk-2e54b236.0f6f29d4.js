(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2e54b236","chunk-5a78c67a"],{"4d25":function(t,e,a){},"64e3":function(t,e,a){"use strict";var l=a("e852"),n=a.n(l);n.a},"899a":function(t,e,a){"use strict";var l=a("4d25"),n=a.n(l);n.a},"9b34":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},t._l(t.list.topicCount,function(e,l){return a("div",{key:l},[t.list.listType1&&t.list.listType1.length>0&&"1"===e.topicType?a("div",[a("h2",[t._v("\n        "+t._s(t._f("indexFilter")(l))+"、单选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType1,function(e,l){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(l+1)+"、"+t._s(e.topicColumn)+"\n          "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-radio-group",{model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item.reply"}},t._l(e.topicOptionMap,function(e,l){return a("el-radio",{key:l,staticStyle:{margin:"0px 100px 0px 50px"},attrs:{label:l}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType2&&t.list.listType2.length>0&&"2"===e.topicType?a("div",[a("h2",[t._v("\n        "+t._s(t._f("indexFilter")(l))+"、多选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType2,function(e,l){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(l+1)+"、"+t._s(e.topicColumn)+"\n          "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-checkbox-group",{model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item2.reply"}},t._l(e.topicOptionMap,function(e,l){return a("el-checkbox",{key:l,attrs:{label:l}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType3&&t.list.listType3.length>0&&"3"===e.topicType?a("div",[a("h2",[t._v("\n        "+t._s(t._f("indexFilter")(l))+"、判断题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType3,function(e,l){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(l+1)+"、"+t._s(e.topicColumn)+"\n          "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-radio-group",{model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item3.reply"}},t._l(e.topicOptionMap,function(e,l){return a("el-radio",{key:l,attrs:{label:l}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType4&&t.list.listType4.length>0&&"4"===e.topicType?a("div",[a("h2",[t._v("\n        "+t._s(t._f("indexFilter")(l))+"、填空题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType4,function(e,l){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(l+1)+"、"+t._s(e.topicColumn)+"\n          "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),a("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-input",{attrs:{type:"textarea",placeholder:"答案之间以逗号（，）分隔开"},model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item4.reply"}})],1)],1)})],2):t._e()])}),0)},n=[],s={name:"TestPaper",filters:{indexFilter:function(t){var e="";switch(t){case 0:e="一";break;case 1:e="二";break;case 2:e="三";break;case 3:e="四";break;case 4:e="五";break}return e}},props:{list:{type:Object,default:{}}},data:function(){return{}},created:function(){},methods:{}},i=s,r=(a("64e3"),a("2877")),o=Object(r["a"])(i,l,n,!1,null,"d4921ace",null);e["default"]=o.exports},e852:function(t,e,a){},ea59:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-container",[a("el-header",{staticStyle:{"margin-top":"20px"}},[a("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer","margin-right":"50px"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),a("h3",{staticStyle:{"text-align":"center"}},[t._v(" "+t._s(t.selfInfo.examineName))])],1),t._v(" "),a("el-header",{staticStyle:{"line-height":"60px"}},[a("el-row",[a("el-col",{attrs:{span:4}},[t._v("\n          姓名："+t._s(t.selfInfo.userName)+"\n        ")]),t._v(" "),a("el-col",{attrs:{span:4}},[t._v("\n          时间："+t._s(t.selfInfo.time)+"\n        ")]),t._v(" "),a("el-col",{attrs:{span:4}},[t._v("\n          单位："+t._s(t.selfInfo.orgName)+"\n        ")])],1)],1),t._v(" "),a("el-main",[a("h2",{staticStyle:{"text-align":"center"}},[t._v("恭喜您，答题已完成，本次考试的成绩为："),a("span",{staticClass:"spanSty spanSty1"},[t._v(" "+t._s(t.selfInfo.fractionsum))]),t._v("分，"),a("span",{staticClass:"spanSty"},[t._v(t._s(t.selfInfo.level))]),t._v("等级")]),t._v(" "),a("el-tabs",{on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"考试概况",name:"first"}},[a("test-content",{attrs:{list:t.list}})],1),t._v(" "),a("el-tab-pane",{attrs:{label:"已结人员清单",name:"second"}},[a("el-table",{staticClass:"new-table",staticStyle:{width:"100%"},attrs:{data:t.tableData,border:"",stripe:"",fit:!0}},[a("el-table-column",{attrs:{prop:"replyUserName",label:"已考人员",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"organName",label:"单位",align:"center","min-width":"300"}}),t._v(" "),a("el-table-column",{attrs:{prop:"fractionsum",label:"成绩",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"level",label:"等级",align:"center"}})],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getAllGradeList}})],1)],1)],1)],1)],1)},n=[],s=(a("28a5"),a("7f7f"),a("f2d1")),i=a("333d"),r=a("9b34"),o={name:"GradeResult",components:{Pagination:i["a"],testContent:r["default"]},props:{testId:{type:String,default:""},examineId:{type:String,default:""},flag:{type:String,default:""}},data:function(){return{selfInfo:null,tableData:[],listQuery:{page:1,limit:20,examineId:this.examineId,isNotExam:1,status:0,makeupStatus:0},list:null,total:0,activeName:"first"}},created:function(){this.getSelfInfo(),this.getTestInfo()},methods:{getSelfInfo:function(){var t=this,e={mainAnswerId:this.testId};this.flag&&"1"===this.flag&&(e={examineId:this.testId}),Object(s["b"])(e).then(function(e){t.selfInfo=e.data})},getAllGradeList:function(){var t=this;Object(s["a"])(this.listQuery).then(function(e){t.tableData=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},handleClick:function(t,e){"second"===t.name?this.getAllGradeList():this.getTestInfo()},getTestInfo:function(){var t=this,e={examineId:this.examineId};Object(s["c"])(e).then(function(e){var a=e.data;if(a.listType2&&a.listType2.length>0)for(var l in a.listType2)a.listType2[l].reply=a.listType2[l].topicResult.split("");t.list=a})},goBack:function(){this.$emit("showTestPaper","1")}}},c=o,p=(a("899a"),a("2877")),u=Object(p["a"])(c,l,n,!1,null,"17158c44",null);e["default"]=u.exports},f2d1:function(t,e,a){"use strict";a.d(e,"b",function(){return n}),a.d(e,"a",function(){return s}),a.d(e,"c",function(){return i}),a.d(e,"d",function(){return r});var l=a("b775");function n(t){return Object(l["a"])({url:"/app/xlgl/xlglexammainanswer/getMainAnsUser",method:"post",data:t})}function s(t){return Object(l["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function i(t){return Object(l["a"])({url:"/app/xlgl/xlglexamanswer/view/info",method:"post",data:t})}function r(t){return Object(l["a"])({url:"/app/xlgl/xlglexamanswer/view/infoLianXi",method:"post",data:t})}}}]);