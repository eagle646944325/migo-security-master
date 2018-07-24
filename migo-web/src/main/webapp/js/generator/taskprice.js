$(function () {
    $("#jqGrid").jqGrid({
        url: '../taskprice/list',
        datatype: "json",
        colModel: [			
			{ label: 'priceId', name: 'priceId', index: 'price_id', width: 50, key: true },
			{ label: '商品价格', name: 'goodsPrice', index: 'goods_price', width: 80 }, 			
			{ label: '快递费', name: 'express', index: 'express', width: 80 }, 			
			{ label: '型号', name: 'model', index: 'model', width: 80 }, 			
			{ label: '拍下件数', name: 'number', index: 'number', width: 80 }, 			
			{ label: '任务数量', name: 'taskNumber', index: 'task_number', width: 80 }, 			
			{ label: '任务ID', name: 'taskId', index: 'task_id', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		taskPrice: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.taskPrice = {};
		},
		update: function (event) {
			var priceId = getSelectedRow();
			if(priceId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(priceId)
		},
		saveOrUpdate: function (event) {
			var url = vm.taskPrice.priceId == null ? "../taskprice/save" : "../taskprice/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.taskPrice),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var priceIds = getSelectedRows();
			if(priceIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../taskprice/delete",
				    data: JSON.stringify(priceIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(priceId){
			$.get("../taskprice/info/"+priceId, function(r){
                vm.taskPrice = r.taskPrice;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});