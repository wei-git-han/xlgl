var checkauth = {"url":rootPath + "/documentclerkset/checkauth","dataType":"text"};
var getUserAdminTypeUrl = {"url":rootPath +"/adminset/getAuthor","dataType":"text"};

var pageModule = function(){
	var initother = function(){
		$ajax({
			url: getUserAdminTypeUrl,
			type: "GET",
//			data: {"ids": ids.toString()},
			success: function(data) {
				if(!data){
					$('#departAdmin').css("display","none");
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
