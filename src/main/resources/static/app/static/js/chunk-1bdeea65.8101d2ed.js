(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1bdeea65","chunk-0308c41f"],{"09a0":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticStyle:{overflow:"scroll"}},[n("div",{staticClass:"search-content"},[n("el-row",{attrs:{span:24}},[n("el-form",{attrs:{model:t.form,"label-width":"150px"}},[n("el-col",{attrs:{span:10}},[n("el-form-item",{attrs:{label:"姓名："}},[n("el-input",{model:{value:t.form.userName,callback:function(e){t.$set(t.form,"userName",e)},expression:"form.userName"}})],1)],1),t._v(" "),n("el-col",{attrs:{span:10}},[n("el-form-item",{attrs:{label:"单位："}},[n("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.company,callback:function(e){t.$set(t.form,"company",e)},expression:"form.company"}},[n("el-option",{attrs:{label:"单位1",value:"0"}}),t._v(" "),n("el-option",{attrs:{label:"单位2",value:"1"}})],1)],1)],1),t._v(" "),n("el-col",{attrs:{span:10}},[n("el-form-item",{attrs:{label:"报名状态："}},[n("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.bmStatus,callback:function(e){t.$set(t.form,"bmStatus",e)},expression:"form.bmStatus"}},[n("el-option",{attrs:{label:"已报名",value:"0"}}),t._v(" "),n("el-option",{attrs:{label:"未报名",value:"1"}})],1)],1)],1),t._v(" "),n("el-col",{attrs:{span:10}},[n("el-form-item",{attrs:{label:"参训状态："}},[n("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.cxStatus,callback:function(e){t.$set(t.form,"cxStatus",e)},expression:"form.cxStatus"}},[n("el-option",{attrs:{label:"已参训",value:"0"}}),t._v(" "),n("el-option",{attrs:{label:"延迟参训",value:"1"}})],1)],1)],1)],1)],1),t._v(" "),n("div",{staticStyle:{"text-align":"right","padding-right":"30px"}},[n("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")]),t._v(" "),n("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{size:"small",icon:"el-icon-refresh"},on:{click:t.reset}},[t._v("重置")])],1)],1),t._v(" "),n("div",{staticClass:"tabList"},[n("el-row",[n("el-col",{attrs:{span:24}},[n("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[n("el-table-column",{attrs:{prop:"id",label:"信息系统综合员",align:"center",width:"180"}},[[n("div",{staticClass:"ta-c"},[n("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),n("div",{staticClass:"ta-c"},[t._v("已参训"+t._s(t.cxNum)+"人")]),t._v(" "),n("div",{staticClass:"ta-c"},[t._v("需补课人数"+t._s(t.bkNum)+"人")])]],2),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{staticStyle:{cursor:"pointer"}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),n("el-table-column",{attrs:{prop:"yjs",align:"center",label:"已接收"}}),t._v(" "),n("el-table-column",{attrs:{prop:"wjs",align:"center",label:"未接收"}}),t._v(" "),n("el-table-column",{attrs:{prop:"sum",align:"center",label:"已报名"}}),t._v(" "),n("el-table-column",{attrs:{prop:"nsum",align:"center",label:"未报名"}}),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("div",{staticClass:"ta-c"},[n("span",{class:["labelBtn","0"!=e.row.isConfirm?"color_active":"color_default"]},[t._v(t._s("0"==e.row.isConfirm?"未确认":"确认"))])])]}}])})],1)],1)],1),t._v(" "),n("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)}}})],1)])},r=[],l=n("333d"),o=n("0fe1"),i={components:{Pagination:l["a"]},props:{infoId:{type:String,default:""}},data:function(){return{tableData:[],form:{userName:"",company:"",bmStatus:"",cxStatus:""},listQuery:{page:1,pagesize:10},total:0,bkNum:"",cxNum:"",confirm:""}},created:function(){this.getDateForJu()},methods:{objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,n=t.columnIndex;if(0===n)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},getDateForJu:function(){var t=this;Object(o["n"])({id:this.infoId}).then(function(e){t.tableData=e.data.listTotal,t.confirm=e.data.confirm,t.cxNum=e.data.ycx,t.bkNum=e.data.bk})},search:function(){},reset:function(){this.form=""},changeStatus:function(){}}},s=i,c=(n("9fd3"),n("2877")),u=Object(c["a"])(s,a,r,!1,null,"74dc07e2",null);e["default"]=u.exports},"0fe1":function(t,e,n){"use strict";n.d(e,"hb",function(){return r}),n.d(e,"d",function(){return l}),n.d(e,"o",function(){return o}),n.d(e,"jb",function(){return i}),n.d(e,"kb",function(){return s}),n.d(e,"H",function(){return c}),n.d(e,"r",function(){return u}),n.d(e,"R",function(){return p}),n.d(e,"S",function(){return d}),n.d(e,"a",function(){return f}),n.d(e,"n",function(){return m}),n.d(e,"ub",function(){return g}),n.d(e,"T",function(){return x}),n.d(e,"ib",function(){return b}),n.d(e,"I",function(){return h}),n.d(e,"m",function(){return v}),n.d(e,"e",function(){return j}),n.d(e,"f",function(){return _}),n.d(e,"i",function(){return w}),n.d(e,"tb",function(){return y}),n.d(e,"q",function(){return O}),n.d(e,"t",function(){return S}),n.d(e,"M",function(){return z}),n.d(e,"g",function(){return C}),n.d(e,"p",function(){return I}),n.d(e,"v",function(){return k}),n.d(e,"u",function(){return N}),n.d(e,"w",function(){return D}),n.d(e,"eb",function(){return L}),n.d(e,"db",function(){return F}),n.d(e,"B",function(){return P}),n.d(e,"A",function(){return $}),n.d(e,"C",function(){return q}),n.d(e,"ob",function(){return T}),n.d(e,"nb",function(){return B}),n.d(e,"cb",function(){return V}),n.d(e,"D",function(){return E}),n.d(e,"bb",function(){return J}),n.d(e,"ab",function(){return Q}),n.d(e,"Z",function(){return U}),n.d(e,"J",function(){return H}),n.d(e,"k",function(){return M}),n.d(e,"j",function(){return A}),n.d(e,"l",function(){return X}),n.d(e,"c",function(){return Z}),n.d(e,"b",function(){return W}),n.d(e,"O",function(){return Y}),n.d(e,"N",function(){return G}),n.d(e,"P",function(){return K}),n.d(e,"wb",function(){return R}),n.d(e,"vb",function(){return tt}),n.d(e,"y",function(){return et}),n.d(e,"x",function(){return nt}),n.d(e,"z",function(){return at}),n.d(e,"mb",function(){return rt}),n.d(e,"lb",function(){return lt}),n.d(e,"F",function(){return ot}),n.d(e,"E",function(){return it}),n.d(e,"G",function(){return st}),n.d(e,"sb",function(){return ct}),n.d(e,"rb",function(){return ut}),n.d(e,"Y",function(){return pt}),n.d(e,"X",function(){return dt}),n.d(e,"pb",function(){return ft}),n.d(e,"qb",function(){return mt}),n.d(e,"K",function(){return gt}),n.d(e,"L",function(){return xt}),n.d(e,"s",function(){return bt}),n.d(e,"gb",function(){return ht}),n.d(e,"fb",function(){return vt}),n.d(e,"U",function(){return jt}),n.d(e,"W",function(){return _t}),n.d(e,"V",function(){return wt}),n.d(e,"h",function(){return yt}),n.d(e,"Q",function(){return Ot});var a=n("b775");function r(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/xlglMeeting/createHuiYi",method:"post",params:t})}function o(){return Object(a["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function i(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function s(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getIsHavePerssion",method:"post",params:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function f(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function m(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function g(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/updateStatus",method:"post",data:t})}function x(t){return Object(a["a"])({url:"/app/xlgl/xlglconfirm/isHaveButton",method:"post",params:t})}function b(t){return Object(a["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function h(t){return Object(a["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function v(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function j(t){return Object(a["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:t})}function _(t){return Object(a["a"])({url:"/app/xlgl/xlglsubdocinfo/deleteZhu",method:"post",params:t})}function w(t){return Object(a["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:t})}function y(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"post",params:t})}function O(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function S(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function z(t){return Object(a["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}function C(t){return Object(a["a"])({url:"/app/xlgl/xlglktap/downLoad",method:"get",params:t})}function I(t){return Object(a["a"])({url:"/app/xlgl/xlglktap/info",method:"get",params:t})}function k(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/list",method:"post",params:t})}function N(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/info",method:"post",params:t})}function D(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/save",method:"post",params:t})}function L(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/update",method:"post",params:t})}function F(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonqueue/delete",method:"post",params:t})}function P(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/list",method:"post",params:t})}function $(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/info",method:"post",params:t})}function q(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/save",method:"post",params:t})}function T(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/update",method:"post",params:t})}function B(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonsports/delete",method:"post",params:t})}function V(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/save",method:"post",params:t})}function E(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/getSumCore",method:"post",params:t})}function J(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/list",method:"post",params:t})}function Q(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/info",method:"post",params:t})}function U(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/delete",method:"post",params:t})}function H(t){return Object(a["a"])({url:"/app/xlgl/xlglphysical/getUserInfo",method:"get",params:t})}function M(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/list",method:"post",params:t})}function A(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/info",method:"post",params:t})}function X(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/save",method:"post",params:t})}function Z(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/update",method:"post",params:t})}function W(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/delete",method:"post",params:t})}function Y(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/list",method:"post",params:t})}function G(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/info",method:"post",params:t})}function K(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/save",method:"post",params:t})}function R(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/update",method:"post",params:t})}function tt(t){return Object(a["a"])({url:"/app/xlgl/xlglwarcommonweapon/delete",method:"post",params:t})}function et(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/list",method:"post",params:t})}function nt(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/info",method:"post",params:t})}function at(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/save",method:"post",params:t})}function rt(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/update",method:"post",params:t})}function lt(t){return Object(a["a"])({url:"/app/xlgl/xlglwarspecialty/delete",method:"post",params:t})}function ot(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/list",method:"post",params:t})}function it(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/info",method:"post",params:t})}function st(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/save",method:"post",params:t})}function ct(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/update",method:"post",params:t})}function ut(t){return Object(a["a"])({url:"/app/xlgl/xlglwartactic/delete",method:"post",params:t})}function pt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/list",method:"post",params:t})}function dt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/count",method:"post",params:t})}function ft(t){return Object(a["a"])({url:"/app/xlgl/personalfile/subjectList",method:"post",params:t})}function mt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/subjectTitle",method:"post",params:t})}function gt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/getUserPerXlInfo",method:"post",params:t})}function xt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/getUserPerZxInfo",method:"post",params:t})}function bt(t){return Object(a["a"])({url:"/app/base/dept/tree_onlyroot",method:"get",params:t})}function ht(t){return Object(a["a"])({url:"/app/xlgl/xlglphysicalrecord/list",method:"get",params:t})}function vt(t){return Object(a["a"])({url:"/app/xlgl/xlglphysicalrecord/delete",method:"get",params:t})}function jt(t){return Object(a["a"])({url:"app/base/dept/tree_onlyroot",method:"get",params:t})}function _t(t){return Object(a["a"])({url:"/app/xlgl/xlglstudyrecord/list",method:"get",params:t})}function wt(t){return Object(a["a"])({url:"/app/xlgl/xlglstudyrecord/delete",method:"get",params:t})}function yt(t){return Object(a["a"])({url:"/app/xlgl/personalfile/getAllDeptInfo",method:"get",params:t})}function Ot(t){return Object(a["a"])({url:"/app/xlgl/xlgldocumentzbjl/getXlCoreList",method:"get",params:t})}},"67e6":function(t,e,n){},"9fd3":function(t,e,n){"use strict";var a=n("b177"),r=n.n(a);r.a},b177:function(t,e,n){},d052:function(t,e,n){"use strict";var a=n("67e6"),r=n.n(a);r.a},e3f3:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("el-row",{attrs:{gutter:10}},[n("el-col",{attrs:{span:19}},[n("div",{staticClass:"container"},[n("div",{staticClass:"header"},[n("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),n("el-row",[n("el-col",{attrs:{span:8}},[n("span",[t._v("时间：")]),t._v(" "),n("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),n("el-col",{staticStyle:{"text-align":"center"},attrs:{span:8}},[n("span",[t._v("类型：")]),t._v(" "),n("span",[t._v("强装兴装大讲堂")])]),t._v(" "),n("el-col",{staticStyle:{"text-align":"right"},attrs:{span:8}},[n("span",[t._v("播放次数：")]),t._v(" "),n("span",[t._v("168次")])])],1),t._v(" "),n("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureId,expression:"pictureId"}],staticStyle:{"margin-top":"20px"}},[n("el-col",{attrs:{span:24}},[n("div",[n("video",{staticStyle:{height:"500px"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.pictureId,controls:"controls"}})])])],1)])]),t._v(" "),n("el-col",{attrs:{span:5}},[n("el-row",[n("el-col",{attrs:{span:24}},[n("div",{staticClass:"statistics"},[n("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[n("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),n("p",{staticStyle:{"margin-left":"10px"}},[n("span",[t._v("参训完成率")]),n("br"),t._v(" "),n("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),n("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("100%")])]),t._v(" "),n("div",{staticClass:"peopleNum"},[n("div",{staticClass:"flex-center",staticStyle:{padding:"0 20px"}},[n("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[n("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),n("p",{staticStyle:{"margin-left":"10px"}},[n("span",[t._v("合计人数")]),n("br"),t._v(" "),n("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("在编人数统计")])])],1),t._v(" "),n("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("320")])]),t._v(" "),n("div",{staticClass:"flex-center",staticStyle:{"border-top":"1px solid #ccc",padding:"10px"}},[n("div",{staticStyle:{flex:"1","border-right":"1px solid #ccc","text-align":"center",height:"40px","line-height":"40px"}},[n("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("已参训")]),t._v("    \n                "),n("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v("300")])]),t._v(" "),n("div",{staticStyle:{flex:"1","text-align":"center",height:"40px","line-height":"40px"}},[n("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("缺席")]),t._v("    \n                "),n("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v("24")])])]),t._v(" "),n("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.showView}},[t._v("查看详情 ＞")])]),t._v(" "),n("div",{staticClass:"statistics"},[n("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[n("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),n("p",{staticStyle:{"margin-left":"10px"}},[n("span",[t._v("各单位年度参训完成情况")]),n("br"),t._v(" "),n("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),n("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])]),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureList.length>0,expression:"pictureList.length>0"}],staticStyle:{background:"#fff","border-radius":"5px","padding-bottom":"5px"}},[n("title-card",{attrs:{"title-text":"附件资料"}}),t._v(" "),t._l(t.pictureList,function(e,a){return n("div",{key:a},[n("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","align-items":"center"}},[n("svg-icon",{staticClass:"icon",attrs:{"icon-class":"affix"}}),t._v(" "),n("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)])})],2)])],1)],1)],1),t._v(" "),n("el-dialog",{attrs:{title:"人员参训情况清单",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[n("auditoriumList",{attrs:{"info-id":t.infoId}})],1)],1)},r=[],l=n("09a0"),o=n("35b7"),i=n("0fe1"),s={components:{auditoriumList:l["default"],TitleCard:o["a"]},props:{infoId:{type:String,default:""},videoId:{type:String,default:""}},data:function(){return{dialogFormVisible:!1,fileId:"",title:"",pictureId:"",exerciseTime:"",pictureList:[]}},created:function(){this.getPerData(),this.getInfo()},methods:{getPerData:function(){Object(i["t"])({fileId:this.infoId}).then(function(t){})},getInfo:function(){var t=this;Object(i["q"])({infoId:this.infoId,id:this.videoId}).then(function(e){t.title=e.data.title,t.exerciseTime=e.data.time,t.pictureId=e.data.xlglPicture?e.data.xlglPicture.pictureId:"",t.pictureList=e.data.list})},back:function(){this.$emit("back")},showView:function(){this.dialogFormVisible=!0},showChart:function(){}}},c=s,u=(n("d052"),n("2877")),p=Object(u["a"])(c,a,r,!1,null,"9946a712",null);e["default"]=p.exports}}]);