(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d1aec23e"],{"12b0":function(t,e,a){"use strict";var i=a("9b4d"),s=a.n(i);s.a},6237:function(t,e,a){"use strict";a.d(e,"f",function(){return s}),a.d(e,"b",function(){return n}),a.d(e,"h",function(){return l}),a.d(e,"a",function(){return o}),a.d(e,"d",function(){return r}),a.d(e,"c",function(){return c}),a.d(e,"e",function(){return p}),a.d(e,"g",function(){return u}),a.d(e,"j",function(){return d}),a.d(e,"i",function(){return v});var i=a("b775");function s(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function n(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function l(t){return Object(i["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function o(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function r(t){return Object(i["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function c(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function p(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function u(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}function d(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function v(t){return Object(i["a"])({url:"/app/xlgl/xlglexamanswer/saveBatchLIANXI",method:"post",data:t})}},8438:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:30}},[a("el-col",{staticStyle:{"background-color":"#ffffff","padding-bottom":"10px"},attrs:{span:18}},[a("title-card",{attrs:{"title-text":t.filterTestName+"("+t.testTime+")",title:t.cardTitle}}),t._v(" "),a("el-button",{staticStyle:{float:"right",cursor:"pointer","margin-top":"-40px","margin-right":"80px"},attrs:{type:"primary",size:"mini"},on:{click:t.openOriginTest}},[t._v("查看原题")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer","margin-top":"-30px","margin-right":"20px"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),a("div",{staticClass:"rateDiv"},[a("ul",{staticClass:"ulSty"},[a("li",[t._v("\n            参考率：\n            "),a("span",{staticClass:"color1 size1"},[t._v(t._s(t.info.raioAll)+"%")])]),t._v(" "),a("li",[t._v("\n            参考人数：\n            "),a("span",{staticClass:"color2 size1"},[t._v(t._s(t.info.peopleNum)+"人")])]),t._v(" "),a("li",[t._v("\n            需补考人数：\n            "),a("span",{staticClass:"color3 size1"},[t._v(t._s(t.info.fillUpNum)+"人")])]),t._v(" "),a("li",[t._v("\n            优秀率：\n            "),a("span",{staticClass:"color1 size1"},[t._v(t._s(t.info.excellent)+"%")])]),t._v(" "),a("li",[t._v("\n            优良率：\n            "),a("span",{staticClass:"color2 size1"},[t._v(t._s(t.info.fine)+"%")])]),t._v(" "),a("li",[t._v("\n            及格率：\n            "),a("span",{staticClass:"color3 size1"},[t._v(t._s(t.info.pass)+"%")])])])]),t._v(" "),a("div",[a("div",{staticStyle:{"margin-bottom":"20px"}},[a("el-input",{staticStyle:{width:"20%"},attrs:{placeholder:"请输入答题人部门"},model:{value:t.listQuery.organName,callback:function(e){t.$set(t.listQuery,"organName",e)},expression:"listQuery.organName"}}),t._v(" "),a("el-input",{staticStyle:{width:"20%"},attrs:{placeholder:"请输入答题人名称"},model:{value:t.listQuery.replyUserName,callback:function(e){t.$set(t.listQuery,"replyUserName",e)},expression:"listQuery.replyUserName"}}),t._v(" "),"first"===t.activeName?a("el-select",{staticClass:"filter-item",staticStyle:{width:"130px"},attrs:{placeholder:"是否已补考",clearable:""},on:{change:t.getRepeatTestList},model:{value:t.listQuery.makeupStatus,callback:function(e){t.$set(t.listQuery,"makeupStatus",e)},expression:"listQuery.makeupStatus"}},[a("el-option",{attrs:{label:"正常",value:0}}),t._v(" "),a("el-option",{attrs:{label:"补考",value:1}})],1):t._e(),t._v(" "),a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.getRepeatTestList}},[t._v("查询")])],1),t._v(" "),a("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{staticStyle:{height:"calc(100vh - 420px)",overflow:"hidden"},attrs:{label:"已考人员清单",name:"first"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,attrs:{data:t.list,border:"",fit:""}},[a("el-table-column",{attrs:{label:"姓名",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.replyUserName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"部门",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.organName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"成绩",width:"170px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.fractionsum))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"考试方式",width:"170px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(t._f("bkFilter")(i.makeupStatus)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"等级",width:"250px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.level))])]}}])})],1)],1)],1),t._v(" "),a("el-tab-pane",{staticStyle:{height:"calc(100vh - 420px)",overflow:"hidden"},attrs:{label:"未考人员清单",name:"second"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,attrs:{data:t.list,border:"",fit:""}},[a("el-table-column",{attrs:{label:"姓名",align:"center","min-width":"150px"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.replyUserName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"部门",width:"400px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.organName))])]}}])})],1)],1)],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getRepeatTestList}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-row",{staticStyle:{height:"calc(100vh - 100px)",overflow:"hidden"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[a("el-col",{staticClass:"div2",attrs:{span:24}},[a("div",[a("div",{staticClass:"div3"},[a("svg-icon",{staticClass:"icon imgP",attrs:{"icon-class":"xinwen"}}),t._v(" "),a("el-col",{attrs:{span:12}},[a("div",{staticClass:"div4"},[t._v("\n                    原考题配比"),a("br")]),t._v(" "),a("div",{staticClass:"div4"},[t._v("\n                    "+t._s(t._f("textFileter")(t.originalTopic.length))+"题型比例\n                  ")])]),t._v(" "),a("el-col",{attrs:{span:8}},[t._v("\n                  "+t._s(t.originalTopic.totalNum)+"题"+t._s(t.originalTopic.totalGrade)+"分\n                ")])],1),t._v(" "),a("div",t._l(t.originalTopic,function(e,i){return a("el-col",{key:i,staticClass:"div5",attrs:{span:12}},[a("el-col",{staticStyle:{"line-height":"80px"},attrs:{span:12}},[t._v("\n                    "+t._s(t._f("typeFilter")(e.topicType))+"\n                  ")]),t._v(" "),a("el-col",{attrs:{span:12}},[a("div",{staticClass:"div4"},[t._v("\n                      "+t._s(e.numberAll)+"分\n                    ")]),t._v(" "),a("div",{staticClass:"div4"},[t._v("\n                      "+t._s(e.typeCount)+"题\n                    ")])])],1)}),1)])]),t._v(" "),a("el-col",{staticClass:"div2",staticStyle:{"margin-top":"20px"},attrs:{span:24}},[a("div",[a("div",{staticClass:"div3"},[a("svg-icon",{staticClass:"icon imgP",attrs:{"icon-class":"benyue"}}),t._v(" "),a("el-col",{attrs:{span:12}},[a("div",{staticClass:"div4"},[t._v("\n                    补考题配比"),a("br")]),t._v(" "),a("div",{staticClass:"div4"},[t._v("\n                    "+t._s(t._f("textFileter")(t.topicTypeCount.length))+"题型比例\n                  ")])])],1),t._v(" "),t.topicTypeCount.length>0?a("div",t._l(t.topicTypeCount,function(e,i){return a("el-col",{key:i,staticClass:"div5",attrs:{span:12}},[a("el-col",{staticStyle:{"line-height":"80px"},attrs:{span:12}},[t._v("\n                    "+t._s(t._f("typeFilter")(e.topicType))+"\n                  ")]),t._v(" "),a("el-col",{attrs:{span:12}},[a("div",{staticClass:"div4"},[t._v("\n                      "+t._s(e.numberAll)+"分\n                    ")]),t._v(" "),a("div",{staticClass:"div4"},[t._v("\n                      "+t._s(e.typeCount)+"题\n                    ")])])],1)}),1):t._e(),t._v(" "),"0"!==t.show&&"1"!==t.show&&"3"!==t.show||"0"!==t.info.examine.makeupStatus||"1"!==t.overStatus?t._e():a("el-col",{attrs:{span:24}},[a("el-button",{staticStyle:{width:"100%",height:"40px","font-size":"1rem"},attrs:{type:"success",size:"mini"},on:{click:t.repeatSet}},[t._v("发起补考")])],1)],1)])],1)],1)],1)],1)],1)},s=[],n=(a("7f7f"),a("35b7")),l=a("333d"),o=a("6237"),r={name:"RepeatTest",components:{TitleCard:n["a"],Pagination:l["a"]},filters:{bkFilter:function(t){return"0"===t?"正常":"1"===t?"补考":void 0},typeFilter:function(t){return"1"===t?"单选题":"2"===t?"多选题":"3"===t?"判断题":"4"===t?"填空题":"5"===t?"简答题":void 0},textFileter:function(t){return 0===t?"零":1===t?"一":2===t?"二":3===t?"三":4===t?"四":5===t?"五":void 0}},props:{testId:{type:String,default:""},testName:{type:String,default:""},testTime:{type:String,default:""},finishStatus:{type:String,default:""},overStatus:{type:String,default:""}},data:function(){return{cardTitle:this.testName+"("+this.testTime+")",listQuery:{page:1,limit:20,isNotExam:0,makeupStatus:"",organName:"",replyUserName:""},listLoading:!1,tableKey:0,list:null,total:0,activeName:"first",info:{excellent:0,fillUpNum:0,fine:0,pass:0,peopleNum:0,raioAll:0},topicTypeCount:[],originalTopic:[],show:this.$store.state.user.userInfo.adminFlag,topicType_list:[]}},computed:{filterTestName:function(){return this.testName.length<20?this.testName:this.testName.substring(0,20)+"..."}},created:function(){this.listQuery.isNotExam=1,this.getRepeatTestList(),this.getExamineTotal(),this.getTopicTypeCount()},methods:{handleClick:function(t,e){"first"===t.name?this.listQuery.isNotExam=1:(this.listQuery.isNotExam=0,this.listQuery.makeupStatus=""),this.getRepeatTestList()},getRepeatTestList:function(){var t=this;this.listQuery.examineId=this.testId,this.listQuery.status=0,Object(o["d"])(this.listQuery).then(function(e){t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},getExamineTotal:function(){var t=this,e={examineId:this.testId};Object(o["c"])(e).then(function(e){t.info=e.data})},getTopicTypeCount:function(){var t=this,e={examineId:this.testId};Object(o["e"])(e).then(function(e){if(t.topicTypeCount="0"===e.data.makeUpTopic?[]:e.data.makeUpTopic,t.originalTopic="0"===e.data.originalTopic?[]:e.data.originalTopic,e.data.originalTopic.length>0)for(var a in t.originalTopic.totalGrade=0,t.originalTopic.totalNum=0,t.originalTopic){if("totalGrade"!==a&&"totalNum"!==a){var i=t.originalTopic[a];t.originalTopic.totalGrade+=parseInt(i.numberAll),t.originalTopic.totalNum+=parseInt(i.typeCount)}t.topicType_list.push(t.originalTopic[a].topicType)}else t.originalTopic.totalGrade=parseInt(0),t.originalTopic.totalNum=parseInt(0)})},goBack:function(){this.$emit("showPage","1")},repeatSet:function(){var t={id:this.testId,testName:this.testName,testTime:this.testTime,topicType_list:this.topicType_list};this.$emit("showPage","6",t)},openOriginTest:function(){if("2"===this.finishStatus)this.$notify({title:"提示",message:"您尚未参加考试，没有查看权限！",duration:1500,type:"warning"});else{var t={id:this.testId,examineId:this.testId,flag:"1"};this.$emit("showPage","3",t)}}}},c=r,p=(a("12b0"),a("2877")),u=Object(p["a"])(c,i,s,!1,null,"518cc214",null);e["default"]=u.exports},"9b4d":function(t,e,a){}}]);