(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-66c71cb5"],{3733:function(t,i,e){},"6ec9":function(t,i,e){"use strict";e.r(i);var n=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"app-container1",staticStyle:{padding:"0 10px 20px"}},[e("div",{staticClass:"app-content"},[e("el-row",{attrs:{gutter:20}},[e("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[e("div",{staticClass:"addTitle"},[e("el-button",{staticStyle:{"margin-right":"30px"},attrs:{type:"primary"},on:{click:t.openDialog}},[t._v("已阅人员详单")]),t._v(" "),e("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),e("div",{staticClass:"content"},[e("el-header",{staticClass:"title"},[t._v("\n            "+t._s(t.list.title)+"\n          ")]),t._v(" "),e("el-main",[e("div",{staticClass:"headDiv"},[1===t.list.isTop?e("span",{class:{istop:t.list.isTop}},[t._v(t._s(t._f("isTopFilter")(t.list.isTop)))]):t._e(),t._v(" "),e("span",{staticClass:"gapSty"},[t._v("发布时间："+t._s(t.list.releaseTime))]),t._v(" "),e("span",{staticClass:"gapSty"},[t._v("发布单位："+t._s(t.list.releaseOrgan))]),t._v(" "),e("span",[t._v("发布人："+t._s(t.list.creator))]),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("span",{staticClass:"btnSty colorSty1",on:{click:function(i){return t.deleteById(t.list.id)}}},[t._v("删除")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("span",{staticClass:"btnSty colorSty1",on:{click:function(i){return t.openDetail(t.list.id)}}},[t._v("编辑")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("span",{staticClass:"btnSty colorSty1",on:{click:function(i){return t.setNoticeTop(t.list.id,t.list.isTop)}}},[t._v(t._s(t._f("isTopFilter1")(t.list.isTop)))]):t._e(),t._v(" "),e("span",{staticClass:"btnSty"},[t._v("已阅人数："+t._s(t.list.userReadNumber)+"人")])]),t._v(" "),e("div",{staticStyle:{overflow:"auto"},domProps:{innerHTML:t._s(t.list.content)}}),t._v(" "),e("div",{staticClass:"fileList"},[e("ul",t._l(t.fileList,function(i){return e("li",{key:i.fileId},[t._v("\n                  "+t._s(i.pictureName)+"\n                  "),e("span",{staticClass:"colorSty1 gapSty",on:{click:function(e){return e.stopPropagation(),t.download(i.pictureId)}}},[t._v("下载")])])}),0)]),t._v(" "),e("div",{staticClass:"changePage"},[e("el-button",{attrs:{size:"mini"},on:{click:function(i){return t.getInfoUpAndDown("pre")}}},[t._v("上一篇")]),t._v(" "),e("el-button",{attrs:{size:"mini"},on:{click:function(i){return t.getInfoUpAndDown("next")}}},[t._v("下一篇")])],1)])],1)])],1),t._v(" "),e("el-dialog",{attrs:{title:"已阅人员详情名单",visible:t.dialogVisible,width:"40%","before-close":t.handleClose},on:{"update:visible":function(i){t.dialogVisible=i}}},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{height:"400px"}},[e("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.tableList,border:"",fit:!0,stripe:!0,"highlight-current-row":""}},[e("el-table-column",{attrs:{label:"姓名",width:"150",align:"center"},scopedSlots:t._u([{key:"default",fn:function(i){return[e("div",{attrs:{title:i.row.readUserName}},[t._v(t._s(i.row.readUserName))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"单位名称",align:"center"},scopedSlots:t._u([{key:"default",fn:function(i){return[e("span",[t._v(t._s(i.row.readOrgName))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"阅读时间",align:"center"},scopedSlots:t._u([{key:"default",fn:function(i){return[e("span",[t._v(t._s(i.row.readDate))])]}}])})],1)],1),t._v(" "),e("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(i){return t.$set(t.listQuery,"page",i)},"update:limit":function(i){return t.$set(t.listQuery,"limit",i)},pagination:t.getExamineList}})],1)],1)])},s=[],a=e("13c4"),o=e("333d"),l={name:"UpdateNotice",components:{Pagination:o["a"]},filters:{isTopFilter:function(t){return 1===t?"置顶":""},isTopFilter1:function(t){return 1===t?"取消置顶":"置顶"}},props:{noticeId:{type:String,default:""}},data:function(){return{list:null,show:this.$store.state.user.userInfo.adminFlag,listQuery:{id:"",page:1,limit:20},tableKey:0,tableList:null,total:0,listLoading:!1,dialogVisible:!1,fileList:[]}},watch:{"listQuery.id":{handler:function(t,i){this.saveExamine(),this.getNoticeInfo(t),this.getFileList()},deep:!0}},created:function(){this.listQuery.id=this.noticeId},methods:{backFn:function(){this.$emit("openCreateNotice","1")},getNoticeInfo:function(t){var i=this,e={id:t};Object(a["f"])(e).then(function(t){i.list=t.data.xlglNotice})},setNoticeTop:function(t,i){var e=this,n="取消置顶",s=0;0===i&&(n="置顶",s=1);var o={id:t,istop:s};Object(a["j"])(o).then(function(i){0===i.data.code?e.$notify({title:"提示",message:n+"成功！",duration:1500,type:"success",onClose:function(){e.getNoticeInfo(t)}}):e.$notify({title:"提示",message:i.data.msg,duration:1500,type:"warning"})})},deleteById:function(t){var i=this,e={ids:t};this.$confirm("此条数据将进行永久删除操作, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(a["a"])(e).then(function(t){0===t.data.code?i.$notify({title:"提示",message:"删除成功！",duration:1500,type:"success",onClose:function(){i.$emit("openCreateNotice","1")}}):i.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}).catch(function(){i.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})})},openDetail:function(t){this.$emit("openCreateNotice","4",t)},getExamineList:function(){var t=this;this.listLoading=!0,Object(a["c"])(this.listQuery).then(function(i){t.tableList=i.data.page.list,t.total=i.data.page.totalCount,setTimeout(function(){t.listLoading=!1},200)})},saveExamine:function(){var t={id:this.listQuery.id};Object(a["h"])(t).then(function(t){})},getInfoUpAndDown:function(t){var i=this,e={id:this.listQuery.id};Object(a["e"])(e).then(function(e){"next"===t?e.data.downNotice?i.listQuery.id=e.data.downNotice.id:i.$notify({title:"提示",message:"已经是最后一篇",duration:1500,type:"warning"}):e.data.upNotice?i.listQuery.id=e.data.upNotice.id:i.$notify({title:"提示",message:"已经是第一篇",duration:1500,type:"warning"})})},openDialog:function(){this.dialogVisible=!0,this.getExamineList()},handleClose:function(){this.dialogVisible=!1},getFileList:function(){var t=this;Object(a["d"])({id:this.listQuery.id}).then(function(i){t.fileList=i.data.list})},download:function(t){window.location.href="xlgl/xlglnotice/downloadPicture?fileId="+t+"&access_token="+this.$store.state.user.token}}},c=l,r=(e("b3ce"),e("2877")),d=Object(r["a"])(c,n,s,!1,null,"9ee291ce",null);i["default"]=d.exports},b3ce:function(t,i,e){"use strict";var n=e("3733"),s=e.n(n);s.a}}]);