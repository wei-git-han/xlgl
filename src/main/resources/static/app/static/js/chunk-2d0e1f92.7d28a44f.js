(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0e1f92"],{"7d5d":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"chart",style:{height:e.height,width:e.width}})},o=[],l=a("313e"),n=a.n(l);a("817d");var r={name:"PeopleGrade",props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},departName:{type:String,default:""},excellenceRate:{type:String,default:""},excellentRate:{type:String,default:""},failRate:{type:String,default:""}},data:function(){return{chart:null,serialData:[],legendData:[],colors:["#3FEC63","#FF5C6D","#348AFF"]}},watch:{departName:{deep:!0,handler:function(){this.initChart()}}},mounted:function(){this.$nextTick(function(){this.initChart()})},methods:{initChart:function(){this.chart=n.a.init(this.$el,"macarons");var e="10",t={normal:{label:{show:!1,position:"outside"},labelLine:{show:!1,length:100,smooth:.5},borderColor:"#BEBEBE"},emphasis:{color:"#dedede",borderC:"#dedede",borderWidth:0}};this.chart.setOption({title:{show:!0,subtext:"".concat(this.departName,"人员年度训练成绩统计"),subtextStyle:{color:"#16191C",fontSize:"16"}},color:["#22C86E","#FF725E","#4976FF"],series:[{name:"优秀率",type:"pie",clockWise:!0,hoverAnimation:!1,radius:[100,101],itemStyle:{normal:{label:{show:!1,position:"outside"},labelLine:{show:!1,length:10,smooth:.5},borderWidth:e,borderColor:"#22C86E"}},data:[{value:this.excellenceRate,name:""},{value:100,name:"",itemStyle:t}]},{name:"优良率",type:"pie",clockWise:!0,hoverAnimation:!1,radius:[80,81],itemStyle:{normal:{label:{show:!1,position:"outside"},labelLine:{show:!1,length:100,smooth:.5},borderWidth:e,borderColor:"#FF725E"}},data:[{value:this.excellentRate,name:""},{value:100,name:"",itemStyle:t}]},{name:"及格率",type:"pie",clockWise:!0,hoverAnimation:!1,radius:[60,61],itemStyle:{normal:{label:{show:!1,position:"outside"},labelLine:{show:!1,length:100,smooth:.5},borderWidth:e,borderColor:"#4976FF"}},data:[{value:this.failRate,name:""},{value:100,name:"",itemStyle:t}]}]})}}},s=r,d=a("2877"),h=Object(d["a"])(s,i,o,!1,null,"a5fed75e",null);t["default"]=h.exports}}]);