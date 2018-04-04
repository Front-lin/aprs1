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
    			"url":"/aprs/getSale",
    		    "dataSrc": "aaData", 
    		    "data": function ( d ) {
                    if(state==1){
						d.sale_id = $('#sid').val();
					}
					else if(state==2){
						d.sale_date = $('#saledate').val();
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
				{"mDataProp":"sale_id"},
    			{"mDataProp":"sale_date"},
				{"mDataProp":"sum"},
				{
                 "sClass": "text-center",
				 "mDataProp":"sale_id",
                 "render": function (mDataProp, type, full, meta) {
                	 return '<button class="btns" onclick="saleDetail(' + mDataProp + ')">详情</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btns" onclick="deletefunc(' + mDataProp + ')" >删除</button>';
                 },
                 "bSortable": false
             },
    		],
            
        });
	


	$(document).on("click","#search6",function(){
		var sale_id = $('#sid').val();
		if(sale_id==""){
			alert("请输入销售单号！");
			return;
		}
		state = 1;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
	$(document).on("click","#search5",function(){
		var date = $('#saledate').val();
		if(date==""){
			alert("请正确输入查询条件！");
			return;
		}
		state = 2;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
	$("#deleteHaulBtn").click(function() {
		var sale_id = $("#deleteHaulId").val();
		if(sale_id=="") return;
		$.ajax({
			type: "POST",
			url: "/aprs/deleteSale",
			data: { sale_id: sale_id },
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
 function deletefunc(sale_id){
	$("#deleteHaulId").val(sale_id);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
	}
function saleDetail(sale_id){
	var id = sale_id;
	var title = "详情";
	var url="saleDetail.html？sale_id="+sale_id;
	window.location.href="./saleDetail.html?sale_id="+sale_id;
 	}
 

