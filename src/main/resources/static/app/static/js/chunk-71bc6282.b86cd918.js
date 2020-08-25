(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-71bc6282"],{"049e":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"createTest"},[a("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer","margin-top":"-30px","margin-right":"20px"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),a("div",{staticClass:"pageContent"},[a("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:t.listQuery,rules:t.rules,"label-width":"150px",inline:!0}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试时间：",required:""}},[a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{prop:"examineStartDateStr"}},[a("el-date-picker",{attrs:{format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy.MM.dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionStart,placeholder:"选择开始时间"},on:{change:t.getsTime1},model:{value:t.listQuery.examineStartDateStr,callback:function(e){t.$set(t.listQuery,"examineStartDateStr",e)},expression:"listQuery.examineStartDateStr"}})],1)],1),t._v(" "),a("el-col",{staticClass:"line",staticStyle:{"text-align":"center"},attrs:{span:2}},[t._v("至")]),t._v(" "),a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{prop:"examineEndDateStr"}},[a("el-date-picker",{attrs:{format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy.MM.dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionEnd,placeholder:"选择结束时间"},on:{change:t.getsTime2},model:{value:t.listQuery.examineEndDateStr,callback:function(e){t.$set(t.listQuery,"examineEndDateStr",e)},expression:"listQuery.examineEndDateStr"}})],1)],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("div",{staticStyle:{float:"right","margin-right":"100px"}},[a("span",[t._v("合计：")]),t._v(" "),a("span",{staticClass:"size1"},[t._v(t._s(t.typesList.totalGradeNum))]),t._v("分\n          "),a("span",{staticClass:"size1"},[t._v(t._s(t.typesList.totalTestNum))]),t._v("题\n        ")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"50px"}},[a("el-col",{attrs:{span:24}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",staticStyle:{"text-align":"center"},attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{float:"left"}},[t._v("题型设置")])]),t._v(" "),a("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},t._l(t.typesList.typeList,function(e,i){return a("el-row",{key:i,attrs:{type:"flex",justify:"center"}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"题型：",prop:"type"}},[a("el-select",{directives:[{name:"required",rawName:"v-required"}],attrs:{placeholder:"请选择",clearable:""},on:{change:function(e){return t.selectType(i)},clear:function(e){return t.cancelSelect(i)}},model:{value:e.type1,callback:function(a){t.$set(e,"type1",a)},expression:"obj.type1"}},t._l(t.typesList.typeList,function(t,e){return a("el-option",{key:e,attrs:{label:t.name,disabled:t.disabled,value:t.type}})}),1)],1)],1),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-form-item",{attrs:{label:" "}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少道题"},model:{value:e.testNum,callback:function(a){t.$set(e,"testNum",a)},expression:"obj.testNum"}},[a("template",{slot:"append"},[t._v("题")])],2)],1)],1),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-form-item",{attrs:{label:" "}},[a("el-col",{attrs:{span:24}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少分"},model:{value:e.testPrice,callback:function(a){t.$set(e,"testPrice",a)},expression:"obj.testPrice"}},[a("template",{slot:"append"},[t._v("分")])],2)],1)],1)],1)],1)}),1)],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{"text-align":"center",margin:"40px 0px 20px"}},[a("el-button",{attrs:{type:"primary"},on:{click:t.repeatTestSave}},[t._v("发起补考")])],1)],1)],1)},s=[],n=a("35b7"),r=a("6237"),l={name:"RepeatTestSet",components:{TitleCard:n["a"]},filters:{typeFilter:function(t){return"1"===t?"单选题":"2"===t?"多选题":"3"===t?"判断题":"4"===t?"填空题":"5"===t?"简答题":void 0}},props:{testId:{type:String,default:""},testName:{type:String,default:""},testTime:{type:String,default:""}},data:function(){var t=this;return{cardTitle:this.testName+"("+this.testTime+")",updateInfo:[],listQuery:{examineName:"",examineDate:"",examineStartDateStr:"",examineEndDateStr:"",examineAllNumber:0,examineSubjectId:"",examineSubjectName:"测试科目",IssueStatus:"0",typeAndNum:"",status:0},typesList:{typeList:[{type:"1",name:"单选题"},{type:"2",name:"多选题"},{type:"3",name:"判断题"},{type:"4",name:"填空题"}],totalGradeNum:0,totalTestNum:0},pickOptionStart:{disabledDate:function(e){var a=t.listQuery.examineEndDateStr;if(a)return e.getTime()>new Date(a).getTime()}},pickOptionEnd:{disabledDate:function(e){var a=t.listQuery.examineStartDateStr;if(a)return e.getTime()<new Date(a).getTime()}}}},watch:{typesList:{handler:function(t,e){var a=0,i=0;for(var s in this.typesList.typeList){var n=this.typesList.typeList[s];a+=this.StringToNumber(n.testNum)*this.StringToNumber(n.testPrice),i+=this.StringToNumber(n.testNum)}this.$set(this.typesList,"totalGradeNum",a),this.$set(this.typesList,"totalTestNum",i)},deep:!0}},methods:{getsTime1:function(t){this.listQuery.examineStartDateStr=t},getsTime2:function(t){this.listQuery.examineEndDateStr=t},repeatTestSave:function(){var t=this,e=[];for(var a in this.typesList.typeList){var i=this.typesList.typeList[a];i.type1&&e.push(i.type1+"-"+this.StringToNumber(i.testNum)+"-"+this.StringToNumber(i.testPrice))}var s={examineId:this.testId,makeUpEndDateStr:this.listQuery.examineStartDateStr,makeUpStartDateStr:this.listQuery.examineEndDateStr,typeAndNum:e.join(",")};Object(r["g"])(s).then(function(e){if(0===e.data.code){var a={id:e.data.id};t.$emit("showPage","2",a)}else t.$message({type:"info",message:e.data.msg,onClose:function(){this.$emit("showPage","1")}})})},goBack:function(){this.$emit("showPage","1")},selectType:function(t){this.$set(this.typesList.typeList[t],"disabled",!0)},cancelSelect:function(t){for(var e in this.typesList.typeList)this.$set(this.typesList.typeList[t],"disabled",!1)},StringToNumber:function(t){return t?parseInt(t):0}}},o=l,c=(a("ea6f"),a("2877")),m=Object(c["a"])(o,i,s,!1,null,"0862ce2c",null);e["default"]=m.exports},3965:function(t,e,a){},6237:function(t,e,a){"use strict";a.d(e,"f",function(){return s}),a.d(e,"b",function(){return n}),a.d(e,"h",function(){return r}),a.d(e,"a",function(){return l}),a.d(e,"d",function(){return o}),a.d(e,"c",function(){return c}),a.d(e,"e",function(){return m}),a.d(e,"g",function(){return p});var i=a("b775");function s(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function n(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function r(t){return Object(i["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function l(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function o(t){return Object(i["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function c(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function m(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function p(t){return Object(i["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}},ea6f:function(t,e,a){"use strict";var i=a("3965"),s=a.n(i);s.a}}]);