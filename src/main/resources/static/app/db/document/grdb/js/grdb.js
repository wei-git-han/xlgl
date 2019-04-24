var tableList= {"url":"/app/db/subdocinfo/personList","dataType":"text"};//原table数据
var numsList={"url":rootPath +"/documentFlow/numsList","dataType":"text"};//筛选状态数字统计
var deptUrl= {"url":"/app/db/document/grdb/data/deptTree.json","dataType":"text"};//高级搜索--部门树
var userUrl = {"url":"/app/db/document/grdb/data/userTree.json","dataType":"text"};//高级搜索--人员树
var grid = null;
var total=0;//列表中，数据的总条数
var pageModule = function(){
	var initgrid = function(){
        grid = $("#gridcont").createGrid({
            columns:[
            	{display:"军委办件号",name:"banjianNumber",width:"10%",align:"center",render:function(rowdata,n){
               	 return rowdata.banjianNumber;
                }},
                {display:"局内状态",name:"statusName",width:"10%",align:"center",render:function(rowdata,n){
               	 	var bgColor="#FF6600";
  				  	return '<div title="'+rowdata.statusName+'" class="btn btn-xs btn-color" style="background-color:'+bgColor+';">'+rowdata.statusNam+'</div>';
                }},
                {display:"办件标题",name:"docTitle",width:"13%",align:"left",render:function(rowdata){
               	 	return '<a title="'+rowdata.docTitle+'" class="table-title" href="../../view/html/view.html?fileId='+rowdata.id+'&fileFrom=grdb" target="iframe1">'+rowdata.docTitle+'</a>'
                }},
                {display:"紧急程度",name:"urgencyDegree",width:"7%",align:"center",paixu:false,render:function(rowdata){
               	 return rowdata.urgencyDegree;
                }},
                {display:"批示指示内容",name:"",width:"10%",align:"center",paixu:false,render:function(rowdata){
               	 return "";
                }},
                {display:"督办落实情况",name:"",width:"10%",align:"left",paixu:false,render:function(rowdata){
               	 return "";
                }},
                {display:"承办单位/人",name:"",width:"10%",align:"center",paixu:false,render:function(rowdata){
               	 return "";
                }},
                {display:"办件分类",name:"docTypeName",width:"10%",align:"center",paixu:false,render:function(rowdata){
               	 return rowdata.docTypeName;
                }},
                {display:"转办时间",name:"createdTime",width:"10%",align:"center",render:function(rowdata){
               	 return rowdata.createdTime;
                }},
                 {display:"接收时间",name:"",width:"10%",align:"center",paixu:false,render:function(rowdata){                	
                 }}
            ],
            width:"100%",
            height:"100%",
            checkbox: true,
            rownumberyon:true,
            overflowx:false,
            pagesize: 15,
            pageyno:true,
            paramobj:{search:$("#searchVal").val(),docStatus:$("input[name='documentStatus']:checked").val()},
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
