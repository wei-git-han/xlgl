(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-29aa322a","chunk-21224280","chunk-5b29f759","chunk-0c8cee64","chunk-6299969b"],{"09f4":function(t,e,a){"use strict";a.d(e,"a",function(){return l}),Math.easeInOutQuad=function(t,e,a,i){return t/=i/2,t<1?a/2*t*t+e:(t--,-a/2*(t*(t-2)-1)+e)};var i=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function n(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function s(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function l(t,e,a){var l=s(),r=t-l,o=20,u=0;e="undefined"===typeof e?500:e;var c=function t(){u+=o;var s=Math.easeInOutQuad(u,l,r,e);n(s),u<e?i(t):a&&"function"===typeof a&&a()};c()}},"1aba":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},["1"===t.showNoPublish?a("create-test",{attrs:{"test-id":t.testId},on:{showPage:t.showNoPub}}):t._e(),t._v(" "),"2"===t.showNoPublish?a("no-publish",{on:{showPage:t.showNoPub}}):t._e(),t._v(" "),"3"===t.showNoPublish?a("test-paper",{attrs:{"test-id":t.testId},on:{showTestPaper:t.showNoPub}}):t._e(),t._v(" "),"4"===t.showNoPublish?a("grade-result",{attrs:{"test-id":t.testId}}):t._e()],1)])},n=[],s=a("fa8e"),l=a("c87d"),r=a("b3c3"),o=a("ea59"),u={name:"ComplexTable",components:{CreateTest:s["default"],NoPublish:l["default"],testPaper:r["default"],GradeResult:o["default"]},data:function(){return{showNoPublish:"1",testId:""}},methods:{showNoPub:function(t,e){this.showNoPublish=t,"2"===t?this.testId=e.id:"3"===t&&(this.testId=e.fileId,this.showNoPublish=4)}}},c=u,p=(a("2def"),a("2877")),d=Object(p["a"])(c,i,n,!1,null,"21afbf6a",null);e["default"]=d.exports},"2cf9":function(t,e,a){},"2def":function(t,e,a){"use strict";var i=a("7eb0"),n=a.n(i);n.a},6237:function(t,e,a){"use strict";a.d(e,"f",function(){return n}),a.d(e,"b",function(){return s}),a.d(e,"h",function(){return l}),a.d(e,"a",function(){return r}),a.d(e,"d",function(){return o}),a.d(e,"c",function(){return u}),a.d(e,"e",function(){return c}),a.d(e,"g",function(){return p});var i=a("b775");function n(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function s(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function l(t){return Object(i["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function r(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function o(t){return Object(i["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function u(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function c(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function p(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}},"66e9":function(t,e,a){},"7eb0":function(t,e,a){},a4e0:function(t,e,a){"use strict";var i=a("66e9"),n=a.n(i);n.a},b3c3:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"borderB",staticStyle:{position:"relative",padding:"0 60px"}},[a("div",{staticClass:"title"},[t._v("\n      "+t._s(t.list.xlglExamExamine.examineName)+"\n    ")]),t._v(" "),a("div",{staticClass:"infoDiv"},[a("span",[t._v("姓名："+t._s(t.username1))]),t._v(" "),a("span",[t._v("时间："+t._s(t._f("parseTime")(new Date,"{y}-{m}-{d} {h}:{i}")))]),t._v(" "),a("span",[t._v("单位："+t._s(t.useDepart1))]),t._v(" "),a("span",{staticClass:"rightP"},[t._v("倒计时："+t._s(t.times))]),t._v(" "),a("el-button",{staticClass:"rightP",attrs:{type:"primary",size:"mini"},on:{click:t.saveBatch}},[t._v("交卷")])],1)]),t._v(" "),a("div",{staticClass:"testDiv"},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},t._l(t.list.topicCount,function(e,i){return a("div",{key:i},[t.list.listType1&&t.list.listType1.length>0&&"1"===e.topicType?a("div",[a("h2",[t._v("\n            "+t._s(t._f("indexFilter")(i))+"、单选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType1,function(e,i){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{attrs:{span:24}},[t._v(t._s(i)+"、"+t._s(e.topicColumn))]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-radio-group",{model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item.reply"}},t._l(e.topicOptionMap,function(e,i){return a("el-radio",{key:i,attrs:{label:i}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType2&&t.list.listType2.length>0&&"2"===e.topicType?a("div",[a("h2",[t._v("\n            "+t._s(t._f("indexFilter")(i))+"、多选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType2,function(e,i){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{attrs:{span:24}},[t._v(t._s(i)+"、"+t._s(e.topicColumn))]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-checkbox-group",{model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item2.reply"}},t._l(e.topicOptionMap,function(e,i){return a("el-checkbox",{key:i,attrs:{label:i}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType3&&t.list.listType3.length>0&&"3"===e.topicType?a("div",[a("h2",[t._v("\n            "+t._s(t._f("indexFilter")(i))+"、判断题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType3,function(e,i){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{attrs:{span:24}},[t._v(t._s(i)+"、"+t._s(e.topicColumn))]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-radio-group",{model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item3.reply"}},t._l(e.topicOptionMap,function(e,i){return a("el-radio",{key:i,attrs:{label:i}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType4&&t.list.listType4.length>0&&"4"===e.topicType?a("div",[a("h2",[t._v("\n            "+t._s(t._f("indexFilter")(i))+"、填空题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType4,function(e,i){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{attrs:{span:24}},[t._v(t._s(i)+"、"+t._s(e.topicColumn))]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-input",{attrs:{type:"textarea",placeholder:"答案之间以逗号（，）分隔开"},model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item4.reply"}})],1)],1)})],2):t._e(),t._v(" "),t.list.listType5&&t.list.listType5.length>0&&"5"===e.topicType?a("div",[a("h2",[t._v("\n            "+t._s(t._f("indexFilter")(i))+"、简答题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType5,function(e,i){return a("el-row",{key:e.id,staticClass:"gapSty borderB"},[a("el-col",{attrs:{span:24}},[t._v(t._s(i)+"、"+t._s(e.topicColumn))]),t._v(" "),a("el-col",{attrs:{span:24}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.reply,callback:function(a){t.$set(e,"reply",a)},expression:"item5.reply"}})],1)],1)})],2):t._e()])}),0)],1)])},n=[],s=a("6237"),l={name:"TestPaper",props:{testId:{type:String,default:""}},filters:{indexFilter:function(t){var e="";switch(t){case 0:e="一";break;case 1:e="二";break;case 2:e="三";break;case 3:e="四";break;case 4:e="五";break}return e}},created:function(){this.getExamineList()},data:function(){return{list:null,times:0,id:"",username1:this.$store.state.user.userInfo.fullname,useDepart1:this.$store.state.user.userInfo.orgName}},methods:{getExamineList:function(){var t=this,e={examineId:this.testId};Object(s["b"])(e).then(function(e){t.list=e.data,t.id=e.data.xlglExamExamine.id,t.times=parseInt(e.data.xlglExamExamine.examineDate);var a=setInterval(function(){t.times--,0===t.times&&(clearInterval(a),t.saveBatch())},1e3)})},saveBatch:function(){var t=this,e=[];this.list.listType1&&this.list.listType1.length>1&&this.list.listType1.map(function(t){t.examineTopicId=t.examineId,t.fraction=t.fractionalNumber,e.push(t)}),this.list.listType2&&this.list.listType2.length>1&&this.list.listType2.map(function(t){t.examineTopicId=t.examineId,t.fraction=t.fractionalNumber,e.push(t)}),this.list.listType3&&this.list.listType3.length>1&&this.list.listType3.map(function(t){t.examineTopicId=t.examineId,t.fraction=t.fractionalNumber,e.push(t)}),this.list.listType4&&this.list.listType4.length>1&&this.list.listType4.map(function(t){t.examineTopicId=t.examineId,t.fraction=t.fractionalNumber,e.push(t)}),this.list.listType5&&this.list.listType5.length>1&&this.list.listType5.map(function(t){t.examineTopicId=t.examineId,t.fraction=t.fractionalNumber,e.push(t)});var a={mainAnswerId:this.id,xlglExamAnswer:JSON.stringify(e)};Object(s["h"])(a).then(function(e){0===e.data.code?t.$message({type:"success",message:"交卷成功!",onClose:function(){t.$emit("showTestPaper","3",e.data)}}):t.$message({type:"info",message:e.data.msg})})}}},r=l,o=(a("eeaa"),a("2877")),u=Object(o["a"])(r,i,n,!1,null,"5b43ab2d",null);e["default"]=u.exports},b40f:function(t,e,a){},bafa:function(t,e,a){"use strict";a.d(e,"f",function(){return n}),a.d(e,"e",function(){return s}),a.d(e,"b",function(){return l}),a.d(e,"d",function(){return r}),a.d(e,"a",function(){return o}),a.d(e,"c",function(){return u});var i=a("b775");function n(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function s(){return Object(i["a"])({url:"/app/xlgl/xlglexamsubject/subjectListAll",method:"get"})}function l(t){return Object(i["a"])({url:"/app/xlgl/xlglexamsubject/findTopicBySubId",method:"post",data:t})}function r(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/issueStatusList",method:"post",data:t})}function o(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/delete",method:"post",data:t})}function u(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/info",method:"post",data:t})}},bb2b:function(t,e,a){"use strict";var i=a("e2d6"),n=a.n(i);n.a},c87d:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"pageContent"},[a("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:t.listQuery,"label-width":"150px",inline:!0}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试名称："}},[a("el-input",{model:{value:t.listQuery.examineName,callback:function(e){t.$set(t.listQuery,"examineName",e)},expression:"listQuery.examineName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.onSubmit}},[t._v("搜索")])],1)],1)],1),t._v(" "),a("div",{staticStyle:{height:"calc(100vh - 320px)",overflow:"hidden",width:"100%"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,attrs:{data:t.list,border:"",fit:"",stripe:""}},[a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"考试名称",width:"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.examineName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"考试科目","min-width":"150px",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("span",[t._v(t._s(i.examineSubjectName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"350","class-name":"small-padding fixed-width"},scopedSlots:t._u([{key:"default",fn:function(e){var i=e.row;return[a("el-button",{staticClass:"noBorder editBtn",attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:function(e){return t.handleUpdate(i)}}},[t._v("编辑")]),t._v(" "),"delete"!=i.status?a("el-button",{staticClass:"noBorder deleteBtn",attrs:{size:"mini",type:"primary",icon:"el-icon-delete"},on:{click:function(e){return t.deleteIssueStatus(i)}}},[t._v("\n                删除\n              ")]):t._e()]}}])})],1)],1)],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getIssueStatusList}})],1)])},n=[],s=a("bafa"),l=a("333d"),r={name:"NoPublish",components:{Pagination:l["a"]},data:function(){return{tableKey:0,list:null,total:0,listLoading:!0,listQuery:{examineName:"",page:1,limit:10}}},created:function(){this.getIssueStatusList()},methods:{getIssueStatusList:function(){var t=this;this.listLoading=!0,Object(s["d"])(this.listQuery).then(function(e){t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1500)})},onSubmit:function(){this.getIssueStatusList()},handleUpdate:function(t){this.$emit("showPage","1",t)},deleteIssueStatus:function(t){var e=this;Object(s["a"])({ids:t.id}).then(function(t){0===t.data.code?e.$message({type:"success",message:"删除成功!",onClose:function(){e.getIssueStatusList()}}):e.$message({type:"info",message:t.data.msg})})}}},o=r,u=(a("a4e0"),a("2877")),c=Object(u["a"])(o,i,n,!1,null,"099c73e8",null);e["default"]=c.exports},cf3c:function(t,e,a){"use strict";var i=a("b40f"),n=a.n(i);n.a},e2d6:function(t,e,a){},ea59:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-container",[a("el-header",[a("h3",[t._v(" "+t._s(t.selfInfo.examineName))])]),t._v(" "),a("el-header",{staticStyle:{"line-height":"60px"}},[a("el-row",[a("el-col",{attrs:{span:4}},[t._v("\n          姓名："+t._s(t.selfInfo.userName)+"\n        ")]),t._v(" "),a("el-col",{attrs:{span:4}},[t._v("\n          时间："+t._s(t.selfInfo.time)+"\n        ")]),t._v(" "),a("el-col",{attrs:{span:4}},[t._v("\n          单位："+t._s(t.selfInfo.orgName)+"\n        ")])],1)],1),t._v(" "),a("el-main",[a("h2",[t._v("恭喜您，答题已完成，本次考试的成绩为："),a("span",{staticClass:"spanSty spanSty1"},[t._v(" "+t._s(t.selfInfo.fractionsum))]),t._v("分，"),a("span",{staticClass:"spanSty"},[t._v(t._s(t.selfInfo.level))]),t._v("等级")]),t._v(" "),a("el-tabs",{on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"考试概况",name:"first"}},[t._v("用户管理")]),t._v(" "),a("el-tab-pane",{attrs:{label:"已结人员清单",name:"second"}},[a("el-table",{staticClass:"new-table",staticStyle:{width:"100%"},attrs:{data:t.tableData,border:"",fit:!0}},[a("el-table-column",{attrs:{prop:"replyUserName",label:"已考人员",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"organName",label:"单位",align:"center","min-width":"300"}}),t._v(" "),a("el-table-column",{attrs:{prop:"fractionsum",label:"成绩",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"level",label:"等级",align:"center"}})],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getAllGradeList}})],1)],1)],1)],1)],1)},n=[],s=(a("7f7f"),a("b775"));function l(t){return Object(s["a"])({url:"/app/xlgl/xlglexammainanswer/getMainAnsUser",method:"post",data:t})}function r(t){return Object(s["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}var o=a("333d"),u={name:"GradeResult",components:{Pagination:o["a"]},data:function(){return{selfInfo:null,tableData:[],listQuery:{page:1,limit:20,examineId:"d96c9f9b-ea97-48e8-aa3a-4c3fcd84ec7e",isNotExam:1,status:0,makeupStatus:0},activeName:"first"}},created:function(){this.getSelfInfo()},methods:{getSelfInfo:function(){var t=this;l({mainAnswerId:"9e1fe091-bc79-4f6a-b897-06adbd41b58d"}).then(function(e){t.selfInfo=e.data})},getAllGradeList:function(){var t=this;r(this.listQuery).then(function(e){t.tableData=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1500)})},handleClick:function(t,e){"second"===t.name&&this.getAllGradeList()}}},c=u,p=(a("bb2b"),a("2877")),d=Object(p["a"])(c,i,n,!1,null,"b3a0bc34",null);e["default"]=d.exports},eeaa:function(t,e,a){"use strict";var i=a("2cf9"),n=a.n(i);n.a},fa8e:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"createTest"},[a("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),a("el-button",{staticClass:"noPublish",attrs:{size:"mini",type:"primary"},on:{click:t.showNoPublish}},[t._v("查看未发布考核")]),t._v(" "),a("div",{staticClass:"pageContent"},[a("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:t.listQuery,rules:t.rules,"label-width":"150px",inline:!0}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试名称：",prop:"examineName"}},[a("el-input",{model:{value:t.listQuery.examineName,callback:function(e){t.$set(t.listQuery,"examineName",e)},expression:"listQuery.examineName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试时长：",prop:"examineDate"}},[a("el-input",{attrs:{placeholder:"请输入考试时长"},model:{value:t.listQuery.examineDate,callback:function(e){t.$set(t.listQuery,"examineDate",e)},expression:"listQuery.examineDate"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试时间：",required:""}},[a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{prop:"examineStartDateStr"}},[a("el-date-picker",{attrs:{type:"datetime","picker-options":t.pickOptionStart,placeholder:"选择开始时间"},model:{value:t.listQuery.examineStartDateStr,callback:function(e){t.$set(t.listQuery,"examineStartDateStr",e)},expression:"listQuery.examineStartDateStr"}})],1)],1),t._v(" "),a("el-col",{staticClass:"line",staticStyle:{"text-align":"center"},attrs:{span:2}},[t._v("至")]),t._v(" "),a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{prop:"examineEndDateStr"}},[a("el-date-picker",{attrs:{type:"datetime","picker-options":t.pickOptionEnd,placeholder:"选择结束时间"},model:{value:t.listQuery.examineEndDateStr,callback:function(e){t.$set(t.listQuery,"examineEndDateStr",e)},expression:"listQuery.examineEndDateStr"}})],1)],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试科目选择：",prop:"examineSubjectId"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.listQuery.examineSubjectId,callback:function(e){t.$set(t.listQuery,"examineSubjectId",e)},expression:"listQuery.examineSubjectId"}},t._l(t.subjectListAll,function(t){return a("el-option",{key:t.id,attrs:{label:t.subjectName,value:t.id}})}),1)],1)],1)],1),t._v(" "),a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",staticStyle:{"text-align":"center"},attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{float:"left"}},[t._v("题型设置")]),t._v(" "),a("span",[t._v("合计：")]),t._v(" "),a("span",[t._v(t._s(t.setTypes.totalGradeNum)+"分")]),t._v(" "),a("span",[t._v(t._s(t.setTypes.totalTestNum)+"题")])]),t._v(" "),t.setTypes.length<1?a("div",[t._v("\n        该科目无题型\n      ")]):t._e(),t._v(" "),a("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},t._l(t.setTypes,function(e,i){return a("el-row",{key:i,attrs:{type:"flex",justify:"center"}},[a("el-col",{attrs:{span:1}},[a("span",{staticClass:"spanPosition"},[t._v("*")])]),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"题型：",prop:"type"}},[a("el-select",{directives:[{name:"required",rawName:"v-required"}],attrs:{placeholder:"请选择",clearable:""},on:{change:function(e){return t.selectType(i)},clear:function(e){return t.cancelSelect(i)}},model:{value:e.type1,callback:function(a){t.$set(e,"type1",a)},expression:"obj.type1"}},t._l(t.typeList,function(t,e){return a("el-option",{key:e,attrs:{label:t.name,disabled:t.disabled,value:t.type}})}),1)],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:" "}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少道题"},model:{value:e.testNum,callback:function(a){t.$set(e,"testNum",a)},expression:"obj.testNum"}},[a("template",{slot:"append"},[t._v("题")])],2)],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:" "}},[a("el-col",{attrs:{span:24}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少分"},model:{value:e.testPrice,callback:function(a){t.$set(e,"testPrice",a)},expression:"obj.testPrice"}},[a("template",{slot:"append"},[t._v("分")])],2)],1)],1)],1)],1)}),1)],1),t._v(" "),a("el-row",{staticStyle:{"text-align":"center",margin:"40px 0px 20px"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.publicTest("1")}}},[t._v("发起考试")]),t._v(" "),a("el-button",{on:{click:function(e){return t.publicTest("0")}}},[t._v("保存")])],1)],1)],1)},n=[],s=a("35b7"),l=a("bafa"),r={name:"NoPublish",components:{TitleCard:s["a"]},directives:{required:{inserted:function(t){t.firstElementChild.firstElementChild.addEventListener("blur",function(){var e=t.firstElementChild.firstElementChild.value,a="blobk",i="",n="red";t.nextSibling&&"div"===t.nextSibling.parentNode.lastChild.localName&&t.nextSibling.parentNode.removeChild(t.nextSibling.parentNode.lastChild);var s=document.createElement("div");e.length<1?i="非空":(a="none",n="#dcdfe6"),t.firstElementChild.style.borderColor=n,s.innerText=i,s.style.display=a,s.style.color="red",t.nextSibling&&t.nextSibling.parentNode.appendChild(s)})}},limitNum:{inserted:function(t){t.firstElementChild.addEventListener("blur",function(){var e=t.firstElementChild.value,a="blobk",i="",n="red";t.nextSibling&&"div"===t.nextSibling.parentNode.lastChild.localName&&t.nextSibling.parentNode.removeChild(t.nextSibling.parentNode.lastChild);var s=document.createElement("div");e.length<1?i="非空":/^[1-9]\d*$/.test(e)?(a="none",n="#dcdfe6"):i="只能输入0以外的正整数",t.firstElementChild.style.borderColor=n,s.innerText=i,s.style.display=a,s.style.color="red",t.nextSibling?t.nextSibling.parentNode.appendChild(s):t.parentNode.appendChild(s)})}}},props:{testId:{type:String,default:""}},data:function(){var t=this;return{cardTitle:"创建考核",tableKey:0,list:null,total:0,listLoading:!0,listQuery:{examineName:"",examineDate:"",examineStartDateStr:"",examineEndDateStr:"",examineAllNumber:0,examineSubjectId:"",examineSubjectName:"测试科目",IssueStatus:"0",typeAndNum:"",status:0},typesList:[{type:"1",name:"单选题"},{type:"2",name:"多选题"},{type:"3",name:"判断题"},{type:"4",name:"填空题"},{type:"5",name:"简答题"}],pickOptionStart:{disabledDate:function(e){var a=t.listQuery.examineEndDateStr;if(a)return e.getTime()>new Date(a).getTime()}},pickOptionEnd:{disabledDate:function(e){var a=t.listQuery.examineStartDateStr;if(a)return e.getTime()<new Date(a).getTime()}},subjectListAll:[],typeList:[],rules:{examineName:[{required:!0,message:"请输入考试名称",trigger:"blur"}],examineDate:[{required:!0,message:"请输入考试时长",trigger:"blur"},{validator:this.isNum,trigger:"blur"}],examineStartDateStr:[{required:!0,message:"请输入开始时间",trigger:"blur"}],examineEndDateStr:[{required:!0,message:"请输入结束时间",trigger:"blur"}],examineSubjectId:[{required:!0,message:"请选择考试科目",trigger:"change"}]}}},computed:{setTypes:function(){return this.typeList}},watch:{"listQuery.examineSubjectId":{handler:function(t,e){var a=this;this.subjectListAll.map(function(t){t.id===a.listQuery.examineSubjectId&&(a.listQuery.examineSubjectName=t.subjectName,a.findTopicBySubId())})},deep:!0},setTypes:{handler:function(){var t=0,e=0;for(var a in this.setTypes){var i=this.setTypes[a];t+=this.StringToNumber(i.testNum)*this.StringToNumber(i.testPrice),e+=this.StringToNumber(i.testNum)}this.$set(this.setTypes,"totalGradeNum",t),this.$set(this.setTypes,"totalTestNum",e)},deep:!0}},created:function(){this.getSubjectListAll(),this.testId&&this.getInfoById()},methods:{publicTest:function(t){this.listQuery.IssueStatus=t;var e=[],a=0,i=!1,n="";for(var s in this.setTypes)if("totalGradeNum"!==s&&"totalTestNum"!==s){var l=this.setTypes[s];l.testNum&&l.testPrice&&l.type1?(a+=parseInt(l.testNum)*parseInt(l.testPrice),e.push(l.type1+"-"+l.testNum+"-"+l.testPrice)):(n="题型设置中每组输入框都必须输入",i=!0)}this.setTypes.totalGradeNum<=0&&(n="请填写题型及分数",i=!0),this.listQuery.examineEndDateStr||(n="请输入考试结束时间",i=!0),this.listQuery.examineStartDateStr||(n="请输入考试开始时间",i=!0),this.listQuery.examineSubjectId||(n="请选择考试科目",i=!0),this.listQuery.examineDate||(n="请输入考试时长",i=!0),this.listQuery.examineName||(n="请输入考试名称",i=!0),this.listQuery.typeAndNum=e.join(","),this.listQuery.status=0,this.listQuery.examineAllNumber=a,i?this.$message({message:n,type:"info"}):this.saveTestPaper(t)},saveTestPaper:function(t){var e=this,a="发起考试成功！";"0"===t&&(a="保存成功！"),Object(l["f"])(this.listQuery).then(function(t){0===t.data.code?e.$message({type:"success",message:a,onClose:function(){e.$emit("showPage","3",t.data)}}):e.$message({type:"info",message:t.data.msg})})},getSubjectListAll:function(){var t=this;Object(l["e"])().then(function(e){t.subjectListAll=e.data.findList,t.subjectListAll.length>1&&(t.listQuery.examineSubjectId=t.subjectListAll[0].id)})},findTopicBySubId:function(){var t=this;Object(l["b"])({subjectId:this.listQuery.examineSubjectId}).then(function(e){var a=e.data.findList.type;t.typeList=[],a.map(function(e){t.typesList.map(function(a){e===a.type&&t.typeList.push(a)})})})},isNum:function(t,e,a){var i=/^[1-9]\d*$/;i.test(e)?a():a(new Error("只能输入除0以外的的正整数"))},selectType:function(t){this.$set(this.typeList[t],"disabled",!0)},cancelSelect:function(t){for(var e in this.typeList)this.setTypes[t].type===this.typeList[e].type&&this.$set(this.typeList[t],"disabled",!1)},StringToNumber:function(t){return t?parseInt(t):0},showNoPublish:function(){this.$emit("showNoPublish","2")},getInfoById:function(){var t=this;Object(l["c"])({id:this.testId}).then(function(e){t.listQuery=e.data.xlglExamExamine})}}},o=r,u=(a("cf3c"),a("2877")),c=Object(u["a"])(o,i,n,!1,null,"55b1d0b1",null);e["default"]=c.exports}}]);