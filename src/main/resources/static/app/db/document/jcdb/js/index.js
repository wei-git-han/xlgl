var url1 = {"url":"/app/db/documentjcdb/list","dataType":"text"};
//var url2 = {"url":"../data/json2.json","dataType":"text"};
var url2 = {"url":"/app/db/documentjcdb/orglist","dataType":"text"};
var url3 = {"url":"/app/db/documentjcdb/orglist2","dataType":"text"};
//var url3 = {"url":"../data/json3.json","dataType":"text"};
var url4 = {"url":"/app/db/documentjcdb/orglist3","dataType":"text"};
var url5 = {"url":"/app/db/documentjcdb/orglist4","dataType":"text"};
//var url5 = {"url":"../data/json5.json","dataType":"text"};
var pageModule = function(){
	
	var inittopfn = function(){
		
		$ajax({
			url:url1,
			success:function(data){
				
				var year = data.year;
				var total = data.total;
				var blz = data.blz;
				var bj = data.bj;
				var ctls = data.ctls;
				var wcl = data.wcl;
				
				$("#year").html(year);
				
				$("#total").attr("title",total);
				
				if(total>9999){
					$("#total").html("9999+");
				}else{
					$("#total").html(total);
				}
				
				$("#blz").attr("title",blz);
				if(blz>9999){
					$("#blz").html("9999+");
				}else{
					$("#blz").html(blz);
				}
				
				$("#bj").attr("title",bj);
				if(bj>9999){
					$("#bj").html("9999+");
				}else{
					$("#bj").html(bj);
				}
				
				$("#ctls").attr("title",ctls);
				if(ctls>9999){
					$("#ctls").html("9999+");
				}else{
					$("#ctls").html(ctls);
				}
				
				$("#wcl").html(wcl);
				
			}
		});
		
	}
	
	
	var inittable = function(month){
		
		$ajax({
			url:url2,
			data:{month:month},
			success:function(data){
				$("#tbody").html('');
				$.each(data,function(i){
					var id = this.id;
					var dwname = this.dwname;
					var blz = this.blz;
					var bj = this.bj;
					var ctls = this.ctls;
					var state = this.state;
					var type = this.type;
					var month_ = month;
					var html = ` style="cursor:pointer" onclick="topage('${id}','${type}','${month_}')" `;
					if(state==0){html=""}
					$("#tbody").append(
						`
							<tr id="${id}" ${html}>
								<td>${i+1}</td>
								<td title="${dwname}">${dwname}</td>
								<td>${blz}</td>
								<td>${bj}</td>
								<td>${ctls}</td>
							</tr>
						`
					);
				});
				$("#tbody tr").unbind("click");
				$("#tbody tr").click(function(){
				})
			}
		});
		
	}
	
	var initpage = function(){
		require.config({
		    paths:{ 
		        echarts:'../js/echarts',
		        'echarts/chart/bar' : '../js/echarts-map',
		        'echarts/chart/line': '../js/echarts-map',
		        'echarts/chart/map' : '../js/echarts-map'
		    }
		});
		require(
		    [
		        'echarts',
		        'echarts/chart/bar',
		        'echarts/chart/line',
		        'echarts/chart/map'
		    ],
		    function (ec) {
		    	initchart1(ec);
		    	initchart2(ec);
		    	initchart3(ec);
		    }
		);
	}
	
	var initchart1 = function(ec){
		$ajax({
			url:url3,
			success:function(data){
				var legend = data.legend;
				var xdata = data.xdata;
				var blzdata = data.blzdata
				var bjdata = data.bjdata
				var ctlsdata = data.ctlsdata
				//var myChart = echarts.init(document.getElementById('chart1'));
			    var myChart = ec.init(document.getElementById('chart1'));
			    myChart.setOption({
			    	grid:{
			    		x:50,
			    		y:30,
			    		x2:30,
			    		y2:80,
			    		borderWidth:0
			    	},
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				    	padding:[0,30,0,0],
				    	x:"right",
				    	textStyle:{color: '#C8D3FF'},
				        data:legend
				    },
				    xAxis : [
				        {
				        	splitLine:false,
				        	axisLine:{
				        		lineStyle:{color: '#C8D3FF', width: 1, type: 'solid'}
				        	},
				        	axisTick:{
				        		lineStyle:{color: '#C8D3FF', width: 1} 
				        	},
				        	axisLabel:{
				        		rotate:40,
				        		textStyle:{color: '#C8D3FF'}
				        	},
				            type : 'category',
				            data : xdata
				        }
				    ],
				    yAxis : [
				        {
				        	axisLine:false,
				        	splitLine:{
				        		lineStyle:{color: ['#223172'], width: 1, type: 'solid'}
				        	},
				        	axisLabel:{
				        		textStyle:{color: '#C8D3FF'}
				        	},
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'办理中',
				            itemStyle:{
							    normal: {
							    	color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#F7EFA7'],[1, '#F59C24']]
				                        )
				                    })()
							    }
				            },
				            type:'bar',
				            barWidth:10,
				            data:blzdata
				        },
				        {
				            name:'办结',
				            itemStyle:{
							    normal: {
							    	color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#CCEBFF'],[1, '#2472D6']]
				                        )
				                    })()
							    }
				            },
				            type:'bar',
				            barWidth:10,
				            data:bjdata
				        },
				        {
				            name:'常态落实',
				            itemStyle:{
							    normal: {
							    	color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#EDBBBC'],[1, '#FF3E3E']]
				                        )
				                    })()
							    }
				            },
				            type:'bar',
				            barWidth:10,
				            data:ctlsdata
				        }
				    ]
			    });
			    
			    var otherdata = data.otherdata;
				myChart.on("click",function(o,n){
					
					console.log(otherdata)
					var name = o.name;
					var seriesIndex = o.seriesIndex;
					var value = o.value;
					
					var object = otherdata[name];
					var state = object.state;
					var id = object.id;
					var type = object.type;
					var month = object.month;
					var ytype = 0;
					console.log(state);
					if(seriesIndex==0){
						ytype = 1;
					}else if(seriesIndex==1){
						ytype = 2;
					}else if(seriesIndex==2){
						ytype = 3;
					}
					if(state!=0){
						topage(id,type,month,ytype);
					}
					
				})
			}
		});
		
	}
	
	var initchart2 = function(ec){
		
		$ajax({
			url:url4,
			success:function(data){
				var legend = data.legend;
				var valdata = data.valdata;
				var array = [
								{itemStyle:{normal: {color:"#87CEFA"}}},
								{itemStyle:{normal: {color:"#A3A4A8"}}},
								{itemStyle:{normal: {color:"#4675CF"}}},
								{itemStyle:{normal: {color:"#F37923"}}},
								{itemStyle:{normal: {color:"#FFBB04"}}},
								{itemStyle:{normal: {color:"#73AF3D"}}},
							]
				$.each(valdata,function(i){
					this.itemStyle = array[i].itemStyle;
				});
				//var myChart = echarts.init(document.getElementById('chart2'));
			    var myChart = ec.init(document.getElementById('chart2'));
			    myChart.setOption({
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				    	textStyle:{color: '#C8D3FF'},
				        orient : 'vertical',
				        x : 'right',
				        data:legend
				    },
				    calculable : false,
				    series : [
				        {
				            name:'落实事项',
				            type:'pie',
				            center:['40%', '50%'],
				            radius : ['50%', '70%'],
				            itemStyle : {
							    normal: {
							        label:{
							        	show:true,
							        	formatter:"{d}%",
							        	textStyle:{
							        		fontWeight:"bold"
							        	}
							        }
							    },
				            },
				            data:valdata
				        }
				    ]
				});
			}
		});
		
	}
	
	var initchart3 = function(ec){
		
		$ajax({
			url:url5,
			success:function(data){
				
				var xdata = data.xdata;
				var wcldata = data.wcldata;
				var array1 =[
								{itemStyle:{normal: {
									color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#F7EFA7'],[1, '#F59C24']]
				                        )
				                    })()
								}}},
								{itemStyle:{normal: {
									color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#CCEBFF'],[1, '#2472D6']]
				                        )
				                    })()
								}}},
								{itemStyle:{normal: {
									color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#EDBBBC'],[1, '#FF3E3E']]
				                        )
				                    })()
								}}},
								{itemStyle:{normal: {
									color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#F7EFA7'],[1, '#F59C24']]
				                        )
				                    })()
								}}},
								{itemStyle:{normal: {
									color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#CCEBFF'],[1, '#2472D6']]
				                        )
				                    })()
								}}},
								{itemStyle:{normal: {
									color : (function (){
				                        var zrColor = require('zrender/tool/color');
				                        return zrColor.getLinearGradient(
				                            0, 0, 0, 200,
				                            [[0, '#EDBBBC'],[1, '#FF3E3E']]
				                        )
				                    })()
								}}}
							];
				var array2 = []
				$.each(wcldata,function(i,val){
					var obj = {value:val,itemStyle:array1[i].itemStyle}
					array2.push(obj)
				})
				wcldata = array2;
				//var myChart = echarts.init(document.getElementById('chart3'));
			    var myChart = ec.init(document.getElementById('chart3'));
			    myChart.setOption({
			    	grid:{
			    		x:70,
			    		y:30,
			    		x2:30,
			    		y2:90,
			    		borderWidth:0
			    	},
				    tooltip : {
				        trigger: 'axis',
				        formatter: function(array){
		        			return array[0][1]+":"+array[0][2]+"%"
		        		}
				    },
				    xAxis : [
				        {
				        	splitLine:false,
				        	axisLine:false,
				        	axisTick:false,
				        	axisLabel:{
				        		rotate:30,
				        		textStyle:{color: '#C8D3FF'}
				        	},
				            type : 'category',
				            data : xdata
				        }
				    ],
				    yAxis : [
				        {
				        	axisLine:false,
				        	axisLabel:{
				        		textStyle:{color: '#C8D3FF'},
				        		formatter:function(val){
				        			return val+"%"
				        		}
				        	},
				        	splitLine:{
				        		lineStyle:{color: ['#223172'], width: 1, type: 'solid'}
				        	},
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'完成率',
				            itemStyle:{
							    normal: {
							    	label:{
							    		show:true,
							    		formatter:"{c}%"
							    	},
							    	color:"#76B1F3"
							    }
				            },
				            type:'bar',
				            barWidth:25,
				            data:wcldata
				        }
				    ]
			    });
				
			}
		});
		
	}
	
	var initother = function(){
		var newdate = new Date();
		var month = newdate.format("MM");
		$(".bs-select").val(month);
		
		$(".bs-select").selectpicker({
		    iconBase: "fa",
		    tickIcon: "fa-check"
		});
		$("#select").change(function(){
			var month = this.value;
			inittable(month);
		})
		
		inittable(month);
	}
	
	return{
		//加载页面处理程序
		initControl:function(){
			initpage();
			inittopfn();
			initother();
		}
	}
	
}();

var topage = function(orgid,type,month,ytype){
/*	alert(orgid);
	alert(type);
	alert(month);
	alert(ytype);
	if(null!=ytype&&typeof(ytype)!="undefined"&&""!=$.trim(ytype)){
	};*/
	if(type==1){
		gettop2().indexobject = {
			ifmenu:"false",
			orgid:orgid,
			month:month,
			ytype:ytype
		}
		window.location.href = "/app/db/document/jcdb/html/table.html?ifmenu=false&orgid="+orgid+"&month="+month+"&ytype="+ytype;
	}else{
		window.location.href = "/app/db/document/blfk/html/blfk.html?fileFrom=jcdb&ifmenu=false&orgid="+orgid+"&month="+month+"&ytype="+ytype;
	}
	
}