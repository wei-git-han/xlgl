(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7df96d02"],{"2df5":function(t,e,i){},6724:function(t,e,i){"use strict";i("8d41");var a="@@wavesContext";function s(t,e){function i(i){var a=Object.assign({},e.value),s=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},a),l=s.ele;if(l){l.style.position="relative",l.style.overflow="hidden";var o=l.getBoundingClientRect(),n=l.querySelector(".waves-ripple");switch(n?n.className="waves-ripple":(n=document.createElement("span"),n.className="waves-ripple",n.style.height=n.style.width=Math.max(o.width,o.height)+"px",l.appendChild(n)),s.type){case"center":n.style.top=o.height/2-n.offsetHeight/2+"px",n.style.left=o.width/2-n.offsetWidth/2+"px";break;default:n.style.top=(i.pageY-o.top-n.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",n.style.left=(i.pageX-o.left-n.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return n.style.backgroundColor=s.color,n.className="waves-ripple z-active",!1}}return t[a]?t[a].removeHandle=i:t[a]={removeHandle:i},i}var l={bind:function(t,e){t.addEventListener("click",s(t,e),!1)},update:function(t,e){t.removeEventListener("click",t[a].removeHandle,!1),t.addEventListener("click",s(t,e),!1)},unbind:function(t){t.removeEventListener("click",t[a].removeHandle,!1),t[a]=null,delete t[a]}},o=function(t){t.directive("waves",l)};window.Vue&&(window.waves=l,Vue.use(o)),l.install=o;e["a"]=l},70235:function(t,e,i){"use strict";var a=i("2df5"),s=i.n(a);s.a},"7a9d":function(t,e,i){},"8d41":function(t,e,i){},c3f7:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",[i("el-button",{staticStyle:{margin:"10px"},attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")]),t._v(" "),t.fileId?i("div",{staticClass:"div1"},[i("iframe",{staticStyle:{height:"calc(100vh - 210px)"},attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%"}})]):i("div",{staticClass:"waitDiv"},[i("p",[t._v("你还未上传文件，请点击按钮上传")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{width:"360px",height:"220px","margin-bottom":"15px"},attrs:{"icon-class":"tixing"}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,name:"pdf",data:t.fileData,accept:".pdf","on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传pdf格式文件")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},s=[],l=i("0fe1"),o={data:function(){return{fileUrl:"/app/xlgl/xlglktap/uploadFile",fileData:{id:""},onlineFileUrl:"",fileId:"",fileDialog:!1}},created:function(){this.getFileList()},methods:{successFile:function(t){this.fileId=t.fileId},openDialog:function(){this.fileDialog=!0},errorFile:function(){},getFileList:function(){var t=this;Object(l["v"])().then(function(e){t.fileId=e.data.fileId,t.fileId&&t.downFile()})},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},downFile:function(){var t=this;Object(l["i"])({fileId:this.fileId}).then(function(e){t.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileId+"&access_token="+t.$store.state.user.token})},submitFile:function(){this.fileDialog=!1,this.downFile()}}},n=o,c=(i("c908"),i("2877")),r=Object(c["a"])(n,a,s,!1,null,"26315b17",null);e["default"]=r.exports},c908:function(t,e,i){"use strict";var a=i("7a9d"),s=i.n(a);s.a},da8e:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[0==t.isShow?i("el-row",{attrs:{gutter:12}},[i("el-col",{attrs:{span:19}},[i("el-card",{staticStyle:{height:"calc(98vh - 15px)"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{attrs:{label:"大讲堂信息",name:"first"}}),t._v(" "),i("el-tab-pane",{attrs:{label:"历年课堂",name:"second"}}),t._v(" "),"1"==t.isManager?i("el-tab-pane",{attrs:{label:"讲堂安排",name:"three"}}):t._e()],1)],1),t._v(" "),"three"!=t.activeName?i("div",[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","justify-content":"space-between","padding-bottom":"20px"}},[i("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName==='first'"}],attrs:{size:"small"},model:{value:t.tabPosition,callback:function(e){t.tabPosition=e},expression:"tabPosition"}},[i("el-radio-button",{attrs:{label:"0"}},[t._v("未参加")]),t._v(" "),i("el-radio-button",{attrs:{label:"1"}},[t._v("历史学习")])],1),t._v(" "),i("div",[i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"请填写训练名称"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.handleFilter(e)}},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),i("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.handleFilter}},[t._v("搜索")])],1)],1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-row",t._l(t.videoList,function(e,a){return i("div",{key:a,staticStyle:{width:"25%",display:"inline-block",padding:"0 10px"}},[i("div",{staticStyle:{height:"100%"},on:{click:function(i){return t.toDetial(e)}}},[i("el-col",{staticClass:"videoCard",attrs:{span:24}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"0"===t.tabPosition,expression:"tabPosition==='0'"}],class:["learnLabel","1"==e.baoming&&e.timeOUt?"bg_active":"bg_default"]},[t._v(t._s("2"==e.baoming||"0"==e.baoming&&!e.timeOUt||"1"==e.baoming&&!e.timeOUt?"需补课":"未开始"))]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.tabPosition,expression:"tabPosition==='1'"}],staticClass:"learnLabel bg_default"},[t._v("已参训")]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px",background:"#F9FBFE"}},[e.listPictureIds?i("video",{staticClass:"imgStyle",staticStyle:{"object-fit":"fill"},attrs:{controls:"controls",poster:e.picturePath}},[i("source",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.listPictureIds}})]):e.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:e.picturePath}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"50%",height:"50%","margin-top":"12.5%","margin-left":"25%"},attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"2"==e.baoming&&""===e.listPictureIds,expression:"item.baoming=='2'&&item.listPictureIds===''"}],class:[e.isUpload?"status_start":""]},[t._v("未上传")])],1),t._v(" "),i("p",{staticClass:"cardTitle",attrs:{title:e.title}},[t._v(t._s(e.title))]),t._v(" "),e.timeOUt?i("p",{staticStyle:{padding:"0 10px"}},[i("span",{staticStyle:{color:"#F56C6C","font-size":"14px"}},[t._v("倒计时:")]),t._v(" "),i("span",{staticStyle:{"font-size":"14px",color:"#F56C6C",background:"#FEF0F0"}},[t._v(t._s(e.timeOUt))])]):i("p",{staticStyle:{color:"#F56C6C","font-size":"14px",padding:"0 10px"}},[t._v("已超时")]),t._v(" "),i("p",{staticClass:"flex-center"},[i("span",[t._v(t._s(e.creatorName))]),t._v(" "),i("span",[t._v(t._s(e.exerciseTime))])])])],1)])}),0)],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getList}})],1):i("div",[i("arrangeMent")],1)])],1),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName === 'first'"}],attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("已完成")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人已完成训练")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.ywc))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("需补考")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人错过训练需补考")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.bk))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("各单位年度参训完成情况")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])])])],1)],1)],1):t._e(),t._v(" "),1===t.isShow?i("organAdd",{on:{back:t.backList}}):t._e(),t._v(" "),2===t.isShow?i("auditorView",{attrs:{"video-type":t.status,"info-id":t.infoId,"video-id":t.videoId,"cx-flag":t.cxFlag,wcl:t.wcl},on:{back:t.backList}}):t._e(),t._v(" "),i("el-dialog",{staticClass:"barChart",attrs:{title:"各单位训练完成率统计",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)],1)},s=[],l=(i("a481"),i("7f7f"),i("ac6a"),i("0fe1")),o=i("6724"),n=i("333d"),c=i("dad1"),r=i("e3f3"),d=i("b5fe"),p=i("c3f7"),f={name:"ComplexTable",components:{Pagination:n["a"],organAdd:c["default"],auditorView:r["default"],FinishRate:d["default"],arrangeMent:p["default"]},directives:{waves:o["a"]},data:function(){return{list:null,total:0,listLoading:!0,listQuery:{page:1,limit:10,type:"0",search:"",flag:"0"},importanceOptions:[1,2,3],temp:{id:void 0,importance:1,remark:"",timestamp:new Date,title:"",type:"",status:"published"},dialogFormVisible:!1,activeName:"first",tabPosition:"0",showList:!0,showAdd:!1,videoList:[],isShow:0,state:["未开始","需补课","需补课"],finishRateList:[],status:"",wcl:"",ywc:"",bk:"",infoId:"",videoId:"",isManager:"",strHtml:"",cxFlag:"",allInfoIds:[],timer:""}},watch:{tabPosition:function(t){this.listQuery.type=t,this.getList()},activeName:function(t){"second"===t?(this.listQuery.flag="1",this.listQuery.type="",this.getList()):"first"===t&&(this.listQuery.flag="0",this.listQuery.type="0",this.tabPosition="0",this.getList())}},created:function(){this.getAuthor(),this.getList(),this.getWcl()},mounted:function(){},methods:{getAuthor:function(){var t=this;Object(l["n"])().then(function(e){t.isManager=e.data})},getList:function(){var t=this;Object(l["Gb"])(this.listQuery).then(function(e){t.total=e.data.page.totalCount,t.videoList=[],t.allInfoIds=[],e.data.page.list.forEach(function(e,i){t.videoList.push({baoming:e.baoming,listPictureIds:e.listPictureIds,id:e.id,infoId:e.infoId,title:e.title,isUpload:e.isUpload,creatorName:e.creatorName,exerciseTime:e.exerciseTime,subId:e.subId,picturePath:e.picturePath,timeOUt:t.delayTime(e.exerciseTime)}),t.allInfoIds.push(e.infoId)})})},getAllDeptAllDoneInfo:function(){var t=this;Object(l["j"])({allInfoIds:this.allInfoIds.join(",")}).then(function(e){"success"===e.data.result&&(t.finishRateList=[],e.data.list.forEach(function(e,i){t.finishRateList.push({departName:e.name,value:e.wcl})}))})},delayTime:function(t){var e=t.replace(/-/g,"/"),i=(new Date).getTime(),a=new Date(e).getTime(),s=Math.floor(a-i),l=s,o=Math.floor(s/864e5);s%=864e5;var n=Math.floor(s/36e5);s%=36e5;var c=Math.floor(s/6e4);return s%=6e4,l>0?this.formatType(o)+"天"+this.formatType(n)+"小时"+this.formatType(c)+"分钟":""},formatType:function(t){return t>0&&t<10?"0"+t:""+t},getWcl:function(){var t=this;Object(l["U"])().then(function(e){t.wcl=e.data.wcl,t.ywc=e.data.ywc,t.bk=e.data.bk})},handleFilter:function(){this.listQuery.page=1,this.getList()},toDetial:function(t){this.isShow=2,this.infoId=t.infoId,this.videoId=t.listPictureIds,this.cxFlag=t.baoming},backList:function(){this.isShow=0,this.getList()},showChart:function(){this.dialogFormVisible=!0,this.getAllDeptAllDoneInfo()}}},v=f,u=(i("70235"),i("2877")),h=Object(u["a"])(v,a,s,!1,null,"35b4117d",null);e["default"]=h.exports}}]);