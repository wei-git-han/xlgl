(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-26542658","chunk-2cb587ec"],{"060e":function(t,e,r){},5851:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"dashboard-editor-container"},[r("div",{staticClass:" clearfix"},[r("pan-thumb",{staticStyle:{float:"left"},attrs:{image:t.avatar}},[t._v("\n      Your roles:\n      "),t._l(t.roles,function(e){return r("span",{key:e,staticClass:"pan-info-roles"},[t._v(t._s(e))])})],2),t._v(" "),r("div",{staticClass:"info-container"},[r("span",{staticClass:"display_name"},[t._v(t._s(t.name))]),t._v(" "),r("span",{staticStyle:{"font-size":"20px","padding-top":"20px",display:"inline-block"}},[t._v("首页")])])],1),t._v(" "),r("div",[r("img",{staticClass:"emptyGif",attrs:{src:t.emptyGif}})])])},a=[],c=(r("8e6e"),r("ac6a"),r("456d"),r("bd86")),o=r("2f62"),s=r("3cbc");function i(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter(function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable})),r.push.apply(r,n)}return r}function l(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?i(r,!0).forEach(function(e){Object(c["a"])(t,e,r[e])}):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):i(r).forEach(function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))})}return t}var u={name:"DashboardEditor",components:{PanThumb:s["a"]},data:function(){return{emptyGif:""}},computed:l({},Object(o["b"])(["name","avatar","roles"]))},p=u,f=(r("5c6c"),r("2877")),b=Object(f["a"])(p,n,a,!1,null,"5d7a4176",null);e["default"]=b.exports},"5c6c":function(t,e,r){"use strict";var n=r("060e"),a=r.n(n);a.a},9406:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"dashboard-container"},[r(t.currentRole,{tag:"component"})],1)},a=[],c=(r("8e6e"),r("ac6a"),r("456d"),r("6762"),r("2fdb"),r("bd86")),o=r("2f62"),s=r("3f2c"),i=r("5851");function l(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter(function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable})),r.push.apply(r,n)}return r}function u(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?l(r,!0).forEach(function(e){Object(c["a"])(t,e,r[e])}):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):l(r).forEach(function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))})}return t}var p={name:"Dashboard",components:{adminDashboard:s["default"],editorDashboard:i["default"]},data:function(){return{currentRole:"adminDashboard"}},computed:u({},Object(o["b"])(["roles"])),created:function(){this.roles.includes("admin")||(this.currentRole="editorDashboard")}},f=p,b=r("2877"),d=Object(b["a"])(f,n,a,!1,null,null,null);e["default"]=d.exports}}]);