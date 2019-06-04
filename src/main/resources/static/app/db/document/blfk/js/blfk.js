//注：修改列表查询的参数一定要对应的修改红点显示leftMenuUrl和统计数numsList
var tableList= {"url":"/app/db/documentinfo/replyList","dataType":"text"};//原table数据
var numsList={"url":"/app/db/documentinfo/replyNums","dataType":"text"};//筛选状态数字统计
var deptUrl= {"url":"/app/db/document/grdb/data/deptTree.json","dataType":"text"};//部门树
var userUrl = {"url":"/app/db/document/grdb/data/userTree.json","dataType":"text"};//人员树
var leftMenuUrl = {"url":"/app/db//documentinfo/getDicByTypet","dataType":"text"};//左侧菜单
var batchReadUrl = {"url":"/app/db/documentinfo/batchRead","dataType":"text"};//批量已读
var leftMenuNums = {"url":"","dataType":"text"};//左侧菜单数字统计
var fileFrom=getUrlParam("fileFrom")||""; //文件来源
var orgid=getUrlParam("orgid")||""; //统计图传过来的机构
var month=getUrlParam("month")||""; //统计图传过来的月份
var ytype=getUrlParam("ytype")||""; //统计图传过来的办理状态
if(fileFrom && fileFrom == "jcdb"){
	if(ytype){
		$("input[value="+ytype+"]").attr("checked",true);
	}
}

var grid = null;
var grid2 = null;
var grid3 = null;
var total=0;//列表中，数据的总条数

if(!window.top.memory){
	window.top.memory = {};
}
var o = window.top.memory;

