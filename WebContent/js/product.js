var state = 0;
var table;
$(document).ready( function () {

		table=$('#table11').DataTable(
        {
        searching: false,//屏蔽datatales的查询框
        aLengthMenu:[5],
        "stateSave": true,
        "bRetrieve": true,
        "ordering": false,//关闭排序
        "pagingType":"simple_numbers",
        "bLengthChange": false,//屏蔽tables的一页展示多少条记录的下拉列表
        "processing": true, //打开数据加载时的等待效果
        "serverSide": true,//打开后台分页
		"bPaginate":true,
        " buttons": [
                   'selectAll',
                   'selectNone'
               ],
         "language": {
                 "lengthMenu": "每页 _MENU_ 条记录",
                 "zeroRecords": "没有找到记录",
                 "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                 "infoEmpty": "无记录",
                 "infoFiltered": "(从 _MAX_ 条记录过滤)",
                 "search":"搜索:",
                 "paginate": {
                    "first":      "第一页",
                    "last":       "最后一页",
                    "next":       "下一页",
                    "previous":   "上一页"
    },

             },
            //"scrollY": "300px",//滚动宽度
    		//"scrollCollapse": "false",//滚动条
    		"ajax":{
    			"url":"/aprs/getAllProduct",
    		    "dataSrc": "aaData", 
    		    "data": function ( d ) {
                    if(state==1){
						d.product_id = $('#idListNum').val();
					}
					else if(state==2){
						d.name = $('#nameListNum').val();
					}
					d.state = state;
				}
    		},
    		"aoColumns" :[
				{"mDataProp":"product_id"},
    			{"mDataProp":"name"},
				{"mDataProp": "product_spec"},
    			{"mDataProp":"sale_price"},
				{"mDataProp":"quantity"},
				{
					 "mDataProp":"product_id",
	                 "render": function (mDataProp, type, full, meta) {
	                     return '<button class="btns" onclick="detailFunc(' + full.product_id + ',\'' + full.sale_price + '\')" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btns" onclick="deletefunc(' + mDataProp + ')" >删除</button>';
	                 },
	                 "bSortable": false
	             },
	             
    		],
            
        });
		$(document).on("click","#search1",function(){
			var product_id = $('#idListNum').val();
			if(product_id==""){
				alert("请输入商品编号！");
				return;
			}
			state = 1;
		    table.draw();
		    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

		});
		$(document).on("click","#search2",function(){
			var name = $('#nameListNum').val();
			if(name==""){
				alert("请正确输入查询条件！");
				return;
			}
			state = 2;
		    table.draw();
		    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

		});
		$("#deleteHaulBtn").click(function() {
			var product_id = $("#deleteHaulId").val();
			if(product_id=="") return;
			$.ajax({
				type: "POST",
				url: "/aprs/deleteProduct",
				data: { product_id: product_id },
				success: function(msg) {
					table.draw();
					//$("#delcfmOverhaul").modal('hide')
					$("#deleteHaulId").val('');
				},
				error: function(a) {
					//$("#delcfmOverhaul").modal('hide')
					alert("删除失败");
				}
			});
		});
		$("#closemodel").click(function() {
			$("#deleteHaulId").val('');
		});
		$("#closemodelsend").click(function() {
			$("#modesale").val('');
		});
		$("#sendHaulBtn").click(function() {
			var product_id = $("#saleId").val();
			var sale_price = $("#modesale").val();
			if(sale_price==""){
				alert("请正确输入");
				return;
			}
			$.ajax({
						type: "POST",
						url: "/aprs/updateSale",
						data: { product_id: product_id,sale_price:sale_price},
							success: function(msg) {
								alert("修改成功");
								table.draw();
							},
						error: function(a) {
							alert("修改失败");
						}
					});
		});
 });
	 
function detailFunc(product_id,sale_price){
	$("#saleId").val(product_id);
	$("#modesale").val(sale_price);
	
	$("#updateOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }
 function deletefunc(product_id){
	$("#deleteHaulId").val(product_id);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }

