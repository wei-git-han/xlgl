(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b09b7c6a"],{"8d3a":function(e,t,s){"use strict";var i=s("b5c0"),a=s.n(i);a.a},b5c0:function(e,t,s){},f90a:function(e,t,s){"use strict";s.r(t);var i=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",[s("el-col",{attrs:{span:18}},[s("el-card",{staticStyle:{height:"calc(98vh - 105px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[s("div",{staticClass:"addTitle"},[s("span"),e._v(" "),s("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:e.backFn}})],1),e._v(" "),s("div",[s("div",{staticStyle:{"text-align":"center","font-size":"20px",color:"#333"}},[e._v(e._s(e.title))]),e._v(" "),s("div",{staticClass:"container"},[s("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[e._v("动态类型：")]),e._v(" "),s("span",{staticStyle:{color:"#333"}},[e._v(e._s(e.newsType))])]),e._v(" "),s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[e._v("发布单位：")]),e._v(" "),s("span",{staticStyle:{color:"#333"}},[e._v(e._s(e.releaseDept))])]),e._v(" "),s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[e._v("发布时间：")]),e._v(" "),s("span",{staticStyle:{color:"#333"}},[e._v(e._s(e.releaseDate))])]),e._v(" "),s("p",{staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[e._v("发布人：")]),e._v(" "),s("span",{staticStyle:{color:"#333"}},[e._v(e._s(e.releaseUser))])]),e._v(" "),s("p",{directives:[{name:"show",rawName:"v-show",value:"1"===e.isRelease,expression:"isRelease==='1'"}],staticStyle:{"margin-left":"20px"}},[s("span",{staticStyle:{color:"#666"}},[e._v("已阅人数：")]),e._v(" "),s("span",{staticStyle:{color:"#333"}},[e._v(e._s(e.hits)+"人")])])]),e._v(" "),s("div",{staticStyle:{color:"#3377FF",cursor:"pointer","font-size":"14px"}},[s("span",{directives:[{name:"show",rawName:"v-show",value:"1"!==this.topFlag&&"1"===e.adminFlag,expression:"this.topFlag !== '1' && adminFlag==='1'"}],on:{click:function(t){return e.toTop()}}},[e._v(e._s(e.isTop?"取消置顶":"置顶"))]),e._v(" "),s("span",{directives:[{name:"show",rawName:"v-show",value:"1"===this.topFlag||e.isEdit&&"1"===e.isEdit,expression:"this.topFlag === '1'||(isEdit && isEdit==='1')"}],staticClass:"ma-l_15",on:{click:function(t){return e.editorFn()}}},[e._v("编辑")]),e._v(" "),s("span",{directives:[{name:"show",rawName:"v-show",value:"1"===this.topFlag||e.isDelete&&"1"===e.isDelete,expression:"this.topFlag === '1'||(isDelete && isDelete==='1')"}],staticClass:"ma-l_15",on:{click:function(t){return e.deleteFn()}}},[e._v("删除")])])]),e._v(" "),s("div",{staticClass:"content",domProps:{innerHTML:e._s(e.content)}})]),e._v(" "),s("div",{staticStyle:{"text-align":"right",position:"absolute",bottom:"50px",right:"30px"}},[s("el-button",{directives:[{name:"show",rawName:"v-show",value:e.preId&&"no"!==e.preId,expression:"preId && preId !== 'no'"}],attrs:{size:"mini"},on:{click:e.lastInfo}},[e._v("上一篇")]),e._v(" "),s("el-button",{directives:[{name:"show",rawName:"v-show",value:e.sufId&&"no"!==e.sufId,expression:"sufId && sufId !== 'no'"}],attrs:{size:"mini"},on:{click:e.nextInfo}},[e._v("下一篇")])],1)])],1)],1)},a=[],n=s("aa2a"),o={components:{},props:{id:{type:String,default:""},isEdit:{type:String,default:""},isDelete:{type:String,default:""},topFlag:{type:String,default:""}},data:function(){return{title:"",newsType:"",content:"",hits:"",releaseDept:"",isTop:"",releaseDate:"",releaseUser:"",preId:"",sufId:"",isRelease:"",adminFlag:this.$store.state.user.userInfo.adminFlag}},created:function(){this.getDetails(this.id)},methods:{getDetails:function(e){var t=this;Object(n["e"])({id:e}).then(function(e){var s=e.data.xlglNews,i=s.title,a=s.newsType,n=s.isTop,o=s.content,c=s.hits,l=s.isRelease,r=s.releaseDept,p=s.releaseDate,d=s.releaseUser,v=s.preId,u=s.sufId;Object.assign(t,{title:i,newsType:a,isTop:n,content:o,hits:c,isRelease:l,releaseDept:r,releaseDate:p,releaseUser:d,preId:v,sufId:u})})},backFn:function(){this.$emit("back")},toTop:function(){var e=this;this.isTop?Object(n["k"])({id:this.id}).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"取消置顶成功!"}),e.$emit("back")):(e.$message({type:"info",message:"取消置顶失败!"}),e.$emit("back"))}):Object(n["j"])({id:this.id}).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"置顶成功!"}),e.$emit("back")):(e.$message({type:"info",message:"置顶失败!"}),e.$emit("back"))})},editorFn:function(){this.$emit("back",this.id,this.topFlag)},deleteFn:function(){var e=this;Object(n["b"])({ids:this.id}).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"删除成功!"}),e.$emit("back")):(e.$message({type:"info",message:"删除失败!"}),e.$emit("back"))})},lastInfo:function(){this.getDetails(this.preId)},nextInfo:function(){this.getDetails(this.sufId)}}},c=o,l=(s("8d3a"),s("2877")),r=Object(l["a"])(c,i,a,!1,null,"92b398fa",null);t["default"]=r.exports}}]);