(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-41c167d1","chunk-23569891","chunk-3eb36221","chunk-66c71cb5"],{"1e59":function(t,e,i){"use strict";var s=i("f551"),n=i.n(s);n.a},"243c":function(t,e,i){"use strict";var s=i("25ad"),n=i.n(s);n.a},"25ad":function(t,e,i){},3733:function(t,e,i){},"6ec9":function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container1",staticStyle:{padding:"0 10px 20px"}},[i("div",{staticClass:"app-content"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[i("div",{staticClass:"addTitle"},[i("el-button",{staticStyle:{"margin-right":"30px"},attrs:{type:"primary"},on:{click:t.openDialog}},[t._v("已阅人员详单")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),i("div",{staticClass:"content"},[i("el-header",{staticClass:"title"},[t._v("\n            "+t._s(t.list.title)+"\n          ")]),t._v(" "),i("el-main",[i("div",{staticClass:"headDiv"},[1===t.list.isTop?i("span",{class:{istop:t.list.isTop}},[t._v(t._s(t._f("isTopFilter")(t.list.isTop)))]):t._e(),t._v(" "),i("span",{staticClass:"gapSty"},[t._v("发布时间："+t._s(t.list.releaseTime))]),t._v(" "),i("span",{staticClass:"gapSty"},[t._v("发布单位："+t._s(t.list.releaseOrgan))]),t._v(" "),i("span",[t._v("发布人："+t._s(t.list.creator))]),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btnSty colorSty1",on:{click:function(e){return t.deleteById(t.list.id)}}},[t._v("删除")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btnSty colorSty1",on:{click:function(e){return t.openDetail(t.list.id)}}},[t._v("编辑")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btnSty colorSty1",on:{click:function(e){return t.setNoticeTop(t.list.id,t.list.isTop)}}},[t._v(t._s(t._f("isTopFilter1")(t.list.isTop)))]):t._e(),t._v(" "),i("span",{staticClass:"btnSty"},[t._v("已阅人数："+t._s(t.list.userReadNumber)+"人")])]),t._v(" "),i("div",{staticStyle:{overflow:"auto"},domProps:{innerHTML:t._s(t.list.content)}}),t._v(" "),i("div",{staticClass:"fileList"},[i("ul",t._l(t.fileList,function(e){return i("li",{key:e.fileId},[t._v("\n                  "+t._s(e.pictureName)+"\n                  "),i("span",{staticClass:"colorSty1 gapSty",on:{click:function(i){return i.stopPropagation(),t.download(e.pictureId)}}},[t._v("下载")])])}),0)]),t._v(" "),i("div",{staticClass:"changePage"},[i("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.getInfoUpAndDown("pre")}}},[t._v("上一篇")]),t._v(" "),i("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.getInfoUpAndDown("next")}}},[t._v("下一篇")])],1)])],1)])],1),t._v(" "),i("el-dialog",{attrs:{title:"已阅人员详情名单",visible:t.dialogVisible,width:"40%","before-close":t.handleClose},on:{"update:visible":function(e){t.dialogVisible=e}}},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.tableList,border:"",fit:!0,stripe:!0,"highlight-current-row":""}},[i("el-table-column",{attrs:{label:"姓名",width:"150",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("div",{attrs:{title:e.row.readUserName}},[t._v(t._s(e.row.readUserName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"单位名称",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.readOrgName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"阅读时间",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.readDate))])]}}])})],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getExamineList}})],1)],1)])},n=[],a=i("13c4"),o=i("333d"),l={name:"UpdateNotice",components:{Pagination:o["a"]},filters:{isTopFilter:function(t){return 1===t?"置顶":""},isTopFilter1:function(t){return 1===t?"取消置顶":"置顶"}},props:{noticeId:{type:String,default:""}},data:function(){return{list:null,show:this.$store.state.user.userInfo.adminFlag,listQuery:{id:"",page:1,limit:20},tableKey:0,tableList:null,total:0,listLoading:!1,dialogVisible:!1,fileList:[]}},watch:{"listQuery.id":{handler:function(t,e){this.saveExamine(),this.getNoticeInfo(t),this.getFileList()},deep:!0}},created:function(){this.listQuery.id=this.noticeId},methods:{backFn:function(){this.$emit("openCreateNotice","1")},getNoticeInfo:function(t){var e=this,i={id:t};Object(a["f"])(i).then(function(t){e.list=t.data.xlglNotice})},setNoticeTop:function(t,e){var i=this,s="取消置顶",n=0;0===e&&(s="置顶",n=1);var o={id:t,istop:n};Object(a["j"])(o).then(function(e){0===e.data.code?i.$notify({title:"提示",message:s+"成功！",duration:1500,type:"success",onClose:function(){i.getNoticeInfo(t)}}):i.$notify({title:"提示",message:e.data.msg,duration:1500,type:"warning"})})},deleteById:function(t){var e=this,i={ids:t};this.$confirm("此条数据将进行永久删除操作, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(a["a"])(i).then(function(t){0===t.data.code?e.$notify({title:"提示",message:"删除成功！",duration:1500,type:"success",onClose:function(){e.$emit("openCreateNotice","1")}}):e.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}).catch(function(){e.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})})},openDetail:function(t){this.$emit("openCreateNotice","4",t)},getExamineList:function(){var t=this;this.listLoading=!0,Object(a["c"])(this.listQuery).then(function(e){t.tableList=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},saveExamine:function(){var t={id:this.listQuery.id};Object(a["h"])(t).then(function(t){})},getInfoUpAndDown:function(t){var e=this,i={id:this.listQuery.id};Object(a["e"])(i).then(function(i){"next"===t?i.data.downNotice?e.listQuery.id=i.data.downNotice.id:e.$notify({title:"提示",message:"已经是最后一篇",duration:1500,type:"warning"}):i.data.upNotice?e.listQuery.id=i.data.upNotice.id:e.$notify({title:"提示",message:"已经是第一篇",duration:1500,type:"warning"})})},openDialog:function(){this.dialogVisible=!0,this.getExamineList()},handleClose:function(){this.dialogVisible=!1},getFileList:function(){var t=this;Object(a["d"])({id:this.listQuery.id}).then(function(e){t.fileList=e.data.list})},download:function(t){window.location.href="xlgl/xlglnotice/downloadPicture?fileId="+t+"&access_token="+this.$store.state.user.token}}},c=l,r=(i("b3ce"),i("2877")),u=Object(r["a"])(c,s,n,!1,null,"9ee291ce",null);e["default"]=u.exports},aa6a:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container2"},[i("div",{staticClass:"app-content"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[i("div",{staticClass:"addTitle"},[i("span",[t._v("通知公告新增")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),i("div",{staticStyle:{padding:"20px 0"}},[i("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"信息类型",required:""}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},t._l(t.infoType,function(e){return i("el-option",{key:e.value,attrs:{label:e.name,value:e.name}},[t._v(t._s(e.name))])}),1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"发布单位",required:""}},[i("el-input",{attrs:{disabled:""},model:{value:t.form.releaseOrgan,callback:function(e){t.$set(t.form,"releaseOrgan",e)},expression:"form.releaseOrgan"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"信息标题",required:""}},[i("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"编辑内容"}},[i("ueditor",{ref:"content",model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:20}},[i("el-form-item",{attrs:{label:"上传附件"}},[i("div",{staticStyle:{border:"1px solid #ccc",padding:"20px","border-radius":"4px"}},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"",action:t.fileUrl,data:t.form,"on-success":t.successFile,"on-error":t.errorFile,"on-remove":t.removeFile,multiple:""}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])]),t._v(" "),i("div",{staticClass:"el-upload__tip",staticStyle:{color:"#BBBBBB"},attrs:{slot:"tip"},slot:"tip"},[t._v("上传word、excel、ofd等文件格式")])]),t._v(" "),i("div",{staticClass:"fileList"},[i("ul",t._l(t.fileLists,function(e){return i("li",{key:e.fileId},[t._v("\n                        "+t._s(e.pictureName)+"\n                        "),i("span",{staticClass:"colorSty1 gapSty",on:{click:function(i){return i.stopPropagation(),t.deleteFileById(e.pictureId)}}},[t._v("删除")]),t._v(" "),i("span",{staticClass:"colorSty1 gapSty",on:{click:function(i){return i.stopPropagation(),t.download(e.pictureId)}}},[t._v("下载")])])}),0)])],1)])],1)],1)],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[i("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},on:{click:t.backFn}},[t._v("取消")])],1)],1)],1)],1)])},n=[],a=i("aa2a"),o=i("13c4"),l=i("63f4"),c={name:"CreateNotice",components:{Ueditor:l["a"]},props:{noticeId:{type:String,default:""}},data:function(){return{infoType:[{name:"通知",value:"1"},{name:"公告",value:"0"}],fileUrl:"/app/xlgl/xlglnotice/uploadPicture",fileList:[],form:{type:"",title:"",content:"",releaseOrgan:"",access_token:this.$store.state.user.token},fileLists:[]}},created:function(){this.noticeId?this.getNoticeInfo():this.getDeptName()},methods:{getDeptName:function(){var t=this;Object(a["d"])().then(function(e){t.form.releaseOrgan=e.data.deptName})},backFn:function(){this.$emit("back","1")},successFile:function(t){t.fileid&&t.fileid.length>0?this.fileList.push(t.fileid):this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},errorFile:function(){this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},removeFile:function(t){var e=this.fileList.indexOf(t.response.fileid);-1!==e&&this.fileList.splice(e,1)},saveOrUpdateNotice:function(){var t=this;this.form.type||this.$notify({title:"提示",message:"请选择信息类型!",duration:1500,type:"warning"}),this.form.title||this.$notify({title:"提示",message:"请输入信息标题!",duration:1500,type:"warning"}),this.form.content=this.$refs.content.getContent(),this.form.type&&this.form.title&&(this.form.pIds=this.fileList.join(","),Object(o["i"])(this.form).then(function(e){t.$notify({title:"提示",message:"发布成功!",duration:1500,type:"success",onClose:function(){t.$parent.showPage="1"}})}))},getNoticeInfo:function(){var t=this,e={id:this.noticeId};Object(o["f"])(e).then(function(e){t.form.id=e.data.xlglNotice.id,t.form.type=e.data.xlglNotice.type,t.form.releaseOrgan=e.data.xlglNotice.releaseOrgan,t.form.title=e.data.xlglNotice.title,t.form.content=e.data.xlglNotice.content,t.$refs.content.setContent(t.form.content),t.$nextTick(function(){this.getFileList()})})},getFileList:function(){var t=this;Object(o["d"])({id:this.noticeId}).then(function(e){t.fileLists=e.data.list})},deleteFileById:function(t){var e=this,i={picId:t};Object(o["b"])(i).then(function(t){0===t.data.code?e.$notify({title:"提示",message:"删除成功!",duration:1500,type:"success",onClose:function(){e.getFileList()}}):e.$notify({title:"提示",message:"删除失败!",duration:1500,type:"warning"})})},download:function(t){window.location.href="xlgl/xlglnotice/downloadPicture?fileId="+t+"&access_token="+this.$store.state.user.token}}},r=c,u=(i("1e59"),i("2877")),d=Object(u["a"])(r,s,n,!1,null,"50b357bf",null);e["default"]=d.exports},b3ce:function(t,e,i){"use strict";var s=i("3733"),n=i.n(s);n.a},cd11:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",["1"===t.showPage?i("inform-list",{ref:"noticeList",on:{openCreateNotice:t.showorNot}}):t._e(),t._v(" "),"2"===t.showPage||"4"===t.showPage?i("create-notice",{attrs:{"notice-id":t.noticeId},on:{back:t.showorNot}}):t._e(),t._v(" "),"3"===t.showPage?i("update-notice",{attrs:{"notice-id":t.noticeId},on:{openCreateNotice:t.showorNot}}):t._e()],1)},n=[],a=i("e2f5"),o=i("aa6a"),l=i("6ec9"),c={name:"NoticeIndex",components:{informList:a["default"],createNotice:o["default"],updateNotice:l["default"]},data:function(){return{showPage:"1",noticeId:""}},created:function(){this.$route.query.id&&(this.showPage="3",this.noticeId=this.$route.query.id)},methods:{showorNot:function(t,e){this.noticeId=e,this.showPage=t}}},r=c,u=i("2877"),d=Object(u["a"])(r,s,n,!1,null,"1e12b672",null);e["default"]=d.exports},e2f5:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("el-button",{staticClass:"createBtn noBorder",attrs:{size:"mini",type:"primary",icon:"el-icon-plus"},on:{click:t.openCreateNotice}},[t._v("新增")]):t._e(),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColSty",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-row",{attrs:{gutter:20}},t._l(t.list,function(e,s){return i("el-col",{key:s,attrs:{span:6}},[i("el-card",{staticClass:"margin-card",staticStyle:{"max-height":"330px",height:"330px"},attrs:{"body-style":{padding:"0px"}}},[i("el-button",{staticClass:"inform",class:{notice:"公告"===e.type},attrs:{type:"success",size:"mini"}},[t._v(t._s(e.type))]),t._v(" "),i("div",{staticClass:"cardContent gapSty"},[i("div",{staticClass:"title",on:{click:function(i){return i.stopPropagation(),t.openDetail(e.id)}}},[i("span",{attrs:{title:e.title}},[t._v(t._s(e.title.length>10?e.title.substr(0,10)+"...":e.title))]),t._v(" "),1===e.isTop?i("span",{class:{istop:e.isTop}},[t._v(t._s(t._f("isTopFilter")(e.isTop)))]):t._e()]),t._v(" "),i("div",{staticClass:"gapSty color2"},[i("svg-icon",{staticClass:"icon",attrs:{"icon-class":"time"}}),t._v(" "),i("span",{staticClass:"gapLeft"},[t._v(" "+t._s(e.releaseTime))])],1),t._v(" "),i("div",{staticClass:"gapSty gapSty1",staticStyle:{height:"50px",margin:"0",padding:"0",overflow:"hidden"},domProps:{innerHTML:t._s(e.content)}}),t._v(" "),i("div",{staticClass:"gapSty height1 color2"},[i("svg-icon",{staticClass:"icon",attrs:{"icon-class":"noticepeople"}}),t._v("\n                    发布人：\n                    "),i("span",{staticClass:"gapLeft"},[t._v(t._s(e.creator))])],1),t._v(" "),i("div",{staticClass:"gapSty height1 color2"},[i("svg-icon",{staticClass:"icon",attrs:{"icon-class":"noticepeople"}}),t._v(" "),i("span",{staticClass:"gapLeft"},[t._v(t._s(e.releaseOrgan))])],1),t._v(" "),i("div",{staticClass:"gapSty height1"},[i("span",{staticClass:"color1"},[t._v("浏览 "+t._s(e.viewNumber))]),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btSty",on:{click:function(i){return t.deleteById(e.id)}}},[t._v("删除")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btSty",on:{click:function(i){return i.stopPropagation(),t.upDateDetail(e.id)}}},[t._v("编辑")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btSty",on:{click:function(i){return t.setNoticeTop(e.id,e.isTop)}}},[t._v(t._s(t._f("isTopFilter1")(1===e.isTop?0:1)))]):t._e()])])],1)],1)}),1)],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getNoticeList}})],1)])},n=[],a=i("35b7"),o=i("333d"),l=i("13c4"),c={name:"InformNoticeList",filters:{isTopFilter:function(t){return 1===t?"置顶":""},isTopFilter1:function(t){return 1===t?"置顶":"取消置顶"},limitText:function(t){return t.length>40?t.substring(0,40)+"...":t}},components:{TitleCard:a["a"],Pagination:o["a"]},data:function(){return{cardTitle:"通知公告",show:this.$store.state.user.userInfo.adminFlag,tableKey:0,list:null,total:0,listLoading:!0,listQuery:{page:1,limit:20,type:""}}},created:function(){this.getNoticeList()},methods:{getNoticeList:function(){var t=this;this.listLoading=!0,Object(l["g"])(this.listQuery).then(function(e){t.list=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},openCreateNotice:function(){this.$emit("openCreateNotice","2")},openDetail:function(t){this.$emit("openCreateNotice","3",t)},upDateDetail:function(t){this.$emit("openCreateNotice","4",t)},deleteById:function(t){var e=this,i={ids:t};this.$confirm("此条数据将进行永久删除操作, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l["a"])(i).then(function(t){0===t.data.code?e.$notify({title:"提示",message:"删除成功",duration:1500,type:"success",onClose:function(){e.getNoticeList()}}):e.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}).catch(function(){e.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})})},setNoticeTop:function(t,e){var i=this,s="取消置顶",n=0;0===e&&(s="置顶",n=1);var a={id:t,istop:n};Object(l["j"])(a).then(function(t){0===t.data.code?i.$notify({title:"提示",message:s+"成功！",duration:1500,type:"success",onClose:function(){i.getNoticeList()}}):i.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}}},r=c,u=(i("243c"),i("2877")),d=Object(u["a"])(r,s,n,!1,null,"f1fb4f98",null);e["default"]=d.exports},f551:function(t,e,i){}}]);