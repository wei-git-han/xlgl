(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0ca4ce0d","chunk-5aa1765e","chunk-20867e66"],{"09f4":function(t,e,n){"use strict";n.d(e,"a",function(){return o}),Math.easeInOutQuad=function(t,e,n,a){return t/=a/2,t<1?n/2*t*t+e:(t--,-n/2*(t*(t-2)-1)+e)};var a=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function r(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function l(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function o(t,e,n){var o=l(),i=t-o,s=20,c=0;e="undefined"===typeof e?500:e;var u=function t(){c+=s;var l=Math.easeInOutQuad(c,o,i,e);r(l),c<e?a(t):n&&"function"===typeof n&&n()};u()}},"0fe1":function(t,e,n){"use strict";n.d(e,"bb",function(){return r}),n.d(e,"l",function(){return l}),n.d(e,"db",function(){return o}),n.d(e,"eb",function(){return i}),n.d(e,"D",function(){return s}),n.d(e,"N",function(){return c}),n.d(e,"O",function(){return u}),n.d(e,"a",function(){return p}),n.d(e,"k",function(){return d}),n.d(e,"cb",function(){return f}),n.d(e,"E",function(){return m}),n.d(e,"j",function(){return g}),n.d(e,"c",function(){return x}),n.d(e,"f",function(){return b}),n.d(e,"lb",function(){return v}),n.d(e,"n",function(){return h}),n.d(e,"p",function(){return _}),n.d(e,"I",function(){return w}),n.d(e,"d",function(){return y}),n.d(e,"m",function(){return j}),n.d(e,"r",function(){return O}),n.d(e,"q",function(){return S}),n.d(e,"s",function(){return C}),n.d(e,"Y",function(){return k}),n.d(e,"x",function(){return z}),n.d(e,"w",function(){return F}),n.d(e,"y",function(){return B}),n.d(e,"gb",function(){return L}),n.d(e,"X",function(){return T}),n.d(e,"z",function(){return I}),n.d(e,"W",function(){return N}),n.d(e,"V",function(){return $}),n.d(e,"U",function(){return D}),n.d(e,"F",function(){return M}),n.d(e,"h",function(){return P}),n.d(e,"g",function(){return A}),n.d(e,"i",function(){return Q}),n.d(e,"b",function(){return U}),n.d(e,"K",function(){return q}),n.d(e,"J",function(){return E}),n.d(e,"L",function(){return W}),n.d(e,"nb",function(){return J}),n.d(e,"u",function(){return R}),n.d(e,"t",function(){return V}),n.d(e,"v",function(){return X}),n.d(e,"fb",function(){return H}),n.d(e,"B",function(){return Z}),n.d(e,"A",function(){return G}),n.d(e,"C",function(){return K}),n.d(e,"kb",function(){return Y}),n.d(e,"jb",function(){return tt}),n.d(e,"T",function(){return et}),n.d(e,"S",function(){return nt}),n.d(e,"hb",function(){return at}),n.d(e,"ib",function(){return rt}),n.d(e,"mb",function(){return lt}),n.d(e,"G",function(){return ot}),n.d(e,"H",function(){return it}),n.d(e,"o",function(){return st}),n.d(e,"ab",function(){return ct}),n.d(e,"Z",function(){return ut}),n.d(e,"P",function(){return pt}),n.d(e,"R",function(){return dt}),n.d(e,"Q",function(){return ft}),n.d(e,"e",function(){return mt}),n.d(e,"M",function(){return gt});var a=n("b775");function r(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function l(){return Object(a["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function o(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function i(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:t})}function s(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function f(t){return Object(a["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function m(t){return Object(a["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function g(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function x(t){return Object(a["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:t})}function b(t){return Object(a["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:t})}function v(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"post",params:t})}function h(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function _(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function w(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}function y(t){return Object(a["a"])({url:"/app/xlgl/xlglktap/downLoad",method:"get",params:t})}function j(t){return Object(a["a"])({url:"/app/xlgl/xlglktap/info",method:"get",params:t})}function O(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/list",method:"post",params:t})}function S(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/info",method:"post",params:t})}function C(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/save",method:"post",params:t})}function k(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/delete",method:"post",params:t})}function z(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/list",method:"post",params:t})}function F(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/info",method:"post",params:t})}function B(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/save",method:"post",params:t})}function L(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/delete",method:"post",params:t})}function T(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/save",method:"post",params:t})}function I(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/getSumCore",method:"post",params:t})}function N(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/list",method:"post",params:t})}function $(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/info",method:"post",params:t})}function D(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/delete",method:"post",params:t})}function M(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/getUserInfo",method:"get",params:t})}function P(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/list",method:"post",params:t})}function A(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/info",method:"post",params:t})}function Q(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/save",method:"post",params:t})}function U(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/delete",method:"post",params:t})}function q(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/list",method:"post",params:t})}function E(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/info",method:"post",params:t})}function W(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/save",method:"post",params:t})}function J(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/delete",method:"post",params:t})}function R(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/list",method:"post",params:t})}function V(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/info",method:"post",params:t})}function X(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/save",method:"post",params:t})}function H(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/delete",method:"post",params:t})}function Z(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/list",method:"post",params:t})}function G(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/info",method:"post",params:t})}function K(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/save",method:"post",params:t})}function Y(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/update",method:"post",params:t})}function tt(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/delete",method:"post",params:t})}function et(t){return Object(a["a"])({url:"/app/xlgl/personalfile/list",method:"post",params:t})}function nt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/count",method:"post",params:t})}function at(t){return Object(a["a"])({url:"/app/xlgl/personalfile/subjectList",method:"post",params:t})}function rt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/subjectTitle",method:"post",params:t})}function lt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/userPerformance",method:"post",params:t})}function ot(t){return Object(a["a"])({url:"/app/xlgl/personalfile/getUserPerXlInfo",method:"post",params:t})}function it(t){return Object(a["a"])({url:"/app/xlgl/personalfile/getUserPerZxInfo",method:"post",params:t})}function st(t){return Object(a["a"])({url:"/app/base/dept/tree_onlyroot",method:"get",params:t})}function ct(t){return Object(a["a"])({url:"/app/xlgl/xlglphysicalrecord/list",method:"get",params:t})}function ut(t){return Object(a["a"])({url:"/app/xlgl/xlglphysicalrecord/delete",method:"get",params:t})}function pt(t){return Object(a["a"])({url:"app/base/dept/tree_onlyroot",method:"get",params:t})}function dt(t){return Object(a["a"])({url:"/app/xlgl/xlglstudyrecord/list",method:"get",params:t})}function ft(t){return Object(a["a"])({url:"/app/xlgl/xlglstudyrecord/delete",method:"get",params:t})}function mt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/getAllDeptInfo",method:"get",params:t})}function gt(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/getXlCoreList",method:"get",params:t})}},"2bd8":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",{staticClass:"app-content"},[n("el-row",{attrs:{gutter:20}},[n("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[n("div",{staticClass:"addTitle"},[n("span",{staticStyle:{color:"#333333","font-size":"16px"}},[t._v("新增训练")]),t._v(" "),n("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),n("div",{staticStyle:{padding:"20px 0"}},[n("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[n("el-row",[n("el-col",{attrs:{span:10}},[n("el-form-item",{attrs:{label:"训练标题",required:""}},[n("el-input",{model:{value:t.form.tacticTitle,callback:function(e){t.$set(t.form,"tacticTitle",e)},expression:"form.tacticTitle"}})],1)],1)],1),t._v(" "),n("el-row",[n("el-col",{attrs:{span:10}},[n("el-form-item",{attrs:{label:"训练内容描述"}},[n("el-col",{attrs:{span:24}},[n("ueditor",{model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1)],1)],1),t._v(" "),n("el-row",[n("el-col",{attrs:{span:4}},[n("el-form-item",{attrs:{label:"上传视频"}},[n("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4",limit:1,drag:"",name:"pdf",action:t.fileUrl,"on-success":t.uploadVideo,multiple:""}},[n("i",{staticClass:"el-icon-upload"}),t._v(" "),n("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),n("em",[t._v("点击上传")]),t._v(" "),n("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),n("el-row",[n("el-col",{attrs:{span:4}},[n("el-form-item",{attrs:{label:"上传封面"}},[n("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".png,.jpeg",limit:1,drag:"",name:"pdf",action:t.fileUrl,"on-success":t.uploadImg,multiple:""}},[n("i",{staticClass:"el-icon-upload"}),t._v(" "),n("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),n("em",[t._v("点击上传")]),t._v(" "),n("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),n("el-row",[n("el-col",{attrs:{span:6}},[n("el-form-item",{attrs:{label:"上传附件"}},[n("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:t.fileUrl,name:"pdf","on-success":t.uploadFile,accept:".word,.ofd,.excel,.docx",multiple:""}},[n("i",{staticClass:"el-icon-upload"}),t._v(" "),n("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),n("em",[t._v("点击上传")]),t._v(" "),n("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)],1)],1)],1)],1),t._v(" "),n("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[n("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),n("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.cancel}},[t._v("取消")])],1)],1)],1)],1)])},r=[],l=n("63f4"),o=n("0fe1"),i={name:"CreateNotice",components:{Ueditor:l["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{fileUrl:"/app/xlgl/xlgldocumentfile/upLoadFile",form:{videoFile:"",coverFile:"",tacticTitle:"",content:"",accessoryArray:""},showImg:!1,fileList:[],radio:"",fileId:[]}},created:function(){},methods:{backFn:function(){this.$emit("back",0)},uploadVideo:function(t){this.form.videoFile=t.fileId},uploadImg:function(t){this.form.coverFile=t.fileId},uploadFile:function(t){this.fileId.push(t.fileId)},saveOrUpdateNotice:function(){var t=this;this.form.tacticTitle?(this.form.accessoryArray=this.fileId.join(","),Object(o["i"])(this.form).then(function(e){"success"===e.data.msg?t.$message({message:"新增成功",type:"success"}):t.$message({message:"新增失败",type:"info"}),t.backFn()})):this.$message({message:"请填写训练标题",type:"info"})},cancel:function(){var t=this;this.$confirm("确定要取消发送此通知吗，您填写的内容将被清空","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){t.form={}}).catch(function(){})}}},s=i,c=(n("538b"),n("2877")),u=Object(c["a"])(s,a,r,!1,null,"1d7091f6",null);e["default"]=u.exports},"538b":function(t,e,n){"use strict";var a=n("f1be"),r=n.n(a);r.a},"5acb":function(t,e,n){},"82f0":function(t,e,n){},"896a":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[0==t.isShow?n("div",{staticClass:"app-content",staticStyle:{"margin-top":"10px",height:"90%"}},[n("title-card",{attrs:{"title-text":"战备基础"}}),t._v(" "),n("div",{staticStyle:{position:"absolute",right:"20px",top:"9px"}},[n("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticClass:"addBtn noBorder",attrs:{type:"success",size:"small",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("新增")])],1),t._v(" "),n("div",{staticStyle:{"margin-top":"15px"}},[n("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},model:{value:t.listQuery.title,callback:function(e){t.$set(t.listQuery,"title",e)},expression:"listQuery.title"}}),t._v(" "),n("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),n("div",{staticClass:"videoList"},t._l(t.videoList,function(e,a){return n("div",{key:a,class:["videoCard",0!=a?"ma-l_20":""],on:{click:function(n){return t.toDetial(e)}}},[n("span",{class:["learnLabel","1"==e.readStatus?"bg_active":"bg_default"]},[t._v(t._s("1"==e.readStatus?"已学习":"待学习"))]),t._v(" "),n("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[e.coverFile?n("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}}):n("svg-icon",{staticClass:"icon",staticStyle:{width:"100%",height:"170px"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),n("div",{staticClass:"flex-center",staticStyle:{"margin-top":"10px",padding:"0 15px"}},[n("span",{staticStyle:{"font-size":"16px"}},[t._v(t._s(e.tacticTitle.length>14?e.tacticTitle.substr(0,14)+"...":e.tacticTitle))])]),t._v(" "),n("div",{staticClass:"flex-center",staticStyle:{"padding-left":"15px"}},[n("p",[n("img"),t._v(" "),n("span",{staticStyle:{color:"#99A6BF"}},[t._v(t._s(e.viewNumber)+"次浏览")])])])])}),0),t._v(" "),n("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)}}})],1):t._e(),t._v(" "),1==t.isShow?n("addPage",{on:{back:t.backList}}):t._e(),t._v(" "),2==t.isShow?n("detailPage",{attrs:{id:t.fileId,isManager:t.isManager},on:{back:t.backList}}):t._e()],1)},r=[],l=n("35b7"),o=n("333d"),i=n("2bd8"),s=n("8ca0"),c=n("0fe1"),u={components:{TitleCard:l["a"],Pagination:o["a"],addPage:i["default"],detailPage:s["default"]},data:function(){return{listQuery:{page:1,limit:10,title:""},total:"0",states:[1,2,3],topicType:[1,2,3],videoList:[],isShow:0,fileId:"",isManager:""}},created:function(){this.getAuthor(),this.getBasisList()},watch:{isShow:function(){this.getBasisList()}},methods:{getBasisList:function(){var t=this;Object(c["h"])(this.listQuery).then(function(e){t.videoList=e.data.page.list,t.total=e.data.page.totalCount})},getAuthor:function(){var t=this;Object(c["f"])().then(function(e){t.isManager=e.data})},search:function(){this.getBasisList()},backList:function(){this.isShow=0},addPage:function(){this.isShow=1},toDetial:function(t){this.isShow=2,this.fileId=t.id}}},p=u,d=(n("b4b2"),n("2877")),f=Object(d["a"])(p,a,r,!1,null,"5898b311",null);e["default"]=f.exports},"8ca0":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("div",{staticClass:"app-content"},[n("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"30px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),n("div",{staticStyle:{padding:"20px"}},[n("div",{staticClass:"header"},[n("div",{staticClass:"title"},[t._v(t._s(t.tacticTitle))]),t._v(" "),n("el-row",[n("el-col",{attrs:{span:6}},[n("span",[t._v("发布时间：")]),t._v(" "),n("span",[t._v(t._s(t.createDate))])]),t._v(" "),n("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[n("span",[t._v("发布单位：")]),t._v(" "),n("span",[t._v(t._s(t.createOrganName))])]),t._v(" "),n("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[n("span",[t._v("浏览次数：")]),t._v(" "),n("span",[t._v(t._s(t.viewNumber))])]),t._v(" "),n("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[n("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),n("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),n("div",{staticStyle:{padding:"20px 40px"}},[n("el-col",{attrs:{span:18}},[n("div",[n("span",[t._v("训练内容描述 ：")]),t._v(" "),n("span",{domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),n("video",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoFile,controls:"controls"}})]),t._v(" "),n("el-col",{attrs:{span:6}},[t.coverFile?n("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.coverFile}}):n("svg-icon",{staticClass:"icon imgStyle",attrs:{"icon-class":"zanwushuju"}}),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{width:"70%",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[n("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.fileList,function(e,a){return n("div",{key:a,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"}},[n("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),n("span",{staticClass:"pictureName"},[t._v(t._s(e.fileName))])],1)})],2)],1)],1)])],1)])},r=[],l=n("0fe1"),o={props:{id:{type:String,default:""},isManager:{type:String,default:""}},data:function(){return{tacticTitle:"",createDate:"",viewNumber:"",createOrganName:"",content:"",coverFile:"",videoFile:"",fileList:[]}},created:function(){this.getBasisInfo()},methods:{getBasisInfo:function(){var t=this;Object(l["g"])({id:this.id}).then(function(e){var n=e.data.xlglWarCommonWarbasis,a=n.tacticTitle,r=n.createDate,l=n.viewNumber,o=n.createOrganName,i=n.coverFile,s=n.videoFile,c=n.content;Object.assign(t,{tacticTitle:a,createDate:r,viewNumber:l,createOrganName:o,coverFile:i,videoFile:s,content:c}),t.fileList=e.data.xlglWarCommonWarbasis.accessoryFileArray})},back:function(){this.$emit("back",0)},editor:function(){this.$emit("back",1,this.id)},deleteFn:function(){var t=this;Object(l["b"])({ids:this.id}).then(function(e){"success"===e.data.msg?t.$message({message:"删除成功",type:"success"}):t.$message({message:"删除失败",type:"info"}),t.back()})}}},i=o,s=(n("c230"),n("2877")),c=Object(s["a"])(i,a,r,!1,null,"084e7a68",null);e["default"]=c.exports},b4b2:function(t,e,n){"use strict";var a=n("5acb"),r=n.n(a);r.a},c230:function(t,e,n){"use strict";var a=n("82f0"),r=n.n(a);r.a},f1be:function(t,e,n){}}]);