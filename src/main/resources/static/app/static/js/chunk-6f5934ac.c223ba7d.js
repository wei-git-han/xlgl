(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6f5934ac"],{"2f26":function(t,e,s){"use strict";var a=s("d55c"),i=s.n(a);i.a},d55c:function(t,e,s){},f90a:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("el-col",{staticClass:"borderSty",attrs:{span:18}},[s("el-card",{staticStyle:{height:"calc(98vh - 105px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[s("div",{staticClass:"addTitle"},[s("span"),t._v(" "),s("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),s("div",[s("div",{staticStyle:{"text-align":"center","font-size":"20px",color:"#333"}},[t._v(t._s(t.title))]),t._v(" "),s("div",{staticClass:"container"},[s("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[t._v("动态类型：")]),t._v(" "),s("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.newsType))])]),t._v(" "),s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[t._v("发布单位：")]),t._v(" "),s("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.releaseDept))])]),t._v(" "),s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[t._v("发布时间：")]),t._v(" "),s("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.releaseDate))])]),t._v(" "),s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[t._v("已阅人数：")]),t._v(" "),s("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.hits)+"人")])])]),t._v(" "),s("div",{staticStyle:{color:"#3377FF",cursor:"pointer","font-size":"14px"}},[s("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag==='1'"}],on:{click:function(e){return t.toTop()}}},[t._v(t._s(t.isTop?"取消置顶":"置顶"))]),t._v(" "),s("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isEdit,expression:"isEdit==='1'"}],staticClass:"ma-l_15",on:{click:function(e){return t.editorFn()}}},[t._v("编辑")]),t._v(" "),s("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isDelete,expression:"isDelete==='1'"}],staticClass:"ma-l_15",on:{click:function(e){return t.deleteFn()}}},[t._v("删除")])])]),t._v(" "),s("div",{staticClass:"content",domProps:{innerHTML:t._s(t.content)}})])])],1)],1)},i=[],n=s("aa2a"),c={components:{},props:{id:{type:String,default:""},isEdit:{type:String,default:""},isDelete:{type:String,default:""}},data:function(){return{title:"",newsType:"",content:"",hits:"",releaseDept:"",isTop:"",releaseDate:"",adminFlag:this.$store.state.user.userInfo.adminFlag}},created:function(){this.getDetails()},methods:{getDetails:function(){var t=this;Object(n["d"])({id:this.id}).then(function(e){t.title=e.data.xlglNews.title,t.newsType=e.data.xlglNews.newsType,t.isTop=e.data.xlglNews.isTop,t.content=e.data.xlglNews.content,t.hits=e.data.xlglNews.hits,t.releaseDept=e.data.xlglNews.releaseDept,t.releaseDate=e.data.xlglNews.releaseDate})},backFn:function(){this.$emit("back")},toTop:function(){var t=this;this.isTop?Object(n["j"])({id:this.id}).then(function(e){"success"===e.data.result?(t.$message({type:"success",message:"取消置顶成功!"}),t.$emit("back")):(t.$message({type:"info",message:"取消置顶失败!"}),t.$emit("back"))}):Object(n["i"])({id:this.id}).then(function(e){"success"===e.data.result?(t.$message({type:"success",message:"置顶成功!"}),t.$emit("back")):(t.$message({type:"info",message:"置顶失败!"}),t.$emit("back"))})},editorFn:function(){this.$emit("back",this.id)},deleteFn:function(){var t=this;Object(n["b"])({ids:this.id}).then(function(e){"success"===e.data.result?(t.$message({type:"success",message:"删除成功!"}),t.$emit("back")):(t.$message({type:"info",message:"删除失败!"}),t.$emit("back"))})}}},l=c,o=(s("2f26"),s("2877")),r=Object(o["a"])(l,a,i,!1,null,"41378d66",null);e["default"]=r.exports}}]);