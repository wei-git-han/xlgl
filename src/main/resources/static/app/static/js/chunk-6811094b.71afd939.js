(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6811094b","chunk-6e56027e","chunk-809de8d8","chunk-4f6d2b90"],{"09f4":function(t,e,a){"use strict";a.d(e,"a",function(){return o}),Math.easeInOutQuad=function(t,e,a,l){return t/=l/2,t<1?a/2*t*t+e:(t--,-a/2*(t*(t-2)-1)+e)};var l=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function n(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function s(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function o(t,e,a){var o=s(),i=t-o,r=20,c=0;e="undefined"===typeof e?500:e;var p=function t(){c+=r;var s=Math.easeInOutQuad(c,o,i,e);n(s),c<e?l(t):a&&"function"===typeof a&&a()};p()}},"0be3":function(t,e,a){},"0fe1":function(t,e,a){"use strict";a.d(e,"Z",function(){return n}),a.d(e,"k",function(){return s}),a.d(e,"bb",function(){return o}),a.d(e,"cb",function(){return i}),a.d(e,"C",function(){return r}),a.d(e,"J",function(){return c}),a.d(e,"K",function(){return p}),a.d(e,"a",function(){return u}),a.d(e,"j",function(){return d}),a.d(e,"ab",function(){return f}),a.d(e,"D",function(){return m}),a.d(e,"i",function(){return v}),a.d(e,"c",function(){return g}),a.d(e,"e",function(){return x}),a.d(e,"jb",function(){return _}),a.d(e,"m",function(){return h}),a.d(e,"o",function(){return b}),a.d(e,"F",function(){return y}),a.d(e,"d",function(){return w}),a.d(e,"l",function(){return S}),a.d(e,"q",function(){return j}),a.d(e,"p",function(){return O}),a.d(e,"r",function(){return k}),a.d(e,"W",function(){return C}),a.d(e,"w",function(){return z}),a.d(e,"v",function(){return F}),a.d(e,"x",function(){return T}),a.d(e,"eb",function(){return L}),a.d(e,"V",function(){return I}),a.d(e,"y",function(){return N}),a.d(e,"U",function(){return $}),a.d(e,"T",function(){return D}),a.d(e,"S",function(){return A}),a.d(e,"E",function(){return B}),a.d(e,"g",function(){return q}),a.d(e,"f",function(){return E}),a.d(e,"h",function(){return M}),a.d(e,"b",function(){return Q}),a.d(e,"H",function(){return U}),a.d(e,"G",function(){return J}),a.d(e,"I",function(){return V}),a.d(e,"lb",function(){return P}),a.d(e,"t",function(){return R}),a.d(e,"s",function(){return H}),a.d(e,"u",function(){return W}),a.d(e,"db",function(){return G}),a.d(e,"A",function(){return K}),a.d(e,"z",function(){return X}),a.d(e,"B",function(){return Y}),a.d(e,"ib",function(){return Z}),a.d(e,"hb",function(){return tt}),a.d(e,"R",function(){return et}),a.d(e,"Q",function(){return at}),a.d(e,"fb",function(){return lt}),a.d(e,"gb",function(){return nt}),a.d(e,"kb",function(){return st}),a.d(e,"n",function(){return ot}),a.d(e,"L",function(){return it}),a.d(e,"Y",function(){return rt}),a.d(e,"X",function(){return ct}),a.d(e,"N",function(){return pt}),a.d(e,"M",function(){return ut}),a.d(e,"P",function(){return dt}),a.d(e,"O",function(){return ft});var l=a("b775");function n(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function s(){return Object(l["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function o(t){return Object(l["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function i(t){return Object(l["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:t})}function r(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:t})}function c(t){return Object(l["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function p(t){return Object(l["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function u(t){return Object(l["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function d(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function f(t){return Object(l["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function m(t){return Object(l["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function v(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function g(t){return Object(l["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:t})}function x(t){return Object(l["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:t})}function _(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"post",params:t})}function h(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function b(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function y(t){return Object(l["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}function w(t){return Object(l["a"])({url:"/app/xlgl/xlglktap/downLoad",method:"get",params:t})}function S(t){return Object(l["a"])({url:"/app/xlgl/xlglktap/info",method:"get",params:t})}function j(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonqueue/list",method:"post",params:t})}function O(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonqueue/info",method:"post",params:t})}function k(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonqueue/save",method:"post",params:t})}function C(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonqueue/delete",method:"post",params:t})}function z(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonsports/list",method:"post",params:t})}function F(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonsports/info",method:"post",params:t})}function T(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonsports/save",method:"post",params:t})}function L(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonsports/delete",method:"post",params:t})}function I(t){return Object(l["a"])({url:"/app/xlgl/xlglphysical/save",method:"post",params:t})}function N(t){return Object(l["a"])({url:"/app/xlgl/xlglphysical/getSumCore",method:"post",params:t})}function $(t){return Object(l["a"])({url:"/app/xlgl/xlglphysical/list",method:"post",params:t})}function D(t){return Object(l["a"])({url:"/app/xlgl/xlglphysical/info",method:"post",params:t})}function A(t){return Object(l["a"])({url:"/app/xlgl/xlglphysical/delete",method:"post",params:t})}function B(t){return Object(l["a"])({url:"/app/xlgl/xlglphysical/getUserInfo",method:"get",params:t})}function q(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/list",method:"post",params:t})}function E(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/info",method:"post",params:t})}function M(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/save",method:"post",params:t})}function Q(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/delete",method:"post",params:t})}function U(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonweapon/list",method:"post",params:t})}function J(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonweapon/info",method:"post",params:t})}function V(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonweapon/save",method:"post",params:t})}function P(t){return Object(l["a"])({url:"/app/xlgl/xlglwarcommonweapon/delete",method:"post",params:t})}function R(t){return Object(l["a"])({url:"/app/xlgl/xlglwarspecialty/list",method:"post",params:t})}function H(t){return Object(l["a"])({url:"/app/xlgl/xlglwarspecialty/info",method:"post",params:t})}function W(t){return Object(l["a"])({url:"/app/xlgl/xlglwarspecialty/save",method:"post",params:t})}function G(t){return Object(l["a"])({url:"/app/xlgl/xlglwarspecialty/delete",method:"post",params:t})}function K(t){return Object(l["a"])({url:"/app/xlgl/xlglwartactic/list",method:"post",params:t})}function X(t){return Object(l["a"])({url:"/app/xlgl/xlglwartactic/info",method:"post",params:t})}function Y(t){return Object(l["a"])({url:"/app/xlgl/xlglwartactic/save",method:"post",params:t})}function Z(t){return Object(l["a"])({url:"/app/xlgl/xlglwartactic/update",method:"post",params:t})}function tt(t){return Object(l["a"])({url:"/app/xlgl/xlglwartactic/delete",method:"post",params:t})}function et(t){return Object(l["a"])({url:"/app/xlgl/personalfile/list",method:"post",params:t})}function at(t){return Object(l["a"])({url:"/app/xlgl/personalfile/count",method:"post",params:t})}function lt(t){return Object(l["a"])({url:"/app/xlgl/personalfile/subjectList",method:"post",params:t})}function nt(t){return Object(l["a"])({url:"/app/xlgl/personalfile/subjectTitle",method:"post",params:t})}function st(t){return Object(l["a"])({url:"/app/xlgl/personalfile/userPerformance",method:"post",params:t})}function ot(t){return Object(l["a"])({url:"/app/base/dept/tree_onlyroot",method:"get",params:t})}function it(t){return Object(l["a"])({url:"/app/xlgl/xlglphysical/importExcel",method:"get",params:t})}function rt(t){return Object(l["a"])({url:"/app/xlgl/xlglphysicalrecord/list",method:"get",params:t})}function ct(t){return Object(l["a"])({url:"/app/xlgl/xlglphysicalrecord/delete",method:"get",params:t})}function pt(t){return Object(l["a"])({url:"app/base/dept/tree_onlyroot",method:"get",params:t})}function ut(t){return Object(l["a"])({url:"/app/xlgl/xlglminestudy/importExcel",method:"get",params:t})}function dt(t){return Object(l["a"])({url:"/app/xlgl/xlglstudyrecord/list",method:"get",params:t})}function ft(t){return Object(l["a"])({url:"/app/xlgl/xlglstudyrecord/delete",method:"get",params:t})}},2495:function(t,e,a){"use strict";var l=a("358c"),n=a.n(l);n.a},"358c":function(t,e,a){},"5ab4":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content",staticStyle:{height:"100%"}},[0==t.isShow?a("div",{staticStyle:{position:"relative",padding:"0 10px"}},[a("el-tabs",{on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"视频教学",name:"first"}},[a("div",[a("div",{staticClass:"search-content"},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"请输入训练名称"},model:{value:t.listQuery.title,callback:function(e){t.$set(t.listQuery,"title",e)},expression:"listQuery.title"}}),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")])],1)]),t._v(" "),a("div",{staticClass:"videoList"},t._l(t.videoList,function(e,l){return a("div",{key:l,class:["videoCard",0!=l?"ma-l_20":""],on:{click:function(a){return t.toDetial(e)}}},[a("span",{class:["learnLabel","1"==e.readStatus?"bg_active":"bg_default"]},[t._v(t._s("1"==e.readStatus?"已学习":"待学习"))]),t._v(" "),a("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[e.coverFile?a("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}}):a("svg-icon",{staticClass:"icon",staticStyle:{width:"100%",height:"170px"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"margin-top":"10px",padding:"0 15px"}},[a("span",{staticStyle:{"font-size":"16px"}},[t._v(t._s(e.tacticTitle.length>14?e.tacticTitle.substr(0,14)+"...":e.tacticTitle))])]),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"padding-left":"15px"}},[a("p",[a("img"),t._v(" "),a("span",{staticStyle:{color:"#99A6BF"}},[t._v(t._s(e.viewNumber)+"次浏览")])])])])}),0),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)}}})],1),t._v(" "),a("el-tab-pane",{attrs:{label:"军事体育成绩评定",name:"second"}},[a("el-row",[a("el-col",{attrs:{span:18}},[a("div",{staticClass:"flex-center",staticStyle:{padding:"0 60px 0 20px"}},[a("div",[a("span",[t._v("体型分数")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v("24")])]),t._v(" "),a("div",[a("span",[t._v("体型评定")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v("优秀")])]),t._v(" "),a("div",[a("span",[t._v("军事体育成绩")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v("优秀")])]),t._v(" "),a("div",[a("span",[t._v("体育等级评定")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v("优秀")])])]),t._v(" "),a("el-form",{ref:"form",staticStyle:{"margin-top":"30px"},attrs:{model:t.form,"label-width":"100px"}},[a("el-row",[a("el-col",{attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"姓名",required:""}},[a("el-input",{attrs:{disabled:""},model:{value:t.userName,callback:function(e){t.userName=e},expression:"userName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"年龄",required:""}},[a("el-input",{model:{value:t.form.age,callback:function(e){t.$set(t.form,"age",e)},expression:"form.age"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:10}},[a("div",{staticClass:"txIcon"},[a("span",[t._v("体型信息录入")])])]),t._v(" "),a("el-col",{attrs:{span:10}},[a("div",{staticStyle:{display:"flex","align-items":"center"}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),a("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看体型标准")}}},[t._v("查看体型标准")])])])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"10px"}},[a("el-col",{attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"性别",required:""}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.sex,callback:function(e){t.$set(t.form,"sex",e)},expression:"form.sex"}},[a("el-option",{attrs:{label:"男",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"女",value:"1"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"身高",required:""}},[a("el-input",{attrs:{placeholder:"请输入"},model:{value:t.form.high,callback:function(e){t.$set(t.form,"high",e)},expression:"form.high"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"类型",required:""}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},[a("el-option",{attrs:{label:"一类人员",value:"1"}}),t._v(" "),a("el-option",{attrs:{label:"二类人员",value:"2"}}),t._v(" "),a("el-option",{attrs:{label:"三类人员",value:"3"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"体重",required:""}},[a("el-input",{attrs:{placeholder:"请输入"},model:{value:t.form.wight,callback:function(e){t.$set(t.form,"wight",e)},expression:"form.wight"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"出生年月",required:""}},[a("el-input",{attrs:{placeholder:"请输入"},model:{value:t.form.birthday,callback:function(e){t.$set(t.form,"birthday",e)},expression:"form.birthday"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:10}},[a("div",{staticClass:"kmIcon"},[a("span",[t._v("科目成绩录入")])])]),t._v(" "),a("el-col",{attrs:{span:10}},[a("div",{staticStyle:{display:"flex","align-items":"center"}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),a("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看训练标准")}}},[t._v("查看训练标准")])])])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"15px"}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"引体向上",required:""}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:t.countMark},model:{value:t.form.ytxs,callback:function(e){t.$set(t.form,"ytxs",e)},expression:"form.ytxs"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[a("span",[t._v("次")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.up))]),t._v("分\n                    ")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"5px"}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"仰卧起坐",required:""}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:t.countMark},model:{value:t.form.ywqz,callback:function(e){t.$set(t.form,"ywqz",e)},expression:"form.ywqz"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[a("span",[t._v("次")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.sit))]),t._v("分\n                    ")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"5px"}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"30米蛇形跑",required:""}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:t.countMark},model:{value:t.form.sxp,callback:function(e){t.$set(t.form,"sxp",e)},expression:"form.sxp"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[a("span",[t._v("次")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.sRun))]),t._v("分\n                    ")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"5px"}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"3000米长跑",required:""}},[a("el-col",{attrs:{span:10}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:t.countMark},model:{value:t.form.cp,callback:function(e){t.$set(t.form,"cp",e)},expression:"form.cp"}})],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:4}},[a("span",[t._v("分")])]),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:t.countMark},model:{value:t.form.cp,callback:function(e){t.$set(t.form,"cp",e)},expression:"form.cp"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[a("span",[t._v("秒")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.tRun))]),t._v("分\n                    ")])])],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bor_b flex-center"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("各单位年度参训完成情况")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showView}},[t._v("查看")])]),t._v(" "),t._l(t.resultList,function(e,l){return a("div",{key:l,staticStyle:{margin:"15px 0"}},[a("el-row",[a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:2}},[a("span",[t._v(t._s(l+1))])]),t._v(" "),a("el-col",{attrs:{span:6}},[a("span",{class:["0"==e.allJudge?"color_red":"color_green"]},[t._v(t._s("0"==e.allJudge?"合格":"不合格"))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:10}},[a("span",[t._v(t._s(e.createdTime))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",{staticClass:"color_red",staticStyle:{cursor:"pointer"},on:{click:function(a){return t.deleteData(e)}}},[t._v("删除")])])],1)],1)})],2)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"20px"},attrs:{span:24}},[a("el-button",{attrs:{type:"primary"},on:{click:t.saveData}},[t._v("保存")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},on:{click:t.resetFn}},[t._v("重置")])],1)],1)],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:0==t.tabIndex,expression:"tabIndex==0"}],staticStyle:{position:"absolute",right:"10px",top:"4px"}},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticClass:"addBtn noBorder",attrs:{type:"success",size:"small",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("新增")])],1)],1):t._e(),t._v(" "),2==t.isShow?a("militaryAdd",{on:{back:t.backList}}):t._e(),t._v(" "),3==t.isShow?a("militaryView",{attrs:{id:t.fileId,isManager:t.isManager},on:{back:t.backList}}):t._e(),t._v(" "),1==t.isShow?a("sportHistory",{on:{back:t.backList}}):t._e(),t._v(" "),a("el-dialog",{attrs:{title:t.fileTitle,visible:t.showDialog},on:{"update:visible":function(e){t.showDialog=e},close:t.resetTemp}},[t._v("\n      加载体型标准对照表\n    ")])],1)])},n=[],s=(a("c5f6"),a("333d")),o=a("c1b8"),i=a("ed32"),r=a("c89c"),c=a("0fe1"),p={components:{Pagination:s["a"],sportHistory:o["default"],militaryAdd:i["default"],militaryView:r["default"]},data:function(){return{listQuery:{page:1,limit:10,title:""},videoList:[],activeName:"first",total:0,tabIndex:0,form:{age:"",up:"",sit:"",sRun:"",tRun:"",sex:"",type:"",birthday:"",wight:"",high:"",tscore:"",judge:"",allScore:"",allJudge:"",ytxs:"",ywqz:"",sxp:"",cp:""},resultList:[],fractionList:[{text:"体型分数目",value:"24"},{text:"体型评定",value:"合格"},{text:"军事体育成绩",value:"24"},{text:"体育登记评定",value:"不合格"}],isShow:0,showDialog:!1,fileTitle:"",fileId:"",isManager:"",userName:""}},watch:{isShow:function(t){"0"===t&&this.getSportsList()},activeName:function(t){"second"===t?(this.getUserInfo(),this.physicalList()):this.getSportsList()}},created:function(){this.getSportsList(),this.getAuthor()},methods:{getSportsList:function(){var t=this;Object(c["w"])(this.listQuery).then(function(e){t.videoList=e.data.page.list,t.total=e.data.page.totalCount})},getAuthor:function(){var t=this;Object(c["e"])().then(function(e){t.isManager=e.data})},getUserInfo:function(){var t=this;Object(c["E"])().then(function(e){t.userName=e.data.userName})},physicalList:function(){var t=this;Object(c["U"])(this.listQuery).then(function(e){t.resultList=e.data.page.list})},search:function(){this.getSportsList()},handleClick:function(t){this.tabIndex=Number(t.index)},addPage:function(){this.isShow=2},showView:function(){this.isShow=1},toDetial:function(t){this.isShow=3,this.fileId=t.id},showChart:function(){},backList:function(t){this.isShow=t},show_dialog:function(t){this.showDialog=!0,this.fileTitle=t},resetTemp:function(){},saveData:function(){var t=this;Object(c["V"])(this.form).then(function(e){"success"===e.data.result?t.$message({message:"保存成功",type:"success"}):t.$message({message:"保存失败",type:"info"}),t.form={},t.physicalList()})},resetFn:function(){this.form={}},countMark:function(){Object(c["y"])(this.form).then(function(t){})},deleteData:function(t){var e=this;Object(c["S"])({id:t.id}).then(function(t){"success"===t.data.result?e.$message({message:"删除成功",type:"success"}):e.$message({message:"删除失败",type:"info"}),e.physicalList()})}}},u=p,d=(a("9498"),a("2877")),f=Object(d["a"])(u,l,n,!1,null,null,null);e["default"]=f.exports},"8b07":function(t,e,a){"use strict";var l=a("b630"),n=a.n(l);n.a},9498:function(t,e,a){"use strict";var l=a("0be3"),n=a.n(l);n.a},b630:function(t,e,a){},c1b8:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"containeer"},[a("title-card",{attrs:{"title-text":"历史评定"}}),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),a("el-row",[a("el-col",{staticStyle:{"margin-left":"60px"},attrs:{span:20}},[a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,border:"","header-cell-style":{background:"#F7F7F8"}}},[a("el-table-column",{attrs:{prop:"company",align:"center",label:"序号"}}),t._v(" "),a("el-table-column",{attrs:{prop:"allJudge",align:"center",label:"等级"}}),t._v(" "),a("el-table-column",{attrs:{prop:"createdTime",align:"center",label:"生成日期"}}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.deleteData(e.row)}}},[t._v("删除")])]}}])})],1)],1)],1),t._v(" "),a("div",{staticStyle:{"border-top":"1px solid #ccc","margin-top":"30px","padding-top":"20px","padding-left":"10px"}},[a("el-row",[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"txIcon"},[a("span",[t._v("体型信息录入")])])]),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticStyle:{display:"flex","align-items":"center"}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),a("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看体型标准")}}},[t._v("查看体型标准")])])])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("性别：")]),t._v(" "),a("span",[t._v("男")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("出生日期：")]),t._v(" "),a("span",[t._v("19900215")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("类别：")]),t._v(" "),a("span",[t._v("一般人员")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("身高：")]),t._v(" "),a("span",[t._v("172cm")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("体重：")]),t._v(" "),a("span",[t._v("120kg")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"30px"}},[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"kmIcon"},[a("span",[t._v("科目成绩录入")])])]),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticStyle:{display:"flex","align-items":"center"}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),a("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看训练标准")}}},[t._v("查看训练标准")])])])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("屈臂悬垂：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("25")]),t._v(" "),a("span",[t._v("个")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("98")]),t._v(" "),a("span",[t._v("分")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("仰卧起坐：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("58")]),t._v(" "),a("span",[t._v("次")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("76")]),t._v(" "),a("span",[t._v("分")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("30米蛇形跑：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("12")]),t._v(" "),a("span",[t._v("秒")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("36")]),t._v(" "),a("span",[t._v("分")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("3000米长跑：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("9分12秒")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("137")]),t._v(" "),a("span",[t._v("分")])])],1)],1),t._v(" "),a("el-dialog",{attrs:{title:t.fileTitle,visible:t.showDialog},on:{"update:visible":function(e){t.showDialog=e},close:t.resetTemp}},[t._v("\n    加载体型标准对照表\n  ")])],1)},n=[],s=a("35b7"),o=a("0fe1"),i={components:{TitleCard:s["a"]},props:{id:{type:String,default:""}},data:function(){return{listQuery:{page:1,limit:10},tableData:[],showDialog:!1,fileTitle:!1}},created:function(){this.physicalInfo(),this.physicalList()},methods:{physicalList:function(){var t=this;Object(o["U"])(this.listQuery).then(function(e){t.tableData=e.data.page.list})},physicalInfo:function(){Object(o["T"])({id:this.id}).then(function(t){})},back:function(){this.$emit("back",0)},deleteData:function(t){},show_dialog:function(t){this.showDialog=!0,this.fileTitle=t}}},r=i,c=(a("8b07"),a("2877")),p=Object(c["a"])(r,l,n,!1,null,"121b38e1",null);e["default"]=p.exports},c89c:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"30px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("div",{staticClass:"header"},[a("div",{staticClass:"title"},[t._v(t._s(t.tacticTitle))]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("span",[t._v("发布时间：")]),t._v(" "),a("span",[t._v(t._s(t.createDate))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("发布单位：")]),t._v(" "),a("span",[t._v(t._s(t.createOrganName))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("浏览次数：")]),t._v(" "),a("span",[t._v(t._s(t.viewNumber))])]),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[a("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),a("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),a("div",{staticStyle:{padding:"20px 40px"}},[a("el-col",{attrs:{span:18}},[a("div",[a("span",[t._v("训练内容描述 ：")]),t._v(" "),a("span",{domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),a("video",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoFile,controls:"controls"}})]),t._v(" "),a("el-col",{attrs:{span:6}},[t.coverFile?a("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.coverFile}}):a("svg-icon",{staticClass:"icon imgStyle",attrs:{"icon-class":"zanwushuju"}}),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{width:"70%",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.fileList,function(e,l){return a("div",{key:l,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),a("span",{staticClass:"pictureName"},[t._v(t._s(e.fileName))])],1)})],2)],1)],1)])],1)])},n=[],s=a("0fe1"),o={props:{id:{type:String,default:""},isManager:{type:String,default:""}},data:function(){return{tacticTitle:"",createDate:"",viewNumber:"",createOrganName:"",content:"",coverFile:"",videoFile:"",fileList:[]}},created:function(){this.getSportsInfo()},methods:{getSportsInfo:function(){var t=this;Object(s["v"])({id:this.id}).then(function(e){var a=e.data.xlglWarCommonSports,l=a.tacticTitle,n=a.createDate,s=a.viewNumber,o=a.createOrganName,i=a.coverFile,r=a.videoFile,c=a.content;Object.assign(t,{tacticTitle:l,createDate:n,viewNumber:s,createOrganName:o,coverFile:i,videoFile:r,content:c}),t.fileList=e.data.xlglWarCommonSports.accessoryFileArray})},back:function(){this.$emit("back",0)},editor:function(){this.$emit("back",1,this.id)},deleteFn:function(){var t=this;Object(s["eb"])({ids:this.id}).then(function(e){"success"===e.data.msg?t.$message({message:"删除成功",type:"success"}):t.$message({message:"删除失败",type:"info"}),t.back()})}}},i=o,r=(a("fb0a"),a("2877")),c=Object(r["a"])(i,l,n,!1,null,"3d235307",null);e["default"]=c.exports},ed32:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"app-content"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",{staticStyle:{color:"#333333","font-size":"16px"}},[t._v("新增训练")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练标题",required:""}},[a("el-input",{model:{value:t.form.tacticTitle,callback:function(e){t.$set(t.form,"tacticTitle",e)},expression:"form.tacticTitle"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练内容描述"}},[a("el-col",{attrs:{span:24}},[a("ueditor",{model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:4}},[a("el-form-item",{attrs:{label:"上传视频"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4",limit:1,drag:"",name:"pdf",action:t.fileUrl,"on-success":t.uploadVideo,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:4}},[a("el-form-item",{attrs:{label:"上传封面"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".png,.jpeg",limit:1,drag:"",name:"pdf",action:t.fileUrl,"on-success":t.uploadImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"上传附件"}},[a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:t.fileUrl,name:"pdf","on-success":t.uploadFile,accept:".word,.ofd,.excel,.docx",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)],1)],1)],1)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.cancel}},[t._v("取消")])],1)],1)],1)],1)])},n=[],s=a("63f4"),o=a("0fe1"),i={name:"CreateNotice",components:{Ueditor:s["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{fileUrl:"/app/xlgl/xlgldocumentfile/upLoadFile",form:{videoFile:"",coverFile:"",tacticTitle:"",content:"",accessoryArray:""},showImg:!1,fileList:[],radio:"",fileId:[]}},created:function(){},methods:{backFn:function(){this.$emit("back",0)},uploadVideo:function(t){this.form.videoFile=t.fileId},uploadImg:function(t){this.form.coverFile=t.fileId},uploadFile:function(t){this.fileId.push(t.fileId)},saveOrUpdateNotice:function(){var t=this;this.form.tacticTitle?(this.form.accessoryArray=this.fileId.join(","),Object(o["x"])(this.form).then(function(e){"success"===e.data.msg?t.$message({message:"新增成功",type:"success"}):t.$message({message:"新增失败",type:"info"}),t.backFn()})):this.$message({message:"请填写训练标题",type:"info"})},cancel:function(){var t=this;this.$confirm("确定要取消发送此通知吗，您填写的内容将被清空","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){t.form={}}).catch(function(){})}}},r=i,c=(a("2495"),a("2877")),p=Object(c["a"])(r,l,n,!1,null,"60dfeabd",null);e["default"]=p.exports},f983:function(t,e,a){},fb0a:function(t,e,a){"use strict";var l=a("f983"),n=a.n(l);n.a}}]);