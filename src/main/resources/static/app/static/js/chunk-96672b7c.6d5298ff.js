(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-96672b7c","chunk-2d210108","chunk-2d0a47b1","chunk-2d0bdede","chunk-2d0cbad5"],{"072f":function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{class:t.className,style:{height:t.height,width:t.width}})},s=[],n=(e("7f7f"),e("313e")),r=e.n(n),l=e("a7dc");e("817d");var o=150,c={normal:{label:{show:!1},labelLine:{show:!1}}},h={name:"PeopleGrade",mixins:[l["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0}},data:function(){return{chart:null,serialData:[],legendData:[],colors:["#3FEC63","#FF5C6D","#348AFF"]}},watch:{chartData:{deep:!0,handler:function(t){for(var a=0;a<t.length;a++){this.legendData.push(t[a].name);var e={name:t[a].name,type:"pie",clockWise:!0,hoverAnimation:!1,radius:[110-20*a,120-20*a],itemStyle:c,label:{normal:{show:!1}},data:[{value:t[a].value,itemStyle:{normal:{color:this.colors[a]}}},{value:o-t[a].value,itemStyle:{normal:{color:"#222C60"}}}]};this.serialData.push(e)}this.initChart()}}},mounted:function(){this.initChart()},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=r.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!1},tooltip:{show:!0,trigger:"item",formatter:function(t,a,e){return t.seriesName+"："+t.value},color:this.colors},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},legend:{show:!0,left:"center",y:"top",icon:"circle",itemHeight:20,itemGap:10,data:this.legendData,textStyle:{color:"#fff"},selectedMode:!0,orient:"horizontal"},series:this.serialData})}}},d=h,u=e("2877"),p=Object(u["a"])(d,i,s,!1,null,"4f1e12f4",null);a["default"]=p.exports},"2da7":function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{class:t.className,style:{height:t.height,width:t.width}})},s=[],n=e("313e"),r=e.n(n),l=e("a7dc");e("817d");var o=6e3,c={mixins:[l["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"300px"},chartData:{type:Array,required:!0}},data:function(){return{chart:null,xData:[],yData1:[],yData2:[],yData3:[]}},watch:{chartData:{deep:!0,handler:function(t){for(var a=0;a<t.length;a++)this.xData.push(t[a].depart),this.yData1.push(t[a].value1),this.yData2.push(t[a].value2),this.yData3.push(t[a].value3);this.initChart()}}},mounted:function(){var t=this;this.$nextTick(function(){t.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=r.a.init(this.$el,"macarons"),this.chart.setOption({tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},dataZoom:[{type:"inside",start:0,throttle:50,minValueSpan:4,end:100}],xAxis:[{type:"category",data:this.xData,interval:0,axisTick:{alignWithLabel:!0},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12}}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}}}],legend:{orient:"horizontal",x:"center",y:"top",data:["优秀","优良","及格"],textStyle:{color:"#fff"}},series:[{name:"优秀",type:"bar",stack:"vistors",barWidth:"60%",data:this.yData1,animationDuration:o},{name:"优良",type:"bar",stack:"vistors",barWidth:"60%",data:this.yData2,animationDuration:o},{name:"及格",type:"bar",stack:"vistors",barWidth:"60%",data:this.yData3,animationDuration:o}]})}}},h=c,d=e("2877"),u=Object(d["a"])(h,i,s,!1,null,null,null);a["default"]=u.exports},"4b4e":function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{class:t.className,style:{height:t.height,width:t.width}})},s=[],n=(e("7f7f"),e("313e")),r=e.n(n),l=e("a7dc");e("817d");var o={mixins:[l["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0}},data:function(){return{chart:null,legendData:[],colors:["#3377FF","#FF6363","#FACC89","#5D2FC6","#F9D44C","#1DC053","#FF9151"],total:0}},watch:{chartData:{deep:!0,handler:function(t){for(var a=0;a<t.length;a++)this.total+=t[a].value,this.legendData.push(t[a].name);this.initChart()}}},mounted:function(){},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=r.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,text:"共装备：（件）",left:"30%",top:"middle",itemGap:20,subtext:this.total,subtextStyle:{align:"center",fontSize:18,color:"#ffffff"}},tooltip:{trigger:"item",formatter:"{a} <br/>{b}: {c}",color:"#000",textStyle:{color:"#fff"}},grid:{top:10,left:20,right:20,bottom:20,containLabel:!0},legend:{orient:"vertical",x:"right",y:"center",data:this.legendData,textStyle:{color:"#fff"}},series:[{name:"",type:"pie",radius:["60%","70%"],center:["40%","50%"],color:this.colors,label:{normal:{show:!1,position:"left"},emphasis:{show:!0,textStyle:{fontSize:"16",fontWeight:"blod"}}},labelLine:{normal:{show:!1}},data:this.chartData}]})}}},c=o,h=e("2877"),d=Object(h["a"])(c,i,s,!1,null,null,null);a["default"]=d.exports},"742e":function(t,a,e){"use strict";var i=e("ba6c"),s=e.n(i);s.a},ac67:function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"statistics"},[e("el-container",[e("el-header",{staticStyle:{"line-height":"60px"}},[e("span",{staticClass:"timeSty"},[t._v(t._s(t._f("parseTime")(t.currentTime,"{y}年{m}月{d}日 {h}:{i}:{s}")))]),t._v(" "),e("div",{staticClass:"titleSty"},[t._v(t._s(t.title))])]),t._v(" "),e("el-main",[e("el-row",{staticClass:"heightC",attrs:{gutter:20}},[e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:16}},[e("div",{staticClass:"titleDiv"},[t._v("\n                  参训情况统计\n                  "),e("span",{staticClass:"morePosition"},[t._v("查看详情 >")])]),t._v(" "),e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple"},[e("div",[e("finish-rate",{attrs:{"chart-data":t.finishRateList}})],1)])]),t._v(" "),e("el-col",{staticStyle:{position:"absolute",right:"0px"},attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple",staticStyle:{position:"relative",height:"100%"}},t._l(t.tableData,function(a,i){return e("div",{key:i,staticClass:"size1"},[e("div",[t._v(t._s(a.title)+"：")]),t._v(" "),e("div",{staticClass:"numDiv"},[e("span",[t._v(t._s(a.num))]),t._v(" "),e("span",4==i?[t._v("%")]:[t._v("/次")])])])}),0)])],1)],1),t._v(" "),e("el-col",{staticStyle:{height:"400px"},attrs:{span:8}},[e("div",[t._v("\n                  最近组训信息\n                ")]),t._v(" "),e("div",{staticStyle:{margin:"20px 0px"}},[e("div",[t._v("\n                    已报名："+t._s(t.lastinfo.total)+"/人\n                  ")]),t._v(" "),e("div",{staticClass:"title gap",attrs:{title:t.lastinfo.title}},[t._v("\n                    "+t._s(t.lastinfo.title)+"\n                  ")]),t._v(" "),e("div",{staticClass:"gap"},[e("span",[t._v(t._s(t.lastinfo.startTime))]),t._v(" "),e("span",[t._v(t._s(t.lastinfo.place))])]),t._v(" "),e("div",{attrs:{title:t.lastinfo.description}},[t._v("\n                    "+t._s(t.lastinfo.description)+"\n                    "),e("span",[t._v("[详情]")])]),t._v(" "),e("ul",{staticClass:"activeUl"},[e("li",[t._v("截止时间："+t._s(t.lastinfo.endTime))]),t._v(" "),t._l(t.lastinfo.content,function(a,i){return e("li",{key:i},[t._v(t._s(a.name))])})],2),t._v(" "),e("div",{staticStyle:{"text-align":"center"}},[e("el-button",{attrs:{type:"primary"}},[t._v("查看详情")])],1),t._v(" "),e("div",[t._v("\n                    倒计时：\n                  ")])])])],1)],1)]),t._v(" "),e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple",staticStyle:{position:"relative",width:"100%",height:"100%"}},[e("div",{staticClass:"titleDiv"},[t._v("\n              人员在位统计\n              "),e("span",{staticClass:"morePosition"},[t._v("查看详情 >")])]),t._v(" "),e("el-row",{staticClass:"row-bg",attrs:{type:"flex",justify:"space-around"}},[e("el-col",{attrs:{span:6}},[e("el-progress",{attrs:{type:"circle",percentage:25,width:100,"stroke-width":12,color:"#FD5C3D"}}),t._v(" "),e("div",[t._v("\n                  人员在位率\n                ")])],1),t._v(" "),e("el-col",{attrs:{span:6}},[e("el-progress",{attrs:{type:"circle",percentage:25,width:100,"stroke-width":12,color:"#8EF624"}}),t._v(" "),e("div",[t._v("\n                  人员在编率\n                ")])],1),t._v(" "),e("el-col",{attrs:{span:6}},[e("el-progress",{attrs:{type:"circle",percentage:25,width:100,"stroke-width":12,color:"#23DEFE"}}),t._v(" "),e("div",[t._v("\n                  人员修假完成率\n                ")])],1),t._v(" "),e("el-col",{attrs:{span:6}},[e("el-progress",{attrs:{type:"circle",percentage:25,width:100,"stroke-width":12,color:"#F9D44C"}}),t._v(" "),e("div",[t._v("\n                  缺编人数\n                ")])],1)],1),t._v(" "),e("el-row",{staticStyle:{position:"absolute",top:"195px",bottom:"20px",overflow:"hidden",width:"100%"}},[e("el-scrollbar",{staticClass:"hidden-x",staticStyle:{overflow:"hidden",height:"100%"}},[e("el-table",{staticClass:"new-table",staticStyle:{width:"100%"},attrs:{data:t.tableData1,border:"",fit:!0}},[e("el-table-column",{attrs:{prop:"depart",label:"单位",align:"center","min-width":"120"}}),t._v(" "),e("el-table-column",{attrs:{prop:"inlineNum",label:"在位人数",align:"center"}}),t._v(" "),e("el-table-column",{attrs:{prop:"realitynum",label:"实际人数",align:"center"}}),t._v(" "),e("el-table-column",{attrs:{prop:"inlineRate",label:"在位率",align:"center"}}),t._v(" "),e("el-table-column",{attrs:{prop:"plaitRate",label:"在编率",align:"center"}}),t._v(" "),e("el-table-column",{attrs:{prop:"leaveRate",label:"请假完成率",align:"center","min-width":"90"}})],1)],1)],1)],1)])],1),t._v(" "),e("el-row",{staticClass:"heightC",attrs:{gutter:20}},[e("el-col",{attrs:{span:10}},[e("div",{staticClass:"grid-content bg-purple"},[e("div",{staticClass:"titleDiv"},[t._v("\n              各单位历年训练成绩对比\n              "),e("span",{staticClass:"morePosition"},[t._v("全部成绩 >")])]),t._v(" "),e("div",[e("train-grade",{attrs:{"chart-data":t.gradeList}})],1)])]),t._v(" "),e("el-col",{attrs:{span:6}},[e("div",{staticClass:"grid-content bg-purple"},[e("div",{staticClass:"titleDiv"},[t._v("\n              人员训练成绩统计\n              "),e("span",{staticClass:"morePosition"},[t._v("查看详情 >")])]),t._v(" "),e("el-row",{staticClass:"row-bg",attrs:{type:"flex",justify:"space-around"}},[e("el-col",{attrs:{span:24}},[e("people-grade",{attrs:{"chart-data":t.peopleGradeList}})],1)],1)],1)]),t._v(" "),e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("div",{staticClass:"titleDiv"},[t._v("\n              武器装备统计\n              "),e("span",{staticClass:"morePosition"},[t._v("查看详情 >")])]),t._v(" "),e("el-row",{staticClass:"row-bg",attrs:{type:"flex",justify:"space-around"}},[e("el-col",{attrs:{span:24}},[e("Weapon",{attrs:{"chart-data":t.weaponList}})],1)],1)],1)])],1)],1)],1)],1)},s=[],n=e("b775");function r(t,a){return Object(n["a"])({url:"/statistics/".concat(t),method:"get",data:a})}function l(){return Object(n["a"])({url:"/statistics/inlineTable",method:"get"})}function o(){return Object(n["a"])({url:"/statistics/numList",method:"get"})}function c(){return Object(n["a"])({url:"/statistics/weaponList",method:"get"})}function h(){return Object(n["a"])({url:"/statistics/gradeList",method:"get"})}function d(){return Object(n["a"])({url:"/statistics/peopleGradeList",method:"get"})}function u(){return Object(n["a"])({url:"/statistics/lastInfo",method:"get"})}var p=e("2da7"),f=e("b5fe"),v=e("4b4e"),g=e("072f"),m={name:"Statistics",components:{TrainGrade:p["default"],FinishRate:f["default"],Weapon:v["default"],PeopleGrade:g["default"]},data:function(){return{currentTime:new Date,title:"训练管理数据态势",finishRateList:[],tableData:[],tableData1:[],weaponList:[],gradeList:[],peopleGradeList:[],lastinfo:{}}},mounted:function(){this.getFinishRateList(),this.getInlineList(),this.getNumList(),this.getWeaponList(),this.getGradeList(),this.getPeopleGradeList(),this.getLastInfo()},methods:{getFinishRateList:function(){var t=this;r("finishRateList").then(function(a){t.finishRateList=a.data})},getInlineList:function(){var t=this;l().then(function(a){t.tableData1=a.data})},getNumList:function(){var t=this;o().then(function(a){t.tableData=a.data})},getWeaponList:function(){var t=this;c().then(function(a){t.weaponList=a.data})},getGradeList:function(){var t=this;h().then(function(a){t.gradeList=a.data})},getPeopleGradeList:function(){var t=this;d().then(function(a){t.peopleGradeList=a.data})},getLastInfo:function(){var t=this;u().then(function(a){t.lastinfo=a.data[0]})}}},y=m,b=(e("742e"),e("2877")),_=Object(b["a"])(y,i,s,!1,null,"2c0d9202",null);a["default"]=_.exports},b5fe:function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{class:t.className,style:{height:t.height,width:t.width}})},s=[],n=e("313e"),r=e.n(n),l=e("a7dc");e("817d");var o=6e3,c={mixins:[l["default"]],props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Array,required:!0}},data:function(){return{chart:null,xData:[],yData:[]}},watch:{chartData:{deep:!0,handler:function(t){for(var a=0;a<t.length;a++)this.xData.push(t[a].departName),this.yData.push(t[a].value);this.initChart()}}},mounted:function(){this.$nextTick(function(){for(var t=0;t<this.chartData.length;t++)this.xData.push(this.chartData[t].departName),this.yData.push(this.chartData[t].value);this.initChart()})},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){this.chart=r.a.init(this.$el,"macarons"),this.chart.setOption({title:{show:!0,subtext:"各单位受训完成率分析",subtextStyle:{color:"#2f8fdc"}},tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{top:50,left:"2%",right:"2%",bottom:"3%",containLabel:!0},dataZoom:[{type:"inside",start:0,throttle:50,minValueSpan:4,end:100}],xAxis:[{type:"category",data:this.xData,interval:0,axisTick:{alignWithLabel:!0},axisLabel:{textStyle:{color:"#ACACAC",fontSize:12}}}],yAxis:[{type:"value",axisTick:{show:!1},min:0,max:100,splitNumber:5,axisLabel:{textStyle:{color:"#ACACAC",fontSize:12},formatter:function(t){return t+"%"}},splitLine:{lineStyle:{type:"dotted",color:"#ACACAC"}}}],series:[{name:"",type:"bar",barWidth:20,label:{normal:{show:!0,position:"top",textStyle:{color:"#58B4FD"}}},itemStyle:{normal:{color:new r.a.graphic.LinearGradient(0,0,0,1,[{offset:1,color:"#2C76EC"},{offset:0,color:"#58B4FD"}]),barBorderRadius:[30,30,0,0],label:{show:!1}}},data:this.yData,animationDuration:o}]})}}},h=c,d=e("2877"),u=Object(d["a"])(h,i,s,!1,null,null,null);a["default"]=u.exports},ba6c:function(t,a,e){}}]);