(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-bd786fcc"],{"3eeb":function(t,e,n){},5522:function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("div",{staticClass:"app-content"},[n("div",{staticStyle:{position:"relative"}},[n("el-tabs",{staticStyle:{padding:"0 10px"},on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[n("el-tab-pane",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading1,expression:"isLoading1"}],attrs:{label:"训练详情",name:"first"}},[n("el-row",[n("el-col",{staticClass:"elColStyle",attrs:{span:24}},[n("el-scrollbar",{staticClass:"hidden-x"},[n("div",{staticStyle:{padding:"0 30px"}},[n("div",{staticClass:"header"},[n("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),n("el-row",[n("el-col",{attrs:{span:6}},[n("span",[t._v("时间：")]),t._v(" "),n("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),n("el-col",{attrs:{span:6}},[n("span",[t._v("类型：")]),t._v(" "),n("span",[t._v(t._s("0"===t.xltype?"强装兴装大讲堂":"日常军事训练"))])]),t._v(" "),n("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[n("span",[t._v("主办单位：")]),t._v(" "),n("span",[t._v(t._s(t.fbDept))])]),t._v(" "),n("el-col",{staticStyle:{"text-align":"right"},attrs:{span:6}},[n("span",{directives:[{name:"show",rawName:"v-show",value:"0"===t.timeFlag&&"0"===t.xltype&&1===t.showEdit||"1"===t.timeFlag&&"0"!==t.listType&&1===t.showEdit,expression:"(timeFlag === '0' && xltype === '0' && showEdit === 1) || (timeFlag === '1' && listType !== '0' && showEdit === 1)"}],staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editorFn}},[t._v("编辑")]),t._v(" "),n("span",{directives:[{name:"show",rawName:"v-show",value:"0"!==t.listType&&"1"===t.isManager&&""!==t.timeOUt,expression:"(listType!=='0' && isManager === '1' && timeOUt !== '')"}],staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),n("div",{staticStyle:{padding:"20px 40px"}},[n("el-row",{attrs:{gutter:20}},[n("el-col",{attrs:{span:18}},[n("p",{directives:[{name:"show",rawName:"v-show",value:"0"===t.listType&&""!==t.timeOUt,expression:"listType === '0' && timeOUt !== '' "}]},[n("span",[t._v("距离开始:")]),t._v(" "),n("span",{staticStyle:{"font-size":"25px",color:"#F56C6C","margin-left":"10px"}},[t._v(t._s(t.timeOUt))])]),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.ykReason,expression:"ykReason"}],staticClass:"ma-t_20"},[t._v("延后参训原因："+t._s(t.ykReason))]),t._v(" "),n("div",{staticStyle:{width:"80%",height:"690px","margin-top":"20px"}},[n("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),n("el-col",{attrs:{span:6}},[t.picturePath?n("img",{staticClass:"imgStyle1",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.picturePath}}):n("div",{staticClass:"imgStyle1",staticStyle:{background:"#F9FBFE"}},[n("svg-icon",{staticClass:"icon",staticStyle:{height:"50%",width:"50%","margin-left":"25%","margin-top":"12.5%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.mainFileList.length>0,expression:"mainFileList.length > 0"}],staticStyle:{width:"70%",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[n("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("主文件")]),t._v(" "),t._l(t.mainFileList,function(e,i){return n("div",{key:i,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(n){return t.downloadFile(e.pictureId)}}},[n("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),n("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)})],2),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureList.length>0,expression:"pictureList.length > 0"}],staticStyle:{width:"70%",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[n("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.pictureList,function(e,i){return n("div",{key:i,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(n){return t.downloadFile(e.pictureId)}}},[n("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),n("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)})],2),t._v(" "),n("div",{staticStyle:{width:"70%",height:"160px",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[n("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("本单位补充说明")]),t._v(" "),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.instraction,expression:"instraction"}],staticStyle:{width:"100%",height:"110px",border:"none",resize:"none",padding:"15px"},attrs:{readonly:t.readFlag},domProps:{value:t.instraction},on:{input:function(e){e.target.composing||(t.instraction=e.target.value)}}})])])],1),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:"0"===t.listType&&""!==t.timeOUt,expression:"listType==='0' && timeOUt !== ''"}],staticStyle:{"text-align":"center","margin-top":"30px"}},[n("el-button",{attrs:{type:"primary"},on:{click:t.forwardFn}},[t._v("转发")])],1),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:"1"===t.listType&&""!==t.timeOUt,expression:"listType==='1' && timeOUt !== ''"}],staticStyle:{display:"flex","flex-direction":"row","margin-top":"30px"}},["0"===t.bmFlag?n("div",{staticClass:"flexRight"},[n("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"success"},on:{click:t.signUp}},[t._v("报名")]),t._v(" "),n("el-popover",{attrs:{placement:"top",width:"200"},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.params.reason,expression:"params.reason"}],staticStyle:{width:"100%",height:"100%",border:"none",resize:"none"},attrs:{placeholder:"*请输入延后原因",maxlength:"200"},domProps:{value:t.params.reason},on:{input:function(e){e.target.composing||t.$set(t.params,"reason",e.target.value)}}}),t._v(" "),n("div",{staticStyle:{"text-align":"right",margin:"0"}},[n("el-button",{attrs:{type:"primary",size:"mini"},on:{click:t.confirmFn}},[t._v("确定")])],1),t._v(" "),n("el-button",{attrs:{slot:"reference"},slot:"reference"},[t._v("延后参训")])],1)],1):n("div",{staticClass:"flexRight"},[n("el-button",{attrs:{type:"success"}},[t._v(t._s("1"===t.bmFlag?"已报名":"延后参训"))])],1),t._v(" "),n("div",{staticClass:"flexRight"},[n("el-button",{directives:[{name:"show",rawName:"v-show",value:t.preId&&"no"!=t.preId,expression:"preId && preId!='no'"}],attrs:{size:"mini"},on:{click:t.lastInfo}},[t._v("上一篇")]),t._v(" "),n("el-button",{directives:[{name:"show",rawName:"v-show",value:t.sufId&&"no"!=t.sufId,expression:"sufId && sufId!='no'"}],attrs:{size:"mini"},on:{click:t.nextInfo}},[t._v("下一篇")])],1)]),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:"1"!=t.listType,expression:"listType!='1'"}],staticStyle:{"text-align":"right"}},[n("el-button",{directives:[{name:"show",rawName:"v-show",value:t.preId&&"no"!=t.preId,expression:"preId && preId!='no'"}],attrs:{size:"mini"},on:{click:t.lastInfo}},[t._v("上一篇")]),t._v(" "),n("el-button",{directives:[{name:"show",rawName:"v-show",value:t.sufId&&"no"!=t.sufId,expression:"sufId && sufId!='no'"}],attrs:{size:"mini"},on:{click:t.nextInfo}},[t._v("下一篇")])],1)],1)])])],1)],1)],1),t._v(" "),n("el-tab-pane",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],attrs:{label:"训练情况跟踪",name:"second"}},[n("el-row",[n("div",{staticStyle:{"padding-left":"30px","font-size":"20px"}},[t._v("\n              装备发展部各单位报名情况\n            ")]),t._v(" "),n("el-form",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag==='1'"}],staticStyle:{"margin-top":"30px"},attrs:{"label-width":"85px"}},[n("el-form-item",{attrs:{label:"单位："}},[n("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changDep},model:{value:t.branchId,callback:function(e){t.branchId=e},expression:"branchId"}},t._l(t.treeData,function(t,e){return n("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1),t._v(" "),n("div",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],staticStyle:{"padding-left":"30px"}},[n("el-row",{staticStyle:{"margin-top":"20px"}},[n("el-row",[n("el-col",{attrs:{span:3}},[n("span",{directives:[{name:"show",rawName:"v-show",value:"3"===t.roleFlag&&"1"!==t.juConfirm,expression:"roleFlag ==='3' && juConfirm !== '1' "}],staticClass:"labelBtn color_active",staticStyle:{cursor:"pointer"},on:{click:t.confirmStatus}},[t._v("确认")]),t._v(" "),n("span",{directives:[{name:"show",rawName:"v-show",value:"5"===t.roleFlag&&t.isShow,expression:"roleFlag ==='5' && isShow"}],staticClass:"labelBtn color_active",staticStyle:{cursor:"pointer"},on:{click:t.confirmStatus}},[t._v("确认")])])],1),t._v(" "),n("el-row",{attrs:{gutter:30}},[n("el-col",{staticClass:"elCol_style",attrs:{span:15}},[n("el-scrollbar",{staticClass:"hidden-x"},[n("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[n("el-table-column",{attrs:{prop:"id",label:t.juName,align:"center",width:"180"}},[[n("div",{staticClass:"ta-c"},[n("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),n("div",{staticClass:"ta-c"},[t._v("已报名"+t._s(t.ybmNum)+"人")]),t._v(" "),n("div",{staticClass:"ta-c"},[t._v("延后参训"+t._s(t.ySum)+"人")])]],2),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{staticStyle:{cursor:"pointer"},on:{click:function(n){return t.showPeople(e.row)}}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),n("el-table-column",{attrs:{prop:"yjs",align:"center",label:"已接收"}}),t._v(" "),n("el-table-column",{attrs:{prop:"wjs",align:"center",label:"未接收"}}),t._v(" "),n("el-table-column",{attrs:{prop:"sum",align:"center",label:"已报名"}}),t._v(" "),n("el-table-column",{attrs:{prop:"yhSum",align:"center",label:"延后参训"}}),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("div",{staticClass:"ta-c"},[n("span",{class:["labelBtn",e.row.confirm?"color_active":"color_default"]},[t._v(t._s(e.row.confirm?"已确认":"未确认"))])])]}}])})],1)],1)],1),t._v(" "),n("el-col",{staticClass:"elCol_style",attrs:{span:8}},[n("el-scrollbar",{staticClass:"hidden-x"},[n("el-table",{attrs:{data:t.juList}},[n("el-table-column",{attrs:{property:"truename",align:"center",label:"人员姓名"}}),t._v(" "),n("el-table-column",{attrs:{label:"人员状态",align:"center",width:"120"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status?n("el-select",{attrs:{placeholder:"请选择"},model:{value:e.row.status,callback:function(n){t.$set(e.row,"status",n)},expression:"scope.row.status"}},[n("el-option",{attrs:{value:"0",label:"已报名"}},[t._v("已报名")]),t._v(" "),n("el-option",{attrs:{value:"1",label:"延后参训"}},[t._v("延后参训")]),t._v(" "),n("el-option",{attrs:{value:"2",label:"未接收"}},[t._v("未接收")]),t._v(" "),n("el-option",{attrs:{value:"3",label:"已接收"}},[t._v("已接收")])],1):n("span",[t._v("--")])]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",align:"center",width:"60"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{type:"text",size:"small",disabled:!e.row.status},on:{click:function(n){return t.updateStatus(e.row)}}},[t._v("修改")])]}}])})],1)],1)],1)],1)],1)],1)],1)],1)],1),t._v(" "),n("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1)])])},a=[],o=(n("ac6a"),n("a481"),n("0fe1")),s=n("f71e"),r={components:{},props:{listType:{type:String,default:""},infoId:{type:String,default:""},subId:{type:String,default:""},fileId:{type:String,default:""},isManager:{type:String,default:""},flag:{type:String,default:""}},data:function(){return{activeName:"first",tableData:[],juList:[],peopleList:[],visible:!1,params:{reason:"",infoId:"",subId:"",baoming:""},title:"",fbDept:"",xltype:"",exerciseTime:"",picturePath:"",meetingLine:"",todeptName:"",pictureList:[],mainFileList:[],instraction:"",bmFlag:"",isLoading:!1,isLoading1:!1,ySum:"",ybmNum:"",wbm:"",ybm:"",confirm:"",juConfirm:"",showEdit:0,adminFlag:this.$store.state.user.userInfo.adminFlag,isShow:!1,preId:"",sufId:"",branchId:"",treeData:[],juName:"",timeOUt:"",readFlag:!0,roleFlag:"",timeFlag:"",statusList:["已报名","延后参训","未接收","已接收"],ykReason:"",timer:"",onlineFileUrl:""}},created:function(){this.getTrainInfo(this.infoId),this.getIsHavePerssion(),"0"===this.listType?this.readFlag=!1:this.readFlag=!0},mounted:function(){},methods:{getTrainInfo:function(t){var e=this;Object(o["Q"])({id:t,flag:this.flag}).then(function(t){var n=t.data.xlglXlzzInfo,i=n.title,a=n.fbDept,o=n.exerciseTime,s=n.xltype,r=n.picturePath,l=n.bz,c=n.exerciseIssue,u=n.joinPeople,d=n.meetingLine,f=n.todeptName,p=n.baoming;Object.assign(e,{title:i,fbDept:a,exerciseTime:o,xltype:s,picturePath:r,bz:l,exerciseIssue:c,joinPeople:u,meetingLine:d,todeptName:f,bmFlag:p}),e.pictureList=t.data.listFile,e.mainFileList=t.data.listMainFile,e.onlineFileUrl="/app/openFile/demo.html?fileId="+t.data.listMainFile[0].pictureId+"&access_token="+e.$store.state.user.token,e.preId=t.data.preId,e.sufId=t.data.sufId,e.timeFlag=t.data.time,e.instraction=t.data.instraction,e.ykReason=t.data.xlglXlzzInfo.reason,e.timeOUt=e.delayTime()})},delayTime:function(){var t=this.exerciseTime.replace(/-/g,"/"),e=(new Date).getTime(),n=new Date(t).getTime(),i=Math.floor(n-e),a=i,o=Math.floor(i/864e5);i%=864e5;var s=Math.floor(i/36e5);i%=36e5;var r=Math.floor(i/6e4);return i%=6e4,a>0?this.formatType(o)+"天"+this.formatType(s)+"小时"+this.formatType(r)+"分钟":""},formatType:function(t){return t>0&&t<10?"0"+t:""+t},getIsHavePerssion:function(){var t=this;Object(o["y"])({id:this.infoId}).then(function(e){"success"===e.data.result?t.showEdit=1:t.showEdit=0})},getDateForJu:function(){var t=this;this.isLoading=!0,Object(o["t"])({id:this.infoId}).then(function(e){t.juList=e.data.listAllUser[0].listUser,t.tableData=e.data.listTotal,t.peopleList=e.data.listAllUser,t.ySum=e.data.ySum,t.ybmNum=e.data.ybm,t.juConfirm=e.data.confirm,t.juName=e.data.juName,t.ybm=e.data.ybm,t.wbm=e.data.wbm,setTimeout(function(){t.isLoading=!1},1)})},changDep:function(){this.getDateForAll()},getDateForAll:function(){var t=this;this.isLoading=!0,Object(o["s"])({id:this.infoId,orgId:this.branchId}).then(function(e){"success"===e.data.result&&e.data.list&&e.data.list.length>0&&(t.tableData=e.data.list[0].listTotal,t.peopleList=e.data.list[0].listAllUser,t.juList=e.data.list[0].listAllUser[0].listUser,t.ySum=e.data.list[0].ySum,t.ybmNum=e.data.list[0].ybm,t.confirm=e.data.list[0].confirm,t.juName=e.data.list[0].juName,t.ybm=e.data.list[0].ybm,t.wbm=e.data.list[0].wbm,setTimeout(function(){t.isLoading=!1},1))})},handleClick:function(t){"1"===t.index&&(this.getRoleSet(),"1"===this.adminFlag?this.getOnlyRoot():this.getDateForJu())},getRoleSet:function(){var t=this;Object(o["F"])().then(function(e){t.roleFlag=e.data.flag})},getOnlyRoot:function(){var t=this;Object(o["z"])().then(function(e){t.treeData=e.data.children,t.branchId=e.data.children[0].id,t.getDateForAll()})},back:function(){this.$emit("back",0,this.listType)},getUrl:function(){this.createHuiYi()},createHuiYi:function(){var t=this;Object(o["e"])({xlglId:this.infoId}).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"发送会见视频消息成功",duration:1500,type:"success"}):t.$notify({title:"提示",message:"发送会见视频消息失败",duration:1500,type:"warning"})})},updateStatusForDjt:function(){Object(o["Jb"])({infoId:this.infoId}).then(function(t){})},handleClipboard:function(t,e){Object(s["a"])(t,e)},objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,n=t.columnIndex;if(0===n)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},editorFn:function(){this.$emit("backAdd",1,this.infoId)},deleteFn:function(){var t=this;"1"===this.adminFlag?this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.deleteZhu()}).catch(function(){t.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})}):"2"===this.adminFlag&&this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.deleteInfo()}).catch(function(){t.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})})},deleteInfo:function(){var t=this;Object(o["g"])({id:this.infoId}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}),t.back()):"false"===e.data.result?t.$confirm("当前时间小于开始时间，不能删除！","提示",{type:"warning",center:!0}):t.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"})})},deleteZhu:function(){var t=this;Object(o["h"])({id:this.infoId}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}),t.back()):"false"===e.data.result?t.$confirm("当前时间大于开始时间，不能删除!","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):t.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"})})},baoMing:function(t){var e=this;this.params.infoId=this.infoId,this.params.subId=this.fileId,this.params.baoming=t,Object(o["a"])(this.params).then(function(n){"success"===n.data.result?(e.$notify({title:"提示",message:"1"===t?"报名成功":"延迟参训成功",duration:1500,type:"success"}),e.back()):e.$notify({title:"提示",message:"1"===t?"报名失败":"延迟参训失败",duration:1500,type:"warning"})})},signUp:function(){this.baoMing("1")},confirmFn:function(){""===this.params.reason?this.$notify({title:"提示",message:"请输入延后原因",duration:1500,type:"warning"}):(this.baoMing("2"),this.visible=!1)},confirmStatus:function(){var t=this;Object(o["Ob"])({infoId:this.infoId}).then(function(e){"success"===e.data.result&&t.$alert("确认成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){t.getDateForJu(),t.isShow=!1}).catch(function(){})})},forwardFn:function(){var t=this;this.isLoading1=!0,Object(o["vb"])({fileId:this.infoId,instraction:this.instraction,subId:this.subId}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"转发成功",duration:1500,type:"success"}),t.back()):t.$notify({title:"提示",message:"转发失败",duration:1500,type:"warning"}),setTimeout(function(){t.isLoading1=!1},1)})},lastInfo:function(){this.getTrainInfo(this.preId)},nextInfo:function(){this.getTrainInfo(this.sufId)},showPeople:function(t){var e=this;this.peopleList.forEach(function(n,i){n.deptName===t.deptName&&(e.juList=n.listUser,t.confirm?e.isShow=!1:e.isHaveButton(t.deptId))})},isHaveButton:function(t){var e=this;Object(o["cb"])({deptId:t}).then(function(t){t.data.result?e.isShow=!0:e.isShow=!1})},updateStatus:function(t){var e=this;Object(o["Ib"])({type:"0",status:t.status,infoId:this.infoId,userId:t.id,isWork:"0"===t.isWork?"1":"0"}).then(function(t){"success"===t.data.result?e.$alert("状态修改成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}).catch(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}):"fail"===t.data.result?e.$confirm("当前修改用户无参训记录","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"confirm"===t.data.result?e.$confirm("管理员已确认，不能修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"no Perssion"===t.data.result&&e.$confirm("您没有权限修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){})})},downloadFile:function(t){this.onlineFileUrl="/app/openFile/demo.html?fileId="+t+"&access_token="+this.$store.state.user.token}}},l=r,c=(n("6198"),n("f86d"),n("2877")),u=Object(c["a"])(l,i,a,!1,null,"4bc45b2c",null);e["default"]=u.exports},6198:function(t,e,n){"use strict";var i=n("3eeb"),a=n.n(i);a.a},"66d5":function(t,e,n){},b311:function(t,e,n){
/*!
 * clipboard.js v2.0.4
 * https://zenorocha.github.io/clipboard.js
 * 
 * Licensed MIT © Zeno Rocha
 */
(function(e,n){t.exports=n()})(0,function(){return function(t){var e={};function n(i){if(e[i])return e[i].exports;var a=e[i]={i:i,l:!1,exports:{}};return t[i].call(a.exports,a,a.exports,n),a.l=!0,a.exports}return n.m=t,n.c=e,n.d=function(t,e,i){n.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:i})},n.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},n.t=function(t,e){if(1&e&&(t=n(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var i=Object.create(null);if(n.r(i),Object.defineProperty(i,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var a in t)n.d(i,a,function(e){return t[e]}.bind(null,a));return i},n.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return n.d(e,"a",e),e},n.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},n.p="",n(n.s=0)}([function(t,e,n){"use strict";var i="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},a=function(){function t(t,e){for(var n=0;n<e.length;n++){var i=e[n];i.enumerable=i.enumerable||!1,i.configurable=!0,"value"in i&&(i.writable=!0),Object.defineProperty(t,i.key,i)}}return function(e,n,i){return n&&t(e.prototype,n),i&&t(e,i),e}}(),o=n(1),s=d(o),r=n(3),l=d(r),c=n(4),u=d(c);function d(t){return t&&t.__esModule?t:{default:t}}function f(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function p(t,e){if(!t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!e||"object"!==typeof e&&"function"!==typeof e?t:e}function h(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function, not "+typeof e);t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,enumerable:!1,writable:!0,configurable:!0}}),e&&(Object.setPrototypeOf?Object.setPrototypeOf(t,e):t.__proto__=e)}var m=function(t){function e(t,n){f(this,e);var i=p(this,(e.__proto__||Object.getPrototypeOf(e)).call(this));return i.resolveOptions(n),i.listenClick(t),i}return h(e,t),a(e,[{key:"resolveOptions",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};this.action="function"===typeof t.action?t.action:this.defaultAction,this.target="function"===typeof t.target?t.target:this.defaultTarget,this.text="function"===typeof t.text?t.text:this.defaultText,this.container="object"===i(t.container)?t.container:document.body}},{key:"listenClick",value:function(t){var e=this;this.listener=(0,u.default)(t,"click",function(t){return e.onClick(t)})}},{key:"onClick",value:function(t){var e=t.delegateTarget||t.currentTarget;this.clipboardAction&&(this.clipboardAction=null),this.clipboardAction=new s.default({action:this.action(e),target:this.target(e),text:this.text(e),container:this.container,trigger:e,emitter:this})}},{key:"defaultAction",value:function(t){return v("action",t)}},{key:"defaultTarget",value:function(t){var e=v("target",t);if(e)return document.querySelector(e)}},{key:"defaultText",value:function(t){return v("text",t)}},{key:"destroy",value:function(){this.listener.destroy(),this.clipboardAction&&(this.clipboardAction.destroy(),this.clipboardAction=null)}}],[{key:"isSupported",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:["copy","cut"],e="string"===typeof t?[t]:t,n=!!document.queryCommandSupported;return e.forEach(function(t){n=n&&!!document.queryCommandSupported(t)}),n}}]),e}(l.default);function v(t,e){var n="data-clipboard-"+t;if(e.hasAttribute(n))return e.getAttribute(n)}t.exports=m},function(t,e,n){"use strict";var i="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},a=function(){function t(t,e){for(var n=0;n<e.length;n++){var i=e[n];i.enumerable=i.enumerable||!1,i.configurable=!0,"value"in i&&(i.writable=!0),Object.defineProperty(t,i.key,i)}}return function(e,n,i){return n&&t(e.prototype,n),i&&t(e,i),e}}(),o=n(2),s=r(o);function r(t){return t&&t.__esModule?t:{default:t}}function l(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}var c=function(){function t(e){l(this,t),this.resolveOptions(e),this.initSelection()}return a(t,[{key:"resolveOptions",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};this.action=t.action,this.container=t.container,this.emitter=t.emitter,this.target=t.target,this.text=t.text,this.trigger=t.trigger,this.selectedText=""}},{key:"initSelection",value:function(){this.text?this.selectFake():this.target&&this.selectTarget()}},{key:"selectFake",value:function(){var t=this,e="rtl"==document.documentElement.getAttribute("dir");this.removeFake(),this.fakeHandlerCallback=function(){return t.removeFake()},this.fakeHandler=this.container.addEventListener("click",this.fakeHandlerCallback)||!0,this.fakeElem=document.createElement("textarea"),this.fakeElem.style.fontSize="12pt",this.fakeElem.style.border="0",this.fakeElem.style.padding="0",this.fakeElem.style.margin="0",this.fakeElem.style.position="absolute",this.fakeElem.style[e?"right":"left"]="-9999px";var n=window.pageYOffset||document.documentElement.scrollTop;this.fakeElem.style.top=n+"px",this.fakeElem.setAttribute("readonly",""),this.fakeElem.value=this.text,this.container.appendChild(this.fakeElem),this.selectedText=(0,s.default)(this.fakeElem),this.copyText()}},{key:"removeFake",value:function(){this.fakeHandler&&(this.container.removeEventListener("click",this.fakeHandlerCallback),this.fakeHandler=null,this.fakeHandlerCallback=null),this.fakeElem&&(this.container.removeChild(this.fakeElem),this.fakeElem=null)}},{key:"selectTarget",value:function(){this.selectedText=(0,s.default)(this.target),this.copyText()}},{key:"copyText",value:function(){var t=void 0;try{t=document.execCommand(this.action)}catch(e){t=!1}this.handleResult(t)}},{key:"handleResult",value:function(t){this.emitter.emit(t?"success":"error",{action:this.action,text:this.selectedText,trigger:this.trigger,clearSelection:this.clearSelection.bind(this)})}},{key:"clearSelection",value:function(){this.trigger&&this.trigger.focus(),window.getSelection().removeAllRanges()}},{key:"destroy",value:function(){this.removeFake()}},{key:"action",set:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"copy";if(this._action=t,"copy"!==this._action&&"cut"!==this._action)throw new Error('Invalid "action" value, use either "copy" or "cut"')},get:function(){return this._action}},{key:"target",set:function(t){if(void 0!==t){if(!t||"object"!==("undefined"===typeof t?"undefined":i(t))||1!==t.nodeType)throw new Error('Invalid "target" value, use a valid Element');if("copy"===this.action&&t.hasAttribute("disabled"))throw new Error('Invalid "target" attribute. Please use "readonly" instead of "disabled" attribute');if("cut"===this.action&&(t.hasAttribute("readonly")||t.hasAttribute("disabled")))throw new Error('Invalid "target" attribute. You can\'t cut text from elements with "readonly" or "disabled" attributes');this._target=t}},get:function(){return this._target}}]),t}();t.exports=c},function(t,e){function n(t){var e;if("SELECT"===t.nodeName)t.focus(),e=t.value;else if("INPUT"===t.nodeName||"TEXTAREA"===t.nodeName){var n=t.hasAttribute("readonly");n||t.setAttribute("readonly",""),t.select(),t.setSelectionRange(0,t.value.length),n||t.removeAttribute("readonly"),e=t.value}else{t.hasAttribute("contenteditable")&&t.focus();var i=window.getSelection(),a=document.createRange();a.selectNodeContents(t),i.removeAllRanges(),i.addRange(a),e=i.toString()}return e}t.exports=n},function(t,e){function n(){}n.prototype={on:function(t,e,n){var i=this.e||(this.e={});return(i[t]||(i[t]=[])).push({fn:e,ctx:n}),this},once:function(t,e,n){var i=this;function a(){i.off(t,a),e.apply(n,arguments)}return a._=e,this.on(t,a,n)},emit:function(t){var e=[].slice.call(arguments,1),n=((this.e||(this.e={}))[t]||[]).slice(),i=0,a=n.length;for(i;i<a;i++)n[i].fn.apply(n[i].ctx,e);return this},off:function(t,e){var n=this.e||(this.e={}),i=n[t],a=[];if(i&&e)for(var o=0,s=i.length;o<s;o++)i[o].fn!==e&&i[o].fn._!==e&&a.push(i[o]);return a.length?n[t]=a:delete n[t],this}},t.exports=n},function(t,e,n){var i=n(5),a=n(6);function o(t,e,n){if(!t&&!e&&!n)throw new Error("Missing required arguments");if(!i.string(e))throw new TypeError("Second argument must be a String");if(!i.fn(n))throw new TypeError("Third argument must be a Function");if(i.node(t))return s(t,e,n);if(i.nodeList(t))return r(t,e,n);if(i.string(t))return l(t,e,n);throw new TypeError("First argument must be a String, HTMLElement, HTMLCollection, or NodeList")}function s(t,e,n){return t.addEventListener(e,n),{destroy:function(){t.removeEventListener(e,n)}}}function r(t,e,n){return Array.prototype.forEach.call(t,function(t){t.addEventListener(e,n)}),{destroy:function(){Array.prototype.forEach.call(t,function(t){t.removeEventListener(e,n)})}}}function l(t,e,n){return a(document.body,t,e,n)}t.exports=o},function(t,e){e.node=function(t){return void 0!==t&&t instanceof HTMLElement&&1===t.nodeType},e.nodeList=function(t){var n=Object.prototype.toString.call(t);return void 0!==t&&("[object NodeList]"===n||"[object HTMLCollection]"===n)&&"length"in t&&(0===t.length||e.node(t[0]))},e.string=function(t){return"string"===typeof t||t instanceof String},e.fn=function(t){var e=Object.prototype.toString.call(t);return"[object Function]"===e}},function(t,e,n){var i=n(7);function a(t,e,n,i,a){var o=s.apply(this,arguments);return t.addEventListener(n,o,a),{destroy:function(){t.removeEventListener(n,o,a)}}}function o(t,e,n,i,o){return"function"===typeof t.addEventListener?a.apply(null,arguments):"function"===typeof n?a.bind(null,document).apply(null,arguments):("string"===typeof t&&(t=document.querySelectorAll(t)),Array.prototype.map.call(t,function(t){return a(t,e,n,i,o)}))}function s(t,e,n,a){return function(n){n.delegateTarget=i(n.target,e),n.delegateTarget&&a.call(t,n)}}t.exports=o},function(t,e){var n=9;if("undefined"!==typeof Element&&!Element.prototype.matches){var i=Element.prototype;i.matches=i.matchesSelector||i.mozMatchesSelector||i.msMatchesSelector||i.oMatchesSelector||i.webkitMatchesSelector}function a(t,e){while(t&&t.nodeType!==n){if("function"===typeof t.matches&&t.matches(e))return t;t=t.parentNode}}t.exports=a}])})},f71e:function(t,e,n){"use strict";n.d(e,"a",function(){return l});var i=n("2b0e"),a=n("b311"),o=n.n(a);function s(){i["default"].prototype.$message({message:"复制成功",type:"success",duration:1500})}function r(){i["default"].prototype.$message({message:"复制失败",type:"error"})}function l(t,e){var n=new o.a(e.target,{text:function(){return t}});n.on("success",function(){s(),n.destroy()}),n.on("error",function(){r(),n.destroy()}),n.onClick(e)}},f86d:function(t,e,n){"use strict";var i=n("66d5"),a=n.n(i);a.a}}]);