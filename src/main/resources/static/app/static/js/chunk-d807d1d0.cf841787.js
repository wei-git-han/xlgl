(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d807d1d0"],{7646:function(t,a,e){},7814:function(t,a,e){"use strict";e.r(a);var s=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"app-container"},[e("el-row",{attrs:{gutter:12}},[e("el-col",{attrs:{span:19}},[0==t.isShow?e("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 105px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[e("title-card",{attrs:{"title-text":"个人训练档案"}}),t._v(" "),e("div",{staticClass:"title"},[t._v("军委装备发展部军事训练档案")]),t._v(" "),e("div",{staticStyle:{"text-align":"right","padding-right":"50px"}},[e("span",[t._v("年度")]),t._v(" "),e("span",[t._v(t._s(t.demoData.year?t.demoData.year:"2020"))])]),t._v(" "),e("table",{staticClass:"border-table"},[e("thead",[e("tr",[e("th",[t._v("\n                姓名\n              ")]),t._v(" "),e("th",[t._v("\n                "+t._s(t.demoData.currentUserName)+"\n              ")]),t._v(" "),e("th",[t._v("\n                单位\n              ")]),t._v(" "),e("th",{attrs:{colspan:"3"}},[t._v("\n                "+t._s(t.demoData.orgName)+"\n              ")]),t._v(" "),e("th",[t._v("\n                职务\n              ")]),t._v(" "),e("th")])]),t._v(" "),e("tbody",[e("tr",[e("td",{attrs:{colspan:"8"}},[t._v("单科目训练成绩")])]),t._v(" "),t._l(parseInt(t.demoData.list.length/2),function(a){return[t._l(t.demoData.list[a-1].list,function(s,n){return["0"===n?e("tr",{key:n},[e("td",{attrs:{colspan:"4"}},[t._v(t._s(t.demoData.list[a-1].examineSubjectName))]),t._v(" "),e("td",{attrs:{colspan:"4"}},[t._v(t._s(t.demoData.list[a].examineSubjectName))])]):t._e(),t._v(" "),"0"==n?e("tr",{key:n},[e("td",{attrs:{colspan:"2"}},[t._v("\n                    科目\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    成绩\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    主考\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"2"}},[t._v("\n                    科目\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    成绩\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    主考\n                  ")])]):t._e(),t._v(" "),e("tr",{key:n},[e("td",{attrs:{colspan:"2"}},[t._v("\n                    "+t._s(s.examineName)+"\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    "+t._s(s.fractionSum)+"\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    "+t._s(s.userName)+"\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"2"}},[t._v("\n                    "+t._s(t.demoData.list[a].list[n]?t.demoData.list[a].list[n].examineName:"")+"\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    "+t._s(t.demoData.list[a].list[n]?t.demoData.list[a].list[n].fractionSum:"")+"\n                  ")]),t._v(" "),e("td",{attrs:{colspan:"1"}},[t._v("\n                    "+t._s(t.demoData.list[a].list[n]?t.demoData.list[a].list[n].userName:"")+"\n                  ")])])]})]}),t._v(" "),e("tr",[e("td",{attrs:{colspan:"3"}},[t._v("\n                总分\n              ")]),t._v(" "),e("td",{attrs:{colspan:"5"}},[t._v("\n                "+t._s(t.demoData.numberAll)+"\n              ")])])],2)]),t._v(" "),e("el-button",{staticClass:"viewBtn",attrs:{type:"primary",size:"small",icon:"el-icon-edit"},on:{click:t.showView}},[t._v("个人档案详情")])],1):t._e(),t._v(" "),1==t.isShow?e("personalFile",{on:{back:t.backList}}):t._e()],1),t._v(" "),e("el-col",{attrs:{span:5}},t._l(t.levelList,function(a,s){return e("div",{key:s,class:["flexCenter","userInfo","优秀"==a.level?"fine":"优良"==a.level?"excellent":"unQualified"]},[e("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[e("p",{staticStyle:{"margin-left":"20px"}},[e("span",[t._v(t._s(a.text))]),e("br"),t._v(" "),e("span",{staticStyle:{"font-size":"14px"}},[t._v("统计获得等级")])])]),t._v(" "),e("span",{staticStyle:{"font-size":"28px"}},[t._v(t._s(a.level))])])}),0)],1)],1)},n=[],l=(e("ac6a"),e("35b7")),i=e("af45"),r=e("0fe1"),o={components:{TitleCard:l["a"],personalFile:i["default"]},data:function(){return{levelList:[{text:"强装兴装大讲堂",level:"优秀"},{text:"训练考核",level:"优良"},{text:"军事体育训练",level:"不及格"}],year:"2020年",isShow:0,demoData:{list:[],currentUserName:"",orgName:"",numberAll:"",year:""}}},created:function(){this.personalfileList()},methods:{personalfileList:function(){var t=this;Object(r["fb"])().then(function(a){var e=a.data,s=e.currentUserName,n=e.orgName,l=e.numberAll,i=e.year;Object.assign(t.demoData,{currentUserName:s,orgName:n,numberAll:l,year:i}),a.data.personalFileList.forEach(function(a,e){t.demoData.list.push(a)})})},showView:function(){this.isShow=1},backList:function(t){this.isShow=t}}},c=o,_=(e("a153"),e("2877")),v=Object(_["a"])(c,s,n,!1,null,"1cec3029",null);a["default"]=v.exports},a153:function(t,a,e){"use strict";var s=e("7646"),n=e.n(s);n.a}}]);