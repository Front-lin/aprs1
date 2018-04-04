$(document).ready( function () {
	$("#addsend").click(function() {
		$("#addsure").modal({
			backdrop : 'static',
			keyboard : false
		});
	});
	
	$("#addHaulBtn").click(function() {
		var cname = $("#addcname").val();
		var provider = $("#selectprovider").find("option:selected").val();
		if(cname==""||provider==""){
			alert("请填入完整信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/aprs/addClassify",
			data: { cname:cname,pid:provider},
					success: function(msg) {
						if (msg=="false"){
							alert("添加失败！");
						} else if(msg=="true"){
							alert("添加成功！");
							window.location.href = "classify.html";
						}
					},
					error: function(a) {
						alert("增加失败");
					}
		});
	});
});
