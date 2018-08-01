$(function () {
    $("#jqGrid").jqGrid({
        url: '../task/list',
        datatype: "json",
        colModel: [			
		/*	{ label: 'taskId', name: 'taskId', index: 'task_id', width: 50, key: true },*/
			{ label: '任务类型', name: 'taskType', index: 'task_type', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 80 }, 			
			{ label: '快递类型', name: 'expressType', index: 'express_type', width: 80 }, 			
		/*	{ label: '商品ID', name: 'productId', index: 'product_id', width: 80 }, 		*/
			{ label: '商品名称', name: 'productName', index: 'product_name', width: 80 }, 			
	/*		{ label: '创建人ID', name: 'createUserId', index: 'create_user_id', width: 80 },
			{ label: '创建人名称', name: 'createUserName', index: 'create_user_name', width: 80 }		*/
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
        showTaskSearch: true,
		title: null,
		task: {},
        product: {},
        taskSearch: {},
        taskSearchList:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.task = {};
            vm.getownerProduct();
		},
		update: function (event) {
			var taskId = getSelectedRow();
			if(taskId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(taskId);
            vm.getownerProduct();
		},
		saveOrUpdate: function (event) {
			var url = vm.task.taskId == null ? "../task/save" : "../task/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.task),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							//vm.reload();
                            // this.$router.push({name: '../order/page1',params:{ id:'1'}});
                            vm.showTaskSearch = false;
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
        addTaskSearch: function(){
            this.taskSearchList.push(this.taskSearch);
            // 添加完newPerson对象后，重置newPerson对象
            this.taskSearch ={};
        },
        del: function (event) {
			var taskIds = getSelectedRows();
			if(taskIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../task/delete",
				    data: JSON.stringify(taskIds),
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
		getInfo: function(taskId){
			$.get("../task/info/"+taskId, function(r){
                vm.task = r.task;
            });
		},
        getownerProduct: function(){
            $.get("../task/productList", function(r){
                vm.product = r.productList;

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