

function pro(){
	$("#content").attr("src","product.html");
}

function b(){
	$("#content").attr("src","purchase.html");
}

function sa(){
	$("#content").attr("src","sale.html");
}
function infor(){
	$("#content").attr("src","pinformation.html");
}
function provide(){
	$("#content").attr("src","provider.html");
}
function classify(){
	$("#content").attr("src","classify.html");
}
function saler(){
	$("#content").attr("src","saler.html");
}
function change(){
	$("#content").attr("src","changepassword.html");
}
function buyproduct(){
	$("#content").attr("src","purchaseproduct.html");
}
function unlogin(){
	$.ajax({
		type: "POST",
		url: "/aprs/unlogin",
	});
	window.top.location.href = 'login.html';
}