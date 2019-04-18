var tableList= {"url":"/app/db/document/grdb/data/tablegrid.json","dataType":"text"};//原table数据
var numsList={"url":rootPath +"/documentFlow/numsList","dataType":"text"};//筛选状态数字统计
var deptUrl= {"url":"/app/db/document/grdb/data/deptTree.json","dataType":"text"};//部门树
var userUrl = {"url":"/app/db/document/grdb/data/userTree.json","dataType":"text"};//人员树
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
		
		//新增
		$("#add").click(function(){
			window.location.href="/app/db/document/djlr/html/add.html";
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
			initgrid();
			numsListfn();
			initother();
			inittree();
		},
		initgrid:function(){
			initgrid();
			numsListfn();
		}
	};
}();

function refreshgrid(){
	var search = $("#searchVal").val();
	grid.setparams({search:search,documentStatus:$("input[name='documentStatus']:checked").val()});
	grid.loadtable();
}
