var tableList= {"url":"/app/db/subdocinfo/personList","dataType":"text"};//原table数据
var numsList={"url":"/app/db/subdocinfo/presonNumsList","dataType":"text"};//筛选状态数字统计
var deptUrl= {"url":"/app/db/document/grdb/data/deptTree.json","dataType":"text"};//高级搜索--部门树
var userUrl = {"url":"/app/db/document/grdb/data/userTree.json","dataType":"text"};//高级搜索--人员树
var grid = null;
var total=0;//列表中，数据的总条数
var bjtype = getUrlParam("type");
var leaderid = getUrlParam("type");

var pageModule = function(){
	var initgrid = function(){
        grid = $("#gridcont").createGrid({
            columns:[
                {display:"状态",name:"statusName",width:"7%",align:"center",render:function(rowdata,n){
                	var statusName="";
               	 	var bgColor="#FF6600";
               	 	if(rowdata.docStatus==9){
	               	 	statusName="办理中";
	               	 	bgColor="rgba(43, 170, 129, 1)";
               	 	}else if(rowdata.docStatus==11){
	               	 	statusName="常态落实";
	               	 	bgColor="rgba(153, 153, 153, 1)";
               	 	}
  				  	return '<div title="'+statusName+'" class="btn btn-xs btn-color" style="background-color:'+bgColor+';">'+statusName+'</div>';
                }},
                {display:"办件标题",name:"docTitle",width:"20%",align:"left",render:function(rowdata){
                	var cuiban="";
                	if(rowdata.cuibanFlag=="1"){
                		cuiban = '<label class="cuibanlabel">催办</label>';
               	    }
               	 	return '<a title="'+rowdata.docTitle+'" class="tabletitle" href="../../view/html/view.html?fileId='+rowdata.infoId+'&subId='+rowdata.id+'&fileFrom=grdb" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
                }},
                {display:"批示指示内容",name:"",width:"25%",align:"left",paixu:false,render:function(rowdata){
               	 	var html1="";
              	 	$.each(rowdata.szpslist,function(i,item){
	               		var createdTime="";
	               		if(item.createdTime!="" && item.createdTime!=null){
	               			 createdTime= item.createdTime.substring(0,16);
	               		}
	               		html1+=item.userName+'&nbsp;&nbsp;'+createdTime+'批示：'+item.leaderComment+'&nbsp;&nbsp;&nbsp;'
	    		    });
              	    return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.infoId+'\')">'+html1+'</div>';
                }},
                {display:"督办落实情况",name:"",width:"25%",align:"left",paixu:false,render:function(rowdata){
                	var duban="";
                	if(rowdata.updateFlag=="1"){
                		duban = '<label class="cuibanlabel">已更新</label>';
                	}
                	var dbCont="";
                	if(rowdata.latestReply){
                		dbCont=rowdata.latestReply;
                	}	 
                	return '<div class="dblsqk" onclick="dblsqkAlert(\''+rowdata.infoId+'\')"  title="'+dbCont+'">'+duban+'<span>'+dbCont+'</span></div>';
                }},
                {display:"承办单位/人",name:"",width:"11%",align:"left",paixu:false,title:false,render:function(rowdata){
                	return '<div class="cbdw" title="'+rowdata.underDepts+'">'+rowdata.underDepts+'</div>'
                }},
                {display:"转办时间",name:"createdTime",width:"6%",align:"center",render:function(rowdata){
               	 return rowdata.createdTime.substring(0,16);
                }},
                 {display:"反馈时间",name:"",width:"6%",align:"center",paixu:false,render:function(rowdata){
                	 var updateTime="";
                	 if(rowdata.updateTime){
                		 updateTime = rowdata.updateTime.substring(0,16);
                	 }
                	 return updateTime;
                 }}
            ],
            width:"100%",
            height:"100%",
            checkbox: true,
            rownumberyon:true,
            overflowx:false,
            pagesize: 10,
            pageyno:true,
            paramobj:{docStatus:bjtype,leaderid:leaderid},
            loadafter:function(data){
            	total=data.total;
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
	
	var numsListfn = function(){
		$ajax({
			url:numsList,
			data:{search:$("#searchVal").val()},
			success:function(data){
				$.each(data,function(i,item){
					var id = "tjsj"+i;
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
		
		$("#contenttitle").click(function(){
			window.location.href = "../../jcdb/html/index.html"
		})
	}

	
	var initfn = function(){
		$.uniform.update($("input[name='documentStatus']").prop("checked",false));
		$.uniform.update($("input[value='"+bjtype+"']").prop("checked",true));
	}
	
	return{
		//加载页面处理程序
		initControl:function(){
			initfn();
			initgrid();
			numsListfn();
			initother();
		},
		initgrid:function(){
			initgrid();
			numsListfn();
		}
	};
}();

function refreshgrid(){
	var search = $("#searchVal").val();
	var documentStatus= $("input[name='documentStatus']:checked").val();
	grid.setparams({search:search,docStatus:documentStatus,leaderid:leaderid});
	grid.loadtable();
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
