var isadmin = getUrlParam("isadmin");
var menulist={"url":"/app/db/common/data/menu.json","dataType":"text"};
var show = getUrlParam("show")||"";
var menuIndex = getUrlParam("menuIndex")||"";
var pageModule = function(){
	//动态加载菜单
	var initMenuList =function(){
		$ajax({
			url:menulist,
			data:{isadmin:isadmin},
			success:function(data){
				var lis = '';
				if(data.length == 0) {
					window.location.href="error.html";
				}else{
					$.each(data, function(i, item) {
						if(i==0){
							$("#iframe1").attr("src",item.href+"?menuId="+item.id);
						}
						
						lis += '<li id="'+item.id+'"><a href="'+item.href+'" target="iframe1">'+item.text;
						lis +='</a></li>';
					});
					
					$('#menulist').html(lis);  //追加到页面
					$(".menuli li").eq(0).addClass("active");
					$(".menuli li").click(function(){
						$(this).siblings().removeClass("active");
						$(this).addClass("active");
					});
				}
			}
		});
	}

	return{
		//加载页面处理程序
		initControl:function(){
			initMenuList();
		}
	};
	
}();

var showModal = function(obj){
	$("#"+obj).modal("show");
}
var hideModal = function(obj){
	$("#"+obj).modal("hide");
}