(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-00f60109"],{aa2a:function(t,e,a){"use strict";a.d(e,"e",function(){return l}),a.d(e,"b",function(){return n}),a.d(e,"h",function(){return i}),a.d(e,"i",function(){return o}),a.d(e,"a",function(){return r}),a.d(e,"d",function(){return c}),a.d(e,"g",function(){return p}),a.d(e,"f",function(){return u}),a.d(e,"c",function(){return m});var s=a("b775");function l(t){return Object(s["a"])({url:"/app/xlgl/news/queryTotal",method:"get",params:t})}function n(t){return Object(s["a"])({url:"/app/xlgl/news/delete",method:"get",params:t})}function i(t){return Object(s["a"])({url:"/app/xlgl/news/top",method:"get",params:t})}function o(t){return Object(s["a"])({url:"/app/xlgl/news/topCancle",method:"get",params:t})}function r(t){return Object(s["a"])({url:"/app/xlgl/news/list",method:"get",params:t})}function c(t){return Object(s["a"])({url:"/app/xlgl/news/addHits",method:"get",params:t})}function p(t){return Object(s["a"])({url:"/app/xlgl/news/saveOrUpdate",method:"post",data:t})}function u(t){return Object(s["a"])({url:"/app/xlgl/news/queryDrafts",method:"get",params:t})}function m(){return Object(s["a"])({url:"/app/xlgl/news/getDeptName",method:"get"})}},af91:function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"addPage"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",[t._v("训管动态新增")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{model:t.form,"label-width":"150px"}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"动态类型",prop:"newsType"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.newsType,callback:function(e){t.$set(t.form,"newsType",e)},expression:"form.newsType"}},[a("el-option",{attrs:{label:"上级工作动态",value:"上级工作动态"}}),t._v(" "),a("el-option",{attrs:{label:"机关部队训练风采",value:"机关部队训练风采"}}),t._v(" "),a("el-option",{attrs:{label:"安全管理",value:"安全管理"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"发布单位",required:""}},[a("el-input",{attrs:{disabled:""},model:{value:t.form.deptName,callback:function(e){t.$set(t.form,"deptName",e)},expression:"form.deptName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"动态标题"}},[a("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"发布时间"}},[a("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},on:{change:t.getsTime},model:{value:t.form.createDate,callback:function(e){t.$set(t.form,"createDate",e)},expression:"form.createDate"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"编辑内容"}},[a("ueditor",{model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"上传封面"}},[a("div",{staticStyle:{border:"1px solid #ccc",padding:"20px","border-radius":"4px",position:"relative"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4,.png,.jpeg",drag:"","show-file-list":t.showImg,action:t.fileUrl,data:t.form,limit:1,"on-success":t.uploadImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                    将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])]),t._v(" "),a("ul",{staticClass:"el-upload-list el-upload-list--text",staticStyle:{position:"absolute",top:"10%",left:"35%"}},t._l(t.imgList,function(e,s){return a("li",{key:s,staticClass:"el-upload-list__item is-success el-list-enter-to",attrs:{tabindex:"0"}},[a("a",{staticClass:"el-upload-list__item-name"},[a("i",{staticClass:"el-icon-document"}),t._v(t._s(e.name)+"\n                    ")]),t._v(" "),a("label",{staticClass:"el-upload-list__item-status-label"},[a("i",{staticClass:"el-icon-upload-success el-icon-circle-check"})]),t._v(" "),a("i",{staticClass:"el-icon-close"})])}),0)],1)])],1)],1)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:t.saveFn}},[t._v("发布")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.saveDraft}},[t._v("存草稿")])],1)],1)],1)],1)},l=[],n=(a("7f7f"),a("c5f6"),a("aa2a")),i=a("63f4"),o={components:{Ueditor:i["a"]},data:function(){return{form:{title:"",newsType:"",createDate:"",picturePath:"",content:"",deptName:""},showImg:!1,imgList:[],fileUrl:"/app/xlgl/xlglnotice/saveOrUpdate"}},props:{flag:{type:Number,default:0},id:{type:String,default:""}},created:function(){this.getDeptName(),1===this.flag&&this.getDetails()},methods:{getDeptName:function(){var t=this;Object(n["c"])().then(function(e){t.form.deptName=e.data.deptName})},getDetails:function(){var t=this;Object(n["d"])({id:this.id}).then(function(e){t.form.title=e.data.xlglNews.title,t.form.newsType=e.data.xlglNews.newsType,t.form.content=e.data.xlglNews.content,t.form.createDate=e.data.xlglNews.releaseDate})},backFn:function(){this.$emit("back")},uploadImg:function(t,e){this.form.picturePath="/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.fileId,this.imgList.push({name:e.raw.name,type:e.raw.type,id:t.fileId})},getsTime:function(t){this.form.createDate=t},saveData:function(t){var e=this,a=!1,s="";this.form.newsType||(s="请选择动态类型",a=!0),a?this.$message({message:s,type:"info"}):(this.form.isRelease=t,this.form.id=this.id,Object(n["g"])(this.form).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"发布成功!"}),e.form="",e.$emit("back")):(e.$message({type:"info",message:"发布失败!"}),e.form="",e.$emit("back"))}))},saveFn:function(){this.saveData(1)},saveDraft:function(){this.saveData(0)}}},r=o,c=(a("fc15"),a("2877")),p=Object(c["a"])(r,s,l,!1,null,"7988bf39",null);e["default"]=p.exports},d8a3:function(t,e,a){},fc15:function(t,e,a){"use strict";var s=a("d8a3"),l=a.n(s);l.a}}]);