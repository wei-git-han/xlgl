(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-commons"],{"35b7":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"titleDIv"},[i("div",[i("span",{staticClass:"textDiv"}),t._v(t._s(t.titleText)+"\n  ")])])},o=[],r={name:"TitleIndex",props:{titleText:{type:String,default:""}}},a=r,s=(i("e78c"),i("2877")),l=Object(s["a"])(a,n,o,!1,null,"76327ba4",null);e["a"]=l.exports},"63f4":function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"tinymce-container"},[i("textarea",{ref:"editor",staticClass:"tinymce-textarea",staticStyle:{height:"300px"},attrs:{id:t.id}}),t._v(" "),i("file-upload",{directives:[{name:"show",rawName:"v-show",value:t.imagecropperShow,expression:"imagecropperShow"}],attrs:{width:300,height:300,type:t.acceptType,url:"/app/xlgl/xlgldocumentfile/upLoadFile","lang-type":"zh-cn"},on:{close:t.close,"crop-upload-success":t.cropSuccess}})],1)},o=[],r=(i("6b54"),i("c5f6"),i("4437"),i("e6ff"),i("2e32"),function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"show",rawName:"v-show",value:t.value,expression:"value"}],staticClass:"vue-image-crop-upload"},[i("div",{staticClass:"vicp-wrap"},[i("div",{staticClass:"vicp-close",on:{click:t.off}},[i("i",{staticClass:"vicp-icon4"})]),t._v(" "),i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:t.type,action:"/app/xlgl/xlgldocumentfile/upLoadFile",limit:1,name:t.field,"list-type":"picture","on-preview":t.handlePreview,"on-remove":t.handleRemove,"on-success":t.successFn,"on-error":t.errorFn}},[i("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")])],1),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"20px",bottom:"20px",cursor:"pointer"}},[i("el-button",{attrs:{type:"text"},on:{click:t.off}},[t._v("取消")]),t._v(" "),i("el-button",{attrs:{type:"text"},on:{click:t.saveFn}},[t._v("保存")])],1)],1)])}),a=[],s={props:{url:{type:String,default:""},field:{type:String,default:"pdf"},value:{default:!0},type:{type:String,default:""}},data:function(){return{createImgUrl:""}},methods:{off:function(){this.$emit("close"),this.$refs.upload.clearFiles(),this.createImgUrl=""},handleRemove:function(t,e){},handlePreview:function(t){},saveFn:function(){this.$emit("crop-upload-success",this.createImgUrl),this.$refs.upload.clearFiles(),this.createImgUrl=""},successFn:function(t){this.createImgUrl=t.fileId},errorFn:function(){alert("上传失败，请重新上传！")}}},l=s,c=(i("7489"),i("2877")),u=Object(c["a"])(l,r,a,!1,null,"f163a08e",null),d=u.exports,p={name:"Ueditor",components:{FileUpload:d},props:{value:{type:String,default:""},toolbar:{type:Array,required:!1,default:function(){return[]}},menubar:{type:String,default:"file edit insert view format table"},height:{type:[Number,String],required:!1,default:300},width:{type:[Number,String],required:!1,default:"auto"},config:{type:Object,default:function(){return{autoHeightEnabled:!1,autoFloatEnabled:!0,intialContent:"",autoClearinitialContent:!0,initialFrameWidth:null,initialFrameHeight:450,BaseUrl:"",UEDITOR_HOME_URL:"/ueditor/"}}}},data:function(){return{id:"ueditorId"+Math.random().toString(16).substring(2),editor:null,imagecropperShow:!1,imagecropperKey:0,image:null,flag:"",acceptType:""}},created:function(){},mounted:function(){var t=this;this.$nextTick(function(){t.initEditor()})},methods:{initEditor:function(){var t=this;this.$refs.editor.id=this.id,this.editor=UE.getEditor(this.id,{toolbars:[["fullscreen","print","fontFamily","fontsize","formatMatch","source","time","undo","redo","bold","italic","fontBorder","justifyleft","justifycenter","justifyright","justifyjustify","insertimage","insertvideo","",""]]}),this.editor.ready(function(){t.value&&t.editor.setContent(t.value),document.getElementsByClassName("edui-for-insertimage")[0].onclick=function(){t.imagecropperShow=!0,t.flag=0,t.acceptType=".png,.jpeg"},document.getElementsByClassName("edui-for-insertvideo")[0].onclick=function(){t.imagecropperShow=!0,t.flag=1,t.acceptType=".mp4"},t.editor.addListener("contentChange",function(){t.$emit("input",t.editor.getContent())})})},getContent:function(){return this.editor.getContent()},setContent:function(t){var e=this;this.editor.ready(function(){e.editor.setContent(t)})},destroyUE:function(){},cropSuccess:function(t){var e=this;""===t?0===this.flag?alert("请选择要上传的图片"):alert("请选择要上传的视频"):(this.imagecropperShow=!1,this.editor.ready(function(){0===e.flag?e.editor.setContent('<img src="/app/xlgl/xlgldocumentfile/downLoad?fileId='.concat(t,'">'),!0):e.editor.setContent('<video src="/app/xlgl/xlgldocumentfile/downLoad?fileId='.concat(t,'" controls="controls"></video>'),!0)}))},close:function(){this.imagecropperShow=!1}}},f=p,m=Object(c["a"])(f,n,o,!1,null,null,null);e["a"]=m.exports},7489:function(t,e,i){"use strict";var n=i("b898"),o=i.n(n);o.a},b898:function(t,e,i){},e78c:function(t,e,i){"use strict";var n=i("fdc5"),o=i.n(n);o.a},fdc5:function(t,e,i){}}]);