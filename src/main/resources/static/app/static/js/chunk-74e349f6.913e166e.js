(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-74e349f6"],{"74ce":function(t,i,e){},"7cf0":function(t,i,e){"use strict";var s=e("74ce"),a=e.n(s);a.a},e2f5:function(t,i,e){"use strict";e.r(i);var s=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"app-container"},[e("div",{staticClass:"app-content"},[e("title-card",{attrs:{"title-text":t.cardTitle}}),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("el-button",{staticClass:"createBtn noBorder",attrs:{size:"mini",type:"primary",icon:"el-icon-plus"},on:{click:t.openCreateNotice}},[t._v("新增")]):t._e(),t._v(" "),e("el-row",[e("el-col",{staticClass:"elColSty",attrs:{span:24}},[e("el-scrollbar",{staticClass:"hidden-x"},[e("el-row",{attrs:{gutter:20}},t._l(t.list,function(i,s){return e("el-col",{key:s,attrs:{span:6}},[e("el-card",{staticClass:"margin-card",staticStyle:{"max-height":"330px",height:"330px"},attrs:{"body-style":{padding:"0px"}}},[e("el-button",{staticClass:"inform",class:{notice:"公告"===i.type},attrs:{type:"success",size:"mini"}},[t._v(t._s(i.type))]),t._v(" "),e("div",{staticClass:"cardContent gapSty",staticStyle:{margin:"0","padding-top":"0"}},[e("div",{staticClass:"title",on:{click:function(e){return e.stopPropagation(),t.openDetail(i.id)}}},[e("span",{attrs:{title:i.title}},[t._v(t._s(i.title.length>35?i.title.substr(0,35)+"...":i.title))]),t._v(" "),1===i.isTop?e("span",{class:{istop:i.isTop}},[t._v(t._s(t._f("isTopFilter")(i.isTop)))]):t._e()]),t._v(" "),e("div",{staticClass:"gapSty color2",staticStyle:{"margin-top":"20px"}},[e("svg-icon",{staticClass:"icon",attrs:{"icon-class":"time"}}),t._v(" "),e("span",{staticClass:"gapLeft"},[t._v(" "+t._s(i.releaseTime))])],1),t._v(" "),e("div",{staticClass:"gapSty gapSty1 gapSty2",staticStyle:{height:"50px",margin:"0",padding:"0",overflow:"hidden"},domProps:{innerHTML:t._s(i.content)}}),t._v(" "),e("div",{staticClass:"gapSty height1 color2"},[e("svg-icon",{staticClass:"icon",attrs:{"icon-class":"noticepeople"}}),t._v("\n                    发布人：\n                    "),e("span",{staticClass:"gapLeft"},[t._v(t._s(i.creator))])],1),t._v(" "),e("div",{staticClass:"gapSty height1 color2"},[e("svg-icon",{staticClass:"icon",attrs:{"icon-class":"noticepeople"}}),t._v(" "),e("span",{staticClass:"gapLeft"},[t._v(t._s(i.releaseOrgan))])],1),t._v(" "),e("div",{staticClass:"gapSty height1"},[e("span",{staticClass:"color1"},[t._v("浏览 "+t._s(i.viewNumber))]),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("span",{staticClass:"btSty",on:{click:function(e){return t.deleteById(i.id)}}},[t._v("删除")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("span",{staticClass:"btSty",on:{click:function(e){return e.stopPropagation(),t.upDateDetail(i.id)}}},[t._v("编辑")]):t._e(),t._v(" "),"0"===t.show||"1"===t.show||"3"===t.show?e("span",{staticClass:"btSty",on:{click:function(e){return t.setNoticeTop(i.id,i.isTop)}}},[t._v(t._s(t._f("isTopFilter1")(1===i.isTop?0:1)))]):t._e()])])],1)],1)}),1)],1)],1)],1),t._v(" "),e("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(i){return t.$set(t.listQuery,"page",i)},"update:limit":function(i){return t.$set(t.listQuery,"limit",i)},pagination:t.getNoticeList}})],1)])},a=[],n=e("35b7"),o=e("333d"),c=e("13c4"),l={name:"InformNoticeList",filters:{isTopFilter:function(t){return 1===t?"置顶":""},isTopFilter1:function(t){return 1===t?"置顶":"取消置顶"},limitText:function(t){return t.length>40?t.substring(0,40)+"...":t}},components:{TitleCard:n["a"],Pagination:o["a"]},data:function(){return{cardTitle:"通知公告",show:this.$store.state.user.userInfo.adminFlag,tableKey:0,list:null,total:0,listLoading:!0,listQuery:{page:1,limit:20,type:""}}},created:function(){this.getNoticeList()},methods:{getNoticeList:function(){var t=this;this.listLoading=!0,Object(c["g"])(this.listQuery).then(function(i){t.list=i.data.page.list,t.total=i.data.page.totalCount,setTimeout(function(){t.listLoading=!1},1)})},openCreateNotice:function(){this.$emit("openCreateNotice","2")},openDetail:function(t){this.$emit("openCreateNotice","3",t)},upDateDetail:function(t){this.$emit("openCreateNotice","4",t)},deleteById:function(t){var i=this,e={ids:t};this.$confirm("此条数据将进行永久删除操作, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c["a"])(e).then(function(t){0===t.data.code?(i.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}),i.getNoticeList()):i.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}).catch(function(){i.$notify({title:"提示",message:"已取消",duration:1500,type:"warning"})})},setNoticeTop:function(t,i){var e=this,s="取消置顶",a=0;0===i&&(s="置顶",a=1);var n={id:t,istop:a};Object(c["j"])(n).then(function(t){0===t.data.code?(e.$notify({title:"提示",message:s+"成功！",duration:1500,type:"success"}),e.getNoticeList()):e.$notify({title:"提示",message:t.data.msg,duration:1500,type:"warning"})})}}},r=l,p=(e("7cf0"),e("2877")),u=Object(p["a"])(r,s,a,!1,null,"121bed95",null);i["default"]=u.exports}}]);