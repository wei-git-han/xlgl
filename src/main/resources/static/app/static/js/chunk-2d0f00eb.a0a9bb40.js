(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0f00eb"],{"9b6b":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:12}},[a("el-col",{attrs:{span:16}},[a("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 105px)"},attrs:{"body-style":{padding:"0px 10px"}}},[a("title-card",{attrs:{"title-text":"下载上传"}}),t._v(" "),a("el-form",{staticStyle:{"margin-top":"30px"},attrs:{model:t.form,"label-width":"100px"}},[a("el-row",{attrs:{span:24}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"单位："}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.form.sex,callback:function(e){t.$set(t.form,"sex",e)},expression:"form.sex"}},[a("el-option",{attrs:{label:"单位1",value:"0"}}),t._v(" "),a("el-option",{attrs:{label:"单位2",value:"1"}})],1)],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"40%","margin-top":"50px"}},[a("div",{staticStyle:{"margin-bottom":"30px","font-weight":"bolder"}},[t._v("下载模板")]),t._v(" "),a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.downloadFile,limit:3,accept:".mp4,.png,.jpeg","show-file-list":t.showImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("p",{staticStyle:{"font-size":"12px"}},[t._v("支持用户上传扫描文件或者图片格式.png/.jpeg等格式")])])])],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"40%","margin-top":"50px"}},[a("div",{staticStyle:{"margin-bottom":"30px","font-weight":"bolder"}},[t._v("上传文件")]),t._v(" "),a("el-upload",{staticClass:"upload-demo uploadImg",attrs:{drag:"",action:"/app/xlgl/xlgldocumentfile/upLoadFile",name:"pdf","on-success":t.uploadImg,limit:2,accept:".mp4,.png,.jpeg","show-file-list":t.showImg,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n                将文件拖到此处，或"),a("em",[t._v("点击上传")]),t._v(" "),a("p",{staticStyle:{"font-size":"12px"}},[t._v("支持用户上传扫描文件或者图片格式.png/.jpeg等格式")])])]),t._v(" "),a("el-col",{attrs:{span:6}},[a("ul",{staticClass:"el-upload-list el-upload-list--text"},t._l(t.imgList,function(e,l){return a("li",{key:l,staticClass:"el-upload-list__item is-success el-list-enter-to",attrs:{tabindex:"0"}},[a("a",{staticClass:"el-upload-list__item-name"},[a("i",{staticClass:"el-icon-document"}),t._v(t._s(e.name)+"\n                  ")]),t._v(" "),a("label",{staticClass:"el-upload-list__item-status-label"},[a("i",{staticClass:"el-icon-upload-success el-icon-circle-check"})]),t._v(" "),a("i",{staticClass:"el-icon-close",on:{click:function(a){return t.deleteFn(e)}}})])}),0)])],1)],1)],1)],1),t._v(" "),a("el-col",{attrs:{span:8}},[a("el-card",{staticClass:"margin-card",staticStyle:{height:"calc(98vh - 105px)"},attrs:{"body-style":{padding:"0px 10px"}}},[a("title-card",{attrs:{"title-text":"上传记录"}}),t._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,border:"",stripe:""}},[a("el-table-column",{attrs:{prop:"type",label:"上传单位",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"date",label:"上传时间",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center",width:"70"}},[[a("el-button",{attrs:{type:"text"},on:{click:t.withdraw}},[t._v("撤回")])]],2)],1)],1)],1)],1)],1)},s=[],i=(a("7f7f"),a("35b7")),o={components:{TitleCard:i["a"]},data:function(){return{tableData:[{date:"2016-05-02",sex:"男",type:"一",age:"26-27岁"},{date:"2016-05-02",sex:"男",type:"一",age:"26-27岁"},{date:"2016-05-02",sex:"男",type:"一",age:"26-27岁"},{date:"2016-05-02",sex:"男",type:"一",age:"26-27岁"}],form:{sex:"",age:"",type:""},showImg:!1,imgList:[]}},methods:{uploadImg:function(t,e){this.imgList.push({name:e.raw.name,type:e.raw.type,id:t.fileId})},downloadFile:function(){},confirm:function(){},withdraw:function(){}}},c=o,n=a("2877"),p=Object(n["a"])(c,l,s,!1,null,"569fcb12",null);e["default"]=p.exports}}]);