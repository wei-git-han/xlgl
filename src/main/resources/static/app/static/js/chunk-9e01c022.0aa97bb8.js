(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-9e01c022","chunk-2d0cef16","chunk-2d21a630"],{"049e":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"createTest"},[i("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer","margin-top":"-30px","margin-right":"20px"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),i("div",{staticClass:"pageContent"},[i("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:t.listQuery,rules:t.rules,"label-width":"150px",inline:!0}},[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"考试时间：",required:""}},[i("el-col",{attrs:{span:11}},[i("el-form-item",{attrs:{prop:"examineStartDateStr"}},[i("el-date-picker",{attrs:{"popper-class":"cancelCurrent",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionStart,placeholder:"选择开始时间"},on:{change:t.getsTime1},model:{value:t.listQuery.examineStartDateStr,callback:function(e){t.$set(t.listQuery,"examineStartDateStr",e)},expression:"listQuery.examineStartDateStr"}})],1)],1),t._v(" "),i("el-col",{staticClass:"line",staticStyle:{"text-align":"center"},attrs:{span:2}},[t._v("至")]),t._v(" "),i("el-col",{attrs:{span:11}},[i("el-form-item",{attrs:{prop:"examineEndDateStr"}},[i("el-date-picker",{attrs:{"popper-class":"cancelCurrent",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionEnd,placeholder:"选择结束时间"},on:{change:t.getsTime2},model:{value:t.listQuery.examineEndDateStr,callback:function(e){t.$set(t.listQuery,"examineEndDateStr",e)},expression:"listQuery.examineEndDateStr"}})],1)],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("div",{staticStyle:{float:"right","margin-right":"100px"}},[i("span",[t._v("合计：")]),t._v(" "),i("span",{staticClass:"size1"},[t._v(t._s(t.totalGrade))]),t._v("分\n          "),i("span",{staticClass:"size1"},[t._v(t._s(t.totalNum))]),t._v("题\n        ")])])],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"50px"}},[i("el-col",{attrs:{span:24}},[i("el-card",{staticClass:"box-card"},[i("div",{staticClass:"clearfix",staticStyle:{"text-align":"center"},attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{float:"left"}},[t._v("题型设置")])]),t._v(" "),i("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},t._l(t.typesList.typeList,function(e,a){return i("el-row",{key:a,attrs:{type:"flex",justify:"center"}},[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"题型：",prop:"type"}},[i("el-select",{attrs:{placeholder:"请选择",clearable:""},on:{change:function(e){return t.selectType(e,a)},clear:function(e){return t.cancelSelect(a)}},model:{value:t.selectedList["type"+a].type1,callback:function(e){t.$set(t.selectedList["type"+a],"type1",e)},expression:"selectedList[`type${index}`].type1"}},t._l(t.typesList.typeList,function(e,a){return i("el-option",{key:a,attrs:{label:e.name,disabled:t.getSelectDisabled(e.type),value:e.type}})}),1)],1)],1),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:" "}},[i("el-input",{attrs:{max:t.selectedList["type"+a].maxNum,oninput:"value=value.replace(/\\D|^0/g, '')",placeholder:"请输入多少道题"},on:{change:function(e){return t.getVal(e,t.selectedList["type"+a].maxNum,a)}},model:{value:t.selectedList["type"+a].testNum,callback:function(e){t.$set(t.selectedList["type"+a],"testNum",e)},expression:"selectedList[`type${index}`].testNum"}},[i("template",{slot:"append"},[t._v("题")])],2),t._v(" "),i("div",{staticClass:"el-form-item__error",staticStyle:{width:"350px"}},[t._v(t._s(t.selectedList["type"+a].tips))])],1)],1),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:" "}},[i("el-col",{attrs:{span:24}},[i("el-input",{attrs:{oninput:"value=value.replace(/\\D|^0/g, '')",placeholder:"请输入多少分"},model:{value:t.selectedList["type"+a].testPrice,callback:function(e){t.$set(t.selectedList["type"+a],"testPrice",e)},expression:"selectedList[`type${index}`].testPrice"}},[i("template",{slot:"append"},[t._v("分")])],2)],1)],1)],1)],1)}),1)],1)],1)],1),t._v(" "),i("el-row",{staticStyle:{"text-align":"center",margin:"40px 0px 20px"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.repeatTestSave}},[t._v("发起补考")])],1)],1)],1)},s=[],n=(i("3b2b"),i("a481"),i("7f7f"),i("ac6a"),i("28a5"),i("35b7")),r=i("6237"),l=i("bafa"),o={name:"RepeatTestSet",components:{TitleCard:n["a"]},directives:{},filters:{typeFilter:function(t){return"1"===t?"单选题":"2"===t?"多选题":"3"===t?"判断题":"4"===t?"填空题":"5"===t?"简答题":void 0}},props:{testId:{type:String,default:""},testName:{type:String,default:""},testTime:{type:String,default:""},topicTypeList:{type:Array,default:function(){}},examineSubjectId:{type:String,default:""}},data:function(){var t=this;return{cardTitle:this.testName+"("+this.testTime+")",updateInfo:[],testTypeList:{},endDateTime:"",endDateTime1:"",listQuery:{examineName:"",examineDate:"",examineStartDateStr:"",examineEndDateStr:"",examineAllNumber:0,examineSubjectId:"",examineSubjectName:"测试科目",IssueStatus:"0",typeAndNum:"",status:0},typesList:{typeList:[],totalGradeNum:0,totalTestNum:0},pickOptionStart:{disabledDate:function(e){var i=t.listQuery.examineEndDateStr;return i?e.getTime()>t.dateToLong(i):e.getTime()<t.dateToLong(t.endDateTime)}},pickOptionEnd:{disabledDate:function(e){var i=t.listQuery.examineStartDateStr;return i?e.getTime()<t.dateToLong(i):e.getTime()<t.dateToLong(t.endDateTime)}},rules:{examineStartDateStr:[{required:!0,message:"请输入开始时间",trigger:"blur"}],examineEndDateStr:[{required:!0,message:"请输入结束时间",trigger:"blur"}]},totalGrade:0,totalNum:0,errorOptionList:[],errorList:[],emptyList:[],selectedList:{type0:{type1:null,testNum:null,testPrice:null,tips:null},type1:{type1:null,testNum:null,testPrice:null,tips:null},type2:{type1:null,testNum:null,testPrice:null,tips:null},type3:{type1:null,testNum:null,testPrice:null,tips:null}},tempData:{},tempData1:[]}},watch:{selectedList:{handler:function(t,e){var i=0,a=0;for(var s in this.selectedList){var n=this.selectedList[s];i+=this.StringToNumber(n.testNum)*this.StringToNumber(n.testPrice),a+=this.StringToNumber(n.testNum)}this.totalGrade=i,this.totalNum=a},deep:!0}},created:function(){var t=this;if(this.tempData=Object.assign({},this.selectedList),this.testTime){var e=this.testTime.split("~"),i=new Date;e[1]&&this.dateToLong(e[1])>Date.now()&&(i=new Date(this.dateToLong(e[1]))),this.endDateTime1=this.endDateTime=this.dateToLong(i.getFullYear()+"/"+(i.getMonth()+1)+"/"+i.getDate()+" 00:00:00")}for(var a in this.topicTypeList.forEach(function(e,i){for(var a in"1"===e&&t.typesList.typeList.push({type:"1",name:"单选题"}),"2"===e&&t.typesList.typeList.push({type:"2",name:"多选题"}),"3"===e&&t.typesList.typeList.push({type:"3",name:"判断题"}),"4"===e&&t.typesList.typeList.push({type:"4",name:"填空题"}),t.tempData)"type".concat(i)===a&&t.tempData1.push(i)}),this.selectedList)a>="type"+this.tempData1.length&&this.$delete(this.selectedList,a);this.getTopicNumber()},methods:{getsTime1:function(t){this.listQuery.examineEndDateStr?(this.dateToLong(this.listQuery.examineStartDateStr)<this.dateToLong(this.endDateTime1)&&(this.$notify({title:"提示",message:"开始时间大于上次考试时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr=""),this.dateToLong(this.listQuery.examineStartDateStr)>this.dateToLong(this.listQuery.examineEndDateStr)&&(this.$notify({title:"提示",message:"开始时间必须小于结束时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr="")):this.dateToLong(this.listQuery.examineStartDateStr)<this.dateToLong(this.endDateTime1)?(this.$notify({title:"提示",message:"开始时间大于上次考试时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr=""):this.dateToLong(this.listQuery.examineStartDateStr)+6e4<(new Date).getTime()&&(this.$notify({title:"提示",message:"开始时间必须大于系统时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr="")},getsTime2:function(t){this.listQuery.examineStartDateStr?this.dateToLong(this.listQuery.examineStartDateStr)>this.dateToLong(this.listQuery.examineEndDateStr)&&(this.$notify({title:"提示",message:"结束时间必须大于开始时间",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr=""):this.dateToLong(this.listQuery.examineEndDateStr)<this.dateToLong(this.endDateTime1)?(this.$notify({title:"提示",message:"结束时间大于上次考试时间",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr=""):this.dateToLong(this.listQuery.examineEndDateStr)+6e4<(new Date).getTime()&&(this.$notify({title:"提示",message:"结束时间必须大于系统时间",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr="")},getTopicNumber:function(){var t=this,e={id:this.examineSubjectId};Object(l["g"])(e).then(function(e){t.testTypeList=e.data,t.errorList=[]})},errorNum:function(t,e){"1"===t&&this.testTypeList[1]<e&&this.errorList.push({type:t,name:"单选题",inputnum:e,originNum:this.testTypeList[1]}),"2"===t&&this.testTypeList[2]<e&&this.errorList.push({type:t,name:"多选题",inputnum:e,originNum:this.testTypeList[2]}),"3"===t&&this.testTypeList[3]<e&&this.errorList.push({type:t,name:"判断题",inputnum:e,originNum:this.testTypeList[3]}),"4"===t&&this.testTypeList[4]<e&&this.errorList.push({type:t,name:"填空题",inputnum:e,originNum:this.testTypeList[4]})},getSelectDisabled:function(t){var e=!1;for(var i in this.selectedList)this.selectedList[i].type1===t&&(e=!0);return e},repeatTestSave:function(){var t=this;this.$refs.form.validate(function(e){if(e){var i=[];for(var a in t.errorList=[],t.errorOptionList=[],t.emptyList=[],t.selectedList){var s=t.selectedList[a];s.type1&&s.testNum&&s.testPrice?(t.errorNum(s.type1,parseInt(s.testNum)),i.push(s.type1+"-"+s.testNum+"-"+s.testPrice)):!s.type1||s.testNum&&s.testPrice?s.type1||t.emptyList.push(a):t.errorOptionList.push("题型、题量以及每道题的分值都需要输入！ ")}if(t.emptyList.length>0&&t.emptyList.length===t.typesList.typeList.length)t.$notify({title:"提示",message:"您还未进行试题的组合设置！",duration:5500,type:"warning"});else if(t.errorOptionList.length>0)t.$notify({title:"提示",message:t.errorOptionList[0],duration:5500,type:"warning"}),t.errorList=[],t.errorOptionList=[],t.emptyList=[];else if(t.errorList.length>0){for(var n="",l=0;l<t.errorList.length;l++)n+="<p>"+t.errorList[l].name+"，当前数量是"+t.errorList[l].inputnum+"，题库数量为"+t.errorList[l].originNum+"，组题量不能大于题库数量</p>";t.$notify({title:"提示",dangerouslyUseHTMLString:!0,message:n,duration:1500,type:"warning"}),t.errorList=[],t.errorOptionList=[],t.emptyList=[]}else{var o={examineId:t.testId,makeUpEndDateStr:t.listQuery.examineStartDateStr,makeUpStartDateStr:t.listQuery.examineEndDateStr,typeAndNum:i.join(",")};Object(r["j"])(o).then(function(e){if(0===e.data.code)t.$emit("showPage","1");else{var i=t;t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"}),i.$emit("showPage","1")}})}}})},goBack:function(){this.$emit("showPage","1")},selectType:function(t,e){this.selectedList["type".concat(e)].testNum&&(this.selectedList["type".concat(e)].testNum="",this.selectedList["type".concat(e)].tips="");for(var i=0;i<this.typesList.typeList.length;i++)this.typesList.typeList[i].type===t&&this.$set(this.typesList.typeList[i],"disabled",!0);for(var a in this.selectedList)this.selectedList[a].type1===t&&(this.selectedList[a].maxNum=this.testTypeList[t])},cancelSelect:function(t){for(var e=0;e<this.typesList.typeList.length;e++)this.typesList.typeList[e].type===this.typesList.typeList[t].type&&this.$set(this.typesList.typeList[t],"disabled",!1)},StringToNumber:function(t){return t?parseInt(t):0},dateToLong:function(t){return t||(t=""),t.replace&&t?new Date(t.replace(new RegExp("-","gm"),"/")).getTime():new Date(t).getTime()},getVal:function(t,e,i){if(t>e){this.selectedList["type".concat(i)].testNum=e;for(var a=0;a<this.typesList.typeList.length;a++)this.typesList.typeList[a].type===this.selectedList["type".concat(i)].type1&&(this.subjectName=this.typesList.typeList[a].name);this.selectedList["type".concat(i)].tips="题库中仅有".concat(e,"道").concat(this.subjectName)}else this.selectedList["type".concat(i)].tips=null}}},p=o,u=(i("dcba"),i("2877")),c=Object(u["a"])(p,a,s,!1,null,"58aef97c",null);e["default"]=c.exports},"42a1":function(t,e,i){},6237:function(t,e,i){"use strict";i.d(e,"i",function(){return s}),i.d(e,"d",function(){return n}),i.d(e,"k",function(){return r}),i.d(e,"c",function(){return l}),i.d(e,"f",function(){return o}),i.d(e,"e",function(){return p}),i.d(e,"h",function(){return u}),i.d(e,"j",function(){return c}),i.d(e,"m",function(){return m}),i.d(e,"l",function(){return d}),i.d(e,"a",function(){return y}),i.d(e,"b",function(){return h}),i.d(e,"g",function(){return g});var a=i("b775");function s(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function n(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function r(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function o(t){return Object(a["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}function m(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/saveBatchLIANXI",method:"post",data:t})}function y(t){return Object(a["a"])({url:"/app/xlgl/sysorgan/currenttree",method:"post",data:t})}function h(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/examAnalyse",method:"post",data:t})}function g(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/getReplyLack",method:"post",data:t})}},bafa:function(t,e,i){"use strict";i.d(e,"h",function(){return s}),i.d(e,"f",function(){return n}),i.d(e,"c",function(){return r}),i.d(e,"e",function(){return l}),i.d(e,"b",function(){return o}),i.d(e,"d",function(){return p}),i.d(e,"g",function(){return u}),i.d(e,"a",function(){return c});var a=i("b775");function s(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function n(){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/subjectListAll",method:"get"})}function r(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/findTopicBySubId",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/issueStatusList",method:"post",data:t})}function o(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/delete",method:"post",data:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/info",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglexamsubject/getTopicNumber",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/verify",method:"post",data:t})}},dcba:function(t,e,i){"use strict";var a=i("42a1"),s=i.n(a);s.a}}]);