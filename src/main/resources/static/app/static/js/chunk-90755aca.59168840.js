(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-90755aca"],{"13c4":function(t,e,a){"use strict";a.d(e,"f",function(){return r}),a.d(e,"e",function(){return l}),a.d(e,"a",function(){return o}),a.d(e,"h",function(){return i}),a.d(e,"b",function(){return s}),a.d(e,"g",function(){return c}),a.d(e,"d",function(){return u}),a.d(e,"c",function(){return p});var n=a("b775");function r(t){return Object(n["a"])({url:"/app/xlgl/xlglnotice/list",method:"get",params:t})}function l(t){return Object(n["a"])({url:"/app/xlgl/xlglnotice/info",method:"post",data:t})}function o(t){return Object(n["a"])({url:"/app/xlgl/xlglnotice/delete",method:"post",data:t})}function i(t){return Object(n["a"])({url:"/app/xlgl/xlglnotice/top",method:"post",data:t})}function s(t){return Object(n["a"])({url:"/app/xlgl/xlglnoticeread/list",method:"post",data:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/xlglnoticeread/save",method:"post",data:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/xlglnotice/infoUpAndDown",method:"post",data:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/xlglnotice/pictureList",method:"post",data:t})}},"28e5":function(t,e,a){},"64ed":function(t,e,a){"use strict";var n=a("28e5"),r=a.n(n);r.a},aa2a:function(t,e,a){"use strict";a.d(e,"e",function(){return r}),a.d(e,"b",function(){return l}),a.d(e,"h",function(){return o}),a.d(e,"i",function(){return i}),a.d(e,"a",function(){return s}),a.d(e,"d",function(){return c}),a.d(e,"g",function(){return u}),a.d(e,"f",function(){return p}),a.d(e,"c",function(){return d});var n=a("b775");function r(t){return Object(n["a"])({url:"/app/xlgl/news/queryTotal",method:"get",params:t})}function l(t){return Object(n["a"])({url:"/app/xlgl/news/delete",method:"get",params:t})}function o(t){return Object(n["a"])({url:"/app/xlgl/news/top",method:"get",params:t})}function i(t){return Object(n["a"])({url:"/app/xlgl/news/topCancle",method:"get",params:t})}function s(t){return Object(n["a"])({url:"/app/xlgl/news/list",method:"get",params:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/news/addHits",method:"get",params:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/news/saveOrUpdate",method:"post",data:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/news/queryDrafts",method:"get",params:t})}function d(){return Object(n["a"])({url:"/app/xlgl/news/getDeptName",method:"get"})}},aa6a:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",[t._v("通知公告新增")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"信息类型",required:""}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},t._l(t.infoType,function(e){return a("el-option",{key:e.value,attrs:{label:e.name,value:e.name}},[t._v(t._s(e.name))])}),1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"发布单位",required:""}},[a("el-input",{attrs:{disabled:""},model:{value:t.form.releaseOrgan,callback:function(e){t.$set(t.form,"releaseOrgan",e)},expression:"form.releaseOrgan"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"信息标题",required:""}},[a("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"发布时间",required:""}},[a("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},model:{value:t.form.releaseTimeStr,callback:function(e){t.$set(t.form,"releaseTimeStr",e)},expression:"form.releaseTimeStr"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"编辑内容"}},[a("ueditor",{model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"上传附件"}},[a("div",{staticStyle:{border:"1px solid #ccc",padding:"20px","border-radius":"4px"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",action:t.fileUrl,data:t.form,"on-success":t.successFile,"on-error":t.errorFile,"auto-upload":!1,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),a("em",[t._v("点击上传")])]),t._v(" "),a("div",{staticClass:"el-upload__tip",staticStyle:{color:"#BBBBBB"},attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传word/ppt/excel文件格式，且不超过500kb")])])],1)])],1)],1)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.backFn}},[t._v("取消")])],1)],1)],1)],1)])},r=[],l=a("aa2a"),o=a("13c4"),i=a("63f4"),s={name:"CreateNotice",components:{Ueditor:i["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{infoType:[{name:"通知",value:"1"},{name:"公告",value:"0"}],fileUrl:"/app/xlgl/xlglnotice/saveOrUpdate",form:{type:"",title:"",content:"",releaseTimeStr:"",releaseOrgan:"",access_token:this.$store.state.user.token}}},created:function(){this.noticeId?this.getNoticeInfo():this.getDeptName()},methods:{getDeptName:function(){var t=this;Object(l["c"])().then(function(e){t.form.releaseOrgan=e.data.deptName})},backFn:function(){this.$emit("back","1")},successFile:function(t){var e=this;this.$message({type:"success",message:"发布成功!",onClose:function(){e.$parent.showPage="1"}})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},saveOrUpdateNotice:function(){this.$refs.upload.submit()},getNoticeInfo:function(){var t=this,e={id:this.noticeId};Object(o["e"])(e).then(function(e){t.form.type=e.data.xlglNotice.type,t.form.releaseOrgan=e.data.xlglNotice.releaseOrgan,t.form.title=e.data.xlglNotice.title,t.form.content=e.data.xlglNotice.content,t.form.releaseTime=e.data.xlglNotice.releaseTime})}}},c=s,u=(a("64ed"),a("2877")),p=Object(u["a"])(c,n,r,!1,null,"316edd39",null);e["default"]=p.exports}}]);