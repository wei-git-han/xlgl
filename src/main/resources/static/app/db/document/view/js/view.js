var getDataUrl = {"url":"/app/db/document/view/data/getData.json","dataType":"text"};;//右侧获取文件信息
var listUrl = {"url":"/app/db/document/view/data/blfkList.json","dataType":"text"}; //办理反馈list

var fileId=getUrlParam("fileId")||""; //主文件id
var pageModule = function(){
	var initdata = function(){
		$ajax({
			url:getDataUrl,
			data:{fileId:fileId},
			success:function(data){
				$(".commonHtml").append(
					'<div class="line1"><span class="fileName">'+data.fileName+'</span><font class="miji secretLevelName">'+data.secretLevelName+'</font></div>'+
	            	'<div class="line2 fileNum">'+data.fileNum+'</div>'+
	            	'<div class="line3"><i class="fa fa-info-circle" style="color:#33CC99"></i> <span class="option">'+data.option+'</span></div>'
				)
			}
		});	
	}
	
	//办理反馈记录
	var initList = function(){
		$ajax({
			url:listUrl,
 			data:{fileId:fileId},
			success:function(data){
				var html1= "";
				$.each(data,function(i,o){
					var listdate = o.listdate;
					html1=	'<div class="timelinesheys ">'+
							'	<div class="timeline-icon1">'+
							'		<i class="icontime"></i>'+
							'	</div>'+
							'	<div class="timeline-user">'+
							'		<span style="color:#999;">'+listdate+'</span>'+
							'	</div>'+
							'	<div class="timeline-body">';
							$.each(o.rows,function(k,b){
								var borderStyle="";
								var answerStyle="";
								var answer = b.answer;
								var isOK = b.isOK;
								var isOKobj = "";
								if(isOK == "1"){
									isOKobj ="审批通过";
								}
								if(answer !="0"){
									answersStyle = "margin-left:20px;"
								}
								if(k>0){
									borderStyle = "border-top:none;"
								}
								html1 += '<div class="timeline-content" title="" style="'+borderStyle+answerStyle+'">'+
								         '	<div class="listUser"><img src="../images/userh.png" class="listicon"> '+b.uerName+'<span class="isOkFlag">'+isOKobj+'</span></div>';
								html1 += '	<div class="listContent">';
								html1 += '		<span>'+b.content+'</span><span>'+b.createdTime+'</span><div class="listfj">';
								$.each(b.fj,function(s,t){
									html1 += '		<a id="'+t.fjId+'">'+t.fjName+'</a>';
								})
								html1 += '	</div></div>';
								html1 += '</div>';
							})
							
							html1 +='	</div>'+
									'</div>'
					$(".timelinesview").append(html1);
				})
			}
		})
	}
	var initother = function(){
		$("#clear").click(function(){
			$("#opinionContent").val("");
		});
	}
		
	return{
		//加载页面处理程序
		initControl:function(){
			initdata();
			initList();
			initother();
			$(".scroller").css("height","100%");
			$(".slimScrollDiv").css("height","100%");
		}
	};
}();
