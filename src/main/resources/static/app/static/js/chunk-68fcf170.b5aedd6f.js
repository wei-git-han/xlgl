(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-68fcf170"],{4170:function(t,e,l){},"8bfa":function(t,e,l){"use strict";var s=l("4170"),n=l.n(s);n.a},"9b34":function(t,e,l){"use strict";l.r(e);var s=function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("div",{staticClass:"app-container1"},t._l(t.list.topicCount,function(e,s){return l("div",{key:s},[t.list.listType1&&t.list.listType1.length>0&&"1"===e.topicType?l("div",[l("h2",[t._v("\n        "+t._s(t._f("indexFilter")(s))+"、单选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType1,function(e,s){return l("el-row",{key:e.id,staticClass:"gapSty borderB"},[l("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(s+1)+"、"+t._s(e.topicColumn)+"\n          "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),l("el-col",{attrs:{span:24}},[l("el-radio-group",{model:{value:e.reply,callback:function(l){t.$set(e,"reply",l)},expression:"item.reply"}},t._l(e.topicOptionMap,function(e,s){return l("el-radio",{key:s,staticStyle:{margin:"0px 100px 0px 50px"},attrs:{label:s}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType2&&t.list.listType2.length>0&&"2"===e.topicType?l("div",[l("h2",[t._v("\n        "+t._s(t._f("indexFilter")(s))+"、多选题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType2,function(e,s){return l("el-row",{key:e.id,staticClass:"gapSty borderB"},[l("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(s+1)+"、"+t._s(e.topicColumn)+"\n          "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),l("el-col",{attrs:{span:24}},[l("el-checkbox-group",{model:{value:e.reply1,callback:function(l){t.$set(e,"reply1",l)},expression:"item2.reply1"}},t._l(e.topicOptionMap,function(e,s){return l("el-checkbox",{key:s,attrs:{label:s}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType3&&t.list.listType3.length>0&&"3"===e.topicType?l("div",[l("h2",[t._v("\n        "+t._s(t._f("indexFilter")(s))+"、判断题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType3,function(e,s){return l("el-row",{key:e.id,staticClass:"gapSty borderB"},[l("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(s+1)+"、"+t._s(e.topicColumn)+"\n          "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),l("el-col",{attrs:{span:24}},[l("el-radio-group",{model:{value:e.reply,callback:function(l){t.$set(e,"reply",l)},expression:"item3.reply"}},t._l(e.topicOptionMap,function(e,s){return l("el-radio",{key:s,attrs:{label:s}},[t._v(t._s(e))])}),1)],1)],1)})],2):t._e(),t._v(" "),t.list.listType4&&t.list.listType4.length>0&&"4"===e.topicType?l("div",[l("h2",[t._v("\n        "+t._s(t._f("indexFilter")(s))+"、填空题（共"+t._s(e.typeCount)+"题，每题"+t._s(e.fractionalNumber)+"分，共"+t._s(e.numberAll)+"分）\n      ")]),t._v(" "),t._l(t.list.listType4,function(e,s){return l("el-row",{key:e.id,staticClass:"gapSty borderB"},[l("el-col",{class:{correctStatus:"1"===e.correctStatus},attrs:{span:24}},[t._v("\n          "+t._s(s+1)+"、"+t._s(e.topicColumn)+"\n          "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("正确答案:"+t._s(e.topicResult))]),t._v(" "),l("span",{staticStyle:{"margin-left":"20px"}},[t._v("您的选择："+t._s(e.reply))])]),t._v(" "),l("el-col",{attrs:{span:24}},[l("el-input",{attrs:{type:"textarea",placeholder:"答案之间以逗号（，）分隔开"},model:{value:e.reply,callback:function(l){t.$set(e,"reply",l)},expression:"item4.reply"}})],1)],1)})],2):t._e()])}),0)},n=[],r={name:"TestPaper",filters:{indexFilter:function(t){var e="";switch(t){case 0:e="一";break;case 1:e="二";break;case 2:e="三";break;case 3:e="四";break;case 4:e="五";break}return e}},props:{list:{type:Object,default:{}}},data:function(){return{}},created:function(){},methods:{}},a=r,i=(l("8bfa"),l("2877")),c=Object(i["a"])(a,s,n,!1,null,"237c2ebf",null);e["default"]=c.exports}}]);