(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0e63476a"],{4413:function(t,e,a){},"579b":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"app-content"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",{staticStyle:{color:"#333333","font-size":"16px"}},[t._v("新增训练")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练标题",required:""}},[a("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练内容描述"}},[a("el-col",{attrs:{span:24}},[a("ueditor",{model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:4}},[a("el-form-item",{attrs:{label:"上传视频"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4",limit:1,drag:"",action:t.fileUrl,data:t.form,"on-success":t.uploadImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:4}},[a("el-form-item",{attrs:{label:"上传封面"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".png,.jpeg",limit:1,drag:"",action:t.fileUrl,data:t.form,"on-success":t.uploadImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"上传附件"}},[a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:t.fileUrl,name:"pdf","on-success":t.uploadFile,accept:".word,.ofd,.excel,.docx",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)],1)],1)],1)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.cancel}},[t._v("取消")])],1)],1)],1)],1)])},o=[],s=(a("7f7f"),a("63f4")),i={name:"CreateNotice",components:{Ueditor:s["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{fileUrl:"/app/xlgl/xlglnotice/saveOrUpdate",form:{title:"",xltype:"",content:"",releaseTimeStr:"",releaseOrgan:"",access_token:this.$store.state.user.token},showImg:!1,fileList:[],radio:""}},created:function(){},methods:{backFn:function(){this.$emit("back",0)},uploadImg:function(t,e){},uploadFile:function(t,e){this.fileList.push({name:e.raw.name,type:e.raw.type,id:t.fileId})},saveOrUpdateNotice:function(){this.form.title||this.$message({message:"请填写训练标题",type:"info"})},cancel:function(){}}},c=i,n=(a("c602"),a("2877")),r=Object(n["a"])(c,l,o,!1,null,"c274cfdc",null);e["default"]=r.exports},c602:function(t,e,a){"use strict";var l=a("4413"),o=a.n(l);o.a}}]);