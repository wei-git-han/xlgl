(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7c1a522b","chunk-2d21a630"],{"571c":function(t,e,i){"use strict";var s=i("70ce"),a=i.n(s);a.a},"70ce":function(t,e,i){},bafa:function(t,e,i){"use strict";i.d(e,"h",function(){return a}),i.d(e,"f",function(){return n}),i.d(e,"c",function(){return l}),i.d(e,"e",function(){return r}),i.d(e,"b",function(){return u}),i.d(e,"d",function(){return o}),i.d(e,"g",function(){return c}),i.d(e,"a",function(){return p});var s=i("b775");function a(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:t})}function n(){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/subjectListAll",method:"get"})}function l(t){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/findTopicBySubId",method:"post",data:t})}function r(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/issueStatusList",method:"post",data:t})}function u(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/delete",method:"post",data:t})}function o(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/info",method:"post",data:t})}function c(t){return Object(s["a"])({url:"/app/xlgl/xlglexamsubject/getTopicNumber",method:"post",data:t})}function p(t){return Object(s["a"])({url:"/app/xlgl/xlglexamexamine/verify",method:"post",data:t})}},fa8e:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],staticClass:"createTest"},[i("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),t.testId?t._e():i("el-button",{staticClass:"noPublish",attrs:{size:"mini",type:"primary"},on:{click:t.showNoPublish}},[t._v("查看未发布考核")]),t._v(" "),i("div",{staticClass:"pageContent"},[i("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:t.listQuery,rules:t.rules,"label-width":"150px",inline:!0}},[i("el-col",{attrs:{xl:12,md:12}},[i("el-form-item",{attrs:{label:"考试名称：",prop:"examineName"}},[i("el-input",{attrs:{maxlength:"50"},model:{value:t.listQuery.examineName,callback:function(e){t.$set(t.listQuery,"examineName",e)},expression:"listQuery.examineName"}})],1)],1),t._v(" "),i("el-col",{attrs:{xl:12,md:12}},[i("el-form-item",{attrs:{label:"考试时长：",prop:"examineDate"}},[i("el-input",{attrs:{placeholder:"请输入考试时长"},model:{value:t.listQuery.examineDate,callback:function(e){t.$set(t.listQuery,"examineDate",e)},expression:"listQuery.examineDate"}},[i("template",{slot:"append"},[t._v("分")])],2)],1)],1),t._v(" "),i("el-col",{attrs:{xl:12,md:12}},[i("el-form-item",{attrs:{label:"考试时间：",required:""}},[i("el-col",{attrs:{xl:11,md:11}},[i("el-form-item",{attrs:{prop:"examineStartDateStr"}},[i("el-date-picker",{attrs:{format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionStart,placeholder:"选择开始时间"},on:{change:t.getsTime1},model:{value:t.listQuery.examineStartDateStr,callback:function(e){t.$set(t.listQuery,"examineStartDateStr",e)},expression:"listQuery.examineStartDateStr"}})],1)],1),t._v(" "),i("el-col",{staticClass:"line",staticStyle:{"text-align":"center"},attrs:{xl:2,md:2}},[t._v("至")]),t._v(" "),i("el-col",{attrs:{xl:11,md:11}},[i("el-form-item",{attrs:{prop:"examineEndDateStr"}},[i("el-date-picker",{attrs:{format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime","picker-options":t.pickOptionEnd,placeholder:"选择结束时间"},on:{change:t.getsTime2},model:{value:t.listQuery.examineEndDateStr,callback:function(e){t.$set(t.listQuery,"examineEndDateStr",e)},expression:"listQuery.examineEndDateStr"}})],1)],1)],1)],1),t._v(" "),i("el-col",{attrs:{xl:12,md:12}},[i("el-form-item",{attrs:{label:"考试科目选择：",prop:"examineSubjectId"}},[i("el-select",{attrs:{placeholder:"请选择"},on:{change:t.repeatRender},model:{value:t.listQuery.examineSubjectId,callback:function(e){t.$set(t.listQuery,"examineSubjectId",e)},expression:"listQuery.examineSubjectId"}},t._l(t.subjectListAll,function(t){return i("el-option",{key:t.id,attrs:{label:t.subjectName,value:t.id}})}),1)],1)],1)],1),t._v(" "),i("el-card",{staticClass:"box-card"},[i("div",{staticClass:"clearfix",staticStyle:{"text-align":"center"},attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{float:"left"}},[t._v("题型设置")]),t._v(" "),i("span",[t._v("合计：")]),t._v(" "),i("span",[t._v(t._s(t.totalGrade)+"分")]),t._v(" "),i("span",[t._v(t._s(t.totalNum)+"题")])]),t._v(" "),t.setTypes.length<1?i("div",[t._v("\n        该科目无题型\n      ")]):t._e(),t._v(" "),t.showtestSet?t._e():i("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},t._l(t.setTypes,function(e,s){return i("el-row",{key:s,attrs:{type:"flex",justify:"center"}},[i("el-col",{attrs:{xl:6,md:6}},[i("el-form-item",{attrs:{label:"题型：",prop:"type"}},[i("el-select",{attrs:{placeholder:"请选择",clearable:""},on:{change:function(e){return t.selectType(e,s)},clear:function(e){return t.cancelSelect(s)}},model:{value:t.selectedList["type"+s].type1,callback:function(e){t.$set(t.selectedList["type"+s],"type1",e)},expression:"selectedList[`type${index}`].type1"}},t._l(t.typeList,function(e,s){return i("el-option",{key:s,attrs:{label:e.name,disabled:t.getSelectDisabled(e.type),value:e.type}})}),1)],1)],1),t._v(" "),i("el-col",{attrs:{xl:6,md:6}},[i("el-form-item",{attrs:{label:" "}},[i("el-input",{attrs:{max:t.selectedList["type"+s].maxNum,placeholder:"请输入多少道题"},on:{change:function(e){return t.getVal(e,t.selectedList["type"+s].maxNum,s)}},model:{value:t.selectedList["type"+s].testNum,callback:function(e){t.$set(t.selectedList["type"+s],"testNum",e)},expression:"selectedList[`type${index}`].testNum"}},[i("template",{slot:"append"},[t._v("题")])],2),t._v(" "),i("div",{staticClass:"el-form-item__error",staticStyle:{width:"350px"}},[t._v(t._s(t.selectedList["type"+s].tips))])],1)],1),t._v(" "),i("el-col",{attrs:{xl:6,md:6}},[i("el-form-item",{attrs:{label:" "}},[i("el-col",{attrs:{xl:24,md:24}},[i("el-input",{attrs:{placeholder:"请输入多少分"},model:{value:t.selectedList["type"+s].testPrice,callback:function(e){t.$set(t.selectedList["type"+s],"testPrice",e)},expression:"selectedList[`type${index}`].testPrice"}},[i("template",{slot:"append"},[t._v("分")])],2)],1)],1)],1)],1)}),1),t._v(" "),t.showtestSet?i("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},t._l(t.updateInfo,function(e,s){return i("el-row",{key:s,attrs:{type:"flex",justify:"center"}},[i("el-col",{attrs:{xl:6,md:6}},[i("el-form-item",{attrs:{label:"题型：",prop:"type"}},[i("el-select",{attrs:{placeholder:"请选择",clearable:""},on:{change:t.selectType,clear:function(e){return t.cancelSelect(s)}},model:{value:t.selectedList["type"+s].type1,callback:function(e){t.$set(t.selectedList["type"+s],"type1",e)},expression:"selectedList[`type${index}`].type1"}},t._l(t.typeList,function(e,s){return i("el-option",{key:s,attrs:{label:e.name,disabled:t.getSelectDisabled(e.type),value:e.type}})}),1)],1)],1),t._v(" "),i("el-col",{attrs:{xl:6,md:6}},[i("el-form-item",{attrs:{label:" "}},[i("el-input",{attrs:{placeholder:"请输入多少道题"},model:{value:t.selectedList["type"+s].testNum,callback:function(e){t.$set(t.selectedList["type"+s],"testNum",e)},expression:"selectedList[`type${index}`].testNum"}},[i("template",{slot:"append"},[t._v("题")])],2)],1)],1),t._v(" "),i("el-col",{attrs:{xl:6,md:6}},[i("el-form-item",{attrs:{label:" "}},[i("el-col",{attrs:{xl:24,md:24}},[i("el-input",{attrs:{placeholder:"请输入多少分"},model:{value:t.selectedList["type"+s].testPrice,callback:function(e){t.$set(t.selectedList["type"+s],"testPrice",e)},expression:"selectedList[`type${index}`].testPrice"}},[i("template",{slot:"append"},[t._v("分")])],2)],1)],1)],1)],1)}),1):t._e()],1),t._v(" "),i("el-row",{staticStyle:{"text-align":"center",margin:"40px 0px 20px"}},[i("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.publicTest("1")}}},[t._v("发起考试")]),t._v(" "),i("el-button",{on:{click:function(e){return t.publicTest("0")}}},[t._v("保存")])],1)],1)],1)},a=[],n=(i("3b2b"),i("a481"),i("ac6a"),i("7f7f"),i("35b7")),l=i("bafa"),r={name:"NoPublish",components:{TitleCard:n["a"]},props:{testId:{type:String,default:""}},data:function(){var t=this;return{cardTitle:"创建考核",tableKey:0,list:null,total:0,listLoading:!0,listQuery:{examineName:"",examineDate:"",examineStartDateStr:"",examineEndDateStr:"",examineAllNumber:0,examineSubjectId:"",examineSubjectName:"测试科目",IssueStatus:"0",typeAndNum:"",status:0},typesList:[{type:"1",name:"单选题"},{type:"2",name:"多选题"},{type:"3",name:"判断题"},{type:"4",name:"填空题"}],pickOptionStart:{disabledDate:function(e){var i=t.listQuery.examineEndDateStr;return i?e.getTime()>new Date(i).getTime():e.getTime()<Date.now()-864e5}},pickOptionEnd:{disabledDate:function(e){var i=t.listQuery.examineStartDateStr;return i?e.getTime()<new Date(i).getTime()-864e5:e.getTime()<Date.now()-864e5}},subjectListAll:[],typeList:[],rules:{examineName:[{required:!0,message:"请输入考试名称,长度最多为50个字",trigger:"blur"},{validator:this.checkExamineName,trigger:"blur"}],examineDate:[{required:!0,message:"请输入考试时长",trigger:"blur"},{validator:this.isNum,trigger:"blur"}],examineStartDateStr:[{required:!0,message:"请输入开始时间",trigger:"blur"}],examineEndDateStr:[{required:!0,message:"请输入结束时间",trigger:"blur"}],examineSubjectId:[{required:!0,message:"请选择考试科目",trigger:"change"}]},updateInfo:[],totalGrade:0,totalNum:0,showtestSet:!1,first:!1,updateId:"",testTypeList:{},errorList:[],isLoading:!1,errorOptionList:[],emptyList:[],selectedList:{type0:{type1:null,testNum:null,testPrice:null,tips:null},type1:{type1:null,testNum:null,testPrice:null,tips:null},type2:{type1:null,testNum:null,testPrice:null,tips:null},type3:{type1:null,testNum:null,testPrice:null,tips:null}},tempData:{},tempData1:[],subjectName:""}},computed:{setTypes:function(){return this.typeList}},watch:{"listQuery.examineSubjectId":{handler:function(t,e){var i=this;this.subjectListAll.map(function(t){t.id===i.listQuery.examineSubjectId&&(i.listQuery.examineSubjectName=t.subjectName,i.first||(i.updateInfo=[],i.showtestSet=!1,i.findTopicBySubId(),i.getTopicNumber()))})},deep:!0},selectedList:{handler:function(t,e){var i=0,s=0;for(var a in this.selectedList){var n=this.selectedList[a];i+=this.StringToNumber(n.testNum)*this.StringToNumber(n.testPrice),s+=this.StringToNumber(n.testNum)}this.totalGrade=i,this.totalNum=s},deep:!0}},created:function(){this.tempData=Object.assign({},this.selectedList),this.getSubjectListAll(),this.testId&&this.getInfoById()},methods:{getsTime1:function(){this.dateToLong(this.listQuery.examineStartDateStr)+6e4<(new Date).getTime()?(this.$notify({title:"提示",message:"开始时间大于当前系统时间,请重新选择开始时间！",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr=""):this.dateToLong(this.listQuery.examineStartDateStr)>this.dateToLong(this.listQuery.examineEndDateStr)&&(this.$notify({title:"提示",message:"开始时间必须小于结束时间,请重新选择开始时间！",duration:1500,type:"warning"}),this.listQuery.examineStartDateStr="")},getSelectDisabled:function(t){var e=!1;for(var i in this.selectedList)this.selectedList[i].type1===t&&(e=!0);return e},getsTime2:function(t){this.listQuery.examineEndDateStr?this.dateToLong(this.listQuery.examineStartDateStr)>this.dateToLong(this.listQuery.examineEndDateStr)&&(this.$notify({title:"提示",message:"结束时间必须大于开始时间,请重新选择结束时间！",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr=""):this.dateToLong(this.listQuery.examineEndDateStr)<Date.now()&&(this.$notify({title:"提示",message:"结束时间必须大于当前系统,请重新选择结束时间！",duration:1500,type:"warning"}),this.listQuery.examineEndDateStr="")},publicTest:function(t){this.listQuery.IssueStatus=t;var e=[],i=0,s=!1,a="";if(this.typeList.length<1)this.$notify({title:"提示",message:"该类型的科目没有题型，请先去题库维护中创建题型，导入考试数据！",duration:5500,type:"warning"});else{for(var n in this.errorList=[],this.errorOptionList=[],this.emptyList=[],this.selectedList){var l=this.selectedList[n];l.type1&&l.testNum&&l.testPrice&&"0"!==l.testPrice?(this.errorNum(l.type1,parseInt(l.testNum)),i+=parseInt(l.testNum)*parseInt(l.testPrice),e.push(l.type1+"-"+l.testNum+"-"+l.testPrice)):!l.type1||l.testNum&&l.testPrice&&"0"!==l.testPrice?l.type1||this.emptyList.push(n):this.errorOptionList.push("题型、题量以及每道题的分值都需要输入！ ")}if(this.emptyList.length===this.typeList.length)this.$notify({title:"提示",message:"您还未进行试题的组合设置！",duration:5500,type:"warning"});else if(this.errorOptionList.length>0)this.$notify({title:"提示",message:this.errorOptionList[0],duration:5500,type:"warning"}),this.errorList=[],this.errorOptionList=[],this.emptyList=[];else{if(this.errorList.length>0){for(var r="",u=0;u<this.errorList.length;u++)r+="<p>"+this.errorList[u].name+"，当前数量是"+this.errorList[u].inputnum+"，题库数量为"+this.errorList[u].originNum+"，组题量不能大于题库数量</p>";a=r,s=!0}this.listQuery.examineEndDateStr||(a="请输入考试结束时间",s=!0),this.listQuery.examineStartDateStr||(a="请输入考试开始时间",s=!0),this.listQuery.examineSubjectId||(a="请选择考试科目",s=!0),this.listQuery.examineDate||(a="请输入考试时长",s=!0),this.listQuery.examineName||(a="请输入考试名称",s=!0),this.listQuery.typeAndNum=e.join(","),this.listQuery.status=0,this.listQuery.examineAllNumber=i,s?(this.$notify({title:"提示",dangerouslyUseHTMLString:!0,message:a,duration:1500,type:"warning"}),this.errorList=[],this.errorOptionList=[],this.emptyList=[]):this.saveTestPaper(t)}}},errorNum:function(t,e){"1"===t&&this.testTypeList[1]<e&&this.errorList.push({type:t,name:"单选题",inputnum:e,originNum:this.testTypeList[1]}),"2"===t&&this.testTypeList[2]<e&&this.errorList.push({type:t,name:"多选题",inputnum:e,originNum:this.testTypeList[2]}),"3"===t&&this.testTypeList[3]<e&&this.errorList.push({type:t,name:"判断题",inputnum:e,originNum:this.testTypeList[3]}),"4"===t&&this.testTypeList[4]<e&&this.errorList.push({type:t,name:"填空题",inputnum:e,originNum:this.testTypeList[4]})},saveTestPaper:function(t){var e=this;this.isLoading=!0;var i="发起考试成功！";"0"===t&&(i="保存成功！");var s=this.listQuery;this.updateId&&(s.id=this.updateId),Object(l["h"])(s).then(function(s){if("0"===s.data.code)if(e.$notify({title:"提示",message:i,duration:1500,type:"success"}),e.listQuery={},"1"===t?e.$router.push({path:"/trainingAssessment/examinationList"}):e.$emit("showPage","2"),e.updateInfo.length>0){for(var a in e.updateInfo)"totalGradeNum"===a&&"totalTestNum"===a||(e.$set(e.updateInfo[a],"type1",""),e.$set(e.updateInfo[a],"testNum",""),e.$set(e.updateInfo[a],"testPrice",""),e.$set(e.updateInfo[a],"disabled",!1));e.totalGradeNum=0,e.totalTestNum=0}else{for(var n in e.setTypes)"totalGradeNum"===n&&"totalTestNum"===n||(e.$set(e.setTypes[n],"type1",""),e.$set(e.setTypes[n],"testNum",""),e.$set(e.setTypes[n],"testPrice",""),e.$set(e.setTypes[n],"disabled",!1));e.$set(e.setTypes,"totalGradeNum",0),e.$set(e.setTypes,"totalTestNum",0)}else e.$notify({title:"提示",message:s.data.msg,duration:1500,type:"warning"});setTimeout(function(){e.isLoading=!1},500)})},getSubjectListAll:function(){var t=this;Object(l["f"])().then(function(e){t.subjectListAll=e.data.findList,t.subjectListAll.length>1&&(t.listQuery.examineSubjectId=t.subjectListAll[0].id)})},findTopicBySubId:function(){var t=this;Object(l["c"])({subjectId:this.listQuery.examineSubjectId}).then(function(e){t.typeList=[],t.tempData1=[];var i=e.data.findList.type;if(i.forEach(function(e,i){for(var s in t.typesList.map(function(i){e===i.type&&t.typeList.push(i)}),t.tempData)"type".concat(i)===s&&t.tempData1.push(i)}),t.selectedList={type0:{type1:null,testNum:null,testPrice:null,tips:null},type1:{type1:null,testNum:null,testPrice:null,tips:null},type2:{type1:null,testNum:null,testPrice:null,tips:null},type3:{type1:null,testNum:null,testPrice:null,tips:null}},t.updateInfo.length>0)for(var s=0;s<t.updateInfo.length;s++)t.selectedList["type".concat(s)].type1=t.updateInfo[s].type1,t.selectedList["type".concat(s)].testNum=t.updateInfo[s].testNum,t.selectedList["type".concat(s)].testPrice=t.updateInfo[s].testPrice,t.tempData1.push(s);for(var a in t.selectedList)a>="type"+t.tempData1.length&&t.$delete(t.selectedList,a)})},isNum:function(t,e,i){var s=/^[1-9]\d*$/;s.test(e)?i():i(new Error("只能输入除0以外的的正整数"))},selectType:function(t,e){this.selectedList["type".concat(e)].testNum&&(this.selectedList["type".concat(e)].testNum="",this.selectedList["type".concat(e)].tips="");for(var i=0;i<this.typeList.length;i++)this.typeList[i].type===t&&this.$set(this.typeList[i],"disabled",!0);for(var s in this.selectedList)this.selectedList[s].type1===t&&(this.selectedList[s].maxNum=this.testTypeList[t])},getVal:function(t,e,i){if(t>e){this.selectedList["type".concat(i)].testNum=e;for(var s=0;s<this.typeList.length;s++)this.typeList[s].type===this.selectedList["type".concat(i)].type1&&(this.subjectName=this.typeList[s].name);this.selectedList["type".concat(i)].tips="题库中仅有".concat(e,"道").concat(this.subjectName)}else this.selectedList["type".concat(i)].tips=null},cancelSelect:function(t){for(var e=0;e<this.typeList.length;e++)this.typeList[e].type===this.typeList[t].type&&this.$set(this.typeList[t],"disabled",!1)},StringToNumber:function(t){return t?parseInt(t):0},showNoPublish:function(){this.$emit("showPage","2")},getInfoById:function(){var t=this;Object(l["d"])({id:this.testId}).then(function(e){t.first=!0,t.updateId=e.data.xlglExamExamine.id,t.listQuery.examineName=e.data.xlglExamExamine.examineName,t.listQuery.examineDate=e.data.xlglExamExamine.examineDate,t.listQuery.examineStartDateStr=e.data.xlglExamExamine.examineStartDate,t.listQuery.examineEndDateStr=e.data.xlglExamExamine.examineEndDate,t.listQuery.examineSubjectId=e.data.xlglExamExamine.examineSubjectId;var i=e.data.listCount;i.forEach(function(e,s){e.type1=i[s].topicType,e.testNum=i[s].typeCount,e.testPrice=i[s].fractionalNumber,t.updateInfo.push(e)}),t.$nextTick(function(){t.showtestSet=!0,t.findTopicBySubId(),t.getTopicNumber(),t.first=!1})})},getTopicNumber:function(){var t=this,e={id:this.listQuery.examineSubjectId};Object(l["g"])(e).then(function(e){t.testTypeList=e.data,t.errorList=[]})},checkExamineName:function(t,e,i){var s={examineName:e};Object(l["a"])(s).then(function(t){t.data.status||i(new Error("考试名称重复，请重新输入"))})},dateToLong:function(t){return new Date(t.replace(new RegExp("-","gm"),"/")).getTime()},repeatRender:function(){for(var t in this.selectedList){var e=this.selectedList[t];e.type1=null,e.testNum=null,e.testPrice=null,this.selectedList[t]=e}this.totalGrade=0,this.totalNum=0}}},u=r,o=(i("571c"),i("2877")),c=Object(o["a"])(u,s,a,!1,null,"76c8ccfe",null);e["default"]=c.exports}}]);