(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ec333076"],{"43f6":function(e,t,i){"use strict";var s=i("bdec"),a=i.n(s);a.a},6314:function(e,t,i){},6724:function(e,t,i){"use strict";i("8d41");var s="@@wavesContext";function a(e,t){function i(i){var s=Object.assign({},t.value),a=Object.assign({ele:e,type:"hit",color:"rgba(0, 0, 0, 0.15)"},s),l=a.ele;if(l){l.style.position="relative",l.style.overflow="hidden";var o=l.getBoundingClientRect(),n=l.querySelector(".waves-ripple");switch(n?n.className="waves-ripple":(n=document.createElement("span"),n.className="waves-ripple",n.style.height=n.style.width=Math.max(o.width,o.height)+"px",l.appendChild(n)),a.type){case"center":n.style.top=o.height/2-n.offsetHeight/2+"px",n.style.left=o.width/2-n.offsetWidth/2+"px";break;default:n.style.top=(i.pageY-o.top-n.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",n.style.left=(i.pageX-o.left-n.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return n.style.backgroundColor=a.color,n.className="waves-ripple z-active",!1}}return e[s]?e[s].removeHandle=i:e[s]={removeHandle:i},i}var l={bind:function(e,t){e.addEventListener("click",a(e,t),!1)},update:function(e,t){e.removeEventListener("click",e[s].removeHandle,!1),e.addEventListener("click",a(e,t),!1)},unbind:function(e){e.removeEventListener("click",e[s].removeHandle,!1),e[s]=null,delete e[s]}},o=function(e){e.directive("waves",l)};window.Vue&&(window.waves=l,Vue.use(o)),l.install=o;t["a"]=l},"8d41":function(e,t,i){},b7c4:function(e,t,i){"use strict";var s=i("6314"),a=i.n(s);a.a},bdec:function(e,t,i){},dad1:function(e,t,i){"use strict";i.r(t);var s=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("title-card",{attrs:{"title-text":"新增训练"}}),e._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:e.back}}),e._v(" "),i("div",{staticStyle:{padding:"20px"}},[i("el-col",{attrs:{span:16}},[i("el-form",{ref:"form",attrs:{model:e.form,"label-width":"150px"}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"讲堂标题",required:""}},[i("el-input",{model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"训练类型",required:""}},[i("el-select",{attrs:{placeholder:"请选择"},on:{change:e.changeType},model:{value:e.form.xltype,callback:function(t){e.$set(e.form,"xltype",t)},expression:"form.xltype"}},[i("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),e._v(" "),i("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1)],1)],1),e._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"训练时间",required:""}},[i("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},on:{change:e.getsTime},model:{value:e.form.exerciseTime,callback:function(t){e.$set(e.form,"exerciseTime",t)},expression:"form.exerciseTime"}})],1)],1),e._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"0"==this.form.xltype,expression:"this.form.xltype=='0'"}],attrs:{span:10}},[i("el-form-item",{attrs:{label:"会议链接",required:""}},[i("el-input",{model:{value:e.form.meetingLine,callback:function(t){e.$set(e.form,"meetingLine",t)},expression:"form.meetingLine"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"训练科目"}},[i("el-input",{attrs:{type:"textarea"},model:{value:e.form.exerciseIssue,callback:function(t){e.$set(e.form,"exerciseIssue",t)},expression:"form.exerciseIssue"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"参训人员"}},[i("el-input",{attrs:{type:"textarea"},model:{value:e.form.joinPeople,callback:function(t){e.$set(e.form,"joinPeople",t)},expression:"form.joinPeople"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"其他事项"}},[i("ueditor",{ref:"content",model:{value:e.form.bz,callback:function(t){e.$set(e.form,"bz",t)},expression:"form.bz"}})],1)],1)],1)],1),e._v(" "),i("el-col",{attrs:{span:4}},[i("div",[i("label",{staticStyle:{"font-size":"18px"}},[e._v("上传视频")]),e._v(" "),i("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":e.uploadVideo,accept:".mp4",multiple:""}},[i("i",{staticClass:"el-icon-upload"}),e._v(" "),i("div",{staticClass:"el-upload__text"},[e._v("\n              将视频文件拖到此处，或"),i("em",[e._v("点击上传")]),e._v(" "),i("p",{staticStyle:{"font-size":"12px"}},[e._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),e._v(" "),i("div",{staticStyle:{"margin-top":"20px"}},[i("label",{staticStyle:{"font-size":"18px"}},[e._v("上传封面")]),e._v(" "),i("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":e.uploadImg,limit:1,accept:".png,.jpeg",multiple:""}},[i("i",{staticClass:"el-icon-upload"}),e._v(" "),i("div",{staticClass:"el-upload__text"},[e._v("\n              将图片文件拖到此处，或"),i("em",[e._v("点击上传")]),e._v(" "),i("p",{staticStyle:{"font-size":"12px"}},[e._v("上传授课的视频文件或者授课图片方便学习.mp4/.png/.jpeg等格式")])])])],1),e._v(" "),i("div",{staticStyle:{"margin-top":"20px"}},[i("label",{staticStyle:{"font-size":"18px"}},[e._v("上传附件")]),e._v(" "),i("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":e.uploadFile,accept:".word,.excel,.ofd",multiple:""}},[i("i",{staticClass:"el-icon-upload"}),e._v(" "),i("div",{staticClass:"el-upload__text"},[e._v("\n              将文件拖到此处，或"),i("em",[e._v("点击上传")]),e._v(" "),i("p",{staticStyle:{"font-size":"12px"}},[e._v("注：只能上传word/ppt/excel文件格式，且不超过500kb")])])])],1)])],1),e._v(" "),i("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveFn}},[e._v("确认并分发")]),e._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},on:{click:e.cancel}},[e._v("取消")])],1),e._v(" "),i("el-dialog",{attrs:{title:"请选择下发局级单位",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t},close:function(t){e.dialogFormVisible=!1}}},[i("el-tree",{ref:"dataTree",attrs:{"show-checkbox":"",data:e.treeData,"node-key":"id",props:e.defaultProps}}),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.confirm}},[e._v("确定")]),e._v(" "),i("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1)])},a=[],l=(i("7f7f"),i("0fe1")),o=i("35b7"),n=i("63f4"),r={components:{TitleCard:o["a"],Ueditor:n["a"]},props:{listType:{type:String,default:"0"},file_id:{type:String,default:""}},data:function(){return{form:{title:"",xltype:"",exerciseTime:"",meetingLine:"",exerciseIssue:"",joinPeople:"",bz:"",picturePath:""},deptData:{fileId:"",idAndNames:"",deptIds:"",deptNames:""},dialogFormVisible:!1,defaultProps:{children:"children",label:"text"},treeData:[],nodeId:[],nodeName:[],fileId:[],fileName:[],fileType:[]}},created:function(){this.file_id&&this.getTrainInfo()},methods:{getsTime:function(e){this.form.createDate=e},getTrainInfo:function(){var e=this;Object(l["F"])({id:this.file_id}).then(function(t){var i=t.data.xlglXlzzInfo,s=i.title,a=i.xltype,l=i.exerciseTime,o=i.exerciseIssue,n=i.joinPeople,r=i.bz,c=i.meetingLine;Object.assign(e.form,{title:s,xltype:a,exerciseTime:l,exerciseIssue:o,joinPeople:n,bz:r,meetingLine:c}),e.$refs.content.setContent(e.form.bz)})},saveFn:function(){var e=this;this.form.title?this.form.xltype?this.form.exerciseTime?"0"!==this.form.xltype||this.form.meetingLine?(this.form.pIds=this.fileId.join(","),this.form.pidNames=this.fileName.join(","),this.form.type=this.fileType.join(","),Object(l["eb"])(this.form).then(function(t){"success"===t.data.result?(e.$message({message:"新增成功",type:"success"}),e.fileId=t.data.fileId,e.dialogFormVisible=!0,Object(l["n"])().then(function(t){e.treeData=t.data.children})):e.$message({message:"新增失败",type:"info"})})):this.$message({message:"请填写会议链接",type:"info"}):this.$message({message:"请选择训练时间",type:"info"}):this.$message({message:"请选择训练类型",type:"info"}):this.$message({message:"请填写讲堂标题",type:"info"})},cancel:function(){var e=this;this.$confirm("确定要取消发送此通知吗，您填写的内容将被清空","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",center:!0}).then(function(){e.form={}}).catch(function(){})},uploadVideo:function(e,t){this.fileId.push(e.fileId),this.fileName.push(t.raw.name),this.fileType.push(t.raw.type)},uploadImg:function(e,t){this.fileId.push(e.fileId),this.fileName.push(t.raw.name),this.fileType.push(t.raw.type),this.form.picturePath="/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.fileId},uploadFile:function(e,t){this.fileId.push(e.fileId),this.fileName.push(t.raw.name),this.fileType.push(t.raw.type?t.raw.type:"docx")},confirm:function(){var e=this;this.deptData.idAndNames="";for(var t=this.$refs.dataTree.getCheckedNodes(),i=0;i<t.length;i++)this.nodeId.push(t[i].id),this.nodeName.push(t[i].text),this.deptData.idAndNames+="".concat(t[i].id,",")+"".concat(t[i].text,";");this.deptData.fileId=this.fileId,this.deptData.deptIds=this.nodeId.join(","),this.deptData.deptNames=this.nodeName.join(","),Object(l["gb"])(this.deptData).then(function(t){"success"===t.data.result?(e.$message({message:"分发成功",type:"success"}),e.dialogFormVisible=!1,e.back()):(e.$message({message:"分发失败",type:"info"}),e.dialogFormVisible=!1)})},deleteFn:function(e){},back:function(){this.$emit("back",0,this.listType)}}},c=r,d=(i("43f6"),i("2877")),p=Object(d["a"])(c,s,a,!1,null,"6d82c379",null);t["default"]=p.exports},e7a7:function(e,t,i){"use strict";i.r(t);var s=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},[0==e.isShow?i("el-row",{attrs:{gutter:10}},[i("el-col",{attrs:{span:19}},[i("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.isLoading,expression:"isLoading"}],staticClass:"margin-card",staticStyle:{height:"calc(98vh - 105px)"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticStyle:{position:"relative"}},[i("el-tabs",{model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},["2"===e.isManager?i("el-tab-pane",{attrs:{label:"待转发",name:"0"}}):e._e(),e._v(" "),i("el-tab-pane",{attrs:{label:"我的训练",name:"1"}})],1),e._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:""!=e.urgencyInfo,expression:"urgencyInfo!=''"}],staticClass:"tips"},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"15px",height:"15px"},attrs:{"icon-class":"tishii"}}),e._v(" "),i("span",{staticStyle:{"margin-left":"5px"}},[e._v("通知公告：")]),e._v(" "),i("span",[e._v(e._s(e.urgencyInfo.length>15?e.urgencyInfo.substr(0,15)+"...":e.urgencyInfo))])],1),e._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:"1"===e.isManager,expression:"isManager==='1'"}],staticStyle:{position:"absolute",right:"10px",top:"4px"}},[i("el-button",{staticClass:"addBtn noBorder",attrs:{type:"success",icon:"el-icon-plus",size:"small"},on:{click:e.addPage}},[e._v("新增")])],1)],1),e._v(" "),i("div",[i("el-radio-group",{directives:[{name:"show",rawName:"v-show",value:1==e.activeName,expression:"activeName==1"}],model:{value:e.learnType,callback:function(t){e.learnType=t},expression:"learnType"}},[i("el-radio-button",{attrs:{label:"0"}},[e._v("未完结")]),e._v(" "),i("el-radio-button",{attrs:{label:"1"}},[e._v("历史学习")])],1),e._v(" "),i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},model:{value:e.listQuery.search,callback:function(t){e.$set(e.listQuery,"search",t)},expression:"listQuery.search"}}),e._v(" "),i("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择类型",size:"small",clearable:""},model:{value:e.listQuery.xltype,callback:function(t){e.$set(e.listQuery,"xltype",t)},expression:"listQuery.xltype"}},[i("el-option",{attrs:{label:"强装兴装大讲堂",value:"0"}}),e._v(" "),i("el-option",{attrs:{label:"日常军事训练",value:"1"}})],1),e._v(" "),i("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:e.search}},[e._v("查询")])],1),e._v(" "),i("div",{staticClass:"videoList"},e._l(e.videoList,function(t,s){return i("div",{key:s,class:["video_card",0!=s?"ma-l_20":""],on:{click:function(i){return e.toDetial(t)}}},[i("span",{class:["learnLabel","0"==e.activeName?"bg_default":"bg_active"]},[e._v(e._s("0"==e.activeName?"待转发":e.jsStatus[t.read]))]),e._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[t.picturePath?i("img",{staticClass:"imgStyle",attrs:{src:t.picturePath}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"100%",height:"170px"},attrs:{"icon-class":"zanwushuju"}}),e._v(" "),i("span",{staticClass:"status_start"},[e._v(e._s("0"==e.activeName?"未开始":e.bmStatus[t.baoming]))])],1),e._v(" "),i("div",{staticStyle:{padding:"0 10px 10px 10px"}},[i("p",{staticClass:"cardTitle"},[e._v(e._s(t.title))]),e._v(" "),i("p",{staticClass:"xltype"},[e._v(e._s("0"==t.xltype?"强装兴装大讲堂":"日常军事训练"))]),e._v(" "),i("div",{staticClass:"flex-center ma-t_10"},[i("div",{staticClass:"flex-center"},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"13px",height:"13px"},attrs:{"icon-class":"shijian"}}),e._v(" "),i("span",{staticStyle:{color:"#99A6BF","margin-left":"10px"}},[e._v(e._s(t.exerciseTime))])],1),e._v(" "),i("div",{staticStyle:{"font-size":"13px",color:"#3377FF"}},[e._v("[详情]")])])])])}),0),e._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.listQuery.page,limit:e.listQuery.pagesize},on:{"update:page":function(t){return e.$set(e.listQuery,"page",t)},"update:limit":function(t){return e.$set(e.listQuery,"pagesize",t)},pagination:e.getList}})],1)],1),e._v(" "),i("el-col",{attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),e._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[e._v("参训完成率")]),i("br"),e._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[e._v("个人的参训完成率")])])],1),e._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[e._v(e._s(e.wcl)+"%")])]),e._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),e._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[e._v("已完成")]),i("br"),e._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[e._v("个人已完成训练")])])],1),e._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[e._v(e._s(e.ywc))])]),e._v(" "),i("div",{staticClass:"statistics"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),e._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[e._v("需补考")]),i("br"),e._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[e._v("个人错过训练需补考")])])],1),e._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"40px","font-family":"DINCondensed-Bold"}},[e._v(e._s(e.bk))])])])],1)],1),e._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"===e.isManager,expression:"isManager==='1'"}],attrs:{span:5}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticStyle:{background:"#fff","border-radius":"5px",border:"1px solid rgb(203, 225, 250)"}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center","padding-left":"20px"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"tongzhifabu"}}),e._v(" "),i("div",{staticStyle:{"margin-left":"10px"}},[i("p",[e._v("紧急通知公告")]),e._v(" "),i("p",{staticStyle:{color:"#999999","font-size":"14px"}},[e._v("编辑发布最新公告通知")])])],1),e._v(" "),i("div",{staticClass:"addInfo",staticStyle:{cursor:"pointer"},on:{click:e.addInfo}},[e._v("立即发布 ＞")])])])],1)],1),e._v(" "),i("el-dialog",{attrs:{title:"紧急通知公告",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t},close:e.resetTemp}},[i("el-form",{ref:"dataForm",staticStyle:{margin:"0px 50px"},attrs:{model:e.temp,"label-position":"right","label-width":"100px"}},[i("el-form-item",{attrs:{label:"单位：",prop:"reDeptName"}},[i("el-popover",{attrs:{placement:"bottom-start",width:"400",trigger:"click"},model:{value:e.showUserTree,callback:function(t){e.showUserTree=t},expression:"showUserTree"}},[i("el-scrollbar",{staticStyle:{height:"400px"}},[i("el-tree",{ref:"userTree",attrs:{data:e.userTreeData,"show-checkbox":"",props:e.defaultProps,"node-key":"id","default-expanded-keys":["root"]}})],1),e._v(" "),i("el-input",{attrs:{slot:"reference",placeholder:"请选择公告通知范围",readonly:"readonly"},slot:"reference",model:{value:e.temp.reDeptName,callback:function(t){e.$set(e.temp,"reDeptName",t)},expression:"temp.reDeptName"}})],1)],1),e._v(" "),i("el-form-item",{attrs:{label:"内容："}},[i("el-input",{attrs:{type:"textarea"},model:{value:e.temp.content,callback:function(t){e.$set(e.temp,"content",t)},expression:"temp.content"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("确定")]),e._v(" "),i("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1):e._e(),e._v(" "),1==e.isShow?i("organAdd",{attrs:{listType:e.activeName,file_id:e.file_id},on:{back:e.backList}}):e._e(),e._v(" "),2==e.isShow?i("organView",{attrs:{listType:e.activeName,infoId:e.id,subId:e.subId,fileId:e.fileId,isManager:e.isManager},on:{back:e.backList,backAdd:e.toEditor}}):e._e()],1)},a=[],l=(i("ac6a"),i("0fe1")),o=i("6724"),n=i("333d"),r=i("dad1"),c=i("5522"),d={name:"ComplexTable",components:{Pagination:n["a"],organAdd:r["default"],organView:c["default"]},directives:{waves:o["a"]},data:function(){return{list:null,total:0,listLoading:!0,listQuery:{page:1,pagesize:10,search:"",xltype:""},learnType:"0",temp:{content:"",reDeptId:"",reDeptName:[]},dialogFormVisible:!1,activeName:"",videoList:[],isShow:0,userTreeData:[],showUserTree:!1,defaultProps:{children:"children",label:"text"},urgencyInfo:"",wcl:"",ywc:"",bk:"",id:"",subId:"",fileId:"",file_id:"",bmStatus:["未报名","已报名","延后参训"],jsStatus:["未接收","已接收"],isManager:"",isLoading:!1}},created:function(){this.getAuthor(),this.getViewInfo(),this.getCxwcl()},watch:{activeName:function(e){"0"===e?(this.listQuery.type="",this.getList()):(this.learnType="0",this.getPersonList("0"))},learnType:function(e){this.getPersonList(e)},showUserTree:function(e){e||this.getCheckMenu()}},methods:{getAuthor:function(){var e=this;Object(l["h"])().then(function(t){e.isManager=t.data,"2"===e.isManager?(e.activeName="0",e.getList()):(e.activeName="1",e.getPersonList("0"))})},getList:function(){var e=this;this.isLoading=!0,Object(l["P"])(this.listQuery).then(function(t){e.videoList=t.data.rows,e.total=t.data.total,setTimeout(function(){e.isLoading=!1},500)})},getCxwcl:function(){var e=this;Object(l["l"])().then(function(t){e.wcl=t.data.wcl,e.ywc=t.data.ywc,e.bk=t.data.bk})},getPersonList:function(e){var t=this;this.isLoading=!0,this.listQuery.type=e,Object(l["Q"])(this.listQuery).then(function(e){t.videoList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},500)})},getViewInfo:function(){var e=this;Object(l["G"])().then(function(t){e.urgencyInfo=t.data.xlglUrgentNotice.content})},search:function(){"0"===this.activeName?this.getList():this.getPersonList(this.learnType)},getTree:function(){var e=this;Object(l["n"])().then(function(t){e.userTreeData=t.data.children})},addPage:function(){this.isShow=1},toDetial:function(e){this.isShow=2,this.id=e.infoId,this.subId=e.id,this.fileId=e.subId},backList:function(e,t){this.isShow=e,"0"===t?(this.listQuery.type="",this.getList()):(this.learnType="0",this.getPersonList("0"))},toEditor:function(e,t){this.isShow=e,this.file_id=t},addInfo:function(){this.dialogFormVisible=!0,this.getTree()},resetTemp:function(){this.temp={}},getCheckMenu:function(){var e=this.$refs.userTree.getCheckedNodes(),t=[],i=[];e.forEach(function(e){i.push(e.id),t.push(e.text)}),this.temp.reDeptId=i.toString(),this.temp.reDeptName=t.toString()},updateData:function(){var e=this;this.temp.reDeptName.length<1?this.$message({message:"请选择公告通知范围",type:"info"}):""!==this.temp.content?Object(l["fb"])(this.temp).then(function(t){"success"===t.data.result?(e.$message({message:"发布成功",type:"success"}),e.dialogFormVisible=!1,e.getViewInfo()):(e.$message({message:"发布失败",type:"info"}),e.dialogFormVisible=!1)}):this.$message({message:"请输入公告内容",type:"info"})}}},p=d,u=(i("b7c4"),i("2877")),f=Object(u["a"])(p,s,a,!1,null,null,null);t["default"]=f.exports}}]);