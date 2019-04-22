var checkauth = {"url":rootPath + "/documentclerkset/checkauth","dataType":"text"};
var pageModule = function(){
	var initother = function(){
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
