(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4e201e35","chunk-2d210108"],{"09a0":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}]},[a("el-row",{staticClass:"search-content"},[a("el-row",{attrs:{span:24}},[a("el-form",{attrs:{model:t.form,"label-width":"150px"}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"姓名："}},[a("el-input",{model:{value:t.form.receiverName,callback:function(e){t.$set(t.form,"receiverName",e)},expression:"form.receiverName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"单位："}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.recDeptId,callback:function(e){t.$set(t.form,"recDeptId",e)},expression:"form.recDeptId"}},t._l(t.treeData,function(t,e){return a("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"报名状态："}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.baoming,callback:function(e){t.$set(t.form,"baoming",e)},expression:"form.baoming"}},[a("el-option",{attrs:{label:"已接收",value:"3"}}),t._v(" "),a("el-option",{attrs:{label:"未接收",value:"2"}}),t._v(" "),a("el-option",{attrs:{label:"已报名",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"延后参训",value:"1"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"参训状态："}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.isWork,callback:function(e){t.$set(t.form,"isWork",e)},expression:"form.isWork"}},[a("el-option",{attrs:{label:"已参训",value:"1"}}),t._v(" "),a("el-option",{attrs:{label:"延迟参训",value:"0"}})],1)],1)],1)],1)],1),t._v(" "),a("div",{staticStyle:{"text-align":"right","padding-right":"30px"}},[a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")]),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{size:"small",icon:"el-icon-refresh"},on:{click:t.reset}},[t._v("重置")])],1)],1),t._v(" "),t.searchList.length>0?a("el-row",[a("el-col",{staticStyle:{"margin-left":"10%"},attrs:{span:16}},[a("el-table",{attrs:{border:"",data:t.searchList}},[a("el-table-column",{attrs:{property:"receiverName",align:"center",label:"人员姓名"}}),t._v(" "),a("el-table-column",{attrs:{label:"报名状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s("0"===e.row.baoming?"未报名":"已报名"))])]}}],null,!1,2703969559)}),t._v(" "),a("el-table-column",{attrs:{label:"参训状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s("0"===e.row.isWork?"延后参训":"已参训"))])]}}],null,!1,370898783)}),t._v(" "),a("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}],null,!1,3001370467)})],1)],1)],1):a("el-row",[a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag==='1'"}],staticStyle:{"margin-top":"30px"},attrs:{"label-width":"85px"}},[a("el-form-item",{attrs:{label:"单位："}},[a("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changDep},model:{value:t.branchId,callback:function(e){t.branchId=e},expression:"branchId"}},t._l(t.treeData,function(t,e){return a("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{padding:"20px"}},[a("el-row",{attrs:{gutter:30,span:24}},[a("el-col",{staticStyle:{height:"calc(95vh - 220px)","overflow-y":"scroll"},attrs:{span:16}},[a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[a("el-table-column",{attrs:{prop:"id",label:t.juName,align:"center",width:"180"}},[[a("div",{staticClass:"ta-c"},[a("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),a("div",{staticClass:"ta-c"},[t._v("已参训"+t._s(t.cxNum)+"人")]),t._v(" "),a("div",{staticClass:"ta-c"},[t._v("延后参训"+t._s(t.bkNum)+"人")])]],2),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticStyle:{cursor:"pointer"},on:{click:function(a){return t.showPeople(e.row)}}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"cycx",align:"center",label:"已参训"}}),t._v(" "),a("el-table-column",{attrs:{prop:"cbk",align:"center",label:"延后参训"}})],1)],1),t._v(" "),a("el-col",{staticStyle:{height:"calc(95vh - 220px)","overflow-y":"scroll"},attrs:{span:8}},[a("el-table",{attrs:{data:t.juList}},[a("el-table-column",{attrs:{property:"truename",align:"center",label:"人员姓名"}}),t._v(" "),a("el-table-column",{attrs:{label:"报名状态",align:"center",width:"70"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.status?t.statusList[e.row.status]:"--"))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"参训状态",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status&&"2"!==e.row.status?a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.row.sfcx,callback:function(a){t.$set(e.row,"sfcx",a)},expression:"scope.row.sfcx"}},[a("el-option",{attrs:{value:"0",label:"延后参训"}},[t._v("延后参训")]),t._v(" "),a("el-option",{attrs:{value:"1",label:"已参训"}},[t._v("已参训")])],1):a("span",[t._v("--")])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticStyle:{"white-space":"nowrap","text-overflow":"ellipsis",overflow:"hidden",cursor:"pointer"},attrs:{title:e.row.reason}},[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"60"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small",disabled:!e.row.status||"2"===e.row.status},on:{click:function(a){return t.updateStatus(e.row)}}},[t._v("修改")])]}}])})],1)],1)],1)],1)],1)],1)},s=[],n=(a("ac6a"),a("0fe1")),l={components:{},props:{infoId:{type:String,default:""}},data:function(){return{tableData:[],form:{receiverName:"",recDeptId:"",isWork:"",baoming:""},activeName:"first",juList:[],peopleList:[],visible:!1,params:{reason:"",infoId:"",subId:"",baoming:""},title:"",fbDept:"",xltype:"",exerciseTime:"",picturePath:"",bz:"",exerciseIssue:"",joinPeople:"",meetingLine:"",todeptName:"",pictureList:[],instraction:"",bmFlag:"",isLoading:!1,bkNum:"",cxNum:"",wbm:"",ybm:"",confirm:"",juConfirm:"",showEdit:0,adminFlag:this.$store.state.user.userInfo.adminFlag,isShow:!1,preId:"",sufId:"",branchId:"",treeData:[],juName:"",timeOUt:"",readFlag:!0,curTime:new Date,roleFlag:"",timeFlag:"",statusList:["已报名","延后参训","未接收","已接收"],cxStatusList:["延后参训","已参训"],searchList:[]}},created:function(){this.getRoleSet(),"1"===this.adminFlag?this.getOnlyRoot():this.getDateForJu()},methods:{getDateForJu:function(){var t=this;this.isLoading=!0,Object(n["t"])({id:this.infoId}).then(function(e){t.juList=e.data.listAllUser[0].listUser,t.tableData=e.data.listTotal,t.peopleList=e.data.listAllUser,t.bkNum=e.data.bk,t.cxNum=e.data.ycx,t.juConfirm=e.data.confirm,t.juName=e.data.juName,t.ybm=e.data.ybm,t.wbm=e.data.wbm,setTimeout(function(){t.isLoading=!1},1)})},changDep:function(){this.getDateForAll()},getDateForAll:function(){var t=this;this.isLoading=!0,Object(n["s"])({id:this.infoId,orgId:this.branchId}).then(function(e){"success"===e.data.result&&e.data.list&&e.data.list.length>0&&(t.tableData=e.data.list[0].listTotal,t.peopleList=e.data.list[0].listAllUser,t.juList=e.data.list[0].listAllUser[0].listUser,t.bkNum=e.data.list[0].bk,t.cxNum=e.data.list[0].ycx,t.confirm=e.data.list[0].confirm,t.juName=e.data.list[0].juName,t.ybm=e.data.list[0].ybm,t.wbm=e.data.list[0].wbm,setTimeout(function(){t.isLoading=!1},1))})},getRoleSet:function(){var t=this;Object(n["F"])().then(function(e){t.roleFlag=e.data.flag})},getOnlyRoot:function(){var t=this;Object(n["z"])().then(function(e){t.treeData=e.data.children,t.branchId=e.data.children[0].id,t.getDateForAll()})},objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,a=t.columnIndex;if(0===a)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},showPeople:function(t){var e=this;this.peopleList.forEach(function(a,i){a.deptName===t.deptName&&(e.juList=a.listUser,t.confirm?e.isShow=!1:e.isHaveButton(t.deptId))})},isHaveButton:function(t){var e=this;Object(n["cb"])({deptId:t}).then(function(t){t.data.result?e.isShow=!0:e.isShow=!1})},updateStatus:function(t){var e=this;Object(n["Ib"])({type:"1",status:t.sfcx,infoId:this.infoId,userId:t.id,isWork:"0"===t.isWork?"1":"0"}).then(function(t){"success"===t.data.result?e.$alert("状态修改成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}).catch(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}):"fail"===t.data.result?e.$confirm("当前修改用户无参训记录","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"confirm"===t.data.result?e.$confirm("管理员已确认，不能修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"no Perssion"===t.data.result&&e.$confirm("您没有权限修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){})})},search:function(){var t=this;""===this.form.receiverName&&""===this.form.recDeptId&&""===this.form.isWork&&""===this.form.baoming?this.$notify({title:"提示",message:"请输入搜索条件!",duration:1500,type:"warning"}):Object(n["tb"])(this.form).then(function(e){e.data&&e.data.length>0?t.searchList=e.data:(t.searchList=[],t.$notify({title:"提示",message:"没有搜索到相关数据!",duration:1500,type:"warning"}))})},reset:function(){this.form.receiverName="",this.form.recDeptId="",this.form.isWork="",this.form.baoming=""}}},o=l,r=(a("5c1a"),a("2877")),c=Object(r["a"])(o,i,s,!1,null,"6c0bcb19",null);e["default"]=c.exports},"13d9":function(t,e,a){},"3a4d":function(t,e,a){},"5c1a":function(t,e,a){"use strict";var i=a("13d9"),s=a.n(i);s.a},b5fe:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{class:t.className,style:{height:t.height,width:t.width}})},s=[],n=a("313e"),l=a.n(n),o=a("a7dc");a("817d");var r=6e3,c={mixins:[o["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0},chartTitle:{type:String,default:""}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){this.xData=[],this.yData=[];for(var e=0;e<t.length;e++)this.xData.push(t[e].departName),this.yData.push(t[e].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){this.xData=[],this.yData=[];for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=l.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:this.chartTitle,subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",data:this.xData,axisTick:{show:!1},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},rotate:20}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new l.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:r}]})}}},d=c,u=a("2877"),p=Object(u["a"])(d,i,s,!1,null,null,null);e["default"]=p.exports},c440:function(t,e,a){"use strict";var i=a("f47c"),s=a.n(i);s.a},df89:function(t,e,a){"use strict";var i=a("3a4d"),s=a.n(i);s.a},e3f3:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:19}},[a("div",{staticClass:"container"},[a("div",{staticClass:"header"},[a("div",{staticClass:"title",attrs:{title:t.title}},[t._v(t._s(t.title))]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("span",[t._v("时间：")]),t._v(" "),a("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("类型：")]),t._v(" "),a("span",[t._v("强装兴装大讲堂")])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("主办单位：")]),t._v(" "),a("span",[t._v(t._s(t.zjdept))])]),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"===t.cxFlag&&t.videoIds,expression:"cxFlag==='2' && videoIds"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[a("span",[t._v("播放次数：")]),t._v(" "),a("span",[t._v(t._s(t.palyNum)+"次")])])],1),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1),t._v(" "),a("el-row",[a("el-col",{staticClass:"elColStyle",attrs:{span:24}},[a("el-scrollbar",{staticClass:"hidden-x"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag||"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag!=='2'||(cxFlag==='2'&&!videoIds)"}],attrs:{span:18}},[a("p",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag&&""!==t.timeOUt,expression:"cxFlag !== '2' && timeOUt !== '' "}]},[a("span",[t._v("距离开始：")]),t._v(" "),a("span",{staticStyle:{"font-size":"25px",color:"#F56C6C","margin-left":"10px"}},[t._v(t._s(t.timeOUt))])]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag,expression:"cxFlag!=='2'"}],staticClass:"ma-t_20",attrs:{span:16}},[a("span",[t._v("会议链接：")]),t._v(" "),a("span",{staticStyle:{color:"#3377FF",cursor:"pointer"},on:{click:t.getUrl}},[t._v(t._s(t.meetingLine))]),t._v(" "),a("span",{staticStyle:{color:"#3377FF",dispaly:"inline-block",border:"1px solid #7477FF",padding:"1px 8px","border-radius":"3px","margin-left":"10px",cursor:"pointer"},on:{click:function(e){return t.handleClipboard(t.meetingLine,e)}}},[t._v("复制链接")])]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:"2"===t.bxFlag,expression:"bxFlag==='2'"}],staticClass:"ma-t_20"},[t._v("延后参训原因："+t._s(t.ykReason))]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag,expression:"cxFlag!=='2'"}]},[t._v("\n                    报名状态："),a("el-button",{attrs:{type:"text"}},[t._v(t._s(t.bxList[t.bxFlag]))])],1)]),t._v(" "),a("el-col",{staticClass:"ma-t_20",attrs:{span:18}},[t.videoIds&&"2"===t.cxFlag||t.videoIds&&!t.timeOUt?a("div",[a("video",{ref:"myVideo",staticStyle:{height:"500px",width:"100%"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoIds,controls:"controls"}})]):t._e(),t._v(" "),a("div",{ref:"mainFile",staticStyle:{width:"90%",height:"690px",margin:"0 auto"}},[a("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:"2"!==t.cxFlag||"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag!=='2'||(cxFlag==='2'&&!videoIds)"}],attrs:{span:6}},[t.picturePath?a("img",{staticClass:"imgStyle",attrs:{src:t.picturePath}}):a("div",{staticClass:"imgStyle",staticStyle:{background:"#F9FBFE"}},[a("svg-icon",{staticClass:"icon",staticStyle:{height:"50%",width:"50%","margin-left":"25%","margin-top":"12.5%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.mainFileList.length>0,expression:"mainFileList.length > 0"}],staticStyle:{width:"80%",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("主文件")]),t._v(" "),t._l(t.mainFileList,function(e,i){return a("div",{key:i,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(a){return t.downloadFile(e.pictureId)}}},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),a("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)})],2),t._v(" "),a("div",{staticStyle:{width:"80%",height:"160px",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("本单位补充说明")]),t._v(" "),a("textarea",{directives:[{name:"model",rawName:"v-model",value:t.instraction,expression:"instraction"}],staticStyle:{width:"100%",height:"110px",border:"none",resize:"none",padding:"15px"},attrs:{readonly:""},domProps:{value:t.instraction},on:{input:function(e){e.target.composing||(t.instraction=e.target.value)}}})])])],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:"2"===t.cxFlag&&!t.videoIds,expression:"cxFlag==='2' && !videoIds"}],staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"text"}},[t._v("需补课")]),t._v(" "),a("el-button",{attrs:{type:"text"}},[t._v("视频待上传")])],1)],1)],1)],1)],1)]),t._v(" "),a("el-col",{attrs:{span:5}},[a("el-row",[a("el-col",{attrs:{span:24}},[a("div",{staticClass:"statistics"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("参训完成率")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本课程参训完成率")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.cxWcl)+"%")])]),t._v(" "),a("div",{staticClass:"peopleNum"},[a("div",{staticClass:"flex-center",staticStyle:{padding:"10px 20px"}},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("合计人数")]),a("br")])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.peopleNum))])]),t._v(" "),a("div",{staticClass:"flex-center",staticStyle:{"border-top":"1px solid #ccc",padding:"10px"}},[a("div",{staticStyle:{flex:"1","border-right":"1px solid #ccc","text-align":"center",height:"40px","line-height":"40px"}},[a("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("已参训")]),t._v(" "),a("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v(t._s(t.ycmNum))])]),t._v(" "),a("div",{staticStyle:{flex:"1","text-align":"center",height:"40px","line-height":"40px"}},[a("span",{staticStyle:{color:"#666666","font-size":"14px"}},[t._v("缺席")]),t._v(" "),a("span",{staticStyle:{color:"#666666","font-size":"30px"}},[t._v(t._s(t.qxNum))])])]),t._v(" "),a("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.showView}},[t._v("查看详情 ＞")])]),t._v(" "),a("div",{staticClass:"statistics"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhoujt"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("各单位年度参训完成情况")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("当前大讲堂参训情况")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showChart}},[t._v("查看")])]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{background:"#fff","border-radius":"5px","padding-bottom":"5px"}},[a("title-card",{attrs:{"title-text":"附件资料"}}),t._v(" "),t._l(t.fileList,function(e,i){return a("div",{key:i,on:{click:function(a){return t.downloadFile(e.pictureId)}}},[a("div",{staticStyle:{padding:"10px",display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",attrs:{"icon-class":"affix"}}),t._v(" "),a("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)])})],2)])],1)],1)],1),t._v(" "),a("el-dialog",{staticClass:"dialogList",attrs:{title:"人员参训情况清单",visible:t.dialogFormVisible,width:"80%"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("auditoriumList",{attrs:{"info-id":t.infoId}})],1),t._v(" "),a("el-dialog",{staticClass:"barChart",attrs:{title:"各单位训练完成率统计",visible:t.dialogchart},on:{"update:visible":function(e){t.dialogchart=e},close:t.closeDialog}},[a("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)],1)},s=[],n=(a("a481"),a("7f7f"),a("ac6a"),a("c5f6"),a("09a0")),l=a("35b7"),o=a("b5fe"),r=a("f71e"),c=a("0fe1"),d={components:{auditoriumList:n["default"],TitleCard:l["a"],FinishRate:o["default"]},props:{infoId:{type:String,default:""},videoId:{type:String,default:""},cxFlag:{type:String,default:""},wcl:{type:Number,default:0}},data:function(){return{dialogFormVisible:!1,dialogchart:!1,fileId:"",title:"",videoIds:"",exerciseTime:"",zjdept:"",meetingLine:"",fileList:[],mainFileList:[],finishRateList:[],instraction:"",picturePath:"",palyNum:"1",bxFlag:"",ykReason:"",bxList:["未报名","已报名","延后参训"],symTime:"",videoTime:"",timeOUt:"",ycmNum:"",qxNum:"",peopleNum:"",timer1:"",onlineFileUrl:"",cxWcl:""}},watch:{videoIds:function(t){var e=this;t&&this.$nextTick(function(){e.$refs.myVideo.onplay=function(){},e.$refs.myVideo.ontimeupdate=function(){e.$refs.myVideo.currentTime-e.symTime>1&&(e.$refs.myVideo.currentTime=e.symTime),e.symTime=e.$refs.myVideo.currentTime},e.$refs.myVideo.onended=function(){e.updateStatusForDjt()}})}},created:function(){this.getPerData(),this.getInfo(),this.getPeopleNum()},methods:{getPeopleNum:function(){var t=this;Object(c["A"])({infoId:this.infoId}).then(function(e){t.ycmNum=e.data.ycm,t.qxNum=e.data.qx,t.peopleNum=e.data.sum,t.cxWcl=e.data.wcl})},getPerData:function(){Object(c["B"])({fileId:this.infoId}).then(function(t){})},getInfo:function(){var t=this;Object(c["x"])({infoId:this.infoId,id:this.videoId}).then(function(e){t.title=e.data.title,t.bxFlag=e.data.baoming,t.ykReason=e.data.reason,t.exerciseTime=e.data.time,t.zjdept=e.data.xlglXlzzInfo.zjdept,t.meetingLine=e.data.xlglXlzzInfo.meetingLine,t.picturePath=e.data.xlglXlzzInfo.picturePath,t.videoIds=e.data.xlglPicture?e.data.xlglPicture.pictureId:"",t.fileList=e.data.list,t.mainFileList=e.data.listMainFile,t.onlineFileUrl="/app/openFile/demo.html?fileId="+e.data.listMainFile[0].pictureId+"&access_token="+t.$store.state.user.token,t.timeOUt=t.delayTime()})},back:function(){this.$emit("back")},showView:function(){this.dialogFormVisible=!0},showChart:function(){var t=this;this.dialogchart=!0,this.$refs.mainFile.style.height="10px",Object(c["k"])({infoId:this.infoId}).then(function(e){"success"===e.data.result&&(t.finishRateList=[],e.data.list.forEach(function(e,a){t.finishRateList.push({departName:e.name,value:e.wcl})}))})},closeDialog:function(){this.$refs.mainFile.style.height="690px"},handleClipboard:function(t,e){Object(r["a"])(t,e)},getUrl:function(){"0"!==this.bxFlag?this.timeOUt&&"1"===this.bxFlag?this.$notify({title:"提示",message:"训练还未开始",duration:1500,type:"warning"}):(this.createHuiYi(),this.updateStatusForDjt()):this.$notify({title:"提示",message:"您还未报名，请先报名",duration:1500,type:"warning"})},createHuiYi:function(){var t=this;Object(c["e"])({xlglId:this.infoId}).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"发送会见视频消息成功",duration:1500,type:"success"}):t.$notify({title:"提示",message:"发送会见视频消息失败",duration:1500,type:"warning"})})},delayTime:function(){var t=this.exerciseTime.replace(/-/g,"/"),e=(new Date).getTime(),a=new Date(t).getTime(),i=Math.floor(a-e),s=i,n=Math.floor(i/864e5);i%=864e5;var l=Math.floor(i/36e5);i%=36e5;var o=Math.floor(i/6e4);return i%=6e4,s>0?this.formatType(n)+"天"+this.formatType(l)+"小时"+this.formatType(o)+"分钟":(clearInterval(this.timer1),"")},formatType:function(t){return t>0&&t<10?"0"+t:""+t},updateStatusForDjt:function(){Object(c["Jb"])({infoId:this.infoId}).then(function(t){})},downloadFile:function(t){this.onlineFileUrl="/app/openFile/demo.html?fileId="+t+"&access_token="+this.$store.state.user.token}}},u=d,p=(a("df89"),a("c440"),a("2877")),f=Object(p["a"])(u,i,s,!1,null,"71cd9a09",null);e["default"]=f.exports},f47c:function(t,e,a){},f71e:function(t,e,a){"use strict";a.d(e,"a",function(){return r});var i=a("2b0e"),s=a("b311"),n=a.n(s);function l(){i["default"].prototype.$message({message:"复制成功",type:"success",duration:1500})}function o(){i["default"].prototype.$message({message:"复制失败",type:"error"})}function r(t,e){var a=new n.a(e.target,{text:function(){return t}});a.on("success",function(){l(),a.destroy()}),a.on("error",function(){o(),a.destroy()}),a.onClick(e)}}}]);