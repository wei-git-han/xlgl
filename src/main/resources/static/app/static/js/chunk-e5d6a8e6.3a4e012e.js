(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-e5d6a8e6","chunk-2d0cef16"],{6237:function(t,e,i){"use strict";i.d(e,"i",function(){return n}),i.d(e,"d",function(){return a}),i.d(e,"k",function(){return l}),i.d(e,"c",function(){return r}),i.d(e,"f",function(){return c}),i.d(e,"e",function(){return u}),i.d(e,"h",function(){return o}),i.d(e,"j",function(){return p}),i.d(e,"m",function(){return d}),i.d(e,"l",function(){return m}),i.d(e,"a",function(){return h}),i.d(e,"b",function(){return y}),i.d(e,"g",function(){return f});var s=i("b775");function n(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/list",method:"get",params:t})}function a(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/view/examine",method:"post",data:t})}function l(t){return Object(s["a"])({url:"/app/xlgl/xlglexamanswer/saveBatch",method:"post",data:t})}function r(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/conutInto",method:"post",data:t})}function c(t){return Object(s["a"])({url:"/app/xlgl/xlglexammainanswer/list",method:"post",data:t})}function u(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/examineTotal",method:"post",data:t})}function o(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/topicTypeCount",method:"post",data:t})}function p(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexaminemakeup/save",method:"post",data:t})}function d(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function m(t){return Object(s["a"])({url:"/app/xlgl/xlglexamanswer/saveBatchLIANXI",method:"post",data:t})}function h(t){return Object(s["a"])({url:"/app/xlgl/sysorgan/currenttree",method:"post",data:t})}function y(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/examAnalyse",method:"post",data:t})}function f(t){return Object(s["a"])({url:"app/xlgl/xlglexamanswer/getReplyLack",method:"post",data:t})}},"63ab":function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"createTest"},[i("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{float:"right",cursor:"pointer","margin-top":"-30px","margin-right":"20px"},attrs:{"icon-class":"goback"},on:{click:t.goBack}}),t._v(" "),i("div",{staticClass:"pageContent"},[i("el-col",{attrs:{span:10}},[i("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:t.listQuery,rules:t.rules,"label-width":"150px",inline:!0}},[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"考试科目选择：",prop:"examineSubjectId"}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.listQuery.examineSubjectId,callback:function(e){t.$set(t.listQuery,"examineSubjectId",e)},expression:"listQuery.examineSubjectId"}},t._l(t.subjectListAll,function(t){return i("el-option",{key:t.id,attrs:{label:t.subjectName,value:t.id}})}),1)],1)],1),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"考试时长：",prop:"examineDate"}},[i("el-input",{attrs:{placeholder:"请输入考试时长"},model:{value:t.listQuery.examineDate,callback:function(e){t.$set(t.listQuery,"examineDate",e)},expression:"listQuery.examineDate"}},[i("template",{slot:"append"},[t._v("分")])],2)],1)],1),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"考试类别："}},[i("el-radio-group",{model:{value:t.listQuery.status,callback:function(e){t.$set(t.listQuery,"status",e)},expression:"listQuery.status"}},[i("el-radio",{attrs:{label:0}},[t._v("模拟考试练习")]),t._v(" "),i("el-radio",{attrs:{label:1}},[t._v("自定义练习")])],1)],1)],1)],1)],1),t._v(" "),t.listQuery.state?i("el-col",{staticStyle:{background:"#EEF5FF",padding:"10px 20px",color:"#4794E9","max-height":"150px","overflow-y":"auto"},attrs:{span:14}},[t._v("\n      "+t._s(t.listQuery.state)+"\n    ")]):t._e(),t._v(" "),i("el-row",{staticStyle:{"margin-top":"150px"}},[i("el-col",{attrs:{span:24}},[i("el-card",{staticClass:"box-card"},[i("div",{staticClass:"clearfix",staticStyle:{"text-align":"center"},attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{float:"left"}},[t._v("题型设置")]),t._v(" "),i("span",[t._v("合计：")]),t._v(" "),0===t.listQuery.status?i("span",[t._v(t._s(t.totalGrade)+"分")]):t._e(),t._v(" "),1===t.listQuery.status?i("span",[t._v(t._s(t.totalNum)+"题")]):t._e()]),t._v(" "),1===t.listQuery.status?i("el-checkbox",{staticStyle:{"margin-left":"410px","margin-bottom":"20px"},on:{change:t.changeCheckAll},model:{value:t.checkedFlag,callback:function(e){t.checkedFlag=e},expression:"checkedFlag"}},[t._v("全量题目练习")]):t._e(),t._v(" "),i("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},t._l(t.setTypes,function(e,s){return i("el-row",{key:s,attrs:{type:"flex",justify:"center"}},[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"题型：",prop:"type"}},[i("el-select",{directives:[{name:"required",rawName:"v-required"}],attrs:{placeholder:"请选择",clearable:""},on:{change:function(e){return t.selectType(e,s)},clear:function(e){return t.cancelSelect(s)}},model:{value:t.selectedList["type"+s].type1,callback:function(e){t.$set(t.selectedList["type"+s],"type1",e)},expression:"selectedList[`type${index}`].type1"}},t._l(t.typeList,function(e,s){return i("el-option",{key:s,attrs:{label:e.name,disabled:t.getSelectDisabled(e.type),value:e.type}})}),1)],1)],1),t._v(" "),1===t.listQuery.status?i("el-col",{attrs:{span:1}},[i("el-checkbox",{staticStyle:{"margin-top":"10px"},on:{change:function(e){return t.changeCheck(e,s)}},model:{value:t.selectedList["type"+s].checkedFlag,callback:function(e){t.$set(t.selectedList["type"+s],"checkedFlag",e)},expression:"selectedList[`type${index}`].checkedFlag"}},[t._v("全选")])],1):t._e(),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:" "}},[i("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{max:t.selectedList["type"+s].maxNum,placeholder:"请输入多少道题"},on:{change:function(e){return t.getVal(e,t.selectedList["type"+s].maxNum,s)}},model:{value:t.selectedList["type"+s].testNum,callback:function(e){t.$set(t.selectedList["type"+s],"testNum",e)},expression:"selectedList[`type${index}`].testNum"}},[i("template",{slot:"append"},[t._v("题")])],2)],1)],1),t._v(" "),0===t.listQuery.status?i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:" "}},[i("el-col",{attrs:{span:24}},[i("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少分"},model:{value:t.selectedList["type"+s].testPrice,callback:function(e){t.$set(t.selectedList["type"+s],"testPrice",e)},expression:"selectedList[`type${index}`].testPrice"}},[i("template",{slot:"append"},[t._v("分")])],2)],1)],1)],1):t._e()],1)}),1)],1)],1)],1),t._v(" "),i("el-row",{staticStyle:{"text-align":"center",margin:"40px 0px 20px"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.repeatTestSave}},[t._v("开始练习")]),t._v(" "),i("el-button",{on:{click:t.goBack}},[t._v("取消")])],1)],1)],1)},n=[],a=(i("ac6a"),i("7f7f"),i("35b7")),l=i("6237"),r=i("bafa"),c=i("e64d"),u={name:"PriticeTestSet",components:{TitleCard:a["a"]},directives:{required:{inserted:function(t){t.firstElementChild.firstElementChild.addEventListener("blur",function(){var e=t.firstElementChild.firstElementChild.value,i="blobk",s="",n="red";t.nextSibling&&"div"===t.nextSibling.parentNode.lastChild.localName&&t.nextSibling.parentNode.removeChild(t.nextSibling.parentNode.lastChild);var a=document.createElement("div");e.length<1?s="非空":(i="none",n="#dcdfe6"),t.firstElementChild.style.borderColor=n,a.innerText=s,a.style.display=i,a.style.color="red",t.nextSibling&&t.nextSibling.parentNode.appendChild(a)})}},limitNum:{inserted:function(t){t.firstElementChild.addEventListener("blur",function(){var e=t.firstElementChild.value,i="blobk",s="",n="red";t.nextSibling&&"div"===t.nextSibling.parentNode.lastChild.localName&&t.nextSibling.parentNode.removeChild(t.nextSibling.parentNode.lastChild);var a=document.createElement("div");e.length<1?s="非空":/^[1-9]\d*$/.test(e)?(i="none",n="#dcdfe6"):s="只能输入0以外的正整数",t.firstElementChild.style.borderColor=n,a.innerText=s,a.style.display=i,a.style.color="red",t.nextSibling?t.nextSibling.parentNode.appendChild(a):t.parentNode.appendChild(a)})}}},filters:{typeFilter:function(t){return"1"===t?"单选题":"2"===t?"多选题":"3"===t?"判断题":"4"===t?"填空题":"5"===t?"简答题":void 0}},props:{testId:{type:String,default:""},testName:{type:String,default:""},testTime:{type:String,default:""}},data:function(){var t=this;return{cardTitle:"自主练习",updateInfo:[],listQuery:{examineName:"",examineDate:"",examineStartDateStr:"",examineEndDateStr:"",examineAllNumber:0,examineSubjectId:"",examineSubjectName:"",IssueStatus:"0",typeAndNum:"",status:0,state:""},typesList:[{type:"1",name:"单选题"},{type:"2",name:"多选题"},{type:"3",name:"判断题"},{type:"4",name:"填空题"}],typeList:[],pickOptionStart:{disabledDate:function(e){var i=t.listQuery.examineEndDateStr;if(i)return e.getTime()>new Date(i).getTime()}},pickOptionEnd:{disabledDate:function(e){var i=t.listQuery.examineStartDateStr;if(i)return e.getTime()<new Date(i).getTime()}},subjectListAll:[],rules:{examineName:[{required:!0,message:"请输入考试名称",trigger:"blur"}],examineDate:[{validator:this.isNum,trigger:"blur"}]},testTypeList:{},errorList:[],errorOptionList:[],emptyList:[],totalGrade:0,totalNum:0,selectedList:{type0:{type1:null,testNum:null,testPrice:null,checkedFlag:!1},type1:{type1:null,testNum:null,testPrice:null,checkedFlag:!1},type2:{type1:null,testNum:null,testPrice:null,checkedFlag:!1},type3:{type1:null,testNum:null,testPrice:null,checkedFlag:!1}},tempData:{},tempData1:[],checkedFlag:!1}},computed:{setTypes:function(){return this.typeList}},watch:{"listQuery.examineSubjectId":{handler:function(t,e){var i=this;this.subjectListAll.map(function(t){t.id===i.listQuery.examineSubjectId&&(i.listQuery.examineSubjectName=t.subjectName,i.checkedFlag&&(i.checkedFlag=!1))}),this.getSubjectState(),this.getTopicNumber(),this.findTopicBySubId()},deep:!0},selectedList:{handler:function(t,e){var i=0,s=0;for(var n in this.selectedList){var a=this.selectedList[n];i+=this.StringToNumber(a.testNum)*this.StringToNumber(a.testPrice),s+=this.StringToNumber(a.testNum)}this.totalGrade=i,this.totalNum=s},deep:!0}},created:function(){this.tempData=Object.assign({},this.selectedList),this.getSubjectListAll()},methods:{getSelectDisabled:function(t){var e=!1;for(var i in this.selectedList)this.selectedList[i].type1===t&&(e=!0);return e},isNum:function(t,e,i){var s=/^[1-9]\d*$/;s.test(e)?i():i(new Error("只能输入除0以外的的正整数"))},repeatTestSave:function(){var t=this,e=/^[1-9]\d*$/,i=[];if(e.test(this.listQuery.examineDate)){for(var s in this.errorList=[],this.errorOptionList=[],this.emptyList=[],this.selectedList){var n=this.selectedList[s];n.type1?0===this.listQuery.status?n.testNum&&n.testPrice?(this.errorNum(n.type1,parseInt(n.testNum)),i.push(n.type1+"-"+n.testNum+"-"+n.testPrice)):this.errorOptionList.push("题型、题量以及每道题的分值都需要输入！ "):1===this.listQuery.status&&(n.testNum?(this.errorNum(n.type1,parseInt(n.testNum)),i.push(n.type1+"-"+n.testNum+"-0")):this.errorOptionList.push("题型、题量都需要输入！ ")):n.type1||this.emptyList.push(s)}if(this.emptyList.length===this.typeList.length)this.$notify({title:"提示",message:"您还未进行试题的组合设置！",duration:5500,type:"warning"});else if(this.errorOptionList.length>0)this.$notify({title:"提示",message:this.errorOptionList[0],duration:5500,type:"warning"}),this.errorList=[],this.errorOptionList=[],this.emptyList=[];else if(this.errorList.length>0){for(var a="",r=0;r<this.errorList.length;r++)a+="<p>"+this.errorList[r].name+"，当前数量是"+this.errorList[r].inputnum+"，题库数量为"+this.errorList[r].originNum+"，组题量不能大于题库数量</p>";this.$notify({title:"提示",dangerouslyUseHTMLString:!0,message:a,duration:1500,type:"warning"}),this.errorList=[],this.errorOptionList=[],this.emptyList=[]}else{var c={examineDate:this.listQuery.examineDate,examineSubjectId:this.listQuery.examineSubjectId,examineSubjectName:this.listQuery.examineSubjectName,lianxiType:this.listQuery.status,status:1,typeAndNum:i.join(",")};Object(l["m"])(c).then(function(e){if("0"===e.data.code){var i={id:e.data.examineId};t.$emit("showPage","8",i)}else t.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"})})}}else this.$notify({title:"提示",message:"考试时长，只能输入除0以外的的正整数",duration:1500,type:"warning"})},goBack:function(){this.$emit("showPage","1")},selectType:function(t,e){this.selectedList["type".concat(e)].testNum&&(this.selectedList["type".concat(e)].testNum="");for(var i=0;i<this.typeList.length;i++)this.typeList[i].type===t&&this.$set(this.typeList[i],"disabled",!0);for(var s in this.selectedList)this.selectedList[s].type1===t&&(this.selectedList[s].maxNum=this.testTypeList[t])},getVal:function(t,e,i){if(t>e){this.selectedList["type".concat(i)].testNum=e;for(var s=0;s<this.typeList.length;s++)this.typeList[s].type===this.selectedList["type".concat(i)].type1&&(this.subjectName=this.typeList[s].name,this.$notify({title:"提示",message:"".concat(this.subjectName,"，题库数量为").concat(e,",组题数量不能大于题库数量"),duration:2e3,type:"warning"}))}},cancelSelect:function(t){this.selectedList["type".concat(t)].checkedFlag=!1;for(var e=0;e<this.typeList.length;e++)this.typeList[e].type===this.typeList[t].type&&this.$set(this.typeList[t],"disabled",!1)},StringToNumber:function(t){return t?parseInt(t):0},getSubjectListAll:function(){var t=this;Object(r["f"])().then(function(e){t.subjectListAll=e.data.findList,t.subjectListAll.length>1&&(t.listQuery.examineSubjectId=t.subjectListAll[0].id,t.listQuery.examineSubjectName=t.subjectListAll[0].subjectName)})},getSubjectState:function(){var t=this,e={id:this.listQuery.examineSubjectId};Object(c["g"])(e).then(function(e){t.listQuery.state=e.data.state})},getTopicNumber:function(){var t=this,e={id:this.listQuery.examineSubjectId};Object(r["g"])(e).then(function(e){t.testTypeList=e.data,t.errorList=[]})},errorNum:function(t,e){"1"===t&&this.testTypeList[0]<e&&this.errorList.push({type:t,name:"单选题",inputnum:e,originNum:this.testTypeList[0]}),"2"===t&&this.testTypeList[1]<e&&this.errorList.push({type:t,name:"多选题",inputnum:e,originNum:this.testTypeList[1]}),"3"===t&&this.testTypeList[2]<e&&this.errorList.push({type:t,name:"判断题",inputnum:e,originNum:this.testTypeList[2]}),"4"===t&&this.testTypeList[3]<e&&this.errorList.push({type:t,name:"填空题",inputnum:e,originNum:this.testTypeList[3]})},findTopicBySubId:function(){var t=this;Object(r["c"])({subjectId:this.listQuery.examineSubjectId}).then(function(e){var i=e.data.findList.type;for(var s in t.typeList=[],t.tempData1=[],i.forEach(function(e,i){for(var s in t.typesList.map(function(i){e===i.type&&t.typeList.push(i)}),t.tempData)"type".concat(i)===s&&t.tempData1.push(i)}),t.selectedList={type0:{type1:null,testNum:null,testPrice:null,checkedFlag:!1},type1:{type1:null,testNum:null,testPrice:null,checkedFlag:!1},type2:{type1:null,testNum:null,testPrice:null,checkedFlag:!1},type3:{type1:null,testNum:null,testPrice:null,checkedFlag:!1}},t.selectedList)s>="type"+t.tempData1.length&&t.$delete(t.selectedList,s)})},changeCheckAll:function(t){if(!0===t)for(var e=0;e<this.typeList.length;e++)this.selectedList["type".concat(e)].type1=this.typeList[e].type,this.selectedList["type".concat(e)].maxNum=this.testTypeList[this.typeList[e].type],this.selectedList["type".concat(e)].testNum=this.testTypeList[this.typeList[e].type],this.selectedList["type".concat(e)].checkedFlag=!0;else for(var i=0;i<this.typeList.length;i++)this.selectedList["type".concat(i)].type1=null,this.selectedList["type".concat(i)].testNum=null,this.selectedList["type".concat(i)].checkedFlag=!1},changeCheck:function(t,e){!0===t?(this.selectedList["type".concat(e)].type1=this.typeList[e].type,this.selectedList["type".concat(e)].maxNum=this.testTypeList[this.typeList[e].type],this.selectedList["type".concat(e)].testNum=this.testTypeList[this.typeList[e].type]):(this.selectedList["type".concat(e)].type1=null,this.selectedList["type".concat(e)].maxNum=null,this.selectedList["type".concat(e)].testNum=null)}}},o=u,p=(i("efc3"),i("2877")),d=Object(p["a"])(o,s,n,!1,null,"4bf94a80",null);e["default"]=d.exports},cc2f:function(t,e,i){},e64d:function(t,e,i){"use strict";i.d(e,"a",function(){return n}),i.d(e,"i",function(){return a}),i.d(e,"h",function(){return l}),i.d(e,"c",function(){return r}),i.d(e,"f",function(){return c}),i.d(e,"b",function(){return u}),i.d(e,"d",function(){return o}),i.d(e,"e",function(){return p}),i.d(e,"g",function(){return d}),i.d(e,"j",function(){return m}),i.d(e,"k",function(){return h}),i.d(e,"l",function(){return y});var s=i("b775");function n(t){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/save",method:"post",data:t})}function a(){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/subject",method:"get"})}function l(t){return Object(s["a"])({url:"/app/xlgl/xlglexamtopic/list",method:"get",params:t})}function r(t){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/update",method:"post",data:t})}function c(t){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/delete",method:"post",data:t})}function u(t){return Object(s["a"])({url:"/app/xlgl/xlglexamtopic/delete",method:"post",data:t})}function o(t){return Object(s["a"])({url:"/app/xlgl/xlglexamtopic/info",method:"post",data:t})}function p(t){return Object(s["a"])({url:"/app/xlgl/xlglexamfile/list",method:"post",data:t})}function d(t){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/getSubjectState",method:"post",data:t})}function m(t){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/getUpLoad",method:"post",data:t})}function h(t){return Object(s["a"])({url:"/app/xlgl/xlglexamtopic/saveTopic",method:"post",data:t})}function y(t){return Object(s["a"])({url:"/app/xlgl/xlglexamtopic/updateTopic",method:"post",data:t})}},efc3:function(t,e,i){"use strict";var s=i("cc2f"),n=i.n(s);n.a}}]);