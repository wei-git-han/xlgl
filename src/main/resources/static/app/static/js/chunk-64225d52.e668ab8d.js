(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-64225d52"],{"605f":function(e,t,a){},7130:function(e,t,a){"use strict";var l=a("605f"),s=a.n(l);s.a},aa6a:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",[e._v("通知公告新增")]),e._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:e.backFn}})],1),e._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:e.form,callback:function(t){e.form=t},expression:"form"}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"信息类型",required:""}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.form.type,callback:function(t){e.$set(e.form,"type",t)},expression:"form.type"}},e._l(e.infoType,function(t){return a("el-option",{key:t.value,attrs:{label:t.name,value:t.name}},[e._v(e._s(t.name))])}),1)],1)],1),e._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"发布单位",required:""}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.releaseOrgan,callback:function(t){e.$set(e.form,"releaseOrgan",t)},expression:"form.releaseOrgan"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"信息标题",required:""}},[a("el-input",{model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"发布时间",required:""}},[a("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},model:{value:e.form.releaseTimeStr,callback:function(t){e.$set(e.form,"releaseTimeStr",t)},expression:"form.releaseTimeStr"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"编辑内容"}},[a("ueditor",{model:{value:e.form.content,callback:function(t){e.$set(e.form,"content",t)},expression:"form.content"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"上传附件"}},[a("div",{staticStyle:{border:"1px solid #ccc",padding:"20px","border-radius":"4px"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",action:e.fileUrl,data:e.form,"on-success":e.successFile,"on-error":e.errorFile,"auto-upload":!1,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),e._v(" "),a("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),a("em",[e._v("点击上传")])]),e._v(" "),a("div",{staticClass:"el-upload__tip",staticStyle:{color:"#BBBBBB"},attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传word、excel、ofd文件格式，且不超过500kb")])])],1)])],1)],1)],1),e._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:e.saveOrUpdateNotice}},[e._v("发布")]),e._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:e.backFn}},[e._v("取消")])],1)],1)],1)],1)])},s=[],o=a("aa2a"),r=a("13c4"),i=a("63f4"),n={name:"CreateNotice",components:{Ueditor:i["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{infoType:[{name:"通知",value:"1"},{name:"公告",value:"0"}],fileUrl:"/app/xlgl/xlglnotice/saveOrUpdate",form:{type:"",title:"",content:"",releaseTimeStr:"",releaseOrgan:"",access_token:this.$store.state.user.token}}},created:function(){this.noticeId?this.getNoticeInfo():this.getDeptName()},methods:{getDeptName:function(){var e=this;Object(o["c"])().then(function(t){e.form.releaseOrgan=t.data.deptName})},backFn:function(){this.$emit("back","1")},successFile:function(e){var t=this;this.$message({type:"success",message:"发布成功!",onClose:function(){t.$parent.showPage="1"}})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},saveOrUpdateNotice:function(){this.$refs.upload.submit()},getNoticeInfo:function(){var e=this,t={id:this.noticeId};Object(r["e"])(t).then(function(t){e.form.type=t.data.xlglNotice.type,e.form.releaseOrgan=t.data.xlglNotice.releaseOrgan,e.form.title=t.data.xlglNotice.title,e.form.content=t.data.xlglNotice.content,e.form.releaseTime=t.data.xlglNotice.releaseTime})}}},c=n,m=(a("7130"),a("2877")),p=Object(m["a"])(c,l,s,!1,null,"bc0a2064",null);t["default"]=p.exports}}]);