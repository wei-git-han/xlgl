var userName;//选择的首长名字
var userId;//选择的首长id

var pageModule = function(){
	var initPeoples = function(){
		$.ajax({
 			url:"/app/db/roleset/querySzList",
 			success:function(data){
 				if(data.length<1){
 					newbootbox.alert('请先在业务配置里设置首长！');
 				}else{
 					$("#peoples").html("");
 					$.each(data,function(i,obj){
 						var	html1 ='<label class="radio-inline">'
		     							html1+='<input type="radio" name="users"  data="'+obj.userId+'" personName="'+obj.userName+'">'+obj.userName
 						           '</label>'
 						$("#peoples").append(html1);
 					})				
 				}
 			}
 		});
	}
	
	var initother = function(){
		//确定
		$("#sure").click(function(){
			var personId="";
			var personName="";
			$("#peoples").find("[name=users]").each(function(){
				if($(this).is(":checked")){					
					personId=$(this).attr("data"),
					personName=$(this).attr("personName")
				}
			})
			
			if(personId == ""||personId==null||personId==undefined){
				newbootbox.alert("请选择首长！");
				return;
			}else{
				window.top.iframe1.window.pageModule.getUserData(personName,personId);
				newbootbox.newdialogClose("chooseszDialog");
			}
		});
		
		//关闭
		$("#close").click(function(){
			newbootbox.newdialogClose("chooseszDialog");
		})
	}
	return{
		//加载页面处理程序
		initControl:function(){
			initPeoples();
			initother();
		}
	};
}();
