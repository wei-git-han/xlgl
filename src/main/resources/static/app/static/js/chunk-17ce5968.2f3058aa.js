(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-17ce5968"],{"05ab":function(t,e,a){},"172f":function(t,e,a){},"3df1":function(t,e,a){},"4c8c":function(t,e,a){"use strict";var s=a("05ab"),i=a.n(s);i.a},"5ab4":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[0===t.isShow?a("div",{staticStyle:{position:"relative",padding:"0 10px"}},[a("el-tabs",{on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"视频教学",name:"first"}},[a("div",[a("div",{staticStyle:{"margin-top":"15px"}},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px","margin-left":"25px"},attrs:{size:"small",placeholder:"请输入训练名称"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.search(e)}},model:{value:t.listQuery.title,callback:function(e){t.$set(t.listQuery,"title",e)},expression:"listQuery.title"}}),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"30px"},attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:t.search}},[t._v("搜索")])],1)]),t._v(" "),a("el-row",[a("el-col",{staticClass:"elColStyle",attrs:{span:24}},[a("el-scrollbar",{staticClass:"hidden-x"},[a("el-row",{attrs:{gutter:20}},[a("div",{staticClass:"videoList"},t._l(t.videoList,function(e,s){return a("div",{key:s,staticClass:"videoCard",on:{click:function(a){return t.toDetial(e)}}},[a("span",{class:["learnLabel","1"===e.readStatus?"bg_active":"bg_default"]},[t._v(t._s("1"===e.readStatus?"已学习":"待学习"))]),t._v(" "),a("div",{staticStyle:{position:"relative",width:"100%",height:"170px",background:"#F9FBFE"}},[e.videoFile?a("video",{staticClass:"imgStyle",staticStyle:{"object-fit":"fill"},attrs:{controls:"controls",poster:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}},[a("source",{attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.videoFile}})]):e.coverFile?a("img",{staticClass:"imgStyle",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+e.coverFile}}):a("svg-icon",{staticClass:"icon",staticStyle:{width:"50%",height:"50%","margin-top":"12.5%","margin-left":"25%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),a("p",{staticClass:"cardTitle",attrs:{title:e.tacticTitle}},[t._v(t._s(e.tacticTitle))]),t._v(" "),a("p",{staticStyle:{color:"#99A6BF",padding:"0 10px"}},[t._v(t._s(e.viewNumber)+"次浏览")])])}),0)])],1)],1)],1),t._v(" "),a("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getSportsList}})],1),t._v(" "),a("el-tab-pane",{attrs:{label:"军事体育成绩评定",name:"second"}},[a("el-row",[a("el-col",{attrs:{span:18}},[a("div",{staticClass:"flex-center",staticStyle:{padding:"0 60px 0 20px"}},[a("div",[a("span",[t._v("体型分数")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t._f("floatFilter")(t.form.tscore)))])]),t._v(" "),a("div",[a("span",[t._v("体型评定")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t.form.judge))])]),t._v(" "),a("div",[a("span",[t._v("军事体育成绩")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t._f("floatFilter")(t.form.allScore)))])]),t._v(" "),a("div",[a("span",[t._v("体育等级评定")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"30px"}},[t._v(t._s(t.form.allJudge))])])]),t._v(" "),a("el-form",{ref:"form",staticStyle:{"margin-top":"30px"},attrs:{rules:t.rules,model:t.form,"label-width":"150px"}},[a("el-row",[a("el-col",{attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"姓名",required:""}},[a("el-input",{attrs:{disabled:""},model:{value:t.userName,callback:function(e){t.userName=e},expression:"userName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"身份证号",prop:"idCard"}},[a("el-input",{attrs:{maxlength:"18"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.idCard,callback:function(e){t.$set(t.form,"idCard",e)},expression:"form.idCard"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:10}},[a("div",{staticClass:"txIcon"},[a("span",[t._v("体型信息录入")])])]),t._v(" "),a("el-col",{attrs:{span:10}},[a("div",{staticStyle:{display:"flex","align-items":"center"}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),a("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看体型标准",1)}}},[t._v("查看体型标准")]),t._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag === '1'"}],staticStyle:{"margin-left":"15px"},attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.changeFileFn(1)}}},[t._v("上传文件")])],1)])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"10px"}},[a("el-col",{attrs:{span:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"性别",prop:"sex"}},[a("el-select",{attrs:{placeholder:"请选择"},on:{change:t.changeSex},model:{value:t.form.sex,callback:function(e){t.$set(t.form,"sex",e)},expression:"form.sex"}},[a("el-option",{attrs:{label:"男",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"女",value:"1"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"身高",prop:"high"}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.high,callback:function(e){t.$set(t.form,"high",e)},expression:"form.high"}},[a("template",{slot:"append"},[t._v("米")])],2)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"类型",prop:"type"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},[a("el-option",{attrs:{label:"一类人员",value:"1"}}),t._v(" "),a("el-option",{attrs:{label:"二类人员",value:"2"}}),t._v(" "),a("el-option",{attrs:{label:"三类人员",value:"3"}})],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"体重",prop:"wight"}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.wight,callback:function(e){t.$set(t.form,"wight",e)},expression:"form.wight"}},[a("template",{slot:"append"},[t._v("Kg")])],2)],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"出生年月",prop:"birthday"}},[a("el-date-picker",{attrs:{type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择","picker-options":t.pickOptionStart},on:{change:t.getVal},model:{value:t.form.birthday,callback:function(e){t.$set(t.form,"birthday",e)},expression:"form.birthday"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"年龄",prop:"age"}},[a("el-input",{attrs:{disabled:""},model:{value:t.form.age,callback:function(e){t.$set(t.form,"age",e)},expression:"form.age"}})],1)],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:10}},[a("div",{staticClass:"kmIcon"},[a("span",[t._v("科目成绩录入")])])]),t._v(" "),a("el-col",{attrs:{span:10}},[a("div",{staticStyle:{display:"flex","align-items":"center"}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v("*")]),t._v(" "),a("span",{staticClass:"ruleText",on:{click:function(e){return t.show_dialog("查看训练标准",2)}}},[t._v("查看训练标准")]),t._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.adminFlag,expression:"adminFlag === '1'"}],staticStyle:{"margin-left":"15px"},attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.changeFileFn(2)}}},[t._v("上传文件")])],1)])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"15px"}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:t.labelText,prop:"ytxs"}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.ytxs,callback:function(e){t.$set(t.form,"ytxs",e)},expression:"form.ytxs"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[a("span",[t._v("次")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.up))]),t._v("分\n                    ")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"5px"}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"仰卧起坐",prop:"ywqz"}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.ywqz,callback:function(e){t.$set(t.form,"ywqz",e)},expression:"form.ywqz"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center ma-l_20"},[a("span",[t._v("次")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.sit))]),t._v("分\n                    ")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"5px"}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"30米 * 2蛇形跑",prop:"sxp"}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.sxp,callback:function(e){t.$set(t.form,"sxp",e)},expression:"form.sxp"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[a("span",[t._v("秒")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.srun))]),t._v("分\n                    ")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"5px"}},[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"3000米长跑",prop:"cpf"}},[a("el-col",{attrs:{span:18}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.cpf,callback:function(e){t.$set(t.form,"cpf",e)},expression:"form.cpf"}})],1),t._v(" "),a("el-col",{staticClass:"text-center",attrs:{span:4}},[a("span",[t._v("分")])])],1)],1),t._v(" "),a("el-col",{attrs:{span:2}},[a("el-input",{attrs:{placeholder:"请输入"},on:{input:function(e){return t.countMark("form")}},model:{value:t.form.cpm,callback:function(e){t.$set(t.form,"cpm",e)},expression:"form.cpm"}})],1),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"flex-center",staticStyle:{"margin-left":"20px"}},[a("span",[t._v("秒")]),t._v(" "),a("span",{staticStyle:{color:"#FAA95E","font-size":"28px"}},[t._v(t._s(t.form.trun))]),t._v("分\n                    ")])])],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bor_b flex-center"},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"center"}},[a("svg-icon",{staticClass:"icon",staticStyle:{width:"40px",height:"40px"},attrs:{"icon-class":"xinwen"}}),t._v(" "),a("p",{staticStyle:{"margin-left":"10px"}},[a("span",[t._v("历史评定")]),a("br"),t._v(" "),a("span",{staticStyle:{color:"#999999","font-size":"14px"}},[t._v("数据统计")])])],1),t._v(" "),a("div",{staticClass:"pointer textClick ff_d",staticStyle:{"font-size":"18px"},on:{click:t.showView}},[t._v("更多>")])]),t._v(" "),t._l(t.resultList,function(e,s){return a("div",{key:s,staticStyle:{margin:"15px 0"}},[a("el-row",[a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:2}},[a("span",[t._v(t._s(s+1))])]),t._v(" "),a("el-col",{attrs:{span:6}},[a("span",{staticClass:"color_green"},[t._v(t._s(e.allJudge?e.allJudge:"--"))])]),t._v(" "),a("el-col",{staticClass:"text-center",attrs:{span:10}},[a("span",[t._v(t._s(e.createdTime))])]),t._v(" "),a("el-col",{staticClass:"text-center",attrs:{span:6}},[a("span",{staticClass:"color_red pointer",on:{click:function(a){return t.deleteData(e)}}},[t._v("删除")])])],1)],1)})],2)],1),t._v(" "),a("el-col",{staticStyle:{"text-align":"center","margin-top":"20px"},attrs:{span:24}},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.saveData("form")}}},[t._v("保存")]),t._v(" "),a("el-button",{staticStyle:{"margin-left":"10px"},on:{click:t.resetFn}},[t._v("重置")])],1)],1)],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:0===t.tabIndex,expression:"tabIndex===0"}],staticStyle:{position:"absolute",right:"40px",top:"6px"}},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:"1"===t.isManager,expression:"isManager==='1'"}],staticClass:"addBtn noBorder",attrs:{type:"success",size:"mini",icon:"el-icon-plus"},on:{click:t.addPage}},[t._v("新增")])],1)],1):2===t.isShow?a("militaryAdd",{attrs:{id:t.fileId},on:{back:t.backList}}):3===t.isShow?a("militaryView",{attrs:{id:t.fileId,"is-manager":t.isManager},on:{back:t.backList}}):1===t.isShow?a("sportHistory",{on:{back:t.backList}}):t._e(),t._v(" "),a("el-dialog",{staticClass:"legalDialog",attrs:{title:t.fileTitle,visible:t.showDialog},on:{"update:visible":function(e){t.showDialog=e},close:t.resetTemp}},[t.newFileId&&!t.reload?a("frame-pdf",{staticStyle:{height:"100%"},attrs:{"file-id":t.newFileId}}):t._e()],1),t._v(" "),a("el-dialog",{staticClass:"cjfx",attrs:{title:t.fileTitle,visible:t.showDialog1,width:"20%"},on:{"update:visible":function(e){t.showDialog1=e}}},[a("div",{staticClass:"text-center"},[a("p",[t._v("\n          您当前成绩排名"),a("span",{staticClass:"redFont"},[t._v(t._s(t.dialogInfo.sort))]),t._v("名\n        ")]),t._v(" "),a("p",[t._v("\n          体重标准为"),a("span",{staticClass:"redFont"},[t._v(t._s(t.dialogInfo.tx))])]),t._v(" "),a("p",[t._v("\n          训练成绩为"),a("span",{staticClass:"redFont"},[t._v(t._s(t.dialogInfo.dj))])])]),t._v(" "),a("div",{staticClass:"dialog-footer text-center",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary",round:""},on:{click:function(e){t.showDialog1=!1}}},[t._v("知道了")])],1)]),t._v(" "),a("el-dialog",{attrs:{title:t.fileTitle1,visible:t.changeFileStatus},on:{"update:visible":function(e){t.changeFileStatus=e}}},[a("change-file-dialog",{on:{close:function(e){t.changeFileStatus=!1},"upload-success":t.uploadSuccess}})],1)],1)])},i=[],l=(a("55dd"),a("c5f6"),a("333d")),n=a("c1b8"),o=a("ed32"),r=a("c89c"),c=a("ef69"),p=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"centerPosition",staticStyle:{"text-align":"center"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!0,"with-credentials":!0,action:t.fileUploadUrl,data:t.fileData,"on-success":t.successFile,"on-error":t.errorFile,accept:".pdf"}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),a("em",[t._v("点击上传")])])])],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","margin-top":"20px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.submitFile}},[t._v("确 定")]),t._v(" "),a("el-button",{on:{click:t.off}},[t._v("取 消")])],1)])},d=[],u={data:function(){return{fileUploadUrl:"/app/xlgl/xlglcarsmanager/uploadFile",fileId:"",fileData:{access_token:this.$store.state.user.token,type:""}}},methods:{off:function(){this.$emit("close")},handleRemove:function(t,e){},handlePreview:function(t){},saveFn:function(){this.$emit("crop-upload-success",this.createImgUrl),this.$refs.upload.clearFiles()},successFile:function(t){this.fileId=t.fileId},submitFile:function(){this.fileId?this.$emit("upload-success",this.fileId):this.$notify({title:"提示",message:"请上传文件后再点击确定!",duration:1500,type:"warning"})},errorFile:function(){this.$notify({title:"提示",message:"上传失败！请重新上传",duration:1500,type:"warning"})}}},f=u,v=a("2877"),m=Object(v["a"])(f,p,d,!1,null,"b66a4894",null),g=m.exports,h=a("9c89"),_=a("0fe1"),y={components:{Pagination:l["a"],sportHistory:n["default"],militaryAdd:o["default"],militaryView:r["default"],FramePdf:c["a"],ChangeFileDialog:g},filters:{floatFilter:function(t){return t?parseFloat(t).toFixed(2):""}},data:function(){return{listQuery:{page:1,limit:10,title:""},videoList:[],activeName:"first",changeFileStatus:!1,total:0,tabIndex:0,form:{age:"",up:"",sit:"",srun:"",trun:"",sex:"",type:"3",birthday:"",wight:"",high:"",tscore:"",judge:"",allScore:"",allJudge:"",ytxs:"",ywqz:"",sxp:"",cpf:"",cpm:""},rules:{idCard:[{required:!0,message:"请填写身份证号",trigger:"blur"},{pattern:/^\d{17}(\d{1}|[X|x])$/,message:"证件号码格式有误！",trigger:"blur"}],sex:[{required:!0,message:"请选择性别",trigger:"change"}],high:[{required:!0,message:"请输入身高",trigger:"blur"}],type:[{required:!0,message:"请选择类型",trigger:"change"}],wight:[{required:!0,message:"请输入体重",trigger:"blur"}],birthday:[{required:!0,message:"请选择出生年月",trigger:"change"}],ytxs:[{required:!0,message:"请输入引体向上次数",trigger:"blur"}],ywqz:[{required:!0,message:"请输入仰卧起坐次数",trigger:"blur"}],sxp:[{required:!0,message:"请输入30米蛇形跑分数",trigger:"blur"}],cpf:[{required:!0,message:"3000米长跑分数",trigger:"blur"}]},resultList:[],isShow:0,showDialog:!1,fileTitle:"",fileId:"",isManager:this.$store.state.user.userInfo.adminFlag,userName:"",fileTitle1:"成绩分析",showDialog1:!1,newFileId:"",changeFileTitle:"修改体型分析",changeStatus:1,reload:!1,dialogInfo:{sort:"",dj:"",tx:""},curTime:new Date,adminFlag:this.$store.state.user.userInfo.adminFlag,pickOptionStart:{disabledDate:function(t){return t.getTime()>(new Date).getTime()-864e5}},labelText:"引体向上",projectList:["单杠引体向上","俯卧撑","单杠屈臂悬停"]}},watch:{isShow:function(t){0===t&&this.getSportsList()}},created:function(){this.$route.query.flag&&(this.activeName="second"),this.getSportsList()},methods:{getVal:function(t){this.form.age=Number(this.curTime.getFullYear())-Number(t.slice(0,4)),this.refershText(),this.countMark("form")},changeSex:function(){this.refershText(),this.countMark("form")},refershText:function(){""!==this.form.age&&this.form.age<=39&&"0"===this.form.sex&&(this.labelText="单杠引体向上"),""!==this.form.age&&this.form.age>=40&&"0"===this.form.sex&&(this.labelText="俯卧撑"),""!==this.form.age&&this.form.age<=39&&"1"===this.form.sex&&(this.labelText="单杠屈臂悬停"),""!==this.form.age&&this.form.age>=40&&"1"===this.form.sex&&(this.labelText="俯卧撑")},getSportsList:function(){var t=this;Object(_["K"])(this.listQuery).then(function(e){t.videoList=e.data.page.list,t.total=e.data.page.totalCount})},getUserInfo:function(){var t=this;Object(_["S"])().then(function(e){t.userName=e.data.userName})},physicalList:function(){var t=this;Object(_["jb"])(this.listQuery).then(function(e){t.resultList=e.data.page.list})},search:function(){this.getSportsList()},handleClick:function(t){this.tabIndex=Number(t.index),"0"===t.index?this.getSportsList():(this.getUserInfo(),this.physicalList())},addPage:function(){this.isShow=2},showView:function(){this.isShow=1},toDetial:function(t){this.isShow=3,this.fileId=t.id},setVal:function(t){for(var e in t)t[e]=""},showChart:function(){},backList:function(t,e){this.isShow=t,this.fileId=e},show_dialog:function(t,e){this.getFileByType(e),this.fileTitle=t},resetTemp:function(){this.newFileId=""},changeFileFn:function(t){2===t&&(this.changeFileTitle="修改训练标准"),this.changeFileStatus=!0,this.changeStatus=t},saveData:function(t){var e=this;this.$refs[t].validate(function(a){if(!a)return!1;Object(_["kb"])(e.form).then(function(a){"success"===a.data.result?(e.dialogInfo.sort=a.data.sort,e.dialogInfo.dj=a.data.dj,e.dialogInfo.tx=a.data.tx,e.showDialog1=!0):e.$notify({title:"提示",message:"保存失败",duration:1500,type:"warning"}),e.$refs[t].resetFields(),e.setVal(e.form),e.physicalList()})})},resetFn:function(){this.form={},this.$refs.form.resetFields()},countMark:function(t){var e=this;this.$refs[t].validate(function(t){if(!t)return!1;Object(_["M"])(e.form).then(function(t){"success"===t.data.result&&(e.form.up=t.data.shang,e.form.sit=t.data.zuo,e.form.srun=t.data.pao,e.form.trun=t.data.changpao,e.form.tscore=t.data.BMI,e.form.judge=t.data.hg,e.form.allScore=t.data.score,e.form.allJudge=t.data.dj)})})},deleteData:function(t){var e=this;Object(_["hb"])({id:t.id}).then(function(t){"success"===t.data.result?e.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}):e.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"}),e.physicalList()})},uploadSuccess:function(t){var e=this;Object(h["b"])({fileId:t,fileName:t+".pdf",type:this.changeStatus}).then(function(t){e.$notify({title:"提示",message:"上传成功！",duration:1500,type:"success"})}),this.changeFileStatus=!1},getFileByType:function(t){var e=this;Object(h["a"])({type:t}).then(function(t){e.reload=!0,t.data.fileId?(e.newFileId=t.data.fileId,e.reload=!1,e.showDialog=!0):e.$notify({title:"提示",message:"管理员还未上传文件！",duration:1500,type:"warning"})})}}},x=y,b=(a("b941"),Object(v["a"])(x,s,i,!1,null,"d0c84884",null));e["default"]=b.exports},"9c89":function(t,e,a){"use strict";a.d(e,"b",function(){return i}),a.d(e,"a",function(){return l});var s=a("b775");function i(t){return Object(s["a"])({url:"/app/xlgl/xlglwarcommonsportsfile/save",method:"post",data:t})}function l(t){return Object(s["a"])({url:"/app/xlgl/xlglwarcommonsportsfile/listOne",method:"get",params:t})}},b941:function(t,e,a){"use strict";var s=a("172f"),i=a.n(s);i.a},c1b8:function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"containeer"},[a("title-card",{attrs:{"title-text":"历史评定"}}),t._v(" "),a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"20px",top:"15px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),a("el-row",[a("el-col",{staticStyle:{"margin-left":"60px"},attrs:{span:20}},[a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData,border:"","header-cell-style":{background:"#F7F7F8"}}},[a("el-table-column",{attrs:{align:"center",label:"序号",type:"index",width:"70"}}),t._v(" "),a("el-table-column",{attrs:{prop:"allJudge",align:"center",label:"等级"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.allJudge?e.row.allJudge:"--"))])]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"createdTime",align:"center",label:"生成日期"}}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.detailData(e.row)}}},[t._v("查看")]),t._v(" "),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.deleteData(e.row)}}},[t._v("删除")])]}}])})],1)],1)],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"isShow"}],staticStyle:{"border-top":"1px solid #ccc","margin-top":"30px","padding-top":"20px","padding-left":"10px"}},[a("el-row",[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"txIcon"},[a("span",[t._v("体型信息录入")])])])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("性别：")]),t._v(" "),a("span",[t._v(t._s("1"===t.sex?"女":"男"))])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("出生日期：")]),t._v(" "),a("span",[t._v(t._s(t.birthday))])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("类别：")]),t._v(" "),a("span",[t._v(t._s(t.typeList[t.type-1]))])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("身高：")]),t._v(" "),a("span",[t._v(t._s(t.high))])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:4}},[a("span",[t._v("体重：")]),t._v(" "),a("span",[t._v(t._s(t.wight))])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-top":"30px"}},[a("el-col",{attrs:{span:10}},[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"kmIcon"},[a("span",[t._v("科目成绩录入")])])])],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("引体向上：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v(t._s(t.ytxs))]),t._v(" "),a("span",[t._v("次")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v(t._s(t.up))]),t._v(" "),a("span",[t._v("分")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("仰卧起坐：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v(t._s(t.ywqz))]),t._v(" "),a("span",[t._v("次")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v(t._s(t.sit))]),t._v(" "),a("span",[t._v("分")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("30米蛇形跑：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v(t._s(t.sxp))]),t._v(" "),a("span",[t._v("秒")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v(t._s(t.srun))]),t._v(" "),a("span",[t._v("分")])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"20px","margin-top":"20px"}},[a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v("3000米长跑：")])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",[t._v(t._s(t.cpf+"分"+t.cpm+"秒"))])]),t._v(" "),a("el-col",{staticStyle:{color:"#666","font-size":"14px"},attrs:{span:3}},[a("span",{staticStyle:{color:"#F56C6C"}},[t._v(t._s(t.trun))]),t._v(" "),a("span",[t._v("分")])])],1)],1)],1)},i=[],l=a("35b7"),n=a("0fe1"),o={components:{TitleCard:l["a"]},data:function(){return{listQuery:{page:1,limit:10},tableData:[],isShow:!0,sex:"",type:"",birthday:"",wight:"",high:"",ytxs:"",ywqz:"",sxp:"",cpf:"",cpm:"",up:"",sit:"",srun:"",trun:"",typeList:["一类人员","二类人员","三类人员"]}},created:function(){this.physicalList()},methods:{physicalList:function(){var t=this;Object(n["jb"])(this.listQuery).then(function(e){e.data.page.list&&e.data.page.list.length>0?(t.tableData=e.data.page.list,t.id=e.data.page.list[0].id,t.physicalInfo(),t.isShow=!0):(t.tableData=[],t.isShow=!1)})},physicalInfo:function(){var t=this;Object(n["ib"])({id:this.id}).then(function(e){var a=e.data.xlglPhysical,s=a.sex,i=a.high,l=a.wight,n=a.up,o=a.sit,r=a.type,c=a.birthday,p=a.ytxs,d=a.ywqz,u=a.sxp,f=a.cpf,v=a.cpm,m=a.srun,g=a.trun;Object.assign(t,{sex:s,high:i,wight:l,up:n,sit:o,type:r,birthday:c,ytxs:p,ywqz:d,sxp:u,cpf:f,cpm:v,srun:m,trun:g})})},back:function(){this.$emit("back",0)},deleteData:function(t){var e=this;Object(n["hb"])({id:t.id}).then(function(t){"success"===t.data.result?(e.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}),e.physicalList()):e.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"})})},detailData:function(t){this.id=t.id,this.physicalInfo()}}},r=o,c=(a("e598"),a("2877")),p=Object(c["a"])(r,s,i,!1,null,"3440a1f8",null);e["default"]=p.exports},c89c:function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"app-content"},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer",position:"absolute",right:"40px",top:"40px"},attrs:{"icon-class":"goback"},on:{click:t.back}}),t._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("div",{staticClass:"header"},[a("div",{staticClass:"title",attrs:{title:t.tacticTitle}},[t._v(t._s(t.tacticTitle))]),t._v(" "),a("el-row",[a("el-col",{attrs:{span:6}},[a("span",[t._v("发布时间：")]),t._v(" "),a("span",[t._v(t._s(t.updateDate))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("发布单位：")]),t._v(" "),a("span",[t._v(t._s(t.createOrganName))])]),t._v(" "),a("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[a("span",[t._v("浏览次数：")]),t._v(" "),a("span",[t._v(t._s(t.viewNumber))])]),t._v(" "),a("el-col",{directives:[{name:"show",rawName:"v-show",value:"1"==t.isManager,expression:"isManager=='1'"}],staticStyle:{"text-align":"right"},attrs:{span:6}},[a("span",{staticStyle:{color:"#2280E5",cursor:"pointer"},on:{click:t.editor}},[t._v("编辑")]),t._v(" "),a("span",{staticStyle:{color:"#2280E5","margin-left":"20px",cursor:"pointer"},on:{click:t.deleteFn}},[t._v("删除")])])],1)],1),t._v(" "),a("el-row",[a("el-col",{staticClass:"elColStyle",attrs:{span:24}},[a("el-scrollbar",{staticClass:"hidden-x"},[a("el-col",{attrs:{span:18}},[a("div",{staticStyle:{display:"flex","flex-direction":"row","align-items":"flex-start",width:"100%",overflow:"hidden"}},[a("div",{staticStyle:{"margin-top":"16px"}},[t._v("训练内容描述：")]),t._v(" "),a("div",{staticStyle:{"word-break":"break-all",width:"90%"},attrs:{id:"content"},domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),a("video",{directives:[{name:"show",rawName:"v-show",value:t.videoFile,expression:"videoFile"}],ref:"myVideo",staticStyle:{height:"500px",width:"100%"},attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.videoFile,controls:"controls"}})]),t._v(" "),a("el-col",{attrs:{span:6}},[t.coverFile?a("img",{staticClass:"imgStyle1 ma_l_30",attrs:{src:"/app/xlgl/xlgldocumentfile/downLoad?fileId="+t.coverFile}}):a("div",{staticClass:"imgStyle1 ma_l_30",staticStyle:{background:"#F9FBFE"}},[a("svg-icon",{staticClass:"icon",staticStyle:{height:"50%",width:"50%","margin-left":"25%","margin-top":"12.5%"},attrs:{"icon-class":"zanwushuju"}})],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.fileList.length>0,expression:"fileList.length>0"}],staticStyle:{width:"70%",border:"1px solid #ccc",margin:"10px 0 0 30px","border-radius":"3px"}},[a("div",{staticStyle:{"border-bottom":"1px solid #DCDFE6",height:"40px","line-height":"40px","padding-left":"20px"}},[t._v("附件资料")]),t._v(" "),t._l(t.fileList,function(e,s){return a("div",{key:s,staticStyle:{padding:"7px",display:"flex","flex-direction":"row","align-items":"center"},on:{click:function(a){return t.downloadFile(e.fileId,e.fileName)}}},[a("svg-icon",{staticClass:"icon",staticStyle:{cursor:"pointer"},attrs:{"icon-class":"affix"}}),t._v(" "),a("span",{staticClass:"pictureName"},[t._v(t._s(e.fileName))])],1)})],2)])],1)],1)],1)],1)],1)])},i=[],l=a("0fe1"),n={props:{id:{type:String,default:""},isManager:{type:String,default:""}},data:function(){return{tacticTitle:"",updateDate:"",viewNumber:"",createOrganName:"",content:"",coverFile:"",videoFile:"",fileList:[],symTime:"",timer:"",videoTime:""}},created:function(){this.getSportsInfo()},mounted:function(){var t=this;this.$refs.myVideo.onplay=function(){t.timer=setInterval(function(){t.videoTime=t.$refs.myVideo.currentTime,t.videoTime-t.symTime>1&&(t.$refs.myVideo.currentTime=t.symTime),t.symTime=t.$refs.myVideo.currentTime},100)},this.$refs.myVideo.onended=function(){t.sportsUpdateRead(),clearInterval(t.timer)}},methods:{getSportsInfo:function(){var t=this;Object(l["J"])({id:this.id,type:"0"}).then(function(e){var a=e.data.xlglWarCommonSports,s=a.tacticTitle,i=a.updateDate,l=a.viewNumber,n=a.createOrganName,o=a.coverFile,r=a.videoFile,c=a.content;Object.assign(t,{tacticTitle:s,updateDate:i,viewNumber:l,createOrganName:n,coverFile:o,videoFile:r,content:c}),t.fileList=e.data.xlglWarCommonSports.accessoryFileArray})},back:function(){this.$emit("back",0)},editor:function(){this.$emit("back",2,this.id)},deleteFn:function(){var t=this;Object(l["zb"])({ids:this.id}).then(function(e){"success"===e.data.msg?t.$notify({title:"提示",message:"删除成功",duration:1500,type:"success"}):t.$notify({title:"提示",message:"删除失败",duration:1500,type:"warning"}),t.back()})},downloadFile:function(t,e){window.location.href="/app/xlgl/xlgldocumentfile/downLoad?fileId="+t+"&fileName="+e+"&access_token="+this.$store.state.user.token},sportsUpdateRead:function(){Object(l["Bb"])({id:this.id}).then(function(t){})}}},o=n,r=(a("e882"),a("4c8c"),a("2877")),c=Object(r["a"])(o,s,i,!1,null,"162b9d7a",null);e["default"]=c.exports},e598:function(t,e,a){"use strict";var s=a("3df1"),i=a.n(s);i.a},e882:function(t,e,a){"use strict";var s=a("ec3b"),i=a.n(s);i.a},ec3b:function(t,e,a){}}]);