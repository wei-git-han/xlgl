(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4d7f8844","chunk-2d210108"],{"09a0":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticStyle:{overflow:"scroll"}},[i("div",{staticClass:"search-content"},[i("el-row",{attrs:{span:24}},[i("el-form",{attrs:{model:t.form,"label-width":"150px"}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"姓名："}},[i("el-input",{model:{value:t.form.userName,callback:function(e){t.$set(t.form,"userName",e)},expression:"form.userName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"单位："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.company,callback:function(e){t.$set(t.form,"company",e)},expression:"form.company"}},[i("el-option",{attrs:{label:"单位1",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"单位2",value:"1"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"报名状态："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.bmStatus,callback:function(e){t.$set(t.form,"bmStatus",e)},expression:"form.bmStatus"}},[i("el-option",{attrs:{label:"已报名",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"未报名",value:"1"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"参训状态："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.cxStatus,callback:function(e){t.$set(t.form,"cxStatus",e)},expression:"form.cxStatus"}},[i("el-option",{attrs:{label:"已参训",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"延迟参训",value:"1"}})],1)],1)],1)],1)],1),t._v(" "),i("div",{staticStyle:{"text-align":"right","padding-right":"30px"}},[i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")]),t._v(" "),i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{size:"small",icon:"el-icon-refresh"},on:{click:t.reset}},[t._v("重置")])],1)],1),t._v(" "),i("div",{staticClass:"tabList"},[i("el-row",[i("el-col",{attrs:{span:24}},[i("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[i("el-table-column",{attrs:{prop:"id",label:"信息系统综合员",align:"center",width:"180"}},[[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("已参训"+t._s(t.cxNum)+"人")]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("需补课人数"+t._s(t.bkNum)+"人")])]],2),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",{staticStyle:{cursor:"pointer"}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{prop:"yjs",align:"center",label:"已接收"}}),t._v(" "),i("el-table-column",{attrs:{prop:"wjs",align:"center",label:"未接收"}}),t._v(" "),i("el-table-column",{attrs:{prop:"sum",align:"center",label:"已报名"}}),t._v(" "),i("el-table-column",{attrs:{prop:"nsum",align:"center",label:"未报名"}}),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn","0"!=e.row.isConfirm?"color_active":"color_default"]},[t._v(t._s("0"==e.row.isConfirm?"未确认":"确认"))])])]}}])})],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)}}})],1)])},s=[],l=i("333d"),n=i("0fe1"),o={components:{Pagination:l["a"]},props:{infoId:{type:String,default:""}},data:function(){return{tableData:[],form:{userName:"",company:"",bmStatus:"",cxStatus:""},listQuery:{page:1,pagesize:10},total:0,bkNum:"",cxNum:"",confirm:""}},created:function(){this.getDateForJu()},methods:{objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,i=t.columnIndex;if(0===i)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},getDateForJu:function(){var t=this;Object(n["m"])({id:this.infoId}).then(function(e){t.tableData=e.data.listTotal,t.confirm=e.data.confirm,t.cxNum=e.data.ycx,t.bkNum=e.data.bk})},search:function(){},reset:function(){this.form=""},changeStatus:function(){}}},c=o,r=(i("9fd3"),i("2877")),d=Object(r["a"])(c,a,s,!1,null,"74dc07e2",null);e["default"]=d.exports},4788:function(t,e,i){"use strict";var a=i("6694"),s=i.n(a);s.a},"48fb":function(t,e,i){"use strict";i.d(e,"f",function(){return s}),i.d(e,"b",function(){return l}),i.d(e,"d",function(){return n}),i.d(e,"g",function(){return o}),i.d(e,"a",function(){return c}),i.d(e,"e",function(){return r}),i.d(e,"c",function(){return d});var a=i("b775");function s(t,e){return Object(a["a"])({url:"/statistics/".concat(t),method:"get",data:e})}function l(){return Object(a["a"])({url:"/statistics/inlineTable",method:"get"})}function n(){return Object(a["a"])({url:"/statistics/numList",method:"get"})}function o(){return Object(a["a"])({url:"/statistics/weaponList",method:"get"})}function c(){return Object(a["a"])({url:"/statistics/gradeList",method:"get"})}function r(){return Object(a["a"])({url:"/statistics/peopleGradeList",method:"get"})}function d(){return Object(a["a"])({url:"/statistics/lastInfo",method:"get"})}},6694:function(t,e,i){},6724:function(t,e,i){"use strict";i("8d41");var a="@@wavesContext";function s(t,e){function i(i){var a=Object.assign({},e.value),s=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},a),l=s.ele;if(l){l.style.position="relative",l.style.overflow="hidden";var n=l.getBoundingClientRect(),o=l.querySelector(".waves-ripple");switch(o?o.className="waves-ripple":(o=document.createElement("span"),o.className="waves-ripple",o.style.height=o.style.width=Math.max(n.width,n.height)+"px",l.appendChild(o)),s.type){case"center":o.style.top=n.height/2-o.offsetHeight/2+"px",o.style.left=n.width/2-o.offsetWidth/2+"px";break;default:o.style.top=(i.pageY-n.top-o.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",o.style.left=(i.pageX-n.left-o.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return o.style.backgroundColor=s.color,o.className="waves-ripple z-active",!1}}return t[a]?t[a].removeHandle=i:t[a]={removeHandle:i},i}var l={bind:function(t,e){t.addEventListener("click",s(t,e),!1)},update:function(t,e){t.removeEventListener("click",t[a].removeHandle,!1),t.addEventListener("click",s(t,e),!1)},unbind:function(t){t.removeEventListener("click",t[a].removeHandle,!1),t[a]=null,delete t[a]}},n=function(t){t.directive("waves",l)};window.Vue&&(window.waves=l,Vue.use(n)),l.install=n;e["a"]=l},"67e6":function(t,e,i){},"8d41":function(t,e,i){},9479:function(t,e,i){"use strict";var a=i("ec21"),s=i.n(a);s.a},"9fd3":function(t,e,i){"use strict";var a=i("b177"),s=i.n(a);s.a},b177:function(t,e,i){},b5fe:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{class:t.className,style:{height:t.height,width:t.width}})},s=[],l=i("313e"),n=i.n(l),o=i("a7dc");i("817d");var c=6e3,r={mixins:[o["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){for(var e=0;e<t.length;e++)this.xData.push(t[e].departName),this.yData.push(t[e].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=n.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:"各单位受训完成率分析",subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},dataZoom:[{type:"inside",start:0,throttle:50,minValueSpan:4,end:100}],xAxis:[{type:"category",data:this.xData,interval:0,axisTick:{alignWithLabel:!0},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12}}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new n.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:c}]})}}},d=r,p=i("2877"),u=Object(p["a"])(d,a,s,!1,null,null,null);e["default"]=u.exports},c3f7:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",[i("el-button",{staticStyle:{margin:"10px"},attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")]),t._v(" "),t.fileId?i("div",{staticClass:"div1"},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})]):i("div",{staticClass:"waitDiv"},[i("p",[t._v("你还未上传文件，请点击按钮上传")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{width:"360px",height:"220px","margin-bottom":"15px"},attrs:{"icon-class":"tixing"}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,name:"pdf",data:t.fileData,accept:".pdf","on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("注：只能上传word文件格式，且不超过500kb")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},s=[],l=i("0fe1"),n={data:function(){return{fileUrl:"/app/xlgl/xlglktap/uploadFile",fileData:{id:""},onlineFileUrl:"",fileId:"",fileDialog:!1}},created:function(){this.getFileList()},methods:{successFile:function(t){this.fileId=t.fileId},openDialog:function(){this.fileDialog=!0},errorFile:function(){},getFileList:function(){var t=this;Object(l["o"])().then(function(e){t.fileId=e.data.fileId,t.fileId&&t.downFile()})},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},downFile:function(){var t=this;Object(l["f"])({fileId:this.fileId}).then(function(e){t.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileId+"&access_token="+t.$store.state.user.token})},submitFile:function(){this.fileDialog=!1,this.downFile()}}},o=n,c=(i("4788"),i("2877")),r=Object(c["a"])(o,a,s,!1,null,"2c6c1d72",null);e["default"]=r.exports},d052:function(t,e,i){"use strict";var a=i("67e6"),s=i.n(a);s.a},da8e:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[0==t.isShow?i("el-row",{attrs:{gutter:12}},[i("el-col",{attrs:{span:19}},[i("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 105px)"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{attrs:{label:"大讲堂信息",name:"first"}}),t._v(" "),i("el-tab-pane",{attrs:{label:"历年课堂",name:"second"}}),t._v(" "),"1"==t.isManager?i("el-tab-pane",{attrs:{label:"课堂安排",name:"three"}}):t._e()],1)],1),t._v(" "),"three"!=t.activeName?i("div",[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","justify-content":"space-between","padding-bottom":"20px"}},[i("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName==='first'"}],model:{value:t.tabPosition,callback:function(e){t.tabPosition=e},expression:"tabPosition"}},[i("el-radio-button",{attrs:{label:"0"}},[t._v("未参加")]),t._v(" "),i("el-radio-button",{attrs:{label:"1"}},[t._v("历史学习")])],1),t._v(" "),i("div",[i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"请填写训练名称"},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),i("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.handleFilter}},[t._v("搜索")])],1),t._v(" "),i("el-dropdown",[i("el-button",{attrs:{type:"primary",size:"small"}},[t._v("\n                排序方式"),i("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),t._v(" "),i("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[i("el-dropdown-item",{attrs:{command:"1"}},[t._v("发布时间")]),t._v(" "),i("el-dropdown-item",{attrs:{command:"2"}},[t._v("热度")]),t._v(" "),i("el-dropdown-item",{attrs:{command:"3"}},[t._v("发布单位")])],1)],1)],1),t._v(" "),i("div",{staticClass:"videoList"},t._l(t.videoList,function(e,a){return i("div",{key:a,class:[0!=a?"ma-l_20":""]},[e.listPictureIds.length>0?i("div",t._l(e.listPictureIds,function(a,s){return i("div",{key:s,class:["videoCard",0!=s?"ma-l_20":""],on:{click:function(i){return t.toDetial(e,a)}}},[i("span",{class:["learnLabel","1"==e.baoming?"bg_active":"bg_default"]},[t._v(t._s("2"==e.baoming?"需补课":"未开始"))]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[a?i("video",{staticClass:"imgStyle",staticStyle:{"object-fit":"fill"},attrs:{controls:"controls"}},[i("source",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+a}})]):t._e()]),t._v(" "),i("div",{staticStyle:{"margin-top":"10px",padding:"0 10px","font-size":"16px",color:"#666"}},[i("p",{staticClass:"cardTitle"},[t._v(t._s(e.title.length>17?e.title.substr(0,17)+"...":e.title))])]),t._v(" "),i("div",{staticClass:"flex-center",staticStyle:{width:"100%",padding:"0 10px",color:"#99A6BF"}},[i("span",[t._v(t._s(e.sendPeople))]),t._v(" "),i("span",[t._v(t._s(e.startTime))])])])}),0):i("div",[i("div",{class:["videoCard",0!=a?"ma-l_20":""],on:{click:function(i){return t.toDetial(e)}}},[i("span",{class:["learnLabel","1"==e.baoming?"bg_active":"bg_default"]},[t._v(t._s("2"==e.baoming?"需补课":"未开始"))]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[e.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:e.picturePath}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"100%",height:"170px"},attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("span",{class:[e.isUpload?"status_start":""]},[t._v("未上传")])],1),t._v(" "),i("div",{staticStyle:{"margin-top":"10px",padding:"0 10px","font-size":"16px",color:"#666"}},[i("p",{staticClass:"cardTitle"},[t._v(t._s(e.title.length>17?e.title.substr(0,17)+"...":e.title))])]),t._v(" "),i("div",{staticClass:"flex-center",staticStyle:{width:"100%",padding:"0 10px",color:"#99A6BF"}},[i("span",[t._v(t._s(e.sendPeople))]),t._v(" "),i("span",[t._v(t._s(e.startTime))])])])])])}),0),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getList}})],1):i("div",[i("arrangeMent")],1)])],1),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"three"!==t.activeName,expression:"activeName!=='three'"}],attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("已完成")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人已完成训练")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.ywc))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("需补考")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人错过训练需补考")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.bk))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("各单位年度参训完成情况")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])])])],1)],1)],1):t._e(),t._v(" "),1===t.isShow?i("organAdd",{on:{back:t.backList}}):t._e(),t._v(" "),2===t.isShow?i("auditorView",{attrs:{"video-type":t.status,"info-id":t.infoId,"video-id":t.videoId},on:{back:t.backList}}):t._e(),t._v(" "),i("el-dialog",{attrs:{title:"各单位训练完成率统计",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:t.resetTemp}},[i("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)],1)},s=[],l=i("48fb"),n=i("0fe1"),o=i("6724"),c=i("333d"),r=i("dad1"),d=i("e3f3"),p=i("b5fe"),u=i("c3f7"),v={name:"ComplexTable",components:{Pagination:c["a"],organAdd:r["default"],auditorView:d["default"],FinishRate:p["default"],arrangeMent:u["default"]},directives:{waves:o["a"]},data:function(){return{list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10,type:"0",search:"",flag:"0"},importanceOptions:[1,2,3],temp:{id:void 0,importance:1,remark:"",timestamp:new Date,title:"",type:"",status:"published"},dialogFormVisible:!1,activeName:"first",tabPosition:"0",showList:!0,showAdd:!1,videoList:[],isShow:0,state:["未开始","需补课","需补课"],finishRateList:[],status:"",wcl:"",ywc:"",bk:"",infoId:"",videoId:"",isManager:""}},watch:{tabPosition:function(t){this.listQuery.type=t,this.getList()},activeName:function(t){"second"===t?(this.listQuery.flag="1",this.listQuery.type="",this.getList()):"first"===t&&(this.listQuery.flag="0",this.listQuery.type="0",this.tabPosition="0",this.getList())}},created:function(){this.getAuthor(),this.getList(),this.getWcl(),this.getFinishRateList()},mounted:function(){},methods:{getAuthor:function(){var t=this;Object(n["h"])().then(function(e){t.isManager=e.data})},getFinishRateList:function(){var t=this;Object(l["f"])("finishRateList").then(function(e){t.finishRateList=e.data})},getList:function(){var t=this;Object(n["rb"])(this.listQuery).then(function(e){t.videoList=e.data.result,t.total=e.data.result.length})},getWcl:function(){var t=this;Object(n["L"])().then(function(e){t.wcl=e.data.wcl,t.ywc=e.data.ywc,t.bk=e.data.bk})},handleFilter:function(){this.listQuery.page=1,this.getList()},resetTemp:function(){this.temp={id:void 0,importance:1,remark:"",timestamp:new Date,title:"",status:"published",type:""}},toDetial:function(t,e){this.isShow=2,this.infoId=t.infoId,this.videoId=e},backList:function(){this.isShow=0},showChart:function(){this.dialogFormVisible=!0}}},f=v,h=(i("9479"),i("2877")),m=Object(h["a"])(f,a,s,!1,null,null,null);e["default"]=m.exports},e3f3:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("el-row",{attrs:{gutter:10}},[i("el-col",{attrs:{span:19}},[i("div",{staticClass:"container"},[i("div",{staticClass:"header"},[i("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("span",[t._v("时间：")]),t._v(" "),i("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:8}},[i("span",[t._v("类型：")]),t._v(" "),i("span",[t._v("强装兴装大讲堂")])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"right"},attrs:{span:8}},[i("span",[t._v("播放次数：")]),t._v(" "),i("span",[t._v("168次")])])],1),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureId,expression:"pictureId"}],staticStyle:{"margin-top":"20px"}},[i("el-col",{attrs:{span:24}},[i("div",[i("video",{staticStyle:{height:"500px"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.pictureId,controls:"controls"}})])])],1)])]),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("100%")])]),t._v(" "),i("div",{staticClass:"peopleNum"},[i("div",{staticClass:"flex-center",staticStyle:{padding:"0 20px"}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("合计人数")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("在编人数统计")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v("320")])]),t._v(" "),i("div",{staticClass:"flex-center",staticStyle:{"border-top":"1px solid #ccc",padding:"10px"}},[i("div",{staticStyle:{flex:"1","border-right":"1px solid #ccc","text-align":"center",height:"40px","line-height":"40px"}},[i("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("已参训")]),t._v("    \n                "),i("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v("300")])]),t._v(" "),i("div",{staticStyle:{flex:"1","text-align":"center",height:"40px","line-height":"40px"}},[i("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("缺席")]),t._v("    \n                "),i("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v("24")])])]),t._v(" "),i("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.showView}},[t._v("查看详情 ＞")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("各单位年度参训完成情况")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureList.length>0,expression:"pictureList.length>0"}],staticStyle:{background:"#fff","border-radius":"5px","padding-bottom":"5px"}},[i("title-card",{attrs:{"title-text":"附件资料"}}),t._v(" "),t._l(t.pictureList,function(e,a){return i("div",{key:a},[i("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)])})],2)])],1)],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"人员参训情况清单",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("auditoriumList",{attrs:{"info-id":t.infoId}})],1)],1)},s=[],l=i("09a0"),n=i("35b7"),o=i("0fe1"),c={components:{auditoriumList:l["default"],TitleCard:n["a"]},props:{infoId:{type:String,default:""},videoId:{type:String,default:""}},data:function(){return{dialogFormVisible:!1,fileId:"",title:"",pictureId:"",exerciseTime:"",pictureList:[]}},created:function(){this.getPerData(),this.getInfo()},methods:{getPerData:function(){Object(o["s"])({fileId:this.infoId}).then(function(t){})},getInfo:function(){var t=this;Object(o["p"])({infoId:this.infoId,id:this.videoId}).then(function(e){t.title=e.data.title,t.exerciseTime=e.data.time,t.pictureId=e.data.xlglPicture?e.data.xlglPicture.pictureId:"",t.pictureList=e.data.list})},back:function(){this.$emit("back")},showView:function(){this.dialogFormVisible=!0},showChart:function(){}}},r=c,d=(i("d052"),i("2877")),p=Object(d["a"])(r,a,s,!1,null,"9946a712",null);e["default"]=p.exports},ec21:function(t,e,i){}}]);