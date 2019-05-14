var checkauth = {"url":rootPath + "/documentclerkset/checkauth","dataType":"text"};
var getUserAdminTypeUrl = {"url":rootPath +"/adminset/getAuthor","dataType":"text"};

var pageModule = function(){
	var initother = function(){
		$ajax({
			url: getUserAdminTypeUrl,
			type: "GET",
			success: function(data) {
				if(data=="0"){//超级管理员
					$("#jssz").show();
					$("#szsz").show();
					$("#zdwh").show();
					$('#departAdmin').show();
					$('#juAdmin').show();
				}else if(data=="1"){//部管理员
					$('#departAdmin').show();
					$('#juAdmin').show();
					$("#szsz").show();
					$("#zdwh").show();
				}else{ //局管理员
					$('#juAdmin').show();
					$("#jssz").show();
				}
			}
		});
		$(".newpage8").click(function(){
			$(".newpage8").removeClass("active");
			$(this).addClass("active");
		});
		
		$ajax({
			url:checkauth,
			type: "GET",
			success:function(data){
				if(data.result == "success") {
					$(".zhmssz").show();
				}else{
					$(".zhmssz").hide();
				}
			}
		});
	}

	return{
		//加载页面处理程序
		initControl:function(){
			initother();
		}
	};
	
}();
