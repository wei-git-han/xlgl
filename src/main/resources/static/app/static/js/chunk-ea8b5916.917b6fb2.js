(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ea8b5916","chunk-2f4bc9fe","chunk-5f8f94b2"],{"000b":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[0==t.isShow?a("div",{staticClass:"app-content",staticStyle:{"margin-top":"10px",height:"90%"}},[a("title-card",{attrs:{"title-text":"战略训练"}}),t._v(" "),a("div",{staticStyle:{position:"absolute",right:"20px",top:"9px"}},[a("el-button",{staticClass:"addBtn noBorder",attrs:{type:"success",size:"small",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("新增")])],1),t._v(" "),a("div",{staticStyle:{"margin-top":"15px"}},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),a("div",{staticClass:"videoList"},t._l(t.videoList,function(e,n){return a("div",{key:n,class:["videoCard",0!=n?"ma-l_20":""],on:{click:t.toDetial}},[a("span",{class:["learnLabel","1"==e.isLearn?"bg_active":"bg_default"]},[t._v(t._s("1"==e.isLearn?"已学习":"待学习"))]),t._v(" "),a("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[a("img",{staticClass:"imgStyle",attrs:{src:e.imgSrc}}),t._v(" "),a("span",{staticClass:"status_start"},[t._v(t._s(e.videoTime))])]),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"margin-top":"10px",padding:"0 15px"}},[a("span",{staticStyle:{"font-size":"16px"}},[t._v(t._s(e.title.length>14?e.title.substr(0,14)+"...":e.title))]),t._v(" "),a("span",{staticStyle:{"font-size":"13px",color:"#3377FF"}},[t._v("[详情]")])]),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"padding-left":"15px"}},[a("p",[a("img"),t._v(" "),a("span",{staticStyle:{color:"#99A6BF"}},[t._v(t._s(e.readNum)+"次浏览")])])])])}),0),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)}}})],1):t._e(),t._v(" "),1==t.isShow?a("addPage",{on:{back:t.backList}}):t._e(),t._v(" "),2==t.isShow?a("detailPage",{attrs:{listType:t.tabIndex},on:{back:t.backList}}):t._e()],1)},i=[],l=a("35b7"),o=a("333d"),s=a("f069"),r=a("dac6"),c=a("0fe1"),u={components:{TitleCard:l["a"],Pagination:o["a"],addPage:s["default"],detailPage:r["default"]},data:function(){return{listQuery:{page:1,pagesize:10,search:""},total:2,states:[1,2,3],topicType:[1,2,3],videoList:[],isShow:0}},created:function(){this.getList()},methods:{getList:function(){var t=this;Object(c["m"])(this.listQuery).then(function(e){t.videoList=e.data.rows,t.total=e.data.total})},search:function(){},backList:function(){this.isShow=0},addPage:function(){this.isShow=1},toDetial:function(){this.isShow=2}}},p=u,d=(a("874d"),a("2877")),f=Object(d["a"])(p,n,i,!1,null,"26a45f18",null);e["default"]=f.exports},"09f4":function(t,e,a){"use strict";a.d(e,"a",function(){return o}),Math.easeInOutQuad=function(t,e,a,n){return t/=n/2,t<1?a/2*t*t+e:(t--,-a/2*(t*(t-2)-1)+e)};var n=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function i(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function l(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function o(t,e,a){var o=l(),s=t-o,r=20,c=0;e="undefined"===typeof e?500:e;var u=function t(){c+=r;var l=Math.easeInOutQuad(c,o,s,e);i(l),c<e?n(t):a&&"function"===typeof a&&a()};u()}},"0fe1":function(t,e,a){"use strict";a.d(e,"o",function(){return i}),a.d(e,"g",function(){return l}),a.d(e,"q",function(){return o}),a.d(e,"r",function(){return s}),a.d(e,"j",function(){return r}),a.d(e,"m",function(){return c}),a.d(e,"n",function(){return u}),a.d(e,"a",function(){return p}),a.d(e,"e",function(){return d}),a.d(e,"f",function(){return f}),a.d(e,"p",function(){return m}),a.d(e,"k",function(){return v}),a.d(e,"d",function(){return g}),a.d(e,"b",function(){return x}),a.d(e,"c",function(){return _}),a.d(e,"s",function(){return b}),a.d(e,"h",function(){return h}),a.d(e,"i",function(){return y}),a.d(e,"l",function(){return w});var n=a("b775");function i(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function l(){return Object(n["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function o(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function s(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:t})}function r(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function d(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForDept",method:"post",params:t})}function f(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function m(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function v(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function g(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function x(t){return Object(n["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:t})}function _(t){return Object(n["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:t})}function b(){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"get"})}function h(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function y(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function w(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}},"874d":function(t,e,a){"use strict";var n=a("f3fa"),i=a.n(n);i.a},"99d1":function(t,e,a){},"9c20":function(t,e,a){"use strict";var n=a("99d1"),i=a.n(n);i.a},a704:function(t,e,a){},d275:function(t,e,a){"use strict";var n=a("a704"),i=a.n(n);i.a},dac6:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"30px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("div",{staticClass:"header"},[a("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("span",[t._v("发布时间：")]),t._v(" "),a("span",[t._v("2020-08-17 10:00:00")])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("发布单位：")]),t._v(" "),a("span",[t._v("办公厅训练管理处")])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("浏览次数：")]),t._v(" "),a("span",[t._v("1256")])]),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:t.isManager,expression:"isManager"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[a("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),a("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),a("div",{staticStyle:{padding:"20px 40px"}},[a("el-col",{attrs:{span:18}},[a("div",[a("span",[t._v("训练内容描述 ：")]),t._v(" "),a("span",[t._v("根据年度“强装兴装大讲堂”安排，定于 7 月 23 日举办“强装兴装大讲堂”第 5 讲(总第 25 讲)。邀请国防大学原战役教研部马平主任围绕“抗美援朝战争战例研究”进行授课。")])]),t._v(" "),a("video",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId=ed892382ffaa4647baa6adba2cf81c0e",controls:"controls"}})]),t._v(" "),a("el-col",{attrs:{span:6}},[a("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId=cb915903c19b453caad500e09a680350"}}),t._v(" "),a("div",{staticStyle:{width:"70%",height:"160px",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),a("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","justify-content":"space-between","align-items":"center"}},[a("div",[a("img"),t._v(" "),a("span",{staticStyle:{"font-size":"12px"}},[t._v("关于改革开放记录《我们一起走....pdf")])])])])])],1)])],1)])},i=[],l={data:function(){return{title:"“强装兴装大讲堂”第 5 讲(总第 25 讲)",isManager:!0}},created:function(){},methods:{back:function(){this.$emit("back",0)},editor:function(){this.$emit("back",1)},deleteFn:function(){}}},o=l,s=(a("d275"),a("2877")),r=Object(s["a"])(o,n,i,!1,null,"48da0498",null);e["default"]=r.exports},f069:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"app-content"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",{staticStyle:{color:"#333333","font-size":"16px"}},[t._v("新增训练")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练标题",required:""}},[a("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练内容描述"}},[a("el-col",{attrs:{span:24}},[a("ueditor",{model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:4}},[a("el-form-item",{attrs:{label:"上传视频"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4",limit:1,drag:"",action:t.fileUrl,data:t.form,"on-success":t.uploadImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:4}},[a("el-form-item",{attrs:{label:"上传封面"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".png,.jpeg",limit:1,drag:"",action:t.fileUrl,data:t.form,"on-success":t.uploadImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"上传附件"}},[a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:t.fileUrl,name:"pdf","on-success":t.uploadFile,accept:".word,.ofd,.excel,.docx",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)],1)],1)],1)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.cancel}},[t._v("取消")])],1)],1)],1)],1)])},i=[],l=(a("7f7f"),a("63f4")),o={name:"CreateNotice",components:{Ueditor:l["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{fileUrl:"/app/xlgl/xlglnotice/saveOrUpdate",form:{type:"",title:"",content:"",releaseTimeStr:"",releaseOrgan:"",access_token:this.$store.state.user.token},showImg:!1,fileList:[],radio:""}},created:function(){},methods:{backFn:function(){this.$emit("back")},uploadImg:function(t,e){},uploadFile:function(t,e){this.fileList.push({name:e.raw.name,type:e.raw.type,id:t.fileId})},saveOrUpdateNotice:function(){this.form.title||this.$message({message:"请填写训练标题",type:"info"})},cancel:function(){}}},s=o,r=(a("9c20"),a("2877")),c=Object(r["a"])(s,n,i,!1,null,"7e078342",null);e["default"]=c.exports},f3fa:function(t,e,a){}}]);