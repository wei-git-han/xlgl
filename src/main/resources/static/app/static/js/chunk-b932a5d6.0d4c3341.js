(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b932a5d6","chunk-2d210108"],{"09a0":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}]},[i("el-row",{staticClass:"search-content"},[i("el-row",{attrs:{span:24}},[i("el-form",{attrs:{model:t.form,"label-width":"150px"}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"姓名："}},[i("el-input",{model:{value:t.form.receiverName,callback:function(e){t.$set(t.form,"receiverName",e)},expression:"form.receiverName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"单位："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.recDeptId,callback:function(e){t.$set(t.form,"recDeptId",e)},expression:"form.recDeptId"}},t._l(t.treeData,function(t,e){return i("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"报名状态："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.baoming,callback:function(e){t.$set(t.form,"baoming",e)},expression:"form.baoming"}},[i("el-option",{attrs:{label:"已接收",value:"3"}}),t._v(" "),i("el-option",{attrs:{label:"未接收",value:"2"}}),t._v(" "),i("el-option",{attrs:{label:"已报名",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"延后参训",value:"1"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"参训状态："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.isWork,callback:function(e){t.$set(t.form,"isWork",e)},expression:"form.isWork"}},[i("el-option",{attrs:{label:"已参训",value:"1"}}),t._v(" "),i("el-option",{attrs:{label:"延迟参训",value:"0"}})],1)],1)],1)],1)],1),t._v(" "),i("div",{staticStyle:{"text-align":"right","padding-right":"30px"}},[i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")]),t._v(" "),i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{size:"small",icon:"el-icon-refresh"},on:{click:t.reset}},[t._v("重置")])],1)],1),t._v(" "),t.searchList.length>0?i("el-row",[i("el-col",{staticStyle:{"margin-left":"10%"},attrs:{span:16}},[i("el-table",{attrs:{border:"",data:t.searchList}},[i("el-table-column",{attrs:{property:"receiverName",align:"center",label:"人员姓名"}}),t._v(" "),i("el-table-column",{attrs:{label:"报名状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s("0"===e.row.baoming?"未报名":"已报名"))])]}}],null,!1,2703969559)}),t._v(" "),i("el-table-column",{attrs:{label:"参训状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s("0"===e.row.isWork?"延后参训":"已参训"))])]}}],null,!1,370898783)}),t._v(" "),i("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}],null,!1,3001370467)})],1)],1)],1):i("el-row",[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag==='1'"}],staticStyle:{"margin-top":"30px"},attrs:{"label-width":"85px"}},[i("el-form-item",{attrs:{label:"单位："}},[i("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changDep},model:{value:t.branchId,callback:function(e){t.branchId=e},expression:"branchId"}},t._l(t.treeData,function(t,e){return i("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1)],1)],1),t._v(" "),i("el-row",{staticStyle:{padding:"20px"}},[i("el-row",{attrs:{gutter:30,span:24}},[i("el-col",{staticStyle:{height:"calc(95vh - 220px)","overflow-y":"scroll"},attrs:{span:16}},[i("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[i("el-table-column",{attrs:{prop:"id",label:t.juName,align:"center",width:"180"}},[[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("已参训"+t._s(t.cxNum)+"人")]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("延后参训"+t._s(t.bkNum)+"人")])]],2),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",{staticStyle:{cursor:"pointer"},on:{click:function(i){return t.showPeople(e.row)}}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{prop:"cycx",align:"center",label:"已参训"}}),t._v(" "),i("el-table-column",{attrs:{prop:"cbk",align:"center",label:"延后参训"}})],1)],1),t._v(" "),i("el-col",{staticStyle:{height:"calc(95vh - 220px)","overflow-y":"scroll"},attrs:{span:8}},[i("el-table",{attrs:{data:t.juList}},[i("el-table-column",{attrs:{property:"truename",align:"center",label:"人员姓名"}}),t._v(" "),i("el-table-column",{attrs:{label:"报名状态",align:"center",width:"70"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.status?t.statusList[e.row.status]:"--"))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"参训状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status&&"2"!==e.row.status?i("el-select",{attrs:{placeholder:"请选择"},model:{value:e.row.sfcx,callback:function(i){t.$set(e.row,"sfcx",i)},expression:"scope.row.sfcx"}},[i("el-option",{attrs:{value:"0",label:"延后参训"}},[t._v("延后参训")]),t._v(" "),i("el-option",{attrs:{value:"1",label:"已参训"}},[t._v("已参训")])],1):i("span",[t._v("--")])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",{staticStyle:{"white-space":"nowrap","text-overflow":"ellipsis",overflow:"hidden",cursor:"pointer"},attrs:{title:e.row.reason}},[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",align:"center",width:"60"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{type:"text",size:"small",disabled:!e.row.status||"2"===e.row.status},on:{click:function(i){return t.updateStatus(e.row)}}},[t._v("修改")])]}}])})],1)],1)],1)],1)],1)],1)},n=[],o=(i("ac6a"),i("0fe1")),r={components:{},props:{infoId:{type:String,default:""}},data:function(){return{tableData:[],form:{receiverName:"",recDeptId:"",isWork:"",baoming:""},activeName:"first",juList:[],peopleList:[],visible:!1,params:{reason:"",infoId:"",subId:"",baoming:""},title:"",fbDept:"",xltype:"",exerciseTime:"",picturePath:"",bz:"",exerciseIssue:"",joinPeople:"",meetingLine:"",todeptName:"",pictureList:[],instraction:"",bmFlag:"",isLoading:!1,bkNum:"",cxNum:"",wbm:"",ybm:"",confirm:"",juConfirm:"",showEdit:0,adminFlag:this.$store.state.user.userInfo.adminFlag,isShow:!1,preId:"",sufId:"",branchId:"",treeData:[],juName:"",timeOUt:"",readFlag:!0,curTime:new Date,roleFlag:"",timeFlag:"",statusList:["已报名","延后参训","未接收","已接收"],cxStatusList:["延后参训","已参训"],searchList:[]}},created:function(){this.getRoleSet(),"1"===this.adminFlag?this.getOnlyRoot():this.getDateForJu()},methods:{getDateForJu:function(){var t=this;this.isLoading=!0,Object(o["t"])({id:this.infoId}).then(function(e){t.juList=e.data.listAllUser[0].listUser,t.tableData=e.data.listTotal,t.peopleList=e.data.listAllUser,t.bkNum=e.data.bk,t.cxNum=e.data.ycx,t.juConfirm=e.data.confirm,t.juName=e.data.juName,t.ybm=e.data.ybm,t.wbm=e.data.wbm,setTimeout(function(){t.isLoading=!1},500)})},changDep:function(){this.getDateForAll()},getDateForAll:function(){var t=this;this.isLoading=!0,Object(o["s"])({id:this.infoId,orgId:this.branchId}).then(function(e){"success"===e.data.result&&e.data.list&&e.data.list.length>0&&(t.tableData=e.data.list[0].listTotal,t.peopleList=e.data.list[0].listAllUser,t.juList=e.data.list[0].listAllUser[0].listUser,t.bkNum=e.data.list[0].bk,t.cxNum=e.data.list[0].ycx,t.confirm=e.data.list[0].confirm,t.juName=e.data.list[0].juName,t.ybm=e.data.list[0].ybm,t.wbm=e.data.list[0].wbm,setTimeout(function(){t.isLoading=!1},500))})},getRoleSet:function(){var t=this;Object(o["E"])().then(function(e){t.roleFlag=e.data.flag})},getOnlyRoot:function(){var t=this;Object(o["y"])().then(function(e){t.treeData=e.data.children,t.branchId=e.data.children[0].id,t.getDateForAll()})},objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,i=t.columnIndex;if(0===i)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},showPeople:function(t){var e=this;this.peopleList.forEach(function(i,a){i.deptName===t.deptName&&(e.juList=i.listUser,t.confirm?e.isShow=!1:e.isHaveButton(t.deptId))})},isHaveButton:function(t){var e=this;Object(o["bb"])({deptId:t}).then(function(t){t.data.result?e.isShow=!0:e.isShow=!1})},updateStatus:function(t){var e=this;Object(o["Hb"])({type:"1",status:t.sfcx,infoId:this.infoId,userId:t.id,isWork:"0"===t.isWork?"1":"0"}).then(function(t){"success"===t.data.result?e.$alert("状态修改成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}).catch(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}):"fail"===t.data.result?e.$confirm("当前修改用户无参训记录","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"confirm"===t.data.result?e.$confirm("管理员已确认，不能修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"no Perssion"===t.data.result&&e.$confirm("您没有权限修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){})})},search:function(){var t=this;""===this.form.receiverName&&""===this.form.recDeptId&&""===this.form.isWork&&""===this.form.baoming?this.$notify({title:"提示",message:"请输入搜索条件!",duration:1500,type:"warning"}):Object(o["sb"])(this.form).then(function(e){e.data&&e.data.length>0?t.searchList=e.data:(t.searchList=[],t.$notify({title:"提示",message:"没有搜索到相关数据!",duration:1500,type:"warning"}))})},reset:function(){this.form.receiverName="",this.form.recDeptId="",this.form.isWork="",this.form.baoming=""}}},s=r,l=(i("cdbe"),i("2877")),c=Object(l["a"])(s,a,n,!1,null,"38d7d4f4",null);e["default"]=c.exports},"5b4d":function(t,e,i){},"5c2b":function(t,e,i){},6485:function(t,e,i){"use strict";var a=i("5c2b"),n=i.n(a);n.a},b311:function(t,e,i){
/*!
 * clipboard.js v2.0.4
 * https://zenorocha.github.io/clipboard.js
 * 
 * Licensed MIT © Zeno Rocha
 */
(function(e,i){t.exports=i()})(0,function(){return function(t){var e={};function i(a){if(e[a])return e[a].exports;var n=e[a]={i:a,l:!1,exports:{}};return t[a].call(n.exports,n,n.exports,i),n.l=!0,n.exports}return i.m=t,i.c=e,i.d=function(t,e,a){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(i.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var n in t)i.d(a,n,function(e){return t[e]}.bind(null,n));return a},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="",i(i.s=0)}([function(t,e,i){"use strict";var a="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},n=function(){function t(t,e){for(var i=0;i<e.length;i++){var a=e[i];a.enumerable=a.enumerable||!1,a.configurable=!0,"value"in a&&(a.writable=!0),Object.defineProperty(t,a.key,a)}}return function(e,i,a){return i&&t(e.prototype,i),a&&t(e,a),e}}(),o=i(1),r=d(o),s=i(3),l=d(s),c=i(4),u=d(c);function d(t){return t&&t.__esModule?t:{default:t}}function f(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function p(t,e){if(!t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!e||"object"!==typeof e&&"function"!==typeof e?t:e}function h(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function, not "+typeof e);t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,enumerable:!1,writable:!0,configurable:!0}}),e&&(Object.setPrototypeOf?Object.setPrototypeOf(t,e):t.__proto__=e)}var m=function(t){function e(t,i){f(this,e);var a=p(this,(e.__proto__||Object.getPrototypeOf(e)).call(this));return a.resolveOptions(i),a.listenClick(t),a}return h(e,t),n(e,[{key:"resolveOptions",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};this.action="function"===typeof t.action?t.action:this.defaultAction,this.target="function"===typeof t.target?t.target:this.defaultTarget,this.text="function"===typeof t.text?t.text:this.defaultText,this.container="object"===a(t.container)?t.container:document.body}},{key:"listenClick",value:function(t){var e=this;this.listener=(0,u.default)(t,"click",function(t){return e.onClick(t)})}},{key:"onClick",value:function(t){var e=t.delegateTarget||t.currentTarget;this.clipboardAction&&(this.clipboardAction=null),this.clipboardAction=new r.default({action:this.action(e),target:this.target(e),text:this.text(e),container:this.container,trigger:e,emitter:this})}},{key:"defaultAction",value:function(t){return v("action",t)}},{key:"defaultTarget",value:function(t){var e=v("target",t);if(e)return document.querySelector(e)}},{key:"defaultText",value:function(t){return v("text",t)}},{key:"destroy",value:function(){this.listener.destroy(),this.clipboardAction&&(this.clipboardAction.destroy(),this.clipboardAction=null)}}],[{key:"isSupported",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:["copy","cut"],e="string"===typeof t?[t]:t,i=!!document.queryCommandSupported;return e.forEach(function(t){i=i&&!!document.queryCommandSupported(t)}),i}}]),e}(l.default);function v(t,e){var i="data-clipboard-"+t;if(e.hasAttribute(i))return e.getAttribute(i)}t.exports=m},function(t,e,i){"use strict";var a="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},n=function(){function t(t,e){for(var i=0;i<e.length;i++){var a=e[i];a.enumerable=a.enumerable||!1,a.configurable=!0,"value"in a&&(a.writable=!0),Object.defineProperty(t,a.key,a)}}return function(e,i,a){return i&&t(e.prototype,i),a&&t(e,a),e}}(),o=i(2),r=s(o);function s(t){return t&&t.__esModule?t:{default:t}}function l(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}var c=function(){function t(e){l(this,t),this.resolveOptions(e),this.initSelection()}return n(t,[{key:"resolveOptions",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};this.action=t.action,this.container=t.container,this.emitter=t.emitter,this.target=t.target,this.text=t.text,this.trigger=t.trigger,this.selectedText=""}},{key:"initSelection",value:function(){this.text?this.selectFake():this.target&&this.selectTarget()}},{key:"selectFake",value:function(){var t=this,e="rtl"==document.documentElement.getAttribute("dir");this.removeFake(),this.fakeHandlerCallback=function(){return t.removeFake()},this.fakeHandler=this.container.addEventListener("click",this.fakeHandlerCallback)||!0,this.fakeElem=document.createElement("textarea"),this.fakeElem.style.fontSize="12pt",this.fakeElem.style.border="0",this.fakeElem.style.padding="0",this.fakeElem.style.margin="0",this.fakeElem.style.position="absolute",this.fakeElem.style[e?"right":"left"]="-9999px";var i=window.pageYOffset||document.documentElement.scrollTop;this.fakeElem.style.top=i+"px",this.fakeElem.setAttribute("readonly",""),this.fakeElem.value=this.text,this.container.appendChild(this.fakeElem),this.selectedText=(0,r.default)(this.fakeElem),this.copyText()}},{key:"removeFake",value:function(){this.fakeHandler&&(this.container.removeEventListener("click",this.fakeHandlerCallback),this.fakeHandler=null,this.fakeHandlerCallback=null),this.fakeElem&&(this.container.removeChild(this.fakeElem),this.fakeElem=null)}},{key:"selectTarget",value:function(){this.selectedText=(0,r.default)(this.target),this.copyText()}},{key:"copyText",value:function(){var t=void 0;try{t=document.execCommand(this.action)}catch(e){t=!1}this.handleResult(t)}},{key:"handleResult",value:function(t){this.emitter.emit(t?"success":"error",{action:this.action,text:this.selectedText,trigger:this.trigger,clearSelection:this.clearSelection.bind(this)})}},{key:"clearSelection",value:function(){this.trigger&&this.trigger.focus(),window.getSelection().removeAllRanges()}},{key:"destroy",value:function(){this.removeFake()}},{key:"action",set:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"copy";if(this._action=t,"copy"!==this._action&&"cut"!==this._action)throw new Error('Invalid "action" value, use either "copy" or "cut"')},get:function(){return this._action}},{key:"target",set:function(t){if(void 0!==t){if(!t||"object"!==("undefined"===typeof t?"undefined":a(t))||1!==t.nodeType)throw new Error('Invalid "target" value, use a valid Element');if("copy"===this.action&&t.hasAttribute("disabled"))throw new Error('Invalid "target" attribute. Please use "readonly" instead of "disabled" attribute');if("cut"===this.action&&(t.hasAttribute("readonly")||t.hasAttribute("disabled")))throw new Error('Invalid "target" attribute. You can\'t cut text from elements with "readonly" or "disabled" attributes');this._target=t}},get:function(){return this._target}}]),t}();t.exports=c},function(t,e){function i(t){var e;if("SELECT"===t.nodeName)t.focus(),e=t.value;else if("INPUT"===t.nodeName||"TEXTAREA"===t.nodeName){var i=t.hasAttribute("readonly");i||t.setAttribute("readonly",""),t.select(),t.setSelectionRange(0,t.value.length),i||t.removeAttribute("readonly"),e=t.value}else{t.hasAttribute("contenteditable")&&t.focus();var a=window.getSelection(),n=document.createRange();n.selectNodeContents(t),a.removeAllRanges(),a.addRange(n),e=a.toString()}return e}t.exports=i},function(t,e){function i(){}i.prototype={on:function(t,e,i){var a=this.e||(this.e={});return(a[t]||(a[t]=[])).push({fn:e,ctx:i}),this},once:function(t,e,i){var a=this;function n(){a.off(t,n),e.apply(i,arguments)}return n._=e,this.on(t,n,i)},emit:function(t){var e=[].slice.call(arguments,1),i=((this.e||(this.e={}))[t]||[]).slice(),a=0,n=i.length;for(a;a<n;a++)i[a].fn.apply(i[a].ctx,e);return this},off:function(t,e){var i=this.e||(this.e={}),a=i[t],n=[];if(a&&e)for(var o=0,r=a.length;o<r;o++)a[o].fn!==e&&a[o].fn._!==e&&n.push(a[o]);return n.length?i[t]=n:delete i[t],this}},t.exports=i},function(t,e,i){var a=i(5),n=i(6);function o(t,e,i){if(!t&&!e&&!i)throw new Error("Missing required arguments");if(!a.string(e))throw new TypeError("Second argument must be a String");if(!a.fn(i))throw new TypeError("Third argument must be a Function");if(a.node(t))return r(t,e,i);if(a.nodeList(t))return s(t,e,i);if(a.string(t))return l(t,e,i);throw new TypeError("First argument must be a String, HTMLElement, HTMLCollection, or NodeList")}function r(t,e,i){return t.addEventListener(e,i),{destroy:function(){t.removeEventListener(e,i)}}}function s(t,e,i){return Array.prototype.forEach.call(t,function(t){t.addEventListener(e,i)}),{destroy:function(){Array.prototype.forEach.call(t,function(t){t.removeEventListener(e,i)})}}}function l(t,e,i){return n(document.body,t,e,i)}t.exports=o},function(t,e){e.node=function(t){return void 0!==t&&t instanceof HTMLElement&&1===t.nodeType},e.nodeList=function(t){var i=Object.prototype.toString.call(t);return void 0!==t&&("[object NodeList]"===i||"[object HTMLCollection]"===i)&&"length"in t&&(0===t.length||e.node(t[0]))},e.string=function(t){return"string"===typeof t||t instanceof String},e.fn=function(t){var e=Object.prototype.toString.call(t);return"[object Function]"===e}},function(t,e,i){var a=i(7);function n(t,e,i,a,n){var o=r.apply(this,arguments);return t.addEventListener(i,o,n),{destroy:function(){t.removeEventListener(i,o,n)}}}function o(t,e,i,a,o){return"function"===typeof t.addEventListener?n.apply(null,arguments):"function"===typeof i?n.bind(null,document).apply(null,arguments):("string"===typeof t&&(t=document.querySelectorAll(t)),Array.prototype.map.call(t,function(t){return n(t,e,i,a,o)}))}function r(t,e,i,n){return function(i){i.delegateTarget=a(i.target,e),i.delegateTarget&&n.call(t,i)}}t.exports=o},function(t,e){var i=9;if("undefined"!==typeof Element&&!Element.prototype.matches){var a=Element.prototype;a.matches=a.matchesSelector||a.mozMatchesSelector||a.msMatchesSelector||a.oMatchesSelector||a.webkitMatchesSelector}function n(t,e){while(t&&t.nodeType!==i){if("function"===typeof t.matches&&t.matches(e))return t;t=t.parentNode}}t.exports=n}])})},b5fe:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{class:t.className,style:{height:t.height,width:t.width}})},n=[],o=i("313e"),r=i.n(o),s=i("a7dc");i("817d");var l=6e3,c={mixins:[s["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0},chartTitle:{type:String,default:""}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){this.xData=[],this.yData=[];for(var e=0;e<t.length;e++)this.xData.push(t[e].departName),this.yData.push(t[e].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){this.xData=[],this.yData=[];for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=r.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:this.chartTitle,subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",data:this.xData,axisTick:{show:!1},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},rotate:20}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new r.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:l}]})}}},u=c,d=i("2877"),f=Object(d["a"])(u,a,n,!1,null,null,null);e["default"]=f.exports},c440:function(t,e,i){"use strict";var a=i("f47c"),n=i.n(a);n.a},cdbe:function(t,e,i){"use strict";var a=i("5b4d"),n=i.n(a);n.a},e3f3:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("el-row",{attrs:{gutter:10}},[i("el-col",{attrs:{span:19}},[i("div",{staticClass:"container"},[i("div",{staticClass:"header"},[i("div",{staticClass:"title",attrs:{title:t.title}},[t._v(t._s(t.title))]),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("span",[t._v("时间：")]),t._v(" "),i("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("类型：")]),t._v(" "),i("span",[t._v("强装兴装大讲堂")])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("主办单位：")]),t._v(" "),i("span",[t._v(t._s(t.zjdept))])]),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"===t.cxFlag&&t.videoIds,expression:"cxFlag==='2' && videoIds"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[i("span",[t._v("播放次数：")]),t._v(" "),i("span",[t._v(t._s(t.palyNum)+"次")])])],1),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag||"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag!=='2'||(cxFlag==='2'&&!videoIds)"}],attrs:{span:18}},[i("p",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag&&""!==t.timeOUt,expression:"cxFlag !== '2' && timeOUt !== '' "}]},[i("span",[t._v("距离开始：")]),t._v(" "),i("span",{staticStyle:{"font-size":"25px",color:"#F56C6C","margin-left":"10px"}},[t._v(t._s(t.timeOUt))])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag,expression:"cxFlag!=='2'"}],staticClass:"ma-t_20",attrs:{span:16}},[i("span",[t._v("会议链接：")]),t._v(" "),i("span",{staticStyle:{color:"#3377FF",cursor:"pointer"},on:{click:t.getUrl}},[t._v(t._s(t.meetingLine))]),t._v(" "),i("span",{staticStyle:{color:"#3377FF",dispaly:"inline-block",border:"1px solid #7477FF",padding:"1px 8px","border-radius":"3px","margin-left":"10px",cursor:"pointer"},on:{click:function(e){return t.handleClipboard(t.meetingLine,e)}}},[t._v("复制链接")])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"===t.bxFlag,expression:"bxFlag==='2'"}],staticClass:"ma-t_20"},[t._v("延后参训原因："+t._s(t.ykReason))]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag,expression:"cxFlag!=='2'"}]},[t._v("\n                    报名状态："),i("el-button",{attrs:{type:"text"}},[t._v(t._s(t.bxList[t.bxFlag]))])],1)]),t._v(" "),i("el-col",{staticClass:"ma-t_20",attrs:{span:18}},[t.videoIds&&"2"===t.cxFlag||t.videoIds&&!t.timeOUt?i("div",[i("video",{ref:"myVideo",staticStyle:{height:"500px",width:"100%"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoIds,controls:"controls"}})]):i("div",{staticStyle:{width:"80%",height:"500px"}},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag||"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag!=='2'||(cxFlag==='2'&&!videoIds)"}],attrs:{span:6}},[t.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:t.picturePath}}):i("div",{staticClass:"imgStyle",staticStyle:{background:"#F9FBFE"}},[i("svg-icon",{staticClass:"icon",staticStyle:{height:"50%",width:"50%","margin-left":"25%","margin-top":"12.5%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.mainFileList.length>0,expression:"mainFileList.length > 0"}],staticStyle:{width:"80%",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("主文件")]),t._v(" "),t._l(t.mainFileList,function(e,a){return i("div",{key:a,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(i){return t.downloadFile(e.pictureId)}}},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)})],2),t._v(" "),i("div",{staticStyle:{width:"80%",height:"160px",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("本单位补充说明")]),t._v(" "),i("textarea",{directives:[{name:"model",rawName:"v-model",value:t.instraction,expression:"instraction"}],staticStyle:{width:"100%",height:"110px",border:"none",resize:"none",padding:"15px"},attrs:{readonly:""},domProps:{value:t.instraction},on:{input:function(e){e.target.composing||(t.instraction=e.target.value)}}})])])],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag==='2' && !videoIds"}],staticStyle:{"text-align":"center"}},[i("el-button",{attrs:{type:"text"}},[t._v("需补课")]),t._v(" "),i("el-button",{attrs:{type:"text"}},[t._v("视频待上传")])],1)],1)],1)],1)],1)]),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本课程参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"peopleNum"},[i("div",{staticClass:"flex-center",staticStyle:{padding:"10px 20px"}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("合计人数")]),i("br")])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.peopleNum))])]),t._v(" "),i("div",{staticClass:"flex-center",staticStyle:{"border-top":"1px solid #ccc",padding:"10px"}},[i("div",{staticStyle:{flex:"1","border-right":"1px solid #ccc","text-align":"center",height:"40px","line-height":"40px"}},[i("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("已参训")]),t._v(" "),i("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v(t._s(t.ycmNum))])]),t._v(" "),i("div",{staticStyle:{flex:"1","text-align":"center",height:"40px","line-height":"40px"}},[i("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("缺席")]),t._v(" "),i("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v(t._s(t.qxNum))])])]),t._v(" "),i("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.showView}},[t._v("查看详情 ＞")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("各单位年度参训完成情况")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{background:"#fff","border-radius":"5px","padding-bottom":"5px"}},[i("title-card",{attrs:{"title-text":"附件资料"}}),t._v(" "),t._l(t.fileList,function(e,a){return i("div",{key:a,on:{click:function(i){return t.downloadFile(e.pictureId)}}},[i("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)])})],2)])],1)],1)],1),t._v(" "),i("el-dialog",{staticClass:"dialogList",attrs:{title:"人员参训情况清单",visible:t.dialogFormVisible,width:"80%"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("auditoriumList",{attrs:{"info-id":t.infoId}})],1),t._v(" "),i("el-dialog",{staticClass:"barChart",attrs:{title:"各单位训练完成率统计",visible:t.dialogchart},on:{"update:visible":function(e){t.dialogchart=e}}},[i("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)],1)},n=[],o=(i("a481"),i("7f7f"),i("ac6a"),i("c5f6"),i("09a0")),r=i("35b7"),s=i("b5fe"),l=i("f71e"),c=i("0fe1"),u={components:{auditoriumList:o["default"],TitleCard:r["a"],FinishRate:s["default"]},props:{infoId:{type:String,default:""},videoId:{type:String,default:""},cxFlag:{type:String,default:""},wcl:{type:Number,default:0}},data:function(){return{dialogFormVisible:!1,dialogchart:!1,fileId:"",title:"",videoIds:"",exerciseTime:"",zjdept:"",meetingLine:"",fileList:[],mainFileList:[],finishRateList:[],instraction:"",picturePath:"",palyNum:"1",bxFlag:"",ykReason:"",bxList:["未报名","已报名","延后参训"],symTime:"",videoTime:"",timeOUt:"",ycmNum:"",qxNum:"",peopleNum:"",timer1:"",onlineFileUrl:""}},created:function(){this.getPerData(),this.getInfo(),this.getPeopleNum()},mounted:function(){var t=this;this.$refs.myVideo.onplay=function(){},this.$refs.myVideo.ontimeupdate=function(){t.$refs.myVideo.currentTime-t.symTime>1&&(t.$refs.myVideo.currentTime=t.symTime),t.symTime=t.$refs.myVideo.currentTime},this.$refs.myVideo.onended=function(){t.updateStatusForDjt()}},methods:{getPeopleNum:function(){var t=this;Object(c["z"])({infoId:this.infoId}).then(function(e){t.ycmNum=e.data.ycm,t.qxNum=e.data.qx,t.peopleNum=e.data.sum})},getPerData:function(){Object(c["A"])({fileId:this.infoId}).then(function(t){})},getInfo:function(){var t=this;Object(c["w"])({infoId:this.infoId,id:this.videoId}).then(function(e){t.title=e.data.title,t.bxFlag=e.data.baoming,t.ykReason=e.data.reason,t.exerciseTime=e.data.time,t.zjdept=e.data.xlglXlzzInfo.zjdept,t.meetingLine=e.data.xlglXlzzInfo.meetingLine,t.picturePath=e.data.xlglXlzzInfo.picturePath,t.videoIds=e.data.xlglPicture?e.data.xlglPicture.pictureId:"",t.fileList=e.data.list,t.mainFileList=e.data.listMainFile,t.onlineFileUrl="/app/openFile/demo.html?fileId="+e.data.listMainFile[0].pictureId+"&access_token="+t.$store.state.user.token,t.timeOUt=t.delayTime()})},back:function(){this.$emit("back")},showView:function(){this.dialogFormVisible=!0},showChart:function(){var t=this;this.dialogchart=!0,Object(c["k"])({infoId:this.infoId}).then(function(e){"success"===e.data.result&&(t.finishRateList=[],e.data.list.forEach(function(e,i){t.finishRateList.push({departName:e.name,value:e.wcl})}))})},handleClipboard:function(t,e){Object(l["a"])(t,e)},getUrl:function(){"0"!==this.bxFlag?this.timeOUt&&"1"===this.bxFlag?this.$notify({title:"提示",message:"训练还未开始",duration:1500,type:"warning"}):(this.createHuiYi(),this.updateStatusForDjt()):this.$notify({title:"提示",message:"您还未报名，请先报名",duration:1500,type:"warning"})},createHuiYi:function(){var t=this;Object(c["e"])({xlglId:this.infoId}).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"发送会见视频消息成功",duration:1500,type:"success"}):t.$notify({title:"提示",message:"发送会见视频消息失败",duration:1500,type:"warning"})})},delayTime:function(){var t=this.exerciseTime.replace(/-/g,"/"),e=(new Date).getTime(),i=new Date(t).getTime(),a=Math.floor(i-e),n=a,o=Math.floor(a/864e5);a%=864e5;var r=Math.floor(a/36e5);a%=36e5;var s=Math.floor(a/6e4);return a%=6e4,n>0?this.formatType(o)+"天"+this.formatType(r)+"小时"+this.formatType(s)+"分钟":(clearInterval(this.timer1),"")},formatType:function(t){return t>0&&t<10?"0"+t:""+t},updateStatusForDjt:function(){Object(c["Ib"])({infoId:this.infoId}).then(function(t){})},downloadFile:function(t){window.location.href="xlgl/xlgldocumentfile/downLoad?fileId="+t+"&access_token="+this.$store.state.user.token}}},d=u,f=(i("6485"),i("c440"),i("2877")),p=Object(f["a"])(d,a,n,!1,null,"007a4b76",null);e["default"]=p.exports},f47c:function(t,e,i){},f71e:function(t,e,i){"use strict";i.d(e,"a",function(){return l});var a=i("2b0e"),n=i("b311"),o=i.n(n);function r(){a["default"].prototype.$message({message:"复制成功",type:"success",duration:1500})}function s(){a["default"].prototype.$message({message:"复制失败",type:"error"})}function l(t,e){var i=new o.a(e.target,{text:function(){return t}});i.on("success",function(){r(),i.destroy()}),i.on("error",function(){s(),i.destroy()}),i.onClick(e)}}}]);