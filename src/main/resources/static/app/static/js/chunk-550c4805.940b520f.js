(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-550c4805"],{"0087":function(t,e,i){"use strict";var a=i("2b18"),s=i.n(a);s.a},"056f":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"40px",top:"40px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),i("div",{staticStyle:{padding:"20px"}},[i("div",{staticClass:"header"},[i("div",{staticClass:"title",attrs:{title:t.tacticTitle}},[t._v(t._s(t.tacticTitle))]),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("span",[t._v("发布时间：")]),t._v(" "),i("span",[t._v(t._s(t.updateDate))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("发布单位：")]),t._v(" "),i("span",[t._v(t._s(t.createOrganName))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("浏览次数：")]),t._v(" "),i("span",[t._v(t._s(t.viewNumber))])]),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[i("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),i("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-col",{attrs:{span:18}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"flex-start",width:"100%",overflow:"hidden"}},[i("div",{staticStyle:{"margin-top":"16px"}},[t._v("训练内容描述：")]),t._v(" "),i("div",{staticStyle:{"word-break":"break-all",width:"90%"},attrs:{id:"content"},domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),i("video",{directives:[{name:"show",rawName:"v-show",value:t.videoFile,expression:"videoFile"}],ref:"myVideo",staticStyle:{height:"500px",width:"100%"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoFile,controls:"controls"}})]),t._v(" "),i("el-col",{staticStyle:{"margin-top":"20px"},attrs:{span:6}},[t.coverFile?i("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.coverFile}}):i("div",{staticClass:"imgStyle",staticStyle:{background:"#F9FBFE"}},[i("svg-icon",{staticClass:"icon",staticStyle:{height:"50%",width:"50%","margin-left":"25%","margin-top":"12.5%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{width:"70%",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.fileList,function(e,a){return i("div",{key:a,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(i){return t.downloadFile(e.fileId)}}},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.fileName))])],1)})],2)])],1)],1)],1)],1)],1)])},s=[],l=i("0fe1"),n={props:{id:{type:String,default:""},isManager:{type:String,default:""}},data:function(){return{tacticTitle:"",updateDate:"",viewNumber:"",createOrganName:"",content:"",coverFile:"",videoFile:"",fileList:[],symTime:"",timer:"",videoTime:""}},created:function(){this.getSpecialtyInfo()},mounted:function(){var t=this;this.$refs.myVideo.onplay=function(){t.timer=setInterval(function(){t.videoTime=t.$refs.myVideo.currentTime,t.videoTime-t.symTime>1&&(t.$refs.myVideo.currentTime=t.symTime),t.symTime=t.$refs.myVideo.currentTime},100)},this.$refs.myVideo.onended=function(){t.specialUpdateRead(),clearInterval(t.timer)}},methods:{getSpecialtyInfo:function(){var t=this;Object(l["G"])({id:this.id,type:"0"}).then(function(e){var i=e.data.xlglWarSpecialty,a=i.tacticTitle,s=i.updateDate,l=i.viewNumber,n=i.createOrganName,c=i.coverFile,o=i.videoFile,r=i.content;Object.assign(t,{tacticTitle:a,updateDate:s,viewNumber:l,createOrganName:n,coverFile:c,videoFile:o,content:r}),t.fileList=e.data.xlglWarSpecialty.accessoryFileArray})},back:function(){this.$emit("back",0)},editor:function(){this.$emit("back",1,this.id)},deleteFn:function(){var t=this;Object(l["xb"])({ids:this.id}).then(function(e){"success"===e.data.msg?t.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}):t.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"}),t.back()})},downloadFile:function(t){window.location.href="/app/xlgl/xlgldocumentfile/downLoad?fileId="+t+"&access_token="+this.$store.state.user.token},specialUpdateRead:function(){Object(l["wb"])({id:this.id}).then(function(t){})}}},c=n,o=(i("0087"),i("b851"),i("2877")),r=Object(o["a"])(c,a,s,!1,null,"42bd6fd1",null);e["default"]=r.exports},1516:function(t,e,i){"use strict";var a=i("ec11"),s=i.n(a);s.a},"25ae":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[0==t.isShow?i("div",{staticClass:"app-content"},[i("title-card",{attrs:{"title-text":"专业训练"}}),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"40px",top:"20px"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticClass:"addBtn noBorder",attrs:{type:"success",size:"mini",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("新增")])],1),t._v(" "),i("div",{staticStyle:{"margin-top":"15px"}},[i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"输入训练名称"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.search(e)}},model:{value:t.listQuery.title,callback:function(e){t.$set(t.listQuery,"title",e)},expression:"listQuery.title"}}),t._v(" "),i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"25px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("查询")])],1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-row",{attrs:{gutter:20}},[i("div",{staticClass:"videoList"},t._l(t.videoList,function(e,a){return i("div",{key:a,staticClass:"videoCard",on:{click:function(i){return t.toDetial(e)}}},[i("span",{class:["learnLabel","1"==e.readStatus?"bg_active":"bg_default"]},[t._v(t._s("1"==e.readStatus?"已学习":"待学习"))]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px",background:"#F9FBFE"}},[e.videoFile?i("video",{staticClass:"imgStyle",staticStyle:{"object-fit":"fill"},attrs:{controls:"controls",poster:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}},[i("source",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.videoFile}})]):e.coverFile?i("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"50%",height:"50%","margin-top":"12.5%","margin-left":"25%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),i("p",{staticClass:"cardTitle",attrs:{title:e.tacticTitle}},[t._v(t._s(e.tacticTitle))]),t._v(" "),i("p",{staticStyle:{color:"#99A6BF",padding:"0 10px"}},[t._v(t._s(e.viewNumber)+"次浏览")])])}),0)])],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getSpecialtyList}})],1):t._e(),t._v(" "),1==t.isShow?i("addPage",{attrs:{id:t.fileId},on:{back:t.backList}}):t._e(),t._v(" "),2==t.isShow?i("detailPage",{attrs:{id:t.fileId,"is-manager":t.isManager},on:{back:t.backList}}):t._e()],1)},s=[],l=i("35b7"),n=i("333d"),c=i("5b2c"),o=i("056f"),r=i("0fe1"),d={components:{TitleCard:l["a"],Pagination:n["a"],addPage:c["default"],detailPage:o["default"]},data:function(){return{listQuery:{page:1,limit:10,title:""},total:0,states:[1,2,3],topicType:[1,2,3],videoList:[],isShow:0,fileId:"",isManager:""}},watch:{isShow:function(t){0===t&&this.getSpecialtyList()}},created:function(){this.getAuthor(),this.getSpecialtyList()},methods:{getSpecialtyList:function(){var t=this;Object(r["H"])(this.listQuery).then(function(e){t.videoList=e.data.page.list,t.total=e.data.page.totalCount})},getAuthor:function(){var t=this;Object(r["n"])().then(function(e){t.isManager=e.data})},search:function(){this.getSpecialtyList()},backList:function(t,e){this.isShow=t,this.fileId=e},addPage:function(){this.isShow=1},toDetial:function(t){this.isShow=2,this.fileId=t.id}}},p=d,u=(i("1516"),i("2877")),v=Object(u["a"])(p,a,s,!1,null,"5e0ffc7a",null);e["default"]=v.exports},"2b18":function(t,e,i){},"2c38":function(t,e,i){},b851:function(t,e,i){"use strict";var a=i("2c38"),s=i.n(a);s.a},ec11:function(t,e,i){}}]);