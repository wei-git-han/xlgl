(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5f5099de","chunk-2d0d0ba5","chunk-2d237873"],{"105d":function(e,t,n){"use strict";n.r(t);var o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"icons-container"},[e._m(0),e._v(" "),n("el-tabs",{attrs:{type:"border-card"}},[n("el-tab-pane",{attrs:{label:"Icons"}},e._l(e.svgIcons,function(t){return n("div",{key:t,on:{click:function(n){e.handleClipboard(e.generateIconCode(t),n)}}},[n("el-tooltip",{attrs:{placement:"top"}},[n("div",{attrs:{slot:"content"},slot:"content"},[e._v("\n            "+e._s(e.generateIconCode(t))+"\n          ")]),e._v(" "),n("div",{staticClass:"icon-item"},[n("svg-icon",{attrs:{"icon-class":t,"class-name":"disabled"}}),e._v(" "),n("span",[e._v(e._s(t))])],1)])],1)}),0),e._v(" "),n("el-tab-pane",{attrs:{label:"Element-UI Icons"}},e._l(e.elementIcons,function(t){return n("div",{key:t,on:{click:function(n){e.handleClipboard(e.generateElementIconCode(t),n)}}},[n("el-tooltip",{attrs:{placement:"top"}},[n("div",{attrs:{slot:"content"},slot:"content"},[e._v("\n            "+e._s(e.generateElementIconCode(t))+"\n          ")]),e._v(" "),n("div",{staticClass:"icon-item"},[n("i",{class:"el-icon-"+t}),e._v(" "),n("span",[e._v(e._s(t))])])])],1)}),0)],1)],1)},c=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("aside",[n("a",{attrs:{href:"https://panjiachen.github.io/xlgl-site/guide/advanced/icon.html",target:"_blank"}},[e._v("Add and use\n    ")])])}],a=n("fc00"),r=n("68e2"),s=n("2b0e"),i=n("b311"),l=n.n(i);function u(){s["default"].prototype.$message({message:"Copy successfully",type:"success",duration:1500})}function d(){s["default"].prototype.$message({message:"Copy failed",type:"error"})}function f(e,t){var n=new l.a(t.target,{text:function(){return e}});n.on("success",function(){u(),n.destroy()}),n.on("error",function(){d(),n.destroy()}),n.onClick(t)}var p={name:"Icons",data:function(){return{svgIcons:a["default"],elementIcons:r["default"]}},methods:{generateIconCode:function(e){return'<svg-icon icon-class="'.concat(e,'" />')},generateElementIconCode:function(e){return'<i class="el-icon-'.concat(e,'" />')},handleClipboard:function(e,t){f(e,t)}}},m=p,v=(n("c32f"),n("2877")),g=Object(v["a"])(m,o,c,!1,null,"80c28304",null);t["default"]=g.exports},"68e2":function(e,t,n){"use strict";n.r(t);var o=["info","error","success","warning","question","back","arrow-left","arrow-down","arrow-right","arrow-up","caret-left","caret-bottom","caret-top","caret-right","d-arrow-left","d-arrow-right","minus","plus","remove","circle-plus","remove-outline","circle-plus-outline","close","check","circle-close","circle-check","circle-close-outline","circle-check-outline","zoom-out","zoom-in","d-caret","sort","sort-down","sort-up","tickets","document","goods","sold-out","news","message","date","printer","time","bell","mobile-phone","service","view","menu","more","more-outline","star-on","star-off","location","location-outline","phone","phone-outline","picture","picture-outline","delete","search","edit","edit-outline","rank","refresh","share","setting","upload","upload2","download","loading"];t["default"]=o},a721:function(e,t,n){},c32f:function(e,t,n){"use strict";var o=n("a721"),c=n.n(o);c.a},fc00:function(e,t,n){"use strict";n.r(t);n("4917"),n("ac6a");var o=n("51ff"),c=function(e){return e.keys()},a=/\.\/(.*)\.svg/,r=c(o).map(function(e){return e.match(a)[1]});t["default"]=r}}]);