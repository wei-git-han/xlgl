(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0af4e3"],{"0e80":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:16}},[a("div",{staticClass:"div1"},[a("iframe",{attrs:{src:e.onlineFileUrl,frameborder:"0",width:"100%",height:"100%"}})])]),e._v(" "),a("el-col",{attrs:{span:8}},[a("div",{staticClass:"div1"},[a("div",{staticClass:"div2"},[a("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[a("el-table",{key:e.tableKey,ref:"filetable",attrs:{data:e.fileList,border:"",fit:"","highlight-current-row":""},on:{"row-click":e.handleCurrent}},[a("el-table-column",{attrs:{label:"文件名",align:"center","min-width":"150px"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("span",[e._v(e._s(n.name))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"上传时间",width:"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("span",[e._v(e._s(n.examineSubjectName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"上传人",width:"100px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("span",[e._v(e._s(n.updateDate))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"80px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.row;return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleModifyStatus(n,"delete")}}},[e._v("下载")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleModifyStatus(n,"delete")}}},[e._v("删除")])]}}])})],1)],1)],1)])])],1)],1)},l=[],i={name:"DetailLegalInfo",props:{fileList:{type:Array,default:function(){return[]}}},data:function(){return{tableKey:0,fileDialog:!1,fileData:{access_token:this.$store.state.user.token},fileUploadUrl:"",onlineFileUrl:"/app/openFile/demo.html"}},mounted:function(){this.$refs.filetable.setCurrentRow(this.fileList[0])},methods:{handleCurrent:function(e){this.$refs.filetable.setCurrentRow(e)},handleModifyStatus:function(e,t){var a=this;deleteFileById({ids:e.id}).then(function(e){0===e.data.code?a.$message({type:"success",message:"删除成功!",onClose:function(){a.getTestList()}}):a.$message({type:"info",message:e.data.msg})})}}},s=i,r=a("2877"),o=Object(r["a"])(s,n,l,!1,null,"a67ee03a",null);t["default"]=o.exports}}]);