(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-767be1a6","chunk-0d57e09f","chunk-7b489672"],{"09f4":function(t,e,a){"use strict";a.d(e,"a",function(){return l}),Math.easeInOutQuad=function(t,e,a,i){return t/=i/2,t<1?a/2*t*t+e:(t--,-a/2*(t*(t-2)-1)+e)};var i=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function s(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function n(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function l(t,e,a){var l=n(),o=t-l,r=20,c=0;e="undefined"===typeof e?500:e;var p=function t(){c+=r;var n=Math.easeInOutQuad(c,l,o,e);s(n),c<e?i(t):a&&"function"===typeof a&&a()};p()}},"0fe1":function(t,e,a){"use strict";a.d(e,"n",function(){return s}),a.d(e,"g",function(){return n}),a.d(e,"p",function(){return l}),a.d(e,"l",function(){return o}),a.d(e,"m",function(){return r}),a.d(e,"a",function(){return c}),a.d(e,"e",function(){return p}),a.d(e,"f",function(){return d}),a.d(e,"o",function(){return u}),a.d(e,"j",function(){return m}),a.d(e,"d",function(){return f}),a.d(e,"c",function(){return v}),a.d(e,"b",function(){return g}),a.d(e,"q",function(){return h}),a.d(e,"h",function(){return x}),a.d(e,"i",function(){return b}),a.d(e,"k",function(){return _});var i=a("b775");function s(t){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/save",method:"post",params:t})}function n(){return Object(i["a"])({url:"/app/base/dept/tree_onlyroot",method:"get"})}function l(t){return Object(i["a"])({url:"/app/xlgl/xlgldocumentzbjl/send",method:"post",params:t})}function o(t){return Object(i["a"])({url:"/app/xlgl/xlgldocumentzbjl/juList",method:"post",params:t})}function r(t){return Object(i["a"])({url:"/app/xlgl/xlgldocumentzbjl/personList",method:"post",params:t})}function c(t){return Object(i["a"])({url:"/app/xlgl/xlgldocumentzbjl/baoming",method:"post",data:t})}function p(t){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForDept",method:"post",params:t})}function d(t){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/getDateForJu",method:"post",data:t})}function u(t){return Object(i["a"])({url:"/app/xlgl/xlglurgentnotice/save",method:"post",params:t})}function m(t){return Object(i["a"])({url:"/app/xlgl/xlglurgentnotice/info",method:"get",params:t})}function f(t){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/getCxwcl",method:"get",params:t})}function v(t){return Object(i["a"])({url:"",method:"get",params:t})}function g(t){return Object(i["a"])({url:"",method:"get",params:t})}function h(){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/getDjtList",method:"get"})}function x(t){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/getInfo",method:"get",params:t})}function b(t){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/getPerData",method:"get",params:t})}function _(t){return Object(i["a"])({url:"/app/xlgl/xlglxlzzinfo/getWcl",method:"get",params:t})}},5522:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("div",{staticStyle:{position:"relative"}},[a("el-tabs",{staticStyle:{padding:"0 10px"},on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"训练详情",name:"first"}},[a("div",{staticStyle:{padding:"0 30px"}},[a("div",{staticClass:"header"},[a("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("span",[t._v("时间：")]),t._v(" "),a("span",[t._v("7月23日（周四）下午 14:45 开始")])]),t._v(" "),a("el-col",{attrs:{span:6}},[a("span",[t._v("类型：")]),t._v(" "),a("span",[t._v("强装兴装大讲堂")])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("主办单位：")]),t._v(" "),a("span",[t._v("办公厅训练管理处")])]),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:t.isManager,expression:"isManager"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[a("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),a("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),a("div",{staticStyle:{padding:"20px 40px"}},[a("div",{staticStyle:{"margin-top":"50px"}},[a("el-col",{attrs:{span:18}},[a("span",[t._v("训练课目 ：")]),t._v(" "),a("span",[t._v("根据年度“强装兴装大讲堂”安排，定于 7 月 23 日举办“强装兴装大讲堂”第 5 讲(总第 25 讲)。邀请国防大学原战役教研部马平主任围绕“抗美援朝战争战例研究”进行授课。")])])],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:18}},[a("p",[a("span",[t._v("参训人员：")]),t._v(" "),a("span",[t._v("依托办公信息系统“视频会议”软件组织，各单位自愿参加听课。")])]),t._v(" "),a("p",{staticStyle:{"margin-left":"80px"}},[t._v("①在京丰宾馆综合楼第四会议室设主会场，各厅局、载人航天工程办公室和装备技术国际交流中心各安排 3 人（不限职别）参加；")]),t._v(" "),a("p",{staticStyle:{"margin-left":"80px"}},[t._v("②其他人员在各自办公室，利用“视频会议”软件参加听讲。")]),t._v(" "),a("p",[a("span",[t._v("其他事项：")])]),t._v(" "),a("p",{staticStyle:{"margin-left":"80px"}},[t._v("①视频会议软件使用。会议开始前 15 分钟，在“视频会议”软件输入“202008”加入会议。会议期间，请打开摄像头，将麦克风置于静音状态。 ")]),t._v(" "),a("p",{staticStyle:{"margin-left":"80px"}},[t._v("②请各单位督促所属人员按时上线参会， 统一着短袖夏常服、不戴帽，保持军容严整、专心听课，届时将滚动播放各单位听课人员画面。请于 7 月 21 日 17 时前将在主会场听课人员名单和在线听课人数报办公厅训练管理处。")]),t._v(" "),a("p",[a("span",[t._v("联系人：邱庆福,")]),t._v(" "),a("span",[t._v("电话：301227，18701632186。")])]),t._v(" "),a("p",[t._v("2020 年 7 月 20 日")]),t._v(" "),a("p",[a("span",[t._v("参加单位：信息系统局、综合计划局、科研订购局、政治工作局")])]),t._v(" "),a("p",[a("span",[t._v("距离开始")]),t._v(" "),a("span",{staticStyle:{"font-size":"25px",color:"#F56C6C","margin-left":"10px"}},[t._v("05:20:56")])]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:"0"==t.xlType,expression:"xlType=='0'"}],attrs:{span:16}},[a("span",[t._v("会议链接:")]),t._v(" "),a("span",{staticStyle:{color:"#3377FF","margin-left":"10px"}},[t._v("http:\\2020728\\ZF-训练管理\\视频会议001")]),t._v(" "),a("span",{staticStyle:{color:"#3377FF",dispaly:"inline-block",border:"1px solid #7477FF",padding:"1px 8px","border-radius":"3px","margin-left":"10px",cursor:"pointer"}},[t._v("复制链接")])])]),t._v(" "),a("el-col",{attrs:{span:6}},[a("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId=cb915903c19b453caad500e09a680350"}}),t._v(" "),a("div",{staticStyle:{width:"70%",height:"160px",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),a("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","justify-content":"space-between","align-items":"center"}},[a("div",[a("img"),t._v(" "),a("span",{staticStyle:{"font-size":"12px"}},[t._v("关于改革开放记录《我们一起走....pdf")])])])]),t._v(" "),a("div",{staticStyle:{width:"70%",height:"160px",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("本单位补充说明")]),t._v(" "),a("textarea",{staticStyle:{width:"100%",height:"110px",border:"none",resize:"none",padding:"20px"}})])])],1),t._v(" "),0===t.listType?a("div",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary"},on:{click:t.forwardFn}},[t._v("转发")])],1):a("div",{staticStyle:{display:"flex","flex-direction":"row","margin-top":"30px"}},[a("div",{staticClass:"flexRight"},[a("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"success"},on:{click:t.signUp}},[t._v("报名")]),t._v(" "),a("el-popover",{attrs:{placement:"top",width:"200"},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[a("textarea",{directives:[{name:"model",rawName:"v-model",value:t.params.laterReason,expression:"params.laterReason"}],staticStyle:{width:"100%",height:"100%",border:"none",resize:"none"},attrs:{placeholder:"*请输入延后原因"},domProps:{value:t.params.laterReason},on:{input:function(e){e.target.composing||t.$set(t.params,"laterReason",e.target.value)}}}),t._v(" "),a("div",{staticStyle:{"text-align":"right",margin:"0"}},[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:t.confirmFn}},[t._v("确定")])],1),t._v(" "),a("el-button",{attrs:{slot:"reference"},slot:"reference"},[t._v("延后参训")])],1)],1),t._v(" "),a("div",{staticClass:"flexRight"},[a("el-button",{attrs:{size:"mini"},on:{click:t.lastInfo}},[t._v("上一篇")]),t._v(" "),a("el-button",{attrs:{size:"mini"},on:{click:t.nextInfo}},[t._v("下一篇")])],1)])],1)])]),t._v(" "),a("el-tab-pane",{attrs:{label:"训练情况跟踪",name:"second"}},[a("div",{staticStyle:{padding:"30px",display:"flex","align-items":"center"}},[a("el-col",{attrs:{span:8}},[a("span",[t._v("装备发展部各单位报名情况")])]),t._v(" "),a("el-col",{attrs:{span:3}},[a("span",[t._v("已报名：")]),t._v(" "),a("span",{staticStyle:{color:"#00BFBF","font-size":"30px"}},[t._v("266")])]),t._v(" "),a("el-col",{attrs:{span:3}},[a("span",[t._v("未报名：")]),t._v(" "),a("span",{staticStyle:{color:"#F56C6C","font-size":"30px"}},[t._v("112")])])],1),t._v(" "),a("div",{staticStyle:{"padding-left":"30px"}},[a("el-row",{attrs:{gutter:30}},[a("el-col",{attrs:{span:15}},[a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData6,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[a("el-table-column",{attrs:{prop:"id",label:"信息系统综合员",align:"center",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("div",{staticClass:"ta-c"},[a("span",{class:["labelBtn","0"==e.row.state?"color_active":"color_default"]},[t._v(t._s("0"==e.row.state?"已确认":"未确认"))])]),t._v(" "),a("div",{staticClass:"ta-c"},[t._v("已参训125人")]),t._v(" "),a("div",{staticClass:"ta-c"},[t._v("需补课人数24人")])]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"company",align:"center",label:"单位"}}),t._v(" "),a("el-table-column",{attrs:{prop:"acceptNum",align:"center",label:"已接收"}}),t._v(" "),a("el-table-column",{attrs:{prop:"notAcceptNum",align:"center",label:"未接收"}}),t._v(" "),a("el-table-column",{attrs:{prop:"applyNum",align:"center",label:"已报名"}}),t._v(" "),a("el-table-column",{attrs:{prop:"notApply",align:"center",label:"未报名"}}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("div",{staticClass:"ta-c"},[a("span",{class:["labelBtn","0"==e.row.state?"color_active":"color_default"]},[t._v(t._s("0"==e.row.state?"确认":"未确认"))])])]}}])})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-tree",{ref:"userTree",staticClass:"peopleView",attrs:{data:t.userTreeData,props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]}})],1)],1)],1)])],1),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1)])])},s=[],n=(a("c5f6"),a("0fe1")),l=a("a417"),o={components:{},props:{listType:{type:Number,default:0}},data:function(){return{activeName:"first",title:"“强装兴装大讲堂”第 5 讲(总第 25 讲)",tableData6:[{company:"综合处",applyNum:"12",notApply:"3",state:"0",acceptNum:"10",notAcceptNum:"2"},{company:"综合处",applyNum:"12",notApply:"3",state:"1",acceptNum:"10",notAcceptNum:"2"},{company:"综合处",applyNum:"12",notApply:"3",state:"1",acceptNum:"10",notAcceptNum:"2"},{company:"综合处",applyNum:"12",notApply:"3",state:"0",acceptNum:"10",notAcceptNum:"2"},{company:"综合处",applyNum:"12",notApply:"3",state:"1",acceptNum:"10",notAcceptNum:"2"}],isManager:!0,visible:!1,xlType:"0",defaultProps:{children:"children",label:"text"},userTreeData:[],params:{laterReason:"",infoId:"",subId:"",baoming:""},infoId:""}},created:function(){},methods:{getDateForDept:function(){Object(n["e"])(this.infoId).then(function(t){})},getDateForJu:function(){Object(n["f"])(this.infoId).then(function(t){})},getTree:function(){var t=this;Object(l["b"])().then(function(e){t.userTreeData=[e.data]})},handleClick:function(t){"1"===t.index&&(this.getTree(),this.getDateForDept(),this.getDateForJu())},back:function(){this.$emit("back",0)},objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,a=t.columnIndex;if(0===a)return e%5===0?{rowspan:5,colspan:1}:{rowspan:0,colspan:0}},editor:function(){},deleteFn:function(){Object(n["b"])(this.infoId).then(function(t){})},baoMing:function(){var t=this;Object(n["a"])(this.params).then(function(e){"success"===e.data.result?t.$message({message:"报名成功",type:"success"}):t.$message({message:"报名失败",type:"info"})})},signUp:function(){this.baoMing()},confirmFn:function(){""===this.params.laterReason?this.$message({message:"请输入延后原因",type:"info"}):(this.baoMing(),this.visible=!1)},forwardFn:function(){Object(n["c"])().then(function(t){})},lastInfo:function(){},nextInfo:function(){}}},r=o,c=(a("9f1f"),a("2877")),p=Object(c["a"])(r,i,s,!1,null,"25007e46",null);e["default"]=p.exports},"5a8a":function(t,e,a){},6314:function(t,e,a){},6724:function(t,e,a){"use strict";a("8d41");var i="@@wavesContext";function s(t,e){function a(a){var i=Object.assign({},e.value),s=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},i),n=s.ele;if(n){n.style.position="relative",n.style.overflow="hidden";var l=n.getBoundingClientRect(),o=n.querySelector(".waves-ripple");switch(o?o.className="waves-ripple":(o=document.createElement("span"),o.className="waves-ripple",o.style.height=o.style.width=Math.max(l.width,l.height)+"px",n.appendChild(o)),s.type){case"center":o.style.top=l.height/2-o.offsetHeight/2+"px",o.style.left=l.width/2-o.offsetWidth/2+"px";break;default:o.style.top=(a.pageY-l.top-o.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",o.style.left=(a.pageX-l.left-o.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return o.style.backgroundColor=s.color,o.className="waves-ripple z-active",!1}}return t[i]?t[i].removeHandle=a:t[i]={removeHandle:a},a}var n={bind:function(t,e){t.addEventListener("click",s(t,e),!1)},update:function(t,e){t.removeEventListener("click",t[i].removeHandle,!1),t.addEventListener("click",s(t,e),!1)},unbind:function(t){t.removeEventListener("click",t[i].removeHandle,!1),t[i]=null,delete t[i]}},l=function(t){t.directive("waves",n)};window.Vue&&(window.waves=n,Vue.use(l)),n.install=l;e["a"]=n},"7c66":function(t,e,a){"use strict";var i=a("5a8a"),s=a.n(i);s.a},"8d41":function(t,e,a){},"9f1f":function(t,e,a){"use strict";var i=a("e4d6"),s=a.n(i);s.a},a417:function(t,e,a){"use strict";a.d(e,"b",function(){return s}),a.d(e,"a",function(){return n});var i=a("b775");function s(){return Object(i["a"])({url:"/app/base/user/tree",method:"get"})}function n(){return Object(i["a"])({url:"/app/base/user/chuTree",method:"get"})}},b7c4:function(t,e,a){"use strict";var i=a("6314"),s=a.n(i);s.a},cc5e:function(t,e,a){"use strict";a.d(e,"c",function(){return s}),a.d(e,"d",function(){return n}),a.d(e,"a",function(){return l}),a.d(e,"b",function(){return o}),a.d(e,"g",function(){return r}),a.d(e,"f",function(){return c}),a.d(e,"e",function(){return p});var i=a("b775");function s(t){return Object(i["a"])({url:"/app/xlgl/roleset/list",method:"get",params:t})}function n(t){return Object(i["a"])({url:"/app/xlgl/roleset/saveOrUpdate",method:"get",params:t})}function l(t){return Object(i["a"])({url:"/app/xlgl/roleset/delete",method:"post",params:t})}function o(t){return Object(i["a"])({url:"/app/base/dept/syncTree",method:"post",params:t})}function r(t){return Object(i["a"])({url:"/app/base/user/list",method:"post",params:t})}function c(t){return Object(i["a"])({url:"/app/base/user/updateZbqk",method:"post",params:t})}function p(t){return Object(i["a"])({url:"/app/base/user/updateSfyx",method:"post",params:t})}},dad1:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("title-card",{attrs:{"title-text":"新增训练"}}),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("el-col",{attrs:{span:16}},[a("el-form",{ref:"form",attrs:{model:t.form,"label-width":"150px"}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"讲堂标题",required:""}},[a("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"训练类型",required:""}},[a("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changeType},model:{value:t.form.xltype,callback:function(e){t.$set(t.form,"xltype",e)},expression:"form.xltype"}},[a("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"训练时间",required:""}},[a("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},on:{change:t.getsTime},model:{value:t.form.exerciseTime,callback:function(e){t.$set(t.form,"exerciseTime",e)},expression:"form.exerciseTime"}})],1)],1),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:t.showUrl,expression:"showUrl"}],attrs:{span:10}},[a("el-form-item",{attrs:{label:"会议链接",required:""}},[a("el-input",{model:{value:t.form.meetingLine,callback:function(e){t.$set(t.form,"meetingLine",e)},expression:"form.meetingLine"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"训练科目"}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.form.exerciseIssue,callback:function(e){t.$set(t.form,"exerciseIssue",e)},expression:"form.exerciseIssue"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"参训人员"}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.form.joinPeople,callback:function(e){t.$set(t.form,"joinPeople",e)},expression:"form.joinPeople"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"其他事项"}},[a("ueditor",{model:{value:t.form.bz,callback:function(e){t.$set(t.form,"bz",e)},expression:"form.bz"}})],1)],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",[a("label",{staticStyle:{"font-size":"18px"}},[t._v("上传视频")]),t._v(" "),a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.uploadImg,limit:1,accept:".mp4",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n              将视频文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("p",{staticStyle:{"font-size":"12px"}},[t._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),t._v(" "),a("div",{staticStyle:{"margin-top":"20px"}},[a("label",{staticStyle:{"font-size":"18px"}},[t._v("上传封面")]),t._v(" "),a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.uploadImg,limit:1,accept:".png,.jpeg",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n              将图片文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("p",{staticStyle:{"font-size":"12px"}},[t._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),t._v(" "),a("div",{staticStyle:{"margin-top":"20px"}},[a("label",{staticStyle:{"font-size":"18px"}},[t._v("上传附件")]),t._v(" "),a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.uploadFile,accept:".word,.excel,.ofd",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n              将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("p",{staticStyle:{"font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)])],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"primary"},on:{click:t.saveFn}},[t._v("确认并分发")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},on:{click:t.cancel}},[t._v("取消")])],1),t._v(" "),a("el-dialog",{attrs:{title:"请选择下发局级单位",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:function(e){t.dialogFormVisible=!1}}},[a("el-tree",{attrs:{"show-checkbox":"",data:t.treeData,"node-key":"id",props:t.defaultProps},on:{"check-change":t.handleCheckChange}}),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.confirm}},[t._v("确定")]),t._v(" "),a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")])],1)],1)],1)])},s=[],n=a("0fe1"),l=a("35b7"),o=a("63f4"),r={components:{TitleCard:l["a"],Ueditor:o["a"]},data:function(){return{form:{title:"",xltype:"",exerciseTime:"",meetingLine:"",exerciseIssue:"",joinPeople:"",bz:"",picturePath:""},deptData:{fileId:"",idAndNames:"",deptIds:"",deptNames:""},dialogFormVisible:!1,defaultProps:{children:"children",label:"text"},treeData:[],nodeId:[],nodeName:[],fileId:[],fileType:[],radio:"",showUrl:!1}},methods:{getsTime:function(t){this.form.createDate=t},handleCheckChange:function(t,e){e&&(this.nodeId.push(t.id),this.nodeName.push(t.text))},changeType:function(t){this.showUrl="0"===t},saveFn:function(){var t=this;this.form.title?this.form.xltype?this.form.exerciseTime?"0"!==this.form.xltype||this.form.meetingLine?(this.form.pIds=this.fileId.join(","),this.form.type=this.fileType.join(","),this.form.picturePath="/app/xlgl/xlgldocumentfile/downLoad?fileId="+this.radio,Object(n["n"])(this.form).then(function(e){"success"===e.data.result?(t.$message({message:"新增成功",type:"success"}),t.dialogFormVisible=!0,Object(n["g"])().then(function(e){t.treeData=e.data.children})):(t.$message({message:"新增失败",type:"info"}),t.cancel())})):this.$message({message:"请填写会议链接",type:"info"}):this.$message({message:"请选择训练时间",type:"info"}):this.$message({message:"请选择训练类型",type:"info"}):this.$message({message:"请填写讲堂标题",type:"info"})},cancel:function(){var t=this;this.$confirm("确定要取消发送此通知吗，您填写的内容将被清空","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){t.form={}}).catch(function(){})},uploadImg:function(t,e){this.fileId.push(t.fileId),this.fileType.push(e.raw.type)},uploadFile:function(t,e){this.fileId.push(t.fileId),this.fileType.push(e.raw.type?e.raw.type:"docx")},confirm:function(){var t=this;this.deptData.deptIds=this.nodeId.join(","),this.deptData.deptNames=this.nodeName.join(","),Object(n["p"])(this.deptData).then(function(e){"success"===e.data.result?(t.$message({message:"分发成功",type:"success"}),t.dialogFormVisible=!1,t.cancel()):(t.$message({message:"分发失败",type:"info"}),t.dialogFormVisible=!1,t.cancel())})},deleteFn:function(t){},back:function(){this.$emit("back",0)}}},c=r,p=(a("7c66"),a("2877")),d=Object(p["a"])(c,i,s,!1,null,"ef51e118",null);e["default"]=d.exports},e4d6:function(t,e,a){},e7a7:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[0==t.isShow?a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:19}},[a("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 105px)"},attrs:{"body-style":{padding:"0px 10px"}}},[a("div",{staticStyle:{position:"relative"}},[a("el-tabs",{on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"待转发",name:"first"}}),t._v(" "),a("el-tab-pane",{attrs:{label:"我的训练",name:"second"}})],1),t._v(" "),a("div",{staticClass:"tips"},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"15px",height:"15px"},attrs:{"icon-class":"tishii"}}),t._v(" "),a("span",{staticStyle:{"margin-left":"5px"}},[t._v("通知公告：")]),t._v(" "),a("span",[t._v(t._s(t.urgencyInfo))])],1),t._v(" "),a("div",{staticStyle:{position:"absolute",right:"10px",top:"4px"}},[a("el-button",{staticClass:"addBtn noBorder",attrs:{type:"success",icon:"el-icon-plus",size:"small"},on:{click:t.addPage}},[t._v("新增")])],1)],1),t._v(" "),a("div",[a("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:1==t.tabIndex,expression:"tabIndex==1"}],model:{value:t.tabPosition,callback:function(e){t.tabPosition=e},expression:"tabPosition"}},[a("el-radio-button",{attrs:{label:"top"}},[t._v("未完结")]),t._v(" "),a("el-radio-button",{attrs:{label:"right"}},[t._v("历史学习")])],1),t._v(" "),a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),a("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择类型",size:"small",clearable:""},model:{value:t.listQuery.xltype,callback:function(e){t.$set(t.listQuery,"xltype",e)},expression:"listQuery.xltype"}},[a("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1),t._v(" "),a("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),a("div",{staticClass:"videoList"},t._l(t.videoList,function(e,i){return a("div",{key:i,class:["video_card",0!=i?"ma-l_20":""],on:{click:t.toDetial}},[a("span",{class:["learnLabel","1"==e.zhuanfaStatus?"bg_default":"bg_active"]},[t._v(t._s("1"==e.zhuanfaStatus?"待转发":"未接收"))]),t._v(" "),a("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[a("img",{staticClass:"imgStyle",attrs:{src:e.imgPath}}),t._v(" "),a("span",{staticClass:"status_start"},[t._v(t._s(e.kaishiStatus))])]),t._v(" "),a("div",{staticStyle:{padding:"0 10px 10px 10px"}},[a("p",{staticClass:"cardTitle"},[t._v(t._s(e.title))]),t._v(" "),a("p",{staticClass:"xltype"},[t._v(t._s(e.xltype))]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:"强装兴装大讲堂"==e.xltype,expression:"item.xltype=='强装兴装大讲堂'"}],staticClass:"flex-center"},[a("div",[a("span",{staticClass:"xltype"},[t._v(t._s(e.zjr))])]),t._v(" "),a("div",[a("span",{staticStyle:{"font-size":"14px",color:"#F56C6C"}},[t._v("倒计时")]),t._v(" "),a("span",{staticStyle:{"font-size":"14px",color:"#F56C6C",background:"#FEF0F0"}},[t._v(t._s(e.daojishi))])])]),t._v(" "),a("div",{staticClass:"flex-center ma-t_10"},[a("div",{staticClass:"flex-center"},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"13px",height:"13px"},attrs:{"icon-class":"shijian"}}),t._v(" "),a("span",{staticStyle:{color:"#99A6BF","margin-left":"10px"}},[t._v(t._s(e.kaixunTime))])],1),t._v(" "),a("div",{staticStyle:{"font-size":"13px",color:"#3377FF"}},[t._v("[详情]")])])])])}),0),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getList}})],1)],1),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-row",[a("el-col",{attrs:{span:24}},[a("div",{staticClass:"statistics"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("参训完成率")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("100%")])]),t._v(" "),a("div",{staticClass:"statistics"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("已完成")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人已完成训练")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("24")])]),t._v(" "),a("div",{staticClass:"statistics"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("需补考")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人错过训练需补考")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("0")])])])],1)],1),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-row",[a("el-col",{attrs:{span:24}},[a("div",{staticStyle:{background:"#fff","border-radius":"5px",border:"1px solid rgb(203, 225, 250)"}},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","padding-left":"20px"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"tongzhifabu"}}),t._v(" "),a("div",{staticStyle:{"margin-left":"10px"}},[a("p",[t._v("紧急通知公告")]),t._v(" "),a("p",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("编辑发布最新公告通知")])])],1),t._v(" "),a("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.addInfo}},[t._v("立即发布 ＞")])])])],1)],1),t._v(" "),a("el-dialog",{attrs:{title:"紧急通知公告",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:t.resetTemp}},[a("el-form",{ref:"dataForm",staticStyle:{margin:"0px 50px"},attrs:{model:t.temp,"label-position":"right","label-width":"100px"}},[a("el-form-item",{attrs:{label:"单位：",prop:"reDeptName"}},[a("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(e){t.showUserTree=e},expression:"showUserTree"}},[a("el-scrollbar",{staticStyle:{height:"400px"}},[a("el-tree",{ref:"userTree",attrs:{data:t.userTreeData,"show-checkbox":"",props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]}})],1),t._v(" "),a("el-input",{attrs:{slot:"reference",placeholder:"请选择公告通知范围",readonly:"readonly"},slot:"reference",model:{value:t.temp.reDeptName,callback:function(e){t.$set(t.temp,"reDeptName",e)},expression:"temp.reDeptName"}})],1)],1),t._v(" "),a("el-form-item",{attrs:{label:"内容："}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.temp.content,callback:function(e){t.$set(t.temp,"content",e)},expression:"temp.content"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.updateData}},[t._v("确定")]),t._v(" "),a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")])],1)],1)],1):t._e(),t._v(" "),1==t.isShow?a("organAdd",{on:{back:t.backList}}):t._e(),t._v(" "),2==t.isShow?a("organView",{attrs:{listType:t.tabIndex},on:{back:t.backList}}):t._e()],1)},s=[],n=(a("ac6a"),a("c5f6"),a("0fe1")),l=a("6724"),o=a("333d"),r=a("dad1"),c=a("5522"),p=a("cc5e"),d={name:"ComplexTable",components:{Pagination:o["a"],organAdd:r["default"],organView:c["default"]},directives:{waves:l["a"]},data:function(){return{list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10,search:"",xltype:""},temp:{content:"",reDeptId:"",reDeptName:[]},dialogFormVisible:!1,activeName:"first",tabPosition:"top",videoList:[{title:"标汇战役首长决心图",kaixunTime:"2020.07.06 8:00",daojishi:"05:20:56",zjr:"柯春娇",xltype:"强装兴装大讲堂",kaishiStatus:"未开始",zhuanfaStatus:"1",imgPath:"/app/xlgl/xlgldocumentfile/downLoad?fileId=cb915903c19b453caad500e09a680350"},{title:"标汇战役首长决心图",kaixunTime:"2020.07.06 8:00",daojishi:"05:20:56",zjr:"柯春娇",xltype:"日常军事训练",kaishiStatus:"已完结",zhuanfaStatus:"1",imgPath:"/app/xlgl/xlgldocumentfile/downLoad?fileId=cb915903c19b453caad500e09a680350"}],isShow:0,userTreeData:[],showUserTree:!1,defaultProps:{children:"children",label:"text"},tabIndex:0,urgencyInfo:"公公告公告公告公公公告公告公告公告公告公告公告告公公告公告公告公告公告公告公告告公公告公告公告公告告"}},created:function(){this.getList(),this.getViewInfo(),this.getCxwcl()},watch:{showUserTree:function(t){t||this.getCheckMenu()}},methods:{getList:function(){Object(n["l"])(this.listQuery).then(function(t){})},getCxwcl:function(){Object(n["d"])().then(function(t){})},getPersonList:function(){Object(n["m"])(this.listQuery).then(function(t){})},getViewInfo:function(){Object(n["j"])().then(function(t){})},search:function(){0===this.tabIndex?this.getList():this.getPersonList()},handleClick:function(t){this.tabIndex=Number(t.index),this.listQuery.search="",this.listQuery.xltype="",0===this.tabIndex?this.getList():this.getPersonList()},getTree:function(){var t=this;Object(p["b"])().then(function(e){t.userTreeData=e.data})},addPage:function(){this.isShow=1},toDetial:function(){this.isShow=2},backList:function(t){this.isShow=t},addInfo:function(){this.dialogFormVisible=!0,this.getTree()},resetTemp:function(){this.temp={}},getCheckMenu:function(){var t=this.$refs.userTree.getCheckedNodes(),e=[],a=[];t.forEach(function(t){a.push(t.id),e.push(t.text)}),this.temp.reDeptId=a.toString(),this.temp.reDeptName=e.toString()},updateData:function(){var t=this;this.temp.reDeptName.length<1?this.$message({message:"请选择公告通知范围",type:"info"}):Object(n["o"])(this.temp).then(function(e){"success"===e.data.result?(t.$message({message:"发布成功",type:"success"}),t.dialogFormVisible=!1,t.getViewInfo()):(t.$message({message:"发布失败",type:"info"}),t.dialogFormVisible=!1)})}}},u=d,m=(a("b7c4"),a("2877")),f=Object(m["a"])(u,i,s,!1,null,null,null);e["default"]=f.exports}}]);