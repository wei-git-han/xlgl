(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d916fb8a"],{5522:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{staticStyle:{padding:"0 10px"},on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],attrs:{label:"训练详情",name:"first"}},[i("div",{staticStyle:{padding:"0 30px"}},[i("div",{staticClass:"header"},[i("div",{staticClass:"title"},[t._v(t._s(t.title))]),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("span",[t._v("时间：")]),t._v(" "),i("span",[t._v(t._s(t.exerciseTime))])]),t._v(" "),i("el-col",{attrs:{span:6}},[i("span",[t._v("类型：")]),t._v(" "),i("span",[t._v(t._s("0"==t.xltype?"强装兴装大讲堂":"日常军事训练"))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("主办单位：")]),t._v(" "),i("span",[t._v(t._s(t.fbDept))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"right"},attrs:{span:6}},[i("span",{directives:[{name:"show",rawName:"v-show",value:1===t.showEdit,expression:"showEdit=== 1"}],staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editorFn}},[t._v("编辑")]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager||"2"===t.isManager,expression:"isManager==='1'||isManager==='2'"}],staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),i("div",{staticStyle:{padding:"20px 40px"}},[i("el-row",[i("el-col",{attrs:{span:18}},[i("div",{directives:[{name:"show",rawName:"v-show",value:t.exerciseIssue,expression:"exerciseIssue"}]},[t._v("训练课目："+t._s(t.exerciseIssue))]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.joinPeople,expression:"joinPeople"}],staticClass:"ma-t_20"},[t._v("参训人员："+t._s(t.joinPeople))]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.bz,expression:"bz"}],staticStyle:{display:"flex","flex-direction":"row","align-items":"center","margin-top":"3px"}},[t._v("\n                    其他事项："),i("span",{domProps:{innerHTML:t._s(t.bz)}})]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.todeptName,expression:"todeptName"}]},[t._v("参加单位："+t._s(t.todeptName))]),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"0"===t.xltype,expression:"xltype==='0'"}],staticClass:"ma-t_20",attrs:{span:16}},[i("span",[t._v("会议链接:")]),t._v(" "),i("span",{staticStyle:{color:"#3377FF","margin-left":"10px",cursor:"pointer"},on:{click:t.createHuiYi}},[t._v(t._s(t.meetingLine))]),t._v(" "),i("span",{staticStyle:{color:"#3377FF",dispaly:"inline-block",border:"1px solid #7477FF",padding:"1px 8px","border-radius":"3px","margin-left":"10px",cursor:"pointer"},on:{click:function(e){t.handleClipboard(t.generateIconCode(t.meetingLine),e)}}},[t._v("复制链接")])])]),t._v(" "),i("el-col",{attrs:{span:6}},[t.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:t.picturePath}}):i("svg-icon",{staticClass:"icon imgStyle",attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.pictureList.length>0,expression:"pictureList.length>0"}],staticStyle:{width:"70%",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.pictureList,function(e,s){return i("div",{key:s,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.pictureName))])],1)})],2),t._v(" "),i("div",{staticStyle:{width:"70%",height:"160px",border:"1px solid #ccc","margin-top":"10px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("本单位补充说明")]),t._v(" "),i("textarea",{directives:[{name:"model",rawName:"v-model",value:t.instraction,expression:"instraction"}],staticStyle:{width:"100%",height:"110px",border:"none",resize:"none",padding:"15px"},domProps:{value:t.instraction},on:{input:function(e){e.target.composing||(t.instraction=e.target.value)}}})])],1)],1),t._v(" "),"0"===t.listType?i("div",{staticStyle:{"text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.forwardFn}},[t._v("转发")])],1):i("div",{staticStyle:{display:"flex","flex-direction":"row","margin-top":"30px"}},["0"===t.bmFlag?i("div",{staticClass:"flexRight"},[i("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"success"},on:{click:t.signUp}},[t._v("报名")]),t._v(" "),i("el-popover",{attrs:{placement:"top",width:"200"},model:{value:t.visible,callback:function(e){t.visible=e},expression:"visible"}},[i("textarea",{directives:[{name:"model",rawName:"v-model",value:t.params.reason,expression:"params.reason"}],staticStyle:{width:"100%",height:"100%",border:"none",resize:"none"},attrs:{placeholder:"*请输入延后原因"},domProps:{value:t.params.reason},on:{input:function(e){e.target.composing||t.$set(t.params,"reason",e.target.value)}}}),t._v(" "),i("div",{staticStyle:{"text-align":"right",margin:"0"}},[i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:t.confirmFn}},[t._v("确定")])],1),t._v(" "),i("el-button",{attrs:{slot:"reference"},slot:"reference"},[t._v("延后参训")])],1)],1):i("div",{staticClass:"flexRight"},[i("el-button",{attrs:{type:"success"}},[t._v(t._s("1"===t.bmFlag?"已报名":"延后参训"))])],1),t._v(" "),i("div",{staticClass:"flexRight"},[i("el-button",{attrs:{size:"mini"},on:{click:t.lastInfo}},[t._v("上一篇")]),t._v(" "),i("el-button",{attrs:{size:"mini"},on:{click:t.nextInfo}},[t._v("下一篇")])],1)])],1)])]),t._v(" "),i("el-tab-pane",{attrs:{label:"训练情况跟踪",name:"second"}},[i("div",{staticStyle:{"padding-left":"30px","font-size":"20px"}},[t._v("\n            装备发展部各单位报名情况\n          ")]),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],staticStyle:{"padding-left":"30px",height:"600px","overflow-y":"scroll","overflow-x":"hidden"}},t._l(t.tableData_list,function(e,s){return i("el-row",{key:s,staticStyle:{"margin-top":"20px"}},[i("el-row",[i("el-col",{attrs:{span:3}},[i("span",[t._v("已报名：")]),t._v(" "),i("span",{staticStyle:{color:"#00BFBF","font-size":"30px"}},[t._v(t._s(e.ybm))])]),t._v(" "),i("el-col",{attrs:{span:3}},[i("span",[t._v("未报名：")]),t._v(" "),i("span",{staticStyle:{color:"#F56C6C","font-size":"30px"}},[t._v(t._s(e.wbm))])]),t._v(" "),i("el-col",{attrs:{span:3}},[i("span",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"isShow"}],staticClass:"labelBtn color_active",staticStyle:{cursor:"pointer"},on:{click:t.confirmStatus}},[t._v("确认")])])],1),t._v(" "),i("el-row",{attrs:{gutter:30}},[i("el-col",{attrs:{span:15}},[i("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.dataList,border:"",stripe:"","header-cell-style":{background:"#F7F7F8"}}},[i("el-table-column",{attrs:{prop:"id",label:"信息系统综合员",align:"center",width:"180"}},[[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn","0"!=e.confirm?"color_active":"color_default"]},[t._v(t._s("0"==e.confirm?"未确认":"确认"))])]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("已参训"+t._s(e.cxNum)+"人")]),t._v(" "),i("div",{staticClass:"ta-c"},[t._v("需补课人数"+t._s(e.bkNum)+"人")])]],2),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"单位"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",{staticStyle:{cursor:"pointer"},on:{click:function(i){return t.showPeople(e.row)}}},[t._v(t._s(e.row.deptName))])]}}],null,!0)}),t._v(" "),i("el-table-column",{attrs:{prop:"yjs",align:"center",label:"已接收"}}),t._v(" "),i("el-table-column",{attrs:{prop:"wjs",align:"center",label:"未接收"}}),t._v(" "),i("el-table-column",{attrs:{prop:"sum",align:"center",label:"已报名"}}),t._v(" "),i("el-table-column",{attrs:{prop:"nsum",align:"center",label:"未报名"}}),t._v(" "),i("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("div",{staticClass:"ta-c"},[i("span",{class:["labelBtn",e.row.confirm?"color_active":"color_default"]},[t._v(t._s(e.row.confirm?"已确认":"未确认"))])])]}}],null,!0)})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-table",{staticStyle:{width:"100%",height:"500px","overflow-y":"scroll"},attrs:{data:t.juList}},[i("el-table-column",{attrs:{property:"truename",align:"center",label:"人员详情"}}),t._v(" "),i("el-table-column",{attrs:{label:"人员状态",align:"center",width:"80"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s("0"==e.row.isWork?"未参训":"1"==e.row.isWork?"已参训":"--"))])]}}],null,!0)}),t._v(" "),i("el-table-column",{attrs:{label:"状态备注",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s("0"==e.row.read?"未接收":"已接收"))])]}}],null,!0)}),t._v(" "),i("el-table-column",{attrs:{label:"操作",align:"center",width:"60"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{type:"text",size:"small"},on:{click:function(i){return t.updateStatus(e.row)}}},[t._v("修改")])]}}],null,!0)})],1)],1)],1)],1)}),1)])],1),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"10px"},attrs:{"icon-class":"goback"},on:{click:t.back}})],1)])])},a=[],n=(i("ac6a"),i("0fe1")),o=i("f71e"),l={components:{},props:{listType:{type:String,default:"0"},infoId:{type:String,default:""},subId:{type:String,default:""},fileId:{type:String,default:""},isManager:{type:String,default:""}},data:function(){return{activeName:"first",tableData_list:[],juList:[],peopleList:[],visible:!1,params:{reason:"",infoId:"",subId:"",baoming:""},title:"",fbDept:"",xltype:"",exerciseTime:"",picturePath:"",bz:"",exerciseIssue:"",joinPeople:"",meetingLine:"",todeptName:"",pictureList:[],instraction:"",bmFlag:"",isLoading:!1,bkNum:"",cxNum:"",wbm:"",ybm:"",confirm:"",showEdit:0,adminFlag:this.$store.state.user.userInfo.adminFlag,isShow:!1}},created:function(){this.getTrainInfo(),this.getIsHavePerssion()},methods:{getTrainInfo:function(){var t=this;Object(n["K"])({id:this.infoId}).then(function(e){var i=e.data.xlglXlzzInfo,s=i.title,a=i.fbDept,n=i.exerciseTime,o=i.xltype,l=i.picturePath,r=i.bz,c=i.exerciseIssue,d=i.joinPeople,p=i.meetingLine,u=i.todeptName,v=i.baoming;Object.assign(t,{title:s,fbDept:a,exerciseTime:n,xltype:o,picturePath:l,bz:r,exerciseIssue:c,joinPeople:d,meetingLine:p,todeptName:u,bmFlag:v})})},getIsHavePerssion:function(){var t=this;Object(n["u"])({id:this.infoId}).then(function(e){"success"===e.data.result&&(t.showEdit=1)})},getDateForJu:function(){var t=this;this.isLoading=!0,Object(n["q"])({id:this.infoId}).then(function(e){t.tableData_list.push({dataList:e.data.listTotal,cxNum:e.data.ycx,bkNum:e.data.bk,wbm:e.data.wbm,ybm:e.data.ybm,confirm:e.data.confirm}),t.peopleList=e.data.listAllUser,t.juList=e.data.listAllUser[0].listUser,setTimeout(function(){t.isLoading=!1},500)})},getDateForAll:function(){var t=this;this.isLoading=!0,Object(n["p"])({id:this.infoId}).then(function(e){"success"===e.data.result&&e.data.list&&e.data.list.length>0&&(e.data.list.forEach(function(e,i){t.tableData_list.push({dataList:e.listTotal,cxNum:e.ycx,bkNum:e.bk,wbm:e.wbm,ybm:e.ybm,confirm:e.confirm})}),t.peopleList=e.data.list[0].listAllUser,t.juList=e.data.list[0].listAllUser[0].listUser,setTimeout(function(){t.isLoading=!1},500))})},handleClick:function(t){"1"===t.index&&("1"===this.adminFlag?this.getDateForAll():this.getDateForJu())},back:function(){this.$emit("back",0,this.listType)},createHuiYi:function(){Object(n["d"])().then(function(t){})},handleClipboard:function(t,e){Object(o["a"])(t,e)},editorFn:function(){this.$emit("backAdd",1,this.infoId)},deleteFn:function(){"1"===this.adminFlag?this.deleteZhu():"2"===this.adminFlag&&this.deleteInfo()},deleteInfo:function(){var t=this;Object(n["e"])({id:this.infoId}).then(function(e){"success"===e.data.result?(t.$message({message:"删除成功",type:"success"}),t.back()):"false"===e.data.result?t.$confirm("已分发的训练不能删除","提示",{type:"warning",center:!0}):t.$message({message:"删除失败",type:"info"})})},deleteZhu:function(){var t=this;Object(n["f"])({id:this.infoId}).then(function(e){"success"===e.data.result?(t.$message({message:"删除成功",type:"success"}),t.back()):"false"===e.data.result?t.$confirm("已分发的训练不能删除","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):t.$message({message:"删除失败",type:"info"})})},baoMing:function(t){var e=this;this.params.infoId=this.infoId,this.params.subId=this.fileId,this.params.baoming=t,Object(n["a"])(this.params).then(function(i){"success"===i.data.result?(e.$message({message:"1"===t?"报名成功":"延迟参训成功",type:"success"}),e.back()):e.$message({message:"1"===t?"报名失败":"延迟参训失败",type:"info"})})},signUp:function(){this.baoMing("1")},confirmFn:function(){""===this.params.reason?this.$message({message:"请输入延后原因",type:"info"}):(this.baoMing("2"),this.visible=!1)},confirmStatus:function(){var t=this;Object(n["Ab"])({infoId:this.infoId}).then(function(e){"success"===e.data.result&&t.$alert("确认成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){t.getDateForJu(),t.isShow=!1}).catch(function(){})})},forwardFn:function(){var t=this;this.isLoading=!0,Object(n["nb"])({fileId:this.infoId,instraction:this.instraction,subId:this.subId}).then(function(e){"success"===e.data.result?(t.$message({message:"转发成功",type:"success"}),t.back()):t.$message({message:"转发失败",type:"info"}),setTimeout(function(){t.isLoading=!1},500)})},lastInfo:function(){},nextInfo:function(){},showPeople:function(t){var e=this;this.peopleList.forEach(function(i,s){i.deptName===t.deptName&&(e.juList=i.listUser)}),this.isHaveButton(t.deptId)},isHaveButton:function(t){var e=this;Object(n["W"])({deptId:t}).then(function(t){t.data.result?e.isShow=!0:e.isShow=!1})},updateStatus:function(t){var e=this;Object(n["xb"])({infoId:this.infoId,userId:t.id,isWork:"0"===t.isWork?"1":"0"}).then(function(t){"success"===t.data.result?e.$alert("状态修改成功","提示",{confirmButtonText:"确定",center:!0}).then(function(){e.getDateForJu()}).catch(function(){}):"fail"===t.data.result?e.$confirm("当前修改用户无参训记录","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){}):"confirm"===t.data.result&&e.$confirm("管理员已确认，不能修改","提示",{confirmButtonText:"确定",type:"warning",center:!0}).then(function(){}).catch(function(){})})}}},r=l,c=(i("70d3"),i("2877")),d=Object(c["a"])(r,s,a,!1,null,"79835a6f",null);e["default"]=d.exports},6724:function(t,e,i){"use strict";i("8d41");var s="@@wavesContext";function a(t,e){function i(i){var s=Object.assign({},e.value),a=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},s),n=a.ele;if(n){n.style.position="relative",n.style.overflow="hidden";var o=n.getBoundingClientRect(),l=n.querySelector(".waves-ripple");switch(l?l.className="waves-ripple":(l=document.createElement("span"),l.className="waves-ripple",l.style.height=l.style.width=Math.max(o.width,o.height)+"px",n.appendChild(l)),a.type){case"center":l.style.top=o.height/2-l.offsetHeight/2+"px",l.style.left=o.width/2-l.offsetWidth/2+"px";break;default:l.style.top=(i.pageY-o.top-l.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",l.style.left=(i.pageX-o.left-l.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return l.style.backgroundColor=a.color,l.className="waves-ripple z-active",!1}}return t[s]?t[s].removeHandle=i:t[s]={removeHandle:i},i}var n={bind:function(t,e){t.addEventListener("click",a(t,e),!1)},update:function(t,e){t.removeEventListener("click",t[s].removeHandle,!1),t.addEventListener("click",a(t,e),!1)},unbind:function(t){t.removeEventListener("click",t[s].removeHandle,!1),t[s]=null,delete t[s]}},o=function(t){t.directive("waves",n)};window.Vue&&(window.waves=n,Vue.use(o)),n.install=o;e["a"]=n},"70d3":function(t,e,i){"use strict";var s=i("fd8c"),a=i.n(s);a.a},"7b17":function(t,e,i){},"8d41":function(t,e,i){},e7a7:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",[0==t.isShow?i("el-row",{attrs:{gutter:20}},[i("el-col",{attrs:{span:19}},[i("el-card",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],staticStyle:{height:"calc(98vh - 105px)"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},["2"===t.isManager?i("el-tab-pane",{attrs:{label:"待转发",name:"0"}}):t._e(),t._v(" "),i("el-tab-pane",{attrs:{label:"我的训练",name:"1"}}),t._v(" "),"1"===t.isManager?i("el-tab-pane",{attrs:{label:"全部",name:"2"}}):t._e()],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:""!=t.urgencyInfo,expression:"urgencyInfo!=''"}],staticClass:"tips"},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"15px",height:"15px"},attrs:{"icon-class":"tishii"}}),t._v(" "),i("span",{staticStyle:{"margin-left":"5px"}},[t._v("通知公告：")]),t._v(" "),i("span",[t._v(t._s(t.urgencyInfo.length>15?t.urgencyInfo.substr(0,15)+"...":t.urgencyInfo))])],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager,expression:"isManager==='1'"}],staticStyle:{position:"absolute",right:"10px",top:"5px"}},[i("el-button",{staticClass:"addBtn noBorder",attrs:{type:"success",icon:"el-icon-plus",size:"mini"},on:{click:t.addPage}},[t._v("新增")])],1)],1),t._v(" "),i("div",[i("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:1==t.activeName,expression:"activeName==1"}],attrs:{size:"small"},model:{value:t.learnType,callback:function(e){t.learnType=e},expression:"learnType"}},[i("el-radio-button",{attrs:{label:"0"}},[t._v("未完结")]),t._v(" "),i("el-radio-button",{attrs:{label:"1"}},[t._v("历史学习")])],1),t._v(" "),i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},model:{value:t.listQuery.search,callback:function(e){t.$set(t.listQuery,"search",e)},expression:"listQuery.search"}}),t._v(" "),i("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择类型",size:"small",clearable:""},model:{value:t.listQuery.xltype,callback:function(e){t.$set(t.listQuery,"xltype",e)},expression:"listQuery.xltype"}},[i("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1),t._v(" "),i("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),i("div",{staticClass:"videoList"},t._l(t.videoList,function(e,s){return i("div",{key:s,staticClass:"video_card",staticStyle:{display:"inline-block"},on:{click:function(i){return t.toDetial(e)}}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"2"!=t.activeName,expression:"activeName!='2'"}],class:["learnLabel","0"==t.activeName?"bg_default":"bg_active"]},[t._v(t._s("0"==t.activeName?"待转发":t.jsStatus[e.read]))]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[e.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:e.picturePath}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"100%",height:"170px"},attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"2"!=t.activeName,expression:"activeName!='2'"}],staticClass:"status_start"},[t._v(t._s("0"==t.activeName?"未开始":t.bmStatus[e.baoming]))])],1),t._v(" "),i("div",[i("p",{staticClass:"cardTitle",attrs:{title:e.title}},[t._v(t._s(e.title))]),t._v(" "),i("p",{staticClass:"xltype"},[t._v(t._s("0"==e.xltype?"强装兴装大讲堂":"日常军事训练"))]),t._v(" "),i("div",{staticClass:"startDate"},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"13px",height:"13px"},attrs:{"icon-class":"shijian"}}),t._v(" "),i("span",{staticStyle:{color:"#99A6BF","margin-left":"10px"}},[t._v(t._s(e.exerciseTime))])],1)])])}),0),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getList}})],1)],1),t._v(" "),i("el-col",{attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("参训完成率")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人的参训完成率")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.wcl)+"%")])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("已完成")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人已完成训练")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.ywc))])]),t._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("需补考")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("个人错过训练需补考")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.bk))])])])],1)],1),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager,expression:"isManager==='1'"}],attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticStyle:{background:"#fff","border-radius":"5px",border:"1px solid rgb(203, 225, 250)"}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","padding-left":"20px"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"tongzhifabu"}}),t._v(" "),i("div",{staticStyle:{"margin-left":"10px"}},[i("p",[t._v("紧急通知公告")]),t._v(" "),i("p",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("编辑发布最新公告通知")])])],1),t._v(" "),i("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:t.addInfo}},[t._v("立即发布 ＞")])])])],1)],1),t._v(" "),i("el-dialog",{attrs:{title:"紧急通知公告",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e},close:t.resetTemp}},[i("el-form",{ref:"dataForm",staticStyle:{margin:"0px 50px"},attrs:{model:t.temp,"label-position":"right","label-width":"100px"}},[i("el-form-item",{attrs:{label:"单位：",prop:"reDeptName"}},[i("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:t.showUserTree,callback:function(e){t.showUserTree=e},expression:"showUserTree"}},[i("el-scrollbar",{staticStyle:{height:"400px"}},[i("el-tree",{ref:"userTree",attrs:{data:t.userTreeData,"show-checkbox":"",props:t.defaultProps,"node-key":"id","default-expanded-keys":["root"]}})],1),t._v(" "),i("el-input",{attrs:{slot:"reference",placeholder:"请选择公告通知范围",readonly:"readonly"},slot:"reference",model:{value:t.temp.reDeptName,callback:function(e){t.$set(t.temp,"reDeptName",e)},expression:"temp.reDeptName"}})],1)],1),t._v(" "),i("el-form-item",{attrs:{label:"内容："}},[i("el-input",{attrs:{type:"textarea"},model:{value:t.temp.content,callback:function(e){t.$set(t.temp,"content",e)},expression:"temp.content"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.updateData}},[t._v("确定")]),t._v(" "),i("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")])],1)],1)],1):t._e()],1),t._v(" "),1==t.isShow?i("organAdd",{attrs:{id:t.file_id,"list-type":t.activeName},on:{back:t.backList}}):t._e(),t._v(" "),2==t.isShow?i("organView",{attrs:{"is-manager":t.isManager,"list-type":t.activeName,"info-id":t.id,"sub-id":t.subId,"file-id":t.fileId},on:{back:t.backList,backAdd:t.toEditor}}):t._e()],1)},a=[],n=(i("ac6a"),i("0fe1")),o=i("6724"),l=i("333d"),r=i("dad1"),c=i("5522"),d={name:"ComplexTable",components:{Pagination:l["a"],organAdd:r["default"],organView:c["default"]},directives:{waves:o["a"]},data:function(){return{list:null,total:0,listQuery:{page:1,pagesize:10,search:"",xltype:""},learnType:"0",temp:{content:"",reDeptId:"",reDeptName:[]},dialogFormVisible:!1,activeName:"",videoList:[],isShow:0,userTreeData:[],showUserTree:!1,defaultProps:{children:"children",label:"text"},urgencyInfo:"",wcl:"",ywc:"",bk:"",id:"",subId:"",fileId:"",file_id:"",bmStatus:["未报名","已报名","延后参训"],jsStatus:["未接收","已接收"],isManager:"",isLoading:!1}},watch:{activeName:function(t){"0"===t?(this.listQuery.type="",this.getList()):"1"===t?(this.learnType="0",this.getPersonList("0")):"2"===t&&this.getAllList()},learnType:function(t){this.getPersonList(t)},showUserTree:function(t){t||this.getCheckMenu()}},created:function(){this.getAuthor(),this.getViewInfo(),this.getCxwcl()},methods:{getAuthor:function(){var t=this;Object(n["k"])().then(function(e){t.isManager=e.data,"2"===t.isManager?(t.activeName="0",t.getList()):(t.activeName="1",t.getPersonList("0"))})},getList:function(){var t=this;this.isLoading=!0,Object(n["U"])(this.listQuery).then(function(e){t.videoList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},500)})},getCxwcl:function(){var t=this;Object(n["o"])().then(function(e){t.wcl=e.data.wcl,t.ywc=e.data.ywc,t.bk=e.data.bk})},getPersonList:function(t){var e=this;this.isLoading=!0,this.listQuery.type=t,Object(n["V"])(this.listQuery).then(function(t){e.videoList=t.data.rows,e.total=t.data.total,e.listQuery.type="",setTimeout(function(){e.isLoading=!1},500)})},getAllList:function(){var t=this;this.isLoading=!0,Object(n["j"])(this.listQuery).then(function(e){t.videoList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},500)})},getViewInfo:function(){var t=this;Object(n["L"])().then(function(e){t.urgencyInfo=e.data.xlglUrgentNotice.content})},search:function(){"0"===this.activeName?this.getList():this.getPersonList(this.learnType)},getTree:function(){var t=this;Object(n["r"])().then(function(e){t.userTreeData=e.data.children})},addPage:function(){this.isShow=1,this.file_id=""},toDetial:function(t){console.log(t),console.log(t.infoId),this.isShow=2,this.id=t.infoId,this.subId=t.id,this.fileId=t.subId},backList:function(t,e){this.isShow=t,"0"===e?(this.listQuery.type="",this.getList()):"1"===e?(this.learnType="0",this.getPersonList("0")):this.getAllList()},toEditor:function(t,e){this.isShow=t,this.file_id=e},addInfo:function(){this.dialogFormVisible=!0,this.getTree()},resetTemp:function(){this.temp={}},getCheckMenu:function(){var t=this.$refs.userTree.getCheckedNodes(),e=[],i=[];t.forEach(function(t){i.push(t.id),e.push(t.text)}),this.temp.reDeptId=i.toString(),this.temp.reDeptName=e.toString()},updateData:function(){var t=this;this.temp.reDeptName.length<1?this.$message({message:"请选择公告通知范围",type:"info"}):""!==this.temp.content?Object(n["lb"])(this.temp).then(function(e){"success"===e.data.result?(t.$message({message:"发布成功",type:"success"}),t.dialogFormVisible=!1,t.getViewInfo()):(t.$message({message:"发布失败",type:"info"}),t.dialogFormVisible=!1)}):this.$message({message:"请输入公告内容",type:"info"})}}},p=d,u=(i("e806"),i("2877")),v=Object(u["a"])(p,s,a,!1,null,"17df76ae",null);e["default"]=v.exports},e806:function(t,e,i){"use strict";var s=i("7b17"),a=i.n(s);a.a},f71e:function(t,e,i){"use strict";i.d(e,"a",function(){return r});var s=i("2b0e"),a=i("b311"),n=i.n(a);function o(){s["default"].prototype.$message({message:"Copy successfully",type:"success",duration:1500})}function l(){s["default"].prototype.$message({message:"Copy failed",type:"error"})}function r(t,e){var i=new n.a(e.target,{text:function(){return t}});i.on("success",function(){o(),i.destroy()}),i.on("error",function(){l(),i.destroy()}),i.onClick(e)}},fd8c:function(t,e,i){}}]);