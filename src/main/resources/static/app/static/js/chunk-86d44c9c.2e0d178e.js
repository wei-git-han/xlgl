(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-86d44c9c","chunk-3c60fb14","chunk-6122b3ca","chunk-1bce6d2c"],{"1b55":function(t,e,i){"use strict";var s=i("8afe"),a=i.n(s);a.a},"1e7a":function(t,e,i){},"3e58":function(t,e,i){"use strict";var s=i("1e7a"),a=i.n(s);a.a},"412e":function(t,e,i){"use strict";var s=i("78b9"),a=i.n(s);a.a},"61e2":function(t,e,i){"use strict";var s=i("826c"),a=i.n(s);a.a},"67c8":function(t,e,i){},"78b9":function(t,e,i){},"7c64":function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container2"},[t.showList?i("div",[i("el-row",{attrs:{gutter:20}},[0==t.isFlag?i("el-col",{staticStyle:{position:"relative"},attrs:{span:18}},[i("el-card",{staticStyle:{height:"calc(98vh - 15px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[i("el-tabs",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],on:{"tab-click":t.handleClick},model:{value:t.editableTabsValue,callback:function(e){t.editableTabsValue=e},expression:"editableTabsValue"}},t._l(t.tabsList,function(t,e){return i("el-tab-pane",{key:e,attrs:{label:t.title,name:t.name}})}),1),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[t.infoList.length>0?i("div",t._l(t.infoList,function(e,s){return i("el-row",{key:s,staticClass:"grid-content bg-purple divSty",attrs:{gutter:20}},[i("div",{staticStyle:{width:"290px",height:"160px",background:"#F9FBFE"}},[e.picturePath?i("img",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.picturePath,alt:"",width:"100%",height:"100%"}}):i("svg-icon",{staticClass:"icon",staticStyle:{width:"50%",height:"50%","margin-top":"12.5%","margin-left":"25%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),i("el-col",{attrs:{span:18}},[i("div",{staticStyle:{"margin-left":"10px",height:"160px",display:"flex","flex-direction":"column","justify-content":"space-between"}},[i("div",{staticClass:"title"},[i("span",{staticClass:"newsTitle",attrs:{title:e.title},on:{click:function(i){return t.toDetail(e)}}},[t._v(t._s(e.title))]),t._v(" "),e.isTop?i("span",{staticClass:"topSty"},[t._v("置顶")]):t._e()]),t._v(" "),i("div",{staticClass:"content",attrs:{id:"editorImg"},domProps:{innerHTML:t._s(e.content)}}),t._v(" "),i("div",{staticClass:"tally",staticStyle:{display:"flex","flex-direction":"row","justify-content":"space-between"}},[i("div",{staticClass:"newsLabel"},[i("span",[t._v(t._s(e.releaseDept))]),t._v(" "),i("span",{staticClass:"ma-l_30"},[t._v(t._s(e.releaseUser))]),t._v(" "),i("span",{staticClass:"ma-l_30"},[t._v(t._s(e.releaseDate))]),t._v(" "),i("span",{staticClass:"ma-l_30"},[t._v(t._s(e.hits?e.hits:0)+"浏览")])]),t._v(" "),i("div",{staticStyle:{color:"#2280E5",cursor:"pointer","font-size":"13px"}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag==='1'"}],on:{click:function(i){return t.isTop(e)}}},[t._v(t._s(e.isTop?"取消置顶":"置顶"))]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:e.isEdit&&"1"===e.isEdit,expression:"item.isEdit && item.isEdit==='1'"}],staticClass:"ma-l_15",on:{click:function(i){return t.editorFn(e.id)}}},[t._v("编辑")]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:e.isDelete&&"1"===e.isDelete,expression:"item.isDelete && item.isDelete==='1'"}],staticClass:"ma-l_15",on:{click:function(i){return t.deleteFn(e.id)}}},[t._v("删除")])])])])])],1)}),1):i("div",{staticStyle:{"text-align":"center",padding:"20px 0",color:"#666666"}},[t._v("暂无数据")])])],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getDataList}}),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"20px",top:"6px"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag||"2"===t.adminFlag,expression:"adminFlag==='1'||adminFlag==='2'"}],staticClass:"addBtn noBorder",attrs:{type:"success",size:"mini",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("增加")]),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag||"2"===t.adminFlag,expression:"adminFlag==='1'||adminFlag==='2'"}],staticClass:"addBtn noBorder",attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:t.toDraft}},[t._v("草稿箱")])],1)],1)],1):1==t.isFlag?i("draftPage",{on:{back:t.drafBack}}):2==t.isFlag?i("detailPage",{attrs:{id:t.viewId,"is-edit":t.isEdit,"is-delete":t.isDelete},on:{back:t.viewBack}}):t._e(),t._v(" "),i("el-col",{attrs:{span:6}},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"div2"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("动态发布数")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本年度全局动态统计")])])],1),t._v(" "),i("div",{staticClass:"textClick fs_50 ff_d"},[t._v(t._s(t.totalYear))])]),t._v(" "),i("div",{staticClass:"div2"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("本月发布动态")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本月全局动态统计")])])],1),t._v(" "),i("div",{staticClass:"textClick fs_50 ff_d"},[t._v(t._s(t.totalMonth))])]),t._v(" "),i("div",{staticClass:"div2"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("本周发布动态")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本周全局动态统计")])])],1),t._v(" "),i("div",{staticClass:"textClick fs_50 ff_d"},[t._v(t._s(t.totalWeek))])])]),t._v(" "),i("el-col",{staticClass:"borderSty",attrs:{span:24}},[i("div",{staticClass:"div1"},[t._v("\n              各单位发布统计\n              "),i("el-dropdown",{attrs:{size:"mini","split-button":"",type:"info"},on:{command:t.handleCommandDate}},[t._v("\n                "+t._s(t.COMMAND_LIST[t.commandDate])+"\n                "),i("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[i("el-dropdown-item",{attrs:{command:"year"}},[t._v("本年")]),t._v(" "),i("el-dropdown-item",{attrs:{command:"month"}},[t._v("本月")]),t._v(" "),i("el-dropdown-item",{attrs:{command:"week"}},[t._v("本周")])],1)],1)],1),t._v(" "),i("div",[i("ul",{staticClass:"ulSty"},t._l(t.departList,function(e,s){return i("li",{key:s},[i("el-row",[i("el-col",{attrs:{span:12}},[t._v(t._s(e.releaseOrgan))]),t._v(" "),i("el-col",{attrs:{span:6}},[t._v(t._s(e.nums)+"条")]),t._v(" "),i("el-col",{staticStyle:{"text-align":"right"},attrs:{span:6}},[i("span",{staticClass:"normal_a",on:{click:function(i){return t.showData(e)}}},[t._v("查看")])])],1)],1)}),0)])])],1)],1)],1)],1):i("addPage",{attrs:{id:t.id,flag:t.isList},on:{back:t.addBack}})],1)},a=[],n=(i("c5f6"),i("aa2a")),l=i("333d"),o=i("af91"),c=i("f8f6"),r=i("f90a"),d={name:"ComplexTable",components:{Pagination:l["a"],addPage:o["default"],draftPage:c["default"],detailPage:r["default"]},data:function(){return{editableTabsValue:"1",commandDate:"month",totalYear:"",totalMonth:"",totalWeek:"",departList:[],otherList:[],COMMAND_LIST:{year:"本年",month:"本月",week:"本周"},listQuery:{page:1,pagesize:10,orgId:""},tabsList:[{title:"上级工作动态",name:"1"},{title:"机关部队训练风采",name:"2"},{title:"安全管理",name:"3"}],tabIndex:0,isLoading:!1,total:0,isFlag:0,showList:!0,viewId:null,id:null,command:"排序方式",infoList:[],adminFlag:this.$store.state.user.userInfo.adminFlag,isDelete:"",isEdit:"",isList:""}},created:function(){this.$route.query.id&&(this.isFlag=2,this.viewId=this.$route.query.id),this.getQueryTotal(this.commandDate),this.getDataList(this.tabIndex)},methods:{handleCommandDate:function(t){this.commandDate=t,this.getQueryTotal(this.commandDate)},handleClick:function(t){this.tabIndex=Number(t.index),this.getDataList()},getDataList:function(){var t=this;0===this.tabIndex?this.listQuery.type="上级工作动态":1===this.tabIndex?this.listQuery.type="机关部队训练风采":this.listQuery.type="安全管理",this.isLoading=!0,this.infoList=[],Object(n["a"])(this.listQuery).then(function(e){t.infoList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},1)})},getQueryTotal:function(t){var e=this;Object(n["g"])({type:t}).then(function(i){e.totalYear=i.data.totalYear,e.totalMonth=i.data.totalMonth,e.totalWeek=i.data.totalWeek,e.departList="year"===t?i.data.totalYearByOrgan:"month"===t?i.data.totalMonthByOrgan:i.data.totalWeekByOrgan})},isTop:function(t){var e=this;t.isTop?Object(n["k"])({id:t.id}).then(function(t){"success"===t.data.result?(e.$notify({title:"提示",message:"取消置顶成功!",duration:1500,type:"success"}),e.getDataList()):e.$notify({title:"提示",message:"取消置顶失败!",duration:1500,type:"warning"})}):Object(n["j"])({id:t.id}).then(function(t){"success"===t.data.result?(e.$notify({title:"提示",message:"置顶成功!",duration:1500,type:"success"}),e.getDataList()):e.$notify({title:"提示",message:"置顶失败!",duration:1500,type:"warning"})})},deleteFn:function(t){var e=this;Object(n["b"])({ids:t}).then(function(t){"success"===t.data.result?(e.$notify({title:"提示",message:"删除成功!",duration:1500,type:"success"}),e.getDataList(),e.getQueryTotal(e.commandDate)):e.$notify({title:"提示",message:"删除失败!",duration:1500,type:"warning"})})},editorFn:function(t){this.isList="0",this.id=t,this.showList=!this.showList},toDetail:function(t){this.viewId=t.id,this.isEdit=t.isEdit,this.isDelete=t.isDelete,this.isFlag=2},toDraft:function(){this.isFlag=1},viewBack:function(t,e){t?(this.id=t,this.showList=!this.showList):(this.isFlag=0,this.getDataList()),e&&(this.isList=e)},drafBack:function(t,e){this.isFlag=t,e&&(this.viewId=e)},addBack:function(t){this.isFlag=t,this.showList=!this.showList,this.getDataList(),this.getQueryTotal(this.commandDate)},showData:function(t){this.isFlag=0,this.listQuery.orgId=t.RELEASE_ORGANID,this.getDataList()},addPage:function(){this.id="",this.isList="1",this.showList=!this.showList}}},u=d,p=(i("412e"),i("1b55"),i("2877")),h=Object(p["a"])(u,s,a,!1,null,"619b9118",null);e["default"]=h.exports},"826c":function(t,e,i){},"8afe":function(t,e,i){},9856:function(t,e,i){"use strict";var s=i("af31"),a=i.n(s);a.a},af31:function(t,e,i){},af91:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"addPage app-content"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticStyle:{"padding-bottom":"100px",position:"relative"}},[i("title-card",{attrs:{"title-text":"训管动态新增"}}),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}}),t._v(" "),i("div",{staticStyle:{padding:"20px 0"}},[i("el-form",{ref:"form",attrs:{model:t.form,rules:t.rules,"label-width":"150px"}},[i("el-col",{attrs:{span:16}},[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"动态类型",prop:"newsType"}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.newsType,callback:function(e){t.$set(t.form,"newsType",e)},expression:"form.newsType"}},[i("el-option",{attrs:{label:"上级工作动态",value:"上级工作动态"}}),t._v(" "),i("el-option",{attrs:{label:"机关部队训练风采",value:"机关部队训练风采"}}),t._v(" "),i("el-option",{attrs:{label:"安全管理",value:"安全管理"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"发布单位",required:""}},[i("el-input",{attrs:{disabled:""},model:{value:t.deptName,callback:function(e){t.deptName=e},expression:"deptName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"动态标题",prop:"title"}},[i("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"编辑内容"}},[i("ueditor",{ref:"content",model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"上传封面"}},[i("el-upload",{ref:"upload",staticClass:"upload-demo default-upload-list wh-100",attrs:{accept:".png,.jpeg,.jpg",drag:"",action:t.fileUrl,data:t.access_token,name:"pdf","file-list":t.imgList,"list-type":"picture-card","on-success":t.uploadImg,"on-error":t.errorFile,"on-remove":t.removeImg,"on-change":t.handleChangeFile,multiple:"",limit:1}},[i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)],1)],1)],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[i("el-button",{attrs:{type:"success"},on:{click:t.saveFn}},[t._v("发布")]),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:"0"!=t.flag,expression:"flag!='0'"}],staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.saveDraft}},[t._v("存草稿")])],1)],1)],1)],1)},a=[],n=(i("28a5"),i("aa2a")),l=i("35b7"),o=i("63f4"),c={components:{Ueditor:o["a"],TitleCard:l["a"]},props:{id:{type:String,default:""},flag:{type:String,default:""}},data:function(){return{form:{title:"",newsType:"",content:"",pIds:"",picutureName:""},rules:{newsType:[{required:!0,message:"请选择动态类型",trigger:"change"}],title:[{required:!0,message:"请填写动态标题",trigger:"blur"}]},deptName:"",isRelease:"",imgList:[],fileUrl:"/app/xlgl/news/upLoadFile",access_token:this.$store.state.user.token}},created:function(){this.getDeptName(),this.id&&this.eidtOrUpdate()},methods:{getDeptName:function(){var t=this;Object(n["d"])().then(function(e){t.deptName=e.data.deptName})},eidtOrUpdate:function(){var t=this;Object(n["f"])({id:this.id}).then(function(e){var i=e.data.xlglNews,s=i.title,a=i.newsType,n=i.content;Object.assign(t.form,{title:s,newsType:a,content:n}),t.isRelease=e.data.xlglNews.isRelease,e.data.xlglNews.picturePath&&t.imgList.push({name:e.data.xlglNews.pictureName,url:"/app/xlgl/xlgldocumentfile/downLoad?fileId=".concat(e.data.xlglNews.picturePath)}),t.$refs.content.setContent(t.form.content)})},backFn:function(){this.$emit("back",0)},uploadImg:function(t){t.fileId&&t.fileId.length>0?(this.form.pIds=t.fileId,this.form.picutureName=t.picutureName):this.errorFile()},errorFile:function(){this.$notify({title:"提示",message:"上传失败!",duration:1500,type:"warning"})},removeImg:function(t){var e=this;Object(n["c"])({infoId:this.id,pictureId:t.url.split("=")[1]}).then(function(t){"success"===t.data.result?(e.$notify({title:"提示",message:"图片删除成功",duration:1500,type:"success"}),e.form.picutureName="",e.form.pIds=""):e.$notify({title:"提示",message:"图片删除失败!",duration:1500,type:"warning"})})},handleChangeFile:function(t,e){e.length>1&&e.splice(0,1)},saveData:function(t,e){var i=this;this.$refs[e].validate(function(e){if(!e)return!1;i.form.isRelease=t,i.form.content=i.$refs.content.getContent(),i.id&&(i.form.id=i.id),Object(n["i"])(i.form).then(function(e){"success"===e.data.result?i.id?("1"===t&&"1"===i.isRelease&&i.$notify({title:"提示",message:"修改成功!",duration:1500,type:"success"}),"0"===t&&i.$notify({title:"提示",message:"存入草稿箱成功!",duration:1500,type:"success"}),"1"===t&&"0"===i.isRelease&&i.$notify({title:"提示",message:"发布成功!",duration:1500,type:"success"})):("1"===t&&i.$notify({title:"提示",message:"发布成功!",duration:1500,type:"success"}),"0"===t&&i.$notify({title:"提示",message:"存入草稿箱成功!",duration:1500,type:"success"})):i.id?("1"===t&&"1"===i.isRelease&&i.$notify({title:"提示",message:"修改失败!",duration:1500,type:"warning"}),"0"===t&&i.$notify({title:"提示",message:"存入草稿箱失败!",duration:1500,type:"warning"}),"1"===t&&"0"===i.isRelease&&i.$notify({title:"提示",message:"发布失败!",duration:1500,type:"warning"})):("1"===t&&i.$notify({title:"提示",message:"发布失败!",duration:1500,type:"warning"}),"0"===t&&i.$notify({title:"提示",message:"存入草稿箱失败!",duration:1500,type:"warning"})),i.form="",i.$emit("back",0)})})},saveFn:function(){this.saveData("1","form")},saveDraft:function(){this.saveData("0","form")}}},r=c,d=(i("d1f1"),i("2877")),u=Object(d["a"])(r,s,a,!1,null,"591e9504",null);e["default"]=u.exports},d1f1:function(t,e,i){"use strict";var s=i("67c8"),a=i.n(s);a.a},f8f6:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("el-col",{attrs:{span:18}},[i("el-card",{staticStyle:{height:"calc(98vh - 15px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[i("title-card",{attrs:{"title-text":"草稿箱列表"}}),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}}),t._v(" "),t.draftList.length>0?i("div",[i("p",{staticClass:"checkAll"},[i("input",{directives:[{name:"model",rawName:"v-model",value:t.checked,expression:"checked"}],staticStyle:{"margin-right":"10px"},attrs:{type:"checkbox"},domProps:{checked:Array.isArray(t.checked)?t._i(t.checked,null)>-1:t.checked},on:{click:t.checkAll,change:function(e){var i=t.checked,s=e.target,a=!!s.checked;if(Array.isArray(i)){var n=null,l=t._i(i,n);s.checked?l<0&&(t.checked=i.concat([n])):l>-1&&(t.checked=i.slice(0,l).concat(i.slice(l+1)))}else t.checked=a}}}),t._v(" "),i("span",[t._v("全选")]),t._v(" "),i("span",{staticClass:"delData",on:{click:t.del}},[t._v("删除草稿")])]),t._v(" "),i("ul",{staticStyle:{margin:"0",padding:"0"}},t._l(t.draftList,function(e,s){return i("li",{key:s,staticClass:"draftList borTop"},[i("p",{staticStyle:{flex:"3","text-align":"left",color:"#333"}},[i("input",{directives:[{name:"model",rawName:"v-model",value:t.checkModel,expression:"checkModel"}],staticStyle:{"margin-right":"10px"},attrs:{type:"checkbox",name:"signUp"},domProps:{value:e.id,checked:Array.isArray(t.checkModel)?t._i(t.checkModel,e.id)>-1:t.checkModel},on:{change:function(i){var s=t.checkModel,a=i.target,n=!!a.checked;if(Array.isArray(s)){var l=e.id,o=t._i(s,l);a.checked?o<0&&(t.checkModel=s.concat([l])):o>-1&&(t.checkModel=s.slice(0,o).concat(s.slice(o+1)))}else t.checkModel=n}}}),t._v(" "),i("span",{staticStyle:{cursor:"pointer"},on:{click:function(i){return t.toDetail(e)}}},[t._v(t._s(e.title))])]),t._v(" "),i("p",{staticStyle:{flex:"3","text-align":"center",color:"#999"}},[t._v(t._s(e.newsType))]),t._v(" "),i("p",{staticStyle:{flex:"3","text-align":"right",color:"#999"}},[t._v(t._s(e.releaseDate))])])}),0)]):i("div",{staticStyle:{"text-align":"center",padding:"20px 0",color:"#666666"}},[t._v("暂无数据")]),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.addDraft}})],1)],1)],1)},a=[],n=(i("ac6a"),i("aa2a")),l=i("35b7"),o=i("333d"),c={components:{Pagination:o["a"],TitleCard:l["a"]},data:function(){return{infoList:[],total:0,listQuery:{page:1,pagesize:10},isLoading:!0,draftList:[],checked:!1,checkModel:[],viewId:""}},watch:{checkModel:function(){this.checkModel.length===this.draftList.length?this.checked=!0:this.checked=!1}},created:function(){this.addDraft()},methods:{addDraft:function(){var t=this;Object(n["h"])(this.listQuery).then(function(e){t.draftList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},1)})},backFn:function(){this.$emit("back",0)},checkAll:function(){var t=this;this.checked?this.checkModel=[]:this.draftList.forEach(function(e){-1===t.checkModel.indexOf(e.id)&&t.checkModel.push(e.id)})},del:function(){var t=this;this.checkModel.length<1?this.$notify({title:"提示",message:"请选择要删除的数据!",duration:1500,type:"warning"}):Object(n["b"])({ids:this.checkModel.join(",")}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"删除成功!",duration:1500,type:"success"}),t.checkModel=[],t.addDraft()):t.$notify({title:"提示",message:"删除失败!",duration:1500,type:"warning"})})},toDetail:function(t){this.viewId=t.id,this.isEdit=t.isEdit,this.isDelete=t.isDelete,this.$emit("back",2,this.viewId)}}},r=c,d=(i("9856"),i("2877")),u=Object(d["a"])(r,s,a,!1,null,"9cb08954",null);e["default"]=u.exports},f90a:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("el-col",{attrs:{span:18}},[i("el-card",{staticStyle:{height:"calc(98vh - 15px)",position:"relative"},attrs:{"body-style":{padding:"0px 10px"}}},[i("div",{staticClass:"addTitle1"},[i("span"),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),i("div",[i("div",{staticClass:"newsTitle"},[t._v(t._s(t.title))]),t._v(" "),i("div",{staticClass:"container"},[i("div",{staticClass:"releaseDate"},[t._v(t._s(t.releaseDate))]),t._v(" "),i("div",{staticStyle:{color:"#3377FF",cursor:"pointer","font-size":"14px",flex:"1","text-align":"right"}},[i("span",{directives:[{name:"show",rawName:"v-show",value:"0"!=t.isRelease&&"1"===t.adminFlag,expression:"isRelease!='0' && adminFlag==='1'"}],on:{click:t.toTop}},[t._v(t._s(t.isTop?"取消置顶":"置顶"))]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"0"===t.isRelease||t.isEdit&&"1"===t.isEdit,expression:"isRelease==='0'||(isEdit && isEdit==='1')"}],staticClass:"ma-l_15",on:{click:t.editorFn}},[t._v("编辑")]),t._v(" "),i("span",{directives:[{name:"show",rawName:"v-show",value:"0"===t.isRelease||t.isDelete&&"1"===t.isDelete,expression:"isRelease==='0'||(isDelete && isDelete==='1')"}],staticClass:"ma-l_15",on:{click:t.deleteFn}},[t._v("删除")])])]),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("div",{staticClass:"contentEle",domProps:{innerHTML:t._s(t.content)}})])],1)],1)],1),t._v(" "),i("div",{staticStyle:{"text-align":"right",position:"absolute",bottom:"50px",right:"30px"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:t.preId&&"no"!==t.preId,expression:"preId && preId !== 'no'"}],attrs:{size:"mini"},on:{click:t.lastInfo}},[t._v("上一篇")]),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:t.sufId&&"no"!==t.sufId,expression:"sufId && sufId !== 'no'"}],attrs:{size:"mini"},on:{click:t.nextInfo}},[t._v("下一篇")])],1)])],1)],1)},a=[],n=i("aa2a"),l={components:{},props:{id:{type:String,default:""},isEdit:{type:String,default:""},isDelete:{type:String,default:""}},data:function(){return{title:"",newsType:"",content:"",hits:"",releaseDept:"",isTop:"",releaseDate:"",releaseUser:"",preId:"",sufId:"",isRelease:"",adminFlag:this.$store.state.user.userInfo.adminFlag}},created:function(){this.getDetails(this.id)},methods:{getDetails:function(t){var e=this;Object(n["e"])({id:t}).then(function(t){var i=t.data.xlglNews,s=i.title,a=i.newsType,n=i.isTop,l=i.content,o=i.hits,c=i.isRelease,r=i.releaseDept,d=i.releaseDate,u=i.releaseUser,p=i.preId,h=i.sufId;Object.assign(e,{title:s,newsType:a,isTop:n,content:l,hits:o,isRelease:c,releaseDept:r,releaseDate:d,releaseUser:u,preId:p,sufId:h})})},backFn:function(){this.$emit("back")},toTop:function(){var t=this;this.isTop?Object(n["k"])({id:this.id}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"取消置顶成功!",duration:1500,type:"success"}),t.$emit("back")):(t.$notify({title:"提示",message:"取消置顶失败!",duration:1500,type:"warning"}),t.$emit("back"))}):Object(n["j"])({id:this.id}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"置顶成功!",duration:1500,type:"success"}),t.$emit("back")):(t.$notify({title:"提示",message:"置顶失败!",duration:1500,type:"warning"}),t.$emit("back"))})},editorFn:function(){this.$emit("back",this.id)},deleteFn:function(){var t=this;Object(n["b"])({ids:this.id}).then(function(e){"success"===e.data.result?(t.$notify({title:"提示",message:"删除成功!",duration:1500,type:"success"}),t.$emit("back")):(t.$notify({title:"提示",message:"删除失败!",duration:1500,type:"warning"}),t.$emit("back"))})},lastInfo:function(){this.getDetails(this.preId)},nextInfo:function(){this.getDetails(this.sufId)}}},o=l,c=(i("61e2"),i("3e58"),i("2877")),r=Object(c["a"])(o,s,a,!1,null,"6a11e157",null);e["default"]=r.exports}}]);