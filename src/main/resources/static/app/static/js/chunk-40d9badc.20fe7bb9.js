(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-40d9badc"],{"050f":function(t,e,n){},"1fb9":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("el-row",{staticStyle:{"background-color":"#fff"}},[n("el-col",[n("div",{staticClass:"titleDIv"},[t._v("开训提醒设置")])])],1),t._v(" "),n("el-row",{staticStyle:{"background-color":"#fff",padding:"0 20px 20px 20px"}},[n("el-col",{attrs:{span:24}},[n("p",{staticStyle:{"font-size":"14px",color:"#333333"}},[t._v("开启提醒后，将默认按照设置的时间向报名训练人员消息中心发送提醒消息")]),t._v(" "),n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],attrs:{data:t.tableList,border:"",fit:"",stripe:""}},[n("el-table-column",{attrs:{label:"序号",type:"index",align:"center",width:"80"}}),t._v(" "),n("el-table-column",{attrs:{label:"提醒时间",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s("开训前"+e.row.remindTime))])]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",width:"80",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.row;return[n("el-switch",{attrs:{"active-color":"#409EFF","inactive-color":"#C0CCDA","active-value":a.remindTime,"inactive-value":"false"},on:{change:function(e){return t.changeStatus(a)}},model:{value:t.checkVal,callback:function(e){t.checkVal=e},expression:"checkVal"}})]}}])})],1)],1)],1)],1)},r=[],i=(n("ac6a"),n("cc5e")),c={name:"TrainingReminder",data:function(){return{tableList:[],listLoading:!1,checkVal:""}},created:function(){this.getTableList()},methods:{getTableList:function(){var t=this;this.listLoading=!0,Object(i["b"])().then(function(e){t.tableList=e.data,t.$nextTick(function(){e.data.forEach(function(e,n){"true"===e.state&&(t.checkVal=e.remindTime)}),setTimeout(function(){t.listLoading=!1},500)})})},changeStatus:function(t){var e=this;Object(i["f"])({id:t.id,state:"true"===t.state?"false":"true"}).then(function(t){"success"===t.data.msg?(e.$notify({title:"提示",message:"修改成功",duration:1500,type:"warning"}),e.getTableList()):(e.$notify({title:"提示",message:"修改失败",duration:1500,type:"warning"}),e.getTableList())})}}},l=c,o=(n("c741"),n("2877")),u=Object(o["a"])(l,a,r,!1,null,"25ebb3ed",null);e["default"]=u.exports},c741:function(t,e,n){"use strict";var a=n("050f"),r=n.n(a);r.a},cc5e:function(t,e,n){"use strict";n.d(e,"d",function(){return r}),n.d(e,"e",function(){return i}),n.d(e,"a",function(){return c}),n.d(e,"c",function(){return l}),n.d(e,"i",function(){return o}),n.d(e,"h",function(){return u}),n.d(e,"g",function(){return s}),n.d(e,"b",function(){return d}),n.d(e,"f",function(){return f});var a=n("b775");function r(t){return Object(a["a"])({url:"/app/xlgl/roleset/list",method:"get",params:t})}function i(t){return Object(a["a"])({url:"/app/xlgl/roleset/saveOrUpdate",method:"get",params:t})}function c(t){return Object(a["a"])({url:"/app/xlgl/roleset/delete",method:"post",data:t})}function l(t){return Object(a["a"])({url:"/app/base/dept/syncTree",method:"post",params:t})}function o(t){return Object(a["a"])({url:"/app/base/user/list",method:"post",data:t})}function u(t){return Object(a["a"])({url:"/app/base/user/updateZbqk",method:"post",data:t})}function s(t){return Object(a["a"])({url:"/app/base/user/updateSfyx",method:"post",data:t})}function d(t){return Object(a["a"])({url:"/app/xlgl/xlglmsgremind/list",method:"post",data:t})}function f(t){return Object(a["a"])({url:"/app/xlgl/xlglmsgremind/update",method:"post",data:t})}}}]);