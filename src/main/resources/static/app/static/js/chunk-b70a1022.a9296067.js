(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b70a1022"],{"07fa":function(t,e,a){},5580:function(t,e,a){"use strict";var n=a("07fa"),s=a.n(n);s.a},7814:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:12}},[a("el-col",{attrs:{span:19}},[0==t.isShow?a("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 15px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[a("title-card",{attrs:{"title-text":"个人训练档案"}}),t._v(" "),a("div",{staticClass:"title"},[t._v("军委装备发展部军事训练档案")]),t._v(" "),a("div",{staticStyle:{"text-align":"right","padding-right":"50px"}},[a("span",[t._v("年度")]),t._v(" "),a("span",[t._v(t._s(t.demoData.year?t.demoData.year:"2020"))])]),t._v(" "),a("table",{staticClass:"border-table"},[a("thead",[a("tr",[a("th",[t._v("\n                姓名\n              ")]),t._v(" "),a("th",[t._v("\n                "+t._s(t.demoData.currentUserName)+"\n              ")]),t._v(" "),a("th",[t._v("\n                单位\n              ")]),t._v(" "),a("th",{attrs:{colspan:"3"}},[t._v("\n                "+t._s(t.demoData.orgName)+"\n              ")]),t._v(" "),a("th",[t._v("\n                职务\n              ")]),t._v(" "),a("th")])]),t._v(" "),a("tbody",[a("tr",[a("td",{attrs:{colspan:"8"}},[t._v("单科目训练成绩")])]),t._v(" "),t._l(t.demoData.list,function(e){return[t._l(e.list,function(e,n){return["0"==n?a("tr",{key:n},[a("td",{attrs:{colspan:"4"}},[t._v(t._s(e.examineSubjectName))])]):t._e(),t._v(" "),"0"==n?a("tr",{key:n},[a("td",{attrs:{colspan:"2"}},[t._v("\n                    科目\n                  ")]),t._v(" "),a("td",{attrs:{colspan:"1"}},[t._v("\n                    成绩\n                  ")]),t._v(" "),a("td",{attrs:{colspan:"1"}},[t._v("\n                    主考\n                  ")])]):t._e(),t._v(" "),a("tr",{key:n},[a("td",{attrs:{colspan:"2"}},[t._v("\n                    "+t._s(e.examineName)+"\n                  ")]),t._v(" "),a("td",{attrs:{colspan:"1"}},[t._v("\n                    "+t._s(e.fractionSum)+"\n                  ")]),t._v(" "),a("td",{attrs:{colspan:"1"}},[t._v("\n                    "+t._s(e.userName)+"\n                  ")])])]})]}),t._v(" "),a("tr",[a("td",{attrs:{colspan:"3"}},[t._v("\n                总分\n              ")]),t._v(" "),a("td",{attrs:{colspan:"5"}},[t._v("\n                "+t._s(t.demoData.numberAll)+"\n              ")])])],2)]),t._v(" "),a("el-button",{staticClass:"viewBtn",attrs:{type:"primary",size:"small",icon:"el-icon-edit"},on:{click:t.showView}},[t._v("个人档案详情")])],1):t._e(),t._v(" "),1==t.isShow?a("personalFile",{on:{back:t.backList}}):t._e()],1),t._v(" "),a("el-col",{attrs:{span:5}},t._l(t.levelList,function(e,n){return a("div",{key:n,class:["flexCenter","userInfo","优秀"==e.level?"fine":"优良"==e.level?"excellent":"unQualified"]},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("p",{staticStyle:{"margin-left":"20px"}},[a("span",[t._v(t._s(e.text))]),a("br"),t._v(" "),a("span",{staticStyle:{"font-size":"14px"}},[t._v("统计获得等级")])])]),t._v(" "),a("span",{staticStyle:{"font-size":"28px"}},[t._v(t._s(e.level))])])}),0)],1)],1)},s=[],l=(a("ac6a"),a("35b7")),r=a("af45"),i=a("0fe1"),o={components:{TitleCard:l["a"],personalFile:r["default"]},data:function(){return{levelList:[{text:"强装兴装大讲堂",level:"优秀"},{text:"训练考核",level:"优良"},{text:"军事体育训练",level:"不及格"}],year:"2020年",isShow:0,demoData:{list:[],currentUserName:"",orgName:"",numberAll:"",year:""}}},created:function(){this.personalfileList()},methods:{personalfileList:function(){var t=this;Object(i["fb"])().then(function(e){var a=e.data,n=a.currentUserName,s=a.orgName,l=a.numberAll,r=a.year;Object.assign(t.demoData,{currentUserName:n,orgName:s,numberAll:l,year:r}),e.data.personalFileList.forEach(function(e,a){t.demoData.list.push(e)})})},showView:function(){this.isShow=1},backList:function(t){this.isShow=t}}},c=o,v=(a("5580"),a("2877")),_=Object(v["a"])(c,n,s,!1,null,"65677c61",null);e["default"]=_.exports}}]);