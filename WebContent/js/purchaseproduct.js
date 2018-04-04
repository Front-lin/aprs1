var dataSet = [[4,"name",500,"2018-03-31",45,1,45],[4,"name",500,"2018-04-03",45,1,40],["total","","","","","",85]];
var table;
var count = 2;
    window.onload = function(e){
        table = $('#example').DataTable( {
        searching: false,//屏蔽datatales的查询框
        bLengthChange: false,//屏蔽tables的一页展示多少条记录的下拉列表
        ordering: false,//关闭排序
        data: dataSet,
        columns: [
            { title: "分类编号"},
            { title: "商品名字" },
            { title: "商品规格" },
            { title: "生产日期"},
            { title: "价格" },
            { title: "数量" },
            { title: "总计" },
        ]
    } );
    }

function add(){
    var cid =  $("#selectclassify").find("option:selected").val();
    var name = $("#selectproduct").find("option:selected").text();
    var spec = $("#spec").val();
    var date = $("#date").val();
    var money = $("#money").val();
    var quantity = $("#num").val();
    var sum = money * quantity;
    var len = count;
    array = [cid,name,spec,date,money,quantity,sum];
    total = table.row(len).data();
    total[6] += array[6];
    table.row(len).data(array).draw();
    table.row.add(total).draw();
    count++;
    clean();
}

function clean(){
    $("#spec").val('');
    $("#date").val('');
    $("#money").val('');
    $("#num").val('');
}

function purchase(){
	var cid = new Array();
	var name = new Array();
	var spec = new Array();
	var date = new Array();
	var money = new Array();
	var quantity = new Array();
	var sum = table.row(count).data()[6];
	for(var i=0;i<count;i++){
		var t =  table.row(i).data();
		cid.push(t[0]);
		name.push(t[1]);
		spec.push(t[2]);
		date.push(t[3]);
		money.push(t[4]);
		quantity.push(t[5]);
    }
	$.ajax({
		type: "POST",
		url: "/aprs/purchase",
		data: {cid: cid, name: name, spec: spec,date: date,money: money,quantity: quantity,sum: sum},
				success: function(msg) {
					if (msg=="false"){
						alert("采购失败！");
					} else if(msg=="true"){
						alert("采购成功！");
					}
				},
				error: function(a) {
					alert("采购失败");
				}
	});
}

    
function getsecond(){
    var provider = $("#selectprovider").find("option:selected").val();
     $("select[name=classify]").empty();     //清空seletct的数据  
            $.ajax({
              dataType:"json",
              type:"GET",                        //post请求
              url:"/aprs/getClassifyItem",                          //请求后台action 根据需求请求自己的后台数据
              data:{pid:provider},
              success:function(data){             //ajax成功的方法 在里卖弄给select的<option>标签赋值
                  //向select中append、option标签
                  var optionString = "<option grade=\'请选择分类\' selected = \'selected\'>--请选择分类--</option>";
                  var beanList = data;            //返回的json数据
                  console.log(beanList);
                  if(beanList){                   //判断
                      for(var i=0; i<beanList.length; i++){ //遍历，动态赋值
                          optionString +="<option grade=\""+beanList[i].cid+"\" value=\""+beanList[i].cid+"\"";  
                          optionString += ">"+beanList[i].cname+"</option>";  //动态添加数据  
                      }  
                      $("select[name=classify]").append(optionString);  // 为当前name为asd的select添加数据。
                }  
            }  
        }); 
}
function getthird(){
    var classify = $("#selectclassify").find("option:selected").val();
     $("select[name=product]").empty();     //清空seletct的数据  
            $.ajax({
              dataType:"json",
              type:"GET",                        //post请求
              url:"/aprs/getProductItem",                          //请求后台action 根据需求请求自己的后台数据
              data:{cid:classify},
              success:function(data){             //ajax成功的方法 在里卖弄给select的<option>标签赋值
                  //向select中append、option标签
                  var optionString = "<option grade=\'请选择农产品\' selected = \'selected\'>--请选择农产品--</option>";
                  var beanList = data;            //返回的json数据
                  console.log(beanList);
                  if(beanList){                   //判断
                      for(var i=0; i<beanList.length; i++){ //遍历，动态赋值
                          optionString +="<option grade=\""+beanList[i].did+"\" value=\""+beanList[i].did+"\"";  
                          optionString += ">"+beanList[i].dname+"</option>";  //动态添加数据  
                      }  
                      $("select[name=product]").append(optionString);  // 为当前name为asd的select添加数据。
                }  
            }  
        }); 
}