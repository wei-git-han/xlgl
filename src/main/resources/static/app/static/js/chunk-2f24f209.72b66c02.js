(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2f24f209","chunk-4668715a","chunk-705a514e","chunk-c58d2fb8"],{"1ef6":function(t,e,a){"use strict";var s=a("9ba0"),i=a.n(s);i.a},"29fb":function(t,e,a){"use strict";var s=a("563c"),i=a.n(s);i.a},"2f75":function(t,e,a){},"4ae2":function(t,e,a){},"4b268":function(t,e,a){"use strict";var s=a("2f75"),i=a.n(s);i.a},"563c":function(t,e,a){},"7c64":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[t.showList?a("div",{staticClass:"listPage"},[a("el-row",{attrs:{gutter:20}},[0==t.isFlag?a("el-col",{staticClass:"borderSty",staticStyle:{position:"relative"},attrs:{span:18}},[a("el-tabs",{directives:[{name:"loading",rawName:"v-loading",value:t.isLoading,expression:"isLoading"}],on:{"tab-click":t.handleClick},model:{value:t.editableTabsValue,callback:function(e){t.editableTabsValue=e},expression:"editableTabsValue"}},t._l(t.tabsList,function(e,s){return a("el-tab-pane",{key:s,attrs:{label:e.title,name:e.name}},[a("div",{staticStyle:{"text-align":"left"}},[a("el-dropdown",{attrs:{size:"small","split-button":"",type:"info"},on:{command:t.handleCommand}},[t._v("\n                "+t._s(t.command)+"\n                "),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",{attrs:{command:"发布时间"}},[t._v("发布时间")]),t._v(" "),a("el-dropdown-item",{attrs:{command:"热度"}},[t._v("热度")]),t._v(" "),a("el-dropdown-item",{attrs:{command:"发布单位"}},[t._v("发布单位")])],1)],1)],1),t._v(" "),t.infoList.length>0?a("div",t._l(t.infoList,function(e,s){return a("el-row",{key:s,staticClass:"grid-content bg-purple divSty",attrs:{gutter:20}},[a("div",{staticStyle:{width:"290px",height:"160px"}},[a("img",{attrs:{src:e.picturePath,alt:"",width:"100%",height:"100%"}})]),t._v(" "),a("el-col",{attrs:{span:18}},[a("div",{staticStyle:{"margin-left":"20px"}},[a("div",{staticClass:"title"},[a("span",{staticStyle:{cursor:"pointer"},on:{click:function(a){return t.toDetail(e.id)}}},[t._v(t._s(e.title))]),t._v(" "),e.isTop?a("span",{staticClass:"topSty"},[t._v("置顶")]):t._e()]),t._v(" "),a("div",{staticClass:"content",attrs:{title:e.content},domProps:{innerHTML:t._s(e.content)}}),t._v(" "),a("div",{staticClass:"tally",staticStyle:{display:"flex","flex-direction":"row","justify-content":"space-between"}},[a("div",{staticStyle:{color:"#666666"}},[a("span",[t._v(t._s(e.releaseDept))]),t._v(" "),a("span",{staticClass:"ma-l_40"},[t._v(t._s(e.releaseDate))]),t._v(" "),a("span",{staticClass:"ma-l_40"},[t._v(t._s(e.hits?e.hits:0)+"浏览")])]),t._v(" "),a("div",{staticStyle:{color:"#3377FF",cursor:"pointer","font-size":"14px"}},[a("span",{on:{click:function(a){return t.isTop(e)}}},[t._v(t._s(e.isTop?"取消置顶":"置顶"))]),t._v(" "),a("span",{staticClass:"ma-l_15",on:{click:function(a){return t.editorFn(e.id)}}},[t._v("编辑")]),t._v(" "),a("span",{staticClass:"ma-l_15",on:{click:function(a){return t.deleteFn(e.id)}}},[t._v("删除")])])])])])],1)}),1):a("div",{staticStyle:{"text-align":"center",padding:"20px 0",color:"#666666"}},[t._v("暂无数据")])])}),1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.getDataList}}),t._v(" "),a("div",{staticStyle:{position:"absolute",right:"20px",top:"4px"}},[a("el-button",{staticClass:"addBtn noBorder",attrs:{type:"success",size:"small",icon:"el-icon-plus"},on:{click:function(e){t.showList=!t.showList}}},[t._v("增加")]),t._v(" "),a("el-button",{staticClass:"addBtn noBorder",attrs:{type:"primary",size:"small",icon:"el-icon-edit"},on:{click:t.toDraft}},[t._v("草稿箱")])],1)],1):t._e(),t._v(" "),1==t.isFlag?a("draftPage",{on:{back:t.viewBack}}):t._e(),t._v(" "),2==t.isFlag?a("detailPage",{attrs:{id:t.viewId},on:{back:t.viewBack}}):t._e(),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-row",[a("el-col",{attrs:{span:24}},[a("div",{staticClass:"div2"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("新闻发布数")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本年度全局新闻统计")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"50px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.totalYear))])]),t._v(" "),a("div",{staticClass:"div2"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benyue"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("本月发布动态")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本月全局动态统计")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"50px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.totalMonth))])]),t._v(" "),a("div",{staticClass:"div2"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"benzhou"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("本周发布动态")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("本日全局动态统计")])])],1),t._v(" "),a("div",{staticStyle:{color:"#2280E5","font-size":"50px","font-family":"DINCondensed-Bold"}},[t._v(t._s(t.totalWeek))])])]),t._v(" "),a("el-col",{staticClass:"borderSty",attrs:{span:24}},[a("div",{staticClass:"div1"},[t._v("\n              各单位发布统计\n              "),a("el-dropdown",{attrs:{size:"mini","split-button":"",type:"info"},on:{command:t.handleCommandDate}},[t._v("\n                "+t._s(t.COMMAND_LIST[t.commandDate])+"\n                "),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",{attrs:{command:"year"}},[t._v("本年")]),t._v(" "),a("el-dropdown-item",{attrs:{command:"month"}},[t._v("本月")]),t._v(" "),a("el-dropdown-item",{attrs:{command:"week"}},[t._v("本周")])],1)],1)],1),t._v(" "),a("div",[a("ul",{staticClass:"ulSty"},t._l(t.departList,function(e,s){return a("li",{key:s},[a("el-row",[a("el-col",{attrs:{span:12}},[t._v(t._s(e.releaseOrgan))]),t._v(" "),a("el-col",{attrs:{span:6}},[t._v(t._s(e.nums)+"条")]),t._v(" "),a("el-col",{staticStyle:{"text-align":"right"},attrs:{span:6}},[a("a",{staticClass:"normal_a",class:{isWatch:e.isWatch},attrs:{href:""}},[t._v("查看")])])],1)],1)}),0)])])],1)],1)],1)],1):t._e(),t._v(" "),t.showList?t._e():a("addPage",{attrs:{flag:t.editorFlag,id:t.id},on:{back:t.addBack}})],1)},i=[],n=(a("c5f6"),a("aa2a")),l=a("333d"),o=a("af91"),c=a("f8f6"),r=a("f90a"),d={name:"ComplexTable",components:{Pagination:l["a"],addPage:o["default"],draftPage:c["default"],detailPage:r["default"]},data:function(){return{editableTabsValue:"1",commandDate:"month",totalYear:"",totalMonth:"",totalWeek:"",departList:[],otherList:[],COMMAND_LIST:{year:"本年",month:"本月",week:"本周"},listQuery:{page:1,pagesize:10},tabsList:[{title:"上级工作动态",name:"1"},{title:"机关部队训练风采",name:"2"},{title:"安全管理",name:"3"}],tabIndex:0,isLoading:!1,total:0,isFlag:0,showList:!0,viewId:null,id:null,command:"排序方式",editorFlag:0,infoList:[]}},created:function(){this.$route.query.id&&(this.isFlag=2,this.viewId=this.$route.query.id),this.getQueryTotal(this.commandDate),this.getDataList(this.tabIndex)},methods:{handleCommandDate:function(t){this.commandDate=t,this.getQueryTotal(this.commandDate)},handleClick:function(t){this.tabIndex=Number(t.index),this.getDataList()},getDataList:function(){var t=this;0===this.tabIndex?this.listQuery.type="上级工作动态":1===this.tabIndex?this.listQuery.type="机关部队训练风采":this.listQuery.type="安全管理",this.isLoading=!0,this.infoList=[],Object(n["a"])(this.listQuery).then(function(e){t.infoList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},500)})},getQueryTotal:function(t){var e=this;Object(n["e"])({type:t}).then(function(a){e.totalYear=a.data.totalYear,e.totalMonth=a.data.totalMonth,e.totalWeek=a.data.totalWeek,e.departList="year"===t?a.data.totalYearByOrgan:"month"===t?a.data.totalMonthByOrgan:a.data.totalWeekByOrgan})},isTop:function(t){var e=this;t.isTop?Object(n["i"])({id:t.id}).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"取消置顶成功!"}),e.getDataList()):e.$message({type:"info",message:"取消置顶失败!"})}):Object(n["h"])({id:t.id}).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"置顶成功!"}),e.getDataList()):e.$message({type:"info",message:"置顶失败!"})})},deleteFn:function(t){var e=this;Object(n["b"])({ids:t}).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"删除成功!"}),e.getDataList()):e.$message({type:"info",message:"删除失败!"})})},editorFn:function(t){this.id=t,this.showList=!this.showList,this.editorFlag=1},toDetail:function(t){this.viewId=t,this.isFlag=2},toDraft:function(){this.isFlag=1},viewBack:function(){this.isFlag=0,this.getDataList()},addBack:function(){this.showList=!this.showList,this.getDataList()},handleCommand:function(t){this.command=t}}},p=d,u=(a("29fb"),a("2877")),f=Object(u["a"])(p,s,i,!1,null,"e5b48422",null);e["default"]=f.exports},"9ba0":function(t,e,a){},af91:function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"addPage"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[a("div",{staticClass:"addTitle"},[a("span",[t._v("训管动态新增")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",{staticStyle:{padding:"20px 0"}},[a("el-form",{ref:"form",attrs:{model:t.form,"label-width":"150px"}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"动态类型",prop:"newsType",required:""}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.newsType,callback:function(e){t.$set(t.form,"newsType",e)},expression:"form.newsType"}},[a("el-option",{attrs:{label:"上级工作动态",value:"上级工作动态"}}),t._v(" "),a("el-option",{attrs:{label:"机关部队训练风采",value:"机关部队训练风采"}}),t._v(" "),a("el-option",{attrs:{label:"安全管理",value:"安全管理"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"发布单位",required:""}},[a("el-input",{attrs:{disabled:""},model:{value:t.form.deptName,callback:function(e){t.$set(t.form,"deptName",e)},expression:"form.deptName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"动态标题",required:""}},[a("el-input",{model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{staticStyle:{width:"100%"},attrs:{label:"发布时间"}},[a("el-date-picker",{attrs:{type:"datetime",format:"yyyy-MM-dd HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择发布时间"},on:{change:t.getsTime},model:{value:t.form.createDate,callback:function(e){t.$set(t.form,"createDate",e)},expression:"form.createDate"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"编辑内容"}},[a("ueditor",{model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"上传封面"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4,.png,.jpeg",drag:"",action:t.fileUrl,data:t.form,limit:1,"on-success":t.uploadImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                  将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4/.png/.jpeg等文件格式")])])])],1)],1)],1)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[a("el-button",{attrs:{type:"success"},on:{click:t.saveFn}},[t._v("发布")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.saveDraft}},[t._v("存草稿")])],1)],1)],1)],1)},i=[],n=(a("c5f6"),a("aa2a")),l=a("63f4"),o={components:{Ueditor:l["a"]},props:{flag:{type:Number,default:0},id:{type:String,default:""}},data:function(){return{form:{title:"",newsType:"",createDate:"",picturePath:"",content:"",deptName:""},fileUrl:"/app/xlgl/xlglnotice/saveOrUpdate"}},created:function(){this.getDeptName(),1===this.flag&&this.getDetails()},methods:{getDeptName:function(){var t=this;Object(n["c"])().then(function(e){t.form.deptName=e.data.deptName})},getDetails:function(){var t=this;Object(n["d"])({id:this.id}).then(function(e){t.form.title=e.data.xlglNews.title,t.form.newsType=e.data.xlglNews.newsType,t.form.content=e.data.xlglNews.content,t.form.createDate=e.data.xlglNews.releaseDate})},backFn:function(){this.$emit("back")},uploadImg:function(t,e){this.form.picturePath="/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.fileId},getsTime:function(t){this.form.createDate=t},saveData:function(t){var e=this;this.form.newsType?this.form.title?(this.form.isRelease=t,this.form.id=this.id,Object(n["g"])(this.form).then(function(t){"success"===t.data.result?(e.$message({type:"success",message:"发布成功!"}),e.form="",e.$emit("back")):(e.$message({type:"info",message:"发布失败!"}),e.form="",e.$emit("back"))})):this.$message({message:"请输入动态标题",type:"info"}):this.$message({message:"请选择动态类型",type:"info"})},saveFn:function(){this.saveData(1)},saveDraft:function(){this.saveData(0)}}},c=o,r=(a("4b268"),a("2877")),d=Object(r["a"])(c,s,i,!1,null,"fd62eb38",null);e["default"]=d.exports},ea56:function(t,e,a){"use strict";var s=a("4ae2"),i=a.n(s);i.a},f8f6:function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-col",{staticClass:"borderSty",attrs:{span:18}},[a("div",{staticClass:"addTitle"},[a("span",[t._v("草稿箱列表")]),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",[a("p",{staticClass:"checkAll"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.checked,expression:"checked"}],staticStyle:{"margin-right":"10px"},attrs:{type:"checkbox"},domProps:{checked:Array.isArray(t.checked)?t._i(t.checked,null)>-1:t.checked},on:{click:t.checkAll,change:function(e){var a=t.checked,s=e.target,i=!!s.checked;if(Array.isArray(a)){var n=null,l=t._i(a,n);s.checked?l<0&&(t.checked=a.concat([n])):l>-1&&(t.checked=a.slice(0,l).concat(a.slice(l+1)))}else t.checked=i}}}),t._v(" "),a("span",[t._v("全选")]),t._v(" "),a("span",{staticClass:"delData",on:{click:t.del}},[t._v("删除草稿")])]),t._v(" "),a("ul",{staticStyle:{margin:"0",padding:"0"}},t._l(t.draftList,function(e,s){return a("li",{key:s,staticClass:"draftList borTop"},[a("p",{staticStyle:{flex:"3","text-align":"left",color:"#333"}},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.checkModel,expression:"checkModel"}],staticStyle:{"margin-right":"10px"},attrs:{type:"checkbox",name:"signUp"},domProps:{value:e.id,checked:Array.isArray(t.checkModel)?t._i(t.checkModel,e.id)>-1:t.checkModel},on:{change:function(a){var s=t.checkModel,i=a.target,n=!!i.checked;if(Array.isArray(s)){var l=e.id,o=t._i(s,l);i.checked?o<0&&(t.checkModel=s.concat([l])):o>-1&&(t.checkModel=s.slice(0,o).concat(s.slice(o+1)))}else t.checkModel=n}}}),t._v(" "),a("span",[t._v(t._s(e.title))])]),t._v(" "),a("p",{staticStyle:{flex:"3","text-align":"center",color:"#999"}},[t._v(t._s(e.newsType))]),t._v(" "),a("p",{staticStyle:{flex:"3","text-align":"right",color:"#999"}},[t._v(t._s(e.releaseDate))])])}),0)]),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.pagesize},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"pagesize",e)},pagination:t.addDraft}})],1)],1)},i=[],n=(a("ac6a"),a("aa2a")),l=a("333d"),o={components:{Pagination:l["a"]},data:function(){return{infoList:[],total:0,listQuery:{page:1,pagesize:10},isLoading:!0,draftList:[],checked:!1,checkModel:[]}},created:function(){this.addDraft()},watch:{checkModel:function(){this.checkModel.length===this.draftList.length?this.checked=!0:this.checked=!1}},methods:{addDraft:function(){var t=this;Object(n["f"])(this.listQuery).then(function(e){t.draftList=e.data.rows,t.total=e.data.total,setTimeout(function(){t.isLoading=!1},1500)})},backFn:function(){this.$emit("back")},checkAll:function(){var t=this;this.checked?this.checkModel=[]:this.draftList.forEach(function(e){-1===t.checkModel.indexOf(e.id)&&t.checkModel.push(e.id)})},del:function(){var t=this;this.checkModel.length<1?this.$message({type:"info",message:"请选择要删除的数据!"}):Object(n["b"])({ids:this.checkModel.join(",")}).then(function(e){"success"===e.data.result?(t.$message({type:"success",message:"删除成功!"}),t.checkModel=[],t.addDraft()):t.$message({type:"info",message:"删除失败!"})})}}},c=o,r=(a("ea56"),a("2877")),d=Object(r["a"])(c,s,i,!1,null,"5d481c87",null);e["default"]=d.exports},f90a:function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-col",{staticClass:"borderSty",attrs:{span:18}},[a("div",{staticClass:"addTitle"},[a("span"),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),a("div",[a("div",{staticStyle:{"text-align":"center","font-size":"20px",color:"#333"}},[t._v(t._s(t.title))]),t._v(" "),a("div",{staticClass:"container"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("p",{staticStyle:{"margin-left":"20px"}},[a("span",{staticStyle:{color:"#666"}},[t._v("动态类型：")]),t._v(" "),a("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.newsType))])]),t._v(" "),a("p",{staticStyle:{"margin-left":"20px"}},[a("span",{staticStyle:{color:"#666"}},[t._v("发布单位：")]),t._v(" "),a("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.releaseDept))])]),t._v(" "),a("p",{staticStyle:{"margin-left":"20px"}},[a("span",{staticStyle:{color:"#666"}},[t._v("发布时间：")]),t._v(" "),a("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.releaseDate))])]),t._v(" "),a("p",{staticStyle:{"margin-left":"20px"}},[a("span",{staticStyle:{color:"#666"}},[t._v("已阅人数：")]),t._v(" "),a("span",{staticStyle:{color:"#333"}},[t._v(t._s(t.hits)+"人")])])]),t._v(" "),a("div",{staticStyle:{color:"#3377FF",cursor:"pointer","font-size":"14px"}},[a("span",{on:{click:function(e){return t.toTop()}}},[t._v(t._s(t.isTop?"取消置顶":"置顶"))]),t._v(" "),a("span",{staticClass:"ma-l_15",on:{click:function(e){return t.editorFn()}}},[t._v("编辑")]),t._v(" "),a("span",{staticClass:"ma-l_15",on:{click:function(e){return t.deleteFn()}}},[t._v("删除")])])]),t._v(" "),a("div",{staticClass:"content",domProps:{innerHTML:t._s(t.content)}})])])],1)},i=[],n=a("aa2a"),l={components:{},props:{id:{type:String,default:""}},data:function(){return{title:"",newsType:"",content:"",hits:"",releaseDept:"",isTop:"",releaseDate:""}},created:function(){this.getDetails()},methods:{getDetails:function(){var t=this;Object(n["d"])({id:this.id}).then(function(e){t.title=e.data.xlglNews.title,t.newsType=e.data.xlglNews.newsType,t.isTop=e.data.xlglNews.isTop,t.content=e.data.xlglNews.content,t.hits=e.data.xlglNews.hits,t.releaseDept=e.data.xlglNews.releaseDept,t.releaseDate=e.data.xlglNews.releaseDate})},backFn:function(){this.$emit("back")},toTop:function(){var t=this;this.isTop?Object(n["i"])({id:this.id}).then(function(e){"success"===e.data.result?(t.$message({type:"success",message:"取消置顶成功!"}),t.$emit("back")):(t.$message({type:"info",message:"取消置顶失败!"}),t.$emit("back"))}):Object(n["h"])({id:this.id}).then(function(e){"success"===e.data.result?(t.$message({type:"success",message:"置顶成功!"}),t.$emit("back")):(t.$message({type:"info",message:"置顶失败!"}),t.$emit("back"))})},editorFn:function(){},deleteFn:function(){var t=this;Object(n["b"])({ids:this.id}).then(function(e){"success"===e.data.result?(t.$message({type:"success",message:"删除成功!"}),t.$emit("back")):(t.$message({type:"info",message:"删除失败!"}),t.$emit("back"))})}}},o=l,c=(a("1ef6"),a("2877")),r=Object(c["a"])(o,s,i,!1,null,"7b3bc4f3",null);e["default"]=r.exports}}]);