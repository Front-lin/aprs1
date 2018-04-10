var dataSet = [[10,"苹果",2000,"2018-04-10",25,1,25],[12,"葡萄",1000,"2018-04-10",25,1,25],["total","","","","","",50]];
var table;
var count = 2;
    window.onload = function(e){
        var code = "";
        var lastTime,nextTime;
        var lastCode,nextCode;
        table = $('#example').DataTable( {
        searching: false,//屏蔽datatales的查询框
        bLengthChange: false,//屏蔽tables的一页展示多少条记录的下拉列表
        ordering: false,//关闭排序
        data: dataSet,
        columns: [
            { title: "商品编号" },
            { title: "商品名字" },
            { title: "商品规格" },
            { title: "生产日期" },
            { title: "价格" },
            { title: "数量" },
            { title: "总计" },
        ]
    } );

        document.onkeypress = function(e) {
            nextCode = e.which;
            nextTime = new Date().getTime();

            if(lastCode != null && lastTime != null && nextTime - lastTime <= 30) {
                code += String.fromCharCode(lastCode); 
            } else if(lastCode != null && lastTime != null && nextTime - lastTime > 100){
                code = "";
            }

            lastCode = nextCode;
            lastTime = nextTime;
        }

        this.onkeypress = function(e){
            if(e.which == 13){
                push(code);
                code = "";
            }
        } 
    }
    function push(product){
         var obj = eval('(' + product + ')');
         addData(obj);
    }
    function addData(product){
        for(var i=0;i<count;i++){
            if (table.row(i).data()[0]==product.id){
                change(i, count);
                return;
            }
        }
        add(product, count);
    }
    function change(i,len){
        array = table.row(i).data();
        total = table.row(len).data();
        array[5] += 1;
        array[6] += array[4];
        total[6] += array[4];
        table.row(i).data(array).draw();
        table.row(len).data(total).draw();
        
    }
    function add(product, len){
        array = [product.id,product.name,product.qu,product_release,product.price,1,product.price];
        total = table.row(len).data();
        total[6] += array[4];
        table.row(len).data(array).draw();
        table.row.add(total).draw();
        count++;
    }
    function settle(){
    	var product_id = new Array();
    	var num = new Array();
    	var releasedate = new Array();
    	var sum = table.row(count).data()[6];
    	for(var i=0;i<count;i++){
    		var t =  table.row(i).data();
    		product_id.push(t[0]);
    		num.push(t[5]);
    		releasedate.push(t[3]);
        }
    	$.ajax({
			type: "POST",
			url: "/aprs/settle",
			data: {product_id: product_id,quantity: num, releasedate: releasedate,sum: sum},
					success: function(msg) {
						if (msg=="false"){
							alert("失败！");
						} else if(msg=="true"){
							alert("成功！");
						}
					},
					error: function(a) {
						alert("失败");
					}
		});
    	
    }