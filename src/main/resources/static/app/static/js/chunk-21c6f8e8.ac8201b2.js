(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-21c6f8e8"],{"22d2":function(t,a,e){},"5efa":function(t,a,e){"use strict";var n=e("22d2"),s=e.n(n);s.a},7814:function(t,a,e){"use strict";e.r(a);var n=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"app-container"},[0==t.isShow?e("el-row",[e("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 15px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[e("title-card",{attrs:{"title-text":"个人训练档案"}}),t._v(" "),e("el-button",{staticClass:"viewBtn",attrs:{type:"primary",size:"small",icon:"el-icon-edit"},on:{click:t.showView}},[t._v("个人档案详情")]),t._v(" "),e("el-row",[e("el-col",{staticClass:"elColStyle",attrs:{span:24}},[e("el-scrollbar",{staticClass:"hidden-x"},[e("div",{staticClass:"title"},[t._v("军委装备发展部军事训练档案")]),t._v(" "),e("div",{staticStyle:{"text-align":"right","padding-right":"50px"}},[e("span",[t._v("年度")]),t._v(" "),e("span",[t._v(t._s(t.demoData.year?t.demoData.year:"2020"))])]),t._v(" "),e("table",{staticClass:"border-table"},[e("thead",[e("tr",[e("th",[t._v("\n                    姓名\n                  ")]),t._v(" "),e("th",[t._v("\n                    "+t._s(t.demoData.currentUserName)+"\n                  ")]),t._v(" "),e("th",[t._v("\n                    单位\n                  ")]),t._v(" "),e("th",{attrs:{colspan:"3"}},[t._v("\n                    "+t._s(t.demoData.orgName)+"\n                  ")]),t._v(" "),e("th",[t._v("\n                    职务\n                  ")]),t._v(" "),e("th")])]),t._v(" "),e("tbody",[e("tr",[e("td",{attrs:{colspan:"8"}},[t._v("单科目训练成绩")])]),t._v(" "),t._l(t.demoData.list,function(a){return[t._l(a.list,function(a,n){return["0"==n?e("tr",{key:n},[e("td",{attrs:{colspan:"8"}},[t._v(t._s(a.examineSubjectName))])]):t._e(),t._v(" "),"0"==n?e("tr",{key:n},[e("td",{attrs:{colspan:"4"}},[t._v("\n                        科目\n                      ")]),t._v(" "),e("td",{attrs:{colspan:"2"}},[t._v("\n                        成绩\n                      ")]),t._v(" "),e("td",{attrs:{colspan:"2"}},[t._v("\n                        主考\n                      ")])]):t._e(),t._v(" "),e("tr",{key:n},[e("td",{attrs:{colspan:"4"}},[t._v("\n                        "+t._s(a.examineName)+"\n                      ")]),t._v(" "),e("td",{attrs:{colspan:"2"}},[t._v("\n                        "+t._s(a.fractionSum)+"\n                      ")]),t._v(" "),e("td",{attrs:{colspan:"2"}},[t._v("\n                        "+t._s(a.userName)+"\n                      ")])])]})]}),t._v(" "),e("tr",[e("td",{attrs:{colspan:"3"}},[t._v("\n                    总分\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"5"}},[t._v("\n                    "+t._s(t.demoData.numberAll)+"\n                  ")])])],2)])])],1)],1)],1)],1):t._e(),t._v(" "),1==t.isShow?e("el-row",[e("personalFile",{on:{back:t.backList}})],1):t._e()],1)},s=[],r=(e("ac6a"),e("35b7")),i=e("af45"),l=e("0fe1"),o={components:{TitleCard:r["a"],personalFile:i["default"]},data:function(){return{year:"2020年",isShow:0,demoData:{list:[],currentUserName:"",orgName:"",numberAll:"",year:""}}},created:function(){this.personalfileList()},methods:{personalfileList:function(){var t=this;Object(l["fb"])().then(function(a){var e=a.data,n=e.currentUserName,s=e.orgName,r=e.numberAll,i=e.year;Object.assign(t.demoData,{currentUserName:n,orgName:s,numberAll:r,year:i}),a.data.personalFileList.forEach(function(a,e){t.demoData.list.push(a)})})},showView:function(){this.isShow=1},backList:function(t){this.isShow=t}}},c=o,_=(e("5efa"),e("2877")),v=Object(_["a"])(c,n,s,!1,null,"73957864",null);a["default"]=v.exports}}]);