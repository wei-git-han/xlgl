(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-386873ac"],{"034e":function(t,e,i){"use strict";var s=i("9fd3"),n=i.n(s);n.a},"6ec9":function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[i("div",{staticClass:"addTitle"},[i("el-button",{staticStyle:{"margin-right":"30px"},attrs:{type:"primary"},on:{click:t.openDialog}},[t._v("已阅人员详单")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),i("div",{staticClass:"content"},[i("el-header",{staticClass:"title"},[t._v("\n            "+t._s(t.list.title)+"\n          ")]),t._v(" "),i("el-main",[i("div",{staticClass:"headDiv"},[1===t.list.isTop?i("span",{class:{istop:t.list.isTop}},[t._v(t._s(t._f("isTopFilter")(t.list.isTop)))]):t._e(),t._v(" "),i("span",{staticClass:"gapSty"},[t._v("发布时间："+t._s(t.list.releaseTime))]),t._v(" "),i("span",{staticClass:"gapSty"},[t._v("发布单位："+t._s(t.list.releaseOrgan))]),t._v(" "),i("span",[t._v("发布人："+t._s(t.list.creator))]),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btnSty colorSty1",on:{click:function(e){return t.deleteById(t.list.id)}}},[t._v("删除")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btnSty colorSty1",on:{click:function(e){return t.openDetail(t.list.id)}}},[t._v("编辑")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?i("span",{staticClass:"btnSty colorSty1",on:{click:function(e){return t.setNoticeTop(t.list.id,t.list.isTop)}}},[t._v(t._s(t._f("isTopFilter1")(t.list.isTop)))]):t._e(),t._v(" "),i("span",{staticClass:"btnSty"},[t._v("已阅人数："+t._s(t.list.viewNumber)+"人")])]),t._v(" "),i("div",{domProps:{innerHTML:t._s(t.list.content)}}),t._v(" "),i("div",{staticClass:"fileList"},[i("ul",t._l(t.fileList,function(e){return i("li",{key:e.fileId},[t._v("\n                  "+t._s(e.pictureName)+"\n                  "),i("span",{staticClass:"colorSty1 gapSty",on:{click:function(i){return i.stopPropagation(),t.download(e.pictureId)}}},[t._v("下载")])])}),0)]),t._v(" "),i("div",{staticClass:"changePage"},[i("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.getInfoUpAndDown("pre")}}},[t._v("上一篇")]),t._v(" "),i("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.getInfoUpAndDown("next")}}},[t._v("下一篇")])],1)])],1)])],1),t._v(" "),i("el-dialog",{attrs:{title:"已阅人员详情名单",visible:t.dialogVisible,width:"40%","before-close":t.handleClose},on:{"update:visible":function(e){t.dialogVisible=e}}},[i("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.tableList,border:"",fit:!0,stripe:!0,"highlight-current-row":""}},[i("el-table-column",{attrs:{label:"姓名",width:"150",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("div",{attrs:{title:e.row.readUserName}},[t._v(t._s(e.row.readUserName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"单位名称",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.readOrgName))])]}}])}),t._v(" "),i("el-table-column",{attrs:{label:"阅读时间",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("span",[t._v(t._s(e.row.readDate))])]}}])})],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getExamineList}})],1)],1)])},n=[],a=i("13c4"),o=i("333d"),l={name:"UpdateNotice",components:{Pagination:o["a"]},filters:{isTopFilter:function(t){return 1===t?"置顶":""},isTopFilter1:function(t){return 1===t?"取消置顶":"置顶"}},props:{noticeId:{type:String,default:""}},data:function(){return{list:null,show:this.$store.state.user.userInfo.adminFlag,listQuery:{id:"",page:1,limit:20},tableKey:0,tableList:null,total:0,listLoading:!1,dialogVisible:!1,fileList:[]}},watch:{"listQuery.id":{handler:function(t,e){this.saveExamine(),this.getNoticeInfo(t),this.getFileList()},deep:!0}},created:function(){this.listQuery.id=this.noticeId},methods:{backFn:function(){this.$emit("openCreateNotice","1")},getNoticeInfo:function(t){var e=this,i={id:t};Object(a["f"])(i).then(function(t){e.list=t.data.xlglNotice})},setNoticeTop:function(t,e){var i=this,s="取消置顶",n=0;0===e&&(s="置顶",n=1);var o={id:t,istop:n};Object(a["j"])(o).then(function(e){0===e.data.code?i.$message({type:"success",message:s+"成功！",onClose:function(){i.getNoticeInfo(t)}}):i.$message({type:"info",message:e.data.msg})})},deleteById:function(t){var e=this,i={ids:t};Object(a["a"])(i).then(function(t){0===t.data.code?e.$message({type:"success",message:"删除成功！",onClose:function(){e.$emit("openCreateNotice","1")}}):e.$message({type:"info",message:t.data.msg})})},openDetail:function(t){this.$emit("openCreateNotice","4",t)},getExamineList:function(){var t=this;this.listLoading=!0,Object(a["c"])(this.listQuery).then(function(e){t.tableList=e.data.page.list,t.total=e.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1500)})},saveExamine:function(){var t={id:this.noticeId};Object(a["h"])(t).then(function(t){})},getInfoUpAndDown:function(t){var e=this,i={id:this.listQuery.id};Object(a["e"])(i).then(function(i){"next"===t?i.data.downNotice?e.listQuery.id=i.data.downNotice.id:e.$message({type:"info",message:"已经是最后一篇"}):i.data.upNotice?e.listQuery.id=i.data.upNotice.id:e.$message({type:"info",message:"已经是第一篇"})})},openDialog:function(){this.dialogVisible=!0,this.getExamineList()},handleClose:function(){this.dialogVisible=!1},getFileList:function(){var t=this;Object(a["d"])({id:this.listQuery.id}).then(function(e){t.fileList=e.data.list})},download:function(t){window.location.href="xlgl/xlglnotice/downloadPicture?fileId="+t+"&access_token="+this.$store.state.user.token}}},c=l,r=(i("034e"),i("2877")),d=Object(r["a"])(c,s,n,!1,null,"5ca60fe9",null);e["default"]=d.exports},"9fd3":function(t,e,i){}}]);