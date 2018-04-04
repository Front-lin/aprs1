$(document).ready( function () {
	$("#addsend").click(function() {
		$("#addsure").modal({
			backdrop : 'static',
			keyboard : false
		});
	});
	$("#addHaulBtn").click(function() {
		var name = $("#addname").val();
		var product_spec = $("#addspec").val();
		var sale_price = $("#addsale").val();
		var quantity = $("#addquantity").val();
		if(name==""||sale_price==""||quantity==""){
			alert("请正确填写信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/aprs/addProduct",
			data: { name:name,product_spec:product_spec,sale_price:sale_price,quantity:quantity},
					success: function(msg) {
						if (msg=="false"){
							alert("添加失败！");
						} else if(msg=="true"){
							alert("添加成功！");
						}
					},
					error: function(a) {
						alert("增加失败");
					}
		});
	});
});
