(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2a58bb5c"],{"049e":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"createTest"},[i("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer","margin-top":"-30px","margin-right":"20px"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),i("div",{staticClass:"pageContent"},[i("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:t.listQuery,rules:t.rules,"label-width":"150px",inline:!0}},[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"考试时间：",required:""}},[i("el-col",{attrs:{span:11}},[i("el-form-item",{attrs:{prop:"examineStartDateStr"}},[i("el-date-picker",{attrs:{format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionStart,placeholder:"选择开始时间"},on:{change:t.getsTime1},model:{value:t.listQuery.examineStartDateStr,callback:function(e){t.$set(t.listQuery,"examineStartDateStr",e)},expression:"listQuery.examineStartDateStr"}})],1)],1),t._v(" "),i("el-col",{staticClass:"line",staticStyle:{"text-align":"center"},attrs:{span:2}},[t._v("至")]),t._v(" "),i("el-col",{attrs:{span:11}},[i("el-form-item",{attrs:{prop:"examineEndDateStr"}},[i("el-date-picker",{attrs:{format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionEnd,placeholder:"选择结束时间"},on:{change:t.getsTime2},model:{value:t.listQuery.examineEndDateStr,callback:function(e){t.$set(t.listQuery,"examineEndDateStr",e)},expression:"listQuery.examineEndDateStr"}})],1)],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("div",{staticStyle:{float:"right","margin-right":"100px"}},[i("span",[t._v("合计：")]),t._v(" "),i("span",{staticClass:"size1"},[t._v(t._s(t.typesList.totalGradeNum))]),t._v("分\n          "),i("span",{staticClass:"size1"},[t._v(t._s(t.typesList.totalTestNum))]),t._v("题\n        ")])])],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"50px"}},[i("el-col",{attrs:{span:24}},[i("el-card",{staticClass:"box-card"},[i("div",{staticClass:"clearfix",staticStyle:{"text-align":"center"},attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{float:"left"}},[t._v("题型设置")])]),t._v(" "),i("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},t._l(t.typesList.typeList,function(e,a){return i("el-row",{key:a,attrs:{type:"flex",justify:"center"}},[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"题型：",prop:"type"}},[i("el-select",{attrs:{placeholder:"请选择",clearable:""},on:{change:t.selectType,clear:function(e){return t.cancelSelect(a)}},model:{value:e.type1,callback:function(i){t.$set(e,"type1",i)},expression:"obj.type1"}},t._l(t.typesList.typeList,function(t,e){return i("el-option",{key:e,attrs:{label:t.name,disabled:t.disabled,value:t.type}})}),1)],1)],1),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:" "}},[i("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少道题"},model:{value:e.testNum,callback:function(i){t.$set(e,"testNum",i)},expression:"obj.testNum"}},[i("template",{slot:"append"},[t._v("题")])],2)],1)],1),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:" "}},[i("el-col",{attrs:{span:24}},[i("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少分"},model:{value:e.testPrice,callback:function(i){t.$set(e,"testPrice",i)},expression:"obj.testPrice"}},[i("template",{slot:"append"},[t._v("分")])],2)],1)],1)],1)],1)}),1)],1)],1)],1),t._v(" "),i("el-row",{staticStyle:{"text-align":"center",margin:"40px 0px 20px"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.repeatTestSave}},[t._v("发起补考")])],1)],1)],1)},n=[],s=(i("3b2b"),i("a481"),i("ac6a"),i("28a5"),i("35b7")),r=i("6237"),l={name:"RepeatTestSet",components:{TitleCard:s["a"]},directives:{required:{inserted:function(t){t.firstElementChild.firstElementChild.addEventListener("blur",function(){var e=t.firstElementChild.firstElementChild.value,i="blobk",a="",n="red";t.nextSibling&&"div"===t.nextSibling.parentNode.lastChild.localName&&t.nextSibling.parentNode.removeChild(t.nextSibling.parentNode.lastChild);var s=document.createElement("div");e.length<1?a="非空":(i="none",n="#dcdfe6"),t.firstElementChild.style.borderColor=n,s.innerText=a,s.style.display=i,s.style.color="red",t.nextSibling&&t.nextSibling.parentNode.appendChild(s)})}},limitNum:{inserted:function(t){t.firstElementChild.addEventListener("blur",function(){var e=t.firstElementChild.value,i="blobk",a="",n="red";t.nextSibling&&"div"===t.nextSibling.parentNode.lastChild.localName&&t.nextSibling.parentNode.removeChild(t.nextSibling.parentNode.lastChild);var s=document.createElement("div");e.length<1?a="非空":/^[1-9]\d*$/.test(e)?(i="none",n="#dcdfe6"):a="只能输入0以外的正整数",t.firstElementChild.style.borderColor=n,s.innerText=a,s.style.display=i,s.style.color="red",t.nextSibling?t.nextSibling.parentNode.appendChild(s):t.parentNode.appendChild(s)})}}},filters:{typeFilter:function(t){return"1"===t?"单选题":"2"===t?"多选题":"3"===t?"判断题":"4"===t?"填空题":"5"===t?"简答题":void 0}},props:{testId:{type:String,default:""},testName:{type:String,default:""},testTime:{type:String,default:""},topicTypeList:{type:Array,default:function(){}}},data:function(){var t=this;return{cardTitle:this.testName+"("+this.testTime+")",updateInfo:[],endDateTime:"",endDateTime1:"",listQuery:{examineName:"",examineDate:"",examineStartDateStr:"",examineEndDateStr:"",examineAllNumber:0,examineSubjectId:"",examineSubjectName:"测试科目",IssueStatus:"0",typeAndNum:"",status:0},typesList:{typeList:[],totalGradeNum:0,totalTestNum:0},pickOptionStart:{disabledDate:function(e){var i=t.listQuery.examineEndDateStr;return i?e.getTime()>new Date(i).getTime():e.getTime()<new Date(t.endDateTime).getTime()}},pickOptionEnd:{disabledDate:function(e){var i=t.listQuery.examineStartDateStr;return i?e.getTime()<new Date(i).getTime():e.getTime()<new Date(t.endDateTime).getTime()}},rules:{examineStartDateStr:[{required:!0,message:"请输入开始时间",trigger:"blur"}],examineEndDateStr:[{required:!0,message:"请输入结束时间",trigger:"blur"}]}}},watch:{typesList:{handler:function(t,e){console.log(t,e);var i=0,a=0;for(var n in this.typesList.typeList){var s=this.typesList.typeList[n];i+=this.StringToNumber(s.testNum)*this.StringToNumber(s.testPrice),a+=this.StringToNumber(s.testNum)}this.$set(this.typesList,"totalGradeNum",i),this.$set(this.typesList,"totalTestNum",a)},deep:!0}},created:function(){var t=this;if(this.testTime){var e=this.testTime.split("~");e[1]?(this.endDateTime1=e[1],new Date(e[1]).getTime()<Date.now()?this.endDateTime=Date.now():this.endDateTime=e[1]):(this.endDateTime1=Date.now(),this.endDateTime=Date.now())}this.topicTypeList.forEach(function(e,i){"1"===e&&t.typesList.typeList.push({type:"1",name:"单选题"}),"2"===e&&t.typesList.typeList.push({type:"2",name:"多选题"}),"3"===e&&t.typesList.typeList.push({type:"3",name:"判断题"}),"4"===e&&t.typesList.typeList.push({type:"4",name:"填空题"})})},methods:{getsTime1:function(t){this.listQuery.examineEndDateStr?(this.dateToLong(this.listQuery.examineStartDateStr)<this.dateToLong(this.endDateTime1)&&(this.$notify({title:"提示",message:"开始时间大于上次考试时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr=""),this.dateToLong(this.listQuery.examineStartDateStr)>this.dateToLong(this.listQuery.examineEndDateStr)&&(this.$notify({title:"提示",message:"开始时间必须小于结束时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr="")):this.dateToLong(this.listQuery.examineStartDateStr)<this.dateToLong(this.endDateTime1)?(this.$notify({title:"提示",message:"开始时间大于上次考试时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr=""):this.dateToLong(this.listQuery.examineStartDateStr)<(new Date).getTime()&&(this.$notify({title:"提示",message:"开始时间必须大于系统时间",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr="")},getsTime2:function(t){this.listQuery.examineStartDateStr?this.dateToLong(this.listQuery.examineStartDateStr)>this.dateToLong(this.listQuery.examineEndDateStr)&&(this.$notify({title:"提示",message:"结束时间必须大于开始时间",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr=""):this.dateToLong(this.listQuery.examineEndDateStr)<this.dateToLong(this.endDateTime1)?(this.$notify({title:"提示",message:"结束时间大于上次考试时间",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr=""):this.dateToLong(this.listQuery.examineEndDateStr)<(new Date).getTime()&&(this.$notify({title:"提示",message:"结束时间必须大于系统时间",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr="")},repeatTestSave:function(){var t=this;this.$refs.form.validate(function(e){if(e){var i=[];for(var a in t.typesList.typeList){var n=t.typesList.typeList[a];n.type1&&i.push(n.type1+"-"+t.StringToNumber(n.testNum)+"-"+t.StringToNumber(n.testPrice))}var s={examineId:t.testId,makeUpEndDateStr:t.listQuery.examineStartDateStr,makeUpStartDateStr:t.listQuery.examineEndDateStr,typeAndNum:i.join(",")};Object(r["h"])(s).then(function(e){if(0===e.data.code)t.$emit("showPage","1");else{var i=t;t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning",onClose:function(){i.$emit("showPage","1")}})}})}})},goBack:function(){this.$emit("showPage","1")},selectType:function(t){for(var e=0;e<this.typesList.typeList.length;e++)this.typesList.typeList[e].type===t&&this.$set(this.typesList.typeList[e],"disabled",!0)},cancelSelect:function(t){for(var e=0;e<this.typesList.typeList.length;e++)this.typesList.typeList[e].type===this.typesList.typeList[t].type&&this.$set(this.typesList.typeList[t],"disabled",!1)},StringToNumber:function(t){return t?parseInt(t):0},dateToLong:function(t){return new Date(t.replace(new RegExp("-","gm"),"/")).getTime()}}},o=l,m=(i("66ba"),i("2877")),d=Object(m["a"])(o,a,n,!1,null,"3d7da8f7",null);e["default"]=d.exports},"1850c":function(t,e,i){},6237:function(t,e,i){"use strict";i.d(e,"g",function(){return n}),i.d(e,"c",function(){return s}),i.d(e,"i",function(){return r}),i.d(e,"b",function(){return l}),i.d(e,"e",function(){return o}),i.d(e,"d",function(){return m}),i.d(e,"f",function(){return d}),i.d(e,"h",function(){return p}),i.d(e,"k",function(){return u}),i.d(e,"j",function(){return c}),i.d(e,"a",function(){return y});var a=i("b775");function n(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function s(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function r(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function o(t){return Object(a["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function m(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglexamanswer/saveBatchLIANXI",method:"post",data:t})}function y(t){return Object(a["a"])({url:"/app/xlgl/sysorgan/currenttree",method:"post",data:t})}},"66ba":function(t,e,i){"use strict";var a=i("1850c"),n=i.n(a);n.a}}]);