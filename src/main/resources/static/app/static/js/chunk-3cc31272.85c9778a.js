(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3cc31272"],{"0fe1":function(t,e,l){"use strict";l.d(e,"o",function(){return i}),l.d(e,"f",function(){return o}),l.d(e,"q",function(){return a}),l.d(e,"r",function(){return r}),l.d(e,"j",function(){return s}),l.d(e,"m",function(){return u}),l.d(e,"n",function(){return c}),l.d(e,"a",function(){return p}),l.d(e,"e",function(){return d}),l.d(e,"p",function(){return f}),l.d(e,"k",function(){return g}),l.d(e,"d",function(){return m}),l.d(e,"b",function(){return x}),l.d(e,"c",function(){return v}),l.d(e,"s",function(){return b}),l.d(e,"h",function(){return h}),l.d(e,"i",function(){return j}),l.d(e,"l",function(){return _}),l.d(e,"g",function(){return z});var n=l("b775");function i(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function o(){return Object(n["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function a(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function r(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:t})}function s(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function d(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function f(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function g(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function m(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function x(t){return Object(n["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:t})}function v(t){return Object(n["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:t})}function b(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"post",params:t})}function h(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function j(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function _(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}function z(t){return Object(n["a"])({url:"/app/xlgl/xlglktap/info",method:"get",params:t})}},8774:function(t,e,l){"use strict";var n=l("ed6e"),i=l.n(n);i.a},c3f7:function(t,e,l){"use strict";l.r(e);var n=function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("div",["no"===t.isHave?l("div",{staticClass:"app-container"},[l("div",{staticClass:"waitDiv"},[l("h6",[t._v("你还未上传文件，请点击按钮上传")]),t._v(" "),l("svg-icon",{staticClass:"icon",staticStyle:{width:"360px",height:"220px","margin-bottom":"15px"},attrs:{"icon-class":"tixing"}}),t._v(" "),l("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,name:"pdf",data:t.fileData,accept:".docx","on-success":t.successFile,"on-error":t.errorFile}},[l("i",{staticClass:"el-icon-upload"}),t._v(" "),l("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),l("em",[t._v("点击上传")])]),t._v(" "),l("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("注：只能上传word文件格式，且不超过500kb")])])],1)]):l("div",[l("el-row",[l("el-col",{attrs:{span:24}},[l("el-button",{staticStyle:{margin:"10px"},attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")]),t._v(" "),l("div",{staticClass:"div1"},[l("iframe",{attrs:{src:"/app/pdf.js/web/viewer.html",frameborder:"0",width:"100%",height:"100%"}})])],1)],1),t._v(" "),l("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[l("div",{staticClass:"centerPosition"},[l("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,name:"pdf",data:t.fileData,accept:".docx","on-success":t.successFile,"on-error":t.errorFile}},[l("i",{staticClass:"el-icon-upload"}),t._v(" "),l("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),l("em",[t._v("点击上传")])]),t._v(" "),l("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("注：只能上传word文件格式，且不超过500kb")])])],1),t._v(" "),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),l("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)])},i=[],o=l("0fe1"),a={data:function(){return{fileUrl:"/app/xlgl/xlglktap/save",fileData:{id:""},onlineFileUrl:"",isHave:"",fileDialog:""}},created:function(){this.getFileList()},methods:{successFile:function(t){console.log(t.result),console.log(t.smjFilePath),console.log(t.smjId),t.result},openDialog:function(){this.fileDialog=!0},errorFile:function(){},getFileList:function(){var t=this;Object(o["g"])().then(function(e){t.isHave=e.data.isHave})},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},submitFile:function(){this.$refs.upload.submit()}}},r=a,s=(l("8774"),l("2877")),u=Object(s["a"])(r,n,i,!1,null,"15287a20",null);e["default"]=u.exports},ed6e:function(t,e,l){}}]);