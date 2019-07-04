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

/*alert(JSON.stringify(gettop2().memory))*/

var pageModule = function(){
	var initgrid = function(){
        grid = $("#gridcont").createGrid({
            columns:[
            	{display:"状态",name:"",width:"8%",align:"center",render:function(rowdata,n){
    				var button1;
    				if(rowdata.status==1){
    					button1 = '<button type="button" class="btn btn-info table-button1">办理中</button>';
    				}else if(rowdata.status==3){
    					button1 = '<button type="button" class="btn btn-info table-button2">常态落实</button>';
    				}else{
    					button1 = '<button type="button" class="btn btn-info table-button2">已办结</button>';
    				}
    				return button1;
                 }},
                 {display:"文件标题",name:"",width:"15%",align:"left",title:false,render:function(rowdata){
                	 var cuiban="";
                 	 if(rowdata.cuibanFlag=="1"){
                 		 cuiban = '<label class="table-label2">催办</label>';
                	 }
                	 return '<a title="'+rowdata.docTitle+'" class="table-title" href="../../djlr/html/djlr_view.html?fileId='+rowdata.id+'&fileFrom='+fileFrom+'&leaderId='+leaderId+'&startdate='+startdate+'&enddate='+enddate+'&status='+status+'" target="iframe1">'+cuiban+rowdata.docTitle+'</a>'
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
                	 return '<div class="zspsnr" onclick="pszsnrAlert(\''+rowdata.id+'\')" title="'+html1+'" style="cursor:pointer;">'+html1+'</div>';
                 }},
                {display:"督办落实情况",name:"",width:"26%",align:"left",paixu:false,title:false,render:function(rowdata){
               	 var duban="";
                	 if(rowdata.updateFlag=="1"){
                		duban = '<label class="cuibanlabel">已更新</label>';
               	 }
               	 var dbCont="";
               	 if(rowdata.latestReply){
               		dbCont=rowdata.latestReply;
               	 }
               	 return '<div class="dblsqk" onclick="dblsqkAlert(\''+rowdata.id+'\')" title="'+dbCont+'" style="cursor:pointer;">'+duban+'<span>'+dbCont+'</span></div>';
                }},
                {display:"承办单位/人",name:"",width:"8%",align:"left",paixu:false,title:false,render:function(rowdata){
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
            pagesize: 6,
            pageyno:true,
            paramobj:{docStatus:status,leaderId:leaderId,startDate:startdate,endDate:enddate},
            loadafter:function(data){
            	total=data.total;
            	$("input[name='documentStatus']:checked").parents("label").find("font").text(total);

            	$(".zspsnr").each(function(){
					var maxwidth = 46;
					if($(this).text().length > maxwidth){
						$(this).text($(this).text().substring(0,maxwidth));
						$(this).html($(this).html()+'...');
					}
				});
            	$(".dblsqk span").each(function(){
					var maxwidth = 46;
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
					var maxwidth = 46;
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
			window.location.href = "../../jcdb/html/index.html"
		});
		$('#typeOption').change(function(){
			grid.setparams({docStatus:status,leaderId:leaderId,startDate:startdate,endDate:enddate,typeId:$('#typeOption').val()});
			grid.loadtable();
		})
		$(".fa-search").click(function(){
			var value = $(".top-right-search input").val();
			grid.setparams({search:value});
			grid.loadtable();
		})
	}

	
	var initfn = function(){
		$.uniform.update($("input[name='documentStatus']").prop("checked",false));
		$.uniform.update($("input[name='documentStatus']").prop("disabled",true));
		$.uniform.update($("input[value='"+status+"']").prop("checked",true));
		$.uniform.update($("input[value='"+status+"']").prop("disabled",false));
		$("input[value='"+status+"']").parents('label').addClass('selectedRadio')
	}
	
	var initOption = function(){
		var optionList = [{
			text:'ssssssssssss',
			id:1
		},{
			text:'ssssssssssss',
			id:2
		},{
			text:'ssssssssssss',
			id:3
		}]
		$('#typeOption').html('');
		$.each(optionList,function(i,v){
			$('#typeOption').append(`<option value="${v.id}" style="background-color:#639AC1">${v.text}</option>`)
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initfn();
			initgrid();
			initother();
			initOption()
		},
		initgrid:function(){
			initgrid();
		}
	};
}();

$('.top-title').click(function(){
	history.back()
})
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
