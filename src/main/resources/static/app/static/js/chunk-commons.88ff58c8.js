(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-commons"],{1368:function(t,e,i){},"2eee":function(t,e,i){"use strict";var n=i("1368"),r=i.n(n);r.a},"35b7":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"titleDIv"},[i("div",[i("span",{staticClass:"textDiv"}),t._v(t._s(t.titleText)+"\n  ")])])},r=[],a={name:"TitleIndex",props:{titleText:{type:String,default:""}}},o=a,l=(i("2eee"),i("2877")),s=Object(l["a"])(o,n,r,!1,null,"007e6128",null);e["a"]=s.exports},"5f1c":function(t,e,i){},"63f4":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"tinymce-container"},[i("textarea",{ref:"editor",staticClass:"tinymce-textarea",staticStyle:{height:"300px"},attrs:{id:t.id}}),t._v(" "),i("file-upload",{directives:[{name:"show",rawName:"v-show",value:t.imagecropperShow,expression:"imagecropperShow"}],attrs:{width:300,height:300,type:t.acceptType,url:"/app/xlgl/xlgldocumentfile/upLoadFile","lang-type":"zh-cn"},on:{close:t.close,"crop-upload-success":t.cropSuccess}})],1)},r=[],a=(i("6b54"),i("c5f6"),i("4437"),i("e6ff"),i("2e32"),function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"show",rawName:"v-show",value:t.value,expression:"value"}],staticClass:"vue-image-crop-upload"},[i("div",{staticClass:"vicp-wrap"},[i("div",{staticClass:"vicp-close",on:{click:t.off}},[i("i",{staticClass:"vicp-icon4"})]),t._v(" "),i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:t.type,action:"/app/xlgl/xlgldocumentfile/upLoadFile",limit:1,name:t.field,"list-type":"picture","on-preview":t.handlePreview,"on-remove":t.handleRemove,"on-success":t.successFn,"on-error":t.errorFn}},[i("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")])],1),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"20px",bottom:"20px",cursor:"pointer"}},[i("el-button",{attrs:{type:"text"},on:{click:t.off}},[t._v("取消")]),t._v(" "),i("el-button",{attrs:{type:"text"},on:{click:t.saveFn}},[t._v("保存")])],1)],1)])}),o=[],l={props:{url:{type:String,default:""},field:{type:String,default:"pdf"},value:{default:!0},type:{type:String,default:""}},data:function(){return{createImgUrl:""}},methods:{off:function(){this.$emit("close"),this.$refs.upload.clearFiles(),this.createImgUrl=""},handleRemove:function(t,e){},handlePreview:function(t){},saveFn:function(){this.$emit("crop-upload-success",this.createImgUrl),this.$refs.upload.clearFiles(),this.createImgUrl=""},successFn:function(t){this.createImgUrl=t.fileId},errorFn:function(){alert("上传失败，请重新上传！")}}},s=l,c=(i("ecca"),i("2877")),u=Object(c["a"])(s,a,o,!1,null,"1ba150ce",null),d=u.exports,p={name:"Ueditor",components:{FileUpload:d},props:{value:{type:String,default:""},toolbar:{type:Array,required:!1,default:function(){return[]}},menubar:{type:String,default:"file edit insert view format table"},height:{type:[Number,String],required:!1,default:300},width:{type:[Number,String],required:!1,default:"auto"},config:{type:Object,default:function(){return{autoHeightEnabled:!1,autoFloatEnabled:!0,intialContent:"",autoClearinitialContent:!0,initialFrameWidth:null,initialFrameHeight:450,BaseUrl:"",UEDITOR_HOME_URL:"/ueditor/"}}}},data:function(){return{id:"ueditorId"+Math.random().toString(16).substring(2),editor:null,imagecropperShow:!1,imagecropperKey:0,image:null,flag:"",acceptType:""}},created:function(){},mounted:function(){var t=this;this.$nextTick(function(){t.initEditor()})},methods:{initEditor:function(){var t=this;this.$refs.editor.id=this.id,this.editor=UE.getEditor(this.id,{toolbars:[["print","fontFamily","fontSize","formatMatch","source","time","undo","redo","bold","italic","fontBorder","justifyLeft","justifyCenter","justifyRight","justifyJustify","insertImage"]],elementPathEnabled:!1,pastePlain:!0,filterTxtRules:function(){function t(t){t.tagName="p",t.setStyle()}return{"-":"script style object iframe embed input select",p:{$:{}},br:{$:{}},div:{$:{}},li:{$:{}},caption:t,th:t,tr:t,h1:t,h2:t,h3:t,h4:t,h5:t,h6:t,td:function(t){var e=!!t.innerText();e&&t.parentNode.insertAfter(this.editor.uNode.createText(" &nbsp; &nbsp;"),t),t.parentNode.removeChild(t,t.innerText())}}}(),scaleEnabled:!0,autoFloatEnabled:!1,tableDragable:!1,maximumWords:2e3}),this.editor.ready(function(){t.value&&t.editor.setContent(t.value),document.getElementsByClassName("edui-for-insertimage")[0].onclick=function(){t.imagecropperShow=!0,t.flag=0,t.acceptType=".png,.jpeg"},t.editor.addListener("contentChange",function(){t.$emit("input",t.editor.getContent())})})},getContent:function(){return this.editor.getContent()},setContent:function(t){var e=this;this.editor.ready(function(){e.editor.setContent(t)})},setDisabled:function(){var t=this;this.editor.ready(function(){t.editor.setDisabled()})},destroyUE:function(){},cropSuccess:function(t){var e=this;""===t?0===this.flag?alert("请选择要上传的图片"):alert("请选择要上传的视频"):(this.imagecropperShow=!1,this.editor.ready(function(){0===e.flag?e.editor.setContent('<img src="/app/xlgl/xlgldocumentfile/downLoad?fileId='.concat(t,'">'),!0):e.editor.setContent('<video src="/app/xlgl/xlgldocumentfile/downLoad?fileId='.concat(t,'" controls="controls"></video>'),!0)}))},close:function(){this.imagecropperShow=!1}}},f=p,h=Object(c["a"])(f,n,r,!1,null,null,null);e["a"]=h.exports},ecca:function(t,e,i){"use strict";var n=i("5f1c"),r=i.n(n);r.a},ef69:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticStyle:{"min-height":"400px",height:"100%"}},[i("iframe",{attrs:{src:t.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])},r=[],a={props:{fileId:{type:String,default:""}},data:function(){return{onlineFileUrl:""}},created:function(){this.onlineFileUrl="/app/pdf.js/web/viewer.html?fileId="+this.fileId+"&access_token="+this.$store.state.user.token}},o=a,l=i("2877"),s=Object(l["a"])(o,n,r,!1,null,"1674d517",null);e["a"]=s.exports}}]);