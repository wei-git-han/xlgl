(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-45b96440","chunk-d632d902","chunk-0a3ad5ce"],{"056f":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"30px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("div",{staticClass:"header"},[a("div",{staticClass:"title"},[t._v(t._s(t.tacticTitle))]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("span",[t._v("发布时间：")]),t._v(" "),a("span",[t._v(t._s(t.createDate))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("发布单位：")]),t._v(" "),a("span",[t._v(t._s(t.createOrganName))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("浏览次数：")]),t._v(" "),a("span",[t._v(t._s(t.viewNumber))])]),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[a("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),a("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),a("div",{staticStyle:{padding:"20px 40px"}},[a("el-col",{attrs:{span:18}},[a("div",[t._v("\n            训练内容描述 ："),a("p",{domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),a("video",{directives:[{name:"show",rawName:"v-show",value:t.videoFile,expression:"videoFile"}],staticStyle:{height:"500px"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoFile,controls:"controls"}})]),t._v(" "),a("el-col",{attrs:{span:6}},[t.coverFile?a("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.coverFile}}):a("svg-icon",{staticClass:"icon imgStyle",attrs:{"icon-class":"zanwushuju"}}),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{width:"70%",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.fileList,function(e,n){return a("div",{key:n,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),a("span",{staticClass:"pictureName"},[t._v(t._s(e.fileName))])],1)})],2)],1)],1)])],1)])},l=[],i=a("0fe1"),r={props:{id:{type:String,default:""},isManager:{type:String,default:""}},data:function(){return{tacticTitle:"",createDate:"",viewNumber:"",createOrganName:"",content:"",coverFile:"",videoFile:"",fileList:[]}},created:function(){this.getSpecialtyInfo()},methods:{getSpecialtyInfo:function(){var t=this;Object(i["w"])({id:this.id}).then(function(e){var a=e.data.xlglWarSpecialty,n=a.tacticTitle,l=a.createDate,i=a.viewNumber,r=a.createOrganName,o=a.coverFile,s=a.videoFile,c=a.content;Object.assign(t,{tacticTitle:n,createDate:l,viewNumber:i,createOrganName:r,coverFile:o,videoFile:s,content:c}),t.fileList=e.data.xlglWarSpecialty.accessoryFileArray})},back:function(){this.$emit("back",0)},editor:function(){this.$emit("back",1,this.id)},deleteFn:function(){var t=this;Object(i["jb"])({ids:this.id}).then(function(e){"success"===e.data.msg?t.$message({message:"删除成功",type:"success"}):t.$message({message:"删除失败",type:"info"}),t.back()})}}},o=r,s=(a("9709"),a("2877")),c=Object(s["a"])(o,n,l,!1,null,"10ffbfd1",null);e["default"]=c.exports},"0fe1":function(t,e,a){"use strict";a.d(e,"fb",function(){return l}),a.d(e,"n",function(){return i}),a.d(e,"hb",function(){return r}),a.d(e,"ib",function(){return o}),a.d(e,"G",function(){return s}),a.d(e,"q",function(){return c}),a.d(e,"Q",function(){return u}),a.d(e,"R",function(){return p}),a.d(e,"a",function(){return d}),a.d(e,"m",function(){return f}),a.d(e,"gb",function(){return m}),a.d(e,"H",function(){return g}),a.d(e,"l",function(){return x}),a.d(e,"d",function(){return h}),a.d(e,"e",function(){return v}),a.d(e,"h",function(){return b}),a.d(e,"rb",function(){return y}),a.d(e,"p",function(){return j}),a.d(e,"s",function(){return w}),a.d(e,"L",function(){return _}),a.d(e,"f",function(){return O}),a.d(e,"o",function(){return S}),a.d(e,"u",function(){return F}),a.d(e,"t",function(){return k}),a.d(e,"v",function(){return C}),a.d(e,"cb",function(){return L}),a.d(e,"bb",function(){return I}),a.d(e,"A",function(){return z}),a.d(e,"z",function(){return B}),a.d(e,"B",function(){return N}),a.d(e,"mb",function(){return T}),a.d(e,"lb",function(){return $}),a.d(e,"ab",function(){return U}),a.d(e,"C",function(){return D}),a.d(e,"Z",function(){return P}),a.d(e,"Y",function(){return W}),a.d(e,"X",function(){return M}),a.d(e,"I",function(){return Q}),a.d(e,"j",function(){return A}),a.d(e,"i",function(){return q}),a.d(e,"k",function(){return E}),a.d(e,"c",function(){return V}),a.d(e,"b",function(){return J}),a.d(e,"N",function(){return H}),a.d(e,"M",function(){return X}),a.d(e,"O",function(){return Z}),a.d(e,"tb",function(){return G}),a.d(e,"sb",function(){return K}),a.d(e,"x",function(){return R}),a.d(e,"w",function(){return Y}),a.d(e,"y",function(){return tt}),a.d(e,"kb",function(){return et}),a.d(e,"jb",function(){return at}),a.d(e,"E",function(){return nt}),a.d(e,"D",function(){return lt}),a.d(e,"F",function(){return it}),a.d(e,"qb",function(){return rt}),a.d(e,"pb",function(){return ot}),a.d(e,"W",function(){return st}),a.d(e,"V",function(){return ct}),a.d(e,"nb",function(){return ut}),a.d(e,"ob",function(){return pt}),a.d(e,"J",function(){return dt}),a.d(e,"K",function(){return ft}),a.d(e,"r",function(){return mt}),a.d(e,"eb",function(){return gt}),a.d(e,"db",function(){return xt}),a.d(e,"S",function(){return ht}),a.d(e,"U",function(){return vt}),a.d(e,"T",function(){return bt}),a.d(e,"g",function(){return yt}),a.d(e,"P",function(){return jt});var n=a("b775");function l(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function i(){return Object(n["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function r(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function o(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:t})}function s(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getIsHavePerssion",method:"post",params:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function d(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function f(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function m(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function g(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function x(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function h(t){return Object(n["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:t})}function v(t){return Object(n["a"])({url:"/app/xlgl/xlglsubdocinfo/deleteZhu",method:"post",params:t})}function b(t){return Object(n["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:t})}function y(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"post",params:t})}function j(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function w(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function _(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}function O(t){return Object(n["a"])({url:"/app/xlgl/xlglktap/downLoad",method:"get",params:t})}function S(t){return Object(n["a"])({url:"/app/xlgl/xlglktap/info",method:"get",params:t})}function F(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/list",method:"post",params:t})}function k(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/info",method:"post",params:t})}function C(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/save",method:"post",params:t})}function L(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/update",method:"post",params:t})}function I(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/delete",method:"post",params:t})}function z(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/list",method:"post",params:t})}function B(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/info",method:"post",params:t})}function N(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/save",method:"post",params:t})}function T(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/update",method:"post",params:t})}function $(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/delete",method:"post",params:t})}function U(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/save",method:"post",params:t})}function D(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/getSumCore",method:"post",params:t})}function P(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/list",method:"post",params:t})}function W(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/info",method:"post",params:t})}function M(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/delete",method:"post",params:t})}function Q(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/getUserInfo",method:"get",params:t})}function A(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/list",method:"post",params:t})}function q(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/info",method:"post",params:t})}function E(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/save",method:"post",params:t})}function V(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/update",method:"post",params:t})}function J(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/delete",method:"post",params:t})}function H(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/list",method:"post",params:t})}function X(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/info",method:"post",params:t})}function Z(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/save",method:"post",params:t})}function G(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/update",method:"post",params:t})}function K(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/delete",method:"post",params:t})}function R(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/list",method:"post",params:t})}function Y(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/info",method:"post",params:t})}function tt(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/save",method:"post",params:t})}function et(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/update",method:"post",params:t})}function at(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/delete",method:"post",params:t})}function nt(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/list",method:"post",params:t})}function lt(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/info",method:"post",params:t})}function it(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/save",method:"post",params:t})}function rt(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/update",method:"post",params:t})}function ot(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/delete",method:"post",params:t})}function st(t){return Object(n["a"])({url:"/app/xlgl/personalfile/list",method:"post",params:t})}function ct(t){return Object(n["a"])({url:"/app/xlgl/personalfile/count",method:"post",params:t})}function ut(t){return Object(n["a"])({url:"/app/xlgl/personalfile/subjectList",method:"post",params:t})}function pt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/subjectTitle",method:"post",params:t})}function dt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/getUserPerXlInfo",method:"post",params:t})}function ft(t){return Object(n["a"])({url:"/app/xlgl/personalfile/getUserPerZxInfo",method:"post",params:t})}function mt(t){return Object(n["a"])({url:"/app/base/dept/tree_onlyroot",method:"get",params:t})}function gt(t){return Object(n["a"])({url:"/app/xlgl/xlglphysicalrecord/list",method:"get",params:t})}function xt(t){return Object(n["a"])({url:"/app/xlgl/xlglphysicalrecord/delete",method:"get",params:t})}function ht(t){return Object(n["a"])({url:"app/base/dept/tree_onlyroot",method:"get",params:t})}function vt(t){return Object(n["a"])({url:"/app/xlgl/xlglstudyrecord/list",method:"get",params:t})}function bt(t){return Object(n["a"])({url:"/app/xlgl/xlglstudyrecord/delete",method:"get",params:t})}function yt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/getAllDeptInfo",method:"get",params:t})}function jt(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/getXlCoreList",method:"get",params:t})}},"25ae":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[0==t.isShow?a("div",{staticClass:"app-content",staticStyle:{"margin-top":"10px",height:"100%"}},[a("title-card",{attrs:{"title-text":"专业训练"}}),t._v(" "),a("div",{staticStyle:{position:"absolute",right:"20px",top:"9px"}},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticClass:"addBtn noBorder",attrs:{type:"success",size:"small",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("新增")])],1),t._v(" "),a("div",{staticStyle:{"margin-top":"15px"}},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},model:{value:t.listQuery.title,callback:function(e){t.$set(t.listQuery,"title",e)},expression:"listQuery.title"}}),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),a("div",{staticClass:"videoList"},t._l(t.videoList,function(e,n){return a("div",{key:n,class:["videoCard",0!=n?"ma-l_20":""],on:{click:function(a){return t.toDetial(e)}}},[a("span",{class:["learnLabel","1"==e.readStatus?"bg_active":"bg_default"]},[t._v(t._s("1"==e.readStatus?"已学习":"待学习"))]),t._v(" "),a("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[e.coverFile?a("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}}):a("svg-icon",{staticClass:"icon",staticStyle:{width:"100%",height:"170px"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"margin-top":"10px",padding:"0 15px"}},[a("span",{staticStyle:{"font-size":"16px"}},[t._v(t._s(e.tacticTitle.length>14?e.tacticTitle.substr(0,14)+"...":e.tacticTitle))])]),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"padding-left":"15px"}},[a("p",[a("img"),t._v(" "),a("span",{staticStyle:{color:"#99A6BF"}},[t._v(t._s(e.viewNumber)+"次浏览")])])])])}),0),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)}}})],1):t._e(),t._v(" "),1==t.isShow?a("addPage",{attrs:{id:t.fileId},on:{back:t.backList}}):t._e(),t._v(" "),2==t.isShow?a("detailPage",{attrs:{id:t.fileId,"is-manager":t.isManager},on:{back:t.backList}}):t._e()],1)},l=[],i=a("35b7"),r=a("333d"),o=a("5b2c"),s=a("056f"),c=a("0fe1"),u={components:{TitleCard:i["a"],Pagination:r["a"],addPage:o["default"],detailPage:s["default"]},data:function(){return{listQuery:{page:1,limit:10,title:""},total:"0",states:[1,2,3],topicType:[1,2,3],videoList:[],isShow:0,fileId:"",isManager:""}},watch:{isShow:function(){this.getSpecialtyList()}},created:function(){this.getAuthor(),this.getSpecialtyList()},methods:{getSpecialtyList:function(){var t=this;Object(c["x"])(this.listQuery).then(function(e){t.videoList=e.data.page.list,t.total=e.data.page.totalCount})},getAuthor:function(){var t=this;Object(c["h"])().then(function(e){t.isManager=e.data})},search:function(){this.getSpecialtyList()},backList:function(t,e){this.isShow=t,this.fileId=e},addPage:function(){this.isShow=1},toDetial:function(t){this.isShow=2,this.fileId=t.id}}},p=u,d=(a("267b"),a("2877")),f=Object(d["a"])(p,n,l,!1,null,"810f9a16",null);e["default"]=f.exports},"267b":function(t,e,a){"use strict";var n=a("52b3"),l=a.n(n);l.a},"52b3":function(t,e,a){},"5b2c":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"app-content"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",{staticStyle:{color:"#333333","font-size":"16px"}},[t._v("新增训练")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练标题",required:""}},[a("el-input",{model:{value:t.form.tacticTitle,callback:function(e){t.$set(t.form,"tacticTitle",e)},expression:"form.tacticTitle"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练内容描述"}},[a("el-col",{attrs:{span:24}},[a("ueditor",{ref:"content",model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"上传视频"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4",limit:1,drag:"",name:"pdf",action:t.fileUrl,"file-list":t.videoList,"on-success":t.uploadVideo,"on-remove":t.removeVideo}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"上传封面"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".png,.jpeg",limit:1,drag:"",name:"pdf",action:t.fileUrl,"file-list":t.imgList,"on-success":t.uploadImg,"on-remove":t.removeImg}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"上传附件"}},[a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:t.fileUrl,name:"pdf","on-success":t.uploadFile,"on-remove":t.removeFile,accept:".word,.ofd,.excel,.docx","file-list":t.fileList,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)],1)],1)],1)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.cancel}},[t._v("取消")])],1)],1)],1)],1)])},l=[],i=(a("ac6a"),a("63f4")),r=a("0fe1"),o={name:"CreateNotice",components:{Ueditor:i["a"]},props:{id:{type:String,default:""}},data:function(){return{fileUrl:"/app/xlgl/xlgldocumentfile/upLoadFile",form:{videoFile:"",coverFile:"",tacticTitle:"",content:""},showImg:!1,fileList:[],fileId:[],videoList:[],imgList:[]}},created:function(){this.id&&this.getSpecialtyInfo()},methods:{getSpecialtyInfo:function(){var t=this;Object(r["w"])({id:this.id}).then(function(e){var a=e.data.xlglWarSpecialty,n=a.tacticTitle,l=a.coverFile,i=a.videoFile,r=a.content;Object.assign(t.form,{tacticTitle:n,coverFile:l,videoFile:i,content:r}),e.data.xlglWarSpecialty.videoFile&&t.videoList.push({name:e.data.xlglWarSpecialty.videoFileName,url:e.data.xlglWarSpecialty.videoFile}),e.data.xlglWarSpecialty.coverFile&&t.imgList.push({name:e.data.xlglWarSpecialty.coverFileName,url:e.data.xlglWarSpecialty.coverFile}),e.data.xlglWarSpecialty.accessoryFileArray.forEach(function(e,a){t.fileList.push({name:e.fileName,url:e.fileId}),t.fileId.push(e.fileId)}),t.$refs.content.setContent(t.form.content)})},backFn:function(){this.$emit("back",0)},uploadVideo:function(t){this.form.videoFile=t.fileId},uploadImg:function(t){this.form.coverFile=t.fileId},uploadFile:function(t){this.fileId.push(t.fileId)},removeVideo:function(){this.form.videoFile=""},removeImg:function(){this.form.coverFile=""},removeFile:function(t){this.fileId.indexOf(t.url)>-1&&this.fileId.splice(t.url,1)},saveOrUpdateNotice:function(){this.form.tacticTitle?this.id?(this.form.id=this.id,this.form.accessoryFile=this.fileId.join(","),this.specialtyUpdate()):(this.form.accessoryArray=this.fileId.join(","),this.getSpecialtySave()):this.$message({message:"请填写训练标题",type:"info"})},getSpecialtySave:function(){var t=this;Object(r["y"])(this.form).then(function(e){"success"===e.data.msg?t.$message({message:"新增成功",type:"success"}):t.$message({message:"新增失败",type:"info"}),t.backFn()})},specialtyUpdate:function(){var t=this;Object(r["kb"])(this.form).then(function(e){"success"===e.data.msg?t.$message({message:"修改成功",type:"success"}):t.$message({message:"修改失败",type:"info"}),t.backFn()})},cancel:function(){var t=this;this.$confirm("确定要取消发送此通知吗，您填写的内容将被清空","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){t.form={}}).catch(function(){})}}},s=o,c=(a("dea2"),a("2877")),u=Object(c["a"])(s,n,l,!1,null,"c0822d30",null);e["default"]=u.exports},9709:function(t,e,a){"use strict";var n=a("d29b"),l=a.n(n);l.a},cbff:function(t,e,a){},d29b:function(t,e,a){},dea2:function(t,e,a){"use strict";var n=a("cbff"),l=a.n(n);l.a}}]);