(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-729b37a0","chunk-0308c41f","chunk-2d210108"],{"09a0":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{overflow:"scroll"}},[a("div",{staticClass:"search-content"},[a("el-row",{attrs:{span:24}},[a("el-form",{attrs:{model:t.form,"label-width":"150px"}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"姓名："}},[a("el-input",{model:{value:t.form.userName,callback:function(e){t.$set(t.form,"userName",e)},expression:"form.userName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"单位："}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.company,callback:function(e){t.$set(t.form,"company",e)},expression:"form.company"}},[a("el-option",{attrs:{label:"单位1",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"单位2",value:"1"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"报名状态："}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.bmStatus,callback:function(e){t.$set(t.form,"bmStatus",e)},expression:"form.bmStatus"}},[a("el-option",{attrs:{label:"已报名",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"未报名",value:"1"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"参训状态："}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.cxStatus,callback:function(e){t.$set(t.form,"cxStatus",e)},expression:"form.cxStatus"}},[a("el-option",{attrs:{label:"已参训",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"延迟参训",value:"1"}})],1)],1)],1)],1)],1),t._v(" "),a("div",{staticStyle:{"text-align":"right","padding-right":"30px"}},[a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")]),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{size:"small",icon:"el-icon-refresh"},on:{click:t.reset}},[t._v("重置")])],1)],1),t._v(" "),a("div",{staticClass:"tabList"},[a("el-row",[a("el-col",{attrs:{span:24}},[a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[a("el-table-column",{attrs:{prop:"id",label:"信息系统综合员",align:"center",width:"180"}},[[a("div",{staticClass:"ta-c"},[a("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),a("div",{staticClass:"ta-c"},[t._v("已参训"+t._s(t.cxNum)+"人")]),t._v(" "),a("div",{staticClass:"ta-c"},[t._v("需补课人数"+t._s(t.bkNum)+"人")])]],2),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticStyle:{cursor:"pointer"}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"yjs",align:"center",label:"已接收"}}),t._v(" "),a("el-table-column",{attrs:{prop:"wjs",align:"center",label:"未接收"}}),t._v(" "),a("el-table-column",{attrs:{prop:"sum",align:"center",label:"已报名"}}),t._v(" "),a("el-table-column",{attrs:{prop:"nsum",align:"center",label:"未报名"}}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("div",{staticClass:"ta-c"},[a("span",{class:["labelBtn","0"!=e.row.isConfirm?"color_active":"color_default"]},[t._v(t._s("0"==e.row.isConfirm?"未确认":"确认"))])])]}}])})],1)],1)],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)}}})],1)])},r=[],l=a("333d"),o=a("0fe1"),i={components:{Pagination:l["a"]},props:{infoId:{type:String,default:""}},data:function(){return{tableData:[],form:{userName:"",company:"",bmStatus:"",cxStatus:""},listQuery:{page:1,pagesize:10},total:0,bkNum:"",cxNum:"",confirm:""}},created:function(){this.getDateForJu()},methods:{objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,a=t.columnIndex;if(0===a)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},getDateForJu:function(){var t=this;Object(o["q"])({id:this.infoId}).then(function(e){t.tableData=e.data.listTotal,t.confirm=e.data.confirm,t.cxNum=e.data.ycx,t.bkNum=e.data.bk})},search:function(){},reset:function(){this.form=""},changeStatus:function(){}}},s=i,c=(a("9fd3"),a("2877")),u=Object(c["a"])(s,n,r,!1,null,"74dc07e2",null);e["default"]=u.exports},"0fe1":function(t,e,a){"use strict";a.d(e,"jb",function(){return r}),a.d(e,"d",function(){return l}),a.d(e,"r",function(){return o}),a.d(e,"lb",function(){return i}),a.d(e,"mb",function(){return s}),a.d(e,"K",function(){return c}),a.d(e,"u",function(){return u}),a.d(e,"U",function(){return p}),a.d(e,"V",function(){return d}),a.d(e,"j",function(){return f}),a.d(e,"a",function(){return m}),a.d(e,"p",function(){return g}),a.d(e,"q",function(){return x}),a.d(e,"wb",function(){return h}),a.d(e,"W",function(){return b}),a.d(e,"zb",function(){return v}),a.d(e,"kb",function(){return y}),a.d(e,"L",function(){return w}),a.d(e,"o",function(){return j}),a.d(e,"e",function(){return _}),a.d(e,"f",function(){return O}),a.d(e,"k",function(){return S}),a.d(e,"vb",function(){return z}),a.d(e,"t",function(){return C}),a.d(e,"w",function(){return D}),a.d(e,"h",function(){return I}),a.d(e,"P",function(){return k}),a.d(e,"g",function(){return N}),a.d(e,"s",function(){return L}),a.d(e,"y",function(){return A}),a.d(e,"x",function(){return F}),a.d(e,"z",function(){return T}),a.d(e,"gb",function(){return $}),a.d(e,"fb",function(){return B}),a.d(e,"E",function(){return P}),a.d(e,"D",function(){return q}),a.d(e,"F",function(){return E}),a.d(e,"qb",function(){return R}),a.d(e,"pb",function(){return V}),a.d(e,"eb",function(){return J}),a.d(e,"G",function(){return Q}),a.d(e,"db",function(){return U}),a.d(e,"cb",function(){return H}),a.d(e,"bb",function(){return M}),a.d(e,"M",function(){return W}),a.d(e,"m",function(){return X}),a.d(e,"l",function(){return Z}),a.d(e,"n",function(){return G}),a.d(e,"c",function(){return Y}),a.d(e,"b",function(){return K}),a.d(e,"R",function(){return tt}),a.d(e,"Q",function(){return et}),a.d(e,"S",function(){return at}),a.d(e,"yb",function(){return nt}),a.d(e,"xb",function(){return rt}),a.d(e,"B",function(){return lt}),a.d(e,"A",function(){return ot}),a.d(e,"C",function(){return it}),a.d(e,"ob",function(){return st}),a.d(e,"nb",function(){return ct}),a.d(e,"I",function(){return ut}),a.d(e,"H",function(){return pt}),a.d(e,"J",function(){return dt}),a.d(e,"ub",function(){return ft}),a.d(e,"tb",function(){return mt}),a.d(e,"ab",function(){return gt}),a.d(e,"Z",function(){return xt}),a.d(e,"rb",function(){return ht}),a.d(e,"sb",function(){return bt}),a.d(e,"N",function(){return vt}),a.d(e,"O",function(){return yt}),a.d(e,"v",function(){return wt}),a.d(e,"ib",function(){return jt}),a.d(e,"hb",function(){return _t}),a.d(e,"Y",function(){return Ot}),a.d(e,"X",function(){return St}),a.d(e,"i",function(){return zt}),a.d(e,"T",function(){return Ct});var n=a("b775");function r(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function l(t){return Object(n["a"])({url:"/app/xlgl/xlglMeeting/createHuiYi",method:"post",params:t})}function o(){return Object(n["a"])({url:"/app/base/dept/tree_onlyroot",method:"post"})}function i(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function s(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/sendToUsers",method:"post",params:t})}function c(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/info",method:"post",params:t})}function u(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getIsHavePerssion",method:"post",params:t})}function p(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function d(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function f(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/list ",method:"post",params:t})}function m(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function g(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForAll",method:"post",params:t})}function x(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function h(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/updateStatus",method:"post",data:t})}function b(t){return Object(n["a"])({url:"/app/xlgl/xlglconfirm/isHaveButton",method:"post",params:t})}function v(t){return Object(n["a"])({url:"/app/xlgl/xlglconfirm/xlglConfirm",method:"post",params:t})}function y(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function w(t){return Object(n["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function j(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function _(t){return Object(n["a"])({url:"/app/xlgl/xlglsubdocinfo/delete",method:"post",params:t})}function O(t){return Object(n["a"])({url:"/app/xlgl/xlglsubdocinfo/deleteZhu",method:"post",params:t})}function S(t){return Object(n["a"])({url:"/app/xlgl/adminset/getAuthor",method:"get",params:t})}function z(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"post",params:t})}function C(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function D(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function I(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getAllDeptDoneInfo",method:"post",params:t})}function k(t){return Object(n["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}function N(t){return Object(n["a"])({url:"/app/xlgl/xlglktap/downLoad",method:"get",params:t})}function L(t){return Object(n["a"])({url:"/app/xlgl/xlglktap/info",method:"get",params:t})}function A(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/list",method:"post",params:t})}function F(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/info",method:"post",params:t})}function T(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/save",method:"post",params:t})}function $(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/update",method:"post",params:t})}function B(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonqueue/delete",method:"post",params:t})}function P(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/list",method:"post",params:t})}function q(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/info",method:"post",params:t})}function E(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/save",method:"post",params:t})}function R(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/update",method:"post",params:t})}function V(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonsports/delete",method:"post",params:t})}function J(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/save",method:"post",params:t})}function Q(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/getSumCore",method:"post",params:t})}function U(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/list",method:"post",params:t})}function H(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/info",method:"post",params:t})}function M(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/delete",method:"post",params:t})}function W(t){return Object(n["a"])({url:"/app/xlgl/xlglphysical/getUserInfo",method:"get",params:t})}function X(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/list",method:"post",params:t})}function Z(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/info",method:"post",params:t})}function G(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/save",method:"post",params:t})}function Y(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/update",method:"post",params:t})}function K(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonwarbasis/delete",method:"post",params:t})}function tt(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/list",method:"post",params:t})}function et(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/info",method:"post",params:t})}function at(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/save",method:"post",params:t})}function nt(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/update",method:"post",params:t})}function rt(t){return Object(n["a"])({url:"/app/xlgl/xlglwarcommonweapon/delete",method:"post",params:t})}function lt(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/list",method:"post",params:t})}function ot(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/info",method:"post",params:t})}function it(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/save",method:"post",params:t})}function st(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/update",method:"post",params:t})}function ct(t){return Object(n["a"])({url:"/app/xlgl/xlglwarspecialty/delete",method:"post",params:t})}function ut(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/list",method:"post",params:t})}function pt(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/info",method:"post",params:t})}function dt(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/save",method:"post",params:t})}function ft(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/update",method:"post",params:t})}function mt(t){return Object(n["a"])({url:"/app/xlgl/xlglwartactic/delete",method:"post",params:t})}function gt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/list",method:"post",params:t})}function xt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/count",method:"post",params:t})}function ht(t){return Object(n["a"])({url:"/app/xlgl/personalfile/subjectList",method:"post",params:t})}function bt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/subjectTitle",method:"post",params:t})}function vt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/getUserPerXlInfo",method:"post",params:t})}function yt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/getUserPerZxInfo",method:"post",params:t})}function wt(t){return Object(n["a"])({url:"/app/base/dept/tree_onlyroot",method:"get",params:t})}function jt(t){return Object(n["a"])({url:"/app/xlgl/xlglphysicalrecord/list",method:"get",params:t})}function _t(t){return Object(n["a"])({url:"/app/xlgl/xlglphysicalrecord/delete",method:"get",params:t})}function Ot(t){return Object(n["a"])({url:"/app/xlgl/xlglstudyrecord/list",method:"get",params:t})}function St(t){return Object(n["a"])({url:"/app/xlgl/xlglstudyrecord/delete",method:"get",params:t})}function zt(t){return Object(n["a"])({url:"/app/xlgl/personalfile/getAllDeptInfo",method:"get",params:t})}function Ct(t){return Object(n["a"])({url:"/app/xlgl/xlgldocumentzbjl/getXlCoreList",method:"get",params:t})}},"9fd3":function(t,e,a){"use strict";var n=a("b177"),r=a.n(n);r.a},afe8:function(t,e,a){},b177:function(t,e,a){},b5fe:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{class:t.className,style:{height:t.height,width:t.width}})},r=[],l=a("313e"),o=a.n(l),i=a("a7dc");a("817d");var s=6e3,c={mixins:[i["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0},chartTitle:{type:String,default:""}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){for(var e=0;e<t.length;e++)this.xData.push(t[e].departName),this.yData.push(t[e].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=o.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:this.chartTitle,subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",data:this.xData,axisTick:{show:!1},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},rotate:20}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new o.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:s}]})}}},u=c,p=a("2877"),d=Object(p["a"])(u,n,r,!1,null,null,null);e["default"]=d.exports},dc4b:function(t,e,a){"use strict";var n=a("afe8"),r=a.n(n);r.a},e3f3:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:19}},[a("div",{staticClass:"container"},[a("div",{staticClass:"header"},[a("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:8}},[a("span",[t._v("时间：")]),t._v(" "),a("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:8}},[a("span",[t._v("类型：")]),t._v(" "),a("span",[t._v("强装兴装大讲堂")])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"right"},attrs:{span:8}},[a("span",[t._v("播放次数：")]),t._v(" "),a("span",[t._v("168次")])])],1),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureId,expression:"pictureId"}],staticStyle:{"margin-top":"20px"}},[a("el-col",{attrs:{span:24}},[a("div",[a("video",{staticStyle:{height:"500px"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.pictureId,controls:"controls"}})])])],1)])]),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-row",[a("el-col",{attrs:{span:24}},[a("div",{staticClass:"statistics"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("参训完成率")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("100%")])]),t._v(" "),a("div",{staticClass:"peopleNum"},[a("div",{staticClass:"flex-center",staticStyle:{padding:"0 20px"}},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("合计人数")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("在编人数统计")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("320")])]),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"border-top":"1px solid #ccc",padding:"10px"}},[a("div",{staticStyle:{flex:"1","border-right":"1px solid #ccc","text-align":"center",height:"40px","line-height":"40px"}},[a("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("已参训")]),t._v("    \n                "),a("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v("300")])]),t._v(" "),a("div",{staticStyle:{flex:"1","text-align":"center",height:"40px","line-height":"40px"}},[a("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("缺席")]),t._v("    \n                "),a("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v("24")])])]),t._v(" "),a("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.showView}},[t._v("查看详情 ＞")])]),t._v(" "),a("div",{staticClass:"statistics"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("各单位年度参训完成情况")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureList.length>0,expression:"pictureList.length>0"}],staticStyle:{background:"#fff","border-radius":"5px","padding-bottom":"5px"}},[a("title-card",{attrs:{"title-text":"附件资料"}}),t._v(" "),t._l(t.pictureList,function(e,n){return a("div",{key:n},[a("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",attrs:{"icon-class":"affix"}}),t._v(" "),a("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)])})],2)])],1)],1)],1),t._v(" "),a("el-dialog",{attrs:{title:"人员参训情况清单",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("auditoriumList",{attrs:{"info-id":t.infoId}})],1),t._v(" "),a("el-dialog",{attrs:{title:"各单位训练完成率统计",visible:t.dialogchart},on:{"update:visible":function(e){t.dialogchart=e}}},[a("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)],1)},r=[],l=(a("7f7f"),a("ac6a"),a("09a0")),o=a("35b7"),i=a("b5fe"),s=a("0fe1"),c={components:{auditoriumList:l["default"],TitleCard:o["a"],FinishRate:i["default"]},props:{infoId:{type:String,default:""},videoId:{type:String,default:""}},data:function(){return{dialogFormVisible:!1,dialogchart:!1,fileId:"",title:"",pictureId:"",exerciseTime:"",pictureList:[],finishRateList:[]}},created:function(){this.getPerData(),this.getInfo()},methods:{getPerData:function(){Object(s["w"])({fileId:this.infoId}).then(function(t){})},getInfo:function(){var t=this;Object(s["t"])({infoId:this.infoId,id:this.videoId}).then(function(e){t.title=e.data.title,t.exerciseTime=e.data.time,t.pictureId=e.data.xlglPicture?e.data.xlglPicture.pictureId:"",t.pictureList=e.data.list})},back:function(){this.$emit("back")},showView:function(){this.dialogFormVisible=!0},showChart:function(){var t=this;this.dialogchart=!0,Object(s["h"])({infoId:this.infoId}).then(function(e){"success"===e.data.result&&e.data.list.forEach(function(e,a){t.finishRateList.push({departName:e.name,value:e.wcl})})})}}},u=c,p=(a("dc4b"),a("2877")),d=Object(p["a"])(u,n,r,!1,null,"41bf8ae4",null);e["default"]=d.exports}}]);