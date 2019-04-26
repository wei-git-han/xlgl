/*var url1 = {"url":"../data/grid.json","dataType":"text"};
var url2 = {"url":"../data/menu.json","dataType":"text"};*/
var url1 = {"url":"/app/db/documentszinfo/list","dataType":"text"};
var url2 = {"url":"/app/db/documentszinfo/grouplist","dataType":"text"};
var grid = null;
var pageModule = function(){

	var initmenu = function(){
		$ajax({
			url:url2,
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
			}
		})
		
	}


	var initgrid = function(){
        grid = $("#gridcont").createGrid({
                    columns:[	
                    			{display:"办理状态",name:"blzt",width:"100px",align:"center",paixu:false,render:function(rowdata,n){
                    				var blzt = rowdata.blzt;
                    				var html = '';
                    				if(blzt==1){
                    					html = '<button type="button" class="btn btn-info table-button1">办理中</button>';
                    				}else if(blzt==3){
                    					html = '<button type="button" class="btn btn-info table-button2">常态落实</button>';
                    				}else{
                    					html = '<button type="button" class="btn btn-info table-button2">已办结</button>';
                    				}
                                    return html;
                                 }},
                                 {display:"军委办件号",name:"jwbjh",width:"200px",align:"center",paixu:true,render:function(rowdata,n){
                                    return rowdata.jwbjh;                                         
                                 }},
                                 {display:"文件标题",name:"title",width:"200px",align:"center",paixu:false,render:function(rowdata){
                                    return rowdata.title;                                         
                                 }},
                                 {display:"批示指示内容",name:"pszsmr",width:"200px",align:"center",paixu:false,render:function(rowdata){
                                    return rowdata.pszsmr;                                        
                                 }},
                                 {display:"督办落实情况",name:"dblsqk",width:"200px",align:"center",paixu:false,render:function(rowdata){
                                    return '<label class="table-label">已更新</label>'+rowdata.dblsqk;                                        
                                 }},
                                 {display:"承办单位/人员 ",name:"cbdwry",width:"200px",align:"center",paixu:false,render:function(rowdata){
                                    return rowdata.cbdwry;                                      
                                 }},
                                 {display:"更新时间",name:"update",width:"200px",align:"center",paixu:false,render:function(rowdata){
                                    return rowdata.update;                                      
                                 }},
                                 {display:"转办时间",name:"zbdate",width:"200px",align:"center",paixu:false,render:function(rowdata){
                                    return rowdata.zbdate;                                      
                                 }},
                                 {display:"操作",name:"",width:"200px",align:"center",paixu:false,render:function(rowdata){
                                 	var other = rowdata.other
                    				var html = '';
                    				if(other==0){
                    					html = '<button type="button" class="btn btn-info table-button1" onclick="editfn(\''+rowdata.id+'\')">确认已读</button>';
                    				}else if(other==1){
                    					html = '<button type="button" class="btn btn-info table-button3" onclick="editfn(\''+rowdata.id+'\')">催办</button>';
                    				}
                                    return html;                                   
                                 }}
                             ],
                    width:"100%",
                    height:"100%",
                    checkbox: true,
                    rownumberyon:true,
                    paramobj:{},
                    overflowx:true,
                    rownumberwidth:"50px",
                    pagesize: 12,
                    url: url1
               });
		
		
		
	}
	
	
	var initother = function(){
	
	}
	
	
	
	
	
	
	return{
		//加载页面处理程序
		initControl:function(){
			initmenu();
			initgrid();
			initother();
		}
	}
	
}();