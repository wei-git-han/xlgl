(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ca738168","chunk-b133e068","chunk-2d2093eb"],{"32e1":function(t,e,i){},4788:function(t,e,i){"use strict";var s=i("6694"),a=i.n(s);a.a},"48fb":function(t,e,i){"use strict";i.d(e,"f",function(){return a}),i.d(e,"b",function(){return l}),i.d(e,"d",function(){return n}),i.d(e,"g",function(){return o}),i.d(e,"a",function(){return r}),i.d(e,"e",function(){return c}),i.d(e,"c",function(){return d});var s=i("b775");function a(t,e){return Object(s["a"])({url:"/statistics/".concat(t),method:"get",data:e})}function l(){return Object(s["a"])({url:"/statistics/inlineTable",method:"get"})}function n(){return Object(s["a"])({url:"/statistics/numList",method:"get"})}function o(){return Object(s["a"])({url:"/statistics/weaponList",method:"get"})}function r(){return Object(s["a"])({url:"/statistics/gradeList",method:"get"})}function c(){return Object(s["a"])({url:"/statistics/peopleGradeList",method:"get"})}function d(){return Object(s["a"])({url:"/statistics/lastInfo",method:"get"})}},6694:function(t,e,i){},6724:function(t,e,i){"use strict";i("8d41");var s="@@wavesContext";function a(t,e){function i(i){var s=Object.assign({},e.value),a=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},s),l=a.ele;if(l){l.style.position="relative",l.style.overflow="hidden";var n=l.getBoundingClientRect(),o=l.querySelector(".waves-ripple");switch(o?o.className="waves-ripple":(o=document.createElement("span"),o.className="waves-ripple",o.style.height=o.style.width=Math.max(n.width,n.height)+"px",l.appendChild(o)),a.type){case"center":o.style.top=n.height/2-o.offsetHeight/2+"px",o.style.left=n.width/2-o.offsetWidth/2+"px";break;default:o.style.top=(i.pageY-n.top-o.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",o.style.left=(i.pageX-n.left-o.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return o.style.backgroundColor=a.color,o.className="waves-ripple z-active",!1}}return t[s]?t[s].removeHandle=i:t[s]={removeHandle:i},i}var l={bind:function(t,e){t.addEventListener("click",a(t,e),!1)},update:function(t,e){t.removeEventListener("click",t[s].removeHandle,!1),t.addEventListener("click",a(t,e),!1)},unbind:function(t){t.removeEventListener("click",t[s].removeHandle,!1),t[s]=null,delete t[s]}},n=function(t){t.directive("waves",l)};window.Vue&&(window.waves=l,Vue.use(n)),l.install=n;e["a"]=l},"8d41":function(t,e,i){},9479:function(t,e,i){"use strict";var s=i("ec21"),a=i.n(s);a.a},a7dc:function(t,e,i){"use strict";i.r(e);var s=i("ed08");e["default"]={data:function(){return{$_sidebarElm:null}},mounted:function(){this.$_initResizeEvent(),this.$_initSidebarResizeEvent()},beforeDestroy:function(){this.$_destroyResizeEvent(),this.$_destroySidebarResizeEvent()},activated:function(){this.$_initResizeEvent(),this.$_initSidebarResizeEvent()},deactivated:function(){this.$_destroyResizeEvent(),this.$_destroySidebarResizeEvent()},methods:{$_resizeHandler:function(){var t=this;return Object(s["a"])(function(){t.chart&&t.chart.resize()},100)()},$_initResizeEvent:function(){window.addEventListener("resize",this.$_resizeHandler)},$_destroyResizeEvent:function(){window.removeEventListener("resize",this.$_resizeHandler)},$_sidebarResizeHandler:function(t){"width"===t.propertyName&&this.$_resizeHandler()},$_initSidebarResizeEvent:function(){this.$_sidebarElm=document.getElementsByClassName("sidebar-container")[0],this.$_sidebarElm&&this.$_sidebarElm.addEventListener("transitionend",this.$_sidebarResizeHandler)},$_destroySidebarResizeEvent:function(){this.$_sidebarElm&&this.$_sidebarElm.removeEventListener("transitionend",this.$_sidebarResizeHandler)}}}},b5fe:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{class:t.className,style:{height:t.height,width:t.width}})},a=[],l=i("313e"),n=i.n(l),o=i("a7dc");i("817d");var r=6e3,c={mixins:[o["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){for(var e=0;e<t.length;e++)this.xData.push(t[e].departName),this.yData.push(t[e].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=n.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:"各单位受训完成率分析",subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},dataZoom:[{type:"inside",start:0,throttle:50,minValueSpan:4,end:100}],xAxis:[{type:"category",data:this.xData,interval:0,axisTick:{alignWithLabel:!0},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12}}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new n.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:r}]})}}},d=c,p=i("2877"),u=Object(p["a"])(d,s,a,!1,null,null,null);e["default"]=u.exports},c3f7:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",[i("el-button",{staticStyle:{margin:"10px"},attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")]),t._v(" "),t.fileId?i("div",{staticClass:"div1"},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})]):i("div",{staticClass:"waitDiv"},[i("p",[t._v("你还未上传文件，请点击按钮上传")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{width:"360px",height:"220px","margin-bottom":"15px"},attrs:{"icon-class":"tixing"}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,name:"pdf",data:t.fileData,accept:".pdf","on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("注：只能上传word文件格式，且不超过500kb")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},a=[],l=i("0fe1"),n={data:function(){return{fileUrl:"/app/xlgl/xlglktap/uploadFile",fileData:{id:""},onlineFileUrl:"",fileId:"",fileDialog:!1}},created:function(){this.getFileList()},methods:{successFile:function(t){this.fileId=t.fileId},openDialog:function(){this.fileDialog=!0},errorFile:function(){},getFileList:function(){var t=this;Object(l["l"])().then(function(e){t.fileId=e.data.fileId,t.fileId&&t.downFile()})},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},downFile:function(){var t=this;Object(l["d"])({fileId:this.fileId}).then(function(e){t.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileId+"&access_token="+t.$store.state.user.token})},submitFile:function(){this.fileDialog=!1,this.downFile()}}},o=n,r=(i("4788"),i("2877")),c=Object(r["a"])(o,s,a,!1,null,"2c6c1d72",null);e["default"]=c.exports},da8e:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[0==t.isShow?i("el-row",{attrs:{gutter:12}},[i("el-col",{attrs:{span:19}},[i("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 105px)"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{attrs:{label:"大讲堂信息",name:"first"}}),t._v(" "),i("el-tab-pane",{attrs:{label:"历年课堂",name:"second"}}),t._v(" "),"1"==t.isManager?i("el-tab-pane",{attrs:{label:"课堂安排",name:"three"}}):t._e()],1)],1),t._v(" "),"three"!=t.activeName?i("div",[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","justify-content":"space-between","padding-bottom":"20px"}},[i("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName==='first'"}],model:{value:t.tabPosition,callback:function(e){t.tabPosition=e},expression:"tabPosition"}},[i("el-radio-button",{attrs:{label:"0"}},[t._v("未参加")]),t._v(" "),i("el-radio-button",{attrs:{label:"1"}},[t._v("历史学习")])],1),t._v(" "),i("div",[i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"请填写训练名称"},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),i("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.handleFilter}},[t._v("搜索")])],1),t._v(" "),i("el-dropdown",[i("el-button",{attrs:{type:"primary",size:"small"}},[t._v("\n                排序方式"),i("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),t._v(" "),i("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[i("el-dropdown-item",{attrs:{command:"1"}},[t._v("发布时间")]),t._v(" "),i("el-dropdown-item",{attrs:{command:"2"}},[t._v("热度")]),t._v(" "),i("el-dropdown-item",{attrs:{command:"3"}},[t._v("发布单位")])],1)],1)],1),t._v(" "),i("div",{staticClass:"videoList"},t._l(t.videoList,function(e,s){return i("div",{key:s,class:[0!=s?"ma-l_20":""],staticStyle:{display:"flex","flex-direction":"row"}},t._l(e.listPictureIds,function(s,a){return i("div",{key:a,class:["videoCard",0!=a?"ma-l_20":""],on:{click:function(i){return t.toDetial(e,s)}}},[i("span",{class:["learnLabel","1"==e.baoming?"bg_active":"bg_default"]},[t._v(t._s("2"==e.baoming?"需补课":"未开始"))]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[s?i("video",{staticClass:"imgStyle",staticStyle:{"object-fit":"fill"},attrs:{controls:"controls"}},[i("source",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+s}})]):e.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:e.picturePath}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"100%",height:"170px"},attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("span",{class:[e.isUpload?"status_start":""]},[t._v(t._s(e.isUpload?"未上传":""))])],1),t._v(" "),i("div",{staticStyle:{"margin-top":"10px",padding:"0 10px","font-size":"16px",color:"#666"}},[i("p",{staticClass:"cardTitle"},[t._v(t._s(e.title.length>17?e.title.substr(0,17)+"...":e.title))])]),t._v(" "),i("div",{staticClass:"flex-center",staticStyle:{width:"100%",padding:"0 10px",color:"#99A6BF"}},[i("span",[t._v(t._s(e.sendPeople))]),t._v(" "),i("span",[t._v(t._s(e.startTime))])])])}),0)}),0),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getList}})],1):i("div",[i("arrangeMent")],1)])],1),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"three"!=t.activeName,expression:"activeName!='three'"}],attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("已完成")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人已完成训练")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.ywc))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("需补考")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人错过训练需补考")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.bk))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("各单位年度参训完成情况")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])])])],1)],1)],1):t._e(),t._v(" "),1==t.isShow?i("organAdd",{on:{back:t.backList}}):t._e(),t._v(" "),2==t.isShow?i("auditorView",{attrs:{videoType:t.status,infoId:t.infoId,videoId:t.videoId},on:{back:t.backList}}):t._e(),t._v(" "),i("el-dialog",{attrs:{title:"各单位训练完成率统计",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:t.resetTemp}},[i("finish-rate",{attrs:{chartData:t.finishRateList}})],1)],1)},a=[],l=i("48fb"),n=i("0fe1"),o=i("6724"),r=i("333d"),c=i("dad1"),d=i("e3f3"),p=i("b5fe"),u=i("c3f7"),f={name:"ComplexTable",components:{Pagination:r["a"],organAdd:c["default"],auditorView:d["default"],FinishRate:p["default"],arrangeMent:u["default"]},directives:{waves:o["a"]},data:function(){return{list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10,type:"0",search:"",flag:"0"},importanceOptions:[1,2,3],temp:{id:void 0,importance:1,remark:"",timestamp:new Date,title:"",type:"",status:"published"},dialogFormVisible:!1,activeName:"first",tabPosition:"0",showList:!0,showAdd:!1,videoList:[],isShow:0,state:["未开始","需补课","需补课"],finishRateList:[],status:"",wcl:"",ywc:"",bk:"",infoId:"",videoId:"",isManager:""}},created:function(){this.getAuthor(),this.getList(),this.getWcl(),this.getFinishRateList()},watch:{tabPosition:function(t){this.listQuery.type=t,this.getList()},activeName:function(t){"second"===t?(this.listQuery.flag="1",this.listQuery.type="",this.getList()):"first"===t&&(this.listQuery.flag="0",this.listQuery.type="0",this.tabPosition="0",this.getList())}},mounted:function(){},methods:{getAuthor:function(){var t=this;Object(n["e"])().then(function(e){t.isManager=e.data})},getFinishRateList:function(){var t=this;Object(l["f"])("finishRateList").then(function(e){t.finishRateList=e.data})},getList:function(){var t=this;Object(n["jb"])(this.listQuery).then(function(e){t.videoList=e.data.result,t.total=e.data.result.length})},getWcl:function(){var t=this;Object(n["F"])().then(function(e){t.wcl=e.data.wcl,t.ywc=e.data.ywc,t.bk=e.data.bk})},handleFilter:function(){this.listQuery.page=1,this.getList()},resetTemp:function(){this.temp={id:void 0,importance:1,remark:"",timestamp:new Date,title:"",status:"published",type:""}},toDetial:function(t,e){this.isShow=2,this.infoId=t.infoId,this.videoId=e},backList:function(){this.isShow=0},showChart:function(){this.dialogFormVisible=!0}}},m=f,h=(i("9479"),i("2877")),v=Object(h["a"])(m,s,a,!1,null,null,null);e["default"]=v.exports},dad1:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("title-card",{attrs:{"title-text":"新增训练"}}),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),i("div",{staticStyle:{padding:"20px"}},[i("el-col",{attrs:{span:16}},[i("el-form",{ref:"form",attrs:{model:t.form,"label-width":"150px"}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"讲堂标题",required:""}},[i("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"训练类型",required:""}},[i("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changeType},model:{value:t.form.xltype,callback:function(e){t.$set(t.form,"xltype",e)},expression:"form.xltype"}},[i("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"训练时间",required:""}},[i("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},on:{change:t.getsTime},model:{value:t.form.exerciseTime,callback:function(e){t.$set(t.form,"exerciseTime",e)},expression:"form.exerciseTime"}})],1)],1),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"0"==this.form.xltype,expression:"this.form.xltype=='0'"}],attrs:{span:10}},[i("el-form-item",{attrs:{label:"会议链接",required:""}},[i("el-input",{model:{value:t.form.meetingLine,callback:function(e){t.$set(t.form,"meetingLine",e)},expression:"form.meetingLine"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"训练科目"}},[i("el-input",{attrs:{type:"textarea"},model:{value:t.form.exerciseIssue,callback:function(e){t.$set(t.form,"exerciseIssue",e)},expression:"form.exerciseIssue"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"参训人员"}},[i("el-input",{attrs:{type:"textarea"},model:{value:t.form.joinPeople,callback:function(e){t.$set(t.form,"joinPeople",e)},expression:"form.joinPeople"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"其他事项"}},[i("ueditor",{attrs:{value:t.form.bz},model:{value:t.form.bz,callback:function(e){t.$set(t.form,"bz",e)},expression:"form.bz"}})],1)],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:4}},[i("div",[i("label",{staticStyle:{"font-size":"18px"}},[t._v("上传视频")]),t._v(" "),i("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.uploadVideo,accept:".mp4",multiple:""}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("\n              将视频文件拖到此处，或"),i("em",[t._v("点击上传")]),t._v(" "),i("p",{staticStyle:{"font-size":"12px"}},[t._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),t._v(" "),i("div",{staticStyle:{"margin-top":"20px"}},[i("label",{staticStyle:{"font-size":"18px"}},[t._v("上传封面")]),t._v(" "),i("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.uploadImg,limit:1,accept:".png,.jpeg",multiple:""}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("\n              将图片文件拖到此处，或"),i("em",[t._v("点击上传")]),t._v(" "),i("p",{staticStyle:{"font-size":"12px"}},[t._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),t._v(" "),i("div",{staticStyle:{"margin-top":"20px"}},[i("label",{staticStyle:{"font-size":"18px"}},[t._v("上传附件")]),t._v(" "),i("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.uploadFile,accept:".word,.excel,.ofd",multiple:""}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("\n              将文件拖到此处，或"),i("em",[t._v("点击上传")]),t._v(" "),i("p",{staticStyle:{"font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)])],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveFn}},[t._v("确认并分发")]),t._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},on:{click:t.cancel}},[t._v("取消")])],1),t._v(" "),i("el-dialog",{attrs:{title:"请选择下发局级单位",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:function(e){t.dialogFormVisible=!1}}},[i("el-tree",{ref:"dataTree",attrs:{"show-checkbox":"",data:t.treeData,"node-key":"id",props:t.defaultProps}}),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.confirm}},[t._v("确定")]),t._v(" "),i("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")])],1)],1)],1)])},a=[],l=(i("7f7f"),i("0fe1")),n=i("35b7"),o=i("63f4"),r={components:{TitleCard:n["a"],Ueditor:o["a"]},props:{listType:{type:String,default:"0"},file_id:{type:String,default:""}},data:function(){return{form:{title:"",xltype:"",exerciseTime:"",meetingLine:"",exerciseIssue:"",joinPeople:"",bz:"",picturePath:""},deptData:{fileId:"",idAndNames:"",deptIds:"",deptNames:""},dialogFormVisible:!1,defaultProps:{children:"children",label:"text"},treeData:[],nodeId:[],nodeName:[],fileId:[],fileName:[],fileType:[]}},created:function(){this.file_id&&this.getTrainInfo()},methods:{getsTime:function(t){this.form.createDate=t},getTrainInfo:function(){var t=this;Object(l["C"])({id:this.file_id}).then(function(e){var i=e.data.xlglXlzzInfo,s=i.title,a=i.xltype,l=i.exerciseTime,n=i.exerciseIssue,o=i.joinPeople,r=i.bz,c=i.meetingLine;Object.assign(t.form,{title:s,xltype:a,exerciseTime:l,exerciseIssue:n,joinPeople:o,bz:r,meetingLine:c})})},saveFn:function(){var t=this;this.form.title?this.form.xltype?this.form.exerciseTime?"0"!==this.form.xltype||this.form.meetingLine?(this.form.pIds=this.fileId.join(","),this.form.pidNames=this.fileName.join(","),this.form.type=this.fileType.join(","),Object(l["Z"])(this.form).then(function(e){"success"===e.data.result?(t.$message({message:"新增成功",type:"success"}),t.fileId=e.data.fileId,t.dialogFormVisible=!0,Object(l["k"])().then(function(e){t.treeData=e.data.children})):t.$message({message:"新增失败",type:"info"})})):this.$message({message:"请填写会议链接",type:"info"}):this.$message({message:"请选择训练时间",type:"info"}):this.$message({message:"请选择训练类型",type:"info"}):this.$message({message:"请填写讲堂标题",type:"info"})},cancel:function(){var t=this;this.$confirm("确定要取消发送此通知吗，您填写的内容将被清空","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){t.form={}}).catch(function(){})},uploadVideo:function(t,e){this.fileId.push(t.fileId),this.fileName.push(e.raw.name),this.fileType.push(e.raw.type)},uploadImg:function(t,e){this.fileId.push(t.fileId),this.fileName.push(e.raw.name),this.fileType.push(e.raw.type),this.form.picturePath="/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.fileId},uploadFile:function(t,e){this.fileId.push(t.fileId),this.fileName.push(e.raw.name),this.fileType.push(e.raw.type?e.raw.type:"docx")},confirm:function(){var t=this;this.deptData.idAndNames="";for(var e=this.$refs.dataTree.getCheckedNodes(),i=0;i<e.length;i++)this.nodeId.push(e[i].id),this.nodeName.push(e[i].text),this.deptData.idAndNames+="".concat(e[i].id,",")+"".concat(e[i].text,";");this.deptData.fileId=this.fileId,this.deptData.deptIds=this.nodeId.join(","),this.deptData.deptNames=this.nodeName.join(","),Object(l["bb"])(this.deptData).then(function(e){"success"===e.data.result?(t.$message({message:"分发成功",type:"success"}),t.dialogFormVisible=!1,t.back()):(t.$message({message:"分发失败",type:"info"}),t.dialogFormVisible=!1)})},deleteFn:function(t){},back:function(){this.$emit("back",0,this.listType)}}},c=r,d=(i("e2d3"),i("2877")),p=Object(d["a"])(c,s,a,!1,null,"650c4b28",null);e["default"]=p.exports},e2d3:function(t,e,i){"use strict";var s=i("32e1"),a=i.n(s);a.a},ec21:function(t,e,i){}}]);