(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0e59c2"],{"94e6":function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{class:t.className,style:{height:t.height,width:t.width}})},r=[],o=e("313e"),s=e.n(o),n=e("a7dc");e("817d");var h=6e3,l={mixins:[n["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0},chartTitle:{type:String,default:""}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){for(var a=0;a<t.length;a++)this.xData.push(t[a].departName),this.yData.push(t[a].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=s.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:this.chartTitle,subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"5%",right:"2%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",data:this.xData,axisTick:{show:!1},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},rotate:20}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new s.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:h}]})}}},c=l,u=e("2877"),d=Object(u["a"])(c,i,r,!1,null,null,null);a["default"]=d.exports}}]);