(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f4b6665a","chunk-7d41aa0e","chunk-2d0cef16"],{"2f21":function(t,e,i){"use strict";var a=i("79e5");t.exports=function(t,e){return!!t&&a(function(){e?t.call(null,function(){},1):t.call(null)})}},"4d78":function(t,e,i){"use strict";var a=i("598d"),n=i.n(a);n.a},"55dd":function(t,e,i){"use strict";var a=i("5ca1"),n=i("d8e8"),s=i("4bf8"),l=i("79e5"),r=[].sort,o=[1,2,3];a(a.P+a.F*(l(function(){o.sort(void 0)})||!l(function(){o.sort(null)})||!i("2f21")(r)),"Array",{sort:function(t){return void 0===t?r.call(s(this)):r.call(s(this),n(t))}})},"598d":function(t,e,i){},6237:function(t,e,i){"use strict";i.d(e,"i",function(){return n}),i.d(e,"d",function(){return s}),i.d(e,"k",function(){return l}),i.d(e,"c",function(){return r}),i.d(e,"f",function(){return o}),i.d(e,"e",function(){return c}),i.d(e,"h",function(){return p}),i.d(e,"j",function(){return u}),i.d(e,"m",function(){return m}),i.d(e,"l",function(){return d}),i.d(e,"a",function(){return f}),i.d(e,"b",function(){return y}),i.d(e,"g",function(){return _});var a=i("b775");function n(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function s(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function r(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function o(t){return Object(a["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}function m(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/saveBatchLIANXI",method:"post",data:t})}function f(t){return Object(a["a"])({url:"/app/xlgl/sysorgan/currenttree",method:"post",data:t})}function y(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/examAnalyse",method:"post",data:t})}function _(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/getReplyLack",method:"post",data:t})}},9907:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[1===t.type?i("div",[i("el-col",{class:{correctStatus:"1"===t.item.correctStatus},attrs:{span:24}},[t._v("\n      "+t._s(t.index+1)+"、"+t._s(t.item.topicColumn)+"\n      "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(t.item.topicResult))]):t._e(),t._v(" "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(t.item.reply))]):t._e()]),t._v(" "),t._l(t.item.columnList,function(e,a){return i("el-col",{key:a,staticClass:"paper-col",attrs:{span:24/t.item.columnList.length}},[i("img",{staticClass:"paperImage",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e}}),t._v(" "),i("p",{staticStyle:{"text-align":"center"}},[t._v("图"+t._s(a+1))])])}),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-radio-group",{staticClass:"optionOverflow",staticStyle:{width:"100%"},model:{value:t.item.reply,callback:function(e){t.$set(t.item,"reply",e)},expression:"item.reply"}},t._l(t.item.topicOptionMap,function(e,a){return i("el-radio",{key:a,staticStyle:{width:"25%","margin-right":"0"},attrs:{label:a}},[t._v(t._s(a)+"、"+t._s(e)),i("br"),t.item.map&&t.item.map[a]?i("img",{staticClass:"paper2Image",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.item.map[a]}}):t._e()])}),1)],1)],2):2===t.type?i("div",[i("el-col",{class:{correctStatus:"1"===t.item.correctStatus},attrs:{span:24}},[t._v("\n      "+t._s(t.index+1)+"、"+t._s(t.item.topicColumn)+"\n      "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(t.item.topicResult))]):t._e(),t._v(" "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(t.item.reply))]):t._e()]),t._v(" "),t._l(t.item.columnList,function(e,a){return i("el-col",{key:a,staticClass:"paper-col",attrs:{span:24/t.item.columnList.length}},[i("img",{staticClass:"paperImage",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e}}),t._v(" "),i("p",{staticStyle:{"text-align":"center"}},[t._v("图"+t._s(a+1))])])}),t._v(" "),i("el-col",{attrs:{span:24}},[t.item.reply1?i("el-checkbox-group",{staticClass:"optionOverflow",staticStyle:{width:"100%"},model:{value:t.item.reply1,callback:function(e){t.$set(t.item,"reply1",e)},expression:"item.reply1"}},t._l(t.item.topicOptionMap,function(e,a){return i("el-checkbox",{key:a,staticStyle:{width:"25%","margin-right":"0"},attrs:{label:a}},[t._v(t._s(a)+"、"+t._s(e)),i("br"),t.item.map&&t.item.map[a]?i("img",{staticClass:"paper2Image",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.item.map[a]}}):t._e()])}),1):i("el-checkbox-group",{staticClass:"optionOverflow",staticStyle:{width:"100%"},model:{value:t.item.reply,callback:function(e){t.$set(t.item,"reply",e)},expression:"item.reply"}},t._l(t.item.topicOptionMap,function(e,a){return i("el-checkbox",{key:a,staticStyle:{width:"25%","margin-right":"0"},attrs:{label:a}},[t._v(t._s(a)+"、"+t._s(e)),i("br"),t.item.map&&t.item.map[a]?i("img",{staticClass:"paper2Image",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.item.map[a]}}):t._e()])}),1)],1)],2):3===t.type?i("div",[i("el-col",{class:{correctStatus:"1"===t.item.correctStatus},attrs:{span:24}},[t._v("\n      "+t._s(t.index+1)+"、"+t._s(t.item.topicColumn)+"\n      "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(t.item.topicResult))]):t._e(),t._v(" "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(t.item.reply))]):t._e()]),t._v(" "),t._l(t.item.columnList,function(e,a){return i("el-col",{key:a,staticClass:"paper-col",attrs:{span:24/t.item.columnList.length}},[i("img",{staticClass:"paperImage",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e}}),t._v(" "),i("p",{staticStyle:{"text-align":"center"}},[t._v("图"+t._s(a+1))])])}),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-radio-group",{staticClass:"optionOverflow",model:{value:t.item.reply,callback:function(e){t.$set(t.item,"reply",e)},expression:"item.reply"}},[i("el-radio",{attrs:{label:"对"}},[t._v("正确")]),t._v(" "),i("el-radio",{attrs:{label:"错"}},[t._v("错误")])],1)],1)],2):4===t.type?i("div",[i("el-col",{class:{correctStatus:"1"===t.item.correctStatus},attrs:{span:24}},[t._v("\n      "+t._s(t.index+1)+"、"+t._s(t.item.topicColumn)+"\n      "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(t.item.topicResult))]):t._e(),t._v(" "),1===t.flag?i("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(t.item.reply))]):t._e()]),t._v(" "),t._l(t.item.columnList,function(e,a){return i("el-col",{key:a,staticClass:"paper-col",attrs:{span:24/t.item.columnList.length}},[i("img",{staticClass:"paperImage",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e}}),t._v(" "),i("p",{staticStyle:{"text-align":"center"}},[t._v("图"+t._s(a+1))])])}),t._v(" "),i("el-col",{class:["optionOverflow",t.item.topicColumn.length>100?"ma-t_25":""],attrs:{span:24}},[i("el-input",{attrs:{type:"textarea",placeholder:"答案之间以逗号（，）分隔开"},model:{value:t.item.reply,callback:function(e){t.$set(t.item,"reply",e)},expression:"item.reply"}})],1)],2):t._e()])},n=[],s=(i("c5f6"),{name:"Radio",props:{item:{type:Object,default:function(){}},type:{type:Number,default:0},index:{type:Number,default:0},flag:{type:Number,default:0}}}),l=s,r=(i("ffcc"),i("2877")),o=Object(r["a"])(l,a,n,!1,null,"a3816328",null);e["default"]=o.exports},b3c3:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container1",staticStyle:{"background-color":"#ffffff",height:"100%",overflow:"auto","user-select":"none","-moz-user-select":"none","-webkit-user-select":"none"}},[i("backToTop"),t._v(" "),i("div",{staticClass:"borderB",staticStyle:{position:"relative",padding:"0 60px","padding-top":"30px"}},[i("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),t.list.xlglExamExamine?i("div",{staticClass:"title"},[t._v("\n      "+t._s(t.list.xlglExamExamine.examineName)+"\n    ")]):t._e(),t._v(" "),i("div",{staticClass:"infoDiv"},[i("span",[t._v("姓名："+t._s(t.username1))]),t._v(" "),i("span",[t._v("时间："+t._s(t._f("parseTime")(new Date,"{y}-{m}-{d} {h}:{i}")))]),t._v(" "),i("span",[t._v("单位："+t._s(t.useDepart1))]),t._v(" "),i("span",{staticClass:"rightP",staticStyle:{"font-size":"24px","margin-top":"3px"}},[t._v("倒计时：\n        "),t._v("\n        "+t._s(t.dataTime)+"\n      ")]),t._v(" "),i("el-button",{staticClass:"rightP",attrs:{type:"primary",size:"small"},on:{click:t.saveBatch}},[t._v("交卷")])],1)],1),t._v(" "),i("div",{staticClass:"testDiv"},[t.list.listType1&&t.list.listType1.length>0&&t.list.topicCount1?i("div",[i("h2",[t._v("\n        "+t._s(t._f("indexFilter")(t.list.topicCount1.num))+"、单选题（共"+t._s(t.list.topicCount1.typeCount)+"题，每题"+t._s(t.list.topicCount1.fractionalNumber)+"分，共"+t._s(t.list.topicCount1.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType1,function(t,e){return i("el-row",{directives:[{name:"viewer",rawName:"v-viewer"}],key:t.id,staticClass:"gapSty borderB"},[i("radio",{attrs:{item:t,index:e,type:1}})],1)})],2):t._e(),t._v(" "),t.list.listType2&&t.list.listType2.length>0?i("div",[i("h2",[t._v("\n        "+t._s(t._f("indexFilter")(t.list.topicCount2.num))+"、多选题（共"+t._s(t.list.topicCount2.typeCount)+"题，每题"+t._s(t.list.topicCount2.fractionalNumber)+"分，共"+t._s(t.list.topicCount2.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType2,function(t,e){return i("el-row",{directives:[{name:"viewer",rawName:"v-viewer"}],key:t.id,staticClass:"gapSty borderB"},[i("radio",{attrs:{item:t,index:e,type:2}})],1)})],2):t._e(),t._v(" "),t.list.listType3&&t.list.listType3.length>0&&t.list.topicCount3?i("div",[i("h2",[t._v("\n        "+t._s(t._f("indexFilter")(t.list.topicCount3.num))+"、判断题（共"+t._s(t.list.topicCount3.typeCount)+"题，每题"+t._s(t.list.topicCount3.fractionalNumber)+"分，共"+t._s(t.list.topicCount3.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType3,function(t,e){return i("el-row",{directives:[{name:"viewer",rawName:"v-viewer"}],key:t.id,staticClass:"gapSty borderB"},[i("radio",{attrs:{item:t,index:e,type:3}})],1)})],2):t._e(),t._v(" "),t.list.listType4&&t.list.listType4.length>0&&t.list.topicCount4?i("div",[i("h2",[t._v("\n        "+t._s(t._f("indexFilter")(t.list.topicCount4.num))+"、填空题（共"+t._s(t.list.topicCount4.typeCount)+"题，每题"+t._s(t.list.topicCount4.fractionalNumber)+"分，共"+t._s(t.list.topicCount4.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType4,function(t,e){return i("el-row",{directives:[{name:"viewer",rawName:"v-viewer"}],key:t.id,staticClass:"gapSty borderB"},[i("radio",{attrs:{item:t,index:e,type:4}})],1)})],2):t._e()])],1)},n=[],s=(i("ac6a"),i("55dd"),i("6237")),l=i("9907"),r=i("0625"),o={name:"TestPaper",components:{radio:l["default"],backToTop:r["a"]},filters:{indexFilter:function(t){var e="";switch(t){case 0:e="一";break;case 1:e="二";break;case 2:e="三";break;case 3:e="四";break;case 4:e="五";break}return e}},props:{testId:{type:String,default:""},makeupStatus:{type:String,default:""}},data:function(){return{list:{},times:0,timer:null,id:"",username1:this.$store.state.user.userInfo.fullname,useDepart1:this.$store.state.user.userInfo.orgName,hours:0,time:0,dataTime:"00:00:00"}},watch:{},created:function(){this.$root.$emit("testHandle",!0),this.getExamineList()},methods:{getExamineList:function(){var t=this,e={examineId:this.testId};Object(s["d"])(e).then(function(e){var i=e.data;if(i.topicCount.sort(function(t,e){return t.topicType-e.topicType}),i.topicCount.forEach(function(t,e){t.num=e,i["topicCount".concat(t.topicType)]=t}),i.listType2&&i.listType2.length>0)for(var a in i.listType2)i.listType2[a].reply=[];t.list=i,t.id=e.data.MainAnswerID,t.times=parseInt(60*e.data.xlglExamExamine.examineDate),t.timer=setInterval(function(){t.times--,t.dataTime=t.formatSecond(t.times),0===t.times&&(clearInterval(t.timer),t.saveBatch())},1e3)})},formatSecond:function(t){var e=Math.floor(t%3600),i=this.formatType(Math.floor(t/3600))+":"+this.formatType(Math.floor(e/60))+":"+this.formatType(t%60);return i},formatType:function(t){return t>9?t:"0"+t},saveBatch:function(){var t=this,e=[];this.list.listType1&&this.list.listType1.length>0&&this.list.listType1.map(function(t,i){var a={};a.examineTopicId=t.id,a.topicColumn=t.topicColumn,a.topicType=t.topicType,a.topicOption=t.topicOption,a.topicResult=t.topicResult,a.reply=t.reply,a.fraction=t.fractionalNumber,a.pictureStatus=t.pictureStatus,a.number=i+1,e.push(a)}),this.list.listType2&&this.list.listType2.length>0&&this.list.listType2.map(function(t,i){var a={};a.examineTopicId=t.id,a.topicColumn=t.topicColumn,a.topicType=t.topicType,a.topicOption=t.topicOption,a.topicResult=t.topicResult,a.reply=t.reply.length>0?t.reply.join(","):"",a.fraction=t.fractionalNumber,a.pictureStatus=t.pictureStatus,a.number=i+1,e.push(a)}),this.list.listType3&&this.list.listType3.length>0&&this.list.listType3.map(function(t,i){var a={};a.examineTopicId=t.id,a.topicColumn=t.topicColumn,a.topicType=t.topicType,a.topicOption=t.topicOption,a.topicResult=t.topicResult,a.reply=t.reply,a.fraction=t.fractionalNumber,a.pictureStatus=t.pictureStatus,a.number=i+1,e.push(a)}),this.list.listType4&&this.list.listType4.length>0&&this.list.listType4.map(function(t,i){var a={};a.examineTopicId=t.id,a.topicColumn=t.topicColumn,a.topicType=t.topicType,a.topicOption=t.topicOption,a.topicResult=t.topicResult,a.reply=t.reply,a.fraction=t.fractionalNumber,a.pictureStatus=t.pictureStatus,a.number=i+1,e.push(a)});var i={mainAnswerId:this.id,xlglExamAnswer:JSON.stringify(e),status:0,makeupStatus:this.makeupStatus};this.times<=0?(clearInterval(this.timer),Object(s["k"])(i).then(function(e){if(0===e.data.code){t.$root.$emit("testHandle",!1),t.$notify({title:"提示",message:"交卷成功!",duration:1500,type:"success"});var i={id:t.id,examineId:t.testId};t.$emit("showTestPaper","3",i)}else t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"})})):Object(s["g"])({xlglExamAnswer:i.xlglExamAnswer}).then(function(e){"0"===e.data.code&&t.$confirm(e.data.msg,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){clearInterval(t.timer),Object(s["k"])(i).then(function(e){if(0===e.data.code){t.$root.$emit("testHandle",!1),t.$notify({title:"提示",message:"交卷成功!",duration:1500,type:"success"});var i={id:t.id,examineId:t.testId};t.$emit("showTestPaper","3",i)}else t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"})})}).catch(function(){t.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})})})},goBack:function(){this.saveBatch()}}},c=o,p=(i("4d78"),i("2877")),u=Object(p["a"])(c,a,n,!1,null,"0e72b869",null);e["default"]=u.exports},f607:function(t,e,i){},ffcc:function(t,e,i){"use strict";var a=i("f607"),n=i.n(a);n.a}}]);