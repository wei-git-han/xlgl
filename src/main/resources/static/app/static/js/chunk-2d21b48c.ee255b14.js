(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21b48c"],{beb5:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{class:t.className,style:{height:t.height,width:t.width}})},l=[],n=a("313e"),r=a.n(n);a("817d");var o={props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0}},data:function(){return{chart:null,xData:[],yData:[]}},mounted:function(){this.initChart()},methods:{initChart:function(){this.chart=r.a.init(this.$el,"macarons");var t={normal:{rotate:90,textStyle:{align:"left",verticalAlign:"middle"}}};this.chart.setOption({title:{show:!0,subtext:"各单位年度训练成绩对比",subtextStyle:{color:"#16191C",fontSize:"16"}},color:["#22C86E","#FF725E","#4976FF"],tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},legend:{data:["优秀率","优良率","及格率"],selectedMode:!1},calculable:!0,xAxis:[{type:"category",axisTick:{show:!1},data:["单位1","单位2","单位3","单位4","单位5","单位6"],axisLabel:{textStyle:{color:"#9F9FA3"},rotate:40},axisLine:{lineStyle:{color:"#9F9FA3"}}}],yAxis:[{type:"value",axisLabel:{textStyle:{color:"#9F9FA3"}},axisLine:{lineStyle:{color:"#9F9FA3"}}}],series:[{name:"优秀率",type:"bar",barGap:0,label:t,barWidth:20,data:[320,332,301,334,390,180]},{name:"优良率",type:"bar",label:t,barWidth:20,data:[220,182,191,234,290,100]},{name:"及格率",type:"bar",label:t,barWidth:20,data:[150,232,201,154,190,200]}]})}}},s=o,c=a("2877"),d=Object(c["a"])(s,i,l,!1,null,null,null);e["default"]=d.exports}}]);