(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b21d8"],{2378:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{width:"1100px",height:"720px"},attrs:{id:"myChinaMap"}})},o=[],i=a("313e"),r=a.n(i);a("3139");var l={props:{dataNum:{type:Array,default:function(){return[]}}},data:function(){return{chart:null}},watch:{dataNum:{deep:!0,handler:function(){this.initChart()}}},mounted:function(){this.$nextTick(function(){this.initChart()})},methods:{initChart:function(){this.chart=r.a.init(this.$el,"china"),this.chart.setOption({tooltip:{trigger:"item"},selectedMode:"single",dataRange:{splitList:[{start:500,color:"#EF5366"},{start:301,end:500,color:"#F86F1A"},{start:101,end:300,color:"#53D591"},{start:1,end:100,color:"#65BBFF"},{end:1,color:"#ccc"}],textStyle:{color:"#3899FF"}},series:[{name:"人员分布情况",type:"map",zoom:1.2,map:"china",itemStyle:{normal:{label:{show:!0},color:"#53D591",areaColor:"#eff6ff"},emphasis:{label:{show:!0},areaColor:"#cbe2ff"}},showLegendSymbol:!1,roam:!0,label:{normal:{show:!0},emphasis:{show:!0}},data:this.dataNum}]})}}},s=l,c=a("2877"),h=Object(c["a"])(s,n,o,!1,null,null,null);e["default"]=h.exports}}]);