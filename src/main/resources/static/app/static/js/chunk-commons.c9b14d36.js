(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-commons"],{"133c":function(t,e,i){"use strict";var n=i("d785"),a=i.n(n);a.a},"333d":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"pagination-container",class:{hidden:t.hidden}},[i("el-pagination",t._b({attrs:{background:t.background,"current-page":t.currentPage,"page-size":t.pageSize,layout:t.layout,"page-sizes":t.pageSizes,total:t.total},on:{"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e},"update:pageSize":function(e){t.pageSize=e},"update:page-size":function(e){t.pageSize=e},"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}},"el-pagination",t.$attrs,!1))],1)},a=[],r=(i("c5f6"),i("09f4")),o={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[10,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(t){this.$emit("update:page",t)}},pageSize:{get:function(){return this.limit},set:function(t){this.$emit("update:limit",t)}}},methods:{handleSizeChange:function(t){this.$emit("pagination",{page:this.currentPage,limit:t}),this.autoScroll&&Object(r["a"])(0,800)},handleCurrentChange:function(t){this.$emit("pagination",{page:t,limit:this.pageSize}),this.autoScroll&&Object(r["a"])(0,800)}}},s=o,c=(i("48e8"),i("2877")),l=Object(c["a"])(s,n,a,!1,null,"64ad424a",null);e["a"]=l.exports},"35b7":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"titleDIv"},[i("div",[i("span",{staticClass:"textDiv"}),t._v(t._s(t.titleText)+"\n  ")])])},a=[],r={name:"TitleIndex",props:{titleText:{type:String,default:""}}},o=r,s=(i("e78c"),i("2877")),c=Object(s["a"])(o,n,a,!1,null,"76327ba4",null);e["a"]=c.exports},"3cbc":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"pan-item",style:{zIndex:t.zIndex,height:t.height,width:t.width}},[i("div",{staticClass:"pan-info"},[i("div",{staticClass:"pan-info-roles-container"},[t._t("default")],2)]),t._v(" "),i("div",{staticClass:"pan-thumb",style:{backgroundImage:"url("+t.image+")"}})])},a=[],r=(i("c5f6"),{name:"PanThumb",props:{image:{type:String,required:!0},zIndex:{type:Number,default:1},width:{type:String,default:"150px"},height:{type:String,default:"150px"}}}),o=r,s=(i("133c"),i("2877")),c=Object(s["a"])(o,n,a,!1,null,"799537af",null);e["a"]=c.exports},"48e8":function(t,e,i){"use strict";var n=i("fa25"),a=i.n(n);a.a},"63f4":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"tinymce-container"},[i("textarea",{ref:"editor",staticClass:"tinymce-textarea",staticStyle:{height:"300px"},attrs:{id:t.id}}),t._v(" "),i("file-upload",{directives:[{name:"show",rawName:"v-show",value:t.imagecropperShow,expression:"imagecropperShow"}],attrs:{width:300,height:300,type:t.acceptType,url:"/app/xlgl/xlgldocumentfile/upLoadFile","lang-type":"zh-cn"},on:{close:t.close,"crop-upload-success":t.cropSuccess}})],1)},a=[],r=(i("6b54"),i("c5f6"),i("4437"),i("e6ff"),i("2e32"),function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"show",rawName:"v-show",value:t.value,expression:"value"}],staticClass:"vue-image-crop-upload"},[i("div",{staticClass:"vicp-wrap"},[i("div",{staticClass:"vicp-close",on:{click:t.off}},[i("i",{staticClass:"vicp-icon4"})]),t._v(" "),i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:t.type,action:"/app/xlgl/xlgldocumentfile/upLoadFile",limit:1,name:t.field,"list-type":"picture","on-preview":t.handlePreview,"on-remove":t.handleRemove,"on-success":t.successFn,"on-error":t.errorFn}},[i("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")])],1),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"20px",bottom:"20px",cursor:"pointer"}},[i("el-button",{attrs:{type:"text"},on:{click:t.off}},[t._v("取消")]),t._v(" "),i("el-button",{attrs:{type:"text"},on:{click:t.saveFn}},[t._v("保存")])],1)],1)])}),o=[],s={props:{url:{type:String,default:""},field:{type:String,default:"pdf"},value:{default:!0},type:{type:String,default:""}},data:function(){return{createImgUrl:""}},methods:{off:function(){this.$emit("close"),this.$refs.upload.clearFiles(),this.createImgUrl=""},handleRemove:function(t,e){},handlePreview:function(t){},saveFn:function(){this.$emit("crop-upload-success",this.createImgUrl),this.$refs.upload.clearFiles(),this.createImgUrl=""},successFn:function(t){this.createImgUrl=t.fileId},errorFn:function(){alert("上传失败，请重新上传！")}}},c=s,l=(i("7489"),i("2877")),u=Object(l["a"])(c,r,o,!1,null,"f163a08e",null),d=u.exports,p={name:"Ueditor",components:{FileUpload:d},props:{value:{type:String,default:""},toolbar:{type:Array,required:!1,default:function(){return[]}},menubar:{type:String,default:"file edit insert view format table"},height:{type:[Number,String],required:!1,default:300},width:{type:[Number,String],required:!1,default:"auto"},config:{type:Object,default:function(){return{autoHeightEnabled:!1,autoFloatEnabled:!0,intialContent:"",autoClearinitialContent:!0,initialFrameWidth:null,initialFrameHeight:450,BaseUrl:"",UEDITOR_HOME_URL:"/ueditor/"}}}},data:function(){return{id:"ueditorId"+Math.random().toString(16).substring(2),editor:null,imagecropperShow:!1,imagecropperKey:0,image:null,flag:"",acceptType:""}},created:function(){},mounted:function(){var t=this;this.$nextTick(function(){t.initEditor()})},methods:{initEditor:function(){var t=this;this.$refs.editor.id=this.id,this.editor=UE.getEditor(this.id,{toolbars:[["fullscreen","print","fontFamily","fontsize","formatMatch","source","time","undo","redo","bold","italic","fontBorder","justifyleft","justifycenter","justifyright","justifyjustify","insertimage","insertvideo","",""]]}),this.editor.ready(function(){t.value&&t.editor.setContent(t.value),document.getElementsByClassName("edui-for-insertimage")[0].onclick=function(){t.imagecropperShow=!0,t.flag=0,t.acceptType=".png,.jpeg"},document.getElementsByClassName("edui-for-insertvideo")[0].onclick=function(){t.imagecropperShow=!0,t.flag=1,t.acceptType=".mp4"},t.editor.addListener("contentChange",function(){t.$emit("input",t.editor.getContent())})})},getContent:function(){return this.editor.getContent()},setContent:function(t){var e=this;this.editor.ready(function(){e.editor.setContent(t)})},destroyUE:function(){},cropSuccess:function(t){var e=this;""===t?0===this.flag?alert("请选择要上传的图片"):alert("请选择要上传的视频"):(this.imagecropperShow=!1,this.editor.ready(function(){0===e.flag?e.editor.setContent('<img src="/app/xlgl/xlgldocumentfile/downLoad?fileId='.concat(t,'">'),!0):e.editor.setContent('<video src="/app/xlgl/xlgldocumentfile/downLoad?fileId='.concat(t,'" controls="controls"></video>'),!0)}))},close:function(){this.imagecropperShow=!1}}},f=p,g=Object(l["a"])(f,n,a,!1,null,null,null);e["a"]=g.exports},7489:function(t,e,i){"use strict";var n=i("b898"),a=i.n(n);a.a},b898:function(t,e,i){},d785:function(t,e,i){},e78c:function(t,e,i){"use strict";var n=i("fdc5"),a=i.n(n);a.a},fa25:function(t,e,i){},fdc5:function(t,e,i){}}]);