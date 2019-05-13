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
var total=0;//列表中，数据的总条数
var pageModule = function(){
	//左侧菜单树
	var leftMenufn = function(){
		$ajax({
			url:leftMenuUrl,
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
					$(this).siblings().removeClass("active");
					$(this).addClass("active");
					if($(this).attr("data_flag") == "1"){
						$("#gridcont").show();
						$("#gridcont2").hide();
						refreshgrid1();
					}else{
						$("#gridcont2").show();
						$("#gridcont").hide();
						refreshgrid2();
					}
				});
				
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
                	 return '<a title="'+rowdata.docTitle+'" class="table-title2" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"批示指示内容",name:"",width:"26%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 var szpsCont="";
                	 if(rowdata.leaderName && rowdata.leaderContent && rowdata.leaderTime){
                		 szpsCont=rowdata.leaderName+":"+rowdata.leaderContent+" "+rowdata.leaderTime.substring(0,16)
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
                 {display:"承办单位/人",name:"",width:"10%",align:"left",paixu:false,title:true,render:function(rowdata){
                	 return rowdata.underDepts||'';
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
            paramobj:{search:$("#searchVal").val(),status:$("input[name='documentStatus']:checked").val(),typeId:$("#classType li.active").attr("value"),orgid:orgid,month:month},
            loadafter:function(data){
            	total=data.total;
            	$(".zspsnr").each(function(){
					var maxwidth = 70;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".dblsqk span").each(function(){
					var maxwidth = 60;
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
            		if(rowdata.printDate && !!rowdata.printDate){
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
                	 return '<a title="'+rowdata.docTitle+'" class="table-title" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
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
                 {display:"承办单位/人",name:"",width:"10%",align:"left",paixu:false,title:true,render:function(rowdata){
                	 return rowdata.underDepts||'';
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
            paramobj:{search:$("#searchVal").val(),status:$("input[name='documentStatus']:checked").val(),typeId:$("#classType li.active").attr("value"),orgid:orgid,month:month},
            loadafter:function(data){
            	total=data.total;
            	$(".dblsqk span").each(function(){
					var maxwidth = 57;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".gzfgnr").each(function(){
					var maxwidth = 57;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            },
            url: tableList
       });
	}

	var numsListfn = function(){
		$ajax({
			url:numsList,
			data:{search:$("#searchVal").val(),typeId:$("#classType li.active").attr("value")},
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
		
		/*$("body").click(function(e){
			if($(e.target).hasClass("searchAll") || $(e.target).hasClass("form-group") || $(e.target).parents("div").hasClass("searchwrap")){
				return;
			};
			$(".searchwrap").slideUp(50);
		});*/
		
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
			if($("#gridcont2").is(":hidden")){
				datas=grid.getcheckrow();
				$(datas).each(function(i){
					ids[i]=this.id;
				});
			}else{
				datas=grid2.getcheckrow();
				$(datas).each(function(i){
					ids[i]=this.id;
				});
			}
			console.log(datas)
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
										if($("#gridcont2").is(":hidden")){
											pageModule.initgrid();
										}else{
											pageModule.initgrid2();
										}
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
			var datas=grid.getcheckrow();
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
			     		/*window.location.href=后台地址+'?ids='+ids;*/
			     	}
			    });
			}else{
				newbootbox.alertInfo("请选择要导出的数据！");
			}
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

	return{
		//加载页面处理程序
		initControl:function(){
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
		}
	};
}();

function refreshgrid(){
	if($("#gridcont2").is(":hidden")){
		pageModule.initgrid();
	}else{
		pageModule.initgrid2();
	}
}

//查询
function refreshgrid1(){
	pageModule.initgrid();
}
function refreshgrid2(){
	pageModule.initgrid2();
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