(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a415ae36"],{"59b6":function(t,e,i){},6237:function(t,e,i){"use strict";i.d(e,"f",function(){return n}),i.d(e,"b",function(){return l}),i.d(e,"h",function(){return a}),i.d(e,"a",function(){return o}),i.d(e,"d",function(){return p}),i.d(e,"c",function(){return r}),i.d(e,"e",function(){return c}),i.d(e,"g",function(){return u});var s=i("b775");function n(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function l(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function a(t){return Object(s["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function o(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function p(t){return Object(s["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function r(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function c(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function u(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}},b3c3:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"borderB",staticStyle:{position:"relative",padding:"0 60px","padding-top":"30px"}},[i("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),i("div",{staticClass:"title"},[t._v("\n      "+t._s(t.list.xlglExamExamine.examineName)+"\n    ")]),t._v(" "),i("div",{staticClass:"infoDiv"},[i("span",[t._v("姓名："+t._s(t.username1))]),t._v(" "),i("span",[t._v("时间："+t._s(t._f("parseTime")(new Date,"{y}-{m}-{d} {h}:{i}")))]),t._v(" "),i("span",[t._v("单位："+t._s(t.useDepart1))]),t._v(" "),i("span",{staticClass:"rightP"},[t._v("倒计时：\n        "),t.hours>0?i("span",{staticStyle:{"margin-right":"10px"}},[t._v(t._s(t.hours)+"时")]):t._e(),t._v("\n        "+t._s(t.time)+"分\n      ")]),t._v(" "),i("el-button",{staticClass:"rightP",attrs:{type:"primary",size:"mini"},on:{click:t.saveBatch}},[t._v("交卷")])],1)],1),t._v(" "),i("div",{staticClass:"testDiv"},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},t._l(t.list.topicCount,function(e,s){return i("div",{key:s},[t.list.listType1&&t.list.listType1.length>0&&"1"===e.topicType?i("div",[i("h2",[t._v("\n            "+t._s(t._f("indexFilter")(s))+"、单选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType1,function(e,s){return i("el-row",{key:e.id,staticClass:"gapSty borderB"},[i("el-col",{attrs:{span:24}},[t._v(t._s(s+1)+"、"+t._s(e.topicColumn))]),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-radio-group",{model:{value:e.reply,callback:function(i){t.$set(e,"reply",i)},expression:"item.reply"}},t._l(e.topicOptionMap,function(e,s){return i("el-radio",{key:s,staticStyle:{margin:"0px 100px 0px 50px"},attrs:{label:s}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType2&&t.list.listType2.length>0&&"2"===e.topicType?i("div",[i("h2",[t._v("\n            "+t._s(t._f("indexFilter")(s))+"、多选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType2,function(e,s){return i("el-row",{key:e.id,staticClass:"gapSty borderB"},[i("el-col",{attrs:{span:24}},[t._v(t._s(s+1)+"、"+t._s(e.topicColumn))]),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-checkbox-group",{model:{value:e.reply,callback:function(i){t.$set(e,"reply",i)},expression:"item2.reply"}},t._l(e.topicOptionMap,function(e,s){return i("el-checkbox",{key:s,attrs:{label:s}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType3&&t.list.listType3.length>0&&"3"===e.topicType?i("div",[i("h2",[t._v("\n            "+t._s(t._f("indexFilter")(s))+"、判断题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType3,function(e,s){return i("el-row",{key:e.id,staticClass:"gapSty borderB"},[i("el-col",{attrs:{span:24}},[t._v(t._s(s+1)+"、"+t._s(e.topicColumn))]),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-radio-group",{model:{value:e.reply,callback:function(i){t.$set(e,"reply",i)},expression:"item3.reply"}},[i("el-radio",{attrs:{label:"对"}},[t._v("正确")]),t._v(" "),i("el-radio",{attrs:{label:"错"}},[t._v("错误")])],1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType4&&t.list.listType4.length>0&&"4"===e.topicType?i("div",[i("h2",[t._v("\n            "+t._s(t._f("indexFilter")(s))+"、填空题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType4,function(e,s){return i("el-row",{key:e.id,staticClass:"gapSty borderB"},[i("el-col",{attrs:{span:24}},[t._v(t._s(s+1)+"、"+t._s(e.topicColumn))]),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-input",{attrs:{type:"textarea",placeholder:"答案之间以逗号（，）分隔开"},model:{value:e.reply,callback:function(i){t.$set(e,"reply",i)},expression:"item4.reply"}})],1)],1)})],2):t._e(),t._v(" "),t.list.listType5&&t.list.listType5.length>0&&"5"===e.topicType?i("div",[i("h2",[t._v("\n            "+t._s(t._f("indexFilter")(s))+"、简答题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n          ")]),t._v(" "),t._l(t.list.listType5,function(e,s){return i("el-row",{key:e.id,staticClass:"gapSty borderB"},[i("el-col",{attrs:{span:24}},[t._v(t._s(s+1)+"、"+t._s(e.topicColumn))]),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-input",{attrs:{type:"textarea"},model:{value:e.reply,callback:function(i){t.$set(e,"reply",i)},expression:"item5.reply"}})],1)],1)})],2):t._e()])}),0)],1)])},n=[],l=i("6237"),a={name:"TestPaper",filters:{indexFilter:function(t){var e="";switch(t){case 0:e="一";break;case 1:e="二";break;case 2:e="三";break;case 3:e="四";break;case 4:e="五";break}return e}},props:{testId:{type:String,default:""},makeupStatus:{type:String,default:""}},data:function(){return{list:null,times:0,id:"",username1:this.$store.state.user.userInfo.fullname,useDepart1:this.$store.state.user.userInfo.orgName,hours:0,time:0}},watch:{times:{handler:function(){this.times>60?this.hours=parseInt(this.times/60):this.hours=0,this.time=parseInt(this.times%60)}}},created:function(){this.getExamineList()},methods:{getExamineList:function(){var t=this,e={examineId:this.testId};Object(l["b"])(e).then(function(e){var i=e.data;if(i.listType2&&i.listType2.length>0)for(var s in i.listType2)i.listType2[s].reply=[];t.list=i,t.id=e.data.MainAnswerID,t.times=parseInt(e.data.xlglExamExamine.examineDate);var n=setInterval(function(){t.times--,0===t.times&&(clearInterval(n),t.saveBatch())},6e3)})},saveBatch:function(){var t=this,e=[];this.list.listType1&&this.list.listType1.length>1&&this.list.listType1.map(function(t){var i={};i.examineTopicId=t.examineId,i.topicColumn=t.topicColumn,i.topicType=t.topicType,i.topicOption=t.topicOption,i.topicResult=t.topicResult,i.reply=t.reply,i.fraction=t.fractionalNumber,e.push(i)}),this.list.listType2&&this.list.listType2.length>1&&this.list.listType2.map(function(t){var i={};i.examineTopicId=t.examineId,i.topicColumn=t.topicColumn,i.topicType=t.topicType,i.topicOption=t.topicOption,i.topicResult=t.topicResult,i.reply=t.reply.length>0?t.reply.join(","):"",i.fraction=t.fractionalNumber,e.push(i)}),this.list.listType3&&this.list.listType3.length>1&&this.list.listType3.map(function(t){var i={};i.examineTopicId=t.examineId,i.topicColumn=t.topicColumn,i.topicType=t.topicType,i.topicOption=t.topicOption,i.topicResult=t.topicResult,i.reply=t.reply,i.fraction=t.fractionalNumber,e.push(i)}),this.list.listType4&&this.list.listType4.length>1&&this.list.listType4.map(function(t){var i={};i.examineTopicId=t.examineId,i.topicColumn=t.topicColumn,i.topicType=t.topicType,i.topicOption=t.topicOption,i.topicResult=t.topicResult,i.reply=t.reply,i.fraction=t.fractionalNumber,e.push(i)}),this.list.listType5&&this.list.listType5.length>1&&this.list.listType5.map(function(t){var i={};i.examineTopicId=t.examineId,i.topicColumn=t.topicColumn,i.topicType=t.topicType,i.topicOption=t.topicOption,i.topicResult=t.topicResult,i.reply=t.reply,i.fraction=t.fractionalNumber,e.push(i)});var i={mainAnswerId:this.id,xlglExamAnswer:JSON.stringify(e),status:0,makeupStatus:this.makeupStatus};Object(l["h"])(i).then(function(e){0===e.data.code?t.$message({type:"success",message:"交卷成功!",onClose:function(){var e={id:t.id,examineId:t.testId};t.$emit("showTestPaper","3",e)}}):t.$message({type:"info",message:e.data.msg})})},goBack:function(){var t=this;this.$confirm("此操作提交试卷, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.saveBatch()}).catch(function(){t.$message({type:"info",message:"已取消"})})}}},o=a,p=(i("dd8b"),i("2877")),r=Object(p["a"])(o,s,n,!1,null,"2a24db12",null);e["default"]=r.exports},dd8b:function(t,e,i){"use strict";var s=i("59b6"),n=i.n(s);n.a}}]);