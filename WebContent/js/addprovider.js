$(document).ready( function () {
	$("#addsend").click(function() {
		$("#addsure").modal({
			backdrop : 'static',
			keyboard : false
		});
	});
	$("#addHaulBtn").click(function() {
		var pname = $("#addname").val();
		var ptel = $("#addspec").val();
		var paddress = $("#addsale").val();
		if(pname==""){
			alert("供应商名称不能为空");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/aprs/addProvider",
			data: { pname:pname,ptel:ptel,paddress:paddress},
					success: function(msg) {
						if (msg=="false"){
							alert("添加失败！");
						} else if(msg=="true"){
							alert("添加成功！");
							window.location.href = "provider.html";
						}
					},
					error: function(a) {
						alert("增加失败");
					}
		});
	});
});
