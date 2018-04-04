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
            // "scrollY": "300px",//滚动宽度
    		//"scrollCollapse": "false",//滚动条
    		"ajax":{
    			"url":"/aprs/getPurchase",
    		    "dataSrc": "aaData", 
    		    "data": function ( d ) {
                    if(state==1){
						d.purchaseOrder_id = $('#pid').val();
					}
					else if(state==2){
						d.date = $('#sdate').val();
					}
					d.state = state;
				}
    		},
//    		"aoColumnDefs": [
//            {
//               sDefaultContent: '',
//               aTargets: [ '_all' ]
//             }
//             ],
    		
    		"aoColumns" :[
				{"mDataProp":"purchaseOrder_id"},
    			{"mDataProp":"date"},
				{"mDataProp":"employee_name"},
    			{"mDataProp":"product_id"},
    			{"mDataProp":"name"},
    			{"mDataProp":"product_spec"},
    			{"mDataProp":"purchase_quantity"},
    			{"mDataProp":"price"},
				{
                 "sClass": "text-center",
				 "mDataProp":"purchaseOrder_id",
                 "render": function (mDataProp, type, full, meta) {
                     return '<button class="btns" onclick="deletefunc(' + mDataProp + ')" >删除</button>';
                 },
                 "bSortable": false
             },
    		],
            
        });

	$(document).on("click","#search4",function(){
		var purchaseOrder_id = $('#pid').val();
		if(purchaseOrder_id==""){
			alert("请输入采购单号！");
			return;
		}
		state = 1;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
	$(document).on("click","#search3",function(){
		var date = $('#sdate').val();
		if(date==""){
			alert("请正确输入查询条件！");
			return;
		}
		state = 2;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
	$("#deleteHaulBtn").click(function() {
		var purchaseOrder_id = $("#deleteHaulId").val();
		if(purchaseOrder_id=="") return;
		$.ajax({
			type: "POST",
			url: "/aprs/deletePurchase",
			data: { purchaseOrder_id: purchaseOrder_id },
			success: function(msg) {
				//$("#delcfmOverhaul").modal('hide')
				if(msg=="true"){
					table.draw();
					alert("删除成功");
				} else {
					alert("删除失败");
				}
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
		$("#modetno").val('');
		$("#modepass").val('');
		$("#modetname").val('');
		$("#modetdept").val('');
		$("#modetdate").val('');
	});
  
 });
 function deletefunc(purchaseOrder_id){
	$("#deleteHaulId").val(purchaseOrder_id);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }
	 


