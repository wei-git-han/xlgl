(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7a0241b2"],{"4e77":function(e,t,a){"use strict";var i=a("c403"),n=a.n(i);n.a},bafa:function(e,t,a){"use strict";a.d(t,"f",function(){return n}),a.d(t,"e",function(){return s}),a.d(t,"b",function(){return l}),a.d(t,"d",function(){return r}),a.d(t,"a",function(){return u}),a.d(t,"c",function(){return o});var i=a("b775");function n(e){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/saveOrUpdate",method:"post",data:e})}function s(){return Object(i["a"])({url:"/app/xlgl/xlglexamsubject/subjectListAll",method:"get"})}function l(e){return Object(i["a"])({url:"/app/xlgl/xlglexamsubject/findTopicBySubId",method:"post",data:e})}function r(e){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/issueStatusList",method:"post",data:e})}function u(e){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/delete",method:"post",data:e})}function o(e){return Object(i["a"])({url:"/app/xlgl/xlglexamexamine/info",method:"post",data:e})}},c403:function(e,t,a){},fa8e:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"createTest"},[a("title-card",{attrs:{"title-text":e.cardTitle}}),e._v(" "),a("el-button",{staticClass:"noPublish",attrs:{size:"mini",type:"primary"},on:{click:e.showNoPublish}},[e._v("查看未发布考核")]),e._v(" "),a("div",{staticClass:"pageContent"},[a("el-form",{ref:"form",staticClass:"oraganForm",attrs:{model:e.listQuery,rules:e.rules,"label-width":"150px",inline:!0}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试名称：",prop:"examineName"}},[a("el-input",{model:{value:e.listQuery.examineName,callback:function(t){e.$set(e.listQuery,"examineName",t)},expression:"listQuery.examineName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试时长：",prop:"examineDate"}},[a("el-input",{attrs:{placeholder:"请输入考试时长"},model:{value:e.listQuery.examineDate,callback:function(t){e.$set(e.listQuery,"examineDate",t)},expression:"listQuery.examineDate"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试时间：",required:""}},[a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{prop:"examineStartDateStr"}},[a("el-date-picker",{attrs:{type:"datetime","picker-options":e.pickOptionStart,placeholder:"选择开始时间"},model:{value:e.listQuery.examineStartDateStr,callback:function(t){e.$set(e.listQuery,"examineStartDateStr",t)},expression:"listQuery.examineStartDateStr"}})],1)],1),e._v(" "),a("el-col",{staticClass:"line",staticStyle:{"text-align":"center"},attrs:{span:2}},[e._v("至")]),e._v(" "),a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{prop:"examineEndDateStr"}},[a("el-date-picker",{attrs:{type:"datetime","picker-options":e.pickOptionEnd,placeholder:"选择结束时间"},model:{value:e.listQuery.examineEndDateStr,callback:function(t){e.$set(e.listQuery,"examineEndDateStr",t)},expression:"listQuery.examineEndDateStr"}})],1)],1)],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"考试科目选择：",prop:"examineSubjectId"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.listQuery.examineSubjectId,callback:function(t){e.$set(e.listQuery,"examineSubjectId",t)},expression:"listQuery.examineSubjectId"}},e._l(e.subjectListAll,function(e){return a("el-option",{key:e.id,attrs:{label:e.subjectName,value:e.id}})}),1)],1)],1)],1),e._v(" "),a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",staticStyle:{"text-align":"center"},attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{float:"left"}},[e._v("题型设置")]),e._v(" "),a("span",[e._v("合计：")]),e._v(" "),a("span",[e._v(e._s(e.setTypes.totalGradeNum)+"分")]),e._v(" "),a("span",[e._v(e._s(e.setTypes.totalTestNum)+"题")])]),e._v(" "),e.setTypes.length<1?a("div",[e._v("\n        该科目无题型\n      ")]):e._e(),e._v(" "),0===e.updateInfo.length?a("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},e._l(e.setTypes,function(t,i){return a("el-row",{key:i,attrs:{type:"flex",justify:"center"}},[a("el-col",{attrs:{span:1}},[a("span",{staticClass:"spanPosition"},[e._v("*")])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"题型：",prop:"type"}},[a("el-select",{directives:[{name:"required",rawName:"v-required"}],attrs:{placeholder:"请选择",clearable:""},on:{change:function(t){return e.selectType(i)},clear:function(t){return e.cancelSelect(i)}},model:{value:t.type1,callback:function(a){e.$set(t,"type1",a)},expression:"obj.type1"}},e._l(e.typeList,function(e,t){return a("el-option",{key:t,attrs:{label:e.name,disabled:e.disabled,value:e.type}})}),1)],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:" "}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少道题"},model:{value:t.testNum,callback:function(a){e.$set(t,"testNum",a)},expression:"obj.testNum"}},[a("template",{slot:"append"},[e._v("题")])],2)],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:" "}},[a("el-col",{attrs:{span:24}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少分"},model:{value:t.testPrice,callback:function(a){e.$set(t,"testPrice",a)},expression:"obj.testPrice"}},[a("template",{slot:"append"},[e._v("分")])],2)],1)],1)],1)],1)}),1):e._e(),e._v(" "),e.updateInfo.length>0?a("el-form",{staticClass:"oraganForm",attrs:{"label-width":"",inline:!0}},e._l(e.updateInfo,function(t,i){return a("el-row",{key:i,attrs:{type:"flex",justify:"center"}},[a("el-col",{attrs:{span:1}},[a("span",{staticClass:"spanPosition"},[e._v("*")])]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"题型：",prop:"type"}},[a("el-select",{directives:[{name:"required",rawName:"v-required"}],attrs:{placeholder:"请选择",clearable:""},on:{change:function(t){return e.selectType(i)},clear:function(t){return e.cancelSelect(i)}},model:{value:t.type1,callback:function(a){e.$set(t,"type1",a)},expression:"obj.type1"}},e._l(e.typeList,function(e,t){return a("el-option",{key:t,attrs:{label:e.name,disabled:e.disabled,value:e.type}})}),1)],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:" "}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少道题"},model:{value:t.testNum,callback:function(a){e.$set(t,"testNum",a)},expression:"obj.testNum"}},[a("template",{slot:"append"},[e._v("题")])],2)],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:" "}},[a("el-col",{attrs:{span:24}},[a("el-input",{directives:[{name:"limit-num",rawName:"v-limit-num"}],attrs:{placeholder:"请输入多少分"},model:{value:t.testPrice,callback:function(a){e.$set(t,"testPrice",a)},expression:"obj.testPrice"}},[a("template",{slot:"append"},[e._v("分")])],2)],1)],1)],1)],1)}),1):e._e()],1),e._v(" "),a("el-row",{staticStyle:{"text-align":"center",margin:"40px 0px 20px"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.publicTest("1")}}},[e._v("发起考试")]),e._v(" "),a("el-button",{on:{click:function(t){return e.publicTest("0")}}},[e._v("保存")])],1)],1)],1)},n=[],s=a("35b7"),l=a("bafa"),r={name:"NoPublish",components:{TitleCard:s["a"]},directives:{required:{inserted:function(e){e.firstElementChild.firstElementChild.addEventListener("blur",function(){var t=e.firstElementChild.firstElementChild.value,a="blobk",i="",n="red";e.nextSibling&&"div"===e.nextSibling.parentNode.lastChild.localName&&e.nextSibling.parentNode.removeChild(e.nextSibling.parentNode.lastChild);var s=document.createElement("div");t.length<1?i="非空":(a="none",n="#dcdfe6"),e.firstElementChild.style.borderColor=n,s.innerText=i,s.style.display=a,s.style.color="red",e.nextSibling&&e.nextSibling.parentNode.appendChild(s)})}},limitNum:{inserted:function(e){e.firstElementChild.addEventListener("blur",function(){var t=e.firstElementChild.value,a="blobk",i="",n="red";e.nextSibling&&"div"===e.nextSibling.parentNode.lastChild.localName&&e.nextSibling.parentNode.removeChild(e.nextSibling.parentNode.lastChild);var s=document.createElement("div");t.length<1?i="非空":/^[1-9]\d*$/.test(t)?(a="none",n="#dcdfe6"):i="只能输入0以外的正整数",e.firstElementChild.style.borderColor=n,s.innerText=i,s.style.display=a,s.style.color="red",e.nextSibling?e.nextSibling.parentNode.appendChild(s):e.parentNode.appendChild(s)})}}},props:{testId:{type:String,default:""}},data:function(){var e=this;return{cardTitle:"创建考核",tableKey:0,list:null,total:0,listLoading:!0,listQuery:{examineName:"",examineDate:"",examineStartDateStr:"",examineEndDateStr:"",examineAllNumber:0,examineSubjectId:"",examineSubjectName:"测试科目",IssueStatus:"0",typeAndNum:"",status:0},typesList:[{type:"1",name:"单选题"},{type:"2",name:"多选题"},{type:"3",name:"判断题"},{type:"4",name:"填空题"},{type:"5",name:"简答题"}],pickOptionStart:{disabledDate:function(t){var a=e.listQuery.examineEndDateStr;if(a)return t.getTime()>new Date(a).getTime()}},pickOptionEnd:{disabledDate:function(t){var a=e.listQuery.examineStartDateStr;if(a)return t.getTime()<new Date(a).getTime()}},subjectListAll:[],typeList:[],rules:{examineName:[{required:!0,message:"请输入考试名称",trigger:"blur"}],examineDate:[{required:!0,message:"请输入考试时长",trigger:"blur"},{validator:this.isNum,trigger:"blur"}],examineStartDateStr:[{required:!0,message:"请输入开始时间",trigger:"blur"}],examineEndDateStr:[{required:!0,message:"请输入结束时间",trigger:"blur"}],examineSubjectId:[{required:!0,message:"请选择考试科目",trigger:"change"}]},updateInfo:[]}},computed:{setTypes:function(){return this.typeList}},watch:{"listQuery.examineSubjectId":{handler:function(e,t){var a=this;this.subjectListAll.map(function(e){e.id===a.listQuery.examineSubjectId&&(a.listQuery.examineSubjectName=e.subjectName,a.findTopicBySubId())})},deep:!0},setTypes:{handler:function(){var e=0,t=0;for(var a in this.setTypes){var i=this.setTypes[a];e+=this.StringToNumber(i.testNum)*this.StringToNumber(i.testPrice),t+=this.StringToNumber(i.testNum)}this.$set(this.setTypes,"totalGradeNum",e),this.$set(this.setTypes,"totalTestNum",t)},deep:!0}},created:function(){this.getSubjectListAll(),this.testId&&this.getInfoById()},methods:{publicTest:function(e){this.listQuery.IssueStatus=e;var t=[],a=0,i=!1,n="";if(0===this.updateInfo.length){for(var s in this.setTypes)if("totalGradeNum"!==s&&"totalTestNum"!==s){var l=this.setTypes[s];l.testNum&&l.testPrice&&l.type1?(a+=parseInt(l.testNum)*parseInt(l.testPrice),t.push(l.type1+"-"+l.testNum+"-"+l.testPrice)):(n="题型设置中每组输入框都必须输入",i=!0)}this.setTypes.totalGradeNum<=0&&(n="请填写题型及分数",i=!0)}this.listQuery.examineEndDateStr||(n="请输入考试结束时间",i=!0),this.listQuery.examineStartDateStr||(n="请输入考试开始时间",i=!0),this.listQuery.examineSubjectId||(n="请选择考试科目",i=!0),this.listQuery.examineDate||(n="请输入考试时长",i=!0),this.listQuery.examineName||(n="请输入考试名称",i=!0),this.listQuery.typeAndNum=t.join(","),this.listQuery.status=0,this.listQuery.examineAllNumber=a,i?this.$message({message:n,type:"info"}):this.saveTestPaper(e)},saveTestPaper:function(e){var t=this,a="发起考试成功！";"0"===e&&(a="保存成功！"),Object(l["f"])(this.listQuery).then(function(e){0===e.data.code?t.$message({type:"success",message:a}):t.$message({type:"info",message:e.data.msg})})},getSubjectListAll:function(){var e=this;Object(l["e"])().then(function(t){e.subjectListAll=t.data.findList,e.subjectListAll.length>1&&(e.listQuery.examineSubjectId=e.subjectListAll[0].id)})},findTopicBySubId:function(){var e=this;Object(l["b"])({subjectId:this.listQuery.examineSubjectId}).then(function(t){var a=t.data.findList.type;e.typeList=[],a.map(function(t){e.typesList.map(function(a){t===a.type&&e.typeList.push(a)})})})},isNum:function(e,t,a){var i=/^[1-9]\d*$/;i.test(t)?a():a(new Error("只能输入除0以外的的正整数"))},selectType:function(e){this.$set(this.typeList[e],"disabled",!0)},cancelSelect:function(e){for(var t in this.typeList)this.setTypes[e].type===this.typeList[t].type&&this.$set(this.typeList[e],"disabled",!1)},StringToNumber:function(e){return e?parseInt(e):0},showNoPublish:function(){this.$emit("showPage","2")},getInfoById:function(){var e=this;Object(l["c"])({id:this.testId}).then(function(t){e.listQuery.examineName=t.data.xlglExamExamine.examineName,e.listQuery.examineDate=t.data.xlglExamExamine.examineDate,e.listQuery.examineStartDateStr=t.data.xlglExamExamine.examineStartDateStr,e.listQuery.examineEndDateStr=t.data.xlglExamExamine.examineEndDateStr,e.listQuery.examineSubjectId=t.data.xlglExamExamine.examineSubjectId;var a=t.data.listCount;for(var i in a){var n={};n.type1=a[i].topicType,n.testNum=a[i].typeCount,n.testPrice=a[i].fractionalNumber,e.updateInfo.push(n)}})}}},u=r,o=(a("4e77"),a("2877")),c=Object(o["a"])(u,i,n,!1,null,"6440d14e",null);t["default"]=c.exports}}]);