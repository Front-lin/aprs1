$(document).ready( function () {
	$("#addsend").click(function() {
		$("#addsure").modal({
			backdrop : 'static',
			keyboard : false
		});
	});
	$("#addHaulBtn").click(function() {
		var sname = $("#addname").val();
		var sage = $("#addspec").val();
		var stel = $("#addsale").val();
		if(sname==""){
			alert("姓名不能为空");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/aprs/addSaler",
			data: { sname:sname,sage:sage,stel:stel},
					success: function(msg) {
						if (msg=="false"){
							alert("添加失败！");
						} else if(msg=="true"){
							alert("添加成功！");
							window.location.href = "saler.html";
						}
					},
					error: function(a) {
						alert("增加失败");
					}
		});
	});
});
