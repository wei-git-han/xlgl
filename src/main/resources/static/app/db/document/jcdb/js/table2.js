/*var url1 = {"url":"../data/grid.json","dataType":"text"};
var url2 = {"url":"../data/menu.json","dataType":"text"};*/
var url1 = {"url":"/app/db/documentszinfo/homelist","dataType":"text"};
var url2 = {"url":"/app/db/documentszinfo/grouplist","dataType":"text"};
var url3 = {"url":"/app/db/documentszinfo/read","dataType":"text"};
var url4 = {"url":"/app/db/documentszinfo/press","dataType":"text"};
var url5 = {"url":"","dataType":"text"};

var ifmenu=getUrlParam("ifmenu")||"";
var orgid=getUrlParam("orgid")||"";
var month=getUrlParam("month")||"";
var ytype=getUrlParam("ytype")||"";

if(typeof(ytype)=="undefined"||ytype==null||$.trim(ytype)=="undefined"){ytype=""};

var grid = null;
var pageModule = function(){

	var initmenu = function(){
		$ajax({
			url:url2,
			data:{orgid:orgid,month:month},
			success:function(data){
				$(".menu").html('');
				$.each(data,function(i){
					var id = this.id;
					var name = this.name;
					var count = this.count;
					var count2 = "";
					if(count>0){
						if(count>99){
							count2="(99+)"
						}else{
							count2="("+count+")";
						}
					}
					$(".menu").append(
					`
							<li class="${i==0?'active':''}" id="${id}">
								<a>
									<i class="fa fa-chevron-right "></i>
									<font>${name}</font>
									<font title="${count}" >${count2}</font>
								</a>
							</li>
					`
					);
				})
				
				$(".menu li").unbind("click");
				$(".menu li").click(function(){
					$(".menu li").removeClass("active");
					$(this).addClass("active");
					
					var id = $(this).attr("id");
					grid.setparams({id:id});
					grid.loadtable();
				})
				
				initgrid(data[0].id);
			}
		})
		
	}


	var initgrid = function(menuid){
        grid = $("#gridcont").createGrid({
                    columns:[	
                    	{display:"状态",name:"blzt",width:"8%",align:"center",paixu:false,render:function(rowdata,n){
            				var button1;
            				if(rowdata.blzt==1){
            					button1 = '<button type="button" class="btn btn-info table-button1">办理中</button>';
            				}else if(rowdata.blzt==3){
            					button1 = '<button type="button" class="btn btn-info table-button2">常态落实</button>';
            				}else{
            					button1 = '<button type="button" class="btn btn-info table-button2">已办结</button>';
            				}
            				return button1;
            			}},
            			{display:"军委办件号",name:"jwbjh",width:"10%",align:"center",paixu:false,render:function(rowdata,n){
                           	var cuiban =
            				title=` <font title="${rowdata.jwbjh}" style="cursor:pointer;" >${rowdata.jwbjh}</font>`
            					return title
            			}},
            			{display:"文件标题",name:"title",width:"18%",align:"left",paixu:false,render:function(rowdata,n){
            				var cuiban = '',title="";
                        	var CuibanFlag = rowdata.CuibanFlag;
                        	if(CuibanFlag==1){
                        		 cuiban = '<label class="table-label2">催办</label>';
                        	}
            				title=`${cuiban} <font class="title" title="${rowdata.title}" onclick="viewpage('${rowdata.id}','${rowdata.id}','${rowdata.id}')" style="cursor:pointer;text-decoration: underline;" >${rowdata.title}</font>`;
            				return title
            			}},
            			{display:"批示指示内容",name:"pszsmr",width:"18%",align:"left",paixu:false,render:function(rowdata,n){
            				var str = `<font class="pszsmr" style="cursor:pointer" title="${rowdata.pszsmr}" onclick="pszsnrAlert('${rowdata.id}')" >${rowdata.pszsmr}</font>`;
            				return str
            			}},
              			{display:"督办落实情况",name:"dblsqk",width:"18%",align:"left",paixu:false,render:function(rowdata,n){
              				var gengxin = "";
          					if(rowdata.gengxin=='1'){
          						gengxin = '<label class="table-label">已更新</label>';
          					}
            				var title=`<font class="dblsqk" title="${rowdata.dblsqk}" onclick="dblsqkAlert('${rowdata.id}')" style="cursor:pointer;" >${gengxin}${rowdata.dblsqk}</font>`;
            				return title
//                    	 return '<div class="dblsqk" onclick="dblsqkAlert(\''+rowdata.id+'\')" title="'+rowdata.dblsqk+'"><span class="hiddenInfo">'+rowdata.dblsqk+'</span></div>';
              			}},
/*                    			{display:"转办时间",name:"zbdate",width:"8%",align:"center",paixu:false,render:function(rowdata,n){
            				return rowdata.zbdate||'';
            			}},*/
            			{display:"承办单位/人",name:"cbdwry",width:"8%",align:"center",paixu:false,render:function(rowdata,n){
            				var title=`<font class="cbdw" title="${rowdata.cbdwry}">${rowdata.cbdwry}</font>`;
            				return title
            			}},
            			{display:"更新时间",name:"update",width:"8%",align:"center",paixu:false,render:function(rowdata,n){
            				return rowdata.update||'';
            			}},
              			{display:"操作",name:"cz",width:"8%",align:"center",paixu:false,render:function(rowdata,n){
            				var button2 = '';
            				if(rowdata.blzt==1&&rowdata.other==1){
                					button2 = '<button type="button" class="btn btn-info table-button3" onclick="cbfn(\''+rowdata.id+'\')">催办</button>';
            				}
            				return button2;
              			}}
                             ],
                    width:"100%",
                    height:"100%",
                    checkbox: true,
                    rownumberyon:true,
                    paramobj:{orgid:orgid,menuid:menuid,month:month,state:ytype},
                    overflowx:false,
                    rownumberwidth:"50px",
                    pagesize: 6,
                    url: url1,
                    loadafter:function(data){
                    	var count2 = data.count2;
                    	var count3 = data.count3;
                    	var count4 = data.count4;
                    	var count5 = data.count5;
                    	var count1 = count2+count3+count4;
                    	if(count1>0){count1="("+count1+")"}else{count1="(0)"};
                    	if(count2>0){count2="("+count2+")"}else{count2="(0)"};
                    	if(count3>0){count3="("+count3+")"}else{count3="(0)"};
                    	if(count4>0){count4="("+count4+")"}else{count4="(0)"};
                    	if(count5>0){count5="("+count5+")"}else{count5="(0)"};
                    	$("#count1").html(count1);
                    	$("#count2").html(count2);
                    	$("#count3").html(count3);
                    	$("#count4").html(count4);
                    	$("#count5").html(count5);
                    	Metronic.initSlimScroll(".scroller");
                    	$(".dblsqk").each(function(){
        					var maxwidth = 46;
        					if($(this).text().length > maxwidth){
        						$(this).text($(this).text().substring(0,maxwidth));
        						$(this).html($(this).html()+'...');
        					}
        				});
                    	$(".gzfgnr").each(function(){
        					var maxwidth = 46;
        					if($(this).text().length > maxwidth){
        						$(this).text($(this).text().substring(0,maxwidth));
        						$(this).html($(this).html()+'...');
        					}
        				});
                    	$(".title").each(function(){
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
                    	$(".pszsmr").each(function(){
        					var maxwidth = 46;
        					if($(this).text().length > maxwidth){
        						$(this).text($(this).text().substring(0,maxwidth));
        						$(this).html($(this).html()+'...');
        					}
        				});
                    }
               });
		
		
		
	}
	
	
	var initother = function(){
		$("#fasong").click(function(){
			var textarea = $("#textarea").val();
			if($.trim(textarea)==""){
				newbootbox.alertInfo("请填写内容!");
				return;
			}
			$ajax({
				url:url4,
				data:{textarea:textarea,id:cbrenid},
				success:function(data){
					if(data.result=="success"){
						$("#viewcont").modal("hide");
						newbootbox.alertInfo("操作成功!");
						grid.refresh();
					}
				}
			});
		})
		
		
				$("#qbqr").click(function(){
			//var datas=grid.getcheckrow();
			//var ids=[];
			//if(datas.length==1){
				//$(datas).each(function(i){
				//	ids[i]=this.id;
				//});
				//ydfn(ids.join(","));
			//}else{
			//	newbootbox.alertInfo("请选择要操作的数据！");
			//}
			
			
			var menuid = $(".menu li.active").attr("id");
			var name = $(".menu li.active font").eq(0).text();
			
			newbootbox.confirm({
			    title: "提示",
			    message: "["+name+"]是否全部已读操作？",
			    callback1:function(){
			    	$ajax({
			    		url:url5,
			    		data:{menuid:menuid},
			    		success:function(data){
			    			if(data.result=="success"){
			    				//newbootbox.alertInfo("确认已读!");
			    				pageModule.initmenu(menuid);
			    			}
			    		}
			    	});
			    	
			    }
			});
			
			
		})
		
		$("#quxiao").click(function(){
			$("#viewcont").modal("hide");
		})
		
		
		$("[name=radio]").click(function(){
			var value = this.value;
			grid.setparams({state:value});
			grid.loadtable();
		})
		
		
		$("#plyd").click(function(){
			var datas=grid.getcheckrow();
			var ids=[];
			if(datas.length>0){
				$(datas).each(function(i){
					ids[i]=this.id;
				});
				newbootbox.confirm({
				    title: "提示",
				    message: "是否批量已读操作？",
				    callback1:function(){
				    	$ajax({
				    		url:url3,
				    		data:{ids:ids.toString()},
				    		success:function(data){
				    			if(data.result=="success"){
				    				newbootbox.alertInfo("确认已读!");
				    				grid.refresh();
				    			}
				    		}
				    	});
				    	
				    }
				});
			}else{
				newbootbox.alertInfo("请选择要操作的数据！");
			}
			
			

			
			
		})
		
		
	}
	
	
	var initfn = function(){
		if(ifmenu!="false"){
			$("#cent-left").show();
			$(".top-title").attr("href","");
			initmenu();
		}else{
			$(".cent-right").css("left",0);
			$(".top-title").attr("href","index.html");
			initgrid();
		}
	}
	
	return{
		//加载页面处理程序
		initControl:function(){
			initfn();
			initother();
		}
	}
	
}();

var ydfn = function(ids){
	$ajax({
		url:url3,
		data:{ids:ids},
		success:function(data){
			if(data.result=="success"){
				newbootbox.alertInfo("确认已读!");
				grid.refresh();
			}
		}
	});
	/*newbootbox.confirm({
		title:"提示!",
		message:"是否确认已读!",
		callback1:function(){
			
		}
	});*/
}
var cbrenid = "";
var cbfn = function(ids){
	cbrenid = ids;
	$("#viewcont").modal("show");
}
var viewpage = function(fileId){
	window.location.href = "../../djlr/html/djlr_view.html?fileId="+fileId+"&frompage=1";//frompage放在最后
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
