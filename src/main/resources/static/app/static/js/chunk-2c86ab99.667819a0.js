(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2c86ab99"],{"551ce":function(t,e,i){},6724:function(t,e,i){"use strict";i("8d41");var a="@@wavesContext";function s(t,e){function i(i){var a=Object.assign({},e.value),s=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},a),n=s.ele;if(n){n.style.position="relative",n.style.overflow="hidden";var l=n.getBoundingClientRect(),o=n.querySelector(".waves-ripple");switch(o?o.className="waves-ripple":(o=document.createElement("span"),o.className="waves-ripple",o.style.height=o.style.width=Math.max(l.width,l.height)+"px",n.appendChild(o)),s.type){case"center":o.style.top=l.height/2-o.offsetHeight/2+"px",o.style.left=l.width/2-o.offsetWidth/2+"px";break;default:o.style.top=(i.pageY-l.top-o.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",o.style.left=(i.pageX-l.left-o.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return o.style.backgroundColor=s.color,o.className="waves-ripple z-active",!1}}return t[a]?t[a].removeHandle=i:t[a]={removeHandle:i},i}var n={bind:function(t,e){t.addEventListener("click",s(t,e),!1)},update:function(t,e){t.removeEventListener("click",t[a].removeHandle,!1),t.addEventListener("click",s(t,e),!1)},unbind:function(t){t.removeEventListener("click",t[a].removeHandle,!1),t[a]=null,delete t[a]}},l=function(t){t.directive("waves",n)};window.Vue&&(window.waves=n,Vue.use(l)),n.install=l;e["a"]=n},"8d41":function(t,e,i){},"8e38":function(t,e,i){"use strict";var a=i("551ce"),s=i.n(a);s.a},e7a7:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[0===t.isShow?i("div",[i("el-row",{attrs:{gutter:20}},[i("el-col",{attrs:{span:19}},[i("el-card",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],staticStyle:{height:"calc(98vh - 15px)"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},["2"===t.isManager?i("el-tab-pane",{attrs:{label:"待转发",name:"0"}}):t._e(),t._v(" "),i("el-tab-pane",{attrs:{label:"我的训练",name:"1"}}),t._v(" "),"1"===t.isManager?i("el-tab-pane",{attrs:{label:"全部",name:"2"}}):t._e()],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:""!==t.urgencyInfo,expression:"urgencyInfo!==''"}],staticClass:"tips",attrs:{title:t.urgencyInfo}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"15px",height:"15px"},attrs:{"icon-class":"tishii"}}),t._v(" "),i("span",{staticStyle:{"margin-left":"5px"}},[t._v("通知公告：")]),t._v(" "),i("span",[t._v(t._s(t.urgencyInfo.length>10?t.urgencyInfo.substr(0,10)+"...":t.urgencyInfo))])],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager,expression:"isManager==='1'"}],staticStyle:{position:"absolute",right:"10px",top:"5px"}},[i("el-button",{staticClass:"addBtn noBorder",attrs:{type:"success",icon:"el-icon-plus",size:"mini"},on:{click:t.addPage}},[t._v("新增")])],1)],1),t._v(" "),i("div",[i("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:"1"===t.activeName,expression:"activeName === '1'"}],attrs:{size:"small"},on:{change:t.changeType},model:{value:t.learnType,callback:function(e){t.learnType=e},expression:"learnType"}},[i("el-radio-button",{attrs:{label:"0"}},[t._v("未完结")]),t._v(" "),i("el-radio-button",{attrs:{label:"1"}},[t._v("历史学习")])],1),t._v(" "),i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.search(e)}},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),i("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择类型",size:"small",clearable:""},model:{value:t.listQuery.xltype,callback:function(e){t.$set(t.listQuery,"xltype",e)},expression:"listQuery.xltype"}},[i("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1),t._v(" "),i("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"mini",icon:"el-icon-search"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("div",{staticClass:"videoList"},t._l(t.videoList,function(e,a){return i("div",{key:a,staticClass:"videoCard",staticStyle:{display:"inline-block"},on:{click:function(i){return t.toDetial(e)}}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.activeName,expression:"activeName!=='2'"}],class:["learnLabel","0"===t.activeName||"0"===t.learnType?"bg_default":"bg_active"]},[t._v(t._s("0"===t.activeName?"待转发":"0"===t.learnType?"未开始":"已结束"))]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px",background:"#F9FBFE"}},[e.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.picturePath}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"50%",height:"50%","margin-top":"12.5%","margin-left":"25%"},attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"0"===t.activeName&&e.timeOUt,expression:"activeName==='0' && item.timeOUt"}],staticClass:"status_start"},[t._v("未开始")]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.activeName,expression:"activeName==='1'"}],staticClass:"status_start"},[t._v(t._s(t.bmStatus[e.sumStatus]))])],1),t._v(" "),i("div",[i("p",{staticClass:"cardTitle",attrs:{title:e.title}},[t._v(t._s(e.title))]),t._v(" "),i("p",{staticClass:"xltype"},[t._v(t._s("0"===e.xltype?"强装兴装大讲堂":"日常军事训练"))]),t._v(" "),i("p",{directives:[{name:"show",rawName:"v-show",value:"0"===t.activeName&&e.timeOUt,expression:"activeName === '0' && item.timeOUt"}],staticStyle:{padding:"0 10px"}},[i("span",{staticStyle:{color:"#F56C6C","font-size":"14px"}},[t._v("倒计时:")]),t._v(" "),i("span",{staticStyle:{"font-size":"14px",color:"#F56C6C",background:"#FEF0F0"}},[t._v(t._s(e.timeOUt))])]),t._v(" "),i("p",{directives:[{name:"show",rawName:"v-show",value:"0"===t.activeName&&!e.timeOUt,expression:"activeName === '0' && !item.timeOUt"}],staticStyle:{padding:"0 10px"}},[i("span",{staticStyle:{color:"#F56C6C","font-size":"14px"}},[t._v("已超时")])]),t._v(" "),i("div",{staticClass:"startDate"},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"13px",height:"13px"},attrs:{"icon-class":"shijian"}}),t._v(" "),i("span",{staticStyle:{color:"#99A6BF","margin-left":"10px"}},[t._v(t._s(e.exerciseTime))])],1)])])}),0)])],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getPageList}})],1)],1),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon wh_40",attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),i("div",{staticClass:"textClick fs_40 ff_d"},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon wh_40",attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("已完成")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人已完成训练")])])],1),t._v(" "),i("div",{staticClass:"textClick fs_40 ff_d"},[t._v(t._s(t.ywc))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon wh_40",attrs:{"icon-class":"benzhou"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("需补考")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人错过训练需补考")])])],1),t._v(" "),i("div",{staticClass:"textClick fs_40 ff_d"},[t._v(t._s(t.bk))])])])],1)],1),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager,expression:"isManager==='1'"}],attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticStyle:{background:"#fff","border-radius":"5px",border:"1px solid rgb(203, 225, 250)"}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","padding-left":"20px"}},[i("svg-icon",{staticClass:"icon wh_40",attrs:{"icon-class":"tongzhifabu"}}),t._v(" "),i("div",{staticStyle:{"margin-left":"10px"}},[i("p",[t._v("紧急通知公告")]),t._v(" "),i("p",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("编辑发布最新公告通知")])])],1),t._v(" "),i("div",{staticClass:"addInfo pointer",on:{click:t.addInfo}},[t._v("立即发布 ＞")])])])],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"紧急通知公告",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:t.resetTemp}},[i("el-form",{ref:"dataForm",staticStyle:{margin:"0px 50px"},attrs:{model:t.temp,"label-position":"right","label-width":"100px"}},[i("el-form-item",{attrs:{label:"单位：",prop:"reDeptName"}},[i("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(e){t.showUserTree=e},expression:"showUserTree"}},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[i("el-tree",{ref:"userTree",attrs:{data:t.userTreeData,"show-checkbox":"",props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]}})],1),t._v(" "),i("el-input",{attrs:{slot:"reference",placeholder:"请选择公告通知范围",readonly:"readonly"},slot:"reference",model:{value:t.temp.reDeptName,callback:function(e){t.$set(t.temp,"reDeptName",e)},expression:"temp.reDeptName"}})],1)],1),t._v(" "),i("el-form-item",{attrs:{label:"内容："}},[i("el-input",{attrs:{type:"textarea",maxlength:"1000",resize:"none"},model:{value:t.temp.content,callback:function(e){t.$set(t.temp,"content",e)},expression:"temp.content"}})],1)],1),t._v(" "),i("div",{staticClass:"text-center",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.updateData}},[t._v("确定")]),t._v(" "),i("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")])],1)],1)],1)],1):1===t.isShow?i("organAdd",{attrs:{id:t.file_id,"list-type":t.activeName},on:{back:t.backList}}):2===t.isShow?i("organView",{attrs:{"is-manager":t.isManager,"list-type":t.activeName,"info-id":t.id,"sub-id":t.subId,"file-id":t.fileId,flag:t.activeName},on:{back:t.backList,backAdd:t.toEditor}}):t._e()],1)},s=[],n=(i("a481"),i("ac6a"),i("0fe1")),l=i("6724"),o=i("333d"),r=i("dad1"),c=i("5522"),d={name:"ComplexTable",components:{Pagination:o["a"],organAdd:r["default"],organView:c["default"]},directives:{waves:l["a"]},data:function(){return{list:null,total:0,listQuery:{page:1,pagesize:10,search:"",xltype:""},learnType:"0",temp:{content:"",reDeptId:[],reDeptName:[]},dialogFormVisible:!1,activeName:"",videoList:[],isShow:0,userTreeData:[],showUserTree:!1,defaultProps:{children:"children",label:"text"},urgencyInfo:"",wcl:"",ywc:"",bk:"",id:"",subId:"",fileId:"",file_id:"",bmStatus:["已接收","未接收","已报名","延后参训","已参训"],isManager:"",isLoading:!1,timer:""}},watch:{activeName:function(t){"0"===t?(this.listQuery.type="",this.getList()):"1"===t?(this.learnType="0",this.getPersonList("0")):"2"===t&&this.getAllList(),this.listQuery.search="",this.listQuery.xltype=""},showUserTree:function(t){t||this.getCheckMenu()},isShow:function(t){0===t&&this.getCxwcl()}},created:function(){this.getAuthor(),this.getViewInfo(),this.getCxwcl()},mounted:function(){},methods:{getAuthor:function(){var t=this;Object(n["n"])().then(function(e){t.isManager=e.data,"2"===t.isManager?t.activeName="0":t.activeName="1"})},getList:function(){var t=this;this.isLoading=!0,Object(n["ab"])(this.listQuery).then(function(e){t.total=e.data.total,t.videoList=[],e.data.rows.forEach(function(e,i){t.videoList.push({read:e.read,picturePath:e.picturePath,xltype:e.xltype,title:e.title,exerciseTime:e.exerciseTime,infoId:e.infoId,id:e.id,subId:e.subId,sumStatus:e.sumStatus,timeOUt:t.delayTime(e.exerciseTime)})}),setTimeout(function(){t.isLoading=!1},1)})},delayTime:function(t){var e=t.replace(/-/g,"/"),i=(new Date).getTime(),a=new Date(e).getTime(),s=Math.floor(a-i),n=s,l=Math.floor(s/864e5);s%=864e5;var o=Math.floor(s/36e5);s%=36e5;var r=Math.floor(s/6e4);return s%=6e4,n>0?this.formatType(l)+"天"+this.formatType(o)+"小时"+this.formatType(r)+"分钟":""},formatType:function(t){return t>0&&t<10?"0"+t:""+t},changeType:function(t){this.getPersonList(t)},getCxwcl:function(){var t=this;Object(n["r"])().then(function(e){t.wcl=e.data.wcl,t.ywc=e.data.ywc,t.bk=e.data.bk})},getPersonList:function(t){var e=this;this.isLoading=!0,this.listQuery.type=t,Object(n["bb"])(this.listQuery).then(function(i){"0"===t?(e.videoList=[],i.data.rows.forEach(function(t,i){e.videoList.push({read:t.read,picturePath:t.picturePath,xltype:t.xltype,title:t.title,exerciseTime:t.exerciseTime,infoId:t.infoId,id:t.id,subId:t.subId,sumStatus:t.sumStatus,timeOUt:e.delayTime(t.exerciseTime)})})):(e.videoList=[],e.videoList=i.data.rows),e.total=i.data.total,e.listQuery.type="",setTimeout(function(){e.isLoading=!1},1)})},getAllList:function(){var t=this;this.isLoading=!0,this.videoList=[],Object(n["m"])(this.listQuery).then(function(e){t.videoList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},1)})},getViewInfo:function(){var t=this;Object(n["R"])().then(function(e){t.urgencyInfo=e.data.xlglUrgentNotice?e.data.xlglUrgentNotice.content:""})},search:function(){"0"===this.activeName?this.getList():"1"===this.activeName?this.getPersonList(this.learnType):"2"===this.activeName&&(this.type="",this.getAllList())},getTree:function(){var t=this;Object(n["u"])().then(function(e){t.userTreeData=e.data.children})},addPage:function(){this.isShow=1,this.file_id=""},toDetial:function(t){this.isShow=2,this.id=t.infoId,this.subId=t.id,this.fileId=t.subId},backList:function(t,e){this.isShow=t,"0"===e?(this.listQuery.type="",this.getList()):"1"===e?(this.learnType="0",this.getPersonList("0")):this.getAllList()},toEditor:function(t,e){this.isShow=t,this.file_id=e},addInfo:function(){this.dialogFormVisible=!0,this.getTree()},resetTemp:function(){this.temp={}},getCheckMenu:function(){var t=this.$refs.userTree.getCheckedNodes(),e=[],i=[];t.forEach(function(t){i.push(t.id),e.push(t.text)}),this.temp.reDeptId=i.toString(),this.temp.reDeptName=e.toString()},updateData:function(){var t=this;this.temp.reDeptName.length<1?this.$notify({title:"提示",message:"请选择公告通知范围",duration:1500,type:"warning"}):""!==this.temp.content?Object(n["sb"])(this.temp).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"发布成功",duration:1500,type:"success"}),t.dialogFormVisible=!1,t.getViewInfo()):(t.$notify({title:"提示",message:"发布失败",duration:1500,type:"warning"}),t.dialogFormVisible=!1)}):this.$notify({title:"提示",message:"请输入公告内容",duration:1500,type:"warning"})},getPageList:function(){"0"===this.activeName?this.getList():"1"===this.activeName?this.getPersonList(this.learnType):this.getAllList()}}},p=d,u=(i("8e38"),i("2877")),v=Object(u["a"])(p,a,s,!1,null,"25b110b6",null);e["default"]=v.exports}}]);