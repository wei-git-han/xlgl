var url1 = {"url":"/app/db/documentszinfo/homelist","dataType":"text"};
var url2 = {"url":"/app/db/documentszinfo/grouplist","dataType":"text"};
var url3 = {"url":"/app/db/documentszinfo/read","dataType":"text"};
var url4 = {"url":"/app/db/documentszinfo/press","dataType":"text"};
var url5 = {"url":"/app/db/documentszinfo/AllreadByType","dataType":"text"};
var groupid=null;
var grid = null;
var pageModule = function(){
	
	
	
	
	
	var initmenu = function(menuid){
		$ajax({
			url:url2,
			success:function(data){
				$(".menu").html('');
				$.each(data,function(i){
					var id = this.id;
					var active = "";
					if(typeof(menuid)!="undefined"){
						if(id==menuid){
							active = "active"
							groupid=id;
							initgrid();
						}
					}else{
						if(i==0){
							active = "active"
							groupid=id;
							initgrid();
							
						}
					}
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
							<li class="${active}" id="${id}">
								<a>
									<i class="fa fa-chevron-right "></i>
									<font title="${name}" >${name}</font>
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
			}
		})
	}
	
	
	
	
	
	
	
	
	
	var initgrid = function(){
		
        grid = $("#gridcont").createGrid({
                    columns:[	
                    			{display:"办理状态",name:"blzt",width:"100%",align:"center",paixu:false,render:function(rowdata,n){
									
                    				var id = rowdata.id;
                    				var blzt = rowdata.blzt;
                    				var jwbjh = rowdata.jwbjh;
                    				var title = rowdata.title;
                    				var pszsmr = rowdata.pszsmr;
                    				var dblsqk = rowdata.dblsqk;
                    				var cbdwry = rowdata.cbdwry;
                    				var update = rowdata.update;
                    				var zbdate = rowdata.zbdate;
                    				var other = rowdata.other;
                    				
                    				var miji = rowdata.miji;
                    				var tbdw = rowdata.tbdw;
                    				var tbrq = rowdata.tbrq;
                    				var array = rowdata.array;
                    				
	                               	var cuiban = '';
	                            	var CuibanFlag = rowdata.CuibanFlag;
	                            	if(CuibanFlag==1){
	                            		 cuiban = '<label class="table-label2">催办</label>';
	                            	}
                    				
                    				//fileId,subId,fileFrom
                    				title=`
                    					${cuiban} <font title="${title}" onclick="viewpage('${id}','${id}','${id}')" style="cursor:pointer;" >${title}</font>
                    				`
                    				
                    				var button1 = "";
                    				if(blzt==1){
                    					button1 = '<button type="button" class="btn btn-info table-button1">办理中</button>';
                    				}else if(blzt==3){
                    					button1 = '<button type="button" class="btn btn-info table-button2">常态落实</button>';
                    				}else{
                    					button1 = '<button type="button" class="btn btn-info table-button2">已办结</button>';
                    				}
                    				
                    				var button2 = '';
                    				var button3 = '';
                    				if(blzt==1){
                    					if(other==0){
                        					button3 = '<a class="btn btn-info newpanel-button1"  onclick="ydfn(\''+rowdata.id+'\')">确认已读</a>';
                        				}else if(other==1){
                        					button2 = '<button type="button" class="btn btn-info table-button3" onclick="cbfn(\''+rowdata.id+'\')">催办</button>';
                        				}
                    				}
                    				
                    				
                    				var gengxin = rowdata.gengxin;
                    				var button4 = '';
                    				if(gengxin==1){
                    					button4 = '<label class="table-label">已更新</label>';
                    				}
                    				
                    				
                    				
                    				var html2 = "";
                    				var width = "width:25%;";
                    				if(array.length==1){
                    					width = "width:110%;";
                    				}else if(array.length==2){
                    					width = "width:50%;";
                    				}else if(array.length==3){
                    					width = "width:33.3%;";
                    				}
                    				$.each(array,function(i){
                    					var dw = this.dw;
                    					var ry = this.ry;
                    					var dwry = this.dwry;
                    					var cont = this.cont;
                    					
                    					html2 = `
	                    								<div class="nc-left-group">
															<div class="nc-left-group-cont" style="${width}">
																<div class="nc-left-group-cont-top" >
																	<font>${dwry}</font>
																</div>
																<div class="nc-left-group-cont-cont scroller" style="height:40px;">
																	${cont}
																</div>
															</div>
														</div>
                    									`;
										
                    				});
                    				if(n==4){console.log(array)}
                    				var html = `
										<div class="newpanel" id="${id}">
											<div class="newpanel-cent">
												
												<table>
													<thead>
														<tr>
															<th style="width:50px;">序号</th>
															<th>状态</th>
															<th>军委办件号</th>
															<th>文件标题</th>
															<th>批示指示内容</th>
															<th>承办单位/人</th>
															<th>转办时间</th>
															<th>反馈更新</th>
															<th>操作</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td style="text-align:center;">${n}</td>
															<td style="text-align:center;">${button1}</td>
															<td style="text-align:center;">${jwbjh}</td>
															<td >${title}</td>
															<td title="${pszsmr}">${pszsmr}</td>
															<td>${cbdwry}</td>
															<td>${update}</td>
															<td>${zbdate}</td>
															<td style="text-align:center;">${button2}</td>
														</tr>
													</tbody>
												</table>
												<div class="newpanel-cent-cont">	
													<div class="wh100">
														
														<div class="newpanel-cent-cont-left">
															<div>
																${button3}
															</div>
														</div>
														
														<div class="newpanel-cent-cont-right">
															
															<div class="nc-left-top">
																<div class="nc-left-top-title">
																	<font>督办落实情况</font>
																	${button4}
																</div>
															</div>
															<div class="nc-left-cent">
																${html2}
															</div>
														</div>
														
													</div>
				
													
												</div>
												
												
												
											</div>
										</div>
                    				`;
                                    return html;
                                 }}
                             ],
                    width:"100%",
                    height:"100%",
                    checkbox: false,
                    rownumberyon:false,
                    paramobj:{month:'all',id:groupid,isMain:'1'},
                    overflowx:false,
                    rownumberwidth:"50px",
                    pagesize: 4,
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
		
		
		$("#quxiao").click(function(){
			$("#viewcont").modal("hide");
		})
		
		
		$("[name=radio]").click(function(){
			var value = this.value;
			grid.setparams({state:value});
			grid.loadtable();
		})
		
		$(".fa-search").click(function(){
			var value = $(".top-right-search input").val();
			grid.setparams({search:value});
			grid.loadtable();
		})
		
		$("#chartbutton").click(function(){
			window.location.href = "index.html"
		});
		
		$(".right-left-button .btn").click(function(){
			
			var o = $(this).find(".fa-chevron-right").is(":hidden");
			if(o){
				$(".cent-left").hide();
				$(".cent-right").css("left","0");
			}else{
				$(".cent-left").show();
				$(".cent-right").css("left","280px");
			}
			initgrid();
			$(this).find(".fa-chevron-right").toggle();
			$(this).find(".fa-chevron-left").toggle();
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
		
	}
	
	
	return{
		//加载页面处理程序
		initControl:function(){
			initmenu();
			initother();
		},
		initmenu:function(menuid){
			initmenu(menuid);
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
				var menuid = $(".menu li.active").attr("id");
				pageModule.initmenu(menuid);
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
	$("#textarea").val("");
	$("#viewcont").modal("show");
}

var viewpage = function(fileId,subId,fileFrom){

	window.location.href = "../../djlr/html/djlr_view.html?fileId="+fileId+"&frompage=0";//frompage放在最后
}
