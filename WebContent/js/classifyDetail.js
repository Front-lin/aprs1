var state = 0;
var table;
var id = GetQueryString("cid");
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
    			"url":"/aprs/getClassifyDetail",
    		    "dataSrc": "aaData", 
    		    "data": function ( d ) {
                    	d.id = id;
				}
    		},
//    		"aoColumnDefs": [
//            {
//               sDefaultContent: '',
//               aTargets: [ '_all' ]
//             }
//             ],
    		
    		"aoColumns" :[
				{"mDataProp":"did"},
				{"mDataProp":"dname"},
				{
	                 "sClass": "text-center",
					 "mDataProp":"did",
	                 "render": function (mDataProp, type, full, meta) {
	                	 return '<button class="btns" onclick="deletefunc(' + mDataProp + ')" >删除</button>';
	                 },
	                 "bSortable": false
	             },
    		],
            
        });
$("#deleteHaulBtn").click(function() {
	var did = $("#deleteHaulId").val();
	if(did=="") return;
	$.ajax({
		type: "POST",
		url: "/aprs/deleteClassifyDetail",
		data: { did: did },
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
$("#addsend").click(function() {
	$("#addsure").modal({
		backdrop : 'static',
		keyboard : false
	});
});
$("#addHaulBtn").click(function() {

	var dname = $("#adddname").val();
	if(dname==""){
		alert("请填入完整信息");
		return;
	}
	$.ajax({
		type: "POST",
		url: "/aprs/addClassifyDetail",
		data: { dname:dname,cid:id },
		success: function(msg) {
			if (msg=="false"){
				alert("添加失败！");
			} else if(msg=="true"){
				alert("添加成功！");
				window.location.reload();
			}
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
function deletefunc(cid){
	$("#deleteHaulId").val(cid);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
	}
		function GetQueryString(name){
		    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		    var r = window.location.search.substr(1).match(reg);
		    if(r!=null) return  unescape(r[2]); 
			return null;
		}
