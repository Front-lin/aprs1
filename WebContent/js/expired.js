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
    			"url":"/aprs/getExpired",
    		    "dataSrc": "aaData", 
 
    		},
    		"aoColumns" :[
				{"mDataProp":"product_id"},
    			{"mDataProp":"name"},
    			{"mDataProp":"product_spec"},
				{"mDataProp":"quantity"},
				{"mDataProp":"releasedate"},
				{"mDataProp":"expired"},
				{
					 "mDataProp":"product_id",
	                 "render": function (mDataProp, type, full, meta) {
	                     return '<button class="btns" onclick="deletefunc(' + full.product_id + ',\'' + full.releasedate + '\')" >清理</button>';
	                 },
	                 "bSortable": false
	             },
    		],
            
        });
		
		$("#deleteHaulBtn").click(function() {
			var product_id = $("#deleteHaulId").val();
			var releasedate = $("#deleteHaulDate").val();
			if(product_id==""||releasedate=="") return;
			$.ajax({
				type: "POST",
				url: "/aprs/deleteExpired",
				data: { product_id: product_id,releasedate:releasedate
					},
				success: function(msg) {
					table.draw();
					//$("#delcfmOverhaul").modal('hide')
					$("#deleteHaulId").val('');
					$("#deleteHaulDate").val(' ');
					alert("清理成功");
				},
				error: function(a) {
					//$("#delcfmOverhaul").modal('hide')
					alert("删除失败");
				}
			});
		});
		$("#closemodel").click(function() {
			$("#deleteHaulId").val('');
			$("#deleteHaulDate").val(' ');
		});
		$("#closemodelsend").click(function() {
			$("#modesale").val('');
		});
 });
	 

 function deletefunc(product_id,releasedate){
	$("#deleteHaulId").val(product_id);
	$("#deleteHaulDate").val(releasedate);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }

