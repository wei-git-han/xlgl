(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-e8218334"],{"3eeb":function(t,e,i){},5522:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{staticStyle:{padding:"0 10px"},on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading1,expression:"isLoading1"}],attrs:{label:"训练详情",name:"first"}},[i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("div",{staticStyle:{padding:"0 30px"}},[i("div",{staticClass:"header"},[i("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("span",[t._v("时间：")]),t._v(" "),i("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),i("el-col",{attrs:{span:6}},[i("span",[t._v("类型：")]),t._v(" "),i("span",[t._v(t._s("0"===t.xltype?"强装兴装大讲堂":"日常军事训练"))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("主办单位：")]),t._v(" "),i("span",[t._v(t._s(t.fbDept))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"right"},attrs:{span:6}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"0"===t.timeFlag&&"0"===t.xltype&&1===t.showEdit||"1"===t.timeFlag&&"0"!==t.listType&&1===t.showEdit,expression:"(timeFlag === '0' && xltype === '0' && showEdit === 1) || (timeFlag === '1' && listType !== '0' && showEdit === 1)"}],staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editorFn}},[t._v("编辑")]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"0"!==t.listType&&"1"===t.isManager&&""!==t.timeOUt,expression:"(listType!=='0' && isManager === '1' && timeOUt !== '')"}],staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),i("div",{staticStyle:{padding:"20px 40px"}},[i("el-row",{attrs:{gutter:20}},[i("el-col",{attrs:{span:18}},[i("p",{directives:[{name:"show",rawName:"v-show",value:"0"===t.listType&&""!==t.timeOUt,expression:"listType === '0' && timeOUt !== '' "}]},[i("span",[t._v("距离开始:")]),t._v(" "),i("span",{staticStyle:{"font-size":"25px",color:"#F56C6C","margin-left":"10px"}},[t._v(t._s(t.timeOUt))])]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.ykReason,expression:"ykReason"}],staticClass:"ma-t_20"},[t._v("延后参训原因："+t._s(t.ykReason))]),t._v(" "),i("div",{staticStyle:{width:"80%",height:"690px","margin-top":"20px"}},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),t._v(" "),i("el-col",{attrs:{span:6}},[t.picturePath?i("img",{staticClass:"imgStyle1",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.picturePath}}):i("div",{staticClass:"imgStyle1",staticStyle:{background:"#F9FBFE"}},[i("svg-icon",{staticClass:"icon",staticStyle:{height:"50%",width:"50%","margin-left":"25%","margin-top":"12.5%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.mainFileList.length>0,expression:"mainFileList.length > 0"}],staticStyle:{width:"70%",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("主文件")]),t._v(" "),t._l(t.mainFileList,function(e,a){return i("div",{key:a,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(i){return t.downloadFile(e.pictureId)}}},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)})],2),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureList.length>0,expression:"pictureList.length > 0"}],staticStyle:{width:"70%",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.pictureList,function(e,a){return i("div",{key:a,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(i){return t.downloadFile(e.pictureId)}}},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)})],2),t._v(" "),i("div",{staticStyle:{width:"70%",height:"160px",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("本单位补充说明")]),t._v(" "),i("textarea",{directives:[{name:"model",rawName:"v-model",value:t.instraction,expression:"instraction"}],staticStyle:{width:"100%",height:"110px",border:"none",resize:"none",padding:"15px"},attrs:{readonly:t.readFlag},domProps:{value:t.instraction},on:{input:function(e){e.target.composing||(t.instraction=e.target.value)}}})])])],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"0"===t.listType&&""!==t.timeOUt,expression:"listType==='0' && timeOUt !== ''"}],staticStyle:{"text-align":"center","margin-top":"30px"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.forwardFn}},[t._v("转发")])],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"1"===t.listType&&""!==t.timeOUt,expression:"listType==='1' && timeOUt !== ''"}],staticStyle:{display:"flex","flex-direction":"row","margin-top":"30px"}},["0"===t.bmFlag?i("div",{staticClass:"flexRight"},[i("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"success"},on:{click:t.signUp}},[t._v("报名")]),t._v(" "),i("el-popover",{attrs:{placement:"top",width:"200"},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[i("textarea",{directives:[{name:"model",rawName:"v-model",value:t.params.reason,expression:"params.reason"}],staticStyle:{width:"100%",height:"100%",border:"none",resize:"none"},attrs:{placeholder:"*请输入延后原因",maxlength:"200"},domProps:{value:t.params.reason},on:{input:function(e){e.target.composing||t.$set(t.params,"reason",e.target.value)}}}),t._v(" "),i("div",{staticStyle:{"text-align":"right",margin:"0"}},[i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:t.confirmFn}},[t._v("确定")])],1),t._v(" "),i("el-button",{attrs:{slot:"reference"},slot:"reference"},[t._v("延后参训")])],1)],1):i("div",{staticClass:"flexRight"},[i("el-button",{attrs:{type:"success"}},[t._v(t._s("1"===t.bmFlag?"已报名":"延后参训"))])],1),t._v(" "),i("div",{staticClass:"flexRight"},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:t.preId&&"no"!=t.preId,expression:"preId && preId!='no'"}],attrs:{size:"mini"},on:{click:t.lastInfo}},[t._v("上一篇")]),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:t.sufId&&"no"!=t.sufId,expression:"sufId && sufId!='no'"}],attrs:{size:"mini"},on:{click:t.nextInfo}},[t._v("下一篇")])],1)]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"1"!=t.listType,expression:"listType!='1'"}],staticStyle:{"text-align":"right"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:t.preId&&"no"!=t.preId,expression:"preId && preId!='no'"}],attrs:{size:"mini"},on:{click:t.lastInfo}},[t._v("上一篇")]),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:t.sufId&&"no"!=t.sufId,expression:"sufId && sufId!='no'"}],attrs:{size:"mini"},on:{click:t.nextInfo}},[t._v("下一篇")])],1)],1)])])],1)],1)],1),t._v(" "),i("el-tab-pane",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],attrs:{label:"训练情况跟踪",name:"second"}},[i("el-row",[i("div",{staticStyle:{"padding-left":"30px","font-size":"20px"}},[t._v("\n              装备发展部各单位报名情况\n            ")]),t._v(" "),i("el-form",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag==='1'"}],staticStyle:{"margin-top":"30px"},attrs:{"label-width":"85px"}},[i("el-form-item",{attrs:{label:"单位："}},[i("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changDep},model:{value:t.branchId,callback:function(e){t.branchId=e},expression:"branchId"}},t._l(t.treeData,function(t,e){return i("el-option",{key:e,attrs:{label:t.text,value:t.id}})}),1)],1)],1),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],staticStyle:{"padding-left":"30px"}},[i("el-row",{staticStyle:{"margin-top":"20px"}},[i("el-row",[i("el-col",{attrs:{span:3}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"3"===t.roleFlag&&"1"!==t.juConfirm,expression:"roleFlag ==='3' && juConfirm !== '1' "}],staticClass:"labelBtn color_active",staticStyle:{cursor:"pointer"},on:{click:t.confirmStatus}},[t._v("确认")]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"5"===t.roleFlag&&t.isShow,expression:"roleFlag ==='5' && isShow"}],staticClass:"labelBtn color_active",staticStyle:{cursor:"pointer"},on:{click:t.confirmStatus}},[t._v("确认")])])],1),t._v(" "),i("el-row",{attrs:{gutter:30}},[i("el-col",{staticClass:"elCol_style",attrs:{span:15}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,"span-method":t.objectSpanMethod,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[i("el-table-column",{attrs:{prop:"id",label:t.juName,align:"center",width:"180"}},[[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn","0"!=t.confirm?"color_active":"color_default"]},[t._v(t._s("0"==t.confirm?"未确认":"确认"))])]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("已报名"+t._s(t.ybmNum)+"人")]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("延后参训"+t._s(t.ySum)+"人")])]],2),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",{staticStyle:{cursor:"pointer"},on:{click:function(i){return t.showPeople(e.row)}}},[t._v(t._s(e.row.deptName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{prop:"yjs",align:"center",label:"已接收"}}),t._v(" "),i("el-table-column",{attrs:{prop:"wjs",align:"center",label:"未接收"}}),t._v(" "),i("el-table-column",{attrs:{prop:"sum",align:"center",label:"已报名"}}),t._v(" "),i("el-table-column",{attrs:{prop:"yhSum",align:"center",label:"延后参训"}}),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn",e.row.confirm?"color_active":"color_default"]},[t._v(t._s(e.row.confirm?"已确认":"未确认"))])])]}}])})],1)],1)],1),t._v(" "),i("el-col",{staticClass:"elCol_style",attrs:{span:8}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-table",{attrs:{data:t.juList}},[i("el-table-column",{attrs:{property:"truename",align:"center",label:"人员姓名"}}),t._v(" "),i("el-table-column",{attrs:{label:"人员状态",align:"center",width:"120"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status?i("el-select",{attrs:{placeholder:"请选择"},model:{value:e.row.status,callback:function(i){t.$set(e.row,"status",i)},expression:"scope.row.status"}},[i("el-option",{attrs:{value:"0",label:"已报名"}},[t._v("已报名")]),t._v(" "),i("el-option",{attrs:{value:"1",label:"延后参训"}},[t._v("延后参训")]),t._v(" "),i("el-option",{attrs:{value:"2",label:"未接收"}},[t._v("未接收")]),t._v(" "),i("el-option",{attrs:{value:"3",label:"已接收"}},[t._v("已接收")])],1):i("span",[t._v("--")])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.reason?e.row.reason:"--"))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"操作",align:"center",width:"60"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{type:"text",size:"small",disabled:!e.row.status},on:{click:function(i){return t.updateStatus(e.row)}}},[t._v("修改")])]}}])})],1)],1)],1)],1)],1)],1)],1)],1)],1),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1)])])},n=[],s=(i("ac6a"),i("a481"),i("0fe1")),o=i("f71e"),l={components:{},props:{listType:{type:String,default:""},infoId:{type:String,default:""},subId:{type:String,default:""},fileId:{type:String,default:""},isManager:{type:String,default:""},flag:{type:String,default:""}},data:function(){return{activeName:"first",tableData:[],juList:[],peopleList:[],visible:!1,params:{reason:"",infoId:"",subId:"",baoming:""},title:"",fbDept:"",xltype:"",exerciseTime:"",picturePath:"",meetingLine:"",todeptName:"",pictureList:[],mainFileList:[],instraction:"",bmFlag:"",isLoading:!1,isLoading1:!1,ySum:"",ybmNum:"",wbm:"",ybm:"",confirm:"",juConfirm:"",showEdit:0,adminFlag:this.$store.state.user.userInfo.adminFlag,isShow:!1,preId:"",sufId:"",branchId:"",treeData:[],juName:"",timeOUt:"",readFlag:!0,roleFlag:"",timeFlag:"",statusList:["已报名","延后参训","未接收","已接收"],ykReason:"",timer:"",onlineFileUrl:""}},created:function(){this.getTrainInfo(this.infoId),this.getIsHavePerssion(),"0"===this.listType?this.readFlag=!1:this.readFlag=!0},mounted:function(){},methods:{getTrainInfo:function(t){var e=this;Object(s["Q"])({id:t,flag:this.flag}).then(function(t){var i=t.data.xlglXlzzInfo,a=i.title,n=i.fbDept,s=i.exerciseTime,o=i.xltype,l=i.picturePath,r=i.bz,c=i.exerciseIssue,d=i.joinPeople,u=i.meetingLine,p=i.todeptName,m=i.baoming;Object.assign(e,{title:a,fbDept:n,exerciseTime:s,xltype:o,picturePath:l,bz:r,exerciseIssue:c,joinPeople:d,meetingLine:u,todeptName:p,bmFlag:m}),e.pictureList=t.data.listFile,e.mainFileList=t.data.listMainFile,e.onlineFileUrl="/app/openFile/demo.html?fileId="+t.data.listMainFile[0].pictureId+"&access_token="+e.$store.state.user.token,e.preId=t.data.preId,e.sufId=t.data.sufId,e.timeFlag=t.data.time,e.instraction=t.data.instraction,e.ykReason=t.data.xlglXlzzInfo.reason,e.timeOUt=e.delayTime()})},delayTime:function(){var t=this.exerciseTime.replace(/-/g,"/"),e=(new Date).getTime(),i=new Date(t).getTime(),a=Math.floor(i-e),n=a,s=Math.floor(a/864e5);a%=864e5;var o=Math.floor(a/36e5);a%=36e5;var l=Math.floor(a/6e4);return a%=6e4,n>0?this.formatType(s)+"天"+this.formatType(o)+"小时"+this.formatType(l)+"分钟":""},formatType:function(t){return t>0&&t<10?"0"+t:""+t},getIsHavePerssion:function(){var t=this;Object(s["y"])({id:this.infoId}).then(function(e){"success"===e.data.result?t.showEdit=1:t.showEdit=0})},getDateForJu:function(){var t=this;this.isLoading=!0,Object(s["t"])({id:this.infoId}).then(function(e){t.juList=e.data.listAllUser[0].listUser,t.tableData=e.data.listTotal,t.peopleList=e.data.listAllUser,t.ySum=e.data.ySum,t.ybmNum=e.data.ybm,t.juConfirm=e.data.confirm,t.juName=e.data.juName,t.ybm=e.data.ybm,t.wbm=e.data.wbm,setTimeout(function(){t.isLoading=!1},1)})},changDep:function(){this.getDateForAll()},getDateForAll:function(){var t=this;this.isLoading=!0,Object(s["s"])({id:this.infoId,orgId:this.branchId}).then(function(e){"success"===e.data.result&&e.data.list&&e.data.list.length>0&&(t.tableData=e.data.list[0].listTotal,t.peopleList=e.data.list[0].listAllUser,t.juList=e.data.list[0].listAllUser[0].listUser,t.ySum=e.data.list[0].ySum,t.ybmNum=e.data.list[0].ybm,t.confirm=e.data.list[0].confirm,t.juName=e.data.list[0].juName,t.ybm=e.data.list[0].ybm,t.wbm=e.data.list[0].wbm,setTimeout(function(){t.isLoading=!1},1))})},handleClick:function(t){"1"===t.index&&(this.getRoleSet(),"1"===this.adminFlag?this.getOnlyRoot():this.getDateForJu())},getRoleSet:function(){var t=this;Object(s["F"])().then(function(e){t.roleFlag=e.data.flag})},getOnlyRoot:function(){var t=this;Object(s["z"])().then(function(e){t.treeData=e.data.children,t.branchId=e.data.children[0].id,t.getDateForAll()})},back:function(){this.$emit("back",0,this.listType)},getUrl:function(){this.createHuiYi()},createHuiYi:function(){var t=this;Object(s["e"])({xlglId:this.infoId}).then(function(e){0===e.data.code?t.$notify({title:"提示",message:"发送会见视频消息成功",duration:1500,type:"success"}):t.$notify({title:"提示",message:"发送会见视频消息失败",duration:1500,type:"warning"})})},updateStatusForDjt:function(){Object(s["Jb"])({infoId:this.infoId}).then(function(t){})},handleClipboard:function(t,e){Object(o["a"])(t,e)},objectSpanMethod:function(t){t.row,t.column;var e=t.rowIndex,i=t.columnIndex;if(0===i)return e%this.tableData.length===0?{rowspan:this.tableData.length,colspan:1}:{rowspan:0,colspan:0}},editorFn:function(){this.$emit("backAdd",1,this.infoId)},deleteFn:function(){var t=this;"1"===this.adminFlag?this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.deleteZhu()}).catch(function(){t.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})}):"2"===this.adminFlag&&this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.deleteInfo()}).catch(function(){t.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})})},deleteInfo:function(){var t=this;Object(s["g"])({id:this.infoId}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}),t.back()):"false"===e.data.result?t.$confirm("当前时间小于开始时间，不能删除！","提示",{type:"warning",center:!0}):t.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"})})},deleteZhu:function(){var t=this;Object(s["h"])({id:this.infoId}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}),t.back()):"false"===e.data.result?t.$confirm("当前时间大于开始时间，不能删除!","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):t.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"})})},baoMing:function(t){var e=this;this.params.infoId=this.infoId,this.params.subId=this.fileId,this.params.baoming=t,Object(s["a"])(this.params).then(function(i){"success"===i.data.result?(e.$notify({title:"提示",message:"1"===t?"报名成功":"延迟参训成功",duration:1500,type:"success"}),e.back()):e.$notify({title:"提示",message:"1"===t?"报名失败":"延迟参训失败",duration:1500,type:"warning"})})},signUp:function(){this.baoMing("1")},confirmFn:function(){""===this.params.reason?this.$notify({title:"提示",message:"请输入延后原因",duration:1500,type:"warning"}):(this.baoMing("2"),this.visible=!1)},confirmStatus:function(){var t=this;Object(s["Ob"])({infoId:this.infoId}).then(function(e){"success"===e.data.result&&t.$alert("确认成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){t.getDateForJu(),t.isShow=!1}).catch(function(){})})},forwardFn:function(){var t=this;this.isLoading1=!0,Object(s["vb"])({fileId:this.infoId,instraction:this.instraction,subId:this.subId}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"转发成功",duration:1500,type:"success"}),t.back()):t.$notify({title:"提示",message:"转发失败",duration:1500,type:"warning"}),setTimeout(function(){t.isLoading1=!1},1)})},lastInfo:function(){this.getTrainInfo(this.preId)},nextInfo:function(){this.getTrainInfo(this.sufId)},showPeople:function(t){var e=this;this.peopleList.forEach(function(i,a){i.deptName===t.deptName&&(e.juList=i.listUser,t.confirm?e.isShow=!1:e.isHaveButton(t.deptId))})},isHaveButton:function(t){var e=this;Object(s["cb"])({deptId:t}).then(function(t){t.data.result?e.isShow=!0:e.isShow=!1})},updateStatus:function(t){var e=this;Object(s["Ib"])({type:"0",status:t.status,infoId:this.infoId,userId:t.id,isWork:"0"===t.isWork?"1":"0"}).then(function(t){"success"===t.data.result?e.$alert("状态修改成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}).catch(function(){"1"===e.adminFlag?e.getOnlyRoot():e.getDateForJu()}):"fail"===t.data.result?e.$confirm("当前修改用户无参训记录","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"confirm"===t.data.result?e.$confirm("管理员已确认，不能修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"no Perssion"===t.data.result&&e.$confirm("您没有权限修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){})})},downloadFile:function(t){this.onlineFileUrl="/app/openFile/demo.html?fileId="+t+"&access_token="+this.$store.state.user.token}}},r=l,c=(i("6198"),i("f86d"),i("2877")),d=Object(c["a"])(r,a,n,!1,null,"4bc45b2c",null);e["default"]=d.exports},6198:function(t,e,i){"use strict";var a=i("3eeb"),n=i.n(a);n.a},"66d5":function(t,e,i){},f71e:function(t,e,i){"use strict";i.d(e,"a",function(){return r});var a=i("2b0e"),n=i("b311"),s=i.n(n);function o(){a["default"].prototype.$message({message:"复制成功",type:"success",duration:1500})}function l(){a["default"].prototype.$message({message:"复制失败",type:"error"})}function r(t,e){var i=new s.a(e.target,{text:function(){return t}});i.on("success",function(){o(),i.destroy()}),i.on("error",function(){l(),i.destroy()}),i.onClick(e)}},f86d:function(t,e,i){"use strict";var a=i("66d5"),n=i.n(a);n.a}}]);