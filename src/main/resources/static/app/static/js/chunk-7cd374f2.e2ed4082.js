(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7cd374f2"],{6103:function(t,e,i){"use strict";var s=i("cb08"),a=i.n(s);a.a},aa6a:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[i("div",{staticClass:"addTitle"},[i("span",[t._v("通知公告新增")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),i("div",{staticStyle:{padding:"20px 0"}},[i("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"信息类型",required:""}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},t._l(t.infoType,function(e){return i("el-option",{key:e.value,attrs:{label:e.name,value:e.name}},[t._v(t._s(e.name))])}),1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"发布单位",required:""}},[i("el-input",{attrs:{disabled:""},model:{value:t.form.releaseOrgan,callback:function(e){t.$set(t.form,"releaseOrgan",e)},expression:"form.releaseOrgan"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"信息标题",required:""}},[i("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"编辑内容"}},[i("ueditor",{ref:"content",model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"上传附件"}},[i("div",{staticStyle:{border:"1px solid #ccc",padding:"20px","border-radius":"4px"}},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",action:t.fileUrl,data:t.form,"on-success":t.successFile,"on-error":t.errorFile,"on-remove":t.removeFile,multiple:""}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",staticStyle:{color:"#BBBBBB"},attrs:{slot:"tip"},slot:"tip"},[t._v("上传word、excel、ofd等文件格式")])]),t._v(" "),i("div",{staticClass:"fileList"},[i("ul",t._l(t.fileLists,function(e){return i("li",{key:e.fileId},[t._v("\n                        "+t._s(e.pictureName)+"\n                        "),i("span",{staticClass:"colorSty1 gapSty",on:{click:function(i){return i.stopPropagation(),t.deleteFileById(e.pictureId)}}},[t._v("删除")]),t._v(" "),i("span",{staticClass:"colorSty1 gapSty",on:{click:function(i){return i.stopPropagation(),t.download(e.pictureId)}}},[t._v("下载")])])}),0)])],1)])],1)],1)],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[i("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.backFn}},[t._v("取消")])],1)],1)],1)],1)])},a=[],o=i("aa2a"),n=i("13c4"),l=i("63f4"),r={name:"CreateNotice",components:{Ueditor:l["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{infoType:[{name:"通知",value:"1"},{name:"公告",value:"0"}],fileUrl:"/app/xlgl/xlglnotice/uploadPicture",fileList:[],form:{type:"",title:"",content:"",releaseOrgan:"",access_token:this.$store.state.user.token},fileLists:[]}},created:function(){this.noticeId?this.getNoticeInfo():this.getDeptName()},methods:{getDeptName:function(){var t=this;Object(o["d"])().then(function(e){t.form.releaseOrgan=e.data.deptName})},backFn:function(){this.$emit("back","1")},successFile:function(t){t.fileid&&t.fileid.length>0?this.fileList.push(t.fileid):this.$message({type:"info",message:"上传失败!"})},errorFile:function(){this.$message({type:"info",message:"上传失败!"})},removeFile:function(t){var e=this.fileList.indexOf(t.response.fileid);-1!==e&&this.fileList.splice(e,1)},saveOrUpdateNotice:function(){var t=this;this.form.type||this.$message({type:"warning",message:"请选择信息类型!"}),this.form.title||this.$message({type:"warning",message:"请输入信息标题!"}),this.form.content=this.$refs.content.getContent(),this.form.type&&this.form.title&&(this.form.pIds=this.fileList.join(","),Object(n["i"])(this.form).then(function(e){t.$message({type:"success",message:"发布成功!",onClose:function(){t.$parent.showPage="1"}})}))},getNoticeInfo:function(){var t=this,e={id:this.noticeId};Object(n["f"])(e).then(function(e){t.form.id=e.data.xlglNotice.id,t.form.type=e.data.xlglNotice.type,t.form.releaseOrgan=e.data.xlglNotice.releaseOrgan,t.form.title=e.data.xlglNotice.title,t.form.content=e.data.xlglNotice.content,t.$refs.content.setContent(t.form.content),t.$nextTick(function(){this.getFileList()})})},getFileList:function(){var t=this;Object(n["d"])({id:this.noticeId}).then(function(e){t.fileLists=e.data.list})},deleteFileById:function(t){var e=this,i={picId:t};Object(n["b"])(i).then(function(t){0===t.data.code?e.$message({type:"success",message:"删除成功!",onClose:function(){e.getFileList()}}):e.$message({type:"indo",message:"删除失败!"})})},download:function(t){window.location.href="xlgl/xlglnotice/downloadPicture?fileId="+t+"&access_token="+this.$store.state.user.token}}},c=r,f=(i("6103"),i("2877")),d=Object(f["a"])(c,s,a,!1,null,"7d59185e",null);e["default"]=d.exports},cb08:function(t,e,i){}}]);