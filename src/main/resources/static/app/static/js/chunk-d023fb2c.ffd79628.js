(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d023fb2c","chunk-564458f4","chunk-2d0b21d8"],{1402:function(t,s,a){},23258:function(t,s,a){"use strict";var e=a("1402"),i=a.n(e);i.a},2378:function(t,s,a){"use strict";a.r(s);var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticStyle:{width:"1100px",height:"720px"},attrs:{id:"myChinaMap"}})},i=[],l=a("313e"),r=a.n(l);a("3139");var n={props:{dataNum:{type:Array,default:function(){return[]}}},data:function(){return{chart:null}},watch:{dataNum:{deep:!0,handler:function(){this.initChart()}}},mounted:function(){this.$nextTick(function(){this.initChart()})},methods:{initChart:function(){this.chart=r.a.init(this.$el,"china"),this.chart.setOption({tooltip:{trigger:"item"},selectedMode:"single",dataRange:{splitList:[{start:500,color:"#EF5366"},{start:301,end:500,color:"#F86F1A"},{start:101,end:300,color:"#53D591"},{start:1,end:100,color:"#65BBFF"},{end:1,color:"#ccc"}],textStyle:{color:"#3899FF"}},series:[{name:"人员分布情况",type:"map",zoom:1.2,map:"china",itemStyle:{normal:{label:{show:!0},color:"#53D591",areaColor:"#eff6ff"},emphasis:{label:{show:!0},areaColor:"#cbe2ff"}},showLegendSymbol:!1,roam:!0,label:{normal:{show:!0},emphasis:{show:!0}},data:this.dataNum}]})}}},o=n,c=a("2877"),p=Object(c["a"])(o,e,i,!1,null,null,null);s["default"]=p.exports},"2c61":function(t,s,a){},"2cae":function(t,s,a){"use strict";a.r(s);var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"posRel",attrs:{id:"container"}},["1"===t.showPage?a("div",[a("el-card",{staticStyle:{height:"calc(98vh - 15px)",margin:"10px"},attrs:{"body-style":{padding:"0px 10px"}}},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName === 'first'"}],staticClass:"iconRefresh",attrs:{type:"primary",size:"mini"},on:{click:t.refreshFn}},[t._v("刷新")]),t._v(" "),a("el-tabs",{model:{value:t.activeName,callback:function(s){t.activeName=s},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"信息局人员在线情况",name:"first"}},[a("ul",{staticClass:"peopleNum bor-bottom",attrs:{id:"zxlRate"}},[a("li",{staticClass:"ma-b_20"},[a("p",{staticClass:"fs-30 color_default"},[t._v(t._s(t.userAllYx))]),t._v(" "),a("p",{staticClass:"pd-t_20"},[t._v("注册人数")])]),t._v(" "),a("li",{staticClass:"ma-b_20"},[a("p",{staticClass:"fs-30 color_yellow"},[t._v(t._s(t.userShouldNumber))]),t._v(" "),a("p",{staticClass:"pd-t_20"},[t._v("应在线人数")])]),t._v(" "),a("li",{staticClass:"ma-b_20"},[a("p",{staticClass:"fs-30 color_green"},[t._v(t._s(t.userIdList))]),t._v(" "),a("p",{staticClass:"pd-t_20"},[t._v("在线人数")])]),t._v(" "),a("li",{staticClass:"ma-b_20"},[a("p",[a("el-progress",{attrs:{type:"circle",percentage:t.zwlv-0,"stroke-width":9,width:80}})],1),t._v(" "),a("p",{staticStyle:{"padding-top":"3px"}},[t._v("在线率")])]),t._v(" "),a("li",{staticClass:"ma-b_20"},[a("p",{staticClass:"fs-30 color_orange"},[t._v(t._s(t.qjNum))]),t._v(" "),a("p",{staticClass:"pd-t_20"},[t._v("请假人数")])]),t._v(" "),a("li",{staticClass:"ma-b_20"},[a("p",{staticClass:"fs-30 color_blue"},[t._v(t._s(t.otherPlacesNum))]),t._v(" "),a("p",{staticClass:"pd-t_20"},[t._v("京外人数")])])]),t._v(" "),a("el-row",{attrs:{gutter:20}},[a("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager,expression:"isManager === '1'"}],attrs:{span:4}},[a("div",{staticClass:"organTree",staticStyle:{height:"calc(75vh - 5px)"}},[a("div",{staticStyle:{height:"40px","line-height":"40px","padding-left":"15px"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px"},attrs:{"icon-class":"mulu"}})],1),t._v(" "),a("ul",[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"600px"}},t._l(t.treeList,function(s,e){return a("li",{key:e,class:[e===t.ins?"active":"pd-l_30"],attrs:{title:s.name},on:{click:function(a){return t.changeOrgan(e,s)}}},[t._v(t._s(s.name.length>7?s.name.substr(0,7):s.name))])}),0)],1)])]),t._v(" "),a("el-col",{attrs:{span:t.spanVal}},[a("el-row",[a("el-col",{attrs:{span:7}},[a("div",{staticClass:"flexCenter",staticStyle:{height:"32px"}},[a("div",{staticClass:"flexCenter"},[a("span",{staticClass:"legends",staticStyle:{background:"#53D591"}}),t._v(" "),a("span",{staticClass:"ma-l_10 fs-14"},[t._v("在线")])]),t._v(" "),a("div",{staticClass:"flexCenter ma-l_25"},[a("span",{staticClass:"legends",staticStyle:{background:"#F86F1A"}}),t._v(" "),a("span",{staticClass:"ma-l_10 fs-14"},[t._v("请假")])]),t._v(" "),a("div",{staticClass:"flexCenter ma-l_25"},[a("span",{staticClass:"legends",staticStyle:{background:"#65BBFF"}}),t._v(" "),a("span",{staticClass:"ma-l_10 fs-14"},[t._v("出差")])]),t._v(" "),a("div",{staticClass:"flexCenter ma-l_25"},[a("span",{staticClass:"legends",staticStyle:{background:"#EF5366"}}),t._v(" "),a("span",{staticClass:"ma-l_10 fs-14"},[t._v("异常")])])])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"right"},attrs:{span:17}},[a("el-select",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{placeholder:"请选择单位",size:"small",clearable:""},on:{change:t.screenOrgan},model:{value:t.listQuery.organId,callback:function(s){t.$set(t.listQuery,"organId",s)},expression:"listQuery.organId"}},t._l(t.organTree_list,function(t,s){return a("el-option",{key:s,attrs:{label:t.name,value:t.id}})}),1),t._v(" "),a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入人员姓名",clearable:""},on:{clear:t.clearFn},nativeOn:{keyup:function(s){return!s.type.indexOf("key")&&t._k(s.keyCode,"enter",13,s.key,"Enter")?null:t.search(s)}},model:{value:t.listQuery.userName,callback:function(s){t.$set(t.listQuery,"userName",s)},expression:"listQuery.userName"}}),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.searchFn}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"sousuo"}}),t._v("\n                    查询\n                  ")],1),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFn}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"daochu"}}),t._v("\n                    导出\n                  ")],1)],1)],1),t._v(" "),a("el-row",[a("ul",{staticClass:"peopleNum bor_1_fe6",staticStyle:{padding:"10px 0"},attrs:{id:"zxlRate1"}},[a("li",[a("p",{staticClass:"fs-20 color_default"},[t._v(t._s(t.userAllYxJu))]),t._v(" "),a("p",{staticClass:"pd-t_10 fs-14"},[t._v("注册人数")])]),t._v(" "),a("li",[a("p",{staticClass:"fs-20 color_yellow"},[t._v(t._s(t.userShouldNumberJu))]),t._v(" "),a("p",{staticClass:"pd-t_10 fs-14"},[t._v("应在线人数")])]),t._v(" "),a("li",[a("p",{staticClass:"fs-20 color_green"},[t._v(t._s(t.userIdListJu))]),t._v(" "),a("p",{staticClass:"pd-t_10 fs-14"},[t._v("在线人数")])]),t._v(" "),a("li",[a("p",[a("el-progress",{attrs:{type:"circle",percentage:t.zwlvJu-0,"stroke-width":4,width:50}})],1),t._v(" "),a("p",{staticStyle:{"padding-top":"2px"}},[t._v("在线率")])]),t._v(" "),a("li",[a("p",{staticClass:"fs-20 color_orange"},[t._v(t._s(t.qjNumJu))]),t._v(" "),a("p",{staticClass:"pd-t_10 fs-14"},[t._v("请假人数")])]),t._v(" "),a("li",[a("p",{staticClass:"fs-20 color_blue"},[t._v(t._s(t.otherPlacesNumJu))]),t._v(" "),a("p",{staticClass:"pd-t_10 fs-14"},[t._v("京外人数")])])])]),t._v(" "),a("el-row",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}]},[a("el-col",{staticClass:"elColStyle",attrs:{span:24}},[a("el-scrollbar",{staticClass:"hidden-x"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},t._l(t.personList1,function(s,e){return a("div",{key:e,class:[0!==e?"ma-t_20":""]},[a("div",{staticClass:"cardBox"},[a("div",{staticClass:"cardTitle"},[t._v(t._s(s.name))]),t._v(" "),a("ul",{staticClass:"flexCenter"},[a("li",[a("p",{staticClass:"color_default fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zcrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("注册人数")])]),t._v(" "),a("li",[a("p",{staticClass:"color_yellow fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.yzxrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("应在线人数")])]),t._v(" "),a("li",[a("p",{staticClass:"color_green fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zxrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("在线人数")])])]),t._v(" "),a("el-row",{attrs:{gutter:20}},t._l(s.list,function(s,e){return a("el-col",{key:e,class:[e>2?"ma-t_10":""],attrs:{span:8}},[a("div",[a("el-popover",{attrs:{placement:"bottom-start",width:"250","visible-arrow":t.visibleArrow,trigger:"hover"}},[a("div",{staticClass:"cardTip"},[a("p",[a("span",{staticClass:"fs-14_default"},[t._v("姓       名：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.fullname?s.fullname:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("在线状态：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.status?s.status:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("部 职 别：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.post?s.post:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("手 机 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.mobile?s.mobile:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("房 间 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.address?s.address:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("座 机 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.telephone?s.telephone:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("应       休：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJtotalDays?s.QXJtotalDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("已       休：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJxiuJiaDays?s.QXJxiuJiaDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("本月在线：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisMonthDays?s.thisMonthDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("累计在线：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisYearDays?s.thisYearDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("当前所在省市：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJcities?s.QXJcities:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("具体位置：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJaddress?s.QXJaddress:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("事       由：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJmatters?s.QXJmatters:"--"))])])]),t._v(" "),a("div",{class:["btnStyle","color"+s.isShow],attrs:{slot:"reference"},slot:"reference"},[t._v(t._s(s.fullname))])])],1)])}),1)],1)])}),0),t._v(" "),a("el-col",{attrs:{span:8}},t._l(t.personList2,function(s,e){return a("div",{key:e,class:[0!==e?"ma-t_20":""]},[a("div",{staticClass:"cardBox"},[a("div",{staticClass:"cardTitle"},[t._v(t._s(s.name))]),t._v(" "),a("ul",{staticClass:"flexCenter"},[a("li",[a("p",{staticClass:"color_default fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zcrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("注册人数")])]),t._v(" "),a("li",[a("p",{staticClass:"color_yellow fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.yzxrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("应在线人数")])]),t._v(" "),a("li",[a("p",{staticClass:"color_green fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zxrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("在线人数")])])]),t._v(" "),a("el-row",{attrs:{gutter:20}},t._l(s.list,function(s,e){return a("el-col",{key:e,class:[e>2?"ma-t_10":""],attrs:{span:8}},[a("div",[a("el-popover",{attrs:{placement:"bottom-start",width:"250","visible-arrow":t.visibleArrow,trigger:"hover"}},[a("div",{staticClass:"cardTip"},[a("p",[a("span",{staticClass:"fs-14_default"},[t._v("姓       名：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.fullname?s.fullname:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("在线状态：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.status?s.status:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("部 职 别：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.post?s.post:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("手 机 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.mobile?s.mobile:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("房 间 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.address?s.address:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("座 机 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.telephone?s.telephone:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("应       休：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJtotalDays?s.QXJtotalDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("已       休：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJxiuJiaDays?s.QXJxiuJiaDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("本月在线：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisMonthDays?s.thisMonthDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("累计在线：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisYearDays?s.thisYearDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("当前所在省市：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJcities?s.QXJcities:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("具体位置：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJaddress?s.QXJaddress:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("事       由：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJmatters?s.QXJmatters:"--"))])])]),t._v(" "),a("div",{class:["btnStyle","color"+s.isShow],attrs:{slot:"reference"},slot:"reference"},[t._v(t._s(s.fullname))])])],1)])}),1)],1)])}),0),t._v(" "),a("el-col",{attrs:{span:8}},t._l(t.personList3,function(s,e){return a("div",{key:e,class:[0!==e?"ma-t_20":""]},[a("div",{staticClass:"cardBox"},[a("div",{staticClass:"cardTitle"},[t._v(t._s(s.name))]),t._v(" "),a("ul",{staticClass:"flexCenter"},[a("li",[a("p",{staticClass:"color_default fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zcrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("注册人数")])]),t._v(" "),a("li",[a("p",{staticClass:"color_yellow fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.yzxrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("应在线人数")])]),t._v(" "),a("li",[a("p",{staticClass:"color_green fs-20",staticStyle:{"padding-bottom":"5px"}},[t._v(t._s(s.zxrs))]),t._v(" "),a("p",{staticClass:"fs-14"},[t._v("在线人数")])])]),t._v(" "),a("el-row",{attrs:{gutter:20}},t._l(s.list,function(s,e){return a("el-col",{key:e,class:[e>2?"ma-t_10":""],attrs:{span:8}},[a("div",[a("el-popover",{attrs:{placement:"bottom-start",width:"250","visible-arrow":t.visibleArrow,trigger:"hover"}},[a("div",{staticClass:"cardTip"},[a("p",[a("span",{staticClass:"fs-14_default"},[t._v("姓       名：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.fullname?s.fullname:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("在线状态：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.status?s.status:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("部 职 别：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.post?s.post:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("手 机 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.mobile?s.mobile:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("房 间 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.address?s.address:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("座 机 号：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.telephone?s.telephone:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("应       休：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJtotalDays?s.QXJtotalDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("已       休：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJxiuJiaDays?s.QXJxiuJiaDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("本月在线：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisMonthDays?s.thisMonthDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("累计在线：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.thisYearDays?s.thisYearDays:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("当前所在省市：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJcities?s.QXJcities:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("具体位置：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJaddress?s.QXJaddress:"--"))])]),t._v(" "),a("p",[a("span",{staticClass:"fs-14_default"},[t._v("事       由：")]),a("span",{staticClass:"fs-14_fe"},[t._v(t._s(s.QXJmatters?s.QXJmatters:"--"))])])]),t._v(" "),a("div",{class:["btnStyle","color"+s.isShow],attrs:{slot:"reference"},slot:"reference"},[t._v(t._s(s.fullname))])])],1)])}),1)],1)])}),0)],1)],1)],1)],1)],1)],1)],1),t._v(" "),a("el-tab-pane",{attrs:{label:"各地区人员分布情况",name:"second"}},[a("el-row",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading1,expression:"listLoading1"}],attrs:{gutter:20}},[a("el-col",{staticStyle:{"margin-top":"15px"},attrs:{span:20}},[a("el-row",{attrs:{id:"mapOrganTree"}},[a("el-form",{attrs:{model:t.tempForm,"label-position":"left","label-width":"100px"}},[a("el-col",{attrs:{span:4}},[a("el-form-item",[a("el-date-picker",{attrs:{type:"date",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd",size:"small",placeholder:"请选择日期"},on:{change:t.getDate},model:{value:t.tempForm.chooseDate,callback:function(s){t.$set(t.tempForm,"chooseDate",s)},expression:"tempForm.chooseDate"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-form-item",[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(s){t.showUserTree=s},expression:"showUserTree"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[a("el-tree",{ref:"userTree",attrs:{data:t.mapTreeData,props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":t.handleNodeClick}})],1),t._v(" "),a("el-input",{attrs:{slot:"reference",size:"small",clearable:"",placeholder:"请选择单位"},on:{clear:t.clearNode},slot:"reference",model:{value:t.tempForm.depetName,callback:function(s){t.$set(t.tempForm,"depetName",s)},expression:"tempForm.depetName"}})],1)],1)],1)],1)],1),t._v(" "),a("el-row",[a("map-labels",{attrs:{"data-num":t.dataNum}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"organTree posRel",staticStyle:{height:"calc(90vh - 5px)"}},[a("div",{staticClass:"exportTitle"},[a("div",{staticClass:"flexCenter",staticStyle:{height:"100%"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px"},attrs:{"icon-class":"mulu"}}),t._v(" "),a("span",{staticStyle:{"margin-left":"15px"}},[t._v("人员分布清单")])],1),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{width:"17px",height:"17px",cursor:"pointer"},attrs:{"icon-class":"daochulan"},on:{click:t.iconExport}})],1),t._v(" "),a("ul",[a("li",{staticStyle:{color:"#2280E5",background:"#C1DBFC",padding:"0 10px 0 20px"}},[a("span",{staticStyle:{float:"left"}},[t._v("地区")]),t._v(" "),a("span",{staticStyle:{float:"right"}},[t._v("人数")])]),t._v(" "),a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"700px"}},t._l(t.mapTreeList,function(s,e){return a("li",{key:e,staticClass:"platNum",on:{click:function(a){return t.toPlatList(s)}}},[a("span",{staticStyle:{float:"left"},attrs:{title:s.plat}},[t._v(t._s(s.plat.length>5?s.plat.substr(0,5):s.plat))]),t._v(" "),a("span",{staticStyle:{float:"right"}},[t._v(t._s(s.number))])])}),0)],1)])])],1)],1)],1)],1)],1):"2"===t.showPage?a("div",[a("depart",{attrs:{id:t.platJuName},on:{back:t.backList}})],1):t._e()])},i=[],l=(a("ac6a"),a("d91d")),r=a("2378"),n=a("c03e"),o={name:"PersonIndex",components:{depart:l["default"],mapLabels:r["default"]},data:function(){return{showPage:"1",activeName:"first",treeList:[],mapTreeList:[],dataNum:[],personList1:[],personList2:[],personList3:[],isManager:this.$store.state.user.userInfo.adminFlag,listQuery:{parentId:"",organId:"",userName:""},form:{chooseDate:"",organId:"",userName:""},ins:0,treeParams:{status:"0",organId:""},listLoading:!1,listLoading1:!1,userAllYx:"",userShouldNumber:"",userIdList:"",zwlv:0,qjNum:"",otherPlacesNum:"",userAllYxJu:"",userShouldNumberJu:"",userIdListJu:"",zwlvJu:0,qjNumJu:"",otherPlacesNumJu:"",organTree_list:[],juId:"",spanVal:20,mapTreeData:[],defaultProps:{children:"children",label:"text"},showUserTree:!1,tempForm:{chooseDate:"",depetName:"",depetId:""},platJuName:"",visibleArrow:!1}},watch:{activeName:function(t){"second"===t&&(this.getPlatNumber(),this.mapOrganTree())}},created:function(){this.organTreeList(),this.getStatistics(),"1"===this.isManager?this.spanVal=20:this.spanVal=24},methods:{refreshFn:function(){Object(n["k"])().then(function(t){})},organTreeList:function(){var t=this;Object(n["g"])().then(function(s){t.treeList=s.data,t.qxjUserInfoList(),"1"===t.isManager?(t.juId=s.data[0].id,t.listQuery.parentId=s.data[0].id):(t.juId=t.$store.state.user.userInfo.juId,t.listQuery.parentId=t.$store.state.user.userInfo.juId),t.organTreeListALL(t.juId),t.getStatisticsByDept(t.listQuery.parentId)})},getStatistics:function(){var t=this;Object(n["c"])(this.treeParams).then(function(s){if(500===s.data.code)t.zwlv=0;else{var a=s.data,e=a.userAllYx,i=a.userShouldNumber,l=a.userIdList,r=a.zwlv,n=a.qjNum,o=a.otherPlacesNum;Object.assign(t,{userAllYx:e,userShouldNumber:i,userIdList:l,zwlv:r,qjNum:n,otherPlacesNum:o})}})},getStatisticsByDept:function(t){var s=this;Object(n["d"])({organId:t}).then(function(t){if(500===t.data.code)s.zwlvJu=0;else{var a=t.data,e=a.userAllYx,i=a.userShouldNumber,l=a.userIdList,r=a.zwlv,n=a.qjNum,o=a.otherPlacesNum;Object.assign(s,{userAllYxJu:e,userShouldNumberJu:i,userIdListJu:l,zwlvJu:r,qjNumJu:n,otherPlacesNumJu:o})}})},qxjUserInfoList:function(){var t=this;this.personList1=[],this.personList2=[],this.personList3=[],this.listLoading=!0,Object(n["j"])(this.listQuery).then(function(s){s.data.forEach(function(s,a){a%3===0?t.personList1.push(s):a%3===1?t.personList2.push(s):a%3===2&&t.personList3.push(s)}),setTimeout(function(){t.listLoading=!1},100)})},organTreeListALL:function(t){var s=this;Object(n["h"])({organId:t}).then(function(t){s.organTree_list=t.data.list})},getPlatNumber:function(){var t=this;this.listLoading1=!0;var s={parentId:"1"===this.isManager?"":this.$store.state.user.userInfo.juId,organId:this.tempForm.depetId,timeStr:this.tempForm.chooseDate};Object(n["b"])(s).then(function(s){t.dataNum=[],t.mapTreeList=s.data.list,s.data.list.forEach(function(s,a){t.dataNum.push({name:s.plat,value:s.number})}),setTimeout(function(){t.listLoading1=!1},100)})},mapOrganTree:function(){var t=this;Object(n["f"])().then(function(s){t.mapTreeData=s.data.children})},changeOrgan:function(t,s){this.ins=t,this.listQuery.parentId=s.id,this.listQuery.organId="",this.qxjUserInfoList(),this.organTreeListALL(s.id),this.getStatisticsByDept(s.id)},screenOrgan:function(t){this.listQuery.organId=t,this.qxjUserInfoList()},clearFn:function(){this.qxjUserInfoList()},searchFn:function(){this.qxjUserInfoList()},exportFn:function(){window.location.href="/app/xlgl/peopleManagement/export?status="+("1"===this.isManager?"0":"1")+"&organId="+this.listQuery.parentId+"&access_token="+this.$store.state.user.token},iconExport:function(){window.location.href="/app/xlgl/peopleManagementNew/exportPlatAndNumber?parentId="+("1"===this.isManager?"":this.$store.state.user.userInfo.juId)+"&timeStr="+this.tempForm.chooseDate+"&access_token="+this.$store.state.user.token},backList:function(t){this.showPage=t},handleNodeClick:function(t){this.tempForm.depetId=t.id,this.tempForm.depetName=t.text,this.showUserTree=!1,this.getPlatNumber()},clearNode:function(){this.tempForm.depetId="",this.getPlatNumber()},getDate:function(t){this.tempForm.chooseDate=t,this.getPlatNumber()},toPlatList:function(t){this.platJuName=t.plat,this.showPage="2"}}},c=o,p=(a("d1ca"),a("a02e"),a("2877")),u=Object(p["a"])(c,e,i,!1,null,"b532ce52",null);s["default"]=u.exports},"76c0":function(t,s,a){},a02e:function(t,s,a){"use strict";var e=a("76c0"),i=a.n(e);i.a},c03e:function(t,s,a){"use strict";a.d(s,"e",function(){return i}),a.d(s,"a",function(){return l}),a.d(s,"j",function(){return r}),a.d(s,"g",function(){return n}),a.d(s,"c",function(){return o}),a.d(s,"h",function(){return c}),a.d(s,"f",function(){return p}),a.d(s,"i",function(){return u}),a.d(s,"b",function(){return d}),a.d(s,"k",function(){return _}),a.d(s,"d",function(){return f});var e=a("b775");function i(t){return Object(e["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function l(t){return Object(e["a"])({url:"/app/xlgl/peopleManagement/list",method:"post",data:t})}function r(t){return Object(e["a"])({url:"/app/xlgl/peopleManagement/qxjUserInfoList",method:"post",data:t})}function n(t){return Object(e["a"])({url:"/app/xlgl/peopleManagementNew/organTreeList",method:"post",data:t})}function o(t){return Object(e["a"])({url:"/app/xlgl/peopleManagement/statistics",method:"post",data:t})}function c(t){return Object(e["a"])({url:"/app/xlgl/peopleManagementNew/organTreeListALL",method:"post",data:t})}function p(t){return Object(e["a"])({url:"/app/xlgl/peopleManagementNew/organTree",method:"post",data:t})}function u(t){return Object(e["a"])({url:"/app/xlgl/peopleManagementNew/platList",method:"post",data:t})}function d(t){return Object(e["a"])({url:"/app/xlgl/peopleManagementNew/getPlatNumber",method:"post",data:t})}function _(t){return Object(e["a"])({url:"/app/xlgl/syncPeople/shuaxin",method:"post",data:t})}function f(t){return Object(e["a"])({url:"/app/xlgl/peopleManagement/getStatisticsByDept",method:"post",data:t})}},d1ca:function(t,s,a){"use strict";var e=a("2c61"),i=a.n(e);i.a},d91d:function(t,s,a){"use strict";a.r(s);var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"posRel"},[a("el-card",{staticStyle:{height:"calc(98vh - 15px)",margin:"10px"},attrs:{"body-style":{padding:"0px 10px"}}},[a("title-card",{attrs:{"title-text":"各地区人员分布情况"}}),t._v(" "),a("el-button",{staticClass:"iconBack",attrs:{size:"mini"},on:{click:t.goBack}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"goback"}}),t._v("\n      返回上一级\n    ")],1),t._v(" "),a("el-row",{staticClass:"ma-t_20",attrs:{gutter:20}},[a("el-col",{attrs:{span:3}},[a("div",{staticClass:"organTree"},[a("div",{staticStyle:{height:"40px","line-height":"40px","padding-left":"15px"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px"},attrs:{"icon-class":"mulu"}})],1),t._v(" "),a("ul",[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"700px"}},t._l(t.mapTreeList,function(s,e){return a("li",{key:e,class:[e===t.ins?"active":"pd-l_30"],on:{click:function(a){return t.changeOrgan(s,e)}}},[t._v(t._s(s.plat.length>5?s.plat.substr(0,5):s.plat))])}),0)],1)])]),t._v(" "),a("el-col",{attrs:{span:21}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"recordNum"},[t._v("共查询到"),a("span",[t._v(t._s(t.recordNum))]),t._v("条人员记录")])]),t._v(" "),a("el-col",{attrs:{span:18}},[a("el-row",[a("el-form",{attrs:{model:t.listQuery,"label-position":"left","label-width":"100px"}},[a("el-col",{attrs:{span:6}},[a("el-date-picker",{attrs:{type:"date",size:"small",placeholder:"请选择日期",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd"},on:{change:t.getDate},model:{value:t.listQuery.timeStr,callback:function(s){t.$set(t.listQuery,"timeStr",s)},expression:"listQuery.timeStr"}})],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(s){t.showUserTree=s},expression:"showUserTree"}},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[a("el-tree",{ref:"userTree",attrs:{data:t.mapTreeData,props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]},on:{"node-click":t.handleNodeClick}})],1),t._v(" "),a("el-input",{staticStyle:{width:"200px"},attrs:{slot:"reference",size:"small",clearable:"",placeholder:"请选择单位"},on:{clear:t.clearNode},slot:"reference",model:{value:t.listQuery.organName,callback:function(s){t.$set(t.listQuery,"organName",s)},expression:"listQuery.organName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{size:"small",placeholder:"输入人员姓名",clearable:""},on:{clear:t.clearFn},nativeOn:{keyup:function(s){return!s.type.indexOf("key")&&t._k(s.keyCode,"enter",13,s.key,"Enter")?null:t.search(s)}},model:{value:t.listQuery.userName,callback:function(s){t.$set(t.listQuery,"userName",s)},expression:"listQuery.userName"}})],1)],1),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.searchFn}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"sousuo"}}),t._v("\n                查询\n              ")],1),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini"},on:{click:t.exportFn}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"18px",height:"13px","margin-bottom":"2px"},attrs:{"icon-class":"daochu"}}),t._v("\n                导出\n              ")],1)],1)],1)],1),t._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],staticClass:"ma-t_20",attrs:{data:t.tableList,border:"",fit:"",stripe:"","header-cell-style":{fontSize:"16px",color:"#333"},"highlight-current-rowstyle":"width: 100%;",height:"730"}},[a("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",align:"center",prop:"userName"}}),t._v(" "),a("el-table-column",{attrs:{label:"单位",align:"center",prop:"deptName"}}),t._v(" "),a("el-table-column",{attrs:{label:"部门",align:"center",prop:"organName"}}),t._v(" "),a("el-table-column",{attrs:{label:"手机号码",align:"center",prop:"phone"}}),t._v(" "),a("el-table-column",{attrs:{label:"当前位置",align:"center",prop:"location"}}),t._v(" "),a("el-table-column",{attrs:{label:"详细地址",align:"center",prop:"address"}}),t._v(" "),a("el-table-column",{attrs:{label:"在位状态",align:"center",prop:"status"}})],1)],1)],1)],1)],1)},i=[],l=(a("ac6a"),a("35b7")),r=a("c03e"),n={name:"PersonStatusJu",components:{TitleCard:l["a"]},props:{id:{type:String,default:""}},data:function(){return{mapTreeList:[],ins:0,listQuery:{userName:"",timeStr:"",organId:"",organName:""},isManager:this.$store.state.user.userInfo.adminFlag,recordNum:"",listLoading:!1,tableList:[],showUserTree:!1,mapTreeData:[],defaultProps:{children:"children",label:"text"}}},created:function(){this.getPlatNumber(),this.platList(),this.mapOrganTree()},methods:{getPlatNumber:function(){var t=this,s={parentId:"1"===this.isManager?"":this.$store.state.user.userInfo.juId};Object(r["b"])(s).then(function(s){t.mapTreeList=s.data.list,s.data.list.forEach(function(s,a){t.id===s.plat&&(t.ins=a)})})},platList:function(){var t=this;this.listLoading=!0;var s={parentId:"1"===this.isManager?"":this.$store.state.user.userInfo.juId,userName:this.listQuery.userName,timeStr:this.listQuery.timeStr,organId:this.listQuery.organId,province:this.id};Object(r["i"])(s).then(function(s){t.tableList=s.data.list,t.recordNum=s.data.list.length,setTimeout(function(){t.listLoading=!1},100)})},mapOrganTree:function(){var t=this;Object(r["f"])().then(function(s){t.mapTreeData=s.data.children})},handleNodeClick:function(t){this.listQuery.organId=t.id,this.listQuery.organName=t.text,this.showUserTree=!1,this.platList()},clearNode:function(){this.listQuery.organId="",this.platList()},clearFn:function(){this.platList()},getDate:function(t){this.listQuery.timeStr=t,this.platList()},goBack:function(){this.$emit("back","1")},changeOrgan:function(t,s){this.ins=s,this.id=t.plat,this.platList()},searchFn:function(){this.platList()},exportFn:function(){window.location.href="/app/xlgl/peopleManagementNew/exportPlat?parentId="+("1"===this.isManager?"":this.$store.state.user.userInfo.juId)+"&province="+this.id+"&timeStr="+this.listQuery.timeStr+"&access_token="+this.$store.state.user.token}}},o=n,c=(a("23258"),a("2877")),p=Object(c["a"])(o,e,i,!1,null,"2a70aab1",null);s["default"]=p.exports}}]);