(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7fa3cc4a"],{"0538":function(t,e,i){},"19cd":function(t,e,i){},"20db":function(t,e,i){"use strict";var a=i("0538"),s=i.n(a);s.a},"5ab4":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content",staticStyle:{height:"100%"}},[0===t.isShow?i("div",{staticStyle:{position:"relative",padding:"0 10px"}},[i("el-tabs",{on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{attrs:{label:"视频教学",name:"first"}},[i("div",[i("div",{staticClass:"search-content"},[i("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"请输入训练名称"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.search(e)}},model:{value:t.listQuery.title,callback:function(e){t.$set(t.listQuery,"title",e)},expression:"listQuery.title"}}),t._v(" "),i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")])],1)]),t._v(" "),i("el-row",[i("el-col",{staticClass:"elColStyle",attrs:{span:24}},[i("el-scrollbar",{staticClass:"hidden-x"},[i("el-row",{attrs:{gutter:20}},[i("div",{staticClass:"videoList"},t._l(t.videoList,function(e,a){return i("div",{key:a,staticClass:"videoCard",on:{click:function(i){return t.toDetial(e)}}},[i("span",{class:["learnLabel","1"===e.readStatus?"bg_active":"bg_default"]},[t._v(t._s("1"===e.readStatus?"已学习":"待学习"))]),t._v(" "),i("div",{staticStyle:{position:"relative",width:"100%",height:"170px"}},[e.videoFile?i("video",{staticClass:"imgStyle",staticStyle:{"object-fit":"fill"},attrs:{controls:"controls"}},[i("source",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.videoFile}})]):e.coverFile?i("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}}):i("svg-icon",{staticClass:"icon imgStyle",attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),i("p",{staticClass:"cardTitle",attrs:{title:e.tacticTitle}},[t._v(t._s(e.tacticTitle))]),t._v(" "),i("p",{staticStyle:{color:"#99A6BF",padding:"0 10px"}},[t._v(t._s(e.viewNumber)+"次浏览")])])}),0)])],1)],1)],1),t._v(" "),i("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getSportsList}})],1),t._v(" "),i("el-tab-pane",{attrs:{label:"军事体育成绩评定",name:"second"}},[i("el-row",[i("el-col",{attrs:{span:18}},[i("div",{staticClass:"flex-center",staticStyle:{padding:"0 60px 0 20px"}},[i("div",[i("span",[t._v("体型分数")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t._f("floatFilter")(t.form.tscore)))])]),t._v(" "),i("div",[i("span",[t._v("体型评定")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t.form.judge))])]),t._v(" "),i("div",[i("span",[t._v("军事体育成绩")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t.form.allScore))])]),t._v(" "),i("div",[i("span",[t._v("体育等级评定")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t.form.allJudge))])])]),t._v(" "),i("el-form",{ref:"form",staticStyle:{"margin-top":"30px"},attrs:{rules:t.rules,model:t.form,"label-width":"150px"}},[i("el-row",[i("el-col",{attrs:{span:20}},[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"姓名",required:""}},[i("el-input",{attrs:{disabled:""},model:{value:t.userName,callback:function(e){t.userName=e},expression:"userName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"身份证号",prop:"idCard"}},[i("el-input",{attrs:{maxlength:"18"},model:{value:t.form.idCard,callback:function(e){t.$set(t.form,"idCard",e)},expression:"form.idCard"}})],1)],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:10}},[i("el-col",{attrs:{span:10}},[i("div",{staticClass:"txIcon"},[i("span",[t._v("体型信息录入")])])]),t._v(" "),i("el-col",{attrs:{span:10}},[i("div",{staticStyle:{display:"flex","align-items":"center"}},[i("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),i("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看体型标准",1)}}},[t._v("查看体型标准")]),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag === '1'"}],staticStyle:{"margin-left":"15px"},attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.changeFileFn(1)}}},[t._v("上传文件")])],1)])],1)],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"10px"}},[i("el-col",{attrs:{span:20}},[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"性别",prop:"sex"}},[i("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changeSex},model:{value:t.form.sex,callback:function(e){t.$set(t.form,"sex",e)},expression:"form.sex"}},[i("el-option",{attrs:{label:"男",value:"0"}}),t._v(" "),i("el-option",{attrs:{label:"女",value:"1"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"身高",prop:"high"}},[i("el-input",{attrs:{placeholder:"请输入"},model:{value:t.form.high,callback:function(e){t.$set(t.form,"high",e)},expression:"form.high"}},[i("template",{slot:"append"},[t._v("米")])],2)],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"类型",prop:"type"}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},[i("el-option",{attrs:{label:"一类人员",value:"1"}}),t._v(" "),i("el-option",{attrs:{label:"二类人员",value:"2"}}),t._v(" "),i("el-option",{attrs:{label:"三类人员",value:"3"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"体重",prop:"wight"}},[i("el-input",{attrs:{placeholder:"请输入"},model:{value:t.form.wight,callback:function(e){t.$set(t.form,"wight",e)},expression:"form.wight"}},[i("template",{slot:"append"},[t._v("Kg")])],2)],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"出生年月",prop:"birthday"}},[i("el-date-picker",{attrs:{type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择","picker-options":t.pickOptionStart},on:{change:t.getVal},model:{value:t.form.birthday,callback:function(e){t.$set(t.form,"birthday",e)},expression:"form.birthday"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"年龄",prop:"age"}},[i("el-input",{attrs:{disabled:""},model:{value:t.form.age,callback:function(e){t.$set(t.form,"age",e)},expression:"form.age"}})],1)],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:10}},[i("el-col",{attrs:{span:10}},[i("div",{staticClass:"kmIcon"},[i("span",[t._v("科目成绩录入")])])]),t._v(" "),i("el-col",{attrs:{span:10}},[i("div",{staticStyle:{display:"flex","align-items":"center"}},[i("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),i("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看训练标准",2)}}},[t._v("查看训练标准")]),t._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag === '1'"}],staticStyle:{"margin-left":"15px"},attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.changeFileFn(2)}}},[t._v("上传文件")])],1)])],1)],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"15px"}},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:t.labelText,prop:"ytxs"}},[i("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.ytxs,callback:function(e){t.$set(t.form,"ytxs",e)},expression:"form.ytxs"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[i("span",[t._v("次")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.up))]),t._v("分\n                    ")])])],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"5px"}},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"仰卧起坐",prop:"ywqz"}},[i("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.ywqz,callback:function(e){t.$set(t.form,"ywqz",e)},expression:"form.ywqz"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[i("span",[t._v("次")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.sit))]),t._v("分\n                    ")])])],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"5px"}},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"30米 * 2蛇形跑",prop:"sxp"}},[i("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.sxp,callback:function(e){t.$set(t.form,"sxp",e)},expression:"form.sxp"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[i("span",[t._v("秒")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.srun))]),t._v("分\n                    ")])])],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"5px"}},[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"3000米长跑",prop:"cpf"}},[i("el-col",{attrs:{span:18}},[i("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.cpf,callback:function(e){t.$set(t.form,"cpf",e)},expression:"form.cpf"}})],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:4}},[i("span",[t._v("分")])])],1)],1),t._v(" "),i("el-col",{attrs:{span:2}},[i("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.cpm,callback:function(e){t.$set(t.form,"cpm",e)},expression:"form.cpm"}})],1),t._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[i("span",[t._v("秒")]),t._v(" "),i("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.trun))]),t._v("分\n                    ")])])],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:6}},[i("div",{staticClass:"bor_b flex-center"},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[i("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),i("p",{staticStyle:{"margin-left":"10px"}},[i("span",[t._v("历史评定")]),i("br"),t._v(" "),i("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("数据统计")])])],1),t._v(" "),i("div",{staticStyle:{color:"#2280E5","font-size":"18px","font-family":"DINCondensed-Bold",cursor:"pointer"},on:{click:t.showView}},[t._v("更多>")])]),t._v(" "),t._l(t.resultList,function(e,a){return i("div",{key:a,staticStyle:{margin:"15px 0"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:2}},[i("span",[t._v(t._s(a+1))])]),t._v(" "),i("el-col",{attrs:{span:6}},[i("span",{staticClass:"color_green"},[t._v(t._s(e.allJudge))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:10}},[i("span",[t._v(t._s(e.createdTime))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",{staticClass:"color_red",staticStyle:{cursor:"pointer"},on:{click:function(i){return t.deleteData(e)}}},[t._v("删除")])])],1)],1)})],2)],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center","margin-top":"20px"},attrs:{span:24}},[i("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.saveData("form")}}},[t._v("保存")]),t._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},on:{click:t.resetFn}},[t._v("重置")])],1)],1)],1),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:0===t.tabIndex,expression:"tabIndex===0"}],staticStyle:{position:"absolute",right:"10px",top:"4px"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager,expression:"isManager==='1'"}],staticClass:"addBtn noBorder",attrs:{type:"success",size:"small",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("新增")])],1)],1):t._e(),t._v(" "),2===t.isShow?i("militaryAdd",{attrs:{id:t.fileId},on:{back:t.backList}}):t._e(),t._v(" "),3===t.isShow?i("militaryView",{attrs:{id:t.fileId,"is-manager":t.isManager},on:{back:t.backList}}):t._e(),t._v(" "),1===t.isShow?i("sportHistory",{on:{back:t.backList}}):t._e(),t._v(" "),i("el-dialog",{attrs:{title:t.fileTitle,visible:t.showDialog},on:{"update:visible":function(e){t.showDialog=e},close:t.resetTemp}},[t.newFileId&&!t.reload?i("frame-pdf",{staticStyle:{height:"400px"},attrs:{"file-id":t.newFileId}}):t._e()],1),t._v(" "),i("el-dialog",{staticClass:"cjfx",attrs:{title:t.fileTitle,visible:t.showDialog1,width:"20%"},on:{"update:visible":function(e){t.showDialog1=e}}},[i("div",{staticStyle:{"text-align":"center"}},[i("p",[t._v("\n          您当前成绩排名"),i("span",{staticClass:"redFont"},[t._v(t._s(t.dialogInfo.sort))]),t._v("名\n        ")]),t._v(" "),i("p",[t._v("\n          体重标准为"),i("span",{staticClass:"redFont"},[t._v(t._s(t.dialogInfo.tx))])]),t._v(" "),i("p",[t._v("\n          训练成绩为"),i("span",{staticClass:"redFont"},[t._v(t._s(t.dialogInfo.dj))])])]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary",round:""},on:{click:function(e){t.showDialog1=!1}}},[t._v("知道了")])],1)]),t._v(" "),i("el-dialog",{attrs:{title:t.fileTitle1,visible:t.changeFileStatus},on:{"update:visible":function(e){t.changeFileStatus=e}}},[i("change-file-dialog",{on:{close:function(e){t.changeFileStatus=!1},"upload-success":t.uploadSuccess}})],1)],1)])},s=[],l=(i("55dd"),i("c5f6"),i("333d")),o=i("c1b8"),r=i("ed32"),n=i("c89c"),c=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticStyle:{"min-height":"400px",height:"100%"}},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])},d=[],p={props:{fileId:{type:String,default:""}},data:function(){return{onlineFileUrl:""}},created:function(){this.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+this.fileId+"&access_token="+this.$store.state.user.token}},f=p,u=i("2877"),m=Object(u["a"])(f,c,d,!1,null,"1674d517",null),v=m.exports,g=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",{staticClass:"centerPosition",staticStyle:{"text-align":"center"}},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!0,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile,accept:".pdf"}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),i("em",[t._v("点击上传")])])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","margin-top":"20px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),i("el-button",{on:{click:t.off}},[t._v("取 消")])],1)])},h=[],_={data:function(){return{fileUploadUrl:"/app/xlgl/xlglcarsmanager/uploadFile",fileId:"",fileData:{access_token:this.$store.state.user.token,type:""}}},methods:{off:function(){this.$emit("close")},handleRemove:function(t,e){},handlePreview:function(t){},saveFn:function(){this.$emit("crop-upload-success",this.createImgUrl),this.$refs.upload.clearFiles()},successFile:function(t){this.fileId=t.fileId},submitFile:function(){this.fileId?this.$emit("upload-success",this.fileId):this.$message.error("请上传文件后再点击确定!")},errorFile:function(){this.$message.error("上传失败！请重新上传")}}},x=_,y=Object(u["a"])(x,g,h,!1,null,"ee98289e",null),b=y.exports,S=i("b775");function w(t){return Object(S["a"])({url:"/app/xlgl/xlglwarcommonsportsfile/save",method:"post",data:t})}function F(t){return Object(S["a"])({url:"/app/xlgl/xlglwarcommonsportsfile/listOne",method:"get",params:t})}var k=i("0fe1"),C={components:{Pagination:l["a"],sportHistory:o["default"],militaryAdd:r["default"],militaryView:n["default"],FramePdf:v,ChangeFileDialog:b},filters:{floatFilter:function(t){return t?parseFloat(t).toFixed(2):""}},data:function(){return{listQuery:{page:1,limit:10,title:""},videoList:[],activeName:"first",changeFileStatus:!1,total:0,tabIndex:0,form:{age:"",up:"",sit:"",srun:"",trun:"",sex:"",type:"3",birthday:"",wight:"",high:"",tscore:"",judge:"",allScore:"",allJudge:"",ytxs:"",ywqz:"",sxp:"",cpf:"",cpm:""},rules:{idCard:[{required:!0,message:"请填写身份证号",trigger:"blur"}],sex:[{required:!0,message:"请选择性别",trigger:"change"}],high:[{required:!0,message:"请输入身高",trigger:"blur"}],type:[{required:!0,message:"请选择类型",trigger:"change"}],wight:[{required:!0,message:"请输入体重",trigger:"blur"}],birthday:[{required:!0,message:"请选择出生年月",trigger:"change"}],ytxs:[{required:!0,message:"请输入引体向上次数",trigger:"blur"}],ywqz:[{required:!0,message:"请输入仰卧起坐次数",trigger:"blur"}],sxp:[{required:!0,message:"请输入30米蛇形跑分数",trigger:"blur"}],cpf:[{required:!0,message:"3000米长跑分数",trigger:"blur"}]},resultList:[],fractionList:[{text:"体型分数目",value:"24"},{text:"体型评定",value:"合格"},{text:"军事体育成绩",value:"24"},{text:"体育登记评定",value:"不合格"}],isShow:0,showDialog:!1,fileTitle:"",fileId:"",isManager:"",userName:"",fileTitle1:"成绩分析",showDialog1:!1,newFileId:"",changeFileTitle:"修改体型分析",changeStatus:1,reload:!1,dialogInfo:{sort:"",dj:"",tx:""},curTime:new Date,adminFlag:this.$store.state.user.userInfo.adminFlag,pickOptionStart:{disabledDate:function(t){return t.getTime()>(new Date).getTime()-864e5}},labelText:"引体向上",projectList:["单杠引体向上","俯卧撑","单杠屈臂悬停"]}},watch:{isShow:function(t){0===t&&this.getSportsList()},activeName:function(t){"second"===t?(this.getUserInfo(),this.physicalList()):this.getSportsList()}},created:function(){this.getSportsList(),this.getAuthor()},methods:{getVal:function(t){this.form.age=Number(this.curTime.getFullYear())-Number(t.slice(0,4)),this.refershText()},changeSex:function(){this.refershText()},refershText:function(){""!==this.form.age&&this.form.age<=39&&"0"===this.form.sex&&(this.labelText="单杠引体向上"),""!==this.form.age&&this.form.age>=40&&"0"===this.form.sex&&(this.labelText="俯卧撑"),""!==this.form.age&&this.form.age<=39&&"1"===this.form.sex&&(this.labelText="单杠屈臂悬停"),""!==this.form.age&&this.form.age>=40&&"1"===this.form.sex&&(this.labelText="俯卧撑")},getSportsList:function(){var t=this;Object(k["J"])(this.listQuery).then(function(e){t.videoList=e.data.page.list,t.total=e.data.page.totalCount})},getAuthor:function(){var t=this;Object(k["n"])().then(function(e){t.isManager=e.data})},getUserInfo:function(){var t=this;Object(k["R"])().then(function(e){t.userName=e.data.userName})},physicalList:function(){var t=this;Object(k["ib"])(this.listQuery).then(function(e){t.resultList=e.data.page.list})},search:function(){this.getSportsList()},handleClick:function(t){this.tabIndex=Number(t.index)},addPage:function(){this.isShow=2},showView:function(){this.isShow=1},toDetial:function(t){this.isShow=3,this.fileId=t.id},setVal:function(t){for(var e in t)t[e]=""},showChart:function(){},backList:function(t,e){this.isShow=t,this.fileId=e,this.physicalList()},show_dialog:function(t,e){this.getFileByType(e),this.fileTitle=t},resetTemp:function(){this.newFileId=""},changeFileFn:function(t){2===t&&(this.changeFileTitle="修改训练标准"),this.changeFileStatus=!0,this.changeStatus=t},saveData:function(t){var e=this;this.$refs[t].validate(function(i){if(!i)return!1;Object(k["jb"])(e.form).then(function(i){"success"===i.data.result?(e.dialogInfo.sort=i.data.sort,e.dialogInfo.dj=i.data.dj,e.dialogInfo.tx=i.data.tx,e.showDialog1=!0):e.$message({message:"保存失败",type:"info"}),e.$refs[t].resetFields(),e.setVal(e.form),e.physicalList()})})},resetFn:function(){this.form={},this.$refs.form.resetFields()},countMark:function(t){var e=this;this.$refs[t].validate(function(t){if(!t)return!1;Object(k["L"])(e.form).then(function(t){"success"===t.data.result&&(e.form.up=t.data.shang,e.form.sit=t.data.zuo,e.form.srun=t.data.pao,e.form.trun=t.data.changpao,e.form.tscore=t.data.BMI,e.form.judge=t.data.hg,e.form.allScore=t.data.score,e.form.allJudge=t.data.dj)})})},deleteData:function(t){var e=this;Object(k["gb"])({id:t.id}).then(function(t){"success"===t.data.result?e.$message({message:"删除成功",type:"success"}):e.$message({message:"删除失败",type:"info"}),e.physicalList()})},uploadSuccess:function(t){var e=this;w({fileId:t,fileName:t+".pdf",type:this.changeStatus}).then(function(t){e.$message.success("上传成功！")}),this.changeFileStatus=!1},getFileByType:function(t){var e=this;F({type:t}).then(function(t){e.reload=!0,t.data.fileId?(e.newFileId=t.data.fileId,e.reload=!1,e.showDialog=!0):e.$message({message:"管理员还未上传文件！",type:"info"})})}}},I=C,$=(i("d2c0"),Object(u["a"])(I,a,s,!1,null,"b9f7aae6",null));e["default"]=$.exports},c89c:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"app-content"},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"30px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),i("div",{staticStyle:{padding:"20px"}},[i("div",{staticClass:"header"},[i("div",{staticClass:"title"},[t._v(t._s(t.tacticTitle))]),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("span",[t._v("发布时间：")]),t._v(" "),i("span",[t._v(t._s(t.updateDate))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("发布单位：")]),t._v(" "),i("span",[t._v(t._s(t.createOrganName))])]),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[i("span",[t._v("浏览次数：")]),t._v(" "),i("span",[t._v(t._s(t.viewNumber))])]),t._v(" "),i("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[i("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),i("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),i("div",{staticStyle:{padding:"20px 40px"}},[i("el-col",{attrs:{span:18}},[i("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"flex-start"}},[i("div",{staticStyle:{"margin-top":"16px",width:"115px"}},[t._v("训练内容描述:")]),t._v(" "),i("div",{domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),i("video",{directives:[{name:"show",rawName:"v-show",value:t.videoFile,expression:"videoFile"}],ref:"myVideo",staticStyle:{height:"500px",width:"100%"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoFile,controls:"controls"}})]),t._v(" "),i("el-col",{attrs:{span:6}},[t.coverFile?i("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.coverFile}}):i("svg-icon",{staticClass:"icon imgStyle",attrs:{"icon-class":"zanwushuju"}}),t._v(" "),i("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{width:"70%",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[i("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.fileList,function(e,a){return i("div",{key:a,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(i){return t.downloadFile(e.fileId)}}},[i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),i("span",{staticClass:"pictureName"},[t._v(t._s(e.fileName))])],1)})],2)],1)],1)])],1)])},s=[],l=i("0fe1"),o={props:{id:{type:String,default:""},isManager:{type:String,default:""}},data:function(){return{tacticTitle:"",updateDate:"",viewNumber:"",createOrganName:"",content:"",coverFile:"",videoFile:"",fileList:[],symTime:"",timer:"",videoTime:""}},created:function(){this.getSportsInfo()},mounted:function(){var t=this;this.$refs.myVideo.onplay=function(){t.timer=setInterval(function(){t.videoTime=t.$refs.myVideo.currentTime,t.videoTime-t.symTime>1&&(t.$refs.myVideo.currentTime=t.symTime),t.symTime=t.$refs.myVideo.currentTime},100)},this.$refs.myVideo.onended=function(){t.sportsUpdateRead(),clearInterval(t.timer)}},methods:{getSportsInfo:function(){var t=this;Object(l["I"])({id:this.id}).then(function(e){var i=e.data.xlglWarCommonSports,a=i.tacticTitle,s=i.updateDate,l=i.viewNumber,o=i.createOrganName,r=i.coverFile,n=i.videoFile,c=i.content;Object.assign(t,{tacticTitle:a,updateDate:s,viewNumber:l,createOrganName:o,coverFile:r,videoFile:n,content:c}),t.fileList=e.data.xlglWarCommonSports.accessoryFileArray})},back:function(){this.$emit("back",0)},editor:function(){this.$emit("back",2,this.id)},deleteFn:function(){var t=this;Object(l["xb"])({ids:this.id}).then(function(e){"success"===e.data.msg?t.$message({message:"删除成功",type:"success"}):t.$message({message:"删除失败",type:"info"}),t.back()})},downloadFile:function(t){window.location.href="xlgl/xlgldocumentfile/downLoad?fileId="+t+"&access_token="+this.$store.state.user.token},sportsUpdateRead:function(){Object(l["zb"])({id:this.id}).then(function(t){})}}},r=o,n=(i("cf24"),i("2877")),c=Object(n["a"])(r,a,s,!1,null,"21648a84",null);e["default"]=c.exports},cf24:function(t,e,i){"use strict";var a=i("d549"),s=i.n(a);s.a},d2c0:function(t,e,i){"use strict";var a=i("19cd"),s=i.n(a);s.a},d549:function(t,e,i){},ed32:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",{staticClass:"app-content"},[i("el-row",{attrs:{gutter:20}},[i("el-col",{staticClass:"borderSty",staticStyle:{"padding-bottom":"100px"}},[i("div",{staticClass:"addTitle"},[i("span",{staticStyle:{color:"#333333","font-size":"16px"}},[t._v("新增训练")]),t._v(" "),i("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer","margin-top":"10px"},attrs:{"icon-class":"goback"},on:{click:t.backFn}})],1),t._v(" "),i("div",{staticStyle:{padding:"20px 0"}},[i("el-form",{ref:"form",attrs:{"label-width":"150px"},model:{value:t.form,callback:function(e){t.form=e},expression:"form"}},[i("el-row",[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"训练标题",required:""}},[i("el-input",{model:{value:t.form.tacticTitle,callback:function(e){t.$set(t.form,"tacticTitle",e)},expression:"form.tacticTitle"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:10}},[i("el-form-item",{attrs:{label:"训练内容描述"}},[i("el-col",{attrs:{span:24}},[i("ueditor",{ref:"content",model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}})],1)],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"上传视频"}},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".mp4",limit:1,drag:"",name:"pdf",action:t.fileUrl,"file-list":t.videoList,"on-success":t.uploadVideo,"on-remove":t.removeVideo}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),i("em",[t._v("点击上传")]),t._v(" "),i("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.mp4文件格式")])])])],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"上传封面"}},[i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".png,.jpeg",limit:1,drag:"",name:"pdf",action:t.fileUrl,"file-list":t.imgList,"on-success":t.uploadImg,"on-remove":t.removeImg}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),i("em",[t._v("点击上传")]),t._v(" "),i("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传.png/.jpeg等文件格式")])])])],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"上传附件"}},[i("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:t.fileUrl,name:"pdf","on-success":t.uploadFile,"on-remove":t.removeFile,accept:".word,.ofd,.excel,.docx","file-list":t.fileList,multiple:""}},[i("i",{staticClass:"el-icon-upload"}),t._v(" "),i("div",{staticClass:"el-upload__text"},[t._v("\n                      将文件拖到此处，或"),i("em",[t._v("点击上传")]),t._v(" "),i("div",{staticStyle:{color:"#BBBBBB","font-size":"12px"}},[t._v("注：只能上传word/ppt/excel文件格式")])])])],1)],1)],1)],1)],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center","margin-top":"30px"},attrs:{span:24}},[i("el-button",{attrs:{type:"success"},on:{click:t.saveOrUpdateNotice}},[t._v("发布")]),t._v(" "),i("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:t.backFn}},[t._v("取消")])],1)],1)],1)],1)])},s=[],l=(i("ac6a"),i("63f4")),o=i("0fe1"),r={name:"CreateNotice",components:{Ueditor:l["a"]},props:{id:{type:String,default:""}},data:function(){return{fileUrl:"/app/xlgl/xlgldocumentfile/upLoadFile",form:{videoFile:"",coverFile:"",tacticTitle:"",content:""},showImg:!1,fileList:[],fileId:[],videoList:[],imgList:[]}},created:function(){this.id&&this.getSportsInfo()},methods:{getSportsInfo:function(){var t=this;Object(o["I"])({id:this.id}).then(function(e){var i=e.data.xlglWarCommonSports,a=i.tacticTitle,s=i.coverFile,l=i.videoFile,o=i.content;Object.assign(t.form,{tacticTitle:a,coverFile:s,videoFile:l,content:o}),e.data.xlglWarCommonSports.videoFile&&t.videoList.push({name:e.data.xlglWarCommonSports.videoFileName,url:e.data.xlglWarCommonSports.videoFile}),e.data.xlglWarCommonSports.coverFile&&t.imgList.push({name:e.data.xlglWarCommonSports.coverFileName,url:e.data.xlglWarCommonSports.coverFile}),e.data.xlglWarCommonSports.accessoryFileArray.forEach(function(e,i){t.fileList.push({name:e.fileName,url:e.fileId}),t.fileId.push(e.fileId)}),t.$refs.content.setContent(t.form.content)})},backFn:function(){this.$emit("back",0)},uploadVideo:function(t){this.form.videoFile=t.fileId},uploadImg:function(t){this.form.coverFile=t.fileId},uploadFile:function(t){this.fileId.push(t.fileId)},removeVideo:function(){this.form.videoFile=""},removeImg:function(){this.form.coverFile=""},removeFile:function(t){this.fileId.indexOf(t.url)>-1&&this.fileId.splice(t.url,1)},saveOrUpdateNotice:function(){this.form.tacticTitle?this.id?(this.form.id=this.id,this.form.accessoryFile=this.fileId.join(","),this.sportsUpdate()):(this.form.accessoryArray=this.fileId.join(","),this.getSportsSave()):this.$message({message:"请填写训练标题",type:"info"})},getSportsSave:function(){var t=this;Object(o["K"])(this.form).then(function(e){"success"===e.data.msg?t.$message({message:"新增成功",type:"success"}):t.$message({message:"新增失败",type:"info"}),t.backFn()})},sportsUpdate:function(){var t=this;Object(o["yb"])(this.form).then(function(e){"success"===e.data.msg?t.$message({message:"修改成功",type:"success"}):t.$message({message:"修改失败",type:"info"}),t.backFn()})}}},n=r,c=(i("20db"),i("2877")),d=Object(c["a"])(n,a,s,!1,null,"0d321bfe",null);e["default"]=d.exports}}]);