var pageModule = function(){
	//左侧菜单树
	var leftMenufn = function(){
		$ajax({
			url:leftMenuUrl,
			data:{orgid:orgid,month:month},
			async:false,
			success:function(data){
				$("#classType").html("");
				$.each(data.document_type,function(i,item){
					var dot ='';
					if(item.hasUpdateNum!=0){
						dot = '<span class="dot"></span>'
					}
					$("#classType").append('<li class="'+(i==0?"active":"")+'" data_flag="'+item.gridFlag+'" value="'+item.value+'"><span>'+item.text+dot+'</span><font id="Menu_num'+i+'"></font><i class="fa fa-angle-right"></i></li>');
				});
				
				$("#classType li").unbind("click");
				$("#classType li").click(function(){
					window.top.memory.value = $(this).attr("value");
					$(this).siblings().removeClass("active");
					$(this).addClass("active");
					if($(this).attr("data_flag") == "3"){ //部领导批示指示 
						window.top.memory.tree = "3";
						$("#gridcont3").show();
						$("#gridcont2").hide();
						$("#gridcont").hide();
						refreshgrid3();
					}else if($(this).attr("data_flag") == "2"){//分工
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
				});
				
				if(o.value!="" && o.value!=null &&　o.value!="null" && o.value!="undefined"){
					$("#classType li").removeClass("active");
					$("#classType li[value="+o.value+"]").addClass("active");
				}
				
				/*$ajax({
					url:leftMenuNums,
					data:{dicType:"document_type"},
					success:function(data){
						$.each(data,function(j,item2){
							var id = "Menu_num"+j;
							$("#"+id).html(item2);
						});
					}
				});	*/
				
			}
		});	
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
                	 return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"批示指示内容",name:"",width:"26%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 /*var szpsCont="";
                	 var leaderTime1="";
                	 if(rowdata.leaderTime!="" && rowdata.leaderTime!=null){
                		 leaderTime1= rowdata.leaderTime.substring(0,16);
                	 }
                	 if(rowdata.leaderName && rowdata.leaderContent){
                		 szpsCont=rowdata.leaderName+" "+leaderTime1+"批示："+rowdata.leaderContent
                	 }
                	 return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.id+'\')" title="'+szpsCont+'">'+szpsCont+'</div>';*/
                	 var html1="";
                	 $.each(rowdata.szpslist,function(i,item){
                		 var createdTime="";
                		 if(item.createdTime!="" && item.createdTime!=null){
                			 createdTime= item.createdTime.substring(0,16);
                		 }
                		 
                		 html1+=	'<div class="pslist">'+
	     			            '	'+item.userName+'&nbsp;&nbsp;'+createdTime+'批示：'+item.leaderComment+
	     			            '</div>';
     				 });
                	 return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.id+'\')">'+html1+'</div>';
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
            pagesize: 10,
            pageyno:true,
            paramobj:{page:o.pagesize1,search:$("#searchVal").val(),status:$("input[name='documentStatus']:checked").val(),typeId:$("#classType li.active").attr("value"),orgid:orgid,month:month},
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
            url: tableList,
            getpagefn:function(page){
            	return window.top.memory.pagesize1 = page;   
            }
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
                {display:"办件标题",name:"",width:"15%",align:"left",render:function(rowdata){
                	 var cuiban="";
                 	 if(rowdata.cuibanFlag=="1"){
                 		 cuiban = '<label class="cuibanlabel">催办</label>';
                	 }
                	 return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"工作分工内容",name:"",width:"21%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 return '<div class="gzfgnr" title="'+rowdata.jobContent+'">'+rowdata.jobContent+'</div>';
                 }},
                 {display:"督办落实情况",name:"",width:"28%",align:"left",paixu:false,title:false,render:function(rowdata){
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
            pagesize: 10,
            pageyno:true,
            paramobj:{page:o.pagesize2,search:$("#searchVal").val(),status:$("input[name='documentStatus']:checked").val(),typeId:$("#classType li.active").attr("value"),orgid:orgid,month:month},
            loadafter:function(data){
            	total=data.total;
            	$(".dblsqk span").each(function(){
					var maxwidth = 72;
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
            url: tableList,
            getpagefn:function(page){
            	return window.top.memory.pagesize2 = page;   
            }
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
                	 return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"批示指示内容",name:"",width:"26%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 /*var szpsCont="";
                	 var leaderTime1="";
                	 if(rowdata.leaderTime!="" && rowdata.leaderTime!=null){
                		 leaderTime1= rowdata.leaderTime.substring(0,16);
                	 }
                	 if(rowdata.leaderName && rowdata.leaderContent){
                		 szpsCont=rowdata.leaderName+" "+leaderTime1+"批示："+rowdata.leaderContent
                	 }
                	 return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.id+'\')" title="'+szpsCont+'">'+szpsCont+'</div>';*/
                	 var html1="";
                	 $.each(rowdata.szpslist,function(i,item){
                		 var createdTime="";
                		 if(item.createdTime!="" && item.createdTime!=null){
                			 createdTime= item.createdTime.substring(0,16);
                		 }
                		 html1+=	'<div class="pslist">'+
	     			            '	'+item.userName+'&nbsp;&nbsp;'+createdTime+'批示：'+item.leaderComment+
	     			            '</div>';
     				 });
                	 return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.id+'\')">'+html1+'</div>';
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
            pagesize: 10,
            pageyno:true,
            paramobj:{page:o.pagesize3,search:$("#searchVal").val(),status:$("input[name='documentStatus']:checked").val(),typeId:$("#classType li.active").attr("value"),orgid:orgid,month:month},
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
            url: tableList,
            getpagefn:function(page){
            	return window.top.memory.pagesize3 = page;   
            }
       });
	}
	
	var numsListfn = function(){
		$ajax({
			url:numsList,
			data:{search:$("#searchVal").val(),typeId:$("#classType li.active").attr("value"),orgid:orgid,month:month},
			success:function(data){
				$.each(data,function(i,item){
					var id = "grdb"+i;
					$("#"+id).html(item);
				});
			}
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
		
		$(".search").hover(function(){
			$(this).attr("src","../../../common/images/u132_mouseOver.png");
		},function(){
			$(this).attr("src","../../../common/images/u132_mouseDown.png");
		});

		$("input[name='documentStatus']").click(function(){
			refreshgrid();
		});
		
		$(".search").click(function(){
			refreshgrid();
		});
		
		$("#searchAll").click(function(){
			$("#searchwrap").toggle();
		});
		
		$("body").click(function(e){
			if($(e.target).hasClass("searchAll") || $(e.target).hasClass("form-group") || $(e.target).parents("div").hasClass("searchwrap")){
				return;
			};
			$(".searchwrap").slideUp(50);
		});
		
		//筛选功能
		$("#sure").click(function(){
			 $("#searchwrap").slideUp(50);
			 refreshgrid();
		});
		
		//筛选功能
		$("#close").click(function(){
			$("#searchwrap").slideUp(50);
		});
		
		//重置
		$("#reset").click(function(){
			removeInputData(["title","deptid","deptname","username","userid","blstatus","designStart","designEnd","fileType"]);
		});
		
		$("#plyd").click(function(){
			var datas;
			var ids=[];
			if($("#gridcont3").is(":visible")){
				datas=grid3.getcheckrow();
				$(datas).each(function(i){
					ids[i]=this.id;
				});
			}else if($("#gridcont2").is(":visible")){
				datas=grid2.getcheckrow();
				$(datas).each(function(i){
					ids[i]=this.id;
				});
			}else{
				datas=grid.getcheckrow();
				$(datas).each(function(i){
					ids[i]=this.id;
				});
			}
			if(datas.length>0){
				newbootbox.confirm({
				    title: "提示",
				    message: "是否要进行确认已读操作？",
				    callback1:function(){
				    	$ajax({
							url:batchReadUrl,
							data:{ids:ids.toString()},
							success:function(data){
								if(data.result == "success"){
									newbootbox.alertInfo("已读成功！").done(function(){
										leftMenufn();
										refreshgrid();
										window.top.blfkfn();
									});
								}
							}
						});	
				    }
				});
			}else{
				newbootbox.alertInfo("请选择要确认已读的数据！");
			}
		});
		
		//导出
		$("#export").click(function(){
			var tableNum;
			if($("#gridcont3").is(":visible")){
				tableNum= '3';
			}else if($("#gridcont2").is(":visible")){
				tableNum= '2';
			}else{
				tableNum= '1';
			};
			newbootbox.newdialog({
			    id: "importTable",
			    title: "导出",
			    style: {
			      "padding": "1px"
			    },
			    width: 1600,
			    height:850,
			    url: rootPath + "/document/blfk/html/exportTable.html?tableNum="+tableNum+'&typeId='+$("#classType li.active").attr("value")+'&fileFrom='+fileFrom
			  });
		});
		
		
		//菜单左缩进
		$("#suo").click(function(){
			if($(this).find("i").hasClass("fa-chevron-right")){
				$(this).find("i").removeClass("fa-chevron-right").addClass("fa-chevron-left");
				$("#right_content").css("left","256px");
				$(this).parent().css("left","256px");
				$("#left_content").show();
			}else{
				$(this).find("i").removeClass("fa-chevron-left").addClass("fa-chevron-right");
				$("#left_content").hide();
				$(this).parent().css("left","0px");
				$("#right_content").css("left","0px");
			}
			if($("#gridcont2").is(":hidden")){
				pageModule.initgrid();
			}else{
				pageModule.initgrid2();
			}
		});
		
	}
	
	var inittree = function(){
		$("#deptname").createcheckboxtree({
			url : deptUrl,
			width : "100%",
			success : function(data, treeobj) {},
			selectnode : function(e, data,treessname,treessid) {
				$("#deptid").val(treessid);
				$("#deptname").val(treessname);
			},
			deselectnode:function(e,data,treessname,treessid){
				$("#deptid").val(treessid);
				$("#deptname").val(treessname);
		   }
		});
		
		$("#username").createUserTree({
			url : userUrl,
			width : "100%",
			success : function(data, treeobj) {
			},
			selectnode : function(e, data,treessname,treessid) {
				$("#userid").val(treessid);
				$("#username").val(treessname);
			},
			deselectnode : function(e, data,treessname,treessid) {
				$("#userid").val(treessid);
				$("#username").val(treessname);
			}
		});
	}
	
	var initfn = function(){
		$.uniform.update($("input[name='documentStatus']").prop("checked",false));
		if(o.radio!="undefined" && o.radio!=null && o.radio!=""){
			$.uniform.update($("input[value='"+o.radio+"']").prop("checked",true));
		}else{
			$.uniform.update($("input[value='']").prop("checked",true));
		}
		$("#searchVal").val(o.search);
	}

	return{
		//加载页面处理程序
		initControl:function(){
			initfn();
			leftMenufn();
			initgrid();
			numsListfn();
			initother();
			inittree();
		},
		initgrid:function(){
			initgrid();
			numsListfn();
		},
		initgrid2:function(){
			initgrid2();
			numsListfn();
		},
		initgrid3:function(){
			initgrid3();
			numsListfn();
		}
	};
}();

function refreshgrid(){
	if(o.tree == "3"){
		$("#gridcont3").show();
		$("#gridcont2").hide();
		$("#gridcont").hide();
	}else if(o.tree == "2"){
		$("#gridcont2").show();
		$("#gridcont3").hide();
		$("#gridcont").hide();
	}else{
		$("#gridcont").show();
		$("#gridcont2").hide();
		$("#gridcont3").hide();
	}
	if($("#gridcont3").is(":visible")){
		pageModule.initgrid3();
	}else if($("#gridcont2").is(":visible")){
		pageModule.initgrid2();
	}else{
		pageModule.initgrid();
	}
	var search = $("#searchVal").val();
	var documentStatus= $("input[name='documentStatus']:checked").val();
	window.top.memory.radio = documentStatus;
	window.top.memory.search = search;
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