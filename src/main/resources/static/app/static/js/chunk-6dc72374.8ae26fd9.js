(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6dc72374","chunk-3ca2fd7e","chunk-07c26ee6","chunk-2d2311d5"],{"22f1":function(t,s,e){},2378:function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticStyle:{width:"1400px",height:"720px"},attrs:{id:"myChinaMap"}})},i=[],l=(e("7f7f"),e("313e")),r=e.n(l),n=e("eeba"),o=e.n(n);e("3139");var c={props:{dataNum:{type:Array,default:function(){return[]}}},data:function(){return{chart:null}},watch:{dataNum:{deep:!0,handler:function(){this.initChart()}}},mounted:function(){this.$nextTick(function(){this.initChart()})},methods:{initChart:function(){var t=this;this.chart=r.a.init(this.$el,"china"),this.chart.setOption({tooltip:{trigger:"item"},selectedMode:"single",dataRange:{splitList:[{start:500,color:"#EF5366"},{start:301,end:500,color:"#F86F1A"},{start:101,end:300,color:"#53D591"},{start:1,end:100,color:"#65BBFF"},{end:1,color:"#ccc"}],textStyle:{color:"#3899FF"}},series:[{name:"人员分布情况",type:"map",zoom:1.2,map:"china",itemStyle:{normal:{label:{show:!0},color:"#53D591",areaColor:"#eff6ff"},emphasis:{label:{show:!0},areaColor:"#cbe2ff"}},showLegendSymbol:!1,roam:!0,markPoint:{data:[{coord:[116.46,39.92]}],symbolSize:[20,20],symbol:"image://".concat(o.a)},label:{normal:{show:!0},emphasis:{show:!0}},data:this.dataNum}]}),this.chart.on("click",function(s){s.value&&t.$emit("mapClick",s.name)})}}},p=c,u=e("2877"),d=Object(u["a"])(p,a,i,!1,null,null,null);s["default"]=d.exports},"2cae":function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"posRel",attrs:{id:"container"}},["1"===t.showPage?e("div",[e("el-card",{staticStyle:{height:"calc(98vh - 15px)",margin:"10px"},attrs:{"body-style":{padding:"0px 10px"}}},[e("el-button",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName === 'first'"}],staticClass:"iconRefresh",attrs:{type:"primary",size:"mini"},on:{click:t.refreshFn}},[t._v("刷新")]),t._v(" "),e("el-tabs",{model:{value:t.activeName,callback:function(s){t.activeName=s},expression:"activeName"}},[e("el-tab-pane",{attrs:{label:t.labelText,name:"first"}},[e("ul",{staticClass:"peopleNum bor-bottom",attrs:{id:"zxlRate"}},[e("li",{staticClass:"ma-b_20"},[e("p",{staticClass:"fs-30 color_default pd-t_20"},[t._v(t._s(t.userAllYx))]),t._v(" "),e("p",{staticClass:"pd-t_30"},[t._v("办公平台注册人数")])]),t._v(" "),e("li",{staticClass:"ma-b_20"},[e("p",{staticClass:"fs-30 color_yellow pd-t_20"},[t._v(t._s(t.userShouldNumber))]),t._v(" "),e("p",{staticClass:"pd-t_30"},[t._v("应在线人数")])]),t._v(" "),e("li",{staticClass:"ma-b_20"},[e("p",{staticClass:"fs-30 color_green pd-t_20"},[t._v(t._s(t.userIdList))]),t._v(" "),e("p",{staticClass:"pd-t_30"},[t._v("在线人数")])]),t._v(" "),e("li",{staticClass:"ma-b_20"},[e("p",[e("el-progress",{attrs:{type:"circle",percentage:t.zwlv-0,"stroke-width":9,width:80}})],1),t._v(" "),e("p",{staticStyle:{"padding-top":"3px"}},[t._v("在线率")])]),t._v(" "),e("li",{staticClass:"ma-b_20"},[e("p",{staticClass:"fs-30 color_orange pd-t_20"},[t._v(t._s(t.qjNum))]),t._v(" "),e("p",{staticClass:"pd-t_30"},[t._v("请假人数")])]),t._v(" "),e("li",{staticClass:"ma-b_20"},[e("p",{staticClass:"fs-30 color_blue pd-t_20"},[t._v(t._s(t.otherPlacesNum))]),t._v(" "),e("p",{staticClass:"pd-t_30"},[t._v("京外人数")])])]),t._v(" "),e("el-row",{attrs:{gutter:20}},[e("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager||t.roleFlag,expression:"isManager === '1' || roleFlag"}],attrs:{span:3}},[e("div",{staticClass:"organTree",staticStyle:{height:"calc(72vh - 5px)"}},[e("div",{staticStyle:{height:"40px","line-height":"40px","padding-left":"15px"}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px"},attrs:{"icon-class":"mulu"}})],1),t._v(" "),e("ul",[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"600px"}},t._l(t.treeList,function(s,a){return e("li",{key:a,class:[a===t.ins?"active":"pd-l_30"],attrs:{title:s.name},on:{click:function(e){return t.changeOrgan(a,s)}}},[t._v(t._s(s.name.length>10?s.name.substr(0,10):s.name))])}),0)],1)])]),t._v(" "),e("el-col",{attrs:{span:t.spanVal}},[e("el-row",[e("el-col",{attrs:{span:7}},[e("div",{staticClass:"flexCenter",staticStyle:{height:"32px"}},[e("div",{staticClass:"flexCenter"},[e("span",{staticClass:"legends",staticStyle:{background:"#53D591"}}),t._v(" "),e("span",{staticClass:"ma-l_10 fs-14"},[t._v("在线")])]),t._v(" "),e("div",{staticClass:"flexCenter ma-l_25"},[e("span",{staticClass:"legends",staticStyle:{background:"#FE8A44"}}),t._v(" "),e("span",{staticClass:"ma-l_10 fs-14"},[t._v("因私请假")])]),t._v(" "),e("div",{staticClass:"flexCenter ma-l_25"},[e("span",{staticClass:"legends",staticStyle:{background:"#65BBFF"}}),t._v(" "),e("span",{staticClass:"ma-l_10 fs-14"},[t._v("因公出差")])]),t._v(" "),e("div",{staticClass:"flexCenter ma-l_25"},[e("span",{staticClass:"legends",staticStyle:{background:"#EF5366"}}),t._v(" "),e("span",{staticClass:"ma-l_10 fs-14"},[t._v("异常")])])])]),t._v(" "),e("el-col",{staticStyle:{"text-align":"right"},attrs:{span:17}},[e("el-select",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{placeholder:t.placeholderVal,size:"small",clearable:""},on:{change:t.screenOrgan},model:{value:t.listQuery.organId,callback:function(s){t.$set(t.listQuery,"organId",s)},expression:"listQuery.organId"}},t._l(t.organTree_list,function(t,s){return e("el-option",{key:s,attrs:{label:t.name,value:t.id}})}),1),t._v(" "),e("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入人员姓名",clearable:""},on:{clear:t.clearFn},nativeOn:{keyup:function(s){return!s.type.indexOf("key")&&t._k(s.keyCode,"enter",13,s.key,"Enter")?null:t.search(s)}},model:{value:t.listQuery.userName,callback:function(s){t.$set(t.listQuery,"userName",s)},expression:"listQuery.userName"}}),t._v(" "),e("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.searchFn}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"sousuo"}}),t._v("\n                    查询\n                  ")],1),t._v(" "),e("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFn}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"daochu"}}),t._v("\n                    导出\n                  ")],1)],1)],1),t._v(" "),e("el-row",[e("ul",{staticClass:"peopleNum bor_1_fe6",staticStyle:{padding:"10px 0"},attrs:{id:"zxlRate1"}},[e("li",[e("p",{staticClass:"fs-20 color_default pd-t_15"},[t._v(t._s(t.userAllYxJu))]),t._v(" "),e("p",{staticClass:"pd-t_15 fs-14"},[t._v("注册人数")])]),t._v(" "),e("li",[e("p",{staticClass:"fs-20 color_yellow pd-t_15"},[t._v(t._s(t.userShouldNumberJu))]),t._v(" "),e("p",{staticClass:"pd-t_15 fs-14"},[t._v("应在线人数")])]),t._v(" "),e("li",[e("p",{staticClass:"fs-20 color_green pd-t_15"},[t._v(t._s(t.userIdListJu))]),t._v(" "),e("p",{staticClass:"pd-t_15 fs-14"},[t._v("在线人数")])]),t._v(" "),e("li",[e("p",[e("el-progress",{attrs:{type:"circle",percentage:t.zwlvJu-0,"stroke-width":4,width:50}})],1),t._v(" "),e("p",{staticClass:"fs-14",staticStyle:{"padding-top":"2px"}},[t._v("在线率")])]),t._v(" "),e("li",[e("p",{staticClass:"fs-20 color_orange pd-t_15"},[t._v(t._s(t.qjNumJu))]),t._v(" "),e("p",{staticClass:"pd-t_15 fs-14"},[t._v("请假人数")])]),t._v(" "),e("li",[e("p",{staticClass:"fs-20 color_blue pd-t_15"},[t._v(t._s(t.otherPlacesNumJu))]),t._v(" "),e("p",{staticClass:"pd-t_15 fs-14"},[t._v("京外人数")])])])]),t._v(" "),e("el-row",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}]},[e("el-col",{staticClass:"elColStyle",attrs:{span:24}},[e("el-scrollbar",{staticClass:"hidden-x"},[e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:8}},t._l(t.personList1,function(s,a){return e("div",{key:a,class:[0!==a?"ma-t_20":""]},[e("div",{staticClass:"cardBox"},[e("div",{staticClass:"cardTitle"},[t._v(t._s(s.name))]),t._v(" "),e("ul",{staticClass:"flexCenter"},[e("li",[e("p",{staticClass:"color_default fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zcrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("注册人数")])]),t._v(" "),e("li",[e("p",{staticClass:"color_yellow fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.yzxrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("应在线人数")])]),t._v(" "),e("li",[e("p",{staticClass:"color_green fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zxrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("在线人数")])])]),t._v(" "),e("el-row",{attrs:{gutter:20}},t._l(s.list,function(s,a){return e("el-col",{key:a,class:[a>2?"ma-t_10":""],attrs:{span:8}},[e("div",[e("el-popover",{attrs:{placement:"bottom-start",width:"250","visible-arrow":t.visibleArrow,trigger:"hover"}},[e("div",{staticClass:"cardTip"},[e("p",[e("span",{staticClass:"fs-14_default"},[t._v("姓       名：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.fullname?s.fullname:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("在线状态：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.status?s.status:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("部 职 别：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.post?s.post:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("手 机 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.mobile?s.mobile:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("房 间 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.address?s.address:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("座 机 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.telephone?s.telephone:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("应       休：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJtotalDays?s.qXJtotalDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("已       休：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJxiuJiaDays?s.qXJxiuJiaDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("本月在线天数：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisMonthDays?s.thisMonthDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("累计在线天数：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisYearDays?s.thisYearDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("当前所在省市：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJcities?s.qXJcities:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("具体位置：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJaddress?s.qXJaddress:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("事       由：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJmatters?s.qXJmatters:"--"))])])]),t._v(" "),e("div",{class:["btnStyle","color"+s.isShow,"1"===s.isSelect?"selectStyle":""],attrs:{slot:"reference"},slot:"reference"},[t._v(t._s(s.fullname))])])],1)])}),1)],1)])}),0),t._v(" "),e("el-col",{attrs:{span:8}},t._l(t.personList2,function(s,a){return e("div",{key:a,class:[0!==a?"ma-t_20":""]},[e("div",{staticClass:"cardBox"},[e("div",{staticClass:"cardTitle"},[t._v(t._s(s.name))]),t._v(" "),e("ul",{staticClass:"flexCenter"},[e("li",[e("p",{staticClass:"color_default fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zcrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("注册人数")])]),t._v(" "),e("li",[e("p",{staticClass:"color_yellow fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.yzxrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("应在线人数")])]),t._v(" "),e("li",[e("p",{staticClass:"color_green fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zxrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("在线人数")])])]),t._v(" "),e("el-row",{attrs:{gutter:20}},t._l(s.list,function(s,a){return e("el-col",{key:a,class:[a>2?"ma-t_10":""],attrs:{span:8}},[e("div",[e("el-popover",{attrs:{placement:"bottom-start",width:"250","visible-arrow":t.visibleArrow,trigger:"hover"}},[e("div",{staticClass:"cardTip"},[e("p",[e("span",{staticClass:"fs-14_default"},[t._v("姓       名：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.fullname?s.fullname:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("在线状态：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.status?s.status:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("部 职 别：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.post?s.post:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("手 机 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.mobile?s.mobile:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("房 间 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.address?s.address:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("座 机 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.telephone?s.telephone:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("应       休：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJtotalDays?s.qXJtotalDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("已       休：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJxiuJiaDays?s.qXJxiuJiaDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("本月在线天数：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisMonthDays?s.thisMonthDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("累计在线天数：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisYearDays?s.thisYearDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("当前所在省市：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJcities?s.qXJcities:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("具体位置：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJaddress?s.qXJaddress:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("事       由：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.qXJmatters?s.qXJmatters:"--"))])])]),t._v(" "),e("div",{class:["btnStyle","color"+s.isShow,"1"===s.isSelect?"selectStyle":""],attrs:{slot:"reference"},slot:"reference"},[t._v(t._s(s.fullname))])])],1)])}),1)],1)])}),0),t._v(" "),e("el-col",{attrs:{span:8}},t._l(t.personList3,function(s,a){return e("div",{key:a,class:[0!==a?"ma-t_20":""]},[e("div",{staticClass:"cardBox"},[e("div",{staticClass:"cardTitle"},[t._v(t._s(s.name))]),t._v(" "),e("ul",{staticClass:"flexCenter"},[e("li",[e("p",{staticClass:"color_default fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zcrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("注册人数")])]),t._v(" "),e("li",[e("p",{staticClass:"color_yellow fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.yzxrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("应在线人数")])]),t._v(" "),e("li",[e("p",{staticClass:"color_green fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zxrs))]),t._v(" "),e("p",{staticClass:"fs-14"},[t._v("在线人数")])])]),t._v(" "),e("el-row",{attrs:{gutter:20}},t._l(s.list,function(s,a){return e("el-col",{key:a,class:[a>2?"ma-t_10":""],attrs:{span:8}},[e("div",[e("el-popover",{attrs:{placement:"bottom-start",width:"250","visible-arrow":t.visibleArrow,trigger:"hover"}},[e("div",{staticClass:"cardTip"},[e("p",[e("span",{staticClass:"fs-14_default"},[t._v("姓       名：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.fullname?s.fullname:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("在线状态：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.status?s.status:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("部 职 别：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.post?s.post:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("手 机 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.mobile?s.mobile:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("房 间 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.address?s.address:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("座 机 号：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.telephone?s.telephone:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("应       休：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJtotalDays?s.QXJtotalDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("已       休：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJxiuJiaDays?s.QXJxiuJiaDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("本月在线天数：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisMonthDays?s.thisMonthDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("累计在线天数：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisYearDays?s.thisYearDays:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("当前所在省市：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJcities?s.QXJcities:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("具体位置：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJaddress?s.QXJaddress:"--"))])]),t._v(" "),e("p",[e("span",{staticClass:"fs-14_default"},[t._v("事       由：")]),e("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJmatters?s.QXJmatters:"--"))])])]),t._v(" "),e("div",{class:["btnStyle","color"+s.isShow,"1"===s.isSelect?"selectStyle":""],attrs:{slot:"reference"},slot:"reference"},[t._v(t._s(s.fullname))])])],1)])}),1)],1)])}),0)],1)],1)],1)],1)],1)],1)],1),t._v(" "),e("el-tab-pane",{attrs:{label:"请假人员分布情况",name:"second"}},[e("el-row",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading1,expression:"listLoading1"}],attrs:{gutter:20}},[e("el-col",{staticStyle:{"margin-top":"15px"},attrs:{span:20}},[e("el-row",{attrs:{id:"mapOrganTree"}},[e("el-form",{attrs:{model:t.tempForm,"label-position":"left","label-width":"100px"}},[e("el-col",{attrs:{span:4}},[e("el-form-item",[e("el-date-picker",{attrs:{type:"date",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd",size:"small",placeholder:"请选择日期"},on:{change:t.getDate},model:{value:t.tempForm.chooseDate,callback:function(s){t.$set(t.tempForm,"chooseDate",s)},expression:"tempForm.chooseDate"}})],1)],1),t._v(" "),e("el-col",{attrs:{span:4}},[e("el-form-item",[e("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(s){t.showUserTree=s},expression:"showUserTree"}},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[e("el-tree",{ref:"userTree",attrs:{data:t.mapTreeData,props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":t.handleNodeClick}})],1),t._v(" "),e("el-input",{attrs:{slot:"reference",size:"small",clearable:"",placeholder:t.placeholderVal1},on:{clear:t.clearNode},slot:"reference",model:{value:t.tempForm.depetName,callback:function(s){t.$set(t.tempForm,"depetName",s)},expression:"tempForm.depetName"}})],1)],1)],1)],1)],1),t._v(" "),e("el-row",[e("map-labels",{attrs:{"data-num":t.dataNum},on:{mapClick:t.mapClick}})],1)],1),t._v(" "),e("el-col",{attrs:{span:4}},[e("div",{staticClass:"organTree posRel",staticStyle:{height:"calc(90vh - 5px)"}},[e("div",{staticClass:"exportTitle"},[e("div",{staticClass:"flexCenter",staticStyle:{height:"100%"}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px"},attrs:{"icon-class":"mulu"}}),t._v(" "),e("span",{staticStyle:{"margin-left":"15px"}},[t._v("人员分布清单")])],1),t._v(" "),e("svg-icon",{staticClass:"icon",staticStyle:{width:"17px",height:"17px",cursor:"pointer"},attrs:{"icon-class":"daochulan",title:"导出"},on:{click:t.iconExport}})],1),t._v(" "),t.mapTreeList.length>0?e("ul",[e("li",{staticStyle:{color:"#2280E5",background:"#C1DBFC",padding:"0 10px 0 20px"}},[e("span",{staticStyle:{float:"left"}},[t._v("地区")]),t._v(" "),e("span",{staticStyle:{float:"right"}},[t._v("人数")])]),t._v(" "),e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"700px"}},t._l(t.mapTreeList,function(s,a){return e("li",{key:a,staticClass:"platNum",on:{click:function(e){return t.toPlatList(s)}}},[e("span",{class:"北京"===s.plat?"color_red":"",staticStyle:{float:"left"},attrs:{title:s.plat}},[t._v(t._s(s.plat.length>5?s.plat.substr(0,5):s.plat))]),t._v(" "),e("span",{class:"北京"===s.plat?"color_red":"",staticStyle:{float:"right"}},[t._v(t._s(s.number))])])}),0)],1):e("div",{staticStyle:{height:"60px","line-height":"60px","text-align":"center",color:"#909399"}},[t._v("暂无数据")])])])],1)],1)],1)],1)],1):"2"===t.showPage?e("div",[e("depart",{attrs:{id:t.platJuName,checkDate:t.checkDate,checkJuName:t.checkJuName,checkJuId:t.checkJuId},on:{back:t.backList}})],1):t._e()])},i=[],l=(e("ac6a"),e("7f7f"),e("6b54"),e("f576"),e("d91d")),r=e("2378"),n=e("c03e"),o={name:"PersonIndex",components:{depart:l["default"],mapLabels:r["default"]},data:function(){return{showPage:"1",labelText:"全局人员在线情况",activeName:"first",treeList:[],mapTreeList:[],dataNum:[],personList1:[],personList2:[],personList3:[],isManager:this.$store.state.user.userInfo.adminFlag,roleFlag:this.$store.state.user.userInfo.roleFlag,listQuery:{parentId:"",organId:"",userName:""},form:{chooseDate:"",organId:"",userName:""},ins:0,treeParams:{status:"0",organId:""},listLoading:!1,listLoading1:!1,userAllYx:"",userShouldNumber:"",userIdList:"",zwlv:0,qjNum:"",otherPlacesNum:"",userAllYxJu:"",userShouldNumberJu:"",userIdListJu:"",zwlvJu:0,qjNumJu:"",otherPlacesNumJu:"",organTree_list:[],juId:"",spanVal:21,mapTreeData:[],defaultProps:{children:"children",label:"text"},showUserTree:!1,tempForm:{chooseDate:this.getNowTime(),depetName:"",depetId:""},platJuName:"",checkDate:"",checkJuName:"",checkJuId:"",visibleArrow:!1,month:"",date:"",placeholderVal:"",placeholderVal1:""}},watch:{activeName:function(t){"second"===t&&(this.getPlatNumber(),this.mapOrganTree())}},created:function(){this.organTreeList(),this.getStatistics(),"1"===this.isManager||this.roleFlag?this.spanVal=21:this.spanVal=24,"1"===this.isManager||this.roleFlag?this.labelText="全局人员在线情况":this.labelText="".concat(this.$store.state.user.userInfo.juName,"人员在线情况"),"1"===this.isManager||this.roleFlag?this.placeholderVal1="装备发展部":this.placeholderVal1=this.$store.state.user.userInfo.juName},methods:{getNowTime:function(){var t=new Date,s=t.getFullYear(),e=t.getMonth(),a=t.getDate();return this.month=e+1,this.month=this.month.toString().padStart(2,"0"),this.date=a.toString().padStart(2,"0"),"".concat(s,"-").concat(this.month,"-").concat(this.date)},refreshFn:function(){Object(n["k"])().then(function(t){}),this.juId="",this.listQuery.parentId="",this.ins=0,this.organTreeList(),this.getStatistics()},organTreeList:function(){var t=this;Object(n["g"])().then(function(s){t.treeList=s.data,t.qxjUserInfoList(),"1"===t.isManager||t.roleFlag?(t.juId=s.data[0].id,t.listQuery.parentId=s.data[0].id):(t.juId=t.$store.state.user.userInfo.juId,t.listQuery.parentId=t.$store.state.user.userInfo.juId),"1"===t.isManager||t.roleFlag?t.placeholderVal=s.data[0].name:t.placeholderVal=t.$store.state.user.userInfo.juName,t.organTreeListALL(t.juId),t.getStatisticsByDept(t.listQuery.parentId)})},getStatistics:function(){var t=this;Object(n["c"])(this.treeParams).then(function(s){if(500!==s.data.code&&s.data){var e=s.data,a=e.userAllYx,i=e.userShouldNumber,l=e.userIdList,r=e.zwlv,n=e.qjNum,o=e.otherPlacesNum;Object.assign(t,{userAllYx:a,userShouldNumber:i,userIdList:l,zwlv:r,qjNum:n,otherPlacesNum:o})}else t.zwlv=0})},getStatisticsByDept:function(t){var s=this;Object(n["d"])({organId:t}).then(function(t){if(500!==t.data.code&&t.data){var e=t.data,a=e.userAllYx,i=e.userShouldNumber,l=e.userIdList,r=e.zwlv,n=e.qjNum,o=e.otherPlacesNum;Object.assign(s,{userAllYxJu:a,userShouldNumberJu:i,userIdListJu:l,zwlvJu:r,qjNumJu:n,otherPlacesNumJu:o})}else s.zwlvJu=0})},qxjUserInfoList:function(){var t=this;this.personList1=[],this.personList2=[],this.personList3=[],this.listLoading=!0,Object(n["j"])(this.listQuery).then(function(s){s.data.forEach(function(s,e){e%3===0?t.personList1.push(s):e%3===1?t.personList2.push(s):e%3===2&&t.personList3.push(s)}),setTimeout(function(){t.listLoading=!1},100)})},organTreeListALL:function(t){var s=this;Object(n["h"])({organId:t}).then(function(t){s.organTree_list=t.data.list})},getPlatNumber:function(){var t=this;this.listLoading1=!0;var s={parentId:"1"===this.isManager||this.roleFlag?"":this.$store.state.user.userInfo.juId,organId:this.tempForm.depetId,timeStr:this.tempForm.chooseDate};Object(n["b"])(s).then(function(s){t.dataNum=[],t.mapTreeList=s.data.list,s.data.list.forEach(function(s,e){t.dataNum.push({name:s.plat,value:s.number})}),setTimeout(function(){t.listLoading1=!1},100)})},mapOrganTree:function(){var t=this;Object(n["f"])().then(function(s){t.mapTreeData=s.data.children})},changeOrgan:function(t,s){this.ins=t,this.listQuery.parentId=s.id,this.listQuery.organId="",this.placeholderVal=s.name,this.qxjUserInfoList(),this.organTreeListALL(s.id),this.getStatisticsByDept(s.id)},screenOrgan:function(t){this.listQuery.organId=t,this.qxjUserInfoList()},clearFn:function(){this.qxjUserInfoList()},searchFn:function(){this.qxjUserInfoList()},exportFn:function(){window.location.href="/app/xlgl/peopleManagement/export?status="+("1"===this.isManager||this.roleFlag?"0":"1")+"&organId="+this.listQuery.parentId+"&access_token="+this.$store.state.user.token},iconExport:function(){window.location.href="/app/xlgl/peopleManagementNew/exportPlatAndNumber?parentId="+("1"===this.isManager||this.roleFlag?"":this.$store.state.user.userInfo.juId)+"&timeStr="+this.tempForm.chooseDate+"&access_token="+this.$store.state.user.token},backList:function(t){this.showPage=t},handleNodeClick:function(t){this.tempForm.depetId=t.id,this.tempForm.depetName=t.text,this.showUserTree=!1,this.getPlatNumber()},clearNode:function(){this.tempForm.depetId="",this.getPlatNumber()},getDate:function(t){this.tempForm.chooseDate=t,this.getPlatNumber()},toPlatList:function(t){this.platJuName=t.plat,this.checkDate=this.tempForm.chooseDate,this.checkJuName=this.tempForm.depetName,this.checkJuId=this.tempForm.depetId,this.showPage="2"},mapClick:function(t){this.platJuName=t,this.checkDate=this.tempForm.chooseDate,this.checkJuName=this.tempForm.depetName,this.checkJuId=this.tempForm.depetId,this.showPage="2"}}},c=o,p=(e("2de7"),e("a02e"),e("2877")),u=Object(p["a"])(c,a,i,!1,null,"17e33c98",null);s["default"]=u.exports},"2de7":function(t,s,e){"use strict";var a=e("22f1"),i=e.n(a);i.a},"2e08":function(t,s,e){var a=e("9def"),i=e("9744"),l=e("be13");t.exports=function(t,s,e,r){var n=String(l(t)),o=n.length,c=void 0===e?" ":String(e),p=a(s);if(p<=o||""==c)return n;var u=p-o,d=i.call(c,Math.ceil(u/c.length));return d.length>u&&(d=d.slice(0,u)),r?d+n:n+d}},"6f89":function(t,s,e){"use strict";var a=e("d348"),i=e.n(a);i.a},"76c01":function(t,s,e){},9744:function(t,s,e){"use strict";var a=e("4588"),i=e("be13");t.exports=function(t){var s=String(i(this)),e="",l=a(t);if(l<0||l==1/0)throw RangeError("Count can't be negative");for(;l>0;(l>>>=1)&&(s+=s))1&l&&(e+=s);return e}},a02e:function(t,s,e){"use strict";var a=e("76c01"),i=e.n(a);i.a},c03e:function(t,s,e){"use strict";e.d(s,"e",function(){return i}),e.d(s,"a",function(){return l}),e.d(s,"j",function(){return r}),e.d(s,"g",function(){return n}),e.d(s,"c",function(){return o}),e.d(s,"h",function(){return c}),e.d(s,"f",function(){return p}),e.d(s,"i",function(){return u}),e.d(s,"b",function(){return d}),e.d(s,"k",function(){return _}),e.d(s,"d",function(){return h});var a=e("b775");function i(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/list",method:"post",data:t})}function r(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/qxjUserInfoList",method:"post",data:t})}function n(t){return Object(a["a"])({url:"/app/xlgl/peopleManagementNew/organTreeList",method:"post",data:t})}function o(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/peopleManagementNew/organTreeListALL",method:"post",data:t})}function p(t){return Object(a["a"])({url:"/app/xlgl/peopleManagementNew/organTree",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/xlgl/peopleManagementNew/platList",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/peopleManagementNew/getPlatNumber",method:"post",data:t})}function _(t){return Object(a["a"])({url:"/app/xlgl/syncPeople/shuaxin",method:"post",data:t})}function h(t){return Object(a["a"])({url:"/app/xlgl/peopleManagement/getStatisticsByDept",method:"post",data:t})}},d348:function(t,s,e){},d91d:function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"posRel"},[e("el-card",{staticStyle:{height:"calc(98vh - 15px)",margin:"10px"},attrs:{"body-style":{padding:"0px 10px"}}},[e("title-card",{attrs:{"title-text":"请假人员分布情况"}}),t._v(" "),e("el-button",{staticClass:"iconBack",attrs:{size:"mini"},on:{click:t.goBack}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"goback"}}),t._v("\n      返回上一级\n    ")],1),t._v(" "),e("el-row",{staticClass:"ma-t_20",attrs:{gutter:20}},[e("el-col",{attrs:{span:3}},[e("div",{staticClass:"organTree"},[e("div",{staticStyle:{height:"40px","line-height":"40px","padding-left":"15px"}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px"},attrs:{"icon-class":"mulu"}})],1),t._v(" "),t.mapTreeList.length>0?e("ul",[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"700px"}},t._l(t.mapTreeList,function(s,a){return e("li",{key:a,class:[a===t.ins?"active":"pd-l_30"],on:{click:function(e){return t.changeOrgan(s,a)}}},[t._v(t._s(s.plat.length>5?s.plat.substr(0,5):s.plat))])}),0)],1):e("div",{staticStyle:{height:"60px","line-height":"60px","text-align":"center",color:"#909399"}},[t._v("暂无数据")])])]),t._v(" "),e("el-col",{attrs:{span:21}},[e("el-row",[e("el-col",{attrs:{span:6}},[e("div",{staticClass:"recordNum"},[t._v("共查询到"),e("span",[t._v(t._s(t.recordNum))]),t._v("条人员记录")])]),t._v(" "),e("el-col",{attrs:{span:18}},[e("el-row",[e("el-form",{attrs:{model:t.listQuery,"label-position":"left","label-width":"100px"}},[e("el-col",{attrs:{span:6}},[e("el-date-picker",{attrs:{type:"date",size:"small",placeholder:"请选择日期",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd"},on:{change:t.getDate},model:{value:t.listQuery.timeStr,callback:function(s){t.$set(t.listQuery,"timeStr",s)},expression:"listQuery.timeStr"}})],1),t._v(" "),e("el-col",{attrs:{span:6}},[e("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(s){t.showUserTree=s},expression:"showUserTree"}},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[e("el-tree",{ref:"userTree",attrs:{data:t.mapTreeData,props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":t.handleNodeClick}})],1),t._v(" "),e("el-input",{staticStyle:{width:"200px"},attrs:{slot:"reference",size:"small",clearable:"",placeholder:t.placeholderVal},on:{clear:t.clearNode},slot:"reference",model:{value:t.listQuery.organName,callback:function(s){t.$set(t.listQuery,"organName",s)},expression:"listQuery.organName"}})],1)],1),t._v(" "),e("el-col",{attrs:{span:6}},[e("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{size:"small",placeholder:"输入人员姓名",clearable:""},on:{clear:t.clearFn},nativeOn:{keyup:function(s){return!s.type.indexOf("key")&&t._k(s.keyCode,"enter",13,s.key,"Enter")?null:t.search(s)}},model:{value:t.listQuery.userName,callback:function(s){t.$set(t.listQuery,"userName",s)},expression:"listQuery.userName"}})],1)],1),t._v(" "),e("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.searchFn}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"sousuo"}}),t._v("\n                查询\n              ")],1),t._v(" "),e("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFn}},[e("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"daochu"}}),t._v("\n                导出\n              ")],1)],1)],1)],1),t._v(" "),e("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],staticClass:"ma-t_20",attrs:{data:t.tableList,border:"",fit:"",stripe:"","header-cell-style":{fontSize:"16px",color:"#333"},"highlight-current-rowstyle":"width: 100%;",height:"730"}},[e("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),e("el-table-column",{attrs:{label:"人员姓名",align:"center",prop:"userName"}}),t._v(" "),e("el-table-column",{attrs:{label:"单位名称",align:"center",prop:"deptName"}}),t._v(" "),e("el-table-column",{attrs:{label:"部门名称",align:"center",prop:"organName"}}),t._v(" "),e("el-table-column",{attrs:{label:"联系电话",align:"center",prop:"phone"}}),t._v(" "),e("el-table-column",{attrs:{label:"当前位置",align:"center",prop:"location"}}),t._v(" "),e("el-table-column",{attrs:{label:"详细位置",align:"center",prop:"address"}}),t._v(" "),e("el-table-column",{attrs:{label:"在位状态",align:"center",prop:"status"}}),t._v(" "),e("el-table-column",{attrs:{label:"事由说明",align:"center",prop:"origin"}})],1)],1)],1)],1)],1)},i=[],l=(e("ac6a"),e("35b7")),r=e("c03e"),n={name:"PersonStatusJu",components:{TitleCard:l["a"]},props:{id:{type:String,default:""},checkDate:{type:String,default:""},checkJuId:{type:String,default:""},checkJuName:{type:String,default:""}},data:function(){return{mapTreeList:[],ins:0,listQuery:{userName:"",timeStr:"",organId:"",organName:""},isManager:this.$store.state.user.userInfo.adminFlag,roleFlag:this.$store.state.user.userInfo.roleFlag,recordNum:"",listLoading:!1,tableList:[],showUserTree:!1,mapTreeData:[],defaultProps:{children:"children",label:"text"},placeholderVal:"",province:"",newArray:[]}},created:function(){this.listQuery.timeStr=this.checkDate,this.province=this.id,this.checkJuId?this.listQuery.organId=this.checkJuId:this.listQuery.organId="",this.checkJuName?this.listQuery.organName=this.checkJuName:this.placeholderVal="1"===this.isManager||this.roleFlag?"装备发展部":this.$store.state.user.userInfo.juName,this.getPlatNumber(),this.mapOrganTree()},methods:{getPlatNumber:function(){var t=this,s={parentId:"1"===this.isManager||this.roleFlag?"":this.$store.state.user.userInfo.juId,organId:this.listQuery.organId,timeStr:this.listQuery.timeStr};Object(r["b"])(s).then(function(s){t.mapTreeList=s.data.list,t.newArray=[],s.data.list.forEach(function(s,e){t.province===s.plat&&(t.ins=e),t.newArray.push(s.plat)}),t.newArray.indexOf(t.province)<0&&(t.$confirm("".concat(t.listQuery.timeStr).concat(t.province,"暂无人员分布，当前显示").concat(t.listQuery.timeStr,"人员分布情况"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",showCancelButton:!1,showClose:!1,center:!0}),t.province=t.newArray[0],t.ins=0),t.platList()})},platList:function(){var t=this;this.listLoading=!0;var s={parentId:"1"===this.isManager||this.roleFlag?"":this.$store.state.user.userInfo.juId,userName:this.listQuery.userName,timeStr:this.listQuery.timeStr,organId:this.listQuery.organId,province:this.province};Object(r["i"])(s).then(function(s){t.tableList=s.data.list,t.recordNum=s.data.list.length,setTimeout(function(){t.listLoading=!1},100)})},mapOrganTree:function(){var t=this;Object(r["f"])().then(function(s){t.mapTreeData=s.data.children})},handleNodeClick:function(t){this.listQuery.organId=t.id,this.listQuery.organName=t.text,this.showUserTree=!1,this.getPlatNumber()},clearNode:function(){this.listQuery.organId="",this.getPlatNumber(),this.placeholderVal="1"===this.isManager||this.roleFlag?"装备发展部":this.$store.state.user.userInfo.juName},clearFn:function(){this.getPlatNumber()},getDate:function(t){this.listQuery.timeStr=t,this.getPlatNumber()},goBack:function(){this.$emit("back","1")},changeOrgan:function(t,s){this.ins=s,this.province=t.plat,this.getPlatNumber()},searchFn:function(){this.getPlatNumber()},exportFn:function(){window.location.href="/app/xlgl/peopleManagementNew/exportPlat?parentId="+("1"===this.isManager||this.roleFlag?"":this.$store.state.user.userInfo.juId)+"&province="+this.province+"&timeStr="+this.listQuery.timeStr+"&access_token="+this.$store.state.user.token}}},o=n,c=(e("6f89"),e("2877")),p=Object(c["a"])(o,a,i,!1,null,"d7e3772c",null);s["default"]=p.exports},eeba:function(t,s,e){t.exports=e.p+"static/img/beijing.0d44ada8.svg"},f576:function(t,s,e){"use strict";var a=e("5ca1"),i=e("2e08"),l=e("a25f"),r=/Version\/10\.\d+(\.\d+)?( Mobile\/\w+)? Safari\//.test(l);a(a.P+a.F*r,"String",{padStart:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0,!0)}})}}]);