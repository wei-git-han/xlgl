(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5e0875dc","chunk-2d210108"],{"09a0":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}]},[i("el-row",{staticClass:"search-content"},[i("el-row",{attrs:{span:24}},[i("el-form",{attrs:{model:t.form,"label-width":"150px"}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"姓名："}},[i("el-input",{model:{value:t.form.receiverName,callback:function(e){t.$set(t.form,"receiverName",e)},expression:"form.receiverName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"单位："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.recDeptId,callback:function(e){t.$set(t.form,"recDeptId",e)},expression:"form.recDeptId"}},t._l(t.treeData,function(t,e){return i("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"报名状态："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.baoming,callback:function(e){t.$set(t.form,"baoming",e)},expression:"form.baoming"}},[i("el-option",{attrs:{label:"已接收",value:"3"}}),t._v(" "),i("el-option",{attrs:{label:"未接收",value:"2"}}),t._v(" "),i("el-option",{attrs:{label:"已报名",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"延后参训",value:"1"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"参训状态："}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.isWork,callback:function(e){t.$set(t.form,"isWork",e)},expression:"form.isWork"}},[i("el-option",{attrs:{label:"已参训",value:"1"}}),t._v(" "),i("el-option",{attrs:{label:"延迟参训",value:"0"}})],1)],1)],1)],1)],1),t._v(" "),i("div",{staticStyle:{"text-align":"right","padding-right":"30px"}},[i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")]),t._v(" "),i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{size:"small",icon:"el-icon-refresh"},on:{click:t.reset}},[t._v("重置")])],1)],1),t._v(" "),t.searchList.length>0?i("el-row",[i("el-col",{staticStyle:{"margin-left":"10%"},attrs:{span:16}},[i("el-table",{attrs:{border:"",data:t.searchList}},[i("el-table-column",{attrs:{property:"receiverName",align:"center",label:"人员姓名"}}),t._v(" "),i("el-table-column",{attrs:{label:"报名状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s("0"===e.row.baoming?"未报名":"已报名"))])]}}],null,!1,2703969559)}),t._v(" "),i("el-table-column",{attrs:{label:"参训状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s("0"===e.row.isWork?"延后参训":"已参训"))])]}}],null,!1,370898783)}),t._v(" "),i("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}],null,!1,3001370467)})],1)],1)],1):i("el-row",[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag==='1'"}],staticStyle:{"margin-top":"30px"},attrs:{"label-width":"85px"}},[i("el-form-item",{attrs:{label:"单位："}},[i("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changDep},model:{value:t.branchId,callback:function(e){t.branchId=e},expression:"branchId"}},t._l(t.treeData,function(t,e){return i("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1)],1)],1),t._v(" "),i("el-row",{staticStyle:{padding:"20px"}},[i("el-row",{attrs:{gutter:30,span:24}},[i("el-col",{staticStyle:{height:"calc(95vh - 220px)","overflow-y":"scroll"},attrs:{span:16}},[i("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[i("el-table-column",{attrs:{prop:"id",label:t.juName,align:"center",width:"180"}},[[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("已参训"+t._s(t.cxNum)+"人")]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("延后参训"+t._s(t.bkNum)+"人")])]],2),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",{staticStyle:{cursor:"pointer"},on:{click:function(i){return t.showPeople(e.row)}}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{prop:"cycx",align:"center",label:"已参训"}}),t._v(" "),i("el-table-column",{attrs:{prop:"cbk",align:"center",label:"延后参训"}})],1)],1),t._v(" "),i("el-col",{staticStyle:{height:"calc(95vh - 220px)","overflow-y":"scroll"},attrs:{span:8}},[i("el-table",{attrs:{data:t.juList}},[i("el-table-column",{attrs:{property:"truename",align:"center",label:"人员姓名"}}),t._v(" "),i("el-table-column",{attrs:{label:"报名状态",align:"center",width:"70"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.status?t.statusList[e.row.status]:"--"))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"参训状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status&&"2"!==e.row.status?i("el-select",{attrs:{placeholder:"请选择"},model:{value:e.row.sfcx,callback:function(i){t.$set(e.row,"sfcx",i)},expression:"scope.row.sfcx"}},[i("el-option",{attrs:{value:"0",label:"延后参训"}},[t._v("延后参训")]),t._v(" "),i("el-option",{attrs:{value:"1",label:"已参训"}},[t._v("已参训")])],1):i("span",[t._v("--")])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",{staticStyle:{"white-space":"nowrap","text-overflow":"ellipsis",overflow:"hidden",cursor:"pointer"},attrs:{title:e.row.reason}},[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",align:"center",width:"60"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{type:"text",size:"small",disabled:!e.row.status||"2"===e.row.status},on:{click:function(i){return t.updateStatus(e.row)}}},[t._v("修改")])]}}])})],1)],1)],1)],1)],1)],1)},s=[],l=(i("ac6a"),i("0fe1")),n={components:{},props:{infoId:{type:String,default:""}},data:function(){return{tableData:[],form:{receiverName:"",recDeptId:"",isWork:"",baoming:""},activeName:"first",juList:[],peopleList:[],visible:!1,params:{reason:"",infoId:"",subId:"",baoming:""},title:"",fbDept:"",xltype:"",exerciseTime:"",picturePath:"",bz:"",exerciseIssue:"",joinPeople:"",meetingLine:"",todeptName:"",pictureList:[],instraction:"",bmFlag:"",isLoading:!1,bkNum:"",cxNum:"",wbm:"",ybm:"",confirm:"",juConfirm:"",showEdit:0,adminFlag:this.$store.state.user.userInfo.adminFlag,isShow:!1,preId:"",sufId:"",branchId:"",treeData:[],juName:"",timeOUt:"",readFlag:!0,curTime:new Date,roleFlag:"",timeFlag:"",statusList:["已报名","延后参训","未接收","已接收"],cxStatusList:["延后参训","已参训"],searchList:[]}},created:function(){this.getRoleSet(),"1"===this.adminFlag?this.getOnlyRoot():this.getDateForJu()},methods:{getDateForJu:function(){var t=this;this.isLoading=!0,Object(l["t"])({id:this.infoId}).then(function(e){t.juList=e.data.listAllUser[0].listUser,t.tableData=e.data.listTotal,t.peopleList=e.data.listAllUser,t.bkNum=e.data.bk,t.cxNum=e.data.ycx,t.juConfirm=e.data.confirm,t.juName=e.data.juName,t.ybm=e.data.ybm,t.wbm=e.data.wbm,setTimeout(function(){t.isLoading=!1},500)})},changDep:function(){this.getDateForAll()},getDateForAll:function(){var t=this;this.isLoading=!0,Object(l["s"])({id:this.infoId,orgId:this.branchId}).then(function(e){"success"===e.data.result&&e.data.list&&e.data.list.length>0&&(t.tableData=e.data.list[0].listTotal,t.peopleList=e.data.list[0].listAllUser,t.juList=e.data.list[0].listAllUser[0].listUser,t.bkNum=e.data.list[0].bk,t.cxNum=e.data.list[0].ycx,t.confirm=e.data.list[0].confirm,t.juName=e.data.list[0].juName,t.ybm=e.data.list[0].ybm,t.wbm=e.data.list[0].wbm,setTimeout(function(){t.isLoading=!1},500))})},getRoleSet:function(){var t=this;Object(l["E"])().then(function(e){t.roleFlag=e.data.flag})},getOnlyRoot:function(){var t=this;Object(l["y"])().then(function(e){t.treeData=e.data.children,t.branchId=e.data.children[0].id,t.getDateForAll()})},objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,i=t.columnIndex;if(0===i)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},showPeople:function(t){var e=this;this.peopleList.forEach(function(i,a){i.deptName===t.deptName&&(e.juList=i.listUser,t.confirm?e.isShow=!1:e.isHaveButton(t.deptId))})},isHaveButton:function(t){var e=this;Object(l["bb"])({deptId:t}).then(function(t){t.data.result?e.isShow=!0:e.isShow=!1})},updateStatus:function(t){var e=this;Object(l["Hb"])({type:"1",status:t.sfcx,infoId:this.infoId,userId:t.id,isWork:"0"===t.isWork?"1":"0"}).then(function(t){"success"===t.data.result?e.$alert("状态修改成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}).catch(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}):"fail"===t.data.result?e.$confirm("当前修改用户无参训记录","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"confirm"===t.data.result?e.$confirm("管理员已确认，不能修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"no Perssion"===t.data.result&&e.$confirm("您没有权限修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){})})},search:function(){var t=this;""===this.form.receiverName&&""===this.form.recDeptId&&""===this.form.isWork&&""===this.form.baoming?this.$notify({title:"提示",message:"请输入搜索条件!",duration:1500,type:"warning"}):Object(l["sb"])(this.form).then(function(e){e.data&&e.data.length>0?t.searchList=e.data:(t.searchList=[],t.$notify({title:"提示",message:"没有搜索到相关数据!",duration:1500,type:"warning"}))})},reset:function(){this.form.receiverName="",this.form.recDeptId="",this.form.isWork="",this.form.baoming=""}}},o=n,r=(i("cdbe"),i("2877")),c=Object(r["a"])(o,a,s,!1,null,"38d7d4f4",null);e["default"]=c.exports},"3eef":function(t,e,i){},"5b4d":function(t,e,i){},6724:function(t,e,i){"use strict";i("8d41");var a="@@wavesContext";function s(t,e){function i(i){var a=Object.assign({},e.value),s=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},a),l=s.ele;if(l){l.style.position="relative",l.style.overflow="hidden";var n=l.getBoundingClientRect(),o=l.querySelector(".waves-ripple");switch(o?o.className="waves-ripple":(o=document.createElement("span"),o.className="waves-ripple",o.style.height=o.style.width=Math.max(n.width,n.height)+"px",l.appendChild(o)),s.type){case"center":o.style.top=n.height/2-o.offsetHeight/2+"px",o.style.left=n.width/2-o.offsetWidth/2+"px";break;default:o.style.top=(i.pageY-n.top-o.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",o.style.left=(i.pageX-n.left-o.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return o.style.backgroundColor=s.color,o.className="waves-ripple z-active",!1}}return t[a]?t[a].removeHandle=i:t[a]={removeHandle:i},i}var l={bind:function(t,e){t.addEventListener("click",s(t,e),!1)},update:function(t,e){t.removeEventListener("click",t[a].removeHandle,!1),t.addEventListener("click",s(t,e),!1)},unbind:function(t){t.removeEventListener("click",t[a].removeHandle,!1),t[a]=null,delete t[a]}},n=function(t){t.directive("waves",l)};window.Vue&&(window.waves=l,Vue.use(n)),l.install=n;e["a"]=l},"7a9d":function(t,e,i){},"8d41":function(t,e,i){},"937e":function(t,e,i){"use strict";var a=i("3eef"),s=i.n(a);s.a},a940:function(t,e,i){"use strict";var a=i("b439"),s=i.n(a);s.a},b439:function(t,e,i){},b5fe:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{class:t.className,style:{height:t.height,width:t.width}})},s=[],l=i("313e"),n=i.n(l),o=i("a7dc");i("817d");var r=6e3,c={mixins:[o["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0},chartTitle:{type:String,default:""}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){this.xData=[],this.yData=[];for(var e=0;e<t.length;e++)this.xData.push(t[e].departName),this.yData.push(t[e].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){this.xData=[],this.yData=[];for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=n.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:this.chartTitle,subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",data:this.xData,axisTick:{show:!1},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},rotate:20}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new n.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:r}]})}}},d=c,u=i("2877"),p=Object(u["a"])(d,a,s,!1,null,null,null);e["default"]=p.exports},c3f7:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",[i("el-button",{staticStyle:{margin:"10px"},attrs:{type:"success",size:"mini"},on:{click:t.openDialog}},[t._v("上传")]),t._v(" "),t.fileId?i("div",{staticClass:"div1"},[i("iframe",{staticStyle:{height:"calc(100vh - 210px)"},attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%"}})]):i("div",{staticClass:"waitDiv"},[i("p",[t._v("你还未上传文件，请点击按钮上传")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{width:"360px",height:"220px","margin-bottom":"15px"},attrs:{"icon-class":"tixing"}})],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"上传附件",visible:t.fileDialog,width:"40%","before-close":t.closeFileDialog},on:{"update:visible":function(e){t.fileDialog=e}}},[i("div",{staticClass:"centerPosition"},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",multiple:!1,limit:1,"with-credentials":!0,action:t.fileUrl,name:"pdf",data:t.fileData,accept:".pdf","on-success":t.successFile,"on-error":t.errorFile}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("支持上传pdf格式文件")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.closeFileDialog}},[t._v("取 消")])],1)])],1)},s=[],l=i("0fe1"),n={data:function(){return{fileUrl:"/app/xlgl/xlglktap/uploadFile",fileData:{id:""},onlineFileUrl:"",fileId:"",fileDialog:!1}},created:function(){this.getFileList()},methods:{successFile:function(t){this.fileId=t.fileId},openDialog:function(){this.fileDialog=!0},errorFile:function(){},getFileList:function(){var t=this;Object(l["v"])().then(function(e){t.fileId=e.data.fileId,t.fileId&&t.downFile()})},closeFileDialog:function(){this.$refs.upload.clearFiles(),this.fileDialog=!1},downFile:function(){var t=this;Object(l["i"])({fileId:this.fileId}).then(function(e){t.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+t.fileId+"&access_token="+t.$store.state.user.token})},submitFile:function(){this.fileDialog=!1,this.downFile()}}},o=n,r=(i("c908"),i("2877")),c=Object(r["a"])(o,a,s,!1,null,"26315b17",null);e["default"]=c.exports},c440:function(t,e,i){"use strict";var a=i("f47c"),s=i.n(a);s.a},c908:function(t,e,i){"use strict";var a=i("7a9d"),s=i.n(a);s.a},cdbe:function(t,e,i){"use strict";var a=i("5b4d"),s=i.n(a);s.a},da8e:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[0==t.isShow?i("el-row",{attrs:{gutter:12}},[i("el-col",{attrs:{span:19}},[i("el-card",{staticStyle:{height:"calc(98vh - 15px)"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{attrs:{label:"大讲堂信息",name:"first"}}),t._v(" "),i("el-tab-pane",{attrs:{label:"历年课堂",name:"second"}}),t._v(" "),"1"==t.isManager?i("el-tab-pane",{attrs:{label:"讲堂安排",name:"three"}}):t._e()],1)],1),t._v(" "),"three"!=t.activeName?i("div",[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","justify-content":"space-between","padding-bottom":"20px"}},[i("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName==='first'"}],attrs:{size:"small"},model:{value:t.tabPosition,callback:function(e){t.tabPosition=e},expression:"tabPosition"}},[i("el-radio-button",{attrs:{label:"0"}},[t._v("未参加")]),t._v(" "),i("el-radio-button",{attrs:{label:"1"}},[t._v("历史学习")])],1),t._v(" "),i("div",[i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"请填写训练名称"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.handleFilter(e)}},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),i("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.handleFilter}},[t._v("搜索")])],1)],1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-row",t._l(t.videoList,function(e,a){return i("div",{key:a,staticStyle:{width:"25%",display:"inline-block",padding:"0 10px"}},[i("div",{staticStyle:{height:"100%"},on:{click:function(i){return t.toDetial(e)}}},[i("el-col",{staticClass:"videoCard",attrs:{span:24}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"0"===t.tabPosition,expression:"tabPosition==='0'"}],class:["learnLabel","1"==e.baoming&&e.timeOUt?"bg_active":"bg_default"]},[t._v(t._s("2"==e.baoming||"0"==e.baoming&&!e.timeOUt||"1"==e.baoming&&!e.timeOUt?"需补课":"未开始"))]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.tabPosition,expression:"tabPosition==='1'"}],staticClass:"learnLabel bg_default"},[t._v("已参训")]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px",background:"#F9FBFE"}},[e.listPictureIds?i("video",{staticClass:"imgStyle",staticStyle:{"object-fit":"fill"},attrs:{controls:"controls",poster:e.picturePath}},[i("source",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.listPictureIds}})]):e.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:e.picturePath}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"50%",height:"50%","margin-top":"12.5%","margin-left":"25%"},attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"2"==e.baoming&&""===e.listPictureIds,expression:"item.baoming=='2'&&item.listPictureIds===''"}],class:[e.isUpload?"status_start":""]},[t._v("未上传")])],1),t._v(" "),i("p",{staticClass:"cardTitle",attrs:{title:e.title}},[t._v(t._s(e.title))]),t._v(" "),e.timeOUt?i("p",{staticStyle:{padding:"0 10px"}},[i("span",{staticStyle:{color:"#F56C6C","font-size":"14px"}},[t._v("倒计时:")]),t._v(" "),i("span",{staticStyle:{"font-size":"14px",color:"#F56C6C",background:"#FEF0F0"}},[t._v(t._s(e.timeOUt))])]):i("p",{staticStyle:{color:"#F56C6C","font-size":"14px",padding:"0 10px"}},[t._v("已超时")]),t._v(" "),i("p",{staticClass:"flex-center"},[i("span",[t._v(t._s(e.creatorName))]),t._v(" "),i("span",[t._v(t._s(e.exerciseTime))])])])],1)])}),0)],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getList}})],1):i("div",[i("arrangeMent")],1)])],1),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"first"===t.activeName,expression:"activeName === 'first'"}],attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("已完成")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人已完成训练")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.ywc))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("需补考")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人错过训练需补考")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.bk))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("各单位年度参训完成情况")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])])])],1)],1)],1):t._e(),t._v(" "),1===t.isShow?i("organAdd",{on:{back:t.backList}}):t._e(),t._v(" "),2===t.isShow?i("auditorView",{attrs:{"video-type":t.status,"info-id":t.infoId,"video-id":t.videoId,"cx-flag":t.cxFlag,wcl:t.wcl},on:{back:t.backList}}):t._e(),t._v(" "),i("el-dialog",{staticClass:"barChart",attrs:{title:"各单位训练完成率统计",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)],1)},s=[],l=(i("a481"),i("7f7f"),i("ac6a"),i("0fe1")),n=i("6724"),o=i("333d"),r=i("dad1"),c=i("e3f3"),d=i("b5fe"),u=i("c3f7"),p={name:"ComplexTable",components:{Pagination:o["a"],organAdd:r["default"],auditorView:c["default"],FinishRate:d["default"],arrangeMent:u["default"]},directives:{waves:n["a"]},data:function(){return{list:null,total:0,listLoading:!0,listQuery:{page:1,limit:10,type:"0",search:"",flag:"0"},importanceOptions:[1,2,3],temp:{id:void 0,importance:1,remark:"",timestamp:new Date,title:"",type:"",status:"published"},dialogFormVisible:!1,activeName:"first",tabPosition:"0",showList:!0,showAdd:!1,videoList:[],isShow:0,state:["未开始","需补课","需补课"],finishRateList:[],status:"",wcl:"",ywc:"",bk:"",infoId:"",videoId:"",isManager:"",strHtml:"",cxFlag:"",allInfoIds:[],timer:""}},watch:{tabPosition:function(t){this.listQuery.type=t,this.getList()},activeName:function(t){"second"===t?(this.listQuery.flag="1",this.listQuery.type="",this.getList()):"first"===t&&(this.listQuery.flag="0",this.listQuery.type="0",this.tabPosition="0",this.getList())}},created:function(){this.getAuthor(),this.getList(),this.getWcl()},mounted:function(){},methods:{getAuthor:function(){var t=this;Object(l["n"])().then(function(e){t.isManager=e.data})},getList:function(){var t=this;Object(l["Gb"])(this.listQuery).then(function(e){t.total=e.data.page.totalCount,t.videoList=[],t.allInfoIds=[],e.data.page.list.forEach(function(e,i){t.videoList.push({baoming:e.baoming,listPictureIds:e.listPictureIds,id:e.id,infoId:e.infoId,title:e.title,isUpload:e.isUpload,creatorName:e.creatorName,exerciseTime:e.exerciseTime,subId:e.subId,picturePath:e.picturePath,timeOUt:t.delayTime(e.exerciseTime)}),t.allInfoIds.push(e.id)})})},getAllDeptAllDoneInfo:function(){var t=this;Object(l["j"])({allInfoIds:this.allInfoIds.join(",")}).then(function(e){"success"===e.data.result&&(t.finishRateList=[],e.data.list.forEach(function(e,i){t.finishRateList.push({departName:e.name,value:e.wcl})}))})},delayTime:function(t){var e=t.replace(/-/g,"/"),i=(new Date).getTime(),a=new Date(e).getTime(),s=Math.floor(a-i),l=s,n=Math.floor(s/864e5);s%=864e5;var o=Math.floor(s/36e5);s%=36e5;var r=Math.floor(s/6e4);return s%=6e4,l>0?this.formatType(n)+"天"+this.formatType(o)+"小时"+this.formatType(r)+"分钟":""},formatType:function(t){return t>0&&t<10?"0"+t:""+t},getWcl:function(){var t=this;Object(l["U"])().then(function(e){t.wcl=e.data.wcl,t.ywc=e.data.ywc,t.bk=e.data.bk})},handleFilter:function(){this.listQuery.page=1,this.getList()},toDetial:function(t){this.isShow=2,this.infoId=t.infoId,this.videoId=t.listPictureIds,this.cxFlag=t.baoming},backList:function(){this.isShow=0,this.getList()},showChart:function(){this.dialogFormVisible=!0,this.getAllDeptAllDoneInfo()}}},f=p,v=(i("937e"),i("2877")),h=Object(v["a"])(f,a,s,!1,null,"1a56922f",null);e["default"]=h.exports},e3f3:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("el-row",{attrs:{gutter:10}},[i("el-col",{attrs:{span:19}},[i("div",{staticClass:"container"},[i("div",{staticClass:"header"},[i("div",{staticClass:"title",attrs:{title:t.title}},[t._v(t._s(t.title))]),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("span",[t._v("时间：")]),t._v(" "),i("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("类型：")]),t._v(" "),i("span",[t._v("强装兴装大讲堂")])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("主办单位：")]),t._v(" "),i("span",[t._v(t._s(t.zjdept))])]),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"===t.cxFlag&&t.videoIds,expression:"cxFlag==='2' && videoIds"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[i("span",[t._v("播放次数：")]),t._v(" "),i("span",[t._v(t._s(t.palyNum)+"次")])])],1),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag||"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag!=='2'||(cxFlag==='2'&&!videoIds)"}],attrs:{span:18}},[i("div",[t._v("训练课目："+t._s(t.exerciseIssue))]),t._v(" "),i("div",{staticClass:"ma-t_20"},[t._v("参训人员："+t._s(t.joinPeople))]),t._v(" "),i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"flex-start",width:"100%",overflow:"hidden","margin-top":"3px"}},[i("div",{staticStyle:{"margin-top":"16px"}},[t._v("其他事项：")]),t._v(" "),i("div",{staticStyle:{"word-break":"break-all",width:"90%"},attrs:{id:"content"},domProps:{innerHTML:t._s(t.bz)}})]),t._v(" "),i("p",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag&&""!==t.timeOUt,expression:"cxFlag !== '2' && timeOUt !== '' "}]},[i("span",[t._v("距离开始：")]),t._v(" "),i("span",{staticStyle:{"font-size":"25px",color:"#F56C6C","margin-left":"10px"}},[t._v(t._s(t.timeOUt))])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag,expression:"cxFlag!=='2'"}],staticClass:"ma-t_20",attrs:{span:16}},[i("span",[t._v("会议链接：")]),t._v(" "),i("span",{staticStyle:{color:"#3377FF",cursor:"pointer"},on:{click:t.getUrl}},[t._v(t._s(t.meetingLine))]),t._v(" "),i("span",{staticStyle:{color:"#3377FF",dispaly:"inline-block",border:"1px solid #7477FF",padding:"1px 8px","border-radius":"3px","margin-left":"10px",cursor:"pointer"},on:{click:function(e){return t.handleClipboard(t.meetingLine,e)}}},[t._v("复制链接")])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"===t.bxFlag,expression:"bxFlag==='2'"}],staticClass:"ma-t_20"},[t._v("延后参训原因："+t._s(t.ykReason))]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag,expression:"cxFlag!=='2'"}]},[t._v("\n                    报名状态："),i("el-button",{attrs:{type:"text"}},[t._v(t._s(t.bxList[t.bxFlag]))])],1)]),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:t.videoIds&&"2"===t.cxFlag||t.videoIds&&!t.timeOUt,expression:"(videoIds && cxFlag==='2') || (videoIds && !timeOUt)"}],staticClass:"ma-t_20",attrs:{span:18}},[i("video",{ref:"myVideo",staticStyle:{height:"500px",width:"100%"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoIds,controls:"controls"}})]),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag||"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag!=='2'||(cxFlag==='2'&&!videoIds)"}],attrs:{span:6}},[t.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:t.picturePath}}):i("div",{staticClass:"imgStyle",staticStyle:{background:"#F9FBFE"}},[i("svg-icon",{staticClass:"icon",staticStyle:{height:"50%",width:"50%","margin-left":"25%","margin-top":"12.5%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),i("div",{staticStyle:{width:"80%",height:"160px",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("本单位补充说明")]),t._v(" "),i("textarea",{directives:[{name:"model",rawName:"v-model",value:t.instraction,expression:"instraction"}],staticStyle:{width:"100%",height:"110px",border:"none",resize:"none",padding:"15px"},attrs:{readonly:""},domProps:{value:t.instraction},on:{input:function(e){e.target.composing||(t.instraction=e.target.value)}}})])])],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag==='2' && !videoIds"}],staticStyle:{"text-align":"center"}},[i("el-button",{attrs:{type:"text"}},[t._v("需补课")]),t._v(" "),i("el-button",{attrs:{type:"text"}},[t._v("视频待上传")])],1)],1)],1)],1)],1)]),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本课程参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"peopleNum"},[i("div",{staticClass:"flex-center",staticStyle:{padding:"10px 20px"}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("合计人数")]),i("br")])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.peopleNum))])]),t._v(" "),i("div",{staticClass:"flex-center",staticStyle:{"border-top":"1px solid #ccc",padding:"10px"}},[i("div",{staticStyle:{flex:"1","border-right":"1px solid #ccc","text-align":"center",height:"40px","line-height":"40px"}},[i("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("已参训")]),t._v(" "),i("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v(t._s(t.ycmNum))])]),t._v(" "),i("div",{staticStyle:{flex:"1","text-align":"center",height:"40px","line-height":"40px"}},[i("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("缺席")]),t._v(" "),i("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v(t._s(t.qxNum))])])]),t._v(" "),i("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.showView}},[t._v("查看详情 ＞")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("各单位年度参训完成情况")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{background:"#fff","border-radius":"5px","padding-bottom":"5px"}},[i("title-card",{attrs:{"title-text":"附件资料"}}),t._v(" "),t._l(t.fileList,function(e,a){return i("div",{key:a,on:{click:function(i){return t.downloadFile(e.pictureId)}}},[i("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)])})],2)])],1)],1)],1),t._v(" "),i("el-dialog",{staticClass:"dialogList",attrs:{title:"人员参训情况清单",visible:t.dialogFormVisible,width:"80%"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("auditoriumList",{attrs:{"info-id":t.infoId}})],1),t._v(" "),i("el-dialog",{staticClass:"barChart",attrs:{title:"各单位训练完成率统计",visible:t.dialogchart},on:{"update:visible":function(e){t.dialogchart=e}}},[i("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)],1)},s=[],l=(i("a481"),i("7f7f"),i("ac6a"),i("c5f6"),i("09a0")),n=i("35b7"),o=i("b5fe"),r=i("f71e"),c=i("0fe1"),d={components:{auditoriumList:l["default"],TitleCard:n["a"],FinishRate:o["default"]},props:{infoId:{type:String,default:""},videoId:{type:String,default:""},cxFlag:{type:String,default:""},wcl:{type:Number,default:0}},data:function(){return{dialogFormVisible:!1,dialogchart:!1,fileId:"",title:"",videoIds:"",exerciseTime:"",zjdept:"",exerciseIssue:"",meetingLine:"",bz:"",joinPeople:"",fileList:[],finishRateList:[],instraction:"",picturePath:"",palyNum:"1",bxFlag:"",ykReason:"",bxList:["未报名","已报名","延后参训"],symTime:"",videoTime:"",timeOUt:"",ycmNum:"",qxNum:"",peopleNum:"",timer1:""}},created:function(){this.getPerData(),this.getInfo(),this.getPeopleNum()},mounted:function(){var t=this;this.$refs.myVideo.onplay=function(){},this.$refs.myVideo.ontimeupdate=function(){t.$refs.myVideo.currentTime-t.symTime>1&&(t.$refs.myVideo.currentTime=t.symTime),t.symTime=t.$refs.myVideo.currentTime},this.$refs.myVideo.onended=function(){t.updateStatusForDjt()}},methods:{getPeopleNum:function(){var t=this;Object(c["z"])({infoId:this.infoId}).then(function(e){t.ycmNum=e.data.ycm,t.qxNum=e.data.qx,t.peopleNum=e.data.sum})},getPerData:function(){Object(c["A"])({fileId:this.infoId}).then(function(t){})},getInfo:function(){var t=this;Object(c["w"])({infoId:this.infoId,id:this.videoId}).then(function(e){t.title=e.data.title,t.bxFlag=e.data.baoming,t.ykReason=e.data.reason,t.exerciseTime=e.data.time,t.zjdept=e.data.xlglXlzzInfo.zjdept,t.exerciseIssue=e.data.xlglXlzzInfo.exerciseIssue,t.joinPeople=e.data.xlglXlzzInfo.joinPeople,t.meetingLine=e.data.xlglXlzzInfo.meetingLine,t.picturePath=e.data.xlglXlzzInfo.picturePath,t.bz=e.data.xlglXlzzInfo.bz,t.videoIds=e.data.xlglPicture?e.data.xlglPicture.pictureId:"",t.fileList=e.data.list,t.timeOUt=t.delayTime()})},back:function(){this.$emit("back")},showView:function(){this.dialogFormVisible=!0},showChart:function(){var t=this;this.dialogchart=!0,Object(c["k"])({infoId:this.infoId}).then(function(e){"success"===e.data.result&&(t.finishRateList=[],e.data.list.forEach(function(e,i){t.finishRateList.push({departName:e.name,value:e.wcl})}))})},handleClipboard:function(t,e){Object(r["a"])(t,e)},getUrl:function(){"0"!==this.bxFlag?this.timeOUt&&"1"===this.bxFlag?this.$notify({title:"提示",message:"训练还未开始",duration:1500,type:"warning"}):(this.createHuiYi(),this.updateStatusForDjt()):this.$notify({title:"提示",message:"您还未报名，请先报名",duration:1500,type:"warning"})},createHuiYi:function(){var t=this;Object(c["e"])({xlglId:this.infoId}).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"发送会见视频消息成功",duration:1500,type:"success"}):t.$notify({title:"提示",message:"发送会见视频消息失败",duration:1500,type:"warning"})})},delayTime:function(){var t=this.exerciseTime.replace(/-/g,"/"),e=(new Date).getTime(),i=new Date(t).getTime(),a=Math.floor(i-e),s=a,l=Math.floor(a/864e5);a%=864e5;var n=Math.floor(a/36e5);a%=36e5;var o=Math.floor(a/6e4);return a%=6e4,s>0?this.formatType(l)+"天"+this.formatType(n)+"小时"+this.formatType(o)+"分钟":(clearInterval(this.timer1),"")},formatType:function(t){return t>0&&t<10?"0"+t:""+t},updateStatusForDjt:function(){Object(c["Ib"])({infoId:this.infoId}).then(function(t){})},downloadFile:function(t){window.location.href="xlgl/xlgldocumentfile/downLoad?fileId="+t+"&access_token="+this.$store.state.user.token}}},u=d,p=(i("a940"),i("c440"),i("2877")),f=Object(p["a"])(u,a,s,!1,null,"ac59694a",null);e["default"]=f.exports},f47c:function(t,e,i){},f71e:function(t,e,i){"use strict";i.d(e,"a",function(){return r});var a=i("2b0e"),s=i("b311"),l=i.n(s);function n(){a["default"].prototype.$message({message:"复制成功",type:"success",duration:1500})}function o(){a["default"].prototype.$message({message:"复制失败",type:"error"})}function r(t,e){var i=new l.a(e.target,{text:function(){return t}});i.on("success",function(){n(),i.destroy()}),i.on("error",function(){o(),i.destroy()}),i.onClick(e)}}}]);