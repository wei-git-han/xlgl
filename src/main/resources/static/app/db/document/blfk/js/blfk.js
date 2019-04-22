var tableList= {"url":"/app/db/document/grdb/data/tablegrid.json","dataType":"text"};//原table数据
var numsList={"url":rootPath +"/documentFlow/numsList","dataType":"text"};//筛选状态数字统计
var deptUrl= {"url":"/app/db/document/grdb/data/deptTree.json","dataType":"text"};//部门树
var userUrl = {"url":"/app/db/document/grdb/data/userTree.json","dataType":"text"};//人员树
var leftMenuUrl = {"url":"/app/db/document/blfk/data/leftMenu.json","dataType":"text"};//左侧菜单
var leaderId=getUrlParam("menuid")||"";//代理领导
var grid = null;
var total=0;//列表中，数据的总条数
var pageModule = function(){
	var initgrid = function(){
        grid = $("#gridcont").createGrid({
            columns:[
                 {display:"军委办件号",name:"",width:"10%",align:"center",render:function(rowdata,n){
                	 
                 }},
                 {display:"局内状态",name:"",width:"5%",align:"center",render:function(rowdata,n){
                	 
                 }},
                 {display:"办件标题",name:"",width:"15%",align:"left",render:function(rowdata){
                	 
                 }},
                 {display:"紧急程度",name:"",width:"5%",align:"center",paixu:true,render:function(rowdata){
                 
                 }},
                 {display:"批示指示内容",name:"",width:"12%",align:"center",paixu:true,render:function(rowdata){
                     
                 }},
                 {display:"督办落实情况",name:"",width:"10%",align:"left",paixu:true,render:function(rowdata){
                
                 }},
                 {display:"承办单位/人",name:"",width:"10%",align:"center",paixu:true,render:function(rowdata){
                 
                 }},
                 {display:"办件分类",name:"",width:"5%",align:"center",paixu:true,render:function(rowdata){
                	
                 }},
                 {display:"转办时间",name:"",width:"10%",align:"center",render:function(rowdata){
                	 
                 }},
                 {display:"接收时间",name:"",width:"10%",align:"center",paixu:true,render:function(rowdata){
                	
                 }},
                 {display:"操作",name:"do",width:"8%",align:"center",render:function(rowdata){
                	
                 }}
            ],
            width:"100%",
            height:"100%",
            checkbox: true,
            rownumberyon:true,
            overflowx:false,
            pagesize: 15,
            pageyno:true,
            paramobj:{},
            loadafter:function(data){
            	total=data.total;
            },
            url: tableList
       });
	}
	
	//左侧菜单树
	var leftMenufn = function(){
		$ajax({
			url:leftMenuUrl,
			success:function(data){
				$("#classType").html("");
				$.each(data,function(i,item){
					$("#classType").append('<li class="'+(i==0?"active":"")+'" id="'+item.id+'"><span>'+item.text+'</span><font>('+item.num+')</font><i class="fa fa-angle-right"></i></li>');
				});
				
				$("#classType li").click(function(){
					$(this).siblings().removeClass("active");
					$(this).addClass("active");
					refreshgrid();
				});
			}
		});	
	}
	
	var numsListfn = function(){
		$ajax({
			url:numsList,
			data:{},
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
		
		//催办
		$("#cuiban").click(function(){
			var datas=grid.getcheckrow();
			var ids=[];
			if(datas.length>0){
				$(datas).each(function(i){
					ids[i]=this.id;
				});
				cuibanFn(ids.toString());
			}else{
				newbootbox.alertInfo("请先选择要催办的数据！");
			}
		});
		
		//转办
		$("#zhuanban").click(function(){
			var datas=grid.getcheckrow();
			var ids=[];
			if(datas.length>0){
				$(datas).each(function(i){
					ids[i]=this.id;
				});
				zhuanbanFn(ids.toString());
			}else{
				newbootbox.alertInfo("请先选择要转办的数据！");
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
			pageModule.initgrid2();
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
			initgrid();
		}
	};
}();
//查询
function refreshgrid(){
	var search = $("#searchVal").val();
	grid.setparams({search:search,documentStatus:$("input[name='documentStatus']:checked").val(),menuId:$("#classType li.active").attr("id")});
	grid.loadtable();
}

//催办
function cuibanFn(id){
	newbootbox.newdialog({
		id:"cuibanDialog",
		width:800,
		height:500,
		header:true,
		title:"催办留言",
		url:"/app/db/document/blfk/html/cuibanDialog.html?fileId="+id,
	})
}

//转办
function zhuanbanFn(id){
	newbootbox.newdialog({
		id:"zhuanbanDialog",
		width:800,
		height:600,
		header:true,
		title:"转办",
		url:"/app/db/document/blfk/html/zhuanbanDialog.html?fileId="+id,
	})
}