﻿var state = 0;
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
    			"url":"/aprs/getProvider",
    		    "dataSrc": "aaData", 
 
    		},
    		"aoColumns" :[
				{"mDataProp":"pid"},
    			{"mDataProp":"pname"},
    			{"mDataProp":"ptel"},
				{"mDataProp":"paddress"},
				{
					 "mDataProp":"pid",
	                 "render": function (mDataProp, type, full, meta) {
	                     return '<button class="btns" onclick="detailFunc('+ full.pid +',\''+full.pname+'\','+full.ptel+',\''+full.paddress+'\')" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btns" onclick="deletefunc(' + mDataProp + ')" >删除</button>';
	                 },
	                 "bSortable": false
	             },
    		],
            
        });
		
		$("#deleteHaulBtn").click(function() {
			var pid = $("#deleteHaulId").val();
			if(pid=="") return;
			$.ajax({
				type: "POST",
				url: "/aprs/deleteProvider",
				data: { pid: pid },
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
			var pid = $("#pid").val();
			var pname = $("#pname").val();
			var ptel = $("#ptel").val();
			var paddress = $("#paddress").val();
			if(pname==""){
				alert("请正确输入");
				return;
			}
			$.ajax({
						type: "POST",
						url: "/aprs/updateProvider",
						data: { pid: pid,pname:pname,ptel:ptel,paddress:paddress},
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
	 
function detailFunc(pid,pname,ptel,paddress){
	$("#pid").val(pid);
	$("#pname").val(pname);
	$("#ptel").val(ptel);
	$("#paddress").val(paddress);
	
	$("#updateOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }
 function deletefunc(pid){
	$("#deleteHaulId").val(pid);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }

