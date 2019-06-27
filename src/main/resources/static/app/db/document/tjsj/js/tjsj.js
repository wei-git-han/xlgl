var tableList= {"url":"/app/db/documentjcdb/leaderStatisticsList","dataType":"text"};//原table数据
var numsList={"url":"/app/db/subdocinfo/presonNumsList","dataType":"text"};//筛选状态数字统计
var deptUrl= {"url":"/app/db/document/grdb/data/deptTree.json","dataType":"text"};//高级搜索--部门树
var userUrl = {"url":"/app/db/document/grdb/data/userTree.json","dataType":"text"};//高级搜索--人员树
var grid = null;
var total=0;//列表中，数据的总条数
var fileFrom=getUrlParam("fileFrom")||"sztj"; //文件来源
var status = getUrlParam("status");//统计图传过来的状态
var leaderId = getUrlParam("leaderId");//统计图传过来的首长ID

var startdate = getUrlParam2("startdate");
var enddate = getUrlParam2("enddate");
/*if(!window.top.memory){
	window.top.memory = {};
}
var o = window.top.memory;*/

//alert(JSON.stringify(gettop().memory))

var pageModule = function(){
	var initgrid = function(){
        grid = $("#gridcont").createGrid({
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
                 {display:"办件标题",name:"",width:"15%",align:"left",title:false,render:function(rowdata){
                	 var cuiban="";
                 	 if(rowdata.cuibanFlag=="1"){
                 		 cuiban = '<label class="cuibanlabel">催办</label>';
                	 }
                	 return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'&leaderId='+leaderId+'&startdate='+startdate+'&enddate='+enddate+'&status='+status+'" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
                 }},
                 {display:"批示指示内容",name:"",width:"26%",align:"left",paixu:false,title:false,render:function(rowdata){
                	 var html1="";
                	 $.each(rowdata.szpslist,function(i,item){
                		 var createdTime="";
                		 if(item.createdTime!="" && item.createdTime!=null){
                			 createdTime= item.createdTime.substring(0,16);
                		 }
                		 html1+=item.userName+'&nbsp;&nbsp;'+createdTime+'批示：'+item.leaderComment+'&nbsp;&nbsp;&nbsp;'
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
                {display:"承办单位/人",name:"",width:"12%",align:"left",paixu:false,title:false,render:function(rowdata){
               	 return '<div class="cbdw" title="'+rowdata.underDepts+'">'+rowdata.underDepts+'</div>'
                }},
                {display:"转办时间",name:"",width:"9%",align:"center",render:function(rowdata){
               	 if(rowdata.firstZbTime && !!rowdata.firstZbTime){
               		 return rowdata.firstZbTime.substring(0,16);
               	 }
               	 return '';
                }},
                {display:"反馈时间",name:"",width:"9%",align:"center",paixu:false,render:function(rowdata){
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
            paramobj:{docStatus:status,leaderId:leaderId,startDate:startdate,endDate:enddate},
            loadafter:function(data){
            	total=data.total;
            	$("input[name='documentStatus']:checked").parents("label").find("font").text(total);

            	$(".zspsnr").each(function(){
					var maxwidth = 75;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".dblsqk span").each(function(){
					var maxwidth = 73;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".tabletitle").each(function(){
					var maxwidth = 57;
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
		$("#goback").click(function(){
			/*remember = {};*/
			window.location.href = "../../jcdb/html/index.html"
		});
	}

	
	var initfn = function(){
		$.uniform.update($("input[name='documentStatus']").prop("checked",false));
		$.uniform.update($("input[name='documentStatus']").prop("disabled",true));
		/*if(remember.status != ""  && remember.status != null && remember.status != "undefined"){
			$.uniform.update($("input[value='"+remember.status+"']").prop("checked",true));
			$.uniform.update($("input[value='"+remember.status+"']").prop("disabled",false));
			status = o.status;
		}else{*/
			$.uniform.update($("input[value='"+status+"']").prop("checked",true));
			$.uniform.update($("input[value='"+status+"']").prop("disabled",false));
			
		/*}	
		
		if(remember.leaderId != ""  && remember.leaderId != null && remember.leaderId != "undefined" &&　remember.leaderId!="null"){
			leaderId = remember.leaderId;
		}
		if(remember.startdate != "" && remember.startdate != null && remember.startdate != "undefined"  &&　remember.startdate!="null"){
			startdate = remember.startdate;
		}
		if(remember.enddate != "" && remember.enddate != null && remember.enddate != "undefined"  &&　remember.enddate!="null"){
			enddate = remember.enddate;
		}*/
	}
	
	return{
		//加载页面处理程序
		initControl:function(){
			initfn();
			initgrid();
			initother();
		},
		initgrid:function(){
			initgrid();
		}
	};
}();

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
