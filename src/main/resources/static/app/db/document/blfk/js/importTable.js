var tableList= {"url":"/app/db/documentinfo/replyList","dataType":"text"};//原table数据
var fileFrom=getUrlParam("fileFrom")||""; //文件来源
var typeId = getUrlParam("typeId");
var grid = null;
var grid2 = null;
var grid3 = null;
var total=0;//列表中，数据的总条数
var tableNum = getUrlParam("tableNum");
if(!window.top.memory){
	window.top.memory = {};
}
var o = window.top.memory;

var pageModule = function(){

	var initTableNum = function(){
		if(tableNum == "3"){ //部领导批示指示 
			window.top.memory.tree = "3";
			$("#gridcont3").show();
			$("#gridcont2").hide();
			$("#gridcont").hide();
			refreshgrid3();
		}else if(tableNum == "2"){//分工
			window.top.memory.tree = "2";
			$("#gridcont3").hide();
			$("#gridcont").hide();
			$("#gridcont2").show();
			refreshgrid2();
		}else{//批示
			window.top.memory.tree = "1";
			$("#gridcont3").hide();
			$("#gridcont2").hide();
			$("#gridcont").show();
			refreshgrid1();
		}
	}
	var initgrid = function(){
        grid = $("#gridcont").createGrid({
            columns:[
            	{display:"军委办件号",name:"",width:"8%",align:"left",title:true,render:function(rowdata,n){
               	 	return rowdata.banjianNumber;
                }},
                {display:"办理状态",name:"",width:"8%",align:"center",render:function(rowdata,n){
                	var statusName="";
               	 	var bgColor="";
               	 	if(rowdata.status==1){
	               	 	statusName="办理中";
	               		bgColor="#2BAA81";
            	 	}else if(rowdata.status==2){
	               	 	statusName="已办结";
	               		bgColor="#BCBCBC";
               	 	}else if(rowdata.status==3){
	               	 	statusName="常态落实";
	               	 	bgColor="#BCBCBC";
               	 	}
  				  	return '<div title="'+statusName+'" class="btn btn-xs btn-color" style="background-color:'+bgColor+';">'+statusName+'</div>';
                 }},
                 {display:"办件标题",name:"",width:"15%",align:"left",title:false,render:function(rowdata){
                	 var cuiban="";
                 	 if(rowdata.cuibanFlag=="1"){
                 		 cuiban = '<label class="cuibanlabel">催办</label>';
                	 }
                	 return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1" onclick="closeTable()">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"批示指示内容",name:"",width:"26%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 var szpsCont="";
                	 var leaderTime1="";
                	 if(rowdata.leaderTime!="" && rowdata.leaderTime!=null){
                		 leaderTime1= rowdata.leaderTime.substring(0,16);
                	 }
                	 if(rowdata.leaderName && rowdata.leaderContent){
                		 szpsCont=rowdata.leaderName+":"+rowdata.leaderContent+" "+leaderTime1
                	 }
                	 return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.id+'\')" title="'+szpsCont+'">'+szpsCont+'</div>';
                 }},
                 {display:"督办落实情况",name:"",width:"21%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 var duban="";
                 	 if(rowdata.updateFlag=="1"){
                 		duban = '<label class="cuibanlabel">已更新</label>';
                	 }
                	 var dbCont="";
                	 if(rowdata.latestReply){
                		dbCont=rowdata.latestReply;
                	 }
                	 return '<div class="dblsqk" onclick="dblsqkAlert(\''+rowdata.id+'\')" title="'+dbCont+'">'+duban+'<span>'+dbCont+'</span></div>';
                 }},
                 {display:"承办单位/人",name:"",width:"10%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 return '<div class="cbdw" title="'+rowdata.underDepts+'">'+rowdata.underDepts+'</div>'
                 }},
                 {display:"转办时间",name:"",width:"6%",align:"center",render:function(rowdata){
                	 if(rowdata.firstZbTime && !!rowdata.firstZbTime){
                		 return rowdata.firstZbTime.substring(0,16);
                	 }
                	 return '';
                 }},
                 {display:"反馈时间",name:"",width:"6%",align:"center",paixu:false,render:function(rowdata){
                	 if(rowdata.latestReplyTime && !!rowdata.latestReplyTime){
                		 return rowdata.latestReplyTime.substring(0,16);
                	 }
                	 return '';
                 }}
            ],
            width:"100%",
            height:"100%",
            checkbox: true,
            rownumberyon:true,
            overflowx:false,
            pagesize: 10000,
            pageyno:false,
            paramobj:{search:"",status:"",typeId:typeId,startDate:$('#designStart').val(),endDate:$('#designEnd').val(),pagesize:100000,page:1},
            loadafter:function(data){
            	total=data.total;
            	$(".zspsnr").each(function(){
					var maxwidth = 85;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".dblsqk span").each(function(){
					var maxwidth = 64;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".tabletitle").each(function(){
					var maxwidth = 46;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".cbdw").each(function(){
					var maxwidth = 32;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            },
            url: tableList
       });
	}
	
	var initgrid2 = function(){
        grid2 = $("#gridcont2").createGrid({
            columns:[
            	{display:"印发时间",name:"",width:"6%",align:"center",paixu:false,render:function(rowdata){
            		if(rowdata.printDate && rowdata.printDate!="" && rowdata.printDate!="null" && rowdata.printDate!=null){
            			return rowdata.printDate.substring(0,16);
	               	}
	               	return '';
                }},
                {display:"办理状态",name:"",width:"6%",align:"center",render:function(rowdata,n){
                	var statusName="";
               	 	var bgColor="";
               	 	if(rowdata.status==1){
	               	 	statusName="办理中";
	               		bgColor="#2BAA81";
            	 	}else if(rowdata.status==2){
	               	 	statusName="已办结";
	               		bgColor="#BCBCBC";
               	 	}else if(rowdata.status==3){
	               	 	statusName="常态落实";
	               	 	bgColor="#BCBCBC";
               	 	}
  				  	return '<div title="'+statusName+'" class="btn btn-xs btn-color" style="background-color:'+bgColor+';">'+statusName+'</div>';
                }},
                {display:"办件标题",name:"",width:"15%",align:"left",render:function(rowdata){
                	 var cuiban="";
                 	 if(rowdata.cuibanFlag=="1"){
                 		 cuiban = '<label class="cuibanlabel">催办</label>';
                	 }
                	 return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1"  onclick="closeTable()">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"工作分工内容",name:"",width:"21%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 return '<div class="gzfgnr" title="'+rowdata.jobContent+'">'+rowdata.jobContent+'</div>';
                 }},
                 {display:"督办落实情况",name:"",width:"30%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 var duban="";
                 	 if(rowdata.updateFlag=="1"){
                 		duban = '<label class="cuibanlabel">已更新</label>';
                	 }
                	 var dbCont="";
                	 if(rowdata.latestReply){
                		dbCont=rowdata.latestReply;
                	 }	 
                	 return '<div class="dblsqk"  onclick="dblsqkAlert(\''+rowdata.id+'\')" title="'+dbCont+'">'+duban+'<span>'+dbCont+'</span></div>';
                 }},
                 {display:"承办单位/人",name:"",width:"10%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 return '<div class="cbdw" title="'+rowdata.underDepts+'">'+rowdata.underDepts+'</div>'
                 }},
                 {display:"转办时间",name:"",width:"6%",align:"center",render:function(rowdata){
                	 if(rowdata.firstZbTime && !!rowdata.firstZbTime){
                		 return rowdata.firstZbTime.substring(0,16);
                	 }
                	 return '';
                 }},
                 {display:"反馈时间",name:"",width:"6%",align:"center",paixu:false,render:function(rowdata){
                	 if(rowdata.latestReplyTime && !!rowdata.latestReplyTime){
                		 return rowdata.latestReplyTime.substring(0,16);
                	 }
                	 return '';
                 }}
            ],
            width:"100%",
            height:"100%",
            checkbox: true,
            rownumberyon:true,
            overflowx:false,
            pagesize: 100000,
            pageyno:false,
            paramobj:{search:'',status:"",typeId:typeId,startDate:$('#designStart').val(),endDate:$('#designEnd').val(),pagesize:100000,page:1},
            loadafter:function(data){
            	total=data.total;
            	$(".dblsqk span").each(function(){
					var maxwidth = 80;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".gzfgnr").each(function(){
					var maxwidth = 65;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".tabletitle").each(function(){
					var maxwidth = 46;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".cbdw").each(function(){
					var maxwidth = 32;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            },
            url: tableList
       });
	}

	var initgrid3 = function(){
        grid3 = $("#gridcont3").createGrid({
            columns:[
                {display:"办理状态",name:"",width:"8%",align:"center",render:function(rowdata,n){
                	var statusName="";
               	 	var bgColor="";
               	 	if(rowdata.status==1){
	               	 	statusName="办理中";
	               		bgColor="#2BAA81";
            	 	}else if(rowdata.status==2){
	               	 	statusName="已办结";
	               		bgColor="#BCBCBC";
               	 	}else if(rowdata.status==3){
	               	 	statusName="常态落实";
	               	 	bgColor="#BCBCBC";
               	 	}
  				  	return '<div title="'+statusName+'" class="btn btn-xs btn-color" style="background-color:'+bgColor+';">'+statusName+'</div>';
                 }},
                 {display:"办件标题",name:"",width:"20%",align:"left",title:false,render:function(rowdata){
                	 var cuiban="";
                 	 if(rowdata.cuibanFlag=="1"){
                 		 cuiban = '<label class="cuibanlabel">催办</label>';
                	 }
                	 return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1"  onclick="closeTable()">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"批示指示内容",name:"",width:"26%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 var szpsCont="";
                	 var leaderTime1="";
                	 if(rowdata.leaderTime!="" && rowdata.leaderTime!=null){
                		 leaderTime1= rowdata.leaderTime.substring(0,16);
                	 }
                	 if(rowdata.leaderName && rowdata.leaderContent){
                		 szpsCont=rowdata.leaderName+":"+rowdata.leaderContent+" "+leaderTime1
                	 }
                	 return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.id+'\')" title="'+szpsCont+'">'+szpsCont+'</div>';
                 }},
                 {display:"督办落实情况",name:"",width:"24%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 var duban="";
                 	 if(rowdata.updateFlag=="1"){
                 		duban = '<label class="cuibanlabel">已更新</label>';
                	 }
                	 var dbCont="";
                	 if(rowdata.latestReply){
                		dbCont=rowdata.latestReply;
                	 }
                	 return '<div class="dblsqk" onclick="dblsqkAlert(\''+rowdata.id+'\')" title="'+dbCont+'">'+duban+'<span>'+dbCont+'</span></div>';
                 }},
                 {display:"承办单位/人",name:"",width:"10%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 return '<div class="cbdw" title="'+rowdata.underDepts+'">'+rowdata.underDepts+'</div>'
                 }},
                 {display:"转办时间",name:"",width:"6%",align:"center",render:function(rowdata){
                	 if(rowdata.firstZbTime && !!rowdata.firstZbTime){
                		 return rowdata.firstZbTime.substring(0,16);
                	 }
                	 return '';
                 }},
                 {display:"反馈时间",name:"",width:"6%",align:"center",paixu:false,render:function(rowdata){
                	 if(rowdata.latestReplyTime && !!rowdata.latestReplyTime){
                		 return rowdata.latestReplyTime.substring(0,16);
                	 }
                	 return '';
                 }}
            ],
            width:"100%",
            height:"100%",
            checkbox: true,
            rownumberyon:true,
            overflowx:false,
            pagesize: 100000,
            pageyno:false,
            paramobj:{search:"",status:"",typeId:typeId,startDate:$('#designStart').val(),endDate:$('#designEnd').val(),pagesize:100000,page:1},
            loadafter:function(data){
            	total=data.total;
            	$(".zspsnr").each(function(){
					var maxwidth = 85;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".dblsqk span").each(function(){
					var maxwidth = 64;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".tabletitle").each(function(){
					var maxwidth = 55;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".cbdw").each(function(){
					var maxwidth = 32;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            },
            url: tableList
       });
	}
	
	
	var initother = function(){
		$(".date-picker").datepicker({
		    language:"zh-CN",
		    rtl: Metronic.isRTL(),
		    orientation: "right",
		    format : "yyyy-mm-dd",
		    autoclose: true
		});
		
		//筛选功能
		$("#sure").click(function(){
			 refreshgrid();
		});
		
		//重置
		$("#reset").click(function(){
			removeInputData(["designStart","designEnd"]);
		});
		
		//导出
		$("#export").click(function(){
			var datas;
			if(tableNum==3){
				datas=grid3.getcheckrow();
			}else if(tableNum==2){
				datas=grid2.getcheckrow();
			}else{
				datas=grid.getcheckrow();
			}
			var ids='';
			var t_count=0;
			$(datas).each(function(i){
				ids+=i!=0?(','+this.id):this.id;
				t_count++;
			});
			t_count=t_count>0?t_count:total;
			if(datas.length>0){
				newbootbox.confirm({
			     	title:"提示",
			     	message: "将导出"+t_count+"条数据！",
			     	callback1:function(){
			     		window.location.href='/app/db/export/exportDocx?stringIds='+ids;
			     	}
			    });
			}else{
				newbootbox.alertInfo("请选择要导出的数据！");
			}
		});
		
		$("#closeTable,#cancel").click(function(){
			newbootbox.newdialogClose("importTable");
		})
	}
	

	return{
		//加载页面处理程序
		initControl:function(){
			initTableNum();
			initgrid();
			initother();
		},
		initgrid:function(){
			initgrid();
		},
		initgrid2:function(){
			initgrid2();
		},
		initgrid3:function(){
			initgrid3();
		}
	};
}();

function refreshgrid(){
	if(o.tree == "3"){
		$("#gridcont3").show();
	}else if(o.tree == "2"){
		$("#gridcont2").show();
	}else{
		$("#gridcont").show();
	}
	if(tableNum==3){
		pageModule.initgrid3();
	}else if(tableNum==2){
		pageModule.initgrid2();
	}else{
		pageModule.initgrid();
	}
}

//查询
function refreshgrid1(){
	pageModule.initgrid();
}
function refreshgrid2(){
	pageModule.initgrid2();
}
function refreshgrid3(){
	pageModule.initgrid3();
}
//批示指示内容弹出框
function pszsnrAlert(id){
	newbootbox.newdialog({
		id:"psDialog",
		width:800,
		height:600,
		header:true,
		title:"批示详情",
		classed:"cjDialog",
		url:"/app/db/document/view/html/psDialog.html?fileId="+id
	})
}

//督办落实情况弹出框
function dblsqkAlert(id){
	newbootbox.newdialog({
		id:"dblsqkDialog",
		width:800,
		height:600,
		header:true,
		title:"督办详情",
		classed:"cjDialog",
		url:"/app/db/document/view/html/dblsqk.html?fileId="+id
	})
}
function closeTable(){
	newbootbox.newdialogClose("importTable");
}