(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0621ea62"],{"30a1":function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-table",{staticStyle:{width:"100%","padding-top":"15px"},attrs:{data:t.list}},[n("el-table-column",{attrs:{label:"Order_No","min-width":"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n      "+t._s(t._f("orderNoFilter")(e.row.order_no))+"\n    ")]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"Price",width:"195",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n      ¥"+t._s(t._f("toThousandFilter")(e.row.price))+"\n    ")]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"Status",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){var r=e.row;return[n("el-tag",{attrs:{type:t._f("statusFilter")(r.status)}},[t._v("\n        "+t._s(r.status)+"\n      ")])]}}])})],1)},a=[],s=n("828d"),u={filters:{statusFilter:function(t){var e={success:"success",pending:"danger"};return e[t]},orderNoFilter:function(t){return t.substring(0,30)}},data:function(){return{list:null}},created:function(){this.fetchData()},methods:{fetchData:function(){var t=this;Object(s["a"])().then(function(e){t.list=e.data.items.slice(0,8)})}}},l=u,i=n("2877"),c=Object(i["a"])(l,r,a,!1,null,null,null);e["default"]=c.exports},"828d":function(t,e,n){"use strict";n.d(e,"a",function(){return a});var r=n("b775");function a(t){return Object(r["a"])({url:"/transaction/list",method:"get",params:t})}}}]);