(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2913a060"],{"0471":function(e,t,l){"use strict";var a=l("0a98"),i=l.n(a);i.a},"0a98":function(e,t,l){},"0fe1":function(e,t,l){"use strict";l.d(t,"o",function(){return i}),l.d(t,"f",function(){return n}),l.d(t,"q",function(){return o}),l.d(t,"r",function(){return s}),l.d(t,"j",function(){return r}),l.d(t,"m",function(){return c}),l.d(t,"n",function(){return p}),l.d(t,"a",function(){return u}),l.d(t,"e",function(){return d}),l.d(t,"p",function(){return f}),l.d(t,"k",function(){return m}),l.d(t,"d",function(){return g}),l.d(t,"b",function(){return h}),l.d(t,"c",function(){return x}),l.d(t,"s",function(){return b}),l.d(t,"h",function(){return v}),l.d(t,"i",function(){return y}),l.d(t,"l",function(){return _}),l.d(t,"g",function(){return j});var a=l("b775");function i(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:e})}function n(){return Object(a["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function o(e){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:e})}function s(e){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:e})}function r(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:e})}function c(e){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:e})}function p(e){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:e})}function u(e){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:e})}function d(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:e})}function f(e){return Object(a["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:e})}function m(e){return Object(a["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:e})}function g(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:e})}function h(e){return Object(a["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:e})}function x(e){return Object(a["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:e})}function b(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"post",params:e})}function v(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:e})}function y(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:e})}function _(e){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:e})}function j(e){return Object(a["a"])({url:"/app/xlgl/xlglktap/info",method:"get",params:e})}},dad1:function(e,t,l){"use strict";l.r(t);var a=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("div",{staticClass:"app-content"},[l("title-card",{attrs:{"title-text":"新增训练"}}),e._v(" "),l("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:e.back}}),e._v(" "),l("div",{staticStyle:{padding:"20px"}},[l("el-col",{attrs:{span:16}},[l("el-form",{ref:"form",attrs:{model:e.form,"label-width":"150px"}},[l("el-col",{attrs:{span:10}},[l("el-form-item",{attrs:{label:"讲堂标题",required:""}},[l("el-input",{model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1)],1),e._v(" "),l("el-col",{attrs:{span:10}},[l("el-form-item",{attrs:{label:"训练类型",required:""}},[l("el-select",{attrs:{placeholder:"请选择"},on:{change:e.changeType},model:{value:e.form.xltype,callback:function(t){e.$set(e.form,"xltype",t)},expression:"form.xltype"}},[l("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),e._v(" "),l("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1)],1)],1),e._v(" "),l("el-col",{attrs:{span:10}},[l("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"训练时间",required:""}},[l("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},on:{change:e.getsTime},model:{value:e.form.exerciseTime,callback:function(t){e.$set(e.form,"exerciseTime",t)},expression:"form.exerciseTime"}})],1)],1),e._v(" "),l("el-col",{directives:[{name:"show",rawName:"v-show",value:e.showUrl,expression:"showUrl"}],attrs:{span:10}},[l("el-form-item",{attrs:{label:"会议链接",required:""}},[l("el-input",{model:{value:e.form.meetingLine,callback:function(t){e.$set(e.form,"meetingLine",t)},expression:"form.meetingLine"}})],1)],1),e._v(" "),l("el-col",{attrs:{span:20}},[l("el-form-item",{attrs:{label:"训练科目"}},[l("el-input",{attrs:{type:"textarea"},model:{value:e.form.exerciseIssue,callback:function(t){e.$set(e.form,"exerciseIssue",t)},expression:"form.exerciseIssue"}})],1)],1),e._v(" "),l("el-col",{attrs:{span:20}},[l("el-form-item",{attrs:{label:"参训人员"}},[l("el-input",{attrs:{type:"textarea"},model:{value:e.form.joinPeople,callback:function(t){e.$set(e.form,"joinPeople",t)},expression:"form.joinPeople"}})],1)],1),e._v(" "),l("el-col",{attrs:{span:20}},[l("el-form-item",{attrs:{label:"其他事项"}},[l("ueditor",{model:{value:e.form.bz,callback:function(t){e.$set(e.form,"bz",t)},expression:"form.bz"}})],1)],1)],1)],1),e._v(" "),l("el-col",{attrs:{span:4}},[l("div",[l("label",{staticStyle:{"font-size":"18px"}},[e._v("上传视频")]),e._v(" "),l("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":e.uploadVideo,accept:".mp4",multiple:""}},[l("i",{staticClass:"el-icon-upload"}),e._v(" "),l("div",{staticClass:"el-upload__text"},[e._v("\n              将视频文件拖到此处，或"),l("em",[e._v("点击上传")]),e._v(" "),l("p",{staticStyle:{"font-size":"12px"}},[e._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),e._v(" "),l("div",{staticStyle:{"margin-top":"20px"}},[l("label",{staticStyle:{"font-size":"18px"}},[e._v("上传封面")]),e._v(" "),l("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":e.uploadImg,limit:1,accept:".png,.jpeg",multiple:""}},[l("i",{staticClass:"el-icon-upload"}),e._v(" "),l("div",{staticClass:"el-upload__text"},[e._v("\n              将图片文件拖到此处，或"),l("em",[e._v("点击上传")]),e._v(" "),l("p",{staticStyle:{"font-size":"12px"}},[e._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),e._v(" "),l("div",{staticStyle:{"margin-top":"20px"}},[l("label",{staticStyle:{"font-size":"18px"}},[e._v("上传附件")]),e._v(" "),l("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":e.uploadFile,accept:".word,.excel,.ofd",multiple:""}},[l("i",{staticClass:"el-icon-upload"}),e._v(" "),l("div",{staticClass:"el-upload__text"},[e._v("\n              将文件拖到此处，或"),l("em",[e._v("点击上传")]),e._v(" "),l("p",{staticStyle:{"font-size":"12px"}},[e._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)])],1),e._v(" "),l("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[l("el-button",{attrs:{type:"primary"},on:{click:e.saveFn}},[e._v("确认并分发")]),e._v(" "),l("el-button",{staticStyle:{"margin-left":"10px"},on:{click:e.cancel}},[e._v("取消")])],1),e._v(" "),l("el-dialog",{attrs:{title:"请选择下发局级单位",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t},close:function(t){e.dialogFormVisible=!1}}},[l("el-tree",{ref:"dataTree",attrs:{"show-checkbox":"",data:e.treeData,"node-key":"id",props:e.defaultProps}}),e._v(" "),l("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:e.confirm}},[e._v("确定")]),e._v(" "),l("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1)])},i=[],n=(l("7f7f"),l("0fe1")),o=l("35b7"),s=l("63f4"),r={components:{TitleCard:o["a"],Ueditor:s["a"]},props:{listType:{type:String,default:"0"},file_id:{type:String,default:""}},data:function(){return{form:{title:"",xltype:"",exerciseTime:"",meetingLine:"",exerciseIssue:"",joinPeople:"",bz:"",picturePath:""},deptData:{fileId:"",idAndNames:"",deptIds:"",deptNames:""},dialogFormVisible:!1,defaultProps:{children:"children",label:"text"},treeData:[],nodeId:[],nodeName:[],fileId:[],fileName:[],fileType:[],showUrl:!1}},created:function(){this.file_id&&this.getTrainInfo()},methods:{getsTime:function(e){this.form.createDate=e},getTrainInfo:function(){var e=this;Object(n["j"])({id:this.file_id}).then(function(t){var l=t.data.xlglXlzzInfo,a=l.title,i=l.xltype,n=l.exerciseTime,o=l.exerciseIssue,s=l.joinPeople,r=l.bz;Object.assign(e.form,{title:a,xltype:i,exerciseTime:n,exerciseIssue:o,joinPeople:s,bz:r})})},changeType:function(e){this.showUrl="0"===e},saveFn:function(){var e=this;this.form.title?this.form.xltype?this.form.exerciseTime?"0"!==this.form.xltype||this.form.meetingLine?(this.form.pIds=this.fileId.join(","),this.form.pidNames=this.fileName.join(","),this.form.type=this.fileType.join(","),Object(n["o"])(this.form).then(function(t){"success"===t.data.result?(e.$message({message:"新增成功",type:"success"}),e.fileId=t.data.fileId,e.dialogFormVisible=!0,Object(n["f"])().then(function(t){e.treeData=t.data.children})):e.$message({message:"新增失败",type:"info"})})):this.$message({message:"请填写会议链接",type:"info"}):this.$message({message:"请选择训练时间",type:"info"}):this.$message({message:"请选择训练类型",type:"info"}):this.$message({message:"请填写讲堂标题",type:"info"})},cancel:function(){var e=this;this.$confirm("确定要取消发送此通知吗，您填写的内容将被清空","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){e.form={}}).catch(function(){})},uploadVideo:function(e,t){this.fileId.push(e.fileId),this.fileName.push(t.raw.name),this.fileType.push(t.raw.type)},uploadImg:function(e,t){this.fileId.push(e.fileId),this.fileName.push(t.raw.name),this.fileType.push(t.raw.type),this.form.picturePath="/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.fileId},uploadFile:function(e,t){this.fileId.push(e.fileId),this.fileName.push(t.raw.name),this.fileType.push(t.raw.type?t.raw.type:"docx")},confirm:function(){var e=this;this.deptData.idAndNames="";for(var t=this.$refs.dataTree.getCheckedNodes(),l=0;l<t.length;l++)this.nodeId.push(t[l].id),this.nodeName.push(t[l].text),this.deptData.idAndNames+="".concat(t[l].id,",")+"".concat(t[l].text,";");this.deptData.fileId=this.fileId,this.deptData.deptIds=this.nodeId.join(","),this.deptData.deptNames=this.nodeName.join(","),Object(n["q"])(this.deptData).then(function(t){"success"===t.data.result?(e.$message({message:"分发成功",type:"success"}),e.dialogFormVisible=!1,e.back()):(e.$message({message:"分发失败",type:"info"}),e.dialogFormVisible=!1)})},deleteFn:function(e){},back:function(){this.$emit("back",0,this.listType)}}},c=r,p=(l("0471"),l("2877")),u=Object(p["a"])(c,a,i,!1,null,"698cf823",null);t["default"]=u.exports}}]);